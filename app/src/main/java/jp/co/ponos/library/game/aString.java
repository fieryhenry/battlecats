package jp.co.ponos.library.game;

import java.util.Locale;

public class aString {
   public static int parseInt(String var0) {
      return Integer.parseInt(var0);
   }

   public static String format(String var0, Object... var1) {
      return String.format(Locale.ENGLISH, var0, var1);
   }

   public static boolean equals(String var0, String var1) {
      return var0.equals(var1);
   }

   public static int indexOf(String var0, String var1) {
      return var0.indexOf(var1);
   }

   public static String getFileNameWithoutExtension(String var0) {
      int var1 = var0.lastIndexOf(".");
      String var2 = var0;
      if (var1 != -1) {
         var2 = var0.substring(0, var1);
      }

      return var2;
   }
}
