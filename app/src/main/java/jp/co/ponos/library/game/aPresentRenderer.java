package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.aw */
/* loaded from: classes.dex */
public abstract class aPresentRenderer {
    public void a() {
    }

    public void a(int i) {
    }

    public void a(String str) {
        if (aUtility.getInstance().canGoBack()) {
            aUtility.getInstance().goBack();
        } else {
            aUtility.getInstance().addWebClient();
        }
    }

    public void a(aHashtable ahashtable) {
    }

    public void b(String str) {
    }
}
