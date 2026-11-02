package y3;

import com.google.zxing.FormatException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o extends p {

    /* renamed from: b, reason: collision with root package name */
    public final int f14440b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14441c;

    public o(int i10, int i11, int i12) throws FormatException {
        super(i10);
        if (i11 < 0 || i11 > 10 || i12 < 0 || i12 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f14440b = i11;
        this.f14441c = i12;
    }

    public int b() {
        return this.f14440b;
    }

    public int c() {
        return this.f14441c;
    }

    public boolean d() {
        return this.f14440b == 10;
    }

    public boolean e() {
        return this.f14441c == 10;
    }
}
