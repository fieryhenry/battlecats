package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aMath;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.battlecats.p */
/* loaded from: classes.dex */
public class Zoom {
    boolean isZooming;
    boolean[] isPointerDown = new boolean[2];
    int[] xPos = new int[2];
    int[] yPos = new int[2];
    int[] pointerIDs = new int[2];
    int[] xPos2 = new int[2];
    int[] yPos2 = new int[2];
    int endZoom;
    int startZoom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zoom() {
        reset();
    }

    int getLength(boolean[] zArr) {
        return zArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.isZooming = false;
        for (int i = 0; i < getLength(this.isPointerDown); i++) {
            this.isPointerDown[i] = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTouchEvent(int eventID, int xPos, int yPos, int pointerID) {
        int pointerIndex = 0;
        switch (eventID) {
            case 0: // down
                for (int pointerIndex1 = 0; pointerIndex1 < getLength(this.isPointerDown); pointerIndex1++) {
                    if (this.isPointerDown[pointerIndex1] && this.pointerIDs[pointerIndex1] == pointerID) {
                        this.isPointerDown[pointerIndex1] = false;
                    }
                }
                while (pointerIndex < getLength(this.isPointerDown)) {
                    if (!this.isPointerDown[pointerIndex]) {
                        this.isPointerDown[pointerIndex] = true;
                        this.xPos[pointerIndex] = xPos;
                        this.yPos[pointerIndex] = yPos;
                        this.pointerIDs[pointerIndex] = pointerID;
                        return;
                    }
                    pointerIndex++;
                }
                return;
            case 1: // move
                break;
            case 2: // up
                for (int i7 = 0; i7 < getLength(this.isPointerDown); i7++) {
                    if (this.isPointerDown[i7] && this.pointerIDs[i7] == pointerID) {
                        this.isPointerDown[i7] = false;
                    }
                }
                return;
            default:
                return;
        }
        while (pointerIndex < getLength(this.isPointerDown)) {
            if (this.isPointerDown[pointerIndex] && this.pointerIDs[pointerIndex] == pointerID) {
                this.xPos[pointerIndex] = xPos;
                this.yPos[pointerIndex] = yPos;
                return;
            }
            pointerIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zoom() {
        if (this.isZooming) {
            if (this.isPointerDown[0] && this.isPointerDown[1]) {
                this.startZoom = this.endZoom;
                this.endZoom = (int) aMath.sqrt(aMath.pow(this.xPos[0] - this.xPos[1], 2.0f) + aMath.pow(this.yPos[0] - this.yPos[1], 2.0f));
                return;
            }
            this.isZooming = false;
            boolean[] zArr = this.isPointerDown;
            this.isPointerDown[1] = false;
            zArr[0] = false;
        } else if (this.isPointerDown[0] && this.isPointerDown[1]) {
            this.isZooming = true;
            for (int i = 0; i < getLength(this.isPointerDown); i++) {
                this.xPos2[i] = this.xPos[i];
                this.yPos2[i] = this.yPos[i];
            }
            int sqrt = (int) aMath.sqrt(aMath.pow(this.xPos[0] - this.xPos[1], 2.0f) + aMath.pow(this.yPos[0] - this.yPos[1], 2.0f));
            this.startZoom = sqrt;
            this.endZoom = sqrt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isZooming() {
        return this.isZooming;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getZoomFactor() {
        if (this.isZooming) {
            return this.endZoom - this.startZoom;
        }
        return 0;
    }
}
