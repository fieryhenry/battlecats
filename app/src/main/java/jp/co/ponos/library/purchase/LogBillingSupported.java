package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.d */
/* loaded from: classes.dex */
public class LogBillingSupported extends BillingLogger {
    public String c;
    final /* synthetic */ BillingService d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogBillingSupported(BillingService billingService, String str) {
        super(billingService, -1);
        this.d = billingService;
        this.c = null;
        this.c = str;
    }

    @Override // jp.co.ponos.library.purchase.BillingLogger
    protected long d() {
        //com.a.a.a.a aVar;
        Bundle a = a("CHECK_BILLING_SUPPORTED");
        if (this.c != null) {
            a.putString("ITEM_TYPE", this.c);
        }
        //aVar = BillingService.a;
        //int i = aVar.a(a).getInt("RESPONSE_CODE");
        //Log.i("BillingService", "CheckBillingSupported response code: " + BillingState.a(i));
        //BillingResponseHandler.a(i == BillingState.RESULT_OK.ordinal(), this.c);
        return BillingRequestID.id;
    }
}
