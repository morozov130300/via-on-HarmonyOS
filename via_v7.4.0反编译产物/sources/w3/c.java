package w3;

import com.google.zxing.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f13236a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f13237b;

    /* renamed from: c, reason: collision with root package name */
    public final k[] f13238c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f13236a = i10;
        this.f13237b = iArr;
        float f10 = i11;
        float f11 = i13;
        this.f13238c = new k[]{new k(f10, f11), new k(i12, f11)};
    }

    public k[] a() {
        return this.f13238c;
    }

    public int[] b() {
        return this.f13237b;
    }

    public int c() {
        return this.f13236a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f13236a == ((c) obj).f13236a;
    }

    public int hashCode() {
        return this.f13236a;
    }
}
