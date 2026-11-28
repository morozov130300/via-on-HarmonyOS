package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5680b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f5681c;

    public w(Executor executor, d dVar) {
        this.f5679a = executor;
        this.f5681c = dVar;
    }

    @Override // h2.z
    public final void a(f fVar) {
        if (fVar.k()) {
            synchronized (this.f5680b) {
                try {
                    if (this.f5681c == null) {
                        return;
                    }
                    this.f5679a.execute(new v(this, fVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
