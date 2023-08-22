package jp.co.ponos.library.score;

import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.Utility;
import jp.co.ponos.library.game.Settings;

public class MyUtility extends Utility {
   public static void createInstance() {
      instance = new MyUtility();
   }

   public static String getAppli() {
      return Settings.getInstance().a(decrypt(md5("a"), "b+rB23dnIvnucgCR1oPbX2IU5sODvhUS1C6t3Tga/+boJbf2dDtLDjb3En8q50TG"));
   }

   protected String getAppliPage(String var1, String var2) {
      return aString.format(decrypt(md5("b"), "jbZyObXJNA2SKLFCjjy87dmRUVv1EVgf530pUPwP3m8/EWdegkI/je7qjPeagOZTea4ozeoGwV1B8gK6d2buOKJAWY4duhaerFwm+0+3+WI="), getAppli(), var1, var2, getString("lang"), Settings.getInstance().packageName, var2);
   }

   public String getID() {
      String var1 = getDeviceID();
      if (var1 == null) {
         var1 = this.getUserID();
      }

      return var1;
   }
}
