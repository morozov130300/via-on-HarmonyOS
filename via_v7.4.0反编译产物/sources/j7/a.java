package j7;

import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements Comparable {

    /* renamed from: m, reason: collision with root package name */
    public static final C0091a f7586m = new C0091a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final a f7587n = b.a();

    /* renamed from: e, reason: collision with root package name */
    public final int f7588e;

    /* renamed from: j, reason: collision with root package name */
    public final int f7589j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7590k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7591l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: j7.a$a, reason: collision with other inner class name */
    public static final class C0091a {
        public C0091a() {
        }

        public /* synthetic */ C0091a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public a(int i10, int i11, int i12) {
        this.f7588e = i10;
        this.f7589j = i11;
        this.f7590k = i12;
        this.f7591l = b(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a other) {
        h.f(other, "other");
        return this.f7591l - other.f7591l;
    }

    public final int b(int i10, int i11, int i12) {
        if (new t7.c(0, 255).k(i10) && new t7.c(0, 255).k(i11) && new t7.c(0, 255).k(i12)) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        a aVar = obj instanceof a ? (a) obj : null;
        return aVar != null && this.f7591l == aVar.f7591l;
    }

    public int hashCode() {
        return this.f7591l;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7588e);
        sb2.append('.');
        sb2.append(this.f7589j);
        sb2.append('.');
        sb2.append(this.f7590k);
        return sb2.toString();
    }
}
