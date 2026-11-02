package rb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f11646a;

    /* renamed from: b, reason: collision with root package name */
    public String f11647b;

    /* renamed from: c, reason: collision with root package name */
    public Throwable f11648c;

    public f(int i10, String str, Throwable th) {
        this.f11646a = i10;
        this.f11647b = str;
        this.f11648c = th;
    }

    public String a() {
        String strB = b();
        if (strB == null) {
            strB = "No message";
        }
        int i10 = this.f11646a;
        return (i10 != 101 ? i10 != 201 ? i10 != 301 ? "" : "Cannot pull: " : "Cannot push: " : "Cannot merge: ") + strB;
    }

    public String b() {
        Throwable th;
        String str = this.f11647b;
        return (str != null || (th = this.f11648c) == null) ? str : th.getMessage();
    }

    public String toString() {
        return "SyncingError{code=" + this.f11646a + ", message='" + this.f11647b + "', exception=" + this.f11648c + '}';
    }
}
