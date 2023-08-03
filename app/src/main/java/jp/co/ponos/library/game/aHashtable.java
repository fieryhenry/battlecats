package jp.co.ponos.library.game;

import java.util.Hashtable;

/* renamed from: jp.co.ponos.library.b.g */
/* loaded from: classes.dex */
public class aHashtable {
    Hashtable a = new Hashtable();

    /* renamed from: a */
    public String get(String str) {
        return (String) this.a.get(str);
    }

    /* renamed from: a */
    public void put(String str, String str2) {
        this.a.put(str, str2);
    }

    /* renamed from: b */
    public boolean contains(String str) {
        return this.a.containsKey(str);
    }
}
