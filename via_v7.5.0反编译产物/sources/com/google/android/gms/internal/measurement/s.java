package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3043c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f3044e;

    public s(String str, List list) {
        this.f3043c = str;
        ArrayList arrayList = new ArrayList();
        this.f3044e = arrayList;
        arrayList.addAll(list);
    }

    public final String a() {
        return this.f3043c;
    }

    public final ArrayList b() {
        return this.f3044e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.f3043c;
        if (str == null ? sVar.f3043c == null : str.equals(sVar.f3043c)) {
            return this.f3044e.equals(sVar.f3044e);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    public final int hashCode() {
        String str = this.f3043c;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f3044e.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return this;
    }
}
