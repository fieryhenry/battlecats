package jp.co.ponos.library.game.DataStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import jp.co.ponos.library.game.aGlobal;
import jp.co.ponos.library.game.aSettings;
import jp.co.ponos.library.game.aUtility;

/* renamed from: jp.co.ponos.library.b.a.a */
/* loaded from: classes.dex */
public class aFileStream {
    DataInputStream a;
    DataOutputStream b;
    ByteArrayOutputStream c;
    DataOutputStream d;
    ByteArrayInputStream e;

    public void writeDouble(double d) {
        try {
            this.b.writeDouble(d);
            if (this.d != null) {
                this.d.writeDouble(d);
            }
        } catch (Exception e) {
        }
    }

    public void writeInt(int i) {
        try {
            this.b.writeInt(i);
            if (this.d != null) {
                this.d.writeInt(i);
            }
        } catch (Exception e) {
        }
    }

    public void writeBoolean(boolean z) {
        try {
            this.b.writeBoolean(z);
            if (this.d != null) {
                this.d.writeBoolean(z);
            }
        } catch (Exception e) {
        }
    }

    public boolean readBoolean() {
        try {
            return this.a.readBoolean();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean openRead(String str) {
        try {
            this.a = new DataInputStream(aGlobal.getInstance().getContext().openFileInput(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int readInt() {
        try {
            return this.a.readInt();
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: b */
    public boolean openWrite(String str) {
        try {
            this.b = new DataOutputStream(aGlobal.getInstance().getContext().openFileOutput(str, 0));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public double readDouble() {
        try {
            return this.a.readDouble();
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public void writeString(String str) {
        try {
            this.c = new ByteArrayOutputStream();
            this.d = new DataOutputStream(this.c);
            if (str == null) {
                this.d.write(aSettings.getInstance().packageName.getBytes());
            } else {
                this.d.write(str.getBytes());
            }
        } catch (Exception e) {
        }
    }

    public void enableMD5() {
        writeString(aSettings.getInstance().packageName);
    }

    public boolean verifyMD5() {
        boolean z = false;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.a.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray.length >= 32) {
                this.d.write(byteArray, 0, byteArray.length - 32);
                byte[] byteArray2 = this.c.toByteArray();
                this.a.close();
                this.e = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                this.a = new DataInputStream(this.e);
                z = aUtility.decrypt(byteArray2, byteArray2.length).equals(new String(byteArray, byteArray.length - 32, 32));
                return z;
            }
            return false;
        } catch (Exception e) {
            return z;
        }
    }

    public void close() {
        try {
            if (this.a != null) {
                this.a.close();
                this.a = null;
            } else if (this.b != null) {
                if (this.d != null) {
                    byte[] byteArray = this.c.toByteArray();
                    this.b.write(aUtility.decrypt(byteArray, byteArray.length).getBytes());
                }
                this.b.close();
                this.b = null;
            }
            if (this.d != null) {
                this.d.close();
                this.d = null;
            }
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
            if (this.e != null) {
                this.e.close();
                this.e = null;
            }
        } catch (Exception e) {
        }
    }
}
