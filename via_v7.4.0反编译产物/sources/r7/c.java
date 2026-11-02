package r7;

import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static final String a(Object from, Object until) {
        h.f(from, "from");
        h.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(double d10, double d11) {
        if (d11 <= d10) {
            throw new IllegalArgumentException(a(Double.valueOf(d10), Double.valueOf(d11)).toString());
        }
    }

    public static final void c(int i10, int i11) {
        if (i11 <= i10) {
            throw new IllegalArgumentException(a(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final void d(long j10, long j11) {
        if (j11 <= j10) {
            throw new IllegalArgumentException(a(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int e(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final int f(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
