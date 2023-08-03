package jp.co.ponos.library.game.DataStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import jp.co.ponos.library.game.aGlobal;

/* renamed from: jp.co.ponos.library.b.a.c */
/* loaded from: classes.dex */
public class aResourceFileStream extends aMemoryStream {
    @Override // jp.co.ponos.library.game.DataStreams.aMemoryStream
    public boolean openRead(String str) {
        try {
            this.a = new BufferedReader(new InputStreamReader(aGlobal.getInstance().getContext().getAssets().open(str), "utf-8"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
