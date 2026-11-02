package a6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q extends d {

    /* renamed from: b, reason: collision with root package name */
    public int f130b;

    /* renamed from: c, reason: collision with root package name */
    public String f131c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f132d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f133e;

    public q(int i10, String str) {
        this(i10, str, null);
    }

    public q(int i10, String str, String str2) {
        this(i10, str, str2, false);
    }

    public q(int i10, String str, String str2, boolean z10) {
        super(str);
        this.f130b = i10;
        this.f131c = str2;
        this.f132d = z10;
        this.f133e = false;
    }

    public int c() {
        return this.f130b;
    }

    public String d() {
        return this.f131c;
    }

    public boolean e() {
        return this.f132d;
    }

    @Override // a6.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f130b != qVar.f130b || this.f132d != qVar.f132d || this.f133e != qVar.f133e) {
            return false;
        }
        String str = this.f131c;
        String str2 = qVar.f131c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public boolean f() {
        return this.f133e;
    }

    public void g(boolean z10) {
        this.f132d = z10;
    }

    public void h(String str) {
        this.f131c = str;
    }

    @Override // a6.d
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.f130b) * 31;
        String str = this.f131c;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.f132d ? 1 : 0)) * 31) + (this.f133e ? 1 : 0);
    }
}
