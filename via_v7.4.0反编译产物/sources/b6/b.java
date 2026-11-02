package b6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f1824a;

    /* renamed from: b, reason: collision with root package name */
    public String f1825b;

    /* renamed from: c, reason: collision with root package name */
    public int f1826c;

    /* renamed from: d, reason: collision with root package name */
    public int f1827d;

    public b(int i10, String str, int i11, int i12) {
        this.f1824a = i10;
        this.f1825b = str;
        this.f1827d = i11;
        this.f1826c = i12;
    }

    public int a() {
        return this.f1826c;
    }

    public String b() {
        return this.f1825b;
    }

    public boolean c() {
        return this.f1826c == 0;
    }

    public boolean d() {
        return this.f1826c == this.f1827d - 1;
    }

    public String toString() {
        return "SectionInfo{id=" + this.f1824a + ", title='" + this.f1825b + "', itemPosition=" + this.f1826c + ", size=" + this.f1827d + '}';
    }
}
