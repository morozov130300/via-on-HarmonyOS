package com.launchdarkly.eventsource;

import com.launchdarkly.eventsource.ConnectionErrorHandler;
import e4.l;
import e4.n;
import e4.o;
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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements Closeable {
    public static final Duration A = Duration.ofSeconds(1);
    public static final Duration B = Duration.ofSeconds(30);
    public static final Duration C = Duration.ofSeconds(10);
    public static final Duration D = Duration.ofSeconds(5);
    public static final Duration E = Duration.ofMinutes(5);
    public static final Duration F = Duration.ofSeconds(60);
    public static final q G = new q.a().a("Accept", "text/event-stream").a("Cache-Control", "no-cache").d();

    /* renamed from: e, reason: collision with root package name */
    public final l f4196e;

    /* renamed from: j, reason: collision with root package name */
    public final String f4197j;

    /* renamed from: k, reason: collision with root package name */
    public volatile r f4198k;

    /* renamed from: l, reason: collision with root package name */
    public final q f4199l;

    /* renamed from: m, reason: collision with root package name */
    public final String f4200m;

    /* renamed from: n, reason: collision with root package name */
    public final x f4201n;

    /* renamed from: o, reason: collision with root package name */
    public final ExecutorService f4202o;

    /* renamed from: p, reason: collision with root package name */
    public final ExecutorService f4203p;

    /* renamed from: q, reason: collision with root package name */
    public volatile Duration f4204q;

    /* renamed from: r, reason: collision with root package name */
    public final Duration f4205r;

    /* renamed from: s, reason: collision with root package name */
    public final Duration f4206s;

    /* renamed from: t, reason: collision with root package name */
    public volatile String f4207t;

    /* renamed from: u, reason: collision with root package name */
    public final e4.a f4208u;

    /* renamed from: v, reason: collision with root package name */
    public final ConnectionErrorHandler f4209v;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicReference f4210w;

    /* renamed from: x, reason: collision with root package name */
    public final u f4211x;

    /* renamed from: y, reason: collision with root package name */
    public volatile okhttp3.d f4212y;

    /* renamed from: z, reason: collision with root package name */
    public final Random f4213z = new Random();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.launchdarkly.eventsource.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0054a implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f4214e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f4215j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f4216k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Integer f4217l;

        public ThreadFactoryC0054a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Integer num) {
            this.f4214e = threadFactory;
            this.f4215j = str;
            this.f4216k = atomicLong;
            this.f4217l = num;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f4214e.newThread(runnable);
            threadNewThread.setName(String.format(Locale.ROOT, "%s-[%s]-%d", this.f4215j, a.this.f4197j, Long.valueOf(this.f4216k.getAndIncrement())));
            threadNewThread.setDaemon(true);
            Integer num = this.f4217l;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            return threadNewThread;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            a.this.r();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements e4.b {
        public c() {
        }

        @Override // e4.b
        public void a(Duration duration) {
            a.this.t(duration);
        }

        @Override // e4.b
        public void b(String str) {
            a.this.s(str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public String f4221a;

        /* renamed from: e, reason: collision with root package name */
        public String f4225e;

        /* renamed from: f, reason: collision with root package name */
        public final r f4226f;

        /* renamed from: g, reason: collision with root package name */
        public final e4.c f4227g;

        /* renamed from: k, reason: collision with root package name */
        public Proxy f4231k;

        /* renamed from: o, reason: collision with root package name */
        public u.b f4235o;

        /* renamed from: b, reason: collision with root package name */
        public Duration f4222b = a.A;

        /* renamed from: c, reason: collision with root package name */
        public Duration f4223c = a.B;

        /* renamed from: d, reason: collision with root package name */
        public Duration f4224d = a.F;

        /* renamed from: h, reason: collision with root package name */
        public ConnectionErrorHandler f4228h = ConnectionErrorHandler.f4193a;

        /* renamed from: i, reason: collision with root package name */
        public Integer f4229i = null;

        /* renamed from: j, reason: collision with root package name */
        public q f4230j = q.i(new String[0]);

        /* renamed from: l, reason: collision with root package name */
        public okhttp3.b f4232l = null;

        /* renamed from: m, reason: collision with root package name */
        public String f4233m = "GET";

        /* renamed from: n, reason: collision with root package name */
        public x f4234n = null;

        /* renamed from: p, reason: collision with root package name */
        public l f4236p = null;

        /* renamed from: q, reason: collision with root package name */
        public String f4237q = null;

        public d(e4.c cVar, r rVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("handler must not be null");
            }
            if (rVar == null) {
                throw new IllegalArgumentException("URI/URL must not be null");
            }
            this.f4226f = rVar;
            this.f4227g = cVar;
            this.f4235o = t();
        }

        public static /* synthetic */ e n(d dVar) {
            dVar.getClass();
            return null;
        }

        public static u.b t() {
            u.b bVarJ = new u.b().e(new h(1, 1L, TimeUnit.SECONDS)).d(a.C).i(a.E).m(a.D).j(true);
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
            this.f4234n = xVar;
            return this;
        }

        public a r() {
            Proxy proxy = this.f4231k;
            if (proxy != null) {
                this.f4235o.f(proxy);
            }
            okhttp3.b bVar = this.f4232l;
            if (bVar != null) {
                this.f4235o.g(bVar);
            }
            return new a(this);
        }

        public d s(u uVar) {
            this.f4235o = uVar.u();
            return this;
        }

        public d v(q qVar) {
            this.f4230j = qVar;
            return this;
        }

        public d w(l lVar) {
            this.f4236p = lVar;
            return this;
        }

        public d x(String str) {
            this.f4233m = (str == null || str.length() <= 0) ? "GET" : str.toUpperCase();
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface e {
    }

    public a(d dVar) {
        String str = "";
        String str2 = dVar.f4221a == null ? "" : dVar.f4221a;
        this.f4197j = str2;
        if (dVar.f4236p == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dVar.f4237q == null ? a.class.getCanonicalName() : dVar.f4237q);
            if (!str2.isEmpty()) {
                str = "." + str2;
            }
            sb2.append(str);
            this.f4196e = new o(sb2.toString());
        } else {
            this.f4196e = dVar.f4236p;
        }
        this.f4198k = dVar.f4226f;
        this.f4199l = g(dVar.f4230j);
        this.f4200m = dVar.f4233m;
        this.f4201n = dVar.f4234n;
        d.n(dVar);
        this.f4207t = dVar.f4225e;
        this.f4204q = dVar.f4222b;
        this.f4205r = dVar.f4223c;
        this.f4206s = dVar.f4224d;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(k("okhttp-eventsource-events", dVar.f4229i));
        this.f4202o = executorServiceNewSingleThreadExecutor;
        this.f4203p = Executors.newSingleThreadExecutor(k("okhttp-eventsource-stream", dVar.f4229i));
        this.f4208u = new e4.a(executorServiceNewSingleThreadExecutor, dVar.f4227g, this.f4196e);
        this.f4209v = dVar.f4228h == null ? ConnectionErrorHandler.f4193a : dVar.f4228h;
        this.f4210w = new AtomicReference(ReadyState.RAW);
        this.f4211x = dVar.f4235o.b();
    }

    public static q g(q qVar) {
        q.a aVar = new q.a();
        for (String str : G.f()) {
            if (!qVar.f().contains(str)) {
                Iterator it = G.l(str).iterator();
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
    public void close() throws IOException {
        AtomicReference atomicReference = this.f4210w;
        ReadyState readyState = ReadyState.SHUTDOWN;
        ReadyState readyState2 = (ReadyState) atomicReference.getAndSet(readyState);
        this.f4196e.a("readyState change: {} -> {}", readyState2, readyState);
        if (readyState2 == readyState) {
            return;
        }
        j(readyState2);
        this.f4202o.shutdown();
        this.f4203p.shutdown();
        if (this.f4211x.e() != null) {
            this.f4211x.e().d();
        }
        if (this.f4211x.l() != null) {
            this.f4211x.l().a();
            if (this.f4211x.l().c() != null) {
                this.f4211x.l().c().shutdownNow();
            }
        }
    }

    public Duration h(int i10) {
        long jMin = Math.min(this.f4205r.toMillis(), this.f4204q.toMillis() * q(i10));
        int i11 = jMin > 2147483647L ? Integer.MAX_VALUE : (int) jMin;
        return Duration.ofMillis((i11 / 2) + (this.f4213z.nextInt(i11) / 2));
    }

    public w i() {
        w.a aVarF = new w.a().e(this.f4199l).k(this.f4198k).f(this.f4200m, this.f4201n);
        if (this.f4207t != null && !this.f4207t.isEmpty()) {
            aVarF.a("Last-Event-ID", this.f4207t);
        }
        return aVarF.b();
    }

    public final void j(ReadyState readyState) {
        if (readyState == ReadyState.OPEN) {
            this.f4208u.d();
        }
        if (this.f4212y != null) {
            this.f4212y.cancel();
            this.f4196e.b("call cancelled", null);
        }
    }

    public final ThreadFactory k(String str, Integer num) {
        return new ThreadFactoryC0054a(Executors.defaultThreadFactory(), str, new AtomicLong(0L), num);
    }

    public final ConnectionErrorHandler.Action l(Throwable th) {
        ConnectionErrorHandler.Action actionA = this.f4209v.a(th);
        if (actionA != ConnectionErrorHandler.Action.SHUTDOWN) {
            this.f4208u.onError(th);
        }
        return actionA;
    }

    public ReadyState m() {
        return (ReadyState) this.f4210w.get();
    }

    public final void n(y yVar) {
        String strN;
        c cVar = new c();
        AtomicReference atomicReference = this.f4210w;
        ReadyState readyState = ReadyState.OPEN;
        ReadyState readyState2 = (ReadyState) atomicReference.getAndSet(readyState);
        if (readyState2 != ReadyState.CONNECTING) {
            this.f4196e.d("Unexpected readyState change: " + readyState2 + " -> " + readyState);
        } else {
            this.f4196e.a("readyState change: {} -> {}", readyState2, readyState);
        }
        this.f4196e.c("Connected to EventSource stream.");
        this.f4208u.b();
        try {
            okio.e eVarB = k.b(yVar.a().i());
            try {
                e4.e eVar = new e4.e(this.f4198k.C(), this.f4208u, cVar, this.f4196e);
                while (!Thread.currentThread().isInterrupted() && !eVarB.C() && (strN = eVarB.N()) != null) {
                    eVar.c(strN);
                }
                if (eVarB != null) {
                    eVarB.close();
                }
            } finally {
            }
        } catch (EOFException unused) {
        }
    }

    public final int o(int i10, long j10) throws InterruptedException {
        if (this.f4204q.isZero() || this.f4204q.isNegative()) {
            return i10;
        }
        if (j10 > 0 && System.currentTimeMillis() - j10 >= this.f4206s.toMillis()) {
            i10 = 1;
        }
        try {
            Duration durationH = h(i10);
            this.f4196e.c("Waiting " + durationH.toMillis() + " milliseconds before reconnecting...");
            Thread.sleep(durationH.toMillis());
        } catch (InterruptedException unused) {
        }
        return i10 + 1;
    }

    public final void p(AtomicLong atomicLong) throws IOException {
        ConnectionErrorHandler.Action actionL = ConnectionErrorHandler.Action.PROCEED;
        AtomicReference atomicReference = this.f4210w;
        ReadyState readyState = ReadyState.CONNECTING;
        this.f4196e.a("readyState change: {} -> {}", (ReadyState) atomicReference.getAndSet(readyState), readyState);
        atomicLong.set(0L);
        this.f4212y = this.f4211x.v(i());
        try {
            try {
                y yVarF = this.f4212y.f();
                try {
                    if (yVarF.j()) {
                        atomicLong.set(System.currentTimeMillis());
                        n(yVarF);
                    } else {
                        this.f4196e.b("Unsuccessful response: {}", yVarF);
                        actionL = l(new UnsuccessfulResponseException(yVarF.d(), yVarF.a() == null ? null : yVarF.a().j()));
                    }
                    yVarF.close();
                    ReadyState readyState2 = (ReadyState) this.f4210w.get();
                    if (readyState2 != ReadyState.SHUTDOWN && readyState2 != ReadyState.CLOSED) {
                        this.f4196e.d("Connection unexpectedly closed");
                        actionL = this.f4209v.a(new EOFException());
                    }
                    if (actionL == ConnectionErrorHandler.Action.SHUTDOWN) {
                        this.f4196e.c("Connection has been explicitly shut down by error handler");
                        close();
                        return;
                    }
                    AtomicReference atomicReference2 = this.f4210w;
                    ReadyState readyState3 = ReadyState.OPEN;
                    ReadyState readyState4 = ReadyState.CLOSED;
                    boolean zA = autodispose2.c.a(atomicReference2, readyState3, readyState4);
                    boolean zA2 = autodispose2.c.a(this.f4210w, readyState, readyState4);
                    if (zA) {
                        this.f4196e.a("readyState change: {} -> {}", readyState3, readyState4);
                        this.f4208u.d();
                    } else if (zA2) {
                        this.f4196e.a("readyState change: {} -> {}", readyState, readyState4);
                    }
                } catch (Throwable th) {
                    if (yVarF != null) {
                        try {
                            yVarF.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                ReadyState readyState5 = (ReadyState) this.f4210w.get();
                if (readyState5 != ReadyState.SHUTDOWN && readyState5 != ReadyState.CLOSED) {
                    this.f4196e.b("Connection problem: {}", e10);
                    actionL = l(e10);
                }
                if (actionL == ConnectionErrorHandler.Action.SHUTDOWN) {
                    this.f4196e.c("Connection has been explicitly shut down by error handler");
                    close();
                    return;
                }
                AtomicReference atomicReference3 = this.f4210w;
                ReadyState readyState6 = ReadyState.OPEN;
                ReadyState readyState7 = ReadyState.CLOSED;
                boolean zA3 = autodispose2.c.a(atomicReference3, readyState6, readyState7);
                AtomicReference atomicReference4 = this.f4210w;
                ReadyState readyState8 = ReadyState.CONNECTING;
                boolean zA4 = autodispose2.c.a(atomicReference4, readyState8, readyState7);
                if (zA3) {
                    this.f4196e.a("readyState change: {} -> {}", readyState6, readyState7);
                    this.f4208u.d();
                } else if (zA4) {
                    this.f4196e.a("readyState change: {} -> {}", readyState8, readyState7);
                }
            }
        } catch (Throwable th3) {
            if (actionL != ConnectionErrorHandler.Action.SHUTDOWN) {
                AtomicReference atomicReference5 = this.f4210w;
                ReadyState readyState9 = ReadyState.OPEN;
                ReadyState readyState10 = ReadyState.CLOSED;
                boolean zA5 = autodispose2.c.a(atomicReference5, readyState9, readyState10);
                AtomicReference atomicReference6 = this.f4210w;
                ReadyState readyState11 = ReadyState.CONNECTING;
                boolean zA6 = autodispose2.c.a(atomicReference6, readyState11, readyState10);
                if (zA5) {
                    this.f4196e.a("readyState change: {} -> {}", readyState9, readyState10);
                    this.f4208u.d();
                } else if (zA6) {
                    this.f4196e.a("readyState change: {} -> {}", readyState11, readyState10);
                }
            } else {
                this.f4196e.c("Connection has been explicitly shut down by error handler");
                close();
            }
            throw th3;
        }
    }

    public final void r() throws IOException {
        AtomicLong atomicLong = new AtomicLong();
        int iO = 0;
        while (!Thread.currentThread().isInterrupted() && this.f4210w.get() != ReadyState.SHUTDOWN) {
            try {
                iO = iO == 0 ? iO + 1 : o(iO, atomicLong.get());
                p(atomicLong);
            } catch (RejectedExecutionException e10) {
                this.f4212y = null;
                this.f4196e.b("Rejected execution exception ignored: {}", e10);
                return;
            }
        }
    }

    public final void s(String str) {
        this.f4207t = str;
    }

    public final void t(Duration duration) {
        this.f4204q = duration;
    }

    public void u() {
        AtomicReference atomicReference = this.f4210w;
        ReadyState readyState = ReadyState.RAW;
        ReadyState readyState2 = ReadyState.CONNECTING;
        if (!autodispose2.c.a(atomicReference, readyState, readyState2)) {
            this.f4196e.c("Start method called on this already-started EventSource object. Doing nothing");
            return;
        }
        this.f4196e.a("readyState change: {} -> {}", readyState, readyState2);
        this.f4196e.c("Starting EventSource client using URI: " + this.f4198k);
        this.f4203p.execute(new b());
    }
}
