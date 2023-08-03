package jp.co.ponos.library.purchase;

import android.app.Activity;
import jp.co.ponos.library.game.aGlobal;

/* renamed from: jp.co.ponos.library.purchase.w */
/* loaded from: classes.dex */
public class Inapp {
    static Inapp a;
    BillingService b;
    InappObserver c;
    aPurchaseDelegate d;
    boolean e;

    public static void a() {
        a = new Inapp();
    }

    public static Inapp b() {
        return a;
    }

    public void a(String str) {
        this.b.a(str, "inapp", (String) null);
    }

    public void a(aPurchaseDelegate apurchasedelegate) {
        this.d = apurchasedelegate;
    }

    public void c() {
        this.b = new BillingService();
        this.b.a((Activity) aGlobal.getInstance().getContext());
        this.c = new InappObserver((Activity) aGlobal.getInstance().getContext());
        d();
        this.b.a("inapp");
    }

    public void d() {
        BillingResponseHandler.a(this.c);
    }

    public void e() {
        BillingResponseHandler.b(this.c);
    }

    public void f() {
        this.b.a();
    }

    public boolean g() {
        return this.e;
    }
}
