package jp.co.ponos.battlecats;

public enum ScreenType {
    NONE(-1),
    TITLE(0),
    CAT_BASE(5),
    MAP(9),
    POWER_UP(7),
    EQUIP(3),
    TREASURE(6),
    ENEMY_GUIDE(8),
    MAP2(4),
    ITEM_SHOP(999),
    STAMP(9999),
    LEGEND(99999),
    ;

    public final int screenID;
    ScreenType(int screenID) {
        this.screenID = screenID;
    }

    public static ScreenType valueOf(int screenID) {
        for (ScreenType type : values()) {
            if (type.screenID == screenID) {
                return type;
            }
        }
        return NONE;
    }

}
