package jp.co.ponos.library.game;

import android.content.Context;
import android.widget.Button;

class JSButton extends Button {
   int a;
   // $FF: synthetic field
   final JSHandler b;

   public JSButton(JSHandler var1, Context var2, int var3) {
      super(var2);
      this.b = var1;
      this.a = var3;
   }
}
