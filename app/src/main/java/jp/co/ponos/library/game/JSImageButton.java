package jp.co.ponos.library.game;

import android.content.Context;
import android.widget.ImageButton;

class JSImageButton extends ImageButton {
   int a;
   // $FF: synthetic field
   final JSHandler b;

   public JSImageButton(JSHandler var1, Context var2, int var3) {
      super(var2);
      this.b = var1;
      this.a = var3;
   }
}
