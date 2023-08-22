package jp.co.ponos.library.game;

class AssetGetter extends DialogFragment {
   String a;
   // $FF: synthetic field
   final Utility b;

   AssetGetter(Utility var1, String var2) {
      this.b = var1;
      if (!var2.startsWith("http://") && !var2.startsWith("https://")) {
         this.a = "file:///android_asset/" + var2;
      } else {
         this.a = var2;
      }

   }

   public boolean loadURL() {
      if (this.b.webView != null) {
         this.b.webView.loadUrl(this.a);
      }

      return true;
   }
}
