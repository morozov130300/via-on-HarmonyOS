package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import w3.c;
import w3.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class Code128Writer extends r {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class MinimalEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[][] f3442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Latch[][] f3443b;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        public MinimalEncoder() {
        }

        public static void b(Collection collection, int i10, int[] iArr, int[] iArr2, int i11) {
            collection.add(c.f13589a[i10]);
            if (i11 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i10 * iArr2[0]);
        }

        public static boolean f(char c10) {
            return c10 >= '0' && c10 <= '9';
        }

        public final boolean c(CharSequence charSequence, Charset charset, int i10) {
            int i11;
            char cCharAt = charSequence.charAt(i10);
            int i12 = a.f3447b[charset.ordinal()];
            if (i12 == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(cCharAt) >= 0;
            }
            if (i12 == 2) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(cCharAt) >= 0;
            }
            if (i12 != 3) {
                return false;
            }
            return cCharAt == 241 || ((i11 = i10 + 1) < charSequence.length() && f(cCharAt) && f(charSequence.charAt(i11)));
        }

        public final int d(CharSequence charSequence, Charset charset, int i10) {
            int iD;
            int iD2;
            int i11 = this.f3442a[charset.ordinal()][i10];
            if (i11 > 0) {
                return i11;
            }
            Latch latch = Latch.NONE;
            int i12 = i10 + 1;
            boolean z10 = i12 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i13 = Integer.MAX_VALUE;
            for (int i14 = 0; i14 <= 1; i14++) {
                if (c(charSequence, charsetArr[i14], i10)) {
                    Latch latchValueOf = Latch.NONE;
                    Charset charset2 = charsetArr[i14];
                    if (charset != charset2) {
                        latchValueOf = Latch.valueOf(charset2.toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z10) {
                        iD2 += d(charSequence, charsetArr[i14], i12);
                    }
                    if (iD2 < i13) {
                        latch = latchValueOf;
                        i13 = iD2;
                    }
                    if (charset == charsetArr[(i14 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iD3 = !z10 ? d(charSequence, charset, i12) + 2 : 2;
                        if (iD3 < i13) {
                            latch = latch2;
                            i13 = iD3;
                        }
                    }
                }
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i10)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset3) {
                    latch3 = Latch.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i15 = (charSequence.charAt(i10) != 241 ? 2 : 1) + i10;
                if (i15 < charSequence.length()) {
                    iD += d(charSequence, charset3, i15);
                }
                if (iD < i13) {
                    latch = latch3;
                    i13 = iD;
                }
            }
            if (i13 != Integer.MAX_VALUE) {
                this.f3442a[charset.ordinal()][i10] = i13;
                this.f3443b[charset.ordinal()][i10] = latch;
                return i13;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i10)));
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:32:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:33:0x00af  */
        /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:38:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:49:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:51:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:69:0x0103 A[SYNTHETIC] */
        public final boolean[] e(String str) {
            Charset charset;
            int i10;
            this.f3442a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.f3443b = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
            Charset charset2 = Charset.NONE;
            d(str, charset2, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i11 = 0;
            while (i11 < length) {
                Latch latch = this.f3443b[charset2.ordinal()][i11];
                int i12 = a.f3446a[latch.ordinal()];
                int iCharAt = 101;
                if (i12 == 1) {
                    charset = Charset.A;
                    b(arrayList, i11 == 0 ? 103 : 101, iArr, iArr2, i11);
                } else if (i12 != 2) {
                    if (i12 == 3) {
                        charset = Charset.C;
                        b(arrayList, i11 == 0 ? 105 : 99, iArr, iArr2, i11);
                    } else if (i12 == 4) {
                        b(arrayList, 98, iArr, iArr2, i11);
                    }
                    if (charset2 == Charset.C) {
                        switch (str.charAt(i11)) {
                            case 241:
                                iCharAt = 102;
                                break;
                            case 242:
                                iCharAt = 97;
                                break;
                            case 243:
                                iCharAt = 96;
                                break;
                            case 244:
                                if ((charset2 != Charset.A || latch == Latch.SHIFT) && (charset2 != Charset.B || latch != Latch.SHIFT)) {
                                }
                                break;
                            default:
                                iCharAt = str.charAt(i11) - ' ';
                                break;
                        }
                        if (((charset2 != Charset.A && latch != Latch.SHIFT) || (charset2 == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                        }
                        b(arrayList, iCharAt, iArr, iArr2, i11);
                    } else if (str.charAt(i11) == 241) {
                        b(arrayList, 102, iArr, iArr2, i11);
                    } else {
                        b(arrayList, Integer.parseInt(str.substring(i11, i11 + 2)), iArr, iArr2, i11);
                        i10 = i11 + 1;
                        if (i10 < length) {
                            i11 = i10;
                        }
                    }
                    i11++;
                } else {
                    charset = Charset.B;
                    b(arrayList, i11 == 0 ? 104 : 100, iArr, iArr2, i11);
                }
                charset2 = charset;
                if (charset2 == Charset.C) {
                    switch (str.charAt(i11)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            iCharAt = charset2 != Charset.A ? 100 : 100;
                            break;
                        default:
                            iCharAt = str.charAt(i11) - ' ';
                            break;
                    }
                    iCharAt = charset2 != Charset.A ? iCharAt + 96 : iCharAt + 96;
                    b(arrayList, iCharAt, iArr, iArr2, i11);
                } else if (str.charAt(i11) == 241) {
                    b(arrayList, 102, iArr, iArr2, i11);
                } else {
                    b(arrayList, Integer.parseInt(str.substring(i11, i11 + 2)), iArr, iArr2, i11);
                    i10 = i11 + 1;
                    if (i10 < length) {
                        i11 = i10;
                    }
                }
                i11++;
            }
            this.f3442a = null;
            this.f3443b = null;
            return Code128Writer.m(arrayList, iArr[0]);
        }

        public /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3447b;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            f3447b = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3447b[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3447b[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            f3446a = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3446a[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3446a[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3446a[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    public static int i(String str, Map map) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i10 = -1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                String string = map.get(encodeHintType).toString();
                string.getClass();
                switch (string) {
                    case "A":
                        i10 = 101;
                        break;
                    case "B":
                        i10 = 100;
                        break;
                    case "C":
                        i10 = 99;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            switch (i10) {
                case 99:
                    if (cCharAt < '0' || ((cCharAt > '9' && cCharAt <= 127) || cCharAt == 242 || cCharAt == 243 || cCharAt == 244)) {
                        throw new IllegalArgumentException("Bad character in input for forced code set C: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 100:
                    if (cCharAt <= ' ') {
                        throw new IllegalArgumentException("Bad character in input for forced code set B: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 101:
                    if (cCharAt > '_' && cCharAt <= 127) {
                        throw new IllegalArgumentException("Bad character in input for forced code set A: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
            }
        }
        return i10;
    }

    public static int j(CharSequence charSequence, int i10, int i11) {
        CType cTypeL;
        CType cTypeL2;
        char cCharAt;
        CType cTypeL3 = l(charSequence, i10);
        CType cType = CType.ONE_DIGIT;
        if (cTypeL3 == cType) {
            return i11 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeL3 == cType2) {
            return (i10 >= charSequence.length() || ((cCharAt = charSequence.charAt(i10)) >= ' ' && (i11 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i11 == 101 && cTypeL3 == CType.FNC_1) {
            return 101;
        }
        if (i11 == 99) {
            return 99;
        }
        if (i11 != 100) {
            if (cTypeL3 == CType.FNC_1) {
                cTypeL3 = l(charSequence, i10 + 1);
            }
            return cTypeL3 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (cTypeL3 == cType3 || (cTypeL = l(charSequence, i10 + 2)) == cType2 || cTypeL == cType) {
            return 100;
        }
        if (cTypeL == cType3) {
            return l(charSequence, i10 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i12 = i10 + 4;
        while (true) {
            cTypeL2 = l(charSequence, i12);
            if (cTypeL2 != CType.TWO_DIGITS) {
                break;
            }
            i12 += 2;
        }
        return cTypeL2 == CType.ONE_DIGIT ? 100 : 99;
    }

    public static boolean[] k(String str, int i10) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i11 < length) {
            int iJ = i10 == -1 ? j(str, i11, i13) : i10;
            int iCharAt = 100;
            if (iJ == i13) {
                switch (str.charAt(i11)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i13 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i13 == 100) {
                            iCharAt = str.charAt(i11) - ' ';
                        } else if (i13 == 101) {
                            char cCharAt = str.charAt(i11);
                            iCharAt = cCharAt - ' ';
                            if (iCharAt < 0) {
                                iCharAt = cCharAt + '@';
                            }
                        } else {
                            int i15 = i11 + 1;
                            if (i15 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            iCharAt = Integer.parseInt(str.substring(i11, i11 + 2));
                            i11 = i15;
                        }
                        break;
                }
                i11++;
            } else {
                if (i13 != 0) {
                    iCharAt = iJ;
                } else if (iJ != 100) {
                    iCharAt = iJ != 101 ? 105 : 103;
                } else {
                    iCharAt = 104;
                }
                i13 = iJ;
            }
            arrayList.add(c.f13589a[iCharAt]);
            i12 += iCharAt * i14;
            if (i11 != 0) {
                i14++;
            }
        }
        return m(arrayList, i12);
    }

    public static CType l(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i11);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    public static boolean[] m(Collection collection, int i10) {
        int[][] iArr = c.f13589a;
        collection.add(iArr[i10 % 103]);
        collection.add(iArr[106]);
        Iterator it = collection.iterator();
        int iB = 0;
        int i11 = 0;
        while (it.hasNext()) {
            for (int i12 : (int[]) it.next()) {
                i11 += i12;
            }
        }
        boolean[] zArr = new boolean[i11];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            iB += r.b(zArr, iB, (int[]) it2.next(), true);
        }
        return zArr;
    }

    @Override // w3.r
    public boolean[] d(String str) {
        return e(str, null);
    }

    @Override // w3.r
    public boolean[] e(String str, Map map) {
        int i10 = i(str, map);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                return new MinimalEncoder(null).e(str);
            }
        }
        return k(str, i10);
    }

    @Override // w3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
