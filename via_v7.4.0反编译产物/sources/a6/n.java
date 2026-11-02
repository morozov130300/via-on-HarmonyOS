package a6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends q {

    /* renamed from: f, reason: collision with root package name */
    public boolean f119f;

    /* renamed from: g, reason: collision with root package name */
    public String f120g;

    /* renamed from: h, reason: collision with root package name */
    public String f121h;

    public n(int i10, String str, String str2, String str3, boolean z10) {
        this(i10, str, str2, str3, z10, false);
    }

    public n(int i10, String str, String str2, String str3, boolean z10, boolean z11) {
        super(i10, str, null, z11);
        this.f119f = z10;
        this.f120g = str2;
        this.f121h = str3;
    }

    public n(int i10, String str, String str2, boolean z10) {
        this(i10, str, str2, z10, false);
    }

    public n(int i10, String str, String str2, boolean z10, boolean z11) {
        super(i10, str, str2, z11);
        this.f119f = z10;
    }

    public n(int i10, String str, boolean z10) {
        this(i10, str, null, z10);
    }

    @Override // a6.q
    public String d() {
        String str = this.f131c;
        return str != null ? str : this.f119f ? this.f120g : this.f121h;
    }

    @Override // a6.q, a6.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && this.f119f == ((n) obj).f119f;
    }

    @Override // a6.q, a6.d
    public int hashCode() {
        return (super.hashCode() * 31) + (this.f119f ? 1 : 0);
    }

    public boolean i() {
        return this.f119f;
    }

    public void j(boolean z10) {
        this.f119f = z10;
    }
}
