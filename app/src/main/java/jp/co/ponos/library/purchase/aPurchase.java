package jp.co.ponos.library.purchase;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.n */
/* loaded from: classes.dex */
public class aPurchase extends aPurchaseBase {
    private boolean a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aPurchase(boolean z, String str) {
        this.a = z;
        this.b = str;
    }

    @Override // jp.co.ponos.library.purchase.aPurchaseBase
    public void a(PurchaseObserver purchaseObserver) {
        purchaseObserver.a(this.a, this.b);
    }
}
