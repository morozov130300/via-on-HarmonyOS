package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Activity f3724m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d1 f3725n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ t2 f3726o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(t2 t2Var, Activity activity, d1 d1Var) {
        super(t2Var.f3779e, true);
        this.f3726o = t2Var;
        this.f3724m = activity;
        this.f3725n = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3726o.f3779e.f3820i)).onActivitySaveInstanceState(y1.b.b0(this.f3724m), this.f3725n, this.f3569j);
    }
}
