package jp.co.ponos.library.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.a */
/* loaded from: classes.dex */
public class BillingStateChanged implements Runnable {
    final /* synthetic */ BillingReceiver a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingStateChanged(BillingReceiver billingReceiver, String str, String str2, Context context) {
        this.a = billingReceiver;
        this.b = str;
        this.c = str2;
        this.d = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PurchaseSender.a(this.b, this.c);
            Intent intent = new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED");
            intent.setClass(this.d, BillingService.class);
            intent.putExtra("inapp_signed_data", this.b);
            intent.putExtra("inapp_signature", this.c);
            this.d.startService(intent);
        } catch (aException e) {
            Intent intent2 = new Intent("com.example.subscriptions.ACTION_VERIFICATION_FAILED");
            intent2.setClass(this.d, BillingService.class);
            Bundle bundle = new Bundle();
            bundle.putInt("error", e.a());
            bundle.putSerializable("throwable", e.getCause());
            intent2.putExtras(bundle);
            this.d.startService(intent2);
        }
    }
}
