package kb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7264c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7265e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7266m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f7267n;

    public b(String str) {
        this(str, -1000, null, null);
    }

    public static b d(String str, ga.c cVar) {
        return cVar == null ? new b(str) : new b(str, cVar.d(), cVar.g(), cVar.a());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        if (this.f7264c == null && bVar.h() == null) {
            return 0;
        }
        return this.f7264c.compareTo(bVar.h());
    }

    public String e() {
        return this.f7267n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f7264c;
            String str2 = ((b) obj).f7264c;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f7266m;
    }

    public int g() {
        return this.f7265e;
    }

    public String h() {
        return this.f7264c;
    }

    public int hashCode() {
        String str = this.f7264c;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void i(String str) {
        this.f7267n = str;
    }

    public ga.c j() {
        return ga.c.l(g(), f(), e());
    }

    public b(String str, int i10, String str2, String str3) {
        this.f7264c = str;
        this.f7265e = i10;
        this.f7266m = str2;
        this.f7267n = str3;
    }
}
