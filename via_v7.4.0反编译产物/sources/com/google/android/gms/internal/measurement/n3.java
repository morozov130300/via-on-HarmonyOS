package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n3 extends a9 implements ba {
    private static final n3 zza;
    private int zzd;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private g9 zzh = a9.s();

    static {
        n3 n3Var = new n3();
        zza = n3Var;
        a9.y(n3.class, n3Var);
    }

    public static n3 F() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u1008\u0001\u0003\u1007\u0002\u0004\u001a", new Object[]{"zzd", "zze", l3.f3608a, "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new n3();
        }
        v2 v2Var = null;
        if (i11 == 4) {
            return new j3(v2Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzh.size();
    }

    public final String G() {
        return this.zzf;
    }

    public final List H() {
        return this.zzh;
    }

    public final boolean I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzd & 4) != 0;
    }

    public final boolean K() {
        return (this.zzd & 2) != 0;
    }

    public final boolean L() {
        return (this.zzd & 1) != 0;
    }

    public final int M() {
        int iA = m3.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
