package jp.co.ponos.library.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLUtils;
import java.io.InputStream;

import jp.co.ponos.library.game.stream.AssetTextStream;

public class Texture {
   static Paint h;
   int a;
   int imgWidth;
   int imgHeight;
   int d;
   int e;
   int f;
   Rect[] rects;

   static void a(String var0, int var1) {
      if (h == null) {
         h = new Paint();
      }

      h.setAntiAlias(true);
      h.setColor(-1);
      if (var0.equals("FONT_SYSTEM_BOLD")) {
         h.setTypeface(Typeface.DEFAULT_BOLD);
      } else if (var0.equals("FONT_SYSTEM_ITALIC")) {
         h.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
      } else {
         h.setTypeface((Typeface)null);
      }

      h.setTextSize((float)var1);
   }

   public static int b(String var0, int var1) {
      return b(var0, "FONT_SYSTEM", var1);
   }

   public static int b(String var0, String var1, int var2) {
      a(var1, var2);
      return (int)h.measureText(var0);
   }

   public int a() {
      return this.imgWidth;
   }

   public Rect a(int var1) {
      return this.rects[var1];
   }

   void a(Bitmap var1, int var2) {
      int[] var3 = new int[1];
      int var4 = var1.getWidth();
      this.imgWidth = var4;
      int var5 = var1.getHeight();
      this.imgHeight = var5;

      int var6;
      for(var6 = 1; var6 < var4; var6 *= 2) {
      }

      this.d = var6;

      for(var6 = 1; var6 < var5; var6 *= 2) {
      }

      this.e = var6;
      Bitmap var7 = Bitmap.createBitmap(this.d, this.e, Config.ARGB_8888);
      Canvas var8 = new Canvas(var7);
      BitmapDrawable var9 = new BitmapDrawable(var1);
      var9.setBounds(0, 0, var4, var5);
      var9.draw(var8);
      Global.instance.gl10.glGenTextures(1, var3, 0);
      Global.instance.gl10.glBindTexture(3553, var3[0]);
      if ((var2 & 8) != 0) {
         Global.instance.gl10.glTexParameterf(3553, 10241, 9728.0F);
         Global.instance.gl10.glTexParameterf(3553, 10240, 9728.0F);
      } else {
         Global.instance.gl10.glTexParameterf(3553, 10241, 9729.0F);
         Global.instance.gl10.glTexParameterf(3553, 10240, 9729.0F);
      }

      GLUtils.texImage2D(3553, 0, var7, 0);
      this.a = var3[0];
   }

   public boolean load(String var1, String var2) {
      return this.a(var1, var2, 0);
   }

   public boolean a(String var1, String var2, int var3) {
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
               this.a(BitmapFactory.decodeStream((InputStream)var25), var3);
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

   public boolean a(String var1, String var2, int var3, int var4) {
      return this.a(var1, var2, var3, var4, 0, 0);
   }

   public boolean a(String var1, String var2, int var3, int var4, int var5, int var6) {
      String var7 = var1;
      if (var1.length() == 0) {
         var7 = " ";
      }

      a(var2, var3);
      var5 = (int)h.measureText(var7);

      for(var3 = 1; var3 < var5; var3 *= 2) {
      }

      Bitmap var8 = Bitmap.createBitmap(var3, (int)(h.descent() - h.ascent()), Config.ARGB_8888);
      Canvas var9 = new Canvas(var8);
      if (var4 == 0) {
         var9.drawText(var7, 0.0F, (float)((int)(-h.ascent())), h);
      } else if (var4 == 1) {
         var9.drawText(var7, (float)((var3 - var5) / 2), (float)((int)(-h.ascent())), h);
      } else {
         var9.drawText(var7, (float)(var3 - var5), (float)((int)(-h.ascent())), h);
      }

      this.a((Bitmap)var8, 0);
      return true;
   }

   public boolean isLoaded() {
      boolean var1;
      if (this.a != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void reset() {
      if (this.a != 0) {
         Global.instance.gl10.glDeleteTextures(1, new int[]{this.a}, 0);
         this.a = 0;
      }

   }
}
