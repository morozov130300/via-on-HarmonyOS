package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class cf extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final gf f2732m;

    public cf(gf gfVar) {
        super("internal.registerCallback");
        this.f2732m = gfVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h(this.f2884c, 3, list);
        String strF = q4Var.b((r) list.get(0)).f();
        r rVarB = q4Var.b((r) list.get(1));
        if (!(rVarB instanceof q)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        r rVarB2 = q4Var.b((r) list.get(2));
        if (!(rVarB2 instanceof o)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        o oVar = (o) rVarB2;
        if (!oVar.k("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        this.f2732m.a(strF, oVar.k("priority") ? r5.b(oVar.p("priority").e().doubleValue()) : 1000, (q) rVarB, oVar.p("type").f());
        return r.f3013a;
    }
}
