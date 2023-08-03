package jp.co.ponos.library.purchase;

import android.app.Activity;
import java.util.ArrayList;

/* renamed from: jp.co.ponos.library.purchase.y */
/* loaded from: classes.dex */
class InappObserver extends PurchaseObserver {
    ArrayList a;

    public InappObserver(Activity activity) {
        super(activity);
        this.a = new ArrayList();
    }

    @Override // jp.co.ponos.library.purchase.PurchaseObserver
    public void a(int i, Throwable th) {
        if (Inapp.a.d != null) {
            Inapp.a.d.a();
        }
    }

    @Override // jp.co.ponos.library.purchase.PurchaseObserver
    public void a(LogPurchaseRequest logPurchaseRequest, BillingState billingState) {
    }

    @Override // jp.co.ponos.library.purchase.PurchaseObserver
    public void a(OrderState orderState, String str, String str2, long j, String str3, String str4) {
        if (Inapp.a.d != null) {
            if (orderState != OrderState.PURCHASED || str4 == null) {
                if (orderState == OrderState.CANCELED) {
                    Inapp.a.d.b();
                } else {
                    Inapp.a.d.a();
                }
            } else if (this.a.contains(str4) || !Inapp.a.d.a(str)) {
            } else {
                Inapp.a.b.b(str4);
                if (str.indexOf("android.test") == -1) {
                    this.a.add(str4);
                }
            }
        }
    }

    @Override // jp.co.ponos.library.purchase.PurchaseObserver
    public void a(boolean z, String str) {
        Inapp.a.e = z;
    }
}
