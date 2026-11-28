package ib;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6394e;

    public r(int i10, String str, String str2, boolean z10, boolean z11) {
        this.f6390a = i10;
        this.f6391b = str;
        this.f6392c = str2;
        this.f6394e = z10;
        this.f6393d = z11;
    }

    public int a() {
        return this.f6390a;
    }

    public String b() {
        return this.f6392c;
    }

    public String c() {
        return this.f6391b;
    }

    public boolean d() {
        return this.f6394e;
    }

    public boolean e() {
        return this.f6393d;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            r rVar = (r) obj;
            if (this.f6390a == rVar.f6390a && this.f6393d == rVar.f6393d && this.f6394e == rVar.f6394e && t1.a(this.f6391b, rVar.f6391b) && t1.a(this.f6392c, rVar.f6392c)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z10) {
        this.f6394e = z10;
    }

    public int hashCode() {
        return t1.b(Integer.valueOf(this.f6390a), this.f6391b, this.f6392c, Boolean.valueOf(this.f6393d), Boolean.valueOf(this.f6394e));
    }
}
