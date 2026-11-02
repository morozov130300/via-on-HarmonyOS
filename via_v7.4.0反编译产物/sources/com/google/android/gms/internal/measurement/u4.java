package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u4 extends a9 implements ba {
    public static final /* synthetic */ int zza = 0;
    private static final u4 zzd;
    private long zzB;
    private int zzC;
    private boolean zzF;
    private int zzI;
    private int zzJ;
    private int zzK;
    private long zzM;
    private long zzN;
    private int zzQ;
    private x4 zzS;
    private long zzU;
    private long zzV;
    private int zzY;
    private boolean zzZ;
    private boolean zzab;
    private p4 zzac;
    private long zzag;
    private int zze;
    private int zzf;
    private int zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzs;
    private long zzw;
    private long zzx;
    private boolean zzz;
    private g9 zzh = a9.s();
    private g9 zzi = a9.s();
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private String zzy = "";
    private String zzA = "";
    private String zzD = "";
    private String zzE = "";
    private g9 zzG = a9.s();
    private String zzH = "";
    private String zzL = "";
    private String zzO = "";
    private String zzP = "";
    private String zzR = "";
    private e9 zzT = a9.p();
    private String zzW = "";
    private String zzX = "";
    private String zzaa = "";
    private String zzad = "";
    private g9 zzae = a9.s();
    private String zzaf = "";

    static {
        u4 u4Var = new u4();
        zzd = u4Var;
        a9.y(u4.class, u4Var);
    }

    public static /* synthetic */ void A0(u4 u4Var) {
        u4Var.zze &= -268435457;
        u4Var.zzL = zzd.zzL;
    }

    public static /* synthetic */ void B0(u4 u4Var, long j10) {
        u4Var.zze |= 536870912;
        u4Var.zzM = j10;
    }

    public static /* synthetic */ void E0(u4 u4Var, Iterable iterable) {
        u4Var.f1();
        t7.f(iterable, u4Var.zzh);
    }

    public static /* synthetic */ void F0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zzf |= 8192;
        u4Var.zzad = str;
    }

    public static /* synthetic */ void G0(u4 u4Var) {
        u4Var.zzf &= -8193;
        u4Var.zzad = zzd.zzad;
    }

    public static /* synthetic */ void H0(u4 u4Var, Iterable iterable) {
        g9 g9Var = u4Var.zzae;
        if (!g9Var.b()) {
            u4Var.zzae = a9.t(g9Var);
        }
        t7.f(iterable, u4Var.zzae);
    }

    public static /* synthetic */ void J0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zzf |= 16384;
        u4Var.zzaf = str;
    }

    public static /* synthetic */ void K0(u4 u4Var, long j10) {
        u4Var.zzf |= 32768;
        u4Var.zzag = j10;
    }

    public static /* synthetic */ void L0(u4 u4Var, int i10) {
        u4Var.f1();
        u4Var.zzh.remove(i10);
    }

    public static /* synthetic */ void M0(u4 u4Var, int i10, d5 d5Var) {
        d5Var.getClass();
        u4Var.g1();
        u4Var.zzi.set(i10, d5Var);
    }

    public static /* synthetic */ void N0(u4 u4Var, d5 d5Var) {
        d5Var.getClass();
        u4Var.g1();
        u4Var.zzi.add(d5Var);
    }

    public static /* synthetic */ void O0(u4 u4Var, Iterable iterable) {
        u4Var.g1();
        t7.f(iterable, u4Var.zzi);
    }

    public static /* synthetic */ void P0(u4 u4Var, int i10) {
        u4Var.g1();
        u4Var.zzi.remove(i10);
    }

    public static /* synthetic */ void Q0(u4 u4Var, long j10) {
        u4Var.zze |= 2;
        u4Var.zzj = j10;
    }

    public static /* synthetic */ void R0(u4 u4Var, long j10) {
        u4Var.zze |= 4;
        u4Var.zzk = j10;
    }

    public static /* synthetic */ void S0(u4 u4Var, long j10) {
        u4Var.zze |= 8;
        u4Var.zzl = j10;
    }

    public static t4 S1() {
        return (t4) zzd.l();
    }

    public static /* synthetic */ void T(u4 u4Var) {
        u4Var.zze &= Integer.MAX_VALUE;
        u4Var.zzO = zzd.zzO;
    }

    public static /* synthetic */ void T0(u4 u4Var, long j10) {
        u4Var.zze |= 16;
        u4Var.zzm = j10;
    }

    public static /* synthetic */ void U(u4 u4Var, int i10) {
        u4Var.zzf |= 2;
        u4Var.zzQ = i10;
    }

    public static /* synthetic */ void U0(u4 u4Var) {
        u4Var.zze &= -17;
        u4Var.zzm = 0L;
    }

    public static /* synthetic */ void V(u4 u4Var, int i10, j4 j4Var) {
        j4Var.getClass();
        u4Var.f1();
        u4Var.zzh.set(i10, j4Var);
    }

    public static /* synthetic */ void V0(u4 u4Var, long j10) {
        u4Var.zze |= 32;
        u4Var.zzn = j10;
    }

    public static /* synthetic */ void W(u4 u4Var, String str) {
        str.getClass();
        u4Var.zzf |= 4;
        u4Var.zzR = str;
    }

    public static /* synthetic */ void W0(u4 u4Var) {
        u4Var.zze &= -33;
        u4Var.zzn = 0L;
    }

    public static /* synthetic */ void X(u4 u4Var, x4 x4Var) {
        x4Var.getClass();
        u4Var.zzS = x4Var;
        u4Var.zzf |= 8;
    }

    public static /* synthetic */ void X0(u4 u4Var, String str) {
        u4Var.zze |= 64;
        u4Var.zzo = "android";
    }

    public static /* synthetic */ void Y(u4 u4Var, Iterable iterable) {
        e9 e9Var = u4Var.zzT;
        if (!e9Var.b()) {
            int size = e9Var.size();
            u4Var.zzT = e9Var.j(size == 0 ? 10 : size + size);
        }
        t7.f(iterable, u4Var.zzT);
    }

    public static /* synthetic */ void Y0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 128;
        u4Var.zzp = str;
    }

    public static /* synthetic */ void Z(u4 u4Var, j4 j4Var) {
        j4Var.getClass();
        u4Var.f1();
        u4Var.zzh.add(j4Var);
    }

    public static /* synthetic */ void Z0(u4 u4Var) {
        u4Var.zze &= -129;
        u4Var.zzp = zzd.zzp;
    }

    public static /* synthetic */ void a0(u4 u4Var, long j10) {
        u4Var.zzf |= 16;
        u4Var.zzU = j10;
    }

    public static /* synthetic */ void a1(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 256;
        u4Var.zzq = str;
    }

    public static /* synthetic */ void b0(u4 u4Var, long j10) {
        u4Var.zzf |= 32;
        u4Var.zzV = j10;
    }

    public static /* synthetic */ void b1(u4 u4Var) {
        u4Var.zze &= -257;
        u4Var.zzq = zzd.zzq;
    }

    public static /* synthetic */ void c0(u4 u4Var, String str) {
        u4Var.zzf |= 128;
        u4Var.zzX = str;
    }

    public static /* synthetic */ void c1(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 512;
        u4Var.zzr = str;
    }

    public static /* synthetic */ void d1(u4 u4Var, int i10) {
        u4Var.zze |= 1024;
        u4Var.zzs = i10;
    }

    public static /* synthetic */ void e0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 2048;
        u4Var.zzt = str;
    }

    public static /* synthetic */ void f0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 4096;
        u4Var.zzu = str;
    }

    public static /* synthetic */ void g0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 8192;
        u4Var.zzv = str;
    }

    public static /* synthetic */ void h0(u4 u4Var, long j10) {
        u4Var.zze |= 16384;
        u4Var.zzw = j10;
    }

    public static /* synthetic */ void i0(u4 u4Var, long j10) {
        u4Var.zze |= 32768;
        u4Var.zzx = 79000L;
    }

    public static /* synthetic */ void j0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 65536;
        u4Var.zzy = str;
    }

    public static /* synthetic */ void k0(u4 u4Var) {
        u4Var.zze &= -65537;
        u4Var.zzy = zzd.zzy;
    }

    public static /* synthetic */ void l0(u4 u4Var, boolean z10) {
        u4Var.zze |= 131072;
        u4Var.zzz = z10;
    }

    public static /* synthetic */ void m0(u4 u4Var) {
        u4Var.zze &= -131073;
        u4Var.zzz = false;
    }

    public static /* synthetic */ void n0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 262144;
        u4Var.zzA = str;
    }

    public static /* synthetic */ void o0(u4 u4Var) {
        u4Var.zze &= -262145;
        u4Var.zzA = zzd.zzA;
    }

    public static /* synthetic */ void p0(u4 u4Var, long j10) {
        u4Var.zze |= 524288;
        u4Var.zzB = j10;
    }

    public static /* synthetic */ void q0(u4 u4Var, int i10) {
        u4Var.zze |= 1048576;
        u4Var.zzC = i10;
    }

    public static /* synthetic */ void r0(u4 u4Var, String str) {
        u4Var.zze |= 2097152;
        u4Var.zzD = str;
    }

    public static /* synthetic */ void s0(u4 u4Var) {
        u4Var.zze &= -2097153;
        u4Var.zzD = zzd.zzD;
    }

    public static /* synthetic */ void t0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 4194304;
        u4Var.zzE = str;
    }

    public static /* synthetic */ void u0(u4 u4Var, boolean z10) {
        u4Var.zze |= 8388608;
        u4Var.zzF = z10;
    }

    public static /* synthetic */ void v0(u4 u4Var, Iterable iterable) {
        g9 g9Var = u4Var.zzG;
        if (!g9Var.b()) {
            u4Var.zzG = a9.t(g9Var);
        }
        t7.f(iterable, u4Var.zzG);
    }

    public static /* synthetic */ void x0(u4 u4Var, String str) {
        str.getClass();
        u4Var.zze |= 16777216;
        u4Var.zzH = str;
    }

    public static /* synthetic */ void y0(u4 u4Var, int i10) {
        u4Var.zze |= 33554432;
        u4Var.zzI = i10;
    }

    public static /* synthetic */ void z0(u4 u4Var, int i10) {
        u4Var.zze |= 1;
        u4Var.zzg = 1;
    }

    public final boolean A1() {
        return (this.zze & 32768) != 0;
    }

    public final int B1() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zzd, "\u00015\u0000\u0002\u0001C5\u0000\u0005\u0000\u0001\u1004\u0000\u0002\u001b\u0003\u001b\u0004\u1002\u0001\u0005\u1002\u0002\u0006\u1002\u0003\u0007\u1002\u0005\b\u1008\u0006\t\u1008\u0007\n\u1008\b\u000b\u1008\t\f\u1004\n\r\u1008\u000b\u000e\u1008\f\u0010\u1008\r\u0011\u1002\u000e\u0012\u1002\u000f\u0013\u1008\u0010\u0014\u1007\u0011\u0015\u1008\u0012\u0016\u1002\u0013\u0017\u1004\u0014\u0018\u1008\u0015\u0019\u1008\u0016\u001a\u1002\u0004\u001c\u1007\u0017\u001d\u001b\u001e\u1008\u0018\u001f\u1004\u0019 \u1004\u001a!\u1004\u001b\"\u1008\u001c#\u1002\u001d$\u1002\u001e%\u1008\u001f&\u1008 '\u1004!)\u1008\",\u1009#-\u001d.\u1002$/\u1002%2\u1008&4\u1008'5\u100c(7\u1007)9\u1008*:\u1007+;\u1009,?\u1008-@\u001aA\u1008.C\u1002/", new Object[]{"zze", "zzf", "zzg", "zzh", j4.class, "zzi", d5.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", f4.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", b4.f3411a, "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag"});
        }
        if (i11 == 3) {
            return new u4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new t4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }

    public final boolean C0() {
        return this.zzz;
    }

    public final int C1() {
        return this.zzg;
    }

    public final String D() {
        return this.zzt;
    }

    public final boolean D0() {
        return this.zzF;
    }

    public final int D1() {
        return this.zzQ;
    }

    public final String E() {
        return this.zzv;
    }

    public final int E1() {
        return this.zzs;
    }

    public final String F() {
        return this.zzX;
    }

    public final int F1() {
        return this.zzi.size();
    }

    public final String G() {
        return this.zzq;
    }

    public final long G1() {
        return this.zzM;
    }

    public final String H() {
        return this.zzO;
    }

    public final long H1() {
        return this.zzB;
    }

    public final String I() {
        return this.zzH;
    }

    public final long I1() {
        return this.zzU;
    }

    public final String J() {
        return this.zzE;
    }

    public final long J1() {
        return this.zzl;
    }

    public final String K() {
        return this.zzD;
    }

    public final long K1() {
        return this.zzw;
    }

    public final String L() {
        return this.zzp;
    }

    public final long L1() {
        return this.zzn;
    }

    public final String M() {
        return this.zzo;
    }

    public final long M1() {
        return this.zzm;
    }

    public final String N() {
        return this.zzy;
    }

    public final long N1() {
        return this.zzk;
    }

    public final String O() {
        return this.zzad;
    }

    public final long O1() {
        return this.zzag;
    }

    public final String P() {
        return this.zzr;
    }

    public final long P1() {
        return this.zzj;
    }

    public final List Q() {
        return this.zzG;
    }

    public final long Q1() {
        return this.zzx;
    }

    public final List R() {
        return this.zzh;
    }

    public final j4 R1(int i10) {
        return (j4) this.zzh.get(i10);
    }

    public final List S() {
        return this.zzi;
    }

    public final d5 U1(int i10) {
        return (d5) this.zzi.get(i10);
    }

    public final String V1() {
        return this.zzR;
    }

    public final String W1() {
        return this.zzu;
    }

    public final String X1() {
        return this.zzA;
    }

    public final int d0() {
        return this.zzI;
    }

    public final int e1() {
        return this.zzC;
    }

    public final void f1() {
        g9 g9Var = this.zzh;
        if (g9Var.b()) {
            return;
        }
        this.zzh = a9.t(g9Var);
    }

    public final void g1() {
        g9 g9Var = this.zzi;
        if (g9Var.b()) {
            return;
        }
        this.zzi = a9.t(g9Var);
    }

    public final boolean h1() {
        return (this.zze & 33554432) != 0;
    }

    public final boolean i1() {
        return (this.zze & 1048576) != 0;
    }

    public final boolean j1() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean k1() {
        return (this.zzf & 128) != 0;
    }

    public final boolean l1() {
        return (this.zze & 524288) != 0;
    }

    public final boolean m1() {
        return (this.zzf & 16) != 0;
    }

    public final boolean n1() {
        return (this.zze & 8) != 0;
    }

    public final boolean o1() {
        return (this.zze & 16384) != 0;
    }

    public final boolean p1() {
        return (this.zze & 131072) != 0;
    }

    public final boolean q1() {
        return (this.zze & 32) != 0;
    }

    public final boolean r1() {
        return (this.zze & 16) != 0;
    }

    public final boolean s1() {
        return (this.zze & 1) != 0;
    }

    public final boolean t1() {
        return (this.zzf & 2) != 0;
    }

    public final boolean u1() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean v1() {
        return (this.zzf & 8192) != 0;
    }

    public final boolean w1() {
        return (this.zze & 4) != 0;
    }

    public final boolean x1() {
        return (this.zzf & 32768) != 0;
    }

    public final boolean y1() {
        return (this.zze & 1024) != 0;
    }

    public final boolean z1() {
        return (this.zze & 2) != 0;
    }
}
