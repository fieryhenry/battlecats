package jp.co.ponos.library.game;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.af */
/* loaded from: classes.dex */
public class aWebClient extends DialogFragment {
    final /* synthetic */ aUtility a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aWebClient(aUtility autility) {
        this.a = autility;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        if (this.a.webView != null) {
            this.a.webView.stopLoading();
            this.a.webView.setWebChromeClient(null);
            this.a.webView.setWebViewClient(null);
            this.a.webView.destroy();
            this.a.webView = null;
            aGlobal.instance.n.removeView(this.a.f);
            aGlobal.instance.b(null);
            ((Activity) aGlobal.instance.getContext()).getWindow().addFlags(1024);
            if (this.a.b != null) {
                this.a.b.a();
            }
            this.a.d = false;
            return true;
        }
        return true;
    }
}
