package jp.co.ponos.library.game.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import jp.co.ponos.library.game.Global;

public class AssetTextStream extends TextStream {
   public boolean openRead(String var1) {
      try {
         InputStreamReader var3 = new InputStreamReader(Global.getInstance().getContext().getAssets().open(var1), "utf-8");
         BufferedReader var2 = new BufferedReader(var3);
         this.readerBuffer = var2;
      } catch (Exception var5) {
         return false;
      }

      return true;
   }
}
