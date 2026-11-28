package w5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13658d;

    public b(int i10, String str, int i11, int i12) {
        this.f13655a = i10;
        this.f13656b = str;
        this.f13658d = i11;
        this.f13657c = i12;
    }

    public int a() {
        return this.f13657c;
    }

    public String b() {
        return this.f13656b;
    }

    public boolean c() {
        return this.f13657c == 0;
    }

    public boolean d() {
        return this.f13657c == this.f13658d - 1;
    }

    public String toString() {
        return "SectionInfo{id=" + this.f13655a + ", title='" + this.f13656b + "', itemPosition=" + this.f13657c + ", size=" + this.f13658d + '}';
    }
}
