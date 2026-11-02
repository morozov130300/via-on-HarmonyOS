package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends n {

    /* renamed from: c, reason: collision with root package name */
    public static final h f7452c = new h();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final Runnable f7453e;

        /* renamed from: j, reason: collision with root package name */
        public final c f7454j;

        /* renamed from: k, reason: collision with root package name */
        public final long f7455k;

        public a(Runnable runnable, c cVar, long j10) {
            this.f7453e = runnable;
            this.f7454j = cVar;
            this.f7455k = j10;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (this.f7454j.f7463l) {
                return;
            }
            long jA = this.f7454j.a(TimeUnit.MILLISECONDS);
            long j10 = this.f7455k;
            if (j10 > jA) {
                try {
                    Thread.sleep(j10 - jA);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    f7.a.o(e10);
                    return;
                }
            }
            if (this.f7454j.f7463l) {
                return;
            }
            this.f7453e.run();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        public final Runnable f7456e;

        /* renamed from: j, reason: collision with root package name */
        public final long f7457j;

        /* renamed from: k, reason: collision with root package name */
        public final int f7458k;

        /* renamed from: l, reason: collision with root package name */
        public volatile boolean f7459l;

        public b(Runnable runnable, Long l10, int i10) {
            this.f7456e = runnable;
            this.f7457j = l10.longValue();
            this.f7458k = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iCompare = Long.compare(this.f7457j, bVar.f7457j);
            return iCompare == 0 ? Integer.compare(this.f7458k, bVar.f7458k) : iCompare;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends n.b implements y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final PriorityBlockingQueue f7460e = new PriorityBlockingQueue();

        /* renamed from: j, reason: collision with root package name */
        public final AtomicInteger f7461j = new AtomicInteger();

        /* renamed from: k, reason: collision with root package name */
        public final AtomicInteger f7462k = new AtomicInteger();

        /* renamed from: l, reason: collision with root package name */
        public volatile boolean f7463l;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public final class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            public final b f7464e;

            public a(b bVar) {
                this.f7464e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7464e.f7459l = true;
                c.this.f7460e.remove(this.f7464e);
            }
        }

        @Override // x6.n.b
        public y6.b b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return d(new a(runnable, this, jA), jA);
        }

        public y6.b d(Runnable runnable, long j10) {
            if (this.f7463l) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f7462k.incrementAndGet());
            this.f7460e.add(bVar);
            if (this.f7461j.getAndIncrement() != 0) {
                return io.reactivex.rxjava3.disposables.a.c(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f7463l) {
                b bVar2 = (b) this.f7460e.poll();
                if (bVar2 == null) {
                    iAddAndGet = this.f7461j.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!bVar2.f7459l) {
                    bVar2.f7456e.run();
                }
            }
            this.f7460e.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // y6.b
        public void dispose() {
            this.f7463l = true;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7463l;
        }
    }

    public static h f() {
        return f7452c;
    }

    @Override // x6.n
    public n.b c() {
        return new c();
    }

    @Override // x6.n
    public y6.b d(Runnable runnable) {
        f7.a.q(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // x6.n
    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) throws InterruptedException {
        try {
            timeUnit.sleep(j10);
            f7.a.q(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            f7.a.o(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}
