package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends y {
    public f0() {
        this.f3188a.add(zzbl.AND);
        this.f3188a.add(zzbl.NOT);
        this.f3188a.add(zzbl.OR);
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
