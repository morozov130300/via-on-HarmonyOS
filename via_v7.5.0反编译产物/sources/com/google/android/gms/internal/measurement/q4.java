package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4 f2998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f2999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3000c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f3001d = new HashMap();

    public q4(q4 q4Var, z zVar) {
        this.f2998a = q4Var;
        this.f2999b = zVar;
    }

    public final q4 a() {
        return new q4(this, this.f2999b);
    }

    public final r b(r rVar) {
        return this.f2999b.a(this, rVar);
    }

    public final r c(f fVar) {
        r rVarA = r.f3013a;
        Iterator itW = fVar.w();
        while (itW.hasNext()) {
            rVarA = this.f2999b.a(this, fVar.u(((Integer) itW.next()).intValue()));
            if (rVarA instanceof h) {
                break;
            }
        }
        return rVarA;
    }

    public final r d(String str) {
        if (this.f3000c.containsKey(str)) {
            return (r) this.f3000c.get(str);
        }
        q4 q4Var = this.f2998a;
        if (q4Var != null) {
            return q4Var.d(str);
        }
        throw new IllegalArgumentException(String.format("%s is not defined", str));
    }

    public final void e(String str, r rVar) {
        if (this.f3001d.containsKey(str)) {
            return;
        }
        if (rVar == null) {
            this.f3000c.remove(str);
        } else {
            this.f3000c.put(str, rVar);
        }
    }

    public final void f(String str, r rVar) {
        e(str, rVar);
        this.f3001d.put(str, Boolean.TRUE);
    }

    public final void g(String str, r rVar) {
        q4 q4Var;
        if (!this.f3000c.containsKey(str) && (q4Var = this.f2998a) != null && q4Var.h(str)) {
            this.f2998a.g(str, rVar);
        } else {
            if (this.f3001d.containsKey(str)) {
                return;
            }
            if (rVar == null) {
                this.f3000c.remove(str);
            } else {
                this.f3000c.put(str, rVar);
            }
        }
    }

    public final boolean h(String str) {
        if (this.f3000c.containsKey(str)) {
            return true;
        }
        q4 q4Var = this.f2998a;
        if (q4Var != null) {
            return q4Var.h(str);
        }
        return false;
    }
}
