package jp.co.ponos.library.purchase;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import jp.co.ponos.library.game.aSettings;
import jp.co.ponos.library.game.aUtility;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: jp.co.ponos.library.purchase.s */
/* loaded from: classes.dex */
public class PurchaseSender {
    private static HashMap a = new HashMap();
    private static KeyStore b = null;

    public static HttpClient a() throws aException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                keyStore.load(null, null);
                aSocket asocket = new aSocket(keyStore);
                asocket.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                Scheme scheme = new Scheme("https", asocket, 443);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getConnectionManager().getSchemeRegistry().register(scheme);
                return defaultHttpClient;
            } catch (IOException e5) {
                throw new aException(256, e5);
            } catch (NoSuchAlgorithmException e6) {
                throw new aException(256, e6);
            } catch (CertificateException e7) {
                throw new aException(256, e7);
            } catch (UnrecoverableKeyException e) {
                throw new RuntimeException(e);
            } catch (KeyManagementException e) {
                throw new RuntimeException(e);
            }
        } catch (KeyStoreException e8) {
            throw new aException(256, e8);
        }
    }

    public static void a(String str, String str2) throws aException {
        Log.i("Security", "signedData: " + str);
        Log.i("Security", "signature: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new aException(258);
        }
        try {
            long j = new JSONObject(str).getLong("nonce");
            if (!a.containsKey(Long.valueOf(j))) {
                throw new aException(258);
            }
            HttpContext httpContext = (HttpContext) a.get(Long.valueOf(j));
            a.remove(Long.valueOf(j));
            HttpClient a2 = a();
            HttpConnectionParams.setConnectionTimeout(a2.getParams(), 10000);
            HttpPost httpPost = new HttpPost(aSettings.getInstance().getSetting("https://www.ponos.net/android/appli/purchase/verify.php"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("signedData", str));
            arrayList.add(new BasicNameValuePair("signature", str2));
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                try {
                    HttpResponse execute = a2.execute(httpPost, httpContext);
                    if (execute.getStatusLine().getStatusCode() != 200) {
                        throw new aException(514);
                    }
                    String entityUtils = EntityUtils.toString(execute.getEntity());
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update((String.valueOf("Ponos Genuine Material".replace(' ', '.')) + str + str2).getBytes("UTF-8"));
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (byte b2 : digest) {
                        int i = b2 & 255;
                        sb.append("0123456789abcdef".charAt(i >>> 4)).append("0123456789abcdef".charAt(i & 15));
                    }
                    if (!sb.toString().equals(entityUtils)) {
                        throw new aException(514);
                    }
                } catch (NoSuchAlgorithmException e) {
                    throw new aException(256, e);
                } catch (ClientProtocolException e2) {
                    throw new aException(513, e2);
                } catch (IOException e3) {
                    throw new aException(513, e3);
                }
            } catch (UnsupportedEncodingException e4) {
                throw new aException(256, e4);
            }
        } catch (JSONException e5) {
            throw new aException(257, e5);
        }
    }

    public static long b() throws aException {
        BasicCookieStore basicCookieStore = new BasicCookieStore();
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.cookie-store", basicCookieStore);
        HttpClient a2 = a();
        HttpConnectionParams.setConnectionTimeout(a2.getParams(), 10000);
        try {
            try {
                HttpResponse execute = a2.execute(new HttpPost(aSettings.getInstance().getSetting("https://www.ponos.net/android/appli/purchase/verify_start.php")), basicHttpContext);
                try {
                    if (execute.getStatusLine().getStatusCode() != 200) {
                        throw new aException(514);
                    }
                    long longValue = Long.decode("0x" + EntityUtils.toString(execute.getEntity())).longValue();
                    if (longValue != 0) {
                        a.put(Long.valueOf(longValue), basicHttpContext);
                    }
                    return longValue;
                } catch (IOException e) {
                    throw new aException(515, e);
                } catch (NumberFormatException e2) {
                    throw new aException(515, e2);
                } catch (ParseException e3) {
                    throw new aException(515, e3);
                }
            } catch (ClientProtocolException e4) {
                throw new aException(513, e4);
            }
        } catch (IOException e5) {
            throw new aException(513, e5);
        }
    }
}
