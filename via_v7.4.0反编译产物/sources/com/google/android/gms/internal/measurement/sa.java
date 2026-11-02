package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class sa extends qa {
    @Override // com.google.android.gms.internal.measurement.qa
    public final /* synthetic */ int a(Object obj) {
        return ((ra) obj).a();
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* synthetic */ int b(Object obj) {
        return ((ra) obj).b();
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        a9 a9Var = (a9) obj;
        ra raVar = a9Var.zzc;
        if (raVar != ra.c()) {
            return raVar;
        }
        ra raVarF = ra.f();
        a9Var.zzc = raVarF;
        return raVarF;
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* synthetic */ Object d(Object obj) {
        return ((a9) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (!ra.c().equals(obj2)) {
            if (ra.c().equals(obj)) {
                return ra.e((ra) obj, (ra) obj2);
            }
            ((ra) obj).d((ra) obj2);
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* bridge */ /* synthetic */ void f(Object obj, int i10, long j10) {
        ((ra) obj).j(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final void g(Object obj) {
        ((a9) obj).zzc.h();
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* synthetic */ void h(Object obj, Object obj2) {
        ((a9) obj).zzc = (ra) obj2;
    }

    @Override // com.google.android.gms.internal.measurement.qa
    public final /* synthetic */ void i(Object obj, gb gbVar) {
        ((ra) obj).k(gbVar);
    }
}
