package jp.co.ponos.library.purchase;

import android.app.Activity;
import java.util.ArrayList;

class y extends l {
   ArrayList a = new ArrayList();

   public y(Activity var1) {
      super(var1);
   }

   public void a(int var1, Throwable var2) {
      if (w.a.d != null) {
         w.a.d.a();
      }

   }

   public void a(g var1, k var2) {
   }

   public void a(j var1, String var2, String var3, long var4, String var6, String var7) {
      if (w.a.d != null) {
         if (var1 == j.a && var7 != null) {
            if (!this.a.contains(var7) && w.a.d.a(var2)) {
               w.a.b.b(var7);
               if (var2.indexOf("android.test") == -1) {
                  this.a.add(var7);
               }
            }
         } else if (var1 == j.b) {
            w.a.d.b();
         } else {
            w.a.d.a();
         }
      }

   }

   public void a(boolean var1, String var2) {
      w.a.e = var1;
   }
}
