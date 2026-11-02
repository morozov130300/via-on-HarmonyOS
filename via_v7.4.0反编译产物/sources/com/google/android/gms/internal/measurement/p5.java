package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p5 extends a9 implements ba {
    private static final p5 zza;
    private int zzd;
    private int zze;
    private g9 zzf = a9.s();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        p5 p5Var = new p5();
        zza = p5Var;
        a9.y(p5.class, p5Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u001b\u0003\u1008\u0001\u0004\u1008\u0002\u0005\u1007\u0003\u0006\u1000\u0004", new Object[]{"zzd", "zze", n5.f3630a, "zzf", p5.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new p5();
        }
        e5 e5Var = null;
        if (i11 == 4) {
            return new l5(e5Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final double D() {
        return this.zzj;
    }

    public final String F() {
        return this.zzg;
    }

    public final String G() {
        return this.zzh;
    }

    public final List H() {
        return this.zzf;
    }

    public final boolean I() {
        return this.zzi;
    }

    public final boolean J() {
        return (this.zzd & 8) != 0;
    }

    public final boolean K() {
        return (this.zzd & 16) != 0;
    }

    public final boolean L() {
        return (this.zzd & 4) != 0;
    }

    public final int M() {
        int iA = o5.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
