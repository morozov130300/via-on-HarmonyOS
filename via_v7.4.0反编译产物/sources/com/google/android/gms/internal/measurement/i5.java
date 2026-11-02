package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i5 extends a9 implements ba {
    private static final i5 zza;
    private int zzd;
    private String zze = "";
    private g9 zzf = a9.s();

    static {
        i5 i5Var = new i5();
        zza = i5Var;
        a9.y(i5.class, i5Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", p5.class});
        }
        if (i11 == 3) {
            return new i5();
        }
        e5 e5Var = null;
        if (i11 == 4) {
            return new h5(e5Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final String E() {
        return this.zze;
    }

    public final List F() {
        return this.zzf;
    }
}
