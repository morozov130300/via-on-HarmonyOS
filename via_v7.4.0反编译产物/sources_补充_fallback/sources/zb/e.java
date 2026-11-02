package zb;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements java.io.Closeable {
    public static final java.util.concurrent.ExecutorService C = null;
    public final zb.e.j A;
    public final java.util.Set B;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14853e;

    /* renamed from: j, reason: collision with root package name */
    public final zb.e.h f14854j;

    /* renamed from: k, reason: collision with root package name */
    public final java.util.Map f14855k;

    /* renamed from: l, reason: collision with root package name */
    public final java.lang.String f14856l;

    /* renamed from: m, reason: collision with root package name */
    public int f14857m;

    /* renamed from: n, reason: collision with root package name */
    public int f14858n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14859o;

    /* renamed from: p, reason: collision with root package name */
    public final java.util.concurrent.ScheduledExecutorService f14860p;

    /* renamed from: q, reason: collision with root package name */
    public final java.util.concurrent.ExecutorService f14861q;

    /* renamed from: r, reason: collision with root package name */
    public final zb.j f14862r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14863s;

    /* renamed from: t, reason: collision with root package name */
    public long f14864t;

    /* renamed from: u, reason: collision with root package name */
    public long f14865u;

    /* renamed from: v, reason: collision with root package name */
    public zb.k f14866v;

    /* renamed from: w, reason: collision with root package name */
    public final zb.k f14867w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14868x;

    /* renamed from: y, reason: collision with root package name */
    public final java.net.Socket f14869y;

    /* renamed from: z, reason: collision with root package name */
    public final zb.h f14870z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14871j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ okhttp3.internal.http2.ErrorCode f14872k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ zb.e f14873l;

        public a(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, okhttp3.internal.http2.ErrorCode r5) {
                r0 = this;
                r0.f14873l = r1
                r0.f14871j = r4
                r0.f14872k = r5
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r3 = this;
                zb.e r0 = r3.f14873l     // Catch: java.io.IOException -> La
                int r1 = r3.f14871j     // Catch: java.io.IOException -> La
                okhttp3.internal.http2.ErrorCode r2 = r3.f14872k     // Catch: java.io.IOException -> La
                r0.W(r1, r2)     // Catch: java.io.IOException -> La
                return
            La:
                zb.e r0 = r3.f14873l
                zb.e.a(r0)
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14874j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f14875k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ zb.e f14876l;

        public b(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, long r5) {
                r0 = this;
                r0.f14876l = r1
                r0.f14874j = r4
                r0.f14875k = r5
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r4 = this;
                zb.e r0 = r4.f14876l     // Catch: java.io.IOException -> Lc
                zb.h r0 = r0.f14870z     // Catch: java.io.IOException -> Lc
                int r1 = r4.f14874j     // Catch: java.io.IOException -> Lc
                long r2 = r4.f14875k     // Catch: java.io.IOException -> Lc
                r0.p(r1, r2)     // Catch: java.io.IOException -> Lc
                return
            Lc:
                zb.e r0 = r4.f14876l
                zb.e.a(r0)
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14877j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ java.util.List f14878k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ zb.e f14879l;

        public c(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, java.util.List r5) {
                r0 = this;
                r0.f14879l = r1
                r0.f14877j = r4
                r0.f14878k = r5
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r3 = this;
                zb.e r0 = r3.f14879l
                zb.j r0 = r0.f14862r
                int r1 = r3.f14877j
                java.util.List r2 = r3.f14878k
                boolean r0 = r0.a(r1, r2)
                if (r0 == 0) goto L2e
                zb.e r0 = r3.f14879l     // Catch: java.io.IOException -> L2e
                zb.h r0 = r0.f14870z     // Catch: java.io.IOException -> L2e
                int r1 = r3.f14877j     // Catch: java.io.IOException -> L2e
                okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.io.IOException -> L2e
                r0.m(r1, r2)     // Catch: java.io.IOException -> L2e
                zb.e r0 = r3.f14879l     // Catch: java.io.IOException -> L2e
                monitor-enter(r0)     // Catch: java.io.IOException -> L2e
                zb.e r1 = r3.f14879l     // Catch: java.lang.Throwable -> L2b
                java.util.Set r1 = r1.B     // Catch: java.lang.Throwable -> L2b
                int r2 = r3.f14877j     // Catch: java.lang.Throwable -> L2b
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L2b
                r1.remove(r2)     // Catch: java.lang.Throwable -> L2b
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                return
            L2b:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                throw r1     // Catch: java.io.IOException -> L2e
            L2e:
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14880j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ java.util.List f14881k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f14882l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ zb.e f14883m;

        public d(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, java.util.List r5, boolean r6) {
                r0 = this;
                r0.f14883m = r1
                r0.f14880j = r4
                r0.f14881k = r5
                r0.f14882l = r6
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r4 = this;
                zb.e r0 = r4.f14883m
                zb.j r0 = r0.f14862r
                int r1 = r4.f14880j
                java.util.List r2 = r4.f14881k
                boolean r3 = r4.f14882l
                boolean r0 = r0.b(r1, r2, r3)
                if (r0 == 0) goto L1b
                zb.e r1 = r4.f14883m     // Catch: java.io.IOException -> L36
                zb.h r1 = r1.f14870z     // Catch: java.io.IOException -> L36
                int r2 = r4.f14880j     // Catch: java.io.IOException -> L36
                okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.io.IOException -> L36
                r1.m(r2, r3)     // Catch: java.io.IOException -> L36
            L1b:
                if (r0 != 0) goto L21
                boolean r0 = r4.f14882l     // Catch: java.io.IOException -> L36
                if (r0 == 0) goto L36
            L21:
                zb.e r0 = r4.f14883m     // Catch: java.io.IOException -> L36
                monitor-enter(r0)     // Catch: java.io.IOException -> L36
                zb.e r1 = r4.f14883m     // Catch: java.lang.Throwable -> L33
                java.util.Set r1 = r1.B     // Catch: java.lang.Throwable -> L33
                int r2 = r4.f14880j     // Catch: java.lang.Throwable -> L33
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L33
                r1.remove(r2)     // Catch: java.lang.Throwable -> L33
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L33
                return
            L33:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L33
                throw r1     // Catch: java.io.IOException -> L36
            L36:
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: zb.e$e, reason: collision with other inner class name */
    public class C0163e extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14884j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ okio.c f14885k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f14886l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f14887m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ zb.e f14888n;

        public C0163e(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, okio.c r5, int r6, boolean r7) {
                r0 = this;
                r0.f14888n = r1
                r0.f14884j = r4
                r0.f14885k = r5
                r0.f14886l = r6
                r0.f14887m = r7
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r5 = this;
                zb.e r0 = r5.f14888n     // Catch: java.io.IOException -> L38
                zb.j r0 = r0.f14862r     // Catch: java.io.IOException -> L38
                int r1 = r5.f14884j     // Catch: java.io.IOException -> L38
                okio.c r2 = r5.f14885k     // Catch: java.io.IOException -> L38
                int r3 = r5.f14886l     // Catch: java.io.IOException -> L38
                boolean r4 = r5.f14887m     // Catch: java.io.IOException -> L38
                boolean r0 = r0.d(r1, r2, r3, r4)     // Catch: java.io.IOException -> L38
                if (r0 == 0) goto L1d
                zb.e r1 = r5.f14888n     // Catch: java.io.IOException -> L38
                zb.h r1 = r1.f14870z     // Catch: java.io.IOException -> L38
                int r2 = r5.f14884j     // Catch: java.io.IOException -> L38
                okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.io.IOException -> L38
                r1.m(r2, r3)     // Catch: java.io.IOException -> L38
            L1d:
                if (r0 != 0) goto L23
                boolean r0 = r5.f14887m     // Catch: java.io.IOException -> L38
                if (r0 == 0) goto L38
            L23:
                zb.e r0 = r5.f14888n     // Catch: java.io.IOException -> L38
                monitor-enter(r0)     // Catch: java.io.IOException -> L38
                zb.e r1 = r5.f14888n     // Catch: java.lang.Throwable -> L35
                java.util.Set r1 = r1.B     // Catch: java.lang.Throwable -> L35
                int r2 = r5.f14884j     // Catch: java.lang.Throwable -> L35
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L35
                r1.remove(r2)     // Catch: java.lang.Throwable -> L35
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L35:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                throw r1     // Catch: java.io.IOException -> L38
            L38:
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f14889j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ okhttp3.internal.http2.ErrorCode f14890k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ zb.e f14891l;

        public f(zb.e r1, java.lang.String r2, java.lang.Object[] r3, int r4, okhttp3.internal.http2.ErrorCode r5) {
                r0 = this;
                r0.f14891l = r1
                r0.f14889j = r4
                r0.f14890k = r5
                r0.<init>(r2, r3)
                return
        }

        @Override // ub.b
        public void k() {
                r3 = this;
                zb.e r0 = r3.f14891l
                zb.j r0 = r0.f14862r
                int r1 = r3.f14889j
                okhttp3.internal.http2.ErrorCode r2 = r3.f14890k
                r0.c(r1, r2)
                zb.e r0 = r3.f14891l
                monitor-enter(r0)
                zb.e r1 = r3.f14891l     // Catch: java.lang.Throwable -> L1d
                java.util.Set r1 = r1.B     // Catch: java.lang.Throwable -> L1d
                int r2 = r3.f14889j     // Catch: java.lang.Throwable -> L1d
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L1d
                r1.remove(r2)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
                return
            L1d:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
                throw r1
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public java.net.Socket f14892a;

        /* renamed from: b, reason: collision with root package name */
        public java.lang.String f14893b;

        /* renamed from: c, reason: collision with root package name */
        public okio.e f14894c;

        /* renamed from: d, reason: collision with root package name */
        public okio.d f14895d;

        /* renamed from: e, reason: collision with root package name */
        public zb.e.h f14896e;

        /* renamed from: f, reason: collision with root package name */
        public zb.j f14897f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f14898g;

        /* renamed from: h, reason: collision with root package name */
        public int f14899h;

        public g(boolean r2) {
                r1 = this;
                r1.<init>()
                zb.e$h r0 = zb.e.h.f14900a
                r1.f14896e = r0
                zb.j r0 = zb.j.f14959a
                r1.f14897f = r0
                r1.f14898g = r2
                return
        }

        public zb.e a() {
                r1 = this;
                zb.e r0 = new zb.e
                r0.<init>(r1)
                return r0
        }

        public zb.e.g b(zb.e.h r1) {
                r0 = this;
                r0.f14896e = r1
                return r0
        }

        public zb.e.g c(int r1) {
                r0 = this;
                r0.f14899h = r1
                return r0
        }

        public zb.e.g d(java.net.Socket r1, java.lang.String r2, okio.e r3, okio.d r4) {
                r0 = this;
                r0.f14892a = r1
                r0.f14893b = r2
                r0.f14894c = r3
                r0.f14895d = r4
                return r0
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public static final zb.e.h f14900a = null;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a extends zb.e.h {
            public a() {
                    r0 = this;
                    r0.<init>()
                    return
            }

            @Override // zb.e.h
            public void b(zb.g r2) {
                    r1 = this;
                    okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM
                    r2.f(r0)
                    return
            }
        }

        static {
                zb.e$h$a r0 = new zb.e$h$a
                r0.<init>()
                zb.e.h.f14900a = r0
                return
        }

        public h() {
                r0 = this;
                r0.<init>()
                return
        }

        public void a(zb.e r1) {
                r0 = this;
                return
        }

        public abstract void b(zb.g r1);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class i extends ub.b {

        /* renamed from: j, reason: collision with root package name */
        public final boolean f14901j;

        /* renamed from: k, reason: collision with root package name */
        public final int f14902k;

        /* renamed from: l, reason: collision with root package name */
        public final int f14903l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ zb.e f14904m;

        public i(zb.e r5, boolean r6, int r7, int r8) {
                r4 = this;
                r4.f14904m = r5
                java.lang.String r5 = r5.f14856l
                java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                r2[r3] = r5
                r5 = 1
                r2[r5] = r0
                r5 = 2
                r2[r5] = r1
                java.lang.String r5 = "OkHttp %s ping %08x%08x"
                r4.<init>(r5, r2)
                r4.f14901j = r6
                r4.f14902k = r7
                r4.f14903l = r8
                return
        }

        @Override // ub.b
        public void k() {
                r4 = this;
                zb.e r0 = r4.f14904m
                boolean r1 = r4.f14901j
                int r2 = r4.f14902k
                int r3 = r4.f14903l
                r0.J(r1, r2, r3)
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class j extends ub.b implements zb.f.b {

        /* renamed from: j, reason: collision with root package name */
        public final zb.f f14905j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ zb.e f14906k;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a extends ub.b {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ zb.g f14907j;

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ zb.e.j f14908k;

            public a(zb.e.j r1, java.lang.String r2, java.lang.Object[] r3, zb.g r4) {
                    r0 = this;
                    r0.f14908k = r1
                    r0.f14907j = r4
                    r0.<init>(r2, r3)
                    return
            }

            @Override // ub.b
            public void k() {
                    r4 = this;
                    zb.e$j r0 = r4.f14908k     // Catch: java.io.IOException -> Lc
                    zb.e r0 = r0.f14906k     // Catch: java.io.IOException -> Lc
                    zb.e$h r0 = r0.f14854j     // Catch: java.io.IOException -> Lc
                    zb.g r1 = r4.f14907j     // Catch: java.io.IOException -> Lc
                    r0.b(r1)     // Catch: java.io.IOException -> Lc
                    return
                Lc:
                    r0 = move-exception
                    ac.f r1 = ac.f.j()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Http2Connection.Listener failure for "
                    r2.append(r3)
                    zb.e$j r3 = r4.f14908k
                    zb.e r3 = r3.f14906k
                    java.lang.String r3 = r3.f14856l
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r3 = 4
                    r1.p(r3, r2, r0)
                    zb.g r0 = r4.f14907j     // Catch: java.io.IOException -> L33
                    okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.io.IOException -> L33
                    r0.f(r1)     // Catch: java.io.IOException -> L33
                L33:
                    return
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class b extends ub.b {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ zb.e.j f14909j;

            public b(zb.e.j r1, java.lang.String r2, java.lang.Object... r3) {
                    r0 = this;
                    r0.f14909j = r1
                    r0.<init>(r2, r3)
                    return
            }

            @Override // ub.b
            public void k() {
                    r2 = this;
                    zb.e$j r0 = r2.f14909j
                    zb.e r0 = r0.f14906k
                    zb.e$h r1 = r0.f14854j
                    r1.a(r0)
                    return
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class c extends ub.b {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ zb.k f14910j;

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ zb.e.j f14911k;

            public c(zb.e.j r1, java.lang.String r2, java.lang.Object[] r3, zb.k r4) {
                    r0 = this;
                    r0.f14911k = r1
                    r0.f14910j = r4
                    r0.<init>(r2, r3)
                    return
            }

            @Override // ub.b
            public void k() {
                    r2 = this;
                    zb.e$j r0 = r2.f14911k     // Catch: java.io.IOException -> Lc
                    zb.e r0 = r0.f14906k     // Catch: java.io.IOException -> Lc
                    zb.h r0 = r0.f14870z     // Catch: java.io.IOException -> Lc
                    zb.k r1 = r2.f14910j     // Catch: java.io.IOException -> Lc
                    r0.a(r1)     // Catch: java.io.IOException -> Lc
                    return
                Lc:
                    zb.e$j r0 = r2.f14911k
                    zb.e r0 = r0.f14906k
                    zb.e.a(r0)
                    return
            }
        }

        public j(zb.e r3, zb.f r4) {
                r2 = this;
                r2.f14906k = r3
                java.lang.String r3 = r3.f14856l
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r1 = 0
                r0[r1] = r3
                java.lang.String r3 = "OkHttp %s"
                r2.<init>(r3, r0)
                r2.f14905j = r4
                return
        }

        @Override // zb.f.b
        public void a(boolean r11, zb.k r12) {
                r10 = this;
                zb.e r0 = r10.f14906k
                monitor-enter(r0)
                zb.e r1 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                zb.k r1 = r1.f14867w     // Catch: java.lang.Throwable -> L15
                int r1 = r1.d()     // Catch: java.lang.Throwable -> L15
                if (r11 == 0) goto L18
                zb.e r11 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                zb.k r11 = r11.f14867w     // Catch: java.lang.Throwable -> L15
                r11.a()     // Catch: java.lang.Throwable -> L15
                goto L18
            L15:
                r11 = move-exception
                goto L8f
            L18:
                zb.e r11 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                zb.k r11 = r11.f14867w     // Catch: java.lang.Throwable -> L15
                r11.h(r12)     // Catch: java.lang.Throwable -> L15
                r10.l(r12)     // Catch: java.lang.Throwable -> L15
                zb.e r11 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                zb.k r11 = r11.f14867w     // Catch: java.lang.Throwable -> L15
                int r11 = r11.d()     // Catch: java.lang.Throwable -> L15
                r12 = -1
                r2 = 1
                r3 = 0
                r5 = 0
                if (r11 == r12) goto L5f
                if (r11 == r1) goto L5f
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch: java.lang.Throwable -> L15
                zb.e r1 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                boolean r6 = r1.f14868x     // Catch: java.lang.Throwable -> L15
                if (r6 != 0) goto L3d
                r1.f14868x = r2     // Catch: java.lang.Throwable -> L15
            L3d:
                java.util.Map r1 = r1.f14855k     // Catch: java.lang.Throwable -> L15
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L15
                if (r1 != 0) goto L60
                zb.e r1 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                java.util.Map r1 = r1.f14855k     // Catch: java.lang.Throwable -> L15
                java.util.Collection r1 = r1.values()     // Catch: java.lang.Throwable -> L15
                zb.e r5 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                java.util.Map r5 = r5.f14855k     // Catch: java.lang.Throwable -> L15
                int r5 = r5.size()     // Catch: java.lang.Throwable -> L15
                zb.g[] r5 = new zb.g[r5]     // Catch: java.lang.Throwable -> L15
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch: java.lang.Throwable -> L15
                r5 = r1
                zb.g[] r5 = (zb.g[]) r5     // Catch: java.lang.Throwable -> L15
                goto L60
            L5f:
                r11 = r3
            L60:
                java.util.concurrent.ExecutorService r1 = zb.e.b()     // Catch: java.lang.Throwable -> L15
                zb.e$j$b r6 = new zb.e$j$b     // Catch: java.lang.Throwable -> L15
                java.lang.String r7 = "OkHttp %s settings"
                zb.e r8 = r10.f14906k     // Catch: java.lang.Throwable -> L15
                java.lang.String r8 = r8.f14856l     // Catch: java.lang.Throwable -> L15
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L15
                r9 = 0
                r2[r9] = r8     // Catch: java.lang.Throwable -> L15
                r6.<init>(r10, r7, r2)     // Catch: java.lang.Throwable -> L15
                r1.execute(r6)     // Catch: java.lang.Throwable -> L15
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
                if (r5 == 0) goto L8e
                int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r0 == 0) goto L8e
                int r0 = r5.length
            L7f:
                if (r9 >= r0) goto L8e
                r1 = r5[r9]
                monitor-enter(r1)
                r1.c(r11)     // Catch: java.lang.Throwable -> L8b
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L8b
                int r9 = r9 + 1
                goto L7f
            L8b:
                r11 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L8b
                throw r11
            L8e:
                return
            L8f:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
                goto L92
            L91:
                throw r11
            L92:
                goto L91
        }

        @Override // zb.f.b
        public void b() {
                r0 = this;
                return
        }

        @Override // zb.f.b
        public void c(boolean r10, int r11, int r12, java.util.List r13) {
                r9 = this;
                zb.e r12 = r9.f14906k
                boolean r12 = r12.r(r11)
                if (r12 == 0) goto Le
                zb.e r12 = r9.f14906k
                r12.o(r11, r13, r10)
                return
            Le:
                zb.e r12 = r9.f14906k
                monitor-enter(r12)
                zb.e r0 = r9.f14906k     // Catch: java.lang.Throwable -> L21
                zb.g r0 = r0.i(r11)     // Catch: java.lang.Throwable -> L21
                if (r0 != 0) goto L6f
                zb.e r0 = r9.f14906k     // Catch: java.lang.Throwable -> L21
                boolean r1 = r0.f14859o     // Catch: java.lang.Throwable -> L21
                if (r1 == 0) goto L24
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                return
            L21:
                r0 = move-exception
                r10 = r0
                goto L7a
            L24:
                int r1 = r0.f14857m     // Catch: java.lang.Throwable -> L21
                if (r11 > r1) goto L2a
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                return
            L2a:
                int r1 = r11 % 2
                int r0 = r0.f14858n     // Catch: java.lang.Throwable -> L21
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L34
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                return
            L34:
                okhttp3.q r8 = ub.c.H(r13)     // Catch: java.lang.Throwable -> L21
                zb.g r3 = new zb.g     // Catch: java.lang.Throwable -> L21
                zb.e r5 = r9.f14906k     // Catch: java.lang.Throwable -> L21
                r6 = 0
                r7 = r10
                r4 = r11
                r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L21
                zb.e r10 = r9.f14906k     // Catch: java.lang.Throwable -> L21
                r10.f14857m = r4     // Catch: java.lang.Throwable -> L21
                java.util.Map r10 = r10.f14855k     // Catch: java.lang.Throwable -> L21
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L21
                r10.put(r11, r3)     // Catch: java.lang.Throwable -> L21
                java.util.concurrent.ExecutorService r10 = zb.e.b()     // Catch: java.lang.Throwable -> L21
                zb.e$j$a r11 = new zb.e$j$a     // Catch: java.lang.Throwable -> L21
                java.lang.String r13 = "OkHttp %s stream %d"
                zb.e r0 = r9.f14906k     // Catch: java.lang.Throwable -> L21
                java.lang.String r0 = r0.f14856l     // Catch: java.lang.Throwable -> L21
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L21
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L21
                r4 = 0
                r2[r4] = r0     // Catch: java.lang.Throwable -> L21
                r0 = 1
                r2[r0] = r1     // Catch: java.lang.Throwable -> L21
                r11.<init>(r9, r13, r2, r3)     // Catch: java.lang.Throwable -> L21
                r10.execute(r11)     // Catch: java.lang.Throwable -> L21
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                return
            L6f:
                r7 = r10
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                r0.q(r13)
                if (r7 == 0) goto L79
                r0.p()
            L79:
                return
            L7a:
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L21
                throw r10
        }

        @Override // zb.f.b
        public void d(int r4, long r5) {
                r3 = this;
                if (r4 != 0) goto L14
                zb.e r0 = r3.f14906k
                monitor-enter(r0)
                zb.e r4 = r3.f14906k     // Catch: java.lang.Throwable -> L11
                long r1 = r4.f14865u     // Catch: java.lang.Throwable -> L11
                long r1 = r1 + r5
                r4.f14865u = r1     // Catch: java.lang.Throwable -> L11
                r4.notifyAll()     // Catch: java.lang.Throwable -> L11
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
                return
            L11:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
                throw r4
            L14:
                zb.e r0 = r3.f14906k
                zb.g r4 = r0.i(r4)
                if (r4 == 0) goto L25
                monitor-enter(r4)
                r4.c(r5)     // Catch: java.lang.Throwable -> L22
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L22
                return
            L22:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L22
                throw r5
            L25:
                return
        }

        @Override // zb.f.b
        public void e(boolean r3, int r4, okio.e r5, int r6) {
                r2 = this;
                zb.e r0 = r2.f14906k
                boolean r0 = r0.r(r4)
                if (r0 == 0) goto Le
                zb.e r0 = r2.f14906k
                r0.m(r4, r5, r6, r3)
                return
            Le:
                zb.e r0 = r2.f14906k
                zb.g r0 = r0.i(r4)
                if (r0 != 0) goto L27
                zb.e r3 = r2.f14906k
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR
                r3.b0(r4, r0)
                zb.e r3 = r2.f14906k
                long r0 = (long) r6
                r3.w(r0)
                r5.skip(r0)
                return
            L27:
                r0.o(r5, r6)
                if (r3 == 0) goto L2f
                r0.p()
            L2f:
                return
        }

        @Override // zb.f.b
        public void f(boolean r4, int r5, int r6) {
                r3 = this;
                if (r4 == 0) goto L15
                zb.e r4 = r3.f14906k
                monitor-enter(r4)
                zb.e r5 = r3.f14906k     // Catch: java.lang.Throwable -> L12
                r6 = 0
                zb.e.f(r5, r6)     // Catch: java.lang.Throwable -> L12
                zb.e r5 = r3.f14906k     // Catch: java.lang.Throwable -> L12
                r5.notifyAll()     // Catch: java.lang.Throwable -> L12
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
                return
            L12:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
                throw r5
            L15:
                zb.e r4 = r3.f14906k     // Catch: java.util.concurrent.RejectedExecutionException -> L26
                java.util.concurrent.ScheduledExecutorService r4 = zb.e.d(r4)     // Catch: java.util.concurrent.RejectedExecutionException -> L26
                zb.e$i r0 = new zb.e$i     // Catch: java.util.concurrent.RejectedExecutionException -> L26
                zb.e r1 = r3.f14906k     // Catch: java.util.concurrent.RejectedExecutionException -> L26
                r2 = 1
                r0.<init>(r1, r2, r5, r6)     // Catch: java.util.concurrent.RejectedExecutionException -> L26
                r4.execute(r0)     // Catch: java.util.concurrent.RejectedExecutionException -> L26
            L26:
                return
        }

        @Override // zb.f.b
        public void g(int r1, int r2, int r3, boolean r4) {
                r0 = this;
                return
        }

        @Override // zb.f.b
        public void h(int r2, okhttp3.internal.http2.ErrorCode r3) {
                r1 = this;
                zb.e r0 = r1.f14906k
                boolean r0 = r0.r(r2)
                if (r0 == 0) goto Le
                zb.e r0 = r1.f14906k
                r0.q(r2, r3)
                return
            Le:
                zb.e r0 = r1.f14906k
                zb.g r2 = r0.s(r2)
                if (r2 == 0) goto L19
                r2.r(r3)
            L19:
                return
        }

        @Override // zb.f.b
        public void i(int r1, int r2, java.util.List r3) {
                r0 = this;
                zb.e r1 = r0.f14906k
                r1.p(r2, r3)
                return
        }

        @Override // zb.f.b
        public void j(int r4, okhttp3.internal.http2.ErrorCode r5, okio.ByteString r6) {
                r3 = this;
                r6.size()
                zb.e r5 = r3.f14906k
                monitor-enter(r5)
                zb.e r6 = r3.f14906k     // Catch: java.lang.Throwable -> L48
                java.util.Map r6 = r6.f14855k     // Catch: java.lang.Throwable -> L48
                java.util.Collection r6 = r6.values()     // Catch: java.lang.Throwable -> L48
                zb.e r0 = r3.f14906k     // Catch: java.lang.Throwable -> L48
                java.util.Map r0 = r0.f14855k     // Catch: java.lang.Throwable -> L48
                int r0 = r0.size()     // Catch: java.lang.Throwable -> L48
                zb.g[] r0 = new zb.g[r0]     // Catch: java.lang.Throwable -> L48
                java.lang.Object[] r6 = r6.toArray(r0)     // Catch: java.lang.Throwable -> L48
                zb.g[] r6 = (zb.g[]) r6     // Catch: java.lang.Throwable -> L48
                zb.e r0 = r3.f14906k     // Catch: java.lang.Throwable -> L48
                r1 = 1
                r0.f14859o = r1     // Catch: java.lang.Throwable -> L48
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L48
                int r5 = r6.length
                r0 = 0
            L26:
                if (r0 >= r5) goto L47
                r1 = r6[r0]
                int r2 = r1.i()
                if (r2 <= r4) goto L44
                boolean r2 = r1.l()
                if (r2 == 0) goto L44
                okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM
                r1.r(r2)
                zb.e r2 = r3.f14906k
                int r1 = r1.i()
                r2.s(r1)
            L44:
                int r0 = r0 + 1
                goto L26
            L47:
                return
            L48:
                r4 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L48
                goto L4c
            L4b:
                throw r4
            L4c:
                goto L4b
        }

        @Override // ub.b
        public void k() {
                r4 = this;
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                zb.f r1 = r4.f14905j     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
                r1.d(r4)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            L7:
                zb.f r1 = r4.f14905j     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
                r2 = 0
                boolean r1 = r1.b(r2, r4)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
                if (r1 == 0) goto L11
                goto L7
            L11:
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L26
                zb.e r2 = r4.f14906k     // Catch: java.io.IOException -> L1a
                r2.g(r1, r0)     // Catch: java.io.IOException -> L1a
            L1a:
                zb.f r0 = r4.f14905j
                ub.c.g(r0)
                goto L2e
            L20:
                r2 = move-exception
                goto L2f
            L22:
                r2 = move-exception
                r1 = r0
                goto L2f
            L25:
                r1 = r0
            L26:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L20
                zb.e r1 = r4.f14906k     // Catch: java.io.IOException -> L1a
                r1.g(r0, r0)     // Catch: java.io.IOException -> L1a
                goto L1a
            L2e:
                return
            L2f:
                zb.e r3 = r4.f14906k     // Catch: java.io.IOException -> L34
                r3.g(r1, r0)     // Catch: java.io.IOException -> L34
            L34:
                zb.f r0 = r4.f14905j
                ub.c.g(r0)
                goto L3b
            L3a:
                throw r2
            L3b:
                goto L3a
        }

        public final void l(zb.k r7) {
                r6 = this;
                zb.e r0 = r6.f14906k     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                java.util.concurrent.ScheduledExecutorService r0 = zb.e.d(r0)     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                zb.e$j$c r1 = new zb.e$j$c     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                java.lang.String r2 = "OkHttp %s ACK Settings"
                zb.e r3 = r6.f14906k     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                java.lang.String r3 = r3.f14856l     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                r5 = 0
                r4[r5] = r3     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                r1.<init>(r6, r2, r4, r7)     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
                r0.execute(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L1a
            L1a:
                return
        }
    }

    static {
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.SynchronousQueue r6 = new java.util.concurrent.SynchronousQueue
            r6.<init>()
            java.lang.String r1 = "OkHttp Http2Connection"
            r2 = 1
            java.util.concurrent.ThreadFactory r7 = ub.c.G(r1, r2)
            r1 = 0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 60
            r0.<init>(r1, r2, r3, r5, r6, r7)
            zb.e.C = r0
            return
    }

    public e(zb.e.g r23) {
            r22 = this;
            r0 = r22
            r1 = r23
            r0.<init>()
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            r0.f14855k = r2
            r2 = 0
            r0.f14864t = r2
            zb.k r2 = new zb.k
            r2.<init>()
            r0.f14866v = r2
            zb.k r2 = new zb.k
            r2.<init>()
            r0.f14867w = r2
            r3 = 0
            r0.f14868x = r3
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            r4.<init>()
            r0.B = r4
            zb.j r4 = r1.f14897f
            r0.f14862r = r4
            boolean r4 = r1.f14898g
            r0.f14853e = r4
            zb.e$h r5 = r1.f14896e
            r0.f14854j = r5
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L3c
            r7 = 1
            goto L3d
        L3c:
            r7 = 2
        L3d:
            r0.f14858n = r7
            if (r4 == 0) goto L44
            int r7 = r7 + r5
            r0.f14858n = r7
        L44:
            r5 = 7
            if (r4 == 0) goto L4e
            zb.k r7 = r0.f14866v
            r8 = 16777216(0x1000000, float:2.3509887E-38)
            r7.i(r5, r8)
        L4e:
            java.lang.String r7 = r1.f14893b
            r0.f14856l = r7
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = new java.util.concurrent.ScheduledThreadPoolExecutor
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r9[r3] = r7
            java.lang.String r10 = "OkHttp %s Writer"
            java.lang.String r9 = ub.c.r(r10, r9)
            java.util.concurrent.ThreadFactory r9 = ub.c.G(r9, r3)
            r8.<init>(r6, r9)
            r0.f14860p = r8
            int r9 = r1.f14899h
            if (r9 == 0) goto L7b
            zb.e$i r9 = new zb.e$i
            r9.<init>(r0, r3, r3, r3)
            int r10 = r1.f14899h
            long r11 = (long) r10
            long r13 = (long) r10
            r10 = r11
            r12 = r13
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.MILLISECONDS
            r8.scheduleAtFixedRate(r9, r10, r12, r14)
        L7b:
            java.util.concurrent.ThreadPoolExecutor r14 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r19 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r20 = new java.util.concurrent.LinkedBlockingQueue
            r20.<init>()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r3] = r7
            java.lang.String r3 = "OkHttp %s Push Observer"
            java.lang.String r3 = ub.c.r(r3, r8)
            java.util.concurrent.ThreadFactory r21 = ub.c.G(r3, r6)
            r15 = 0
            r16 = 1
            r17 = 60
            r14.<init>(r15, r16, r17, r19, r20, r21)
            r0.f14861q = r14
            r3 = 65535(0xffff, float:9.1834E-41)
            r2.i(r5, r3)
            r3 = 5
            r5 = 16384(0x4000, float:2.2959E-41)
            r2.i(r3, r5)
            int r2 = r2.d()
            long r2 = (long) r2
            r0.f14865u = r2
            java.net.Socket r2 = r1.f14892a
            r0.f14869y = r2
            zb.h r2 = new zb.h
            okio.d r3 = r1.f14895d
            r2.<init>(r3, r4)
            r0.f14870z = r2
            zb.e$j r2 = new zb.e$j
            zb.f r3 = new zb.f
            okio.e r1 = r1.f14894c
            r3.<init>(r1, r4)
            r2.<init>(r0, r3)
            r0.A = r2
            return
    }

    public static /* synthetic */ void a(zb.e r0) {
            r0.h()
            return
    }

    public static /* synthetic */ java.util.concurrent.ExecutorService b() {
            java.util.concurrent.ExecutorService r0 = zb.e.C
            return r0
    }

    public static /* synthetic */ java.util.concurrent.ScheduledExecutorService d(zb.e r0) {
            java.util.concurrent.ScheduledExecutorService r0 = r0.f14860p
            return r0
    }

    public static /* synthetic */ boolean f(zb.e r0, boolean r1) {
            r0.f14863s = r1
            return r1
    }

    public void J(boolean r3, int r4, int r5) {
            r2 = this;
            if (r3 != 0) goto L12
            monitor-enter(r2)
            boolean r0 = r2.f14863s     // Catch: java.lang.Throwable -> Lf
            r1 = 1
            r2.f14863s = r1     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L12
            r2.h()
            return
        Lf:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lf
            throw r3
        L12:
            zb.h r0 = r2.f14870z     // Catch: java.io.IOException -> L18
            r0.k(r3, r4, r5)     // Catch: java.io.IOException -> L18
            return
        L18:
            r2.h()
            return
    }

    public void W(int r2, okhttp3.internal.http2.ErrorCode r3) {
            r1 = this;
            zb.h r0 = r1.f14870z
            r0.m(r2, r3)
            return
    }

    public void b0(int r8, okhttp3.internal.http2.ErrorCode r9) {
            r7 = this;
            java.util.concurrent.ScheduledExecutorService r0 = r7.f14860p     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            zb.e$a r1 = new zb.e$a     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.String r3 = "OkHttp %s stream %d"
            java.lang.String r2 = r7.f14856l     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r6 = 0
            r5[r6] = r2     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r2 = 1
            r5[r2] = r4     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r2 = r7
            r6 = r9
            r4 = r5
            r5 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r0.execute(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
        L1f:
            return
    }

    public void c0(int r9, long r10) {
            r8 = this;
            java.util.concurrent.ScheduledExecutorService r0 = r8.f14860p     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            zb.e$b r1 = new zb.e$b     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.String r3 = "OkHttp Window Update %s stream %d"
            java.lang.String r2 = r8.f14856l     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r6 = 0
            r5[r6] = r2     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r2 = 1
            r5[r2] = r4     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r2 = r8
            r6 = r10
            r4 = r5
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r0.execute(r1)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
        L1f:
            return
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
            r2 = this;
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.NO_ERROR
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL
            r2.g(r0, r1)
            return
    }

    public void flush() {
            r1 = this;
            zb.h r0 = r1.f14870z
            r0.flush()
            return
    }

    public void g(okhttp3.internal.http2.ErrorCode r5, okhttp3.internal.http2.ErrorCode r6) {
            r4 = this;
            r0 = 0
            r4.t(r5)     // Catch: java.io.IOException -> L6
            r5 = r0
            goto L7
        L6:
            r5 = move-exception
        L7:
            monitor-enter(r4)
            java.util.Map r1 = r4.f14855k     // Catch: java.lang.Throwable -> L2a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2a
            if (r1 != 0) goto L2c
            java.util.Map r0 = r4.f14855k     // Catch: java.lang.Throwable -> L2a
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L2a
            java.util.Map r1 = r4.f14855k     // Catch: java.lang.Throwable -> L2a
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L2a
            zb.g[] r1 = new zb.g[r1]     // Catch: java.lang.Throwable -> L2a
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch: java.lang.Throwable -> L2a
            zb.g[] r0 = (zb.g[]) r0     // Catch: java.lang.Throwable -> L2a
            java.util.Map r1 = r4.f14855k     // Catch: java.lang.Throwable -> L2a
            r1.clear()     // Catch: java.lang.Throwable -> L2a
            goto L2c
        L2a:
            r5 = move-exception
            goto L5f
        L2c:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L40
            int r1 = r0.length
            r2 = 0
        L31:
            if (r2 >= r1) goto L40
            r3 = r0[r2]
            r3.f(r6)     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r3 = move-exception
            if (r5 == 0) goto L3d
            r5 = r3
        L3d:
            int r2 = r2 + 1
            goto L31
        L40:
            zb.h r6 = r4.f14870z     // Catch: java.io.IOException -> L46
            r6.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r6 = move-exception
            if (r5 != 0) goto L4a
            r5 = r6
        L4a:
            java.net.Socket r6 = r4.f14869y     // Catch: java.io.IOException -> L50
            r6.close()     // Catch: java.io.IOException -> L50
            goto L51
        L50:
            r5 = move-exception
        L51:
            java.util.concurrent.ScheduledExecutorService r6 = r4.f14860p
            r6.shutdown()
            java.util.concurrent.ExecutorService r6 = r4.f14861q
            r6.shutdown()
            if (r5 != 0) goto L5e
            return
        L5e:
            throw r5
        L5f:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2a
            goto L62
        L61:
            throw r5
        L62:
            goto L61
    }

    public final void h() {
            r1 = this;
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.io.IOException -> L5
            r1.g(r0, r0)     // Catch: java.io.IOException -> L5
        L5:
            return
    }

    public synchronized zb.g i(int r2) {
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.f14855k     // Catch: java.lang.Throwable -> Lf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> Lf
            zb.g r2 = (zb.g) r2     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r1)
            return r2
        Lf:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
            throw r2
    }

    public synchronized boolean isShutdown() {
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14859o     // Catch: java.lang.Throwable -> L5
            monitor-exit(r1)
            return r0
        L5:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5
            throw r0
    }

    public synchronized int j() {
            r2 = this;
            monitor-enter(r2)
            zb.k r0 = r2.f14867w     // Catch: java.lang.Throwable -> Lc
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r0 = r0.e(r1)     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return r0
        Lc:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r0
    }

    public final zb.g k(int r10, java.util.List r11, boolean r12) {
            r9 = this;
            r3 = r12 ^ 1
            zb.h r6 = r9.f14870z
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L82
            int r0 = r9.f14858n     // Catch: java.lang.Throwable -> L76
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L18
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L13
            r9.t(r0)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L80
        L18:
            boolean r0 = r9.f14859o     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L79
            int r1 = r9.f14858n     // Catch: java.lang.Throwable -> L76
            int r0 = r1 + 2
            r9.f14858n = r0     // Catch: java.lang.Throwable -> L76
            zb.g r0 = new zb.g     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r4 = 0
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3d
            if (r12 == 0) goto L40
            long r4 = r2.f14865u     // Catch: java.lang.Throwable -> L3d
            r7 = 0
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 == 0) goto L40
            long r4 = r0.f14924b     // Catch: java.lang.Throwable -> L3d
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 != 0) goto L3b
            goto L40
        L3b:
            r12 = 0
            goto L41
        L3d:
            r0 = move-exception
        L3e:
            r10 = r0
            goto L80
        L40:
            r12 = 1
        L41:
            boolean r4 = r0.m()     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L50
            java.util.Map r4 = r2.f14855k     // Catch: java.lang.Throwable -> L3d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L3d
            r4.put(r5, r0)     // Catch: java.lang.Throwable -> L3d
        L50:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L3d
            if (r10 != 0) goto L5c
            zb.h r4 = r2.f14870z     // Catch: java.lang.Throwable -> L59
            r4.o(r3, r1, r10, r11)     // Catch: java.lang.Throwable -> L59
            goto L65
        L59:
            r0 = move-exception
        L5a:
            r10 = r0
            goto L85
        L5c:
            boolean r3 = r2.f14853e     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L6e
            zb.h r3 = r2.f14870z     // Catch: java.lang.Throwable -> L59
            r3.l(r10, r1, r11)     // Catch: java.lang.Throwable -> L59
        L65:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L59
            if (r12 == 0) goto L6d
            zb.h r10 = r2.f14870z
            r10.flush()
        L6d:
            return r0
        L6e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L59
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L59
            throw r10     // Catch: java.lang.Throwable -> L59
        L76:
            r0 = move-exception
            r2 = r9
            goto L3e
        L79:
            r2 = r9
            okhttp3.internal.http2.ConnectionShutdownException r10 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L3d
            r10.<init>()     // Catch: java.lang.Throwable -> L3d
            throw r10     // Catch: java.lang.Throwable -> L3d
        L80:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L3d
            throw r10     // Catch: java.lang.Throwable -> L59
        L82:
            r0 = move-exception
            r2 = r9
            goto L5a
        L85:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L59
            goto L88
        L87:
            throw r10
        L88:
            goto L87
    }

    public zb.g l(java.util.List r2, boolean r3) {
            r1 = this;
            r0 = 0
            zb.g r2 = r1.k(r0, r2, r3)
            return r2
    }

    public void m(int r9, okio.e r10, int r11, boolean r12) {
            r8 = this;
            okio.c r5 = new okio.c
            r5.<init>()
            long r0 = (long) r11
            r10.X(r0)
            r10.U(r5, r0)
            long r2 = r5.size()
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 != 0) goto L32
            zb.e$e r0 = new zb.e$e
            java.lang.String r10 = r8.f14856l
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r2 = 0
            r3[r2] = r10
            r10 = 1
            r3[r10] = r1
            java.lang.String r2 = "OkHttp %s Push Data[%s]"
            r1 = r8
            r4 = r9
            r6 = r11
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.n(r0)
            return
        L32:
            r1 = r8
            r6 = r11
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            long r11 = r5.size()
            r10.append(r11)
            java.lang.String r11 = " != "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
    }

    public final synchronized void n(ub.b r2) {
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isShutdown()     // Catch: java.lang.Throwable -> Ld
            if (r0 != 0) goto Lf
            java.util.concurrent.ExecutorService r0 = r1.f14861q     // Catch: java.lang.Throwable -> Ld
            r0.execute(r2)     // Catch: java.lang.Throwable -> Ld
            goto Lf
        Ld:
            r2 = move-exception
            goto L11
        Lf:
            monitor-exit(r1)
            return
        L11:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r2
    }

    public void o(int r8, java.util.List r9, boolean r10) {
            r7 = this;
            zb.e$d r0 = new zb.e$d     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.String r2 = "OkHttp %s Push Headers[%s]"
            java.lang.String r1 = r7.f14856l     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r5 = 0
            r4[r5] = r1     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r1 = 1
            r4[r1] = r3     // Catch: java.util.concurrent.RejectedExecutionException -> L1f
            r1 = r7
            r5 = r9
            r6 = r10
            r3 = r4
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch: java.util.concurrent.RejectedExecutionException -> L20
            r7.n(r0)     // Catch: java.util.concurrent.RejectedExecutionException -> L20
            return
        L1f:
            r1 = r7
        L20:
            return
    }

    public void p(int r9, java.util.List r10) {
            r8 = this;
            monitor-enter(r8)
            java.util.Set r0 = r8.B     // Catch: java.lang.Throwable -> L41
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
            java.util.Set r0 = r8.B     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L41
            zb.e$c r2 = new zb.e$c     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.f14856l     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
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
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
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
    }

    public void q(int r7, okhttp3.internal.http2.ErrorCode r8) {
            r6 = this;
            zb.e$f r0 = new zb.e$f
            java.lang.String r1 = r6.f14856l
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r1
            r1 = 1
            r3[r1] = r2
            java.lang.String r2 = "OkHttp %s Push Reset[%s]"
            r1 = r6
            r4 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.n(r0)
            return
    }

    public boolean r(int r2) {
            r1 = this;
            if (r2 == 0) goto L7
            r0 = 1
            r2 = r2 & r0
            if (r2 != 0) goto L7
            return r0
        L7:
            r2 = 0
            return r2
    }

    public synchronized zb.g s(int r2) {
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.f14855k     // Catch: java.lang.Throwable -> L12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.Object r2 = r0.remove(r2)     // Catch: java.lang.Throwable -> L12
            zb.g r2 = (zb.g) r2     // Catch: java.lang.Throwable -> L12
            r1.notifyAll()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r1)
            return r2
        L12:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
            throw r2
    }

    public void t(okhttp3.internal.http2.ErrorCode r5) {
            r4 = this;
            zb.h r0 = r4.f14870z
            monitor-enter(r0)
            monitor-enter(r4)     // Catch: java.lang.Throwable -> Lb
            boolean r1 = r4.f14859o     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto Lf
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
            return
        Lb:
            r5 = move-exception
            goto L20
        Ld:
            r5 = move-exception
            goto L1e
        Lf:
            r1 = 1
            r4.f14859o = r1     // Catch: java.lang.Throwable -> Ld
            int r1 = r4.f14857m     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
            zb.h r2 = r4.f14870z     // Catch: java.lang.Throwable -> Lb
            byte[] r3 = ub.c.f12935a     // Catch: java.lang.Throwable -> Lb
            r2.h(r1, r5, r3)     // Catch: java.lang.Throwable -> Lb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
            return
        L1e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
            throw r5     // Catch: java.lang.Throwable -> Lb
        L20:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
            throw r5
    }

    public void u() {
            r1 = this;
            r0 = 1
            r1.v(r0)
            return
    }

    public void v(boolean r5) {
            r4 = this;
            if (r5 == 0) goto L21
            zb.h r5 = r4.f14870z
            r5.b()
            zb.h r5 = r4.f14870z
            zb.k r0 = r4.f14866v
            r5.n(r0)
            zb.k r5 = r4.f14866v
            int r5 = r5.d()
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r5 == r0) goto L21
            zb.h r1 = r4.f14870z
            int r5 = r5 - r0
            long r2 = (long) r5
            r5 = 0
            r1.p(r5, r2)
        L21:
            java.lang.Thread r5 = new java.lang.Thread
            zb.e$j r0 = r4.A
            r5.<init>(r0)
            r5.start()
            return
    }

    public synchronized void w(long r4) {
            r3 = this;
            monitor-enter(r3)
            long r0 = r3.f14864t     // Catch: java.lang.Throwable -> L1e
            long r0 = r0 + r4
            r3.f14864t = r0     // Catch: java.lang.Throwable -> L1e
            zb.k r4 = r3.f14866v     // Catch: java.lang.Throwable -> L1e
            int r4 = r4.d()     // Catch: java.lang.Throwable -> L1e
            int r4 = r4 / 2
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L1e
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 < 0) goto L20
            long r4 = r3.f14864t     // Catch: java.lang.Throwable -> L1e
            r0 = 0
            r3.c0(r0, r4)     // Catch: java.lang.Throwable -> L1e
            r4 = 0
            r3.f14864t = r4     // Catch: java.lang.Throwable -> L1e
            goto L20
        L1e:
            r4 = move-exception
            goto L22
        L20:
            monitor-exit(r3)
            return
        L22:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1e
            throw r4
    }

    public void x(int r9, boolean r10, okio.c r11, long r12) {
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            zb.h r12 = r8.f14870z
            r12.d(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.f14865u     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map r3 = r8.f14855k     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            zb.h r3 = r8.f14870z     // Catch: java.lang.Throwable -> L28
            int r3 = r3.j()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f14865u     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f14865u = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            zb.h r4 = r8.f14870z
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.d(r5, r9, r11, r3)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
    }
}
