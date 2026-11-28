package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {
    public static r a(n nVar, r rVar, q4 q4Var, List list) {
        if (nVar.k(rVar.f())) {
            r rVarP = nVar.p(rVar.f());
            if (rVarP instanceof k) {
                return ((k) rVarP).a(q4Var, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", rVar.f()));
        }
        if (!"hasOwnProperty".equals(rVar.f())) {
            throw new IllegalArgumentException(String.format("Object has no function %s", rVar.f()));
        }
        r5.h("hasOwnProperty", 1, list);
        return nVar.k(q4Var.b((r) list.get(0)).f()) ? r.f3018h : r.f3019i;
    }

    public static Iterator b(Map map) {
        return new m(map.keySet().iterator());
    }
}
