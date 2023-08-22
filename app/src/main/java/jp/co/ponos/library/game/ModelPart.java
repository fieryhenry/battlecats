package jp.co.ponos.library.game;

public class ModelPart {
   int A;
   int baseAlpha;
   int animAlpha;
   int glow;
   int[] E = new int[8];
   Point F = new Point();
   AnimationTransformer G = new AnimationTransformer();
   AnimationTransformer H = new AnimationTransformer();
   AnimationTransformer a = new AnimationTransformer();
   int b;
   int c;
   int d;
   int e;
   int f;
   int g;
   int h;
   int i;
   int j;
   int k;
   int l;
   int m;
   int n;
   int o;
   int p;
   int q;
   int xScale;
   int s;
   int t;
   int yScale;
   int v;
   int w;
   int x;
   int y;
   int z;

   public void setScale(int xScale, int yScale) {
      this.xScale = xScale;
      this.yScale = yScale;
   }

   void a(Model var1) {
      int var2;
      int var3;
      int var6;
      if (this.b + this.c != -1) {
         var2 = (int)((long)this.xScale * (long)this.t * (long)var1.parts[this.b + this.c].s / (long)var1.f / (long)var1.f);
         this.s = (int)((long)this.xScale * (long)this.t * (long)var1.parts[this.b + this.c].s / (long)var1.f / (long)var1.f);
         var3 = (int)((long)this.yScale * (long)this.w * (long)var1.parts[this.b + this.c].v / (long)var1.f / (long)var1.f);
         this.v = (int)((long)this.yScale * (long)this.w * (long)var1.parts[this.b + this.c].v / (long)var1.f / (long)var1.f);
         this.baseAlpha = (int)((long)this.z * (long)this.animAlpha * (long)var1.parts[this.b + this.c].A / (long)var1.h / (long)var1.h);
         this.A = (int)((long)this.z * (long)this.animAlpha * (long)var1.parts[this.b + this.c].A / (long)var1.h / (long)var1.h);
      } else {
         var2 = this.xScale * this.t / var1.f;
         this.s = var2;
         var3 = this.yScale * this.w / var1.f;
         this.v = var3;
         var6 = this.z * this.animAlpha / var1.h;
         this.A = var6;
         this.baseAlpha = var6;
      }

      if (this.d + this.e != -1) {
         int[] var4 = this.E;
         int[] var5 = this.E;
         var6 = -(this.n + this.p) * var2 / var1.f;
         var5[2] = var6;
         var4[0] = var6;
         var4 = this.E;
         var5 = this.E;
         var6 = this.E[0];
         var2 = var2 * var1.a[this.d + this.e].getRect(this.f + this.g).width / var1.f + var6;
         var5[6] = var2;
         var4[4] = var2;
         var4 = this.E;
         var5 = this.E;
         var2 = -(this.o + this.q) * var3 / var1.f;
         var5[7] = var2;
         var4[1] = var2;
         var4 = this.E;
         var5 = this.E;
         var2 = this.E[1];
         var3 = var3 * var1.a[this.d + this.e].getRect(this.f + this.g).height / var1.f + var2;
         var5[5] = var3;
         var4[3] = var3;
      }

      this.G.a(this.x + this.y, var1.g);
      if (this.b + this.c != -1) {
         this.H.b((this.j + this.l) * var1.parts[this.b + this.c].s / var1.f, (this.k + this.m) * var1.parts[this.b + this.c].v / var1.f);
      } else {
         this.H.b(this.l, this.m);
      }

      this.a.a();
      if (this.b + this.c != -1) {
         this.a.a(var1.parts[this.b + this.c].a);
      }

      this.a.a(this.H);
      this.a.a(this.G);

      for(var3 = 0; var3 < 4; ++var3) {
         this.a.a(this.E[var3 * 2], this.E[var3 * 2 + 1], this.F);
         this.E[var3 * 2] = this.F.x;
         this.E[var3 * 2 + 1] = this.F.y;
      }

   }

   public void a(Model var1, int var2, int var3, Point var4) {
      this.a.a((var2 - this.n - this.p) * this.s / var1.f, (var3 - this.o - this.q) * this.v / var1.f, var4);
   }

   void a(Model var1, TextureRenderer var2, int var3, int var4) {
      if (this.d + this.e != -1) {
         if (this.glow == 0) {
            var2.setBlendMode(0);
         } else if (this.glow == 1) {
            var2.setBlendMode(1);
         } else if (this.glow == 2) {
            var2.setBlendMode(3);
         } else if (this.glow == 3) {
            var2.setBlendMode(4);
         }

         var2.setImageAlpha(this.baseAlpha * 255 / var1.h);
         Texture var14 = var1.a[this.d + this.e];
         int var5 = this.E[0];
         int var6 = this.E[1];
         int var7 = this.E[2];
         int var8 = this.E[3];
         int var9 = this.E[4];
         int var10 = this.E[5];
         int var11 = this.E[6];
         int var12 = this.E[7];
         int var13 = this.f;
         var2.drawScaledImageI(var14, var5 + var3, var6 + var4, var7 + var3, var8 + var4, var9 + var3, var10 + var4, var11 + var3, var12 + var4, this.g + var13);
      }

   }
}
