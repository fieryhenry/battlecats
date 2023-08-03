package jp.co.ponos.battlecats;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import jp.co.ponos.library.game.aGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.battlecats.n */
/* loaded from: classes.dex */
public class MyFLSurfaceView extends GLSurfaceView {
    MyGLSurfaceRenderer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyFLSurfaceView(Context context) {
        super(context);
        this.a = new MyGLSurfaceRenderer(context);
        setRenderer(this.a);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (aGlobal.getInstance().b() != 0) {
            if (motionEvent.getAction() == 0) {

            }
            switch (motionEvent.getAction() & 255) {
                case MotionEvent.ACTION_DOWN: // down
                    int actionIndex = motionEvent.getActionIndex();
                    A.a().onTouchEvent(0, (int) motionEvent.getX(actionIndex), (int) motionEvent.getY(actionIndex), motionEvent.getPointerId(actionIndex));
                    break;
                case MotionEvent.ACTION_UP: // up
                    int actionIndex2 = motionEvent.getActionIndex();
                    A.a().onTouchEvent(2, (int) motionEvent.getX(actionIndex2), (int) motionEvent.getY(actionIndex2), motionEvent.getPointerId(actionIndex2));
                    break;
                case MotionEvent.ACTION_MOVE: // move
                    int actionIndex3 = motionEvent.getActionIndex();
                    A.a().onTouchEvent(1, (int) motionEvent.getX(actionIndex3), (int) motionEvent.getY(actionIndex3), motionEvent.getPointerId(actionIndex3));
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    int actionIndex4 = motionEvent.getActionIndex();
                    A.a().onTouchEvent(0, (int) motionEvent.getX(actionIndex4), (int) motionEvent.getY(actionIndex4), motionEvent.getPointerId(actionIndex4));
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    int actionIndex5 = motionEvent.getActionIndex();
                    A.a().onTouchEvent(2, (int) motionEvent.getX(actionIndex5), (int) motionEvent.getY(actionIndex5), motionEvent.getPointerId(actionIndex5));
                    break;
            }
        }
        return true;
    }
}
