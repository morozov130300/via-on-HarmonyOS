package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2809c;

    public g(Boolean bool) {
        this.f2809c = bool == null ? false : bool.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new g(Boolean.valueOf(this.f2809c));
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return Double.valueOf(true != this.f2809c ? 0.0d : 1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f2809c == ((g) obj).f2809c;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return Boolean.toString(this.f2809c);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.valueOf(this.f2809c);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f2809c).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        if ("toString".equals(str)) {
            return new v(Boolean.toString(this.f2809c));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.f2809c), str));
    }

    public final String toString() {
        return String.valueOf(this.f2809c);
    }
}
