package jp.co.ponos.library.game;

import android.content.Context;
import android.widget.ImageButton;

/* renamed from: jp.co.ponos.library.b.au */
/* loaded from: classes.dex */
class aJSImageButton extends ImageButton {
    int a;
    final /* synthetic */ aJSHandler b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aJSImageButton(aJSHandler ajshandler, Context context, int i) {
        super(context);
        this.b = ajshandler;
        this.a = i;
    }
}
