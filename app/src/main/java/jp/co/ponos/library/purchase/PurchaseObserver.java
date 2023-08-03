package jp.co.ponos.library.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: jp.co.ponos.library.purchase.l */
/* loaded from: classes.dex */
public abstract class PurchaseObserver {
    private static final Class[] d = {IntentSender.class, Intent.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
    private final Activity a;
    private Method b;
    private Object[] c = new Object[5];

    public PurchaseObserver(Activity activity) {
        this.a = activity;
        a();
    }

    private void a() {
        try {
            this.b = this.a.getClass().getMethod("startIntentSender", d);
        } catch (NoSuchMethodException e) {
            this.b = null;
        } catch (SecurityException e2) {
            this.b = null;
        }
    }

    public abstract void a(int i, Throwable th);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PendingIntent pendingIntent, Intent intent) {
        if (this.b == null) {
            try {
                pendingIntent.send(this.a, 0, intent);
                return;
            } catch (PendingIntent.CanceledException e) {
                Log.e("PurchaseObserver", "error starting activity", e);
                return;
            }
        }
        try {
            this.c[0] = pendingIntent.getIntentSender();
            this.c[1] = intent;
            this.c[2] = 0;
            this.c[3] = 0;
            this.c[4] = 0;
            this.b.invoke(this.a, this.c);
        } catch (Exception e2) {
            Log.e("PurchaseObserver", "error starting activity", e2);
        }
    }

    public abstract void a(LogPurchaseRequest logPurchaseRequest, BillingState billingState);

    public abstract void a(OrderState orderState, String str, String str2, long j, String str3, String str4);

    public abstract void a(boolean z, String str);
}
