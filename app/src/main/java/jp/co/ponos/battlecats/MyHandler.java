package jp.co.ponos.battlecats;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.battlecats.c */
/* loaded from: classes.dex */
public class MyHandler extends Handler {
    final /* synthetic */ MyActivity activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyHandler(MyActivity myActivity) {
        this.activity = myActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getMessages(int i) {
        removeMessages(0);
        sendMessageDelayed(obtainMessage(0), i);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.activity.a();
    }
}
