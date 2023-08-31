package jp.co.ponos.library.game;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;

import java.util.Random;
import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class Global {
   static Global instance;
   Random b = new Random();
   int surfaceWidth;
   int surfaceHeight;
   int viewportX;
   int viewportY;
   int viewportWidth;
   int viewportHeight;
   int width;
   int height;
   Handler handler;
   Context context;
   boolean isGameOpen;
   FrameLayout frameLayout;
   GL10 gl10;
   Vector dialogs = new Vector();
   BackKeyController q;
   BackKeyController r;

   public static Global getInstance() {
      return instance;
   }

   public static void setInstance(Global var0) {
      instance = var0;
   }

   public void setWidthHeight(int screenWidth, int screenHeight, int surfaceWidth, int surfaceHeight) {
      this.surfaceWidth = surfaceWidth;
      this.surfaceHeight = surfaceHeight;
      this.width = screenWidth;
      this.height = screenHeight;
      if (this.surfaceWidth * screenHeight / screenWidth <= this.surfaceHeight) {
         this.viewportWidth = this.surfaceWidth;
         this.viewportHeight = this.surfaceWidth * screenHeight / screenWidth;
         this.viewportX = 0;
         this.viewportY = (this.surfaceHeight - this.viewportHeight) / 2;
      } else {
         this.viewportWidth = this.surfaceHeight * screenWidth / screenHeight;
         this.viewportHeight = this.surfaceHeight;
         this.viewportX = (this.surfaceWidth - this.viewportWidth) / 2;
         this.viewportY = 0;
      }

   }

   public void setContext(Context var1) {
      this.context = var1;
   }

   public void setHandler(Handler var1) {
      this.handler = var1;
   }

   public void setFrameLayout(FrameLayout var1) {
      this.frameLayout = var1;
   }

   public void setGL10(GL10 var1) {
      this.gl10 = var1;
   }

   public void setBackKeyController(BackKeyController var1) {
      this.r = var1;
   }

   public int getViewportWidth() {
      return this.viewportWidth;
   }

   public void setBackKeyController2(BackKeyController var1) {
      this.q = var1;
   }

   public Context getContext() {
      return this.context;
   }

   public FrameLayout getFrameLayout() {
      return this.frameLayout;
   }

   public Vector getDialogs() {
      return this.dialogs;
   }

   public BackKeyController f() {
      BackKeyController var1;
      if (this.q == null) {
         var1 = this.r;
      } else {
         var1 = this.q;
      }

      return var1;
   }
}
