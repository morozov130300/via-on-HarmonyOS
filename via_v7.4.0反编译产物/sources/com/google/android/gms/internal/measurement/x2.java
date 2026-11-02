package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x2 extends a9 implements ba {
    private static final x2 zza;
    private int zzd;
    private int zze;
    private g9 zzf = a9.s();
    private g9 zzg = a9.s();
    private boolean zzh;
    private boolean zzi;

    static {
        x2 x2Var = new x2();
        zza = x2Var;
        a9.y(x2.class, x2Var);
    }

    public static /* synthetic */ void L(x2 x2Var, int i10, i3 i3Var) {
        i3Var.getClass();
        g9 g9Var = x2Var.zzf;
        if (!g9Var.b()) {
            x2Var.zzf = a9.t(g9Var);
        }
        x2Var.zzf.set(i10, i3Var);
    }

    public static /* synthetic */ void M(x2 x2Var, int i10, z2 z2Var) {
        z2Var.getClass();
        g9 g9Var = x2Var.zzg;
        if (!g9Var.b()) {
            x2Var.zzg = a9.t(g9Var);
        }
        x2Var.zzg.set(i10, z2Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1004\u0000\u0002\u001b\u0003\u001b\u0004\u1007\u0001\u0005\u1007\u0002", new Object[]{"zzd", "zze", "zzf", i3.class, "zzg", z2.class, "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new x2();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new w2(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zze;
    }

    public final int E() {
        return this.zzg.size();
    }

    public final int F() {
        return this.zzf.size();
    }

    public final z2 H(int i10) {
        return (z2) this.zzg.get(i10);
    }

    public final i3 I(int i10) {
        return (i3) this.zzf.get(i10);
    }

    public final List J() {
        return this.zzg;
    }

    public final List K() {
        return this.zzf;
    }

    public final boolean N() {
        return (this.zzd & 1) != 0;
    }
}
