package jp.co.ponos.library.game.stream;

import android.content.SharedPreferences;
import android.util.Base64;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.Settings;
import jp.co.ponos.library.game.Utility;

public class SaveDataStream {
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    ByteArrayInputStream byteArrayInputStream;
    ByteArrayOutputStream byteArrayOutputStream;
    String e = null;
    ByteArrayOutputStream byteArrayOutputStream1;

    void reset() {
        this.dataInputStream = null;
        this.dataOutputStream = null;
        this.byteArrayOutputStream1 = null;
    }

    public void writeDouble(double d) {
        try {
            this.dataOutputStream.writeDouble(d);
            if (this.byteArrayOutputStream1 != null) {
                long doubleToLongBits = Double.doubleToLongBits(d);
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 56) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 48) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 40) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 32) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 24) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 16) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 8) & 255));
                this.byteArrayOutputStream1.write((byte) ((doubleToLongBits >> 0) & 255));
            }
        } catch (Exception e) {
        }
    }

    public void writeInt(int i) {
        try {
            this.dataOutputStream.writeInt(i);
            if (this.byteArrayOutputStream1 != null) {
                this.byteArrayOutputStream1.write((i >> 24) & 255);
                this.byteArrayOutputStream1.write((i >> 16) & 255);
                this.byteArrayOutputStream1.write((i >> 8) & 255);
                this.byteArrayOutputStream1.write((i >> 0) & 255);
            }
        } catch (Exception e) {
        }
    }

    public void writeBoolean(boolean z) {
        try {
            this.dataOutputStream.writeBoolean(z);
            if (this.byteArrayOutputStream1 != null) {
                this.byteArrayOutputStream1.write(z ? 1 : 0);
            }
        } catch (Exception e) {
        }
    }

    public boolean openRead(String saveName) {
        reset();
        String string = Global.getInstance().getContext().getSharedPreferences("save", 0).getString(saveName, "");
        if (string.length() == 0) {
            return false;
        }
        this.byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string, 0));
        this.dataInputStream = new DataInputStream(this.byteArrayInputStream);
        return true;
    }

    public boolean readBoolean() {
        try {
            return this.dataInputStream.readBoolean();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean openWrite(String str) {
        try {
            reset();
            this.e = str;
            this.byteArrayOutputStream = new ByteArrayOutputStream();
            this.dataOutputStream = new DataOutputStream(this.byteArrayOutputStream);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int readInt() {
        try {
            return this.dataInputStream.readInt();
        } catch (Exception e) {
            return 0;
        }
    }

    public void writeString(String str) {
        try {
            this.byteArrayOutputStream1 = new ByteArrayOutputStream();
            if (str == null) {
                this.byteArrayOutputStream1.write(Settings.getInstance().packageName.getBytes());
            } else {
                this.byteArrayOutputStream1.write(str.getBytes());
            }
        } catch (Exception e) {
        }
    }

    public double readDouble() {
        try {
            return this.dataInputStream.readDouble();
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public void enableMD5() {
        writeString(Settings.getInstance().packageName);
    }

    public boolean verifyMD5() {
        boolean z = false;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.dataInputStream.close();
            this.dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(byteArray)));
            if (byteArray.length >= 32) {
                this.byteArrayOutputStream1.write(byteArray, 0, byteArray.length - 32);
                byte[] byteArray2 = this.byteArrayOutputStream1.toByteArray();
                z = Utility.md5(byteArray2, byteArray2.length).equals(new String(byteArray, byteArray.length - 32, 32));
                return z;
            }
            return false;
        } catch (Exception e) {
            return z;
        }
    }

    public void close() {
        try {
            if (this.dataInputStream != null) {
                this.dataInputStream.close();
                this.dataInputStream = null;
                this.byteArrayInputStream = null;
            } else if (this.dataOutputStream != null) {
                if (this.byteArrayOutputStream1 != null) {
                    byte[] byteArray = this.byteArrayOutputStream1.toByteArray();
                    this.dataOutputStream.write(Utility.md5(byteArray, byteArray.length).getBytes());
                }
                SharedPreferences.Editor edit = Global.getInstance().getContext().getSharedPreferences("save", 0).edit();
                edit.putString(this.e, Base64.encodeToString(this.byteArrayOutputStream.toByteArray(), 0, this.byteArrayOutputStream.size(), 0));
                edit.commit();
                this.dataOutputStream.close();
                this.dataOutputStream = null;
                this.byteArrayOutputStream = null;
            }
            if (this.byteArrayOutputStream1 != null) {
                this.byteArrayOutputStream1.close();
                this.byteArrayOutputStream1 = null;
            }
        } catch (Exception e) {
        }
    }
}
