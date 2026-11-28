package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o6 extends v6 {
    public o6(r6 r6Var, String str, Boolean bool, boolean z10) {
        super(r6Var, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.v6
    public final /* synthetic */ Object a(Object obj) {
        if (s5.f3053c.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (s5.f3054d.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + this.f3144b + ": " + ((String) obj));
        return null;
    }
}
