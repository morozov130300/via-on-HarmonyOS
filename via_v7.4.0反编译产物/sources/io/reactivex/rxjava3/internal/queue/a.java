package io.reactivex.rxjava3.internal.queue;

import d7.d;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: q, reason: collision with root package name */
    public static final int f7376q = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: r, reason: collision with root package name */
    public static final Object f7377r = new Object();

    /* renamed from: j, reason: collision with root package name */
    public int f7379j;

    /* renamed from: k, reason: collision with root package name */
    public long f7380k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7381l;

    /* renamed from: m, reason: collision with root package name */
    public AtomicReferenceArray f7382m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7383n;

    /* renamed from: o, reason: collision with root package name */
    public AtomicReferenceArray f7384o;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f7378e = new AtomicLong();

    /* renamed from: p, reason: collision with root package name */
    public final AtomicLong f7385p = new AtomicLong();

    public a(int i10) {
        int iA = io.reactivex.rxjava3.internal.util.d.a(Math.max(8, i10));
        int i11 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.f7382m = atomicReferenceArray;
        this.f7381l = i11;
        a(iA);
        this.f7384o = atomicReferenceArray;
        this.f7383n = i11;
        this.f7380k = iA - 2;
        o(0L);
    }

    public static int b(int i10) {
        return i10;
    }

    public static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    public static Object g(AtomicReferenceArray atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private void l(long j10) {
        this.f7385p.lazySet(j10);
    }

    public static void m(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void o(long j10) {
        this.f7378e.lazySet(j10);
    }

    public final void a(int i10) {
        this.f7379j = Math.min(i10 / 4, f7376q);
    }

    @Override // d7.e
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f7385p.get();
    }

    public final long e() {
        return this.f7378e.get();
    }

    public final long f() {
        return this.f7385p.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int i10) {
        int iB = b(i10);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        m(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f7378e.get();
    }

    @Override // d7.e
    public boolean isEmpty() {
        return i() == f();
    }

    public final Object j(AtomicReferenceArray atomicReferenceArray, long j10, int i10) {
        this.f7384o = atomicReferenceArray;
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
        this.f7382m = atomicReferenceArray2;
        this.f7380k = (j11 + j10) - 1;
        m(atomicReferenceArray2, i10, obj);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i10, f7377r);
        o(j10 + 1);
    }

    public final void n(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // d7.e
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f7382m;
        long jE = e();
        int i10 = this.f7381l;
        int iC = c(jE, i10);
        if (jE < this.f7380k) {
            return p(atomicReferenceArray, obj, jE, iC);
        }
        long j10 = this.f7379j + jE;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f7380k = j10 - 1;
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

    @Override // d7.d, d7.e
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f7384o;
        long jD = d();
        int i10 = this.f7383n;
        int iC = c(jD, i10);
        Object objG = g(atomicReferenceArray, iC);
        boolean z10 = objG == f7377r;
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
}
