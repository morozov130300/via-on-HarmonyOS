package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a5 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e5 f4645b;

    public a5(e5 e5Var, String str) {
        this.f4645b = e5Var;
        u1.f.h(str);
        this.f4644a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f4645b.f4646a.d().r().b(this.f4644a, th);
    }
}
