package w3;

import com.google.zxing.ReaderException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13625c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f13626a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f13627b = new v();

    public com.google.zxing.j a(int i10, t3.a aVar, int i11) {
        int[] iArrN = x.n(aVar, i11, false, f13625c);
        try {
            return this.f13627b.b(i10, aVar, iArrN);
        } catch (ReaderException unused) {
            return this.f13626a.b(i10, aVar, iArrN);
        }
    }
}
