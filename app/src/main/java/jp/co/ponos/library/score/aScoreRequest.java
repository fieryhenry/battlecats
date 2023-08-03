package jp.co.ponos.library.score;

import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: jp.co.ponos.library.d.c */
/* loaded from: classes.dex */
class aScoreRequest extends AsyncTask {
    final /* synthetic */ aScoreDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aScoreRequest(aScoreDialog ascoredialog) {
        this.a = ascoredialog;
    }

    /* JADX DEBUG: Method merged with bridge method: doInBackground([Ljava/lang/Object;)Ljava/lang/Object; */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Object... objArr) {
        aScoreUploader ascoreuploader;
        aScoreUploader ascoreuploader2;
        boolean z;
        aScoreUploader ascoreuploader3;
        aScoreUploader ascoreuploader4;
        aScoreUploader ascoreuploader5;
        aScoreUploader ascoreuploader6;
        aScoreUploader ascoreuploader7;
        if (objArr[3] != null) {
            ascoreuploader6 = this.a.f;
            ascoreuploader6.scoreInstance.a((String) objArr[1], ((int[]) objArr[3])[0], 1);
            ascoreuploader7 = this.a.f;
            ascoreuploader7.scoreInstance.a((String) objArr[1], (int[]) objArr[3], objArr[4] != null ? (int[]) objArr[4] : null, 1);
        } else {
            ascoreuploader = this.a.f;
            ascoreuploader.scoreInstance.a((String) objArr[1], 0, 2);
            ascoreuploader2 = this.a.f;
            ascoreuploader2.scoreInstance.a((String) objArr[1], null, null, 2);
        }
        try {
            ascoreuploader5 = this.a.f;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(ascoreuploader5.submitScore((String) objArr[0], (String) objArr[1], (String) objArr[2], (int[]) objArr[3], (int[]) objArr[4])).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            boolean z2 = (inputStream.read() == 79 && inputStream.read() == 75) ? false : true;
            inputStream.close();
            httpURLConnection.disconnect();
            z = z2;
        } catch (Exception e) {
            z = true;
        }
        ascoreuploader3 = this.a.f;
        ascoreuploader3.scoreInstance.b((String) objArr[1], ((int[]) objArr[3])[0], !z ? 1 : 2);
        ascoreuploader4 = this.a.f;
        ascoreuploader4.scoreInstance.b((String) objArr[1], (int[]) objArr[3], objArr[4] != null ? (int[]) objArr[4] : null, z ? 2 : 1);
        return null;
    }
}
