package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class x7 {
    public static int a(byte[] bArr, int i10, w7 w7Var) {
        int iJ = j(bArr, i10, w7Var);
        int i11 = w7Var.f3864a;
        if (i11 < 0) {
            throw zzll.zzd();
        }
        if (i11 > bArr.length - iJ) {
            throw zzll.zzf();
        }
        if (i11 == 0) {
            w7Var.f3866c = zzka.zzb;
            return iJ;
        }
        w7Var.f3866c = zzka.zzl(bArr, iJ, i11);
        return iJ + i11;
    }

    public static int b(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    public static int c(la laVar, byte[] bArr, int i10, int i11, int i12, w7 w7Var) {
        Object objD = laVar.d();
        int iN = n(objD, laVar, bArr, i10, i11, i12, w7Var);
        laVar.a(objD);
        w7Var.f3866c = objD;
        return iN;
    }

    public static int d(la laVar, byte[] bArr, int i10, int i11, w7 w7Var) {
        Object objD = laVar.d();
        int iO = o(objD, laVar, bArr, i10, i11, w7Var);
        laVar.a(objD);
        w7Var.f3866c = objD;
        return iO;
    }

    public static int e(la laVar, int i10, byte[] bArr, int i11, int i12, g9 g9Var, w7 w7Var) {
        int iD = d(laVar, bArr, i11, i12, w7Var);
        g9Var.add(w7Var.f3866c);
        while (iD < i12) {
            int iJ = j(bArr, iD, w7Var);
            if (i10 != w7Var.f3864a) {
                break;
            }
            iD = d(laVar, bArr, iJ, i12, w7Var);
            g9Var.add(w7Var.f3866c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i10, g9 g9Var, w7 w7Var) {
        b9 b9Var = (b9) g9Var;
        int iJ = j(bArr, i10, w7Var);
        int i11 = w7Var.f3864a + iJ;
        while (iJ < i11) {
            iJ = j(bArr, iJ, w7Var);
            b9Var.h(w7Var.f3864a);
        }
        if (iJ == i11) {
            return iJ;
        }
        throw zzll.zzf();
    }

    public static int g(byte[] bArr, int i10, w7 w7Var) throws zzll {
        int iJ = j(bArr, i10, w7Var);
        int i11 = w7Var.f3864a;
        if (i11 < 0) {
            throw zzll.zzd();
        }
        if (i11 == 0) {
            w7Var.f3866c = "";
            return iJ;
        }
        w7Var.f3866c = new String(bArr, iJ, i11, h9.f3536b);
        return iJ + i11;
    }

    public static int h(byte[] bArr, int i10, w7 w7Var) throws zzll {
        int iJ = j(bArr, i10, w7Var);
        int i11 = w7Var.f3864a;
        if (i11 < 0) {
            throw zzll.zzd();
        }
        if (i11 == 0) {
            w7Var.f3866c = "";
            return iJ;
        }
        cb cbVar = eb.f3486a;
        int length = bArr.length;
        if ((((length - iJ) - i11) | iJ | i11) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iJ), Integer.valueOf(i11)));
        }
        int i12 = iJ + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (iJ < i12) {
            byte b10 = bArr[iJ];
            if (!bb.d(b10)) {
                break;
            }
            iJ++;
            cArr[i13] = (char) b10;
            i13++;
        }
        int i14 = i13;
        while (iJ < i12) {
            int i15 = iJ + 1;
            byte b11 = bArr[iJ];
            if (bb.d(b11)) {
                cArr[i14] = (char) b11;
                i14++;
                iJ = i15;
                while (iJ < i12) {
                    byte b12 = bArr[iJ];
                    if (bb.d(b12)) {
                        iJ++;
                        cArr[i14] = (char) b12;
                        i14++;
                    }
                }
            } else if (b11 < -32) {
                if (i15 >= i12) {
                    throw zzll.zzc();
                }
                iJ += 2;
                bb.c(b11, bArr[i15], cArr, i14);
                i14++;
            } else if (b11 < -16) {
                if (i15 >= i12 - 1) {
                    throw zzll.zzc();
                }
                int i16 = iJ + 2;
                iJ += 3;
                bb.b(b11, bArr[i15], bArr[i16], cArr, i14);
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    throw zzll.zzc();
                }
                byte b13 = bArr[i15];
                int i17 = iJ + 3;
                byte b14 = bArr[iJ + 2];
                iJ += 4;
                bb.a(b11, b13, b14, bArr[i17], cArr, i14);
                i14 += 2;
            }
        }
        w7Var.f3866c = new String(cArr, 0, i14);
        return i12;
    }

    public static int i(int i10, byte[] bArr, int i11, int i12, ra raVar, w7 w7Var) {
        if ((i10 >>> 3) == 0) {
            throw zzll.zzb();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iM = m(bArr, i11, w7Var);
            raVar.j(i10, Long.valueOf(w7Var.f3865b));
            return iM;
        }
        if (i13 == 1) {
            raVar.j(i10, Long.valueOf(p(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iJ = j(bArr, i11, w7Var);
            int i14 = w7Var.f3864a;
            if (i14 < 0) {
                throw zzll.zzd();
            }
            if (i14 > bArr.length - iJ) {
                throw zzll.zzf();
            }
            if (i14 == 0) {
                raVar.j(i10, zzka.zzb);
            } else {
                raVar.j(i10, zzka.zzl(bArr, iJ, i14));
            }
            return iJ + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw zzll.zzb();
            }
            raVar.j(i10, Integer.valueOf(b(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        ra raVarF = ra.f();
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iJ2 = j(bArr, i11, w7Var);
            i16 = w7Var.f3864a;
            if (i16 == i15) {
                i11 = iJ2;
                break;
            }
            i11 = i(i16, bArr, iJ2, i12, raVarF, w7Var);
        }
        if (i11 > i12 || i16 != i15) {
            throw zzll.zze();
        }
        raVar.j(i10, raVarF);
        return i11;
    }

    public static int j(byte[] bArr, int i10, w7 w7Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return k(b10, bArr, i11, w7Var);
        }
        w7Var.f3864a = b10;
        return i11;
    }

    public static int k(int i10, byte[] bArr, int i11, w7 w7Var) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            w7Var.f3864a = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            w7Var.f3864a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            w7Var.f3864a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            w7Var.f3864a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                w7Var.f3864a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int l(int i10, byte[] bArr, int i11, int i12, g9 g9Var, w7 w7Var) {
        b9 b9Var = (b9) g9Var;
        int iJ = j(bArr, i11, w7Var);
        b9Var.h(w7Var.f3864a);
        while (iJ < i12) {
            int iJ2 = j(bArr, iJ, w7Var);
            if (i10 != w7Var.f3864a) {
                break;
            }
            iJ = j(bArr, iJ2, w7Var);
            b9Var.h(w7Var.f3864a);
        }
        return iJ;
    }

    public static int m(byte[] bArr, int i10, w7 w7Var) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            w7Var.f3865b = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & 127) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & 127) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        w7Var.f3865b = j11;
        return i12;
    }

    public static int n(Object obj, la laVar, byte[] bArr, int i10, int i11, int i12, w7 w7Var) {
        int iF = ((da) laVar).F(obj, bArr, i10, i11, i12, w7Var);
        w7Var.f3866c = obj;
        return iF;
    }

    public static int o(Object obj, la laVar, byte[] bArr, int i10, int i11, w7 w7Var) {
        int iK = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iK = k(i12, bArr, iK, w7Var);
            i12 = w7Var.f3864a;
        }
        int i13 = iK;
        if (i12 < 0 || i12 > i11 - i13) {
            throw zzll.zzf();
        }
        int i14 = i13 + i12;
        laVar.f(obj, bArr, i13, i14, w7Var);
        w7Var.f3866c = obj;
        return i14;
    }

    public static long p(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
    }
}
