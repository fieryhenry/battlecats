package jp.co.ponos.library.game;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/* renamed from: jp.co.ponos.library.b.f */
/* loaded from: classes.dex */
public class aTextureRenderer {
    static aTextureRenderer textureRenderer;
    int imageOrientation;
    short[] vertexCoordinatesS = new short[32];
    float[] vertexCoordinatesF = new float[32];
    int[] d = new int[64];
    int[] vertexCoordinatesI = new int[8];
    ShortBuffer shortBuffer;
    FloatBuffer floatBuffer;
    IntBuffer h;
    IntBuffer intBuffer;
    float zoomFactor;
    int xOffsetI;
    int yOffsetI;
    float xOffset;
    float yOffset;
    int blendSFactor;
    int blendDFactor;
    AnimTransformer animTransformer;
    int red;
    int green;
    int blue;
    int alpha;
    int imageRed;
    int imageGreen;
    int imageBlue;
    int imageAlpha;
    int additiveBlending;

    public static void createInstance() {
        textureRenderer = new aTextureRenderer();
    }

    public static aTextureRenderer getInstance() {
        return textureRenderer;
    }

    public void updateProjection(float zoom) {
        this.zoomFactor = zoom;
        aGlobal.instance.gl10.glMatrixMode(GL10.GL_PROJECTION);
        aGlobal.instance.gl10.glLoadIdentity();
        aGlobal.instance.gl10.glOrthof(0.0f, (aGlobal.instance.width * this.zoomFactor) / 100.0f, (aGlobal.instance.height * this.zoomFactor) / 100.0f, 0.0f, -1.0f, 1.0f);
        aGlobal.instance.gl10.glMatrixMode(GL10.GL_MODELVIEW);
        aGlobal.instance.gl10.glLoadIdentity();
    }

    public void fillRect(float x, float y, float width, float height) {
        float x1 = this.xOffset + x;
        float y1 = this.yOffset + y;
        float x2 = x1 + width;
        float y2 = y1 + height;

        this.vertexCoordinatesF[0] = x1;
        this.vertexCoordinatesF[1] = y1;
        this.vertexCoordinatesF[2] = x1;
        this.vertexCoordinatesF[3] = y2;
        this.vertexCoordinatesF[4] = x2;
        this.vertexCoordinatesF[5] = y1;
        this.vertexCoordinatesF[6] = x2;
        this.vertexCoordinatesF[7] = y2;

        applyTransformationToCoordinates(this.vertexCoordinatesF, 4);
        this.floatBuffer.clear();
        this.floatBuffer.put(this.vertexCoordinatesF);
        this.floatBuffer.position(0);

        aGlobal.instance.gl10.glDisable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.gl10.glVertexPointer(2, 5126, 0, this.floatBuffer);
        aGlobal.instance.gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }

    public void setBlendMode(int blendMode) {
        switch (blendMode) {
            case 0:
                this.blendSFactor = GL10.GL_SRC_ALPHA;
                this.blendDFactor = GL10.GL_ONE_MINUS_SRC_ALPHA;
                break;
            case 1:
                this.blendSFactor = GL10.GL_SRC_ALPHA;
                this.blendDFactor = GL10.GL_ONE;
                break;
            case 3:
                this.blendSFactor = GL10.GL_ZERO;
                this.blendDFactor = GL10.GL_SRC_COLOR;
                break;
            case 4:
                this.blendSFactor = GL10.GL_ONE_MINUS_DST_COLOR;
                this.blendDFactor = GL10.GL_ONE;
                break;
            default:
                break;
        }
    }

