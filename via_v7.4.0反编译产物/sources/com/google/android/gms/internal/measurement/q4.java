package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q4 {

    /* renamed from: a, reason: collision with root package name */
    public final q4 f3699a;

    /* renamed from: b, reason: collision with root package name */
    public final z f3700b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f3701c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map f3702d = new HashMap();

    public q4(q4 q4Var, z zVar) {
        this.f3699a = q4Var;
        this.f3700b = zVar;
    }

    public final q4 a() {
        return new q4(this, this.f3700b);
    }

    public final r b(r rVar) {
        return this.f3700b.a(this, rVar);
    }

    public final r c(f fVar) {
        r rVarA = r.f3714a;
        Iterator itW = fVar.w();
        while (itW.hasNext()) {
            rVarA = this.f3700b.a(this, fVar.u(((Integer) itW.next()).intValue()));
            if (rVarA instanceof h) {
                break;
            }
        }
        return rVarA;
    }

    public final r d(String str) {
        if (this.f3701c.containsKey(str)) {
            return (r) this.f3701c.get(str);
        }
        q4 q4Var = this.f3699a;
        if (q4Var != null) {
            return q4Var.d(str);
        }
        throw new IllegalArgumentException(String.format("%s is not defined", str));
    }

    public final void e(String str, r rVar) {
        if (this.f3702d.containsKey(str)) {
            return;
        }
        if (rVar == null) {
            this.f3701c.remove(str);
        } else {
            this.f3701c.put(str, rVar);
        }
    }

    public final void f(String str, r rVar) {
        e(str, rVar);
        this.f3702d.put(str, Boolean.TRUE);
    }

    public final void g(String str, r rVar) {
        q4 q4Var;
        if (!this.f3701c.containsKey(str) && (q4Var = this.f3699a) != null && q4Var.h(str)) {
            this.f3699a.g(str, rVar);
        } else {
            if (this.f3702d.containsKey(str)) {
                return;
            }
            if (rVar == null) {
                this.f3701c.remove(str);
            } else {
                this.f3701c.put(str, rVar);
            }
        }
    }

    public final boolean h(String str) {
        if (this.f3701c.containsKey(str)) {
            return true;
        }
        q4 q4Var = this.f3699a;
        if (q4Var != null) {
            return q4Var.h(str);
        }
        return false;
    }
}
