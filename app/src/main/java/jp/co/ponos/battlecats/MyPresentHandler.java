package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.PurchaseDelegate;
import jp.co.ponos.library.game.aHashTable;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.PurchaseHandler;
import jp.co.ponos.library.score.MyUtility;

class MyPresentHandler extends PurchaseHandler {
   @Override
   public void a(PurchaseDelegate var1) {
      String[] var2 = var1.a().split("&", -1);
      aHashTable var6 = new aHashTable();
      int var3 = var2.length;

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         String[] var5 = var2[var4].split("=", -1);
         var6.put(var5[0], var5[1]);
      }

      MyUtility.getInstance().addAlertCloser();
      String var7;
      if (var6.contains("result") && var6.contains("present")) {
         if (aString.equals(var6.get("result"), "ok")) {
            var4 = aString.parseInt(var6.get("present"));
            if (var4 >= 0 && var4 <= 10 && !A.a().bF[var4]) {
               AppInstance var8;
               if (var4 == 0) {
                  var8 = A.a();
                  var8.aY += 10000;
                  if (A.a().aY >= 99999999) {
                     A.a().aY = 99999999;
                  }
               } else if (var4 == 1) {
                  var8 = A.a();
                  var8.aY += 10000;
                  if (A.a().aY >= 99999999) {
                     A.a().aY = 99999999;
                  }
               } else {
                  int[] var9;
                  if (var4 == 2) {
                     var9 = A.a().bA;
                     var9[0] += 15;
                     if (A.a().bA[0] >= 9999) {
                        A.a().bA[0] = 9999;
                     }
                  } else if (var4 == 3) {
                     var8 = A.a();
                     var8.aL += 30;
                     if (A.a().aL >= 999999) {
                        A.a().aL = 999999;
                     }
                  } else if (var4 == 4) {
                     var8 = A.a();
                     var8.aY += 30000;
                     if (A.a().aY >= 99999999) {
                        A.a().aY = 99999999;
                     }
                  } else if (var4 == 5) {
                     var9 = A.a().bA;
                     var9[1] += 3;
                     if (A.a().bA[1] >= 9999) {
                        A.a().bA[1] = 9999;
                     }
                  } else if (var4 == 6) {
                     var8 = A.a();
                     var8.aL += 30;
                     if (A.a().aL >= 999999) {
                        A.a().aL = 999999;
                     }
                  } else if (var4 == 7) {
                     var8 = A.a();
                     var8.aY += 50000;
                     if (A.a().aY >= 99999999) {
                        A.a().aY = 99999999;
                     }
                  } else if (var4 == 8) {
                     var9 = A.a().bA;
                     var9[1] += 5;
                     if (A.a().bA[1] >= 9999) {
                        A.a().bA[1] = 9999;
                     }
                  } else if (var4 == 9) {
                     var8 = A.a();
                     var8.aL += 30;
                     if (A.a().aL >= 999999) {
                        A.a().aL = 999999;
                     }
                  } else if (var4 == 10) {
                     A.a().bD[0] = 1;
                     A.a().by[1] = 1;
                     A.a().bC[A.a().bJ[16][13]] = 0;
                  }
               }

               MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=facebook&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
               var7 = aString.format("type=get2&pid=%s&no=-1&lang=%s", A.a().e, MyUtility.getString("lang"));
               var7 = aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), var7, MyUtility.md5(aString.format("%s&check=adlmn", var7)));
               MyUtility.getInstance().addAssetGetter(var7);
               A.a().bF[var4] = true;
               A.a().ac();
            }
         } else if (aString.equals(var6.get("result"), "ng")) {
            var7 = aString.format("type=get2&pid=%s&no=%s&lang=%s", A.a().e, var6.get("error"), MyUtility.getString("lang"));
            var7 = aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), var7, MyUtility.md5(aString.format("%s&check=adlmn", var7)));
            MyUtility.getInstance().addAssetGetter(var7);
         } else {
            var7 = aString.format("type=get2&pid=%s&no=2&lang=%s", A.a().e, MyUtility.getString("lang"));
            var7 = aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), var7, MyUtility.md5(aString.format("%s&check=adlmn", var7)));
            MyUtility.getInstance().addAssetGetter(var7);
         }
      } else {
         var7 = aString.format("type=get2&pid=%s&no=2&lang=%s", A.a().e, MyUtility.getString("lang"));
         var7 = aString.format("%s/battlecats/friend.php?%&check=%s", MyUtility.getAppli(), var7, MyUtility.md5(aString.format("%s&check=adlmn", var7)));
         MyUtility.getInstance().addAssetGetter(var7);
      }

   }
   @Override
   public void b(PurchaseDelegate var1) {
      MyUtility.getInstance().addAlertCloser();
      MyUtility.getInstance().addButton(MyUtility.getString("error"));
   }
}
