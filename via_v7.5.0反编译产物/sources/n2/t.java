package n2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t implements h3.d, h3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10567a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f10568b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f10569c;

    public t(Executor executor) {
        this.f10569c = executor;
    }

    @Override // h3.d
    public synchronized void a(Class cls, Executor executor, h3.b bVar) {
        try {
            a0.b(cls);
            a0.b(bVar);
            a0.b(executor);
            if (!this.f10567a.containsKey(cls)) {
                this.f10567a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f10567a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void c() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f10568b;
                if (queue != null) {
                    this.f10568b = null;
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

    public final synchronized Set d(h3.a aVar) {
        throw null;
    }

    public void e(final h3.a aVar) {
        a0.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.f10568b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry entry : d(aVar)) {
                    ((Executor) entry.getValue()).execute(new Runnable(entry, aVar) { // from class: n2.s

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ Map.Entry f10566c;

                        @Override // java.lang.Runnable
                        public final void run() {
                            ((h3.b) this.f10566c.getKey()).a(null);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
