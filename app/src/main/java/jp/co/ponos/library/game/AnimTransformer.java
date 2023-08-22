package jp.co.ponos.library.game;

public class AnimTransformer {
   float[] a = new float[9];

   public AnimTransformer() {
      this.a();
   }

   public void a() {
      this.a[0] = 1.0F;
      this.a[1] = 0.0F;
      this.a[2] = 0.0F;
      this.a[3] = 0.0F;
      this.a[4] = 1.0F;
      this.a[5] = 0.0F;
      this.a[6] = 0.0F;
      this.a[7] = 0.0F;
      this.a[8] = 1.0F;
   }

   public void a(float var1, float var2) {
      this.a[0] = var1 / 100.0F;
      this.a[1] = 0.0F;
      this.a[2] = 0.0F;
      this.a[3] = 0.0F;
      this.a[4] = var2 / 100.0F;
      this.a[5] = 0.0F;
      this.a[6] = 0.0F;
      this.a[7] = 0.0F;
      this.a[8] = 1.0F;
   }

   public void a(int var1, int var2, Point var3) {
      var3.x = (int)(this.a[0] * (float)var1 + this.a[1] * (float)var2 + this.a[2]);
      var3.y = (int)(this.a[3] * (float)var1 + this.a[4] * (float)var2 + this.a[5]);
   }

   public void a(AnimTransformer var1) {
      float var2 = this.a[0];
      float var3 = var1.a[0];
      float var4 = this.a[1];
      float var5 = var1.a[3];
      float var6 = this.a[2];
      float var7 = var1.a[6];
      float var8 = this.a[0];
      float var9 = var1.a[1];
      float var10 = this.a[1];
      float var11 = var1.a[4];
      float var12 = this.a[2];
      float var13 = var1.a[7];
      float var14 = this.a[0];
      float var15 = var1.a[2];
      float var16 = this.a[1];
      float var17 = var1.a[5];
      float var18 = this.a[2];
      float var19 = var1.a[8];
      float var20 = this.a[3];
      float var21 = var1.a[0];
      float var22 = this.a[4];
      float var23 = var1.a[3];
      float var24 = this.a[5];
      float var25 = var1.a[6];
      float var26 = this.a[3];
      float var27 = var1.a[1];
      float var28 = this.a[4];
      float var29 = var1.a[4];
      float var30 = this.a[5];
      float var31 = var1.a[7];
      float var32 = this.a[3];
      float var33 = var1.a[2];
      float var34 = this.a[4];
      float var35 = var1.a[5];
      float var36 = this.a[5];
      float var37 = var1.a[8];
      float var38 = this.a[6];
      float var39 = var1.a[0];
      float var40 = this.a[7];
      float var41 = var1.a[3];
      float var42 = this.a[8];
      float var43 = var1.a[6];
      float var44 = this.a[6];
      float var45 = var1.a[1];
      float var46 = this.a[7];
      float var47 = var1.a[4];
      float var48 = this.a[8];
      float var49 = var1.a[7];
      float var50 = this.a[6];
      float var51 = var1.a[2];
      float var52 = this.a[7];
      float var53 = var1.a[5];
      float var54 = this.a[8];
      float var55 = var1.a[8];
      this.a[0] = var2 * var3 + var4 * var5 + var6 * var7;
      this.a[1] = var8 * var9 + var10 * var11 + var12 * var13;
      this.a[2] = var14 * var15 + var16 * var17 + var18 * var19;
      this.a[3] = var20 * var21 + var22 * var23 + var24 * var25;
      this.a[4] = var26 * var27 + var28 * var29 + var30 * var31;
      this.a[5] = var32 * var33 + var34 * var35 + var36 * var37;
      this.a[6] = var38 * var39 + var40 * var41 + var42 * var43;
      this.a[7] = var44 * var45 + var46 * var47 + var48 * var49;
      this.a[8] = var50 * var51 + var52 * var53 + var54 * var55;
   }

   public void b(float var1, float var2) {
      this.a[0] = 1.0F;
      this.a[1] = 0.0F;
      this.a[2] = var1;
      this.a[3] = 0.0F;
      this.a[4] = 1.0F;
      this.a[5] = var2;
      this.a[6] = 0.0F;
      this.a[7] = 0.0F;
      this.a[8] = 1.0F;
   }
}
