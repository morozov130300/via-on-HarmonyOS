package m2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f8599a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8600b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8601c;

    public r(Class cls, int i10, int i11) {
        this(b0.b(cls), i10, i11);
    }

    public r(b0 b0Var, int i10, int i11) {
        this.f8599a = (b0) a0.c(b0Var, "Null dependency anInterface.");
        this.f8600b = i10;
        this.f8601c = i11;
    }

    public static r a(Class cls) {
        return new r(cls, 0, 2);
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return "provider";
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    public static r h(Class cls) {
        return new r(cls, 0, 1);
    }

    public static r i(Class cls) {
        return new r(cls, 1, 0);
    }

    public static r j(b0 b0Var) {
        return new r(b0Var, 1, 0);
    }

    public static r k(Class cls) {
        return new r(cls, 1, 1);
    }

    public static r l(Class cls) {
        return new r(cls, 2, 0);
    }

    public b0 c() {
        return this.f8599a;
    }

    public boolean d() {
        return this.f8601c == 2;
    }

    public boolean e() {
        return this.f8601c == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f8599a.equals(rVar.f8599a) && this.f8600b == rVar.f8600b && this.f8601c == rVar.f8601c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f8600b == 1;
    }

    public boolean g() {
        return this.f8600b == 2;
    }

    public int hashCode() {
        return ((((this.f8599a.hashCode() ^ 1000003) * 1000003) ^ this.f8600b) * 1000003) ^ this.f8601c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f8599a);
        sb2.append(", type=");
        int i10 = this.f8600b;
        sb2.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb2.append(", injection=");
        sb2.append(b(this.f8601c));
        sb2.append("}");
        return sb2.toString();
    }
}
