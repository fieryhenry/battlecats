package jp.co.ponos.library.game;

import android.content.DialogInterface;

/* renamed from: jp.co.ponos.library.b.an */
/* loaded from: classes.dex */
class ButtonEventHandler implements DialogInterface.OnClickListener {
    final /* synthetic */ ButtonBuilder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ButtonEventHandler(ButtonBuilder buttonBuilder) {
        this.a = buttonBuilder;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d.a = 0;
    }
}
