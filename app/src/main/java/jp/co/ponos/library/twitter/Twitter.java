package jp.co.ponos.library.twitter;

import jp.co.ponos.library.score.MyUtility;

public class Twitter {
   static Twitter twitter;

   public static void createInstance() {
      twitter = new Twitter();
   }

   public static Twitter getInstance() {
      return twitter;
   }

   public void tweet(String var1, String var2) {
      String var3 = "http://twitter.com/intent/tweet?text=" + MyUtility.urlEncode(var1);
      var1 = var3;
      if (var2 != null) {
         var1 = var3 + "&url=" + MyUtility.urlEncode(var2);
      }

      MyUtility.getInstance().addJSDialog(var1);
   }

   @Deprecated
   public void tweet(String var1, String var2, String var3) {
      this.tweet(var1, var2);
   }

   public boolean isEnabled() {
      return true;
   }
}