    public void setOffset(int x, int y) {
        this.xOffsetI = x;
        this.yOffsetI = y;
        this.xOffset = x;
        this.yOffset = y;
    }

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }

    public void setColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public void drawScaledImagef(aTexture atexture, float f, float f2, float f3, float f4) {
        drawScaledImagef(atexture, f, f2, f3, f4, 0, 0, atexture.imgWidth, atexture.imgHeight);
    }

    public void drawScaledImagef(aTexture atexture, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, int left, int top, int width, int height) {
        float x1Offset = xOffset + x1;
        float y1Offset = yOffset + y1;
        float x2Offset = xOffset + x2;
        float y2Offset = yOffset + y2;
        float x3Offset = xOffset + x3;
        float y3Offset = yOffset + y3;
        float x4Offset = xOffset + x4;
        float y4Offset = yOffset + y4;

        this.vertexCoordinatesF[0] = x1Offset;
        this.vertexCoordinatesF[1] = y1Offset;
        this.vertexCoordinatesF[2] = x2Offset;
        this.vertexCoordinatesF[3] = y2Offset;
        this.vertexCoordinatesF[4] = x4Offset;
        this.vertexCoordinatesF[5] = y4Offset;
        this.vertexCoordinatesF[6] = x3Offset;
        this.vertexCoordinatesF[7] = y3Offset;

        applyTransformationToCoordinates(this.vertexCoordinatesF, 4);

        this.floatBuffer.clear();
        this.floatBuffer.put(this.vertexCoordinatesF);
        this.floatBuffer.position(0);

        this.vertexCoordinatesI[0] = left;
        this.vertexCoordinatesI[1] = top;
        this.vertexCoordinatesI[2] = left;
        this.vertexCoordinatesI[3] = top + height;
        this.vertexCoordinatesI[4] = left + width;
        this.vertexCoordinatesI[5] = top;
        this.vertexCoordinatesI[6] = left + width;
        this.vertexCoordinatesI[7] = top + height;

        for (int i = 0; i < 4; i++) {
            this.vertexCoordinatesI[i * 2] = (65536 * this.vertexCoordinatesI[i * 2]) / atexture.pow2Width;
            this.vertexCoordinatesI[(i * 2) + 1] = (65536 * this.vertexCoordinatesI[(i * 2) + 1]) / atexture.pow2Height;
        }

        this.intBuffer.clear();
        this.intBuffer.put(this.vertexCoordinatesI);
        this.intBuffer.position(0);

        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 260);
        }

        aGlobal.instance.gl10.glEnable(GL10.GL_TEXTURE_2D);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.gl10.glBlendFunc(1, 771);
            aGlobal.instance.gl10.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.gl10.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, atexture.textureID);
        aGlobal.instance.gl10.glVertexPointer(2, 5126, 0, this.floatBuffer);
        aGlobal.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
        aGlobal.instance.gl10.glDrawArrays(5, 0, 4);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void drawScaledImagef(aTexture atexture, float xPos, float yPos, float width, float height, int rectID) {
        drawScaledImagef(atexture, xPos, yPos, width, height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void drawScaledImagef(aTexture atexture, float xPos, float yPos, float width, float height, int xBound, int yBound, int widthBound, int heightBound) {
        float xOffset = this.xOffset + xPos;
        float yOffset = this.yOffset + yPos;

        if (this.imageOrientation == 1) {
            this.vertexCoordinatesF[0] = xOffset + width;
            this.vertexCoordinatesF[1] = yOffset;
            this.vertexCoordinatesF[2] = xOffset + width;
            this.vertexCoordinatesF[3] = yOffset + height;
            this.vertexCoordinatesF[4] = xOffset;
            this.vertexCoordinatesF[5] = yOffset;
            this.vertexCoordinatesF[6] = xOffset;
            this.vertexCoordinatesF[7] = yOffset + height;
        } else if (this.imageOrientation == 2) {
            this.vertexCoordinatesF[0] = xOffset;
            this.vertexCoordinatesF[1] = yOffset + height;
            this.vertexCoordinatesF[2] = xOffset;
            this.vertexCoordinatesF[3] = yOffset;
            this.vertexCoordinatesF[4] = xOffset + width;
            this.vertexCoordinatesF[5] = yOffset + height;
            this.vertexCoordinatesF[6] = xOffset + width;
            this.vertexCoordinatesF[7] = yOffset;
        } else if (this.imageOrientation == 3) {
            this.vertexCoordinatesF[0] = xOffset + width;
            this.vertexCoordinatesF[1] = yOffset + height;
            this.vertexCoordinatesF[2] = xOffset + width;
            this.vertexCoordinatesF[3] = yOffset;
            this.vertexCoordinatesF[4] = xOffset;
            this.vertexCoordinatesF[5] = yOffset + height;
            this.vertexCoordinatesF[6] = xOffset;
            this.vertexCoordinatesF[7] = yOffset;
        } else if (this.imageOrientation == 4) {
            this.vertexCoordinatesF[0] = xOffset;
            this.vertexCoordinatesF[1] = yOffset + width;
            this.vertexCoordinatesF[2] = xOffset + height;
            this.vertexCoordinatesF[3] = yOffset + width;
            this.vertexCoordinatesF[4] = xOffset;
            this.vertexCoordinatesF[5] = yOffset;
            this.vertexCoordinatesF[6] = xOffset + height;
            this.vertexCoordinatesF[7] = yOffset;
        } else if (this.imageOrientation == 5) {
            this.vertexCoordinatesF[0] = xOffset + height;
            this.vertexCoordinatesF[1] = yOffset;
            this.vertexCoordinatesF[2] = xOffset;
            this.vertexCoordinatesF[3] = yOffset;
            this.vertexCoordinatesF[4] = xOffset + height;
            this.vertexCoordinatesF[5] = yOffset + width;
            this.vertexCoordinatesF[6] = xOffset;
            this.vertexCoordinatesF[7] = yOffset + width;
        } else {
            this.vertexCoordinatesF[0] = xOffset;
            this.vertexCoordinatesF[1] = yOffset;
            this.vertexCoordinatesF[2] = xOffset;
            this.vertexCoordinatesF[3] = yOffset + height;
            this.vertexCoordinatesF[4] = xOffset + width;
            this.vertexCoordinatesF[5] = yOffset;
            this.vertexCoordinatesF[6] = xOffset + width;
            this.vertexCoordinatesF[7] = yOffset + height;
        }
        applyTransformationToCoordinates(this.vertexCoordinatesF, 4);
        this.floatBuffer.clear();
        this.floatBuffer.put(this.vertexCoordinatesF);
        this.floatBuffer.position(0);
        this.vertexCoordinatesI[0] = xBound;
        this.vertexCoordinatesI[1] = yBound;
        this.vertexCoordinatesI[2] = xBound;
        this.vertexCoordinatesI[3] = yBound + heightBound;
        this.vertexCoordinatesI[4] = xBound + widthBound;
        this.vertexCoordinatesI[5] = yBound;
        this.vertexCoordinatesI[6] = xBound + widthBound;
        this.vertexCoordinatesI[7] = yBound + heightBound;
        for (int i = 0; i < 4; i++) {
            this.vertexCoordinatesI[i * 2] = (65536 * this.vertexCoordinatesI[i * 2]) / atexture.pow2Width;
            this.vertexCoordinatesI[(i * 2) + 1] = (65536 * this.vertexCoordinatesI[(i * 2) + 1]) / atexture.pow2Height;
        }
        this.intBuffer.clear();
        this.intBuffer.put(this.vertexCoordinatesI);
        this.intBuffer.position(0);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_ADD);
        }
        aGlobal.instance.gl10.glEnable(GL10.GL_TEXTURE_2D);
        if (this.blendSFactor == GL10.GL_SRC_ALPHA && this.blendDFactor == GL10.GL_ONE_MINUS_SRC_ALPHA) {
            aGlobal.instance.gl10.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
            aGlobal.instance.gl10.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.gl10.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, atexture.textureID);
        aGlobal.instance.gl10.glVertexPointer(2, GL10.GL_FLOAT, 0, this.floatBuffer);
        aGlobal.instance.gl10.glTexCoordPointer(2, GL10.GL_FIXED, 0, this.intBuffer);
        aGlobal.instance.gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);
        }
    }

    public void drawScaledImagef(aTexture atexture, float x, float y, float f3, float f4, int i, int i2, int i3, int i4, float f5, int i5) {
        drawScaledImagef(atexture, x, y, f3, f4, i, i2, i3, i4, f5, atexture.rects[i5].x, atexture.rects[i5].y, atexture.rects[i5].width, atexture.rects[i5].height);
    }

    public void drawScaledImagef(aTexture atexture, float x, float y, float width, float height, int i1, int i2, int i3, int i4, float f5, int rectX, int rectY, int rectWidth, int rectHeight) {
        float f6;
        float f7;
        float f8 = (i1 & 1) != 0 ? (x - (width / 2.0f)) + this.xOffset : (i1 & 2) != 0 ? (x - width) + this.xOffset : this.xOffset + x;
        float f9 = (i1 & 4) != 0 ? (y - (height / 2.0f)) + this.yOffset : (i1 & 8) != 0 ? (y - height) + this.yOffset : this.yOffset + y;
        if ((i4 & 16) != 0) {
            f6 = this.xOffsetI + i2;
            f7 = this.yOffsetI + i3;
        } else {
            f6 = (i4 & 1) != 0 ? i2 + (width / 2.0f) + f8 : (i4 & 2) != 0 ? i2 + f8 + width : f8 + i2;
            f7 = (i4 & 4) != 0 ? (height / 2.0f) + f9 + i3 : (i4 & 8) != 0 ? f9 + height + i3 : i3 + f9;
        }
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = f10 + width;
        float f13 = f11 + height;
        float f14 = -f5;
        drawScaledImagef(atexture, (aMath.cos(f14) * f10) + (aMath.sin(f14) * f11) + f6, ((-f10) * aMath.sin(f14)) + (aMath.cos(f14) * f11) + f7, (aMath.cos(f14) * f10) + (aMath.sin(f14) * f13) + f6, ((-f10) * aMath.sin(f14)) + (aMath.cos(f14) * f13) + f7, (aMath.cos(f14) * f12) + (aMath.sin(f14) * f13) + f6, (f13 * aMath.cos(f14)) + ((-f12) * aMath.sin(f14)) + f7, (aMath.cos(f14) * f12) + (aMath.sin(f14) * f11) + f6, ((-f12) * aMath.sin(f14)) + (f11 * aMath.cos(f14)) + f7, rectX, rectY, rectWidth, rectHeight);
    }

    public void drawScaledImage(aTexture atexture, int i, int i2) {
        drawScaledImage(atexture, i, i2, 0);
    }

    public void drawScaledImage(aTexture atexture, int x, int y, int orientation) {
        int xOffset = x + this.xOffsetI;
        int yOffset = this.yOffsetI + y;
        if ((orientation & 1) != 0) {
            xOffset -= atexture.imgWidth / 2;
        } else if ((orientation & 2) != 0) {
            xOffset -= atexture.imgWidth;
        }
        if ((orientation & 4) != 0) {
            yOffset -= atexture.imgHeight / 2;
        } else if ((orientation & 8) != 0) {
            yOffset -= atexture.imgHeight;
        }
        this.vertexCoordinatesS[0] = (short) xOffset;
        this.vertexCoordinatesS[1] = (short) yOffset;
        this.vertexCoordinatesS[2] = (short) xOffset;
        this.vertexCoordinatesS[3] = (short) (atexture.imgHeight + yOffset);
        this.vertexCoordinatesS[4] = (short) (atexture.imgWidth + xOffset);
        this.vertexCoordinatesS[5] = (short) yOffset;
        this.vertexCoordinatesS[6] = (short) (xOffset + atexture.imgWidth);
        this.vertexCoordinatesS[7] = (short) (yOffset + atexture.imgHeight);
        applyTransformationToCoordinates(this.vertexCoordinatesS, 4);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        this.vertexCoordinatesI[0] = 0;
        this.vertexCoordinatesI[1] = 0;
        this.vertexCoordinatesI[2] = 0;
        this.vertexCoordinatesI[3] = atexture.imgHeight;
        this.vertexCoordinatesI[4] = atexture.imgWidth;
        this.vertexCoordinatesI[5] = 0;
        this.vertexCoordinatesI[6] = atexture.imgWidth;
        this.vertexCoordinatesI[7] = atexture.imgHeight;
        for (int i6 = 0; i6 < 4; i6++) {
            this.vertexCoordinatesI[i6 * 2] = (65536 * this.vertexCoordinatesI[i6 * 2]) / atexture.pow2Width;
            this.vertexCoordinatesI[(i6 * 2) + 1] = (65536 * this.vertexCoordinatesI[(i6 * 2) + 1]) / atexture.pow2Height;
        }
        this.intBuffer.clear();
        this.intBuffer.put(this.vertexCoordinatesI);
        this.intBuffer.position(0);
        aGlobal.instance.gl10.glEnable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, atexture.textureID);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
        aGlobal.instance.gl10.glDrawArrays(5, 0, 4);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height) {
        drawScaledImage(atexture, xPos, yPos, width, height, 0, 0, atexture.imgWidth, atexture.imgHeight);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height, int rectID) {
        drawScaledImage(atexture, xPos, yPos, width, height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height, int xBound, int yBound, int widthBound, int heightBound) {
        int i9 = this.xOffsetI + xPos;
        int i10 = this.yOffsetI + yPos;
        if (this.imageOrientation == 1) {
            this.vertexCoordinatesS[0] = (short) (i9 + width);
            this.vertexCoordinatesS[1] = (short) i10;
            this.vertexCoordinatesS[2] = (short) (i9 + width);
            this.vertexCoordinatesS[3] = (short) (i10 + height);
            this.vertexCoordinatesS[4] = (short) i9;
            this.vertexCoordinatesS[5] = (short) i10;
            this.vertexCoordinatesS[6] = (short) i9;
            this.vertexCoordinatesS[7] = (short) (i10 + height);
        } else if (this.imageOrientation == 2) {
            this.vertexCoordinatesS[0] = (short) i9;
            this.vertexCoordinatesS[1] = (short) (i10 + height);
            this.vertexCoordinatesS[2] = (short) i9;
            this.vertexCoordinatesS[3] = (short) i10;
            this.vertexCoordinatesS[4] = (short) (i9 + width);
            this.vertexCoordinatesS[5] = (short) (i10 + height);
            this.vertexCoordinatesS[6] = (short) (i9 + width);
            this.vertexCoordinatesS[7] = (short) i10;
        } else if (this.imageOrientation == 3) {
            this.vertexCoordinatesS[0] = (short) (i9 + width);
            this.vertexCoordinatesS[1] = (short) (i10 + height);
            this.vertexCoordinatesS[2] = (short) (i9 + width);
            this.vertexCoordinatesS[3] = (short) i10;
            this.vertexCoordinatesS[4] = (short) i9;
            this.vertexCoordinatesS[5] = (short) (i10 + height);
            this.vertexCoordinatesS[6] = (short) i9;
            this.vertexCoordinatesS[7] = (short) i10;
        } else if (this.imageOrientation == 4) {
            this.vertexCoordinatesS[0] = (short) i9;
            this.vertexCoordinatesS[1] = (short) (i10 + width);
            this.vertexCoordinatesS[2] = (short) (i9 + height);
            this.vertexCoordinatesS[3] = (short) (i10 + width);
            this.vertexCoordinatesS[4] = (short) i9;
            this.vertexCoordinatesS[5] = (short) i10;
            this.vertexCoordinatesS[6] = (short) (i9 + height);
            this.vertexCoordinatesS[7] = (short) i10;
        } else if (this.imageOrientation == 5) {
            this.vertexCoordinatesS[0] = (short) (i9 + height);
            this.vertexCoordinatesS[1] = (short) i10;
            this.vertexCoordinatesS[2] = (short) i9;
            this.vertexCoordinatesS[3] = (short) i10;
            this.vertexCoordinatesS[4] = (short) (i9 + height);
            this.vertexCoordinatesS[5] = (short) (i10 + width);
            this.vertexCoordinatesS[6] = (short) i9;
            this.vertexCoordinatesS[7] = (short) (i10 + width);
        } else {
            this.vertexCoordinatesS[0] = (short) i9;
            this.vertexCoordinatesS[1] = (short) i10;
            this.vertexCoordinatesS[2] = (short) i9;
            this.vertexCoordinatesS[3] = (short) (i10 + height);
            this.vertexCoordinatesS[4] = (short) (i9 + width);
            this.vertexCoordinatesS[5] = (short) i10;
            this.vertexCoordinatesS[6] = (short) (i9 + width);
            this.vertexCoordinatesS[7] = (short) (i10 + height);
        }
        applyTransformationToCoordinates(this.vertexCoordinatesS, 4);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        this.vertexCoordinatesI[0] = xBound;
        this.vertexCoordinatesI[1] = yBound;
        this.vertexCoordinatesI[2] = xBound;
        this.vertexCoordinatesI[3] = yBound + heightBound;
        this.vertexCoordinatesI[4] = xBound + widthBound;
        this.vertexCoordinatesI[5] = yBound;
        this.vertexCoordinatesI[6] = xBound + widthBound;
        this.vertexCoordinatesI[7] = yBound + heightBound;
        for (int i11 = 0; i11 < 4; i11++) {
            this.vertexCoordinatesI[i11 * 2] = (65536 * this.vertexCoordinatesI[i11 * 2]) / atexture.pow2Width;
            this.vertexCoordinatesI[(i11 * 2) + 1] = (65536 * this.vertexCoordinatesI[(i11 * 2) + 1]) / atexture.pow2Height;
        }
        this.intBuffer.clear();
        this.intBuffer.put(this.vertexCoordinatesI);
        this.intBuffer.position(0);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.gl10.glEnable(GL10.GL_TEXTURE_2D);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.gl10.glBlendFunc(1, 771);
            aGlobal.instance.gl10.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.gl10.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, atexture.textureID);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
        aGlobal.instance.gl10.glDrawArrays(5, 0, 4);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void drawScaledImage(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9) {
        a(atexture, i, i2, i3, i4, i5, i6, i7, i8, f, atexture.rects[i9].x, atexture.rects[i9].y, atexture.rects[i9].width, atexture.rects[i9].height);
    }

    public void a(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15 = (i5 & 1) != 0 ? (i - (i3 / 2)) + this.xOffsetI : (i5 & 2) != 0 ? (i - i3) + this.xOffsetI : this.xOffsetI + i;
        int i16 = (i5 & 4) != 0 ? (i2 - (i4 / 2)) + this.yOffsetI : (i5 & 8) != 0 ? (i2 - i4) + this.yOffsetI : this.yOffsetI + i2;
        if ((i8 & 16) != 0) {
            i13 = i6 + this.xOffsetI;
            i14 = this.yOffsetI + i7;
        } else {
            i13 = (i8 & 1) != 0 ? (i3 / 2) + i15 + i6 : (i8 & 2) != 0 ? i15 + i3 + i6 : i15 + i6;
            i14 = (i8 & 4) != 0 ? (i4 / 2) + i16 + i7 : (i8 & 8) != 0 ? i16 + i4 + i7 : i16 + i7;
        }
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        int i19 = i17 + i3;
        int i20 = i18 + i4;
        float f2 = -f;
        drawScaledImage(atexture, (int) ((i17 * aMath.cos(f2)) + (i18 * aMath.sin(f2)) + i13), (int) (((-i17) * aMath.sin(f2)) + (i18 * aMath.cos(f2)) + i14), (int) ((i17 * aMath.cos(f2)) + (i20 * aMath.sin(f2)) + i13), (int) (((-i17) * aMath.sin(f2)) + (i20 * aMath.cos(f2)) + i14), (int) ((i19 * aMath.cos(f2)) + (i20 * aMath.sin(f2)) + i13), (int) ((i20 * aMath.cos(f2)) + ((-i19) * aMath.sin(f2)) + i14), (int) (i13 + (i19 * aMath.cos(f2)) + (i18 * aMath.sin(f2))), (int) (i14 + ((-i19) * aMath.sin(f2)) + (i18 * aMath.cos(f2))), i9, i10, i11, i12);
    }

    public void drawScaledImage(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        drawScaledImage(atexture, i, i2, i3, i4, i5, i6, i7, i8, atexture.rects[i9].x, atexture.rects[i9].y, atexture.rects[i9].width, atexture.rects[i9].height);
    }

    public void drawScaledImage(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = this.xOffsetI + i;
        int i14 = this.yOffsetI + i2;
        int i15 = this.xOffsetI + i3;
        int i16 = this.yOffsetI + i4;
        int i17 = this.xOffsetI + i5;
        int i18 = this.yOffsetI + i6;
        int i19 = this.xOffsetI + i7;
        int i20 = this.yOffsetI + i8;
        this.vertexCoordinatesS[0] = (short) i13;
        this.vertexCoordinatesS[1] = (short) i14;
        this.vertexCoordinatesS[2] = (short) i15;
        this.vertexCoordinatesS[3] = (short) i16;
        this.vertexCoordinatesS[4] = (short) i19;
        this.vertexCoordinatesS[5] = (short) i20;
        this.vertexCoordinatesS[6] = (short) i17;
        this.vertexCoordinatesS[7] = (short) i18;
        applyTransformationToCoordinates(this.vertexCoordinatesS, 4);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        this.vertexCoordinatesI[0] = i9;
        this.vertexCoordinatesI[1] = i10;
        this.vertexCoordinatesI[2] = i9;
        this.vertexCoordinatesI[3] = i10 + i12;
        this.vertexCoordinatesI[4] = i9 + i11;
        this.vertexCoordinatesI[5] = i10;
        this.vertexCoordinatesI[6] = i9 + i11;
        this.vertexCoordinatesI[7] = i10 + i12;
        for (int i21 = 0; i21 < 4; i21++) {
            this.vertexCoordinatesI[i21 * 2] = (65536 * this.vertexCoordinatesI[i21 * 2]) / atexture.pow2Width;
            this.vertexCoordinatesI[(i21 * 2) + 1] = (65536 * this.vertexCoordinatesI[(i21 * 2) + 1]) / atexture.pow2Height;
        }
        this.intBuffer.clear();
        this.intBuffer.put(this.vertexCoordinatesI);
        this.intBuffer.position(0);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.gl10.glEnable(GL10.GL_TEXTURE_2D);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.gl10.glBlendFunc(1, 771);
            aGlobal.instance.gl10.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.gl10.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, atexture.textureID);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
        aGlobal.instance.gl10.glDrawArrays(5, 0, 4);
        if (this.additiveBlending == 1) {
            aGlobal.instance.gl10.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void setAnimTransformer(AnimTransformer animTransformer) {
        this.animTransformer = animTransformer;
    }

    public void setTextures(aModel amodel, int i, int i2) {
        int i3 = this.blendSFactor;
        int i4 = this.blendDFactor;
        int i5 = this.imageAlpha;
        amodel.setTextures(this, i, i2);
        this.blendSFactor = i3;
        this.blendDFactor = i4;
        this.imageAlpha = i5;
    }

    void applyTransformationToCoordinates(float[] coordinates, int numPairs) {
        if (this.animTransformer != null) {
            for (int i = 0; i < numPairs; i++) {
                float x = coordinates[i * 2];
                float y = coordinates[(i * 2) + 1];
                coordinates[i * 2] = (this.animTransformer.matrix[0] * x) + (this.animTransformer.matrix[1] * y) + this.animTransformer.matrix[2];
                coordinates[(i * 2) + 1] = (x * this.animTransformer.matrix[3]) + (y * this.animTransformer.matrix[4]) + this.animTransformer.matrix[5];
            }
        }
    }

    public void a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.vertexCoordinatesS[i2 * 2] = (short) (iArr[i2] + this.xOffsetI);
            this.vertexCoordinatesS[(i2 * 2) + 1] = (short) (iArr2[i2] + this.yOffsetI);
        }
        applyTransformationToCoordinates(this.vertexCoordinatesS, i);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        aGlobal.instance.gl10.glDisable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glDrawArrays(6, 0, i);
    }

    public void a(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.vertexCoordinatesS[i2 * 2] = (short) (iArr[i2] + this.xOffsetI);
            this.vertexCoordinatesS[(i2 * 2) + 1] = (short) (iArr2[i2] + this.yOffsetI);
            this.d[i2 * 4] = (((iArr3[i2] >> 16) & 255) * 65536) / 255;
            this.d[(i2 * 4) + 1] = (((iArr3[i2] >> 8) & 255) * 65536) / 255;
            this.d[(i2 * 4) + 2] = ((iArr3[i2] & 255) * 65536) / 255;
            this.d[(i2 * 4) + 3] = (((iArr3[i2] >> 24) & 255) * 65536) / 255;
        }
        applyTransformationToCoordinates(this.vertexCoordinatesS, i);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        this.h.clear();
        this.h.put(this.d);
        this.h.position(0);
        aGlobal.instance.gl10.glEnableClientState(32886);
        aGlobal.instance.gl10.glDisable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glColorPointer(4, 5132, 0, this.h);
        aGlobal.instance.gl10.glDrawArrays(6, 0, i);
        aGlobal.instance.gl10.glDisableClientState(32886);
    }

    void applyTransformationToCoordinates(short[] coordinates, int pairCount) {
        if (this.animTransformer != null) {
            for (int i = 0; i < pairCount; i++) {
                float x = coordinates[i * 2];
                float y = coordinates[(i * 2) + 1];
                coordinates[i * 2] = (short) ((this.animTransformer.matrix[0] * x) + (this.animTransformer.matrix[1] * y) + this.animTransformer.matrix[2]);
                coordinates[(i * 2) + 1] = (short) ((x * this.animTransformer.matrix[3]) + (y * this.animTransformer.matrix[4]) + this.animTransformer.matrix[5]);
            }
        }
    }

    public void setAlpha(int i) {
        this.alpha = i;
    }

    public void setImageColor(int i, int i2, int i3) {
        this.imageRed = i;
        this.imageGreen = i2;
        this.imageBlue = i3;
        this.imageAlpha = 255;
    }

    public void b(int i, int i2, int i3, int i4) {
        int i5 = this.xOffsetI + i;
        int i6 = this.yOffsetI + i2;
        int i7 = this.xOffsetI + i3;
        int i8 = this.yOffsetI + i4;
        this.vertexCoordinatesS[0] = (short) i5;
        this.vertexCoordinatesS[1] = (short) i6;
        this.vertexCoordinatesS[2] = (short) i7;
        this.vertexCoordinatesS[3] = (short) i8;
        applyTransformationToCoordinates(this.vertexCoordinatesS, 2);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        aGlobal.instance.gl10.glDisable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
        aGlobal.instance.gl10.glDrawArrays(1, 0, 2);
    }

    public void drawScaledImagef(aTexture atexture, int xPos, int yPos, int rectID) {
        drawScaledImage(atexture, xPos, yPos, atexture.rects[rectID].width, atexture.rects[rectID].height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void setupGL() {
        aGlobal.instance.gl10.glViewport(aGlobal.instance.viewportX, aGlobal.instance.viewportY, aGlobal.instance.viewportWidth, aGlobal.instance.viewportHeight);
        aGlobal.instance.gl10.glTexEnvx(8960, 8704, 8448);
        aGlobal.instance.gl10.glEnableClientState(32884);
        aGlobal.instance.gl10.glEnableClientState(32888);
        aGlobal.instance.gl10.glEnable(3042);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.vertexCoordinatesS.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.shortBuffer = allocateDirect.asShortBuffer();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.vertexCoordinatesS.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.floatBuffer = allocateDirect2.asFloatBuffer();
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.d.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.h = allocateDirect3.asIntBuffer();
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(this.vertexCoordinatesI.length * 4);
        allocateDirect4.order(ByteOrder.nativeOrder());
        this.intBuffer = allocateDirect4.asIntBuffer();
        setOffset(0, 0);
        setBlendMode(0);
        removeAnimTransformer();
        setColor(0, 0, 0, 255);
        setImageColor(255, 255, 255, 255);
    }

    public void setImageAlpha(int alpha) {
        this.imageAlpha = alpha;
    }

    public void drawRectangle(int x, int y, int width, int height) {
        int xOffset = this.xOffsetI + x;
        int yOffset = this.yOffsetI + y;

        this.vertexCoordinatesS[0] = (short) xOffset;
        this.vertexCoordinatesS[1] = (short) yOffset;
        this.vertexCoordinatesS[2] = (short) xOffset;
        this.vertexCoordinatesS[3] = (short) (yOffset + height);
        this.vertexCoordinatesS[4] = (short) (xOffset + width);
        this.vertexCoordinatesS[5] = (short) yOffset;
        this.vertexCoordinatesS[6] = (short) (xOffset + width);
        this.vertexCoordinatesS[7] = (short) (yOffset + height);

        applyTransformationToCoordinates(this.vertexCoordinatesS, 4);
        this.shortBuffer.clear();
        this.shortBuffer.put(this.vertexCoordinatesS);
        this.shortBuffer.position(0);
        aGlobal.instance.gl10.glDisable(GL10.GL_TEXTURE_2D);
        aGlobal.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.gl10.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.gl10.glVertexPointer(2, GL10.GL_SHORT, 0, this.shortBuffer);
        aGlobal.instance.gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }

    public void clearScreen() {
        aGlobal.instance.gl10.glClearColorx(0, 0, 0, 65535);
        aGlobal.instance.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }

    public void setOrientation(int orientation) {
        this.imageOrientation = orientation;
    }

    public void setImageColor(int red, int green, int blue, int alpha) {
        this.imageRed = red;
        this.imageGreen = green;
        this.imageBlue = blue;
        this.imageAlpha = alpha;
    }

    public void resetProjection() {
        updateProjection(100.0f);
    }

    public void removeAnimTransformer() {
        setAnimTransformer((AnimTransformer) null);
    }
}
