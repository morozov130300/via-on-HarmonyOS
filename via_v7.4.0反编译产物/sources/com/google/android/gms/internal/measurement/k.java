package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class k implements r, n {

    /* renamed from: e, reason: collision with root package name */
    public final String f3585e;

    /* renamed from: j, reason: collision with root package name */
    public final Map f3586j = new HashMap();

    public k(String str) {
        this.f3585e = str;
    }

    public abstract r a(q4 q4Var, List list);

    public final String b() {
        return this.f3585e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public r c() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        String str = this.f3585e;
        if (str != null) {
            return str.equals(kVar.f3585e);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return this.f3585e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return l.b(this.f3586j);
    }

    public final int hashCode() {
        String str = this.f3585e;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return this.f3586j.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f3586j.remove(str);
        } else {
            this.f3586j.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        return "toString".equals(str) ? new v(this.f3585e) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        return this.f3586j.containsKey(str) ? (r) this.f3586j.get(str) : r.f3714a;
    }
}
