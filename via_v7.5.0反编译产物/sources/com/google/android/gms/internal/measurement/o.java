package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o implements r, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2940c = new HashMap();

    public final List a() {
        return new ArrayList(this.f2940c.keySet());
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        o oVar = new o();
        for (Map.Entry entry : this.f2940c.entrySet()) {
            if (entry.getValue() instanceof n) {
                oVar.f2940c.put((String) entry.getKey(), (r) entry.getValue());
            } else {
                oVar.f2940c.put((String) entry.getKey(), ((r) entry.getValue()).c());
            }
        }
        return oVar;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return this.f2940c.equals(((o) obj).f2940c);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return l.b(this.f2940c);
    }

    public final int hashCode() {
        return this.f2940c.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return this.f2940c.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f2940c.remove(str);
        } else {
            this.f2940c.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public r o(String str, q4 q4Var, List list) {
        return "toString".equals(str) ? new v(toString()) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        return this.f2940c.containsKey(str) ? (r) this.f2940c.get(str) : r.f3013a;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        if (!this.f2940c.isEmpty()) {
            for (String str : this.f2940c.keySet()) {
                sb2.append(String.format("%s: %s,", str, this.f2940c.get(str)));
            }
            sb2.deleteCharAt(sb2.lastIndexOf(","));
        }
        sb2.append("}");
        return sb2.toString();
    }
}
