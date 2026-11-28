package v5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13417e;

    public q(int i10, String str) {
        this(i10, str, null);
    }

    public int c() {
        return this.f13414b;
    }

    public String d() {
        return this.f13415c;
    }

    public boolean e() {
        return this.f13416d;
    }

    @Override // v5.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f13414b != qVar.f13414b || this.f13416d != qVar.f13416d || this.f13417e != qVar.f13417e) {
            return false;
        }
        String str = this.f13415c;
        String str2 = qVar.f13415c;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public boolean f() {
        return this.f13417e;
    }

    public void g(boolean z10) {
        this.f13416d = z10;
    }

    public void h(String str) {
        this.f13415c = str;
    }

    @Override // v5.d
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.f13414b) * 31;
        String str = this.f13415c;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.f13416d ? 1 : 0)) * 31) + (this.f13417e ? 1 : 0);
    }

    public q(int i10, String str, String str2) {
        this(i10, str, str2, false);
    }

    public q(int i10, String str, String str2, boolean z10) {
        super(str);
        this.f13414b = i10;
        this.f13415c = str2;
        this.f13416d = z10;
        this.f13417e = false;
    }
}
