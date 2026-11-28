package h2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5670b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f5671c;

    public s(Executor executor, b bVar) {
        this.f5669a = executor;
        this.f5671c = bVar;
    }

    @Override // h2.z
    public final void a(f fVar) {
        if (fVar.i()) {
            synchronized (this.f5670b) {
                try {
                    if (this.f5671c == null) {
                        return;
                    }
                    this.f5669a.execute(new r(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
