package jp.co.ponos.library.game;

import android.media.MediaPlayer;
import android.media.SoundPool;

public class Sound {
   static Sound sound;
   MediaPlayer bgmMediaPlayer;
   SoundPool soundEffectPool;
   int totalSoundEffects;
   int[] soundTypes;
   int[] soundFiles;
   int[] loadedSoundEffects;
   int[] soundEffects;
   boolean mutedbgm;
   boolean mutedse;
   boolean[] soundEffectIsPlaying;
   boolean[] soundEffectLoaded;
   int volume = 100;
   int[] volumes;
   int o = 100;
   int p = 100;

   public static void createInstance() {
      sound = new Sound();
   }

   public static Sound getInstance() {
      return sound;
   }

   public void load(int var1) {
      try {
         if ((this.soundTypes[var1] & 2) != 0 && !this.soundEffectLoaded[var1]) {
            this.loadedSoundEffects[var1] = this.soundEffectPool.load(Global.instance.context, this.soundFiles[var1], 1);
            this.soundEffectLoaded[var1] = true;
         }
      } catch (Exception var3) {
      }

   }

   void play(int var1, PlayOption var2, boolean var3) {
      boolean var4 = false;
      byte var5 = -1;

      boolean var10001;
      label124: {
         label125: {
            try {
               if ((this.soundTypes[var1] & 1) != 0 && !this.mutedbgm) {
                  this.stop(-1);
                  break label125;
               }
            } catch (Exception var21) {
               var10001 = false;
               return;
            }

            try {
               if ((this.soundTypes[var1] & 2) == 0 || this.mutedse) {
                  break label124;
               }

               if (!this.soundEffectLoaded[var1]) {
                  return;
               }

               if (this.soundEffects[var1] != 0) {
                  this.soundEffectPool.stop(this.soundEffects[var1]);
               }
            } catch (Exception var20) {
               var10001 = false;
               return;
            }

            if (!var3) {
               if (var2 == null) {
                  try {
                     this.volumes[var1] = 100;
                  } catch (Exception var17) {
                     var10001 = false;
                     return;
                  }
               } else {
                  try {
                     this.volumes[var1] = var2.getVolume();
                  } catch (Exception var16) {
                     var10001 = false;
                     return;
                  }
               }
            }

            SoundPool var6;
            int var7;
            float var8;
            float var9;
            int[] var22;
            label92: {
               try {
                  if (!MyApplicationBase.getInstance().isGameOpen()) {
                     break label124;
                  }

                  var22 = this.soundEffects;
                  var6 = this.soundEffectPool;
                  var7 = this.loadedSoundEffects[var1];
                  var8 = (float)(this.p * this.volumes[var1]) / 10000.0F;
                  var9 = (float)(this.p * this.volumes[var1]) / 10000.0F;
                  if ((this.soundTypes[var1] & 4) != 0) {
                     break label92;
                  }
               } catch (Exception var18) {
                  var10001 = false;
                  return;
               }

               var5 = 0;
            }

            try {
               var22[var1] = var6.play(var7, var8, var9, 1, var5, 1.0F);
               break label124;
            } catch (Exception var15) {
               var10001 = false;
               return;
            }
         }

         if (!var3) {
            if (var2 == null) {
               try {
                  this.volume = 100;
               } catch (Exception var14) {
                  var10001 = false;
                  return;
               }
            } else {
               try {
                  this.volume = var2.getVolume();
               } catch (Exception var13) {
                  var10001 = false;
                  return;
               }
            }
         }

         MediaPlayer var23;
         try {
            this.bgmMediaPlayer = MediaPlayer.create(Global.instance.context, this.soundFiles[var1]);
            var23 = this.bgmMediaPlayer;
         } catch (Exception var12) {
            var10001 = false;
            return;
         }

         var3 = var4;

         label98: {
            try {
               if ((this.soundTypes[var1] & 4) == 0) {
                  break label98;
               }
            } catch (Exception var19) {
               var10001 = false;
               return;
            }

            var3 = true;
         }

         try {
            var23.setLooping(var3);
            this.bgmMediaPlayer.setVolume((float)(this.o * this.volume) / 10000.0F, (float)(this.o * this.volume) / 10000.0F);
            if (MyApplicationBase.getInstance().isGameOpen()) {
               this.bgmMediaPlayer.start();
            }
         } catch (Exception var11) {
            var10001 = false;
            return;
         }
      }

      try {
         if ((this.soundTypes[var1] & 4) != 0) {
            this.soundEffectIsPlaying[var1] = true;
         }
      } catch (Exception var10) {
         var10001 = false;
      }

   }

   public void muteBGM(boolean var1) {
      this.mutedbgm = var1;
      if (var1 && this.bgmMediaPlayer != null) {
         this.bgmMediaPlayer.stop();
      }

   }

