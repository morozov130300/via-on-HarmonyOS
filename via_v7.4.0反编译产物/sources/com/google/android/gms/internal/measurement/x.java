package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x extends y {
    public x() {
        this.f3889a.add(zzbl.BITWISE_AND);
        this.f3889a.add(zzbl.BITWISE_LEFT_SHIFT);
        this.f3889a.add(zzbl.BITWISE_NOT);
        this.f3889a.add(zzbl.BITWISE_OR);
        this.f3889a.add(zzbl.BITWISE_RIGHT_SHIFT);
        this.f3889a.add(zzbl.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f3889a.add(zzbl.BITWISE_XOR);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        zzbl zzblVar = zzbl.ADD;
        switch (r5.e(str).ordinal()) {
            case 4:
                r5.h(zzbl.BITWISE_AND.name(), 2, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) & r5.b(q4Var.b((r) list.get(1)).e().doubleValue())));
            case 5:
                r5.h(zzbl.BITWISE_LEFT_SHIFT.name(), 2, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) << ((int) (r5.d(q4Var.b((r) list.get(1)).e().doubleValue()) & 31))));
            case 6:
                r5.h(zzbl.BITWISE_NOT.name(), 1, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) ^ (-1)));
            case 7:
                r5.h(zzbl.BITWISE_OR.name(), 2, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) | r5.b(q4Var.b((r) list.get(1)).e().doubleValue())));
            case 8:
                r5.h(zzbl.BITWISE_RIGHT_SHIFT.name(), 2, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) >> ((int) (r5.d(q4Var.b((r) list.get(1)).e().doubleValue()) & 31))));
            case 9:
                r5.h(zzbl.BITWISE_UNSIGNED_RIGHT_SHIFT.name(), 2, list);
                return new j(Double.valueOf(r5.d(q4Var.b((r) list.get(0)).e().doubleValue()) >>> ((int) (r5.d(q4Var.b((r) list.get(1)).e().doubleValue()) & 31))));
            case 10:
                r5.h(zzbl.BITWISE_XOR.name(), 2, list);
                return new j(Double.valueOf(r5.b(q4Var.b((r) list.get(0)).e().doubleValue()) ^ r5.b(q4Var.b((r) list.get(1)).e().doubleValue())));
            default:
                return super.b(str);
        }
    }
}
