package jp.co.ponos.library.score;

import jp.co.ponos.library.game.DialogFragment;

/* renamed from: jp.co.ponos.library.d.b */
/* loaded from: classes.dex */
class aScoreDialog extends DialogFragment {
    String a;
    String b;
    String c;
    int[] d;
    int[] e;
    final /* synthetic */ aScoreUploader f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aScoreDialog(aScoreUploader ascoreuploader, String str, String str2, String str3, int[] iArr, int[] iArr2) {
        this.f = ascoreuploader;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        new aScoreRequest(this).execute(this.a, this.b, this.c, this.d, this.e);
        return true;
    }
}