   public void loadMany(int[] var1, int var2) {
      int var3 = 0;
      this.soundEffectPool = new SoundPool(var2, 3, 0);
      this.totalSoundEffects = var2;
      this.soundTypes = var1;
      this.soundFiles = new int[var2];
      this.loadedSoundEffects = new int[var2];
      this.soundEffects = new int[var2];
      this.soundEffectIsPlaying = new boolean[var2];
      this.soundEffectLoaded = new boolean[var2];

      for(this.volumes = new int[var2]; var3 < var2; ++var3) {
         try {
            this.soundFiles[var3] = AssetLoader.assetLoader.getRaw(String.format("snd%03d", var3));
            this.volumes[var3] = 100;
         } catch (Exception var4) {
         }
      }

   }

   public void unloadSoundEffect(int var1) {
      this.soundEffectLoaded[var1] = false;
      this.soundEffects[var1] = 0;
   }

   public void muteSE(boolean var1) {
      this.mutedse = var1;
      if (var1) {
         for(int var2 = 0; var2 < this.totalSoundEffects; ++var2) {
            if ((this.soundTypes[var2] & 2) != 0 && this.soundEffectLoaded[var2] && this.soundEffects[var2] != 0) {
               this.soundEffectPool.stop(this.soundEffects[var2]);
            }
         }
      }

   }

   public void resume() {
   }

   public void play(int var1) {
      this.play(var1, (PlayOption)null, false);
   }

   public void d() {
   }

   public void stop(int var1) {
      boolean var10001;
      byte var2;
      int var3;
      label100: {
         var2 = 0;
         if (var1 != -1 && var1 != -4) {
            if (var1 < 0) {
               break label100;
            }

            try {
               if ((this.soundTypes[var1] & 1) == 0) {
                  break label100;
               }
            } catch (Exception var9) {
               var10001 = false;
               return;
            }
         }

         try {
            if (this.bgmMediaPlayer != null) {
               this.bgmMediaPlayer.stop();
            }
         } catch (Exception var11) {
            var10001 = false;
            return;
         }

         var3 = 0;

         while(true) {
            try {
               if (var3 >= this.totalSoundEffects) {
                  break;
               }
            } catch (Exception var8) {
               var10001 = false;
               return;
            }

            try {
               if ((this.soundTypes[var3] & 1) != 0) {
                  this.soundEffectIsPlaying[var3] = false;
               }
            } catch (Exception var10) {
               var10001 = false;
               return;
            }

            ++var3;
         }
      }

      var3 = var2;
      if (var1 != -2) {
         if (var1 != -4) {
            if (var1 >= 0) {
               try {
                  if ((this.soundTypes[var1] & 2) != 0 && this.soundEffectLoaded[var1] && this.soundEffects[var1] != 0) {
                     this.soundEffectPool.stop(this.soundEffects[var1]);
                     this.soundEffectIsPlaying[var1] = false;
                     return;
                  }
               } catch (Exception var5) {
                  var10001 = false;
               }

               return;
            }

            return;
         }

         var3 = var2;
      }

      while(true) {
         try {
            if (var3 >= this.totalSoundEffects) {
               break;
            }
         } catch (Exception var6) {
            var10001 = false;
            break;
         }

         try {
            if ((this.soundTypes[var3] & 2) != 0 && this.soundEffectLoaded[var3] && this.soundEffects[var3] != 0) {
               this.soundEffectPool.stop(this.soundEffects[var3]);
               this.soundEffectIsPlaying[var3] = false;
            }
         } catch (Exception var7) {
            var10001 = false;
            break;
         }

         ++var3;
      }

   }

   public void stopAll() {
      try {
         if (this.bgmMediaPlayer != null) {
            this.bgmMediaPlayer.stop();
         }
         for (int i = 0; i < this.totalSoundEffects; i++) {
            if ((this.soundTypes[i] & 2) != 0 && this.soundEffectLoaded[i] && this.soundEffects[i] != 0) {
               this.soundEffectPool.stop(this.soundEffects[i]);
            }
         }
      } catch (Exception e) {
      }
   }

   public void setVolume(int volume) {
      try {
         this.volume = volume;
         if (this.bgmMediaPlayer != null && this.bgmMediaPlayer.isPlaying()) {
            this.bgmMediaPlayer.setVolume((float)(this.o * this.volume) / 10000.0F, (float)(this.o * this.volume) / 10000.0F);
         }
      } catch (Exception var3) {
      }

   }

   public void reloadSounds() {
      for(int i = 0; i < this.totalSoundEffects; ++i) {
         if (this.soundEffectIsPlaying[i]) {
            this.play(i, (PlayOption)null, true);
         }
      }

   }

   public boolean isMutedBGM() {
      return this.mutedbgm;
   }

   public boolean isMutedSE() {
      return this.mutedse;
   }
}
