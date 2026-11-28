package zb;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Closeable {
    public static final ExecutorService E = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), ub.c.G("OkHttp Http2Connection", true));
    public final Socket A;
    public final zb.h B;
    public final j C;
    public final Set D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15590c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f15591e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f15593n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15594o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15595p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15596q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ScheduledExecutorService f15597r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ExecutorService f15598s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final zb.j f15599t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15600u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f15602w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k f15604y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f15605z;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f15592m = new LinkedHashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f15601v = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k f15603x = new k();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15606e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ErrorCode f15607m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i10, ErrorCode errorCode) {
            super(str, objArr);
            this.f15606e = i10;
            this.f15607m = errorCode;
        }

        @Override // ub.b
        public void k() {
            try {
                e.this.W(this.f15606e, this.f15607m);
            } catch (IOException unused) {
                e.this.g();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15609e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f15610m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i10, long j10) {
            super(str, objArr);
            this.f15609e = i10;
            this.f15610m = j10;
        }

        @Override // ub.b
        public void k() {
            try {
                e.this.B.p(this.f15609e, this.f15610m);
            } catch (IOException unused) {
                e.this.g();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15612e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ List f15613m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, int i10, List list) {
            super(str, objArr);
            this.f15612e = i10;
            this.f15613m = list;
        }

        @Override // ub.b
        public void k() {
            if (e.this.f15599t.a(this.f15612e, this.f15613m)) {
                try {
                    e.this.B.m(this.f15612e, ErrorCode.CANCEL);
                    synchronized (e.this) {
                        try {
                            e.this.D.remove(Integer.valueOf(this.f15612e));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15615e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ List f15616m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f15617n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i10, List list, boolean z10) {
            super(str, objArr);
            this.f15615e = i10;
            this.f15616m = list;
            this.f15617n = z10;
        }

        @Override // ub.b
        public void k() {
            boolean zB = e.this.f15599t.b(this.f15615e, this.f15616m, this.f15617n);
            if (zB) {
                try {
                    e.this.B.m(this.f15615e, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zB || this.f15617n) {
                synchronized (e.this) {
                    try {
                        e.this.D.remove(Integer.valueOf(this.f15615e));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: zb.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0168e extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15619e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ okio.c f15620m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f15621n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f15622o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0168e(String str, Object[] objArr, int i10, okio.c cVar, int i11, boolean z10) {
            super(str, objArr);
            this.f15619e = i10;
            this.f15620m = cVar;
            this.f15621n = i11;
            this.f15622o = z10;
        }

        @Override // ub.b
        public void k() {
            try {
                boolean zD = e.this.f15599t.d(this.f15619e, this.f15620m, this.f15621n, this.f15622o);
                if (zD) {
                    e.this.B.m(this.f15619e, ErrorCode.CANCEL);
                }
                if (zD || this.f15622o) {
                    synchronized (e.this) {
                        e.this.D.remove(Integer.valueOf(this.f15619e));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15624e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ErrorCode f15625m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i10, ErrorCode errorCode) {
            super(str, objArr);
            this.f15624e = i10;
            this.f15625m = errorCode;
        }

        @Override // ub.b
        public void k() {
            e.this.f15599t.c(this.f15624e, this.f15625m);
            synchronized (e.this) {
                e.this.D.remove(Integer.valueOf(this.f15624e));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Socket f15627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public okio.e f15629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public okio.d f15630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h f15631e = h.f15635a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public zb.j f15632f = zb.j.f15694a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15634h;

        public g(boolean z10) {
            this.f15633g = z10;
        }

        public e a() {
            return new e(this);
        }

        public g b(h hVar) {
            this.f15631e = hVar;
            return this;
        }

        public g c(int i10) {
            this.f15634h = i10;
            return this;
        }

        public g d(Socket socket, String str, okio.e eVar, okio.d dVar) {
            this.f15627a = socket;
            this.f15628b = str;
            this.f15629c = eVar;
            this.f15630d = dVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class i extends ub.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f15636e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f15637m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f15638n;

        public i(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", e.this.f15593n, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f15636e = z10;
            this.f15637m = i10;
            this.f15638n = i11;
        }

        @Override // ub.b
        public void k() {
            e.this.J(this.f15636e, this.f15637m, this.f15638n);
        }
    }

    public e(g gVar) {
        k kVar = new k();
        this.f15604y = kVar;
        this.f15605z = false;
        this.D = new LinkedHashSet();
        this.f15599t = gVar.f15632f;
        boolean z10 = gVar.f15633g;
        this.f15590c = z10;
        this.f15591e = gVar.f15631e;
        int i10 = z10 ? 1 : 2;
        this.f15595p = i10;
        if (z10) {
            this.f15595p = i10 + 2;
        }
        if (z10) {
            this.f15603x.i(7, 16777216);
        }
        String str = gVar.f15628b;
        this.f15593n = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, ub.c.G(ub.c.r("OkHttp %s Writer", str), false));
        this.f15597r = scheduledThreadPoolExecutor;
        if (gVar.f15634h != 0) {
            i iVar = new i(false, 0, 0);
            int i11 = gVar.f15634h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.f15598s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), ub.c.G(ub.c.r("OkHttp %s Push Observer", str), true));
        kVar.i(7, 65535);
        kVar.i(5, 16384);
        this.f15602w = kVar.d();
        this.A = gVar.f15627a;
        this.B = new zb.h(gVar.f15630d, z10);
        this.C = new j(new zb.f(gVar.f15629c, z10));
    }

    public void J(boolean z10, int i10, int i11) {
        boolean z11;
        if (!z10) {
            synchronized (this) {
                z11 = this.f15600u;
                this.f15600u = true;
            }
            if (z11) {
                g();
                return;
            }
        }
        try {
            this.B.k(z10, i10, i11);
        } catch (IOException unused) {
            g();
        }
    }

    public void W(int i10, ErrorCode errorCode) {
        this.B.m(i10, errorCode);
    }

    public void b0(int i10, ErrorCode errorCode) {
        try {
            this.f15597r.execute(new a("OkHttp %s stream %d", new Object[]{this.f15593n, Integer.valueOf(i10)}, i10, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void c0(int i10, long j10) {
        try {
            this.f15597r.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f15593n, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void f(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        zb.g[] gVarArr = null;
        try {
            t(errorCode);
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        synchronized (this) {
            try {
                if (!this.f15592m.isEmpty()) {
                    gVarArr = (zb.g[]) this.f15592m.values().toArray(new zb.g[this.f15592m.size()]);
                    this.f15592m.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (gVarArr != null) {
            for (zb.g gVar : gVarArr) {
                try {
                    gVar.f(errorCode2);
                } catch (IOException e11) {
                    if (e != null) {
                        e = e11;
                    }
                }
            }
        }
        try {
            this.B.close();
        } catch (IOException e12) {
            if (e == null) {
                e = e12;
            }
        }
        try {
            this.A.close();
        } catch (IOException e13) {
            e = e13;
        }
        this.f15597r.shutdown();
        this.f15598s.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void flush() {
        this.B.flush();
    }

    public final void g() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            f(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    public synchronized zb.g h(int i10) {
        return (zb.g) this.f15592m.get(Integer.valueOf(i10));
    }

    public synchronized boolean isShutdown() {
        return this.f15596q;
    }

    public synchronized int j() {
        return this.f15604y.e(Integer.MAX_VALUE);
    }

    public final zb.g k(int i10, List list, boolean z10) throws Throwable {
        Throwable th;
        boolean z11 = !z10;
        synchronized (this.B) {
            try {
                try {
                    try {
                        synchronized (this) {
                            try {
                                if (this.f15595p > 1073741823) {
                                    try {
                                        t(ErrorCode.REFUSED_STREAM);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                if (this.f15596q) {
                                    throw new ConnectionShutdownException();
                                }
                                int i11 = this.f15595p;
                                this.f15595p = i11 + 2;
                                zb.g gVar = new zb.g(i11, this, z11, false, null);
                                boolean z12 = !z10 || this.f15602w == 0 || gVar.f15659b == 0;
                                if (gVar.m()) {
                                    this.f15592m.put(Integer.valueOf(i11), gVar);
                                }
                                if (i10 == 0) {
                                    this.B.o(z11, i11, i10, list);
                                } else {
                                    if (this.f15590c) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.B.l(i10, i11, list);
                                }
                                if (z12) {
                                    this.B.flush();
                                }
                                return gVar;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public zb.g l(List list, boolean z10) {
        return k(0, list, z10);
    }

    public void m(int i10, okio.e eVar, int i11, boolean z10) throws IOException {
        okio.c cVar = new okio.c();
        long j10 = i11;
        eVar.X(j10);
        eVar.U(cVar, j10);
        if (cVar.size() == j10) {
            n(new C0168e("OkHttp %s Push Data[%s]", new Object[]{this.f15593n, Integer.valueOf(i10)}, i10, cVar, i11, z10));
            return;
        }
        throw new IOException(cVar.size() + " != " + i11);
    }

    public final synchronized void n(ub.b bVar) {
        if (!isShutdown()) {
            this.f15598s.execute(bVar);
        }
    }

    public void o(int i10, List list, boolean z10) {
        try {
            try {
                n(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f15593n, Integer.valueOf(i10)}, i10, list, z10));
            } catch (RejectedExecutionException unused) {
            }
        } catch (RejectedExecutionException unused2) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x0046
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void p(int r9, java.util.List r10) throws java.lang.Throwable {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set r0 = r8.D     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L18
            okhttp3.internal.http2.ErrorCode r10 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r8.b0(r9, r10)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L44
        L18:
            java.util.Set r0 = r8.D     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L41
            zb.e$c r2 = new zb.e$c     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.f15593n     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 0
            r5[r3] = r0     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r0 = 1
            r5[r0] = r1     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5, r6, r7)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            r8.n(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            return
        L3f:
            r3 = r8
        L40:
            return
        L41:
            r0 = move-exception
            r3 = r8
        L43:
            r9 = r0
        L44:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L46
            throw r9
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.e.p(int, java.util.List):void");
    }

    public void q(int i10, ErrorCode errorCode) {
        n(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f15593n, Integer.valueOf(i10)}, i10, errorCode));
    }

    public boolean r(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public synchronized zb.g s(int i10) {
        zb.g gVar;
        gVar = (zb.g) this.f15592m.remove(Integer.valueOf(i10));
        notifyAll();
        return gVar;
    }

    public void t(ErrorCode errorCode) {
        synchronized (this.B) {
            synchronized (this) {
                if (this.f15596q) {
                    return;
                }
                this.f15596q = true;
                this.B.g(this.f15594o, errorCode, ub.c.f12945a);
            }
        }
    }

    public void u() {
        v(true);
    }

    public void v(boolean z10) {
        if (z10) {
            this.B.b();
            this.B.n(this.f15603x);
            int iD = this.f15603x.d();
            if (iD != 65535) {
                this.B.p(0, iD - 65535);
            }
        }
        new Thread(this.C).start();
    }

    public synchronized void w(long j10) {
        long j11 = this.f15601v + j10;
        this.f15601v = j11;
        if (j11 >= this.f15603x.d() / 2) {
            c0(0, this.f15601v);
            this.f15601v = 0L;
        }
    }

    public void x(int i10, boolean z10, okio.c cVar, long j10) {
        long j11;
        int iMin;
        long j12;
        if (j10 == 0) {
            this.B.c(z10, i10, cVar, 0);
            return;
        }
        while (j10 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j11 = this.f15602w;
                            if (j11 <= 0) {
                                if (!this.f15592m.containsKey(Integer.valueOf(i10))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j10, j11), this.B.j());
                j12 = iMin;
                this.f15602w -= j12;
            }
            j10 -= j12;
            this.B.c(z10 && j10 == 0, i10, cVar, iMin);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f15635a = new a();

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends h {
            @Override // zb.e.h
            public void b(zb.g gVar) {
                gVar.f(ErrorCode.REFUSED_STREAM);
            }
        }

        public abstract void b(zb.g gVar);

        public void a(e eVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class j extends ub.b implements zb.f.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final zb.f f15640e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends ub.b {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ zb.g f15642e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, zb.g gVar) {
                super(str, objArr);
                this.f15642e = gVar;
            }

            @Override // ub.b
            public void k() {
                try {
                    e.this.f15591e.b(this.f15642e);
                } catch (IOException e10) {
                    ac.f.j().p(4, "Http2Connection.Listener failure for " + e.this.f15593n, e10);
                    try {
                        this.f15642e.f(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b extends ub.b {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // ub.b
            public void k() {
                e eVar = e.this;
                eVar.f15591e.a(eVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class c extends ub.b {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ k f15645e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, k kVar) {
                super(str, objArr);
                this.f15645e = kVar;
            }

            @Override // ub.b
            public void k() {
                try {
                    e.this.B.a(this.f15645e);
                } catch (IOException unused) {
                    e.this.g();
                }
            }
        }

        public j(zb.f fVar) {
            super("OkHttp %s", e.this.f15593n);
            this.f15640e = fVar;
        }

        @Override // zb.f.b
        public void a(boolean z10, k kVar) {
            zb.g[] gVarArr;
            long j10;
            int i10;
            synchronized (e.this) {
                try {
                    int iD = e.this.f15604y.d();
                    if (z10) {
                        e.this.f15604y.a();
                    }
                    e.this.f15604y.h(kVar);
                    l(kVar);
                    int iD2 = e.this.f15604y.d();
                    gVarArr = null;
                    if (iD2 == -1 || iD2 == iD) {
                        j10 = 0;
                    } else {
                        j10 = iD2 - iD;
                        e eVar = e.this;
                        if (!eVar.f15605z) {
                            eVar.f15605z = true;
                        }
                        if (!eVar.f15592m.isEmpty()) {
                            gVarArr = (zb.g[]) e.this.f15592m.values().toArray(new zb.g[e.this.f15592m.size()]);
                        }
                    }
                    e.E.execute(new b("OkHttp %s settings", e.this.f15593n));
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (gVarArr == null || j10 == 0) {
                return;
            }
            for (zb.g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.c(j10);
                }
            }
        }

        @Override // zb.f.b
        public void c(boolean z10, int i10, int i11, List list) {
            if (e.this.r(i10)) {
                e.this.o(i10, list, z10);
                return;
            }
            synchronized (e.this) {
                try {
                    zb.g gVarH = e.this.h(i10);
                    if (gVarH != null) {
                        gVarH.q(list);
                        if (z10) {
                            gVarH.p();
                            return;
                        }
                        return;
                    }
                    e eVar = e.this;
                    if (eVar.f15596q) {
                        return;
                    }
                    if (i10 <= eVar.f15594o) {
                        return;
                    }
                    if (i10 % 2 == eVar.f15595p % 2) {
                        return;
                    }
                    zb.g gVar = new zb.g(i10, e.this, false, z10, ub.c.H(list));
                    e eVar2 = e.this;
                    eVar2.f15594o = i10;
                    eVar2.f15592m.put(Integer.valueOf(i10), gVar);
                    e.E.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f15593n, Integer.valueOf(i10)}, gVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // zb.f.b
        public void d(int i10, long j10) {
            if (i10 == 0) {
                synchronized (e.this) {
                    e eVar = e.this;
                    eVar.f15602w += j10;
                    eVar.notifyAll();
                }
                return;
            }
            zb.g gVarH = e.this.h(i10);
            if (gVarH != null) {
                synchronized (gVarH) {
                    gVarH.c(j10);
                }
            }
        }

        @Override // zb.f.b
        public void e(boolean z10, int i10, okio.e eVar, int i11) throws IOException {
            if (e.this.r(i10)) {
                e.this.m(i10, eVar, i11, z10);
                return;
            }
            zb.g gVarH = e.this.h(i10);
            if (gVarH == null) {
                e.this.b0(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                e.this.w(j10);
                eVar.skip(j10);
                return;
            }
            gVarH.o(eVar, i11);
            if (z10) {
                gVarH.p();
            }
        }

        @Override // zb.f.b
        public void f(boolean z10, int i10, int i11) {
            if (!z10) {
                try {
                    e.this.f15597r.execute(e.this.new i(true, i10, i11));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (e.this) {
                    e.this.f15600u = false;
                    e.this.notifyAll();
                }
            }
        }

        @Override // zb.f.b
        public void h(int i10, ErrorCode errorCode) {
            if (e.this.r(i10)) {
                e.this.q(i10, errorCode);
                return;
            }
            zb.g gVarS = e.this.s(i10);
            if (gVarS != null) {
                gVarS.r(errorCode);
            }
        }

        @Override // zb.f.b
        public void i(int i10, int i11, List list) throws Throwable {
            e.this.p(i11, list);
        }

        @Override // zb.f.b
        public void j(int i10, ErrorCode errorCode, ByteString byteString) {
            zb.g[] gVarArr;
            byteString.size();
            synchronized (e.this) {
                gVarArr = (zb.g[]) e.this.f15592m.values().toArray(new zb.g[e.this.f15592m.size()]);
                e.this.f15596q = true;
            }
            for (zb.g gVar : gVarArr) {
                if (gVar.i() > i10 && gVar.l()) {
                    gVar.r(ErrorCode.REFUSED_STREAM);
                    e.this.s(gVar.i());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // ub.b
        public void k() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f15640e.c(this);
                        while (this.f15640e.b(false, this)) {
                        }
                        ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                        try {
                            errorCode2 = ErrorCode.CANCEL;
                            e.this.f(errorCode3, errorCode2);
                            errorCode = errorCode3;
                        } catch (IOException unused) {
                            errorCode2 = ErrorCode.PROTOCOL_ERROR;
                            e eVar = e.this;
                            eVar.f(errorCode2, errorCode2);
                            errorCode = eVar;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            e.this.f(errorCode, errorCode2);
                        } catch (IOException unused2) {
                        }
                        ub.c.g(this.f15640e);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode2;
                    e.this.f(errorCode, errorCode2);
                    ub.c.g(this.f15640e);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            ub.c.g(this.f15640e);
        }

        public final void l(k kVar) {
            try {
                e.this.f15597r.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f15593n}, kVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // zb.f.b
        public void b() {
        }

        @Override // zb.f.b
        public void g(int i10, int i11, int i12, boolean z10) {
        }
    }
}
