package jp.co.ponos.battlecats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: jp.co.ponos.battlecats.b */
/* loaded from: classes.dex */
class MyBroadcastReceiver extends BroadcastReceiver {
    final /* synthetic */ MyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyBroadcastReceiver(MyActivity myActivity) {
        this.a = myActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.a.d) {
            this.a.d = false;
            A.a().setIsGameOpen(true);
            this.a.handler.getMessages(0);
            A.a().onResume();
        }
    }
}
