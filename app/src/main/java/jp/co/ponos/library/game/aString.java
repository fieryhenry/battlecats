package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.aa */
/* loaded from: classes.dex */
public class aString {
    /* renamed from: a */
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    /* renamed from: a */
    public static String format(String str, Object... objArr) {
        return String.format(str, objArr);
    }

    /* renamed from: a */
    public static boolean isEqual(String str, String str2) {
        return str.equals(str2);
    }

    /* renamed from: b */
    public static int indexOf(String str, String str2) {
        return str.indexOf(str2);
    }

    /* renamed from: b */
    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }
}
