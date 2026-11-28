package d4;

import b4.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f3912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f3913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f3914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3915d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f3916e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public b a() {
        return this.f3916e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f3913b = errorCorrectionLevel;
    }

    public void d(int i10) {
        this.f3915d = i10;
    }

    public void e(b bVar) {
        this.f3916e = bVar;
    }

    public void f(Mode mode) {
        this.f3912a = mode;
    }

    public void g(f fVar) {
        this.f3914c = fVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f3912a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f3913b);
        sb2.append("\n version: ");
        sb2.append(this.f3914c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f3915d);
        if (this.f3916e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f3916e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
