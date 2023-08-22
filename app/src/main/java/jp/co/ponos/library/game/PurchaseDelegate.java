package jp.co.ponos.library.game;

public class PurchaseDelegate {
   PurchaseHandler a;
   String b;

   public String a() {
      return this.b;
   }

   public void a(String var1, PurchaseHandler var2) {
      this.b = null;
      this.a = var2;
      (new MakePurchaseHandler(this)).execute(new String[]{var1});
   }
}
