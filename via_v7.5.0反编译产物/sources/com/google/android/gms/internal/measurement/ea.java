package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ea implements la {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa f2781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qa f2782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r8 f2784d;

    public ea(qa qaVar, r8 r8Var, aa aaVar) {
        this.f2782b = qaVar;
        this.f2783c = r8Var.c(aaVar);
        this.f2784d = r8Var;
        this.f2781a = aaVar;
    }

    public static ea j(qa qaVar, r8 r8Var, aa aaVar) {
        return new ea(qaVar, r8Var, aaVar);
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void a(Object obj) {
        this.f2782b.g(obj);
        this.f2784d.b(obj);
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void b(Object obj, gb gbVar) {
        this.f2784d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean c(Object obj) {
        this.f2784d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final Object d() {
        aa aaVar = this.f2781a;
        return aaVar instanceof a9 ? ((a9) aaVar).o() : aaVar.d().f();
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int e(Object obj) {
        int iHashCode = this.f2782b.d(obj).hashCode();
        if (!this.f2783c) {
            return iHashCode;
        }
        this.f2784d.a(obj);
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
        qa qaVar = this.f2782b;
        int iB = qaVar.b(qaVar.d(obj));
        if (!this.f2783c) {
            return iB;
        }
        this.f2784d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void h(Object obj, Object obj2) {
        na.b(this.f2782b, obj, obj2);
        if (this.f2783c) {
            this.f2784d.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean i(Object obj, Object obj2) {
        if (!this.f2782b.d(obj).equals(this.f2782b.d(obj2))) {
            return false;
        }
        if (!this.f2783c) {
            return true;
        }
        this.f2784d.a(obj);
        this.f2784d.a(obj2);
        throw null;
    }
}
