package p9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f11021a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11022b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11023c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f11024d;

    public g(int i10, e eVar, String str, Throwable th) {
        this.f11021a = i10;
        this.f11022b = eVar;
        this.f11023c = str;
        this.f11024d = th;
    }

    public static g a(int i10, Throwable th) {
        return new g(i10, null, null, th);
    }

    public static g b(Throwable th) {
        return new g(100, null, null, th);
    }

    public static g c(e eVar, String str, Throwable th) {
        return new g(100, eVar, str, th);
    }

    public static g k(e eVar, String str) {
        return new g(1, eVar, str, null);
    }

    public static g l(e eVar) {
        return new g(0, eVar, null, null);
    }

    public e d() {
        return this.f11022b;
    }

    public String e() {
        return this.f11023c;
    }

    public int f() {
        return this.f11021a;
    }

    public Throwable g() {
        return this.f11024d;
    }

    public boolean h() {
        return (i() || j()) ? false : true;
    }

    public boolean i() {
        return this.f11021a == 1;
    }

    public boolean j() {
        return this.f11021a == 0;
    }

    public String toString() {
        return "ChatStreamResponse{status=" + this.f11021a + ", chatMessage=" + this.f11022b + ", finishReason='" + this.f11023c + "', throwable=" + this.f11024d + '}';
    }
}
