package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z4 extends a9 implements ba {
    private static final z4 zza;
    private f9 zzd = a9.q();
    private f9 zze = a9.q();
    private g9 zzf = a9.s();
    private g9 zzg = a9.s();

    static {
        z4 z4Var = new z4();
        zza = z4Var;
        a9.y(z4.class, z4Var);
    }

    public static y4 H() {
        return (y4) zza.l();
    }

    public static z4 J() {
        return zza;
    }

    public static /* synthetic */ void O(z4 z4Var, Iterable iterable) {
        f9 f9Var = z4Var.zzd;
        if (!f9Var.b()) {
            z4Var.zzd = a9.r(f9Var);
        }
        t7.f(iterable, z4Var.zzd);
    }

    public static /* synthetic */ void Q(z4 z4Var, Iterable iterable) {
        f9 f9Var = z4Var.zze;
        if (!f9Var.b()) {
            z4Var.zze = a9.r(f9Var);
        }
        t7.f(iterable, z4Var.zze);
    }

    public static /* synthetic */ void S(z4 z4Var, Iterable iterable) {
        g9 g9Var = z4Var.zzf;
        if (!g9Var.b()) {
            z4Var.zzf = a9.t(g9Var);
        }
        t7.f(iterable, z4Var.zzf);
    }

    public static /* synthetic */ void U(z4 z4Var, Iterable iterable) {
        g9 g9Var = z4Var.zzg;
        if (!g9Var.b()) {
            z4Var.zzg = a9.t(g9Var);
        }
        t7.f(iterable, z4Var.zzg);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", h4.class, "zzg", b5.class});
        }
        if (i11 == 3) {
            return new z4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new y4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzf.size();
    }

    public final int E() {
        return this.zze.size();
    }

    public final int F() {
        return this.zzg.size();
    }

    public final int G() {
        return this.zzd.size();
    }

    public final List K() {
        return this.zzf;
    }

    public final List L() {
        return this.zze;
    }

    public final List M() {
        return this.zzg;
    }

    public final List N() {
        return this.zzd;
    }
}
