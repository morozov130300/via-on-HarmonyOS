package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f3404a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3405b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f3406c;

    public b(String str, long j10, Map map) {
        this.f3404a = str;
        this.f3405b = j10;
        HashMap map2 = new HashMap();
        this.f3406c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public final long a() {
        return this.f3405b;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b(this.f3404a, this.f3405b, new HashMap(this.f3406c));
    }

    public final Object c(String str) {
        if (this.f3406c.containsKey(str)) {
            return this.f3406c.get(str);
        }
        return null;
    }

    public final String d() {
        return this.f3404a;
    }

    public final Map e() {
        return this.f3406c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f3405b == bVar.f3405b && this.f3404a.equals(bVar.f3404a)) {
            return this.f3406c.equals(bVar.f3406c);
        }
        return false;
    }

    public final void f(String str) {
        this.f3404a = str;
    }

    public final void g(String str, Object obj) {
        if (obj == null) {
            this.f3406c.remove(str);
        } else {
            this.f3406c.put(str, obj);
        }
    }

    public final int hashCode() {
        int iHashCode = this.f3404a.hashCode() * 31;
        long j10 = this.f3405b;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f3406c.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.f3404a + "', timestamp=" + this.f3405b + ", params=" + this.f3406c.toString() + "}";
    }
}
