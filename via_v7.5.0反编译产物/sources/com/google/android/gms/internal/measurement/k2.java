package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k2 extends m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g2.k6 f2886d;

    public k2(g2.k6 k6Var) {
        this.f2886d = k6Var;
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final int c() {
        return System.identityHashCode(this.f2886d);
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final void d(String str, String str2, Bundle bundle, long j10) {
        this.f2886d.a(str, str2, bundle, j10);
    }
}
