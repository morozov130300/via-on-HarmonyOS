package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v5 extends s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d7 f3137b;

    public v5(Context context, d7 d7Var) {
        this.f3136a = context;
        this.f3137b = d7Var;
    }

    @Override // com.google.android.gms.internal.measurement.s6
    public final Context a() {
        return this.f3136a;
    }

    @Override // com.google.android.gms.internal.measurement.s6
    public final d7 b() {
        return this.f3137b;
    }

    public final boolean equals(Object obj) {
        d7 d7Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s6) {
            s6 s6Var = (s6) obj;
            if (this.f3136a.equals(s6Var.a()) && ((d7Var = this.f3137b) != null ? d7Var.equals(s6Var.b()) : s6Var.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f3136a.hashCode() ^ 1000003;
        d7 d7Var = this.f3137b;
        return (iHashCode * 1000003) ^ (d7Var == null ? 0 : d7Var.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.f3136a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.f3137b) + "}";
    }
}
