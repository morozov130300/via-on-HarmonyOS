package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture implements Future {

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f549l = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: m, reason: collision with root package name */
    public static final Logger f550m = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: n, reason: collision with root package name */
    public static final b f551n;

    /* renamed from: o, reason: collision with root package name */
    public static final Object f552o;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f553e;

    /* renamed from: j, reason: collision with root package name */
    public volatile d f554j;

    /* renamed from: k, reason: collision with root package name */
    public volatile g f555k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f556b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f557a;

        public Failure(Throwable th) {
            this.f557a = (Throwable) AbstractResolvableFuture.d(th);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f558c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f559d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f560a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f561b;

        static {
            if (AbstractResolvableFuture.f549l) {
                f559d = null;
                f558c = null;
            } else {
                f559d = new c(false, null);
                f558c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f560a = z10;
            this.f561b = th;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final d f562d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f563a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f564b;

        /* renamed from: c, reason: collision with root package name */
        public d f565c;

        public d(Runnable runnable, Executor executor) {
            this.f563a = runnable;
            this.f564b = executor;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f566a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f567b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f568c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f569d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f570e;

        public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f566a = atomicReferenceFieldUpdater;
            this.f567b = atomicReferenceFieldUpdater2;
            this.f568c = atomicReferenceFieldUpdater3;
            this.f569d = atomicReferenceFieldUpdater4;
            this.f570e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            return l.a.a(this.f569d, abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            return l.a.a(this.f570e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2) {
            return l.a.a(this.f568c, abstractResolvableFuture, gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            this.f567b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            this.f566a.lazySet(gVar, thread);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f554j != dVar) {
                        return false;
                    }
                    abstractResolvableFuture.f554j = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f553e != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f553e = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f555k != gVar) {
                        return false;
                    }
                    abstractResolvableFuture.f555k = gVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            gVar.f573b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            gVar.f572a = thread;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        public static final g f571c = new g(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f572a;

        /* renamed from: b, reason: collision with root package name */
        public volatile g f573b;

        public g() {
            AbstractResolvableFuture.f551n.e(this, Thread.currentThread());
        }

        public g(boolean z10) {
        }

        public void a(g gVar) {
            AbstractResolvableFuture.f551n.d(this, gVar);
        }

        public void b() {
            Thread thread = this.f572a;
            if (thread != null) {
                this.f572a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "k"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, "j"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "e"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f551n = fVar;
        if (th != null) {
            f550m.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f552o = new Object();
    }

    public static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void f(AbstractResolvableFuture abstractResolvableFuture) {
        abstractResolvableFuture.l();
        abstractResolvableFuture.b();
        d dVarE = abstractResolvableFuture.e(null);
        while (dVarE != null) {
            d dVar = dVarE.f565c;
            g(dVarE.f563a, dVarE.f564b);
            dVarE = dVar;
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f550m.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object i(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object objI = i(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(p(objI));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f553e;
        if (obj == null) {
            if (f551n.b(this, obj, f549l ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f558c : c.f559d)) {
                if (z10) {
                    j();
                }
                f(this);
                return true;
            }
        }
        return false;
    }

    public final d e(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f554j;
        } while (!f551n.a(this, dVar2, d.f562d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f565c;
            dVar4.f565c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f553e;
        if (obj2 != null) {
            return h(obj2);
        }
        g gVar = this.f555k;
        if (gVar != g.f571c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f551n.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f553e;
                    } while (!(obj != null));
                    return h(obj);
                }
                gVar = this.f555k;
            } while (gVar != g.f571c);
        }
        return h(this.f553e);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f553e;
        if (obj != null) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f555k;
            if (gVar != g.f571c) {
                g gVar2 = new g();
                do {
                    gVar2.a(gVar);
                    if (f551n.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                m(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f553e;
                            if (obj2 != null) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m(gVar2);
                    } else {
                        gVar = this.f555k;
                    }
                } while (gVar != g.f571c);
            }
            return h(this.f553e);
        }
        while (nanos > 0) {
            Object obj3 = this.f553e;
            if (obj3 != null) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    public final Object h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f561b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f557a);
        }
        if (obj == f552o) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f553e instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f553e != null;
    }

    public void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String k() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void l() {
        g gVar;
        do {
            gVar = this.f555k;
        } while (!f551n.c(this, gVar, g.f571c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f573b;
        }
    }

    public final void m(g gVar) {
        gVar.f572a = null;
        while (true) {
            g gVar2 = this.f555k;
            if (gVar2 == g.f571c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f573b;
                if (gVar2.f572a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f573b = gVar4;
                    if (gVar3.f572a == null) {
                        break;
                    }
                } else if (!f551n.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    public boolean n(Object obj) {
        if (obj == null) {
            obj = f552o;
        }
        if (!f551n.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean o(Throwable th) {
        if (!f551n.b(this, null, new Failure((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public final String p(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean q() {
        Object obj = this.f553e;
        return (obj instanceof c) && ((c) obj).f560a;
    }

    public String toString() {
        String strK;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strK = k();
            } catch (RuntimeException e10) {
                strK = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strK != null && !strK.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strK);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
