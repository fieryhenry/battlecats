package jp.co.ponos.library.game;

import android.media.MediaPlayer;
import android.media.SoundPool;

public class aSound {
    static aSound aSound;
    MediaPlayer bgmMediaPlayer;
    SoundPool soundEffectPool;
    int totalSoundEffects;
    int[] soundTypes;
    int[] soundFiles;
    int[] loadedSoundEffects;
    int[] soundEffects;
    boolean muteBgm;
    boolean muteSoundEffects;
    boolean[] soundEffectIsPlaying;
    boolean[] soundEffectLoaded;
    int[] volumes;
    int p = 100;
    int o = 100;

    /* renamed from: m */
    int volume = 100;

    public static void a() {
        aSound = new aSound();
    }

    public static aSound getInstance() {
        return aSound;
    }

    public void load(int i) {
        try {
            if ((this.soundTypes[i] & 2) == 0 || this.soundEffectLoaded[i]) {
                return;
            }
            this.loadedSoundEffects[i] = this.soundEffectPool.load(aGlobal.instance.context, this.soundFiles[i], 1);
            this.soundEffectLoaded[i] = true;
        } catch (Exception e) {
        }
    }

    void play(int soundID, aPlayOption aplayoption, boolean changeVolume) {
        try {
            if ((this.soundTypes[soundID] & 1) != 0 && !this.muteBgm) {
                stop(-1);
                if (!changeVolume) {
                    if (aplayoption == null) {
                        this.volume = 100;
                    } else {
                        this.volume = aplayoption.getVolume();
                    }
                }
                this.bgmMediaPlayer = MediaPlayer.create(aGlobal.instance.context, this.soundFiles[soundID]);
                this.bgmMediaPlayer.setLooping((this.soundTypes[soundID] & 4) != 0);
                this.bgmMediaPlayer.setVolume((this.o * this.volume) / 10000.0f, (this.o * this.volume) / 10000.0f);
                if (MyApplicationBase.getInstance().isGameOpen()) {
                    this.bgmMediaPlayer.start();
                }
            } else if ((this.soundTypes[soundID] & 2) != 0 && !this.muteSoundEffects) {
                if (!this.soundEffectLoaded[soundID]) {
                    return;
                }
                if (this.soundEffects[soundID] != 0) {
                    this.soundEffectPool.stop(this.soundEffects[soundID]);
                }
                if (!changeVolume) {
                    if (aplayoption == null) {
                        this.volumes[soundID] = 100;
                    } else {
                        this.volumes[soundID] = aplayoption.getVolume();
                    }
                }
                if (MyApplicationBase.getInstance().isGameOpen()) {
                    this.soundEffects[soundID] = this.soundEffectPool.play(this.loadedSoundEffects[soundID], (this.p * this.volumes[soundID]) / 10000.0f, (this.p * this.volumes[soundID]) / 10000.0f, 1, (this.soundTypes[soundID] & 4) == 0 ? 0 : -1, 1.0f);
                }
            }
            if ((this.soundTypes[soundID] & 4) != 0) {
                this.soundEffectIsPlaying[soundID] = true;
            }
        } catch (Exception e) {
        }
    }

    public void muteBGM(boolean z) {
        this.muteBgm = z;
        if (!z || this.bgmMediaPlayer == null) {
            return;
        }
        this.bgmMediaPlayer.stop();
    }

    public void loadMany(int[] soundTypes, int totalSounds) {
        this.soundEffectPool = new SoundPool(totalSounds, 3, 0);
        this.totalSoundEffects = totalSounds;
        this.soundTypes = soundTypes;
        this.soundFiles = new int[totalSounds];
        this.loadedSoundEffects = new int[totalSounds];
        this.soundEffects = new int[totalSounds];
        this.soundEffectIsPlaying = new boolean[totalSounds];
        this.soundEffectLoaded = new boolean[totalSounds];
        this.volumes = new int[totalSounds];
        for (int soundID = 0; soundID < totalSounds; soundID++) {
            try {
                this.soundFiles[soundID] = aAssetLoader.assetLoader.getRaw(String.format("snd%03d", Integer.valueOf(soundID)));
                this.volumes[soundID] = 100;
            } catch (Exception e) {
            }
        }
    }

    public void unloadSoundEffect(int i) {
        this.soundEffectLoaded[i] = false;
        this.soundEffects[i] = 0;
    }

    public void muteSE(boolean muteSE) {
        this.muteSoundEffects = muteSE;
        if (muteSE) {
            for (int i = 0; i < this.totalSoundEffects; i++) {
                if ((this.soundTypes[i] & 2) != 0 && this.soundEffectLoaded[i] && this.soundEffects[i] != 0) {
                    this.soundEffectPool.stop(this.soundEffects[i]);
                }
            }
        }
    }

    public void c() {
    }

    public void play(int soundID) {
        play(soundID, null, false);
    }

    public void play(SoundType soundType) {
        play(soundType.ordinal(), null, false);
    }

    public void d() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if ((r5.e[r6] & 1) != 0) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:6:0x0009, B:33:0x0060, B:35:0x0068, B:37:0x006e, B:39:0x0074, B:17:0x0024, B:24:0x0039, B:26:0x0041, B:28:0x0047, B:30:0x004d, B:31:0x005b, B:8:0x0011, B:10:0x0015, B:12:0x001b, B:20:0x0029, B:22:0x0031, B:23:0x0036), top: B:43:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void stop(int soundID) {
        if (soundID != -1 && soundID != -4) {
            if (soundID >= 0) {
                try {
                    this.soundEffectPool.stop(this.soundEffects[soundID]);
                    this.soundEffectIsPlaying[soundID] = false;
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            if (soundID == -2 && soundID != -4) {
                if (soundID < 0 || (this.soundTypes[soundID] & 2) == 0 || !this.soundEffectLoaded[soundID] || this.soundEffects[soundID] == 0) {
                    return;
                } else {
                    this.soundEffectPool.stop(this.soundEffects[soundID]);
                    this.soundEffectIsPlaying[soundID] = false;
                    return;
                }
            }
            for (int i2 = 0; i2 < this.totalSoundEffects; i2++) {
                if ((this.soundTypes[i2] & 2) != 0 && this.soundEffectLoaded[i2] && this.soundEffects[i2] != 0) {
                    this.soundEffectPool.stop(this.soundEffects[i2]);
                    this.soundEffectIsPlaying[i2] = false;
                }
            }
        }
        if (this.bgmMediaPlayer != null) {
            this.bgmMediaPlayer.stop();
        }
        for (int i3 = 0; i3 < this.totalSoundEffects; i3++) {
            if ((this.soundTypes[i3] & 1) != 0) {
                this.soundEffectIsPlaying[i3] = false;
            }
        }
        if (soundID == -2) {
        }
        //while (i2 < this.d) {
        //}
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

    public void setVolume(int i) {
        try {
            this.volume = i;
            if (this.bgmMediaPlayer == null || !this.bgmMediaPlayer.isPlaying()) {
                return;
            }
            this.bgmMediaPlayer.setVolume((this.o * this.volume) / 10000.0f, (this.o * this.volume) / 10000.0f);
        } catch (Exception e) {
        }
    }

    public void reloadSounds() {
        for (int i = 0; i < this.totalSoundEffects; i++) {
            if (this.soundEffectIsPlaying[i]) {
                play(i, null, true);
            }
        }
    }

    public boolean isMutedBGM() {
        return this.muteBgm;
    }

    public boolean isMutedSE() {
        return this.muteSoundEffects;
    }
}
