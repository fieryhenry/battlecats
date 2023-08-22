package jp.co.ponos.library.game;

public class aMath {
   public static float sin(float var0) {
      return (float)Math.sin(Math.PI * (double)var0 / 180.0);
   }

   public static float atan2(float var0, float var1) {
      if (var0 >= 0.0F) {
         var0 = (float)(Math.atan2((double)var0, (double)var1) * 180.0 / Math.PI);
      } else {
         var0 = (float)(Math.atan2((double)var0, (double)var1) * 180.0 / Math.PI + 360.0);
      }

      return var0;
   }

   public static int rand() {
      return Math.abs(Global.instance.b.nextInt());
   }

   public static int rand(int var0) {
      return Global.instance.b.nextInt(var0);
   }

   public static float cos(float var0) {
      return (float)Math.cos(Math.PI * (double)var0 / 180.0);
   }

   public static float pow(float var0, float var1) {
      return (float)Math.pow((double)var0, (double)var1);
   }

   public static float sqrt(float var0) {
      return (float)Math.sqrt((double)var0);
   }
}
