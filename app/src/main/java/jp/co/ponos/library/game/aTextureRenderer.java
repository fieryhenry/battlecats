package jp.co.ponos.library.game;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* renamed from: jp.co.ponos.library.b.f */
/* loaded from: classes.dex */
public class aTextureRenderer {
    static aTextureRenderer textureRenderer;
    int A;
    short[] b = new short[32];
    float[] c = new float[32];
    int[] d = new int[64];
    int[] e = new int[8];
    ShortBuffer f;
    FloatBuffer g;
    IntBuffer h;
    IntBuffer i;
    float j;
    int k;
    int l;
    float m;
    float n;
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
    int z;

    public static void createInstance() {
        textureRenderer = new aTextureRenderer();
    }

    public static aTextureRenderer getInstance() {
        return textureRenderer;
    }

    public void scale(float f) {
        this.j = f;
        aGlobal.instance.o.glMatrixMode(5889);
        aGlobal.instance.o.glLoadIdentity();
        aGlobal.instance.o.glOrthof(0.0f, (aGlobal.instance.width * this.j) / 100.0f, (aGlobal.instance.height * this.j) / 100.0f, 0.0f, -1.0f, 1.0f);
        aGlobal.instance.o.glMatrixMode(5888);
        aGlobal.instance.o.glLoadIdentity();
    }

    public void fillRect(float f, float f2, float f3, float f4) {
        float f5 = this.m + f;
        float f6 = this.n + f2;
        this.c[0] = f5;
        this.c[1] = f6;
        this.c[2] = f5;
        this.c[3] = f6 + f4;
        this.c[4] = f5 + f3;
        this.c[5] = f6;
        this.c[6] = f5 + f3;
        this.c[7] = f6 + f4;
        a(this.c, 4);
        this.g.clear();
        this.g.put(this.c);
        this.g.position(0);
        aGlobal.instance.o.glDisable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.o.glVertexPointer(2, 5126, 0, this.g);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
    }

    public void setGlow(int i) {
        if (i == 0) {
            this.blendSFactor = 770;
            this.blendDFactor = 771;
        } else if (i == 1) {
            this.blendSFactor = 770;
            this.blendDFactor = 1;
        } else if (i == 3) {
            this.blendSFactor = 0;
            this.blendDFactor = 768;
        } else if (i == 4) {
            this.blendSFactor = 775;
            this.blendDFactor = 1;
        }
    }

