package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s implements r {

    /* renamed from: e, reason: collision with root package name */
    public final String f3744e;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f3745j;

    public s(String str, List list) {
        this.f3744e = str;
        ArrayList arrayList = new ArrayList();
        this.f3745j = arrayList;
        arrayList.addAll(list);
    }

    public final String a() {
        return this.f3744e;
    }

    public final ArrayList b() {
        return this.f3745j;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return this;
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
        String str = this.f3744e;
        if (str == null ? sVar.f3744e == null : str.equals(sVar.f3744e)) {
            return this.f3745j.equals(sVar.f3745j);
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
        String str = this.f3744e;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f3745j.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }
}
