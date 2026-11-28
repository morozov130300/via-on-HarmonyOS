package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f2819a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeMap f2820b = new TreeMap();

    public static final int c(q4 q4Var, q qVar, r rVar) {
        r rVarA = qVar.a(q4Var, Collections.singletonList(rVar));
        if (rVarA instanceof j) {
            return r5.b(rVarA.e().doubleValue());
        }
        return -1;
    }

    public final void a(String str, int i10, q qVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f2820b;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
            }
            treeMap = this.f2819a;
        }
        if (treeMap.containsKey(Integer.valueOf(i10))) {
            i10 = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i10), qVar);
    }

    public final void b(q4 q4Var, c cVar) {
        z8 z8Var = new z8(cVar);
        for (Integer num : this.f2819a.keySet()) {
            b bVarClone = cVar.b().clone();
            int iC = c(q4Var, (q) this.f2819a.get(num), z8Var);
            if (iC == 2 || iC == -1) {
                cVar.f(bVarClone);
            }
        }
        Iterator it = this.f2820b.keySet().iterator();
        while (it.hasNext()) {
            c(q4Var, (q) this.f2820b.get((Integer) it.next()), z8Var);
        }
    }
}
