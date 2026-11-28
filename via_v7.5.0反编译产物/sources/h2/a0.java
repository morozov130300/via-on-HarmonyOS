package h2;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5634a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f5635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5636c;

    public final void a(z zVar) {
        synchronized (this.f5634a) {
            try {
                if (this.f5635b == null) {
                    this.f5635b = new ArrayDeque();
                }
                this.f5635b.add(zVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(f fVar) {
        z zVar;
        synchronized (this.f5634a) {
            if (this.f5635b != null && !this.f5636c) {
                this.f5636c = true;
                while (true) {
                    synchronized (this.f5634a) {
                        try {
                            zVar = (z) this.f5635b.poll();
                            if (zVar == null) {
                                this.f5636c = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zVar.a(fVar);
                }
            }
        }
    }
}
