package v5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13405h;

    public n(int i10, String str, boolean z10) {
        this(i10, str, null, z10);
    }

    @Override // v5.q
    public String d() {
        String str = this.f13415c;
        if (str != null) {
            return str;
        }
        return this.f13403f ? this.f13404g : this.f13405h;
    }

    @Override // v5.q, v5.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.f13403f == ((n) obj).f13403f;
    }

    @Override // v5.q, v5.d
    public int hashCode() {
        return (super.hashCode() * 31) + (this.f13403f ? 1 : 0);
    }

    public boolean i() {
        return this.f13403f;
    }

    public void j(boolean z10) {
        this.f13403f = z10;
    }

    public n(int i10, String str, String str2, boolean z10) {
        this(i10, str, str2, z10, false);
    }

    public n(int i10, String str, String str2, String str3, boolean z10) {
        this(i10, str, str2, str3, z10, false);
    }

    public n(int i10, String str, String str2, boolean z10, boolean z11) {
        super(i10, str, str2, z11);
        this.f13403f = z10;
    }

    public n(int i10, String str, String str2, String str3, boolean z10, boolean z11) {
        super(i10, str, null, z11);
        this.f13403f = z10;
        this.f13404g = str2;
        this.f13405h = str3;
    }
}
