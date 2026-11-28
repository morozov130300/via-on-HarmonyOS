package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2705c;

    public b(String str, long j10, Map map) {
        this.f2703a = str;
        this.f2704b = j10;
        HashMap map2 = new HashMap();
        this.f2705c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public final long a() {
        return this.f2704b;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b(this.f2703a, this.f2704b, new HashMap(this.f2705c));
    }

    public final Object c(String str) {
        if (this.f2705c.containsKey(str)) {
            return this.f2705c.get(str);
        }
        return null;
    }

    public final String d() {
        return this.f2703a;
    }

    public final Map e() {
        return this.f2705c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2704b == bVar.f2704b && this.f2703a.equals(bVar.f2703a)) {
            return this.f2705c.equals(bVar.f2705c);
        }
        return false;
    }

    public final void f(String str) {
        this.f2703a = str;
    }

    public final void g(String str, Object obj) {
        if (obj == null) {
            this.f2705c.remove(str);
        } else {
            this.f2705c.put(str, obj);
        }
    }

    public final int hashCode() {
        int iHashCode = this.f2703a.hashCode() * 31;
        long j10 = this.f2704b;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f2705c.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.f2703a + "', timestamp=" + this.f2704b + ", params=" + this.f2705c.toString() + "}";
    }
}
