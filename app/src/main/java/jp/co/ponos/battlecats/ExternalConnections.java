package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aPurchaseDialog;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.aUtility;
import jp.co.ponos.library.purchase.Inapp;
import jp.co.ponos.library.score.ScoreSubmit;
import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.twitter.aTwitter;

/* renamed from: jp.co.ponos.battlecats.h */
/* loaded from: classes.dex */
class ExternalConnections extends ScoreSubmit {
    public void buy(int i) {
        if (A.a().b) {
            MyUtility.getInstance();
            if (!aUtility.isConnected()) {
                MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
            } else if (i < 0) {
                if (i == -2) {
                    //com.tapjoy.g.a().b();
                    A.a().b = false;
                }
            } else if (!Inapp.b().g()) {
                MyUtility.getInstance().addButton(MyUtility.getString("gmail_err"));
            } else {
                Inapp.b().a(A.a().purchaseIDs[i]);
                A.a().b = false;
            }
        }
    }

    public void copyToClipboard(String str) {
        MyUtility.getInstance().editClipboard(str);
        MyUtility.getInstance().addButton(MyUtility.getString("Copied_txt"));
    }

    public void facebook(String str) {
        A.a().menuType = 4;
        A.a().f = null;
        A.a().f = str;
        MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=facebook&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
        int[] iArr = A.a().hC;
        iArr[0] = iArr[0] + 1;
        if (A.a().hC[0] >= 999999999) {
            A.a().hC[0] = 999999999;
        }
        A.a().ae();
    }

    public void facebook2() {
        MyUtility.getInstance().addWebClient();
        //aFacebook.getInstance().a(null, null);
        A.a().i = 0;
        A.a().menuType = -1;
        int[] iArr = A.a().hC;
        iArr[1] = iArr[1] + 1;
        if (A.a().hC[1] >= 999999999) {
            A.a().hC[1] = 999999999;
        }
        A.a().ae();
        if (A.a().getScene() == 100 && A.a().fD == 0) {
            //aAd.b().d();
        }
    }

    public void games() {
        if (A.a().getScene() == 100 && A.a().fD == 0) {
            //aAd.b().d();
        }
        MyUtility.getInstance().addWebClient();
        A.a().t = true;
        A.a().i = 0;
        A.a().menuType = -1;
        MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
        MyUtility.getInstance().addAlertAppliPage("games", A.a().r);
    }

    public void getInviteCount(int i) {
        A.a().hB = i;
        A.a().ae();
    }

    public void getPresent(int i) {
        MyUtility.getInstance();
        if (!aUtility.isConnected()) {
            MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
            return;
        }
        MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
        String format = aString.format("type=get&pid=%s&present=%d&lang=%s", A.a().e, Integer.valueOf(i), MyUtility.getString("lang"));
        new aPurchaseDialog().a(aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), format, MyUtility.md5(aString.format("%s&check=adlmn", format))), A.a().d);
    }

    public void line(String str) {
        A.a().f = null;
        A.a().f = str;
        MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=line&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
        int[] iArr = A.a().hC;
        iArr[2] = iArr[2] + 1;
        if (A.a().hC[2] >= 999999999) {
            A.a().hC[2] = 999999999;
        }
        A.a().ae();
        A.a().menuType = 6;
    }

    public void line2(String str) {
        A.a().i = 0;
        A.a().menuType = -1;
        MyUtility.getInstance().addWebClient();
        MyUtility.getInstance().displayURL("http://line.naver.jp/msg/text/" + MyUtility.urlEncode(str));
    }

    public void review(String str) {
        if (A.a().getScene() == 100 && A.a().fD == 0) {
            //aAd.b().d();
        }
        A.a().f = null;
        A.a().f = str;
        MyUtility.getInstance().addWebClient();
        A.a().t = true;
        MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
        MyUtility.getInstance().addAlertAppliPage("review", A.a().r);
        A.a().i = 0;
        A.a().menuType = -1;
        int[] iArr = A.a().hC;
        iArr[3] = iArr[3] + 1;
        if (A.a().hC[3] >= 999999999) {
            A.a().hC[3] = 999999999;
        }
        A.a().ae();
    }

    public void twitter(String str) {
        A.a().f = null;
        A.a().f = str;
        MyUtility.getInstance().addWebClient();
        A.a().i = 0;
        A.a().menuType = -1;
        if (A.a().getScene() == 100 && A.a().fD == 0) {
            //aAd.b().d();
        }
        aTwitter.getInstance().tweet(aString.format("%s %s %s", aString.format(MyUtility.getString("twitter_txt3"), A.a().f), MyUtility.getString("url_abbr"), MyUtility.getString("twitter_hash")), null, null);
        int[] iArr = A.a().hC;
        iArr[1] = iArr[1] + 1;
        if (A.a().hC[1] >= 999999999) {
            A.a().hC[1] = 999999999;
        }
        A.a().ae();
    }

    public void video() {
        if (A.a().getScene() == 100 && A.a().fD == 0) {
            //aAd.b().d();
        }
        MyUtility.getInstance().addWebClient();
        A.a().t = true;
        A.a().i = 0;
        A.a().menuType = -1;
        MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
        MyUtility.getInstance().addAlertAppliPage("video", A.a().r);
    }
}
