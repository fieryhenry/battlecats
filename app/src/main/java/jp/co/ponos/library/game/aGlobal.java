package jp.co.ponos.library.game;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: jp.co.ponos.library.b.e */
/* loaded from: classes.dex */
public class aGlobal {

    /* renamed from: a */
    static aGlobal instance;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int width;
    int height;
    Handler k;

    /* renamed from: l */
    Context context;
    boolean isGameOpen;
    FrameLayout n;
    GL10 o;
    aBackKeyController q;
    aBackKeyController r;
    Random b = new Random();

    /* renamed from: p */
    ArrayList dialogs = new ArrayList();

    /* renamed from: a */
    public static aGlobal getInstance() {
        return instance;
    }

    /* renamed from: a */
    public static void setInstance(aGlobal aglobal) {
        instance = aglobal;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.c = i3;
        this.d = i4;
        this.width = i;
        this.height = i2;
        if ((this.c * i2) / i <= this.d) {
            this.g = this.c;
            this.h = (this.c * i2) / i;
            this.e = 0;
            this.f = (this.d - this.h) / 2;
            return;
        }
        this.g = (this.d * i) / i2;
        this.h = this.d;
        this.e = (this.c - this.g) / 2;
        this.f = 0;
    }

    public void a(Context context) {
        this.context = context;
    }

    public void a(Handler handler) {
        this.k = handler;
    }

    public void a(FrameLayout frameLayout) {
        this.n = frameLayout;
    }

    public void a(GL10 gl10) {
        this.o = gl10;
    }

    public void a(aBackKeyController abackkeycontroller) {
        this.r = abackkeycontroller;
    }

    public int b() {
        return this.g;
    }

    public void b(aBackKeyController abackkeycontroller) {
        this.q = abackkeycontroller;
    }

    /* renamed from: c */
    public Context getContext() {
        return this.context;
    }

    public FrameLayout getFrameLayout() {
        return this.n;
    }

    /* renamed from: e */
    public ArrayList getDialogs() {
        return this.dialogs;
    }

    public aBackKeyController f() {
        return this.q == null ? this.r : this.q;
    }
}
