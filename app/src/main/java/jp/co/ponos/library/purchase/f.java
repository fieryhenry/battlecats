package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.os.RemoteException;

class f extends c {
   long c;
   final String[] d;
   // $FF: synthetic field
   final BillingService e;

   public f(BillingService var1, int var2, String[] var3, long var4) {
      super(var1, var2);
      this.e = var1;
      this.c = var4;
      this.d = var3;
   }

   protected void a(RemoteException var1) {
      super.a(var1);
   }

   protected long d() {
      Bundle var1 = this.a("GET_PURCHASE_INFORMATION");
      var1.putLong("NONCE", this.c);
      var1.putStringArray("NOTIFY_IDS", this.d);
      //var1 = BillingService.c().a(var1);
      this.a("getPurchaseInformation", var1);
      return var1.getLong("REQUEST_ID", i.a);
   }
}
