package jp.co.ponos.library.purchase;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class m {
   private static l a;
   private static LinkedList b = new LinkedList();

   public static void a(int var0, Throwable var1) {
      if (a != null) {
         a.a(var0, var1);
      } else {
         b.add(new r(var0, var1));
      }

   }

   public static void a(PendingIntent var0, Intent var1) {
      if (a == null) {
         Log.d("ResponseHandler", "UI is not running");
      } else {
         a.a(var0, var1);
      }

   }

   public static void a(Context var0, g var1, k var2) {
      if (a != null) {
         a.a(var1, var2);
      } else {
         b.add(new q(var1, var2));
      }

   }

   public static void a(Context var0, j var1, String var2, String var3, long var4, String var6, String var7) {
      if (a != null) {
         a.a(var1, var2, var3, var4, var6, var7);
      } else {
         b.add(new o(var1, var2, var3, var4, var6, var7));
      }

   }

   public static void a(l var0) throws Throwable {
      synchronized(m.class){}

      label221: {
         Throwable var10000;
         label225: {
            boolean var10001;
            try {
               a = var0;
               var0 = a;
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               break label225;
            }

            if (var0 == null) {
               break label221;
            }

            Iterator var21;
            try {
               if (b.isEmpty()) {
                  break label221;
               }

               var21 = b.iterator();
            } catch (Throwable var19) {
               var10000 = var19;
               var10001 = false;
               break label225;
            }

            while(true) {
               try {
                  if (!var21.hasNext()) {
                     b.clear();
                     break label221;
                  }
               } catch (Throwable var18) {
                  var10000 = var18;
                  var10001 = false;
                  break;
               }

               try {
                  ((p)var21.next()).a(a);
               } catch (Throwable var17) {
                  var10000 = var17;
                  var10001 = false;
                  break;
               }
            }
         }

         Throwable var22 = var10000;
         throw var22;
      }

   }

   public static void a(boolean var0, String var1) {
      if (a != null) {
         a.a(var0, var1);
      } else {
         b.add(new n(var0, var1));
      }

   }

   public static void b(l var0) {
      synchronized(m.class){}

      try {
         a = null;
      } finally {
         ;
      }

   }
}
