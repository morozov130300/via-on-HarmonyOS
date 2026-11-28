package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t3 extends a9 implements ba {
    private static final t3 zza;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        t3 t3Var = new t3();
        zza = t3Var;
        a9.y(t3.class, t3Var);
    }

    public static /* synthetic */ void G(t3 t3Var, String str) {
        str.getClass();
        t3Var.zzd |= 1;
        t3Var.zze = str;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new t3();
        }
        o3 o3Var = null;
        if (i11 == 4) {
            return new s3(o3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzh;
    }

    public final String F() {
        return this.zze;
    }

    public final boolean H() {
        return this.zzf;
    }

    public final boolean I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzd & 2) != 0;
    }

    public final boolean K() {
        return (this.zzd & 4) != 0;
    }

    public final boolean L() {
        return (this.zzd & 8) != 0;
    }
}
