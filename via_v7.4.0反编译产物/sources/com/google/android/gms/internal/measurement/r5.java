package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class r5 {
    public static double a(double d10) {
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (Double.isInfinite(d10) || d10 == 0.0d || d10 == 0.0d) {
            return d10;
        }
        int i10 = d10 > 0.0d ? 1 : -1;
        double dFloor = Math.floor(Math.abs(d10));
        double d11 = i10;
        Double.isNaN(d11);
        return d11 * dFloor;
    }

    public static int b(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10) || d10 == 0.0d) {
            return 0;
        }
        int i10 = d10 > 0.0d ? 1 : -1;
        double dFloor = Math.floor(Math.abs(d10));
        Double.isNaN(i10);
        return (int) ((r0 * dFloor) % 4.294967296E9d);
    }

    public static int c(q4 q4Var) {
        int iB = b(q4Var.d("runtime.counter").e().doubleValue() + 1.0d);
        if (iB > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        q4Var.g("runtime.counter", new j(Double.valueOf(iB)));
        return iB;
    }

    public static long d(double d10) {
        return b(d10) & 4294967295L;
    }

    public static zzbl e(String str) {
        zzbl zzblVarZza = null;
        if (str != null && !str.isEmpty()) {
            zzblVarZza = zzbl.zza(Integer.parseInt(str));
        }
        if (zzblVarZza != null) {
            return zzblVarZza;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static Object f(r rVar) {
        if (r.f3715b.equals(rVar)) {
            return null;
        }
        if (r.f3714a.equals(rVar)) {
            return "";
        }
        if (rVar instanceof o) {
            return g((o) rVar);
        }
        if (!(rVar instanceof f)) {
            return !rVar.e().isNaN() ? rVar.e() : rVar.f();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((f) rVar).iterator();
        while (it.hasNext()) {
            Object objF = f((r) it.next());
            if (objF != null) {
                arrayList.add(objF);
            }
        }
        return arrayList;
    }

    public static Map g(o oVar) {
        HashMap map = new HashMap();
        for (String str : oVar.a()) {
            Object objF = f(oVar.p(str));
            if (objF != null) {
                map.put(str, objF);
            }
        }
        return map;
    }

    public static void h(String str, int i10, List list) {
        if (list.size() != i10) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }

    public static void i(String str, int i10, List list) {
        if (list.size() < i10) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }

    public static void j(String str, int i10, List list) {
        if (list.size() > i10) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }

    public static boolean k(r rVar) {
        if (rVar == null) {
            return false;
        }
        Double dE = rVar.e();
        return !dE.isNaN() && dE.doubleValue() >= 0.0d && dE.equals(Double.valueOf(Math.floor(dE.doubleValue())));
    }

    public static boolean l(r rVar, r rVar2) {
        if (!rVar.getClass().equals(rVar2.getClass())) {
            return false;
        }
        if ((rVar instanceof w) || (rVar instanceof p)) {
            return true;
        }
        if (!(rVar instanceof j)) {
            return rVar instanceof v ? rVar.f().equals(rVar2.f()) : rVar instanceof g ? rVar.g().equals(rVar2.g()) : rVar == rVar2;
        }
        if (Double.isNaN(rVar.e().doubleValue()) || Double.isNaN(rVar2.e().doubleValue())) {
            return false;
        }
        return rVar.e().equals(rVar2.e());
    }
}
