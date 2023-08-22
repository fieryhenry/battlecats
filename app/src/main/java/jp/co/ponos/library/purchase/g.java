package jp.co.ponos.library.purchase;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

class g extends c {
   public final String c;
   public final String d;
   public final String e;
   // $FF: synthetic field
   final BillingService f;

   public g(BillingService var1, String var2, String var3, String var4) {
      super(var1, -1);
      this.f = var1;
      this.c = var2;
      this.d = var4;
      this.e = var3;
   }

   protected void a(k var1) {
      m.a(this.f, this, var1);
   }

   protected long d() {
      Bundle var1 = this.a("REQUEST_PURCHASE");
      var1.putString("ITEM_ID", this.c);
      var1.putString("ITEM_TYPE", this.e);
      if (this.d != null) {
         var1.putString("DEVELOPER_PAYLOAD", this.d);
      }

      //Bundle var2 = BillingService.c().a(var1);
      //PendingIntent var5 = (PendingIntent)var2.getParcelable("PURCHASE_INTENT");
      long var3;
      //if (var5 == null) {
     //    Log.e("BillingService", "Error with requestPurchase");
      //   var3 = i.a;
      //} else {
       //  m.a(var5, new Intent());
         //var3 = var2.getLong("REQUEST_ID", i.a);
      //}

      return -1;
   }
}
