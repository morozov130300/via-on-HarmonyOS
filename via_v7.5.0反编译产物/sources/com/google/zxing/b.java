package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t3.b f3411b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f3410a = aVar;
    }

    public t3.b a() {
        if (this.f3411b == null) {
            this.f3411b = this.f3410a.b();
        }
        return this.f3411b;
    }

    public t3.a b(int i10, t3.a aVar) {
        return this.f3410a.c(i10, aVar);
    }

    public int c() {
        return this.f3410a.d();
    }

    public int d() {
        return this.f3410a.f();
    }

    public boolean e() {
        return this.f3410a.e().f();
    }

    public b f() {
        return new b(this.f3410a.a(this.f3410a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
