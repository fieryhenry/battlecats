package jp.co.ponos.library.game;

import jp.co.ponos.library.game.stream.AssetTextStream;

public class ModelAnimation {
   ModelAnimationPart[] parts;
   int totalParts;

   public int a() {
      int var1 = 0;

      int var4;
      for(int var2 = 0; var2 < this.totalParts; var1 = var4) {
         if (this.parts[var2].loop == -1) {
            var1 = -1;
            break;
         }

         int var3 = (this.parts[var2].keyFrames[this.parts[var2].totalKeyFrames - 1].frame - this.parts[var2].keyFrames[0].frame) * this.parts[var2].loop + 1;
         var4 = var1;
         if (var3 > var1) {
            var4 = var3;
         }

         ++var2;
      }

      return var1;
   }

   public boolean load(String var1) {
      boolean var2 = false;
      AssetTextStream var3 = new AssetTextStream();
      this.reset();
      if (var3.openRead(var1)) {
         var3.getLine();
         int var4 = Integer.parseInt(var3.getLine());
         var3.readLine();
         this.totalParts = var3.getInt(0);
         this.parts = new ModelAnimationPart[this.totalParts];

         for(int var5 = 0; var5 < this.totalParts; ++var5) {
            var3.readLine();
            this.parts[var5] = new ModelAnimationPart();
            this.parts[var5].modelID = var3.getInt(0);
            this.parts[var5].modification = var3.getInt(1);
            this.parts[var5].loop = var3.getInt(2);
            var3.readLine();
            this.parts[var5].totalKeyFrames = var3.getInt(0);
            this.parts[var5].keyFrames = new KeyFrame[this.parts[var5].totalKeyFrames];

            for(int var6 = 0; var6 < this.parts[var5].totalKeyFrames; ++var6) {
               var3.readLine();
               this.parts[var5].keyFrames[var6] = new KeyFrame();
               this.parts[var5].keyFrames[var6].frame = var3.getInt(0);
               this.parts[var5].keyFrames[var6].change = var3.getInt(1);
               this.parts[var5].keyFrames[var6].ease = var3.getInt(2);
               if (var4 >= 1) {
                  this.parts[var5].keyFrames[var6].easePower = var3.getInt(3);
               } else {
                  this.parts[var5].keyFrames[var6].easePower = 0;
               }
            }
         }

         var3.close();
         var2 = true;
      }

      return var2;
   }

   public int b() {
      int var1 = 0;

      int var4;
      for(int var2 = 0; var2 < this.totalParts; var1 = var4) {
         int var3 = this.parts[var2].keyFrames[this.parts[var2].totalKeyFrames - 1].frame - this.parts[var2].keyFrames[0].frame;
         var4 = var1;
         if (var3 > var1) {
            var4 = var3;
         }

         ++var2;
      }

      return var1;
   }

   public void reset() {
      this.parts = null;
   }
}
