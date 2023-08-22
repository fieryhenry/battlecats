package jp.co.ponos.battlecats;

import android.content.Context;

import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.AssetLoader;

class l extends AssetLoader {

   @Override
   public int getDrawable(String str) {
      Context context = Global.getInstance().getContext();
      int drawableResource = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
      return drawableResource;
   }

   public int getRaw(String str) {
      Context context = Global.getInstance().getContext();
      int drawableResource = context.getResources().getIdentifier(str, "raw", context.getPackageName());
      return drawableResource;
   }

   public int getString(String str) {
      Context context = Global.getInstance().getContext();
      int drawableResource = context.getResources().getIdentifier(str, "string", context.getPackageName());
      return drawableResource;
   }
}
