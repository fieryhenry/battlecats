package jp.co.ponos.library.game;

public abstract class AssetLoader {
   static AssetLoader assetLoader;

   public static void setInstance(AssetLoader var0) {
      assetLoader = var0;
   }

   public abstract int getDrawable(String var1);

   public abstract int getRaw(String var1);

   public abstract int getString(String var1);
}
