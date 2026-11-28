package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2960b;

    public p8(Object obj, int i10) {
        this.f2959a = obj;
        this.f2960b = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p8)) {
            return false;
        }
        p8 p8Var = (p8) obj;
        return this.f2959a == p8Var.f2959a && this.f2960b == p8Var.f2960b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f2959a) * 65535) + this.f2960b;
    }
}
