package jp.co.ponos.library.game;

import java.util.Hashtable;

public class aHashTable {
   Hashtable hashtable = new Hashtable();

   public String get(String var1) {
      return (String)this.hashtable.get(var1);
   }

   public void put(String var1, String var2) {
      this.hashtable.put(var1, var2);
   }

   public boolean contains(String var1) {
      return this.hashtable.containsKey(var1);
   }
}
