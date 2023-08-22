package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.BackKeyController;

public class MyBackKeyController extends BackKeyController {
   @Override
   public boolean isBackPressValid() {
      boolean var1 = false;
      if (A.a().getSceneType() != SceneType.MAIN || A.a().screen != 0 || A.a().fG[0] != 0 || A.a().ee) {
         A.a().backPressed = true;
         A.a().i = 0;
         A.a().menuType = -1;
         var1 = true;
      }

      return var1;
   }
}
