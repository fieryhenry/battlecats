package jp.co.ponos.library.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.ETC1;
import android.opengl.ETC1Util;
import android.opengl.GLES10;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import jp.co.ponos.library.game.stream.AssetTextStream;

public class Texture {
   static Paint paint;
   int textureID;
   int imgWidth;
   int imgHeight;
   int pow2Width;
   int pow2Height;
   TextureLoader loader;
   int f;
   Rect[] rects;

   public static int measureText(String var0, String var1, int var2) {
      setFont(var1, var2);
      return (int) paint.measureText(var0);
   }

   static void setFont(String font, int fontSize) {
      if (paint == null) {
         paint = new Paint();
      }

      paint.setAntiAlias(true);
      paint.setColor(-1);
      if (font.equals("FONT_SYSTEM_BOLD")) {
         paint.setTypeface(Typeface.DEFAULT_BOLD);
      } else if (font.equals("FONT_SYSTEM_ITALIC")) {
         paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
      } else {
         paint.setTypeface((Typeface)null);
      }

      paint.setTextSize((float)fontSize);
   }

   public static int measureText(String var0, int var1) {
      return measureText(var0, "FONT_SYSTEM", var1);
   }

   public Rect getRect(int var1) {
      return this.rects[var1];
   }

   void loadImage(Bitmap bitmap, int i) {
      int[] var3 = new int[1];
      int var4 = bitmap.getWidth();
      this.imgWidth = var4;
      int var5 = bitmap.getHeight();
      this.imgHeight = var5;

      int var6;
      for(var6 = 1; var6 < var4; var6 *= 2) {
      }

      this.pow2Width = var6;

      for(var6 = 1; var6 < var5; var6 *= 2) {
      }

      this.pow2Height = var6;
      Bitmap var13;
      if (!bitmap.hasAlpha() && ETC1Util.isETC1Supported() && (i & 32) == 0) {
         var13 = Bitmap.createBitmap(this.pow2Width, this.pow2Height, Config.RGB_565);
      } else {
         Bitmap.Config var7;
         int var10;
         if (bitmap.hasAlpha()) {
            var6 = this.pow2Width;
            var10 = this.pow2Height;
            if ((i & 16) != 0) {
               var7 = Config.ARGB_4444;
            } else {
               var7 = Config.ARGB_8888;
            }

            var13 = Bitmap.createBitmap(var6, var10, var7);
         } else {
            var10 = this.pow2Width;
            var6 = this.pow2Height;
            if ((i & 16) != 0) {
               var7 = Config.RGB_565;
            } else {
               var7 = Config.ARGB_8888;
            }

            var13 = Bitmap.createBitmap(var10, var6, var7);
         }
      }

      Canvas var8 = new Canvas(var13);
      BitmapDrawable var9 = new BitmapDrawable(bitmap);
      var9.setBounds(0, 0, var4, var5);
      var9.draw(var8);
      Global.instance.gl10.glGenTextures(1, var3, 0);
      Global.instance.gl10.glBindTexture(3553, var3[0]);
      if ((i & 8) != 0) {
         Global.instance.gl10.glTexParameterf(3553, 10241, 9728.0F);
         Global.instance.gl10.glTexParameterf(3553, 10240, 9728.0F);
      } else {
         Global.instance.gl10.glTexParameterf(3553, 10241, 9729.0F);
         Global.instance.gl10.glTexParameterf(3553, 10240, 9729.0F);
      }

      if (!bitmap.hasAlpha() && ETC1Util.isETC1Supported() && (i & 32) == 0) {
         ByteBuffer var11 = ByteBuffer.allocateDirect(var13.getRowBytes() * var13.getHeight()).order(ByteOrder.nativeOrder());
         var13.copyPixelsToBuffer(var11);
         var11.position(0);
         ByteBuffer var14 = ByteBuffer.allocateDirect(ETC1.getEncodedDataSize(var13.getWidth(), var13.getHeight())).order(ByteOrder.nativeOrder());
         ETC1.encodeImage(var11, var13.getWidth(), var13.getHeight(), 2, var13.getWidth() * 2, var14);
         ETC1Util.ETC1Texture var12 = new ETC1Util.ETC1Texture(var13.getWidth(), var13.getHeight(), var14);
         GLES10.glCompressedTexImage2D(3553, 0, 36196, var13.getWidth(), var13.getHeight(), 0, var12.getData().capacity(), var12.getData());
      } else {
         GLUtils.texImage2D(3553, 0, var13, 0);
      }

      var13.recycle();
      this.textureID = var3[0];
   }

   void loadImage(String imgName, int var2) throws Exception {
      Exception var10000;
      label59: {
         boolean var10001;
         label55: {
            label54: {
               try {
                  if (VERSION.SDK_INT >= 14) {
                     break label54;
                  }
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
                  break label59;
               }

               var2 |= 48;
               break label55;
            }

            var2 |= 32;
         }

         Object var9;
         if ((var2 & 1) != 0) {
            try {
               var9 = Global.instance.context.openFileInput(imgName);
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label59;
            }
         } else {
            try {
               var9 = Global.instance.context.getResources().openRawResource(AssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(imgName)));
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
               break label59;
            }
         }

         try {
            this.loadImage(BitmapFactory.decodeStream((InputStream)var9), var2);
            ((InputStream)var9).close();
         } catch (Exception var5) {
            var10000 = var5;
            var10001 = false;
            break label59;
         }

         if ((var2 & 2) != 0) {
            try {
               this.imgWidth /= 2;
               this.imgHeight /= 2;
               return;
            } catch (Exception var3) {
               var10000 = var3;
               var10001 = false;
            }
         } else {
            if ((var2 & 4) == 0) {
               return;
            }

            try {
               this.imgWidth *= 2;
               this.imgHeight *= 2;
               return;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
            }
         }
      }

