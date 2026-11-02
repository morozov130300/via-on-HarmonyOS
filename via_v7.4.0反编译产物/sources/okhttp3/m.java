package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public Runnable f10683c;

    /* renamed from: d, reason: collision with root package name */
    public ExecutorService f10684d;

    /* renamed from: a, reason: collision with root package name */
    public int f10681a = 64;

    /* renamed from: b, reason: collision with root package name */
    public int f10682b = 5;

    /* renamed from: e, reason: collision with root package name */
    public final Deque f10685e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    public final Deque f10686f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final Deque f10687g = new ArrayDeque();

    public synchronized void a() {
        Iterator it = this.f10685e.iterator();
        if (it.hasNext()) {
            n.g.a(it.next());
            throw null;
        }
        Iterator it2 = this.f10686f.iterator();
        if (it2.hasNext()) {
            n.g.a(it2.next());
            throw null;
        }
        Iterator it3 = this.f10687g.iterator();
        while (it3.hasNext()) {
            ((v) it3.next()).cancel();
        }
    }

    public synchronized void b(v vVar) {
        this.f10687g.add(vVar);
    }

    public synchronized ExecutorService c() {
        try {
            if (this.f10684d == null) {
                this.f10684d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), ub.c.G("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10684d;
    }

    public final void d(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f10683c;
        }
        if (f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void e(v vVar) {
        d(this.f10687g, vVar);
    }

    public final boolean f() {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f10685e.iterator();
                while (it.hasNext()) {
                    n.g.a(it.next());
                    if (this.f10686f.size() >= this.f10681a) {
                        break;
                    }
                    if (h(null) < this.f10682b) {
                        it.remove();
                        arrayList.add(null);
                        this.f10686f.add(null);
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
        return this.f10686f.size() + this.f10687g.size();
    }

    public final int h(v.b bVar) {
        Iterator it = this.f10686f.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        n.g.a(it.next());
        throw null;
    }
}
