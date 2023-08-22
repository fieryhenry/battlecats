package jp.co.ponos.library.purchase;

import android.os.Bundle;

class e extends c {
   final String[] c;
   // $FF: synthetic field
   final BillingService d;

   public e(BillingService var1, int var2, String[] var3) {
      super(var1, var2);
      this.d = var1;
      this.c = var3;
   }

   protected long d() {
      Bundle var1 = this.a("CONFIRM_NOTIFICATIONS");
      var1.putStringArray("NOTIFY_IDS", this.c);
      //var1 = BillingService.c().a(var1);
      this.a("confirmNotifications", var1);
      return var1.getLong("REQUEST_ID", i.a);
   }
}
