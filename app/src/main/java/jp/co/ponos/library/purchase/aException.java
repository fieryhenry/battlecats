package jp.co.ponos.library.purchase;

/* renamed from: jp.co.ponos.library.purchase.v */
/* loaded from: classes.dex */
public class aException extends Exception {
    private int a;

    public aException(int i) {
        this.a = i;
    }

    public aException(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }
}
