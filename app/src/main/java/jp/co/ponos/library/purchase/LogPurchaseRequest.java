package jp.co.ponos.library.purchase;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.g */
/* loaded from: classes.dex */
public class LogPurchaseRequest extends BillingLogger {
    public final String c;
    public final String d;
    public final String e;
    final /* synthetic */ BillingService f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogPurchaseRequest(BillingService billingService, String str, String str2, String str3) {
        super(billingService, -1);
        this.f = billingService;
        this.c = str;
        this.d = str3;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jp.co.ponos.library.purchase.BillingLogger
    public void a(BillingState billingState) {
        BillingResponseHandler.a(this.f, this, billingState);
    }

    @Override // jp.co.ponos.library.purchase.BillingLogger
    protected long d() {
        //com.a.a.a.a aVar;
        Bundle a = a("REQUEST_PURCHASE");
        a.putString("ITEM_ID", this.c);
        a.putString("ITEM_TYPE", this.e);
        if (this.d != null) {
            a.putString("DEVELOPER_PAYLOAD", this.d);
        }
        //aVar = BillingService.a;
        //Bundle a2 = aVar.a(a);
        //PendingIntent pendingIntent = (PendingIntent) a2.getParcelable("PURCHASE_INTENT");
        //if (pendingIntent == null) {
        //    Log.e("BillingService", "Error with requestPurchase");
        //    return BillingRequestID.id;
        //}
        //BillingResponseHandler.a(pendingIntent, new Intent());
        //return a2.getLong("REQUEST_ID", BillingRequestID.id);
        return -1;
    }
}
