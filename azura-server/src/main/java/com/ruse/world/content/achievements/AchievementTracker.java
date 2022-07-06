package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/*
 * Project Avalon
 * Author @Avalon (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public class AchievementTracker {

    private final Player player;
    private final Map<Integer, AchievementProgress> idToProgress = new HashMap<>();

    public AchievementTracker(Player player) {
        this.player = player;
    }

    public void progress(AchievementData achievement, int amount) {
        AchievementProgress progress;
        if (idToProgress.containsKey(achievement.id)) {
            progress = idToProgress.get(achievement.id);
        } else {
            progress = new AchievementProgress(0, false);
            idToProgress.put(achievement.id, progress);
        }
        int oldProgress = progress.amountDone;
        int newProgress = progress.addAmount(amount, achievement.progressAmount);
        if (oldProgress != newProgress && newProgress >= achievement.progressAmount) {
            player.getSeasonPass().addXp(2);
            player.sendMessage("@red@<img=832>You have completed the achievement: @blu@" + achievement.toString());
        }
    }

    public JsonArray jsonSave() {
        JsonArray jsonArray = new JsonArray();
        for (Map.Entry<Integer, AchievementProgress> progress : idToProgress.entrySet()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", progress.getKey());
            jsonObject.addProperty("amount", progress.getValue().amountDone);
            jsonObject.addProperty("collected", progress.getValue().rewardCollected);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public void load(JsonElement jsonElement) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        for (JsonElement element : jsonArray) {
            if (!element.isJsonObject())
                continue;

            JsonObject object = (JsonObject) element;
            int id = object.get("id").getAsInt();
            int amount = object.get("amount").getAsInt();
            boolean collected = object.get("collected").getAsBoolean();
            idToProgress.put(id, new AchievementProgress(amount, collected));
        }
    }

    public int getProgressFor(AchievementData selected) {
        if (idToProgress.containsKey(selected.id))
            return idToProgress.get(selected.id).amountDone;
        return 0;
    }

    public boolean hasCollected(AchievementData selected) {
        if (!idToProgress.containsKey(selected.id))
            return false;
        return idToProgress.get(selected.id).rewardCollected;
    }

    public void setCollected(AchievementData selected) {
        if (!idToProgress.containsKey(selected.id)) {
            System.err.println("No Progress but collected achievement reward!");
            return;
        }
        idToProgress.get(selected.id).rewardCollected = true;
    }

    class AchievementProgress {
        private int amountDone;
        private boolean rewardCollected;

        AchievementProgress(int amountDone, boolean rewardCollected) {
            this.amountDone = amountDone;
            this.rewardCollected = rewardCollected;
        }

        int addAmount(int amount, int maxAmount) {
            amountDone = Math.min(amountDone + amount, maxAmount);
            return amountDone;
        }
    }
}
