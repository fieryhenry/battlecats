package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.x */
/* loaded from: classes.dex */
public abstract class aSettings {
    static aSettings m;
    public boolean a;
    public boolean b;
    public boolean c;
    public String[] e;
    public boolean facebookEnable;
    public boolean h;
    public boolean i;
    public boolean j;

    /* renamed from: k */
    public String packageName;

    /* renamed from: l */
    public int fps;
    public String d = "";
    public String g = "";

    /* renamed from: a */
    public static aSettings getInstance() {
        return m;
    }

    /* renamed from: a */
    public static void setInstance(aSettings asettings) {
        m = asettings;
    }

    /* renamed from: a */
    public String getSetting(String str) {
        return str;
    }
}
