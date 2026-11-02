package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Long f3547m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3548n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3549o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Bundle f3550p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f3551q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ boolean f3552r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ u2 f3553s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(u2 u2Var, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(u2Var, true);
        this.f3553s = u2Var;
        this.f3547m = l10;
        this.f3548n = str;
        this.f3549o = str2;
        this.f3550p = bundle;
        this.f3551q = z10;
        this.f3552r = z11;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        Long l10 = this.f3547m;
        ((h1) t1.f.h(this.f3553s.f3820i)).logEvent(this.f3548n, this.f3549o, this.f3550p, this.f3551q, this.f3552r, l10 == null ? this.f3568e : l10.longValue());
    }
}
