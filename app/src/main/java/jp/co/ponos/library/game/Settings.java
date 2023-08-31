package jp.co.ponos.library.game;

public abstract class Settings {
   static Settings settings;
   public boolean a;
   public boolean b;
   public boolean c;
   public String d = "";
   public String[] e;
   public boolean f;
   public String g = "";
   public boolean h;
   public boolean twitterEnable;
   public boolean normalScreen;
   public String packageName;
   public int fps;
   public boolean dev;

   public static Settings getInstance() {
      return settings;
   }

   public static void setInstance(Settings settings) {
      Settings.settings = settings;
   }

   public String getSetting(String var1) {
      return var1;
   }
}
