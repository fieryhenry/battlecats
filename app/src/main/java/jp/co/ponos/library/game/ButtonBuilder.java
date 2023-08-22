package jp.co.ponos.library.game;

import android.app.AlertDialog;
import android.content.DialogInterface;

class ButtonBuilder extends DialogFragment {
   String a;
   String[] b;
   int c;
   AlertAppli d;
   // $FF: synthetic field
   final Utility e;

   ButtonBuilder(Utility var1, String var2) {
      this.e = var1;
      this.a = var2;
      this.b = null;
   }

   public boolean loadURL() {
      return false;
   }

   public AlertDialog.Builder b() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(Global.instance.context);
      if (this.b == null) {
         var1.setPositiveButton("OK", (DialogInterface.OnClickListener)null);
      } else {
         var1.setPositiveButton(this.b[0], new ButtonEventHandler(this));
         if (this.c >= 2) {
            var1.setNeutralButton(this.b[1], new ButtonEventHandler2(this));
         }

         if (this.c >= 3) {
            var1.setNegativeButton(this.b[2], new ButtonEventHandler3(this));
         }
      }

      var1.setMessage(this.a);
      var1.setCancelable(false);
      return var1;
   }
}
