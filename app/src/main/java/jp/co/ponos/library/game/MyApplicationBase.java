package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.a */
/* loaded from: classes.dex */
public abstract class MyApplicationBase {
    static MyApplicationBase instance;

    public static void setInstance(MyApplicationBase myApplicationBase) {
        instance = myApplicationBase;
    }

    /* renamed from: af */
    public static MyApplicationBase getInstance() {
        return instance;
    }

    public void setIsGameOpen(boolean z) {
        aGlobal.instance.isGameOpen = z;
    }

    public void ag() {
    }

    public int getWidth() {
        return aGlobal.instance.width;
    }

    public int getHeight() {
        return aGlobal.instance.height;
    }

    public boolean isGameOpen() {
        return aGlobal.instance.isGameOpen;
    }

    public void b(boolean z) {
    }
}
