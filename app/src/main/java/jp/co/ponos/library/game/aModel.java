package jp.co.ponos.library.game;

import jp.co.ponos.library.game.DataStreams.aResourceFileStream;

/* renamed from: jp.co.ponos.library.b.l */
/* loaded from: classes.dex */
public class aModel {
    aTexture[] textures;
    aModelPart[] parts;
    int totalParts;
    int[] partIndexes;
    int[] e;
    int scaleUnit;
    int angleUnit;
    int alphaUnit;
    aModelCollision[] modelCollisions;
    int totalCollisionLines;

    public aModelCollision getModelCollision(int i) {
        return this.modelCollisions[i];
    }

    public void setAction() {
        setAction(null, 0, 0, 1);
    }

    public void setTextures(aTextureRenderer atexturerenderer, int i, int i2) {
        for (int partID = 0; partID < this.totalParts; partID++) {
            this.parts[this.partIndexes[partID]].a(this, atexturerenderer, i, i2);
        }
    }

    public void setAction(aModelAnimation amodelanimation, int i) {
        setAction(amodelanimation, i, 0, 1);
    }

    /* renamed from: a */
    public void setAction(aModelAnimation amodelanimation, int i, int i2, int i3) {
        int change;
        for (int partID = 0; partID < this.totalParts; partID++) {
            this.parts[partID].animParent = 0;
            this.parts[partID].animUnitID = 0;
            this.parts[partID].animTextureID = 0;
            aModelPart amodeltransformer = this.parts[partID];
            this.parts[partID].animPosY = 0;
            amodeltransformer.animPosX = 0;
            aModelPart amodeltransformer2 = this.parts[partID];
            this.parts[partID].animPivotY = 0;
            amodeltransformer2.animPivotX = 0;
            aModelPart amodeltransformer3 = this.parts[partID];
            aModelPart amodeltransformer4 = this.parts[partID];
            int i6 = this.scaleUnit;
            amodeltransformer4.animScaleY = i6;
            amodeltransformer3.animScaleX = i6;
            this.parts[partID].animAngle = 0;
            this.parts[partID].animOpacity = this.alphaUnit;
        }
        if (amodelanimation != null) {
            for (int i7 = 0; i7 < amodelanimation.totalParts; i7++) {
                change = 0;
                int i8 = amodelanimation.parts[i7].keyFrames[0].frame;
                int i9 = amodelanimation.parts[i7].keyFrames[amodelanimation.parts[i7].totalKeyFrames - 1].frame;
                int localFrame = i >= i8 ? (i < i9 || i8 == i9) ? i : amodelanimation.parts[i7].loop == -1 ? (i - i8) % (i9 - i8) : amodelanimation.parts[i7].loop >= 1 ? (i - i8) / (i9 - i8) < amodelanimation.parts[i7].loop ? (i - i8) % (i9 - i8) : i9 : i9 : -1;
                if (localFrame >= 0) {
                    if (i8 == i9) {
                        change = amodelanimation.parts[i7].keyFrames[0].change;
                    } else if (localFrame == i9) {
                        change = amodelanimation.parts[i7].keyFrames[amodelanimation.parts[i7].totalKeyFrames - 1].change;
                    } else {
                        int i11 = 0;
                        while (true) {
                            if (i11 < amodelanimation.parts[i7].totalKeyFrames - 1) {
                                int currentFrame = amodelanimation.parts[i7].keyFrames[i11].frame;
                                int nextFrame = amodelanimation.parts[i7].keyFrames[i11 + 1].frame;
                                if (localFrame < currentFrame || localFrame >= nextFrame) {
                                    i11++;
                                } else if (amodelanimation.parts[i7].keyFrames[i11].easeType == 0) {
                                    change = (((amodelanimation.parts[i7].keyFrames[i11 + 1].change - amodelanimation.parts[i7].keyFrames[i11].change) * (((localFrame - currentFrame) * i3) + i2)) / ((nextFrame - currentFrame) * i3)) + amodelanimation.parts[i7].keyFrames[i11].change;
                                    break;
                                } else if (amodelanimation.parts[i7].keyFrames[i11].easeType == 1) {
                                    change = amodelanimation.parts[i7].keyFrames[i11].change;
                                    break;
                                } else if (amodelanimation.parts[i7].keyFrames[i11].easeType == 2) {
                                    change = amodelanimation.parts[i7].keyFrames[i11].easePower >= 0 ? (int) (((1.0d - Math.sqrt(1.0d - Math.pow((((localFrame - currentFrame) * i3) + i2) / ((nextFrame - currentFrame) * i3), amodelanimation.parts[i7].keyFrames[i11].easePower))) * (amodelanimation.parts[i7].keyFrames[i11 + 1].change - amodelanimation.parts[i7].keyFrames[i11].change)) + amodelanimation.parts[i7].keyFrames[i11].change) : (int) ((Math.sqrt(1.0d - Math.pow(1.0d - ((((localFrame - currentFrame) * i3) + i2) / ((nextFrame - currentFrame) * i3)), -amodelanimation.parts[i7].keyFrames[i11].easePower)) * (amodelanimation.parts[i7].keyFrames[i11 + 1].change - amodelanimation.parts[i7].keyFrames[i11].change)) + amodelanimation.parts[i7].keyFrames[i11].change);
                                    break;
                                }
                            }
                            else{
                                break;
                            }
                        }
                    }
                    switch (amodelanimation.parts[i7].modificationType) {
                        case 0:
                            this.parts[amodelanimation.parts[i7].modelID].animParent = change - this.parts[amodelanimation.parts[i7].modelID].parentID;
                            continue;
                        case 1:
                            this.parts[amodelanimation.parts[i7].modelID].animUnitID = change - this.parts[amodelanimation.parts[i7].modelID].unitID;
                            continue;
                        case 2:
                            this.parts[amodelanimation.parts[i7].modelID].animTextureID = change - this.parts[amodelanimation.parts[i7].modelID].textureID;
                            continue;
                        case 3:
                            this.parts[amodelanimation.parts[i7].modelID].animZDepth = change - this.parts[amodelanimation.parts[i7].modelID].zDepth;
                            continue;
                        case 4:
                            this.parts[amodelanimation.parts[i7].modelID].animPosX = change;
                            continue;
                        case 5:
                            this.parts[amodelanimation.parts[i7].modelID].animPosY = change;
                            continue;
                        case 6:
                            this.parts[amodelanimation.parts[i7].modelID].animPivotX = change;
                            continue;
                        case 7:
                            this.parts[amodelanimation.parts[i7].modelID].animPivotY = change;
                            continue;
                        case 8:
                            aModelPart amodeltransformer5 = this.parts[amodelanimation.parts[i7].modelID];
                            this.parts[amodelanimation.parts[i7].modelID].animScaleY = change;
                            amodeltransformer5.animScaleX = change;
                            continue;
                        case 9:
                            this.parts[amodelanimation.parts[i7].modelID].animScaleX = change;
                            continue;
                        case 10:
                            this.parts[amodelanimation.parts[i7].modelID].animScaleY = change;
                            continue;
                        case 11:
                            this.parts[amodelanimation.parts[i7].modelID].animAngle = change;
                            continue;
                        case 12:
                            this.parts[amodelanimation.parts[i7].modelID].animOpacity = change;
                            continue;
                    }
                }
            }
        }
        for (int i14 = 0; i14 < this.totalParts; i14++) {
            this.parts[i14].a(this);
        }
        for (int i15 = 0; i15 < this.totalParts; i15++) {
            this.partIndexes[i15] = i15;
            this.e[i15] = this.parts[i15].zDepth;
        }
        for (int i16 = 1; i16 < this.totalParts; i16++) {
            int i17 = this.partIndexes[i16];
            int i18 = this.e[i16];
            int i19 = i16 - 1;
            while (i19 >= 0 && this.e[i19] > i18) {
                this.partIndexes[i19 + 1] = this.partIndexes[i19];
                this.e[i19 + 1] = this.e[i19];
                i19--;
            }
            this.partIndexes[i19 + 1] = i17;
            this.e[i19 + 1] = i18;
        }
    }

