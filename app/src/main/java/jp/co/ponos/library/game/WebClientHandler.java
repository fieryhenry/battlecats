package jp.co.ponos.library.game;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: jp.co.ponos.library.b.ai */
/* loaded from: classes.dex */
class WebClientHandler extends WebViewClient {
    boolean a;
    final /* synthetic */ aUtility b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebClientHandler(aUtility autility, boolean z) {
        this.b = autility;
        this.a = z;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (!this.a || aUtility.instance.b == null) {
            return;
        }
        aUtility.instance.b.b(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.loadData("", "text/html", "utf-8");
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.a || str.indexOf("ponos-api://function?") != 0) {
            if (this.a && (str.startsWith("http://www.ponos.co.jp/") || str.startsWith("http://www.ponos.net/") || str.startsWith("https://www.ponos.co.jp/") || str.startsWith("https://www.ponos.net/") || str.startsWith("file://android_asset/") || str.startsWith("data:text/html"))) {
                webView.getSettings().setJavaScriptEnabled(true);
            } else {
                webView.getSettings().setJavaScriptEnabled(false);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView.stopLoading();
        if (aUtility.instance.b != null) {
            aHashtable ahashtable = new aHashtable();
            for (String str2 : str.substring("ponos-api://function?".length()).split("&")) {
                String[] split = str2.split("=");
                if (split.length >= 2) {
                    ahashtable.put(split[0], split[1]);
                }
            }
            aUtility.instance.b.a(ahashtable);
            return false;
        }
        return false;
    }
}
