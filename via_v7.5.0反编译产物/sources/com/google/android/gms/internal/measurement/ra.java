package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ra {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ra f3031f = new ra(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f3034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3035d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3036e;

    public ra(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f3032a = i10;
        this.f3033b = iArr;
        this.f3034c = objArr;
        this.f3036e = z10;
    }

    public static ra c() {
        return f3031f;
    }

    public static ra e(ra raVar, ra raVar2) {
        int i10 = raVar.f3032a + raVar2.f3032a;
        int[] iArrCopyOf = Arrays.copyOf(raVar.f3033b, i10);
        System.arraycopy(raVar2.f3033b, 0, iArrCopyOf, raVar.f3032a, raVar2.f3032a);
        Object[] objArrCopyOf = Arrays.copyOf(raVar.f3034c, i10);
        System.arraycopy(raVar2.f3034c, 0, objArrCopyOf, raVar.f3032a, raVar2.f3032a);
        return new ra(i10, iArrCopyOf, objArrCopyOf, true);
    }

    public static ra f() {
        return new ra(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iZ;
        int iY;
        int iY2;
        int i10 = this.f3035d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f3032a; i12++) {
            int i13 = this.f3033b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 == 1) {
                    ((Long) this.f3034c[i12]).getClass();
                    iY2 = m8.y(i14 << 3) + 8;
                } else if (i15 == 2) {
                    zzka zzkaVar = (zzka) this.f3034c[i12];
                    Logger logger = m8.f2919b;
                    int iZzd = zzkaVar.zzd();
                    iY2 = m8.y(i14 << 3) + m8.y(iZzd) + iZzd;
                } else if (i15 == 3) {
                    int i16 = i14 << 3;
                    Logger logger2 = m8.f2919b;
                    iZ = ((ra) this.f3034c[i12]).a();
                    int iY3 = m8.y(i16);
                    iY = iY3 + iY3;
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException(zzll.zza());
                    }
                    ((Integer) this.f3034c[i12]).getClass();
                    iY2 = m8.y(i14 << 3) + 4;
                }
                i11 += iY2;
            } else {
                int i17 = i14 << 3;
                iZ = m8.z(((Long) this.f3034c[i12]).longValue());
                iY = m8.y(i17);
            }
            iY2 = iY + iZ;
            i11 += iY2;
        }
        this.f3035d = i11;
        return i11;
    }

    public final int b() {
        int i10 = this.f3035d;
        if (i10 != -1) {
            return i10;
        }
        int iY = 0;
        for (int i11 = 0; i11 < this.f3032a; i11++) {
            int i12 = this.f3033b[i11] >>> 3;
            zzka zzkaVar = (zzka) this.f3034c[i11];
            Logger logger = m8.f2919b;
            int iZzd = zzkaVar.zzd();
            int iY2 = m8.y(iZzd) + iZzd;
            int iY3 = m8.y(16);
            int iY4 = m8.y(i12);
            int iY5 = m8.y(8);
            iY += iY5 + iY5 + iY3 + iY4 + m8.y(24) + iY2;
        }
        this.f3035d = iY;
        return iY;
    }

    public final ra d(ra raVar) {
        if (raVar.equals(f3031f)) {
            return this;
        }
        g();
        int i10 = this.f3032a + raVar.f3032a;
        l(i10);
        System.arraycopy(raVar.f3033b, 0, this.f3033b, this.f3032a, raVar.f3032a);
        System.arraycopy(raVar.f3034c, 0, this.f3034c, this.f3032a, raVar.f3032a);
        this.f3032a = i10;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ra)) {
            return false;
        }
        ra raVar = (ra) obj;
        int i10 = this.f3032a;
        if (i10 == raVar.f3032a) {
            int[] iArr = this.f3033b;
            int[] iArr2 = raVar.f3033b;
            for (int i11 = 0; i11 < i10; i11++) {
                if (iArr[i11] == iArr2[i11]) {
                }
            }
            Object[] objArr = this.f3034c;
            Object[] objArr2 = raVar.f3034c;
            int i12 = this.f3032a;
            for (int i13 = 0; i13 < i12; i13++) {
                if (objArr[i13].equals(objArr2[i13])) {
                }
            }
            return true;
        }
        return false;
    }

    public final void g() {
        if (!this.f3036e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if (this.f3036e) {
            this.f3036e = false;
        }
    }

    public final int hashCode() {
        int i10 = this.f3032a;
        int i11 = i10 + 527;
        int[] iArr = this.f3033b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i11 * 31) + i12;
        Object[] objArr = this.f3034c;
        int i15 = this.f3032a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return (i14 * 31) + iHashCode;
    }

    public final void i(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f3032a; i11++) {
            ca.b(sb2, i10, String.valueOf(this.f3033b[i11] >>> 3), this.f3034c[i11]);
        }
    }

    public final void j(int i10, Object obj) {
        g();
        l(this.f3032a + 1);
        int[] iArr = this.f3033b;
        int i11 = this.f3032a;
        iArr[i11] = i10;
        this.f3034c[i11] = obj;
        this.f3032a = i11 + 1;
    }

    public final void k(gb gbVar) {
        if (this.f3032a != 0) {
            for (int i10 = 0; i10 < this.f3032a; i10++) {
                int i11 = this.f3033b[i10];
                Object obj = this.f3034c[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    gbVar.i(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    gbVar.G(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    gbVar.A(i13, (zzka) obj);
                } else if (i12 == 3) {
                    gbVar.E(i13);
                    ((ra) obj).k(gbVar);
                    gbVar.J(i13);
                } else {
                    if (i12 != 5) {
                        throw new RuntimeException(zzll.zza());
                    }
                    gbVar.e(i13, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void l(int i10) {
        int[] iArr = this.f3033b;
        if (i10 > iArr.length) {
            int i11 = this.f3032a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f3033b = Arrays.copyOf(iArr, i10);
            this.f3034c = Arrays.copyOf(this.f3034c, i10);
        }
    }
}
