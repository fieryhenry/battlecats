package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.purchase.aPurchaseDelegate;
import jp.co.ponos.library.score.MyUtility;

/* renamed from: jp.co.ponos.battlecats.i */
/* loaded from: classes.dex */
public class MyPurchaseDelegate extends aPurchaseDelegate {
    @Override // jp.co.ponos.library.purchase.aPurchaseDelegate
    public void a() {
        MyUtility.getInstance().addButton(MyUtility.getString("purchase_failed"));
    }

    @Override // jp.co.ponos.library.purchase.aPurchaseDelegate
    public boolean a(String str) {
        if ((A.a().getScene() == 300 && A.a().battleData[14] == 1) || A.a().getScene() == 99) {
            return false;
        }
        if (A.a().getScene() == 100 && A.a().fD == 9999) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (aString.isEqual(str, A.a().purchaseIDs[i])) {
                if (A.a().hA == 0) {
                    A.a().hy = (int) (((MyUtility.getTimeStamp() - A.a().ht[0]) / 86400.0d) + 1.0d);
                    A.a().hz = A.a().hv;
                    A.a().hA = 1;
                }
                int[] iArr = A.a().hx;
                iArr[i] = iArr[i] + 1;
                if (A.a().hx[i] >= 999999999) {
                    A.a().hx[i] = 999999999;
                }
                AppInstance a = A.a();
                a.catfood = AppInstance.l[i] + a.catfood;
                if (A.a().catfood >= 999999) {
                    A.a().catfood = 999999;
                }
                A.a().h = true;
                A.a().aSave();
                A.a().i = 0;
                MyUtility.getInstance().addWebClient();
                return true;
            }
        }
        return false;
    }

    @Override // jp.co.ponos.library.purchase.aPurchaseDelegate
    public void b() {
    }
}
