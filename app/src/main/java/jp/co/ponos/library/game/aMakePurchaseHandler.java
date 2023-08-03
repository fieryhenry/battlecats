package jp.co.ponos.library.game;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.i */
/* loaded from: classes.dex */
public class aMakePurchaseHandler extends AsyncTask<String, String, Void> {
    final /* synthetic */ aPurchaseDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aMakePurchaseHandler(aPurchaseDialog apurchasedialog) {
        this.a = apurchasedialog;
    }

    /* JADX DEBUG: Method merged with bridge method: doInBackground([Ljava/lang/Object;)Ljava/lang/Object; */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
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
                    this.a.b = new String(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    this.a.a.a(this.a);
                    return null;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            this.a.a.b(this.a);
            return null;
        }
    }
}
