package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f11298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f11299d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11296a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11297b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque f11300e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Deque f11301f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque f11302g = new ArrayDeque();

    public synchronized void a() {
        Iterator it = this.f11300e.iterator();
        if (it.hasNext()) {
            n.g.a(it.next());
            throw null;
        }
        Iterator it2 = this.f11301f.iterator();
        if (it2.hasNext()) {
            n.g.a(it2.next());
            throw null;
        }
        Iterator it3 = this.f11302g.iterator();
        while (it3.hasNext()) {
            ((v) it3.next()).cancel();
        }
    }

    public synchronized void b(v vVar) {
        this.f11302g.add(vVar);
    }

    public synchronized ExecutorService c() {
        try {
            if (this.f11299d == null) {
                this.f11299d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), ub.c.G("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f11299d;
    }

    public final void d(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f11298c;
        }
        if (f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void e(v vVar) {
        d(this.f11302g, vVar);
    }

    public final boolean f() {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f11300e.iterator();
                while (it.hasNext()) {
                    n.g.a(it.next());
                    if (this.f11301f.size() >= this.f11296a) {
                        break;
                    }
                    if (h(null) < this.f11297b) {
                        it.remove();
                        arrayList.add(null);
                        this.f11301f.add(null);
                    }
                }
                z10 = g() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList.size() <= 0) {
            return z10;
        }
        n.g.a(arrayList.get(0));
        c();
        throw null;
    }

    public synchronized int g() {
        return this.f11301f.size() + this.f11302g.size();
    }

    public final int h(v.b bVar) {
        Iterator it = this.f11301f.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        n.g.a(it.next());
        throw null;
    }
}
