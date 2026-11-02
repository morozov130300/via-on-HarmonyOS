package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s1 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3746m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3747n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bundle f3748o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f3749p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(u2 u2Var, String str, String str2, Bundle bundle) {
        super(u2Var, true);
        this.f3749p = u2Var;
        this.f3746m = str;
        this.f3747n = str2;
        this.f3748o = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) t1.f.h(this.f3749p.f3820i)).clearConditionalUserProperty(this.f3746m, this.f3747n, this.f3748o);
    }
}
