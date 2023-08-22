package jp.co.ponos.battlecats;

import jp.co.ponos.library.game.aMath;

class Zoom {
   boolean isZooming;
   boolean[] isPointerDown = new boolean[2];
   int[] xPos = new int[2];
   int[] yPos = new int[2];
   int[] pointerIDs = new int[2];
   int[] xPos2 = new int[2];
   int[] yPos2 = new int[2];
   int endZoom;
   int startZoom;

   Zoom() {
      this.reset();
   }

   int getLength(boolean[] arr) {
      return arr.length;
   }

   void reset() {
      this.isZooming = false;

      for(int var1 = 0; var1 < this.getLength(this.isPointerDown); ++var1) {
         this.isPointerDown[var1] = false;
      }

   }

   void onTouchEvent(int eventID, int xPos, int yPos, int pointerID) {
      int pointerIndex = 0;
      switch (eventID) {
         case 0:
            for(eventID = 0; eventID < this.getLength(this.isPointerDown); ++eventID) {
               if (this.isPointerDown[eventID] && this.pointerIDs[eventID] == pointerID) {
                  this.isPointerDown[eventID] = false;
               }
            }

            for(eventID = 0; eventID < this.getLength(this.isPointerDown); ++eventID) {
               if (!this.isPointerDown[eventID]) {
                  this.isPointerDown[eventID] = true;
                  this.xPos[eventID] = xPos;
                  this.yPos[eventID] = yPos;
                  this.pointerIDs[eventID] = pointerID;
                  return;
               }
            }

            return;
         case 1:
            while(pointerIndex < this.getLength(this.isPointerDown)) {
               if (this.isPointerDown[pointerIndex] && this.pointerIDs[pointerIndex] == pointerID) {
                  this.xPos[pointerIndex] = xPos;
                  this.yPos[pointerIndex] = yPos;
                  return;
               }

               ++pointerIndex;
            }

            return;
         case 2:
            for(eventID = 0; eventID < this.getLength(this.isPointerDown); ++eventID) {
               if (this.isPointerDown[eventID] && this.pointerIDs[eventID] == pointerID) {
                  this.isPointerDown[eventID] = false;
               }
            }
      }

   }

   void zoom() {
      if (!this.isZooming) {
         if (this.isPointerDown[0] && this.isPointerDown[1]) {
            this.isZooming = true;

            int var1;
            for(var1 = 0; var1 < this.getLength(this.isPointerDown); ++var1) {
               this.xPos2[var1] = this.xPos[var1];
               this.yPos2[var1] = this.yPos[var1];
            }

            var1 = (int) aMath.sqrt(aMath.pow((float)(this.xPos[0] - this.xPos[1]), 2.0F) + aMath.pow((float)(this.yPos[0] - this.yPos[1]), 2.0F));
            this.startZoom = var1;
            this.endZoom = var1;
         }
      } else if (this.isPointerDown[0] && this.isPointerDown[1]) {
         this.startZoom = this.endZoom;
         this.endZoom = (int) aMath.sqrt(aMath.pow((float)(this.xPos[0] - this.xPos[1]), 2.0F) + aMath.pow((float)(this.yPos[0] - this.yPos[1]), 2.0F));
      } else {
         this.isZooming = false;
         boolean[] var2 = this.isPointerDown;
         this.isPointerDown[1] = false;
         var2[0] = false;
      }

   }

   boolean isZooming() {
      return this.isZooming;
   }

   int getZoomFactor() {
      int var1;
      if (this.isZooming) {
         var1 = this.endZoom - this.startZoom;
      } else {
         var1 = 0;
      }

      return var1;
   }
}
