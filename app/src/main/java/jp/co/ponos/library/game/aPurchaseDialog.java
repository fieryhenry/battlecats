package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.h */
/* loaded from: classes.dex */
public class aPurchaseDialog {
    aPurchaseHandler a;
    String b;

    public String a() {
        return this.b;
    }

    public void a(String str, aPurchaseHandler apurchasehandler) {
        this.b = null;
        this.a = apurchasehandler;
        new aMakePurchaseHandler(this).execute(str);
    }
}
