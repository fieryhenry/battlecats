package jp.co.ponos.library.game.stream;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import jp.co.ponos.library.game.Utility;
import jp.co.ponos.library.game.Global;

public class AssetFileStream extends SaveDataStream {
   public static String getHash(String var0) {
      label33: {
         DataInputStream var1;
         boolean var10001;
         ByteArrayOutputStream var2;
         byte[] var8;
         try {
            var1 = new DataInputStream(Global.getInstance().getContext().getAssets().open(var0));
            var2 = new ByteArrayOutputStream();
            var8 = new byte[1024];
         } catch (Exception var7) {
            var10001 = false;
            break label33;
         }

         while(true) {
            int var3;
            try {
               var3 = var1.read(var8);
            } catch (Exception var5) {
               var10001 = false;
               break;
            }

            if (var3 == -1) {
               try {
                  var0 = Utility.md5(var2.toByteArray(), var2.toByteArray().length);
                  var2.close();
                  var1.close();
                  return var0;
               } catch (Exception var4) {
                  var10001 = false;
                  break;
               }
            }

            try {
               var2.write(var8, 0, var3);
            } catch (Exception var6) {
               var10001 = false;
               break;
            }
         }
      }

      var0 = null;
      return var0;
   }

   public boolean openRead(String var1) {
      boolean var3;
      try {
         DataInputStream var2 = new DataInputStream(Global.getInstance().getContext().getAssets().open(var1));
         this.dataInputStream = var2;
      } catch (Exception var4) {
         var3 = false;
         return var3;
      }

      var3 = true;
      return var3;
   }
}
