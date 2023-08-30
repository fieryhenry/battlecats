package jp.co.ponos.battlecats;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.FrameLayout;
//import com.tapjoy.ab;
//import com.tapjoy.ac;

import jp.co.ponos.library.game.BackKeyController;
import jp.co.ponos.library.game.ButtonBuilder;
import jp.co.ponos.library.game.DialogFragment;
import jp.co.ponos.library.game.JSInterfaceBase;
import jp.co.ponos.library.game.MyApplicationBase;
import jp.co.ponos.library.game.Sound;
import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.TexturesLoader;
import jp.co.ponos.library.game.TextureRenderer;
import jp.co.ponos.library.purchase.w;
import jp.co.ponos.library.purchase.PurchaseDelegate;
import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.twitter.Twitter;

public class MyActivity extends Activity { //implements ab, ac, com.tapjoy.q {
   Handler otherHandler;
   MyHandler handler;
   MyFLSurfaceView surfaceView;
   FrameLayout frameLayout;
   boolean d = false;
   BroadcastReceiver broadcastReceiver = new MyBroadcastReceiver(this);

   void a() {
      if (A.a().isGameOpen()) {
         for(int var1 = 0; Global.getInstance().getDialogs().size() > 0; Global.getInstance().getDialogs().remove(0)) {
            if (!((DialogFragment) Global.getInstance().getDialogs().get(0)).loadURL()) {
               this.removeDialog(var1);
               this.showDialog(var1);
               ++var1;
            }
         }

         this.surfaceView.requestRender();
         this.handler.getMessages(1000 / MySettings.getInstance().fps);
      }

   }

   public void a(String var1, int var2) {
      this.otherHandler.post(new TapJoyCatfood(this, var2));
   }

   public void b(String var1) {
   }

   public void b(String var1, int var2) {
   }
   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (MySettings.getInstance().f) {
         //jp.co.ponos.library.c.a.b().a(var1, var2, var3);
      }

   }
   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      Global.setInstance(new Global());
      Global.getInstance().setContext((Context)this);
      MySettings.setInstance(new MySettings());
      l.setInstance(new l());
      AppInstance.setInstance((MyApplicationBase)(new AppInstance()));
      Global.getInstance().setBackKeyController((BackKeyController)(new MyBackKeyController()));
      jp.co.ponos.library.score.a.a();
      TextureRenderer.createInstance();
      Sound.createInstance();
      TexturesLoader.createInstance();
      MyUtility.createInstance();
      MyUtility.getInstance().setJSInterface((JSInterfaceBase)(new h()));
      if (MySettings.getInstance().a) {
         //jp.co.ponos.library.a.a.a();
         //jp.co.ponos.library.a.a.b().c();
      }

      if (MySettings.getInstance().f) {
         //jp.co.ponos.library.c.a.a();
      }

      if (MySettings.getInstance().h) {
         w.a();
         w.b().a((PurchaseDelegate)(new MyPurchaseDelegate()));
         w.b().c();
      }

      if (MySettings.getInstance().i) {
         Twitter.createInstance();
      }

      this.getWindow().addFlags(1024);
      this.getWindow().addFlags(128);
      this.requestWindowFeature(1);
      this.setVolumeControlStream(3);
      this.otherHandler = new Handler();
      this.handler = new MyHandler(this);
      Global.getInstance().setHandler((Handler)this.handler);
      this.frameLayout = new FrameLayout(this);
      Global.getInstance().setFrameLayout(this.frameLayout);
      this.surfaceView = new MyFLSurfaceView(this);
      this.surfaceView.setFocusableInTouchMode(true);
      this.surfaceView.setRenderMode(0);
      this.frameLayout.addView(this.surfaceView);
      this.setContentView(this.frameLayout);
      IntentFilter var3 = new IntentFilter("android.intent.action.USER_PRESENT");

      try {
         this.registerReceiver(this.broadcastReceiver, var3);
      } catch (RuntimeException var2) {
      }

      //com.tapjoy.g.a(this, "44779599-c0d7-458a-9bd6-c743581e8bf7", "qswMlwAS3AaxYQ54v2pJ");
      //com.tapjoy.g.a().a((ab)this);
      //com.tapjoy.g.a().a((com.tapjoy.q)this);
      A.a().onCreate();

      if (MySettings.getInstance().dev) { // dev mode (not in original game)
         this.dev();
      }

   }
   public void dev() {
      A.a().catfood = 999999;
      A.a().xp = 99999999;
      A.a().battleItems = new int[]{999, 999, 999, 999, 999, 999};
      A.a().baseSpecialSkillLevels = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
   }
   @Override
   protected Dialog onCreateDialog(int var1) {
      AlertDialog var2;
      if (Global.getInstance().getDialogs().size() > 0 && ((ButtonBuilder)Global.getInstance().getDialogs().get(0)).b() != null) {
         var2 = ((DialogFragment) Global.getInstance().getDialogs().get(0)).b().create();
      } else {
         var2 = null;
      }

      return var2;
   }
   @Override
   public void onDestroy() {
      super.onDestroy();
      this.unregisterReceiver(this.broadcastReceiver);
      if (MySettings.getInstance().h) {
         w.b().f();
      }

   }
   @Override
   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if (var2.getRepeatCount() == 0) {
         switch (var1) {
            case 4:
               if (Global.getInstance().f().isBackPressValid()) {
                  var3 = true;
                  return var3;
               }
         }
      }

      var3 = super.onKeyDown(var1, var2);
      return var3;
   }
   @Override
   public void onPause() {
      super.onPause();
      this.surfaceView.onPause();
      A.a().setIsGameOpen(false);
      A.a().onPause();
   }
   @Override
   public void onRestart() {
      super.onRestart();
      //com.tapjoy.g.a().a((ab)this);
      //com.tapjoy.g.a().a((com.tapjoy.q)this);
      A.a().onRestart();
   }
   @Override
   public void onResume() {
      super.onResume();
      this.surfaceView.onResume();
      this.getWindow().addFlags(1024);
      if (!((KeyguardManager) Global.getInstance().getContext().getSystemService(Context.KEYGUARD_SERVICE)).inKeyguardRestrictedInputMode()) {
         this.d = false;
         A.a().setIsGameOpen(true);
         this.handler.getMessages(0);
         A.a().onResume();
      } else {
         this.d = true;
      }

   }
   @Override
   public void onStart() {
      super.onStart();
      if (MySettings.getInstance().h) {
         w.b().d();
      }

   }
   @Override
   public void onStop() {
      super.onStop();
      if (MySettings.getInstance().h) {
         w.b().e();
      }

   }
}
