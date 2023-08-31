package jp.co.ponos.library.game;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public abstract class Utility {
   protected static Utility instance;
   WebClientViewer webClientViewer;
   String c;
   boolean d;
   WebView webView;
   FrameLayout frameLayout;
   String g;
   AlertAppli alertAppli;
   JSInterfaceBase jsInterface;
   boolean j;
   android.app.ProgressDialog progressDialog;

   public static int transCoordWindowToGLViewX(int var0) {
      return Global.instance.width * (var0 - Global.instance.viewportX) / Global.instance.viewportWidth;
   }

   public static String getString(String var0) {
      String var1;
      try {
         var1 = Global.instance.context.getString(AssetLoader.assetLoader.getString(var0.replace('.', '_')));
      } catch (Exception var2) {
         return var0;
      }

      var0 = var1;
      return var0;
   }

   public static String encrypt(String var0, String var1) {
      try {
         SecretKeySpec var2 = new SecretKeySpec(var0.getBytes(), "AES");
         Cipher var3 = Cipher.getInstance("AES");
         var3.init(1, var2);
         var0 = new String(Base64.encode(var3.doFinal(var1.getBytes()), 2));
      } catch (Exception var4) {
         var0 = null;
      }

      return var0;
   }

   public static String md5(byte[] var0, int var1) {
      byte var2 = 0;

      String var10;
      label43: {
         boolean var10001;
         byte[] var4;
         StringBuffer var9;
         try {
            MessageDigest var3 = MessageDigest.getInstance("MD5");
            var3.update(var0, 0, var1);
            var4 = var3.digest();
            var9 = new StringBuffer();
         } catch (Exception var8) {
            var10001 = false;
            break label43;
         }

         var1 = var2;

         while(true) {
            try {
               if (var1 >= var4.length) {
                  var10 = var9.toString();
                  return var10;
               }
            } catch (Exception var7) {
               var10001 = false;
               break;
            }

            if ((var4[var1] & 255) < 16) {
               try {
                  StringBuilder var11 = new StringBuilder("0");
                  var9.append(var11.append(Integer.toHexString(var4[var1] & 255)).toString());
               } catch (Exception var6) {
                  var10001 = false;
                  break;
               }
            } else {
               try {
                  var9.append(Integer.toHexString(var4[var1] & 255));
               } catch (Exception var5) {
                  var10001 = false;
                  break;
               }
            }

            ++var1;
         }
      }

      var10 = null;
      return var10;
   }

   public static Utility getInstance() {
      return instance;
   }

   public static int transCoordWindowToGLViewY(int var0) {
      return Global.instance.height * (var0 - Global.instance.viewportY) / Global.instance.viewportHeight;
   }

   public static String urlEncode(String var0) {
      return URLEncoder.encode(var0);
   }

   public static String decrypt(String var0, String var1) {
      try {
         SecretKeySpec var2 = new SecretKeySpec(var0.getBytes(), "AES");
         Cipher var3 = Cipher.getInstance("AES");
         var3.init(2, var2);
         var0 = new String(var3.doFinal(Base64.decode(var1, 2)));
      } catch (Exception var4) {
         var0 = null;
      }

      return var0;
   }

   @Deprecated
   public static boolean shouldOffsetY() {
      return false;
   }

   public static String md5(String var0) {
      label40: {
         boolean var10001;
         StringBuffer var2;
         byte[] var9;
         try {
            MessageDigest var1 = MessageDigest.getInstance("MD5");
            var1.update(var0.getBytes());
            var9 = var1.digest();
            var2 = new StringBuffer();
         } catch (Exception var7) {
            var10001 = false;
            break label40;
         }

         int var3 = 0;

         while(true) {
            try {
               if (var3 >= var9.length) {
                  var0 = var2.toString();
                  return var0;
               }
            } catch (Exception var6) {
               var10001 = false;
               break;
            }

            if ((var9[var3] & 255) < 16) {
               try {
                  StringBuilder var8 = new StringBuilder("0");
                  var2.append(var8.append(Integer.toHexString(var9[var3] & 255)).toString());
               } catch (Exception var5) {
                  var10001 = false;
                  break;
               }
            } else {
               try {
                  var2.append(Integer.toHexString(var9[var3] & 255));
               } catch (Exception var4) {
                  var10001 = false;
                  break;
               }
            }

            ++var3;
         }
      }

      var0 = null;
      return var0;
   }

   public static boolean isConnected() {
      ConnectivityManager var0 = (ConnectivityManager) Global.instance.context.getSystemService(Context.CONNECTIVITY_SERVICE);
      boolean var1;
      if (var0.getActiveNetworkInfo() != null) {
         var1 = var0.getActiveNetworkInfo().isConnected();
      } else {
         var1 = false;
      }

      return var1;
   }

   public static String getRandomUUID() {
      return UUID.randomUUID().toString();
   }

   @SuppressLint("MissingPermission")
   public static String getDeviceID() {
      return ((TelephonyManager) Global.getInstance().getContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
   }

   public static double getTimeStamp() {
      return (double)System.currentTimeMillis() / 1000.0;
   }

   public void a(String var1, BrowserOption var2) {
      JSHandler var3 = new JSHandler(this);
      var3.b(var1, true, var2);
      Global.instance.dialogs.add(var3);
   }

   public void addAlertAppliPage(String var1, AlertAppli var2) {
      this.alertAppli = var2;
      this.alertAppli.a = 0;
      Global.instance.dialogs.add(new AlertRunner(this, this.getAppliPage(Settings.getInstance().packageName, var1)));
   }

   public void addButtonAppli(String str, String[] strArr, int i, AlertAppli alertAppli) {
      Global.instance.dialogs.add(new ButtonBuilder(this, str, strArr, i, alertAppli));
   }


   public void setWebClientViewer(WebClientViewer var1) {
      this.webClientViewer = var1;
   }

   public void setJSInterface(JSInterfaceBase var1) {
      this.jsInterface = var1;
   }

   public void addJSDialog(String var1, BrowserOption var2) {
      JSHandler var3 = new JSHandler(this);
      var3.a(var1, true, var2);
      Global.instance.dialogs.add(var3);
   }

   protected abstract String getAppliPage(String var1, String var2);

   public void displayURL(String var1) {
      Global.instance.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
   }

   public String getUserID() {
      if (this.c == null) {
         SharedPreferences var1 = PreferenceManager.getDefaultSharedPreferences(Global.instance.context);
         this.c = decrypt(md5("uuid"), var1.getString(md5("uuid"), encrypt(md5("uuid"), (String)null)));
         if (this.c == null) {
            this.c = getRandomUUID();
            SharedPreferences.Editor var2 = var1.edit();
            var2.putString(md5("uuid"), encrypt(md5("uuid"), this.c));
            var2.commit();
         }
      }

      return this.c;
   }

   public void addJSDialog(String var1) {
      JSHandler var2 = new JSHandler(this);
      var2.a(var1, false);
      Global.instance.dialogs.add(var2);
   }

   public void addAssetGetter(String var1) {
      Global.instance.dialogs.add(new AssetGetter(this, var1));
   }

   public abstract String getID();

   public String runFunction(String var1) {
      if (this.webView != null) {
         this.webView.loadUrl("javascript:" + var1);
      }

      return null;
   }

   public void addButton(String var1) {
      Global.instance.dialogs.add(new ButtonBuilder(this, var1));
   }

   public void addProgressDialog(String var1) {
      this.addAlertCloser();
      Global.instance.dialogs.add(new ProgressDialog(this, var1));
   }

   public boolean i() {
      return this.d;
   }

   public void goBack() {
      if (this.webView != null) {
         this.webView.goBack();
      }

   }

   public void editClipboard(String var1) {
      if (VERSION.SDK_INT >= 11) {
         this.setClipboardNew(var1);
      } else {
         this.setClipboardOld(var1);
      }

   }

   public void addWebClient() {
      Global.instance.dialogs.add(new WebClient(this));
   }

   void setClipboardNew(String var1) {
      if (VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
         ClipboardManager var2 = (ClipboardManager) Global.instance.context.getSystemService(Context.CLIPBOARD_SERVICE);
         ClipData.Item var3 = new ClipData.Item(var1);
            var2.setPrimaryClip(new ClipData("data", new String[]{"text/plain"}, var3));
      }
   }

   void setClipboardOld(String var1) {
      ((android.text.ClipboardManager) Global.instance.context.getSystemService(Context.CLIPBOARD_SERVICE)).setText(var1);
   }

   public boolean canGoBack() {
      boolean var1;
      if (this.webView != null) {
         var1 = this.webView.canGoBack();
      } else {
         var1 = false;
      }

      return var1;
   }

   public String getURL() {
      String var1;
      if (this.webView != null) {
         var1 = this.webView.getUrl();
      } else {
         var1 = null;
      }

      return var1;
   }

   public void n() {
      Global.instance.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.g)));
   }

   public void addJSDialog() {
      this.addJSDialog(this.g);
   }

   public void addProgressDialog() {
      this.addAlertCloser();
      Global.instance.dialogs.add(new ProgressDialog(this, ""));
   }

   public void addAlertCloser() {
      Global.instance.dialogs.add(new AlertCloser(this));
   }
}
