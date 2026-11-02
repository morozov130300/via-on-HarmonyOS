package h7;

import autodispose2.c;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.internal.util.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: p, reason: collision with root package name */
    public static final C0077a[] f6388p = new C0077a[0];

    /* renamed from: q, reason: collision with root package name */
    public static final C0077a[] f6389q = new C0077a[0];

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f6390e;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference f6391j;

    /* renamed from: k, reason: collision with root package name */
    public final ReadWriteLock f6392k;

    /* renamed from: l, reason: collision with root package name */
    public final Lock f6393l;

    /* renamed from: m, reason: collision with root package name */
    public final Lock f6394m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference f6395n;

    /* renamed from: o, reason: collision with root package name */
    public long f6396o;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: h7.a$a, reason: collision with other inner class name */
    public static final class C0077a implements y6.b, a.InterfaceC0087a {

        /* renamed from: e, reason: collision with root package name */
        public final m f6397e;

        /* renamed from: j, reason: collision with root package name */
        public final a f6398j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f6399k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f6400l;

        /* renamed from: m, reason: collision with root package name */
        public io.reactivex.rxjava3.internal.util.a f6401m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f6402n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f6403o;

        /* renamed from: p, reason: collision with root package name */
        public long f6404p;

        public C0077a(m mVar, a aVar) {
            this.f6397e = mVar;
            this.f6398j = aVar;
        }

        public void a() {
            if (this.f6403o) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f6403o) {
                        return;
                    }
                    if (this.f6399k) {
                        return;
                    }
                    a aVar = this.f6398j;
                    Lock lock = aVar.f6393l;
                    lock.lock();
                    this.f6404p = aVar.f6396o;
                    Object obj = aVar.f6390e.get();
                    lock.unlock();
                    this.f6400l = obj != null;
                    this.f6399k = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            io.reactivex.rxjava3.internal.util.a aVar;
            while (!this.f6403o) {
                synchronized (this) {
                    try {
                        aVar = this.f6401m;
                        if (aVar == null) {
                            this.f6400l = false;
                            return;
                        }
                        this.f6401m = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar.c(this);
            }
        }

        public void c(Object obj, long j10) {
            if (this.f6403o) {
                return;
            }
            if (!this.f6402n) {
                synchronized (this) {
                    try {
                        if (this.f6403o) {
                            return;
                        }
                        if (this.f6404p == j10) {
                            return;
                        }
                        if (this.f6400l) {
                            io.reactivex.rxjava3.internal.util.a aVar = this.f6401m;
                            if (aVar == null) {
                                aVar = new io.reactivex.rxjava3.internal.util.a(4);
                                this.f6401m = aVar;
                            }
                            aVar.b(obj);
                            return;
                        }
                        this.f6399k = true;
                        this.f6402n = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // y6.b
        public void dispose() {
            if (this.f6403o) {
                return;
            }
            this.f6403o = true;
            this.f6398j.R(this);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f6403o;
        }

        @Override // io.reactivex.rxjava3.internal.util.a.InterfaceC0087a, a7.h
        public boolean test(Object obj) {
            return this.f6403o || NotificationLite.accept(obj, this.f6397e);
        }
    }

    public a(Object obj) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f6392k = reentrantReadWriteLock;
        this.f6393l = reentrantReadWriteLock.readLock();
        this.f6394m = reentrantReadWriteLock.writeLock();
        this.f6391j = new AtomicReference(f6388p);
        this.f6390e = new AtomicReference(obj);
        this.f6395n = new AtomicReference();
    }

    public static a O() {
        return new a(null);
    }

    public static a P(Object obj) {
        Objects.requireNonNull(obj, "defaultValue is null");
        return new a(obj);
    }

    @Override // x6.j
    public void C(m mVar) {
        C0077a c0077a = new C0077a(mVar, this);
        mVar.onSubscribe(c0077a);
        if (N(c0077a)) {
            if (c0077a.f6403o) {
                R(c0077a);
                return;
            } else {
                c0077a.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f6395n.get();
        if (th == ExceptionHelper.f7466a) {
            mVar.onComplete();
        } else {
            mVar.onError(th);
        }
    }

    public boolean N(C0077a c0077a) {
        C0077a[] c0077aArr;
        C0077a[] c0077aArr2;
        do {
            c0077aArr = (C0077a[]) this.f6391j.get();
            if (c0077aArr == f6389q) {
                return false;
            }
            int length = c0077aArr.length;
            c0077aArr2 = new C0077a[length + 1];
            System.arraycopy(c0077aArr, 0, c0077aArr2, 0, length);
            c0077aArr2[length] = c0077a;
        } while (!c.a(this.f6391j, c0077aArr, c0077aArr2));
        return true;
    }

    public Object Q() {
        Object obj = this.f6390e.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    public void R(C0077a c0077a) {
        C0077a[] c0077aArr;
        C0077a[] c0077aArr2;
        do {
            c0077aArr = (C0077a[]) this.f6391j.get();
            int length = c0077aArr.length;
            if (length == 0) {
                return;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (c0077aArr[i10] == c0077a) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                c0077aArr2 = f6388p;
            } else {
                C0077a[] c0077aArr3 = new C0077a[length - 1];
                System.arraycopy(c0077aArr, 0, c0077aArr3, 0, i10);
                System.arraycopy(c0077aArr, i10 + 1, c0077aArr3, i10, (length - i10) - 1);
                c0077aArr2 = c0077aArr3;
            }
        } while (!c.a(this.f6391j, c0077aArr, c0077aArr2));
    }

    public void S(Object obj) {
        this.f6394m.lock();
        this.f6396o++;
        this.f6390e.lazySet(obj);
        this.f6394m.unlock();
    }

    public C0077a[] T(Object obj) {
        S(obj);
        return (C0077a[]) this.f6391j.getAndSet(f6389q);
    }

    @Override // x6.m
    public void onComplete() {
        if (c.a(this.f6395n, null, ExceptionHelper.f7466a)) {
            Object objComplete = NotificationLite.complete();
            for (C0077a c0077a : T(objComplete)) {
                c0077a.c(objComplete, this.f6396o);
            }
        }
    }

    @Override // x6.m
    public void onError(Throwable th) {
        ExceptionHelper.c(th, "onError called with a null Throwable.");
        if (!c.a(this.f6395n, null, th)) {
            f7.a.o(th);
            return;
        }
        Object objError = NotificationLite.error(th);
        for (C0077a c0077a : T(objError)) {
            c0077a.c(objError, this.f6396o);
        }
    }

    @Override // x6.m
    public void onNext(Object obj) {
        ExceptionHelper.c(obj, "onNext called with a null value.");
        if (this.f6395n.get() != null) {
            return;
        }
        Object next = NotificationLite.next(obj);
        S(next);
        for (C0077a c0077a : (C0077a[]) this.f6391j.get()) {
            c0077a.c(next, this.f6396o);
        }
    }

    @Override // x6.m
    public void onSubscribe(y6.b bVar) {
        if (this.f6395n.get() != null) {
            bVar.dispose();
        }
    }
}
