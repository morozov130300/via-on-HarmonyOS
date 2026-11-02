package j5;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentLinkedQueue f7575e = null;

    @Override // j5.c
    public void J(g5.c cVar, int i10, int i11) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f7575e;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((c) it.next()).J(cVar, i10, i11);
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f7575e == null) {
            this.f7575e = new ConcurrentLinkedQueue();
        }
        if (this.f7575e.contains(cVar)) {
            return;
        }
        this.f7575e.add(cVar);
    }

    public void b(c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        if (cVar == null || (concurrentLinkedQueue = this.f7575e) == null || !concurrentLinkedQueue.remove(cVar) || this.f7575e.size() != 0) {
            return;
        }
        this.f7575e = null;
    }
}
