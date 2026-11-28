package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f6687c = new i();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f6688c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f6689e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f6690m;

        public a(Runnable runnable, c cVar, long j10) {
            this.f6688c = runnable;
            this.f6689e = cVar;
            this.f6690m = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6689e.f6698n) {
                return;
            }
            long jA = this.f6689e.a(TimeUnit.MILLISECONDS);
            long j10 = this.f6690m;
            if (j10 > jA) {
                try {
                    Thread.sleep(j10 - jA);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    z6.a.o(e10);
                    return;
                }
            }
            if (this.f6689e.f6698n) {
                return;
            }
            this.f6688c.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements Comparable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f6691c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f6692e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f6693m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public volatile boolean f6694n;

        public b(Runnable runnable, Long l10, int i10) {
            this.f6691c = runnable;
            this.f6692e = l10.longValue();
            this.f6693m = i10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iCompare = Long.compare(this.f6692e, bVar.f6692e);
            return iCompare == 0 ? Integer.compare(this.f6693m, bVar.f6693m) : iCompare;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c extends p.c implements s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PriorityBlockingQueue f6695c = new PriorityBlockingQueue();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f6696e = new AtomicInteger();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final AtomicInteger f6697m = new AtomicInteger();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public volatile boolean f6698n;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final b f6699c;

            public a(b bVar) {
                this.f6699c = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6699c.f6694n = true;
                c.this.f6695c.remove(this.f6699c);
            }
        }

        @Override // r6.p.c
        public s6.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return e(new a(runnable, this, jA), jA);
        }

        @Override // s6.b
        public void dispose() {
            this.f6698n = true;
        }

        public s6.b e(Runnable runnable, long j10) {
            if (this.f6698n) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f6697m.incrementAndGet());
            this.f6695c.add(bVar);
            if (this.f6696e.getAndIncrement() != 0) {
                return io.reactivex.rxjava3.disposables.a.c(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f6698n) {
                b bVar2 = (b) this.f6695c.poll();
                if (bVar2 == null) {
                    iAddAndGet = this.f6696e.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!bVar2.f6694n) {
                    bVar2.f6691c.run();
                }
            }
            this.f6695c.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6698n;
        }
    }

    public static i g() {
        return f6687c;
    }

    @Override // r6.p
    public p.c c() {
        return new c();
    }

    @Override // r6.p
    public s6.b d(Runnable runnable) {
        z6.a.q(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // r6.p
    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            z6.a.q(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            z6.a.o(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}
