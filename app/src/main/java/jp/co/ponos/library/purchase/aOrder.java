package jp.co.ponos.library.purchase;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.o */
/* loaded from: classes.dex */
public class aOrder extends aPurchaseBase {
    private OrderState a;
    private String b;
    private String c;
    private long d;
    private String e;
    private String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aOrder(OrderState orderState, String str, String str2, long j, String str3, String str4) {
        this.a = orderState;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = str3;
        this.f = str4;
    }

    @Override // jp.co.ponos.library.purchase.aPurchaseBase
    public void a(PurchaseObserver purchaseObserver) {
        purchaseObserver.a(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
