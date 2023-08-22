package jp.co.ponos.library.game;

public abstract class Settings {
   static Settings m;
   public boolean a;
   public boolean b;
   public boolean c;
   public String d = "";
   public String[] e;
   public boolean f;
   public String g = "";
   public boolean h;
   public boolean i;
   public boolean j;
   public String packageName;
   public int fps;

   public static Settings getInstance() {
      return m;
   }

   public static void a(Settings var0) {
      m = var0;
   }

   public String a(String var1) {
      return var1;
   }
}
