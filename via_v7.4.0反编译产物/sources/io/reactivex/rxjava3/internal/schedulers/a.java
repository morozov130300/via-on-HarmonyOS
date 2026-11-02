package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends n {

    /* renamed from: e, reason: collision with root package name */
    public static final b f7402e;

    /* renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f7403f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f7404g = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* renamed from: h, reason: collision with root package name */
    public static final c f7405h;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadFactory f7406c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7407d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: io.reactivex.rxjava3.internal.schedulers.a$a, reason: collision with other inner class name */
    public static final class C0085a extends n.b {

        /* renamed from: e, reason: collision with root package name */
        public final b7.a f7408e;

        /* renamed from: j, reason: collision with root package name */
        public final y6.a f7409j;

        /* renamed from: k, reason: collision with root package name */
        public final b7.a f7410k;

        /* renamed from: l, reason: collision with root package name */
        public final c f7411l;

        /* renamed from: m, reason: collision with root package name */
        public volatile boolean f7412m;

        public C0085a(c cVar) {
            this.f7411l = cVar;
            b7.a aVar = new b7.a();
            this.f7408e = aVar;
            y6.a aVar2 = new y6.a();
            this.f7409j = aVar2;
            b7.a aVar3 = new b7.a();
            this.f7410k = aVar3;
            aVar3.b(aVar);
            aVar3.b(aVar2);
        }

        @Override // x6.n.b
        public y6.b b(Runnable runnable) {
            return this.f7412m ? EmptyDisposable.INSTANCE : this.f7411l.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f7408e);
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f7412m ? EmptyDisposable.INSTANCE : this.f7411l.d(runnable, j10, timeUnit, this.f7409j);
        }

        @Override // y6.b
        public void dispose() {
            if (this.f7412m) {
                return;
            }
            this.f7412m = true;
            this.f7410k.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7412m;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7413a;

        /* renamed from: b, reason: collision with root package name */
        public final c[] f7414b;

        /* renamed from: c, reason: collision with root package name */
        public long f7415c;

        public b(int i10, ThreadFactory threadFactory) {
            this.f7413a = i10;
            this.f7414b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f7414b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f7413a;
            if (i10 == 0) {
                return a.f7405h;
            }
            c[] cVarArr = this.f7414b;
            long j10 = this.f7415c;
            this.f7415c = 1 + j10;
            return cVarArr[(int) (j10 % i10)];
        }

        public void b() {
            for (c cVar : this.f7414b) {
                cVar.dispose();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends e {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f7405h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f7403f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f7402e = bVar;
        bVar.b();
    }

    public a() {
        this(f7403f);
    }

    public a(ThreadFactory threadFactory) {
        this.f7406c = threadFactory;
        this.f7407d = new AtomicReference(f7402e);
        g();
    }

    public static int f(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // x6.n
    public n.b c() {
        return new C0085a(((b) this.f7407d.get()).a());
    }

    @Override // x6.n
    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        return ((b) this.f7407d.get()).a().e(runnable, j10, timeUnit);
    }

    public void g() {
        b bVar = new b(f7404g, this.f7406c);
        if (autodispose2.c.a(this.f7407d, f7402e, bVar)) {
            return;
        }
        bVar.b();
    }
}
