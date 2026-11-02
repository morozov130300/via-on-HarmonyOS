package n9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f10260a;

    /* renamed from: b, reason: collision with root package name */
    public String f10261b;

    /* renamed from: c, reason: collision with root package name */
    public String f10262c;

    /* renamed from: d, reason: collision with root package name */
    public String f10263d;

    /* renamed from: e, reason: collision with root package name */
    public int f10264e;

    /* renamed from: f, reason: collision with root package name */
    public long f10265f;

    /* renamed from: g, reason: collision with root package name */
    public long f10266g;

    public b() {
        this(null, null);
    }

    public b(int i10, String str, String str2, String str3, int i11, long j10, long j11) {
        this.f10260a = i10;
        this.f10261b = str;
        this.f10262c = str2;
        this.f10263d = str3;
        this.f10264e = i11;
        this.f10265f = j11;
        this.f10266g = j10;
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
        return this.f10265f;
    }

    public String b() {
        return this.f10263d;
    }

    public int c() {
        return this.f10260a;
    }

    public int d() {
        return this.f10264e;
    }

    public String e() {
        String str = this.f10262c;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f10260a != bVar.f10260a || this.f10264e != bVar.f10264e || this.f10265f != bVar.f10265f || this.f10266g != bVar.f10266g) {
                return false;
            }
            String str = this.f10261b;
            if (str == null ? bVar.f10261b != null : !str.equals(bVar.f10261b)) {
                return false;
            }
            String str2 = this.f10262c;
            if (str2 == null ? bVar.f10262c != null : !str2.equals(bVar.f10262c)) {
                return false;
            }
            String str3 = this.f10263d;
            String str4 = bVar.f10263d;
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
        return this.f10266g;
    }

    public String g() {
        String str = this.f10261b;
        return str == null ? "" : str;
    }

    public boolean h() {
        String str = this.f10261b;
        return str == null || str.isEmpty();
    }

    public int hashCode() {
        int i10 = this.f10260a * 31;
        String str = this.f10261b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10262c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10263d;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f10264e) * 31;
        long j10 = this.f10265f;
        int i11 = (iHashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f10266g;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public void k(long j10) {
        this.f10265f = j10;
    }

    public void l(String str) {
        this.f10263d = str;
    }

    public void m(int i10) {
        this.f10260a = i10;
    }

    public void n(int i10) {
        this.f10264e = i10;
    }

    public void o(String str) {
        this.f10262c = str;
    }

    public void p(long j10) {
        this.f10266g = j10;
    }

    public void q(String str) {
        this.f10261b = str;
    }

    public String toString() {
        return "HistoryItem{id=" + this.f10260a + ", url='" + this.f10261b + "', title='" + this.f10262c + "', folder='" + this.f10263d + "', order=" + this.f10264e + ", createdAt=" + this.f10265f + ", updatedAt=" + this.f10266g + '}';
    }
}
