package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h4 extends a9 implements ba {
    private static final h4 zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        h4 h4Var = new h4();
        zza = h4Var;
        a9.y(h4.class, h4Var);
    }

    public static g4 F() {
        return (g4) zza.l();
    }

    public static /* synthetic */ void H(h4 h4Var, int i10) {
        h4Var.zzd |= 1;
        h4Var.zze = i10;
    }

    public static /* synthetic */ void I(h4 h4Var, long j10) {
        h4Var.zzd |= 2;
        h4Var.zzf = j10;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1002\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new h4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new g4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zze;
    }

    public final long E() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzd & 2) != 0;
    }

    public final boolean K() {
        return (this.zzd & 1) != 0;
    }
}
