package jp.co.ponos.library.game;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.aj */
/* loaded from: classes.dex */
public class AlertRunner extends DialogFragment {
    String a;
    final /* synthetic */ aUtility b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertRunner(aUtility autility, String str) {
        this.b = autility;
        this.a = str;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        new aAlertRequestHandler(this).execute(this.a);
        return true;
    }
}
