package jp.co.ponos.library.game;

import android.content.DialogInterface;

class ButtonEventHandler2 implements DialogInterface.OnClickListener {
   // $FF: synthetic field
   final ButtonBuilder a;

   ButtonEventHandler2(ButtonBuilder var1) {
      this.a = var1;
   }

   public void onClick(DialogInterface var1, int var2) {
      this.a.d.a = 1;
   }
}
