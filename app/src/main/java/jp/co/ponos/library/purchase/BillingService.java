package jp.co.ponos.library.purchase;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BillingService extends Service implements ServiceConnection {
    public static LinkedList b = new LinkedList();
    public static HashMap c = new HashMap();

    private void a(int i, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("orders");
            int length = optJSONArray != null ? optJSONArray.length() : 0;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    arrayList.add(new Billing(OrderState.a(jSONObject.getInt("purchaseState")), jSONObject.has("notificationId") ? jSONObject.getString("notificationId") : null, jSONObject.getString("productId"), jSONObject.optString("orderId", ""), jSONObject.getLong("purchaseTime"), jSONObject.optString("developerPayload", null)));
                } catch (JSONException e) {
                    BillingResponseHandler.a(257, e);
                    return;
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Billing billing = (Billing) it.next();
                BillingResponseHandler.a(this, billing.a, billing.c, billing.d, billing.e, billing.f, billing.b);
            }
        } catch (JSONException e2) {
            BillingResponseHandler.a(257, e2);
        }
    }

    private void a(long j, BillingState billingState) {
        BillingLogger billingLogger = (BillingLogger) c.get(Long.valueOf(j));
        if (billingLogger != null) {
            Log.d("BillingService", String.valueOf(billingLogger.getClass().getSimpleName()) + ": " + billingState);
            billingLogger.a(billingState);
        }
        c.remove(Long.valueOf(j));
    }

    private boolean a(int i, String[] strArr) {
        return new LogBillingNotification(this, i, strArr).b();
    }

    private boolean a(int i, String[] strArr, long j) {
        return new LogPurchaseInfo(this, i, strArr, j).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        try {
            Log.i("BillingService", "binding to Market billing service");
        } catch (SecurityException e) {
            Log.e("BillingService", "Security exception: " + e);
        }
        if (bindService(new Intent("com.android.vending.billing.MarketBillingService.BIND"), this, Context.BIND_AUTO_CREATE)) {
            return true;
        }
        Log.e("BillingService", "Could not bind to service.");
        return false;
    }

    private void f() {
        int i = -1;
        while (true) {
            BillingLogger billingLogger = (BillingLogger) b.peek();
            if (billingLogger == null) {
                if (i >= 0) {
                    Log.i("BillingService", "stopping service, startId: " + i);
                    stopSelf(i);
                    return;
                }
                return;
            } else if (!billingLogger.c()) {
                e();
                return;
            } else {
                b.remove();
                if (i < billingLogger.a()) {
                    i = billingLogger.a();
                }
            }
        }
    }

    public void a() {
        try {
            unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }

    public void a(Context context) {
        attachBaseContext(context);
    }

    public void a(Intent intent, int i) {
        String action = intent.getAction();
        Log.i("BillingService", "handleCommand() action: " + action);
        if ("com.example.subscriptions.CONFIRM_NOTIFICATION".equals(action)) {
            a(i, intent.getStringArrayExtra("notification_id"));
        } else if ("com.example.subscriptions.GET_PURCHASE_INFORMATION".equals(action)) {
            String stringExtra = intent.getStringExtra("notification_id");
            long longExtra = intent.getLongExtra("server_nonce", -1L);
            if (longExtra != -1) {
                a(i, new String[]{stringExtra}, longExtra);
                return;
            }
            Log.e("BillingService", "nonce is missing");
            BillingResponseHandler.a(258, (Throwable) null);
        } else if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(action)) {
            a(i, intent.getStringExtra("inapp_signed_data"), intent.getStringExtra("inapp_signature"));
        } else if ("com.android.vending.billing.RESPONSE_CODE".equals(action)) {
            a(intent.getLongExtra("request_id", -1L), BillingState.a(intent.getIntExtra("response_code", BillingState.RESULT_ERROR.ordinal())));
        } else if ("com.example.subscriptions.ACTION_VERIFICATION_FAILED".equals(action)) {
            Bundle extras = intent.getExtras();
            BillingResponseHandler.a(extras.getInt("error", 0), (Throwable) extras.getSerializable("throwable"));
        }
    }

    public boolean a(String str) {
        return new LogBillingSupported(this, str).b();
    }

    public boolean a(String str, String str2, String str3) {
        return new LogPurchaseRequest(this, str, str2, str3).b();
    }

    public void b(String str) {
        a(-1, new String[]{str});
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("BillingService", "Billing service connected");
        f();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.w("BillingService", "Billing service disconnected");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent != null) {
            a(intent, i);
        }
    }
}
