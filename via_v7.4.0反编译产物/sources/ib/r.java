package ib;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public int f7158a;

    /* renamed from: b, reason: collision with root package name */
    public String f7159b;

    /* renamed from: c, reason: collision with root package name */
    public String f7160c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7161d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7162e;

    public r(int i10, String str, String str2, boolean z10, boolean z11) {
        this.f7158a = i10;
        this.f7159b = str;
        this.f7160c = str2;
        this.f7162e = z10;
        this.f7161d = z11;
    }

    public int a() {
        return this.f7158a;
    }

    public String b() {
        return this.f7160c;
    }

    public String c() {
        return this.f7159b;
    }

    public boolean d() {
        return this.f7162e;
    }

    public boolean e() {
        return this.f7161d;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            r rVar = (r) obj;
            if (this.f7158a == rVar.f7158a && this.f7161d == rVar.f7161d && this.f7162e == rVar.f7162e && u1.a(this.f7159b, rVar.f7159b) && u1.a(this.f7160c, rVar.f7160c)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z10) {
        this.f7162e = z10;
    }

    public int hashCode() {
        return u1.b(Integer.valueOf(this.f7158a), this.f7159b, this.f7160c, Boolean.valueOf(this.f7161d), Boolean.valueOf(this.f7162e));
    }
}
