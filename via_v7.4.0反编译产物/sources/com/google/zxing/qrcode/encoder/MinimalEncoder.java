package com.google.zxing.qrcode.encoder;

import a4.f;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s3.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class MinimalEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final String f4168a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4169b;

    /* renamed from: c, reason: collision with root package name */
    public final g f4170c;

    /* renamed from: d, reason: collision with root package name */
    public final ErrorCorrectionLevel f4171d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4173a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4174b;

        static {
            int[] iArr = new int[Mode.values().length];
            f4174b = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4174b[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4174b[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4174b[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4174b[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VersionSize.values().length];
            f4173a = iArr2;
            try {
                iArr2[VersionSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4173a[VersionSize.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4173a[VersionSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Mode f4175a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4176b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4177c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4178d;

        /* renamed from: e, reason: collision with root package name */
        public final b f4179e;

        /* renamed from: f, reason: collision with root package name */
        public final int f4180f;

        public b(Mode mode, int i10, int i11, int i12, b bVar, f fVar) {
            this.f4175a = mode;
            this.f4176b = i10;
            Mode mode2 = Mode.BYTE;
            int i13 = (mode == mode2 || bVar == null) ? i11 : bVar.f4177c;
            this.f4177c = i13;
            this.f4178d = i12;
            this.f4179e = bVar;
            boolean z10 = false;
            int characterCountBits = bVar != null ? bVar.f4180f : 0;
            if ((mode == mode2 && bVar == null && i13 != 0) || (bVar != null && i13 != bVar.f4177c)) {
                z10 = true;
            }
            characterCountBits = (bVar == null || mode != bVar.f4175a || z10) ? characterCountBits + mode.getCharacterCountBits(fVar) + 4 : characterCountBits;
            int i14 = a.f4174b[mode.ordinal()];
            if (i14 == 1) {
                characterCountBits += 13;
            } else if (i14 == 2) {
                characterCountBits += i12 == 1 ? 6 : 11;
            } else if (i14 == 3) {
                characterCountBits += i12 != 1 ? i12 == 2 ? 7 : 10 : 4;
            } else if (i14 == 4) {
                characterCountBits += MinimalEncoder.this.f4170c.b(MinimalEncoder.this.f4168a.substring(i10, i12 + i10), i11).length * 8;
                if (z10) {
                    characterCountBits += 12;
                }
            }
            this.f4180f = characterCountBits;
        }

        public /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i10, int i11, int i12, b bVar, f fVar, a aVar) {
            this(mode, i10, i11, i12, bVar, fVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final List f4182a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final f f4183b;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public final class a {

            /* renamed from: a, reason: collision with root package name */
            public final Mode f4185a;

            /* renamed from: b, reason: collision with root package name */
            public final int f4186b;

            /* renamed from: c, reason: collision with root package name */
            public final int f4187c;

            /* renamed from: d, reason: collision with root package name */
            public final int f4188d;

            public a(Mode mode, int i10, int i11, int i12) {
                this.f4185a = mode;
                this.f4186b = i10;
                this.f4187c = i11;
                this.f4188d = i12;
            }

            public final void d(s3.a aVar) {
                aVar.c(this.f4185a.getBits(), 4);
                if (this.f4188d > 0) {
                    aVar.c(e(), this.f4185a.getCharacterCountBits(c.this.f4183b));
                }
                if (this.f4185a == Mode.ECI) {
                    aVar.c(MinimalEncoder.this.f4170c.d(this.f4187c), 8);
                } else if (this.f4188d > 0) {
                    String str = MinimalEncoder.this.f4168a;
                    int i10 = this.f4186b;
                    com.google.zxing.qrcode.encoder.a.c(str.substring(i10, this.f4188d + i10), this.f4185a, aVar, MinimalEncoder.this.f4170c.c(this.f4187c));
                }
            }

            public final int e() {
                if (this.f4185a != Mode.BYTE) {
                    return this.f4188d;
                }
                g gVar = MinimalEncoder.this.f4170c;
                String str = MinimalEncoder.this.f4168a;
                int i10 = this.f4186b;
                return gVar.b(str.substring(i10, this.f4188d + i10), this.f4187c).length;
            }

            public final int f(f fVar) {
                int iE;
                int characterCountBits = this.f4185a.getCharacterCountBits(fVar);
                int i10 = characterCountBits + 4;
                int i11 = a.f4174b[this.f4185a.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        int i12 = this.f4188d;
                        return i10 + ((i12 / 2) * 11) + (i12 % 2 == 1 ? 6 : 0);
                    }
                    if (i11 == 3) {
                        int i13 = this.f4188d;
                        int i14 = i10 + ((i13 / 3) * 10);
                        int i15 = i13 % 3;
                        if (i15 == 1) {
                            i = 4;
                        } else if (i15 == 2) {
                            i = 7;
                        }
                        return i14 + i;
                    }
                    if (i11 != 4) {
                        return i11 != 5 ? i10 : characterCountBits + 12;
                    }
                    iE = e() * 8;
                } else {
                    iE = this.f4188d * 13;
                }
                return i10 + iE;
            }

            public final String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < str.length(); i10++) {
                    if (str.charAt(i10) < ' ' || str.charAt(i10) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i10));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f4185a);
                sb2.append('(');
                if (this.f4185a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f4170c.c(this.f4187c).displayName());
                } else {
                    String str = MinimalEncoder.this.f4168a;
                    int i10 = this.f4186b;
                    sb2.append(g(str.substring(i10, this.f4188d + i10)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        public c(f fVar, b bVar) {
            int i10;
            int i11;
            int i12;
            b bVar2 = bVar;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (bVar2 == null) {
                    break;
                }
                int i15 = i13 + bVar2.f4178d;
                b bVar3 = bVar2.f4179e;
                boolean z10 = (bVar2.f4175a == Mode.BYTE && bVar3 == null && bVar2.f4177c != 0) || !(bVar3 == null || bVar2.f4177c == bVar3.f4177c);
                i10 = z10 ? 1 : i14;
                if (bVar3 == null || bVar3.f4175a != bVar2.f4175a || z10) {
                    this.f4182a.add(0, new a(bVar2.f4175a, bVar2.f4176b, bVar2.f4177c, i15));
                    i12 = 0;
                } else {
                    i12 = i15;
                }
                if (z10) {
                    this.f4182a.add(0, new a(Mode.ECI, bVar2.f4176b, bVar2.f4177c, 0));
                }
                i14 = i10;
                bVar2 = bVar3;
                i13 = i12;
            }
            if (MinimalEncoder.this.f4169b) {
                a aVar = (a) this.f4182a.get(0);
                if (aVar != null) {
                    Mode mode = aVar.f4185a;
                    int i16 = i14;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && i16 != 0) {
                        this.f4182a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f4182a.add(((a) this.f4182a.get(0)).f4185a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iJ = fVar.j();
            int i17 = a.f4173a[MinimalEncoder.m(fVar).ordinal()];
            if (i17 == 1) {
                i11 = 9;
            } else if (i17 != 2) {
                i10 = 27;
                i11 = 40;
            } else {
                i10 = 10;
                i11 = 26;
            }
            int iD = d(fVar);
            while (iJ < i11 && !com.google.zxing.qrcode.encoder.a.v(iD, f.i(iJ), MinimalEncoder.this.f4171d)) {
                iJ++;
            }
            while (iJ > i10 && com.google.zxing.qrcode.encoder.a.v(iD, f.i(iJ - 1), MinimalEncoder.this.f4171d)) {
                iJ--;
            }
            this.f4183b = f.i(iJ);
        }

        public void b(s3.a aVar) {
            Iterator it = this.f4182a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).d(aVar);
            }
        }

        public int c() {
            return d(this.f4183b);
        }

        public final int d(f fVar) {
            Iterator it = this.f4182a.iterator();
            int iF = 0;
            while (it.hasNext()) {
                iF += ((a) it.next()).f(fVar);
            }
            return iF;
        }

        public f e() {
            return this.f4183b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f4182a) {
                if (aVar != null) {
                    sb2.append(",");
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    public MinimalEncoder(String str, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f4168a = str;
        this.f4169b = z10;
        this.f4170c = new g(str, charset, -1);
        this.f4171d = errorCorrectionLevel;
    }

    public static c i(String str, f fVar, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        return new MinimalEncoder(str, charset, z10, errorCorrectionLevel).h(fVar);
    }

    public static int k(Mode mode) {
        int i10;
        if (mode == null || (i10 = a.f4174b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    public static f l(VersionSize versionSize) {
        int i10 = a.f4173a[versionSize.ordinal()];
        return i10 != 1 ? i10 != 2 ? f.i(40) : f.i(26) : f.i(9);
    }

    public static VersionSize m(f fVar) {
        return fVar.j() <= 9 ? VersionSize.SMALL : fVar.j() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    public static boolean n(char c10) {
        return com.google.zxing.qrcode.encoder.a.p(c10) != -1;
    }

    public static boolean o(char c10) {
        return com.google.zxing.qrcode.encoder.a.s(String.valueOf(c10));
    }

    public static boolean p(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public void e(b[][][] bVarArr, int i10, b bVar) {
        b[] bVarArr2 = bVarArr[i10 + bVar.f4178d][bVar.f4177c];
        int iK = k(bVar.f4175a);
        b bVar2 = bVarArr2[iK];
        if (bVar2 == null || bVar2.f4180f > bVar.f4180f) {
            bVarArr2[iK] = bVar;
        }
    }

    public void f(f fVar, b[][][] bVarArr, int i10, b bVar) {
        int i11;
        int iF = this.f4170c.f();
        int iE = this.f4170c.e();
        if (iE < 0 || !this.f4170c.a(this.f4168a.charAt(i10), iE)) {
            iE = 0;
        } else {
            iF = iE + 1;
        }
        int i12 = iF;
        for (int i13 = iE; i13 < i12; i13++) {
            if (this.f4170c.a(this.f4168a.charAt(i10), i13)) {
                e(bVarArr, i10, new b(this, Mode.BYTE, i10, i13, 1, bVar, fVar, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f4168a.charAt(i10))) {
            e(bVarArr, i10, new b(this, mode, i10, 0, 1, bVar, fVar, null));
        }
        int length = this.f4168a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f4168a.charAt(i10))) {
            int i14 = i10 + 1;
            e(bVarArr, i10, new b(this, mode2, i10, 0, (i14 >= length || !g(mode2, this.f4168a.charAt(i14))) ? 1 : 2, bVar, fVar, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f4168a.charAt(i10))) {
            int i15 = i10 + 1;
            if (i15 >= length || !g(mode3, this.f4168a.charAt(i15))) {
                i11 = 1;
            } else {
                int i16 = i10 + 2;
                i11 = (i16 >= length || !g(mode3, this.f4168a.charAt(i16))) ? 2 : 3;
            }
            e(bVarArr, i10, new b(this, mode3, i10, 0, i11, bVar, fVar, null));
        }
    }

    public boolean g(Mode mode, char c10) {
        int i10 = a.f4174b[mode.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 == 4 : p(c10) : n(c10) : o(c10);
    }

    public c h(f fVar) throws WriterException {
        if (fVar != null) {
            c cVarJ = j(fVar);
            if (com.google.zxing.qrcode.encoder.a.v(cVarJ.c(), l(m(cVarJ.e())), this.f4171d)) {
                return cVarJ;
            }
            throw new WriterException("Data too big for version" + fVar);
        }
        f[] fVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(fVarArr[0]), j(fVarArr[1]), j(fVarArr[2])};
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 3; i12++) {
            int iC = cVarArr[i12].c();
            if (com.google.zxing.qrcode.encoder.a.v(iC, fVarArr[i12], this.f4171d) && iC < i10) {
                i10 = iC;
                i11 = i12;
            }
        }
        if (i11 >= 0) {
            return cVarArr[i11];
        }
        throw new WriterException("Data too big for any version");
    }

    public c j(f fVar) throws WriterException {
        int length = this.f4168a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f4170c.f(), 4);
        f(fVar, bVarArr, 0, null);
        for (int i10 = 1; i10 <= length; i10++) {
            for (int i11 = 0; i11 < this.f4170c.f(); i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    b bVar = bVarArr[i10][i11][i12];
                    if (bVar != null && i10 < length) {
                        f(fVar, bVarArr, i10, bVar);
                    }
                }
            }
        }
        int i13 = -1;
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < this.f4170c.f(); i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                b bVar2 = bVarArr[length][i16][i17];
                if (bVar2 != null && bVar2.f4180f < i15) {
                    i15 = bVar2.f4180f;
                    i13 = i16;
                    i14 = i17;
                }
            }
        }
        if (i13 >= 0) {
            return new c(fVar, bVarArr[length][i13][i14]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f4168a + "\"");
    }
}
