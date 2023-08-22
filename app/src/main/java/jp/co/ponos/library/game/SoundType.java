package jp.co.ponos.library.game;

public enum SoundType {
    ALL(-1),
    OPENING(0),
    TITLE(1),
    CAT_BASE(2),
    BATTLE_3(3),
    BATTLE_4(4),
    ENDING(5),
    BATTLE_6(6),
    BATTLE_START(7),
    BATTLE_VICTORY(8),
    BATTLE_LOSE(9),
    BUTTON_SELECT(10),
    BUTTON_PRESS(11),
    MENU_NAVIGATION_BUTTON2(12),
    MENU_NAVIGATION_BUTTON3(13),
    UPGRADE(14),
    CANT_PRESS(15),
    MENU_NAVIGATION_BUTTON4(16),
    MENU_NAVIGATION_BUTTON5(17),
    MENU_NAVIGATION_BUTTON6(18),
    BATTLE_ACTIVATE(19),
    HIT_1(20),
    HIT_2(21),
    BASE_HIT(22),
    ENEMY_KILLED(23),
    UNIT_KILLED(24),
    CANNON_BEAM(25),
    CANNON_BLAST(26),
    CAT_RECHARGE(27),
    CANNON_RECHARGE(28),
    REWARD_GET(29),
    BATTLE_30(30),
    BATTLE_31(31),
    BATTLE_32(32),
    BATTLE_33(33),
    BATTLE_34(34),
    MERGE_1(35),
    GOD_1(36),
    GOD_2(37),
    MERGE_2(38),
    MERGE_3(39),
    MERGE_4(40),
    STAMP(41),
    POPUP(42);

    public final int soundID;

    SoundType(int soundID) {
        this.soundID = soundID;
    }


    public static SoundType valueOf(int value) {
        for (SoundType type : values()) {
            if (type.soundID == value) {
                return type;
            }
        }
        return ALL;
    }

}
