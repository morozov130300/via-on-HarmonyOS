package d8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f4585a;

    /* renamed from: b, reason: collision with root package name */
    public long f4586b;

    /* renamed from: c, reason: collision with root package name */
    public int f4587c;

    /* renamed from: d, reason: collision with root package name */
    public long f4588d;

    public int a(boolean z10) {
        return z10 ? this.f4587c : this.f4585a;
    }

    public long b(boolean z10) {
        return z10 ? this.f4588d : this.f4586b;
    }

    public void c(boolean z10, int i10) {
        if (z10) {
            this.f4587c = i10;
        } else {
            this.f4585a = i10;
        }
    }

    public void d(boolean z10, long j10) {
        if (z10) {
            this.f4588d = j10;
        } else {
            this.f4586b = j10;
        }
    }

    public String toString() {
        return "JsAlertRecord{" + this.f4585a + ":" + this.f4586b + ", " + this.f4587c + ":" + this.f4588d + "}";
    }
}
