package jp.co.ponos.library.purchase;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class u implements X509TrustManager {
   // $FF: synthetic field
   final t a;

   u(t var1) {
      this.a = var1;
   }

   public void checkClientTrusted(X509Certificate[] var1, String var2) {
   }

   public void checkServerTrusted(X509Certificate[] var1, String var2) {
   }

   public X509Certificate[] getAcceptedIssuers() {
      return null;
   }
}
