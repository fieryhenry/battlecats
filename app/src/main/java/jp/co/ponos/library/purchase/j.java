package jp.co.ponos.library.purchase;

public enum j {
   a,
   b,
   c;

   public static j a(int var0) {
      j[] var1 = values();
      j var2;
      if (var0 >= 0 && var0 < var1.length) {
         var2 = var1[var0];
      } else {
         var2 = b;
      }

      return var2;
   }
}
