package com.launchdarkly.eventsource;

import f4.l;
import f4.n;
import f4.o;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.h;
import okhttp3.q;
import okhttp3.r;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okio.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {
    public static final Duration C = Duration.ofSeconds(1);
    public static final Duration D = Duration.ofSeconds(30);
    public static final Duration E = Duration.ofSeconds(10);
    public static final Duration F = Duration.ofSeconds(5);
    public static final Duration G = Duration.ofMinutes(5);
    public static final Duration H = Duration.ofSeconds(60);
    public static final q I = new q.a().a("Accept", "text/event-stream").a("Cache-Control", "no-cache").d();
    public volatile okhttp3.d A;
    public final Random B = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f3493c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3494e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile r f3495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q f3496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final x f3498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ExecutorService f3499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ExecutorService f3500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile Duration f3501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Duration f3502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Duration f3503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile String f3504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f4.a f3505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConnectionErrorHandler f3506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicReference f3507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final u f3508z;

    /* JADX INFO: renamed from: com.launchdarkly.eventsource.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class ThreadFactoryC0048a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f3509c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f3510e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f3511m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Integer f3512n;

        public ThreadFactoryC0048a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Integer num) {
            this.f3509c = threadFactory;
            this.f3510e = str;
            this.f3511m = atomicLong;
            this.f3512n = num;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f3509c.newThread(runnable);
            threadNewThread.setName(String.format(Locale.ROOT, "%s-[%s]-%d", this.f3510e, a.this.f3494e, Long.valueOf(this.f3511m.getAndIncrement())));
            threadNewThread.setDaemon(true);
            Integer num = this.f3512n;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.r();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements f4.b {
        public c() {
        }

        @Override // f4.b
        public void a(Duration duration) {
            a.this.t(duration);
        }

        @Override // f4.b
        public void b(String str) {
            a.this.s(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3516a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final r f3521f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final f4.c f3522g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Proxy f3526k;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public u.b f3530o;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Duration f3517b = a.C;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Duration f3518c = a.D;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Duration f3519d = a.H;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ConnectionErrorHandler f3523h = ConnectionErrorHandler.f3490a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f3524i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public q f3525j = q.i(new String[0]);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public okhttp3.b f3527l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f3528m = "GET";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public x f3529n = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public l f3531p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f3532q = null;

        public d(f4.c cVar, r rVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("handler must not be null");
            }
            if (rVar == null) {
                throw new IllegalArgumentException("URI/URL must not be null");
            }
            this.f3521f = rVar;
            this.f3522g = cVar;
            this.f3530o = t();
        }

        public static /* synthetic */ e n(d dVar) {
            dVar.getClass();
            return null;
        }

        public static u.b t() {
            u.b bVarJ = new u.b().e(new h(1, 1L, TimeUnit.SECONDS)).d(a.E).i(a.G).m(a.F).j(true);
            try {
                bVarJ.k(new n(), u());
            } catch (GeneralSecurityException unused) {
            }
            return bVarJ;
        }

        public static X509TrustManager u() throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }

        public d q(x xVar) {
            this.f3529n = xVar;
            return this;
        }

        public a r() {
            Proxy proxy = this.f3526k;
            if (proxy != null) {
                this.f3530o.f(proxy);
            }
            okhttp3.b bVar = this.f3527l;
            if (bVar != null) {
                this.f3530o.g(bVar);
            }
            return new a(this);
        }

        public d s(u uVar) {
            this.f3530o = uVar.u();
            return this;
        }

        public d v(q qVar) {
            this.f3525j = qVar;
            return this;
        }

        public d w(l lVar) {
            this.f3531p = lVar;
            return this;
        }

        public d x(String str) {
            this.f3528m = (str == null || str.length() <= 0) ? "GET" : str.toUpperCase();
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
    }

    public a(d dVar) {
        String str = "";
        String str2 = dVar.f3516a == null ? "" : dVar.f3516a;
        this.f3494e = str2;
        if (dVar.f3531p == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dVar.f3532q == null ? a.class.getCanonicalName() : dVar.f3532q);
            if (!str2.isEmpty()) {
                str = "." + str2;
            }
            sb2.append(str);
            this.f3493c = new o(sb2.toString());
        } else {
            this.f3493c = dVar.f3531p;
        }
        this.f3495m = dVar.f3521f;
        this.f3496n = f(dVar.f3525j);
        this.f3497o = dVar.f3528m;
        this.f3498p = dVar.f3529n;
        d.n(dVar);
        this.f3504v = dVar.f3520e;
        this.f3501s = dVar.f3517b;
        this.f3502t = dVar.f3518c;
        this.f3503u = dVar.f3519d;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(k("okhttp-eventsource-events", dVar.f3524i));
        this.f3499q = executorServiceNewSingleThreadExecutor;
        this.f3500r = Executors.newSingleThreadExecutor(k("okhttp-eventsource-stream", dVar.f3524i));
        this.f3505w = new f4.a(executorServiceNewSingleThreadExecutor, dVar.f3522g, this.f3493c);
        this.f3506x = dVar.f3523h == null ? ConnectionErrorHandler.f3490a : dVar.f3523h;
        this.f3507y = new AtomicReference(ReadyState.RAW);
        this.f3508z = dVar.f3530o.b();
    }

    public static q f(q qVar) {
        q.a aVar = new q.a();
        for (String str : I.f()) {
            if (!qVar.f().contains(str)) {
                Iterator it = I.l(str).iterator();
                while (it.hasNext()) {
                    aVar.a(str, (String) it.next());
                }
            }
        }
        for (String str2 : qVar.f()) {
            Iterator it2 = qVar.l(str2).iterator();
            while (it2.hasNext()) {
                aVar.a(str2, (String) it2.next());
            }
        }
        return aVar.d();
    }

    public static int q(int i10) {
        if (i10 < 31) {
            return 1 << i10;
        }
        return Integer.MAX_VALUE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AtomicReference atomicReference = this.f3507y;
        ReadyState readyState = ReadyState.SHUTDOWN;
        ReadyState readyState2 = (ReadyState) atomicReference.getAndSet(readyState);
        this.f3493c.a("readyState change: {} -> {}", readyState2, readyState);
        if (readyState2 == readyState) {
            return;
        }
        j(readyState2);
        this.f3499q.shutdown();
        this.f3500r.shutdown();
        if (this.f3508z.i() != null) {
            this.f3508z.i().d();
        }
        if (this.f3508z.l() != null) {
            this.f3508z.l().a();
            if (this.f3508z.l().c() != null) {
                this.f3508z.l().c().shutdownNow();
            }
        }
    }

    public Duration g(int i10) {
        long jMin = Math.min(this.f3502t.toMillis(), this.f3501s.toMillis() * ((long) q(i10)));
        int i11 = jMin > 2147483647L ? Integer.MAX_VALUE : (int) jMin;
        return Duration.ofMillis((i11 / 2) + (this.B.nextInt(i11) / 2));
    }

    public w h() {
        w.a aVarF = new w.a().e(this.f3496n).k(this.f3495m).f(this.f3497o, this.f3498p);
        if (this.f3504v != null && !this.f3504v.isEmpty()) {
            aVarF.a("Last-Event-ID", this.f3504v);
        }
        return aVarF.b();
    }

    public final void j(ReadyState readyState) {
        if (readyState == ReadyState.OPEN) {
            this.f3505w.c();
        }
        if (this.A != null) {
            this.A.cancel();
            this.f3493c.b("call cancelled", null);
        }
    }

    public final ThreadFactory k(String str, Integer num) {
        return new ThreadFactoryC0048a(Executors.defaultThreadFactory(), str, new AtomicLong(0L), num);
    }

    public final ConnectionErrorHandler.Action l(Throwable th) {
        ConnectionErrorHandler.Action actionA = this.f3506x.a(th);
        if (actionA != ConnectionErrorHandler.Action.SHUTDOWN) {
            this.f3505w.onError(th);
        }
        return actionA;
    }

    public ReadyState m() {
        return (ReadyState) this.f3507y.get();
    }

    public final void n(y yVar) {
        String strO;
        c cVar = new c();
        AtomicReference atomicReference = this.f3507y;
        ReadyState readyState = ReadyState.OPEN;
        ReadyState readyState2 = (ReadyState) atomicReference.getAndSet(readyState);
        if (readyState2 != ReadyState.CONNECTING) {
            this.f3493c.d("Unexpected readyState change: " + readyState2 + " -> " + readyState);
        } else {
            this.f3493c.a("readyState change: {} -> {}", readyState2, readyState);
        }
        this.f3493c.c("Connected to EventSource stream.");
        this.f3505w.b();
        try {
            okio.e eVarB = k.b(yVar.a().h());
            try {
                f4.e eVar = new f4.e(this.f3495m.D(), this.f3505w, cVar, this.f3493c);
                while (!Thread.currentThread().isInterrupted() && !eVarB.C() && (strO = eVarB.O()) != null) {
                    eVar.c(strO);
                }
                if (eVarB != null) {
                    eVarB.close();
                }
            } catch (Throwable th) {
                if (eVarB != null) {
                    try {
                        eVarB.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (EOFException unused) {
        }
    }

    public final int o(int i10, long j10) {
        if (this.f3501s.isZero() || this.f3501s.isNegative()) {
            return i10;
        }
        if (j10 > 0 && System.currentTimeMillis() - j10 >= this.f3503u.toMillis()) {
            i10 = 1;
        }
        try {
            Duration durationG = g(i10);
            this.f3493c.c("Waiting " + durationG.toMillis() + " milliseconds before reconnecting...");
            Thread.sleep(durationG.toMillis());
        } catch (InterruptedException unused) {
        }
        return i10 + 1;
    }

    public final void p(AtomicLong atomicLong) {
        ConnectionErrorHandler.Action actionL = ConnectionErrorHandler.Action.PROCEED;
        AtomicReference atomicReference = this.f3507y;
        ReadyState readyState = ReadyState.CONNECTING;
        this.f3493c.a("readyState change: {} -> {}", (ReadyState) atomicReference.getAndSet(readyState), readyState);
        atomicLong.set(0L);
        this.A = this.f3508z.v(h());
        try {
            try {
                y yVarC = this.A.c();
                try {
                    if (yVarC.j()) {
                        atomicLong.set(System.currentTimeMillis());
                        n(yVarC);
                    } else {
                        this.f3493c.b("Unsuccessful response: {}", yVarC);
                        actionL = l(new UnsuccessfulResponseException(yVarC.c(), yVarC.a() == null ? null : yVarC.a().j()));
                    }
                    yVarC.close();
                    ReadyState readyState2 = (ReadyState) this.f3507y.get();
                    if (readyState2 != ReadyState.SHUTDOWN && readyState2 != ReadyState.CLOSED) {
                        this.f3493c.d("Connection unexpectedly closed");
                        actionL = this.f3506x.a(new EOFException());
                    }
                    if (actionL == ConnectionErrorHandler.Action.SHUTDOWN) {
                        this.f3493c.c("Connection has been explicitly shut down by error handler");
                        close();
                        return;
                    }
                    AtomicReference atomicReference2 = this.f3507y;
                    ReadyState readyState3 = ReadyState.OPEN;
                    ReadyState readyState4 = ReadyState.CLOSED;
                    boolean zA = autodispose2.c.a(atomicReference2, readyState3, readyState4);
                    boolean zA2 = autodispose2.c.a(this.f3507y, readyState, readyState4);
                    if (zA) {
                        this.f3493c.a("readyState change: {} -> {}", readyState3, readyState4);
                        this.f3505w.c();
                    } else if (zA2) {
                        this.f3493c.a("readyState change: {} -> {}", readyState, readyState4);
                    }
                } catch (Throwable th) {
                    if (yVarC != null) {
                        try {
                            yVarC.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                ReadyState readyState5 = (ReadyState) this.f3507y.get();
                if (readyState5 != ReadyState.SHUTDOWN && readyState5 != ReadyState.CLOSED) {
                    this.f3493c.b("Connection problem: {}", e10);
                    actionL = l(e10);
                }
                if (actionL == ConnectionErrorHandler.Action.SHUTDOWN) {
                    this.f3493c.c("Connection has been explicitly shut down by error handler");
                    close();
                    return;
                }
                AtomicReference atomicReference3 = this.f3507y;
                ReadyState readyState6 = ReadyState.OPEN;
                ReadyState readyState7 = ReadyState.CLOSED;
                boolean zA3 = autodispose2.c.a(atomicReference3, readyState6, readyState7);
                AtomicReference atomicReference4 = this.f3507y;
                ReadyState readyState8 = ReadyState.CONNECTING;
                boolean zA4 = autodispose2.c.a(atomicReference4, readyState8, readyState7);
                if (zA3) {
                    this.f3493c.a("readyState change: {} -> {}", readyState6, readyState7);
                    this.f3505w.c();
                } else if (zA4) {
                    this.f3493c.a("readyState change: {} -> {}", readyState8, readyState7);
                }
            }
        } catch (Throwable th3) {
            if (actionL != ConnectionErrorHandler.Action.SHUTDOWN) {
                AtomicReference atomicReference5 = this.f3507y;
                ReadyState readyState9 = ReadyState.OPEN;
                ReadyState readyState10 = ReadyState.CLOSED;
                boolean zA5 = autodispose2.c.a(atomicReference5, readyState9, readyState10);
                AtomicReference atomicReference6 = this.f3507y;
                ReadyState readyState11 = ReadyState.CONNECTING;
                boolean zA6 = autodispose2.c.a(atomicReference6, readyState11, readyState10);
                if (zA5) {
                    this.f3493c.a("readyState change: {} -> {}", readyState9, readyState10);
                    this.f3505w.c();
                } else if (zA6) {
                    this.f3493c.a("readyState change: {} -> {}", readyState11, readyState10);
                }
            } else {
                this.f3493c.c("Connection has been explicitly shut down by error handler");
                close();
            }
            throw th3;
        }
    }

    public final void r() {
        AtomicLong atomicLong = new AtomicLong();
        int iO = 0;
        while (!Thread.currentThread().isInterrupted() && this.f3507y.get() != ReadyState.SHUTDOWN) {
            try {
                iO = iO == 0 ? iO + 1 : o(iO, atomicLong.get());
                p(atomicLong);
            } catch (RejectedExecutionException e10) {
                this.A = null;
                this.f3493c.b("Rejected execution exception ignored: {}", e10);
                return;
            }
        }
    }

    public final void s(String str) {
        this.f3504v = str;
    }

    public final void t(Duration duration) {
        this.f3501s = duration;
    }

    public void u() {
        AtomicReference atomicReference = this.f3507y;
        ReadyState readyState = ReadyState.RAW;
        ReadyState readyState2 = ReadyState.CONNECTING;
        if (!autodispose2.c.a(atomicReference, readyState, readyState2)) {
            this.f3493c.c("Start method called on this already-started EventSource object. Doing nothing");
            return;
        }
        this.f3493c.a("readyState change: {} -> {}", readyState, readyState2);
        this.f3493c.c("Starting EventSource client using URI: " + this.f3495m);
        this.f3500r.execute(new b());
    }
}
