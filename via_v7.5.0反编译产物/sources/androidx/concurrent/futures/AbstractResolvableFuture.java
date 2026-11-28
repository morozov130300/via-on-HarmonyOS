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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResolvableFuture implements Future {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f452n = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f453o = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f455q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f456c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile d f457e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile g f458m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f459b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f460a;

        public Failure(Throwable th) {
            this.f460a = (Throwable) AbstractResolvableFuture.f(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f462d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f464b;

        static {
            if (AbstractResolvableFuture.f452n) {
                f462d = null;
                f461c = null;
            } else {
                f462d = new c(false, null);
                f461c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f463a = z10;
            this.f464b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f465d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f468c;

        public d(Runnable runnable, Executor executor) {
            this.f466a = runnable;
            this.f467b = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f473e;

        public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f469a = atomicReferenceFieldUpdater;
            this.f470b = atomicReferenceFieldUpdater2;
            this.f471c = atomicReferenceFieldUpdater3;
            this.f472d = atomicReferenceFieldUpdater4;
            this.f473e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            return l.a.a(this.f472d, abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            return l.a.a(this.f473e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2) {
            return l.a.a(this.f471c, abstractResolvableFuture, gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            this.f470b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            this.f469a.lazySet(gVar, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f extends b {
        public f() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f457e != dVar) {
                        return false;
                    }
                    abstractResolvableFuture.f457e = dVar2;
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
                    if (abstractResolvableFuture.f456c != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f456c = obj2;
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
                    if (abstractResolvableFuture.f458m != gVar) {
                        return false;
                    }
                    abstractResolvableFuture.f458m = gVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g gVar, g gVar2) {
            gVar.f476b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g gVar, Thread thread) {
            gVar.f475a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f474c = new g(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile g f476b;

        public g(boolean z10) {
        }

        public void a(g gVar) {
            AbstractResolvableFuture.f454p.d(this, gVar);
        }

        public void b() {
            Thread thread = this.f475a;
            if (thread != null) {
                this.f475a = null;
                LockSupport.unpark(thread);
            }
        }

        public g() {
            AbstractResolvableFuture.f454p.e(this, Thread.currentThread());
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "m"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, "e"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "c"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f454p = fVar;
        if (th != null) {
            f453o.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f455q = new Object();
    }

    public static CancellationException e(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object f(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void h(AbstractResolvableFuture abstractResolvableFuture) {
        abstractResolvableFuture.n();
        abstractResolvableFuture.d();
        d dVarG = abstractResolvableFuture.g(null);
        while (dVarG != null) {
            d dVar = dVarG.f468c;
            i(dVarG.f466a, dVarG.f467b);
            dVarG = dVar;
        }
    }

    public static void i(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f453o.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object k(Future future) {
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
            Object objK = k(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(r(objK));
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

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.f456c;
        if (obj == null) {
            if (f452n) {
                cVar = new c(z10, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z10 ? c.f461c : c.f462d;
            }
            if (f454p.b(this, obj, cVar)) {
                if (z10) {
                    l();
                }
                h(this);
                return true;
            }
        }
        return false;
    }

    public final d g(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f457e;
        } while (!f454p.a(this, dVar2, d.f465d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f468c;
            dVar4.f468c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f456c;
        if (obj != null) {
            return j(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f458m;
            if (gVar != g.f474c) {
                g gVar2 = new g();
                while (true) {
                    gVar2.a(gVar);
                    if (f454p.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f456c;
                            if (obj2 != null) {
                                return j(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(gVar2);
                        break;
                    }
                    gVar = this.f458m;
                    if (gVar == g.f474c) {
                    }
                }
            }
            return j(this.f456c);
        }
        while (nanos > 0) {
            Object obj3 = this.f456c;
            if (obj3 != null) {
                return j(obj3);
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

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f456c instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f456c != null;
    }

    public final Object j(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw e("Task was cancelled.", ((c) obj).f464b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f460a);
        }
        if (obj == f455q) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String m() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void n() {
        g gVar;
        do {
            gVar = this.f458m;
        } while (!f454p.c(this, gVar, g.f474c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f476b;
        }
    }

    public final void o(g gVar) {
        gVar.f475a = null;
        while (true) {
            g gVar2 = this.f458m;
            if (gVar2 == g.f474c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f476b;
                if (gVar2.f475a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f476b = gVar4;
                    if (gVar3.f475a == null) {
                    }
                } else if (!f454p.c(this, gVar2, gVar4)) {
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    public boolean p(Object obj) {
        if (obj == null) {
            obj = f455q;
        }
        if (!f454p.b(this, null, obj)) {
            return false;
        }
        h(this);
        return true;
    }

    public boolean q(Throwable th) {
        if (!f454p.b(this, null, new Failure((Throwable) f(th)))) {
            return false;
        }
        h(this);
        return true;
    }

    public final String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean s() {
        Object obj = this.f456c;
        return (obj instanceof c) && ((c) obj).f463a;
    }

    public String toString() {
        String strM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e10) {
                strM = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strM);
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

    public void d() {
    }

    public void l() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f456c;
            if (obj2 != null) {
                return j(obj2);
            }
            g gVar = this.f458m;
            if (gVar != g.f474c) {
                g gVar2 = new g();
                do {
                    gVar2.a(gVar);
                    if (f454p.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f456c;
                            } else {
                                o(gVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return j(obj);
                    }
                    gVar = this.f458m;
                } while (gVar != g.f474c);
            }
            return j(this.f456c);
        }
        throw new InterruptedException();
    }
}
