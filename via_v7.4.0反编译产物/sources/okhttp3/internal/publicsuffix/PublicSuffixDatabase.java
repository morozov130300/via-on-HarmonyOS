package okhttp3.internal.publicsuffix;

import ac.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.e;
import okio.i;
import okio.k;
import ub.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f10659e = {42};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f10660f = new String[0];

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f10661g = {"*"};

    /* renamed from: h, reason: collision with root package name */
    public static final PublicSuffixDatabase f10662h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f10663a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f10664b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f10665c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f10666d;

    public static String a(byte[] bArr, byte[][] bArr2, int i10) {
        int i11;
        boolean z10;
        int i12;
        int i13;
        int length = bArr.length;
        int i14 = 0;
        while (i14 < length) {
            int i15 = (i14 + length) / 2;
            while (i15 > -1 && bArr[i15] != 10) {
                i15--;
            }
            int i16 = i15 + 1;
            int i17 = 1;
            while (true) {
                i11 = i16 + i17;
                if (bArr[i11] == 10) {
                    break;
                }
                i17++;
            }
            int i18 = i11 - i16;
            int i19 = i10;
            boolean z11 = false;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (z11) {
                    i12 = 46;
                    z10 = false;
                } else {
                    z10 = z11;
                    i12 = bArr2[i19][i20] & 255;
                }
                i13 = i12 - (bArr[i16 + i21] & 255);
                if (i13 == 0) {
                    i21++;
                    i20++;
                    if (i21 == i18) {
                        break;
                    }
                    if (bArr2[i19].length != i20) {
                        z11 = z10;
                    } else {
                        if (i19 == bArr2.length - 1) {
                            break;
                        }
                        i19++;
                        z11 = true;
                        i20 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i13 >= 0) {
                if (i13 <= 0) {
                    int i22 = i18 - i21;
                    int length2 = bArr2[i19].length - i20;
                    while (true) {
                        i19++;
                        if (i19 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i19].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            return new String(bArr, i16, i18, c.f12944j);
                        }
                    }
                }
                i14 = i11 + 1;
            }
            length = i15;
        }
        return null;
    }

    public static PublicSuffixDatabase c() {
        return f10662h;
    }

    public final String[] b(String[] strArr) throws InterruptedException {
        String str;
        String strA;
        String strA2;
        int i10 = 0;
        if (this.f10663a.get() || !this.f10663a.compareAndSet(false, true)) {
            try {
                this.f10664b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            f();
        }
        synchronized (this) {
            if (this.f10665c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            bArr[i11] = strArr[i11].getBytes(c.f12944j);
        }
        int i12 = 0;
        while (true) {
            str = null;
            if (i12 >= length) {
                strA = null;
                break;
            }
            strA = a(this.f10665c, bArr, i12);
            if (strA != null) {
                break;
            }
            i12++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i13 = 0; i13 < bArr2.length - 1; i13++) {
                bArr2[i13] = f10659e;
                strA2 = a(this.f10665c, bArr2, i13);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            while (true) {
                if (i10 >= length - 1) {
                    break;
                }
                String strA3 = a(this.f10666d, bArr, i10);
                if (strA3 != null) {
                    str = strA3;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return f10661g;
        }
        String[] strArrSplit = strA != null ? strA.split("\\.") : f10660f;
        String[] strArrSplit2 = strA2 != null ? strA2.split("\\.") : f10660f;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    public String d(String str) throws InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrB = b(strArrSplit);
        if (strArrSplit.length == strArrB.length && strArrB[0].charAt(0) != '!') {
            return null;
        }
        if (strArrB[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrB.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrB.length + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i10 = length - length2; i10 < strArrSplit2.length; i10++) {
            sb2.append(strArrSplit2[i10]);
            sb2.append('.');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public final void e() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e eVarB = k.b(new i(k.g(resourceAsStream)));
        try {
            byte[] bArr = new byte[eVarB.readInt()];
            eVarB.readFully(bArr);
            byte[] bArr2 = new byte[eVarB.readInt()];
            eVarB.readFully(bArr2);
            synchronized (this) {
                this.f10665c = bArr;
                this.f10666d = bArr2;
            }
            this.f10664b.countDown();
        } finally {
            c.g(eVarB);
        }
    }

    public final void f() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    f.j().p(5, "Failed to read public suffix list", e10);
                    if (!z10) {
                        return;
                    }
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
