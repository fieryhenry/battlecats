package jp.co.ponos.library.score;

import jp.co.ponos.library.game.aSettings;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.aUtility;

/* renamed from: jp.co.ponos.library.d.f */
/* loaded from: classes.dex */
public class MyUtility extends aUtility {
    /* renamed from: r */
    public static void createInstance() {
        instance = new MyUtility();
    }

    /* renamed from: s */
    public static String getAppli() {
        return aSettings.getInstance().getSetting("http://www.ponos.net/android/appli");
    }

    @Override // jp.co.ponos.library.game.aUtility
    /* renamed from: c */
    protected String getAppliPage(String str, String str2) {
        return aString.format("%s/games/link.php?type=1&appli=%s&page=%s&lang=%s&ref=appli_access_%s_%s", getAppli(), str, str2, getString("lang"), aSettings.getInstance().packageName, str2);
    }

    @Override // jp.co.ponos.library.game.aUtility
    /* renamed from: g */
    public String getID() {
        String f = getDeviceID();
        return f != null ? f : getUserID();
    }
}
