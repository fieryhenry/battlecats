package jp.co.ponos.battlecats;

import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.score.aScore;
import jp.co.ponos.library.score.aScoreUploader;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.battlecats.g */
/* loaded from: classes.dex */
public class MyScore extends aScore {
    @Override // jp.co.ponos.library.score.aScore
    public void a(String str, int i, int i2) {
        if (i2 == 1) {
            MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
        } else {
            MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
        }
    }

    @Override // jp.co.ponos.library.score.aScore
    public void b(String str, int i, int i2) {
        MyUtility.getInstance().addAlertCloser();
        if (i2 != 1) {
            MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
            return;
        }
        aScoreUploader.getInstance().viewLeaderboard("battlecats_score");
        A.a().aW = 0;
        A.a().aSave();
    }
}
