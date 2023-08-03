package jp.co.ponos.library.purchase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class BillingReceiver extends BroadcastReceiver {
    private void a(Context context, long j, int i) {
        Intent intent = new Intent("com.android.vending.billing.RESPONSE_CODE");
        intent.setClass(context, BillingService.class);
        intent.putExtra("request_id", j);
        intent.putExtra("response_code", i);
        context.startService(intent);
    }

    private void a(Context context, String str) {
        new Thread(new SubscriptionInfo(this, context, str)).start();
    }

    private void a(Context context, String str, String str2) {
        new Thread(new BillingStateChanged(this, str, str2, context)).start();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(action)) {
            a(context, intent.getStringExtra("inapp_signed_data"), intent.getStringExtra("inapp_signature"));
        } else if ("com.android.vending.billing.IN_APP_NOTIFY".equals(action)) {
            String stringExtra = intent.getStringExtra("notification_id");
            Log.i("BillingReceiver", "notifyId: " + stringExtra);
            a(context, stringExtra);
        } else if ("com.android.vending.billing.RESPONSE_CODE".equals(action)) {
            a(context, intent.getLongExtra("request_id", -1L), intent.getIntExtra("response_code", BillingState.RESULT_ERROR.ordinal()));
        } else {
            Log.w("BillingReceiver", "unexpected action: " + action);
        }
    }
}
