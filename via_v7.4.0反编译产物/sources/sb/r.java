package sb;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f11993a;

    /* renamed from: b, reason: collision with root package name */
    public String f11994b;

    /* renamed from: c, reason: collision with root package name */
    public Throwable f11995c;

    public r(int i10, String str) {
        this(i10, str, null);
    }

    public r(int i10, String str, Throwable th) {
        this.f11993a = i10;
        this.f11994b = str;
        this.f11995c = th;
    }

    public static r a(String str) {
        return new r(1, str, null);
    }

    public static r b(String str) {
        return new r(0, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            r rVar = (r) obj;
            if (this.f11993a == rVar.f11993a && u1.a(this.f11994b, rVar.f11994b) && u1.a(this.f11995c, rVar.f11995c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return u1.b(Integer.valueOf(this.f11993a), this.f11994b, this.f11995c);
    }

    public String toString() {
        return "UpdateResult{code=" + this.f11993a + ", message='" + this.f11994b + "', error=" + this.f11995c + '}';
    }
}
