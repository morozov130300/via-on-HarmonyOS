package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p6 extends v6 {
    public p6(r6 r6Var, String str, Double d10, boolean z10) {
        super(r6Var, "measurement.test.double_flag", d10, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final /* synthetic */ Object a(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + this.f3845b + ": " + ((String) obj));
            return null;
        }
    }
}
