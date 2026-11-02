package m2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t implements g3.d, g3.c {

    /* renamed from: a, reason: collision with root package name */
    public final Map f8603a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Queue f8604b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f8605c;

    public t(Executor executor) {
        this.f8605c = executor;
    }

    @Override // g3.d
    public synchronized void a(Class cls, Executor executor, g3.b bVar) {
        try {
            a0.b(cls);
            a0.b(bVar);
            a0.b(executor);
            if (!this.f8603a.containsKey(cls)) {
                this.f8603a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f8603a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void c() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f8604b;
                if (queue != null) {
                    this.f8604b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                n.g.a(it.next());
                e(null);
            }
        }
    }

    public final synchronized Set d(g3.a aVar) {
        throw null;
    }

    public void e(final g3.a aVar) {
        a0.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.f8604b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry entry : d(aVar)) {
                    ((Executor) entry.getValue()).execute(new Runnable(entry, aVar) { // from class: m2.s

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ Map.Entry f8602e;

                        @Override // java.lang.Runnable
                        public final void run() {
                            ((g3.b) this.f8602e.getKey()).a(null);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
