package io.reactivex.rxjava3.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import x6.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6605s = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f6606t = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6608e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AtomicReferenceArray f6611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f6612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AtomicReferenceArray f6613q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f6607c = new AtomicLong();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f6614r = new AtomicLong();

    public a(int i10) {
        int iA = io.reactivex.rxjava3.internal.util.d.a(Math.max(8, i10));
        int i11 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.f6611o = atomicReferenceArray;
        this.f6610n = i11;
        a(iA);
        this.f6613q = atomicReferenceArray;
        this.f6612p = i11;
        this.f6609m = iA - 2;
        o(0L);
    }

    public static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    public static Object g(AtomicReferenceArray atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private void l(long j10) {
        this.f6614r.lazySet(j10);
    }

    public static void m(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void o(long j10) {
        this.f6607c.lazySet(j10);
    }

    public final void a(int i10) {
        this.f6608e = Math.min(i10 / 4, f6605s);
    }

    @Override // x6.e
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f6614r.get();
    }

    public final long e() {
        return this.f6607c.get();
    }

    public final long f() {
        return this.f6614r.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int i10) {
        int iB = b(i10);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        m(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f6607c.get();
    }

    @Override // x6.e
    public boolean isEmpty() {
        return i() == f();
    }

    public final Object j(AtomicReferenceArray atomicReferenceArray, long j10, int i10) {
        this.f6613q = atomicReferenceArray;
        int iC = c(j10, i10);
        Object objG = g(atomicReferenceArray, iC);
        if (objG != null) {
            m(atomicReferenceArray, iC, null);
            l(j10 + 1);
        }
        return objG;
    }

    public final void k(AtomicReferenceArray atomicReferenceArray, long j10, int i10, Object obj, long j11) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f6611o = atomicReferenceArray2;
        this.f6609m = (j11 + j10) - 1;
        m(atomicReferenceArray2, i10, obj);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i10, f6606t);
        o(j10 + 1);
    }

    public final void n(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // x6.e
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f6611o;
        long jE = e();
        int i10 = this.f6610n;
        int iC = c(jE, i10);
        if (jE < this.f6609m) {
            return p(atomicReferenceArray, obj, jE, iC);
        }
        long j10 = ((long) this.f6608e) + jE;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f6609m = j10 - 1;
            return p(atomicReferenceArray, obj, jE, iC);
        }
        if (g(atomicReferenceArray, c(jE + 1, i10)) == null) {
            return p(atomicReferenceArray, obj, jE, iC);
        }
        k(atomicReferenceArray, jE, iC, obj, i10);
        return true;
    }

    public final boolean p(AtomicReferenceArray atomicReferenceArray, Object obj, long j10, int i10) {
        m(atomicReferenceArray, i10, obj);
        o(j10 + 1);
        return true;
    }

    @Override // x6.d, x6.e
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f6613q;
        long jD = d();
        int i10 = this.f6612p;
        int iC = c(jD, i10);
        Object objG = g(atomicReferenceArray, iC);
        boolean z10 = objG == f6606t;
        if (objG == null || z10) {
            if (z10) {
                return j(h(atomicReferenceArray, i10 + 1), jD, i10);
            }
            return null;
        }
        m(atomicReferenceArray, iC, null);
        l(jD + 1);
        return objG;
    }

    public static int b(int i10) {
        return i10;
    }
}
