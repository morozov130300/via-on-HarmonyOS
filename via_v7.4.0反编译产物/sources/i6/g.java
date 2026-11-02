package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f6992a = new g();

    public final boolean a(int i10) {
        double d10 = (i10 >> 16) & 255;
        Double.isNaN(d10);
        double d11 = (i10 >> 8) & 255;
        Double.isNaN(d11);
        double d12 = (d10 * 0.299d) + (d11 * 0.587d);
        double d13 = i10 & 255;
        Double.isNaN(d13);
        return d12 + (d13 * 0.114d) >= 192.0d;
    }

    public final int b(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return (((int) (((i10 & 255) * f10) + ((i11 & 255) * f11))) & 255) | (-16777216) | ((((int) ((((i10 >> 16) & 255) * f10) + (((i11 >> 16) & 255) * f11))) & 255) << 16) | ((((int) ((((i10 >> 8) & 255) * f10) + (((i11 >> 8) & 255) * f11))) & 255) << 8);
    }
}
