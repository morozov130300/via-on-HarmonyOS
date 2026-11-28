package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5675b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f5676c;

    public u(Executor executor, c cVar) {
        this.f5674a = executor;
        this.f5676c = cVar;
    }

    @Override // h2.z
    public final void a(f fVar) {
        if (fVar.k() || fVar.i()) {
            return;
        }
        synchronized (this.f5675b) {
            try {
                if (this.f5676c == null) {
                    return;
                }
                this.f5674a.execute(new t(this, fVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
