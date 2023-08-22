package jp.co.ponos.library.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLUtils;
import java.io.InputStream;

import javax.microedition.khronos.opengles.GL10;

import jp.co.ponos.library.game.stream.AssetTextStream;

public class Texture {
   static Paint paint;
   int textureID;
   int imgWidth;
   int imgHeight;
   int pow2Width;
   int pow2Height;
   int f;
   Rect[] rects;

   static void setFont(String var0, int var1) {
      if (paint == null) {
         paint = new Paint();
      }

      paint.setAntiAlias(true);
      paint.setColor(-1);
      if (var0.equals("FONT_SYSTEM_BOLD")) {
         paint.setTypeface(Typeface.DEFAULT_BOLD);
      } else if (var0.equals("FONT_SYSTEM_ITALIC")) {
         paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
      } else {
         paint.setTypeface((Typeface)null);
      }

      paint.setTextSize((float)var1);
   }

   public static int measureText(String var0, int var1) {
      return measureText(var0, "FONT_SYSTEM", var1);
   }

   public static int measureText(String var0, String var1, int var2) {
      setFont(var1, var2);
      return (int) paint.measureText(var0);
   }

   public int getImgWidth() {
      return this.imgWidth;
   }

   public Rect getRect(int var1) {
      return this.rects[var1];
   }

   void drawImage(Bitmap bitmap, int i) {
      int[] textureIds = new int[1];
      int width = bitmap.getWidth();
      this.imgWidth = width;
      int height = bitmap.getHeight();
      this.imgHeight = height;
      int pow2Width = 1;
      while (pow2Width < width) {
         pow2Width *= 2;
      }
      this.pow2Width = pow2Width;
      int pow2Height = 1;
      while (pow2Height < height) {
         pow2Height *= 2;
      }
      this.pow2Height = pow2Height;
      Bitmap createBitmap = Bitmap.createBitmap(this.pow2Width, this.pow2Height, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(createBitmap);
      BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
      bitmapDrawable.setBounds(0, 0, width, height);
      bitmapDrawable.draw(canvas);
      Global.instance.gl10.glGenTextures(1, textureIds, 0);
      Global.instance.gl10.glBindTexture(GL10.GL_TEXTURE_2D, textureIds[0]);
      if ((i & 8) != 0) {
         Global.instance.gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
         Global.instance.gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);
      } else {
         Global.instance.gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
         Global.instance.gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
      }
      GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, createBitmap, 0);
      this.textureID = textureIds[0];
   }

   public boolean load(String var1, String var2) {
      return this.load(var1, var2, 0);
   }

   public boolean load(String var1, String var2, int var3) {
      boolean var4 = false;

      boolean var6;
      label151: {
         label138: {
            boolean var10001;
            try {
               this.reset();
               this.f = var3;
            } catch (Exception var24) {
               var10001 = false;
               break label138;
            }

            if (var2 != null) {
               AssetTextStream var5;
               int var7;
               int var8;
               if ((var3 & 1) != 0) {
                  try {
                     var5 = new AssetTextStream();
                  } catch (Exception var23) {
                     var10001 = false;
                     break label138;
                  }

                  var6 = var4;

                  try {
                     if (!var5.openRead(var2)) {
                        return var6;
                     }

                     var5.getLine();
                     var5.getLine();
                     var5.getLine();
                     var5.readLine();
                     var7 = var5.getInt(0);
                     this.rects = new Rect[var7];
                  } catch (Exception var22) {
                     var10001 = false;
                     break label138;
                  }

                  for(var8 = 0; var8 < var7; ++var8) {
                     try {
                        var5.readLine();
                        this.rects[var8].x = var5.getInt(0);
                        this.rects[var8].y = var5.getInt(1);
                        this.rects[var8].width = var5.getInt(2);
                        this.rects[var8].height = var5.getInt(3);
                     } catch (Exception var21) {
                        var10001 = false;
                        break label138;
                     }
                  }

                  try {
                     var5.close();
                  } catch (Exception var20) {
                     var10001 = false;
                     break label138;
                  }
               } else {
                  try {
                     var5 = new AssetTextStream();
                  } catch (Exception var19) {
                     var10001 = false;
                     break label138;
                  }

                  var6 = var4;

                  try {
                     if (!var5.openRead(var2)) {
                        return var6;
                     }

                     var5.getLine();
                     var5.getLine();
                     var5.getLine();
                     var5.readLine();
                     var7 = var5.getInt(0);
                     this.rects = new Rect[var7];
                  } catch (Exception var18) {
                     var10001 = false;
                     break label138;
                  }

                  for(var8 = 0; var8 < var7; ++var8) {
                     Rect var9;
                     Rect[] var26;
                     try {
                        var5.readLine();
                        var26 = this.rects;
                        var9 = new Rect();
                     } catch (Exception var17) {
                        var10001 = false;
                        break label138;
                     }

                     var26[var8] = var9;

                     try {
                        this.rects[var8].x = var5.getInt(0);
                        this.rects[var8].y = var5.getInt(1);
                        this.rects[var8].width = var5.getInt(2);
                        this.rects[var8].height = var5.getInt(3);
                     } catch (Exception var16) {
                        var10001 = false;
                        break label138;
                     }
                  }

                  try {
                     var5.close();
                  } catch (Exception var15) {
                     var10001 = false;
                     break label138;
                  }
               }
            }

            Object var25;
            if ((var3 & 1) != 0) {
               try {
                  var25 = Global.instance.context.openFileInput(var1);
               } catch (Exception var14) {
                  var10001 = false;
                  break label138;
               }
            } else {
               try {
                  var25 = Global.instance.context.getResources().openRawResource(AssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(var1)));
               } catch (Exception var13) {
                  var10001 = false;
                  break label138;
               }
            }

            try {
               this.drawImage(BitmapFactory.decodeStream((InputStream)var25), var3);
               ((InputStream)var25).close();
            } catch (Exception var12) {
               var10001 = false;
               break label138;
            }

            if ((var3 & 2) != 0) {
               try {
                  this.imgWidth /= 2;
                  this.imgHeight /= 2;
                  break label151;
               } catch (Exception var10) {
                  var10001 = false;
               }
            } else {
               if ((var3 & 4) == 0) {
                  break label151;
               }

               try {
                  this.imgWidth *= 2;
                  this.imgHeight *= 2;
                  break label151;
               } catch (Exception var11) {
                  var10001 = false;
               }
            }
         }

         var6 = var4;
         return var6;
      }

      var6 = true;
      return var6;
   }

   public boolean drawText(String var1, String var2, int var3, int var4) {
      return this.drawText(var1, var2, var3, var4, 0, 0);
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
      boolean var1;
      if (this.textureID != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void reset() {
      if (this.textureID != 0) {
         Global.instance.gl10.glDeleteTextures(1, new int[]{this.textureID}, 0);
         this.textureID = 0;
      }

   }
}
