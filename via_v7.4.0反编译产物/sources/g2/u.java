package g2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u implements z {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6177a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6178b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public c f6179c;

    public u(Executor executor, c cVar) {
        this.f6177a = executor;
        this.f6179c = cVar;
    }

    @Override // g2.z
    public final void a(f fVar) {
        if (fVar.k() || fVar.i()) {
            return;
        }
        synchronized (this.f6178b) {
            try {
                if (this.f6179c == null) {
                    return;
                }
                this.f6177a.execute(new t(this, fVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
