package okio;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static n f10866a;

    /* renamed from: b, reason: collision with root package name */
    public static long f10867b;

    public static void a(n nVar) {
        if (nVar.f10864f != null || nVar.f10865g != null) {
            throw new IllegalArgumentException();
        }
        if (nVar.f10862d) {
            return;
        }
        synchronized (o.class) {
            try {
                long j10 = f10867b;
                if (j10 + 8192 > 65536) {
                    return;
                }
                f10867b = j10 + 8192;
                nVar.f10864f = f10866a;
                nVar.f10861c = 0;
                nVar.f10860b = 0;
                f10866a = nVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static n b() {
        synchronized (o.class) {
            try {
                n nVar = f10866a;
                if (nVar == null) {
                    return new n();
                }
                f10866a = nVar.f10864f;
                nVar.f10864f = null;
                f10867b -= 8192;
                return nVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
