package jp.co.ponos.library.game;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.r */
/* loaded from: classes.dex */
public class aAnimTransformer {
    float[] a = new float[9];

    public aAnimTransformer() {
        a();
    }

    public void a() {
        this.a[0] = 1.0f;
        this.a[1] = 0.0f;
        this.a[2] = 0.0f;
        this.a[3] = 0.0f;
        this.a[4] = 1.0f;
        this.a[5] = 0.0f;
        this.a[6] = 0.0f;
        this.a[7] = 0.0f;
        this.a[8] = 1.0f;
    }

    public void a(int i, int i2) {
        a();
        this.a[0] = aMath.cos((i * 360) / i2);
        this.a[1] = -aMath.sin((i * 360) / i2);
        this.a[3] = aMath.sin((i * 360) / i2);
        this.a[4] = aMath.cos((i * 360) / i2);
    }

    public void a(int i, int i2, aPoint apoint) {
        apoint.x = (int) ((this.a[0] * i) + (this.a[1] * i2) + this.a[2]);
        apoint.y = (int) ((this.a[3] * i) + (this.a[4] * i2) + this.a[5]);
    }

    public void a(aAnimTransformer aanimtransformer) {
        float f = (this.a[0] * aanimtransformer.a[0]) + (this.a[1] * aanimtransformer.a[3]) + (this.a[2] * aanimtransformer.a[6]);
        float f2 = (this.a[0] * aanimtransformer.a[1]) + (this.a[1] * aanimtransformer.a[4]) + (this.a[2] * aanimtransformer.a[7]);
        float f3 = (this.a[0] * aanimtransformer.a[2]) + (this.a[1] * aanimtransformer.a[5]) + (this.a[2] * aanimtransformer.a[8]);
        float f4 = (this.a[3] * aanimtransformer.a[0]) + (this.a[4] * aanimtransformer.a[3]) + (this.a[5] * aanimtransformer.a[6]);
        float f5 = (this.a[3] * aanimtransformer.a[1]) + (this.a[4] * aanimtransformer.a[4]) + (this.a[5] * aanimtransformer.a[7]);
        float f6 = (this.a[3] * aanimtransformer.a[2]) + (this.a[4] * aanimtransformer.a[5]) + (this.a[5] * aanimtransformer.a[8]);
        float f7 = (this.a[6] * aanimtransformer.a[0]) + (this.a[7] * aanimtransformer.a[3]) + (this.a[8] * aanimtransformer.a[6]);
        float f8 = (this.a[6] * aanimtransformer.a[1]) + (this.a[7] * aanimtransformer.a[4]) + (this.a[8] * aanimtransformer.a[7]);
        float f9 = (this.a[6] * aanimtransformer.a[2]) + (this.a[7] * aanimtransformer.a[5]) + (this.a[8] * aanimtransformer.a[8]);
        this.a[0] = f;
        this.a[1] = f2;
        this.a[2] = f3;
        this.a[3] = f4;
        this.a[4] = f5;
        this.a[5] = f6;
        this.a[6] = f7;
        this.a[7] = f8;
        this.a[8] = f9;
    }

    public void b(int i, int i2) {
        a();
        this.a[2] = i;
        this.a[5] = i2;
    }
}
