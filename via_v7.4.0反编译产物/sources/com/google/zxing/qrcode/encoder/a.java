package com.google.zxing.qrcode.encoder;

import a4.f;
import c4.b;
import c4.c;
import c4.d;
import c4.e;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import s3.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4190a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f4191b = StandardCharsets.ISO_8859_1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.zxing.qrcode.encoder.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0053a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4192a;

        static {
            int[] iArr = new int[Mode.values().length];
            f4192a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4192a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4192a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4192a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, s3.a aVar, Charset charset) {
        for (byte b10 : str.getBytes(charset)) {
            aVar.c(b10, 8);
        }
    }

    public static void b(CharSequence charSequence, s3.a aVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iP = p(charSequence.charAt(i10));
            if (iP == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int iP2 = p(charSequence.charAt(i11));
                if (iP2 == -1) {
                    throw new WriterException();
                }
                aVar.c((iP * 45) + iP2, 11);
                i10 += 2;
            } else {
                aVar.c(iP, 6);
                i10 = i11;
            }
        }
    }

    public static void c(String str, Mode mode, s3.a aVar, Charset charset) {
        int i10 = C0053a.f4192a[mode.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
            return;
        }
        if (i10 == 2) {
            b(str, aVar);
            return;
        }
        if (i10 == 3) {
            a(str, aVar, charset);
        } else {
            if (i10 == 4) {
                e(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, s3.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    public static void e(String str, s3.a aVar) throws WriterException {
        int i10;
        byte[] bytes = str.getBytes(l.f11847b);
        if (bytes.length % 2 != 0) {
            throw new WriterException("Kanji byte size not even");
        }
        int length = bytes.length - 1;
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = ((bytes[i11] & 255) << 8) | (bytes[i11 + 1] & 255);
            int i13 = 33088;
            if (i12 >= 33088 && i12 <= 40956) {
                i10 = i12 - i13;
            } else if (i12 < 57408 || i12 > 60351) {
                i10 = -1;
            } else {
                i13 = 49472;
                i10 = i12 - i13;
            }
            if (i10 == -1) {
                throw new WriterException("Invalid byte sequence");
            }
            aVar.c(((i10 >> 8) * 192) + (i10 & 255), 13);
        }
    }

    public static void f(int i10, f fVar, Mode mode, s3.a aVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(fVar);
        int i11 = 1 << characterCountBits;
        if (i10 < i11) {
            aVar.c(i10, characterCountBits);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void g(Mode mode, s3.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, s3.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iCharAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((iCharAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((iCharAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(iCharAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, s3.a aVar, s3.a aVar2, f fVar) {
        return aVar.n() + mode.getCharacterCountBits(fVar) + aVar2.n();
    }

    public static int j(b bVar) {
        return c.a(bVar) + c.c(bVar) + c.d(bVar) + c.e(bVar);
    }

    public static int k(s3.a aVar, ErrorCorrectionLevel errorCorrectionLevel, f fVar, b bVar) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            d.a(aVar, errorCorrectionLevel, fVar, i12, bVar);
            int iJ = j(bVar);
            if (iJ < i10) {
                i11 = i12;
                i10 = iJ;
            }
        }
        return i11;
    }

    public static Mode l(String str, Charset charset) {
        if (l.f11847b.equals(charset) && s(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z11 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static f m(int i10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            f fVarI = f.i(i11);
            if (v(i10, fVarI, errorCorrectionLevel)) {
                return fVarI;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e n(String str, ErrorCorrectionLevel errorCorrectionLevel, Map map) throws NumberFormatException, WriterException {
        boolean z10;
        boolean z11;
        f fVarT;
        f fVarE;
        s3.a aVar;
        Mode mode;
        CharacterSetECI characterSetECI;
        int iK;
        boolean z12 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.GS1_FORMAT;
            z10 = map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString());
        }
        if (map != null) {
            EncodeHintType encodeHintType2 = EncodeHintType.QR_COMPACT;
            z11 = map.containsKey(encodeHintType2) && Boolean.parseBoolean(map.get(encodeHintType2).toString());
        }
        Object obj = f4191b;
        if (map != null && map.containsKey(EncodeHintType.CHARACTER_SET)) {
            z12 = true;
        }
        Charset charsetForName = z12 ? Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()) : obj;
        if (z11) {
            mode = Mode.BYTE;
            if (charsetForName.equals(obj)) {
                charsetForName = null;
            }
            MinimalEncoder.c cVarI = MinimalEncoder.i(str, null, charsetForName, z10, errorCorrectionLevel);
            aVar = new s3.a();
            cVarI.b(aVar);
            fVarE = cVarI.e();
        } else {
            Mode modeL = l(str, charsetForName);
            s3.a aVar2 = new s3.a();
            Mode mode2 = Mode.BYTE;
            if (modeL == mode2 && z12 && (characterSetECI = CharacterSetECI.getCharacterSetECI(charsetForName)) != null) {
                d(characterSetECI, aVar2);
            }
            if (z10) {
                g(Mode.FNC1_FIRST_POSITION, aVar2);
            }
            g(modeL, aVar2);
            s3.a aVar3 = new s3.a();
            c(str, modeL, aVar3, charsetForName);
            if (map != null) {
                EncodeHintType encodeHintType3 = EncodeHintType.QR_VERSION;
                if (map.containsKey(encodeHintType3)) {
                    fVarT = f.i(Integer.parseInt(map.get(encodeHintType3).toString()));
                    if (!v(i(modeL, aVar2, aVar3, fVarT), fVarT, errorCorrectionLevel)) {
                        throw new WriterException("Data too big for requested version");
                    }
                } else {
                    fVarT = t(errorCorrectionLevel, modeL, aVar2, aVar3);
                }
                s3.a aVar4 = new s3.a();
                aVar4.b(aVar2);
                f(modeL == mode2 ? aVar3.o() : str.length(), fVarT, modeL, aVar4);
                aVar4.b(aVar3);
                fVarE = fVarT;
                aVar = aVar4;
                mode = modeL;
            }
        }
        f.b bVarF = fVarE.f(errorCorrectionLevel);
        int iH = fVarE.h() - bVarF.d();
        u(iH, aVar);
        s3.a aVarR = r(aVar, fVarE.h(), iH, bVarF.c());
        e eVar = new e();
        eVar.c(errorCorrectionLevel);
        eVar.f(mode);
        eVar.g(fVarE);
        int iE = fVarE.e();
        b bVar = new b(iE, iE);
        if (map != null) {
            EncodeHintType encodeHintType4 = EncodeHintType.QR_MASK_PATTERN;
            if (map.containsKey(encodeHintType4)) {
                iK = Integer.parseInt(map.get(encodeHintType4).toString());
                if (!e.b(iK)) {
                    iK = -1;
                }
            }
        }
        if (iK == -1) {
            iK = k(aVarR, errorCorrectionLevel, fVarE, bVar);
        }
        eVar.d(iK);
        d.a(aVarR, errorCorrectionLevel, fVarE, iK, bVar);
        eVar.e(bVar);
        return eVar;
    }

    public static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new u3.d(u3.a.f12801l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int p(int i10) {
        int[] iArr = f4190a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 >= i12) {
            throw new WriterException("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    public static s3.a r(s3.a aVar, int i10, int i11, int i12) throws WriterException {
        if (aVar.o() != i11) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int i14 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i13 < i12) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i15 = i10;
            int i16 = i11;
            int i17 = i12;
            q(i15, i16, i17, i13, iArr, iArr2);
            int i18 = iArr[0];
            byte[] bArr = new byte[i18];
            aVar.t(i14 * 8, bArr, 0, i18);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new c4.a(bArr, bArrO));
            iMax = Math.max(iMax, i18);
            iMax2 = Math.max(iMax2, bArrO.length);
            i14 += iArr[0];
            i13++;
            i10 = i15;
            i11 = i16;
            i12 = i17;
        }
        int i19 = i10;
        if (i11 != i14) {
            throw new WriterException("Data bytes does not match offset");
        }
        s3.a aVar2 = new s3.a();
        for (int i20 = 0; i20 < iMax; i20++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((c4.a) it.next()).a();
                if (i20 < bArrA.length) {
                    aVar2.c(bArrA[i20], 8);
                }
            }
        }
        for (int i21 = 0; i21 < iMax2; i21++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((c4.a) it2.next()).b();
                if (i21 < bArrB.length) {
                    aVar2.c(bArrB[i21], 8);
                }
            }
        }
        if (i19 == aVar2.o()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i19 + " and " + aVar2.o() + " differ.");
    }

    public static boolean s(String str) {
        byte[] bytes = str.getBytes(l.f11847b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10 += 2) {
            int i11 = bytes[i10] & 255;
            if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                return false;
            }
        }
        return true;
    }

    public static f t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, s3.a aVar, s3.a aVar2) {
        return m(i(mode, aVar, aVar2, m(i(mode, aVar, aVar2, f.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void u(int i10, s3.a aVar) throws WriterException {
        int i11 = i10 * 8;
        if (aVar.n() > i11) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.n() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.n() < i11; i12++) {
            aVar.a(false);
        }
        int iN = aVar.n() & 7;
        if (iN > 0) {
            while (iN < 8) {
                aVar.a(false);
                iN++;
            }
        }
        int iO = i10 - aVar.o();
        for (int i13 = 0; i13 < iO; i13++) {
            aVar.c((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.n() != i11) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean v(int i10, f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return fVar.h() - fVar.f(errorCorrectionLevel).d() >= (i10 + 7) / 8;
    }
}
