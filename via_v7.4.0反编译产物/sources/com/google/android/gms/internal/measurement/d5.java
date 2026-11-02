package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d5 extends a9 implements ba {
    private static final d5 zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        d5 d5Var = new d5();
        zza = d5Var;
        a9.y(d5.class, d5Var);
    }

    public static c5 G() {
        return (c5) zza.l();
    }

    public static /* synthetic */ void K(d5 d5Var, long j10) {
        d5Var.zzd |= 1;
        d5Var.zze = j10;
    }

    public static /* synthetic */ void L(d5 d5Var, String str) {
        str.getClass();
        d5Var.zzd |= 2;
        d5Var.zzf = str;
    }

    public static /* synthetic */ void M(d5 d5Var, String str) {
        str.getClass();
        d5Var.zzd |= 4;
        d5Var.zzg = str;
    }

    public static /* synthetic */ void N(d5 d5Var) {
        d5Var.zzd &= -5;
        d5Var.zzg = zza.zzg;
    }

    public static /* synthetic */ void O(d5 d5Var, long j10) {
        d5Var.zzd |= 8;
        d5Var.zzh = j10;
    }

    public static /* synthetic */ void P(d5 d5Var) {
        d5Var.zzd &= -9;
        d5Var.zzh = 0L;
    }

    public static /* synthetic */ void Q(d5 d5Var, double d10) {
        d5Var.zzd |= 32;
        d5Var.zzj = d10;
    }

    public static /* synthetic */ void R(d5 d5Var) {
        d5Var.zzd &= -33;
        d5Var.zzj = 0.0d;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1002\u0003\u0005\u1001\u0004\u0006\u1000\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new d5();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new c5(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final double D() {
        return this.zzj;
    }

    public final long E() {
        return this.zzh;
    }

    public final long F() {
        return this.zze;
    }

    public final String I() {
        return this.zzf;
    }

    public final String J() {
        return this.zzg;
    }

    public final boolean S() {
        return (this.zzd & 32) != 0;
    }

    public final boolean T() {
        return (this.zzd & 8) != 0;
    }

    public final boolean U() {
        return (this.zzd & 1) != 0;
    }

    public final boolean V() {
        return (this.zzd & 4) != 0;
    }
}
