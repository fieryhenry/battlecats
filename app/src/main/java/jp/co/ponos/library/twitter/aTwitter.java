package jp.co.ponos.library.twitter;

import jp.co.ponos.library.score.MyUtility;

/* renamed from: jp.co.ponos.library.e.a */
/* loaded from: classes.dex */
public class aTwitter {
    static aTwitter a;

    /* renamed from: a */
    public static void createInstance() {
        a = new aTwitter();
    }

    /* renamed from: b */
    public static aTwitter getInstance() {
        return a;
    }

    /* renamed from: a */
    public void tweet(String str, String str2) {
        String str3 = "http://twitter.com/intent/tweet?text=" + MyUtility.urlEncode(str);
        if (str2 != null) {
            str3 = String.valueOf(str3) + "&url=" + MyUtility.urlEncode(str2);
        }
        MyUtility.getInstance().addJSDialog(str3);
    }

    @Deprecated
    /* renamed from: a */
    public void tweet(String str, String str2, String str3) {
        tweet(str, str2);
    }

    public boolean c() {
        return true;
    }
}
