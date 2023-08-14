package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.p */
/* loaded from: classes.dex */
public class aModelPart {
    int A;
    int baseAlpha;
    int animOpacity;
    int glow;
    int parentID;
    int animParent;
    int unitID;
    int animUnitID;
    int textureID;
    int animTextureID;
    int zDepth;
    int animZDepth;
    int xPos;
    int yPos;
    int animPosX;
    int animPosY;
    int xPivot;
    int yPivot;
    int animPivotX;
    int animPivotY;
    int xScale;
    int s;
    int animScaleX;
    int yScale;
    int v;
    int animScaleY;
    int rotation;
    int animAngle;
    int alpha;
    aAnimTransformer a = new aAnimTransformer();
    int[] E = new int[8];
    aPoint F = new aPoint();
    aAnimTransformer G = new aAnimTransformer();
    aAnimTransformer H = new aAnimTransformer();

    public void setScale(int xScale, int yScale) {
        this.xScale = xScale;
        this.yScale = yScale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(aModel amodel) {
        int i;
        int i2;
        if (this.parentID + this.animParent != -1) {
            i = (int) ((((this.xScale * this.animScaleX) * amodel.parts[this.parentID + this.animParent].s) / amodel.scaleUnit) / amodel.scaleUnit);
            this.s = (int) ((((this.xScale * this.animScaleX) * amodel.parts[this.parentID + this.animParent].s) / amodel.scaleUnit) / amodel.scaleUnit);
            i2 = (int) ((((this.yScale * this.animScaleY) * amodel.parts[this.parentID + this.animParent].v) / amodel.scaleUnit) / amodel.scaleUnit);
            this.v = (int) ((((this.yScale * this.animScaleY) * amodel.parts[this.parentID + this.animParent].v) / amodel.scaleUnit) / amodel.scaleUnit);
            this.baseAlpha = (int) ((((this.alpha * this.animOpacity) * amodel.parts[this.parentID + this.animParent].A) / amodel.alphaUnit) / amodel.alphaUnit);
            this.A = (int) ((((this.alpha * this.animOpacity) * amodel.parts[this.parentID + this.animParent].A) / amodel.alphaUnit) / amodel.alphaUnit);
        } else {
            i = (this.xScale * this.animScaleX) / amodel.scaleUnit;
            this.s = i;
            i2 = (this.yScale * this.animScaleY) / amodel.scaleUnit;
            this.v = i2;
            int i3 = (this.alpha * this.animOpacity) / amodel.alphaUnit;
            this.A = i3;
            this.baseAlpha = i3;
        }
        if (this.unitID + this.animUnitID != -1) {
            int[] iArr = this.E;
            int[] iArr2 = this.E;
            int i4 = ((-(this.xPivot + this.animPivotX)) * i) / amodel.scaleUnit;
            iArr2[2] = i4;
            iArr[0] = i4;
            int[] iArr3 = this.E;
            int[] iArr4 = this.E;
            int i5 = ((i * amodel.textures[this.unitID + this.animUnitID].getRect(this.textureID + this.animTextureID).width) / amodel.scaleUnit) + this.E[0];
            iArr4[6] = i5;
            iArr3[4] = i5;
            int[] iArr5 = this.E;
            int[] iArr6 = this.E;
            int i6 = ((-(this.yPivot + this.animPivotY)) * i2) / amodel.scaleUnit;
            iArr6[7] = i6;
            iArr5[1] = i6;
            int[] iArr7 = this.E;
            int[] iArr8 = this.E;
            int i7 = ((i2 * amodel.textures[this.unitID + this.animUnitID].getRect(this.textureID + this.animTextureID).height) / amodel.scaleUnit) + this.E[1];
            iArr8[5] = i7;
            iArr7[3] = i7;
        }
        this.G.a(this.rotation + this.animAngle, amodel.angleUnit);
        if (this.parentID + this.animParent != -1) {
            this.H.b(((this.xPos + this.animPosX) * amodel.parts[this.parentID + this.animParent].s) / amodel.scaleUnit, ((this.yPos + this.animPosY) * amodel.parts[this.parentID + this.animParent].v) / amodel.scaleUnit);
        } else {
            this.H.b(this.animPosX, this.animPosY);
        }
        this.a.a();
        if (this.parentID + this.animParent != -1) {
            this.a.a(amodel.parts[this.parentID + this.animParent].a);
        }
        this.a.a(this.H);
        this.a.a(this.G);
        for (int i8 = 0; i8 < 4; i8++) {
            this.a.a(this.E[i8 * 2], this.E[(i8 * 2) + 1], this.F);
            this.E[i8 * 2] = this.F.x;
            this.E[(i8 * 2) + 1] = this.F.y;
        }
    }

    public void a(aModel amodel, int i, int i2, aPoint apoint) {
        this.a.a((((i - this.xPivot) - this.animPivotX) * this.s) / amodel.scaleUnit, (((i2 - this.yPivot) - this.animPivotY) * this.v) / amodel.scaleUnit, apoint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(aModel amodel, aTextureRenderer atexturerenderer, int i, int i2) {
        if (this.unitID + this.animUnitID == -1) {
            return;
        }
        if (this.glow == 0) {
            atexturerenderer.setBlendMode(0);
        } else if (this.glow == 1) {
            atexturerenderer.setBlendMode(1);
        } else if (this.glow == 2) {
            atexturerenderer.setBlendMode(3);
        } else if (this.glow == 3) {
            atexturerenderer.setBlendMode(4);
        }
        atexturerenderer.setImageAlpha((this.baseAlpha * 255) / amodel.alphaUnit);
        atexturerenderer.drawScaledImage(amodel.textures[this.unitID + this.animUnitID], this.E[0] + i, this.E[1] + i2, this.E[2] + i, this.E[3] + i2, this.E[4] + i, this.E[5] + i2, this.E[6] + i, this.E[7] + i2, this.animTextureID + this.textureID);
    }
}
