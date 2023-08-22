package jp.co.ponos.library.game;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebClientHandler extends WebViewClient {
   boolean a;
   // $FF: synthetic field
   final Utility utility;

   WebClientHandler(Utility var1, boolean var2) {
      this.utility = var1;
      this.a = var2;
   }
   @Override
   public void onPageFinished(WebView var1, String var2) {
      if (this.a && Utility.instance.webClientViewer != null) {
         Utility.instance.webClientViewer.b(var2);
      }

   }
   @Override
   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      var1.loadData("", "text/html", "utf-8");
   }
   @Override
   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      if (var2 != null) {
         var2.proceed();
      }

   }
   @Override
   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      boolean var3 = false;
      boolean var4;
      if (this.a && var2.indexOf(Utility.decrypt(Utility.md5("p"), "YM1eNfl4i010nIZxIVR267IBp11YGTdTa80I6EywKC8=")) == 0) {
         var1.stopLoading();
         var4 = var3;
         if (Utility.instance.webClientViewer != null) {
            aHashTable var7 = new aHashTable();
            String[] var5 = var2.substring(Utility.decrypt(Utility.md5("p"), "YM1eNfl4i010nIZxIVR267IBp11YGTdTa80I6EywKC8=").length()).split("&");

            for(int var6 = 0; var6 < var5.length; ++var6) {
               String[] var8 = var5[var6].split("=");
               if (var8.length >= 2) {
                  var7.put(var8[0], var8[1]);
               }
            }

            Utility.instance.webClientViewer.a(var7);
            var4 = var3;
         }
      } else {
         if (!this.a || !var2.startsWith(Utility.decrypt(Utility.md5("j"), "n1YWtEyyCucWHkS9zWji/YPWxT5CpfXA7f5g8MlDmts=")) && !var2.startsWith(Utility.decrypt(Utility.md5("k"), "Hcoe0xz75+nMtUQDEtbp9LUKTgAiKi72O37lwU5pG7U=")) && !var2.startsWith(Utility.decrypt(Utility.md5("l"), "IwadsMddagoWqNh5PFRTqJLpXOr3Im1AONvor8XK7FI=")) && !var2.startsWith(Utility.decrypt(Utility.md5("m"), "/IfjXRARE9nwKQVYuWTXh/GB9kmn5jI3u3JIS4/x6M4=")) && !var2.startsWith(Utility.decrypt(Utility.md5("n"), "wpH8/+yzkbQWOCGl9xLdGKmU2bCTVeSqUOhpQPOKUvo=")) && !var2.startsWith(Utility.decrypt(Utility.md5("o"), "9sFIVYgf22gbbuH/13FxPA=="))) {
            var1.getSettings().setJavaScriptEnabled(false);
         } else {
            var1.getSettings().setJavaScriptEnabled(true);
         }

         var4 = super.shouldOverrideUrlLoading(var1, var2);
      }

      return var4;
   }
}
