package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z2 extends a9 implements ba {
    private static final z2 zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private g9 zzg = a9.s();
    private boolean zzh;
    private g3 zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        z2 z2Var = new z2();
        zza = z2Var;
        a9.y(z2.class, z2Var);
    }

    public static y2 F() {
        return (y2) zza.l();
    }

    public static /* synthetic */ void L(z2 z2Var, String str) {
        z2Var.zzd |= 2;
        z2Var.zzf = str;
    }

    public static /* synthetic */ void M(z2 z2Var, int i10, b3 b3Var) {
        b3Var.getClass();
        g9 g9Var = z2Var.zzg;
        if (!g9Var.b()) {
            z2Var.zzg = a9.t(g9Var);
        }
        z2Var.zzg.set(i10, b3Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", b3.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i11 == 3) {
            return new z2();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new y2(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzg.size();
    }

    public final int E() {
        return this.zze;
    }

    public final b3 H(int i10) {
        return (b3) this.zzg.get(i10);
    }

    public final g3 I() {
        g3 g3Var = this.zzi;
        return g3Var == null ? g3.E() : g3Var;
    }

    public final String J() {
        return this.zzf;
    }

    public final List K() {
        return this.zzg;
    }

    public final boolean N() {
        return this.zzj;
    }

    public final boolean O() {
        return this.zzk;
    }

    public final boolean P() {
        return this.zzl;
    }

    public final boolean Q() {
        return (this.zzd & 8) != 0;
    }

    public final boolean R() {
        return (this.zzd & 1) != 0;
    }

    public final boolean S() {
        return (this.zzd & 64) != 0;
    }
}
