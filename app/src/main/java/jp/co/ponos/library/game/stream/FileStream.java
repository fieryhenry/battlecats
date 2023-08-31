package jp.co.ponos.library.game.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import jp.co.ponos.library.game.Utility;
import jp.co.ponos.library.game.Global;
import jp.co.ponos.library.game.Settings;

public class FileStream extends SaveDataStream {
   DataInputStream dataInputStream;
   DataOutputStream dataOutputStream;
   ByteArrayOutputStream byteArrayOutputStream;
   DataOutputStream dataOutputStream1;
   ByteArrayInputStream e;

   @Override
   public void writeDouble(double var1) {
      try {
         this.dataOutputStream.writeDouble(var1);
         if (this.dataOutputStream1 != null) {
            this.dataOutputStream1.writeDouble(var1);
         }
      } catch (Exception var4) {
      }

   }
   @Override
   public void writeInt(int var1) {
      try {
         this.dataOutputStream.writeInt(var1);
         if (this.dataOutputStream1 != null) {
            this.dataOutputStream1.writeInt(var1);
         }
      } catch (Exception var3) {
      }

   }
   @Override

   public void writeBoolean(boolean var1) {
      try {
         this.dataOutputStream.writeBoolean(var1);
         if (this.dataOutputStream1 != null) {
            this.dataOutputStream1.writeBoolean(var1);
         }
      } catch (Exception var3) {
      }

   }
   @Override
   public boolean readBoolean() {
      boolean var1;
      try {
         var1 = this.dataInputStream.readBoolean();
      } catch (Exception var3) {
         var1 = false;
      }

      return var1;
   }
   @Override
   public boolean openRead(String var1) {
      boolean var3;
      try {
         DataInputStream var2 = new DataInputStream(Global.getInstance().getContext().openFileInput(var1));
         this.dataInputStream = var2;
      } catch (Exception var4) {
         var3 = false;
         return var3;
      }

      var3 = true;
      return var3;
   }
   @Override
   public int readInt() {
      int var1;
      try {
         var1 = this.dataInputStream.readInt();
      } catch (Exception var3) {
         var1 = 0;
      }

      return var1;
   }
   @Override
   public boolean openWrite(String var1) {

      try {
         DataOutputStream var3 = new DataOutputStream(Global.getInstance().getContext().openFileOutput(var1, 0));
         this.dataOutputStream = var3;
      } catch (Exception var4) {
         return false;
      }

      return true;
   }
   @Override
   public double readDouble() {
      double var1;
      try {
         var1 = this.dataInputStream.readDouble();
      } catch (Exception var4) {
         var1 = 0.0;
      }

      return var1;
   }
   @Override
   public void writeString(String var1) {
      boolean var10001;
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         this.byteArrayOutputStream = var2;
         DataOutputStream var6 = new DataOutputStream(this.byteArrayOutputStream);
         this.dataOutputStream1 = var6;
      } catch (Exception var5) {
         var10001 = false;
         return;
      }

      if (var1 == null) {
         try {
            this.dataOutputStream1.write(Settings.getInstance().packageName.getBytes());
         } catch (Exception var3) {
            var10001 = false;
         }
      } else {
         try {
            this.dataOutputStream1.write(var1.getBytes());
         } catch (Exception var4) {
            var10001 = false;
         }
      }

   }
   @Override
   public void enableMD5() {
      this.writeString(Settings.getInstance().packageName);
   }
   @Override
   public boolean verifyMD5() {
      boolean var1 = false;

      boolean var5;
      label44: {
         boolean var10001;
         ByteArrayOutputStream var2;
         byte[] var3;
         try {
            var2 = new ByteArrayOutputStream();
            var3 = new byte[1024];
         } catch (Exception var12) {
            var10001 = false;
            break label44;
         }

         while(true) {
            int var4;
            try {
               var4 = this.dataInputStream.read(var3);
            } catch (Exception var10) {
               var10001 = false;
               break;
            }

            if (var4 == -1) {
               try {
                  var3 = var2.toByteArray();
                  var2.close();
               } catch (Exception var9) {
                  var10001 = false;
                  break;
               }

               var5 = var1;

               try {
                  if (var3.length >= 32) {
                     this.dataOutputStream1.write(var3, 0, var3.length - 32);
                     byte[] var6 = this.byteArrayOutputStream.toByteArray();
                     this.dataInputStream.close();
                     ByteArrayInputStream var7 = new ByteArrayInputStream(var2.toByteArray());
                     this.e = var7;
                     DataInputStream var13 = new DataInputStream(this.e);
                     this.dataInputStream = var13;
                     String var15 = Utility.md5(var6, var6.length);
                     String var14 = new String(var3, var3.length - 32, 32);
                     var5 = var15.equals(var14);
                  }

                  return var5;
               } catch (Exception var8) {
                  var10001 = false;
                  break;
               }
            }

            try {
               var2.write(var3, 0, var4);
            } catch (Exception var11) {
               var10001 = false;
               break;
            }
         }
      }

      var5 = var1;
      return var5;
   }
   @Override
   public void close() {
      try {
         if (this.dataInputStream != null) {
            this.dataInputStream.close();
            this.dataInputStream = null;
         } else if (this.dataOutputStream != null) {
            if (this.dataOutputStream1 != null) {
               byte[] byteArray = this.byteArrayOutputStream.toByteArray();
               this.dataOutputStream.write(Utility.md5(byteArray, byteArray.length).getBytes());
            }
            this.dataOutputStream.close();
            this.dataOutputStream = null;
         }
         if (this.dataOutputStream1 != null) {
            this.dataOutputStream1.close();
            this.dataOutputStream1 = null;
         }
         if (this.byteArrayOutputStream != null) {
            this.byteArrayOutputStream.close();
            this.byteArrayOutputStream = null;
         }
         if (this.e != null) {
            this.e.close();
            this.e = null;
         }
      } catch (Exception e) {
      }
   }
}
