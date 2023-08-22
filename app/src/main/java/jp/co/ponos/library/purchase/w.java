package jp.co.ponos.library.purchase;

import android.app.Activity;
import android.content.Context;

import jp.co.ponos.library.game.Global;

public class w {
   static w a;
   BillingService b;
   y c;
   PurchaseDelegate d;
   boolean e;

   public static void a() {
      a = new w();
   }

   public static w b() {
      return a;
   }

   public void a(String var1) {
      this.b.a(var1, "inapp", (String)null);
   }

   public void a(PurchaseDelegate var1) {
      this.d = var1;
   }

   public void c() {
      this.b = new BillingService();
      this.b.a((Context)((Activity) Global.getInstance().getContext()));
      this.c = new y((Activity) Global.getInstance().getContext());
      this.d();
      this.b.a("inapp");
   }

   public void d() {
      try {
         m.a(this.c);
      } catch (Throwable ex) {
         throw new RuntimeException(ex);
      }
   }

   public void e() {
      m.b(this.c);
   }

   public void f() {
      this.b.a();
   }

   public boolean g() {
      return this.e;
   }
}
