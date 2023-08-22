package jp.co.ponos.library.purchase;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

abstract class c {
   protected long a;
   // $FF: synthetic field
   final BillingService b;
   private final int c;

   public c(BillingService var1, int var2) {
      this.b = var1;
      this.c = var2;
   }

   private void a(v var1) {
      Log.w("BillingService", "Could not reach the verification service or verification failed");
      m.a(var1.a(), var1.getCause());
   }

   public int a() {
      return this.c;
   }

   protected Bundle a(String var1) {
      Bundle var2 = new Bundle();
      var2.putString("BILLING_REQUEST", var1);
      var2.putInt("API_VERSION", 2);
      var2.putString("PACKAGE_NAME", this.b.getPackageName());
      return var2;
   }

   protected void a(RemoteException var1) {
      Log.w("BillingService", "remote billing service crashed");
      //BillingService.a((com.a.a.a.a)null);
   }

   protected void a(String var1, Bundle var2) {
      k var3 = k.a(var2.getInt("RESPONSE_CODE"));
      Log.e("BillingService", var1 + " received " + var3.toString());
   }

   protected void a(k var1) {
   }

   public boolean b() {
      boolean var1 = true;
      if (!this.c()) {
         if (BillingService.a(this.b)) {
            BillingService.b().add(this);
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   public boolean c() {
      boolean var1 = true;
      Log.d("BillingService", this.getClass().getSimpleName());
      boolean var3;
      //if (BillingService.c() != null) {
      //   label51: {
      //      label36: {
      //         RemoteException var10;
      //         label52: {
      //            v var10000;
      //            label41: {
      //               boolean var10001;
      //               try {
      //                  this.a = this.d();
      //                  StringBuilder var2 = new StringBuilder("request id: ");
      //                  Log.d("BillingService", var2.append(this.a).toString());
      //               } catch (RemoteException var6) {
      //                  var10 = var6;
      //                  var10001 = false;
      //                  break label52;
      //               } catch (v var7) {
      //                  var10000 = var7;
      //                  var10001 = false;
      //                  break label41;
      //               }
//
      //               var3 = var1;
//
      //               try {
      //                  if (this.a < 0L) {
      //                     return var3;
      //                  }
//
      //                  BillingService.d().put(this.a, this);
      //                  break label36;
      //               } catch (RemoteException var4) {
      //                  var10 = var4;
      //                  var10001 = false;
      //                  break label52;
      //               } catch (v var5) {
      //                  var10000 = var5;
      //                  var10001 = false;
      //               }
      //            }
//
      //            v var8 = var10000;
      //            this.a(var8);
      //            var3 = var1;
      //            return var3;
      //         }
//
      //         RemoteException var9 = var10;
      //         this.a(var9);
      //         break label51;
      //      }
//
      //      var3 = var1;
      //      return var3;
      //   }
      //}

      var3 = false;
      return var3;
   }

   protected abstract long d();
}
