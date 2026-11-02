package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class gf {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f3520a = new TreeMap();

    /* renamed from: b, reason: collision with root package name */
    public final TreeMap f3521b = new TreeMap();

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
            treeMap = this.f3521b;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
            }
            treeMap = this.f3520a;
        }
        if (treeMap.containsKey(Integer.valueOf(i10))) {
            i10 = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i10), qVar);
    }

    public final void b(q4 q4Var, c cVar) {
        z8 z8Var = new z8(cVar);
        for (Integer num : this.f3520a.keySet()) {
            b bVarClone = cVar.b().clone();
            int iC = c(q4Var, (q) this.f3520a.get(num), z8Var);
            if (iC == 2 || iC == -1) {
                cVar.f(bVarClone);
            }
        }
        Iterator it = this.f3521b.keySet().iterator();
        while (it.hasNext()) {
            c(q4Var, (q) this.f3521b.get((Integer) it.next()), z8Var);
        }
    }
}