      Exception var10 = var10000;
      throw var10;
   }

   void loadText(String text, String font, int fontSize, int textMode, int width, int height) {
      String var7 = text;
      if (text.length() == 0) {
         var7 = " ";
      }

      setFont(font, fontSize);
      width = (int) paint.measureText(var7);

      for(fontSize = 1; fontSize < width; fontSize *= 2) {
      }

      Bitmap var8 = Bitmap.createBitmap(fontSize, (int)(paint.descent() - paint.ascent()), Config.ARGB_8888);
      Canvas var9 = new Canvas(var8);
      if (textMode == 0) {
         var9.drawText(var7, 0.0F, (float)((int)(-paint.ascent())), paint);
      } else if (textMode == 1) {
         var9.drawText(var7, (float)((fontSize - width) / 2), (float)((int)(-paint.ascent())), paint);
      } else {
         var9.drawText(var7, (float)(fontSize - width), (float)((int)(-paint.ascent())), paint);
      }

      this.loadImage((Bitmap)var8, 16);
   }

   public boolean loadUnknown() {
      label36: {
         label37: {
            try {
               if (this.loader != null) {
                  if (this.loader instanceof ImageTextureLoader) {
                     this.loadImage(((ImageTextureLoader)this.loader).imgName, ((ImageTextureLoader)this.loader).b);
                     break label36;
                  }

                  if (this.loader instanceof TextTextureLoader) {
                     this.loadText(((TextTextureLoader)this.loader).text, ((TextTextureLoader)this.loader).font, ((TextTextureLoader)this.loader).fontSize, ((TextTextureLoader)this.loader).textMode, ((TextTextureLoader)this.loader).width, ((TextTextureLoader)this.loader).height);
                     break label37;
                  }
               }
            } catch (Exception var3) {
            }
            return false;
         }
         return true;
      }
      return true;
   }

   public boolean load(String var1, String var2) {
      return this.load(var1, var2, 0);
   }

   public boolean load(String var1, String var2, int var3) {
      boolean var4 = false;

      boolean var6;
      label121: {
         label108: {
            boolean var10001;
            try {
               this.reset();
               this.f = var3;
            } catch (Exception var20) {
               var10001 = false;
               break label108;
            }

            if (var2 != null) {
               AssetTextStream var5;
               int var7;
               int var8;
               if ((var3 & 1) != 0) {
                  try {
                     var5 = new AssetTextStream();
                  } catch (Exception var19) {
                     var10001 = false;
                     break label108;
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
                     break label108;
                  }

                  for(var8 = 0; var8 < var7; ++var8) {
                     try {
                        var5.readLine();
                        this.rects[var8].x = var5.getInt(0);
                        this.rects[var8].y = var5.getInt(1);
                        this.rects[var8].width = var5.getInt(2);
                        this.rects[var8].height = var5.getInt(3);
                     } catch (Exception var17) {
                        var10001 = false;
                        break label108;
                     }
                  }

                  try {
                     var5.close();
                  } catch (Exception var16) {
                     var10001 = false;
                     break label108;
                  }
               } else {
                  try {
                     var5 = new AssetTextStream();
                  } catch (Exception var15) {
                     var10001 = false;
                     break label108;
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
                  } catch (Exception var14) {
                     var10001 = false;
                     break label108;
                  }

                  for(var8 = 0; var8 < var7; ++var8) {
                     Rect[] var9;
                     Rect var21;
                     try {
                        var5.readLine();
                        var9 = this.rects;
                        var21 = new Rect();
                     } catch (Exception var13) {
                        var10001 = false;
                        break label108;
                     }

                     var9[var8] = var21;

                     try {
                        this.rects[var8].x = var5.getInt(0);
                        this.rects[var8].y = var5.getInt(1);
                        this.rects[var8].width = var5.getInt(2);
                        this.rects[var8].height = var5.getInt(3);
                     } catch (Exception var12) {
                        var10001 = false;
                        break label108;
                     }
                  }

                  try {
                     var5.close();
                  } catch (Exception var11) {
                     var10001 = false;
                     break label108;
                  }
               }
            }

            try {
               this.loadImage(var1, var3);
               ImageTextureLoader var22 = new ImageTextureLoader(var1, var3);
               this.loader = var22;
               TexturesLoader.getInstance().getTextures().add(this);
               break label121;
            } catch (Exception var10) {
               var10001 = false;
            }
         }

         var6 = var4;
         return var6;
      }

      var6 = true;
      return var6;
   }

   public boolean loadText(String var1, String var2, int var3, int var4) {
      return this.loadTextureLoader(var1, var2, var3, var4, 0, 0);
   }

   public int getImgWidth() {
      return this.imgWidth;
   }

   public boolean loadTextureLoader(String text, String font, int fontSize, int textMode, int width, int height) {
      this.reset();
      this.loadText(text, font, fontSize, textMode, width, height);
      this.loader = new TextTextureLoader(text, font, fontSize, textMode, width, height);
      TexturesLoader.getInstance().getTextures().add(this);
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
         TexturesLoader.getInstance().getTextures().remove(this);
      }

   }
}
