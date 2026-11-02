package s3;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f11846a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f11847b = Charset.forName("SJIS");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f11848c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f11849d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f11850e;

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f11848c = charsetForName;
        Charset charsetForName2 = Charset.forName("EUC_JP");
        f11849d = charsetForName2;
        Charset charset = f11847b;
        Charset charset2 = f11846a;
        f11850e = charset.equals(charset2) || charsetForName2.equals(charset2);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x00da A[PHI: r19
  0x00da: PHI (r19v6 boolean) = (r19v5 boolean), (r19v5 boolean), (r19v5 boolean), (r19v7 boolean), (r19v7 boolean), (r19v7 boolean) binds: [B:86:0x00e0, B:88:0x00e4, B:90:0x00e8, B:78:0x00ce, B:79:0x00d0, B:81:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Charset a(byte[] bArr, Map map) {
        boolean z10;
        boolean z11;
        boolean z12;
        byte b10;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return Charset.forName(map.get(decodeHintType).toString());
            }
        }
        boolean z13 = true;
        int i10 = 0;
        if (bArr2.length > 2 && (((b10 = bArr2[0]) == -2 && bArr2[1] == -1) || (b10 == -1 && bArr2[1] == -2))) {
            return StandardCharsets.UTF_16;
        }
        int length = bArr2.length;
        boolean z14 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i11 = 0;
        boolean z15 = true;
        boolean z16 = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i12 < length && (z13 || z15 || z16)) {
            byte b11 = bArr2[i12];
            int i22 = b11 & 255;
            if (z16) {
                if (i13 <= 0) {
                    z10 = z13;
                    if ((b11 & 128) != 0) {
                        if ((b11 & 64) != 0) {
                            int i23 = i13 + 1;
                            if ((b11 & 32) == 0) {
                                i15++;
                            } else {
                                i23 = i13 + 2;
                                if ((b11 & 16) == 0) {
                                    i16++;
                                } else {
                                    i13 += 3;
                                    if ((b11 & 8) == 0) {
                                        i17++;
                                    }
                                }
                            }
                            i13 = i23;
                        }
                    }
                } else if ((b11 & 128) == 0) {
                    z10 = z13;
                } else {
                    i13--;
                    z10 = z13;
                }
                z16 = false;
            } else {
                z10 = z13;
            }
            if (!z10) {
                z11 = z10;
            } else if (i22 <= 127 || i22 >= 160) {
                if (i22 > 159 && (i22 < 192 || i22 == 215 || i22 == 247)) {
                    i19++;
                }
                z11 = z10;
            } else {
                z11 = false;
            }
            if (!z15) {
                z12 = z11;
            } else if (i14 > 0) {
                z12 = z11;
                if (i22 < 64 || i22 == 127 || i22 > 252) {
                    z15 = false;
                } else {
                    i14--;
                }
            } else {
                z12 = z11;
                if (i22 != 128 && i22 != 160 && i22 <= 239) {
                    if (i22 <= 160 || i22 >= 224) {
                        if (i22 > 127) {
                            i14++;
                            int i24 = i20 + 1;
                            if (i24 > i10) {
                                i10 = i24;
                                i20 = i10;
                            } else {
                                i20 = i24;
                            }
                        } else {
                            i20 = 0;
                        }
                        i21 = 0;
                    } else {
                        i11++;
                        int i25 = i21 + 1;
                        if (i25 > i18) {
                            i18 = i25;
                            i21 = i18;
                        } else {
                            i21 = i25;
                        }
                        i20 = 0;
                    }
                }
            }
            i12++;
            bArr2 = bArr;
            z13 = z12;
        }
        boolean z17 = z13;
        if (z16 && i13 > 0) {
            z16 = false;
        }
        if (z15 && i14 > 0) {
            z15 = false;
        }
        return (!z16 || (!z14 && (i15 + i16) + i17 <= 0)) ? (!z15 || (!f11850e && i18 < 3 && i10 < 3)) ? (z17 && z15) ? (!(i18 == 2 && i11 == 2) && i19 * 10 < length) ? StandardCharsets.ISO_8859_1 : f11847b : z17 ? StandardCharsets.ISO_8859_1 : z15 ? f11847b : z16 ? StandardCharsets.UTF_8 : f11846a : f11847b : StandardCharsets.UTF_8;
    }
}
