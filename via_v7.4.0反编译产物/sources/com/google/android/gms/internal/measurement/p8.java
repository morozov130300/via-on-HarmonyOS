package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p8 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3661b;

    public p8(Object obj, int i10) {
        this.f3660a = obj;
        this.f3661b = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p8)) {
            return false;
        }
        p8 p8Var = (p8) obj;
        return this.f3660a == p8Var.f3660a && this.f3661b == p8Var.f3661b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3660a) * 65535) + this.f3661b;
    }
}
