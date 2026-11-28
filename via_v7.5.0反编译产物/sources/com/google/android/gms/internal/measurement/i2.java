package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Long f2846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f2847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f2848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Bundle f2849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ boolean f2850s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ boolean f2851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ u2 f2852u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2(u2 u2Var, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(u2Var, true);
        this.f2852u = u2Var;
        this.f2846o = l10;
        this.f2847p = str;
        this.f2848q = str2;
        this.f2849r = bundle;
        this.f2850s = z10;
        this.f2851t = z11;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        Long l10 = this.f2846o;
        ((h1) u1.f.h(this.f2852u.f3119i)).logEvent(this.f2847p, this.f2848q, this.f2849r, this.f2850s, this.f2851t, l10 == null ? this.f2867c : l10.longValue());
    }
}
