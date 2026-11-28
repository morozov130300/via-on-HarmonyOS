package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ObservableZip extends r6.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r6.n[] f6518c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Iterable f6519e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u6.g f6520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f6522o;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements s6.b {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final r6.o downstream;
        final a[] observers;
        final T[] row;
        final u6.g zipper;

        public ZipCoordinator(r6.o oVar, u6.g gVar, int i10, boolean z10) {
            this.downstream = oVar;
            this.zipper = gVar;
            this.observers = new a[i10];
            this.row = (T[]) new Object[i10];
            this.delayError = z10;
        }

        public void cancel() {
            clear();
            cancelSources();
        }

        public void cancelSources() {
            for (a aVar : this.observers) {
                aVar.a();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, r6.o oVar, boolean z12, a aVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
                if (!z11) {
                    return false;
                }
                Throwable th = aVar.f6526n;
                this.cancelled = true;
                cancel();
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
            Throwable th2 = aVar.f6526n;
            if (th2 != null) {
                this.cancelled = true;
                cancel();
                oVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            this.cancelled = true;
            cancel();
            oVar.onComplete();
            return true;
        }

        public void clear() {
            for (a aVar : this.observers) {
                aVar.f6524e.clear();
            }
        }

        @Override // s6.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            a[] aVarArr = this.observers;
            r6.o oVar = this.downstream;
            T[] tArr = this.row;
            boolean z10 = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i10 = 0;
                int i11 = 0;
                for (a aVar : aVarArr) {
                    if (tArr[i11] == null) {
                        boolean z11 = aVar.f6525m;
                        Object objPoll = aVar.f6524e.poll();
                        boolean z12 = objPoll == null;
                        if (checkTerminated(z11, z12, oVar, z10, aVar)) {
                            return;
                        }
                        if (z12) {
                            i10++;
                        } else {
                            tArr[i11] = objPoll;
                        }
                    } else if (aVar.f6525m && !z10 && (th = aVar.f6526n) != null) {
                        this.cancelled = true;
                        cancel();
                        oVar.onError(th);
                        return;
                    }
                    i11++;
                }
                if (i10 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        Object objApply = this.zipper.apply(tArr.clone());
                        Objects.requireNonNull(objApply, "The zipper returned a null value");
                        oVar.onNext(objApply);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        t6.a.b(th2);
                        cancel();
                        oVar.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(r6.n[] nVarArr, int i10) {
            a[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                aVarArr[i11] = new a(this, i10);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.cancelled; i12++) {
                nVarArr[i12].c(aVarArr[i12]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements r6.o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ZipCoordinator f6523c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final io.reactivex.rxjava3.internal.queue.a f6524e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f6525m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Throwable f6526n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final AtomicReference f6527o = new AtomicReference();

        public a(ZipCoordinator zipCoordinator, int i10) {
            this.f6523c = zipCoordinator;
            this.f6524e = new io.reactivex.rxjava3.internal.queue.a(i10);
        }

        public void a() {
            DisposableHelper.dispose(this.f6527o);
        }

        @Override // r6.o
        public void onComplete() {
            this.f6525m = true;
            this.f6523c.drain();
        }

        @Override // r6.o
        public void onError(Throwable th) {
            this.f6526n = th;
            this.f6525m = true;
            this.f6523c.drain();
        }

        @Override // r6.o
        public void onNext(Object obj) {
            this.f6524e.offer(obj);
            this.f6523c.drain();
        }

        @Override // r6.o
        public void onSubscribe(s6.b bVar) {
            DisposableHelper.setOnce(this.f6527o, bVar);
        }
    }

    public ObservableZip(r6.n[] nVarArr, Iterable iterable, u6.g gVar, int i10, boolean z10) {
        this.f6518c = nVarArr;
        this.f6519e = iterable;
        this.f6520m = gVar;
        this.f6521n = i10;
        this.f6522o = z10;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        int length;
        r6.n[] nVarArr = this.f6518c;
        if (nVarArr == null) {
            nVarArr = new r6.n[8];
            length = 0;
            for (r6.n nVar : this.f6519e) {
                if (length == nVarArr.length) {
                    r6.n[] nVarArr2 = new r6.n[(length >> 2) + length];
                    System.arraycopy(nVarArr, 0, nVarArr2, 0, length);
                    nVarArr = nVarArr2;
                }
                nVarArr[length] = nVar;
                length++;
            }
        } else {
            length = nVarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(oVar);
        } else {
            new ZipCoordinator(oVar, this.f6520m, length, this.f6522o).subscribe(nVarArr, this.f6521n);
        }
    }
}
