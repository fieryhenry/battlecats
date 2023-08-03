package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aHashtable;
import jp.co.ponos.library.game.aPurchaseDialog;
import jp.co.ponos.library.game.aPurchaseHandler;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.score.MyUtility;

/* renamed from: jp.co.ponos.battlecats.k */
/* loaded from: classes.dex */
class MyPresentHandler extends aPurchaseHandler {
    @Override // jp.co.ponos.library.game.aPurchaseHandler
    public void a(aPurchaseDialog apurchasedialog) {
        String[] split = apurchasedialog.a().split("&", -1);
        aHashtable ahashtable = new aHashtable();
        for (String str : split) {
            String[] split2 = str.split("=", -1);
            ahashtable.put(split2[0], split2[1]);
        }
        MyUtility.getInstance().addAlertCloser();
        if (!ahashtable.contains("result") || !ahashtable.contains("present")) {
            String format = aString.format("type=get2&pid=%s&no=2&lang=%s", A.a().e, MyUtility.getString("lang"));
            MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/friend.php?%&check=%s", MyUtility.getAppli(), format, MyUtility.md5(aString.format("%s&check=adlmn", format))));
        } else if (!aString.isEqual(ahashtable.get("result"), "ok")) {
            if (aString.isEqual(ahashtable.get("result"), "ng")) {
                String format2 = aString.format("type=get2&pid=%s&no=%s&lang=%s", A.a().e, ahashtable.get("error"), MyUtility.getString("lang"));
                MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), format2, MyUtility.md5(aString.format("%s&check=adlmn", format2))));
                return;
            }
            String format3 = aString.format("type=get2&pid=%s&no=2&lang=%s", A.a().e, MyUtility.getString("lang"));
            MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), format3, MyUtility.md5(aString.format("%s&check=adlmn", format3))));
        } else {
            int parseInt = aString.parseInt(ahashtable.get("present"));
            if (parseInt < 0 || parseInt > 10 || A.a().bF[parseInt]) {
                return;
            }
            if (parseInt == 0) {
                A.a().aY += 10000;
                if (A.a().aY >= 99999999) {
                    A.a().aY = 99999999;
                }
            } else if (parseInt == 1) {
                A.a().aY += 10000;
                if (A.a().aY >= 99999999) {
                    A.a().aY = 99999999;
                }
            } else if (parseInt == 2) {
                int[] iArr = A.a().bA;
                iArr[0] = iArr[0] + 15;
                if (A.a().bA[0] >= 9999) {
                    A.a().bA[0] = 9999;
                }
            } else if (parseInt == 3) {
                A.a().catfood += 30;
                if (A.a().catfood >= 999999) {
                    A.a().catfood = 999999;
                }
            } else if (parseInt == 4) {
                A.a().aY += 30000;
                if (A.a().aY >= 99999999) {
                    A.a().aY = 99999999;
                }
            } else if (parseInt == 5) {
                int[] iArr2 = A.a().bA;
                iArr2[1] = iArr2[1] + 3;
                if (A.a().bA[1] >= 9999) {
                    A.a().bA[1] = 9999;
                }
            } else if (parseInt == 6) {
                A.a().catfood += 30;
                if (A.a().catfood >= 999999) {
                    A.a().catfood = 999999;
                }
            } else if (parseInt == 7) {
                A.a().aY += 50000;
                if (A.a().aY >= 99999999) {
                    A.a().aY = 99999999;
                }
            } else if (parseInt == 8) {
                int[] iArr3 = A.a().bA;
                iArr3[1] = iArr3[1] + 5;
                if (A.a().bA[1] >= 9999) {
                    A.a().bA[1] = 9999;
                }
            } else if (parseInt == 9) {
                A.a().catfood += 30;
                if (A.a().catfood >= 999999) {
                    A.a().catfood = 999999;
                }
            } else if (parseInt == 10) {
                A.a().bD[0] = 1;
                A.a().by[1] = 1;
                A.a().bC[A.a().unitBuyStats[16][13]] = 0;
            }
            MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=facebook&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
            String format4 = aString.format("type=get2&pid=%s&no=-1&lang=%s", A.a().e, MyUtility.getString("lang"));
            MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), format4, MyUtility.md5(aString.format("%s&check=adlmn", format4))));
            A.a().bF[parseInt] = true;
            A.a().aSave();
        }
    }

    @Override // jp.co.ponos.library.game.aPurchaseHandler
    public void b(aPurchaseDialog apurchasedialog) {
        MyUtility.getInstance().addAlertCloser();
        MyUtility.getInstance().addButton(MyUtility.getString("error"));
    }
}
