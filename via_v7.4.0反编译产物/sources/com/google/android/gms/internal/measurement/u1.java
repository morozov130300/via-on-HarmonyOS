package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u1 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Activity f3807m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3808n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3809o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f3810p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(u2 u2Var, Activity activity, String str, String str2) {
        super(u2Var, true);
        this.f3810p = u2Var;
        this.f3807m = activity;
        this.f3808n = str;
        this.f3809o = str2;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3810p.f3820i)).setCurrentScreen(y1.b.b0(this.f3807m), this.f3808n, this.f3809o, this.f3568e);
    }
}
