package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g implements r {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3510e;

    public g(Boolean bool) {
        this.f3510e = bool == null ? false : bool.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new g(Boolean.valueOf(this.f3510e));
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return Double.valueOf(true != this.f3510e ? 0.0d : 1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f3510e == ((g) obj).f3510e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return Boolean.toString(this.f3510e);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.valueOf(this.f3510e);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f3510e).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        if ("toString".equals(str)) {
            return new v(Boolean.toString(this.f3510e));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.f3510e), str));
    }

    public final String toString() {
        return String.valueOf(this.f3510e);
    }
}
