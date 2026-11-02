package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f0 extends y {
    public f0() {
        this.f3889a.add(zzbl.AND);
        this.f3889a.add(zzbl.NOT);
        this.f3889a.add(zzbl.OR);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = r5.e(str).ordinal();
        if (iOrdinal == 1) {
            r5.h(zzbl.AND.name(), 2, list);
            r rVarB = q4Var.b((r) list.get(0));
            return !rVarB.g().booleanValue() ? rVarB : q4Var.b((r) list.get(1));
        }
        if (iOrdinal == 47) {
            r5.h(zzbl.NOT.name(), 1, list);
            return new g(Boolean.valueOf(!q4Var.b((r) list.get(0)).g().booleanValue()));
        }
        if (iOrdinal != 50) {
            return super.b(str);
        }
        r5.h(zzbl.OR.name(), 2, list);
        r rVarB2 = q4Var.b((r) list.get(0));
        return rVarB2.g().booleanValue() ? rVarB2 : q4Var.b((r) list.get(1));
    }
}
