package rb;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f12128c;

    public f(int i10, String str, Throwable th) {
        this.f12126a = i10;
        this.f12127b = str;
        this.f12128c = th;
    }

    public String a() {
        String str;
        String strB = b();
        if (strB == null) {
            strB = "No message";
        }
        int i10 = this.f12126a;
        if (i10 == 101) {
            str = "Cannot merge: ";
        } else if (i10 != 201) {
            str = i10 != 301 ? "" : "Cannot pull: ";
        } else {
            str = "Cannot push: ";
        }
        return str + strB;
    }

    public String b() {
        Throwable th;
        String str = this.f12127b;
        return (str != null || (th = this.f12128c) == null) ? str : th.getMessage();
    }

    public String toString() {
        return "SyncingError{code=" + this.f12126a + ", message='" + this.f12127b + "', exception=" + this.f12128c + '}';
    }
}
