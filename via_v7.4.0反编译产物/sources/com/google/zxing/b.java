package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f4113a;

    /* renamed from: b, reason: collision with root package name */
    public s3.b f4114b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f4113a = aVar;
    }

    public s3.b a() {
        if (this.f4114b == null) {
            this.f4114b = this.f4113a.b();
        }
        return this.f4114b;
    }

    public s3.a b(int i10, s3.a aVar) {
        return this.f4113a.c(i10, aVar);
    }

    public int c() {
        return this.f4113a.d();
    }

    public int d() {
        return this.f4113a.f();
    }

    public boolean e() {
        return this.f4113a.e().f();
    }

    public b f() {
        return new b(this.f4113a.a(this.f4113a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
