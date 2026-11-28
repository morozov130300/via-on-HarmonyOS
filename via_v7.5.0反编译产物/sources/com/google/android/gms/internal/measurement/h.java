package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f2821c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2822e;

    public h(String str) {
        this.f2821c = r.f3013a;
        this.f2822e = str;
    }

    public final r a() {
        return this.f2821c;
    }

    public final String b() {
        return this.f2822e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new h(this.f2822e, this.f2821c.c());
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        throw new IllegalStateException("Control is not a double");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f2822e.equals(hVar.f2822e) && this.f2821c.equals(hVar.f2821c);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    public final int hashCode() {
        return (this.f2822e.hashCode() * 31) + this.f2821c.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public h(String str, r rVar) {
        this.f2821c = rVar;
        this.f2822e = str;
    }
}
