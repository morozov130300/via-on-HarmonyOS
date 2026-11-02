package y2;

import android.database.SQLException;
import android.os.SystemClock;
import com.google.android.datatransport.Priority;
import d1.l;
import g2.g;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p2.f;
import s2.a0;
import s2.p;
import s2.u0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final double f14416a;

    /* renamed from: b, reason: collision with root package name */
    public final double f14417b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14418c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14419d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14420e;

    /* renamed from: f, reason: collision with root package name */
    public final BlockingQueue f14421f;

    /* renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f14422g;

    /* renamed from: h, reason: collision with root package name */
    public final a1.e f14423h;

    /* renamed from: i, reason: collision with root package name */
    public final a0 f14424i;

    /* renamed from: j, reason: collision with root package name */
    public int f14425j;

    /* renamed from: k, reason: collision with root package name */
    public long f14426k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final p f14427e;

        /* renamed from: j, reason: collision with root package name */
        public final g f14428j;

        public b(p pVar, g gVar) {
            this.f14427e = pVar;
            this.f14428j = gVar;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            e.this.n(this.f14427e, this.f14428j);
            e.this.f14424i.c();
            double dG = e.this.g();
            f.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f14427e.d());
            e.o(dG);
        }
    }

    public e(double d10, double d11, long j10, a1.e eVar, a0 a0Var) {
        this.f14416a = d10;
        this.f14417b = d11;
        this.f14418c = j10;
        this.f14423h = eVar;
        this.f14424i = a0Var;
        this.f14419d = SystemClock.elapsedRealtime();
        int i10 = (int) d10;
        this.f14420e = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.f14421f = arrayBlockingQueue;
        this.f14422g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f14425j = 0;
        this.f14426k = 0L;
    }

    public e(a1.e eVar, z2.d dVar, a0 a0Var) {
        this(dVar.f14567f, dVar.f14568g, dVar.f14569h * 1000, eVar, a0Var);
    }

    public static /* synthetic */ void a(e eVar, g gVar, boolean z10, p pVar, Exception exc) {
        eVar.getClass();
        if (exc != null) {
            gVar.d(exc);
            return;
        }
        if (z10) {
            eVar.j();
        }
        gVar.e(pVar);
    }

    public static /* synthetic */ void b(e eVar, CountDownLatch countDownLatch) {
        eVar.getClass();
        try {
            l.a(eVar.f14423h, Priority.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    public static void o(double d10) throws InterruptedException {
        try {
            Thread.sleep((long) d10);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f14416a) * Math.pow(this.f14417b, h()));
    }

    public final int h() {
        if (this.f14426k == 0) {
            this.f14426k = m();
        }
        int iM = (int) ((m() - this.f14426k) / this.f14418c);
        int iMin = l() ? Math.min(100, this.f14425j + iM) : Math.max(0, this.f14425j - iM);
        if (this.f14425j != iMin) {
            this.f14425j = iMin;
            this.f14426k = m();
        }
        return iMin;
    }

    public g i(p pVar, boolean z10) {
        synchronized (this.f14421f) {
            try {
                g gVar = new g();
                if (!z10) {
                    n(pVar, gVar);
                    return gVar;
                }
                this.f14424i.b();
                if (!k()) {
                    h();
                    f.f().b("Dropping report due to queue being full: " + pVar.d());
                    this.f14424i.a();
                    gVar.e(pVar);
                    return gVar;
                }
                f.f().b("Enqueueing report: " + pVar.d());
                f.f().b("Queue size: " + this.f14421f.size());
                this.f14422g.execute(new b(pVar, gVar));
                f.f().b("Closing task for report: " + pVar.d());
                gVar.e(pVar);
                return gVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: y2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f14414e, countDownLatch);
            }
        }).start();
        u0.g(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f14421f.size() < this.f14420e;
    }

    public final boolean l() {
        return this.f14421f.size() == this.f14420e;
    }

    public final long m() {
        return System.currentTimeMillis();
    }

    public final void n(final p pVar, final g gVar) {
        f.f().b("Sending report through Google DataTransport: " + pVar.d());
        final boolean z10 = SystemClock.elapsedRealtime() - this.f14419d < 2000;
        this.f14423h.a(a1.c.d(pVar.b()), new a1.g() { // from class: y2.c
            @Override // a1.g
            public final void a(Exception exc) {
                e.a(this.f14410a, gVar, z10, pVar, exc);
            }
        });
    }
}
