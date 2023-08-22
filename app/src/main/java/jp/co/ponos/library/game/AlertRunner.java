package jp.co.ponos.library.game;

class AlertRunner extends DialogFragment {
   String a;
   // $FF: synthetic field
   final Utility utility;

   AlertRunner(Utility var1, String var2) {
      this.utility = var1;
      this.a = var2;
   }

   // $FF: synthetic method
   static Utility getUtility(AlertRunner var0) {
      return var0.utility;
   }

   public boolean loadURL() {
      (new AlertRequestHandler(this)).execute(new String[]{this.a});
      return true;
   }
}
