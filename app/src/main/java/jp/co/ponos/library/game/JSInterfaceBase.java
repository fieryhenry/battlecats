package jp.co.ponos.library.game;

import jp.co.ponos.library.score.MyUtility;

public abstract class JSInterfaceBase {
   public void cancel() {
      MyUtility.instance.addWebClient();
   }
}
