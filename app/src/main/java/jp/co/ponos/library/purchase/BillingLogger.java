package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.c */
/* loaded from: classes.dex */
public abstract class BillingLogger {
    protected long a;
    final /* synthetic */ BillingService b;
    private final int c;

    public BillingLogger(BillingService billingService, int i) {
        this.b = billingService;
        this.c = i;
    }

    private void a(aException aexception) {
        Log.w("BillingService", "Could not reach the verification service or verification failed");
        BillingResponseHandler.a(aexception.a(), aexception.getCause());
    }

    public int a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("BILLING_REQUEST", str);
        bundle.putInt("API_VERSION", 2);
        bundle.putString("PACKAGE_NAME", this.b.getPackageName());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RemoteException remoteException) {
        Log.w("BillingService", "remote billing service crashed");
        //BillingService.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Bundle bundle) {
        Log.e("BillingService", String.valueOf(str) + " received " + BillingState.a(bundle.getInt("RESPONSE_CODE")).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BillingState billingState) {
    }

    public boolean b() {
        boolean e;
        LinkedList linkedList;
        if (c()) {
            return true;
        }
        e = this.b.e();
        if (e) {
            linkedList = BillingService.b;
            linkedList.add(this);
            return true;
        }
        return false;
    }

    public boolean c() {
        //com.a.a.a.a aVar;
        HashMap hashMap;
        Log.d("BillingService", getClass().getSimpleName());
        //aVar = BillingService.a;
        //if (aVar != null) {
        //    try {
        //        this.a = d();
        //        Log.d("BillingService", "request id: " + this.a);
        //        if (this.a >= 0) {
        //            hashMap = BillingService.c;
        //            hashMap.put(Long.valueOf(this.a), this);
        //            return true;
        //        }
        //        return true;
        //    } catch (RemoteException e) {
        //        a(e);
        //    } catch (aException e2) {
        //        a(e2);
        //        return true;
        //    }
        //}
        return false;
    }

    protected abstract long d();
}
