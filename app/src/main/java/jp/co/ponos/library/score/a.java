package jp.co.ponos.library.score;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import jp.co.ponos.library.game.BrowserOption;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.Settings;

public class a {
   static a a;
   Score b;

   public static void a() {
      a = new a();
   }

   public static a b() {
      return a;
   }

   String a(String var1, String var2, String var3, int[] var4, int[] var5) {
      var2 = aString.format(MyUtility.decrypt(MyUtility.md5("d"), "Z5ZpvK3Fn40EugNff6sS3vWsR1+rPZRcAYhxprErheC3vD0dZbh/NVI3XH59ZZ8u"), this.e(), Settings.getInstance().packageName, var2, MyUtility.urlEncode(var3), MyUtility.getString("lang"));

      int var6;
      for(var6 = 0; var6 < var4.length; ++var6) {
         var2 = var2 + aString.format(MyUtility.decrypt(MyUtility.md5("f"), "F+pmeTD5PBeYdHYaRhI/JA=="), var6, var4[var6]);
      }

      var3 = var2;
      if (var5 != null) {
         for(var6 = 0; var6 < var5.length; ++var6) {
            var2 = var2 + aString.format(MyUtility.decrypt(MyUtility.md5("g"), "N+GNZgaGWv7cETVD5ftr7w=="), var6, var5[var6]);
         }

         var3 = var2;
      }

      return aString.format(MyUtility.decrypt(MyUtility.md5("e"), "ojL0PG0ZcSSfJGHERh1DdHzEjDK5UsCb6nnATReXNow="), MyUtility.getAppli(), var1, var3, MyUtility.urlEncode(MyUtility.encrypt(MyUtility.md5(Settings.getInstance().packageName), var3)));
   }

   public void a(Score var1) {
      this.b = var1;
   }

   public boolean a(String var1) {
      BrowserOption var2 = new BrowserOption();
      var2.a(true);
      MyUtility.getInstance().addJSDialog(aString.format(MyUtility.decrypt(MyUtility.md5("c"), "HtdNbsDG5EOqVaD7jVKuwiwORga/YgG7YexC6jLR10r4xAhxj1lcgcLn2sigOMzE4K7/c8BpUTPeLFQQ+X0cGA=="), MyUtility.getAppli(), this.e(), Settings.getInstance().packageName, var1, MyUtility.getString("lang")), var2);
      return true;
   }

   public boolean a(String var1, int var2) {
      return this.a(var1, new int[]{var2}, (int[])null);
   }

   public boolean a(String var1, int[] var2, int[] var3) {
      SharedPreferences var4 = PreferenceManager.getDefaultSharedPreferences(Global.getInstance().getContext());
      String var5 = MyUtility.decrypt(MyUtility.md5("name"), var4.getString(MyUtility.md5("name"), MyUtility.encrypt(MyUtility.md5("name"), "")));
      String var6 = var5;
      if (var5.length() > 8) {
         var6 = var5.substring(0, 8);
      }

      BrowserOption var7 = new BrowserOption();
      var7.a(true);
      MyUtility.getInstance().addJSDialog(this.a(MyUtility.decrypt(MyUtility.md5("h"), "5Ow+Q+T8Tz3MSHBmKtSU6zbwbep/Mf1mWa9gr7a99eQ="), var1, var6, var2, var3), var7);
      return true;
   }

   public void c() {
   }

   public boolean d() {
      return true;
   }

   public String e() {
      return MyUtility.getInstance().getID();
   }
}
