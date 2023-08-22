package jp.co.ponos.battlecats;

import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.score.Score;

class MyScore extends Score {
   @Override
   public void a(String var1, int var2, int var3) {
      if (var3 == 1) {
         MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
      } else {
         MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
      }

   }
   @Override
   public void b(String var1, int var2, int var3) {
      MyUtility.getInstance().addAlertCloser();
      if (var3 == 1) {
         jp.co.ponos.library.score.a.b().a("battlecats_score");
         A.a().aW = 0;
         A.a().ac();
      } else {
         MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
      }

   }
}
