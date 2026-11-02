package okhttp3;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import wb.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: g, reason: collision with root package name */
    public static final Executor f10636g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), ub.c.G("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    public final int f10637a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10638b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f10639c;

    /* renamed from: d, reason: collision with root package name */
    public final Deque f10640d;

    /* renamed from: e, reason: collision with root package name */
    public final wb.d f10641e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10642f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            while (true) {
                long jA = h.this.a(System.nanoTime());
                if (jA == -1) {
                    return;
                }
                if (jA > 0) {
                    long j10 = jA / 1000000;
                    long j11 = jA - (1000000 * j10);
                    synchronized (h.this) {
                        try {
                            h.this.wait(j10, (int) j11);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public h() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public h(int i10, long j10, TimeUnit timeUnit) {
        this.f10639c = new a();
        this.f10640d = new ArrayDeque();
        this.f10641e = new wb.d();
        this.f10637a = i10;
        this.f10638b = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    public long a(long j10) throws IOException {
        synchronized (this) {
            try {
                wb.c cVar = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                for (wb.c cVar2 : this.f10640d) {
                    if (f(cVar2, j10) > 0) {
                        i11++;
                    } else {
                        i10++;
                        long j12 = j10 - cVar2.f13425o;
                        if (j12 > j11) {
                            cVar = cVar2;
                            j11 = j12;
                        }
                    }
                }
                long j13 = this.f10638b;
                if (j11 < j13 && i10 <= this.f10637a) {
                    if (i10 > 0) {
                        return j13 - j11;
                    }
                    if (i11 > 0) {
                        return j13;
                    }
                    this.f10642f = false;
                    return -1L;
                }
                this.f10640d.remove(cVar);
                ub.c.h(cVar.q());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b(wb.c cVar) {
        if (cVar.f13421k || this.f10637a == 0) {
            this.f10640d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public Socket c(okhttp3.a aVar, wb.f fVar) {
        for (wb.c cVar : this.f10640d) {
            if (cVar.l(aVar, null) && cVar.n() && cVar != fVar.d()) {
                return fVar.m(cVar);
            }
        }
        return null;
    }

    public void d() throws IOException {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f10640d.iterator();
                while (it.hasNext()) {
                    wb.c cVar = (wb.c) it.next();
                    if (cVar.f13424n.isEmpty()) {
                        cVar.f13421k = true;
                        arrayList.add(cVar);
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ub.c.h(((wb.c) it2.next()).q());
        }
    }

    public wb.c e(okhttp3.a aVar, wb.f fVar, a0 a0Var) {
        for (wb.c cVar : this.f10640d) {
            if (cVar.l(aVar, a0Var)) {
                fVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    public final int f(wb.c cVar, long j10) {
        List list = cVar.f13424n;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference reference = (Reference) list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                ac.f.j().q("A connection to " + cVar.p().a().l() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f13451a);
                list.remove(i10);
                cVar.f13421k = true;
                if (list.isEmpty()) {
                    cVar.f13425o = j10 - this.f10638b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public void g(wb.c cVar) {
        if (!this.f10642f) {
            this.f10642f = true;
            f10636g.execute(this.f10639c);
        }
        this.f10640d.add(cVar);
    }
}
