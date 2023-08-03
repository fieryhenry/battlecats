package jp.co.ponos.library.purchase;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.q */
/* loaded from: classes.dex */
public class aBilllingRequest extends aPurchaseBase {
    private LogPurchaseRequest a;
    private BillingState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aBilllingRequest(LogPurchaseRequest logPurchaseRequest, BillingState billingState) {
        this.a = logPurchaseRequest;
        this.b = billingState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // jp.co.ponos.library.purchase.aPurchaseBase
    public void a(PurchaseObserver purchaseObserver) {
        purchaseObserver.a(this.a, this.b);
    }
}
