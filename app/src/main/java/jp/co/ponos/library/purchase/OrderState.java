package jp.co.ponos.library.purchase;

/* renamed from: jp.co.ponos.library.purchase.j */
/* loaded from: classes.dex */
public enum OrderState {
    PURCHASED,
    CANCELED,
    REFUNDED;

    public static OrderState a(int i) {
        OrderState[] valuesCustom = valuesCustom();
        return (i < 0 || i >= valuesCustom.length) ? CANCELED : valuesCustom[i];
    }

    /* JADX DEBUG: Replace access to removed values field (d) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static OrderState[] valuesCustom() {
        OrderState[] valuesCustom = values();
        int length = valuesCustom.length;
        OrderState[] orderStateArr = new OrderState[length];
        System.arraycopy(valuesCustom, 0, orderStateArr, 0, length);
        return orderStateArr;
    }
}
