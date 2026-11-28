package j5;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentLinkedQueue f6730c = null;

    @Override // j5.c
    public void I(g5.c cVar, int i10, int i11) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f6730c;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((c) it.next()).I(cVar, i10, i11);
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f6730c == null) {
            this.f6730c = new ConcurrentLinkedQueue();
        }
        if (this.f6730c.contains(cVar)) {
            return;
        }
        this.f6730c.add(cVar);
    }

    public void b(c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        if (cVar == null || (concurrentLinkedQueue = this.f6730c) == null || !concurrentLinkedQueue.remove(cVar) || this.f6730c.size() != 0) {
            return;
        }
        this.f6730c = null;
    }
}
