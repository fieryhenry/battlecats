package jp.co.ponos.battlecats;

import android.content.Context;

import jp.co.ponos.library.game.aAssetLoader;
import jp.co.ponos.library.game.aGlobal;

/* renamed from: jp.co.ponos.battlecats.l */
/* loaded from: classes.dex */
class MyAssetLoader extends aAssetLoader {
    @Override // jp.co.ponos.library.game.aAssetLoader
    public int getDrawable(String str) {
        Context context = aGlobal.getInstance().getContext();
        int drawableResource = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        return drawableResource;
    }

    @Override // jp.co.ponos.library.game.aAssetLoader
    public int getRaw(String str) {
        Context context = aGlobal.getInstance().getContext();
        int drawableResource = context.getResources().getIdentifier(str, "raw", context.getPackageName());
        return drawableResource;
    }

    @Override // jp.co.ponos.library.game.aAssetLoader
    public int getString(String str) {
        Context context = aGlobal.getInstance().getContext();
        int drawableResource = context.getResources().getIdentifier(str, "string", context.getPackageName());
        return drawableResource;
    }
}
