package jp.co.ponos.library.purchase;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class t extends SSLSocketFactory {
   private SSLContext a = SSLContext.getInstance("TLS");

   public t(KeyStore var1) throws NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException, KeyStoreException {
      super(var1);
      u var2 = new u(this);
      this.a.init((KeyManager[])null, new TrustManager[]{var2}, (SecureRandom)null);
   }

   public Socket createSocket() throws IOException {
      return this.a.getSocketFactory().createSocket();
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return this.a.getSocketFactory().createSocket(var1, var2, var3, var4);
   }
}
