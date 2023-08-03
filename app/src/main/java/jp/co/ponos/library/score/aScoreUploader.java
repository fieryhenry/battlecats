package jp.co.ponos.library.score;

import android.preference.PreferenceManager;
import jp.co.ponos.library.game.aBrowserOption;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aSettings;
import jp.co.ponos.library.game.aString;

/* renamed from: jp.co.ponos.library.d.a */
/* loaded from: classes.dex */
public class aScoreUploader {

    /* renamed from: a */
    static aScoreUploader instance;

    /* renamed from: b */
    aScore scoreInstance;

    /* renamed from: a */
    public static void createInstance() {
        instance = new aScoreUploader();
    }

    /* renamed from: b */
    public static aScoreUploader getInstance() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String submitScore(String str, String str2, String str3, int[] iArr, int[] iArr2) {
        String format = aString.format("uid=%s&appli=%s&id=%s&name=%s&lang=%s", getID(), aSettings.getInstance().packageName, str2, MyUtility.urlEncode(str3), MyUtility.getString("lang"));
        for (int i = 0; i < iArr.length; i++) {
            format = String.valueOf(format) + aString.format("&score%d=%d", Integer.valueOf(i), Integer.valueOf(iArr[i]));
        }
        if (iArr2 != null) {
            for (int i2 = 0; i2 < iArr2.length; i2++) {
                format = String.valueOf(format) + aString.format("&param%d=%d", Integer.valueOf(i2), Integer.valueOf(iArr2[i2]));
            }
        }
        return aString.format("%s/games/%s?%s&check=%s", MyUtility.getAppli(), str, format, MyUtility.urlEncode(MyUtility.encrypt(MyUtility.md5(aSettings.getInstance().packageName), format)));
    }

    /* renamed from: a */
    public void setScoreInstance(aScore ascore) {
        this.scoreInstance = ascore;
    }

    /* renamed from: a */
    public boolean viewLeaderboard(String str) {
        aBrowserOption abrowseroption = new aBrowserOption();
        abrowseroption.setSystemFlag(true);
        MyUtility.getInstance().addJSDialog(aString.format("%s/games/leaderboard.php?uid=%s&appli=%s&id=%s&lang=%s", MyUtility.getAppli(), getID(), aSettings.getInstance().packageName, str, MyUtility.getString("lang")), abrowseroption);
        return true;
    }

    /* renamed from: a */
    public boolean configureLeaderboard(String str, int i) {
        return configureLeaderboard(str, new int[]{i}, null);
    }

    /* renamed from: a */
    public boolean configureLeaderboard(String str, int[] iArr, int[] iArr2) {
        String b = MyUtility.decrypt(MyUtility.md5("name"), PreferenceManager.getDefaultSharedPreferences(aGlobal.getInstance().getContext()).getString(MyUtility.md5("name"), MyUtility.encrypt(MyUtility.md5("name"), "")));
        if (b.length() > 8) {
            b = b.substring(0, 8);
        }
        aBrowserOption abrowseroption = new aBrowserOption();
        abrowseroption.setSystemFlag(true);
        MyUtility.getInstance().addJSDialog(submitScore("leaderboard_conf.php", str, b, iArr, iArr2), abrowseroption);
        return true;
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    /* renamed from: e */
    public String getID() {
        return MyUtility.getInstance().getID();
    }
}
