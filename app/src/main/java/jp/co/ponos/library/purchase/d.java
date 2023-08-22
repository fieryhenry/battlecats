package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.util.Log;

class d extends c {
   public String c;
   // $FF: synthetic field
   final BillingService d;

   public d(BillingService var1, String var2) {
      super(var1, -1);
      this.d = var1;
      this.c = null;
      this.c = var2;
   }

   protected long d() {
      Bundle var1 = this.a("CHECK_BILLING_SUPPORTED");
      if (this.c != null) {
         var1.putString("ITEM_TYPE", this.c);
      }

      //int var2 = BillingService.c().a(var1).getInt("RESPONSE_CODE");
      //Log.i("BillingService", "CheckBillingSupported response code: " + k.a(var2));
      boolean var3;
      //if (var2 == k.a.ordinal()) {
      //   var3 = true;
      //} else {
      //   var3 = false;
      //}

      //m.a(var3, this.c);
      return i.a;
   }
}
