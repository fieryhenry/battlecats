package jp.co.ponos.library.purchase;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.purchase.u */
/* loaded from: classes.dex */
public class aTrust implements X509TrustManager {
    final /* synthetic */ aSocket a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aTrust(aSocket asocket) {
        this.a = asocket;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
