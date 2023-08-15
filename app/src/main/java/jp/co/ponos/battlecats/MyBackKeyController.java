package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aBackKeyController;

/* renamed from: jp.co.ponos.battlecats.f */
/* loaded from: classes.dex */
public class MyBackKeyController extends aBackKeyController {
    @Override // jp.co.ponos.library.game.aBackKeyController
    public boolean a() {
        if (A.a().getSceneType() == SceneType.MAIN && A.a().screenID == 0 && A.a().fG[0] == 0 && !A.a().ee) {
            return false;
        }
        A.a().S = true;
        A.a().i = 0;
        A.a().menuType = -1;
        return true;
    }
}
