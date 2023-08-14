package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.k */
/* loaded from: classes.dex */
public class aMath {
    /* renamed from: a */
    public static float sin(float f) {
        return (float) Math.sin((3.141592653589793d * f) / 180.0d);
    }

    /* renamed from: a */
    public static float atan2(float f, float f2) {
        return f >= 0.0f ? (float) ((Math.atan2(f, f2) * 180.0d) / 3.141592653589793d) : (float) (((Math.atan2(f, f2) * 180.0d) / 3.141592653589793d) + 360.0d);
    }

    /* renamed from: a */
    public static int rand() {
        return Math.abs(aGlobal.instance.b.nextInt());
    }

    /* renamed from: a */
    public static int rand(int bound) {
        return aGlobal.instance.b.nextInt(bound);
    }

    /* renamed from: b */
    public static float cos(float f) {
        return (float) Math.cos((3.141592653589793d * f) / 180.0d);
    }

    /* renamed from: b */
    public static float pow(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    /* renamed from: c */
    public static float sqrt(float f) {
        return (float) Math.sqrt(f);
    }
}
