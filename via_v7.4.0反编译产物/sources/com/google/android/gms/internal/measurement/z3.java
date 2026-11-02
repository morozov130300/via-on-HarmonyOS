package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z3 extends a9 implements ba {
    private static final z3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        z3 z3Var = new z3();
        zza = z3Var;
        a9.y(z3.class, z3Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new z3();
        }
        o3 o3Var = null;
        if (i11 == 4) {
            return new y3(o3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final String E() {
        return this.zze;
    }

    public final String F() {
        return this.zzf;
    }
}
