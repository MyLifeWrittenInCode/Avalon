package com.ruse.world.content.dailyTasksNew;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DailyTaskManager {

    private final Player p;

    private int selectedDifficulty = 0;
    private int selectedSlot = 0;

    @Getter
    @Setter
    private DailyTaskSlot[][] taskSlots = new DailyTaskSlot[5][5];

    public void refresh() {
        for (int i = 0; i < 5; i++) {
            DailyTaskDifficulty difficulty = DailyTaskDifficulty.values()[i];
            refreshTasks(difficulty);
        }
        p.sendMessage("<col=0264ea>Your Daily tasks have been reset.");
    }

    public void refreshTasks(DailyTaskDifficulty difficulty) {
        for (int j = 0; j < difficulty.getTasksPerDay(); j++) {
           // if (taskSlots[difficulty.ordinal()][j] == null)
            taskSlots[difficulty.ordinal()][j] = new DailyTaskSlot();
                taskSlots[difficulty.ordinal ()][j].assignTask (DailyTask.getRandomTaskByDifficulty (difficulty));
        }
    }

    public void submitProgressToIdentifier(int identifier, int progress) {
        for (int i = 0; i < taskSlots.length; i++) {
            for (int j = 0; j < taskSlots[i].length; j++) {
                DailyTaskSlot slot = taskSlots[i][j];
                if (slot != null && slot.getTask() != null && !slot.isCompleted()) {
                    if (slot.getTask().getTaskIdentifier() == identifier) {
                        slot.addProgress(progress);
                        slot.checkForCompletion(p);
                        if (p.getInterfaceId() == 143000)
                            sendData();
                    }
                }
            }
        }
    }

    public void open() {
        p.getPA().sendInterface(143000);
        selectedDifficulty = 0;
        selectedSlot = 0;
        sendData();
    }

    public void sendData() {
        String text = "Easy";
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 1:
                    text = "Medium";
                    break;
                case 2:
                    text = "Hard";
                    break;
                case 3:
                    text = "Elite";
                    break;
                case 4:
                    text = "Master";
                    break;
            }
            if (i == selectedDifficulty)
                text = "@gre@" + text;
            p.getPA().sendString(143010 + (i * 4), text);
        }
        int numberOfTasks = DailyTaskDifficulty.values()[selectedDifficulty].getTasksPerDay();
        for (int i = 0; i < 5; i++) {
            if (i < numberOfTasks) {
                String taskName = taskSlots[selectedDifficulty][i].getTask().getName();
                text = (i == selectedSlot ? "@whi@" : taskSlots[selectedDifficulty][i].isCompleted() ? "@gre@" : taskSlots[selectedDifficulty][i].getProgressOnTask() != 0 ? "@yel@":   "")
                        + taskName.replace("\\n" ,   "\\n" + (i == selectedSlot ? "@whi@" : taskSlots[selectedDifficulty][i].isCompleted() ? "@gre@" :
                        taskSlots[selectedDifficulty][i].getProgressOnTask() != 0 ? "@yel@" : ""));
            } else {
                text = "";
            }
            p.getPA().sendString(143030 + (i * 4), text);

        }
        DailyTaskSlot selectedTaskSlot = taskSlots[selectedDifficulty][selectedSlot];
        DailyTask selectedTask = selectedTaskSlot.getTask();
        p.getPA().sendString(143067, selectedTask.getName());
        text = selectedTaskSlot.isClaimedReward() ? "You have completed this task and claimed the reward!" : selectedTaskSlot.isCompleted() ? "Task is complete! Claim your reward now!" :
                "Progress - " + selectedTaskSlot.getProgressOnTask() + "/" + Misc.insertCommasToNumber(selectedTask.getAmountNeeded());
        p.getPA().sendString(143068, text);
        List<Item> rewardList = new ArrayList<>();
        for (Item item : selectedTask.getRewards())
            rewardList.add(item);
        p.getPA().sendInterfaceItems(143083, rewardList);

        p.getPA().sendString(143066, Misc.getTimeTillReset());
    }

    public boolean handleButton(int id) {
        if (id >= 143007 && id <= 143023) {
            int index = (id - 143007) / 4;
            selectedDifficulty = index;
            selectedSlot = 0;
            sendData();
            return true;
        } else if (id >= 143027 && id <= 143043) {
            int index = (id - 143027) / 4;
            if (taskSlots[selectedDifficulty][index] == null) {
                p.sendMessage("Invalid selection!");
            } else {
                selectedSlot = index;
                sendData();
            }
            return true;
        } else {
            switch (id) {
                case 143074:
                    if (taskSlots[selectedDifficulty][selectedSlot].getTask().getPosition() != null) {
                        TeleportHandler.teleportPlayer(p, taskSlots[selectedDifficulty][selectedSlot].getTask().getPosition(), p.getSpellbook().getTeleportType());
                    } else {
                        p.sendMessage("This task does not have a teleport!");
                    }
                    return true;
            }
        }
        return false;
    }


}
