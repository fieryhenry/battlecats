package jp.co.ponos.library.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLUtils;
import java.io.InputStream;
import jp.co.ponos.library.game.DataStreams.aResourceFileStream;

/* renamed from: jp.co.ponos.library.b.ac */
/* loaded from: classes.dex */
public class aTexture {
    static Paint paint;
    int a;
    int imgWidth;
    int imgHeight;
    int d;
    int e;
    int f;
    Rect[] rects;

    static void setFont(String str, int i) {
        if (paint == null) {
            paint = new Paint();
        }
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (str.equals("FONT_SYSTEM_BOLD")) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (str.equals("FONT_SYSTEM_ITALIC")) {
            paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
        } else {
            paint.setTypeface(null);
        }
        paint.setTextSize(i);
    }

    public static int measureText(String str, int i) {
        return measureText(str, "FONT_SYSTEM", i);
    }

    public static int measureText(String str, String str2, int i) {
        setFont(str2, i);
        return (int) paint.measureText(str);
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public Rect getRect(int i) {
        return this.rects[i];
    }

    void drawImage(Bitmap bitmap, int i) {
        int[] iArr = new int[1];
        int width = bitmap.getWidth();
        this.imgWidth = width;
        int height = bitmap.getHeight();
        this.imgHeight = height;
        int i2 = 1;
        while (i2 < width) {
            i2 *= 2;
        }
        this.d = i2;
        int i3 = 1;
        while (i3 < height) {
            i3 *= 2;
        }
        this.e = i3;
        Bitmap createBitmap = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, width, height);
        bitmapDrawable.draw(canvas);
        aGlobal.instance.o.glGenTextures(1, iArr, 0);
        aGlobal.instance.o.glBindTexture(3553, iArr[0]);
        if ((i & 8) != 0) {
            aGlobal.instance.o.glTexParameterf(3553, 10241, 9728.0f);
            aGlobal.instance.o.glTexParameterf(3553, 10240, 9728.0f);
        } else {
            aGlobal.instance.o.glTexParameterf(3553, 10241, 9729.0f);
            aGlobal.instance.o.glTexParameterf(3553, 10240, 9729.0f);
        }
        GLUtils.texImage2D(3553, 0, createBitmap, 0);
        this.a = iArr[0];
    }

    public boolean load(String str, String str2) {
        return load(str, str2, 0);
    }

    public boolean load(String str, String str2, int i) {
        try {
            reset();
            this.f = i;
            if (str2 != null) {
                if ((i & 1) != 0) {
                    aResourceFileStream aresourcefilestream = new aResourceFileStream();
                    if (!aresourcefilestream.openRead(str2)) {
                        return false;
                    }
                    aresourcefilestream.readRawLine();
                    aresourcefilestream.readRawLine();
                    aresourcefilestream.readRawLine();
                    aresourcefilestream.readLine();
                    int totalRects = aresourcefilestream.getInt(0);
                    this.rects = new Rect[totalRects];
                    for (int i2 = 0; i2 < totalRects; i2++) {
                        aresourcefilestream.readLine();
                        this.rects[i2].x = aresourcefilestream.getInt(0);
                        this.rects[i2].y = aresourcefilestream.getInt(1);
                        this.rects[i2].width = aresourcefilestream.getInt(2);
                        this.rects[i2].height = aresourcefilestream.getInt(3);
                    }
                    aresourcefilestream.close();
                } else {
                    aResourceFileStream aresourcefilestream2 = new aResourceFileStream();
                    if (!aresourcefilestream2.openRead(str2)) {
                        return false;
                    }
                    aresourcefilestream2.readRawLine();
                    aresourcefilestream2.readRawLine();
                    aresourcefilestream2.readRawLine();
                    aresourcefilestream2.readLine();
                    int totalRects = aresourcefilestream2.getInt(0);
                    this.rects = new Rect[totalRects];
                    for (int i3 = 0; i3 < totalRects; i3++) {
                        aresourcefilestream2.readLine();
                        this.rects[i3] = new Rect();
                        this.rects[i3].x = aresourcefilestream2.getInt(0);
                        this.rects[i3].y = aresourcefilestream2.getInt(1);
                        this.rects[i3].width = aresourcefilestream2.getInt(2);
                        this.rects[i3].height = aresourcefilestream2.getInt(3);
                    }
                    aresourcefilestream2.close();
                }
            }
            InputStream openFileInput = (i & 1) != 0 ? aGlobal.instance.context.openFileInput(str) : aGlobal.instance.context.getResources().openRawResource(aAssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(str)));
            drawImage(BitmapFactory.decodeStream(openFileInput), i);
            openFileInput.close();
            if ((i & 2) != 0) {
                this.imgWidth /= 2;
                this.imgHeight /= 2;
            } else if ((i & 4) != 0) {
                this.imgWidth *= 2;
                this.imgHeight *= 2;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean drawText(String str, String str2, int i, int i2) {
        return drawText(str, str2, i, i2, 0, 0);
    }

    public boolean drawText(String str, String str2, int i, int i2, int i3, int i4) {
        if (str.length() == 0) {
            str = " ";
        }
        setFont(str2, i);
        int i5 = 1;
        while (i5 < ((int) paint.measureText(str))) {
            i5 *= 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i5, (int) (paint.descent() - paint.ascent()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (i2 == 0) {
            canvas.drawText(str, 0.0f, (int) (-paint.ascent()), paint);
        } else if (i2 == 1) {
            canvas.drawText(str, (i5 - paint.measureText(str)) / 2, (int) (-paint.ascent()), paint);
        } else {
            canvas.drawText(str, i5 - paint.measureText(str), (int) (-paint.ascent()), paint);
        }
        drawImage(createBitmap, 0);
        return true;
    }

    public boolean isLoaded() {
        return this.a != 0;
    }

    public void reset() {
        if (this.a != 0) {
            aGlobal.instance.o.glDeleteTextures(1, new int[]{this.a}, 0);
            this.a = 0;
        }
    }
}
