package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1965c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f1966d = new c0(0, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1968b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final c0 a() {
            return c0.f1966d;
        }

        public a() {
        }
    }

    public c0(int i10, String str) {
        this.f1967a = i10;
        this.f1968b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f1967a == c0Var.f1967a && kotlin.jvm.internal.h.a(this.f1968b, c0Var.f1968b);
    }

    public int hashCode() {
        int i10 = this.f1967a * 31;
        String str = this.f1968b;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Error(code=" + this.f1967a + ", message=" + this.f1968b + ')';
    }

    public /* synthetic */ c0(int i10, String str, int i11, kotlin.jvm.internal.f fVar) {
        this(i10, (i11 & 2) != 0 ? null : str);
    }
}
