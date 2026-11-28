package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b3 extends a9 implements ba {
    private static final b3 zza;
    private int zzd;
    private n3 zze;
    private g3 zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        b3 b3Var = new b3();
        zza = b3Var;
        a9.y(b3.class, b3Var);
    }

    public static b3 E() {
        return zza;
    }

    public static /* synthetic */ void I(b3 b3Var, String str) {
        b3Var.zzd |= 8;
        b3Var.zzh = str;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new b3();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new a3(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final g3 F() {
        g3 g3Var = this.zzf;
        return g3Var == null ? g3.E() : g3Var;
    }

    public final n3 G() {
        n3 n3Var = this.zze;
        return n3Var == null ? n3.F() : n3Var;
    }

    public final String H() {
        return this.zzh;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final boolean K() {
        return (this.zzd & 4) != 0;
    }

    public final boolean L() {
        return (this.zzd & 2) != 0;
    }

    public final boolean M() {
        return (this.zzd & 8) != 0;
    }

    public final boolean N() {
        return (this.zzd & 1) != 0;
    }
}
