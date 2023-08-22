package jp.co.ponos.library.game;

class AlertCloser extends DialogFragment {
   // $FF: synthetic field
   final Utility utility;

   AlertCloser(Utility var1) {
      this.utility = var1;
   }
   @Override
   public boolean loadURL() {
      if (this.utility.progressDialog != null) {
         this.utility.progressDialog.dismiss();
      }

      return true;
   }
}
