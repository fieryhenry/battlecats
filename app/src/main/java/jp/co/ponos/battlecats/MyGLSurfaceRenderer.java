package jp.co.ponos.battlecats;

import android.content.Context;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aTextureRenderer;

/* renamed from: jp.co.ponos.battlecats.j */
/* loaded from: classes.dex */
class MyGLSurfaceRenderer implements GLSurfaceView.Renderer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MyGLSurfaceRenderer(Context context) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (A.a().isGameOpen()) {
            A.a().onProcess();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        aGlobal.getInstance().a(gl10);
        if (MySettings.getInstance().j) {
            int width = (((MyActivity) aGlobal.getInstance().getContext()).b.getWidth() * 640) / ((MyActivity) aGlobal.getInstance().getContext()).b.getHeight();
            aGlobal.getInstance().a(width >= 960 ? width > 1136 ? 1136 : width : 960, 640, ((MyActivity) aGlobal.getInstance().getContext()).b.getWidth(), ((MyActivity) aGlobal.getInstance().getContext()).b.getHeight());
        } else {
            int width2 = (((MyActivity) aGlobal.getInstance().getContext()).b.getWidth() * 640) / ((MyActivity) aGlobal.getInstance().getContext()).b.getHeight();
            aGlobal.getInstance().a(width2 >= 960 ? width2 > 1136 ? 1136 : width2 : 960, 640, ((MyActivity) aGlobal.getInstance().getContext()).b.getWidth(), ((MyActivity) aGlobal.getInstance().getContext()).b.getHeight());
        }
        aTextureRenderer.getInstance().setupGL();
    }
}
