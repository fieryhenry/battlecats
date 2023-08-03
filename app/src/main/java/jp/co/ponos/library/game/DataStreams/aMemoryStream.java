package jp.co.ponos.library.game.DataStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import jp.co.ponos.library.game.aGlobal;

/* renamed from: jp.co.ponos.library.b.a.d */
/* loaded from: classes.dex */
public class aMemoryStream {
    BufferedReader a;
    String[] b;
    PrintWriter c;

    public int getInt(int i) {
        return Integer.parseInt(this.b[i]);
    }

    public String readRawLine() {
        try {
            return this.a.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean openRead(String str) {
        try {
            this.a = new BufferedReader(new InputStreamReader(aGlobal.getInstance().getContext().openFileInput(str), "utf-8"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getString(int i) {
        return this.b[i];
    }

    public String[] readLine() {
        try {
            this.b = this.a.readLine().split(",", -1);
            return this.b;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] readLine(String str) {
        try {
            this.b = this.a.readLine().split(str, -1);
            return this.b;
        } catch (Exception e) {
            return null;
        }
    }

    public String c() {
        try {
            char[] cArr = new char[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int read = this.a.read(cArr);
                if (read == -1) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(cArr, 0, read);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void close() {
        try {
            if (this.a != null) {
                this.a.close();
                this.a = null;
            } else if (this.c != null) {
                this.c.close();
                this.c = null;
            }
        } catch (Exception e) {
        }
    }
}
