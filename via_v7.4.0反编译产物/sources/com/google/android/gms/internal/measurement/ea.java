package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ea implements la {

    /* renamed from: a, reason: collision with root package name */
    public final aa f3482a;

    /* renamed from: b, reason: collision with root package name */
    public final qa f3483b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3484c;

    /* renamed from: d, reason: collision with root package name */
    public final r8 f3485d;

    public ea(qa qaVar, r8 r8Var, aa aaVar) {
        this.f3483b = qaVar;
        this.f3484c = r8Var.c(aaVar);
        this.f3485d = r8Var;
        this.f3482a = aaVar;
    }

    public static ea j(qa qaVar, r8 r8Var, aa aaVar) {
        return new ea(qaVar, r8Var, aaVar);
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void a(Object obj) {
        this.f3483b.g(obj);
        this.f3485d.b(obj);
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void b(Object obj, gb gbVar) {
        this.f3485d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean c(Object obj) {
        this.f3485d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final Object d() {
        aa aaVar = this.f3482a;
        return aaVar instanceof a9 ? ((a9) aaVar).o() : aaVar.c().g();
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int e(Object obj) {
        int iHashCode = this.f3483b.d(obj).hashCode();
        if (!this.f3484c) {
            return iHashCode;
        }
        this.f3485d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void f(Object obj, byte[] bArr, int i10, int i11, w7 w7Var) {
        a9 a9Var = (a9) obj;
        if (a9Var.zzc == ra.c()) {
            a9Var.zzc = ra.f();
        }
        n.g.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int g(Object obj) {
        qa qaVar = this.f3483b;
        int iB = qaVar.b(qaVar.d(obj));
        if (!this.f3484c) {
            return iB;
        }
        this.f3485d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void h(Object obj, Object obj2) {
        na.b(this.f3483b, obj, obj2);
        if (this.f3484c) {
            this.f3485d.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean i(Object obj, Object obj2) {
        if (!this.f3483b.d(obj).equals(this.f3483b.d(obj2))) {
            return false;
        }
        if (!this.f3484c) {
            return true;
        }
        this.f3485d.a(obj);
        this.f3485d.a(obj2);
        throw null;
    }
}
