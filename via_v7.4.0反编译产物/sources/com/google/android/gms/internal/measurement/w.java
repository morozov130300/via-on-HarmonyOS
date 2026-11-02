package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w implements r {
    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return r.f3714a;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof w;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return "undefined";
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.FALSE;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", str));
    }
}
