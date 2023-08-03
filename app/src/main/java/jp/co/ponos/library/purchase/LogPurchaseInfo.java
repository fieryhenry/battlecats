package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.f */
/* loaded from: classes.dex */
public class LogPurchaseInfo extends BillingLogger {
    long c;
    final String[] d;
    final /* synthetic */ BillingService e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogPurchaseInfo(BillingService billingService, int i, String[] strArr, long j) {
        super(billingService, i);
        this.e = billingService;
        this.c = j;
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jp.co.ponos.library.purchase.BillingLogger
    public void a(RemoteException remoteException) {
        super.a(remoteException);
    }

    @Override // jp.co.ponos.library.purchase.BillingLogger
    protected long d() {
        //com.a.a.a.a aVar;
        Bundle a = a("GET_PURCHASE_INFORMATION");
        a.putLong("NONCE", this.c);
        a.putStringArray("NOTIFY_IDS", this.d);
        //aVar = BillingService.a;
        //Bundle a2 = aVar.a(a);
        //a("getPurchaseInformation", a2);
        //return a2.getLong("REQUEST_ID", BillingRequestID.id);
        return -1;
    }
}
