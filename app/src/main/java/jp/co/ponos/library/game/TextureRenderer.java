package jp.co.ponos.library.game;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import jp.co.ponos.battlecats.A;

public class TextureRenderer {
   static TextureRenderer textureRenderer;
   int imageOrientation;
   short[] vertexCoordinatesS = new short[32];
   float[] vertexCoordinatesF = new float[32];
   int[] colors = new int[64];
   int[] vertexCoordinatesI = new int[8];
   ShortBuffer shortBuffer;
   FloatBuffer floatBuffer;
   IntBuffer colorBuffer;
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
      textureRenderer = new TextureRenderer();
   }

   public static TextureRenderer getInstance() {
      return textureRenderer;
   }

   public void updateProjection(float zoom) {
      this.zoomFactor = zoom;
      Global.instance.gl10.glMatrixMode(5889);
      Global.instance.gl10.glLoadIdentity();
      Global.instance.gl10.glOrthof(0.0F, (float) Global.instance.width * this.zoomFactor / 100.0F, (float) Global.instance.height * this.zoomFactor / 100.0F, 0.0F, -1.0F, 1.0F);
      Global.instance.gl10.glMatrixMode(5888);
      Global.instance.gl10.glLoadIdentity();
   }

   public void fillRect(float x, float y, float width, float height) {
      x += this.xOffset;
      y += this.yOffset;
      this.vertexCoordinatesF[0] = x;
      this.vertexCoordinatesF[1] = y;
      this.vertexCoordinatesF[2] = x;
      this.vertexCoordinatesF[3] = y + height;
      this.vertexCoordinatesF[4] = x + width;
      this.vertexCoordinatesF[5] = y;
      this.vertexCoordinatesF[6] = x + width;
      this.vertexCoordinatesF[7] = y + height;
      this.applyTransformation(this.vertexCoordinatesF, 4);
      this.floatBuffer.clear();
      this.floatBuffer.put(this.vertexCoordinatesF);
      this.floatBuffer.position(0);
      Global.instance.gl10.glDisable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, (float)this.alpha / 255.0F);
      Global.instance.gl10.glVertexPointer(2, 5126, 0, this.floatBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
   }

   public void setBlendMode(int blendMode) {
      if (blendMode == 0) {
         this.blendSFactor = 770;
         this.blendDFactor = 771;
      } else if (blendMode == 1) {
         this.blendSFactor = 770;
         this.blendDFactor = 1;
      } else if (blendMode == 3) {
         this.blendSFactor = 0;
         this.blendDFactor = 768;
      } else if (blendMode == 4) {
         this.blendSFactor = 775;
         this.blendDFactor = 1;
      }

   }

   public void setOffset(int x, int y) {
      this.xOffsetI = x;
      this.yOffsetI = y;
      this.xOffset = (float)x;
      this.yOffset = (float)y;
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

   public void drawScaledImage(Texture texture, float x1, float y1, float x2, float y2) {
      this.drawScaledImage(texture, x1, y1, x2, y2, 0, 0, texture.imgWidth, texture.imgHeight);
   }

   public void drawScaledImage(Texture var1, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, int left, int top, int width, int height) {
      float var14 = this.xOffset;
      float var15 = this.yOffset;
      float var16 = this.xOffset;
      float var17 = this.yOffset;
      float var18 = this.xOffset;
      float var19 = this.yOffset;
      float var20 = this.xOffset;
      float var21 = this.yOffset;
      this.vertexCoordinatesF[0] = var14 + x1;
      this.vertexCoordinatesF[1] = var15 + y1;
      this.vertexCoordinatesF[2] = var16 + x2;
      this.vertexCoordinatesF[3] = var17 + y2;
      this.vertexCoordinatesF[4] = var20 + x4;
      this.vertexCoordinatesF[5] = var21 + y4;
      this.vertexCoordinatesF[6] = var18 + x3;
      this.vertexCoordinatesF[7] = var19 + y3;
      this.applyTransformation(this.vertexCoordinatesF, 4);
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

      for(left = 0; left < 4; ++left) {
         this.vertexCoordinatesI[left * 2] = 65536 * this.vertexCoordinatesI[left * 2] / var1.pow2Width;
         this.vertexCoordinatesI[left * 2 + 1] = 65536 * this.vertexCoordinatesI[left * 2 + 1] / var1.pow2Height;
      }

      this.intBuffer.clear();
      this.intBuffer.put(this.vertexCoordinatesI);
      this.intBuffer.position(0);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 260);
      }

      Global.instance.gl10.glEnable(3553);
      if (this.blendSFactor == 770 && this.blendDFactor == 771) {
         Global.instance.gl10.glBlendFunc(1, 771);
         Global.instance.gl10.glColor4f((float)(this.imageRed * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageGreen * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageBlue * this.imageAlpha) / 255.0F / 255.0F, (float)this.imageAlpha / 255.0F);
      } else {
         Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
         Global.instance.gl10.glColor4f((float)this.imageRed / 255.0F, (float)this.imageGreen / 255.0F, (float)this.imageBlue / 255.0F, (float)this.imageAlpha / 255.0F);
      }

      Global.instance.gl10.glBindTexture(3553, var1.textureID);
      Global.instance.gl10.glVertexPointer(2, 5126, 0, this.floatBuffer);
      Global.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 8448);
      }

   }

   public void drawScaledImage(Texture texture, float x, float y, float width, float height, int rectID) {
      this.drawScaledImage(texture, x, y, width, height, texture.rects[rectID].x, texture.rects[rectID].y, texture.rects[rectID].width, texture.rects[rectID].height);
   }

   public void drawScaledImage(Texture texture, float x, float y, float width, float height, int rectX, int rectY, int rectWidth, int rectHeight) {
      x += this.xOffset;
      y += this.yOffset;
      if (this.imageOrientation == 1) {
         this.vertexCoordinatesF[0] = x + width;
         this.vertexCoordinatesF[1] = y;
         this.vertexCoordinatesF[2] = x + width;
         this.vertexCoordinatesF[3] = y + height;
         this.vertexCoordinatesF[4] = x;
         this.vertexCoordinatesF[5] = y;
         this.vertexCoordinatesF[6] = x;
         this.vertexCoordinatesF[7] = y + height;
      } else if (this.imageOrientation == 2) {
         this.vertexCoordinatesF[0] = x;
         this.vertexCoordinatesF[1] = y + height;
         this.vertexCoordinatesF[2] = x;
         this.vertexCoordinatesF[3] = y;
         this.vertexCoordinatesF[4] = x + width;
         this.vertexCoordinatesF[5] = y + height;
         this.vertexCoordinatesF[6] = x + width;
         this.vertexCoordinatesF[7] = y;
      } else if (this.imageOrientation == 3) {
         this.vertexCoordinatesF[0] = x + width;
         this.vertexCoordinatesF[1] = y + height;
         this.vertexCoordinatesF[2] = x + width;
         this.vertexCoordinatesF[3] = y;
         this.vertexCoordinatesF[4] = x;
         this.vertexCoordinatesF[5] = y + height;
         this.vertexCoordinatesF[6] = x;
         this.vertexCoordinatesF[7] = y;
      } else if (this.imageOrientation == 4) {
         this.vertexCoordinatesF[0] = x;
         this.vertexCoordinatesF[1] = y + width;
         this.vertexCoordinatesF[2] = x + height;
         this.vertexCoordinatesF[3] = y + width;
         this.vertexCoordinatesF[4] = x;
         this.vertexCoordinatesF[5] = y;
         this.vertexCoordinatesF[6] = x + height;
         this.vertexCoordinatesF[7] = y;
      } else if (this.imageOrientation == 5) {
         this.vertexCoordinatesF[0] = x + height;
         this.vertexCoordinatesF[1] = y;
         this.vertexCoordinatesF[2] = x;
         this.vertexCoordinatesF[3] = y;
         this.vertexCoordinatesF[4] = x + height;
         this.vertexCoordinatesF[5] = y + width;
         this.vertexCoordinatesF[6] = x;
         this.vertexCoordinatesF[7] = y + width;
      } else {
         this.vertexCoordinatesF[0] = x;
         this.vertexCoordinatesF[1] = y;
         this.vertexCoordinatesF[2] = x;
         this.vertexCoordinatesF[3] = y + height;
         this.vertexCoordinatesF[4] = x + width;
         this.vertexCoordinatesF[5] = y;
         this.vertexCoordinatesF[6] = x + width;
         this.vertexCoordinatesF[7] = y + height;
      }

      this.applyTransformation(this.vertexCoordinatesF, 4);
      this.floatBuffer.clear();
      this.floatBuffer.put(this.vertexCoordinatesF);
      this.floatBuffer.position(0);
      this.vertexCoordinatesI[0] = rectX;
      this.vertexCoordinatesI[1] = rectY;
      this.vertexCoordinatesI[2] = rectX;
      this.vertexCoordinatesI[3] = rectY + rectHeight;
      this.vertexCoordinatesI[4] = rectX + rectWidth;
      this.vertexCoordinatesI[5] = rectY;
      this.vertexCoordinatesI[6] = rectX + rectWidth;
      this.vertexCoordinatesI[7] = rectY + rectHeight;

      for(rectX = 0; rectX < 4; ++rectX) {
         this.vertexCoordinatesI[rectX * 2] = 65536 * this.vertexCoordinatesI[rectX * 2] / texture.pow2Width;
         this.vertexCoordinatesI[rectX * 2 + 1] = 65536 * this.vertexCoordinatesI[rectX * 2 + 1] / texture.pow2Height;
      }

      this.intBuffer.clear();
      this.intBuffer.put(this.vertexCoordinatesI);
      this.intBuffer.position(0);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 260);
      }

      Global.instance.gl10.glEnable(3553);
      if (this.blendSFactor == 770 && this.blendDFactor == 771) {
         Global.instance.gl10.glBlendFunc(1, 771);
         Global.instance.gl10.glColor4f((float)(this.imageRed * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageGreen * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageBlue * this.imageAlpha) / 255.0F / 255.0F, (float)this.imageAlpha / 255.0F);
      } else {
         Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
         Global.instance.gl10.glColor4f((float)this.imageRed / 255.0F, (float)this.imageGreen / 255.0F, (float)this.imageBlue / 255.0F, (float)this.imageAlpha / 255.0F);
      }

      Global.instance.gl10.glBindTexture(3553, texture.textureID);
      Global.instance.gl10.glVertexPointer(2, 5126, 0, this.floatBuffer);
      Global.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 8448);
      }

   }

   public void drawScaledImage(Texture texture, float x, float var3, float var4, float var5, int var6, int var7, int var8, int var9, float var10, int var11) {
      this.drawScaledImage(texture, x, var3, var4, var5, var6, var7, var8, var9, var10, texture.rects[var11].x, texture.rects[var11].y, texture.rects[var11].width, texture.rects[var11].height);
   }

   public void drawScaledImage(Texture var1, float x, float y, float width, float height, int var6, int var7, int var8, int var9, float var10, int rectX, int rectY, int rectWidth, int rectHeight) {
      float var15;
      if ((var6 & 1) != 0) {
         var15 = x - width / 2.0F + this.xOffset;
      } else if ((var6 & 2) != 0) {
         var15 = x - width + this.xOffset;
      } else {
         var15 = this.xOffset + x;
      }

      float var16;
      if ((var6 & 4) != 0) {
         var16 = y - height / 2.0F + this.yOffset;
      } else if ((var6 & 8) != 0) {
         var16 = y - height + this.yOffset;
      } else {
         var16 = this.yOffset + y;
      }

      if ((var9 & 16) != 0) {
         y = (float)(this.xOffsetI + var7);
         x = (float)(this.yOffsetI + var8);
      } else {
         if ((var9 & 1) != 0) {
            x = width / 2.0F;
            y = (float)var7 + x + var15;
         } else if ((var9 & 2) != 0) {
            y = (float)var7 + var15 + width;
         } else {
            y = var15 + (float)var7;
         }

         if ((var9 & 4) != 0) {
            x = height / 2.0F + var16 + (float)var8;
         } else if ((var9 & 8) != 0) {
            x = var16 + height + (float)var8;
         } else {
            x = (float)var8 + var16;
         }
      }

      var15 -= y;
      var16 -= x;
      width += var15;
      height += var16;
      float var17 = -var10;
      float var18 = aMath.cos(var17);
      float var19 = aMath.sin(var17);
      float var20 = -var15;
      float var21 = aMath.sin(var17);
      float var22 = aMath.cos(var17);
      float var23 = aMath.cos(var17);
      float var24 = aMath.sin(var17);
      var10 = -var15;
      float var25 = aMath.sin(var17);
      float var26 = aMath.cos(var17);
      float var27 = aMath.cos(var17);
      float var28 = aMath.sin(var17);
      float var29 = -width;
      float var30 = aMath.sin(var17);
      this.drawScaledImage(var1, var18 * var15 + var19 * var16 + y, var20 * var21 + var22 * var16 + x, var23 * var15 + var24 * height + y, var10 * var25 + var26 * height + x, var27 * width + var28 * height + y, height * aMath.cos(var17) + var29 * var30 + x, aMath.cos(var17) * width + aMath.sin(var17) * var16 + y, -width * aMath.sin(var17) + var16 * aMath.cos(var17) + x, rectX, rectY, rectWidth, rectHeight);
   }

   public void drawScaledImage(Texture texture, int x, int y) {
      this.drawScaledImage(texture, x, y, 0);
   }

   public void drawScaledImage(Texture texture, int x, int y, int orientation) {
      int var5 = x + this.xOffsetI;
      int var6 = this.yOffsetI + y;
      if ((orientation & 1) != 0) {
         x = var5 - texture.imgWidth / 2;
      } else {
         x = var5;
         if ((orientation & 2) != 0) {
            x = var5 - texture.imgWidth;
         }
      }

      if ((orientation & 4) != 0) {
         y = var6 - texture.imgHeight / 2;
      } else {
         y = var6;
         if ((orientation & 8) != 0) {
            y = var6 - texture.imgHeight;
         }
      }

      this.vertexCoordinatesS[0] = (short)((short)x);
      this.vertexCoordinatesS[1] = (short)((short)y);
      this.vertexCoordinatesS[2] = (short)((short)x);
      this.vertexCoordinatesS[3] = (short)((short)(texture.imgHeight + y));
      this.vertexCoordinatesS[4] = (short)((short)(texture.imgWidth + x));
      this.vertexCoordinatesS[5] = (short)((short)y);
      this.vertexCoordinatesS[6] = (short)((short)(x + texture.imgWidth));
      this.vertexCoordinatesS[7] = (short)((short)(y + texture.imgHeight));
      this.applyTransformation(this.vertexCoordinatesS, 4);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      this.vertexCoordinatesI[0] = 0;
      this.vertexCoordinatesI[1] = 0;
      this.vertexCoordinatesI[2] = 0;
      this.vertexCoordinatesI[3] = texture.imgHeight;
      this.vertexCoordinatesI[4] = texture.imgWidth;
      this.vertexCoordinatesI[5] = 0;
      this.vertexCoordinatesI[6] = texture.imgWidth;
      this.vertexCoordinatesI[7] = texture.imgHeight;

      for(x = 0; x < 4; ++x) {
         this.vertexCoordinatesI[x * 2] = 65536 * this.vertexCoordinatesI[x * 2] / texture.pow2Width;
         this.vertexCoordinatesI[x * 2 + 1] = 65536 * this.vertexCoordinatesI[x * 2 + 1] / texture.pow2Height;
      }

      this.intBuffer.clear();
      this.intBuffer.put(this.vertexCoordinatesI);
      this.intBuffer.position(0);
      Global.instance.gl10.glEnable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, (float)this.alpha / 255.0F);
      Global.instance.gl10.glBindTexture(3553, texture.textureID);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
   }

   public void drawScaledImageI(Texture texture, int x, int y, int width, int height) {
      this.drawScaledImageI(texture, x, y, width, height, 0, 0, texture.imgWidth, texture.imgHeight);
   }

   public void drawScaledImageI(Texture texture, int x, int y, int width, int height, int rectID) {
      this.drawScaledImageI(texture, x, y, width, height, texture.rects[rectID].x, texture.rects[rectID].y, texture.rects[rectID].width, texture.rects[rectID].height);
   }

   public void drawScaledImageI(Texture texture, int x, int y, int width, int height, int rectX, int rectY, int rectWidth, int rectHeight) {
      x += this.xOffsetI;
      y += this.yOffsetI;
      if (this.imageOrientation == 1) {
         this.vertexCoordinatesS[0] = (short)((short)(x + width));
         this.vertexCoordinatesS[1] = (short)((short)y);
         this.vertexCoordinatesS[2] = (short)((short)(x + width));
         this.vertexCoordinatesS[3] = (short)((short)(y + height));
         this.vertexCoordinatesS[4] = (short)((short)x);
         this.vertexCoordinatesS[5] = (short)((short)y);
         this.vertexCoordinatesS[6] = (short)((short)x);
         this.vertexCoordinatesS[7] = (short)((short)(y + height));
      } else if (this.imageOrientation == 2) {
         this.vertexCoordinatesS[0] = (short)((short)x);
         this.vertexCoordinatesS[1] = (short)((short)(y + height));
         this.vertexCoordinatesS[2] = (short)((short)x);
         this.vertexCoordinatesS[3] = (short)((short)y);
         this.vertexCoordinatesS[4] = (short)((short)(x + width));
         this.vertexCoordinatesS[5] = (short)((short)(y + height));
         this.vertexCoordinatesS[6] = (short)((short)(x + width));
         this.vertexCoordinatesS[7] = (short)((short)y);
      } else if (this.imageOrientation == 3) {
         this.vertexCoordinatesS[0] = (short)((short)(x + width));
         this.vertexCoordinatesS[1] = (short)((short)(y + height));
         this.vertexCoordinatesS[2] = (short)((short)(x + width));
         this.vertexCoordinatesS[3] = (short)((short)y);
         this.vertexCoordinatesS[4] = (short)((short)x);
         this.vertexCoordinatesS[5] = (short)((short)(y + height));
         this.vertexCoordinatesS[6] = (short)((short)x);
         this.vertexCoordinatesS[7] = (short)((short)y);
      } else if (this.imageOrientation == 4) {
         this.vertexCoordinatesS[0] = (short)((short)x);
         this.vertexCoordinatesS[1] = (short)((short)(y + width));
         this.vertexCoordinatesS[2] = (short)((short)(x + height));
         this.vertexCoordinatesS[3] = (short)((short)(y + width));
         this.vertexCoordinatesS[4] = (short)((short)x);
         this.vertexCoordinatesS[5] = (short)((short)y);
         this.vertexCoordinatesS[6] = (short)((short)(x + height));
         this.vertexCoordinatesS[7] = (short)((short)y);
      } else if (this.imageOrientation == 5) {
         this.vertexCoordinatesS[0] = (short)((short)(x + height));
         this.vertexCoordinatesS[1] = (short)((short)y);
         this.vertexCoordinatesS[2] = (short)((short)x);
         this.vertexCoordinatesS[3] = (short)((short)y);
         this.vertexCoordinatesS[4] = (short)((short)(x + height));
         this.vertexCoordinatesS[5] = (short)((short)(y + width));
         this.vertexCoordinatesS[6] = (short)((short)x);
         this.vertexCoordinatesS[7] = (short)((short)(y + width));
      } else {
         this.vertexCoordinatesS[0] = (short)((short)x);
         this.vertexCoordinatesS[1] = (short)((short)y);
         this.vertexCoordinatesS[2] = (short)((short)x);
         this.vertexCoordinatesS[3] = (short)((short)(y + height));
         this.vertexCoordinatesS[4] = (short)((short)(x + width));
         this.vertexCoordinatesS[5] = (short)((short)y);
         this.vertexCoordinatesS[6] = (short)((short)(x + width));
         this.vertexCoordinatesS[7] = (short)((short)(y + height));
      }

      this.applyTransformation(this.vertexCoordinatesS, 4);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      this.vertexCoordinatesI[0] = rectX;
      this.vertexCoordinatesI[1] = rectY;
      this.vertexCoordinatesI[2] = rectX;
      this.vertexCoordinatesI[3] = rectY + rectHeight;
      this.vertexCoordinatesI[4] = rectX + rectWidth;
      this.vertexCoordinatesI[5] = rectY;
      this.vertexCoordinatesI[6] = rectX + rectWidth;
      this.vertexCoordinatesI[7] = rectY + rectHeight;

      for(x = 0; x < 4; ++x) {
         this.vertexCoordinatesI[x * 2] = 65536 * this.vertexCoordinatesI[x * 2] / texture.pow2Width;
         this.vertexCoordinatesI[x * 2 + 1] = 65536 * this.vertexCoordinatesI[x * 2 + 1] / texture.pow2Height;
      }

      this.intBuffer.clear();
      this.intBuffer.put(this.vertexCoordinatesI);
      this.intBuffer.position(0);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 260);
      }

      Global.instance.gl10.glEnable(3553);
      if (this.blendSFactor == 770 && this.blendDFactor == 771) {
         Global.instance.gl10.glBlendFunc(1, 771);
         Global.instance.gl10.glColor4f((float)(this.imageRed * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageGreen * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageBlue * this.imageAlpha) / 255.0F / 255.0F, (float)this.imageAlpha / 255.0F);
      } else {
         Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
         Global.instance.gl10.glColor4f((float)this.imageRed / 255.0F, (float)this.imageGreen / 255.0F, (float)this.imageBlue / 255.0F, (float)this.imageAlpha / 255.0F);
      }

      Global.instance.gl10.glBindTexture(3553, texture.textureID);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 8448);
      }

   }

   public void drawScaledImageI(Texture texture, int x, int y, int width, int height, int positionFlag, int xOffset, int yOffset, int offsetFlag, float angle, int rectID) {
      this.drawScaledImageI(texture, x, y, width, height, positionFlag, xOffset, yOffset, offsetFlag, angle, texture.rects[rectID].x, texture.rects[rectID].y, texture.rects[rectID].width, texture.rects[rectID].height);
   }

   public void drawScaledImageI(Texture texture, int x, int y, int width, int height, int positionFlag, int xOffset, int yOffset, int offsetFlag, float angle, int rectX, int rectY, int rectWidth, int rectHeight) {
      int var15;
      if ((positionFlag & 1) != 0) {
         var15 = x - width / 2 + this.xOffsetI;
      } else if ((positionFlag & 2) != 0) {
         var15 = x - width + this.xOffsetI;
      } else {
         var15 = this.xOffsetI + x;
      }

      if ((positionFlag & 4) != 0) {
         positionFlag = y - height / 2 + this.yOffsetI;
      } else if ((positionFlag & 8) != 0) {
         positionFlag = y - height + this.yOffsetI;
      } else {
         positionFlag = this.yOffsetI + y;
      }

      if ((offsetFlag & 16) != 0) {
         y = xOffset + this.xOffsetI;
         x = this.yOffsetI + yOffset;
      } else {
         if ((offsetFlag & 1) != 0) {
            y = width / 2 + var15 + xOffset;
         } else if ((offsetFlag & 2) != 0) {
            y = var15 + width + xOffset;
         } else {
            y = var15 + xOffset;
         }

         if ((offsetFlag & 4) != 0) {
            x = height / 2 + positionFlag + yOffset;
         } else if ((offsetFlag & 8) != 0) {
            x = positionFlag + height + yOffset;
         } else {
            x = positionFlag + yOffset;
         }
      }

      offsetFlag = var15 - y;
      positionFlag -= x;
      width += offsetFlag;
      int var16 = positionFlag + height;
      angle = -angle;
      xOffset = (int)((float)offsetFlag * aMath.cos(angle) + (float)positionFlag * aMath.sin(angle) + (float)y);
      height = (int)((float)(-offsetFlag) * aMath.sin(angle) + (float)positionFlag * aMath.cos(angle) + (float)x);
      yOffset = (int)((float)offsetFlag * aMath.cos(angle) + (float)var16 * aMath.sin(angle) + (float)y);
      var15 = (int)((float)(-offsetFlag) * aMath.sin(angle) + (float)var16 * aMath.cos(angle) + (float)x);
      offsetFlag = (int)((float)width * aMath.cos(angle) + (float)var16 * aMath.sin(angle) + (float)y);
      float var17 = (float)(-width);
      float var18 = aMath.sin(angle);
      var16 = (int)((float)var16 * aMath.cos(angle) + var17 * var18 + (float)x);
      var18 = (float)width;
      var17 = aMath.cos(angle);
      float var19 = (float)positionFlag;
      float var20 = aMath.sin(angle);
      y = (int)((float)y + var18 * var17 + var19 * var20);
      var18 = (float)(-width);
      var20 = aMath.sin(angle);
      var17 = (float)positionFlag;
      angle = aMath.cos(angle);
      this.drawScaledImageI(texture, xOffset, height, yOffset, var15, offsetFlag, var16, y, (int)((float)x + var18 * var20 + var17 * angle), rectX, rectY, rectWidth, rectHeight);
   }

   public void drawScaledImageI(Texture texture, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int rectID) {
      this.drawScaledImageI(texture, x1, y1, x2, y2, x3, y3, x4, y4, texture.rects[rectID].x, texture.rects[rectID].y, texture.rects[rectID].width, texture.rects[rectID].height);
   }

   public void drawScaledImageI(Texture texture, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int rectX, int rectY, int rectWidth, int rectHeight) {
      int var14 = this.xOffsetI;
      int var15 = this.yOffsetI;
      int var16 = this.xOffsetI;
      int var17 = this.yOffsetI;
      int var18 = this.xOffsetI;
      int var19 = this.yOffsetI;
      int var20 = this.xOffsetI;
      int var21 = this.yOffsetI;
      this.vertexCoordinatesS[0] = (short)((short)(var14 + x1));
      this.vertexCoordinatesS[1] = (short)((short)(var15 + y1));
      this.vertexCoordinatesS[2] = (short)((short)(var16 + x2));
      this.vertexCoordinatesS[3] = (short)((short)(var17 + y2));
      this.vertexCoordinatesS[4] = (short)((short)(var20 + x4));
      this.vertexCoordinatesS[5] = (short)((short)(var21 + y4));
      this.vertexCoordinatesS[6] = (short)((short)(var18 + x3));
      this.vertexCoordinatesS[7] = (short)((short)(var19 + y3));
      this.applyTransformation(this.vertexCoordinatesS, 4);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      this.vertexCoordinatesI[0] = rectX;
      this.vertexCoordinatesI[1] = rectY;
      this.vertexCoordinatesI[2] = rectX;
      this.vertexCoordinatesI[3] = rectY + rectHeight;
      this.vertexCoordinatesI[4] = rectX + rectWidth;
      this.vertexCoordinatesI[5] = rectY;
      this.vertexCoordinatesI[6] = rectX + rectWidth;
      this.vertexCoordinatesI[7] = rectY + rectHeight;

      for(x1 = 0; x1 < 4; ++x1) {
         this.vertexCoordinatesI[x1 * 2] = 65536 * this.vertexCoordinatesI[x1 * 2] / texture.pow2Width;
         this.vertexCoordinatesI[x1 * 2 + 1] = 65536 * this.vertexCoordinatesI[x1 * 2 + 1] / texture.pow2Height;
      }

      this.intBuffer.clear();
      this.intBuffer.put(this.vertexCoordinatesI);
      this.intBuffer.position(0);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 260);
      }

      Global.instance.gl10.glEnable(3553);
      if (this.blendSFactor == 770 && this.blendDFactor == 771) {
         Global.instance.gl10.glBlendFunc(1, 771);
         Global.instance.gl10.glColor4f((float)(this.imageRed * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageGreen * this.imageAlpha) / 255.0F / 255.0F, (float)(this.imageBlue * this.imageAlpha) / 255.0F / 255.0F, (float)this.imageAlpha / 255.0F);
      } else {
         Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
         Global.instance.gl10.glColor4f((float)this.imageRed / 255.0F, (float)this.imageGreen / 255.0F, (float)this.imageBlue / 255.0F, (float)this.imageAlpha / 255.0F);
      }

      Global.instance.gl10.glBindTexture(3553, texture.textureID);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glTexCoordPointer(2, 5132, 0, this.intBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
      if (this.additiveBlending == 1) {
         Global.instance.gl10.glTexEnvx(8960, 8704, 8448);
      }

   }

   public void setAnimTransformer(AnimTransformer animTransformer) {
      this.animTransformer = animTransformer;
   }

   public void setTextures(Model model, int var2, int var3) {
      int var4 = this.blendSFactor;
      int var5 = this.blendDFactor;
      int var6 = this.imageAlpha;
      model.setTextures(this, var2, var3);
      this.blendSFactor = var4;
      this.blendDFactor = var5;
      this.imageAlpha = var6;
   }

   void applyTransformation(float[] coordinates, int pairCount) {
      if (this.animTransformer != null) {
         for(int var3 = 0; var3 < pairCount; ++var3) {
            float var4 = coordinates[var3 * 2];
            float var5 = coordinates[var3 * 2 + 1];
            coordinates[var3 * 2] = this.animTransformer.a[0] * var4 + this.animTransformer.a[1] * var5 + this.animTransformer.a[2];
            coordinates[var3 * 2 + 1] = var4 * this.animTransformer.a[3] + var5 * this.animTransformer.a[4] + this.animTransformer.a[5];
         }
      }

   }

   public void drawVertices(int[] xCoordinates, int[] yCoordinates, int pairCount) {
      for(int var4 = 0; var4 < pairCount; ++var4) {
         this.vertexCoordinatesS[var4 * 2] = (short)((short)(xCoordinates[var4] + this.xOffsetI));
         this.vertexCoordinatesS[var4 * 2 + 1] = (short)((short)(yCoordinates[var4] + this.yOffsetI));
      }

      this.applyTransformation(this.vertexCoordinatesS, pairCount);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      Global.instance.gl10.glDisable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, (float)this.alpha / 255.0F);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glDrawArrays(6, 0, pairCount);
   }

   public void a(int[] var1, int[] var2, int[] var3, int var4) {
      for(int var5 = 0; var5 < var4; ++var5) {
         this.vertexCoordinatesS[var5 * 2] = (short)((short)(var1[var5] + this.xOffsetI));
         this.vertexCoordinatesS[var5 * 2 + 1] = (short)((short)(var2[var5] + this.yOffsetI));
         this.colors[var5 * 4] = (var3[var5] >> 16 & 255) * 65536 / 255;
         this.colors[var5 * 4 + 1] = (var3[var5] >> 8 & 255) * 65536 / 255;
         this.colors[var5 * 4 + 2] = (var3[var5] & 255) * 65536 / 255;
         this.colors[var5 * 4 + 3] = (var3[var5] >> 24 & 255) * 65536 / 255;
      }

      this.applyTransformation(this.vertexCoordinatesS, var4);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      this.colorBuffer.clear();
      this.colorBuffer.put(this.colors);
      this.colorBuffer.position(0);
      Global.instance.gl10.glEnableClientState(32886);
      Global.instance.gl10.glDisable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glColorPointer(4, 5132, 0, this.colorBuffer);
      Global.instance.gl10.glDrawArrays(6, 0, var4);
      Global.instance.gl10.glDisableClientState(32886);
   }

   void applyTransformation(short[] coordinates, int pairCount) {
      if (this.animTransformer != null) {
         for(int var3 = 0; var3 < pairCount; ++var3) {
            float var4 = coordinates[var3 * 2];
            float var5 = coordinates[var3 * 2 + 1];
            coordinates[var3 * 2] = (short)((short)((int)(this.animTransformer.a[0] * var4 + this.animTransformer.a[1] * var5 + this.animTransformer.a[2])));
            coordinates[var3 * 2 + 1] = (short)((short)((int)(var4 * this.animTransformer.a[3] + var5 * this.animTransformer.a[4] + this.animTransformer.a[5])));
         }
      }

   }

   public void setAlpha(int alpha) {
      this.alpha = alpha;
   }

   public void setImageColor(int red, int green, int blue) {
      this.imageRed = red;
      this.imageGreen = green;
      this.imageBlue = blue;
      this.imageAlpha = 255;
   }

   public void drawLine(int x1, int y1, int x2, int y2) {
      int var5 = this.xOffsetI;
      int var6 = this.yOffsetI;
      int var7 = this.xOffsetI;
      int var8 = this.yOffsetI;
      this.vertexCoordinatesS[0] = (short)((short)(var5 + x1));
      this.vertexCoordinatesS[1] = (short)((short)(var6 + y1));
      this.vertexCoordinatesS[2] = (short)((short)(var7 + x2));
      this.vertexCoordinatesS[3] = (short)((short)(var8 + y2));
      this.applyTransformation(this.vertexCoordinatesS, 2);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      Global.instance.gl10.glDisable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, (float)this.alpha / 255.0F);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glDrawArrays(1, 0, 2);
   }

   public void drawScaledImageI(Texture texture, int x, int y, int rectID) {
      this.drawScaledImageI(texture, x, y, texture.rects[rectID].width, texture.rects[rectID].height, texture.rects[rectID].x, texture.rects[rectID].y, texture.rects[rectID].width, texture.rects[rectID].height);
   }

   public void setupGL() {
      Global.instance.gl10.glViewport(Global.instance.viewportX, Global.instance.viewportY, Global.instance.viewportWidth, Global.instance.viewportHeight);
      Global.instance.gl10.glTexEnvx(8960, 8704, 8448);
      Global.instance.gl10.glEnableClientState(32884);
      Global.instance.gl10.glEnableClientState(32888);
      Global.instance.gl10.glEnable(3042);
      ByteBuffer var1 = ByteBuffer.allocateDirect(this.vertexCoordinatesS.length * 2);
      var1.order(ByteOrder.nativeOrder());
      this.shortBuffer = var1.asShortBuffer();
      var1 = ByteBuffer.allocateDirect(this.vertexCoordinatesS.length * 4);
      var1.order(ByteOrder.nativeOrder());
      this.floatBuffer = var1.asFloatBuffer();
      var1 = ByteBuffer.allocateDirect(this.colors.length * 4);
      var1.order(ByteOrder.nativeOrder());
      this.colorBuffer = var1.asIntBuffer();
      var1 = ByteBuffer.allocateDirect(this.vertexCoordinatesI.length * 4);
      var1.order(ByteOrder.nativeOrder());
      this.intBuffer = var1.asIntBuffer();
      this.setOffset(0, 0);
      this.setBlendMode(0);
      this.removeAnimTransformer();
      this.setColor(0, 0, 0, 255);
      this.setImageColor(255, 255, 255, 255);
   }

   public void setImageAlpha(int imageAlpha) {
      this.imageAlpha = imageAlpha;
   }

   public void drawRectButton(int[] buttonCoordinates) {
      this.drawRectangle(buttonCoordinates[0], buttonCoordinates[1], buttonCoordinates[2], buttonCoordinates[3]);
   }
   public void drawRectButtons(int[][] buttonCoordinates) { // purely for dev stuff
      for(int i = 0; i < buttonCoordinates.length; i++) {
         if (buttonCoordinates[i][2] == 0 || buttonCoordinates[i][3] == 0) {
            continue;
         }
         if (!A.a().isTouching(buttonCoordinates[i][0], buttonCoordinates[i][1], buttonCoordinates[i][2], buttonCoordinates[i][3])) {
            this.setColor(100, 100, 100, 150);
         }
         else {
            this.setColor(254, 0, 0, 150);
         }
         Texture texture = new Texture();
         String buttonText = aString.format("%d", i);
         texture.loadText(buttonText, "FONT_SYSTEM_BOLD", 30, 1);
         this.drawScaledImageI(texture, buttonCoordinates[i][0], buttonCoordinates[i][1], texture.imgWidth, texture.imgHeight);
         this.drawRectangle(buttonCoordinates[i][0], buttonCoordinates[i][1], buttonCoordinates[i][2], buttonCoordinates[i][3]);
      }
   }
   public void drawRectangle(int x, int y, int width, int height) {
      x += this.xOffsetI;
      y += this.yOffsetI;
      this.vertexCoordinatesS[0] = (short)((short)x);
      this.vertexCoordinatesS[1] = (short)((short)y);
      this.vertexCoordinatesS[2] = (short)((short)x);
      this.vertexCoordinatesS[3] = (short)((short)(y + height));
      this.vertexCoordinatesS[4] = (short)((short)(x + width));
      this.vertexCoordinatesS[5] = (short)((short)y);
      this.vertexCoordinatesS[6] = (short)((short)(x + width));
      this.vertexCoordinatesS[7] = (short)((short)(y + height));
      this.applyTransformation(this.vertexCoordinatesS, 4);
      this.shortBuffer.clear();
      this.shortBuffer.put(this.vertexCoordinatesS);
      this.shortBuffer.position(0);
      Global.instance.gl10.glDisable(3553);
      Global.instance.gl10.glBlendFunc(this.blendSFactor, this.blendDFactor);
      Global.instance.gl10.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, (float)this.alpha / 255.0F);
      Global.instance.gl10.glVertexPointer(2, 5122, 0, this.shortBuffer);
      Global.instance.gl10.glDrawArrays(5, 0, 4);
   }

   public void clearScreen() {
      Global.instance.gl10.glClearColorx(0, 0, 0, 65535);
      Global.instance.gl10.glClear(16640);
   }

   public void setImageOrientation(int var1) {
      this.imageOrientation = var1;
   }

   public void setImageColor(int var1, int var2, int var3, int var4) {
      this.imageRed = var1;
      this.imageGreen = var2;
      this.imageBlue = var3;
      this.imageAlpha = var4;
   }

   public void resetProjection() {
      this.updateProjection(100.0F);
   }

   public void removeAnimTransformer() {
      this.setAnimTransformer(null);
   }
}
