package v3;

import com.google.zxing.ReaderException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f13010c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    public final u f13011a = new u();

    /* renamed from: b, reason: collision with root package name */
    public final v f13012b = new v();

    public com.google.zxing.j a(int i10, s3.a aVar, int i11) {
        int[] iArrN = x.n(aVar, i11, false, f13010c);
        try {
            return this.f13012b.b(i10, aVar, iArrN);
        } catch (ReaderException unused) {
            return this.f13011a.b(i10, aVar, iArrN);
        }
    }
}
