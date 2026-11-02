package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t6 {
    public static r a(p5 p5Var) {
        if (p5Var == null) {
            return r.f3714a;
        }
        int iM = p5Var.M() - 1;
        if (iM == 1) {
            return p5Var.L() ? new v(p5Var.G()) : r.f3721i;
        }
        if (iM == 2) {
            return p5Var.K() ? new j(Double.valueOf(p5Var.D())) : new j(null);
        }
        if (iM == 3) {
            return p5Var.J() ? new g(Boolean.valueOf(p5Var.I())) : new g(null);
        }
        if (iM != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List listH = p5Var.H();
        ArrayList arrayList = new ArrayList();
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(a((p5) it.next()));
        }
        return new s(p5Var.F(), arrayList);
    }

    public static r b(Object obj) {
        if (obj == null) {
            return r.f3715b;
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof Double) {
            return new j((Double) obj);
        }
        if (obj instanceof Long) {
            return new j(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new j(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new g((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            f fVar = new f();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                fVar.B(fVar.t(), b(it.next()));
            }
            return fVar;
        }
        o oVar = new o();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            r rVarB = b(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                oVar.n((String) string, rVarB);
            }
        }
        return oVar;
    }
}
