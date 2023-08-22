package jp.co.ponos.library.game.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import jp.co.ponos.library.game.Global;

public class TextStream {
   BufferedReader readerBuffer;
   String[] currentLine;
   PrintWriter c;

   public int getInt(int var1) {
      return Integer.parseInt(this.currentLine[var1]);
   }

   public String getLine() {
      String line;
      try {
         line = this.readerBuffer.readLine();
      } catch (Exception var2) {
         line = null;
      }

      return line;
   }

   public boolean openRead(String var1) {
      try {
         InputStreamReader var3 = new InputStreamReader(Global.getInstance().getContext().openFileInput(var1), "utf-8");
         BufferedReader var2 = new BufferedReader(var3);
         this.readerBuffer = var2;
      } catch (Exception var5) {
         return false;
      }

      return true;
   }

   public String getLine(int var1) {
      return this.currentLine[var1];
   }

   public String[] readLine() {
      String[] var1;
      try {
         this.currentLine = this.readerBuffer.readLine().split(",", -1);
         var1 = this.currentLine;
      } catch (Exception var2) {
         var1 = null;
      }

      return var1;
   }

   public String[] readLine(String delim) {
      String[] var3;
      try {
         this.currentLine = this.readerBuffer.readLine().split(delim, -1);
         var3 = this.currentLine;
      } catch (Exception var2) {
         var3 = null;
      }

      return var3;
   }

   public String c() {
      String var8;
      label33: {
         char[] var1;
         boolean var10001;
         StringBuffer var2;
         try {
            var1 = new char[1024];
            var2 = new StringBuffer();
         } catch (Exception var7) {
            var10001 = false;
            break label33;
         }

         while(true) {
            int var3;
            try {
               var3 = this.readerBuffer.read(var1);
            } catch (Exception var5) {
               var10001 = false;
               break;
            }

            if (var3 == -1) {
               try {
                  var8 = var2.toString();
                  return var8;
               } catch (Exception var4) {
                  var10001 = false;
                  break;
               }
            }

            try {
               var2.append(var1, 0, var3);
            } catch (Exception var6) {
               var10001 = false;
               break;
            }
         }
      }

      var8 = null;
      return var8;
   }

   public void close() {
      try {
         if (this.readerBuffer != null) {
            this.readerBuffer.close();
            this.readerBuffer = null;
         } else if (this.c != null) {
            this.c.close();
            this.c = null;
         }
      } catch (Exception var2) {
      }

   }
}
