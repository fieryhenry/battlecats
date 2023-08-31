package jp.co.ponos.library.game.stream;

import jp.co.ponos.library.game.Global;

public class FileHandler {
    public static boolean exists(String str) {
        return Global.getInstance().getContext().getFileStreamPath(str).exists();
    }

    public static boolean rename(String str, String str2) {
        return Global.getInstance().getContext().getFileStreamPath(str).renameTo(Global.getInstance().getContext().getFileStreamPath(str2));
    }
}
