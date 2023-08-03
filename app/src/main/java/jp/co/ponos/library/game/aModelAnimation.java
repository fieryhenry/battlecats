package jp.co.ponos.library.game;

import jp.co.ponos.library.game.DataStreams.aResourceFileStream;

/* renamed from: jp.co.ponos.library.b.m */
/* loaded from: classes.dex */
public class aModelAnimation {
    aMaanimPart[] parts;
    int totalParts;

    public int a() {
        int i = 0;
        for (int i2 = 0; i2 < this.totalParts; i2++) {
            if (this.parts[i2].loop == -1) {
                return -1;
            }
            int i3 = ((this.parts[i2].keyFrames[this.parts[i2].totalKeyFrames - 1].frame - this.parts[i2].keyFrames[0].frame) * this.parts[i2].loop) + 1;
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public boolean load(String str) {
        aResourceFileStream aresourcefilestream = new aResourceFileStream();
        reset();
        if (aresourcefilestream.openRead(str)) {
            aresourcefilestream.readRawLine();
            int versionCode = Integer.parseInt(aresourcefilestream.readRawLine());
            aresourcefilestream.readLine();
            this.totalParts = aresourcefilestream.getInt(0);
            this.parts = new aMaanimPart[this.totalParts];
            for (int i = 0; i < this.totalParts; i++) {
                aresourcefilestream.readLine();
                this.parts[i] = new aMaanimPart();
                this.parts[i].modelID = aresourcefilestream.getInt(0);
                this.parts[i].modificationType = aresourcefilestream.getInt(1);
                this.parts[i].loop = aresourcefilestream.getInt(2);
                aresourcefilestream.readLine();
                this.parts[i].totalKeyFrames = aresourcefilestream.getInt(0);
                this.parts[i].keyFrames = new aKeyFrame[this.parts[i].totalKeyFrames];
                for (int i2 = 0; i2 < this.parts[i].totalKeyFrames; i2++) {
                    aresourcefilestream.readLine();
                    this.parts[i].keyFrames[i2] = new aKeyFrame();
                    this.parts[i].keyFrames[i2].frame = aresourcefilestream.getInt(0);
                    this.parts[i].keyFrames[i2].change = aresourcefilestream.getInt(1);
                    this.parts[i].keyFrames[i2].easeType = aresourcefilestream.getInt(2);
                    if (versionCode >= 1) {
                        this.parts[i].keyFrames[i2].easePower = aresourcefilestream.getInt(3);
                    } else {
                        this.parts[i].keyFrames[i2].easePower = 0;
                    }
                }
            }
            aresourcefilestream.close();
            return true;
        }
        return false;
    }

    public int b() {
        int i = 0;
        for (int i2 = 0; i2 < this.totalParts; i2++) {
            int i3 = this.parts[i2].keyFrames[this.parts[i2].totalKeyFrames - 1].frame - this.parts[i2].keyFrames[0].frame;
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public void reset() {
        this.parts = null;
    }
}
