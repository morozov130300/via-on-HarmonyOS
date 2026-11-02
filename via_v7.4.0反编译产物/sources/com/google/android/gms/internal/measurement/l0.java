package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l0 extends y {
    public l0() {
        this.f3889a.add(zzbl.ADD);
        this.f3889a.add(zzbl.DIVIDE);
        this.f3889a.add(zzbl.MODULUS);
        this.f3889a.add(zzbl.MULTIPLY);
        this.f3889a.add(zzbl.NEGATE);
        this.f3889a.add(zzbl.POST_DECREMENT);
        this.f3889a.add(zzbl.POST_INCREMENT);
        this.f3889a.add(zzbl.PRE_DECREMENT);
        this.f3889a.add(zzbl.PRE_INCREMENT);
        this.f3889a.add(zzbl.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = r5.e(str).ordinal();
        if (iOrdinal == 0) {
            r5.h(zzbl.ADD.name(), 2, list);
            r rVarB = q4Var.b((r) list.get(0));
            r rVarB2 = q4Var.b((r) list.get(1));
            if (!(rVarB instanceof n) && !(rVarB instanceof v) && !(rVarB2 instanceof n) && !(rVarB2 instanceof v)) {
                return new j(Double.valueOf(rVarB.e().doubleValue() + rVarB2.e().doubleValue()));
            }
            return new v(String.valueOf(rVarB.f()).concat(String.valueOf(rVarB2.f())));
        }
        if (iOrdinal == 21) {
            r5.h(zzbl.DIVIDE.name(), 2, list);
            return new j(Double.valueOf(q4Var.b((r) list.get(0)).e().doubleValue() / q4Var.b((r) list.get(1)).e().doubleValue()));
        }
        if (iOrdinal == 59) {
            r5.h(zzbl.SUBTRACT.name(), 2, list);
            return new j(Double.valueOf(q4Var.b((r) list.get(0)).e().doubleValue() + new j(Double.valueOf(-q4Var.b((r) list.get(1)).e().doubleValue())).e().doubleValue()));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            r5.h(str, 2, list);
            r rVarB3 = q4Var.b((r) list.get(0));
            q4Var.b((r) list.get(1));
            return rVarB3;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            r5.h(str, 1, list);
            return q4Var.b((r) list.get(0));
        }
        switch (iOrdinal) {
            case 44:
                r5.h(zzbl.MODULUS.name(), 2, list);
                return new j(Double.valueOf(q4Var.b((r) list.get(0)).e().doubleValue() % q4Var.b((r) list.get(1)).e().doubleValue()));
            case 45:
                r5.h(zzbl.MULTIPLY.name(), 2, list);
                return new j(Double.valueOf(q4Var.b((r) list.get(0)).e().doubleValue() * q4Var.b((r) list.get(1)).e().doubleValue()));
            case 46:
                r5.h(zzbl.NEGATE.name(), 1, list);
                return new j(Double.valueOf(-q4Var.b((r) list.get(0)).e().doubleValue()));
            default:
                return super.b(str);
        }
    }
}
