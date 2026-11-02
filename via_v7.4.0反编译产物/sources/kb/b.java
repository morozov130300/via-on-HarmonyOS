package kb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public String f8256e;

    /* renamed from: j, reason: collision with root package name */
    public int f8257j;

    /* renamed from: k, reason: collision with root package name */
    public String f8258k;

    /* renamed from: l, reason: collision with root package name */
    public String f8259l;

    public b(String str) {
        this(str, -1000, null, null);
    }

    public b(String str, int i10, String str2, String str3) {
        this.f8256e = str;
        this.f8257j = i10;
        this.f8258k = str2;
        this.f8259l = str3;
    }

    public static b b(String str, ja.c cVar) {
        return cVar == null ? new b(str) : new b(str, cVar.d(), cVar.g(), cVar.a());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        if (this.f8256e == null && bVar.f() == null) {
            return 0;
        }
        return this.f8256e.compareTo(bVar.f());
    }

    public String c() {
        return this.f8259l;
    }

    public String d() {
        return this.f8258k;
    }

    public int e() {
        return this.f8257j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f8256e;
            String str2 = ((b) obj).f8256e;
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
        return this.f8256e;
    }

    public void g(String str) {
        this.f8259l = str;
    }

    public ja.c h() {
        return ja.c.l(e(), d(), c());
    }

    public int hashCode() {
        String str = this.f8256e;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
