package jp.co.ponos.library.game;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class MakePurchaseHandler extends AsyncTask {
   // $FF: synthetic field
   final PurchaseDelegate a;

   MakePurchaseHandler(PurchaseDelegate var1) {
      this.a = var1;
   }

   protected Void a(String... var1) {
      label33: {
         boolean var10001;
         HttpURLConnection var3;
         byte[] var4;
         ByteArrayOutputStream var11;
         InputStream var12;
         try {
            URL var2 = new URL(var1[0]);
            var3 = (HttpURLConnection)var2.openConnection();
            var3.setConnectTimeout(10000);
            var3.setReadTimeout(10000);
            var3.connect();
            var12 = var3.getInputStream();
            var11 = new ByteArrayOutputStream();
            var4 = new byte[256];
         } catch (Exception var10) {
            var10001 = false;
            break label33;
         }

         while(true) {
            int var5;
            try {
               var5 = var12.read(var4, 0, var4.length);
            } catch (Exception var8) {
               var10001 = false;
               break;
            }

            if (var5 == -1) {
               try {
                  PurchaseDelegate var13 = this.a;
                  String var6 = new String(var11.toByteArray());
                  var13.b = var6;
                  var11.close();
                  var12.close();
                  var3.disconnect();
                  this.a.a.a(this.a);
                  return null;
               } catch (Exception var7) {
                  var10001 = false;
                  break;
               }
            }

            try {
               var11.write(var4, 0, var5);
            } catch (Exception var9) {
               var10001 = false;
               break;
            }
         }
      }

      this.a.a.b(this.a);
      return null;
   }

   // $FF: synthetic method
   protected Object doInBackground(Object... var1) {
      return this.a((String[])var1);
   }
}
