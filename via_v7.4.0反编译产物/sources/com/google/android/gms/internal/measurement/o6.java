package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o6 extends v6 {
    public o6(r6 r6Var, String str, Boolean bool, boolean z10) {
        super(r6Var, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.v6
    public final /* synthetic */ Object a(Object obj) {
        if (s5.f3754c.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (s5.f3755d.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + this.f3845b + ": " + ((String) obj));
        return null;
    }
}
