package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k2 f3526m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ u2 f3527n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h2(u2 u2Var, k2 k2Var) {
        super(u2Var, true);
        this.f3527n = u2Var;
        this.f3526m = k2Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3527n.f3820i)).registerOnMeasurementEventListener(this.f3526m);
    }
}
