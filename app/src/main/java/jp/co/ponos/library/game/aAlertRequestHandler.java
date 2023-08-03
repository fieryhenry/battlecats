package jp.co.ponos.library.game;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: jp.co.ponos.library.b.ak */
/* loaded from: classes.dex */
class aAlertRequestHandler extends AsyncTask<String, String, Void> {
    final /* synthetic */ AlertRunner a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aAlertRequestHandler(AlertRunner alertRunner) {
        this.a = alertRunner;
    }

    /* JADX DEBUG: Method merged with bridge method: doInBackground([Ljava/lang/Object;)Ljava/lang/Object; */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(String... strArr) {
        aUtility autility;
        aUtility autility2;
        aUtility autility3;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[256];
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    autility2 = this.a.b;
                    autility2.g = new String(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    autility3 = this.a.b;
                    autility3.h.a = 1;
                    return null;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            autility = this.a.b;
            autility.h.a = 2;
            return null;
        }
    }
}
