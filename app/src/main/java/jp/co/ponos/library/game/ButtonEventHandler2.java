package jp.co.ponos.library.game;

import android.content.DialogInterface;

/* renamed from: jp.co.ponos.library.b.ao */
/* loaded from: classes.dex */
class ButtonEventHandler2 implements DialogInterface.OnClickListener {
    final /* synthetic */ ButtonBuilder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ButtonEventHandler2(ButtonBuilder buttonBuilder) {
        this.a = buttonBuilder;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d.a = 1;
    }
}
