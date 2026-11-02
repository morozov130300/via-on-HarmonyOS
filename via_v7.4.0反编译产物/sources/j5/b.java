package j5;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentLinkedQueue f7574e = null;

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f7574e == null) {
            this.f7574e = new ConcurrentLinkedQueue();
        }
        if (this.f7574e.contains(aVar)) {
            return;
        }
        this.f7574e.add(aVar);
    }

    public void b(a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        if (aVar == null || (concurrentLinkedQueue = this.f7574e) == null || !concurrentLinkedQueue.remove(aVar) || this.f7574e.size() != 0) {
            return;
        }
        this.f7574e = null;
    }

    @Override // j5.a
    public void v(g5.c cVar, long j10, long j11) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f7574e;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((a) it.next()).v(cVar, j10, j11);
        }
    }
}
