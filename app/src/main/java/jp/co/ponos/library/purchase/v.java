package jp.co.ponos.library.purchase;

public class v extends Exception {
   private int a;

   public v(int var1) {
      this.a = var1;
   }

   public v(int var1, Throwable var2) {
      super(var2);
      this.a = var1;
   }

   int a() {
      return this.a;
   }
}
