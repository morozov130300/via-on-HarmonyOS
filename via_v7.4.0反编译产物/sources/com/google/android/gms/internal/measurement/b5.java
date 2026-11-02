package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b5 extends a9 implements ba {
    private static final b5 zza;
    private int zzd;
    private int zze;
    private f9 zzf = a9.q();

    static {
        b5 b5Var = new b5();
        zza = b5Var;
        a9.y(b5.class, b5Var);
    }

    public static a5 G() {
        return (a5) zza.l();
    }

    public static /* synthetic */ void J(b5 b5Var, int i10) {
        b5Var.zzd |= 1;
        b5Var.zze = i10;
    }

    public static /* synthetic */ void K(b5 b5Var, Iterable iterable) {
        f9 f9Var = b5Var.zzf;
        if (!f9Var.b()) {
            b5Var.zzf = a9.r(f9Var);
        }
        t7.f(iterable, b5Var.zzf);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new b5();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new a5(a4Var);
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
        return this.zze;
    }

    public final long F(int i10) {
        return this.zzf.i(i10);
    }

    public final List I() {
        return this.zzf;
    }

    public final boolean L() {
        return (this.zzd & 1) != 0;
    }
}