    public void setTextures(aTexture[] atextureArr) {
        this.textures = atextureArr;
    }

    public boolean load(String str) {
        aResourceFileStream aresourcefilestream = new aResourceFileStream();
        reset();
        if (aresourcefilestream.openRead(str)) {
            aresourcefilestream.readRawLine();
            aresourcefilestream.readLine();
            int versionCode = aresourcefilestream.getInt(0);
            aresourcefilestream.readLine();
            this.totalParts = aresourcefilestream.getInt(0);
            this.parts = new aModelPart[this.totalParts];
            this.partIndexes = new int[this.totalParts];
            this.e = new int[this.totalParts];
            for (int i = 0; i < this.totalParts; i++) {
                aresourcefilestream.readLine();
                this.parts[i] = new aModelPart();
                this.parts[i].parentID = aresourcefilestream.getInt(0);
                this.parts[i].unitID = aresourcefilestream.getInt(1);
                this.parts[i].textureID = aresourcefilestream.getInt(2);
                this.parts[i].zDepth = aresourcefilestream.getInt(3);
                this.parts[i].xPos = aresourcefilestream.getInt(4);
                this.parts[i].yPos = aresourcefilestream.getInt(5);
                this.parts[i].xPivot = aresourcefilestream.getInt(6);
                this.parts[i].yPivot = aresourcefilestream.getInt(7);
                this.parts[i].xScale = aresourcefilestream.getInt(8);
                this.parts[i].yScale = aresourcefilestream.getInt(9);
                this.parts[i].rotation = aresourcefilestream.getInt(10);
                this.parts[i].alpha = aresourcefilestream.getInt(11);
                if (versionCode >= 2) {
                    this.parts[i].glow = aresourcefilestream.getInt(12);
                } else {
                    this.parts[i].glow = 0;
                }
            }
            if (versionCode >= 1) {
                aresourcefilestream.readLine();
                this.scaleUnit = aresourcefilestream.getInt(0);
                this.angleUnit = aresourcefilestream.getInt(1);
                this.alphaUnit = aresourcefilestream.getInt(2);
            } else {
                this.scaleUnit = 100;
                this.angleUnit = 360;
                this.alphaUnit = 255;
            }
            if (versionCode >= 3) {
                aresourcefilestream.readLine();
                this.totalCollisionLines = aresourcefilestream.getInt(0);
                this.modelCollisions = new aModelCollision[this.totalCollisionLines];
                for (int i2 = 0; i2 < this.totalCollisionLines; i2++) {
                    aresourcefilestream.readLine();
                    this.modelCollisions[i2] = new aModelCollision();
                    this.modelCollisions[i2].b = aresourcefilestream.getInt(0);
                    this.modelCollisions[i2].a = this.parts[this.modelCollisions[i2].b];
                    this.modelCollisions[i2].c = aresourcefilestream.getInt(1);
                    this.modelCollisions[i2].d = aresourcefilestream.getInt(2);
                    this.modelCollisions[i2].e = aresourcefilestream.getInt(3);
                    this.modelCollisions[i2].f = aresourcefilestream.getInt(4);
                    this.modelCollisions[i2].g = aresourcefilestream.getInt(5);
                }
            } else {
                this.totalCollisionLines = 0;
            }
            aresourcefilestream.close();
            return true;
        }
        return false;
    }

    public aModelPart getBasePart() {
        return this.parts[0];
    }

    public int getScaleUnit() {
        return this.scaleUnit;
    }

    public void reset() {
        this.parts = null;
        this.partIndexes = null;
        this.e = null;
        this.modelCollisions = null;
    }
}
