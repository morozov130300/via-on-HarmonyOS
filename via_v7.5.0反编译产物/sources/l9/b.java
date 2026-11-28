package l9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7520g;

    public b() {
        this(null, null);
    }

    public static b i(int i10, String str, String str2) {
        b bVar = new b();
        bVar.m(i10);
        bVar.q(str);
        bVar.o(str2);
        return bVar;
    }

    public static b j(int i10, String str, String str2, long j10) {
        b bVar = new b();
        bVar.m(i10);
        bVar.q(str);
        bVar.o(str2);
        bVar.p(j10);
        return bVar;
    }

    public long a() {
        return this.f7519f;
    }

    public String b() {
        return this.f7517d;
    }

    public int c() {
        return this.f7514a;
    }

    public int d() {
        return this.f7518e;
    }

    public String e() {
        String str = this.f7516c;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f7514a != bVar.f7514a || this.f7518e != bVar.f7518e || this.f7519f != bVar.f7519f || this.f7520g != bVar.f7520g) {
                return false;
            }
            String str = this.f7515b;
            if (str == null ? bVar.f7515b != null : !str.equals(bVar.f7515b)) {
                return false;
            }
            String str2 = this.f7516c;
            if (str2 == null ? bVar.f7516c != null : !str2.equals(bVar.f7516c)) {
                return false;
            }
            String str3 = this.f7517d;
            String str4 = bVar.f7517d;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f7520g;
    }

    public String g() {
        String str = this.f7515b;
        return str == null ? "" : str;
    }

    public boolean h() {
        String str = this.f7515b;
        return str == null || str.isEmpty();
    }

    public int hashCode() {
        int i10 = this.f7514a * 31;
        String str = this.f7515b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f7516c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7517d;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f7518e) * 31;
        long j10 = this.f7519f;
        int i11 = (iHashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f7520g;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public void k(long j10) {
        this.f7519f = j10;
    }

    public void l(String str) {
        this.f7517d = str;
    }

    public void m(int i10) {
        this.f7514a = i10;
    }

    public void n(int i10) {
        this.f7518e = i10;
    }

    public void o(String str) {
        this.f7516c = str;
    }

    public void p(long j10) {
        this.f7520g = j10;
    }

    public void q(String str) {
        this.f7515b = str;
    }

    public String toString() {
        return "HistoryItem{id=" + this.f7514a + ", url='" + this.f7515b + "', title='" + this.f7516c + "', folder='" + this.f7517d + "', order=" + this.f7518e + ", createdAt=" + this.f7519f + ", updatedAt=" + this.f7520g + '}';
    }

    public b(String str, String str2) {
        this(str, str2, null);
    }

    public b(String str, String str2, String str3) {
        this(str, str2, str3, -1, 0L, 0L);
    }

    public b(String str, String str2, String str3, int i10, long j10, long j11) {
        this(0, str, str2, str3, i10, j10, j11);
    }

    public b(int i10, String str, String str2, String str3, int i11, long j10, long j11) {
        this.f7514a = i10;
        this.f7515b = str;
        this.f7516c = str2;
        this.f7517d = str3;
        this.f7518e = i11;
        this.f7519f = j11;
        this.f7520g = j10;
    }
}
