package jp.co.ponos.battlecats;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

//import jp.co.ponos.library.ads.aAd;
//import jp.co.ponos.library.facebook.aFacebook;
import jp.co.ponos.library.game.DialogFragment;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aSound;
import jp.co.ponos.library.game.aTextureRenderer;
import jp.co.ponos.library.purchase.Inapp;
import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.score.aScoreUploader;
import jp.co.ponos.library.twitter.aTwitter;

/* loaded from: classes.dex */
public class MyActivity extends Activity {
    MyHandler handler;
    MyFLSurfaceView b;
    FrameLayout c;
    boolean d = false;
    BroadcastReceiver e = new MyBroadcastReceiver(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i;
        if (A.a().isGameOpen()) {
            int i2 = 0;
            while (aGlobal.getInstance().getDialogs().size() > 0) {
                if (((DialogFragment) aGlobal.getInstance().getDialogs().get(0)).loadURL()) {
                    i = i2;
                } else {
                    removeDialog(i2);
                    showDialog(i2);
                    i = i2 + 1;
                }
                aGlobal.getInstance().getDialogs().remove(0);
                i2 = i;
            }
            this.b.requestRender();
            this.handler.getMessages(1000 / MySettings.getInstance().fps);
        }
    }

    public void a(int i) {
    }

    public void a(String str) {
    }

    public void a(String str, int i) {
        String a = MyUtility.getString("catfoodtapjoy_txt");
        if ((A.a().getSceneType() == SceneType.BATTLE && A.a().battleData[14] == 1) || A.a().getSceneType() == SceneType.ENDING) {
            return;
        }
        if (!(A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.STAMP) && i > 0) {
            A.a().catfood += i;
            MyUtility.getInstance().addButton(String.format(a, Integer.valueOf(i)));
            A.a().aSave();
        }
    }

    public void b(String str) {
    }

    public void b(String str, int i) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (MySettings.getInstance().facebookEnable) {
            //aFacebook.getInstance().a(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aGlobal.setInstance(new aGlobal());
        aGlobal.getInstance().a(this);
        MySettings.setInstance(new MySettings());
        MyAssetLoader.getDrawable(new MyAssetLoader());
        AppInstance.setInstance(new AppInstance());
        aGlobal.getInstance().a(new MyBackKeyController());
        aScoreUploader.createInstance();
        aTextureRenderer.createInstance();
        aSound.a();
        MyUtility.createInstance();
        MyUtility.getInstance().setJSInterface(new ExternalConnections());
        if (MySettings.getInstance().a) {
            //aAd.a();
            //aAd.b().c();
        }
        if (MySettings.getInstance().facebookEnable) {
            //aFacebook.setInstance();
        }
        if (MySettings.getInstance().h) {
            Inapp.a();
            Inapp.b().a(new MyPurchaseDelegate());
            Inapp.b().c();
        }
        if (MySettings.getInstance().i) {
            aTwitter.createInstance();
        }
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
        requestWindowFeature(1);
        setVolumeControlStream(3);
        this.handler = new MyHandler(this);
        aGlobal.getInstance().a(this.handler);
        this.c = new FrameLayout(this);
        aGlobal.getInstance().a(this.c);
        this.b = new MyFLSurfaceView(this);
        this.b.setFocusableInTouchMode(true);
        this.b.setRenderMode(0);
        this.c.addView(this.b);
        setContentView(this.c);
        try {
            registerReceiver(this.e, new IntentFilter("android.intent.action.USER_PRESENT"));
        } catch (RuntimeException e) {
        }
        A.a().onCreate();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (aGlobal.getInstance().getDialogs().size() > 0) {
            return ((DialogFragment) aGlobal.getInstance().getDialogs().get(0)).b().create();
        }
        return null;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.e);
        if (MySettings.getInstance().h) {
            Inapp.b().f();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            switch (i) {
                case 4:
                    if (aGlobal.getInstance().f().a()) {
                        return true;
                    }
                    break;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        A.a().setIsGameOpen(false);
        A.a().d();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        A.a().b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().addFlags(1024);
        if (((KeyguardManager) aGlobal.getInstance().getContext().getSystemService(Context.KEYGUARD_SERVICE)).inKeyguardRestrictedInputMode()) {
            this.d = true;
            return;
        }
        this.d = false;
        A.a().setIsGameOpen(true);
        this.handler.getMessages(0);
        A.a().onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (MySettings.getInstance().h) {
            Inapp.b().d();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (MySettings.getInstance().h) {
            Inapp.b().e();
        }
    }

}
