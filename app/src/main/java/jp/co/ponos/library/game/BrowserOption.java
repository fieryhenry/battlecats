package jp.co.ponos.library.game;

public class BrowserOption {
   int a;
   int[] b = new int[3];
   int[] c = new int[3];
   String[] d = new String[3];
   String e;
   boolean f;

   public void a(int var1, int var2, String var3) {
      this.b[this.a] = var1;
      this.c[this.a] = var2;
      this.d[this.a] = var3;
      ++this.a;
   }

   public void a(String var1) {
      this.e = var1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }
}
