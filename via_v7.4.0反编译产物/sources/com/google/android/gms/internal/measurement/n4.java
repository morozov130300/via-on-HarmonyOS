package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n4 extends a9 implements ba {
    private static final n4 zza;
    private int zzd;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private g9 zzj = a9.s();

    static {
        n4 n4Var = new n4();
        zza = n4Var;
        a9.y(n4.class, n4Var);
    }

    public static m4 H() {
        return (m4) zza.l();
    }

    public static /* synthetic */ void M(n4 n4Var, String str) {
        str.getClass();
        n4Var.zzd |= 1;
        n4Var.zze = str;
    }

    public static /* synthetic */ void N(n4 n4Var, String str) {
        str.getClass();
        n4Var.zzd |= 2;
        n4Var.zzf = str;
    }

    public static /* synthetic */ void O(n4 n4Var) {
        n4Var.zzd &= -3;
        n4Var.zzf = zza.zzf;
    }

    public static /* synthetic */ void P(n4 n4Var, long j10) {
        n4Var.zzd |= 4;
        n4Var.zzg = j10;
    }

    public static /* synthetic */ void Q(n4 n4Var) {
        n4Var.zzd &= -5;
        n4Var.zzg = 0L;
    }

    public static /* synthetic */ void R(n4 n4Var, double d10) {
        n4Var.zzd |= 16;
        n4Var.zzi = d10;
    }

    public static /* synthetic */ void S(n4 n4Var) {
        n4Var.zzd &= -17;
        n4Var.zzi = 0.0d;
    }

    public static /* synthetic */ void T(n4 n4Var, n4 n4Var2) {
        n4Var2.getClass();
        n4Var.b0();
        n4Var.zzj.add(n4Var2);
    }

    public static /* synthetic */ void U(n4 n4Var, Iterable iterable) {
        n4Var.b0();
        t7.f(iterable, n4Var.zzj);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1002\u0002\u0004\u1001\u0003\u0005\u1000\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", n4.class});
        }
        if (i11 == 3) {
            return new n4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new m4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final double D() {
        return this.zzi;
    }

    public final float E() {
        return this.zzh;
    }

    public final int F() {
        return this.zzj.size();
    }

    public final long G() {
        return this.zzg;
    }

    public final String J() {
        return this.zze;
    }

    public final String K() {
        return this.zzf;
    }

    public final List L() {
        return this.zzj;
    }

    public final boolean W() {
        return (this.zzd & 16) != 0;
    }

    public final boolean X() {
        return (this.zzd & 8) != 0;
    }

    public final boolean Y() {
        return (this.zzd & 4) != 0;
    }

    public final boolean Z() {
        return (this.zzd & 1) != 0;
    }

    public final boolean a0() {
        return (this.zzd & 2) != 0;
    }

    public final void b0() {
        g9 g9Var = this.zzj;
        if (g9Var.b()) {
            return;
        }
        this.zzj = a9.t(g9Var);
    }
}
