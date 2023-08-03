package jp.co.ponos.library.game;

import android.app.ProgressDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.av */
/* loaded from: classes.dex */
public class aProgessDialog extends DialogFragment {
    String a;
    final /* synthetic */ aUtility b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aProgessDialog(aUtility autility, String str) {
        this.b = autility;
        this.a = str;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        if (this.b.k != null) {
            this.b.k.dismiss();
        }
        this.b.k = new ProgressDialog(aGlobal.instance.context);
        this.b.k.setMessage(this.a);
        this.b.k.setProgressStyle(0);
        this.b.k.setCancelable(false);
        this.b.k.show();
        return true;
    }
}
