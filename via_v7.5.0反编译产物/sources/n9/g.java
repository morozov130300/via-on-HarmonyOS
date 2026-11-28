package n9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f10751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f10753d;

    public g(int i10, e eVar, String str, Throwable th) {
        this.f10750a = i10;
        this.f10751b = eVar;
        this.f10752c = str;
        this.f10753d = th;
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
        return this.f10751b;
    }

    public String e() {
        return this.f10752c;
    }

    public int f() {
        return this.f10750a;
    }

    public Throwable g() {
        return this.f10753d;
    }

    public boolean h() {
        return (i() || j()) ? false : true;
    }

    public boolean i() {
        return this.f10750a == 1;
    }

    public boolean j() {
        return this.f10750a == 0;
    }

    public String toString() {
        return "ChatStreamResponse{status=" + this.f10750a + ", chatMessage=" + this.f10751b + ", finishReason='" + this.f10752c + "', throwable=" + this.f10753d + '}';
    }
}
