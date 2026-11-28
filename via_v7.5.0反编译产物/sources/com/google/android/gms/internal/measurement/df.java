package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class df extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final n7 f2768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f2769n;

    public df(n7 n7Var) {
        super("require");
        this.f2769n = new HashMap();
        this.f2768m = n7Var;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r rVar;
        r5.h("require", 1, list);
        String strF = q4Var.b((r) list.get(0)).f();
        if (this.f2769n.containsKey(strF)) {
            return (r) this.f2769n.get(strF);
        }
        n7 n7Var = this.f2768m;
        if (n7Var.f2930a.containsKey(strF)) {
            try {
                rVar = (r) ((Callable) n7Var.f2930a.get(strF)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strF)));
            }
        } else {
            rVar = r.f3013a;
        }
        if (rVar instanceof k) {
            this.f2769n.put(strF, (k) rVar);
        }
        return rVar;
    }
}
