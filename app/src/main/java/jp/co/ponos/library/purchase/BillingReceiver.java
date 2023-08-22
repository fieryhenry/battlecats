package jp.co.ponos.library.purchase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BillingReceiver extends BroadcastReceiver {
   private void a(Context var1, long var2, int var4) {
      Intent var5 = new Intent("com.android.vending.billing.RESPONSE_CODE");
      var5.setClass(var1, BillingService.class);
      var5.putExtra("request_id", var2);
      var5.putExtra("response_code", var4);
      var1.startService(var5);
   }

   private void a(Context var1, String var2) {
      (new Thread(new b(this, var1, var2))).start();
   }

   private void a(Context var1, String var2, String var3) {
      (new Thread(new a(this, var2, var3, var1))).start();
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(var3)) {
         this.a(var1, var2.getStringExtra("inapp_signed_data"), var2.getStringExtra("inapp_signature"));
      } else if ("com.android.vending.billing.IN_APP_NOTIFY".equals(var3)) {
         String var4 = var2.getStringExtra("notification_id");
         Log.i("BillingReceiver", "notifyId: " + var4);
         this.a(var1, var4);
      } else if ("com.android.vending.billing.RESPONSE_CODE".equals(var3)) {
         this.a(var1, var2.getLongExtra("request_id", -1L), var2.getIntExtra("response_code", k.g.ordinal()));
      } else {
         Log.w("BillingReceiver", "unexpected action: " + var3);
      }

   }
}
