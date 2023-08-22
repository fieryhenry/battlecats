package jp.co.ponos.battlecats;

//import com.tapjoy.ab;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.purchase.PurchaseDelegate;
import jp.co.ponos.library.score.MyUtility;

public class MyPurchaseDelegate extends PurchaseDelegate {
   @Override
   public void a() {
      MyUtility.getInstance().addButton(MyUtility.getString("purchase_failed"));
   }
   @Override
   public boolean a(String var1) {
      boolean var2 = false;
      boolean var3;
      if (A.a().getSceneType() == SceneType.BATTLE) {
         var3 = var2;
         if (A.a().bM[14] == 1) {
            return var3;
         }
      }

      var3 = var2;
      if (A.a().getSceneType() != SceneType.ENDING) {
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.STAMP) {
            var3 = var2;
         } else {
            int var4 = 0;

            while(true) {
               var3 = var2;
               if (var4 >= 8) {
                  break;
               }

               if (aString.equals(var1, A.a().k[var4])) {
                  if (A.a().hA == 0) {
                     A.a().hy = (int)((MyUtility.getTimeStamp() - (double) A.a().ht[0]) / 86400.0 + 1.0);
                     A.a().hz = A.a().hv;
                     A.a().hA = 1;
                  }

                  int[] var6 = A.a().hx;
                  int var10002 = var6[var4]++;
                  if (A.a().hx[var4] >= 999999999) {
                     A.a().hx[var4] = 999999999;
                  }

                  AppInstance var7 = A.a();
                  int var5 = var7.aL;
                  var7.aL = AppInstance.l[var4] + var5;
                  if (A.a().aL >= 999999) {
                     A.a().aL = 999999;
                  }

                  A.a().h = true;
                  A.a().ac();
                  A.a().i = 0;
                  MyUtility.getInstance().addWebClient();
                  //com.tapjoy.g.a().a((ab)jp.co.ponos.library.b.e.a().c());
                  //com.tapjoy.g.a().a((com.tapjoy.q)jp.co.ponos.library.b.e.a().c());
                  var3 = true;
                  break;
               }

               ++var4;
            }
         }
      }

      return var3;
   }
   @Override
   public void b() {
   }
}
