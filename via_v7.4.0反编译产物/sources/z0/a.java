package z0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static short a(byte[] bArr, byte[] bArr2, int i10) {
        int i11 = i10 % 8;
        short s10 = (short) (bArr2[i10] & 255);
        return (bArr[i10 / 8] & e.f14553a[i11]) != 0 ? (short) (s10 | 256) : s10;
    }

    public static int b(char c10) {
        int i10 = c10 - '\u4e00';
        return (i10 < 0 || i10 >= 7000) ? (7000 > i10 || i10 >= 14000) ? a(d.f14551a, d.f14552b, c10 - '\u84b0') : a(c.f14549a, c.f14550b, c10 - '\u6958') : a(b.f14547a, b.f14548b, i10);
    }

    public static boolean c(char c10) {
        return ('\u4e00' <= c10 && c10 <= '\u9fa5' && b(c10) > 0) || '\u3007' == c10;
    }

    public static String d(char c10) {
        return c(c10) ? c10 == '\u3007' ? "LING" : e.f14554b[b(c10)] : String.valueOf(c10);
    }
}
