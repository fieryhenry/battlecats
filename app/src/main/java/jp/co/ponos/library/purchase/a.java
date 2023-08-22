package jp.co.ponos.library.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class a implements Runnable {
   // $FF: synthetic field
   final BillingReceiver a;
   // $FF: synthetic field
   private final String b;
   // $FF: synthetic field
   private final String c;
   // $FF: synthetic field
   private final Context d;

   a(BillingReceiver var1, String var2, String var3, Context var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void run() {
      try {
         s.a(this.b, this.c);
      } catch (v var4) {
         Intent var2 = new Intent("com.example.subscriptions.ACTION_VERIFICATION_FAILED");
         var2.setClass(this.d, BillingService.class);
         Bundle var3 = new Bundle();
         var3.putInt("error", var4.a());
         var3.putSerializable("throwable", var4.getCause());
         var2.putExtras(var3);
         this.d.startService(var2);
         return;
      }

      Intent var1 = new Intent("com.android.vending.billing.PURCHASE_STATE_CHANGED");
      var1.setClass(this.d, BillingService.class);
      var1.putExtra("inapp_signed_data", this.b);
      var1.putExtra("inapp_signature", this.c);
      this.d.startService(var1);
   }
}
