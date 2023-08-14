package jp.co.ponos.library.game;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: jp.co.ponos.library.b.ae */
/* loaded from: classes.dex */
public abstract class aUtility {

    /* renamed from: a */
    protected static aUtility instance;
    aPresentRenderer b;
    String c;
    boolean d;
    WebView webView;
    FrameLayout f;
    String g;
    aUnknown2 h;
    aJSInterfaceBase i;
    boolean j;
    ProgressDialog k;

    public static int transCoordWindowToGLViewX(int i) {
        return (aGlobal.instance.width * (i - aGlobal.instance.viewportX)) / aGlobal.instance.viewportWidth;
    }

    public static String getString(String str) {
        try {
            return aGlobal.instance.context.getString(aAssetLoader.assetLoader.getString(str.replace('.', '_')));
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a */
    public static String encrypt(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec);
            return new String(Base64.encode(cipher.doFinal(str2.getBytes()), 2));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String md5(byte[] bArr, int i) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr, 0, i);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                if ((digest[i2] & 255) < 16) {
                    stringBuffer.append("0" + Integer.toHexString(digest[i2] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i2] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static aUtility getInstance() {
        return instance;
    }

    public static int transCoordWindowToGLViewY(int i) {
        return (aGlobal.instance.height * (i - aGlobal.instance.viewportY)) / aGlobal.instance.viewportHeight;
    }

    /* renamed from: b */
    public static String urlEncode(String str) {
        return URLEncoder.encode(str);
    }

    /* renamed from: b */
    public static String decrypt(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str2, 2)));
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static boolean shouldOffsetY() {
        return false;
    }

    /* renamed from: c */
    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if ((digest[i] & 255) < 16) {
                    stringBuffer.append("0" + Integer.toHexString(digest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) aGlobal.instance.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null) {
            return connectivityManager.getActiveNetworkInfo().isConnected();
        }
        return false;
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: f */
    public static String getDeviceID() {
        return ((TelephonyManager) aGlobal.getInstance().getContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static double getTimeStamp() {
        return System.currentTimeMillis() / 1000.0d;
    }

    public void a(String str, aBrowserOption abrowseroption) {
        aJSHandler ajshandler = new aJSHandler(this);
        ajshandler.b(str, true, abrowseroption);
        aGlobal.instance.dialogs.add(ajshandler);
    }

    public void addAlertAppliPage(String str, aUnknown2 aunknown2) {
        this.h = aunknown2;
        this.h.a = 0;
        aGlobal.instance.dialogs.add(new AlertRunner(this, getAppliPage(aSettings.getInstance().packageName, str)));
    }

    public void setPresentRenderer(aPresentRenderer apresentrenderer) {
        this.b = apresentrenderer;
    }

    public void setJSInterface(aJSInterfaceBase ajsinterfacebase) {
        this.i = ajsinterfacebase;
    }

    /* renamed from: b */
    public void addJSDialog(String str, aBrowserOption abrowseroption) {
        aJSHandler ajshandler = new aJSHandler(this);
        ajshandler.a(str, true, abrowseroption);
        aGlobal.instance.dialogs.add(ajshandler);
    }

    /* renamed from: c */
    protected abstract String getAppliPage(String str, String str2);

    public void displayURL(String str) {
        aGlobal.instance.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* renamed from: e */
    public String getUserID() {
        if (this.c == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(aGlobal.instance.context);
            this.c = decrypt(md5("uuid"), defaultSharedPreferences.getString(md5("uuid"), encrypt(md5("uuid"), (String) null)));
            if (this.c == null) {
                this.c = getRandomUUID();
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putString(md5("uuid"), encrypt(md5("uuid"), this.c));
                edit.commit();
            }
        }
        return this.c;
    }

    /* renamed from: e */
    public void addJSDialog(String str) {
        aJSHandler ajshandler = new aJSHandler(this);
        ajshandler.a(str, false);
        aGlobal.instance.dialogs.add(ajshandler);
    }

    public void addAssetGetter(String str) {
        aGlobal.instance.dialogs.add(new aAssetGetter(this, str));
    }

    /* renamed from: g */
    public abstract String getID();

    public String runFunction(String str) {
        if (this.webView != null) {
            this.webView.loadUrl("javascript:" + str);
            return null;
        }
        return null;
    }

    public void addButton(String str) {
        aGlobal.instance.dialogs.add(new ButtonBuilder(this, str));
    }

    public void addProgressDialog(String str) {
        addAlertCloser();
        aGlobal.instance.dialogs.add(new aProgessDialog(this, str));
    }

    public boolean i() {
        return this.d;
    }

    public void goBack() {
        if (this.webView != null) {
            this.webView.goBack();
        }
    }

    public void editClipboard(String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            setClipboardData(str);
        } else {
            setClipboard(str);
        }
    }

    public void addWebClient() {
        aGlobal.instance.dialogs.add(new aWebClient(this));
    }

    void setClipboardData(String str) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ((ClipboardManager) aGlobal.instance.context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(new ClipData("data", new String[]{"text/plain"}, new ClipData.Item(str)));
        }
    }

    void setClipboard(String str) {
        ((android.text.ClipboardManager) aGlobal.instance.context.getSystemService(Context.CLIPBOARD_SERVICE)).setText(str);
    }

    public boolean canGoBack() {
        if (this.webView != null) {
            return this.webView.canGoBack();
        }
        return false;
    }

    public String getURL() {
        if (this.webView != null) {
            return this.webView.getUrl();
        }
        return null;
    }

    public void n() {
        aGlobal.instance.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.g)));
    }

    public void addJSDialog() {
        addJSDialog(this.g);
    }

    public void addProgressDialog() {
        addAlertCloser();
        aGlobal.instance.dialogs.add(new aProgessDialog(this, ""));
    }

    public void addAlertCloser() {
        aGlobal.instance.dialogs.add(new aAlertCloser(this));
    }
}
