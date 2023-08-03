package jp.co.ponos.library.purchase;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.r */
/* loaded from: classes.dex */
public class aBillingException extends aPurchaseBase {
    private int a;
    private Throwable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aBillingException(int i, Throwable th) {
        this.a = i;
        this.b = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // jp.co.ponos.library.purchase.aPurchaseBase
    public void a(PurchaseObserver purchaseObserver) {
        purchaseObserver.a(this.a, this.b);
    }
}
