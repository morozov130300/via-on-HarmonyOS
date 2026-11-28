package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class m8 extends y7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f2919b = Logger.getLogger(m8.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f2920c = ab.C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n8 f2921a;

    public /* synthetic */ m8(l8 l8Var) {
    }

    public static m8 A(byte[] bArr, int i10, int i11) {
        return new k8(bArr, 0, i11);
    }

    public static int u(int i10, aa aaVar, la laVar) {
        int iC = ((t7) aaVar).c(laVar);
        int iY = y(i10 << 3);
        return iY + iY + iC;
    }

    public static int v(int i10) {
        if (i10 >= 0) {
            return y(i10);
        }
        return 10;
    }

    public static int w(aa aaVar, la laVar) {
        int iC = ((t7) aaVar).c(laVar);
        return y(iC) + iC;
    }

    public static int x(String str) {
        int length;
        try {
            length = eb.c(str);
        } catch (zzny unused) {
            length = str.getBytes(h9.f2835b).length;
        }
        return y(length) + length;
    }

    public static int y(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int z(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            j10 >>>= 14;
            i10 += 2;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public final void a() {
        if (d() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void b(String str, zzny zznyVar) throws zzkg {
        f2919b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznyVar);
        byte[] bytes = str.getBytes(h9.f2835b);
        try {
            int length = bytes.length;
            r(length);
            n(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(e10);
        }
    }

    public abstract int d();

    public abstract void e(byte b10);

    public abstract void f(int i10, boolean z10);

    public abstract void g(int i10, zzka zzkaVar);

    public abstract void h(int i10, int i11);

    public abstract void i(int i10);

    public abstract void j(int i10, long j10);

    public abstract void k(long j10);

    public abstract void l(int i10, int i11);

    public abstract void m(int i10);

    public abstract void n(byte[] bArr, int i10, int i11);

    public abstract void o(int i10, String str);

    public abstract void p(int i10, int i11);

    public abstract void q(int i10, int i11);

    public abstract void r(int i10);

    public abstract void s(int i10, long j10);

    public abstract void t(long j10);
}
