package z7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.a f15212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15214c;

    public a(m9.a aVar, int i10, boolean z10) {
        this.f15212a = aVar;
        this.f15213b = i10;
        this.f15214c = z10;
    }

    public m9.a a() {
        return this.f15212a;
    }

    public int b() {
        return this.f15213b;
    }

    public boolean c() {
        return this.f15214c;
    }

    public void d(boolean z10) {
        this.f15214c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f15213b == aVar.f15213b && this.f15214c == aVar.f15214c && x8.t1.a(this.f15212a, aVar.f15212a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return x8.t1.b(this.f15212a, Integer.valueOf(this.f15213b), Boolean.valueOf(this.f15214c));
    }

    public String toString() {
        return "BookmarkFolderWrapper{folder=" + this.f15212a + ", level=" + this.f15213b + ", selected=" + this.f15214c + '}';
    }
}
