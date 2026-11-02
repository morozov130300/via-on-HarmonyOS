package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3513m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d1 f3514n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ u2 f3515o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(u2 u2Var, String str, d1 d1Var) {
        super(u2Var, true);
        this.f3515o = u2Var;
        this.f3513m = str;
        this.f3514n = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3515o.f3820i)).getMaxUserProperties(this.f3513m, this.f3514n);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f3514n.w(null);
    }
}
