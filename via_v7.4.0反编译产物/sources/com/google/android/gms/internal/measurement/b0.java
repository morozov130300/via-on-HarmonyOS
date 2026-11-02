package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b0 extends y {
    public b0() {
        this.f3889a.add(zzbl.APPLY);
        this.f3889a.add(zzbl.BLOCK);
        this.f3889a.add(zzbl.BREAK);
        this.f3889a.add(zzbl.CASE);
        this.f3889a.add(zzbl.DEFAULT);
        this.f3889a.add(zzbl.CONTINUE);
        this.f3889a.add(zzbl.DEFINE_FUNCTION);
        this.f3889a.add(zzbl.FN);
        this.f3889a.add(zzbl.IF);
        this.f3889a.add(zzbl.QUOTE);
        this.f3889a.add(zzbl.RETURN);
        this.f3889a.add(zzbl.SWITCH);
        this.f3889a.add(zzbl.TERNARY);
    }

    public static r c(q4 q4Var, List list) {
        r5.i(zzbl.FN.name(), 2, list);
        r rVarB = q4Var.b((r) list.get(0));
        r rVarB2 = q4Var.b((r) list.get(1));
        if (!(rVarB2 instanceof f)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", rVarB2.getClass().getCanonicalName()));
        }
        List listX = ((f) rVarB2).x();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new q(rVarB.f(), listX, arrayList, q4Var);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = r5.e(str).ordinal();
        if (iOrdinal == 2) {
            r5.h(zzbl.APPLY.name(), 3, list);
            r rVarB = q4Var.b((r) list.get(0));
            String strF = q4Var.b((r) list.get(1)).f();
            r rVarB2 = q4Var.b((r) list.get(2));
            if (!(rVarB2 instanceof f)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", rVarB2.getClass().getCanonicalName()));
            }
            if (strF.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return rVarB.o(strF, q4Var, ((f) rVarB2).x());
        }
        if (iOrdinal == 15) {
            r5.h(zzbl.BREAK.name(), 0, list);
            return r.f3716c;
        }
        if (iOrdinal == 25) {
            return c(q4Var, list);
        }
        if (iOrdinal == 41) {
            r5.i(zzbl.IF.name(), 2, list);
            r rVarB3 = q4Var.b((r) list.get(0));
            r rVarB4 = q4Var.b((r) list.get(1));
            r rVarB5 = list.size() > 2 ? q4Var.b((r) list.get(2)) : null;
            r rVar = r.f3714a;
            r rVarC = rVarB3.g().booleanValue() ? q4Var.c((f) rVarB4) : rVarB5 != null ? q4Var.c((f) rVarB5) : rVar;
            return rVarC instanceof h ? rVarC : rVar;
        }
        if (iOrdinal == 54) {
            return new f(list);
        }
        if (iOrdinal == 57) {
            if (list.isEmpty()) {
                return r.f3718f;
            }
            r5.h(zzbl.RETURN.name(), 1, list);
            return new h("return", q4Var.b((r) list.get(0)));
        }
        if (iOrdinal != 19) {
            if (iOrdinal == 20) {
                r5.i(zzbl.DEFINE_FUNCTION.name(), 2, list);
                r rVarC2 = c(q4Var, list);
                k kVar = (k) rVarC2;
                if (kVar.b() == null) {
                    q4Var.g("", rVarC2);
                    return rVarC2;
                }
                q4Var.g(kVar.b(), rVarC2);
                return rVarC2;
            }
            if (iOrdinal == 60) {
                r5.h(zzbl.SWITCH.name(), 3, list);
                r rVarB6 = q4Var.b((r) list.get(0));
                r rVarB7 = q4Var.b((r) list.get(1));
                r rVarB8 = q4Var.b((r) list.get(2));
                if (!(rVarB7 instanceof f)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(rVarB8 instanceof f)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                f fVar = (f) rVarB7;
                f fVar2 = (f) rVarB8;
                boolean z10 = false;
                for (int i10 = 0; i10 < fVar.t(); i10++) {
                    if (z10 || rVarB6.equals(q4Var.b(fVar.u(i10)))) {
                        r rVarB9 = q4Var.b(fVar2.u(i10));
                        if (rVarB9 instanceof h) {
                            return ((h) rVarB9).b().equals("break") ? r.f3714a : rVarB9;
                        }
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
                if (fVar.t() + 1 == fVar2.t()) {
                    r rVarB10 = q4Var.b(fVar2.u(fVar.t()));
                    if (rVarB10 instanceof h) {
                        String strB = ((h) rVarB10).b();
                        if (strB.equals("return") || strB.equals("continue")) {
                            return rVarB10;
                        }
                    }
                }
                return r.f3714a;
            }
            if (iOrdinal == 61) {
                r5.h(zzbl.TERNARY.name(), 3, list);
                return q4Var.b((r) list.get(0)).g().booleanValue() ? q4Var.b((r) list.get(1)) : q4Var.b((r) list.get(2));
            }
            switch (iOrdinal) {
                case 11:
                    return q4Var.a().c(new f(list));
                case 12:
                    r5.h(zzbl.BREAK.name(), 0, list);
                    return r.f3717d;
                case 13:
                    break;
                default:
                    return super.b(str);
            }
        }
        if (list.isEmpty()) {
            return r.f3714a;
        }
        r rVarB11 = q4Var.b((r) list.get(0));
        return rVarB11 instanceof f ? q4Var.c((f) rVarB11) : r.f3714a;
    }
}
