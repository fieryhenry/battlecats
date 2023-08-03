package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.c */
/* loaded from: classes.dex */
public class aBrowserOption {
    int a;
    int[] b = new int[3];
    int[] c = new int[3];
    String[] d = new String[3];
    String e;
    boolean f;

    /* renamed from: a */
    public void addButton(int i, int i2, String str) {
        this.b[this.a] = i;
        this.c[this.a] = i2;
        this.d[this.a] = str;
        this.a++;
    }

    /* renamed from: a */
    public void setBackgroundImage(String str) {
        this.e = str;
    }

    /* renamed from: a */
    public void setSystemFlag(boolean z) {
        this.f = z;
    }
}
