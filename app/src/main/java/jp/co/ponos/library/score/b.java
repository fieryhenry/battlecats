package jp.co.ponos.library.score;

import jp.co.ponos.library.game.DialogFragment;

class b extends DialogFragment {
   String a;
   String b;
   String c;
   int[] d;
   int[] e;
   // $FF: synthetic field
   final a f;

   b(a var1, String var2, String var3, String var4, int[] var5, int[] var6) {
      this.f = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   // $FF: synthetic method
   static a a(b var0) {
      return var0.f;
   }

   public boolean loadURL() {
      (new c(this)).execute(new Object[]{this.a, this.b, this.c, this.d, this.e});
      return true;
   }
}
