package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f8 extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f2798m;

    public f8(c cVar) {
        super("internal.eventLogger");
        this.f2798m = cVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h(this.f2884c, 3, list);
        String strF = q4Var.b((r) list.get(0)).f();
        long jA = (long) r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
        r rVarB = q4Var.b((r) list.get(2));
        this.f2798m.e(strF, jA, rVarB instanceof o ? r5.g((o) rVarB) : new HashMap());
        return r.f3013a;
    }
}
