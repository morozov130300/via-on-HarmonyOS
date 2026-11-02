package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g3 extends a9 implements ba {
    private static final g3 zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        g3 g3Var = new g3();
        zza = g3Var;
        a9.y(g3.class, g3Var);
    }

    public static g3 E() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004", new Object[]{"zzd", "zze", e3.f3480a, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new g3();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new c3(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final String F() {
        return this.zzg;
    }

    public final String G() {
        return this.zzi;
    }

    public final String H() {
        return this.zzh;
    }

    public final boolean I() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzd & 1) != 0;
    }

    public final boolean K() {
        return (this.zzd & 4) != 0;
    }

    public final boolean L() {
        return (this.zzd & 2) != 0;
    }

    public final boolean M() {
        return (this.zzd & 16) != 0;
    }

    public final boolean N() {
        return (this.zzd & 8) != 0;
    }

    public final int O() {
        int iA = f3.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
