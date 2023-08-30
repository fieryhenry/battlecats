package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.score.MyUtility;

public class TapJoyCatfood implements Runnable {
    final MyActivity myActivity;
    private final int catfood;

    public TapJoyCatfood(MyActivity activity, int catfood) {
        this.myActivity = activity;
        this.catfood = catfood;
    }

    @Override
    public void run() {
        String a = MyUtility.getString("catfoodtapjoy_txt");
        if ((A.a().getSceneType() != SceneType.BATTLE || A.a().battleStats[14] != 1) && A.a().getSceneType() != SceneType.ENDING && (A.a().getSceneType() != SceneType.MAIN || A.a().getScreenType() != ScreenType.STAMP) && this.catfood > 0) {
            AppInstance var3 = A.a();
            var3.catfood += this.catfood;
            MyUtility.getInstance().addButton(aString.format(a, this.catfood));
            //com.tapjoy.g.a().a(var2, this);
            A.a().ac();
        }
    }
}
