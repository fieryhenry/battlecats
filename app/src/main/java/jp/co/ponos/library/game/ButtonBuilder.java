package jp.co.ponos.library.game;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.am */
/* loaded from: classes.dex */
public class ButtonBuilder extends DialogFragment {
    String a;
    String[] b = null;
    int c;
    aUnknown2 d;
    final /* synthetic */ aUtility e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ButtonBuilder(aUtility autility, String str) {
        this.e = autility;
        this.a = str;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        return false;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public AlertDialog.Builder b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(aGlobal.instance.context);
        if (this.b == null) {
            builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton(this.b[0], new ButtonEventHandler(this));
            if (this.c >= 2) {
                builder.setNeutralButton(this.b[1], new ButtonEventHandler2(this));
            }
            if (this.c >= 3) {
                builder.setNegativeButton(this.b[2], new ButtonEventHandler3(this));
            }
        }
        builder.setMessage(this.a);
        builder.setCancelable(false);
        return builder;
    }
}
