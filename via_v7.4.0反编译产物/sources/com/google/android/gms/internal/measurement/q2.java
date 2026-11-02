package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Activity f3697m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t2 f3698n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(t2 t2Var, Activity activity) {
        super(t2Var.f3779e, true);
        this.f3698n = t2Var;
        this.f3697m = activity;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3698n.f3779e.f3820i)).onActivityStopped(y1.b.b0(this.f3697m), this.f3569j);
    }
}
