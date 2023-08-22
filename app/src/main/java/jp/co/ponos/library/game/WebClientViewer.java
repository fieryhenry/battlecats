package jp.co.ponos.library.game;

public abstract class WebClientViewer {
   public void a() {
   }

   public void a(int var1) {
   }

   public void canGoBack(String var1) {
      if (Utility.getInstance().canGoBack()) {
         Utility.getInstance().goBack();
      } else {
         Utility.getInstance().addWebClient();
      }

   }

   public void a(aHashTable var1) {
   }

   public void b(String var1) {
   }
}
