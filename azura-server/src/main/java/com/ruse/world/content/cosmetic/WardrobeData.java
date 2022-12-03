package com.ruse.world.content.cosmetic;


/**
 * The wardrobes data.
 * @author Avalon
 */

public enum WardrobeData {
    /*
     * Wardrobe items
     */

    COSTUME_1(133071, "Season 1 Outfit", "2,000 Gems", 2000, WardrobeCategory.FAVORITES,
            new int[] {23396, 1}, //helmet
            new int[] {-1, 1}, //amulet
            new int[] {23397, 1}, //body
            new int[] {23398, 1}, //legs
            new int[] {23399, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {23400, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            9244, //npcid
            390,
            false),//zoom

    COSTUME_2(133072, "Rogue Bandit", "5000 Gems", 5000, WardrobeCategory.FAVORITES,
            new int[] {10612, 1}, //helmet
            new int[] {19335, 1}, //amulet
            new int[] {5553, 1}, //body
            new int[] {5555, 1}, //legs
            new int[] {5557, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {5556, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            2270, //npcid
            320,
            false),//zoom

    ;


    private int clickingid, textButtonId, backgroundButtonId;

    /** The name of the teleport. */
    private final int[] helmet;
    public int[] getHelmet() {
        return helmet;
    }
    private final int[] amulet;
    public int[] getAmulet() {
        return amulet;
    }
    private final int[] body;
    public int[] getBody() {
        return body;
    }
    private final int[] legs;
    public int[] getLegs() {
        return legs;
    }
    private final int[] boots;
    public int[] getBoots() {
        return boots;
    }
    private final int[] cape;
    public int[] getCape() {
        return cape;
    }
    private final int[] weapon;
    public int[] getWeapon() {
        return weapon;
    }
    private final int[] aura;
    public int[] getAura() {
        return aura;
    }
    private final int[] gloves;
    public int[] getGloves() {
        return gloves;
    }
    private final int[] shield;
    public int[] getShield() {
        return shield;
    }
    private final int[] ring;
    public int[] getRing() {
        return ring;
    }

    public final int npcId;
    public int getNpcId() {
        return npcId;
    }
    public boolean unlocked;

    public boolean getOutfitUnlocked() {
        return unlocked;
    }
    public void setOutfitUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    private final String name;

    private final String description;

    private final int cost;
    public int getCost() {
        return cost;
    }
    /** The type of the teleport. */
    private final WardrobeCategory type;

    public final int buttonId;

    private int spriteId;

    private final int adjustedZoom;
    /** Creates a new <code>Teleport<code>. */ //might have to make it multidimensioanl
    //the format of the enumid
    WardrobeData(int buttonId, String name,
                 String description, int cost, WardrobeCategory type, int[] helmet,int[] amulet,int[] body,int[] legs,int[] boots,int[] cape,int[]
                         weapon,int[] aura,int[] gloves,int[] shield,int[] ring,int npcId, int adjustedZoom,boolean unlocked) {
        //npcid is 3rd to last parameter
        //this.index = (index);
        this.buttonId = buttonId;
        this.clickingid = clickingid;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.type = type;
        this.helmet = helmet;
        this.amulet = amulet;
        this.body = body;
        this.legs = legs;
        this.boots = boots;
        this.cape = cape;
        this.weapon = weapon;
        this.aura = aura;
        this.gloves = gloves;
        this.shield = shield;
        this.ring = ring;
        this.npcId = npcId;
        this.adjustedZoom = adjustedZoom;
        this.unlocked = unlocked;
    }

    public String getName() {
        return name;
    }
    public int getAdjustedZoom() {
        return adjustedZoom;
    }
    public String getDescription() {
        return description;
    }

    public WardrobeCategory getType() {
        return type;
    }

    public int getButtonId() {
        return buttonId;
    }


}
