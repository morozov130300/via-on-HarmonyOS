package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f4 extends a9 implements ba {
    private static final f4 zza;
    private int zzd;
    private int zze;
    private z4 zzf;
    private z4 zzg;
    private boolean zzh;

    static {
        f4 f4Var = new f4();
        zza = f4Var;
        a9.y(f4.class, f4Var);
    }

    public static e4 E() {
        return (e4) zza.l();
    }

    public static /* synthetic */ void I(f4 f4Var, int i10) {
        f4Var.zzd |= 1;
        f4Var.zze = i10;
    }

    public static /* synthetic */ void J(f4 f4Var, z4 z4Var) {
        z4Var.getClass();
        f4Var.zzf = z4Var;
        f4Var.zzd |= 2;
    }

    public static /* synthetic */ void K(f4 f4Var, z4 z4Var) {
        f4Var.zzg = z4Var;
        f4Var.zzd |= 4;
    }

    public static /* synthetic */ void L(f4 f4Var, boolean z10) {
        f4Var.zzd |= 8;
        f4Var.zzh = z10;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1007\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new f4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new e4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zze;
    }

    public final z4 G() {
        z4 z4Var = this.zzf;
        return z4Var == null ? z4.J() : z4Var;
    }

    public final z4 H() {
        z4 z4Var = this.zzg;
        return z4Var == null ? z4.J() : z4Var;
    }

    public final boolean M() {
        return this.zzh;
    }

    public final boolean N() {
        return (this.zzd & 1) != 0;
    }

    public final boolean O() {
        return (this.zzd & 8) != 0;
    }

    public final boolean P() {
        return (this.zzd & 4) != 0;
    }
}
