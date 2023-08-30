package jp.co.ponos.battlecats;

import android.content.Context;
import android.opengl.GLSurfaceView;

import java.util.Iterator;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.TexturesLoader;
import jp.co.ponos.library.game.Texture;
import jp.co.ponos.library.game.TextureRenderer;

class MyGLSurfaceRenderer implements GLSurfaceView.Renderer {
   MyGLSurfaceRenderer(Context var1) {
   }
   @Override
   public void onDrawFrame(GL10 var1) {
      if (A.a().isGameOpen()) {
         A.a().onProcess();
      }

   }
   @Override
   public void onSurfaceChanged(GL10 var1, int var2, int var3) {
   }
   @Override
   public void onSurfaceCreated(GL10 var1, EGLConfig var2) {
      int var3 = 960;
      Global.getInstance().setGL10(var1);
      int var4;
      if (!MySettings.getInstance().j) {
         var4 = ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth() * 640 / ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight();
         if (var4 >= 960) {
            if (var4 > 1136) {
               var3 = 1136;
            } else {
               var3 = var4;
            }
         }

         Global.getInstance().a(var3, 640, ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth(), ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight());
      } else {
         var4 = ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth() * 640 / ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight();
         if (var4 >= 960) {
            if (var4 > 1136) {
               var3 = 1136;
            } else {
               var3 = var4;
            }
         }

         Global.getInstance().a(var3, 640, ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth(), ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight());
      }

      TextureRenderer.getInstance().setupGL();
      Iterator it = TexturesLoader.getInstance().getTextures().iterator();
      while (it.hasNext()) {
         ((Texture) it.next()).loadUnknown();
      }
   }
}
