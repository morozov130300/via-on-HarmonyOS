package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i3 extends a9 implements ba {
    private static final i3 zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private b3 zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        i3 i3Var = new i3();
        zza = i3Var;
        a9.y(i3.class, i3Var);
    }

    public static h3 F() {
        return (h3) zza.l();
    }

    public static /* synthetic */ void I(i3 i3Var, String str) {
        i3Var.zzd |= 2;
        i3Var.zzf = str;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new i3();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new h3(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zze;
    }

    public final b3 E() {
        b3 b3Var = this.zzg;
        return b3Var == null ? b3.E() : b3Var;
    }

    public final String H() {
        return this.zzf;
    }

    public final boolean J() {
        return this.zzh;
    }

    public final boolean K() {
        return this.zzi;
    }

    public final boolean L() {
        return this.zzj;
    }

    public final boolean M() {
        return (this.zzd & 1) != 0;
    }

    public final boolean N() {
        return (this.zzd & 32) != 0;
    }
}
