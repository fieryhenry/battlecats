package jp.co.ponos.library.game;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

class WebClient extends DialogFragment {
   // $FF: synthetic field
   final Utility a;

   WebClient(Utility var1) {
      this.a = var1;
   }

   public boolean loadURL() {
      if (this.a.webView != null) {
         this.a.webView.stopLoading();
         this.a.webView.setWebChromeClient((WebChromeClient)null);
         this.a.webView.setWebViewClient((WebViewClient)null);
         this.a.webView.destroy();
         this.a.webView = null;
         Global.instance.frameLayout.removeView(this.a.frameLayout);
         Global.instance.setBackKeyController2((BackKeyController)null);
         ((Activity) Global.instance.getContext()).getWindow().addFlags(1024);
         if (this.a.webClientViewer != null) {
            this.a.webClientViewer.a();
         }

         this.a.d = false;
      }

      return true;
   }
}
