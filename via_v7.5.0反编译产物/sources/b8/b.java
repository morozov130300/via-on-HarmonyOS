package b8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1774d;

    public int a(boolean z10) {
        return z10 ? this.f1773c : this.f1771a;
    }

    public long b(boolean z10) {
        return z10 ? this.f1774d : this.f1772b;
    }

    public void c(boolean z10, int i10) {
        if (z10) {
            this.f1773c = i10;
        } else {
            this.f1771a = i10;
        }
    }

    public void d(boolean z10, long j10) {
        if (z10) {
            this.f1774d = j10;
        } else {
            this.f1772b = j10;
        }
    }

    public String toString() {
        return "JsAlertRecord{" + this.f1771a + ":" + this.f1772b + ", " + this.f1773c + ":" + this.f1774d + "}";
    }
}
