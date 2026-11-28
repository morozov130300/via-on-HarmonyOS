package b7;

import autodispose2.c;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0034a[] f1752r = new C0034a[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0034a[] f1753s = new C0034a[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f1754c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f1755e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ReadWriteLock f1756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lock f1757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lock f1758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicReference f1759p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f1760q;

    /* JADX INFO: renamed from: b7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0034a implements s6.b, io.reactivex.rxjava3.internal.util.a.InterfaceC0081a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f1761c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f1762e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1763m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1764n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public io.reactivex.rxjava3.internal.util.a f1765o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1766p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public volatile boolean f1767q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f1768r;

        public C0034a(o oVar, a aVar) {
            this.f1761c = oVar;
            this.f1762e = aVar;
        }

        public void a() {
            if (this.f1767q) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f1767q) {
                        return;
                    }
                    if (this.f1763m) {
                        return;
                    }
                    a aVar = this.f1762e;
                    Lock lock = aVar.f1757n;
                    lock.lock();
                    this.f1768r = aVar.f1760q;
                    Object obj = aVar.f1754c.get();
                    lock.unlock();
                    this.f1764n = obj != null;
                    this.f1763m = true;
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
            while (!this.f1767q) {
                synchronized (this) {
                    try {
                        aVar = this.f1765o;
                        if (aVar == null) {
                            this.f1764n = false;
                            return;
                        }
                        this.f1765o = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar.c(this);
            }
        }

        public void c(Object obj, long j10) {
            if (this.f1767q) {
                return;
            }
            if (!this.f1766p) {
                synchronized (this) {
                    try {
                        if (this.f1767q) {
                            return;
                        }
                        if (this.f1768r == j10) {
                            return;
                        }
                        if (this.f1764n) {
                            io.reactivex.rxjava3.internal.util.a aVar = this.f1765o;
                            if (aVar == null) {
                                aVar = new io.reactivex.rxjava3.internal.util.a(4);
                                this.f1765o = aVar;
                            }
                            aVar.b(obj);
                            return;
                        }
                        this.f1763m = true;
                        this.f1766p = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // s6.b
        public void dispose() {
            if (this.f1767q) {
                return;
            }
            this.f1767q = true;
            this.f1762e.U(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f1767q;
        }

        @Override // io.reactivex.rxjava3.internal.util.a.InterfaceC0081a, u6.i
        public boolean test(Object obj) {
            return this.f1767q || NotificationLite.accept(obj, this.f1761c);
        }
    }

    public a(Object obj) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1756m = reentrantReadWriteLock;
        this.f1757n = reentrantReadWriteLock.readLock();
        this.f1758o = reentrantReadWriteLock.writeLock();
        this.f1755e = new AtomicReference(f1752r);
        this.f1754c = new AtomicReference(obj);
        this.f1759p = new AtomicReference();
    }

    public static a R() {
        return new a(null);
    }

    public static a S(Object obj) {
        Objects.requireNonNull(obj, "defaultValue is null");
        return new a(obj);
    }

    @Override // r6.j
    public void F(o oVar) {
        C0034a c0034a = new C0034a(oVar, this);
        oVar.onSubscribe(c0034a);
        if (Q(c0034a)) {
            if (c0034a.f1767q) {
                U(c0034a);
                return;
            } else {
                c0034a.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f1759p.get();
        if (th == ExceptionHelper.f6701a) {
            oVar.onComplete();
        } else {
            oVar.onError(th);
        }
    }

    public boolean Q(C0034a c0034a) {
        C0034a[] c0034aArr;
        C0034a[] c0034aArr2;
        do {
            c0034aArr = (C0034a[]) this.f1755e.get();
            if (c0034aArr == f1753s) {
                return false;
            }
            int length = c0034aArr.length;
            c0034aArr2 = new C0034a[length + 1];
            System.arraycopy(c0034aArr, 0, c0034aArr2, 0, length);
            c0034aArr2[length] = c0034a;
        } while (!c.a(this.f1755e, c0034aArr, c0034aArr2));
        return true;
    }

    public Object T() {
        Object obj = this.f1754c.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    public void U(C0034a c0034a) {
        C0034a[] c0034aArr;
        C0034a[] c0034aArr2;
        do {
            c0034aArr = (C0034a[]) this.f1755e.get();
            int length = c0034aArr.length;
            if (length == 0) {
                return;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (c0034aArr[i10] == c0034a) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                c0034aArr2 = f1752r;
            } else {
                C0034a[] c0034aArr3 = new C0034a[length - 1];
                System.arraycopy(c0034aArr, 0, c0034aArr3, 0, i10);
                System.arraycopy(c0034aArr, i10 + 1, c0034aArr3, i10, (length - i10) - 1);
                c0034aArr2 = c0034aArr3;
            }
        } while (!c.a(this.f1755e, c0034aArr, c0034aArr2));
    }

    public void V(Object obj) {
        this.f1758o.lock();
        this.f1760q++;
        this.f1754c.lazySet(obj);
        this.f1758o.unlock();
    }

    public C0034a[] W(Object obj) {
        V(obj);
        return (C0034a[]) this.f1755e.getAndSet(f1753s);
    }

    @Override // r6.o
    public void onComplete() {
        if (c.a(this.f1759p, null, ExceptionHelper.f6701a)) {
            Object objComplete = NotificationLite.complete();
            for (C0034a c0034a : W(objComplete)) {
                c0034a.c(objComplete, this.f1760q);
            }
        }
    }

    @Override // r6.o
    public void onError(Throwable th) {
        ExceptionHelper.c(th, "onError called with a null Throwable.");
        if (!c.a(this.f1759p, null, th)) {
            z6.a.o(th);
            return;
        }
        Object objError = NotificationLite.error(th);
        for (C0034a c0034a : W(objError)) {
            c0034a.c(objError, this.f1760q);
        }
    }

    @Override // r6.o
    public void onNext(Object obj) {
        ExceptionHelper.c(obj, "onNext called with a null value.");
        if (this.f1759p.get() != null) {
            return;
        }
        Object next = NotificationLite.next(obj);
        V(next);
        for (C0034a c0034a : (C0034a[]) this.f1755e.get()) {
            c0034a.c(next, this.f1760q);
        }
    }

    @Override // r6.o
    public void onSubscribe(s6.b bVar) {
        if (this.f1759p.get() != null) {
            bVar.dispose();
        }
    }
}
