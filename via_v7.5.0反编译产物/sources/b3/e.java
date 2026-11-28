package b3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f1727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f1728d;

    public e(Throwable th, d dVar) {
        this.f1725a = th.getLocalizedMessage();
        this.f1726b = th.getClass().getName();
        this.f1727c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f1728d = cause != null ? new e(cause, dVar) : null;
    }
}
