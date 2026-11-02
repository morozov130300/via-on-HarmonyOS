package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x1 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3879m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ u2 f3880n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(u2 u2Var, String str) {
        super(u2Var, true);
        this.f3880n = u2Var;
        this.f3879m = str;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3880n.f3820i)).endAdUnitExposure(this.f3879m, this.f3569j);
    }
}
