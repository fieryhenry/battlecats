package jp.co.ponos.library.game;

import android.content.Context;
import android.widget.Button;

/* renamed from: jp.co.ponos.library.b.at */
/* loaded from: classes.dex */
class aJSButton extends Button {
    int a;
    final /* synthetic */ aJSHandler b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aJSButton(aJSHandler ajshandler, Context context, int i) {
        super(context);
        this.b = ajshandler;
        this.a = i;
    }
}
