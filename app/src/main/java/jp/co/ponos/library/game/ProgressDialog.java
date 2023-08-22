package jp.co.ponos.library.game;

class ProgressDialog extends DialogFragment {
   String a;
   // $FF: synthetic field
   final Utility b;

   ProgressDialog(Utility var1, String var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean loadURL() {
      if (this.b.progressDialog != null) {
         this.b.progressDialog.dismiss();
      }

      this.b.progressDialog = new android.app.ProgressDialog(Global.instance.context);
      this.b.progressDialog.setMessage(this.a);
      this.b.progressDialog.setProgressStyle(0);
      this.b.progressDialog.setCancelable(false);
      this.b.progressDialog.show();
      return true;
   }
}
