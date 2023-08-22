package jp.co.ponos.library.game;

import jp.co.ponos.library.game.stream.AssetTextStream;

public class Model {
   Texture[] a;
   ModelPart[] parts;
   int c;
   int[] d;
   int[] e;
   int f;
   int g;
   int h;
   ModelCollision[] i;
   int j;

   public ModelCollision a(int var1) {
      return this.i[var1];
   }

   public void a() {
      this.a((ModelAnimation)null, 0, 0, 1);
   }

   public void setTextures(TextureRenderer var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.c; ++var4) {
         this.parts[this.d[var4]].a(this, var1, var2, var3);
      }

   }

   public void a(ModelAnimation var1, int var2) {
      this.a(var1, var2, 0, 1);
   }

   public void a(ModelAnimation var1, int var2, int var3, int var4) {
      int var5;
      int var6;
      ModelPart var7;
      for(var5 = 0; var5 < this.c; ++var5) {
         this.parts[var5].c = 0;
         this.parts[var5].e = 0;
         this.parts[var5].g = 0;
         var7 = this.parts[var5];
         this.parts[var5].m = 0;
         var7.l = 0;
         var7 = this.parts[var5];
         this.parts[var5].q = 0;
         var7.p = 0;
         ModelPart var8 = this.parts[var5];
         var7 = this.parts[var5];
         var6 = this.f;
         var7.w = var6;
         var8.t = var6;
         this.parts[var5].y = 0;
         this.parts[var5].animAlpha = this.h;
      }

      if (var1 != null) {
         for(var6 = 0; var6 < var1.totalParts; ++var6) {
            int var9 = var1.parts[var6].keyFrames[0].frame;
            int var10 = var1.parts[var6].keyFrames[var1.parts[var6].totalKeyFrames - 1].frame;
            if (var2 >= var9) {
               if (var2 >= var10 && var9 != var10) {
                  if (var1.parts[var6].loop == -1) {
                     var5 = (var2 - var9) % (var10 - var9);
                  } else if (var1.parts[var6].loop >= 1) {
                     if ((var2 - var9) / (var10 - var9) < var1.parts[var6].loop) {
                        var5 = (var2 - var9) % (var10 - var9);
                     } else {
                        var5 = var10;
                     }
                  } else {
                     var5 = var10;
                  }
               } else {
                  var5 = var2;
               }
            } else {
               var5 = -1;
            }

            if (var5 >= 0) {
               if (var9 == var10) {
                  var5 = var1.parts[var6].keyFrames[0].change;
               } else if (var5 == var10) {
                  var5 = var1.parts[var6].keyFrames[var1.parts[var6].totalKeyFrames - 1].change;
               } else {
                  label145: {
                     for(var10 = 0; var10 < var1.parts[var6].totalKeyFrames - 1; ++var10) {
                        int var11 = var1.parts[var6].keyFrames[var10].frame;
                        var9 = var1.parts[var6].keyFrames[var10 + 1].frame;
                        if (var5 >= var11 && var5 < var9) {
                           if (var1.parts[var6].keyFrames[var10].ease == 0) {
                              int var12 = var1.parts[var6].keyFrames[var10].change;
                              var5 = (var1.parts[var6].keyFrames[var10 + 1].change - var1.parts[var6].keyFrames[var10].change) * ((var5 - var11) * var4 + var3) / ((var9 - var11) * var4) + var12;
                              break label145;
                           }

                           if (var1.parts[var6].keyFrames[var10].ease == 1) {
                              var5 = var1.parts[var6].keyFrames[var10].change;
                              break label145;
                           }

                           if (var1.parts[var6].keyFrames[var10].ease == 2) {
                              double var13;
                              double var15;
                              if (var1.parts[var6].keyFrames[var10].easePower >= 0) {
                                 var13 = (double)var1.parts[var6].keyFrames[var10].change;
                                 var15 = (double)(var1.parts[var6].keyFrames[var10 + 1].change - var1.parts[var6].keyFrames[var10].change);
                                 var5 = (int)((1.0 - Math.sqrt(1.0 - Math.pow((double)((var5 - var11) * var4 + var3) / (double)((var9 - var11) * var4), (double)var1.parts[var6].keyFrames[var10].easePower))) * var15 + var13);
                              } else {
                                 var15 = (double)var1.parts[var6].keyFrames[var10].change;
                                 var13 = (double)(var1.parts[var6].keyFrames[var10 + 1].change - var1.parts[var6].keyFrames[var10].change);
                                 var5 = (int)(Math.sqrt(1.0 - Math.pow(1.0 - (double)((var5 - var11) * var4 + var3) / (double)((var9 - var11) * var4), (double)(-var1.parts[var6].keyFrames[var10].easePower))) * var13 + var15);
                              }
                              break label145;
                           }
                           break;
                        }
                     }

                     var5 = 0;
                  }
               }

               switch (var1.parts[var6].modification) {
                  case 0:
                     this.parts[var1.parts[var6].modelID].c = var5 - this.parts[var1.parts[var6].modelID].b;
                     break;
                  case 1:
                     this.parts[var1.parts[var6].modelID].e = var5 - this.parts[var1.parts[var6].modelID].d;
                     break;
                  case 2:
                     this.parts[var1.parts[var6].modelID].g = var5 - this.parts[var1.parts[var6].modelID].f;
                     break;
                  case 3:
                     this.parts[var1.parts[var6].modelID].i = var5 - this.parts[var1.parts[var6].modelID].h;
                     break;
                  case 4:
                     this.parts[var1.parts[var6].modelID].l = var5;
                     break;
                  case 5:
                     this.parts[var1.parts[var6].modelID].m = var5;
                     break;
                  case 6:
                     this.parts[var1.parts[var6].modelID].p = var5;
                     break;
                  case 7:
                     this.parts[var1.parts[var6].modelID].q = var5;
                     break;
                  case 8:
                     var7 = this.parts[var1.parts[var6].modelID];
                     this.parts[var1.parts[var6].modelID].w = var5;
                     var7.t = var5;
                     break;
                  case 9:
                     this.parts[var1.parts[var6].modelID].t = var5;
                     break;
                  case 10:
                     this.parts[var1.parts[var6].modelID].w = var5;
                     break;
                  case 11:
                     this.parts[var1.parts[var6].modelID].y = var5;
                     break;
                  case 12:
                     this.parts[var1.parts[var6].modelID].animAlpha = var5;
               }
            }
         }
      }

      for(var2 = 0; var2 < this.c; ++var2) {
         this.parts[var2].a(this);
      }

      for(var2 = 0; var2 < this.c; ++var2) {
         this.d[var2] = var2;
         this.e[var2] = this.parts[var2].h;
      }

      for(var2 = 1; var2 < this.c; ++var2) {
         var5 = this.d[var2];
         var4 = this.e[var2];

         for(var3 = var2 - 1; var3 >= 0 && this.e[var3] > var4; --var3) {
            this.d[var3 + 1] = this.d[var3];
            this.e[var3 + 1] = this.e[var3];
         }

         this.d[var3 + 1] = var5;
         this.e[var3 + 1] = var4;
      }

   }

   public void a(Texture[] var1) {
      this.a = var1;
   }

   public boolean a(String var1) {
      boolean var2 = false;
      AssetTextStream var3 = new AssetTextStream();
      this.d();
      if (var3.openRead(var1)) {
         var3.getLine();
         var3.readLine();
         int var4 = var3.getInt(0);
         var3.readLine();
         this.c = var3.getInt(0);
         this.parts = new ModelPart[this.c];
         this.d = new int[this.c];
         this.e = new int[this.c];

         int var5;
         for(var5 = 0; var5 < this.c; ++var5) {
            var3.readLine();
            this.parts[var5] = new ModelPart();
            this.parts[var5].b = var3.getInt(0);
            this.parts[var5].d = var3.getInt(1);
            this.parts[var5].f = var3.getInt(2);
            this.parts[var5].h = var3.getInt(3);
            this.parts[var5].j = var3.getInt(4);
            this.parts[var5].k = var3.getInt(5);
            this.parts[var5].n = var3.getInt(6);
            this.parts[var5].o = var3.getInt(7);
            this.parts[var5].xScale = var3.getInt(8);
            this.parts[var5].yScale = var3.getInt(9);
            this.parts[var5].x = var3.getInt(10);
            this.parts[var5].z = var3.getInt(11);
            if (var4 >= 2) {
               this.parts[var5].glow = var3.getInt(12);
            } else {
               this.parts[var5].glow = 0;
            }
         }

         if (var4 >= 1) {
            var3.readLine();
            this.f = var3.getInt(0);
            this.g = var3.getInt(1);
            this.h = var3.getInt(2);
         } else {
            this.f = 100;
            this.g = 360;
            this.h = 255;
         }

         if (var4 >= 3) {
            var3.readLine();
            this.j = var3.getInt(0);
            this.i = new ModelCollision[this.j];

            for(var5 = 0; var5 < this.j; ++var5) {
               var3.readLine();
               this.i[var5] = new ModelCollision();
               this.i[var5].b = var3.getInt(0);
               this.i[var5].a = this.parts[this.i[var5].b];
               this.i[var5].c = var3.getInt(1);
               this.i[var5].d = var3.getInt(2);
               this.i[var5].e = var3.getInt(3);
               this.i[var5].f = var3.getInt(4);
               this.i[var5].g = var3.getInt(5);
            }
         } else {
            this.j = 0;
         }

         var3.close();
         var2 = true;
      }

      return var2;
   }

   public ModelPart b() {
      return this.parts[0];
   }

   public int c() {
      return this.f;
   }

   public void d() {
      this.parts = null;
      this.d = null;
      this.e = null;
      this.i = null;
   }
}
