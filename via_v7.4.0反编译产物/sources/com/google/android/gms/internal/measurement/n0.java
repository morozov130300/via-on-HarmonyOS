package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n0 extends y {
    public n0() {
        this.f3889a.add(zzbl.ASSIGN);
        this.f3889a.add(zzbl.CONST);
        this.f3889a.add(zzbl.CREATE_ARRAY);
        this.f3889a.add(zzbl.CREATE_OBJECT);
        this.f3889a.add(zzbl.EXPRESSION_LIST);
        this.f3889a.add(zzbl.GET);
        this.f3889a.add(zzbl.GET_INDEX);
        this.f3889a.add(zzbl.GET_PROPERTY);
        this.f3889a.add(zzbl.NULL);
        this.f3889a.add(zzbl.SET_PROPERTY);
        this.f3889a.add(zzbl.TYPEOF);
        this.f3889a.add(zzbl.UNDEFINED);
        this.f3889a.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final r a(String str, q4 q4Var, List list) {
        String str2;
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = r5.e(str).ordinal();
        int i10 = 0;
        if (iOrdinal == 3) {
            r5.h(zzbl.ASSIGN.name(), 2, list);
            r rVarB = q4Var.b((r) list.get(0));
            if (!(rVarB instanceof v)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", rVarB.getClass().getCanonicalName()));
            }
            if (!q4Var.h(rVarB.f())) {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", rVarB.f()));
            }
            r rVarB2 = q4Var.b((r) list.get(1));
            q4Var.g(rVarB.f(), rVarB2);
            return rVarB2;
        }
        if (iOrdinal == 14) {
            r5.i(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            for (int i11 = 0; i11 < list.size() - 1; i11 += 2) {
                r rVarB3 = q4Var.b((r) list.get(i11));
                if (!(rVarB3 instanceof v)) {
                    throw new IllegalArgumentException(String.format("Expected string for const name. got %s", rVarB3.getClass().getCanonicalName()));
                }
                q4Var.f(rVarB3.f(), q4Var.b((r) list.get(i11 + 1)));
            }
            return r.f3714a;
        }
        if (iOrdinal == 24) {
            r5.i(zzbl.EXPRESSION_LIST.name(), 1, list);
            r rVarB4 = r.f3714a;
            while (i10 < list.size()) {
                rVarB4 = q4Var.b((r) list.get(i10));
                if (rVarB4 instanceof h) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i10++;
            }
            return rVarB4;
        }
        if (iOrdinal == 33) {
            r5.h(zzbl.GET.name(), 1, list);
            r rVarB5 = q4Var.b((r) list.get(0));
            if (rVarB5 instanceof v) {
                return q4Var.d(rVarB5.f());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", rVarB5.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            r5.h(zzbl.NULL.name(), 0, list);
            return r.f3715b;
        }
        if (iOrdinal == 58) {
            r5.h(zzbl.SET_PROPERTY.name(), 3, list);
            r rVarB6 = q4Var.b((r) list.get(0));
            r rVarB7 = q4Var.b((r) list.get(1));
            r rVarB8 = q4Var.b((r) list.get(2));
            if (rVarB6 == r.f3714a || rVarB6 == r.f3715b) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", rVarB7.f(), rVarB6.f()));
            }
            if ((rVarB6 instanceof f) && (rVarB7 instanceof j)) {
                ((f) rVarB6).B(rVarB7.e().intValue(), rVarB8);
                return rVarB8;
            }
            if (rVarB6 instanceof n) {
                ((n) rVarB6).n(rVarB7.f(), rVarB8);
            }
            return rVarB8;
        }
        if (iOrdinal == 17) {
            if (list.isEmpty()) {
                return new f();
            }
            f fVar = new f();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                r rVarB9 = q4Var.b((r) it.next());
                if (rVarB9 instanceof h) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                fVar.B(i10, rVarB9);
                i10++;
            }
            return fVar;
        }
        if (iOrdinal == 18) {
            if (list.isEmpty()) {
                return new o();
            }
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            o oVar = new o();
            while (i10 < list.size() - 1) {
                r rVarB10 = q4Var.b((r) list.get(i10));
                r rVarB11 = q4Var.b((r) list.get(i10 + 1));
                if ((rVarB10 instanceof h) || (rVarB11 instanceof h)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                oVar.n(rVarB10.f(), rVarB11);
                i10 += 2;
            }
            return oVar;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            r5.h(zzbl.GET_PROPERTY.name(), 2, list);
            r rVarB12 = q4Var.b((r) list.get(0));
            r rVarB13 = q4Var.b((r) list.get(1));
            if ((rVarB12 instanceof f) && r5.k(rVarB13)) {
                return ((f) rVarB12).u(rVarB13.e().intValue());
            }
            if (rVarB12 instanceof n) {
                return ((n) rVarB12).p(rVarB13.f());
            }
            if (rVarB12 instanceof v) {
                if (Name.LENGTH.equals(rVarB13.f())) {
                    return new j(Double.valueOf(rVarB12.f().length()));
                }
                if (r5.k(rVarB13) && rVarB13.e().doubleValue() < rVarB12.f().length()) {
                    return new v(String.valueOf(rVarB12.f().charAt(rVarB13.e().intValue())));
                }
            }
            return r.f3714a;
        }
        switch (iOrdinal) {
            case 62:
                r5.h(zzbl.TYPEOF.name(), 1, list);
                r rVarB14 = q4Var.b((r) list.get(0));
                if (rVarB14 instanceof w) {
                    str2 = "undefined";
                } else if (rVarB14 instanceof g) {
                    str2 = "boolean";
                } else if (rVarB14 instanceof j) {
                    str2 = "number";
                } else if (rVarB14 instanceof v) {
                    str2 = "string";
                } else if (rVarB14 instanceof q) {
                    str2 = "function";
                } else {
                    if ((rVarB14 instanceof s) || (rVarB14 instanceof h)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", rVarB14));
                    }
                    str2 = "object";
                }
                return new v(str2);
            case 63:
                r5.h(zzbl.UNDEFINED.name(), 0, list);
                return r.f3714a;
            case 64:
                r5.i(zzbl.VAR.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    r rVarB15 = q4Var.b((r) it2.next());
                    if (!(rVarB15 instanceof v)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", rVarB15.getClass().getCanonicalName()));
                    }
                    q4Var.e(rVarB15.f(), r.f3714a);
                }
                return r.f3714a;
            default:
                return super.b(str);
        }
    }
}