    public void a(int i, int i2) {
        this.k = i;
        this.l = i2;
        this.m = i;
        this.n = i2;
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

    public void drawScaledImage(aTexture atexture, float f, float f2, float f3, float f4) {
        drawScaledImage(atexture, f, f2, f3, f4, 0, 0, atexture.imgWidth, atexture.imgHeight);
    }

    public void a(aTexture atexture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i, int i2, int i3, int i4) {
        float f9 = this.m + f;
        float f10 = this.n + f2;
        float f11 = this.m + f3;
        float f12 = this.n + f4;
        float f13 = this.m + f5;
        float f14 = this.n + f6;
        float f15 = this.m + f7;
        float f16 = this.n + f8;
        this.c[0] = f9;
        this.c[1] = f10;
        this.c[2] = f11;
        this.c[3] = f12;
        this.c[4] = f15;
        this.c[5] = f16;
        this.c[6] = f13;
        this.c[7] = f14;
        a(this.c, 4);
        this.g.clear();
        this.g.put(this.c);
        this.g.position(0);
        this.e[0] = i;
        this.e[1] = i2;
        this.e[2] = i;
        this.e[3] = i2 + i4;
        this.e[4] = i + i3;
        this.e[5] = i2;
        this.e[6] = i + i3;
        this.e[7] = i2 + i4;
        for (int i5 = 0; i5 < 4; i5++) {
            this.e[i5 * 2] = (65536 * this.e[i5 * 2]) / atexture.d;
            this.e[(i5 * 2) + 1] = (65536 * this.e[(i5 * 2) + 1]) / atexture.e;
        }
        this.i.clear();
        this.i.put(this.e);
        this.i.position(0);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.o.glEnable(3553);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.o.glBlendFunc(1, 771);
            aGlobal.instance.o.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.o.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.o.glBindTexture(3553, atexture.a);
        aGlobal.instance.o.glVertexPointer(2, 5126, 0, this.g);
        aGlobal.instance.o.glTexCoordPointer(2, 5132, 0, this.i);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void drawScaledImagef(aTexture atexture, float xPos, float yPos, float width, float height, int rectID) {
        drawScaledImage(atexture, xPos, yPos, width, height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void drawScaledImage(aTexture atexture, float xPos, float yPos, float width, float height, int xBound, int yBound, int widthBound, int heightBound) {
        float f5 = this.m + xPos;
        float f6 = this.n + yPos;
        if (this.A == 1) {
            this.c[0] = f5 + width;
            this.c[1] = f6;
            this.c[2] = f5 + width;
            this.c[3] = f6 + height;
            this.c[4] = f5;
            this.c[5] = f6;
            this.c[6] = f5;
            this.c[7] = f6 + height;
        } else if (this.A == 2) {
            this.c[0] = f5;
            this.c[1] = f6 + height;
            this.c[2] = f5;
            this.c[3] = f6;
            this.c[4] = f5 + width;
            this.c[5] = f6 + height;
            this.c[6] = f5 + width;
            this.c[7] = f6;
        } else if (this.A == 3) {
            this.c[0] = f5 + width;
            this.c[1] = f6 + height;
            this.c[2] = f5 + width;
            this.c[3] = f6;
            this.c[4] = f5;
            this.c[5] = f6 + height;
            this.c[6] = f5;
            this.c[7] = f6;
        } else if (this.A == 4) {
            this.c[0] = f5;
            this.c[1] = f6 + width;
            this.c[2] = f5 + height;
            this.c[3] = f6 + width;
            this.c[4] = f5;
            this.c[5] = f6;
            this.c[6] = f5 + height;
            this.c[7] = f6;
        } else if (this.A == 5) {
            this.c[0] = f5 + height;
            this.c[1] = f6;
            this.c[2] = f5;
            this.c[3] = f6;
            this.c[4] = f5 + height;
            this.c[5] = f6 + width;
            this.c[6] = f5;
            this.c[7] = f6 + width;
        } else {
            this.c[0] = f5;
            this.c[1] = f6;
            this.c[2] = f5;
            this.c[3] = f6 + height;
            this.c[4] = f5 + width;
            this.c[5] = f6;
            this.c[6] = f5 + width;
            this.c[7] = f6 + height;
        }
        a(this.c, 4);
        this.g.clear();
        this.g.put(this.c);
        this.g.position(0);
        this.e[0] = xBound;
        this.e[1] = yBound;
        this.e[2] = xBound;
        this.e[3] = yBound + heightBound;
        this.e[4] = xBound + widthBound;
        this.e[5] = yBound;
        this.e[6] = xBound + widthBound;
        this.e[7] = yBound + heightBound;
        for (int i5 = 0; i5 < 4; i5++) {
            this.e[i5 * 2] = (65536 * this.e[i5 * 2]) / atexture.d;
            this.e[(i5 * 2) + 1] = (65536 * this.e[(i5 * 2) + 1]) / atexture.e;
        }
        this.i.clear();
        this.i.put(this.e);
        this.i.position(0);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.o.glEnable(3553);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.o.glBlendFunc(1, 771);
            aGlobal.instance.o.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.o.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.o.glBindTexture(3553, atexture.a);
        aGlobal.instance.o.glVertexPointer(2, 5126, 0, this.g);
        aGlobal.instance.o.glTexCoordPointer(2, 5132, 0, this.i);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void drawScaledImage(aTexture atexture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, float f5, int i5) {
        a(atexture, f, f2, f3, f4, i, i2, i3, i4, f5, atexture.rects[i5].x, atexture.rects[i5].y, atexture.rects[i5].width, atexture.rects[i5].height);
    }

    public void a(aTexture atexture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, float f5, int i5, int i6, int i7, int i8) {
        float f6;
        float f7;
        float f8 = (i & 1) != 0 ? (f - (f3 / 2.0f)) + this.m : (i & 2) != 0 ? (f - f3) + this.m : this.m + f;
        float f9 = (i & 4) != 0 ? (f2 - (f4 / 2.0f)) + this.n : (i & 8) != 0 ? (f2 - f4) + this.n : this.n + f2;
        if ((i4 & 16) != 0) {
            f6 = this.k + i2;
            f7 = this.l + i3;
        } else {
            f6 = (i4 & 1) != 0 ? i2 + (f3 / 2.0f) + f8 : (i4 & 2) != 0 ? i2 + f8 + f3 : f8 + i2;
            f7 = (i4 & 4) != 0 ? (f4 / 2.0f) + f9 + i3 : (i4 & 8) != 0 ? f9 + f4 + i3 : i3 + f9;
        }
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = f10 + f3;
        float f13 = f11 + f4;
        float f14 = -f5;
        a(atexture, (aMath.cos(f14) * f10) + (aMath.sin(f14) * f11) + f6, ((-f10) * aMath.sin(f14)) + (aMath.cos(f14) * f11) + f7, (aMath.cos(f14) * f10) + (aMath.sin(f14) * f13) + f6, ((-f10) * aMath.sin(f14)) + (aMath.cos(f14) * f13) + f7, (aMath.cos(f14) * f12) + (aMath.sin(f14) * f13) + f6, (f13 * aMath.cos(f14)) + ((-f12) * aMath.sin(f14)) + f7, (aMath.cos(f14) * f12) + (aMath.sin(f14) * f11) + f6, ((-f12) * aMath.sin(f14)) + (f11 * aMath.cos(f14)) + f7, i5, i6, i7, i8);
    }

    public void drawScaledImage(aTexture atexture, int i, int i2) {
        a(atexture, i, i2, 0);
    }

    public void a(aTexture atexture, int i, int i2, int i3) {
        int i4 = i + this.k;
        int i5 = this.l + i2;
        if ((i3 & 1) != 0) {
            i4 -= atexture.imgWidth / 2;
        } else if ((i3 & 2) != 0) {
            i4 -= atexture.imgWidth;
        }
        if ((i3 & 4) != 0) {
            i5 -= atexture.imgHeight / 2;
        } else if ((i3 & 8) != 0) {
            i5 -= atexture.imgHeight;
        }
        this.b[0] = (short) i4;
        this.b[1] = (short) i5;
        this.b[2] = (short) i4;
        this.b[3] = (short) (atexture.imgHeight + i5);
        this.b[4] = (short) (atexture.imgWidth + i4);
        this.b[5] = (short) i5;
        this.b[6] = (short) (i4 + atexture.imgWidth);
        this.b[7] = (short) (i5 + atexture.imgHeight);
        a(this.b, 4);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        this.e[0] = 0;
        this.e[1] = 0;
        this.e[2] = 0;
        this.e[3] = atexture.imgHeight;
        this.e[4] = atexture.imgWidth;
        this.e[5] = 0;
        this.e[6] = atexture.imgWidth;
        this.e[7] = atexture.imgHeight;
        for (int i6 = 0; i6 < 4; i6++) {
            this.e[i6 * 2] = (65536 * this.e[i6 * 2]) / atexture.d;
            this.e[(i6 * 2) + 1] = (65536 * this.e[(i6 * 2) + 1]) / atexture.e;
        }
        this.i.clear();
        this.i.put(this.e);
        this.i.position(0);
        aGlobal.instance.o.glEnable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.o.glBindTexture(3553, atexture.a);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glTexCoordPointer(2, 5132, 0, this.i);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height) {
        drawScaledImage(atexture, xPos, yPos, width, height, 0, 0, atexture.imgWidth, atexture.imgHeight);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height, int rectID) {
        drawScaledImage(atexture, xPos, yPos, width, height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int width, int height, int xBound, int yBound, int widthBound, int heightBound) {
        int i9 = this.k + xPos;
        int i10 = this.l + yPos;
        if (this.A == 1) {
            this.b[0] = (short) (i9 + width);
            this.b[1] = (short) i10;
            this.b[2] = (short) (i9 + width);
            this.b[3] = (short) (i10 + height);
            this.b[4] = (short) i9;
            this.b[5] = (short) i10;
            this.b[6] = (short) i9;
            this.b[7] = (short) (i10 + height);
        } else if (this.A == 2) {
            this.b[0] = (short) i9;
            this.b[1] = (short) (i10 + height);
            this.b[2] = (short) i9;
            this.b[3] = (short) i10;
            this.b[4] = (short) (i9 + width);
            this.b[5] = (short) (i10 + height);
            this.b[6] = (short) (i9 + width);
            this.b[7] = (short) i10;
        } else if (this.A == 3) {
            this.b[0] = (short) (i9 + width);
            this.b[1] = (short) (i10 + height);
            this.b[2] = (short) (i9 + width);
            this.b[3] = (short) i10;
            this.b[4] = (short) i9;
            this.b[5] = (short) (i10 + height);
            this.b[6] = (short) i9;
            this.b[7] = (short) i10;
        } else if (this.A == 4) {
            this.b[0] = (short) i9;
            this.b[1] = (short) (i10 + width);
            this.b[2] = (short) (i9 + height);
            this.b[3] = (short) (i10 + width);
            this.b[4] = (short) i9;
            this.b[5] = (short) i10;
            this.b[6] = (short) (i9 + height);
            this.b[7] = (short) i10;
        } else if (this.A == 5) {
            this.b[0] = (short) (i9 + height);
            this.b[1] = (short) i10;
            this.b[2] = (short) i9;
            this.b[3] = (short) i10;
            this.b[4] = (short) (i9 + height);
            this.b[5] = (short) (i10 + width);
            this.b[6] = (short) i9;
            this.b[7] = (short) (i10 + width);
        } else {
            this.b[0] = (short) i9;
            this.b[1] = (short) i10;
            this.b[2] = (short) i9;
            this.b[3] = (short) (i10 + height);
            this.b[4] = (short) (i9 + width);
            this.b[5] = (short) i10;
            this.b[6] = (short) (i9 + width);
            this.b[7] = (short) (i10 + height);
        }
        a(this.b, 4);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        this.e[0] = xBound;
        this.e[1] = yBound;
        this.e[2] = xBound;
        this.e[3] = yBound + heightBound;
        this.e[4] = xBound + widthBound;
        this.e[5] = yBound;
        this.e[6] = xBound + widthBound;
        this.e[7] = yBound + heightBound;
        for (int i11 = 0; i11 < 4; i11++) {
            this.e[i11 * 2] = (65536 * this.e[i11 * 2]) / atexture.d;
            this.e[(i11 * 2) + 1] = (65536 * this.e[(i11 * 2) + 1]) / atexture.e;
        }
        this.i.clear();
        this.i.put(this.e);
        this.i.position(0);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.o.glEnable(3553);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.o.glBlendFunc(1, 771);
            aGlobal.instance.o.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.o.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.o.glBindTexture(3553, atexture.a);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glTexCoordPointer(2, 5132, 0, this.i);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 8448);
        }
    }

    public void drawScaledImage(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9) {
        a(atexture, i, i2, i3, i4, i5, i6, i7, i8, f, atexture.rects[i9].x, atexture.rects[i9].y, atexture.rects[i9].width, atexture.rects[i9].height);
    }

    public void a(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15 = (i5 & 1) != 0 ? (i - (i3 / 2)) + this.k : (i5 & 2) != 0 ? (i - i3) + this.k : this.k + i;
        int i16 = (i5 & 4) != 0 ? (i2 - (i4 / 2)) + this.l : (i5 & 8) != 0 ? (i2 - i4) + this.l : this.l + i2;
        if ((i8 & 16) != 0) {
            i13 = i6 + this.k;
            i14 = this.l + i7;
        } else {
            i13 = (i8 & 1) != 0 ? (i3 / 2) + i15 + i6 : (i8 & 2) != 0 ? i15 + i3 + i6 : i15 + i6;
            i14 = (i8 & 4) != 0 ? (i4 / 2) + i16 + i7 : (i8 & 8) != 0 ? i16 + i4 + i7 : i16 + i7;
        }
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        int i19 = i17 + i3;
        int i20 = i18 + i4;
        float f2 = -f;
        a(atexture, (int) ((i17 * aMath.cos(f2)) + (i18 * aMath.sin(f2)) + i13), (int) (((-i17) * aMath.sin(f2)) + (i18 * aMath.cos(f2)) + i14), (int) ((i17 * aMath.cos(f2)) + (i20 * aMath.sin(f2)) + i13), (int) (((-i17) * aMath.sin(f2)) + (i20 * aMath.cos(f2)) + i14), (int) ((i19 * aMath.cos(f2)) + (i20 * aMath.sin(f2)) + i13), (int) ((i20 * aMath.cos(f2)) + ((-i19) * aMath.sin(f2)) + i14), (int) (i13 + (i19 * aMath.cos(f2)) + (i18 * aMath.sin(f2))), (int) (i14 + ((-i19) * aMath.sin(f2)) + (i18 * aMath.cos(f2))), i9, i10, i11, i12);
    }

    public void drawScaledImage(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(atexture, i, i2, i3, i4, i5, i6, i7, i8, atexture.rects[i9].x, atexture.rects[i9].y, atexture.rects[i9].width, atexture.rects[i9].height);
    }

    public void a(aTexture atexture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = this.k + i;
        int i14 = this.l + i2;
        int i15 = this.k + i3;
        int i16 = this.l + i4;
        int i17 = this.k + i5;
        int i18 = this.l + i6;
        int i19 = this.k + i7;
        int i20 = this.l + i8;
        this.b[0] = (short) i13;
        this.b[1] = (short) i14;
        this.b[2] = (short) i15;
        this.b[3] = (short) i16;
        this.b[4] = (short) i19;
        this.b[5] = (short) i20;
        this.b[6] = (short) i17;
        this.b[7] = (short) i18;
        a(this.b, 4);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        this.e[0] = i9;
        this.e[1] = i10;
        this.e[2] = i9;
        this.e[3] = i10 + i12;
        this.e[4] = i9 + i11;
        this.e[5] = i10;
        this.e[6] = i9 + i11;
        this.e[7] = i10 + i12;
        for (int i21 = 0; i21 < 4; i21++) {
            this.e[i21 * 2] = (65536 * this.e[i21 * 2]) / atexture.d;
            this.e[(i21 * 2) + 1] = (65536 * this.e[(i21 * 2) + 1]) / atexture.e;
        }
        this.i.clear();
        this.i.put(this.e);
        this.i.position(0);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 260);
        }
        aGlobal.instance.o.glEnable(3553);
        if (this.blendSFactor == 770 && this.blendDFactor == 771) {
            aGlobal.instance.o.glBlendFunc(1, 771);
            aGlobal.instance.o.glColor4f(((this.imageRed * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageGreen * this.imageAlpha) / 255.0f) / 255.0f, ((this.imageBlue * this.imageAlpha) / 255.0f) / 255.0f, this.imageAlpha / 255.0f);
        } else {
            aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
            aGlobal.instance.o.glColor4f(this.imageRed / 255.0f, this.imageGreen / 255.0f, this.imageBlue / 255.0f, this.imageAlpha / 255.0f);
        }
        aGlobal.instance.o.glBindTexture(3553, atexture.a);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glTexCoordPointer(2, 5132, 0, this.i);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
        if (this.z == 1) {
            aGlobal.instance.o.glTexEnvx(8960, 8704, 8448);
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

    void a(float[] fArr, int i) {
        if (this.animTransformer != null) {
            for (int i2 = 0; i2 < i; i2++) {
                float f = fArr[i2 * 2];
                float f2 = fArr[(i2 * 2) + 1];
                fArr[i2 * 2] = (this.animTransformer.a[0] * f) + (this.animTransformer.a[1] * f2) + this.animTransformer.a[2];
                fArr[(i2 * 2) + 1] = (f * this.animTransformer.a[3]) + (f2 * this.animTransformer.a[4]) + this.animTransformer.a[5];
            }
        }
    }

    public void a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.b[i2 * 2] = (short) (iArr[i2] + this.k);
            this.b[(i2 * 2) + 1] = (short) (iArr2[i2] + this.l);
        }
        a(this.b, i);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        aGlobal.instance.o.glDisable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glDrawArrays(6, 0, i);
    }

    public void a(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.b[i2 * 2] = (short) (iArr[i2] + this.k);
            this.b[(i2 * 2) + 1] = (short) (iArr2[i2] + this.l);
            this.d[i2 * 4] = (((iArr3[i2] >> 16) & 255) * 65536) / 255;
            this.d[(i2 * 4) + 1] = (((iArr3[i2] >> 8) & 255) * 65536) / 255;
            this.d[(i2 * 4) + 2] = ((iArr3[i2] & 255) * 65536) / 255;
            this.d[(i2 * 4) + 3] = (((iArr3[i2] >> 24) & 255) * 65536) / 255;
        }
        a(this.b, i);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        this.h.clear();
        this.h.put(this.d);
        this.h.position(0);
        aGlobal.instance.o.glEnableClientState(32886);
        aGlobal.instance.o.glDisable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glColorPointer(4, 5132, 0, this.h);
        aGlobal.instance.o.glDrawArrays(6, 0, i);
        aGlobal.instance.o.glDisableClientState(32886);
    }

    void a(short[] sArr, int i) {
        if (this.animTransformer != null) {
            for (int i2 = 0; i2 < i; i2++) {
                float f = sArr[i2 * 2];
                float f2 = sArr[(i2 * 2) + 1];
                sArr[i2 * 2] = (short) ((this.animTransformer.a[0] * f) + (this.animTransformer.a[1] * f2) + this.animTransformer.a[2]);
                sArr[(i2 * 2) + 1] = (short) ((f * this.animTransformer.a[3]) + (f2 * this.animTransformer.a[4]) + this.animTransformer.a[5]);
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
        int i5 = this.k + i;
        int i6 = this.l + i2;
        int i7 = this.k + i3;
        int i8 = this.l + i4;
        this.b[0] = (short) i5;
        this.b[1] = (short) i6;
        this.b[2] = (short) i7;
        this.b[3] = (short) i8;
        a(this.b, 2);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        aGlobal.instance.o.glDisable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glDrawArrays(1, 0, 2);
    }

    public void drawScaledImage(aTexture atexture, int xPos, int yPos, int rectID) {
        drawScaledImage(atexture, xPos, yPos, atexture.rects[rectID].width, atexture.rects[rectID].height, atexture.rects[rectID].x, atexture.rects[rectID].y, atexture.rects[rectID].width, atexture.rects[rectID].height);
    }

    public void c() {
        aGlobal.instance.o.glViewport(aGlobal.instance.e, aGlobal.instance.f, aGlobal.instance.g, aGlobal.instance.h);
        aGlobal.instance.o.glTexEnvx(8960, 8704, 8448);
        aGlobal.instance.o.glEnableClientState(32884);
        aGlobal.instance.o.glEnableClientState(32888);
        aGlobal.instance.o.glEnable(3042);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.b.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f = allocateDirect.asShortBuffer();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.b.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.g = allocateDirect2.asFloatBuffer();
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.d.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.h = allocateDirect3.asIntBuffer();
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(this.e.length * 4);
        allocateDirect4.order(ByteOrder.nativeOrder());
        this.i = allocateDirect4.asIntBuffer();
        a(0, 0);
        setGlow(0);
        removeAnimTranformer();
        setColor(0, 0, 0, 255);
        setImageColor(255, 255, 255, 255);
    }

    public void setImageAlpha(int i) {
        this.imageAlpha = i;
    }

    public void c(int i, int i2, int i3, int i4) {
        int i5 = this.k + i;
        int i6 = this.l + i2;
        this.b[0] = (short) i5;
        this.b[1] = (short) i6;
        this.b[2] = (short) i5;
        this.b[3] = (short) (i6 + i4);
        this.b[4] = (short) (i5 + i3);
        this.b[5] = (short) i6;
        this.b[6] = (short) (i5 + i3);
        this.b[7] = (short) (i6 + i4);
        a(this.b, 4);
        this.f.clear();
        this.f.put(this.b);
        this.f.position(0);
        aGlobal.instance.o.glDisable(3553);
        aGlobal.instance.o.glBlendFunc(this.blendSFactor, this.blendDFactor);
        aGlobal.instance.o.glColor4f(this.red / 255.0f, this.green / 255.0f, this.blue / 255.0f, this.alpha / 255.0f);
        aGlobal.instance.o.glVertexPointer(2, 5122, 0, this.f);
        aGlobal.instance.o.glDrawArrays(5, 0, 4);
    }

    public void d() {
        aGlobal.instance.o.glClearColorx(0, 0, 0, 65535);
        aGlobal.instance.o.glClear(16640);
    }

    public void d(int i) {
        this.A = i;
    }

    public void setImageColor(int i, int i2, int i3, int i4) {
        this.imageRed = i;
        this.imageGreen = i2;
        this.imageBlue = i3;
        this.imageAlpha = i4;
    }

    public void reset() {
        scale(100.0f);
    }

    public void removeAnimTranformer() {
        setAnimTransformer((AnimTransformer) null);
    }
}
