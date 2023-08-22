package jp.co.ponos.library.game;

class BackHandler extends BackKeyController {
   // $FF: synthetic field
   final Utility utility;

   BackHandler(Utility var1) {
      this.utility = var1;
   }

   @Override
   public boolean isBackPressValid() {
      if (this.utility.webClientViewer != null && !this.utility.j) {
         this.utility.webClientViewer.canGoBack(this.utility.getURL());
      } else if (this.utility.canGoBack()) {
         this.utility.goBack();
      } else {
         this.utility.addWebClient();
      }

      return true;
   }
}
