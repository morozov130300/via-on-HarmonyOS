package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j4 extends a9 implements ba {
    private static final j4 zza;
    private int zzd;
    private g9 zze = a9.s();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        j4 j4Var = new j4();
        zza = j4Var;
        a9.y(j4.class, j4Var);
    }

    public static i4 H() {
        return (i4) zza.l();
    }

    public static /* synthetic */ void M(j4 j4Var, int i10, n4 n4Var) {
        n4Var.getClass();
        j4Var.X();
        j4Var.zze.set(i10, n4Var);
    }

    public static /* synthetic */ void N(j4 j4Var, n4 n4Var) {
        n4Var.getClass();
        j4Var.X();
        j4Var.zze.add(n4Var);
    }

    public static /* synthetic */ void O(j4 j4Var, Iterable iterable) {
        j4Var.X();
        t7.f(iterable, j4Var.zze);
    }

    public static /* synthetic */ void Q(j4 j4Var, int i10) {
        j4Var.X();
        j4Var.zze.remove(i10);
    }

    public static /* synthetic */ void R(j4 j4Var, String str) {
        str.getClass();
        j4Var.zzd |= 1;
        j4Var.zzf = str;
    }

    public static /* synthetic */ void S(j4 j4Var, long j10) {
        j4Var.zzd |= 2;
        j4Var.zzg = j10;
    }

    public static /* synthetic */ void T(j4 j4Var, long j10) {
        j4Var.zzd |= 4;
        j4Var.zzh = j10;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\u1008\u0000\u0003\u1002\u0001\u0004\u1002\u0002\u0005\u1004\u0003", new Object[]{"zzd", "zze", n4.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new j4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new i4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzi;
    }

    public final int E() {
        return this.zze.size();
    }

    public final long F() {
        return this.zzh;
    }

    public final long G() {
        return this.zzg;
    }

    public final n4 J(int i10) {
        return (n4) this.zze.get(i10);
    }

    public final String K() {
        return this.zzf;
    }

    public final List L() {
        return this.zze;
    }

    public final boolean U() {
        return (this.zzd & 8) != 0;
    }

    public final boolean V() {
        return (this.zzd & 4) != 0;
    }

    public final boolean W() {
        return (this.zzd & 2) != 0;
    }

    public final void X() {
        g9 g9Var = this.zze;
        if (g9Var.b()) {
            return;
        }
        this.zze = a9.t(g9Var);
    }
}
