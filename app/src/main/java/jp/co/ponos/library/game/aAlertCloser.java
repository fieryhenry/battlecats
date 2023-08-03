package jp.co.ponos.library.game;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.ag */
/* loaded from: classes.dex */
public class aAlertCloser extends DialogFragment {
    final /* synthetic */ aUtility a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aAlertCloser(aUtility autility) {
        this.a = autility;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        if (this.a.k != null) {
            this.a.k.dismiss();
            return true;
        }
        return true;
    }
}
