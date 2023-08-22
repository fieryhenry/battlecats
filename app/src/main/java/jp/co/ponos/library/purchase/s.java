package jp.co.ponos.library.purchase;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;

import jp.co.ponos.library.game.Settings;
import jp.co.ponos.library.game.Utility;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
   private static HashMap a = new HashMap();
   private static KeyStore b = null;

   public static HttpClient a() throws v {
      KeyStore var0;
      try {
         var0 = KeyStore.getInstance(KeyStore.getDefaultType());
      } catch (KeyStoreException var9) {
         throw new v(256, var9);
      }

      try {
         var0.load((InputStream)null, (char[])null);
      } catch (NoSuchAlgorithmException var6) {
         throw new v(256, var6);
      } catch (CertificateException var7) {
         throw new v(256, var7);
      } catch (IOException var8) {
         throw new v(256, var8);
      }

      t var10;
      try {
         var10 = new t(var0);
      } catch (KeyManagementException var2) {
         throw new v(256, var2);
      } catch (UnrecoverableKeyException var3) {
         throw new v(256, var3);
      } catch (NoSuchAlgorithmException var4) {
         throw new v(256, var4);
      } catch (KeyStoreException var5) {
         throw new v(256, var5);
      }

      var10.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      Scheme var1 = new Scheme("https", var10, 443);
      DefaultHttpClient var11 = new DefaultHttpClient();
      var11.getConnectionManager().getSchemeRegistry().register(var1);
      return var11;
   }

   public static void a(String var0, String var1) throws v {
      Log.i("Security", "signedData: " + var0);
      Log.i("Security", "signature: " + var1);
      if (!TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var1)) {
         long var3;
         try {
            JSONObject var2 = new JSONObject(var0);
            var3 = var2.getLong("nonce");
         } catch (JSONException var12) {
            throw new v(257, var12);
         }

         if (!a.containsKey(var3)) {
            throw new v(258);
         } else {
            HttpContext var5 = (HttpContext)a.get(var3);
            a.remove(var3);
            HttpClient var6 = a();
            HttpConnectionParams.setConnectionTimeout(var6.getParams(), 10000);
            HttpPost var31 = new HttpPost(Settings.getInstance().getSetting(Utility.decrypt(Utility.md5("s"), "CdTw1Qm0PDW7xd5OeYD/DCe0NkeB0wcTNbgDxskn5Hcf5f0JylsjMzkAqWF3R3ut0/Tqa2Pz6Wk7UiOam1ho2w==")));
            ArrayList var7 = new ArrayList();
            var7.add(new BasicNameValuePair("signedData", var0));
            var7.add(new BasicNameValuePair("signature", var1));

            try {
               UrlEncodedFormEntity var8 = new UrlEncodedFormEntity(var7);
               var31.setEntity(var8);
            } catch (UnsupportedEncodingException var11) {
               throw new v(256, var11);
            }

            ClientProtocolException var37;
            label84: {
               IOException var36;
               label83: {
                  NoSuchAlgorithmException var10000;
                  label94: {
                     boolean var10001;
                     v var30;
                     HttpResponse var32;
                     try {
                        var32 = var6.execute(var31, var5);
                        if (var32.getStatusLine().getStatusCode() != 200) {
                           var30 = new v(514);
                           throw var30;
                        }
                     } catch (ClientProtocolException var22) {
                        var37 = var22;
                        var10001 = false;
                        break label84;
                     } catch (IOException var23) {
                        var36 = var23;
                        var10001 = false;
                        break label83;
                     }

                     StringBuilder var25;
                     byte[] var29;
                     String var33;
                     try {
                        var33 = EntityUtils.toString(var32.getEntity());
                        MessageDigest var35 = MessageDigest.getInstance("SHA-1");
                        StringBuilder var34 = new StringBuilder(String.valueOf("Ponos Genuine Material".replace(' ', '.')));
                        var35.update(var34.append(var0).append(var1).toString().getBytes("UTF-8"));
                        var29 = var35.digest();
                        var25 = new StringBuilder(var29.length * 2);
                     } catch (ClientProtocolException var19) {
                        var37 = var19;
                        var10001 = false;
                        break label84;
                     } catch (IOException var20) {
                        var36 = var20;
                        var10001 = false;
                        break label83;
                     } catch (NoSuchAlgorithmException var21) {
                        var10000 = var21;
                        var10001 = false;
                        break label94;
                     }

                     int var9 = 0;

                     while(true) {
                        if (var9 >= var29.length) {
                           if (!var25.toString().equals(var33)) {
                              var30 = new v(514);
                              throw var30;
                           }

                           return;
                        }

                        int var10 = var29[var9] & 255;

                        var25.append("0123456789abcdef".charAt(var10 >>> 4)).append("0123456789abcdef".charAt(var10 & 15));

                        ++var9;
                     }
                  }

                  NoSuchAlgorithmException var26 = var10000;
                  throw new v(256, var26);
               }

               IOException var27 = var36;
               throw new v(513, var27);
            }

            ClientProtocolException var28 = var37;
            throw new v(513, var28);
         }
      } else {
         throw new v(258);
      }
   }

   public static long b() throws v {
      BasicCookieStore basicCookieStore = new BasicCookieStore();
      BasicHttpContext basicHttpContext = new BasicHttpContext();
      basicHttpContext.setAttribute("http.cookie-store", basicCookieStore);
      HttpClient a2 = a();
      HttpConnectionParams.setConnectionTimeout(a2.getParams(), 10000);
      try {
         try {
            HttpResponse execute = a2.execute(new HttpPost(Settings.getInstance().getSetting("https://www.ponos.net/android/appli/purchase/verify_start.php")), basicHttpContext);
            try {
               if (execute.getStatusLine().getStatusCode() != 200) {
                  throw new v(514);
               }
               long longValue = Long.decode("0x" + EntityUtils.toString(execute.getEntity())).longValue();
               if (longValue != 0) {
                  a.put(Long.valueOf(longValue), basicHttpContext);
               }
               return longValue;
            } catch (IOException e) {
               throw new v(515, e);
            } catch (NumberFormatException e2) {
               throw new v(515, e2);
            } catch (ParseException e3) {
               throw new v(515, e3);
            }
         } catch (ClientProtocolException e4) {
            throw new v(513, e4);
         }
      } catch (IOException e5) {
         throw new v(513, e5);
      }
   }
}
