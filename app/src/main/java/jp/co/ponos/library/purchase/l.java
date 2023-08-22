package jp.co.ponos.library.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class l {
   private static final Class[] d;
   private final Activity a;
   private Method b;
   private Object[] c = new Object[5];

   static {
      d = new Class[]{IntentSender.class, Intent.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
   }

   public l(Activity var1) {
      this.a = var1;
      this.a();
   }

   private void a() {
      try {
         this.b = this.a.getClass().getMethod("startIntentSender", d);
      } catch (SecurityException var2) {
         this.b = null;
      } catch (NoSuchMethodException var3) {
         this.b = null;
      }

   }

   public abstract void a(int var1, Throwable var2);

   void a(PendingIntent var1, Intent var2) {
      if (this.b != null) {
         try {
            this.c[0] = var1.getIntentSender();
            this.c[1] = var2;
            this.c[2] = 0;
            this.c[3] = 0;
            this.c[4] = 0;
            this.b.invoke(this.a, this.c);
         } catch (Exception var4) {
            Log.e("PurchaseObserver", "error starting activity", var4);
         }
      } else {
         try {
            var1.send(this.a, 0, var2);
         } catch (PendingIntent.CanceledException var3) {
            Log.e("PurchaseObserver", "error starting activity", var3);
         }
      }

   }

   public abstract void a(g var1, k var2);

   public abstract void a(j var1, String var2, String var3, long var4, String var6, String var7);

   public abstract void a(boolean var1, String var2);
}
