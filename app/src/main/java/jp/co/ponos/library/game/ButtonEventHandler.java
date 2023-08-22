package jp.co.ponos.library.game;

import android.content.DialogInterface;

class ButtonEventHandler implements DialogInterface.OnClickListener {
   // $FF: synthetic field
   final ButtonBuilder buttonBuilder;

   ButtonEventHandler(ButtonBuilder var1) {
      this.buttonBuilder = var1;
   }

   @Override
   public void onClick(DialogInterface var1, int var2) {
      this.buttonBuilder.d.a = 0;
   }
}
