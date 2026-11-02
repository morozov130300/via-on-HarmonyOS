package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k5 extends a9 implements ba {
    private static final k5 zza;
    private int zzd;
    private g9 zze = a9.s();
    private g5 zzf;

    static {
        k5 k5Var = new k5();
        zza = k5Var;
        a9.y(k5.class, k5Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u1009\u0000", new Object[]{"zzd", "zze", p5.class, "zzf"});
        }
        if (i11 == 3) {
            return new k5();
        }
        e5 e5Var = null;
        if (i11 == 4) {
            return new j5(e5Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final g5 D() {
        g5 g5Var = this.zzf;
        return g5Var == null ? g5.F() : g5Var;
    }

    public final List F() {
        return this.zze;
    }
}
