package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k2 extends m1 {

    /* renamed from: d, reason: collision with root package name */
    public final f2.k6 f3587d;

    public k2(f2.k6 k6Var) {
        this.f3587d = k6Var;
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final int c() {
        return System.identityHashCode(this.f3587d);
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final void d(String str, String str2, Bundle bundle, long j10) {
        this.f3587d.a(str, str2, bundle, j10);
    }
}
