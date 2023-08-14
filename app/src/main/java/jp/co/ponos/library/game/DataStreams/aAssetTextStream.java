package jp.co.ponos.library.game.DataStreams;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aUtility;

/* renamed from: jp.co.ponos.library.b.a.b */
/* loaded from: classes.dex */
public class aAssetTextStream extends aFileStream {
    public static String getHash(String str) {
        try {
            DataInputStream dataInputStream = new DataInputStream(aGlobal.getInstance().getContext().getAssets().open(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    String hash = aUtility.md5(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length);
                    byteArrayOutputStream.close();
                    dataInputStream.close();
                    return hash;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override // jp.co.ponos.library.game.DataStreams.aFileStream
    /* renamed from: a */
    public boolean openRead(String str) {
        try {
            this.a = new DataInputStream(aGlobal.getInstance().getContext().getAssets().open(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
