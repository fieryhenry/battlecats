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
    int viewportX;
    int viewportY;
    int viewportWidth;
    int viewportHeight;
    int width;
    int height;
    Handler k;

    /* renamed from: l */
    Context context;
    boolean isGameOpen;
    FrameLayout n;
    GL10 gl10;
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
            this.viewportWidth = this.c;
            this.viewportHeight = (this.c * i2) / i;
            this.viewportX = 0;
            this.viewportY = (this.d - this.viewportHeight) / 2;
            return;
        }
        this.viewportWidth = (this.d * i) / i2;
        this.viewportHeight = this.d;
        this.viewportX = (this.c - this.viewportWidth) / 2;
        this.viewportY = 0;
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
        this.gl10 = gl10;
    }

    public void a(aBackKeyController abackkeycontroller) {
        this.r = abackkeycontroller;
    }

    public int b() {
        return this.viewportWidth;
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
