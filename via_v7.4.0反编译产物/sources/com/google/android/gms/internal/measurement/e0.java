package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e0 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static r a(String str, f fVar, q4 q4Var, List list) {
        double dT;
        double dMin;
        Double dValueOf = Double.valueOf(-1.0d);
        String strF = ",";
        double d10 = 0.0d;
        k kVar = null;
        int i10 = 0;
        switch (str.hashCode()) {
            case -1776922004:
                if (str.equals("toString")) {
                    r5.h("toString", 0, list);
                    return new v(fVar.v(","));
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    r rVarC = fVar.c();
                    if (!list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            r rVarB = q4Var.b((r) it.next());
                            if (rVarB instanceof h) {
                                throw new IllegalStateException("Failed evaluation of arguments");
                            }
                            f fVar2 = (f) rVarC;
                            int iT = fVar2.t();
                            if (rVarB instanceof f) {
                                f fVar3 = (f) rVarB;
                                Iterator itW = fVar3.w();
                                while (itW.hasNext()) {
                                    Integer num = (Integer) itW.next();
                                    fVar2.B(num.intValue() + iT, fVar3.u(num.intValue()));
                                }
                            } else {
                                fVar2.B(iT, rVarB);
                            }
                        }
                    }
                    return rVarC;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    r5.h("filter", 1, list);
                    r rVarB2 = q4Var.b((r) list.get(0));
                    if (!(rVarB2 instanceof q)) {
                        throw new IllegalArgumentException("Callback should be a method");
                    }
                    if (fVar.s() == 0) {
                        return new f();
                    }
                    r rVarC2 = fVar.c();
                    f fVarB = b(fVar, q4Var, (q) rVarB2, null, Boolean.TRUE);
                    f fVar4 = new f();
                    Iterator itW2 = fVarB.w();
                    while (itW2.hasNext()) {
                        fVar4.B(fVar4.t(), ((f) rVarC2).u(((Integer) itW2.next()).intValue()));
                    }
                    return fVar4;
                }
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    return c(fVar, q4Var, list, true);
                }
                break;
            case -895859076:
                if (str.equals("splice")) {
                    if (list.isEmpty()) {
                        return new f();
                    }
                    int iA = (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                    if (iA < 0) {
                        iA = Math.max(0, iA + fVar.t());
                    } else if (iA > fVar.t()) {
                        iA = fVar.t();
                    }
                    int iT2 = fVar.t();
                    f fVar5 = new f();
                    if (list.size() > 1) {
                        int iMax = Math.max(0, (int) r5.a(q4Var.b((r) list.get(1)).e().doubleValue()));
                        if (iMax > 0) {
                            for (int i11 = iA; i11 < Math.min(iT2, iA + iMax); i11++) {
                                fVar5.B(fVar5.t(), fVar.u(iA));
                                fVar.A(iA);
                            }
                        }
                        if (list.size() > 2) {
                            for (int i12 = 2; i12 < list.size(); i12++) {
                                r rVarB3 = q4Var.b((r) list.get(i12));
                                if (rVarB3 instanceof h) {
                                    throw new IllegalArgumentException("Failed to parse elements to add");
                                }
                                fVar.z((iA + i12) - 2, rVarB3);
                            }
                        }
                    } else {
                        while (iA < iT2) {
                            fVar5.B(fVar5.t(), fVar.u(iA));
                            fVar.B(iA, null);
                            iA++;
                        }
                    }
                    return fVar5;
                }
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    r5.h("forEach", 1, list);
                    r rVarB4 = q4Var.b((r) list.get(0));
                    if (!(rVarB4 instanceof q)) {
                        throw new IllegalArgumentException("Callback should be a method");
                    }
                    if (fVar.s() == 0) {
                        return r.f3714a;
                    }
                    b(fVar, q4Var, (q) rVarB4, null, null);
                    return r.f3714a;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    r5.j("lastIndexOf", 2, list);
                    r rVarB5 = r.f3714a;
                    if (!list.isEmpty()) {
                        rVarB5 = q4Var.b((r) list.get(0));
                    }
                    int iT3 = fVar.t() - 1;
                    if (list.size() > 1) {
                        r rVarB6 = q4Var.b((r) list.get(1));
                        dT = Double.isNaN(rVarB6.e().doubleValue()) ? fVar.t() - 1 : r5.a(rVarB6.e().doubleValue());
                        if (dT < 0.0d) {
                            double dT2 = fVar.t();
                            Double.isNaN(dT2);
                            dT += dT2;
                        }
                    } else {
                        dT = iT3;
                    }
                    if (dT < 0.0d) {
                        return new j(dValueOf);
                    }
                    for (int iMin = (int) Math.min(fVar.t(), dT); iMin >= 0; iMin--) {
                        if (fVar.C(iMin) && r5.l(fVar.u(iMin), rVarB5)) {
                            return new j(Double.valueOf(iMin));
                        }
                    }
                    return new j(dValueOf);
                }
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    if (!list.isEmpty()) {
                        f fVar6 = new f();
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            r rVarB7 = q4Var.b((r) it2.next());
                            if (rVarB7 instanceof h) {
                                throw new IllegalStateException("Argument evaluation failed");
                            }
                            fVar6.B(fVar6.t(), rVarB7);
                        }
                        int iT4 = fVar6.t();
                        Iterator itW3 = fVar.w();
                        while (itW3.hasNext()) {
                            Integer num2 = (Integer) itW3.next();
                            fVar6.B(num2.intValue() + iT4, fVar.u(num2.intValue()));
                        }
                        fVar.y();
                        Iterator itW4 = fVar6.w();
                        while (itW4.hasNext()) {
                            Integer num3 = (Integer) itW4.next();
                            fVar.B(num3.intValue(), fVar6.u(num3.intValue()));
                        }
                    }
                    return new j(Double.valueOf(fVar.t()));
                }
                break;
            case 107868:
                if (str.equals("map")) {
                    r5.h("map", 1, list);
                    r rVarB8 = q4Var.b((r) list.get(0));
                    if (rVarB8 instanceof q) {
                        return fVar.t() == 0 ? new f() : b(fVar, q4Var, (q) rVarB8, null, null);
                    }
                    throw new IllegalArgumentException("Callback should be a method");
                }
                break;
            case 111185:
                if (str.equals("pop")) {
                    r5.h("pop", 0, list);
                    int iT5 = fVar.t();
                    if (iT5 == 0) {
                        return r.f3714a;
                    }
                    int i13 = iT5 - 1;
                    r rVarU = fVar.u(i13);
                    fVar.A(i13);
                    return rVarU;
                }
                break;
            case 3267882:
                if (str.equals("join")) {
                    r5.j("join", 1, list);
                    if (fVar.t() == 0) {
                        return r.f3721i;
                    }
                    if (!list.isEmpty()) {
                        r rVarB9 = q4Var.b((r) list.get(0));
                        strF = ((rVarB9 instanceof p) || (rVarB9 instanceof w)) ? "" : rVarB9.f();
                    }
                    return new v(fVar.v(strF));
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    if (!list.isEmpty()) {
                        Iterator it3 = list.iterator();
                        while (it3.hasNext()) {
                            fVar.B(fVar.t(), q4Var.b((r) it3.next()));
                        }
                    }
                    return new j(Double.valueOf(fVar.t()));
                }
                break;
            case 3536116:
                if (str.equals("some")) {
                    r5.h("some", 1, list);
                    r rVarB10 = q4Var.b((r) list.get(0));
                    if (!(rVarB10 instanceof k)) {
                        throw new IllegalArgumentException("Callback should be a method");
                    }
                    if (fVar.t() == 0) {
                        return r.f3720h;
                    }
                    k kVar2 = (k) rVarB10;
                    Iterator itW5 = fVar.w();
                    while (itW5.hasNext()) {
                        int iIntValue = ((Integer) itW5.next()).intValue();
                        if (fVar.C(iIntValue) && kVar2.a(q4Var, Arrays.asList(fVar.u(iIntValue), new j(Double.valueOf(iIntValue)), fVar)).g().booleanValue()) {
                            return r.f3719g;
                        }
                    }
                    return r.f3720h;
                }
                break;
            case 3536286:
                if (str.equals("sort")) {
                    r5.j("sort", 1, list);
                    if (fVar.t() >= 2) {
                        List listX = fVar.x();
                        if (!list.isEmpty()) {
                            r rVarB11 = q4Var.b((r) list.get(0));
                            if (!(rVarB11 instanceof k)) {
                                throw new IllegalArgumentException("Comparator should be a method");
                            }
                            kVar = (k) rVarB11;
                        }
                        Collections.sort(listX, new d0(kVar, q4Var));
                        fVar.y();
                        Iterator it4 = listX.iterator();
                        while (it4.hasNext()) {
                            fVar.B(i10, (r) it4.next());
                            i10++;
                        }
                    }
                    return fVar;
                }
                break;
            case 96891675:
                if (str.equals("every")) {
                    r5.h("every", 1, list);
                    r rVarB12 = q4Var.b((r) list.get(0));
                    if (!(rVarB12 instanceof q)) {
                        throw new IllegalArgumentException("Callback should be a method");
                    }
                    if (fVar.t() != 0 && b(fVar, q4Var, (q) rVarB12, Boolean.FALSE, Boolean.TRUE).t() != fVar.t()) {
                        return r.f3720h;
                    }
                    return r.f3719g;
                }
                break;
            case 109407362:
                if (str.equals("shift")) {
                    r5.h("shift", 0, list);
                    if (fVar.t() == 0) {
                        return r.f3714a;
                    }
                    r rVarU2 = fVar.u(0);
                    fVar.A(0);
                    return rVarU2;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    r5.j("slice", 2, list);
                    if (list.isEmpty()) {
                        return fVar.c();
                    }
                    double dT3 = fVar.t();
                    double dA = r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                    if (dA < 0.0d) {
                        Double.isNaN(dT3);
                        dMin = Math.max(dA + dT3, 0.0d);
                    } else {
                        dMin = Math.min(dA, dT3);
                    }
                    if (list.size() == 2) {
                        double dA2 = r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
                        if (dA2 < 0.0d) {
                            Double.isNaN(dT3);
                            dT3 = Math.max(dT3 + dA2, 0.0d);
                        } else {
                            dT3 = Math.min(dT3, dA2);
                        }
                    }
                    f fVar7 = new f();
                    for (int i14 = (int) dMin; i14 < dT3; i14++) {
                        fVar7.B(fVar7.t(), fVar.u(i14));
                    }
                    return fVar7;
                }
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    return c(fVar, q4Var, list, false);
                }
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    r5.h("reverse", 0, list);
                    int iT6 = fVar.t();
                    if (iT6 != 0) {
                        while (i10 < iT6 / 2) {
                            if (fVar.C(i10)) {
                                r rVarU3 = fVar.u(i10);
                                fVar.B(i10, null);
                                int i15 = (iT6 - 1) - i10;
                                if (fVar.C(i15)) {
                                    fVar.B(i10, fVar.u(i15));
                                }
                                fVar.B(i15, rVarU3);
                            }
                            i10++;
                        }
                    }
                    return fVar;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    r5.j("indexOf", 2, list);
                    r rVarB13 = r.f3714a;
                    if (!list.isEmpty()) {
                        rVarB13 = q4Var.b((r) list.get(0));
                    }
                    if (list.size() > 1) {
                        double dA3 = r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
                        if (dA3 >= fVar.t()) {
                            return new j(dValueOf);
                        }
                        if (dA3 < 0.0d) {
                            double dT4 = fVar.t();
                            Double.isNaN(dT4);
                            d10 = dT4 + dA3;
                        } else {
                            d10 = dA3;
                        }
                    }
                    Iterator itW6 = fVar.w();
                    while (itW6.hasNext()) {
                        int iIntValue2 = ((Integer) itW6.next()).intValue();
                        double d11 = iIntValue2;
                        if (d11 >= d10 && r5.l(fVar.u(iIntValue2), rVarB13)) {
                            return new j(Double.valueOf(d11));
                        }
                    }
                    return new j(dValueOf);
                }
                break;
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public static f b(f fVar, q4 q4Var, k kVar, Boolean bool, Boolean bool2) {
        f fVar2 = new f();
        Iterator itW = fVar.w();
        while (itW.hasNext()) {
            int iIntValue = ((Integer) itW.next()).intValue();
            if (fVar.C(iIntValue)) {
                r rVarA = kVar.a(q4Var, Arrays.asList(fVar.u(iIntValue), new j(Double.valueOf(iIntValue)), fVar));
                if (rVarA.g().equals(bool)) {
                    break;
                }
                if (bool2 == null || rVarA.g().equals(bool2)) {
                    fVar2.B(iIntValue, rVarA);
                }
            }
        }
        return fVar2;
    }

    public static r c(f fVar, q4 q4Var, List list, boolean z10) {
        r rVarA;
        r5.i("reduce", 1, list);
        r5.j("reduce", 2, list);
        r rVarB = q4Var.b((r) list.get(0));
        if (!(rVarB instanceof k)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            rVarA = q4Var.b((r) list.get(1));
            if (rVarA instanceof h) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (fVar.t() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            rVarA = null;
        }
        k kVar = (k) rVarB;
        int iT = fVar.t();
        int i10 = z10 ? 0 : iT - 1;
        int i11 = z10 ? iT - 1 : 0;
        int i12 = true == z10 ? 1 : -1;
        if (rVarA == null) {
            rVarA = fVar.u(i10);
            i10 += i12;
        }
        while ((i11 - i10) * i12 >= 0) {
            if (fVar.C(i10)) {
                rVarA = kVar.a(q4Var, Arrays.asList(rVarA, fVar.u(i10), new j(Double.valueOf(i10)), fVar));
                if (rVarA instanceof h) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i10 += i12;
            } else {
                i10 += i12;
            }
        }
        return rVarA;
    }
}
