package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3477m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f3478n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ u2 f3479o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(u2 u2Var, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(u2Var, false);
        this.f3479o = u2Var;
        this.f3477m = str;
        this.f3478n = obj;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3479o.f3820i)).logHealthData(5, this.f3477m, y1.b.b0(this.f3478n), y1.b.b0(null), y1.b.b0(null));
    }
}
