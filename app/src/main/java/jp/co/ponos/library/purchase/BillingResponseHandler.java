package jp.co.ponos.library.purchase;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: jp.co.ponos.library.purchase.m */
/* loaded from: classes.dex */
public class BillingResponseHandler {
    private static PurchaseObserver a;
    private static LinkedList b = new LinkedList();

    public static void a(int i, Throwable th) {
        if (a != null) {
            a.a(i, th);
        } else {
            b.add(new aBillingException(i, th));
        }
    }

    public static void a(PendingIntent pendingIntent, Intent intent) {
        if (a == null) {
            Log.d("ResponseHandler", "UI is not running");
        } else {
            a.a(pendingIntent, intent);
        }
    }

    public static void a(Context context, LogPurchaseRequest logPurchaseRequest, BillingState billingState) {
        if (a != null) {
            a.a(logPurchaseRequest, billingState);
        } else {
            b.add(new aBilllingRequest(logPurchaseRequest, billingState));
        }
    }

    public static void a(Context context, OrderState orderState, String str, String str2, long j, String str3, String str4) {
        if (a != null) {
            a.a(orderState, str, str2, j, str3, str4);
        } else {
            b.add(new aOrder(orderState, str, str2, j, str3, str4));
        }
    }

    public static synchronized void a(PurchaseObserver purchaseObserver) {
        synchronized (BillingResponseHandler.class) {
            a = purchaseObserver;
            if (a != null && !b.isEmpty()) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    ((aPurchaseBase) it.next()).a(a);
                }
                b.clear();
            }
        }
    }

    public static void a(boolean z, String str) {
        if (a != null) {
            a.a(z, str);
        } else {
            b.add(new aPurchase(z, str));
        }
    }

    public static synchronized void b(PurchaseObserver purchaseObserver) {
        synchronized (BillingResponseHandler.class) {
            a = null;
        }
    }
}
