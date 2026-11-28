package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements r, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2884c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f2885e = new HashMap();

    public k(String str) {
        this.f2884c = str;
    }

    public abstract r a(q4 q4Var, List list);

    public final String b() {
        return this.f2884c;
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
        String str = this.f2884c;
        if (str != null) {
            return str.equals(kVar.f2884c);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return this.f2884c;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return l.b(this.f2885e);
    }

    public final int hashCode() {
        String str = this.f2884c;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return this.f2885e.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f2885e.remove(str);
        } else {
            this.f2885e.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        return "toString".equals(str) ? new v(this.f2884c) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        return this.f2885e.containsKey(str) ? (r) this.f2885e.get(str) : r.f3013a;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public r c() {
        return this;
    }
}
