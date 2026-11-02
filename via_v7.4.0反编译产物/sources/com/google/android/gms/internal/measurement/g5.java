package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g5 extends a9 implements ba {
    private static final g5 zza;
    private g9 zzd = a9.s();

    static {
        g5 g5Var = new g5();
        zza = g5Var;
        a9.y(g5.class, g5Var);
    }

    public static g5 F() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", i5.class});
        }
        if (i11 == 3) {
            return new g5();
        }
        e5 e5Var = null;
        if (i11 == 4) {
            return new f5(e5Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzd.size();
    }

    public final List G() {
        return this.zzd;
    }
}
