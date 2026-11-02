package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements r {

    /* renamed from: e, reason: collision with root package name */
    public final r f3522e;

    /* renamed from: j, reason: collision with root package name */
    public final String f3523j;

    public h(String str) {
        this.f3522e = r.f3714a;
        this.f3523j = str;
    }

    public h(String str, r rVar) {
        this.f3522e = rVar;
        this.f3523j = str;
    }

    public final r a() {
        return this.f3522e;
    }

    public final String b() {
        return this.f3523j;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new h(this.f3523j, this.f3522e.c());
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
        return this.f3523j.equals(hVar.f3523j) && this.f3522e.equals(hVar.f3522e);
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
        return (this.f3523j.hashCode() * 31) + this.f3522e.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        throw new IllegalStateException("Control does not have functions");
    }
}
