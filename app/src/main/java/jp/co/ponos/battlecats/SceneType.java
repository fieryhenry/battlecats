package jp.co.ponos.battlecats;

public enum SceneType {
    NONE(-1),
    ERROR(4),
    OPENING(98),
    ENDING(99),
    MAIN(100),
    BATTLE(300),
    ;

    public final int sceneID;

    SceneType(int sceneID) {
        this.sceneID = sceneID;
    }

    public static SceneType valueOf(int sceneID) {
        for (SceneType type : values()) {
            if (type.sceneID == sceneID) {
                return type;
            }
        }
        return NONE;
    }

}
