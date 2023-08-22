package jp.co.ponos.battlecats;

import android.os.Handler;
import android.os.Message;

class MyHandler extends Handler {
   // $FF: synthetic field
   final MyActivity myActivity;

   MyHandler(MyActivity activity) {
      this.myActivity = activity;
   }

   void getMessages(int var1) {
      this.removeMessages(0);
      this.sendMessageDelayed(this.obtainMessage(0), (long)var1);
   }
   @Override
   public void handleMessage(Message var1) {
      this.myActivity.a();
   }
}
