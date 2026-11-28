package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f6631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f6632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6633g = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f6634h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f6635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f6636d;

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.schedulers.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0080a extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v6.a f6637c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s6.a f6638e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final v6.a f6639m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final c f6640n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f6641o;

        public C0080a(c cVar) {
            this.f6640n = cVar;
            v6.a aVar = new v6.a();
            this.f6637c = aVar;
            s6.a aVar2 = new s6.a();
            this.f6638e = aVar2;
            v6.a aVar3 = new v6.a();
            this.f6639m = aVar3;
            aVar3.b(aVar);
            aVar3.b(aVar2);
        }

        @Override // r6.p.c
        public s6.b b(Runnable runnable) {
            return this.f6641o ? EmptyDisposable.INSTANCE : this.f6640n.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f6637c);
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f6641o ? EmptyDisposable.INSTANCE : this.f6640n.e(runnable, j10, timeUnit, this.f6638e);
        }

        @Override // s6.b
        public void dispose() {
            if (this.f6641o) {
                return;
            }
            this.f6641o = true;
            this.f6639m.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6641o;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f6643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6644c;

        public b(int i10, ThreadFactory threadFactory) {
            this.f6642a = i10;
            this.f6643b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f6643b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f6642a;
            if (i10 == 0) {
                return a.f6634h;
            }
            c[] cVarArr = this.f6643b;
            long j10 = this.f6644c;
            this.f6644c = 1 + j10;
            return cVarArr[(int) (j10 % ((long) i10))];
        }

        public void b() {
            for (c cVar : this.f6643b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c extends f {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f6634h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f6632f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f6631e = bVar;
        bVar.b();
    }

    public a() {
        this(f6632f);
    }

    public static int g(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // r6.p
    public p.c c() {
        return new C0080a(((b) this.f6636d.get()).a());
    }

    @Override // r6.p
    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        return ((b) this.f6636d.get()).a().f(runnable, j10, timeUnit);
    }

    @Override // r6.p
    public s6.b f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return ((b) this.f6636d.get()).a().g(runnable, j10, j11, timeUnit);
    }

    public void h() {
        b bVar = new b(f6633g, this.f6635c);
        if (autodispose2.c.a(this.f6636d, f6631e, bVar)) {
            return;
        }
        bVar.b();
    }

    public a(ThreadFactory threadFactory) {
        this.f6635c = threadFactory;
        this.f6636d = new AtomicReference(f6631e);
        h();
    }
}
