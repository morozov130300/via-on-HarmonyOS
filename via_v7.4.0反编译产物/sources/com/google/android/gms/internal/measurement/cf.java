package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class cf extends k {

    /* renamed from: k, reason: collision with root package name */
    public final gf f3433k;

    public cf(gf gfVar) {
        super("internal.registerCallback");
        this.f3433k = gfVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h(this.f3585e, 3, list);
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
        this.f3433k.a(strF, oVar.k("priority") ? r5.b(oVar.p("priority").e().doubleValue()) : 1000, (q) rVarB, oVar.p("type").f());
        return r.f3714a;
    }
}
