package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3440m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3441n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f3442o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d1 f3443p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u2 f3444q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(u2 u2Var, String str, String str2, boolean z10, d1 d1Var) {
        super(u2Var, true);
        this.f3444q = u2Var;
        this.f3440m = str;
        this.f3441n = str2;
        this.f3442o = z10;
        this.f3443p = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3444q.f3820i)).getUserProperties(this.f3440m, this.f3441n, this.f3442o, this.f3443p);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f3443p.w(null);
    }
}
