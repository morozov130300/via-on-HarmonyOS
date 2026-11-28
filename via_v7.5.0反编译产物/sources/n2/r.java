package n2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f10563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10565c;

    public r(Class cls, int i10, int i11) {
        this(b0.b(cls), i10, i11);
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
        return this.f10563a;
    }

    public boolean d() {
        return this.f10565c == 2;
    }

    public boolean e() {
        return this.f10565c == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f10563a.equals(rVar.f10563a) && this.f10564b == rVar.f10564b && this.f10565c == rVar.f10565c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f10564b == 1;
    }

    public boolean g() {
        return this.f10564b == 2;
    }

    public int hashCode() {
        return ((((this.f10563a.hashCode() ^ 1000003) * 1000003) ^ this.f10564b) * 1000003) ^ this.f10565c;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f10563a);
        sb2.append(", type=");
        int i10 = this.f10564b;
        if (i10 == 1) {
            str = "required";
        } else {
            str = i10 == 0 ? "optional" : "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        sb2.append(b(this.f10565c));
        sb2.append("}");
        return sb2.toString();
    }

    public r(b0 b0Var, int i10, int i11) {
        this.f10563a = (b0) a0.c(b0Var, "Null dependency anInterface.");
        this.f10564b = i10;
        this.f10565c = i11;
    }
}
