package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 extends y {
    public a0() {
        this.f3889a.add(zzbl.EQUALS);
        this.f3889a.add(zzbl.GREATER_THAN);
        this.f3889a.add(zzbl.GREATER_THAN_EQUALS);
        this.f3889a.add(zzbl.IDENTITY_EQUALS);
        this.f3889a.add(zzbl.IDENTITY_NOT_EQUALS);
        this.f3889a.add(zzbl.LESS_THAN);
        this.f3889a.add(zzbl.LESS_THAN_EQUALS);
        this.f3889a.add(zzbl.NOT_EQUALS);
    }

    public static boolean c(r rVar, r rVar2) {
        if (rVar.getClass().equals(rVar2.getClass())) {
            if ((rVar instanceof w) || (rVar instanceof p)) {
                return true;
            }
            return rVar instanceof j ? (Double.isNaN(rVar.e().doubleValue()) || Double.isNaN(rVar2.e().doubleValue()) || rVar.e().doubleValue() != rVar2.e().doubleValue()) ? false : true : rVar instanceof v ? rVar.f().equals(rVar2.f()) : rVar instanceof g ? rVar.g().equals(rVar2.g()) : rVar == rVar2;
        }
        if (((rVar instanceof w) || (rVar instanceof p)) && ((rVar2 instanceof w) || (rVar2 instanceof p))) {
            return true;
        }
        boolean z10 = rVar instanceof j;
        if (z10 && (rVar2 instanceof v)) {
            return c(rVar, new j(rVar2.e()));
        }
        boolean z11 = rVar instanceof v;
        if ((!z11 || !(rVar2 instanceof j)) && !(rVar instanceof g)) {
            if (rVar2 instanceof g) {
                return c(rVar, new j(rVar2.e()));
            }
            if ((z11 || z10) && (rVar2 instanceof n)) {
                return c(rVar, new v(rVar2.f()));
            }
            if ((rVar instanceof n) && ((rVar2 instanceof v) || (rVar2 instanceof j))) {
                return c(new v(rVar.f()), rVar2);
            }
            return false;
        }
        return c(new j(rVar.e()), rVar2);
    }

    public static boolean d(r rVar, r rVar2) {
        if (rVar instanceof n) {
            rVar = new v(rVar.f());
        }
        if (rVar2 instanceof n) {
            rVar2 = new v(rVar2.f());
        }
        if ((rVar instanceof v) && (rVar2 instanceof v)) {
            return rVar.f().compareTo(rVar2.f()) < 0;
        }
        double dDoubleValue = rVar.e().doubleValue();
        double dDoubleValue2 = rVar2.e().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static boolean e(r rVar, r rVar2) {
        if (rVar instanceof n) {
            rVar = new v(rVar.f());
        }
        if (rVar2 instanceof n) {
            rVar2 = new v(rVar2.f());
        }
        return (((rVar instanceof v) && (rVar2 instanceof v)) || !(Double.isNaN(rVar.e().doubleValue()) || Double.isNaN(rVar2.e().doubleValue()))) && !d(rVar2, rVar);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        boolean zC;
        boolean zC2;
        r5.h(r5.e(str).name(), 2, list);
        r rVarB = q4Var.b((r) list.get(0));
        r rVarB2 = q4Var.b((r) list.get(1));
        int iOrdinal = r5.e(str).ordinal();
        if (iOrdinal != 23) {
            if (iOrdinal == 48) {
                zC2 = c(rVarB, rVarB2);
            } else if (iOrdinal == 42) {
                zC = d(rVarB, rVarB2);
            } else if (iOrdinal != 43) {
                switch (iOrdinal) {
                    case 37:
                        zC = d(rVarB2, rVarB);
                        break;
                    case 38:
                        zC = e(rVarB2, rVarB);
                        break;
                    case 39:
                        zC = r5.l(rVarB, rVarB2);
                        break;
                    case 40:
                        zC2 = r5.l(rVarB, rVarB2);
                        break;
                    default:
                        return super.b(str);
                }
            } else {
                zC = e(rVarB, rVarB2);
            }
            zC = !zC2;
        } else {
            zC = c(rVarB, rVarB2);
        }
        return zC ? r.f3719g : r.f3720h;
    }
}
