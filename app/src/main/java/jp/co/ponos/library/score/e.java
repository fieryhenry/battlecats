package jp.co.ponos.library.score;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Vector;

import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.JSInterfaceBase;

public class e extends JSInterfaceBase {
   public void error(String var1) {
      Toast.makeText(Global.getInstance().getContext(), var1, Toast.LENGTH_SHORT).show();
   }

   public void submitScore(String var1, String var2, String var3, String var4) {
      byte var5 = 0;

      label90: {
         label78: {
            String var6;
            try {
               if (var4.length() <= 8) {
                  break label78;
               }

               var6 = var4.substring(0, 8);
            } catch (Exception var16) {
               break label90;
            }

            var4 = var6;
         }

         String[] var17;
         boolean var10001;
         int[] var24;
         try {
            SharedPreferences.Editor var23 = PreferenceManager.getDefaultSharedPreferences(Global.getInstance().getContext()).edit();
            var23.putString(MyUtility.md5("name"), MyUtility.encrypt(MyUtility.md5("name"), var4));
            var23.commit();
            var17 = var2.split(",", -1);
            var24 = new int[var17.length];
         } catch (Exception var15) {
            var10001 = false;
            break label90;
         }

         int var7 = 0;

         int[] var18;
         label66:
         while(true) {
            label64: {
               label87: {
                  String[] var19;
                  try {
                     if (var7 < var24.length) {
                        break label64;
                     }

                     if (var3.length() <= 0) {
                        break label87;
                     }

                     var19 = var3.split(",", -1);
                     var18 = new int[var19.length];
                  } catch (Exception var14) {
                     var10001 = false;
                     break label90;
                  }

                  var7 = var5;

                  while(true) {
                     try {
                        if (var7 >= var18.length) {
                           break label66;
                        }
                     } catch (Exception var13) {
                        var10001 = false;
                        break label90;
                     }

                     try {
                        var18[var7] = Integer.parseInt(var19[var7]);
                     } catch (Exception var11) {
                        var10001 = false;
                        break label90;
                     }

                     ++var7;
                  }
               }

               var18 = null;
               break;
            }

            try {
               var24[var7] = Integer.parseInt(var17[var7]);
            } catch (Exception var12) {
               var10001 = false;
               break label90;
            }

            ++var7;
         }

         try {
            Vector var21 = Global.getInstance().getDialogs();
            a var9 = a.b();
            var9.getClass();
            b var8 = new b(var9, MyUtility.decrypt(MyUtility.md5("q"), "Uh7ZhyOPKQVrg15k9Qgev7dUpYMimG7lU8MtFdl11Dg="), var1, var4, var24, var18);
            var21.add(var8);
            MyUtility.getInstance().addWebClient();
            return;
         } catch (Exception var10) {
            var10001 = false;
         }
      }

      Vector var20 = Global.getInstance().getDialogs();
      a var22 = a.b();
      var22.getClass();
      var20.add(new b(var22, MyUtility.decrypt(MyUtility.md5("q"), "Uh7ZhyOPKQVrg15k9Qgev7dUpYMimG7lU8MtFdl11Dg="), var1, var4, (int[])null, (int[])null));
   }
}
