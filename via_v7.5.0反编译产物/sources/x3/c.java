package x3;

import com.google.zxing.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f14485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k[] f14486c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f14484a = i10;
        this.f14485b = iArr;
        float f10 = i11;
        float f11 = i13;
        this.f14486c = new k[]{new k(f10, f11), new k(i12, f11)};
    }

    public k[] a() {
        return this.f14486c;
    }

    public int[] b() {
        return this.f14485b;
    }

    public int c() {
        return this.f14484a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f14484a == ((c) obj).f14484a;
    }

    public int hashCode() {
        return this.f14484a;
    }
}
