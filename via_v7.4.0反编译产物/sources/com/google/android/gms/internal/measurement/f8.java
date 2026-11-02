package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f8 extends k {

    /* renamed from: k, reason: collision with root package name */
    public final c f3499k;

    public f8(c cVar) {
        super("internal.eventLogger");
        this.f3499k = cVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h(this.f3585e, 3, list);
        String strF = q4Var.b((r) list.get(0)).f();
        long jA = (long) r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
        r rVarB = q4Var.b((r) list.get(2));
        this.f3499k.e(strF, jA, rVarB instanceof o ? r5.g((o) rVarB) : new HashMap());
        return r.f3714a;
    }
}
