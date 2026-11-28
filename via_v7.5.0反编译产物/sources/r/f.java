package r;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f11874e = new f(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11878d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public f(int i10, int i11, int i12, int i13) {
        this.f11875a = i10;
        this.f11876b = i11;
        this.f11877c = i12;
        this.f11878d = i13;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f11875a, fVar2.f11875a), Math.max(fVar.f11876b, fVar2.f11876b), Math.max(fVar.f11877c, fVar2.f11877c), Math.max(fVar.f11878d, fVar2.f11878d));
    }

    public static f b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f11874e : new f(i10, i11, i12, i13);
    }

    public static f c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static f d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f11875a, this.f11876b, this.f11877c, this.f11878d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11878d == fVar.f11878d && this.f11875a == fVar.f11875a && this.f11877c == fVar.f11877c && this.f11876b == fVar.f11876b;
    }

    public int hashCode() {
        return (((((this.f11875a * 31) + this.f11876b) * 31) + this.f11877c) * 31) + this.f11878d;
    }

    public String toString() {
        return "Insets{left=" + this.f11875a + ", top=" + this.f11876b + ", right=" + this.f11877c + ", bottom=" + this.f11878d + '}';
    }
}
