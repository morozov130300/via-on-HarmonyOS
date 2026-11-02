package t7;

import k7.v;
import kotlin.jvm.internal.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public static final C0125a f12273l = new C0125a(null);

    /* renamed from: e, reason: collision with root package name */
    public final int f12274e;

    /* renamed from: j, reason: collision with root package name */
    public final int f12275j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12276k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: t7.a$a, reason: collision with other inner class name */
    public static final class C0125a {
        public C0125a() {
        }

        public /* synthetic */ C0125a(f fVar) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12274e = i10;
        this.f12275j = m7.c.b(i10, i11, i12);
        this.f12276k = i12;
    }

    public final int c() {
        return this.f12274e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f12274e == aVar.f12274e && this.f12275j == aVar.f12275j && this.f12276k == aVar.f12276k;
    }

    public final int f() {
        return this.f12275j;
    }

    public final int g() {
        return this.f12276k;
    }

    @Override // java.lang.Iterable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public v iterator() {
        return new b(this.f12274e, this.f12275j, this.f12276k);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f12274e * 31) + this.f12275j) * 31) + this.f12276k;
    }

    public boolean isEmpty() {
        return this.f12276k > 0 ? this.f12274e > this.f12275j : this.f12274e < this.f12275j;
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f12276k > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f12274e);
            sb2.append("..");
            sb2.append(this.f12275j);
            sb2.append(" step ");
            i10 = this.f12276k;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f12274e);
            sb2.append(" downTo ");
            sb2.append(this.f12275j);
            sb2.append(" step ");
            i10 = -this.f12276k;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
