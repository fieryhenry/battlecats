package jp.co.ponos.library.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class b implements Runnable {
   // $FF: synthetic field
   final BillingReceiver a;
   // $FF: synthetic field
   private final Context b;
   // $FF: synthetic field
   private final String c;

   b(BillingReceiver var1, Context var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void run() {
      long var1;
      try {
         var1 = s.b();
      } catch (v var6) {
         Intent var5 = new Intent("com.example.subscriptions.ACTION_VERIFICATION_FAILED");
         var5.setClass(this.b, BillingService.class);
         Bundle var3 = new Bundle();
         var3.putInt("error", var6.a());
         var3.putSerializable("throwable", var6.getCause());
         var5.putExtras(var3);
         this.b.startService(var5);
         return;
      }

      Intent var7 = new Intent("com.example.subscriptions.GET_PURCHASE_INFORMATION");
      var7.setClass(this.b, BillingService.class);
      var7.putExtra("notification_id", this.c);
      var7.putExtra("server_nonce", var1);
      this.b.startService(var7);
   }
}
