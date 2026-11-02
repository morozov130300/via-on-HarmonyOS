package c4;

import a4.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Mode f2285a;

    /* renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f2286b;

    /* renamed from: c, reason: collision with root package name */
    public f f2287c;

    /* renamed from: d, reason: collision with root package name */
    public int f2288d = -1;

    /* renamed from: e, reason: collision with root package name */
    public b f2289e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public b a() {
        return this.f2289e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f2286b = errorCorrectionLevel;
    }

    public void d(int i10) {
        this.f2288d = i10;
    }

    public void e(b bVar) {
        this.f2289e = bVar;
    }

    public void f(Mode mode) {
        this.f2285a = mode;
    }

    public void g(f fVar) {
        this.f2287c = fVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f2285a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f2286b);
        sb2.append("\n version: ");
        sb2.append(this.f2287c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f2288d);
        if (this.f2289e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f2289e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
