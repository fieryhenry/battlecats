package jp.co.ponos.library.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.b */
/* loaded from: classes.dex */
public class SubscriptionInfo implements Runnable {
    final /* synthetic */ BillingReceiver a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscriptionInfo(BillingReceiver billingReceiver, Context context, String str) {
        this.a = billingReceiver;
        this.b = context;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            long b = PurchaseSender.b();
            Intent intent = new Intent("com.example.subscriptions.GET_PURCHASE_INFORMATION");
            intent.setClass(this.b, BillingService.class);
            intent.putExtra("notification_id", this.c);
            intent.putExtra("server_nonce", b);
            this.b.startService(intent);
        } catch (aException e) {
            Intent intent2 = new Intent("com.example.subscriptions.ACTION_VERIFICATION_FAILED");
            intent2.setClass(this.b, BillingService.class);
            Bundle bundle = new Bundle();
            bundle.putInt("error", e.a());
            bundle.putSerializable("throwable", e.getCause());
            intent2.putExtras(bundle);
            this.b.startService(intent2);
        }
    }
}
