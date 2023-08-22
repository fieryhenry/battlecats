package jp.co.ponos.battlecats;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import jp.co.ponos.library.game.Global;

class MyFLSurfaceView extends GLSurfaceView {
   MyGLSurfaceRenderer a;

   MyFLSurfaceView(Context var1) {
      super(var1);
      this.a = new MyGLSurfaceRenderer(var1);
      this.setRenderer(this.a);
   }
   @Override
   public boolean onTouchEvent(MotionEvent var1) {
      if (Global.getInstance().getViewportWidth() != 0) {
         int var2;
         switch (var1.getAction() & 255) {
            case 0:
               var2 = var1.getActionIndex();
               A.a().onTouchEvent(0, (int)var1.getX(var2), (int)var1.getY(var2), var1.getPointerId(var2));
               break;
            case 1:
               var2 = var1.getActionIndex();
               A.a().onTouchEvent(2, (int)var1.getX(var2), (int)var1.getY(var2), var1.getPointerId(var2));
               break;
            case 2:
               var2 = var1.getActionIndex();
               A.a().onTouchEvent(1, (int)var1.getX(var2), (int)var1.getY(var2), var1.getPointerId(var2));
            case 3:
            case 4:
            default:
               break;
            case 5:
               var2 = var1.getActionIndex();
               A.a().onTouchEvent(0, (int)var1.getX(var2), (int)var1.getY(var2), var1.getPointerId(var2));
               break;
            case 6:
               var2 = var1.getActionIndex();
               A.a().onTouchEvent(2, (int)var1.getX(var2), (int)var1.getY(var2), var1.getPointerId(var2));
         }
      }

      return true;
   }
}
