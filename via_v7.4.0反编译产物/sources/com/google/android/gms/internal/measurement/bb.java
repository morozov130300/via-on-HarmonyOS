package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class bb {
    public static /* bridge */ /* synthetic */ void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws zzll {
        if (e(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || e(b12) || e(b13)) {
            throw zzll.zzc();
        }
        int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
        cArr[i10] = (char) ((i11 >>> 10) + 55232);
        cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0018 A[PHI: r2
  0x0018: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0012, B:11:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* bridge */ /* synthetic */ void b(byte b10, byte b11, byte b12, char[] cArr, int i10) throws zzll {
        if (!e(b11)) {
            if (b10 != -32) {
                if (b10 != -19) {
                    if (!e(b12)) {
                        cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
                        return;
                    }
                } else if (b11 < -96) {
                    b10 = -19;
                    if (!e(b12)) {
                    }
                }
            } else if (b11 >= -96) {
                b10 = -32;
                if (b10 != -19) {
                }
            }
        }
        throw zzll.zzc();
    }

    public static /* bridge */ /* synthetic */ void c(byte b10, byte b11, char[] cArr, int i10) throws zzll {
        if (b10 < -62 || e(b11)) {
            throw zzll.zzc();
        }
        cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean d(byte b10) {
        return b10 >= 0;
    }

    public static boolean e(byte b10) {
        return b10 > -65;
    }
}
