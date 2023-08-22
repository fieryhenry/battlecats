package jp.co.ponos.library.purchase;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BillingService extends Service implements ServiceConnection {
   //private static com.a.a.a.a a;
   private static LinkedList b = new LinkedList();
   private static HashMap c = new HashMap();

   private void a(int var1, String var2, String var3) {
      ArrayList var19 = new ArrayList();

      JSONArray var5;
      JSONException var10000;
      boolean var10001;
      JSONException var18;
      label87: {
         label76: {
            try {
               JSONObject var4 = new JSONObject(var2);
               var5 = var4.optJSONArray("orders");
            } catch (JSONException var17) {
               var10000 = var17;
               var10001 = false;
               break label76;
            }

            if (var5 == null) {
               var1 = 0;
               break label87;
            }

            var1 = var5.length();
            break label87;
         }

         var18 = var10000;
         m.a(257, var18);
         return;
      }

      for(int var6 = 0; var6 < var1; ++var6) {
         label78: {
            JSONObject var7;
            String var8;
            long var9;
            String var11;
            j var22;
            try {
               var7 = var5.getJSONObject(var6);
               var22 = j.a(var7.getInt("purchaseState"));
               var8 = var7.getString("productId");
               var9 = var7.getLong("purchaseTime");
               var11 = var7.optString("orderId", "");
            } catch (JSONException var15) {
               var10000 = var15;
               var10001 = false;
               break label78;
            }

            var2 = null;

            try {
               if (var7.has("notificationId")) {
                  var2 = var7.getString("notificationId");
               }
            } catch (JSONException var14) {
               var10000 = var14;
               var10001 = false;
               break label78;
            }

            String var23 = var7.optString("developerPayload", (String)null);
            h var12 = new h(var22, var2, var8, var11, var9, var23);
            var19.add(var12);
            continue;
         }

         var18 = var10000;
         m.a(257, var18);
         return;
      }

      Iterator var21 = var19.iterator();

      while(var21.hasNext()) {
         h var20 = (h)var21.next();
         m.a(this, var20.a, var20.c, var20.d, var20.e, var20.f, var20.b);
      }

   }

   private void a(long var1, k var3) {
      c var4 = (c)c.get(var1);
      if (var4 != null) {
         Log.d("BillingService", var4.getClass().getSimpleName() + ": " + var3);
         var4.a(var3);
      }

      c.remove(var1);
   }

   // $FF: synthetic method
   //static void a(com.a.a.a.a var0) {
      //a = var0;
   //}

   private boolean a(int var1, String[] var2) {
      return (new e(this, var1, var2)).b();
   }

   private boolean a(int var1, String[] var2, long var3) {
      return (new f(this, var1, var2, var3)).b();
   }

   // $FF: synthetic method
   static boolean a(BillingService var0) {
      return var0.e();
   }

   // $FF: synthetic method
   static LinkedList b() {
      return b;
   }

   // $FF: synthetic method
   //static com.a.a.a.a c() {
      //return a;
   //}

   // $FF: synthetic method
   static HashMap d() {
      return c;
   }

   private boolean e() {
      boolean var1 = true;

      try {
         Log.i("BillingService", "binding to Market billing service");
         Intent var2 = new Intent("com.android.vending.billing.MarketBillingService.BIND");
         var2.setPackage("com.android.vending");
         if (this.bindService(var2, this, Context.BIND_AUTO_CREATE)) {
            return var1;
         }

         Log.e("BillingService", "Could not bind to service.");
      } catch (SecurityException var3) {
         Log.e("BillingService", "Security exception: " + var3);
      }

      var1 = false;
      return var1;
   }

   private void f() {
      int var1 = -1;

      while(true) {
         c var2 = (c)b.peek();
         if (var2 == null) {
            if (var1 >= 0) {
               Log.i("BillingService", "stopping service, startId: " + var1);
               this.stopSelf(var1);
            }
            break;
         }

         if (!var2.c()) {
            this.e();
            break;
         }

         b.remove();
         if (var1 < var2.a()) {
            var1 = var2.a();
         }
      }

   }

   public void a() {
      try {
         this.unbindService(this);
      } catch (IllegalArgumentException var2) {
      }

   }

   public void a(Context var1) {
      this.attachBaseContext(var1);
   }

   public void a(Intent var1, int var2) {
      String var3 = var1.getAction();
      Log.i("BillingService", "handleCommand() action: " + var3);
      if ("com.example.subscriptions.CONFIRM_NOTIFICATION".equals(var3)) {
         this.a(var2, var1.getStringArrayExtra("notification_id"));
      } else if ("com.example.subscriptions.GET_PURCHASE_INFORMATION".equals(var3)) {
         var3 = var1.getStringExtra("notification_id");
         long var4 = var1.getLongExtra("server_nonce", -1L);
         if (var4 == -1L) {
            Log.e("BillingService", "nonce is missing");
            m.a(258, (Throwable)null);
         } else {
            this.a(var2, new String[]{var3}, var4);
         }
      } else if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(var3)) {
         this.a(var2, var1.getStringExtra("inapp_signed_data"), var1.getStringExtra("inapp_signature"));
      } else if ("com.android.vending.billing.RESPONSE_CODE".equals(var3)) {
         this.a(var1.getLongExtra("request_id", -1L), k.a(var1.getIntExtra("response_code", k.g.ordinal())));
      } else if ("com.example.subscriptions.ACTION_VERIFICATION_FAILED".equals(var3)) {
         Bundle var6 = var1.getExtras();
         m.a(var6.getInt("error", 0), (Throwable)var6.getSerializable("throwable"));
      }

   }

   public boolean a(String var1) {
      return (new d(this, var1)).b();
   }

   public boolean a(String var1, String var2, String var3) {
      return (new g(this, var1, var2, var3)).b();
   }

   public void b(String var1) {
      this.a(-1, new String[]{var1});
   }

   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      Log.d("BillingService", "Billing service connected");
      //a = com.a.a.a.b.a(var2);
      this.f();
   }

   public void onServiceDisconnected(ComponentName var1) {
      Log.w("BillingService", "Billing service disconnected");
      //a = null;
   }

   public void onStart(Intent var1, int var2) {
      if (var1 != null) {
         this.a(var1, var2);
      }

   }
}
