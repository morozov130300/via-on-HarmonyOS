package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y1 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d1 f3890m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ u2 f3891n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(u2 u2Var, d1 d1Var) {
        super(u2Var, true);
        this.f3891n = u2Var;
        this.f3890m = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3891n.f3820i)).getGmpAppId(this.f3890m);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f3890m.w(null);
    }
}
