package z2;

import android.database.SQLException;
import android.os.SystemClock;
import com.google.android.datatransport.Priority;
import e1.l;
import h2.g;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q2.f;
import t2.a0;
import t2.p;
import t2.u0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f15144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f15145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f15149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f15150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1.e f15151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a0 f15152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f15154k;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f15155c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g f15156e;

        @Override // java.lang.Runnable
        public void run() {
            e.this.n(this.f15155c, this.f15156e);
            e.this.f15152i.c();
            double dG = e.this.g();
            f.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f15155c.d());
            e.o(dG);
        }

        public b(p pVar, g gVar) {
            this.f15155c = pVar;
            this.f15156e = gVar;
        }
    }

    public e(b1.e eVar, a3.d dVar, a0 a0Var) {
        this(dVar.f35f, dVar.f36g, ((long) dVar.f37h) * 1000, eVar, a0Var);
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
            l.a(eVar.f15151h, Priority.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    public static void o(double d10) {
        try {
            Thread.sleep((long) d10);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f15144a) * Math.pow(this.f15145b, h()));
    }

    public final int h() {
        if (this.f15154k == 0) {
            this.f15154k = m();
        }
        int iM = (int) ((m() - this.f15154k) / this.f15146c);
        int iMin = l() ? Math.min(100, this.f15153j + iM) : Math.max(0, this.f15153j - iM);
        if (this.f15153j != iMin) {
            this.f15153j = iMin;
            this.f15154k = m();
        }
        return iMin;
    }

    public g i(p pVar, boolean z10) {
        synchronized (this.f15149f) {
            try {
                g gVar = new g();
                if (!z10) {
                    n(pVar, gVar);
                    return gVar;
                }
                this.f15152i.b();
                if (!k()) {
                    h();
                    f.f().b("Dropping report due to queue being full: " + pVar.d());
                    this.f15152i.a();
                    gVar.e(pVar);
                    return gVar;
                }
                f.f().b("Enqueueing report: " + pVar.d());
                f.f().b("Queue size: " + this.f15149f.size());
                this.f15150g.execute(new b(pVar, gVar));
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
        new Thread(new Runnable() { // from class: z2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f15142c, countDownLatch);
            }
        }).start();
        u0.g(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f15149f.size() < this.f15148e;
    }

    public final boolean l() {
        return this.f15149f.size() == this.f15148e;
    }

    public final long m() {
        return System.currentTimeMillis();
    }

    public final void n(final p pVar, final g gVar) {
        f.f().b("Sending report through Google DataTransport: " + pVar.d());
        final boolean z10 = SystemClock.elapsedRealtime() - this.f15147d < 2000;
        this.f15151h.a(b1.c.d(pVar.b()), new b1.g() { // from class: z2.c
            @Override // b1.g
            public final void a(Exception exc) {
                e.a(this.f15138a, gVar, z10, pVar, exc);
            }
        });
    }

    public e(double d10, double d11, long j10, b1.e eVar, a0 a0Var) {
        this.f15144a = d10;
        this.f15145b = d11;
        this.f15146c = j10;
        this.f15151h = eVar;
        this.f15152i = a0Var;
        this.f15147d = SystemClock.elapsedRealtime();
        int i10 = (int) d10;
        this.f15148e = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.f15149f = arrayBlockingQueue;
        this.f15150g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f15153j = 0;
        this.f15154k = 0L;
    }
}
