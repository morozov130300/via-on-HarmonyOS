package ib;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7123a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7124b;

    /* renamed from: c, reason: collision with root package name */
    public int f7125c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7126d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7127e;

    public b0(int i10, boolean z10, int i11, boolean z11, int i12) {
        this.f7123a = i10;
        this.f7124b = z10;
        this.f7125c = i11;
        this.f7126d = z11;
        this.f7127e = i12;
    }

    public int a() {
        return this.f7127e;
    }

    public int b() {
        return this.f7123a;
    }

    public int c() {
        return this.f7125c;
    }

    public boolean d() {
        return this.f7126d;
    }

    public boolean e() {
        return this.f7124b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b0 b0Var = (b0) obj;
            if (this.f7123a == b0Var.f7123a && this.f7124b == b0Var.f7124b && this.f7125c == b0Var.f7125c && this.f7126d == b0Var.f7126d && this.f7127e == b0Var.f7127e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return u1.b(Integer.valueOf(this.f7123a), Boolean.valueOf(this.f7124b), Integer.valueOf(this.f7125c), Boolean.valueOf(this.f7126d), Integer.valueOf(this.f7127e));
    }
}
