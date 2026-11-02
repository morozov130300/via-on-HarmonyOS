package r;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final f f11464e = new f(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f11465a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11466b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11467c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11468d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public f(int i10, int i11, int i12, int i13) {
        this.f11465a = i10;
        this.f11466b = i11;
        this.f11467c = i12;
        this.f11468d = i13;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f11465a, fVar2.f11465a), Math.max(fVar.f11466b, fVar2.f11466b), Math.max(fVar.f11467c, fVar2.f11467c), Math.max(fVar.f11468d, fVar2.f11468d));
    }

    public static f b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f11464e : new f(i10, i11, i12, i13);
    }

    public static f c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static f d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f11465a, this.f11466b, this.f11467c, this.f11468d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11468d == fVar.f11468d && this.f11465a == fVar.f11465a && this.f11467c == fVar.f11467c && this.f11466b == fVar.f11466b;
    }

    public int hashCode() {
        return (((((this.f11465a * 31) + this.f11466b) * 31) + this.f11467c) * 31) + this.f11468d;
    }

    public String toString() {
        return "Insets{left=" + this.f11465a + ", top=" + this.f11466b + ", right=" + this.f11467c + ", bottom=" + this.f11468d + '}';
    }
}
