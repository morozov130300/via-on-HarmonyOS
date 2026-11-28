package s7;

import e7.y;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0121a f12216n = new C0121a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12217c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12218e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12219m;

    /* JADX INFO: renamed from: s7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0121a {
        public /* synthetic */ C0121a(f fVar) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }

        public C0121a() {
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12217c = i10;
        this.f12218e = k7.c.b(i10, i11, i12);
        this.f12219m = i12;
    }

    public final int c() {
        return this.f12217c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f12217c == aVar.f12217c && this.f12218e == aVar.f12218e && this.f12219m == aVar.f12219m;
    }

    public final int f() {
        return this.f12218e;
    }

    public final int g() {
        return this.f12219m;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public y iterator() {
        return new b(this.f12217c, this.f12218e, this.f12219m);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f12217c * 31) + this.f12218e) * 31) + this.f12219m;
    }

    public boolean isEmpty() {
        if (this.f12219m > 0) {
            return this.f12217c > this.f12218e;
        }
        return this.f12217c < this.f12218e;
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f12219m > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f12217c);
            sb2.append("..");
            sb2.append(this.f12218e);
            sb2.append(" step ");
            i10 = this.f12219m;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f12217c);
            sb2.append(" downTo ");
            sb2.append(this.f12218e);
            sb2.append(" step ");
            i10 = -this.f12219m;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
