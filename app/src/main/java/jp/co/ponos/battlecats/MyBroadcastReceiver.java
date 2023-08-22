package jp.co.ponos.battlecats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MyBroadcastReceiver extends BroadcastReceiver {
   // $FF: synthetic field
   final MyActivity myActivity;

   MyBroadcastReceiver(MyActivity var1) {
      this.myActivity = var1;
   }
   @Override
   public void onReceive(Context context, Intent intent) {
      if (this.myActivity.d) {
         this.myActivity.d = false;
         A.a().setIsGameOpen(true);
         this.myActivity.handler.getMessages(0);
         A.a().onResume();
      }

   }
}
