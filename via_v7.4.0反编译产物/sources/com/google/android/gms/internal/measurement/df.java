package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class df extends k {

    /* renamed from: k, reason: collision with root package name */
    public final n7 f3469k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f3470l;

    public df(n7 n7Var) {
        super("require");
        this.f3470l = new HashMap();
        this.f3469k = n7Var;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r rVar;
        r5.h("require", 1, list);
        String strF = q4Var.b((r) list.get(0)).f();
        if (this.f3470l.containsKey(strF)) {
            return (r) this.f3470l.get(strF);
        }
        n7 n7Var = this.f3469k;
        if (n7Var.f3631a.containsKey(strF)) {
            try {
                rVar = (r) ((Callable) n7Var.f3631a.get(strF)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strF)));
            }
        } else {
            rVar = r.f3714a;
        }
        if (rVar instanceof k) {
            this.f3470l.put(strF, (k) rVar);
        }
        return rVar;
    }
}
