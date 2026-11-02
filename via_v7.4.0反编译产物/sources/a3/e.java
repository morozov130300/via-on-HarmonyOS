package a3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f58a;

    /* renamed from: b, reason: collision with root package name */
    public final String f59b;

    /* renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f60c;

    /* renamed from: d, reason: collision with root package name */
    public final e f61d;

    public e(Throwable th, d dVar) {
        this.f58a = th.getLocalizedMessage();
        this.f59b = th.getClass().getName();
        this.f60c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f61d = cause != null ? new e(cause, dVar) : null;
    }
}
