package jp.co.ponos.library.game;

public class aStringBuffer {
   StringBuffer buffer = new StringBuffer();

   public void append(String var1) {
      this.buffer.append(var1);
   }

   public String toString() {
      return this.buffer.toString();
   }
}
