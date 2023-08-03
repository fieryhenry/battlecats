package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.w */
/* loaded from: classes.dex */
public abstract class aAssetLoader {
    static aAssetLoader assetLoader;

    public static void getDrawable(aAssetLoader aassetloader) {
        assetLoader = aassetloader;
    }

    public abstract int getDrawable(String str);

    public abstract int getRaw(String str);

    public abstract int getString(String str);
}
