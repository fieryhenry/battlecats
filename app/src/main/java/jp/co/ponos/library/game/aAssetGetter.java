package jp.co.ponos.library.game;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.al */
/* loaded from: classes.dex */
public class aAssetGetter extends DialogFragment {
    String a;
    final /* synthetic */ aUtility b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aAssetGetter(aUtility autility, String str) {
        this.b = autility;
        if (str.startsWith("http://") || str.startsWith("https://")) {
            this.a = str;
        } else {
            this.a = "file:///android_asset/" + str;
        }
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        if (this.b.webView != null) {
            this.b.webView.loadUrl(this.a);
            return true;
        }
        return true;
    }
}
