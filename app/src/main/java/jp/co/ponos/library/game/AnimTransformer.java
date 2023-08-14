package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.ad */
/* loaded from: classes.dex */
public class AnimTransformer {
    float[] matrix = new float[9];

    public AnimTransformer() {
        init();
    }

    public void init() {
        this.matrix[0] = 1.0f;
        this.matrix[1] = 0.0f;
        this.matrix[2] = 0.0f;
        this.matrix[3] = 0.0f;
        this.matrix[4] = 1.0f;
        this.matrix[5] = 0.0f;
        this.matrix[6] = 0.0f;
        this.matrix[7] = 0.0f;
        this.matrix[8] = 1.0f;
    }

    public void scale(float xScale, float yScale) {
        this.matrix[0] = xScale / 100.0f;
        this.matrix[1] = 0.0f;
        this.matrix[2] = 0.0f;
        this.matrix[3] = 0.0f;
        this.matrix[4] = yScale / 100.0f;
        this.matrix[5] = 0.0f;
        this.matrix[6] = 0.0f;
        this.matrix[7] = 0.0f;
        this.matrix[8] = 1.0f;
    }

    public void applyTransformation(int x, int y, aPoint result) {
        result.x = (int) ((this.matrix[0] * x) + (this.matrix[1] * y) + this.matrix[2]);
        result.y = (int) ((this.matrix[3] * x) + (this.matrix[4] * y) + this.matrix[5]);
    }

    public void merge(AnimTransformer other) {
        float f = (this.matrix[0] * other.matrix[0]) + (this.matrix[1] * other.matrix[3]) + (this.matrix[2] * other.matrix[6]);
        float f2 = (this.matrix[0] * other.matrix[1]) + (this.matrix[1] * other.matrix[4]) + (this.matrix[2] * other.matrix[7]);
        float f3 = (this.matrix[0] * other.matrix[2]) + (this.matrix[1] * other.matrix[5]) + (this.matrix[2] * other.matrix[8]);
        float f4 = (this.matrix[3] * other.matrix[0]) + (this.matrix[4] * other.matrix[3]) + (this.matrix[5] * other.matrix[6]);
        float f5 = (this.matrix[3] * other.matrix[1]) + (this.matrix[4] * other.matrix[4]) + (this.matrix[5] * other.matrix[7]);
        float f6 = (this.matrix[3] * other.matrix[2]) + (this.matrix[4] * other.matrix[5]) + (this.matrix[5] * other.matrix[8]);
        float f7 = (this.matrix[6] * other.matrix[0]) + (this.matrix[7] * other.matrix[3]) + (this.matrix[8] * other.matrix[6]);
        float f8 = (this.matrix[6] * other.matrix[1]) + (this.matrix[7] * other.matrix[4]) + (this.matrix[8] * other.matrix[7]);
        float f9 = (this.matrix[6] * other.matrix[2]) + (this.matrix[7] * other.matrix[5]) + (this.matrix[8] * other.matrix[8]);
        this.matrix[0] = f;
        this.matrix[1] = f2;
        this.matrix[2] = f3;
        this.matrix[3] = f4;
        this.matrix[4] = f5;
        this.matrix[5] = f6;
        this.matrix[6] = f7;
        this.matrix[7] = f8;
        this.matrix[8] = f9;
    }

    public void translate(float xOffset, float yOffset) {
        this.matrix[0] = 1.0f;
        this.matrix[1] = 0.0f;
        this.matrix[2] = xOffset;
        this.matrix[3] = 0.0f;
        this.matrix[4] = 1.0f;
        this.matrix[5] = yOffset;
        this.matrix[6] = 0.0f;
        this.matrix[7] = 0.0f;
        this.matrix[8] = 1.0f;
    }
}
