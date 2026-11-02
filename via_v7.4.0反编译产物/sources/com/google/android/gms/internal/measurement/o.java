package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o implements r, n {

    /* renamed from: e, reason: collision with root package name */
    public final Map f3641e = new HashMap();

    public final List a() {
        return new ArrayList(this.f3641e.keySet());
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        o oVar = new o();
        for (Map.Entry entry : this.f3641e.entrySet()) {
            if (entry.getValue() instanceof n) {
                oVar.f3641e.put((String) entry.getKey(), (r) entry.getValue());
            } else {
                oVar.f3641e.put((String) entry.getKey(), ((r) entry.getValue()).c());
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
            return this.f3641e.equals(((o) obj).f3641e);
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
        return l.b(this.f3641e);
    }

    public final int hashCode() {
        return this.f3641e.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return this.f3641e.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f3641e.remove(str);
        } else {
            this.f3641e.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public r o(String str, q4 q4Var, List list) {
        return "toString".equals(str) ? new v(toString()) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        return this.f3641e.containsKey(str) ? (r) this.f3641e.get(str) : r.f3714a;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        if (!this.f3641e.isEmpty()) {
            for (String str : this.f3641e.keySet()) {
                sb2.append(String.format("%s: %s,", str, this.f3641e.get(str)));
            }
            sb2.deleteCharAt(sb2.lastIndexOf(","));
        }
        sb2.append("}");
        return sb2.toString();
    }
}
