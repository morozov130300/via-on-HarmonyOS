package j5;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentLinkedQueue f6729c = null;

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f6729c == null) {
            this.f6729c = new ConcurrentLinkedQueue();
        }
        if (this.f6729c.contains(aVar)) {
            return;
        }
        this.f6729c.add(aVar);
    }

    public void b(a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        if (aVar == null || (concurrentLinkedQueue = this.f6729c) == null || !concurrentLinkedQueue.remove(aVar) || this.f6729c.size() != 0) {
            return;
        }
        this.f6729c = null;
    }

    @Override // j5.a
    public void u(g5.c cVar, long j10, long j11) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f6729c;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((a) it.next()).u(cVar, j10, j11);
        }
    }
}
