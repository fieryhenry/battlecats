package jp.co.ponos.library.game;

import android.view.View;

/* renamed from: jp.co.ponos.library.b.as */
/* loaded from: classes.dex */
class WebViewClickHandler2 implements View.OnClickListener {
    final /* synthetic */ aJSHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewClickHandler2(aJSHandler ajshandler) {
        this.a = ajshandler;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aUtility autility;
        aUtility autility2;
        autility = this.a.e;
        if (autility.b != null) {
            autility2 = this.a.e;
            autility2.b.a(((aJSImageButton) view).a);
        }
    }
}
