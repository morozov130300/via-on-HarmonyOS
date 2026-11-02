package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v3 extends a9 implements ba {
    private static final v3 zza;
    private int zzd;
    private long zze;
    private int zzg;
    private boolean zzl;
    private String zzf = "";
    private g9 zzh = a9.s();
    private g9 zzi = a9.s();
    private g9 zzj = a9.s();
    private String zzk = "";
    private g9 zzm = a9.s();
    private g9 zzn = a9.s();
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        v3 v3Var = new v3();
        zza = v3Var;
        a9.y(v3.class, v3Var);
    }

    public static u3 H() {
        return (u3) zza.l();
    }

    public static v3 J() {
        return zza;
    }

    public static /* synthetic */ void S(v3 v3Var, int i10, t3 t3Var) {
        t3Var.getClass();
        g9 g9Var = v3Var.zzi;
        if (!g9Var.b()) {
            v3Var.zzi = a9.t(g9Var);
        }
        v3Var.zzi.set(i10, t3Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0005\u0000\u0001\u1002\u0000\u0002\u1008\u0001\u0003\u1004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u1008\u0003\b\u1007\u0004\t\u001b\n\u001b\u000b\u1008\u0005\f\u1008\u0006\r\u1008\u0007\u000e\u1008\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", z3.class, "zzi", t3.class, "zzj", x2.class, "zzk", "zzl", "zzm", k5.class, "zzn", r3.class, "zzo", "zzp", "zzq", "zzr"});
        }
        if (i11 == 3) {
            return new v3();
        }
        o3 o3Var = null;
        if (i11 == 4) {
            return new u3(o3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final int D() {
        return this.zzm.size();
    }

    public final int E() {
        return this.zzi.size();
    }

    public final long F() {
        return this.zze;
    }

    public final t3 G(int i10) {
        return (t3) this.zzi.get(i10);
    }

    public final String K() {
        return this.zzf;
    }

    public final String L() {
        return this.zzq;
    }

    public final String M() {
        return this.zzp;
    }

    public final String N() {
        return this.zzo;
    }

    public final List O() {
        return this.zzj;
    }

    public final List P() {
        return this.zzn;
    }

    public final List Q() {
        return this.zzm;
    }

    public final List R() {
        return this.zzh;
    }

    public final boolean U() {
        return this.zzl;
    }

    public final boolean V() {
        return (this.zzd & 2) != 0;
    }

    public final boolean W() {
        return (this.zzd & 1) != 0;
    }
}
