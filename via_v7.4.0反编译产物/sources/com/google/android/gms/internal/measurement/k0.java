package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k0 extends y {
    public k0() {
        this.f3889a.add(zzbl.FOR_IN);
        this.f3889a.add(zzbl.FOR_IN_CONST);
        this.f3889a.add(zzbl.FOR_IN_LET);
        this.f3889a.add(zzbl.FOR_LET);
        this.f3889a.add(zzbl.FOR_OF);
        this.f3889a.add(zzbl.FOR_OF_CONST);
        this.f3889a.add(zzbl.FOR_OF_LET);
        this.f3889a.add(zzbl.WHILE);
    }

    public static r c(i0 i0Var, Iterator it, r rVar) {
        if (it != null) {
            while (it.hasNext()) {
                r rVarC = i0Var.a((r) it.next()).c((f) rVar);
                if (rVarC instanceof h) {
                    h hVar = (h) rVarC;
                    if ("break".equals(hVar.b())) {
                        return r.f3714a;
                    }
                    if ("return".equals(hVar.b())) {
                        return hVar;
                    }
                }
            }
        }
        return r.f3714a;
    }

    public static r d(i0 i0Var, r rVar, r rVar2) {
        return c(i0Var, rVar.h(), rVar2);
    }

    public static r e(i0 i0Var, r rVar, r rVar2) {
        if (rVar instanceof Iterable) {
            return c(i0Var, ((Iterable) rVar).iterator(), rVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = r5.e(str).ordinal();
        if (iOrdinal == 65) {
            r5.h(zzbl.WHILE.name(), 4, list);
            r rVar = (r) list.get(0);
            r rVar2 = (r) list.get(1);
            r rVar3 = (r) list.get(2);
            r rVarB = q4Var.b((r) list.get(3));
            if (q4Var.b(rVar3).g().booleanValue()) {
                r rVarC = q4Var.c((f) rVarB);
                if (rVarC instanceof h) {
                    h hVar = (h) rVarC;
                    if ("break".equals(hVar.b())) {
                        return r.f3714a;
                    }
                    if ("return".equals(hVar.b())) {
                        return hVar;
                    }
                }
            }
            while (q4Var.b(rVar).g().booleanValue()) {
                r rVarC2 = q4Var.c((f) rVarB);
                if (rVarC2 instanceof h) {
                    h hVar2 = (h) rVarC2;
                    if ("break".equals(hVar2.b())) {
                        return r.f3714a;
                    }
                    if ("return".equals(hVar2.b())) {
                        return hVar2;
                    }
                }
                q4Var.b(rVar2);
            }
            return r.f3714a;
        }
        switch (iOrdinal) {
            case 26:
                r5.h(zzbl.FOR_IN.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                String strF = ((r) list.get(0)).f();
                return d(new j0(q4Var, strF), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            case 27:
                r5.h(zzbl.FOR_IN_CONST.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                String strF2 = ((r) list.get(0)).f();
                return d(new g0(q4Var, strF2), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            case 28:
                r5.h(zzbl.FOR_IN_LET.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                String strF3 = ((r) list.get(0)).f();
                return d(new h0(q4Var, strF3), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            case 29:
                r5.h(zzbl.FOR_LET.name(), 4, list);
                r rVarB2 = q4Var.b((r) list.get(0));
                if (!(rVarB2 instanceof f)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                f fVar = (f) rVarB2;
                r rVar4 = (r) list.get(1);
                r rVar5 = (r) list.get(2);
                r rVarB3 = q4Var.b((r) list.get(3));
                q4 q4VarA = q4Var.a();
                for (int i10 = 0; i10 < fVar.t(); i10++) {
                    String strF4 = fVar.u(i10).f();
                    q4VarA.g(strF4, q4Var.d(strF4));
                }
                while (q4Var.b(rVar4).g().booleanValue()) {
                    r rVarC3 = q4Var.c((f) rVarB3);
                    if (rVarC3 instanceof h) {
                        h hVar3 = (h) rVarC3;
                        if ("break".equals(hVar3.b())) {
                            return r.f3714a;
                        }
                        if ("return".equals(hVar3.b())) {
                            return hVar3;
                        }
                    }
                    q4 q4VarA2 = q4Var.a();
                    for (int i11 = 0; i11 < fVar.t(); i11++) {
                        String strF5 = fVar.u(i11).f();
                        q4VarA2.g(strF5, q4VarA.d(strF5));
                    }
                    q4VarA2.b(rVar5);
                    q4VarA = q4VarA2;
                }
                return r.f3714a;
            case 30:
                r5.h(zzbl.FOR_OF.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                String strF6 = ((r) list.get(0)).f();
                return e(new j0(q4Var, strF6), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            case 31:
                r5.h(zzbl.FOR_OF_CONST.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                String strF7 = ((r) list.get(0)).f();
                return e(new g0(q4Var, strF7), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            case 32:
                r5.h(zzbl.FOR_OF_LET.name(), 3, list);
                if (!(list.get(0) instanceof v)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                String strF8 = ((r) list.get(0)).f();
                return e(new h0(q4Var, strF8), q4Var.b((r) list.get(1)), q4Var.b((r) list.get(2)));
            default:
                return super.b(str);
        }
    }
}
