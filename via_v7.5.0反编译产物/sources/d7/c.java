package d7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f3927o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f3928p = d.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3929c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3930e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3932n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    public c(int i10, int i11, int i12) {
        this.f3929c = i10;
        this.f3930e = i11;
        this.f3931m = i12;
        this.f3932n = d(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c other) {
        kotlin.jvm.internal.h.f(other, "other");
        return this.f3932n - other.f3932n;
    }

    public final int d(int i10, int i11, int i12) {
        if (i10 >= 0 && i10 < 256 && i11 >= 0 && i11 < 256 && i12 >= 0 && i12 < 256) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && this.f3932n == cVar.f3932n;
    }

    public int hashCode() {
        return this.f3932n;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3929c);
        sb2.append('.');
        sb2.append(this.f3930e);
        sb2.append('.');
        sb2.append(this.f3931m);
        return sb2.toString();
    }
}
