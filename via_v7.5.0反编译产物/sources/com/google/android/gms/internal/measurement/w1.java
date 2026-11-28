package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f3159p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w1(u2 u2Var, String str) {
        super(u2Var, true);
        this.f3159p = u2Var;
        this.f3158o = str;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3159p.f3119i)).beginAdUnitExposure(this.f3158o, this.f2868e);
    }
}
