package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v5 extends s6 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3837a;

    /* renamed from: b, reason: collision with root package name */
    public final d7 f3838b;

    public v5(Context context, d7 d7Var) {
        this.f3837a = context;
        this.f3838b = d7Var;
    }

    @Override // com.google.android.gms.internal.measurement.s6
    public final Context a() {
        return this.f3837a;
    }

    @Override // com.google.android.gms.internal.measurement.s6
    public final d7 b() {
        return this.f3838b;
    }

    public final boolean equals(Object obj) {
        d7 d7Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s6) {
            s6 s6Var = (s6) obj;
            if (this.f3837a.equals(s6Var.a()) && ((d7Var = this.f3838b) != null ? d7Var.equals(s6Var.b()) : s6Var.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f3837a.hashCode() ^ 1000003;
        d7 d7Var = this.f3838b;
        return (iHashCode * 1000003) ^ (d7Var == null ? 0 : d7Var.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.f3837a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.f3838b) + "}";
    }
}
