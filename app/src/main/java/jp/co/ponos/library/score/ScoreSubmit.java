package jp.co.ponos.library.score;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import java.util.ArrayList;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aJSInterfaceBase;

/* renamed from: jp.co.ponos.library.d.e */
/* loaded from: classes.dex */
public class ScoreSubmit extends aJSInterfaceBase {
    public void error(String str) {
        Toast.makeText(aGlobal.getInstance().getContext(), str, 0).show();
    }

    public void submitScore(String str, String str2, String str3, String str4) {
        String str5;
        int[] iArr;
        try {
            str5 = str4.length() > 8 ? str4.substring(0, 8) : str4;
            try {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(aGlobal.getInstance().getContext()).edit();
                edit.putString(MyUtility.md5("name"), MyUtility.encrypt(MyUtility.md5("name"), str5));
                edit.commit();
                String[] split = str2.split(",", -1);
                int[] iArr2 = new int[split.length];
                for (int i = 0; i < iArr2.length; i++) {
                    iArr2[i] = Integer.parseInt(split[i]);
                }
                if (str3.length() > 0) {
                    String[] split2 = str3.split(",", -1);
                    iArr = new int[split2.length];
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        iArr[i2] = Integer.parseInt(split2[i2]);
                    }
                } else {
                    iArr = null;
                }
                ArrayList dialogs = aGlobal.getInstance().getDialogs();
                aScoreUploader ascoreuploader = aScoreUploader.getInstance();
                ascoreuploader.getClass();
                dialogs.add(new aScoreDialog(ascoreuploader, "leaderboard_reg.php", str, str5, iArr2, iArr));
                MyUtility.getInstance().addWebClient();
            } catch (Exception e) {
                ArrayList dialogs2 = aGlobal.getInstance().getDialogs();
                aScoreUploader ascoreuploader2 = aScoreUploader.getInstance();
                ascoreuploader2.getClass();
                dialogs2.add(new aScoreDialog(ascoreuploader2, "leaderboard_reg.php", str, str5, null, null));
            }
        } catch (Exception e2) {
            str5 = str4;
        }
    }
}
