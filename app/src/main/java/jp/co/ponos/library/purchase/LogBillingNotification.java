package jp.co.ponos.library.purchase;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.e */
/* loaded from: classes.dex */
public class LogBillingNotification extends BillingLogger {
    final String[] c;
    final /* synthetic */ BillingService d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogBillingNotification(BillingService billingService, int i, String[] strArr) {
        super(billingService, i);
        this.d = billingService;
        this.c = strArr;
    }

    @Override // jp.co.ponos.library.purchase.BillingLogger
    protected long d() {
        //com.a.a.a.a aVar;
        Bundle a = a("CONFIRM_NOTIFICATIONS");
        a.putStringArray("NOTIFY_IDS", this.c);
        //aVar = BillingService.a;
       // Bundle a2 = aVar.a(a);
        //a("confirmNotifications", a2);
        //return a2.getLong("REQUEST_ID", BillingRequestID.id);
        return -1;
    }
}
