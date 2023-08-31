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
   public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
      int width = 960;
      Global.getInstance().setGL10(gl10);
      int var4;
      var4 = ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth() * 640 / ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight();
      if (var4 >= 960) {
         if (var4 > 1136) {
            width = 1136;
         } else {
            width = var4;
         }
      }
      Global.getInstance().setWidthHeight(width, 640, ((MyActivity) Global.getInstance().getContext()).surfaceView.getWidth(), ((MyActivity) Global.getInstance().getContext()).surfaceView.getHeight());

      TextureRenderer.getInstance().setupGL();
      for (Object o : TexturesLoader.getInstance().getTextures()) {
         ((Texture) o).loadUnknown();
      }
   }
}
