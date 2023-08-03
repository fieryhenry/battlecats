package jp.co.ponos.library.purchase;

/* renamed from: jp.co.ponos.library.purchase.k */
/* loaded from: classes.dex */
public enum BillingState {
    RESULT_OK,
    RESULT_USER_CANCELED,
    RESULT_SERVICE_UNAVAILABLE,
    RESULT_BILLING_UNAVAILABLE,
    RESULT_ITEM_UNAVAILABLE,
    RESULT_DEVELOPER_ERROR,
    RESULT_ERROR;

    public static BillingState a(int i) {
        BillingState[] valuesCustom = valuesCustom();
        return (i < 0 || i >= valuesCustom.length) ? RESULT_ERROR : valuesCustom[i];
    }

    /* JADX DEBUG: Replace access to removed values field (h) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BillingState[] valuesCustom() {
        BillingState[] valuesCustom = values();
        int length = valuesCustom.length;
        BillingState[] billingStateArr = new BillingState[length];
        System.arraycopy(valuesCustom, 0, billingStateArr, 0, length);
        return billingStateArr;
    }
}
