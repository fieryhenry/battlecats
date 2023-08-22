package jp.co.ponos.library.purchase;

public enum k {
   a,
   b,
   c,
   d,
   e,
   f,
   g;

   public static k a(int var0) {
      k[] var1 = values();
      k var2;
      if (var0 >= 0 && var0 < var1.length) {
         var2 = var1[var0];
      } else {
         var2 = g;
      }

      return var2;
   }
}
