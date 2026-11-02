package a4;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import s3.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f64a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f65a;

        static {
            int[] iArr = new int[Mode.values().length];
            f65a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f65a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f65a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f65a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f65a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f65a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f65a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f65a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103 A[LOOP:0: B:65:0x001e->B:61:0x0103, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static s3.d a(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel, Map map) throws FormatException {
        Mode mode;
        StringBuilder sb2;
        int i10;
        byte[] bArr2 = bArr;
        s3.c cVar = new s3.c(bArr2);
        StringBuilder sb3 = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECIByValue = null;
        int iB = -1;
        int iB2 = -1;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            try {
                Mode modeForBits = cVar.a() < 4 ? Mode.TERMINATOR : Mode.forBits(cVar.b(4));
                int[] iArr = a.f65a;
                switch (iArr[modeForBits.ordinal()]) {
                    case 5:
                        mode = modeForBits;
                        if (mode == Mode.TERMINATOR) {
                            if (characterSetECIByValue != null) {
                                if (z11) {
                                    sb2 = sb3;
                                    i10 = 4;
                                } else if (z12) {
                                    sb2 = sb3;
                                    i10 = 6;
                                } else {
                                    sb2 = sb3;
                                    i10 = 2;
                                }
                            } else if (z11) {
                                sb2 = sb3;
                                i10 = 3;
                            } else if (z12) {
                                sb2 = sb3;
                                i10 = 5;
                            } else {
                                sb2 = sb3;
                                i10 = 1;
                            }
                            String string = sb2.toString();
                            if (arrayList.isEmpty()) {
                                arrayList = null;
                            }
                            return new s3.d(bArr2, string, arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), iB, iB2, i10);
                        }
                        bArr2 = bArr;
                    case 6:
                        mode = modeForBits;
                        z10 = true;
                        z11 = true;
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                    case 7:
                        mode = modeForBits;
                        z10 = true;
                        z12 = true;
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                    case 8:
                        mode = modeForBits;
                        if (cVar.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        iB = cVar.b(8);
                        iB2 = cVar.b(8);
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                    case 9:
                        mode = modeForBits;
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(g(cVar));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                    case 10:
                        mode = modeForBits;
                        int iB3 = cVar.b(4);
                        int iB4 = cVar.b(mode.getCharacterCountBits(fVar));
                        if (iB3 == 1) {
                            d(cVar, sb3, iB4);
                        }
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                    default:
                        int iB5 = cVar.b(modeForBits.getCharacterCountBits(fVar));
                        int i11 = iArr[modeForBits.ordinal()];
                        if (i11 == 1) {
                            mode = modeForBits;
                            f(cVar, sb3, iB5);
                        } else if (i11 == 2) {
                            mode = modeForBits;
                            b(cVar, sb3, iB5, z10);
                        } else if (i11 == 3) {
                            mode = modeForBits;
                            c(cVar, sb3, iB5, characterSetECIByValue, arrayList, map);
                        } else {
                            if (i11 != 4) {
                                throw FormatException.getFormatInstance();
                            }
                            e(cVar, sb3, iB5);
                            mode = modeForBits;
                        }
                        if (mode == Mode.TERMINATOR) {
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(s3.c cVar, StringBuilder sb2, int i10, boolean z10) throws FormatException {
        while (i10 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int iB = cVar.b(11);
            sb2.append(h(iB / 45));
            sb2.append(h(iB % 45));
            i10 -= 2;
        }
        if (i10 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(cVar.b(6)));
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        } else {
                            sb2.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    public static void c(s3.c cVar, StringBuilder sb2, int i10, CharacterSetECI characterSetECI, Collection collection, Map map) throws FormatException {
        if (i10 * 8 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) cVar.b(8);
        }
        sb2.append(new String(bArr, characterSetECI == null ? l.a(bArr, map) : characterSetECI.getCharset()));
        collection.add(bArr);
    }

    public static void d(s3.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (l.f11848c == null) {
            throw FormatException.getFormatInstance();
        }
        if (i10 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iB = cVar.b(13);
            int i12 = (iB % 96) | ((iB / 96) << 8);
            int i13 = i12 + (i12 < 2560 ? 41377 : 42657);
            bArr[i11] = (byte) ((i13 >> 8) & 255);
            bArr[i11 + 1] = (byte) (i13 & 255);
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, l.f11848c));
    }

    public static void e(s3.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iB = cVar.b(13);
            int i12 = (iB % 192) | ((iB / 192) << 8);
            int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, l.f11847b));
    }

    public static void f(s3.c cVar, StringBuilder sb2, int i10) throws FormatException {
        while (i10 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int iB = cVar.b(10);
            if (iB >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iB / 100));
            sb2.append(h((iB / 10) % 10));
            sb2.append(h(iB % 10));
            i10 -= 3;
        }
        if (i10 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int iB2 = cVar.b(7);
            if (iB2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iB2 / 10));
            sb2.append(h(iB2 % 10));
            return;
        }
        if (i10 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int iB3 = cVar.b(4);
            if (iB3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(iB3));
        }
    }

    public static int g(s3.c cVar) throws FormatException {
        int iB = cVar.b(8);
        if ((iB & 128) == 0) {
            return iB & 127;
        }
        if ((iB & 192) == 128) {
            return cVar.b(8) | ((iB & 63) << 8);
        }
        if ((iB & 224) == 192) {
            return cVar.b(16) | ((iB & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char h(int i10) throws FormatException {
        char[] cArr = f64a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.getFormatInstance();
    }
}
