package jp.co.ponos.library.game;

public abstract class MyApplicationBase {
   static MyApplicationBase instance;

   public static void setInstance(MyApplicationBase instance) {
      MyApplicationBase.instance = instance;
   }

   public static MyApplicationBase getInstance() {
      return instance;
   }

   public void setIsGameOpen(boolean isGameOpen) {
      Global.instance.isGameOpen = isGameOpen;
   }

   public void ag() {
   }

   public int getWidth() {
      return Global.instance.width;
   }

   public int getHeight() {
      return Global.instance.height;
   }

   public boolean isGameOpen() {
      return Global.instance.isGameOpen;
   }

   public void b(boolean var1) {
   }
}
