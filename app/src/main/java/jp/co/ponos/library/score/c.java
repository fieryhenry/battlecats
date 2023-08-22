package jp.co.ponos.library.score;

import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class c extends AsyncTask {
   // $FF: synthetic field
   final b a;

   c(b var1) {
      this.a = var1;
   }

   protected Void a(Object... var1) {
      byte var2 = 1;
      Score var3;
      String var4;
      int[] var6;
      if (var1[3] != null) {
         b.a(this.a).b.a((String)var1[1], ((int[])var1[3])[0], 1);
         var3 = b.a(this.a).b;
         var4 = (String)var1[1];
         int[] var5 = (int[])var1[3];
         if (var1[4] != null) {
            var6 = (int[])var1[4];
         } else {
            var6 = null;
         }

         var3.a(var4, var5, var6, 1);
      } else {
         b.a(this.a).b.a((String)var1[1], 0, 2);
         b.a(this.a).b.a((String)var1[1], (int[])null, (int[])null, 2);
      }

      boolean var7;
      label54: {
         label53: {
            InputStream var14;
            HttpURLConnection var16;
            boolean var10001;
            label52: {
               label51: {
                  try {
                     String var13 = b.a(this.a).a((String)var1[0], (String)var1[1], (String)var1[2], (int[])var1[3], (int[])var1[4]);
                     URL var15 = new URL(var13);
                     var16 = (HttpURLConnection)var15.openConnection();
                     var16.setConnectTimeout(10000);
                     var16.setReadTimeout(10000);
                     var16.connect();
                     var14 = var16.getInputStream();
                     if (var14.read() == 79 && var14.read() == 75) {
                        break label51;
                     }
                  } catch (Exception var11) {
                     var10001 = false;
                     break label53;
                  }

                  var7 = true;
                  break label52;
               }

               var7 = false;
            }

            try {
               var14.close();
               var16.disconnect();
               break label54;
            } catch (Exception var10) {
               var10001 = false;
            }
         }

         var7 = true;
      }

      var3 = b.a(this.a).b;
      String var17 = (String)var1[1];
      int var8 = ((int[])var1[3])[0];
      byte var9;
      if (!var7) {
         var9 = 1;
      } else {
         var9 = 2;
      }

      var3.b(var17, var8, var9);
      var3 = b.a(this.a).b;
      var4 = (String)var1[1];
      var6 = (int[])var1[3];
      int[] var12;
      if (var1[4] != null) {
         var12 = (int[])var1[4];
      } else {
         var12 = null;
      }

      byte var18;
      if (!var7) {
         var18 = var2;
      } else {
         var18 = 2;
      }

      var3.b(var4, var6, var12, var18);
      return null;
   }

   // $FF: synthetic method
   protected Object doInBackground(Object... var1) {
      return this.a((Object[])var1);
   }
}
