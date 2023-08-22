package jp.co.ponos.library.game;

import android.view.View;

class WebViewClickHandler implements View.OnClickListener {
   // $FF: synthetic field
   final JSHandler a;

   WebViewClickHandler(JSHandler var1) {
      this.a = var1;
   }

   public void onClick(View var1) {
      if (JSHandler.a(this.a).webClientViewer != null) {
         JSHandler.a(this.a).webClientViewer.a(((JSButton)var1).a);
      }

   }
}
