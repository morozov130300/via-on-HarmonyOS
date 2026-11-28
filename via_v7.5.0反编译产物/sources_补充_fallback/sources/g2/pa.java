package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class pa implements g2.c6 {
    public static volatile g2.pa F;
    public final java.util.Map A;
    public final java.util.Map B;
    public g2.v7 C;
    public java.lang.String D;
    public final g2.va E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2.y4 f5203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2.b4 f5204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g2.k f5205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g2.e4 f5206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g2.z9 f5207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g2.b f5208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g2.ra f5209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g2.t7 f5210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g2.g9 f5211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g2.da f5212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g2.o4 f5213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g2.h5 f5214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5215m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5216n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5217o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public java.util.List f5218p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5219q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5220r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5221s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5222t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f5223u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public java.nio.channels.FileLock f5224v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public java.nio.channels.FileChannel f5225w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public java.util.List f5226x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public java.util.List f5227y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f5228z;

    public pa(g2.qa r3, g2.h5 r4) {
            r2 = this;
            r2.<init>()
            r4 = 0
            r2.f5215m = r4
            g2.ka r4 = new g2.ka
            r4.<init>(r2)
            r2.E = r4
            u1.f.h(r3)
            android.content.Context r4 = r3.f5260a
            r0 = 0
            g2.h5 r4 = g2.h5.H(r4, r0, r0)
            r2.f5214l = r4
            r0 = -1
            r2.f5228z = r0
            g2.da r4 = new g2.da
            r4.<init>(r2)
            r2.f5212j = r4
            g2.ra r4 = new g2.ra
            r4.<init>(r2)
            r4.j()
            r2.f5209g = r4
            g2.b4 r4 = new g2.b4
            r4.<init>(r2)
            r4.j()
            r2.f5204b = r4
            g2.y4 r4 = new g2.y4
            r4.<init>(r2)
            r4.j()
            r2.f5203a = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2.A = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2.B = r4
            g2.e5 r4 = r2.f()
            g2.ea r0 = new g2.ea
            r0.<init>(r2, r3)
            r4.z(r0)
            return
    }

    public static final void G(com.google.android.gms.internal.measurement.i4 r4, int r5, java.lang.String r6) {
            java.util.List r0 = r4.H()
            r1 = 0
        L5:
            int r2 = r0.size()
            java.lang.String r3 = "_err"
            if (r1 >= r2) goto L21
            java.lang.Object r2 = r0.get(r1)
            com.google.android.gms.internal.measurement.n4 r2 = (com.google.android.gms.internal.measurement.n4) r2
            java.lang.String r2 = r2.J()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L1e
            return
        L1e:
            int r1 = r1 + 1
            goto L5
        L21:
            com.google.android.gms.internal.measurement.m4 r0 = com.google.android.gms.internal.measurement.n4.H()
            r0.B(r3)
            long r1 = (long) r5
            r0.A(r1)
            com.google.android.gms.internal.measurement.a9 r5 = r0.o()
            com.google.android.gms.internal.measurement.n4 r5 = (com.google.android.gms.internal.measurement.n4) r5
            com.google.android.gms.internal.measurement.m4 r0 = com.google.android.gms.internal.measurement.n4.H()
            java.lang.String r1 = "_ev"
            r0.B(r1)
            r0.C(r6)
            com.google.android.gms.internal.measurement.a9 r6 = r0.o()
            com.google.android.gms.internal.measurement.n4 r6 = (com.google.android.gms.internal.measurement.n4) r6
            r4.x(r5)
            r4.x(r6)
            return
    }

    public static final void H(com.google.android.gms.internal.measurement.i4 r3, java.lang.String r4) {
            java.util.List r0 = r3.H()
            r1 = 0
        L5:
            int r2 = r0.size()
            if (r1 >= r2) goto L22
            java.lang.Object r2 = r0.get(r1)
            com.google.android.gms.internal.measurement.n4 r2 = (com.google.android.gms.internal.measurement.n4) r2
            java.lang.String r2 = r2.J()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L1f
            r3.z(r1)
            return
        L1f:
            int r1 = r1 + 1
            goto L5
        L22:
            return
    }

    public static final boolean Q(com.google.android.gms.measurement.internal.zzq r1) {
            java.lang.String r0 = r1.f3276e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L13
            java.lang.String r1 = r1.A
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L11
            goto L13
        L11:
            r1 = 0
            return r1
        L13:
            r1 = 1
            return r1
    }

    public static final g2.ba R(g2.ba r2) {
            if (r2 == 0) goto L1d
            boolean r0 = r2.k()
            if (r0 == 0) goto L9
            return r2
        L9:
            java.lang.Class r2 = r2.getClass()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Component not initialized: "
            java.lang.String r2 = r1.concat(r2)
            r0.<init>(r2)
            throw r0
        L1d:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = "Upload Component not created"
            r2.<init>(r0)
            throw r2
    }

    public static /* bridge */ /* synthetic */ g2.h5 a0(g2.pa r0) {
            g2.h5 r0 = r0.f5214l
            return r0
    }

    public static g2.pa f0(android.content.Context r3) {
            u1.f.h(r3)
            android.content.Context r0 = r3.getApplicationContext()
            u1.f.h(r0)
            g2.pa r0 = g2.pa.F
            if (r0 != 0) goto L2f
            java.lang.Class<g2.pa> r0 = g2.pa.class
            monitor-enter(r0)
            g2.pa r1 = g2.pa.F     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L2b
            g2.qa r1 = new g2.qa     // Catch: java.lang.Throwable -> L29
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r3 = u1.f.h(r1)     // Catch: java.lang.Throwable -> L29
            g2.qa r3 = (g2.qa) r3     // Catch: java.lang.Throwable -> L29
            g2.pa r1 = new g2.pa     // Catch: java.lang.Throwable -> L29
            r2 = 0
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L29
            g2.pa.F = r1     // Catch: java.lang.Throwable -> L29
            goto L2b
        L29:
            r3 = move-exception
            goto L2d
        L2b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            goto L2f
        L2d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            throw r3
        L2f:
            g2.pa r3 = g2.pa.F
            return r3
    }

    public static /* bridge */ /* synthetic */ void k0(g2.pa r3, g2.qa r4) {
            g2.e5 r4 = r3.f()
            r4.h()
            g2.o4 r4 = new g2.o4
            r4.<init>(r3)
            r3.f5213k = r4
            g2.k r4 = new g2.k
            r4.<init>(r3)
            r4.j()
            r3.f5205c = r4
            g2.g r4 = r3.U()
            g2.y4 r0 = r3.f5203a
            java.lang.Object r0 = u1.f.h(r0)
            g2.f r0 = (g2.f) r0
            r4.z(r0)
            g2.g9 r4 = new g2.g9
            r4.<init>(r3)
            r4.j()
            r3.f5211i = r4
            g2.b r4 = new g2.b
            r4.<init>(r3)
            r4.j()
            r3.f5208f = r4
            g2.t7 r4 = new g2.t7
            r4.<init>(r3)
            r4.j()
            r3.f5210h = r4
            g2.z9 r4 = new g2.z9
            r4.<init>(r3)
            r4.j()
            r3.f5207e = r4
            g2.e4 r4 = new g2.e4
            r4.<init>(r3)
            r3.f5206d = r4
            int r4 = r3.f5219q
            int r0 = r3.f5220r
            if (r4 == r0) goto L75
            g2.v3 r4 = r3.d()
            g2.t3 r4 = r4.r()
            int r0 = r3.f5219q
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = r3.f5220r
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "Not all upload components initialized"
            r4.c(r2, r0, r1)
        L75:
            r4 = 1
            r3.f5215m = r4
            return
    }

    public final void A(java.lang.String r6, g2.f6 r7) {
            r5 = this;
            g2.e5 r0 = r5.f()
            r0.h()
            r5.g()
            java.util.Map r0 = r5.A
            r0.put(r6, r7)
            g2.k r0 = r5.f5205c
            R(r0)
            u1.f.h(r6)
            u1.f.h(r7)
            r0.h()
            r0.i()
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "app_id"
            r1.put(r2, r6)
            java.lang.String r2 = "consent_state"
            java.lang.String r7 = r7.i()
            r1.put(r2, r7)
            android.database.sqlite.SQLiteDatabase r7 = r0.P()     // Catch: android.database.sqlite.SQLiteException -> L59
            java.lang.String r2 = "consent_settings"
            r3 = 0
            r4 = 5
            long r1 = r7.insertWithOnConflict(r2, r3, r1, r4)     // Catch: android.database.sqlite.SQLiteException -> L59
            r3 = -1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L5b
            g2.h5 r7 = r0.f4646a     // Catch: android.database.sqlite.SQLiteException -> L59
            g2.v3 r7 = r7.d()     // Catch: android.database.sqlite.SQLiteException -> L59
            g2.t3 r7 = r7.r()     // Catch: android.database.sqlite.SQLiteException -> L59
            java.lang.String r1 = "Failed to insert/update consent setting (got -1). appId"
            java.lang.Object r2 = g2.v3.z(r6)     // Catch: android.database.sqlite.SQLiteException -> L59
            r7.b(r1, r2)     // Catch: android.database.sqlite.SQLiteException -> L59
            return
        L59:
            r7 = move-exception
            goto L5c
        L5b:
            return
        L5c:
            g2.h5 r0 = r0.f4646a
            g2.v3 r0 = r0.d()
            g2.t3 r0 = r0.r()
            java.lang.Object r6 = g2.v3.z(r6)
            java.lang.String r1 = "Error storing consent setting. appId, error"
            r0.c(r1, r6, r7)
            return
    }

    public final void B(com.google.android.gms.measurement.internal.zzlk r18, com.google.android.gms.measurement.internal.zzq r19) {
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.String r3 = "_id"
            g2.e5 r4 = r1.f()
            r4.h()
            r1.g()
            boolean r4 = Q(r2)
            if (r4 != 0) goto L1a
            goto Laf
        L1a:
            boolean r4 = r2.f3282r
            if (r4 != 0) goto L22
            r1.S(r2)
            return
        L22:
            g2.wa r4 = r1.h0()
            java.lang.String r5 = r0.f3269e
            int r9 = r4.p0(r5)
            r4 = 1
            r5 = 24
            r6 = 0
            if (r9 == 0) goto L58
            g2.wa r3 = r1.h0()
            java.lang.String r7 = r0.f3269e
            r1.U()
            java.lang.String r11 = r3.r(r7, r5, r4)
            java.lang.String r0 = r0.f3269e
            if (r0 == 0) goto L49
            int r6 = r0.length()
            r12 = r6
            goto L4a
        L49:
            r12 = 0
        L4a:
            g2.wa r6 = r1.h0()
            g2.va r7 = r1.E
            java.lang.String r8 = r2.f3275c
            java.lang.String r10 = "_ev"
            r6.C(r7, r8, r9, r10, r11, r12)
            return
        L58:
            g2.wa r7 = r1.h0()
            java.lang.String r8 = r0.f3269e
            java.lang.Object r9 = r0.c()
            int r13 = r7.l0(r8, r9)
            if (r13 == 0) goto L9f
            g2.wa r3 = r1.h0()
            java.lang.String r7 = r0.f3269e
            r1.U()
            java.lang.String r15 = r3.r(r7, r5, r4)
            java.lang.Object r0 = r0.c()
            if (r0 == 0) goto L84
            boolean r3 = r0 instanceof java.lang.String
            if (r3 != 0) goto L87
            boolean r3 = r0 instanceof java.lang.CharSequence
            if (r3 == 0) goto L84
            goto L87
        L84:
            r16 = 0
            goto L91
        L87:
            java.lang.String r0 = r0.toString()
            int r6 = r0.length()
            r16 = r6
        L91:
            g2.wa r10 = r1.h0()
            g2.va r11 = r1.E
            java.lang.String r12 = r2.f3275c
            java.lang.String r14 = "_ev"
            r10.C(r11, r12, r13, r14, r15, r16)
            return
        L9f:
            g2.wa r4 = r1.h0()
            java.lang.String r5 = r0.f3269e
            java.lang.Object r6 = r0.c()
            java.lang.Object r13 = r4.p(r5, r6)
            if (r13 != 0) goto Lb0
        Laf:
            return
        Lb0:
            java.lang.String r4 = r0.f3269e
            java.lang.String r5 = "_sid"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L126
            long r8 = r0.f3270m
            java.lang.String r11 = r0.f3273p
            java.lang.String r4 = r2.f3275c
            java.lang.Object r4 = u1.f.h(r4)
            java.lang.String r4 = (java.lang.String) r4
            g2.k r6 = r1.f5205c
            R(r6)
            java.lang.String r7 = "_sno"
            g2.ta r6 = r6.X(r4, r7)
            if (r6 == 0) goto Le0
            java.lang.Object r7 = r6.f5334e
            boolean r10 = r7 instanceof java.lang.Long
            if (r10 == 0) goto Le0
            java.lang.Long r7 = (java.lang.Long) r7
            long r6 = r7.longValue()
            goto L114
        Le0:
            if (r6 == 0) goto Lf1
            g2.v3 r7 = r1.d()
            g2.t3 r7 = r7.w()
            java.lang.String r10 = "Retrieved last session number from database does not contain a valid (long) value"
            java.lang.Object r6 = r6.f5334e
            r7.b(r10, r6)
        Lf1:
            g2.k r6 = r1.f5205c
            R(r6)
            java.lang.String r7 = "_s"
            g2.q r4 = r6.V(r4, r7)
            if (r4 == 0) goto L112
            long r6 = r4.f5231c
            g2.v3 r4 = r1.d()
            g2.t3 r4 = r4.v()
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            java.lang.String r12 = "Backfill the session number. Last used session number"
            r4.b(r12, r10)
            goto L114
        L112:
            r6 = 0
        L114:
            com.google.android.gms.measurement.internal.zzlk r4 = new com.google.android.gms.measurement.internal.zzlk
            r14 = 1
            long r6 = r6 + r14
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            java.lang.String r7 = "_sno"
            r6 = r4
            r6.<init>(r7, r8, r10, r11)
            r1.B(r6, r2)
        L126:
            g2.ta r7 = new g2.ta
            java.lang.String r4 = r2.f3275c
            java.lang.Object r4 = u1.f.h(r4)
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r4 = r0.f3273p
            java.lang.Object r4 = u1.f.h(r4)
            r9 = r4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = r0.f3269e
            long r11 = r0.f3270m
            r7.<init>(r8, r9, r10, r11, r13)
            g2.v3 r4 = r1.d()
            g2.t3 r4 = r4.v()
            g2.h5 r6 = r1.f5214l
            g2.q3 r6 = r6.D()
            java.lang.String r8 = r7.f5332c
            java.lang.String r6 = r6.f(r8)
            java.lang.String r8 = "Setting user property"
            r4.c(r8, r6, r13)
            g2.k r4 = r1.f5205c
            R(r4)
            r4.e0()
            java.lang.String r4 = r7.f5332c     // Catch: java.lang.Throwable -> L18e
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Throwable -> L18e
            if (r4 == 0) goto L191
            g2.k r4 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r4)     // Catch: java.lang.Throwable -> L18e
            java.lang.String r6 = r2.f3275c     // Catch: java.lang.Throwable -> L18e
            g2.ta r3 = r4.X(r6, r3)     // Catch: java.lang.Throwable -> L18e
            if (r3 == 0) goto L191
            java.lang.Object r4 = r7.f5334e     // Catch: java.lang.Throwable -> L18e
            java.lang.Object r3 = r3.f5334e     // Catch: java.lang.Throwable -> L18e
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L18e
            if (r3 != 0) goto L191
            g2.k r3 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r3)     // Catch: java.lang.Throwable -> L18e
            java.lang.String r4 = r2.f3275c     // Catch: java.lang.Throwable -> L18e
            java.lang.String r6 = "_lair"
            r3.m(r4, r6)     // Catch: java.lang.Throwable -> L18e
            goto L191
        L18e:
            r0 = move-exception
            goto L219
        L191:
            r1.S(r2)     // Catch: java.lang.Throwable -> L18e
            g2.k r3 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r3)     // Catch: java.lang.Throwable -> L18e
            boolean r3 = r3.x(r7)     // Catch: java.lang.Throwable -> L18e
            g2.g r4 = r1.U()     // Catch: java.lang.Throwable -> L18e
            g2.h3 r6 = g2.i3.J0     // Catch: java.lang.Throwable -> L18e
            r8 = 0
            boolean r4 = r4.B(r8, r6)     // Catch: java.lang.Throwable -> L18e
            if (r4 == 0) goto L1db
            java.lang.String r0 = r0.f3269e     // Catch: java.lang.Throwable -> L18e
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Throwable -> L18e
            if (r0 == 0) goto L1db
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> L18e
            R(r0)     // Catch: java.lang.Throwable -> L18e
            java.lang.String r4 = r2.H     // Catch: java.lang.Throwable -> L18e
            long r4 = r0.y(r4)     // Catch: java.lang.Throwable -> L18e
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r0)     // Catch: java.lang.Throwable -> L18e
            java.lang.String r6 = r2.f3275c     // Catch: java.lang.Throwable -> L18e
            g2.e6 r0 = r0.R(r6)     // Catch: java.lang.Throwable -> L18e
            if (r0 == 0) goto L1db
            r0.K(r4)     // Catch: java.lang.Throwable -> L18e
            boolean r4 = r0.P()     // Catch: java.lang.Throwable -> L18e
            if (r4 == 0) goto L1db
            g2.k r4 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r4)     // Catch: java.lang.Throwable -> L18e
            r4.p(r0)     // Catch: java.lang.Throwable -> L18e
        L1db:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L18e
            R(r0)     // Catch: java.lang.Throwable -> L18e
            r0.o()     // Catch: java.lang.Throwable -> L18e
            if (r3 != 0) goto L210
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L18e
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> L18e
            java.lang.String r3 = "Too many unique user properties are set. Ignoring user property"
            g2.h5 r4 = r1.f5214l     // Catch: java.lang.Throwable -> L18e
            g2.q3 r4 = r4.D()     // Catch: java.lang.Throwable -> L18e
            java.lang.String r5 = r7.f5332c     // Catch: java.lang.Throwable -> L18e
            java.lang.String r4 = r4.f(r5)     // Catch: java.lang.Throwable -> L18e
            java.lang.Object r5 = r7.f5334e     // Catch: java.lang.Throwable -> L18e
            r0.c(r3, r4, r5)     // Catch: java.lang.Throwable -> L18e
            g2.wa r6 = r1.h0()     // Catch: java.lang.Throwable -> L18e
            g2.va r7 = r1.E     // Catch: java.lang.Throwable -> L18e
            java.lang.String r8 = r2.f3275c     // Catch: java.lang.Throwable -> L18e
            r11 = 0
            r12 = 0
            r9 = 9
            r10 = 0
            r6.C(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L18e
        L210:
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L219:
            g2.k r2 = r1.f5205c
            R(r2)
            r2.f0()
            throw r0
    }

    public final void C() {
            r22 = this;
            r1 = r22
            g2.e5 r0 = r1.f()
            r0.h()
            r1.g()
            r2 = 1
            r1.f5223u = r2
            r3 = 0
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> L34
            r0.b()     // Catch: java.lang.Throwable -> L34
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> L34
            g2.d9 r0 = r0.L()     // Catch: java.lang.Throwable -> L34
            java.lang.Boolean r0 = r0.J()     // Catch: java.lang.Throwable -> L34
            if (r0 != 0) goto L38
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.a(r2)     // Catch: java.lang.Throwable -> L34
            r1.f5223u = r3
        L30:
            r1.K()
            return
        L34:
            r0 = move-exception
            r10 = 0
            goto L54a
        L38:
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L4e
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.a(r2)     // Catch: java.lang.Throwable -> L34
            r1.f5223u = r3
            goto L30
        L4e:
            long r4 = r1.f5217o     // Catch: java.lang.Throwable -> L34
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L5c
            r1.M()     // Catch: java.lang.Throwable -> L34
            r1.f5223u = r3
            goto L30
        L5c:
            g2.e5 r0 = r1.f()     // Catch: java.lang.Throwable -> L34
            r0.h()     // Catch: java.lang.Throwable -> L34
            java.util.List r0 = r1.f5226x     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L77
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r0 = r0.v()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "Uploading requested multiple times"
            r0.a(r2)     // Catch: java.lang.Throwable -> L34
            r1.f5223u = r3
            goto L30
        L77:
            g2.b4 r0 = r1.f5204b     // Catch: java.lang.Throwable -> L34
            R(r0)     // Catch: java.lang.Throwable -> L34
            boolean r0 = r0.m()     // Catch: java.lang.Throwable -> L34
            if (r0 != 0) goto L95
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r0 = r0.v()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.a(r2)     // Catch: java.lang.Throwable -> L34
            r1.M()     // Catch: java.lang.Throwable -> L34
            r1.f5223u = r3
            goto L30
        L95:
            x1.c r0 = r1.a()     // Catch: java.lang.Throwable -> L34
            long r4 = r0.a()     // Catch: java.lang.Throwable -> L34
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L34
            g2.h3 r8 = g2.i3.T     // Catch: java.lang.Throwable -> L34
            r9 = 0
            int r0 = r0.o(r9, r8)     // Catch: java.lang.Throwable -> L34
            r1.U()     // Catch: java.lang.Throwable -> L34
            long r10 = g2.g.I()     // Catch: java.lang.Throwable -> L34
            long r10 = r4 - r10
            r8 = 0
        Lb2:
            if (r8 >= r0) goto Lbd
            boolean r12 = r1.N(r9, r10)     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto Lbd
            int r8 = r8 + 1
            goto Lb2
        Lbd:
            g2.g9 r0 = r1.f5211i     // Catch: java.lang.Throwable -> L34
            g2.h4 r0 = r0.f4835g     // Catch: java.lang.Throwable -> L34
            long r10 = r0.a()     // Catch: java.lang.Throwable -> L34
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto Le0
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r0 = r0.q()     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch: java.lang.Throwable -> L34
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L34
            r0.b(r6, r7)     // Catch: java.lang.Throwable -> L34
        Le0:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L34
            R(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r12 = r0.Z()     // Catch: java.lang.Throwable -> L34
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L34
            r6 = -1
            if (r0 != 0) goto L4c1
            long r10 = r1.f5228z     // Catch: java.lang.Throwable -> L34
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 != 0) goto L13a
            g2.k r8 = r1.f5205c     // Catch: java.lang.Throwable -> L34
            R(r8)     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r0 = r8.P()     // Catch: java.lang.Throwable -> L11b android.database.sqlite.SQLiteException -> L11d
            java.lang.String r10 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r10 = r0.rawQuery(r10, r9)     // Catch: java.lang.Throwable -> L11b android.database.sqlite.SQLiteException -> L11d
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L115 android.database.sqlite.SQLiteException -> L117
            if (r0 != 0) goto L110
        L10c:
            r10.close()     // Catch: java.lang.Throwable -> L34
            goto L131
        L110:
            long r6 = r10.getLong(r3)     // Catch: java.lang.Throwable -> L115 android.database.sqlite.SQLiteException -> L117
            goto L10c
        L115:
            r0 = move-exception
            goto L119
        L117:
            r0 = move-exception
            goto L11f
        L119:
            r9 = r10
            goto L134
        L11b:
            r0 = move-exception
            goto L134
        L11d:
            r0 = move-exception
            r10 = r9
        L11f:
            g2.h5 r8 = r8.f4646a     // Catch: java.lang.Throwable -> L115
            g2.v3 r8 = r8.d()     // Catch: java.lang.Throwable -> L115
            g2.t3 r8 = r8.r()     // Catch: java.lang.Throwable -> L115
            java.lang.String r11 = "Error querying raw events"
            r8.b(r11, r0)     // Catch: java.lang.Throwable -> L115
            if (r10 == 0) goto L131
            goto L10c
        L131:
            r1.f5228z = r6     // Catch: java.lang.Throwable -> L34
            goto L13a
        L134:
            if (r9 == 0) goto L139
            r9.close()     // Catch: java.lang.Throwable -> L34
        L139:
            throw r0     // Catch: java.lang.Throwable -> L34
        L13a:
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L34
            g2.h3 r6 = g2.i3.f4927i     // Catch: java.lang.Throwable -> L34
            int r0 = r0.o(r12, r6)     // Catch: java.lang.Throwable -> L34
            g2.g r6 = r1.U()     // Catch: java.lang.Throwable -> L34
            g2.h3 r7 = g2.i3.f4929j     // Catch: java.lang.Throwable -> L34
            int r6 = r6.o(r12, r7)     // Catch: java.lang.Throwable -> L34
            int r6 = java.lang.Math.max(r3, r6)     // Catch: java.lang.Throwable -> L34
            g2.k r7 = r1.f5205c     // Catch: java.lang.Throwable -> L34
            R(r7)     // Catch: java.lang.Throwable -> L34
            r7.h()     // Catch: java.lang.Throwable -> L34
            r7.i()     // Catch: java.lang.Throwable -> L34
            if (r0 <= 0) goto L161
            r8 = 1
            goto L162
        L161:
            r8 = 0
        L162:
            u1.f.a(r8)     // Catch: java.lang.Throwable -> L34
            if (r6 <= 0) goto L169
            r8 = 1
            goto L16a
        L169:
            r8 = 0
        L16a:
            u1.f.a(r8)     // Catch: java.lang.Throwable -> L34
            u1.f.d(r12)     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r13 = r7.P()     // Catch: java.lang.Throwable -> L299 android.database.sqlite.SQLiteException -> L29b
            java.lang.String r14 = "queue"
            java.lang.String r10 = "rowid"
            java.lang.String r11 = "data"
            java.lang.String r15 = "retry_count"
            java.lang.String[] r15 = new java.lang.String[]{r10, r11, r15}     // Catch: java.lang.Throwable -> L299 android.database.sqlite.SQLiteException -> L29b
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r17 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L299 android.database.sqlite.SQLiteException -> L29b
            java.lang.String r20 = "rowid"
            java.lang.String r21 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L299 android.database.sqlite.SQLiteException -> L29b
            r18 = 0
            r19 = 0
            android.database.Cursor r10 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch: java.lang.Throwable -> L299 android.database.sqlite.SQLiteException -> L29b
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8
            if (r0 != 0) goto L1af
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8
            r10.close()     // Catch: java.lang.Throwable -> L34
            r17 = 1
            goto L2bd
        L1a3:
            r0 = move-exception
            r21 = r10
            goto L292
        L1a8:
            r0 = move-exception
            r21 = r10
            r17 = 1
            goto L296
        L1af:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8
            r11.<init>()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8
            r13 = 0
        L1b5:
            long r14 = r10.getLong(r3)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8
            byte[] r0 = r10.getBlob(r2)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8 java.io.IOException -> L265
            g2.pa r9 = r7.f4655b     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8 java.io.IOException -> L265
            g2.ra r9 = r9.f5209g     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8 java.io.IOException -> L265
            R(r9)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1a8 java.io.IOException -> L265
            r17 = 1
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r3.<init>()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r20 = r2
        L1db:
            int r2 = r0.read(r8)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            if (r2 > 0) goto L245
            r0.close()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            r20.close()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L241
            boolean r2 = r11.isEmpty()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            if (r2 != 0) goto L1fe
            int r2 = r0.length     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            int r2 = r2 + r13
            if (r2 <= r6) goto L1fe
            r21 = r10
            goto L28d
        L1f9:
            r0 = move-exception
            r21 = r10
            goto L296
        L1fe:
            com.google.android.gms.internal.measurement.t4 r2 = com.google.android.gms.internal.measurement.u4.S1()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L22c
            com.google.android.gms.internal.measurement.z9 r2 = g2.ra.E(r2, r0)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L22c
            com.google.android.gms.internal.measurement.t4 r2 = (com.google.android.gms.internal.measurement.t4) r2     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9 java.io.IOException -> L22c
            r3 = 2
            boolean r8 = r10.isNull(r3)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            if (r8 != 0) goto L216
            int r8 = r10.getInt(r3)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            r2.Y(r8)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
        L216:
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.a9 r0 = r2.o()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            com.google.android.gms.internal.measurement.u4 r0 = (com.google.android.gms.internal.measurement.u4) r0     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            r11.add(r0)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
        L229:
            r21 = r10
            goto L27d
        L22c:
            r0 = move-exception
            g2.h5 r2 = r7.f4646a     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r8 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            r2.c(r3, r8, r0)     // Catch: java.lang.Throwable -> L1a3 android.database.sqlite.SQLiteException -> L1f9
            goto L229
        L241:
            r0 = move-exception
            r21 = r10
            goto L253
        L245:
            r21 = r10
            r10 = 0
            r3.write(r8, r10, r2)     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L252
            r10 = r21
            goto L1db
        L24e:
            r0 = move-exception
            goto L292
        L250:
            r0 = move-exception
            goto L296
        L252:
            r0 = move-exception
        L253:
            g2.h5 r2 = r9.f4646a     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L263
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L263
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L263
            java.lang.String r3 = "Failed to ungzip content"
            r2.b(r3, r0)     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L263
            throw r0     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250 java.io.IOException -> L263
        L263:
            r0 = move-exception
            goto L26a
        L265:
            r0 = move-exception
            r21 = r10
            r17 = 1
        L26a:
            g2.h5 r2 = r7.f4646a     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r8 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
            r2.c(r3, r8, r0)     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
        L27d:
            boolean r0 = r21.moveToNext()     // Catch: java.lang.Throwable -> L24e android.database.sqlite.SQLiteException -> L250
            if (r0 == 0) goto L28d
            if (r13 <= r6) goto L286
            goto L28d
        L286:
            r10 = r21
            r2 = 1
            r3 = 0
            r9 = 0
            goto L1b5
        L28d:
            r21.close()     // Catch: java.lang.Throwable -> L34
            r0 = r11
            goto L2bd
        L292:
            r9 = r21
            goto L4bb
        L296:
            r10 = r21
            goto L2a3
        L299:
            r0 = move-exception
            goto L29f
        L29b:
            r0 = move-exception
            r17 = 1
            goto L2a2
        L29f:
            r9 = 0
            goto L4bb
        L2a2:
            r10 = 0
        L2a3:
            g2.h5 r2 = r7.f4646a     // Catch: java.lang.Throwable -> L4b9
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L4b9
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L4b9
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r6 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L4b9
            r2.c(r3, r6, r0)     // Catch: java.lang.Throwable -> L4b9
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L4b9
            if (r10 == 0) goto L2bd
            r10.close()     // Catch: java.lang.Throwable -> L34
        L2bd:
            boolean r2 = r0.isEmpty()     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L4a0
            g2.f6 r2 = r1.c0(r12)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.measurement.internal.zzha r3 = com.google.android.gms.measurement.internal.zzha.zza     // Catch: java.lang.Throwable -> L34
            boolean r2 = r2.j(r3)     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L324
            java.util.Iterator r2 = r0.iterator()     // Catch: java.lang.Throwable -> L34
        L2d3:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r3 == 0) goto L2f2
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L34
            android.util.Pair r3 = (android.util.Pair) r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r3 = r3.first     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.u4 r3 = (com.google.android.gms.internal.measurement.u4) r3     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = r3.N()     // Catch: java.lang.Throwable -> L34
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L34
            if (r6 != 0) goto L2d3
            java.lang.String r2 = r3.N()     // Catch: java.lang.Throwable -> L34
            goto L2f3
        L2f2:
            r2 = 0
        L2f3:
            if (r2 == 0) goto L324
            r3 = 0
        L2f6:
            int r6 = r0.size()     // Catch: java.lang.Throwable -> L34
            if (r3 >= r6) goto L324
            java.lang.Object r6 = r0.get(r3)     // Catch: java.lang.Throwable -> L34
            android.util.Pair r6 = (android.util.Pair) r6     // Catch: java.lang.Throwable -> L34
            java.lang.Object r6 = r6.first     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.u4 r6 = (com.google.android.gms.internal.measurement.u4) r6     // Catch: java.lang.Throwable -> L34
            java.lang.String r7 = r6.N()     // Catch: java.lang.Throwable -> L34
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L311
            goto L321
        L311:
            java.lang.String r6 = r6.N()     // Catch: java.lang.Throwable -> L34
            boolean r6 = r6.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r6 != 0) goto L321
            r10 = 0
            java.util.List r0 = r0.subList(r10, r3)     // Catch: java.lang.Throwable -> L34
            goto L324
        L321:
            int r3 = r3 + 1
            goto L2f6
        L324:
            com.google.android.gms.internal.measurement.r4 r2 = com.google.android.gms.internal.measurement.s4.D()     // Catch: java.lang.Throwable -> L34
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            int r7 = r0.size()     // Catch: java.lang.Throwable -> L34
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L34
            g2.g r7 = r1.U()     // Catch: java.lang.Throwable -> L34
            boolean r7 = r7.C(r12)     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L34d
            g2.f6 r7 = r1.c0(r12)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.zza     // Catch: java.lang.Throwable -> L34
            boolean r7 = r7.j(r8)     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L34d
            r7 = 1
            goto L34e
        L34d:
            r7 = 0
        L34e:
            g2.f6 r8 = r1.c0(r12)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.measurement.internal.zzha r9 = com.google.android.gms.measurement.internal.zzha.zza     // Catch: java.lang.Throwable -> L34
            boolean r8 = r8.j(r9)     // Catch: java.lang.Throwable -> L34
            g2.f6 r9 = r1.c0(r12)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.measurement.internal.zzha r10 = com.google.android.gms.measurement.internal.zzha.zzb     // Catch: java.lang.Throwable -> L34
            boolean r9 = r9.j(r10)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.ae.b()     // Catch: java.lang.Throwable -> L34
            g2.g r10 = r1.U()     // Catch: java.lang.Throwable -> L34
            g2.h3 r11 = g2.i3.f4944q0     // Catch: java.lang.Throwable -> L34
            boolean r10 = r10.B(r12, r11)     // Catch: java.lang.Throwable -> L34
            r11 = 0
        L370:
            if (r11 >= r3) goto L3ea
            java.lang.Object r13 = r0.get(r11)     // Catch: java.lang.Throwable -> L34
            android.util.Pair r13 = (android.util.Pair) r13     // Catch: java.lang.Throwable -> L34
            java.lang.Object r13 = r13.first     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.u4 r13 = (com.google.android.gms.internal.measurement.u4) r13     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.x8 r13 = r13.m()     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.t4 r13 = (com.google.android.gms.internal.measurement.t4) r13     // Catch: java.lang.Throwable -> L34
            java.lang.Object r14 = r0.get(r11)     // Catch: java.lang.Throwable -> L34
            android.util.Pair r14 = (android.util.Pair) r14     // Catch: java.lang.Throwable -> L34
            java.lang.Object r14 = r14.second     // Catch: java.lang.Throwable -> L34
            java.lang.Long r14 = (java.lang.Long) r14     // Catch: java.lang.Throwable -> L34
            r6.add(r14)     // Catch: java.lang.Throwable -> L34
            g2.g r14 = r1.U()     // Catch: java.lang.Throwable -> L34
            r14.q()     // Catch: java.lang.Throwable -> L34
            r14 = 79000(0x13498, double:3.9031E-319)
            r13.f0(r14)     // Catch: java.lang.Throwable -> L34
            r13.e0(r4)     // Catch: java.lang.Throwable -> L34
            g2.h5 r14 = r1.f5214l     // Catch: java.lang.Throwable -> L34
            r14.b()     // Catch: java.lang.Throwable -> L34
            r14 = 0
            r13.Z(r14)     // Catch: java.lang.Throwable -> L34
            if (r7 != 0) goto L3ad
            r13.D0()     // Catch: java.lang.Throwable -> L34
        L3ad:
            if (r8 != 0) goto L3b5
            r13.K0()     // Catch: java.lang.Throwable -> L34
            r13.G0()     // Catch: java.lang.Throwable -> L34
        L3b5:
            if (r9 != 0) goto L3ba
            r13.A0()     // Catch: java.lang.Throwable -> L34
        L3ba:
            r1.h(r12, r13)     // Catch: java.lang.Throwable -> L34
            if (r10 != 0) goto L3c2
            r13.L0()     // Catch: java.lang.Throwable -> L34
        L3c2:
            g2.g r14 = r1.U()     // Catch: java.lang.Throwable -> L34
            g2.h3 r15 = g2.i3.X     // Catch: java.lang.Throwable -> L34
            boolean r14 = r14.B(r12, r15)     // Catch: java.lang.Throwable -> L34
            if (r14 == 0) goto L3e4
            com.google.android.gms.internal.measurement.a9 r14 = r13.o()     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.u4 r14 = (com.google.android.gms.internal.measurement.u4) r14     // Catch: java.lang.Throwable -> L34
            byte[] r14 = r14.j()     // Catch: java.lang.Throwable -> L34
            g2.ra r15 = r1.f5209g     // Catch: java.lang.Throwable -> L34
            R(r15)     // Catch: java.lang.Throwable -> L34
            long r14 = r15.z(r14)     // Catch: java.lang.Throwable -> L34
            r13.B(r14)     // Catch: java.lang.Throwable -> L34
        L3e4:
            r2.s(r13)     // Catch: java.lang.Throwable -> L34
            int r11 = r11 + 1
            goto L370
        L3ea:
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r0.D()     // Catch: java.lang.Throwable -> L34
            r7 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r7)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L409
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> L34
            R(r0)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.a9 r7 = r2.o()     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.s4) r7     // Catch: java.lang.Throwable -> L34
            java.lang.String r9 = r0.F(r7)     // Catch: java.lang.Throwable -> L34
            goto L40a
        L409:
            r9 = 0
        L40a:
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> L34
            R(r0)     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.a9 r0 = r2.o()     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.s4) r0     // Catch: java.lang.Throwable -> L34
            byte[] r14 = r0.j()     // Catch: java.lang.Throwable -> L34
            g2.da r0 = r1.f5212j     // Catch: java.lang.Throwable -> L34
            g2.ca r0 = r0.i(r12)     // Catch: java.lang.Throwable -> L34
            boolean r7 = r6.isEmpty()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r7 = r7 ^ 1
            u1.f.a(r7)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.util.List r7 = r1.f5226x     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            if (r7 == 0) goto L43a
            g2.v3 r6 = r1.d()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.t3 r6 = r6.r()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r6.a(r7)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            goto L441
        L43a:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r1.f5226x = r7     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
        L441:
            g2.g9 r6 = r1.f5211i     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.h4 r6 = r6.f4836h     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r6.b(r4)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L455
            r10 = 0
            com.google.android.gms.internal.measurement.u4 r2 = r2.t(r10)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.String r4 = r2.W1()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
        L455:
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.t3 r2 = r2.v()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r5 = r14.length     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r2.d(r3, r4, r5, r9)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r2 = 1
            r1.f5222t = r2     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.b4 r11 = r1.f5204b     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            R(r11)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.net.URL r13 = new java.net.URL     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.lang.String r2 = r0.a()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r13.<init>(r2)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            java.util.Map r15 = r0.b()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.fa r2 = new g2.fa     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r2.<init>(r1, r12)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r11.h()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r11.i()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            u1.f.h(r13)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            u1.f.h(r14)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            u1.f.h(r2)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.h5 r3 = r11.f4646a     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.e5 r3 = r3.f()     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            g2.a4 r10 = new g2.a4     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
            r3.y(r10)     // Catch: java.lang.Throwable -> L34 java.net.MalformedURLException -> L4a3
        L4a0:
            r10 = 0
            goto L540
        L4a3:
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L34
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L34
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L34
            goto L4a0
        L4b9:
            r0 = move-exception
            r9 = r10
        L4bb:
            if (r9 == 0) goto L4c0
            r9.close()     // Catch: java.lang.Throwable -> L34
        L4c0:
            throw r0     // Catch: java.lang.Throwable -> L34
        L4c1:
            r1.f5228z = r6     // Catch: java.lang.Throwable -> L34
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> L34
            R(r2)     // Catch: java.lang.Throwable -> L34
            r1.U()     // Catch: java.lang.Throwable -> L34
            long r6 = g2.g.I()     // Catch: java.lang.Throwable -> L34
            long r4 = r4 - r6
            r2.h()     // Catch: java.lang.Throwable -> L34
            r2.i()     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch: java.lang.Throwable -> L511 android.database.sqlite.SQLiteException -> L513
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L511 android.database.sqlite.SQLiteException -> L513
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L511 android.database.sqlite.SQLiteException -> L513
            android.database.Cursor r3 = r0.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L511 android.database.sqlite.SQLiteException -> L513
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
            if (r0 != 0) goto L506
            g2.h5 r0 = r2.f4646a     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
            g2.t3 r0 = r0.v()     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.a(r4)     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
        L4fd:
            r3.close()     // Catch: java.lang.Throwable -> L34
        L500:
            r9 = 0
            goto L52a
        L502:
            r0 = move-exception
            goto L50f
        L504:
            r0 = move-exception
            goto L518
        L506:
            r10 = 0
            java.lang.String r9 = r3.getString(r10)     // Catch: java.lang.Throwable -> L502 android.database.sqlite.SQLiteException -> L504
            r3.close()     // Catch: java.lang.Throwable -> L34
            goto L52a
        L50f:
            r9 = r3
            goto L544
        L511:
            r0 = move-exception
            goto L515
        L513:
            r0 = move-exception
            goto L517
        L515:
            r9 = 0
            goto L544
        L517:
            r3 = 0
        L518:
            g2.h5 r2 = r2.f4646a     // Catch: java.lang.Throwable -> L502
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L502
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L502
            java.lang.String r4 = "Error selecting expired configs"
            r2.b(r4, r0)     // Catch: java.lang.Throwable -> L502
            if (r3 == 0) goto L500
            goto L4fd
        L52a:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L34
            if (r0 != 0) goto L4a0
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L34
            R(r0)     // Catch: java.lang.Throwable -> L34
            g2.e6 r0 = r0.R(r9)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L4a0
            r1.i(r0)     // Catch: java.lang.Throwable -> L34
            goto L4a0
        L540:
            r1.f5223u = r10
            goto L30
        L544:
            if (r9 == 0) goto L549
            r9.close()     // Catch: java.lang.Throwable -> L34
        L549:
            throw r0     // Catch: java.lang.Throwable -> L34
        L54a:
            r1.f5223u = r10
            r1.K()
            goto L551
        L550:
            throw r0
        L551:
            goto L550
    }

    public final void D(com.google.android.gms.measurement.internal.zzau r41, com.google.android.gms.measurement.internal.zzq r42) {
            r40 = this;
            r1 = r40
            r0 = r41
            r2 = r42
            java.lang.String r3 = "metadata_fingerprint"
            java.lang.String r4 = "app_id"
            java.lang.String r5 = "raw_events"
            java.lang.String r6 = "_sno"
            u1.f.h(r2)
            java.lang.String r7 = r2.f3275c
            u1.f.d(r7)
            long r7 = java.lang.System.nanoTime()
            g2.e5 r9 = r1.f()
            r9.h()
            r1.g()
            java.lang.String r12 = r2.f3275c
            g2.ra r9 = r1.f5209g
            R(r9)
            boolean r9 = g2.ra.n(r41, r42)
            if (r9 != 0) goto L33
            goto Ldc
        L33:
            boolean r9 = r2.f3282r
            if (r9 == 0) goto Lb08
            g2.y4 r9 = r1.f5203a
            R(r9)
            java.lang.String r10 = r0.f3263c
            boolean r9 = r9.F(r12, r10)
            java.lang.String r10 = "_err"
            r11 = 0
            if (r9 == 0) goto Ldd
            g2.v3 r2 = r1.d()
            g2.t3 r2 = r2.w()
            java.lang.Object r3 = g2.v3.z(r12)
            g2.h5 r4 = r1.f5214l
            g2.q3 r4 = r4.D()
            java.lang.String r5 = r0.f3263c
            java.lang.String r4 = r4.d(r5)
            java.lang.String r5 = "Dropping blocked event. appId"
            r2.c(r5, r3, r4)
            g2.y4 r2 = r1.f5203a
            R(r2)
            boolean r2 = r2.D(r12)
            if (r2 != 0) goto L95
            g2.y4 r2 = r1.f5203a
            R(r2)
            boolean r2 = r2.G(r12)
            if (r2 == 0) goto L7b
            goto L95
        L7b:
            java.lang.String r2 = r0.f3263c
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto Ldc
            g2.wa r10 = r1.h0()
            g2.va r11 = r1.E
            java.lang.String r15 = r0.f3263c
            java.lang.String r14 = "_ev"
            r16 = 0
            r13 = 11
            r10.C(r11, r12, r13, r14, r15, r16)
            return
        L95:
            g2.k r0 = r1.f5205c
            R(r0)
            g2.e6 r0 = r0.R(r12)
            if (r0 == 0) goto Ldc
            long r2 = r0.b0()
            long r4 = r0.S()
            long r2 = java.lang.Math.max(r2, r4)
            x1.c r4 = r1.a()
            long r4 = r4.a()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            r1.U()
            g2.h3 r4 = g2.i3.B
            java.lang.Object r4 = r4.a(r11)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto Ldc
            g2.v3 r2 = r1.d()
            g2.t3 r2 = r2.q()
            java.lang.String r3 = "Fetching config for blocked app"
            r2.a(r3)
            r1.i(r0)
        Ldc:
            return
        Ldd:
            g2.w3 r0 = g2.w3.b(r0)
            g2.wa r9 = r1.h0()
            g2.g r13 = r1.U()
            int r13 = r13.n(r12)
            r9.B(r0, r13)
            com.google.android.gms.internal.measurement.vc.b()
            g2.g r9 = r1.U()
            g2.h3 r13 = g2.i3.C0
            boolean r9 = r9.B(r11, r13)
            if (r9 == 0) goto L10e
            g2.g r9 = r1.U()
            g2.h3 r14 = g2.i3.S
            r15 = 10
            r13 = 35
            int r9 = r9.p(r12, r14, r15, r13)
            goto L10f
        L10e:
            r9 = 0
        L10f:
            java.util.TreeSet r13 = new java.util.TreeSet
            android.os.Bundle r14 = r0.f5401d
            java.util.Set r14 = r14.keySet()
            r13.<init>(r14)
            java.util.Iterator r13 = r13.iterator()
        L11e:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L153
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = "items"
            boolean r15 = r15.equals(r14)
            if (r15 == 0) goto L11e
            g2.wa r15 = r1.h0()
            android.os.Bundle r11 = r0.f5401d
            android.os.Parcelable[] r11 = r11.getParcelableArray(r14)
            com.google.android.gms.internal.measurement.vc.b()
            g2.g r14 = r1.U()
            r27 = r7
            g2.h3 r7 = g2.i3.C0
            r8 = 0
            boolean r7 = r14.B(r8, r7)
            r15.A(r11, r9, r7)
            r7 = r27
            r11 = 0
            goto L11e
        L153:
            r27 = r7
            com.google.android.gms.measurement.internal.zzau r7 = r0.a()
            g2.v3 r0 = r1.d()
            java.lang.String r0 = r0.D()
            r8 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r8)
            if (r0 == 0) goto L17f
            g2.v3 r0 = r1.d()
            g2.t3 r0 = r0.v()
            g2.h5 r8 = r1.f5214l
            g2.q3 r8 = r8.D()
            java.lang.String r8 = r8.c(r7)
            java.lang.String r9 = "Logging event"
            r0.b(r9, r8)
        L17f:
            com.google.android.gms.internal.measurement.sc.b()
            g2.g r0 = r1.U()
            g2.h3 r8 = g2.i3.f4962z0
            r9 = 0
            r0.B(r9, r8)
            g2.k r0 = r1.f5205c
            R(r0)
            r0.e0()
            r1.S(r2)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = "ecommerce_purchase"
            java.lang.String r8 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = "refund"
            r11 = 1
            if (r0 != 0) goto L1b6
            java.lang.String r0 = "purchase"
            java.lang.String r13 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.equals(r13)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L1b6
            java.lang.String r0 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r8.equals(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L1b8
        L1b6:
            r0 = 1
            goto L1bd
        L1b8:
            r0 = 0
            goto L1bd
        L1ba:
            r0 = move-exception
            goto Laff
        L1bd:
            java.lang.String r13 = "_iap"
            java.lang.String r14 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r13 = r13.equals(r14)     // Catch: java.lang.Throwable -> L1ba
            if (r13 != 0) goto L1ce
            if (r0 == 0) goto L1cb
            r0 = 1
            goto L1ce
        L1cb:
            r9 = r10
            goto L331
        L1ce:
            com.google.android.gms.measurement.internal.zzas r13 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r14 = "currency"
            java.lang.String r13 = r13.o(r14)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r14 = "value"
            if (r0 == 0) goto L241
            com.google.android.gms.measurement.internal.zzas r0 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            java.lang.Double r0 = r0.h(r14)     // Catch: java.lang.Throwable -> L1ba
            double r15 = r0.doubleValue()     // Catch: java.lang.Throwable -> L1ba
            r17 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r15 = r15 * r17
            r19 = 0
            int r0 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r0 != 0) goto L201
            com.google.android.gms.measurement.internal.zzas r0 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = r0.k(r14)     // Catch: java.lang.Throwable -> L1ba
            long r14 = r0.longValue()     // Catch: java.lang.Throwable -> L1ba
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r15 = r14 * r17
        L201:
            r17 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 > 0) goto L21b
            r17 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 < 0) goto L21b
            long r14 = java.lang.Math.round(r15)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r8.equals(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L24b
            long r14 = -r14
            goto L24b
        L21b:
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r2 = "Data lost. Currency value is too big. appId"
            java.lang.Object r3 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Double r4 = java.lang.Double.valueOf(r15)     // Catch: java.lang.Throwable -> L1ba
            r0.c(r2, r3, r4)     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.o()     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L241:
            com.google.android.gms.measurement.internal.zzas r0 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = r0.k(r14)     // Catch: java.lang.Throwable -> L1ba
            long r14 = r0.longValue()     // Catch: java.lang.Throwable -> L1ba
        L24b:
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L1cb
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r13.toUpperCase(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r0.matches(r8)     // Catch: java.lang.Throwable -> L1ba
            if (r8 == 0) goto L1cb
            java.lang.String r8 = "_ltv_"
            java.lang.String r13 = r8.concat(r0)     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            g2.ta r0 = r0.X(r12, r13)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L276
            java.lang.Object r0 = r0.f5334e     // Catch: java.lang.Throwable -> L1ba
            boolean r8 = r0 instanceof java.lang.Long     // Catch: java.lang.Throwable -> L1ba
            if (r8 != 0) goto L279
        L276:
            r8 = r9
            r9 = r10
            goto L29f
        L279:
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Throwable -> L1ba
            long r16 = r0.longValue()     // Catch: java.lang.Throwable -> L1ba
            r8 = r10
            g2.ta r10 = new g2.ta     // Catch: java.lang.Throwable -> L1ba
            r11 = r12
            r18 = 1
            java.lang.String r12 = r7.f3265m     // Catch: java.lang.Throwable -> L1ba
            x1.c r0 = r1.a()     // Catch: java.lang.Throwable -> L1ba
            long r19 = r0.a()     // Catch: java.lang.Throwable -> L1ba
            long r16 = r16 + r14
            java.lang.Long r16 = java.lang.Long.valueOf(r16)     // Catch: java.lang.Throwable -> L1ba
            r14 = r9
            r9 = r8
            r8 = r14
            r14 = r19
            r10.<init>(r11, r12, r13, r14, r16)     // Catch: java.lang.Throwable -> L1ba
            r12 = r11
            goto L2f8
        L29f:
            g2.k r10 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r10)     // Catch: java.lang.Throwable -> L1ba
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.G     // Catch: java.lang.Throwable -> L1ba
            int r0 = r0.o(r12, r11)     // Catch: java.lang.Throwable -> L1ba
            int r0 = r0 + (-1)
            u1.f.d(r12)     // Catch: java.lang.Throwable -> L1ba
            r10.h()     // Catch: java.lang.Throwable -> L1ba
            r10.i()     // Catch: java.lang.Throwable -> L1ba
            android.database.sqlite.SQLiteDatabase r11 = r10.P()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L2cb
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L2cb
            java.lang.String[] r0 = new java.lang.String[]{r12, r12, r0}     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L2cb
            r11.execSQL(r8, r0)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L2cb
            goto L2df
        L2cb:
            r0 = move-exception
            g2.h5 r8 = r10.f4646a     // Catch: java.lang.Throwable -> L1ba
            g2.v3 r8 = r8.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r8 = r8.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = "Error pruning currencies. appId"
            java.lang.Object r11 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            r8.c(r10, r11, r0)     // Catch: java.lang.Throwable -> L1ba
        L2df:
            g2.ta r10 = new g2.ta     // Catch: java.lang.Throwable -> L1ba
            r11 = r12
            java.lang.String r12 = r7.f3265m     // Catch: java.lang.Throwable -> L1ba
            x1.c r0 = r1.a()     // Catch: java.lang.Throwable -> L1ba
            long r16 = r0.a()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L1ba
            r14 = r16
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r16)     // Catch: java.lang.Throwable -> L1ba
            r12 = r11
        L2f8:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.x(r10)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L331
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r11 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r13 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.q3 r13 = r13.D()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r14 = r10.f5332c     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r13 = r13.f(r14)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r10 = r10.f5334e     // Catch: java.lang.Throwable -> L1ba
            r0.d(r8, r11, r13, r10)     // Catch: java.lang.Throwable -> L1ba
            g2.wa r10 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            g2.va r11 = r1.E     // Catch: java.lang.Throwable -> L1ba
            r15 = 0
            r16 = 0
            r13 = 9
            r14 = 0
            r10.C(r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L1ba
        L331:
            java.lang.String r0 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r17 = g2.wa.Z(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r19 = r9.equals(r0)     // Catch: java.lang.Throwable -> L1ba
            r1.h0()     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.measurement.internal.zzas r0 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L349
            r13 = 0
        L346:
            r29 = 0
            goto L36d
        L349:
            g2.r r10 = new g2.r     // Catch: java.lang.Throwable -> L1ba
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
        L350:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> L1ba
            if (r11 == 0) goto L346
            java.lang.String r11 = r10.a()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r11 = r0.n(r11)     // Catch: java.lang.Throwable -> L1ba
            boolean r15 = r11 instanceof android.os.Parcelable[]     // Catch: java.lang.Throwable -> L1ba
            if (r15 == 0) goto L36a
            android.os.Parcelable[] r11 = (android.os.Parcelable[]) r11     // Catch: java.lang.Throwable -> L1ba
            int r11 = r11.length     // Catch: java.lang.Throwable -> L1ba
            r29 = 0
            long r8 = (long) r11     // Catch: java.lang.Throwable -> L1ba
            long r13 = r13 + r8
            goto L350
        L36a:
            r29 = 0
            goto L350
        L36d:
            g2.k r10 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r10)     // Catch: java.lang.Throwable -> L1ba
            r8 = r13
            r13 = r12
            long r11 = r1.F()     // Catch: java.lang.Throwable -> L1ba
            r21 = 1
            long r14 = r8 + r21
            r18 = 0
            r20 = 0
            r16 = 1
            g2.i r0 = r10.U(r11, r13, r14, r16, r17, r18, r19, r20)     // Catch: java.lang.Throwable -> L1ba
            r12 = r13
            r8 = r17
            long r9 = r0.f4904b     // Catch: java.lang.Throwable -> L1ba
            r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.f4935m     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
            java.lang.Object r11 = r11.a(r13)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch: java.lang.Throwable -> L1ba
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L1ba
            long r13 = (long) r11     // Catch: java.lang.Throwable -> L1ba
            long r9 = r9 - r13
            r13 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r9 > r29 ? 1 : (r9 == r29 ? 0 : -1))
            if (r11 <= 0) goto L3d0
            long r9 = r9 % r13
            int r2 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r2 != 0) goto L3bf
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            long r5 = r0.f4904b     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L1ba
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba
        L3bf:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.o()     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L3d0:
            if (r8 == 0) goto L429
            long r9 = r0.f4903a     // Catch: java.lang.Throwable -> L1ba
            r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.f4939o     // Catch: java.lang.Throwable -> L1ba
            r15 = 0
            java.lang.Object r11 = r11.a(r15)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch: java.lang.Throwable -> L1ba
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L1ba
            r15 = r13
            long r13 = (long) r11     // Catch: java.lang.Throwable -> L1ba
            long r9 = r9 - r13
            int r11 = (r9 > r29 ? 1 : (r9 == r29 ? 0 : -1))
            if (r11 <= 0) goto L429
            long r9 = r9 % r15
            int r2 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r2 != 0) goto L407
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            long r5 = r0.f4903a     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L1ba
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba
        L407:
            g2.wa r10 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            g2.va r11 = r1.E     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r14 = "_ev"
            java.lang.String r15 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            r16 = 0
            r13 = 16
            r10.C(r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.o()     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L429:
            r9 = 1000000(0xf4240, float:1.401298E-39)
            if (r19 == 0) goto L477
            long r10 = r0.f4906d     // Catch: java.lang.Throwable -> L1ba
            g2.g r13 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r14 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r15 = g2.i3.f4937n     // Catch: java.lang.Throwable -> L1ba
            int r13 = r13.o(r14, r15)     // Catch: java.lang.Throwable -> L1ba
            int r13 = java.lang.Math.min(r9, r13)     // Catch: java.lang.Throwable -> L1ba
            r14 = 0
            int r13 = java.lang.Math.max(r14, r13)     // Catch: java.lang.Throwable -> L1ba
            long r13 = (long) r13     // Catch: java.lang.Throwable -> L1ba
            long r10 = r10 - r13
            int r13 = (r10 > r29 ? 1 : (r10 == r29 ? 0 : -1))
            if (r13 <= 0) goto L477
            int r2 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r2 != 0) goto L466
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            long r5 = r0.f4906d     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L1ba
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba
        L466:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.o()     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L477:
            com.google.android.gms.measurement.internal.zzas r0 = r7.f3264e     // Catch: java.lang.Throwable -> L1ba
            android.os.Bundle r10 = r0.g()     // Catch: java.lang.Throwable -> L1ba
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = "_o"
            java.lang.String r13 = r7.f3265m     // Catch: java.lang.Throwable -> L1ba
            r0.D(r10, r11, r13)     // Catch: java.lang.Throwable -> L1ba
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.U(r12)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = "_r"
            if (r0 == 0) goto L4a8
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r13 = "_dbg"
            java.lang.Long r14 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Throwable -> L1ba
            r0.D(r10, r13, r14)     // Catch: java.lang.Throwable -> L1ba
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            r0.D(r10, r11, r14)     // Catch: java.lang.Throwable -> L1ba
        L4a8:
            java.lang.String r0 = "_s"
            java.lang.String r13 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.equals(r13)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L4ce
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r13 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            g2.ta r0 = r0.X(r13, r6)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L4ce
            java.lang.Object r13 = r0.f5334e     // Catch: java.lang.Throwable -> L1ba
            boolean r13 = r13 instanceof java.lang.Long     // Catch: java.lang.Throwable -> L1ba
            if (r13 == 0) goto L4ce
            g2.wa r13 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r0 = r0.f5334e     // Catch: java.lang.Throwable -> L1ba
            r13.D(r10, r6, r0)     // Catch: java.lang.Throwable -> L1ba
        L4ce:
            g2.k r6 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r6)     // Catch: java.lang.Throwable -> L1ba
            u1.f.d(r12)     // Catch: java.lang.Throwable -> L1ba
            r6.h()     // Catch: java.lang.Throwable -> L1ba
            r6.i()     // Catch: java.lang.Throwable -> L1ba
            android.database.sqlite.SQLiteDatabase r0 = r6.P()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            g2.h5 r13 = r6.f4646a     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            g2.g r13 = r13.z()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            g2.h3 r14 = g2.i3.f4945r     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            int r13 = r13.o(r12, r14)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            int r9 = java.lang.Math.min(r9, r13)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L507
            r13 = 0
            int r9 = java.lang.Math.max(r13, r9)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L505
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L505
            java.lang.String r14 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            java.lang.String[] r9 = new java.lang.String[]{r12, r9}     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L505
            int r0 = r0.delete(r5, r14, r9)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> L505
            long r14 = (long) r0
            goto L51e
        L505:
            r0 = move-exception
            goto L509
        L507:
            r0 = move-exception
            r13 = 0
        L509:
            g2.h5 r6 = r6.f4646a     // Catch: java.lang.Throwable -> L1ba
            g2.v3 r6 = r6.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r6 = r6.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = "Error deleting over the limit events. appId"
            java.lang.Object r14 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            r6.c(r9, r14, r0)     // Catch: java.lang.Throwable -> L1ba
            r14 = r29
        L51e:
            int r0 = (r14 > r29 ? 1 : (r14 == r29 ? 0 : -1))
            if (r0 <= 0) goto L537
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r6 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r9 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L1ba
            r0.c(r6, r9, r14)     // Catch: java.lang.Throwable -> L1ba
        L537:
            r19 = r10
            g2.p r10 = new g2.p     // Catch: java.lang.Throwable -> L1ba
            r6 = r11
            g2.h5 r11 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            r13 = r12
            r14 = 0
            java.lang.String r12 = r7.f3265m     // Catch: java.lang.Throwable -> L1ba
            r9 = 0
            java.lang.String r14 = r7.f3263c     // Catch: java.lang.Throwable -> L1ba
            r41 = r10
            long r9 = r7.f3266n     // Catch: java.lang.Throwable -> L1ba
            r17 = 0
            r15 = r9
            r9 = 0
            r10 = r41
            r10.<init>(r11, r12, r13, r14, r15, r17, r19)     // Catch: java.lang.Throwable -> L1ba
            r0 = r10
            r12 = r13
            g2.k r7 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r7)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = r0.f5187b     // Catch: java.lang.Throwable -> L1ba
            g2.q r7 = r7.V(r12, r10)     // Catch: java.lang.Throwable -> L1ba
            if (r7 != 0) goto L5d8
            g2.k r7 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r7)     // Catch: java.lang.Throwable -> L1ba
            long r10 = r7.O(r12)     // Catch: java.lang.Throwable -> L1ba
            g2.g r7 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            int r7 = r7.l(r12)     // Catch: java.lang.Throwable -> L1ba
            long r13 = (long) r7     // Catch: java.lang.Throwable -> L1ba
            int r7 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r7 < 0) goto L5ba
            if (r8 == 0) goto L5ba
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r5 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.q3 r5 = r5.D()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r0.f5187b     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r5.d(r0)     // Catch: java.lang.Throwable -> L1ba
            g2.g r5 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            int r5 = r5.l(r12)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L1ba
            r2.d(r3, r4, r0, r5)     // Catch: java.lang.Throwable -> L1ba
            g2.wa r10 = r1.h0()     // Catch: java.lang.Throwable -> L1ba
            g2.va r11 = r1.E     // Catch: java.lang.Throwable -> L1ba
            r15 = 0
            r16 = 0
            r13 = 8
            r14 = 0
            r10.C(r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L5ba:
            g2.q r10 = new g2.q     // Catch: java.lang.Throwable -> L1ba
            r11 = r12
            java.lang.String r12 = r0.f5187b     // Catch: java.lang.Throwable -> L1ba
            long r7 = r0.f5189d     // Catch: java.lang.Throwable -> L1ba
            r25 = 0
            r26 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r19 = r7
            r10.<init>(r11, r12, r13, r15, r17, r19, r21, r23, r24, r25, r26)     // Catch: java.lang.Throwable -> L1ba
            r7 = r0
            goto L5e8
        L5d8:
            g2.h5 r8 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            long r10 = r7.f5234f     // Catch: java.lang.Throwable -> L1ba
            g2.p r10 = r0.a(r8, r10)     // Catch: java.lang.Throwable -> L1ba
            long r11 = r10.f5189d     // Catch: java.lang.Throwable -> L1ba
            g2.q r0 = r7.c(r11)     // Catch: java.lang.Throwable -> L1ba
            r7 = r10
            r10 = r0
        L5e8:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.q(r10)     // Catch: java.lang.Throwable -> L1ba
            g2.e5 r0 = r1.f()     // Catch: java.lang.Throwable -> L1ba
            r0.h()     // Catch: java.lang.Throwable -> L1ba
            r1.g()     // Catch: java.lang.Throwable -> L1ba
            u1.f.h(r7)     // Catch: java.lang.Throwable -> L1ba
            u1.f.h(r2)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            u1.f.d(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Throwable -> L1ba
            u1.f.a(r0)     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.internal.measurement.t4 r8 = com.google.android.gms.internal.measurement.u4.S1()     // Catch: java.lang.Throwable -> L1ba
            r10 = 1
            r8.W(r10)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = "android"
            r8.R(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L62a
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            r8.v(r0)     // Catch: java.lang.Throwable -> L1ba
        L62a:
            java.lang.String r0 = r2.f3278n     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L637
            java.lang.String r0 = r2.f3278n     // Catch: java.lang.Throwable -> L1ba
            r8.x(r0)     // Catch: java.lang.Throwable -> L1ba
        L637:
            java.lang.String r0 = r2.f3277m     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L644
            java.lang.String r0 = r2.f3277m     // Catch: java.lang.Throwable -> L1ba
            r8.y(r0)     // Catch: java.lang.Throwable -> L1ba
        L644:
            com.google.android.gms.internal.measurement.ae.b()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r2.H     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L66f
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.f4940o0     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
            boolean r0 = r0.B(r13, r11)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L66a
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r12 = g2.i3.f4944q0     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.B(r11, r12)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L66f
        L66a:
            java.lang.String r0 = r2.H     // Catch: java.lang.Throwable -> L1ba
            r8.a0(r0)     // Catch: java.lang.Throwable -> L1ba
        L66f:
            long r11 = r2.f3284t     // Catch: java.lang.Throwable -> L1ba
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L67c
            int r0 = (int) r11     // Catch: java.lang.Throwable -> L1ba
            r8.z(r0)     // Catch: java.lang.Throwable -> L1ba
        L67c:
            long r11 = r2.f3279o     // Catch: java.lang.Throwable -> L1ba
            r8.N(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r2.f3276e     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L68e
            java.lang.String r0 = r2.f3276e     // Catch: java.lang.Throwable -> L1ba
            r8.M(r0)     // Catch: java.lang.Throwable -> L1ba
        L68e:
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1ba
            g2.f6 r0 = r1.c0(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.F     // Catch: java.lang.Throwable -> L1ba
            r12 = 100
            g2.f6 r11 = g2.f6.c(r11, r12)     // Catch: java.lang.Throwable -> L1ba
            g2.f6 r0 = r0.d(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r0.i()     // Catch: java.lang.Throwable -> L1ba
            r8.D(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r8.k0()     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L6c4
            java.lang.String r0 = r2.A     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L6c4
            java.lang.String r0 = r2.A     // Catch: java.lang.Throwable -> L1ba
            r8.u(r0)     // Catch: java.lang.Throwable -> L1ba
        L6c4:
            long r13 = r2.f3280p     // Catch: java.lang.Throwable -> L1ba
            int r0 = (r13 > r29 ? 1 : (r13 == r29 ? 0 : -1))
            if (r0 == 0) goto L6cd
            r8.E(r13)     // Catch: java.lang.Throwable -> L1ba
        L6cd:
            long r13 = r2.C     // Catch: java.lang.Throwable -> L1ba
            r8.H(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.ra r11 = r1.f5209g     // Catch: java.lang.Throwable -> L1ba
            R(r11)     // Catch: java.lang.Throwable -> L1ba
            g2.pa r0 = r11.f4655b     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r0 = r0.f5214l     // Catch: java.lang.Throwable -> L1ba
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> L1ba
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r13 = "com.google.android.gms.measurement"
            android.net.Uri r13 = com.google.android.gms.internal.measurement.j6.a(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.u r14 = g2.u.f5335c     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.internal.measurement.y5 r0 = com.google.android.gms.internal.measurement.y5.b(r0, r13, r14)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L6f4
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch: java.lang.Throwable -> L1ba
            goto L6f8
        L6f4:
            java.util.Map r0 = r0.c()     // Catch: java.lang.Throwable -> L1ba
        L6f8:
            if (r0 == 0) goto L700
            boolean r13 = r0.isEmpty()     // Catch: java.lang.Throwable -> L1ba
            if (r13 == 0) goto L703
        L700:
            r11 = 0
            goto L788
        L703:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1ba
            r13.<init>()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r14 = g2.i3.R     // Catch: java.lang.Throwable -> L1ba
            r15 = 0
            java.lang.Object r14 = r14.a(r15)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch: java.lang.Throwable -> L1ba
            int r14 = r14.intValue()     // Catch: java.lang.Throwable -> L1ba
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L1ba
            java.util.Iterator r15 = r0.iterator()     // Catch: java.lang.Throwable -> L1ba
        L71d:
            boolean r0 = r15.hasNext()     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L77f
            java.lang.Object r0 = r15.next()     // Catch: java.lang.Throwable -> L1ba
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r16 = r0.getKey()     // Catch: java.lang.Throwable -> L1ba
            r9 = r16
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = "measurement.id."
            boolean r9 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L1ba
            if (r9 == 0) goto L76c
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            if (r0 == 0) goto L76c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            r13.add(r0)     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            int r0 = r13.size()     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            if (r0 < r14) goto L76c
            g2.h5 r0 = r11.f4646a     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            java.lang.String r9 = "Too many experiment IDs. Number of IDs"
            int r10 = r13.size()     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            r0.b(r9, r10)     // Catch: java.lang.Throwable -> L1ba java.lang.NumberFormatException -> L76a
            goto L77f
        L76a:
            r0 = move-exception
            goto L76f
        L76c:
            r9 = 0
            r10 = 1
            goto L71d
        L76f:
            g2.h5 r9 = r11.f4646a     // Catch: java.lang.Throwable -> L1ba
            g2.v3 r9 = r9.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r9 = r9.w()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = "Experiment ID NumberFormatException"
            r9.b(r10, r0)     // Catch: java.lang.Throwable -> L1ba
            goto L76c
        L77f:
            boolean r0 = r13.isEmpty()     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L787
            goto L700
        L787:
            r11 = r13
        L788:
            if (r11 == 0) goto L78d
            r8.u0(r11)     // Catch: java.lang.Throwable -> L1ba
        L78d:
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1ba
            g2.f6 r0 = r1.c0(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = r2.F     // Catch: java.lang.Throwable -> L1ba
            g2.f6 r9 = g2.f6.c(r9, r12)     // Catch: java.lang.Throwable -> L1ba
            g2.f6 r0 = r0.d(r9)     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.measurement.internal.zzha r9 = com.google.android.gms.measurement.internal.zzha.zza     // Catch: java.lang.Throwable -> L1ba
            boolean r10 = r0.j(r9)     // Catch: java.lang.Throwable -> L1ba
            if (r10 == 0) goto L7d9
            boolean r10 = r2.f3289y     // Catch: java.lang.Throwable -> L1ba
            if (r10 == 0) goto L7d9
            g2.g9 r10 = r1.f5211i     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            android.util.Pair r10 = r10.n(r11, r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r11 = r10.first     // Catch: java.lang.Throwable -> L1ba
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> L1ba
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L1ba
            if (r11 != 0) goto L7d9
            boolean r11 = r2.f3289y     // Catch: java.lang.Throwable -> L1ba
            if (r11 == 0) goto L7d9
            java.lang.Object r11 = r10.first     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L1ba
            r8.X(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r10 = r10.second     // Catch: java.lang.Throwable -> L1ba
            if (r10 == 0) goto L7d9
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1ba
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1ba
            r8.P(r10)     // Catch: java.lang.Throwable -> L1ba
        L7d9:
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.o r10 = r10.A()     // Catch: java.lang.Throwable -> L1ba
            r10.k()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> L1ba
            r8.F(r10)     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.o r10 = r10.A()     // Catch: java.lang.Throwable -> L1ba
            r10.k()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> L1ba
            r8.Q(r10)     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.o r10 = r10.A()     // Catch: java.lang.Throwable -> L1ba
            long r10 = r10.p()     // Catch: java.lang.Throwable -> L1ba
            int r11 = (int) r10     // Catch: java.lang.Throwable -> L1ba
            r8.d0(r11)     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            g2.o r10 = r10.A()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r10 = r10.q()     // Catch: java.lang.Throwable -> L1ba
            r8.h0(r10)     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.internal.measurement.ed.b()     // Catch: java.lang.Throwable -> L1ba
            g2.g r10 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.G0     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
            boolean r10 = r10.B(r13, r11)     // Catch: java.lang.Throwable -> L1ba
            if (r10 == 0) goto L825
            long r10 = r2.J     // Catch: java.lang.Throwable -> L1ba
            r8.c0(r10)     // Catch: java.lang.Throwable -> L1ba
        L825:
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            boolean r10 = r10.o()     // Catch: java.lang.Throwable -> L1ba
            if (r10 == 0) goto L83a
            r8.j0()     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
            boolean r10 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L1ba
            if (r10 != 0) goto L83a
            r8.G(r13)     // Catch: java.lang.Throwable -> L1ba
        L83a:
            g2.k r10 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r10)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            g2.e6 r10 = r10.R(r11)     // Catch: java.lang.Throwable -> L1ba
            if (r10 != 0) goto L8aa
            g2.e6 r10 = new g2.e6     // Catch: java.lang.Throwable -> L1ba
            g2.h5 r11 = r1.f5214l     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r12 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            r10.<init>(r11, r12)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r1.i0(r0)     // Catch: java.lang.Throwable -> L1ba
            r10.j(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3285u     // Catch: java.lang.Throwable -> L1ba
            r10.x(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3276e     // Catch: java.lang.Throwable -> L1ba
            r10.y(r11)     // Catch: java.lang.Throwable -> L1ba
            boolean r9 = r0.j(r9)     // Catch: java.lang.Throwable -> L1ba
            if (r9 == 0) goto L874
            g2.g9 r9 = r1.f5211i     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            boolean r12 = r2.f3289y     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = r9.o(r11, r12)     // Catch: java.lang.Throwable -> L1ba
            r10.H(r9)     // Catch: java.lang.Throwable -> L1ba
        L874:
            r11 = r29
            r10.D(r11)     // Catch: java.lang.Throwable -> L1ba
            r10.E(r11)     // Catch: java.lang.Throwable -> L1ba
            r10.C(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = r2.f3277m     // Catch: java.lang.Throwable -> L1ba
            r10.l(r9)     // Catch: java.lang.Throwable -> L1ba
            long r11 = r2.f3284t     // Catch: java.lang.Throwable -> L1ba
            r10.m(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = r2.f3278n     // Catch: java.lang.Throwable -> L1ba
            r10.k(r9)     // Catch: java.lang.Throwable -> L1ba
            long r11 = r2.f3279o     // Catch: java.lang.Throwable -> L1ba
            r10.z(r11)     // Catch: java.lang.Throwable -> L1ba
            long r11 = r2.f3280p     // Catch: java.lang.Throwable -> L1ba
            r10.u(r11)     // Catch: java.lang.Throwable -> L1ba
            boolean r9 = r2.f3282r     // Catch: java.lang.Throwable -> L1ba
            r10.F(r9)     // Catch: java.lang.Throwable -> L1ba
            long r11 = r2.C     // Catch: java.lang.Throwable -> L1ba
            r10.v(r11)     // Catch: java.lang.Throwable -> L1ba
            g2.k r9 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r9)     // Catch: java.lang.Throwable -> L1ba
            r9.p(r10)     // Catch: java.lang.Throwable -> L1ba
        L8aa:
            com.google.android.gms.measurement.internal.zzha r9 = com.google.android.gms.measurement.internal.zzha.zzb     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.j(r9)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L8c9
            java.lang.String r0 = r10.m0()     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L8c9
            java.lang.String r0 = r10.m0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1ba
            r8.w(r0)     // Catch: java.lang.Throwable -> L1ba
        L8c9:
            java.lang.String r0 = r10.p0()     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 != 0) goto L8e0
            java.lang.String r0 = r10.p0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1ba
            r8.L(r0)     // Catch: java.lang.Throwable -> L1ba
        L8e0:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r9 = r2.f3275c     // Catch: java.lang.Throwable -> L1ba
            java.util.List r0 = r0.c0(r9)     // Catch: java.lang.Throwable -> L1ba
            r13 = 0
        L8ec:
            int r9 = r0.size()     // Catch: java.lang.Throwable -> L1ba
            if (r13 >= r9) goto L95f
            com.google.android.gms.internal.measurement.c5 r9 = com.google.android.gms.internal.measurement.d5.G()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r11 = r0.get(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.ta r11 = (g2.ta) r11     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r11.f5332c     // Catch: java.lang.Throwable -> L1ba
            r9.x(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r11 = r0.get(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.ta r11 = (g2.ta) r11     // Catch: java.lang.Throwable -> L1ba
            long r11 = r11.f5333d     // Catch: java.lang.Throwable -> L1ba
            r9.y(r11)     // Catch: java.lang.Throwable -> L1ba
            g2.ra r11 = r1.f5209g     // Catch: java.lang.Throwable -> L1ba
            R(r11)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r12 = r0.get(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.ta r12 = (g2.ta) r12     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r12 = r12.f5334e     // Catch: java.lang.Throwable -> L1ba
            r11.M(r9, r12)     // Catch: java.lang.Throwable -> L1ba
            r8.y0(r9)     // Catch: java.lang.Throwable -> L1ba
            g2.g r9 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r11 = g2.i3.J0     // Catch: java.lang.Throwable -> L1ba
            r15 = 0
            boolean r9 = r9.B(r15, r11)     // Catch: java.lang.Throwable -> L1ba
            if (r9 == 0) goto L95c
            java.lang.String r9 = "_sid"
            java.lang.Object r11 = r0.get(r13)     // Catch: java.lang.Throwable -> L1ba
            g2.ta r11 = (g2.ta) r11     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r11.f5332c     // Catch: java.lang.Throwable -> L1ba
            boolean r9 = r9.equals(r11)     // Catch: java.lang.Throwable -> L1ba
            if (r9 == 0) goto L95c
            long r11 = r10.g0()     // Catch: java.lang.Throwable -> L1ba
            r29 = 0
            int r9 = (r11 > r29 ? 1 : (r11 == r29 ? 0 : -1))
            if (r9 == 0) goto L95c
            g2.ra r9 = r1.f5209g     // Catch: java.lang.Throwable -> L1ba
            R(r9)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r11 = r2.H     // Catch: java.lang.Throwable -> L1ba
            long r11 = r9.y(r11)     // Catch: java.lang.Throwable -> L1ba
            long r14 = r10.g0()     // Catch: java.lang.Throwable -> L1ba
            int r9 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r9 == 0) goto L95c
            r8.L0()     // Catch: java.lang.Throwable -> L1ba
        L95c:
            int r13 = r13 + 1
            goto L8ec
        L95f:
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            R(r2)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            com.google.android.gms.internal.measurement.a9 r0 = r8.o()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r9 = r0
            com.google.android.gms.internal.measurement.u4 r9 = (com.google.android.gms.internal.measurement.u4) r9     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r2.h()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r2.i()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            u1.f.h(r9)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.String r0 = r9.W1()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            u1.f.d(r0)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            byte[] r0 = r9.j()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            g2.pa r10 = r2.f4655b     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            g2.ra r10 = r10.f5209g     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            R(r10)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            long r10 = r10.z(r0)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r12.<init>()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.String r13 = r9.W1()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r12.put(r4, r13)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r12.put(r3, r13)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.String r13 = "metadata"
            r12.put(r13, r0)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c android.database.sqlite.SQLiteException -> La9e
            java.lang.String r13 = "raw_events_metadata"
            r14 = 4
            r15 = 0
            r0.insertWithOnConflict(r13, r15, r12, r14)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c android.database.sqlite.SQLiteException -> La9e
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r2)     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.measurement.internal.zzas r0 = r7.f5191f     // Catch: java.lang.Throwable -> L1ba
            g2.r r8 = new g2.r     // Catch: java.lang.Throwable -> L1ba
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L1ba
        L9b9:
            boolean r0 = r8.hasNext()     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L9cb
            java.lang.String r0 = r8.a()     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r6.equals(r0)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto L9b9
        L9c9:
            r13 = 1
            goto La0c
        L9cb:
            g2.y4 r0 = r1.f5203a     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r6 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = r7.f5187b     // Catch: java.lang.Throwable -> L1ba
            boolean r0 = r0.E(r6, r8)     // Catch: java.lang.Throwable -> L1ba
            g2.k r6 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r6)     // Catch: java.lang.Throwable -> L1ba
            long r32 = r1.F()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            r38 = 0
            r39 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r31 = r6
            r34 = r8
            g2.i r6 = r31.T(r32, r34, r35, r36, r37, r38, r39)     // Catch: java.lang.Throwable -> L1ba
            if (r0 == 0) goto La0b
            long r8 = r6.f4907e     // Catch: java.lang.Throwable -> L1ba
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r6 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            g2.h3 r12 = g2.i3.f4943q     // Catch: java.lang.Throwable -> L1ba
            int r0 = r0.o(r6, r12)     // Catch: java.lang.Throwable -> L1ba
            long r12 = (long) r0     // Catch: java.lang.Throwable -> L1ba
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 >= 0) goto La0b
            goto L9c9
        La0b:
            r13 = 0
        La0c:
            r2.h()     // Catch: java.lang.Throwable -> L1ba
            r2.i()     // Catch: java.lang.Throwable -> L1ba
            u1.f.h(r7)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            u1.f.d(r0)     // Catch: java.lang.Throwable -> L1ba
            g2.pa r0 = r2.f4655b     // Catch: java.lang.Throwable -> L1ba
            g2.ra r0 = r0.f5209g     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            com.google.android.gms.internal.measurement.j4 r0 = r0.D(r7)     // Catch: java.lang.Throwable -> L1ba
            byte[] r0 = r0.j()     // Catch: java.lang.Throwable -> L1ba
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L1ba
            r6.<init>()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r8 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            r6.put(r4, r8)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r4 = "name"
            java.lang.String r8 = r7.f5187b     // Catch: java.lang.Throwable -> L1ba
            r6.put(r4, r8)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r4 = "timestamp"
            long r8 = r7.f5189d     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L1ba
            r6.put(r4, r8)     // Catch: java.lang.Throwable -> L1ba
            java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L1ba
            r6.put(r3, r4)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "data"
            r6.put(r3, r0)     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r0 = "realtime"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.Throwable -> L1ba
            r6.put(r0, r3)     // Catch: java.lang.Throwable -> L1ba
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            r13 = 0
            long r3 = r0.insert(r5, r13, r6)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto La81
            g2.h5 r0 = r2.f4646a     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            java.lang.String r3 = "Failed to insert raw event (got -1). appId"
            java.lang.String r4 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            r0.b(r3, r4)     // Catch: java.lang.Throwable -> L1ba android.database.sqlite.SQLiteException -> La7f
            goto Lacc
        La7f:
            r0 = move-exception
            goto La86
        La81:
            r11 = 0
            r1.f5217o = r11     // Catch: java.lang.Throwable -> L1ba
            goto Lacc
        La86:
            g2.h5 r2 = r2.f4646a     // Catch: java.lang.Throwable -> L1ba
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Error storing raw event. appId"
            java.lang.String r4 = r7.f5186a     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> L1ba
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba
            goto Lacc
        La9c:
            r0 = move-exception
            goto Lab7
        La9e:
            r0 = move-exception
            g2.h5 r2 = r2.f4646a     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.String r3 = "Error storing raw event metadata. appId"
            java.lang.String r4 = r9.W1()     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
            throw r0     // Catch: java.lang.Throwable -> L1ba java.io.IOException -> La9c
        Lab7:
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> L1ba
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> L1ba
            java.lang.String r3 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r8.j0()     // Catch: java.lang.Throwable -> L1ba
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> L1ba
            r2.c(r3, r4, r0)     // Catch: java.lang.Throwable -> L1ba
        Lacc:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> L1ba
            R(r0)     // Catch: java.lang.Throwable -> L1ba
            r0.o()     // Catch: java.lang.Throwable -> L1ba
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            r1.M()
            g2.v3 r0 = r1.d()
            g2.t3 r0 = r0.v()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r27
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r0.b(r3, r2)
            return
        Laff:
            g2.k r2 = r1.f5205c
            R(r2)
            r2.f0()
            throw r0
        Lb08:
            r1.S(r2)
            return
    }

    public final boolean E() {
            r5 = this;
            g2.e5 r0 = r5.f()
            r0.h()
            java.nio.channels.FileLock r0 = r5.f5224v
            r1 = 1
            java.lang.String r2 = "Storage concurrent access okay"
            if (r0 == 0) goto L21
            boolean r0 = r0.isValid()
            if (r0 != 0) goto L15
            goto L21
        L15:
            g2.v3 r0 = r5.d()
            g2.t3 r0 = r0.v()
            r0.a(r2)
            return r1
        L21:
            g2.k r0 = r5.f5205c
            g2.h5 r0 = r0.f4646a
            r0.z()
            g2.h5 r0 = r5.f5214l
            android.content.Context r0 = r0.c()
            java.io.File r0 = r0.getFilesDir()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "google_app_measurement.db"
            r3.<init>(r0, r4)
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            java.lang.String r4 = "rw"
            r0.<init>(r3, r4)     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            java.nio.channels.FileChannel r0 = r0.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            r5.f5225w = r0     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            java.nio.channels.FileLock r0 = r0.tryLock()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            r5.f5224v = r0     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            if (r0 == 0) goto L60
            g2.v3 r0 = r5.d()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            g2.t3 r0 = r0.v()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            r0.a(r2)     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            return r1
        L5a:
            r0 = move-exception
            goto L6e
        L5c:
            r0 = move-exception
            goto L7c
        L5e:
            r0 = move-exception
            goto L8a
        L60:
            g2.v3 r0 = r5.d()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            g2.t3 r0 = r0.r()     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            java.lang.String r1 = "Storage concurrent data access panic"
            r0.a(r1)     // Catch: java.nio.channels.OverlappingFileLockException -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L5e
            goto L97
        L6e:
            g2.v3 r1 = r5.d()
            g2.t3 r1 = r1.w()
            java.lang.String r2 = "Storage lock already acquired"
            r1.b(r2, r0)
            goto L97
        L7c:
            g2.v3 r1 = r5.d()
            g2.t3 r1 = r1.r()
            java.lang.String r2 = "Failed to access storage lock file"
            r1.b(r2, r0)
            goto L97
        L8a:
            g2.v3 r1 = r5.d()
            g2.t3 r1 = r1.r()
            java.lang.String r2 = "Failed to acquire storage lock"
            r1.b(r2, r0)
        L97:
            r0 = 0
            return r0
    }

    public final long F() {
            r8 = this;
            x1.c r0 = r8.a()
            long r0 = r0.a()
            g2.g9 r2 = r8.f5211i
            r2.i()
            r2.h()
            g2.h4 r3 = r2.f4837i
            long r3 = r3.a()
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L36
            g2.h5 r3 = r2.f4646a
            g2.wa r3 = r3.N()
            java.security.SecureRandom r3 = r3.u()
            r4 = 86400000(0x5265c00, float:7.82218E-36)
            int r3 = r3.nextInt(r4)
            long r3 = (long) r3
            g2.h4 r2 = r2.f4837i
            r5 = 1
            long r3 = r3 + r5
            r2.b(r3)
        L36:
            long r0 = r0 + r3
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            r2 = 60
            long r0 = r0 / r2
            long r0 = r0 / r2
            r2 = 24
            long r0 = r0 / r2
            return r0
    }

    public final com.google.android.gms.measurement.internal.zzq I(java.lang.String r36) {
            r35 = this;
            r0 = r35
            r2 = r36
            g2.k r1 = r0.f5205c
            R(r1)
            g2.e6 r1 = r1.R(r2)
            r3 = 0
            if (r1 == 0) goto L9e
            java.lang.String r4 = r1.o0()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L1c
            goto L9e
        L1c:
            java.lang.Boolean r4 = r0.J(r1)
            if (r4 == 0) goto L3a
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L3a
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.r()
            java.lang.Object r2 = g2.v3.z(r2)
            java.lang.String r4 = "App version does not match; dropping. appId"
            r1.b(r4, r2)
            return r3
        L3a:
            r3 = r1
            com.google.android.gms.measurement.internal.zzq r1 = new com.google.android.gms.measurement.internal.zzq
            r4 = r3
            java.lang.String r3 = r4.a()
            r5 = r4
            java.lang.String r4 = r5.o0()
            r7 = r5
            long r5 = r7.R()
            r8 = r7
            java.lang.String r7 = r8.n0()
            r10 = r8
            long r8 = r10.c0()
            r12 = r10
            long r10 = r12.Z()
            boolean r13 = r12.O()
            java.lang.String r15 = r12.p0()
            r12.A()
            boolean r21 = r12.N()
            java.lang.String r23 = r12.j0()
            java.lang.Boolean r24 = r12.i0()
            long r25 = r12.a0()
            java.util.List r27 = r12.e()
            g2.f6 r14 = r35.c0(r36)
            java.lang.String r29 = r14.i()
            boolean r32 = r12.Q()
            long r33 = r12.h0()
            java.lang.String r30 = ""
            r31 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r28 = 0
            r1.<init>(r2, r3, r4, r5, r7, r8, r10, r12, r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r32, r33)
            return r1
        L9e:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.q()
            java.lang.String r4 = "No app data available; dropping"
            r1.b(r4, r2)
            return r3
    }

    public final java.lang.Boolean J(g2.e6 r7) {
            r6 = this;
            long r0 = r7.R()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            r2 = -2147483648(0xffffffff80000000, double:NaN)
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L2c
            g2.h5 r0 = r6.f5214l     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            android.content.Context r0 = r0.c()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            y1.d r0 = y1.e.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            java.lang.String r1 = r7.l0()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            android.content.pm.PackageInfo r0 = r0.c(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            int r0 = r0.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            long r1 = r7.R()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            long r3 = (long) r0     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L4f
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            return r7
        L2c:
            g2.h5 r0 = r6.f5214l     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            android.content.Context r0 = r0.c()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            y1.d r0 = y1.e.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            java.lang.String r1 = r7.l0()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            android.content.pm.PackageInfo r0 = r0.c(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            java.lang.String r0 = r0.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            java.lang.String r7 = r7.o0()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            if (r7 == 0) goto L4f
            boolean r7 = r7.equals(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            if (r7 == 0) goto L4f
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L52
            return r7
        L4f:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L52:
            r7 = 0
            return r7
    }

    public final void K() {
            r5 = this;
            g2.e5 r0 = r5.f()
            r0.h()
            boolean r0 = r5.f5221s
            if (r0 != 0) goto L46
            boolean r0 = r5.f5222t
            if (r0 != 0) goto L46
            boolean r0 = r5.f5223u
            if (r0 == 0) goto L14
            goto L46
        L14:
            g2.v3 r0 = r5.d()
            g2.t3 r0 = r0.v()
            java.lang.String r1 = "Stopping uploading service(s)"
            r0.a(r1)
            java.util.List r0 = r5.f5218p
            if (r0 != 0) goto L26
            return
        L26:
            java.util.Iterator r0 = r0.iterator()
        L2a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3a
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L2a
        L3a:
            java.util.List r0 = r5.f5218p
            java.lang.Object r0 = u1.f.h(r0)
            java.util.List r0 = (java.util.List) r0
            r0.clear()
            return
        L46:
            g2.v3 r0 = r5.d()
            g2.t3 r0 = r0.v()
            boolean r1 = r5.f5221s
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r2 = r5.f5222t
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r3 = r5.f5223u
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "Not stopping services. fetch, network, upload"
            r0.d(r4, r1, r2, r3)
            return
    }

    public final void L(com.google.android.gms.internal.measurement.t4 r12, long r13, boolean r15) {
            r11 = this;
            g2.k r0 = r11.f5205c
            R(r0)
            r1 = 1
            if (r1 == r15) goto Lc
            java.lang.String r2 = "_lte"
        La:
            r6 = r2
            goto Lf
        Lc:
            java.lang.String r2 = "_se"
            goto La
        Lf:
            java.lang.String r2 = r12.j0()
            g2.ta r0 = r0.X(r2, r6)
            if (r0 == 0) goto L3f
            java.lang.Object r2 = r0.f5334e
            if (r2 != 0) goto L1e
            goto L3f
        L1e:
            g2.ta r3 = new g2.ta
            java.lang.String r4 = r12.j0()
            x1.c r2 = r11.a()
            long r7 = r2.a()
            java.lang.Object r0 = r0.f5334e
            java.lang.Long r0 = (java.lang.Long) r0
            long r9 = r0.longValue()
            long r9 = r9 + r13
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r5 = "auto"
            r3.<init>(r4, r5, r6, r7, r9)
            goto L56
        L3f:
            g2.ta r3 = new g2.ta
            java.lang.String r4 = r12.j0()
            x1.c r0 = r11.a()
            long r7 = r0.a()
            java.lang.Long r9 = java.lang.Long.valueOf(r13)
            java.lang.String r5 = "auto"
            r3.<init>(r4, r5, r6, r7, r9)
        L56:
            com.google.android.gms.internal.measurement.c5 r0 = com.google.android.gms.internal.measurement.d5.G()
            r0.x(r6)
            x1.c r2 = r11.a()
            long r4 = r2.a()
            r0.y(r4)
            java.lang.Object r2 = r3.f5334e
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            r0.w(r4)
            com.google.android.gms.internal.measurement.a9 r0 = r0.o()
            com.google.android.gms.internal.measurement.d5 r0 = (com.google.android.gms.internal.measurement.d5) r0
            int r2 = g2.ra.x(r12, r6)
            if (r2 < 0) goto L83
            r12.g0(r2, r0)
            goto L86
        L83:
            r12.z0(r0)
        L86:
            r4 = 0
            int r12 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r12 <= 0) goto Laa
            g2.k r12 = r11.f5205c
            R(r12)
            r12.x(r3)
            if (r1 == r15) goto L99
            java.lang.String r12 = "lifetime"
            goto L9b
        L99:
            java.lang.String r12 = "session-scoped"
        L9b:
            g2.v3 r13 = r11.d()
            g2.t3 r13 = r13.v()
            java.lang.Object r14 = r3.f5334e
            java.lang.String r15 = "Updated engagement user property. scope, value"
            r13.c(r15, r12, r14)
        Laa:
            return
    }

    public final void M() {
            r20 = this;
            r0 = r20
            g2.e5 r1 = r0.f()
            r1.h()
            r0.g()
            long r1 = r0.f5217o
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4e
            x1.c r1 = r0.a()
            long r1 = r1.b()
            long r5 = r0.f5217o
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L4c
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.v()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.b(r2, r3)
            g2.e4 r1 = r0.Y()
            r1.c()
            g2.z9 r1 = r0.f5207e
            R(r1)
            r1.m()
            return
        L4c:
            r0.f5217o = r3
        L4e:
            g2.h5 r1 = r0.f5214l
            boolean r1 = r1.r()
            if (r1 == 0) goto L260
            boolean r1 = r0.O()
            if (r1 != 0) goto L5e
            goto L260
        L5e:
            x1.c r1 = r0.a()
            long r1 = r1.a()
            r0.U()
            g2.h3 r5 = g2.i3.C
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            g2.k r5 = r0.f5205c
            R(r5)
            boolean r5 = r5.t()
            r10 = 1
            if (r5 != 0) goto L93
            g2.k r5 = r0.f5205c
            R(r5)
            boolean r5 = r5.s()
            if (r5 == 0) goto L92
            goto L93
        L92:
            r10 = 0
        L93:
            if (r10 == 0) goto Ld3
            g2.g r5 = r0.U()
            java.lang.String r5 = r5.u()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto Lbf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto Lbf
            r0.U()
            g2.h3 r5 = g2.i3.f4957x
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto Le6
        Lbf:
            r0.U()
            g2.h3 r5 = g2.i3.f4955w
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto Le6
        Ld3:
            r0.U()
            g2.h3 r5 = g2.i3.f4953v
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        Le6:
            g2.g9 r5 = r0.f5211i
            g2.h4 r5 = r5.f4835g
            long r13 = r5.a()
            g2.g9 r5 = r0.f5211i
            g2.h4 r5 = r5.f4836h
            long r15 = r5.a()
            g2.k r5 = r0.f5205c
            R(r5)
            r17 = r3
            long r3 = r5.M()
            g2.k r5 = r0.f5205c
            R(r5)
            r19 = r10
            long r9 = r5.N()
            long r3 = java.lang.Math.max(r3, r9)
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 != 0) goto L118
            r7 = r17
            goto L198
        L118:
            long r3 = r3 - r1
            long r3 = java.lang.Math.abs(r3)
            long r3 = r1 - r3
            long r13 = r13 - r1
            long r9 = java.lang.Math.abs(r13)
            long r9 = r1 - r9
            long r15 = r15 - r1
            long r13 = java.lang.Math.abs(r15)
            long r1 = r1 - r13
            long r7 = r7 + r3
            long r9 = java.lang.Math.max(r9, r1)
            if (r19 == 0) goto L13c
            int r5 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r5 <= 0) goto L13c
            long r7 = java.lang.Math.min(r3, r9)
            long r7 = r7 + r11
        L13c:
            g2.ra r5 = r0.f5209g
            R(r5)
            boolean r5 = r5.O(r9, r11)
            if (r5 != 0) goto L149
            long r9 = r9 + r11
            r7 = r9
        L149:
            int r5 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r5 == 0) goto L18d
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L18d
            r3 = 0
        L152:
            r0.U()
            g2.h3 r4 = g2.i3.E
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            r9 = 20
            int r4 = java.lang.Math.min(r9, r4)
            if (r3 >= r4) goto L195
            r9 = 1
            long r9 = r9 << r3
            r0.U()
            g2.h3 r4 = g2.i3.D
            java.lang.Object r4 = r4.a(r6)
            java.lang.Long r4 = (java.lang.Long) r4
            long r11 = r4.longValue()
            r13 = r17
            long r11 = java.lang.Math.max(r13, r11)
            long r11 = r11 * r9
            long r7 = r7 + r11
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 <= 0) goto L190
        L18d:
            r17 = 0
            goto L198
        L190:
            int r3 = r3 + 1
            r17 = 0
            goto L152
        L195:
            r7 = 0
            goto L18d
        L198:
            int r1 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r1 == 0) goto L243
            g2.b4 r1 = r0.f5204b
            R(r1)
            boolean r1 = r1.m()
            if (r1 == 0) goto L226
            g2.g9 r1 = r0.f5211i
            g2.h4 r1 = r1.f4834f
            long r1 = r1.a()
            r0.U()
            g2.h3 r3 = g2.i3.f4949t
            java.lang.Object r3 = r3.a(r6)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r13 = 0
            long r3 = java.lang.Math.max(r13, r3)
            g2.ra r5 = r0.f5209g
            R(r5)
            boolean r5 = r5.O(r1, r3)
            if (r5 != 0) goto L1d4
            long r1 = r1 + r3
            long r7 = java.lang.Math.max(r7, r1)
        L1d4:
            g2.e4 r1 = r0.Y()
            r1.c()
            x1.c r1 = r0.a()
            long r1 = r1.a()
            long r7 = r7 - r1
            r13 = 0
            int r1 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r1 > 0) goto L20c
            r0.U()
            g2.h3 r1 = g2.i3.f4959y
            java.lang.Object r1 = r1.a(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r13, r1)
            g2.g9 r1 = r0.f5211i
            g2.h4 r1 = r1.f4835g
            x1.c r2 = r0.a()
            long r2 = r2.a()
            r1.b(r2)
        L20c:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.v()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.b(r2, r3)
            g2.z9 r1 = r0.f5207e
            R(r1)
            r1.n(r7)
            return
        L226:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.v()
            java.lang.String r2 = "No network"
            r1.a(r2)
            g2.e4 r1 = r0.Y()
            r1.b()
            g2.z9 r1 = r0.f5207e
            R(r1)
            r1.m()
            return
        L243:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.v()
            java.lang.String r2 = "Next upload time is 0"
            r1.a(r2)
            g2.e4 r1 = r0.Y()
            r1.c()
            g2.z9 r1 = r0.f5207e
            R(r1)
            r1.m()
            return
        L260:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.v()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.a(r2)
            g2.e4 r1 = r0.Y()
            r1.c()
            g2.z9 r1 = r0.f5207e
            R(r1)
            r1.m()
            return
    }

    public final boolean N(java.lang.String r46, long r47) {
            r45 = this;
            r1 = r45
            java.lang.String r0 = "_npa"
            java.lang.String r2 = "_ai"
            r3 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            g2.k r6 = r1.f5205c
            R(r6)
            r6.e0()
            g2.ma r13 = new g2.ma     // Catch: java.lang.Throwable -> Lef
            r6 = 0
            r13.<init>(r1, r6)     // Catch: java.lang.Throwable -> Lef
            g2.k r7 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r7)     // Catch: java.lang.Throwable -> Lef
            long r11 = r1.f5228z     // Catch: java.lang.Throwable -> Lef
            r8 = 0
            r9 = r47
            r7.G(r8, r9, r11, r13)     // Catch: java.lang.Throwable -> Lef
            java.util.List r7 = r13.f5126c     // Catch: java.lang.Throwable -> Lef
            if (r7 == 0) goto Lcc2
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> Lef
            if (r7 == 0) goto L33
            goto Lcc2
        L33:
            com.google.android.gms.internal.measurement.u4 r7 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.x8 r7 = r7.m()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.t4 r7 = (com.google.android.gms.internal.measurement.t4) r7     // Catch: java.lang.Throwable -> Lef
            r7.E0()     // Catch: java.lang.Throwable -> Lef
            r14 = r6
            r16 = r14
            r6 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = -1
        L46:
            java.util.List r8 = r13.f5126c     // Catch: java.lang.Throwable -> Lef
            int r8 = r8.size()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = "_et"
            java.lang.String r3 = "_fr"
            java.lang.String r4 = "_e"
            r19 = r11
            if (r10 >= r8) goto L513
            java.util.List r8 = r13.f5126c     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r8 = r8.get(r10)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r8 = (com.google.android.gms.internal.measurement.j4) r8     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.x8 r8 = r8.m()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.i4 r8 = (com.google.android.gms.internal.measurement.i4) r8     // Catch: java.lang.Throwable -> Lef
            r20 = 1
            g2.y4 r11 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r11)     // Catch: java.lang.Throwable -> Lef
            r21 = r12
            com.google.android.gms.internal.measurement.u4 r12 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r12 = r12.W1()     // Catch: java.lang.Throwable -> Lef
            r22 = r14
            java.lang.String r14 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r11 = r11.F(r12, r14)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r12 = "_err"
            if (r11 == 0) goto L100
            g2.v3 r3 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.u4 r9 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = r9.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r9 = g2.v3.z(r9)     // Catch: java.lang.Throwable -> Lef
            g2.h5 r11 = r1.f5214l     // Catch: java.lang.Throwable -> Lef
            g2.q3 r11 = r11.D()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r8.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r11 = r11.d(r14)     // Catch: java.lang.Throwable -> Lef
            r3.c(r4, r9, r11)     // Catch: java.lang.Throwable -> Lef
            g2.y4 r3 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r4 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r4.W1()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r3.D(r4)     // Catch: java.lang.Throwable -> Lef
            if (r3 != 0) goto Lf2
            g2.y4 r3 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r4 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r4.W1()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r3.G(r4)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto Lc9
            goto Lf2
        Lc9:
            java.lang.String r3 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r12.equals(r3)     // Catch: java.lang.Throwable -> Lef
            if (r3 != 0) goto Lf2
            g2.wa r23 = r1.h0()     // Catch: java.lang.Throwable -> Lef
            g2.va r3 = r1.E     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r4 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r25 = r4.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r8.G()     // Catch: java.lang.Throwable -> Lef
            r29 = 0
            r26 = 11
            r24 = r3
            r23.C(r24, r25, r26, r27, r28, r29)     // Catch: java.lang.Throwable -> Lef
            goto Lf2
        Lef:
            r0 = move-exception
            goto Lcd4
        Lf2:
            r24 = r2
            r25 = r5
            r4 = r10
            r11 = r19
            r12 = r21
            r14 = r22
            r5 = -1
            goto L509
        L100:
            java.lang.String r11 = r8.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = g2.g6.a(r2)     // Catch: java.lang.Throwable -> Lef
            boolean r11 = r11.equals(r14)     // Catch: java.lang.Throwable -> Lef
            if (r11 == 0) goto L176
            r8.A(r2)     // Catch: java.lang.Throwable -> Lef
            g2.v3 r11 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r11 = r11.v()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = "Renaming ad_impression to _ai"
            r11.a(r14)     // Catch: java.lang.Throwable -> Lef
            g2.v3 r11 = r1.d()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r11 = r11.D()     // Catch: java.lang.Throwable -> Lef
            r14 = 5
            boolean r11 = android.util.Log.isLoggable(r11, r14)     // Catch: java.lang.Throwable -> Lef
            if (r11 == 0) goto L176
            r11 = 0
        L12e:
            int r14 = r8.s()     // Catch: java.lang.Throwable -> Lef
            if (r11 >= r14) goto L176
            java.lang.String r14 = "ad_platform"
            com.google.android.gms.internal.measurement.n4 r23 = r8.F(r11)     // Catch: java.lang.Throwable -> Lef
            r24 = r2
            java.lang.String r2 = r23.J()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r14.equals(r2)     // Catch: java.lang.Throwable -> Lef
            if (r2 == 0) goto L171
            com.google.android.gms.internal.measurement.n4 r2 = r8.F(r11)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r2 = r2.K()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lef
            if (r2 != 0) goto L171
            java.lang.String r2 = "admob"
            com.google.android.gms.internal.measurement.n4 r14 = r8.F(r11)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r14.K()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r2.equalsIgnoreCase(r14)     // Catch: java.lang.Throwable -> Lef
            if (r2 == 0) goto L171
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.x()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = "AdMob ad impression logged from app. Potentially duplicative."
            r2.a(r14)     // Catch: java.lang.Throwable -> Lef
        L171:
            int r11 = r11 + 1
            r2 = r24
            goto L12e
        L176:
            r24 = r2
            g2.y4 r2 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r11 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r11 = r11.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r2.E(r11, r14)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r11 = "_c"
            if (r2 != 0) goto L1c2
            g2.ra r14 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r14)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r8.G()     // Catch: java.lang.Throwable -> Lef
            u1.f.d(r14)     // Catch: java.lang.Throwable -> Lef
            r23 = r2
            int r2 = r14.hashCode()     // Catch: java.lang.Throwable -> Lef
            r25 = r5
            r5 = 95027(0x17333, float:1.33161E-40)
            if (r2 == r5) goto L1a9
            goto L1b6
        L1a9:
            java.lang.String r2 = "_ui"
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L1b6
        L1b1:
            r2 = 0
            r14 = 0
            r26 = 0
            goto L1c7
        L1b6:
            r27 = r9
            r26 = r10
            r28 = r15
            r23 = 0
        L1be:
            r12 = r21
            goto L397
        L1c2:
            r23 = r2
            r25 = r5
            goto L1b1
        L1c7:
            int r5 = r8.s()     // Catch: java.lang.Throwable -> Lef
            r27 = r14
            java.lang.String r14 = "_r"
            if (r2 >= r5) goto L22f
            com.google.android.gms.internal.measurement.n4 r5 = r8.F(r2)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = r5.J()     // Catch: java.lang.Throwable -> Lef
            boolean r5 = r11.equals(r5)     // Catch: java.lang.Throwable -> Lef
            if (r5 == 0) goto L1fe
            com.google.android.gms.internal.measurement.n4 r5 = r8.F(r2)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.x8 r5 = r5.m()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r5 = (com.google.android.gms.internal.measurement.m4) r5     // Catch: java.lang.Throwable -> Lef
            r28 = r15
            r14 = 1
            r5.A(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r5 = r5.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r5 = (com.google.android.gms.internal.measurement.n4) r5     // Catch: java.lang.Throwable -> Lef
            r8.C(r2, r5)     // Catch: java.lang.Throwable -> Lef
            r14 = r27
            r26 = 1
            goto L22a
        L1fe:
            r28 = r15
            com.google.android.gms.internal.measurement.n4 r5 = r8.F(r2)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = r5.J()     // Catch: java.lang.Throwable -> Lef
            boolean r5 = r14.equals(r5)     // Catch: java.lang.Throwable -> Lef
            if (r5 == 0) goto L228
            com.google.android.gms.internal.measurement.n4 r5 = r8.F(r2)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.x8 r5 = r5.m()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r5 = (com.google.android.gms.internal.measurement.m4) r5     // Catch: java.lang.Throwable -> Lef
            r14 = 1
            r5.A(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r5 = r5.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r5 = (com.google.android.gms.internal.measurement.n4) r5     // Catch: java.lang.Throwable -> Lef
            r8.C(r2, r5)     // Catch: java.lang.Throwable -> Lef
            r14 = 1
            goto L22a
        L228:
            r14 = r27
        L22a:
            int r2 = r2 + 1
            r15 = r28
            goto L1c7
        L22f:
            r28 = r15
            if (r26 != 0) goto L263
            if (r23 == 0) goto L263
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.v()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Marking event as conversion"
            g2.h5 r15 = r1.f5214l     // Catch: java.lang.Throwable -> Lef
            g2.q3 r15 = r15.D()     // Catch: java.lang.Throwable -> Lef
            r26 = r10
            java.lang.String r10 = r8.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r15.d(r10)     // Catch: java.lang.Throwable -> Lef
            r2.b(r5, r10)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r2 = com.google.android.gms.internal.measurement.n4.H()     // Catch: java.lang.Throwable -> Lef
            r2.B(r11)     // Catch: java.lang.Throwable -> Lef
            r5 = r9
            r9 = 1
            r2.A(r9)     // Catch: java.lang.Throwable -> Lef
            r8.w(r2)     // Catch: java.lang.Throwable -> Lef
            goto L266
        L263:
            r5 = r9
            r26 = r10
        L266:
            if (r27 != 0) goto L292
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.v()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = "Marking event as real-time"
            g2.h5 r10 = r1.f5214l     // Catch: java.lang.Throwable -> Lef
            g2.q3 r10 = r10.D()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r8.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r10.d(r15)     // Catch: java.lang.Throwable -> Lef
            r2.b(r9, r10)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r2 = com.google.android.gms.internal.measurement.n4.H()     // Catch: java.lang.Throwable -> Lef
            r2.B(r14)     // Catch: java.lang.Throwable -> Lef
            r9 = 1
            r2.A(r9)     // Catch: java.lang.Throwable -> Lef
            r8.w(r2)     // Catch: java.lang.Throwable -> Lef
        L292:
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            long r30 = r1.F()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r9 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r32 = r9.W1()     // Catch: java.lang.Throwable -> Lef
            r36 = 0
            r37 = 1
            r33 = 0
            r34 = 0
            r35 = 0
            r29 = r2
            g2.i r2 = r29.T(r30, r32, r33, r34, r35, r36, r37)     // Catch: java.lang.Throwable -> Lef
            long r9 = r2.f4907e     // Catch: java.lang.Throwable -> Lef
            g2.g r2 = r1.U()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r15 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r15.W1()     // Catch: java.lang.Throwable -> Lef
            r27 = r5
            g2.h3 r5 = g2.i3.f4943q     // Catch: java.lang.Throwable -> Lef
            int r2 = r2.o(r15, r5)     // Catch: java.lang.Throwable -> Lef
            r29 = r9
            long r9 = (long) r2     // Catch: java.lang.Throwable -> Lef
            int r2 = (r29 > r9 ? 1 : (r29 == r9 ? 0 : -1))
            if (r2 <= 0) goto L2d0
            H(r8, r14)     // Catch: java.lang.Throwable -> Lef
            goto L2d2
        L2d0:
            r21 = 1
        L2d2:
            java.lang.String r2 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = g2.wa.Z(r2)     // Catch: java.lang.Throwable -> Lef
            if (r2 == 0) goto L1be
            if (r23 == 0) goto L1be
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            long r30 = r1.F()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r5 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r32 = r5.W1()     // Catch: java.lang.Throwable -> Lef
            r36 = 0
            r37 = 0
            r33 = 0
            r34 = 0
            r35 = 1
            r29 = r2
            g2.i r2 = r29.T(r30, r32, r33, r34, r35, r36, r37)     // Catch: java.lang.Throwable -> Lef
            long r9 = r2.f4905c     // Catch: java.lang.Throwable -> Lef
            g2.g r2 = r1.U()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r5 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = r5.W1()     // Catch: java.lang.Throwable -> Lef
            g2.h3 r14 = g2.i3.f4941p     // Catch: java.lang.Throwable -> Lef
            int r2 = r2.o(r5, r14)     // Catch: java.lang.Throwable -> Lef
            long r14 = (long) r2     // Catch: java.lang.Throwable -> Lef
            int r2 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r2 <= 0) goto L1be
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.u4 r9 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = r9.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r9 = g2.v3.z(r9)     // Catch: java.lang.Throwable -> Lef
            r2.b(r5, r9)     // Catch: java.lang.Throwable -> Lef
            r2 = 0
            r5 = 0
            r9 = 0
            r10 = -1
        L32f:
            int r14 = r8.s()     // Catch: java.lang.Throwable -> Lef
            if (r5 >= r14) goto L359
            com.google.android.gms.internal.measurement.n4 r14 = r8.F(r5)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r14.J()     // Catch: java.lang.Throwable -> Lef
            boolean r15 = r11.equals(r15)     // Catch: java.lang.Throwable -> Lef
            if (r15 == 0) goto L34b
            com.google.android.gms.internal.measurement.x8 r2 = r14.m()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r2 = (com.google.android.gms.internal.measurement.m4) r2     // Catch: java.lang.Throwable -> Lef
            r10 = r5
            goto L356
        L34b:
            java.lang.String r14 = r14.J()     // Catch: java.lang.Throwable -> Lef
            boolean r14 = r12.equals(r14)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L356
            r9 = 1
        L356:
            int r5 = r5 + 1
            goto L32f
        L359:
            if (r9 == 0) goto L363
            if (r2 == 0) goto L362
            r8.z(r10)     // Catch: java.lang.Throwable -> Lef
            goto L1be
        L362:
            r2 = 0
        L363:
            if (r2 == 0) goto L37e
            com.google.android.gms.internal.measurement.x8 r2 = r2.l()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.m4 r2 = (com.google.android.gms.internal.measurement.m4) r2     // Catch: java.lang.Throwable -> Lef
            r2.B(r12)     // Catch: java.lang.Throwable -> Lef
            r14 = 10
            r2.A(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r2 = r2.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r2 = (com.google.android.gms.internal.measurement.n4) r2     // Catch: java.lang.Throwable -> Lef
            r8.C(r10, r2)     // Catch: java.lang.Throwable -> Lef
            goto L1be
        L37e:
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.u4 r9 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = r9.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r9 = g2.v3.z(r9)     // Catch: java.lang.Throwable -> Lef
            r2.b(r5, r9)     // Catch: java.lang.Throwable -> Lef
            goto L1be
        L397:
            if (r23 == 0) goto L455
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lef
            java.util.List r5 = r8.H()     // Catch: java.lang.Throwable -> Lef
            r2.<init>(r5)     // Catch: java.lang.Throwable -> Lef
            r5 = 0
            r9 = -1
            r10 = -1
        L3a5:
            int r14 = r2.size()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = "currency"
            r20 = r12
            java.lang.String r12 = "value"
            if (r5 >= r14) goto L3d9
            java.lang.Object r14 = r2.get(r5)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r14 = (com.google.android.gms.internal.measurement.n4) r14     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r14.J()     // Catch: java.lang.Throwable -> Lef
            boolean r12 = r12.equals(r14)     // Catch: java.lang.Throwable -> Lef
            if (r12 == 0) goto L3c3
            r9 = r5
            goto L3d4
        L3c3:
            java.lang.Object r12 = r2.get(r5)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r12 = (com.google.android.gms.internal.measurement.n4) r12     // Catch: java.lang.Throwable -> Lef
            java.lang.String r12 = r12.J()     // Catch: java.lang.Throwable -> Lef
            boolean r12 = r15.equals(r12)     // Catch: java.lang.Throwable -> Lef
            if (r12 == 0) goto L3d4
            r10 = r5
        L3d4:
            int r5 = r5 + 1
            r12 = r20
            goto L3a5
        L3d9:
            r5 = -1
            if (r9 != r5) goto L3de
            goto L458
        L3de:
            java.lang.Object r5 = r2.get(r9)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r5 = (com.google.android.gms.internal.measurement.n4) r5     // Catch: java.lang.Throwable -> Lef
            boolean r5 = r5.Y()     // Catch: java.lang.Throwable -> Lef
            if (r5 != 0) goto L410
            java.lang.Object r5 = r2.get(r9)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r5 = (com.google.android.gms.internal.measurement.n4) r5     // Catch: java.lang.Throwable -> Lef
            boolean r5 = r5.W()     // Catch: java.lang.Throwable -> Lef
            if (r5 != 0) goto L410
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.x()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.a(r5)     // Catch: java.lang.Throwable -> Lef
            r8.z(r9)     // Catch: java.lang.Throwable -> Lef
            H(r8, r11)     // Catch: java.lang.Throwable -> Lef
            r2 = 18
            G(r8, r2, r12)     // Catch: java.lang.Throwable -> Lef
        L40e:
            r5 = -1
            goto L458
        L410:
            r5 = -1
            if (r10 != r5) goto L414
            goto L43c
        L414:
            java.lang.Object r2 = r2.get(r10)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r2 = (com.google.android.gms.internal.measurement.n4) r2     // Catch: java.lang.Throwable -> Lef
            java.lang.String r2 = r2.K()     // Catch: java.lang.Throwable -> Lef
            int r10 = r2.length()     // Catch: java.lang.Throwable -> Lef
            r12 = 3
            if (r10 != r12) goto L43c
            r10 = 0
        L426:
            int r12 = r2.length()     // Catch: java.lang.Throwable -> Lef
            if (r10 >= r12) goto L458
            int r12 = r2.codePointAt(r10)     // Catch: java.lang.Throwable -> Lef
            boolean r14 = java.lang.Character.isLetter(r12)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L43c
            int r12 = java.lang.Character.charCount(r12)     // Catch: java.lang.Throwable -> Lef
            int r10 = r10 + r12
            goto L426
        L43c:
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.x()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r10)     // Catch: java.lang.Throwable -> Lef
            r8.z(r9)     // Catch: java.lang.Throwable -> Lef
            H(r8, r11)     // Catch: java.lang.Throwable -> Lef
            r2 = 19
            G(r8, r2, r15)     // Catch: java.lang.Throwable -> Lef
            goto L458
        L455:
            r20 = r12
            goto L40e
        L458:
            java.lang.String r2 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> Lef
            r9 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L4a4
            g2.ra r2 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r2 = r8.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r2 = (com.google.android.gms.internal.measurement.j4) r2     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r2 = g2.ra.o(r2, r3)     // Catch: java.lang.Throwable -> Lef
            if (r2 != 0) goto L4a1
            if (r16 == 0) goto L49d
            long r2 = r16.u()     // Catch: java.lang.Throwable -> Lef
            long r11 = r8.u()     // Catch: java.lang.Throwable -> Lef
            long r2 = r2 - r11
            long r2 = java.lang.Math.abs(r2)     // Catch: java.lang.Throwable -> Lef
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 > 0) goto L49d
            com.google.android.gms.internal.measurement.x8 r2 = r16.l()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.i4 r2 = (com.google.android.gms.internal.measurement.i4) r2     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r1.P(r8, r2)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L49d
            r7.K(r6, r2)     // Catch: java.lang.Throwable -> Lef
            r15 = r28
        L499:
            r14 = 0
            r16 = 0
            goto L4f5
        L49d:
            r14 = r8
            r15 = r19
            goto L4f5
        L4a1:
            r9 = r28
            goto L4f3
        L4a4:
            java.lang.String r2 = "_vs"
            java.lang.String r3 = r8.G()     // Catch: java.lang.Throwable -> Lef
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> Lef
            if (r2 == 0) goto L4a1
            g2.ra r2 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r2 = r8.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r2 = (com.google.android.gms.internal.measurement.j4) r2     // Catch: java.lang.Throwable -> Lef
            r11 = r27
            com.google.android.gms.internal.measurement.n4 r2 = g2.ra.o(r2, r11)     // Catch: java.lang.Throwable -> Lef
            if (r2 != 0) goto L4a1
            if (r22 == 0) goto L4e9
            long r2 = r22.u()     // Catch: java.lang.Throwable -> Lef
            long r11 = r8.u()     // Catch: java.lang.Throwable -> Lef
            long r2 = r2 - r11
            long r2 = java.lang.Math.abs(r2)     // Catch: java.lang.Throwable -> Lef
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 > 0) goto L4e9
            com.google.android.gms.internal.measurement.x8 r2 = r22.l()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.i4 r2 = (com.google.android.gms.internal.measurement.i4) r2     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r1.P(r2, r8)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L4e9
            r9 = r28
            r7.K(r9, r2)     // Catch: java.lang.Throwable -> Lef
            r15 = r9
            goto L499
        L4e9:
            r9 = r28
            r16 = r8
            r15 = r9
            r6 = r19
        L4f0:
            r14 = r22
            goto L4f5
        L4f3:
            r15 = r9
            goto L4f0
        L4f5:
            java.util.List r2 = r13.f5126c     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r3 = r8.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r3 = (com.google.android.gms.internal.measurement.j4) r3     // Catch: java.lang.Throwable -> Lef
            r4 = r26
            r2.set(r4, r3)     // Catch: java.lang.Throwable -> Lef
            int r11 = r19 + 1
            r7.x0(r8)     // Catch: java.lang.Throwable -> Lef
            r12 = r20
        L509:
            int r10 = r4 + 1
            r2 = r24
            r5 = r25
            r3 = 1
            goto L46
        L513:
            r25 = r5
            r11 = r9
            r21 = r12
            r20 = 1
            r5 = 0
            r9 = r5
            r8 = r19
            r2 = 0
        L520:
            if (r2 >= r8) goto L570
            com.google.android.gms.internal.measurement.j4 r12 = r7.r0(r2)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r12.K()     // Catch: java.lang.Throwable -> Lef
            boolean r14 = r4.equals(r14)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L543
            g2.ra r14 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r14 = g2.ra.o(r12, r3)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L543
            r7.s(r2)     // Catch: java.lang.Throwable -> Lef
            int r8 = r8 + (-1)
            int r2 = r2 + (-1)
            goto L56d
        L543:
            g2.ra r14 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r12 = g2.ra.o(r12, r11)     // Catch: java.lang.Throwable -> Lef
            if (r12 == 0) goto L56d
            boolean r14 = r12.Y()     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L55d
            long r14 = r12.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r12 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> Lef
            goto L55e
        L55d:
            r12 = 0
        L55e:
            if (r12 == 0) goto L56d
            long r14 = r12.longValue()     // Catch: java.lang.Throwable -> Lef
            int r16 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r16 <= 0) goto L56d
            long r14 = r12.longValue()     // Catch: java.lang.Throwable -> Lef
            long r9 = r9 + r14
        L56d:
            int r2 = r2 + 1
            goto L520
        L570:
            r2 = 0
            r1.L(r7, r9, r2)     // Catch: java.lang.Throwable -> Lef
            java.util.List r2 = r7.m0()     // Catch: java.lang.Throwable -> Lef
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lef
        L57c:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "_se"
            if (r3 == 0) goto L5a2
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r3 = (com.google.android.gms.internal.measurement.j4) r3     // Catch: java.lang.Throwable -> Lef
            java.lang.String r8 = "_s"
            java.lang.String r3 = r3.K()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r8.equals(r3)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L57c
            g2.k r2 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r3 = r7.j0()     // Catch: java.lang.Throwable -> Lef
            r2.m(r3, r4)     // Catch: java.lang.Throwable -> Lef
        L5a2:
            java.lang.String r2 = "_sid"
            int r2 = g2.ra.x(r7, r2)     // Catch: java.lang.Throwable -> Lef
            if (r2 < 0) goto L5af
            r2 = 1
            r1.L(r7, r9, r2)     // Catch: java.lang.Throwable -> Lef
            goto L5cf
        L5af:
            int r2 = g2.ra.x(r7, r4)     // Catch: java.lang.Throwable -> Lef
            if (r2 < 0) goto L5cf
            r7.t(r2)     // Catch: java.lang.Throwable -> Lef
            g2.v3 r2 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.u4 r4 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r4.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> Lef
            r2.b(r3, r4)     // Catch: java.lang.Throwable -> Lef
        L5cf:
            g2.ra r2 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r2)     // Catch: java.lang.Throwable -> Lef
            g2.h5 r3 = r2.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r3 = r3.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.v()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Checking account type status for ad personalization signals"
            r3.a(r4)     // Catch: java.lang.Throwable -> Lef
            g2.pa r3 = r2.f4655b     // Catch: java.lang.Throwable -> Lef
            g2.y4 r3 = r3.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r7.j0()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r3.B(r4)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L664
            g2.pa r3 = r2.f4655b     // Catch: java.lang.Throwable -> Lef
            g2.k r3 = r3.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r7.j0()     // Catch: java.lang.Throwable -> Lef
            g2.e6 r3 = r3.R(r4)     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L664
            boolean r3 = r3.N()     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L664
            g2.h5 r3 = r2.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.o r3 = r3.A()     // Catch: java.lang.Throwable -> Lef
            boolean r3 = r3.s()     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto L664
            g2.h5 r3 = r2.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r3 = r3.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.q()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Turning off ad personalization due to account type"
            r3.a(r4)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.c5 r3 = com.google.android.gms.internal.measurement.d5.G()     // Catch: java.lang.Throwable -> Lef
            r3.x(r0)     // Catch: java.lang.Throwable -> Lef
            g2.h5 r2 = r2.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.o r2 = r2.A()     // Catch: java.lang.Throwable -> Lef
            long r8 = r2.o()     // Catch: java.lang.Throwable -> Lef
            r3.y(r8)     // Catch: java.lang.Throwable -> Lef
            r14 = 1
            r3.w(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r2 = r3.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.d5 r2 = (com.google.android.gms.internal.measurement.d5) r2     // Catch: java.lang.Throwable -> Lef
            r3 = 0
        L646:
            int r4 = r7.o0()     // Catch: java.lang.Throwable -> Lef
            if (r3 >= r4) goto L661
            com.google.android.gms.internal.measurement.d5 r4 = r7.i0(r3)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r4.I()     // Catch: java.lang.Throwable -> Lef
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Throwable -> Lef
            if (r4 == 0) goto L65e
            r7.g0(r3, r2)     // Catch: java.lang.Throwable -> Lef
            goto L664
        L65e:
            int r3 = r3 + 1
            goto L646
        L661:
            r7.z0(r2)     // Catch: java.lang.Throwable -> Lef
        L664:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7.b0(r2)     // Catch: java.lang.Throwable -> Lef
            r2 = -9223372036854775808
            r7.I(r2)     // Catch: java.lang.Throwable -> Lef
            r2 = 0
        L672:
            int r0 = r7.S()     // Catch: java.lang.Throwable -> Lef
            if (r2 >= r0) goto L6a5
            com.google.android.gms.internal.measurement.j4 r0 = r7.r0(r2)     // Catch: java.lang.Throwable -> Lef
            long r3 = r0.G()     // Catch: java.lang.Throwable -> Lef
            long r8 = r7.q0()     // Catch: java.lang.Throwable -> Lef
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 >= 0) goto L68f
            long r3 = r0.G()     // Catch: java.lang.Throwable -> Lef
            r7.b0(r3)     // Catch: java.lang.Throwable -> Lef
        L68f:
            long r3 = r0.G()     // Catch: java.lang.Throwable -> Lef
            long r8 = r7.p0()     // Catch: java.lang.Throwable -> Lef
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 <= 0) goto L6a2
            long r3 = r0.G()     // Catch: java.lang.Throwable -> Lef
            r7.I(r3)     // Catch: java.lang.Throwable -> Lef
        L6a2:
            int r2 = r2 + 1
            goto L672
        L6a5:
            r7.M0()     // Catch: java.lang.Throwable -> Lef
            r7.B0()     // Catch: java.lang.Throwable -> Lef
            g2.b r0 = r1.f5208f     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r27 = r7.j0()     // Catch: java.lang.Throwable -> Lef
            java.util.List r28 = r7.m0()     // Catch: java.lang.Throwable -> Lef
            java.util.List r29 = r7.n0()     // Catch: java.lang.Throwable -> Lef
            long r2 = r7.q0()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r30 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lef
            long r2 = r7.p0()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r31 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lef
            r26 = r0
            java.util.List r0 = r26.m(r27, r28, r29, r30, r31)     // Catch: java.lang.Throwable -> Lef
            r7.s0(r0)     // Catch: java.lang.Throwable -> Lef
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r2 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r2 = r2.W1()     // Catch: java.lang.Throwable -> Lef
            boolean r0 = r0.F(r2)     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto La17
            java.util.HashMap r2 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lef
            r2.<init>()     // Catch: java.lang.Throwable -> Lef
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lef
            r3.<init>()     // Catch: java.lang.Throwable -> Lef
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> Lef
            java.security.SecureRandom r4 = r0.u()     // Catch: java.lang.Throwable -> Lef
            r8 = 0
        L6f8:
            int r0 = r7.S()     // Catch: java.lang.Throwable -> Lef
            if (r8 >= r0) goto L9dc
            com.google.android.gms.internal.measurement.j4 r0 = r7.r0(r8)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.x8 r0 = r0.m()     // Catch: java.lang.Throwable -> Lef
            r9 = r0
            com.google.android.gms.internal.measurement.i4 r9 = (com.google.android.gms.internal.measurement.i4) r9     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = r9.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = "_ep"
            boolean r0 = r0.equals(r10)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = "_efs"
            java.lang.String r11 = "_sr"
            if (r0 == 0) goto L79f
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r0 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0     // Catch: java.lang.Throwable -> Lef
            java.lang.String r12 = "_en"
            java.lang.Object r0 = g2.ra.p(r0, r12)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r12 = r2.get(r0)     // Catch: java.lang.Throwable -> Lef
            g2.q r12 = (g2.q) r12     // Catch: java.lang.Throwable -> Lef
            if (r12 != 0) goto L74e
            g2.k r12 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r12)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r14 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r14.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r15 = u1.f.h(r0)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = (java.lang.String) r15     // Catch: java.lang.Throwable -> Lef
            g2.q r12 = r12.V(r14, r15)     // Catch: java.lang.Throwable -> Lef
            if (r12 == 0) goto L74e
            r2.put(r0, r12)     // Catch: java.lang.Throwable -> Lef
        L74e:
            if (r12 == 0) goto L790
            java.lang.Long r0 = r12.f5237i     // Catch: java.lang.Throwable -> Lef
            if (r0 != 0) goto L790
            java.lang.Long r0 = r12.f5238j     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto L76d
            long r14 = r0.longValue()     // Catch: java.lang.Throwable -> Lef
            r17 = 1
            int r0 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r0 <= 0) goto L76f
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r0 = r12.f5238j     // Catch: java.lang.Throwable -> Lef
            g2.ra.m(r9, r11, r0)     // Catch: java.lang.Throwable -> Lef
            goto L76f
        L76d:
            r17 = 1
        L76f:
            java.lang.Boolean r0 = r12.f5239k     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto L784
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto L784
            g2.ra r0 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            r12 = r25
            g2.ra.m(r9, r10, r12)     // Catch: java.lang.Throwable -> Lef
            goto L786
        L784:
            r12 = r25
        L786:
            com.google.android.gms.internal.measurement.a9 r0 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0     // Catch: java.lang.Throwable -> Lef
            r3.add(r0)     // Catch: java.lang.Throwable -> Lef
            goto L794
        L790:
            r12 = r25
            r17 = 1
        L794:
            r7.K(r8, r9)     // Catch: java.lang.Throwable -> Lef
            r22 = r5
        L799:
            r15 = r7
            r5 = r8
            r28 = r13
            goto L9d1
        L79f:
            r12 = r25
            r17 = 1
            g2.y4 r14 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r0 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r0.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r0 = r14.e(r15, r0)     // Catch: java.lang.Throwable -> Lef
            boolean r16 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lef
            if (r16 != 0) goto L7da
            long r14 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lef java.lang.NumberFormatException -> L7c1
            r22 = r5
            goto L7dd
        L7c1:
            r0 = move-exception
            g2.h5 r14 = r14.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r14 = r14.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r14 = r14.w()     // Catch: java.lang.Throwable -> Lef
            r22 = r5
            java.lang.String r5 = "Unable to parse timezone offset. appId"
            java.lang.Object r6 = g2.v3.z(r15)     // Catch: java.lang.Throwable -> Lef
            r14.c(r5, r6, r0)     // Catch: java.lang.Throwable -> Lef
        L7d7:
            r14 = r22
            goto L7dd
        L7da:
            r22 = r5
            goto L7d7
        L7dd:
            g2.wa r0 = r1.h0()     // Catch: java.lang.Throwable -> Lef
            long r5 = r9.u()     // Catch: java.lang.Throwable -> Lef
            long r5 = r0.u0(r5, r14)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r0 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0     // Catch: java.lang.Throwable -> Lef
            r48 = r10
            java.lang.String r10 = "_dbg"
            boolean r16 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lef
            if (r16 != 0) goto L82d
            java.util.List r0 = r0.L()     // Catch: java.lang.Throwable -> Lef
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lef
        L801:
            boolean r16 = r0.hasNext()     // Catch: java.lang.Throwable -> Lef
            if (r16 == 0) goto L82d
            java.lang.Object r16 = r0.next()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.n4 r16 = (com.google.android.gms.internal.measurement.n4) r16     // Catch: java.lang.Throwable -> Lef
            r24 = r14
            java.lang.String r14 = r16.J()     // Catch: java.lang.Throwable -> Lef
            boolean r14 = r10.equals(r14)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L82a
            long r14 = r16.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r0 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> Lef
            boolean r0 = r12.equals(r0)     // Catch: java.lang.Throwable -> Lef
            if (r0 != 0) goto L828
            goto L82f
        L828:
            r0 = 1
            goto L842
        L82a:
            r14 = r24
            goto L801
        L82d:
            r24 = r14
        L82f:
            g2.y4 r0 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r10 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r10.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r9.G()     // Catch: java.lang.Throwable -> Lef
            int r0 = r0.r(r10, r14)     // Catch: java.lang.Throwable -> Lef
        L842:
            if (r0 > 0) goto L867
            g2.v3 r5 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r5 = r5.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = "Sample rate must be positive. event, rate"
            java.lang.String r10 = r9.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lef
            r5.c(r6, r10, r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r0 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0     // Catch: java.lang.Throwable -> Lef
            r3.add(r0)     // Catch: java.lang.Throwable -> Lef
            r7.K(r8, r9)     // Catch: java.lang.Throwable -> Lef
            goto L799
        L867:
            java.lang.String r10 = r9.G()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r10 = r2.get(r10)     // Catch: java.lang.Throwable -> Lef
            g2.q r10 = (g2.q) r10     // Catch: java.lang.Throwable -> Lef
            if (r10 != 0) goto L8c7
            g2.k r10 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r10)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r14 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = r14.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r9.G()     // Catch: java.lang.Throwable -> Lef
            g2.q r10 = r10.V(r14, r15)     // Catch: java.lang.Throwable -> Lef
            if (r10 != 0) goto L8c7
            g2.v3 r10 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r10 = r10.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.u4 r15 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r15 = r15.W1()     // Catch: java.lang.Throwable -> Lef
            r16 = r12
            java.lang.String r12 = r9.G()     // Catch: java.lang.Throwable -> Lef
            r10.c(r14, r15, r12)     // Catch: java.lang.Throwable -> Lef
            g2.q r26 = new g2.q     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r10 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r27 = r10.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r28 = r9.G()     // Catch: java.lang.Throwable -> Lef
            long r35 = r9.u()     // Catch: java.lang.Throwable -> Lef
            r41 = 0
            r42 = 0
            r29 = 1
            r31 = 1
            r33 = 1
            r37 = 0
            r39 = 0
            r40 = 0
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch: java.lang.Throwable -> Lef
            r10 = r26
            goto L8c9
        L8c7:
            r16 = r12
        L8c9:
            g2.ra r12 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r12)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r12 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r12 = (com.google.android.gms.internal.measurement.j4) r12     // Catch: java.lang.Throwable -> Lef
            java.lang.String r14 = "_eid"
            java.lang.Object r12 = g2.ra.p(r12, r14)     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.Throwable -> Lef
            if (r12 == 0) goto L8e1
            r14 = 1
        L8df:
            r15 = 1
            goto L8e3
        L8e1:
            r14 = 0
            goto L8df
        L8e3:
            if (r0 != r15) goto L913
            com.google.android.gms.internal.measurement.a9 r0 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0     // Catch: java.lang.Throwable -> Lef
            r3.add(r0)     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L908
            java.lang.Long r0 = r10.f5237i     // Catch: java.lang.Throwable -> Lef
            if (r0 != 0) goto L8fc
            java.lang.Long r0 = r10.f5238j     // Catch: java.lang.Throwable -> Lef
            if (r0 != 0) goto L8fc
            java.lang.Boolean r0 = r10.f5239k     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto L908
        L8fc:
            r5 = 0
            g2.q r0 = r10.a(r5, r5, r5)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = r9.G()     // Catch: java.lang.Throwable -> Lef
            r2.put(r5, r0)     // Catch: java.lang.Throwable -> Lef
        L908:
            r7.K(r8, r9)     // Catch: java.lang.Throwable -> Lef
            r15 = r7
            r5 = r8
            r28 = r13
            r12 = r16
            goto L9d1
        L913:
            int r15 = r4.nextInt(r0)     // Catch: java.lang.Throwable -> Lef
            if (r15 != 0) goto L94f
            g2.ra r12 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r12)     // Catch: java.lang.Throwable -> Lef
            r19 = r14
            long r14 = (long) r0     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r0 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> Lef
            g2.ra.m(r9, r11, r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r11 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r11 = (com.google.android.gms.internal.measurement.j4) r11     // Catch: java.lang.Throwable -> Lef
            r3.add(r11)     // Catch: java.lang.Throwable -> Lef
            if (r19 == 0) goto L938
            r11 = 0
            g2.q r10 = r10.a(r11, r0, r11)     // Catch: java.lang.Throwable -> Lef
        L938:
            java.lang.String r0 = r9.G()     // Catch: java.lang.Throwable -> Lef
            long r11 = r9.u()     // Catch: java.lang.Throwable -> Lef
            g2.q r5 = r10.b(r11, r5)     // Catch: java.lang.Throwable -> Lef
            r2.put(r0, r5)     // Catch: java.lang.Throwable -> Lef
            r15 = r7
            r5 = r8
            r28 = r13
            r12 = r16
            goto L9ce
        L94f:
            r19 = r14
            java.lang.Long r14 = r10.f5236h     // Catch: java.lang.Throwable -> Lef
            if (r14 == 0) goto L965
            long r14 = r14.longValue()     // Catch: java.lang.Throwable -> Lef
            r26 = r8
            r27 = r12
            r28 = r13
            r43 = r14
            r15 = r7
            r7 = r43
            goto L97a
        L965:
            g2.wa r14 = r1.h0()     // Catch: java.lang.Throwable -> Lef
            r15 = r7
            r26 = r8
            long r7 = r9.t()     // Catch: java.lang.Throwable -> Lef
            r27 = r12
            r28 = r13
            r12 = r24
            long r7 = r14.u0(r7, r12)     // Catch: java.lang.Throwable -> Lef
        L97a:
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 == 0) goto L9bb
            g2.ra r7 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r7)     // Catch: java.lang.Throwable -> Lef
            r7 = r48
            r12 = r16
            g2.ra.m(r9, r7, r12)     // Catch: java.lang.Throwable -> Lef
            g2.ra r7 = r1.f5209g     // Catch: java.lang.Throwable -> Lef
            R(r7)     // Catch: java.lang.Throwable -> Lef
            long r7 = (long) r0     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lef
            g2.ra.m(r9, r11, r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r7 = r9.o()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.j4 r7 = (com.google.android.gms.internal.measurement.j4) r7     // Catch: java.lang.Throwable -> Lef
            r3.add(r7)     // Catch: java.lang.Throwable -> Lef
            if (r19 == 0) goto L9a9
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lef
            r11 = 0
            g2.q r10 = r10.a(r11, r0, r7)     // Catch: java.lang.Throwable -> Lef
        L9a9:
            java.lang.String r0 = r9.G()     // Catch: java.lang.Throwable -> Lef
            long r7 = r9.u()     // Catch: java.lang.Throwable -> Lef
            g2.q r5 = r10.b(r7, r5)     // Catch: java.lang.Throwable -> Lef
            r2.put(r0, r5)     // Catch: java.lang.Throwable -> Lef
        L9b8:
            r5 = r26
            goto L9ce
        L9bb:
            r12 = r16
            if (r19 == 0) goto L9b8
            java.lang.String r0 = r9.G()     // Catch: java.lang.Throwable -> Lef
            r5 = r27
            r11 = 0
            g2.q r5 = r10.a(r5, r11, r11)     // Catch: java.lang.Throwable -> Lef
            r2.put(r0, r5)     // Catch: java.lang.Throwable -> Lef
            goto L9b8
        L9ce:
            r15.K(r5, r9)     // Catch: java.lang.Throwable -> Lef
        L9d1:
            int r8 = r5 + 1
            r25 = r12
            r7 = r15
            r5 = r22
            r13 = r28
            goto L6f8
        L9dc:
            r22 = r5
            r15 = r7
            r28 = r13
            int r0 = r3.size()     // Catch: java.lang.Throwable -> Lef
            int r4 = r15.S()     // Catch: java.lang.Throwable -> Lef
            if (r0 >= r4) goto L9f1
            r15.E0()     // Catch: java.lang.Throwable -> Lef
            r15.t0(r3)     // Catch: java.lang.Throwable -> Lef
        L9f1:
            java.util.Set r0 = r2.entrySet()     // Catch: java.lang.Throwable -> Lef
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lef
        L9f9:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> Lef
            if (r2 == 0) goto La14
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> Lef
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> Lef
            g2.k r3 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> Lef
            g2.q r2 = (g2.q) r2     // Catch: java.lang.Throwable -> Lef
            r3.q(r2)     // Catch: java.lang.Throwable -> Lef
            goto L9f9
        La14:
            r13 = r28
            goto La1a
        La17:
            r22 = r5
            r15 = r7
        La1a:
            com.google.android.gms.internal.measurement.u4 r0 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r2 = r0.W1()     // Catch: java.lang.Throwable -> Lef
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            g2.e6 r0 = r0.R(r2)     // Catch: java.lang.Throwable -> Lef
            if (r0 != 0) goto La43
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r3 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.u4 r4 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = r4.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> Lef
            r0.b(r3, r4)     // Catch: java.lang.Throwable -> Lef
            goto La9b
        La43:
            int r3 = r15.S()     // Catch: java.lang.Throwable -> Lef
            if (r3 <= 0) goto La9b
            long r3 = r0.d0()     // Catch: java.lang.Throwable -> Lef
            int r5 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r5 == 0) goto La55
            r15.U(r3)     // Catch: java.lang.Throwable -> Lef
            goto La58
        La55:
            r15.I0()     // Catch: java.lang.Throwable -> Lef
        La58:
            long r5 = r0.f0()     // Catch: java.lang.Throwable -> Lef
            int r7 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r7 != 0) goto La61
            goto La62
        La61:
            r3 = r5
        La62:
            int r5 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r5 == 0) goto La6a
            r15.V(r3)     // Catch: java.lang.Throwable -> Lef
            goto La6d
        La6a:
            r15.J0()     // Catch: java.lang.Throwable -> Lef
        La6d:
            r0.g()     // Catch: java.lang.Throwable -> Lef
            long r3 = r0.e0()     // Catch: java.lang.Throwable -> Lef
            int r4 = (int) r3     // Catch: java.lang.Throwable -> Lef
            r15.A(r4)     // Catch: java.lang.Throwable -> Lef
            long r3 = r15.q0()     // Catch: java.lang.Throwable -> Lef
            r0.E(r3)     // Catch: java.lang.Throwable -> Lef
            long r3 = r15.p0()     // Catch: java.lang.Throwable -> Lef
            r0.C(r3)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r3 = r0.k0()     // Catch: java.lang.Throwable -> Lef
            if (r3 == 0) goto La90
            r15.O(r3)     // Catch: java.lang.Throwable -> Lef
            goto La93
        La90:
            r15.F0()     // Catch: java.lang.Throwable -> Lef
        La93:
            g2.k r3 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            r3.p(r0)     // Catch: java.lang.Throwable -> Lef
        La9b:
            int r0 = r15.S()     // Catch: java.lang.Throwable -> Lef
            if (r0 <= 0) goto Lc1e
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> Lef
            r0.b()     // Catch: java.lang.Throwable -> Lef
            g2.y4 r0 = r1.f5203a     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.u4 r3 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r3 = r3.W1()     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.v3 r0 = r0.t(r3)     // Catch: java.lang.Throwable -> Lef
            r3 = -1
            if (r0 == 0) goto Lac8
            boolean r5 = r0.W()     // Catch: java.lang.Throwable -> Lef
            if (r5 != 0) goto Lac0
            goto Lac8
        Lac0:
            long r5 = r0.F()     // Catch: java.lang.Throwable -> Lef
            r15.C(r5)     // Catch: java.lang.Throwable -> Lef
            goto Laef
        Lac8:
            com.google.android.gms.internal.measurement.u4 r0 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = r0.J()     // Catch: java.lang.Throwable -> Lef
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto Lad8
            r15.C(r3)     // Catch: java.lang.Throwable -> Lef
            goto Laef
        Lad8:
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.u4 r6 = r13.f5124a     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r6 = g2.v3.z(r6)     // Catch: java.lang.Throwable -> Lef
            r0.b(r5, r6)     // Catch: java.lang.Throwable -> Lef
        Laef:
            g2.k r5 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r5)     // Catch: java.lang.Throwable -> Lef
            com.google.android.gms.internal.measurement.a9 r0 = r15.o()     // Catch: java.lang.Throwable -> Lef
            r6 = r0
            com.google.android.gms.internal.measurement.u4 r6 = (com.google.android.gms.internal.measurement.u4) r6     // Catch: java.lang.Throwable -> Lef
            r5.h()     // Catch: java.lang.Throwable -> Lef
            r5.i()     // Catch: java.lang.Throwable -> Lef
            u1.f.h(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            u1.f.d(r0)     // Catch: java.lang.Throwable -> Lef
            boolean r0 = r6.n1()     // Catch: java.lang.Throwable -> Lef
            u1.f.k(r0)     // Catch: java.lang.Throwable -> Lef
            r5.h0()     // Catch: java.lang.Throwable -> Lef
            g2.h5 r0 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            x1.c r0 = r0.a()     // Catch: java.lang.Throwable -> Lef
            long r7 = r0.a()     // Catch: java.lang.Throwable -> Lef
            long r9 = r6.J1()     // Catch: java.lang.Throwable -> Lef
            g2.h5 r0 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            r0.z()     // Catch: java.lang.Throwable -> Lef
            long r11 = g2.g.i()     // Catch: java.lang.Throwable -> Lef
            long r11 = r7 - r11
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 < 0) goto Lb44
            long r9 = r6.J1()     // Catch: java.lang.Throwable -> Lef
            g2.h5 r0 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            r0.z()     // Catch: java.lang.Throwable -> Lef
            long r11 = g2.g.i()     // Catch: java.lang.Throwable -> Lef
            long r11 = r11 + r7
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 <= 0) goto Lb67
        Lb44:
            g2.h5 r0 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r9 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r10 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r10 = g2.v3.z(r10)     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lef
            long r11 = r6.J1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> Lef
            r0.d(r9, r10, r7, r8)     // Catch: java.lang.Throwable -> Lef
        Lb67:
            byte[] r0 = r6.j()     // Catch: java.lang.Throwable -> Lef
            g2.pa r7 = r5.f4655b     // Catch: java.lang.Throwable -> Lef java.io.IOException -> Lc06
            g2.ra r7 = r7.f5209g     // Catch: java.lang.Throwable -> Lef java.io.IOException -> Lc06
            R(r7)     // Catch: java.lang.Throwable -> Lef java.io.IOException -> Lc06
            byte[] r0 = r7.Q(r0)     // Catch: java.lang.Throwable -> Lef java.io.IOException -> Lc06
            g2.h5 r7 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r7 = r7.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r7 = r7.v()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r8 = "Saving bundle, size"
            int r9 = r0.length     // Catch: java.lang.Throwable -> Lef
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> Lef
            r7.b(r8, r9)     // Catch: java.lang.Throwable -> Lef
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch: java.lang.Throwable -> Lef
            r7.<init>()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r8 = "app_id"
            java.lang.String r9 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r8 = "bundle_end_timestamp"
            long r9 = r6.J1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> Lef
            r7.put(r8, r9)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r8 = "data"
            r7.put(r8, r0)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r0 = "has_realtime"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r21)     // Catch: java.lang.Throwable -> Lef
            r7.put(r0, r8)     // Catch: java.lang.Throwable -> Lef
            boolean r0 = r6.t1()     // Catch: java.lang.Throwable -> Lef
            if (r0 == 0) goto Lbc6
            java.lang.String r0 = "retry_count"
            int r8 = r6.D1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> Lef
            r7.put(r0, r8)     // Catch: java.lang.Throwable -> Lef
        Lbc6:
            android.database.sqlite.SQLiteDatabase r0 = r5.P()     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            java.lang.String r8 = "queue"
            r11 = 0
            long r7 = r0.insert(r8, r11, r7)     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 != 0) goto Lc1e
            g2.h5 r0 = r5.f4646a     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            java.lang.String r3 = "Failed to insert bundle (got -1). appId"
            java.lang.String r4 = r6.W1()     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            r0.b(r3, r4)     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lbed
            goto Lc1e
        Lbed:
            r0 = move-exception
            g2.h5 r3 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r3 = r3.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Error storing bundle. appId"
            java.lang.String r5 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r5 = g2.v3.z(r5)     // Catch: java.lang.Throwable -> Lef
            r3.c(r4, r5, r0)     // Catch: java.lang.Throwable -> Lef
            goto Lc1e
        Lc06:
            r0 = move-exception
            g2.h5 r3 = r5.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r3 = r3.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r6.W1()     // Catch: java.lang.Throwable -> Lef
            java.lang.Object r5 = g2.v3.z(r5)     // Catch: java.lang.Throwable -> Lef
            r3.c(r4, r5, r0)     // Catch: java.lang.Throwable -> Lef
        Lc1e:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            java.util.List r3 = r13.f5125b     // Catch: java.lang.Throwable -> Lef
            u1.f.h(r3)     // Catch: java.lang.Throwable -> Lef
            r0.h()     // Catch: java.lang.Throwable -> Lef
            r0.i()     // Catch: java.lang.Throwable -> Lef
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "rowid in ("
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lef
            r8 = 0
        Lc36:
            int r5 = r3.size()     // Catch: java.lang.Throwable -> Lef
            if (r8 >= r5) goto Lc53
            if (r8 == 0) goto Lc43
            java.lang.String r5 = ","
            r4.append(r5)     // Catch: java.lang.Throwable -> Lef
        Lc43:
            java.lang.Object r5 = r3.get(r8)     // Catch: java.lang.Throwable -> Lef
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> Lef
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> Lef
            r4.append(r5)     // Catch: java.lang.Throwable -> Lef
            int r8 = r8 + 1
            goto Lc36
        Lc53:
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lef
            android.database.sqlite.SQLiteDatabase r5 = r0.P()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lef
            r11 = 0
            int r4 = r5.delete(r6, r4, r11)     // Catch: java.lang.Throwable -> Lef
            int r5 = r3.size()     // Catch: java.lang.Throwable -> Lef
            if (r4 == r5) goto Lc88
            g2.h5 r0 = r0.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r5 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lef
            int r3 = r3.size()     // Catch: java.lang.Throwable -> Lef
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lef
            r0.c(r5, r4, r3)     // Catch: java.lang.Throwable -> Lef
        Lc88:
            g2.k r3 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r3)     // Catch: java.lang.Throwable -> Lef
            android.database.sqlite.SQLiteDatabase r0 = r3.P()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            java.lang.String[] r5 = new java.lang.String[]{r2, r2}     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lc9b
            r0.execSQL(r4, r5)     // Catch: java.lang.Throwable -> Lef android.database.sqlite.SQLiteException -> Lc9b
            goto Lcaf
        Lc9b:
            r0 = move-exception
            g2.h5 r3 = r3.f4646a     // Catch: java.lang.Throwable -> Lef
            g2.v3 r3 = r3.d()     // Catch: java.lang.Throwable -> Lef
            g2.t3 r3 = r3.r()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = g2.v3.z(r2)     // Catch: java.lang.Throwable -> Lef
            r3.c(r4, r2, r0)     // Catch: java.lang.Throwable -> Lef
        Lcaf:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            r0.o()     // Catch: java.lang.Throwable -> Lef
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            r20 = 1
            return r20
        Lcc2:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lef
            R(r0)     // Catch: java.lang.Throwable -> Lef
            r0.o()     // Catch: java.lang.Throwable -> Lef
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            r2 = 0
            return r2
        Lcd4:
            g2.k r2 = r1.f5205c
            R(r2)
            r2.f0()
            goto Lcde
        Lcdd:
            throw r0
        Lcde:
            goto Lcdd
    }

    public final boolean O() {
            r1 = this;
            g2.e5 r0 = r1.f()
            r0.h()
            r1.g()
            g2.k r0 = r1.f5205c
            R(r0)
            boolean r0 = r0.r()
            if (r0 != 0) goto L27
            g2.k r0 = r1.f5205c
            R(r0)
            java.lang.String r0 = r0.Z()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L25
            goto L27
        L25:
            r0 = 0
            return r0
        L27:
            r0 = 1
            return r0
    }

    public final boolean P(com.google.android.gms.internal.measurement.i4 r10, com.google.android.gms.internal.measurement.i4 r11) {
            r9 = this;
            java.lang.String r0 = r10.G()
            java.lang.String r1 = "_e"
            boolean r0 = r1.equals(r0)
            u1.f.a(r0)
            g2.ra r0 = r9.f5209g
            R(r0)
            com.google.android.gms.internal.measurement.a9 r0 = r10.o()
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0
            java.lang.String r2 = "_sc"
            com.google.android.gms.internal.measurement.n4 r0 = g2.ra.o(r0, r2)
            r2 = 0
            if (r0 != 0) goto L23
            r0 = r2
            goto L27
        L23:
            java.lang.String r0 = r0.K()
        L27:
            g2.ra r3 = r9.f5209g
            R(r3)
            com.google.android.gms.internal.measurement.a9 r3 = r11.o()
            com.google.android.gms.internal.measurement.j4 r3 = (com.google.android.gms.internal.measurement.j4) r3
            java.lang.String r4 = "_pc"
            com.google.android.gms.internal.measurement.n4 r3 = g2.ra.o(r3, r4)
            if (r3 != 0) goto L3b
            goto L3f
        L3b:
            java.lang.String r2 = r3.K()
        L3f:
            if (r2 == 0) goto Lb6
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto Lb6
            java.lang.String r0 = r10.G()
            boolean r0 = r1.equals(r0)
            u1.f.a(r0)
            g2.ra r0 = r9.f5209g
            R(r0)
            com.google.android.gms.internal.measurement.a9 r0 = r10.o()
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0
            java.lang.String r1 = "_et"
            com.google.android.gms.internal.measurement.n4 r0 = g2.ra.o(r0, r1)
            if (r0 == 0) goto Lb4
            boolean r2 = r0.Y()
            if (r2 == 0) goto Lb4
            long r2 = r0.G()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L76
            goto Lb4
        L76:
            long r2 = r0.G()
            g2.ra r0 = r9.f5209g
            R(r0)
            com.google.android.gms.internal.measurement.a9 r0 = r11.o()
            com.google.android.gms.internal.measurement.j4 r0 = (com.google.android.gms.internal.measurement.j4) r0
            com.google.android.gms.internal.measurement.n4 r0 = g2.ra.o(r0, r1)
            if (r0 == 0) goto L98
            long r6 = r0.G()
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L98
            long r4 = r0.G()
            long r2 = r2 + r4
        L98:
            g2.ra r0 = r9.f5209g
            R(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            g2.ra.m(r11, r1, r0)
            g2.ra r11 = r9.f5209g
            R(r11)
            r0 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "_fr"
            g2.ra.m(r10, r0, r11)
        Lb4:
            r10 = 1
            return r10
        Lb6:
            r10 = 0
            return r10
    }

    public final g2.e6 S(com.google.android.gms.measurement.internal.zzq r11) {
            r10 = this;
            g2.e5 r0 = r10.f()
            r0.h()
            r10.g()
            u1.f.h(r11)
            java.lang.String r0 = r11.f3275c
            u1.f.d(r0)
            java.lang.String r0 = r11.G
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L29
            java.util.Map r0 = r10.B
            java.lang.String r2 = r11.f3275c
            g2.oa r3 = new g2.oa
            java.lang.String r4 = r11.G
            r3.<init>(r10, r4, r1)
            r0.put(r2, r3)
        L29:
            g2.k r0 = r10.f5205c
            R(r0)
            java.lang.String r2 = r11.f3275c
            g2.e6 r0 = r0.R(r2)
            java.lang.String r2 = r11.f3275c
            g2.f6 r2 = r10.c0(r2)
            java.lang.String r3 = r11.F
            r4 = 100
            g2.f6 r3 = g2.f6.c(r3, r4)
            g2.f6 r2 = r2.d(r3)
            com.google.android.gms.measurement.internal.zzha r3 = com.google.android.gms.measurement.internal.zzha.zza
            boolean r4 = r2.j(r3)
            if (r4 == 0) goto L59
            g2.g9 r4 = r10.f5211i
            java.lang.String r5 = r11.f3275c
            boolean r6 = r11.f3289y
            java.lang.String r4 = r4.o(r5, r6)
            goto L5b
        L59:
            java.lang.String r4 = ""
        L5b:
            if (r0 != 0) goto L80
            g2.e6 r0 = new g2.e6
            g2.h5 r5 = r10.f5214l
            java.lang.String r6 = r11.f3275c
            r0.<init>(r5, r6)
            com.google.android.gms.measurement.internal.zzha r5 = com.google.android.gms.measurement.internal.zzha.zzb
            boolean r5 = r2.j(r5)
            if (r5 == 0) goto L75
            java.lang.String r5 = r10.i0(r2)
            r0.j(r5)
        L75:
            boolean r2 = r2.j(r3)
            if (r2 == 0) goto L10b
            r0.H(r4)
            goto L10b
        L80:
            boolean r3 = r2.j(r3)
            if (r3 == 0) goto Lf2
            if (r4 == 0) goto Lf2
            java.lang.String r3 = r0.c()
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto Lf2
            r0.H(r4)
            boolean r3 = r11.f3289y
            if (r3 == 0) goto L10b
            g2.g9 r3 = r10.f5211i
            java.lang.String r4 = r11.f3275c
            android.util.Pair r3 = r3.n(r4, r2)
            java.lang.Object r3 = r3.first
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L10b
            java.lang.String r2 = r10.i0(r2)
            r0.j(r2)
            g2.k r2 = r10.f5205c
            R(r2)
            java.lang.String r3 = r11.f3275c
            java.lang.String r4 = "_id"
            g2.ta r2 = r2.X(r3, r4)
            if (r2 == 0) goto L10b
            g2.k r2 = r10.f5205c
            R(r2)
            java.lang.String r3 = r11.f3275c
            java.lang.String r4 = "_lair"
            g2.ta r2 = r2.X(r3, r4)
            if (r2 != 0) goto L10b
            x1.c r2 = r10.a()
            long r7 = r2.a()
            g2.ta r3 = new g2.ta
            java.lang.String r4 = r11.f3275c
            r5 = 1
            java.lang.Long r9 = java.lang.Long.valueOf(r5)
            java.lang.String r5 = "auto"
            java.lang.String r6 = "_lair"
            r3.<init>(r4, r5, r6, r7, r9)
            g2.k r2 = r10.f5205c
            R(r2)
            r2.x(r3)
            goto L10b
        Lf2:
            java.lang.String r3 = r0.m0()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L10b
            com.google.android.gms.measurement.internal.zzha r3 = com.google.android.gms.measurement.internal.zzha.zzb
            boolean r3 = r2.j(r3)
            if (r3 == 0) goto L10b
            java.lang.String r2 = r10.i0(r2)
            r0.j(r2)
        L10b:
            java.lang.String r2 = r11.f3276e
            r0.y(r2)
            java.lang.String r2 = r11.A
            r0.h(r2)
            java.lang.String r2 = r11.f3285u
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L122
            java.lang.String r2 = r11.f3285u
            r0.x(r2)
        L122:
            long r2 = r11.f3279o
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L12d
            r0.z(r2)
        L12d:
            java.lang.String r2 = r11.f3277m
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L13a
            java.lang.String r2 = r11.f3277m
            r0.l(r2)
        L13a:
            long r2 = r11.f3284t
            r0.m(r2)
            java.lang.String r2 = r11.f3278n
            if (r2 == 0) goto L146
            r0.k(r2)
        L146:
            long r2 = r11.f3280p
            r0.u(r2)
            boolean r2 = r11.f3282r
            r0.F(r2)
            java.lang.String r2 = r11.f3281q
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L15d
            java.lang.String r2 = r11.f3281q
            r0.B(r2)
        L15d:
            boolean r2 = r11.f3289y
            r0.i(r2)
            java.lang.Boolean r2 = r11.B
            r0.G(r2)
            long r2 = r11.C
            r0.v(r2)
            com.google.android.gms.internal.measurement.ae.b()
            g2.g r2 = r10.U()
            g2.h3 r3 = g2.i3.f4940o0
            boolean r2 = r2.B(r1, r3)
            if (r2 != 0) goto L189
            g2.g r2 = r10.U()
            java.lang.String r3 = r11.f3275c
            g2.h3 r4 = g2.i3.f4944q0
            boolean r2 = r2.B(r3, r4)
            if (r2 == 0) goto L18e
        L189:
            java.lang.String r2 = r11.H
            r0.J(r2)
        L18e:
            com.google.android.gms.internal.measurement.tb.b()
            g2.g r2 = r10.U()
            g2.h3 r3 = g2.i3.f4938n0
            boolean r2 = r2.B(r1, r3)
            if (r2 == 0) goto L1a3
            java.util.List r2 = r11.D
            r0.I(r2)
            goto L1b5
        L1a3:
            com.google.android.gms.internal.measurement.tb.b()
            g2.g r2 = r10.U()
            g2.h3 r3 = g2.i3.f4936m0
            boolean r2 = r2.B(r1, r3)
            if (r2 == 0) goto L1b5
            r0.I(r1)
        L1b5:
            com.google.android.gms.internal.measurement.ke.b()
            g2.g r2 = r10.U()
            g2.h3 r3 = g2.i3.f4948s0
            boolean r2 = r2.B(r1, r3)
            if (r2 == 0) goto L1c9
            boolean r2 = r11.I
            r0.L(r2)
        L1c9:
            com.google.android.gms.internal.measurement.ed.b()
            g2.g r2 = r10.U()
            g2.h3 r3 = g2.i3.G0
            boolean r1 = r2.B(r1, r3)
            if (r1 == 0) goto L1dd
            long r1 = r11.J
            r0.M(r1)
        L1dd:
            boolean r11 = r0.P()
            if (r11 == 0) goto L1eb
            g2.k r11 = r10.f5205c
            R(r11)
            r11.p(r0)
        L1eb:
            return r0
    }

    public final g2.b T() {
            r1 = this;
            g2.b r0 = r1.f5208f
            R(r0)
            return r0
    }

    public final g2.g U() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            java.lang.Object r0 = u1.f.h(r0)
            g2.h5 r0 = (g2.h5) r0
            g2.g r0 = r0.z()
            return r0
    }

    public final g2.k V() {
            r1 = this;
            g2.k r0 = r1.f5205c
            R(r0)
            return r0
    }

    public final g2.q3 W() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            g2.q3 r0 = r0.D()
            return r0
    }

    public final g2.b4 X() {
            r1 = this;
            g2.b4 r0 = r1.f5204b
            R(r0)
            return r0
    }

    public final g2.e4 Y() {
            r2 = this;
            g2.e4 r0 = r2.f5206d
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Network broadcast receiver not created"
            r0.<init>(r1)
            throw r0
    }

    public final g2.y4 Z() {
            r1 = this;
            g2.y4 r0 = r1.f5203a
            R(r0)
            return r0
    }

    @Override // g2.c6
    public final x1.c a() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            java.lang.Object r0 = u1.f.h(r0)
            g2.h5 r0 = (g2.h5) r0
            x1.c r0 = r0.a()
            return r0
    }

    @Override // g2.c6
    public final g2.c b() {
            r1 = this;
            r0 = 0
            throw r0
    }

    public final g2.h5 b0() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            return r0
    }

    @Override // g2.c6
    public final android.content.Context c() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            android.content.Context r0 = r0.c()
            return r0
    }

    public final g2.f6 c0(java.lang.String r6) {
            r5 = this;
            g2.f6 r0 = g2.f6.f4794c
            g2.e5 r0 = r5.f()
            r0.h()
            r5.g()
            java.util.Map r0 = r5.A
            java.lang.Object r0 = r0.get(r6)
            g2.f6 r0 = (g2.f6) r0
            if (r0 != 0) goto L6a
            g2.k r0 = r5.f5205c
            R(r0)
            u1.f.h(r6)
            r0.h()
            r0.i()
            java.lang.String[] r1 = new java.lang.String[]{r6}
            android.database.sqlite.SQLiteDatabase r2 = r0.P()
            java.lang.String r3 = "select consent_state from consent_settings where app_id=? limit 1;"
            r4 = 0
            android.database.Cursor r4 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            boolean r1 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            if (r1 == 0) goto L42
            r1 = 0
            java.lang.String r0 = r4.getString(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            r4.close()
            goto L47
        L42:
            r4.close()
            java.lang.String r0 = "G1"
        L47:
            r1 = 100
            g2.f6 r0 = g2.f6.c(r0, r1)
            r5.A(r6, r0)
            return r0
        L51:
            r6 = move-exception
            goto L64
        L53:
            r6 = move-exception
            g2.h5 r0 = r0.f4646a     // Catch: java.lang.Throwable -> L51
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> L51
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "Database error"
            r0.c(r1, r3, r6)     // Catch: java.lang.Throwable -> L51
            throw r6     // Catch: java.lang.Throwable -> L51
        L64:
            if (r4 == 0) goto L69
            r4.close()
        L69:
            throw r6
        L6a:
            return r0
    }

    @Override // g2.c6
    public final g2.v3 d() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            java.lang.Object r0 = u1.f.h(r0)
            g2.h5 r0 = (g2.h5) r0
            g2.v3 r0 = r0.d()
            return r0
    }

    public final g2.t7 d0() {
            r1 = this;
            g2.t7 r0 = r1.f5210h
            R(r0)
            return r0
    }

    public final void e() {
            r9 = this;
            g2.e5 r0 = r9.f()
            r0.h()
            r9.g()
            boolean r0 = r9.f5216n
            if (r0 != 0) goto L12a
            r0 = 1
            r9.f5216n = r0
            boolean r1 = r9.E()
            if (r1 == 0) goto L12a
            java.nio.channels.FileChannel r1 = r9.f5225w
            g2.e5 r2 = r9.f()
            r2.h()
            java.lang.String r2 = "Bad channel to read from"
            r3 = 0
            r5 = 4
            r6 = 0
            if (r1 == 0) goto L69
            boolean r7 = r1.isOpen()
            if (r7 != 0) goto L2f
            goto L69
        L2f:
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r5)
            r1.position(r3)     // Catch: java.io.IOException -> L51
            int r1 = r1.read(r7)     // Catch: java.io.IOException -> L51
            if (r1 == r5) goto L53
            r7 = -1
            if (r1 == r7) goto L74
            g2.v3 r7 = r9.d()     // Catch: java.io.IOException -> L51
            g2.t3 r7 = r7.w()     // Catch: java.io.IOException -> L51
            java.lang.String r8 = "Unexpected data length. Bytes read"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.io.IOException -> L51
            r7.b(r8, r1)     // Catch: java.io.IOException -> L51
            goto L74
        L51:
            r1 = move-exception
            goto L5b
        L53:
            r7.flip()     // Catch: java.io.IOException -> L51
            int r6 = r7.getInt()     // Catch: java.io.IOException -> L51
            goto L74
        L5b:
            g2.v3 r7 = r9.d()
            g2.t3 r7 = r7.r()
            java.lang.String r8 = "Failed to read from channel"
            r7.b(r8, r1)
            goto L74
        L69:
            g2.v3 r1 = r9.d()
            g2.t3 r1 = r1.r()
            r1.a(r2)
        L74:
            g2.h5 r1 = r9.f5214l
            g2.m3 r1 = r1.B()
            int r1 = r1.p()
            g2.e5 r7 = r9.f()
            r7.h()
            if (r6 <= r1) goto L9d
            g2.v3 r0 = r9.d()
            g2.t3 r0 = r0.r()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Panic: can't downgrade version. Previous, current version"
            r0.c(r3, r2, r1)
            return
        L9d:
            if (r6 >= r1) goto L12a
            java.nio.channels.FileChannel r7 = r9.f5225w
            g2.e5 r8 = r9.f()
            r8.h()
            if (r7 == 0) goto L10a
            boolean r8 = r7.isOpen()
            if (r8 != 0) goto Lb1
            goto L10a
        Lb1:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            r2.putInt(r1)
            r2.flip()
            r7.truncate(r3)     // Catch: java.io.IOException -> Le4
            r7.write(r2)     // Catch: java.io.IOException -> Le4
            r7.force(r0)     // Catch: java.io.IOException -> Le4
            long r2 = r7.size()     // Catch: java.io.IOException -> Le4
            r4 = 4
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Le6
            g2.v3 r0 = r9.d()     // Catch: java.io.IOException -> Le4
            g2.t3 r0 = r0.r()     // Catch: java.io.IOException -> Le4
            java.lang.String r2 = "Error writing to channel. Bytes written"
            long r3 = r7.size()     // Catch: java.io.IOException -> Le4
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.io.IOException -> Le4
            r0.b(r2, r3)     // Catch: java.io.IOException -> Le4
            goto Le6
        Le4:
            r0 = move-exception
            goto Lfc
        Le6:
            g2.v3 r0 = r9.d()
            g2.t3 r0 = r0.v()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Storage version upgraded. Previous, current version"
            r0.c(r3, r2, r1)
            return
        Lfc:
            g2.v3 r2 = r9.d()
            g2.t3 r2 = r2.r()
            java.lang.String r3 = "Failed to write to channel"
            r2.b(r3, r0)
            goto L115
        L10a:
            g2.v3 r0 = r9.d()
            g2.t3 r0 = r0.r()
            r0.a(r2)
        L115:
            g2.v3 r0 = r9.d()
            g2.t3 r0 = r0.r()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Storage version upgrade failed. Previous, current version"
            r0.c(r3, r2, r1)
        L12a:
            return
    }

    public final g2.g9 e0() {
            r1 = this;
            g2.g9 r0 = r1.f5211i
            return r0
    }

    @Override // g2.c6
    public final g2.e5 f() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            java.lang.Object r0 = u1.f.h(r0)
            g2.h5 r0 = (g2.h5) r0
            g2.e5 r0 = r0.f()
            return r0
    }

    public final void g() {
            r2 = this;
            boolean r0 = r2.f5215m
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "UploadController is not initialized"
            r0.<init>(r1)
            throw r0
    }

    public final g2.ra g0() {
            r1 = this;
            g2.ra r0 = r1.f5209g
            R(r0)
            return r0
    }

    public final void h(java.lang.String r7, com.google.android.gms.internal.measurement.t4 r8) {
            r6 = this;
            g2.y4 r0 = r6.f5203a
            R(r0)
            java.util.Set r0 = r0.y(r7)
            if (r0 == 0) goto Le
            r8.v0(r0)
        Le:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r0 = r0.J(r7)
            if (r0 == 0) goto L1c
            r8.C0()
        L1c:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r0 = r0.M(r7)
            r1 = -1
            if (r0 == 0) goto L52
            g2.g r0 = r6.U()
            g2.h3 r2 = g2.i3.f4950t0
            boolean r0 = r0.B(r7, r2)
            if (r0 == 0) goto L4f
            java.lang.String r0 = r8.l0()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L52
            java.lang.String r2 = "."
            int r2 = r0.indexOf(r2)
            if (r2 == r1) goto L52
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)
            r8.Q(r0)
            goto L52
        L4f:
            r8.H0()
        L52:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r0 = r0.N(r7)
            if (r0 == 0) goto L68
            java.lang.String r0 = "_id"
            int r0 = g2.ra.x(r8, r0)
            if (r0 == r1) goto L68
            r8.t(r0)
        L68:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r0 = r0.L(r7)
            if (r0 == 0) goto L76
            r8.D0()
        L76:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r0 = r0.I(r7)
            if (r0 == 0) goto Lb7
            r8.A0()
            java.util.Map r0 = r6.B
            java.lang.Object r0 = r0.get(r7)
            g2.oa r0 = (g2.oa) r0
            if (r0 == 0) goto La7
            long r1 = r0.f5185b
            g2.g r3 = r6.U()
            g2.h3 r4 = g2.i3.V
            long r3 = r3.r(r7, r4)
            long r1 = r1 + r3
            x1.c r3 = r6.a()
            long r3 = r3.b()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lb2
        La7:
            g2.oa r0 = new g2.oa
            r1 = 0
            r0.<init>(r6, r1)
            java.util.Map r1 = r6.B
            r1.put(r7, r0)
        Lb2:
            java.lang.String r0 = r0.f5184a
            r8.J(r0)
        Lb7:
            g2.y4 r0 = r6.f5203a
            R(r0)
            boolean r7 = r0.K(r7)
            if (r7 == 0) goto Lc5
            r8.L0()
        Lc5:
            return
    }

    public final g2.wa h0() {
            r1 = this;
            g2.h5 r0 = r1.f5214l
            java.lang.Object r0 = u1.f.h(r0)
            g2.h5 r0 = (g2.h5) r0
            g2.wa r0 = r0.N()
            return r0
    }

    public final void i(g2.e6 r14) {
            r13 = this;
            g2.e5 r0 = r13.f()
            r0.h()
            java.lang.String r0 = r14.a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1b
            java.lang.String r0 = r14.j0()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1d
        L1b:
            r0 = r13
            goto L32
        L1d:
            java.lang.String r14 = r14.l0()
            java.lang.Object r14 = u1.f.h(r14)
            r1 = r14
            java.lang.String r1 = (java.lang.String) r1
            r4 = 0
            r5 = 0
            r2 = 204(0xcc, float:2.86E-43)
            r3 = 0
            r0 = r13
            r0.n(r1, r2, r3, r4, r5)
            return
        L32:
            g2.da r1 = r0.f5212j
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = r14.a()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L47
            java.lang.String r3 = r14.j0()
        L47:
            g2.h3 r4 = g2.i3.f4923g
            r5 = 0
            java.lang.Object r4 = r4.a(r5)
            java.lang.String r4 = (java.lang.String) r4
            android.net.Uri$Builder r4 = r2.scheme(r4)
            g2.h3 r6 = g2.i3.f4925h
            java.lang.Object r6 = r6.a(r5)
            java.lang.String r6 = (java.lang.String) r6
            android.net.Uri$Builder r4 = r4.encodedAuthority(r6)
            java.lang.String r6 = "config/app/"
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r6.concat(r3)
            android.net.Uri$Builder r3 = r4.path(r3)
            java.lang.String r4 = "platform"
            java.lang.String r6 = "android"
            android.net.Uri$Builder r3 = r3.appendQueryParameter(r4, r6)
            g2.h5 r1 = r1.f4646a
            g2.g r1 = r1.z()
            r1.q()
            r6 = 79000(0x13498, double:3.9031E-319)
            java.lang.String r1 = java.lang.String.valueOf(r6)
            java.lang.String r4 = "gmp_version"
            android.net.Uri$Builder r1 = r3.appendQueryParameter(r4, r1)
            java.lang.String r3 = "runtime_version"
            java.lang.String r4 = "0"
            r1.appendQueryParameter(r3, r4)
            android.net.Uri r1 = r2.build()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r14.l0()     // Catch: java.net.MalformedURLException -> L122
            java.lang.Object r2 = u1.f.h(r2)     // Catch: java.net.MalformedURLException -> L122
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.net.MalformedURLException -> L122
            java.net.URL r9 = new java.net.URL     // Catch: java.net.MalformedURLException -> L122
            r9.<init>(r1)     // Catch: java.net.MalformedURLException -> L122
            g2.v3 r2 = r13.d()     // Catch: java.net.MalformedURLException -> L122
            g2.t3 r2 = r2.v()     // Catch: java.net.MalformedURLException -> L122
            java.lang.String r3 = "Fetching remote configuration"
            r2.b(r3, r8)     // Catch: java.net.MalformedURLException -> L122
            g2.y4 r2 = r0.f5203a     // Catch: java.net.MalformedURLException -> L122
            R(r2)     // Catch: java.net.MalformedURLException -> L122
            com.google.android.gms.internal.measurement.v3 r2 = r2.t(r8)     // Catch: java.net.MalformedURLException -> L122
            g2.y4 r3 = r0.f5203a     // Catch: java.net.MalformedURLException -> L122
            R(r3)     // Catch: java.net.MalformedURLException -> L122
            java.lang.String r3 = r3.v(r8)     // Catch: java.net.MalformedURLException -> L122
            if (r2 == 0) goto Lf8
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.net.MalformedURLException -> L122
            if (r2 != 0) goto Ldc
            k.a r5 = new k.a     // Catch: java.net.MalformedURLException -> L122
            r5.<init>()     // Catch: java.net.MalformedURLException -> L122
            java.lang.String r2 = "If-Modified-Since"
            r5.put(r2, r3)     // Catch: java.net.MalformedURLException -> L122
        Ldc:
            g2.y4 r2 = r0.f5203a     // Catch: java.net.MalformedURLException -> L122
            R(r2)     // Catch: java.net.MalformedURLException -> L122
            java.lang.String r2 = r2.u(r8)     // Catch: java.net.MalformedURLException -> L122
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.net.MalformedURLException -> L122
            if (r3 != 0) goto Lf8
            if (r5 != 0) goto Lf3
            k.a r3 = new k.a     // Catch: java.net.MalformedURLException -> L122
            r3.<init>()     // Catch: java.net.MalformedURLException -> L122
            r5 = r3
        Lf3:
            java.lang.String r3 = "If-None-Match"
            r5.put(r3, r2)     // Catch: java.net.MalformedURLException -> L122
        Lf8:
            r11 = r5
            r2 = 1
            r0.f5221s = r2     // Catch: java.net.MalformedURLException -> L122
            g2.b4 r7 = r0.f5204b     // Catch: java.net.MalformedURLException -> L122
            R(r7)     // Catch: java.net.MalformedURLException -> L122
            g2.ga r12 = new g2.ga     // Catch: java.net.MalformedURLException -> L122
            r12.<init>(r13)     // Catch: java.net.MalformedURLException -> L122
            r7.h()     // Catch: java.net.MalformedURLException -> L122
            r7.i()     // Catch: java.net.MalformedURLException -> L122
            u1.f.h(r9)     // Catch: java.net.MalformedURLException -> L122
            u1.f.h(r12)     // Catch: java.net.MalformedURLException -> L122
            g2.h5 r2 = r7.f4646a     // Catch: java.net.MalformedURLException -> L122
            g2.e5 r2 = r2.f()     // Catch: java.net.MalformedURLException -> L122
            g2.a4 r6 = new g2.a4     // Catch: java.net.MalformedURLException -> L122
            r10 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: java.net.MalformedURLException -> L122
            r2.y(r6)     // Catch: java.net.MalformedURLException -> L122
            return
        L122:
            g2.v3 r2 = r13.d()
            g2.t3 r2 = r2.r()
            java.lang.String r14 = r14.l0()
            java.lang.Object r14 = g2.v3.z(r14)
            java.lang.String r3 = "Failed to parse config URL. Not fetching. appId"
            r2.c(r3, r14, r1)
            return
    }

    public final java.lang.String i0(g2.f6 r4) {
            r3 = this;
            com.google.android.gms.measurement.internal.zzha r0 = com.google.android.gms.measurement.internal.zzha.zzb
            boolean r4 = r4.j(r0)
            if (r4 == 0) goto L2b
            r4 = 16
            byte[] r4 = new byte[r4]
            g2.wa r0 = r3.h0()
            java.security.SecureRandom r0 = r0.u()
            r0.nextBytes(r4)
            java.util.Locale r0 = java.util.Locale.US
            java.math.BigInteger r1 = new java.math.BigInteger
            r2 = 1
            r1.<init>(r2, r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r2 = 0
            r4[r2] = r1
            java.lang.String r1 = "%032x"
            java.lang.String r4 = java.lang.String.format(r0, r1, r4)
            return r4
        L2b:
            r4 = 0
            return r4
    }

    public final void j(com.google.android.gms.measurement.internal.zzau r14, com.google.android.gms.measurement.internal.zzq r15) {
            r13 = this;
            u1.f.h(r15)
            java.lang.String r0 = r15.f3275c
            u1.f.d(r0)
            g2.e5 r0 = r13.f()
            r0.h()
            r13.g()
            java.lang.String r0 = r15.f3275c
            long r5 = r14.f3266n
            g2.w3 r14 = g2.w3.b(r14)
            g2.e5 r1 = r13.f()
            r1.h()
            g2.v7 r1 = r13.C
            r2 = 0
            if (r1 == 0) goto L33
            java.lang.String r1 = r13.D
            if (r1 == 0) goto L33
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L31
            goto L33
        L31:
            g2.v7 r2 = r13.C
        L33:
            android.os.Bundle r1 = r14.f5401d
            r3 = 0
            g2.wa.y(r2, r1, r3)
            com.google.android.gms.measurement.internal.zzau r14 = r14.a()
            g2.ra r1 = r13.f5209g
            R(r1)
            boolean r1 = g2.ra.n(r14, r15)
            if (r1 != 0) goto L49
            return
        L49:
            boolean r1 = r15.f3282r
            if (r1 != 0) goto L51
            r13.S(r15)
            return
        L51:
            java.util.List r1 = r15.D
            if (r1 == 0) goto L8e
            java.lang.String r2 = r14.f3263c
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L7c
            com.google.android.gms.measurement.internal.zzas r1 = r14.f3264e
            android.os.Bundle r1 = r1.g()
            java.lang.String r2 = "ga_safelisted"
            r3 = 1
            r1.putLong(r2, r3)
            com.google.android.gms.measurement.internal.zzau r7 = new com.google.android.gms.measurement.internal.zzau
            java.lang.String r8 = r14.f3263c
            com.google.android.gms.measurement.internal.zzas r9 = new com.google.android.gms.measurement.internal.zzas
            r9.<init>(r1)
            java.lang.String r10 = r14.f3265m
            long r11 = r14.f3266n
            r7.<init>(r8, r9, r10, r11)
            r14 = r7
            goto L8e
        L7c:
            g2.v3 r15 = r13.d()
            g2.t3 r15 = r15.q()
            java.lang.String r1 = r14.f3263c
            java.lang.String r14 = r14.f3265m
            java.lang.String r2 = "Dropping non-safelisted event. appId, event name, origin"
            r15.d(r2, r0, r1, r14)
            return
        L8e:
            g2.k r1 = r13.f5205c
            R(r1)
            r1.e0()
            g2.k r1 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r1)     // Catch: java.lang.Throwable -> Lc4
            u1.f.d(r0)     // Catch: java.lang.Throwable -> Lc4
            r1.h()     // Catch: java.lang.Throwable -> Lc4
            r1.i()     // Catch: java.lang.Throwable -> Lc4
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lc8
            g2.h5 r1 = r1.f4646a     // Catch: java.lang.Throwable -> Lc4
            g2.v3 r1 = r1.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r1 = r1.w()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = "Invalid time querying timed out conditional properties"
            java.lang.Object r7 = g2.v3.z(r0)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            r1.c(r4, r7, r8)     // Catch: java.lang.Throwable -> Lc4
            java.util.List r1 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Lc4
            goto Ld6
        Lc4:
            r0 = move-exception
            r14 = r0
            goto L2eb
        Lc8:
            java.lang.String r4 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String[] r7 = new java.lang.String[]{r0, r7}     // Catch: java.lang.Throwable -> Lc4
            java.util.List r1 = r1.b0(r4, r7)     // Catch: java.lang.Throwable -> Lc4
        Ld6:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Lc4
        Lda:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> Lc4
            if (r4 == 0) goto L124
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzac r4 = (com.google.android.gms.measurement.internal.zzac) r4     // Catch: java.lang.Throwable -> Lc4
            if (r4 == 0) goto Lda
            g2.v3 r7 = r13.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r7 = r7.v()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r8 = "User property timed out"
            java.lang.String r9 = r4.f3251c     // Catch: java.lang.Throwable -> Lc4
            g2.h5 r10 = r13.f5214l     // Catch: java.lang.Throwable -> Lc4
            g2.q3 r10 = r10.D()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r11 = r4.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r11 = r11.f3269e     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = r10.f(r11)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r11 = r4.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r11 = r11.c()     // Catch: java.lang.Throwable -> Lc4
            r7.d(r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r7 = r4.f3257q     // Catch: java.lang.Throwable -> Lc4
            if (r7 == 0) goto L117
            com.google.android.gms.measurement.internal.zzau r8 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc4
            r8.<init>(r7, r5)     // Catch: java.lang.Throwable -> Lc4
            r13.D(r8, r15)     // Catch: java.lang.Throwable -> Lc4
        L117:
            g2.k r7 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r7)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r4 = r4.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = r4.f3269e     // Catch: java.lang.Throwable -> Lc4
            r7.J(r0, r4)     // Catch: java.lang.Throwable -> Lc4
            goto Lda
        L124:
            g2.k r1 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r1)     // Catch: java.lang.Throwable -> Lc4
            u1.f.d(r0)     // Catch: java.lang.Throwable -> Lc4
            r1.h()     // Catch: java.lang.Throwable -> Lc4
            r1.i()     // Catch: java.lang.Throwable -> Lc4
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 >= 0) goto L150
            g2.h5 r1 = r1.f4646a     // Catch: java.lang.Throwable -> Lc4
            g2.v3 r1 = r1.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r1 = r1.w()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = "Invalid time querying expired conditional properties"
            java.lang.Object r7 = g2.v3.z(r0)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            r1.c(r4, r7, r8)     // Catch: java.lang.Throwable -> Lc4
            java.util.List r1 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Lc4
            goto L15e
        L150:
            java.lang.String r4 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String[] r7 = new java.lang.String[]{r0, r7}     // Catch: java.lang.Throwable -> Lc4
            java.util.List r1 = r1.b0(r4, r7)     // Catch: java.lang.Throwable -> Lc4
        L15e:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc4
            int r7 = r1.size()     // Catch: java.lang.Throwable -> Lc4
            r4.<init>(r7)     // Catch: java.lang.Throwable -> Lc4
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Lc4
        L16b:
            boolean r7 = r1.hasNext()     // Catch: java.lang.Throwable -> Lc4
            if (r7 == 0) goto L1bc
            java.lang.Object r7 = r1.next()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzac r7 = (com.google.android.gms.measurement.internal.zzac) r7     // Catch: java.lang.Throwable -> Lc4
            if (r7 == 0) goto L16b
            g2.v3 r8 = r13.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r8 = r8.v()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r9 = "User property expired"
            java.lang.String r10 = r7.f3251c     // Catch: java.lang.Throwable -> Lc4
            g2.h5 r11 = r13.f5214l     // Catch: java.lang.Throwable -> Lc4
            g2.q3 r11 = r11.D()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r12 = r7.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r12 = r12.f3269e     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r11 = r11.f(r12)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r12 = r7.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r12 = r12.c()     // Catch: java.lang.Throwable -> Lc4
            r8.d(r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lc4
            g2.k r8 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r8)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r9 = r7.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r9 = r9.f3269e     // Catch: java.lang.Throwable -> Lc4
            r8.m(r0, r9)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r8 = r7.f3261u     // Catch: java.lang.Throwable -> Lc4
            if (r8 == 0) goto L1af
            r4.add(r8)     // Catch: java.lang.Throwable -> Lc4
        L1af:
            g2.k r8 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r8)     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzlk r7 = r7.f3253m     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r7 = r7.f3269e     // Catch: java.lang.Throwable -> Lc4
            r8.J(r0, r7)     // Catch: java.lang.Throwable -> Lc4
            goto L16b
        L1bc:
            java.util.Iterator r1 = r4.iterator()     // Catch: java.lang.Throwable -> Lc4
        L1c0:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> Lc4
            if (r4 == 0) goto L1d5
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r4 = (com.google.android.gms.measurement.internal.zzau) r4     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r7 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc4
            r7.<init>(r4, r5)     // Catch: java.lang.Throwable -> Lc4
            r13.D(r7, r15)     // Catch: java.lang.Throwable -> Lc4
            goto L1c0
        L1d5:
            g2.k r1 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = r14.f3263c     // Catch: java.lang.Throwable -> Lc4
            u1.f.d(r0)     // Catch: java.lang.Throwable -> Lc4
            u1.f.d(r4)     // Catch: java.lang.Throwable -> Lc4
            r1.h()     // Catch: java.lang.Throwable -> Lc4
            r1.i()     // Catch: java.lang.Throwable -> Lc4
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 >= 0) goto L210
            g2.h5 r2 = r1.f4646a     // Catch: java.lang.Throwable -> Lc4
            g2.v3 r2 = r2.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r2 = r2.w()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = "Invalid time querying triggered conditional properties"
            java.lang.Object r0 = g2.v3.z(r0)     // Catch: java.lang.Throwable -> Lc4
            g2.h5 r1 = r1.f4646a     // Catch: java.lang.Throwable -> Lc4
            g2.q3 r1 = r1.D()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = r1.d(r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Long r4 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            r2.d(r3, r0, r1, r4)     // Catch: java.lang.Throwable -> Lc4
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Lc4
            goto L21e
        L210:
            java.lang.String r2 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String[] r0 = new java.lang.String[]{r0, r4, r3}     // Catch: java.lang.Throwable -> Lc4
            java.util.List r0 = r1.b0(r2, r0)     // Catch: java.lang.Throwable -> Lc4
        L21e:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc4
            int r1 = r0.size()     // Catch: java.lang.Throwable -> Lc4
            r8.<init>(r1)     // Catch: java.lang.Throwable -> Lc4
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lc4
        L22b:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto L2be
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> Lc4
            r9 = r1
            com.google.android.gms.measurement.internal.zzac r9 = (com.google.android.gms.measurement.internal.zzac) r9     // Catch: java.lang.Throwable -> Lc4
            if (r9 == 0) goto L22b
            com.google.android.gms.measurement.internal.zzlk r1 = r9.f3253m     // Catch: java.lang.Throwable -> Lc4
            r2 = r1
            g2.ta r1 = new g2.ta     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = r9.f3251c     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r3 = u1.f.h(r3)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lc4
            r4 = r2
            r2 = r3
            java.lang.String r3 = r9.f3252e     // Catch: java.lang.Throwable -> Lc4
            r7 = r4
            java.lang.String r4 = r7.f3269e     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r7 = r7.c()     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r7 = u1.f.h(r7)     // Catch: java.lang.Throwable -> Lc4
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> Lc4
            g2.k r2 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r2)     // Catch: java.lang.Throwable -> Lc4
            boolean r2 = r2.x(r1)     // Catch: java.lang.Throwable -> Lc4
            if (r2 == 0) goto L282
            g2.v3 r2 = r13.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r2 = r2.v()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = "User property triggered"
            java.lang.String r4 = r9.f3251c     // Catch: java.lang.Throwable -> Lc4
            g2.h5 r7 = r13.f5214l     // Catch: java.lang.Throwable -> Lc4
            g2.q3 r7 = r7.D()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = r1.f5332c     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r7 = r7.f(r10)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r10 = r1.f5334e     // Catch: java.lang.Throwable -> Lc4
            r2.d(r3, r4, r7, r10)     // Catch: java.lang.Throwable -> Lc4
            goto L2a3
        L282:
            g2.v3 r2 = r13.d()     // Catch: java.lang.Throwable -> Lc4
            g2.t3 r2 = r2.r()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = "Too many active user properties, ignoring"
            java.lang.String r4 = r9.f3251c     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> Lc4
            g2.h5 r7 = r13.f5214l     // Catch: java.lang.Throwable -> Lc4
            g2.q3 r7 = r7.D()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = r1.f5332c     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r7 = r7.f(r10)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r10 = r1.f5334e     // Catch: java.lang.Throwable -> Lc4
            r2.d(r3, r4, r7, r10)     // Catch: java.lang.Throwable -> Lc4
        L2a3:
            com.google.android.gms.measurement.internal.zzau r2 = r9.f3259s     // Catch: java.lang.Throwable -> Lc4
            if (r2 == 0) goto L2aa
            r8.add(r2)     // Catch: java.lang.Throwable -> Lc4
        L2aa:
            com.google.android.gms.measurement.internal.zzlk r2 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> Lc4
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Lc4
            r9.f3253m = r2     // Catch: java.lang.Throwable -> Lc4
            r1 = 1
            r9.f3255o = r1     // Catch: java.lang.Throwable -> Lc4
            g2.k r1 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r1)     // Catch: java.lang.Throwable -> Lc4
            r1.w(r9)     // Catch: java.lang.Throwable -> Lc4
            goto L22b
        L2be:
            r13.D(r14, r15)     // Catch: java.lang.Throwable -> Lc4
            java.util.Iterator r14 = r8.iterator()     // Catch: java.lang.Throwable -> Lc4
        L2c5:
            boolean r0 = r14.hasNext()     // Catch: java.lang.Throwable -> Lc4
            if (r0 == 0) goto L2da
            java.lang.Object r0 = r14.next()     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r0 = (com.google.android.gms.measurement.internal.zzau) r0     // Catch: java.lang.Throwable -> Lc4
            com.google.android.gms.measurement.internal.zzau r1 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc4
            r1.<init>(r0, r5)     // Catch: java.lang.Throwable -> Lc4
            r13.D(r1, r15)     // Catch: java.lang.Throwable -> Lc4
            goto L2c5
        L2da:
            g2.k r14 = r13.f5205c     // Catch: java.lang.Throwable -> Lc4
            R(r14)     // Catch: java.lang.Throwable -> Lc4
            r14.o()     // Catch: java.lang.Throwable -> Lc4
            g2.k r14 = r13.f5205c
            R(r14)
            r14.f0()
            return
        L2eb:
            g2.k r15 = r13.f5205c
            R(r15)
            r15.f0()
            goto L2f5
        L2f4:
            throw r14
        L2f5:
            goto L2f4
    }

    public final java.lang.String j0(com.google.android.gms.measurement.internal.zzq r5) {
            r4 = this;
            g2.e5 r0 = r4.f()
            g2.ia r1 = new g2.ia
            r1.<init>(r4, r5)
            java.util.concurrent.Future r0 = r0.s(r1)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.ExecutionException -> L18 java.lang.InterruptedException -> L1a java.util.concurrent.TimeoutException -> L1c
            r2 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r0 = r0.get(r2, r1)     // Catch: java.util.concurrent.ExecutionException -> L18 java.lang.InterruptedException -> L1a java.util.concurrent.TimeoutException -> L1c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.util.concurrent.ExecutionException -> L18 java.lang.InterruptedException -> L1a java.util.concurrent.TimeoutException -> L1c
            return r0
        L18:
            r0 = move-exception
            goto L1d
        L1a:
            r0 = move-exception
            goto L1d
        L1c:
            r0 = move-exception
        L1d:
            g2.v3 r1 = r4.d()
            g2.t3 r1 = r1.r()
            java.lang.String r5 = r5.f3275c
            java.lang.Object r5 = g2.v3.z(r5)
            java.lang.String r2 = "Failed to get app instance id. appId"
            r1.c(r2, r5, r0)
            r5 = 0
            return r5
    }

    public final void k(com.google.android.gms.measurement.internal.zzau r37, java.lang.String r38) {
            r36 = this;
            r0 = r36
            r1 = r37
            r3 = r38
            g2.k r2 = r0.f5205c
            R(r2)
            g2.e6 r2 = r2.R(r3)
            if (r2 == 0) goto Lbe
            java.lang.String r4 = r2.o0()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L1d
            goto Lbe
        L1d:
            java.lang.Boolean r4 = r0.J(r2)
            if (r4 != 0) goto L40
            java.lang.String r4 = r1.f3263c
            java.lang.String r5 = "_ui"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L3e
            g2.v3 r4 = r0.d()
            g2.t3 r4 = r4.w()
            java.lang.Object r5 = g2.v3.z(r3)
            java.lang.String r6 = "Could not find package. appId"
            r4.b(r6, r5)
        L3e:
            r4 = r2
            goto L58
        L40:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L3e
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.r()
            java.lang.Object r2 = g2.v3.z(r3)
            java.lang.String r3 = "App version does not match; dropping event. appId"
            r1.b(r3, r2)
            return
        L58:
            com.google.android.gms.measurement.internal.zzq r2 = new com.google.android.gms.measurement.internal.zzq
            r5 = r4
            java.lang.String r4 = r5.a()
            r6 = r5
            java.lang.String r5 = r6.o0()
            r8 = r6
            long r6 = r8.R()
            r9 = r8
            java.lang.String r8 = r9.n0()
            r11 = r9
            long r9 = r11.c0()
            r13 = r11
            long r11 = r13.Z()
            boolean r14 = r13.O()
            java.lang.String r16 = r13.p0()
            r13.A()
            boolean r22 = r13.N()
            java.lang.String r24 = r13.j0()
            java.lang.Boolean r25 = r13.i0()
            long r26 = r13.a0()
            java.util.List r28 = r13.e()
            g2.f6 r15 = r0.c0(r3)
            java.lang.String r30 = r15.i()
            boolean r33 = r13.Q()
            long r34 = r13.h0()
            java.lang.String r31 = ""
            r32 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r29 = 0
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34)
            r0.l(r1, r2)
            return
        Lbe:
            g2.v3 r1 = r0.d()
            g2.t3 r1 = r1.q()
            java.lang.String r2 = "No app data available; dropping event"
            r1.b(r2, r3)
            return
    }

    public final void l(com.google.android.gms.measurement.internal.zzau r9, com.google.android.gms.measurement.internal.zzq r10) {
            r8 = this;
            java.lang.String r0 = r10.f3275c
            u1.f.d(r0)
            g2.w3 r9 = g2.w3.b(r9)
            g2.wa r0 = r8.h0()
            android.os.Bundle r1 = r9.f5401d
            g2.k r2 = r8.f5205c
            R(r2)
            java.lang.String r3 = r10.f3275c
            android.os.Bundle r2 = r2.Q(r3)
            r0.z(r1, r2)
            g2.wa r0 = r8.h0()
            g2.g r1 = r8.U()
            java.lang.String r2 = r10.f3275c
            int r1 = r1.n(r2)
            r0.B(r9, r1)
            com.google.android.gms.measurement.internal.zzau r9 = r9.a()
            java.lang.String r0 = r9.f3263c
            java.lang.String r1 = "_cmp"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L3d
            goto L69
        L3d:
            com.google.android.gms.measurement.internal.zzas r0 = r9.f3264e
            java.lang.String r1 = "_cis"
            java.lang.String r0 = r0.o(r1)
            java.lang.String r1 = "referrer API v2"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L69
            com.google.android.gms.measurement.internal.zzas r0 = r9.f3264e
            java.lang.String r1 = "gclid"
            java.lang.String r6 = r0.o(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L69
            com.google.android.gms.measurement.internal.zzlk r2 = new com.google.android.gms.measurement.internal.zzlk
            long r4 = r9.f3266n
            java.lang.String r7 = "auto"
            java.lang.String r3 = "_lgclid"
            r2.<init>(r3, r4, r6, r7)
            r8.B(r2, r10)
        L69:
            r8.j(r9, r10)
            return
    }

    public final void l0(java.lang.Runnable r2) {
            r1 = this;
            g2.e5 r0 = r1.f()
            r0.h()
            java.util.List r0 = r1.f5218p
            if (r0 != 0) goto L12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.f5218p = r0
        L12:
            java.util.List r0 = r1.f5218p
            r0.add(r2)
            return
    }

    public final void m() {
            r1 = this;
            int r0 = r1.f5220r
            int r0 = r0 + 1
            r1.f5220r = r0
            return
    }

    public final void n(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
            r7 = this;
            g2.e5 r0 = r7.f()
            r0.h()
            r7.g()
            u1.f.d(r8)
            r0 = 0
            if (r11 != 0) goto L16
            byte[] r11 = new byte[r0]     // Catch: java.lang.Throwable -> L13
            goto L16
        L13:
            r8 = move-exception
            goto L188
        L16:
            g2.v3 r1 = r7.d()     // Catch: java.lang.Throwable -> L13
            g2.t3 r1 = r1.v()     // Catch: java.lang.Throwable -> L13
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r11.length     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L13
            r1.b(r2, r3)     // Catch: java.lang.Throwable -> L13
            g2.k r1 = r7.f5205c     // Catch: java.lang.Throwable -> L13
            R(r1)     // Catch: java.lang.Throwable -> L13
            r1.e0()     // Catch: java.lang.Throwable -> L13
            g2.k r1 = r7.f5205c     // Catch: java.lang.Throwable -> L62
            R(r1)     // Catch: java.lang.Throwable -> L62
            g2.e6 r1 = r1.R(r8)     // Catch: java.lang.Throwable -> L62
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r9 == r2) goto L4a
            r2 = 204(0xcc, float:2.86E-43)
            if (r9 == r2) goto L4a
            if (r9 != r4) goto L48
            r9 = 304(0x130, float:4.26E-43)
            goto L4a
        L48:
            r2 = 0
            goto L4d
        L4a:
            if (r10 != 0) goto L48
            r2 = 1
        L4d:
            if (r1 != 0) goto L65
            g2.v3 r9 = r7.d()     // Catch: java.lang.Throwable -> L62
            g2.t3 r9 = r9.w()     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r8 = g2.v3.z(r8)     // Catch: java.lang.Throwable -> L62
            r9.b(r10, r8)     // Catch: java.lang.Throwable -> L62
            goto L169
        L62:
            r8 = move-exception
            goto L17f
        L65:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto Lc3
            if (r9 != r5) goto L6c
            goto Lc3
        L6c:
            x1.c r11 = r7.a()     // Catch: java.lang.Throwable -> L62
            long r11 = r11.a()     // Catch: java.lang.Throwable -> L62
            r1.w(r11)     // Catch: java.lang.Throwable -> L62
            g2.k r11 = r7.f5205c     // Catch: java.lang.Throwable -> L62
            R(r11)     // Catch: java.lang.Throwable -> L62
            r11.p(r1)     // Catch: java.lang.Throwable -> L62
            g2.v3 r11 = r7.d()     // Catch: java.lang.Throwable -> L62
            g2.t3 r11 = r11.v()     // Catch: java.lang.Throwable -> L62
            java.lang.String r12 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L62
            r11.c(r12, r1, r10)     // Catch: java.lang.Throwable -> L62
            g2.y4 r10 = r7.f5203a     // Catch: java.lang.Throwable -> L62
            R(r10)     // Catch: java.lang.Throwable -> L62
            r10.z(r8)     // Catch: java.lang.Throwable -> L62
            g2.g9 r8 = r7.f5211i     // Catch: java.lang.Throwable -> L62
            g2.h4 r8 = r8.f4836h     // Catch: java.lang.Throwable -> L62
            x1.c r10 = r7.a()     // Catch: java.lang.Throwable -> L62
            long r10 = r10.a()     // Catch: java.lang.Throwable -> L62
            r8.b(r10)     // Catch: java.lang.Throwable -> L62
            r8 = 503(0x1f7, float:7.05E-43)
            if (r9 == r8) goto Laf
            r8 = 429(0x1ad, float:6.01E-43)
            if (r9 != r8) goto Lbe
        Laf:
            g2.g9 r8 = r7.f5211i     // Catch: java.lang.Throwable -> L62
            g2.h4 r8 = r8.f4834f     // Catch: java.lang.Throwable -> L62
            x1.c r9 = r7.a()     // Catch: java.lang.Throwable -> L62
            long r9 = r9.a()     // Catch: java.lang.Throwable -> L62
            r8.b(r9)     // Catch: java.lang.Throwable -> L62
        Lbe:
            r7.M()     // Catch: java.lang.Throwable -> L62
            goto L169
        Lc3:
            r10 = 0
            if (r12 == 0) goto Lcf
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r12.get(r2)     // Catch: java.lang.Throwable -> L62
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L62
            goto Ld0
        Lcf:
            r2 = r10
        Ld0:
            if (r2 == 0) goto Ldf
            boolean r6 = r2.isEmpty()     // Catch: java.lang.Throwable -> L62
            if (r6 != 0) goto Ldf
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L62
            goto Le0
        Ldf:
            r2 = r10
        Le0:
            if (r12 == 0) goto Leb
            java.lang.String r6 = "ETag"
            java.lang.Object r12 = r12.get(r6)     // Catch: java.lang.Throwable -> L62
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L62
            goto Lec
        Leb:
            r12 = r10
        Lec:
            if (r12 == 0) goto Lfb
            boolean r6 = r12.isEmpty()     // Catch: java.lang.Throwable -> L62
            if (r6 != 0) goto Lfb
            java.lang.Object r12 = r12.get(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L62
            goto Lfc
        Lfb:
            r12 = r10
        Lfc:
            if (r9 == r5) goto L10a
            if (r9 != r4) goto L101
            goto L10a
        L101:
            g2.y4 r10 = r7.f5203a     // Catch: java.lang.Throwable -> L62
            R(r10)     // Catch: java.lang.Throwable -> L62
            r10.H(r8, r11, r2, r12)     // Catch: java.lang.Throwable -> L62
            goto L11d
        L10a:
            g2.y4 r11 = r7.f5203a     // Catch: java.lang.Throwable -> L62
            R(r11)     // Catch: java.lang.Throwable -> L62
            com.google.android.gms.internal.measurement.v3 r11 = r11.t(r8)     // Catch: java.lang.Throwable -> L62
            if (r11 != 0) goto L11d
            g2.y4 r11 = r7.f5203a     // Catch: java.lang.Throwable -> L62
            R(r11)     // Catch: java.lang.Throwable -> L62
            r11.H(r8, r10, r10, r10)     // Catch: java.lang.Throwable -> L62
        L11d:
            x1.c r10 = r7.a()     // Catch: java.lang.Throwable -> L62
            long r10 = r10.a()     // Catch: java.lang.Throwable -> L62
            r1.n(r10)     // Catch: java.lang.Throwable -> L62
            g2.k r10 = r7.f5205c     // Catch: java.lang.Throwable -> L62
            R(r10)     // Catch: java.lang.Throwable -> L62
            r10.p(r1)     // Catch: java.lang.Throwable -> L62
            if (r9 != r5) goto L140
            g2.v3 r9 = r7.d()     // Catch: java.lang.Throwable -> L62
            g2.t3 r9 = r9.x()     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = "Config not found. Using empty config. appId"
            r9.b(r10, r8)     // Catch: java.lang.Throwable -> L62
            goto L151
        L140:
            g2.v3 r8 = r7.d()     // Catch: java.lang.Throwable -> L62
            g2.t3 r8 = r8.v()     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L62
            r8.c(r10, r9, r3)     // Catch: java.lang.Throwable -> L62
        L151:
            g2.b4 r8 = r7.f5204b     // Catch: java.lang.Throwable -> L62
            R(r8)     // Catch: java.lang.Throwable -> L62
            boolean r8 = r8.m()     // Catch: java.lang.Throwable -> L62
            if (r8 == 0) goto L166
            boolean r8 = r7.O()     // Catch: java.lang.Throwable -> L62
            if (r8 == 0) goto L166
            r7.C()     // Catch: java.lang.Throwable -> L62
            goto L169
        L166:
            r7.M()     // Catch: java.lang.Throwable -> L62
        L169:
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> L62
            R(r8)     // Catch: java.lang.Throwable -> L62
            r8.o()     // Catch: java.lang.Throwable -> L62
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> L13
            R(r8)     // Catch: java.lang.Throwable -> L13
            r8.f0()     // Catch: java.lang.Throwable -> L13
            r7.f5221s = r0
            r7.K()
            return
        L17f:
            g2.k r9 = r7.f5205c     // Catch: java.lang.Throwable -> L13
            R(r9)     // Catch: java.lang.Throwable -> L13
            r9.f0()     // Catch: java.lang.Throwable -> L13
            throw r8     // Catch: java.lang.Throwable -> L13
        L188:
            r7.f5221s = r0
            r7.K()
            goto L18f
        L18e:
            throw r8
        L18f:
            goto L18e
    }

    public final void o(boolean r1) {
            r0 = this;
            r0.M()
            return
    }

    public final void p(int r8, java.lang.Throwable r9, byte[] r10, java.lang.String r11) {
            r7 = this;
            g2.e5 r11 = r7.f()
            r11.h()
            r7.g()
            r11 = 0
            if (r10 != 0) goto L13
            byte[] r10 = new byte[r11]     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r8 = move-exception
            goto L171
        L13:
            java.util.List r0 = r7.f5226x     // Catch: java.lang.Throwable -> L10
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L10
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L10
            r1 = 0
            r7.f5226x = r1     // Catch: java.lang.Throwable -> L10
            r2 = 200(0xc8, float:2.8E-43)
            if (r8 == r2) goto L28
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 != r2) goto L129
            r8 = 204(0xcc, float:2.86E-43)
        L28:
            if (r9 != 0) goto L129
            g2.g9 r9 = r7.f5211i     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.h4 r9 = r9.f4835g     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            x1.c r2 = r7.a()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            long r2 = r2.a()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r9.b(r2)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.g9 r9 = r7.f5211i     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.h4 r9 = r9.f4836h     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r2 = 0
            r9.b(r2)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r7.M()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.v3 r9 = r7.d()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.t3 r9 = r9.v()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            java.lang.String r4 = "Successful upload. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            int r10 = r10.length     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r9.c(r4, r8, r10)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            R(r8)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r8.e0()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            java.util.Iterator r8 = r0.iterator()     // Catch: java.lang.Throwable -> La2
        L67:
            boolean r9 = r8.hasNext()     // Catch: java.lang.Throwable -> La2
            if (r9 == 0) goto Lc2
            java.lang.Object r9 = r8.next()     // Catch: java.lang.Throwable -> La2
            java.lang.Long r9 = (java.lang.Long) r9     // Catch: java.lang.Throwable -> La2
            g2.k r10 = r7.f5205c     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            R(r10)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            long r4 = r9.longValue()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            r10.h()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            r10.i()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            android.database.sqlite.SQLiteDatabase r0 = r10.P()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String r5 = "queue"
            java.lang.String r6 = "rowid=?"
            int r0 = r0.delete(r5, r6, r4)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            r4 = 1
            if (r0 != r4) goto L9a
            goto L67
        L9a:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            java.lang.String r4 = "Deleted fewer rows from queue than expected"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
            throw r0     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> La4
        La2:
            r8 = move-exception
            goto Lf5
        La4:
            r0 = move-exception
            g2.h5 r10 = r10.f4646a     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            g2.v3 r10 = r10.d()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            g2.t3 r10 = r10.r()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String r4 = "Failed to delete a bundle in a queue table"
            r10.b(r4, r0)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
            throw r0     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteException -> Lb5
        Lb5:
            r10 = move-exception
            java.util.List r0 = r7.f5227y     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto Lc1
            boolean r9 = r0.contains(r9)     // Catch: java.lang.Throwable -> La2
            if (r9 == 0) goto Lc1
            goto L67
        Lc1:
            throw r10     // Catch: java.lang.Throwable -> La2
        Lc2:
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> La2
            R(r8)     // Catch: java.lang.Throwable -> La2
            r8.o()     // Catch: java.lang.Throwable -> La2
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            R(r8)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r8.f0()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r7.f5227y = r1     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            g2.b4 r8 = r7.f5204b     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            R(r8)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            boolean r8 = r8.m()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            if (r8 == 0) goto Leb
            boolean r8 = r7.O()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            if (r8 == 0) goto Leb
            r7.C()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            goto Lf2
        Le9:
            r8 = move-exception
            goto Lfe
        Leb:
            r8 = -1
            r7.f5228z = r8     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r7.M()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
        Lf2:
            r7.f5217o = r2     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            goto L16b
        Lf5:
            g2.k r9 = r7.f5205c     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            R(r9)     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            r9.f0()     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
            throw r8     // Catch: java.lang.Throwable -> L10 android.database.sqlite.SQLiteException -> Le9
        Lfe:
            g2.v3 r9 = r7.d()     // Catch: java.lang.Throwable -> L10
            g2.t3 r9 = r9.r()     // Catch: java.lang.Throwable -> L10
            java.lang.String r10 = "Database error while trying to delete uploaded bundles"
            r9.b(r10, r8)     // Catch: java.lang.Throwable -> L10
            x1.c r8 = r7.a()     // Catch: java.lang.Throwable -> L10
            long r8 = r8.b()     // Catch: java.lang.Throwable -> L10
            r7.f5217o = r8     // Catch: java.lang.Throwable -> L10
            g2.v3 r8 = r7.d()     // Catch: java.lang.Throwable -> L10
            g2.t3 r8 = r8.v()     // Catch: java.lang.Throwable -> L10
            java.lang.String r9 = "Disable upload, time"
            long r0 = r7.f5217o     // Catch: java.lang.Throwable -> L10
            java.lang.Long r10 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L10
            r8.b(r9, r10)     // Catch: java.lang.Throwable -> L10
            goto L16b
        L129:
            g2.v3 r10 = r7.d()     // Catch: java.lang.Throwable -> L10
            g2.t3 r10 = r10.v()     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = "Network upload failed. Will retry later. code, error"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L10
            r10.c(r1, r2, r9)     // Catch: java.lang.Throwable -> L10
            g2.g9 r9 = r7.f5211i     // Catch: java.lang.Throwable -> L10
            g2.h4 r9 = r9.f4836h     // Catch: java.lang.Throwable -> L10
            x1.c r10 = r7.a()     // Catch: java.lang.Throwable -> L10
            long r1 = r10.a()     // Catch: java.lang.Throwable -> L10
            r9.b(r1)     // Catch: java.lang.Throwable -> L10
            r9 = 503(0x1f7, float:7.05E-43)
            if (r8 == r9) goto L151
            r9 = 429(0x1ad, float:6.01E-43)
            if (r8 != r9) goto L160
        L151:
            g2.g9 r8 = r7.f5211i     // Catch: java.lang.Throwable -> L10
            g2.h4 r8 = r8.f4834f     // Catch: java.lang.Throwable -> L10
            x1.c r9 = r7.a()     // Catch: java.lang.Throwable -> L10
            long r9 = r9.a()     // Catch: java.lang.Throwable -> L10
            r8.b(r9)     // Catch: java.lang.Throwable -> L10
        L160:
            g2.k r8 = r7.f5205c     // Catch: java.lang.Throwable -> L10
            R(r8)     // Catch: java.lang.Throwable -> L10
            r8.g0(r0)     // Catch: java.lang.Throwable -> L10
            r7.M()     // Catch: java.lang.Throwable -> L10
        L16b:
            r7.f5222t = r11
            r7.K()
            return
        L171:
            r7.f5222t = r11
            r7.K()
            goto L178
        L177:
            throw r8
        L178:
            goto L177
    }

    public final void q(com.google.android.gms.measurement.internal.zzq r27) {
            r26 = this;
            r1 = r26
            r2 = r27
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "com.android.vending"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            g2.e5 r9 = r1.f()
            r9.h()
            r1.g()
            u1.f.h(r2)
            java.lang.String r9 = r2.f3275c
            u1.f.d(r9)
            boolean r9 = Q(r2)
            if (r9 == 0) goto L566
            g2.k r9 = r1.f5205c
            R(r9)
            java.lang.String r10 = r2.f3275c
            g2.e6 r9 = r9.R(r10)
            r10 = 0
            if (r9 == 0) goto L60
            java.lang.String r12 = r9.a()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L60
            java.lang.String r12 = r2.f3276e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L60
            r9.n(r10)
            g2.k r12 = r1.f5205c
            R(r12)
            r12.p(r9)
            g2.y4 r9 = r1.f5203a
            R(r9)
            java.lang.String r12 = r2.f3275c
            r9.A(r12)
        L60:
            boolean r9 = r2.f3282r
            if (r9 != 0) goto L68
            r26.S(r27)
            return
        L68:
            long r12 = r2.f3287w
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 != 0) goto L76
            x1.c r9 = r1.a()
            long r12 = r9.a()
        L76:
            r16 = r12
            g2.h5 r9 = r1.f5214l
            g2.o r9 = r9.A()
            r9.r()
            int r9 = r2.f3288x
            r12 = 1
            if (r9 == 0) goto La0
            if (r9 == r12) goto La0
            g2.v3 r14 = r1.d()
            g2.t3 r14 = r14.w()
            java.lang.String r15 = r2.f3275c
            java.lang.Object r15 = g2.v3.z(r15)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "Incorrect app type, assuming installed app. appId, appType"
            r14.c(r10, r15, r9)
            r9 = 0
        La0:
            g2.k r10 = r1.f5205c
            R(r10)
            r10.e0()
            g2.k r10 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r11 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            g2.ta r10 = r10.X(r11, r0)     // Catch: java.lang.Throwable -> Lc3
            if (r10 == 0) goto Lc6
            java.lang.String r11 = "auto"
            java.lang.String r14 = r10.f5331b     // Catch: java.lang.Throwable -> Lc3
            boolean r11 = r11.equals(r14)     // Catch: java.lang.Throwable -> Lc3
            if (r11 == 0) goto Lc0
            goto Lc6
        Lc0:
            r12 = 1
            goto L101
        Lc3:
            r0 = move-exception
            goto L55d
        Lc6:
            java.lang.Boolean r11 = r2.B     // Catch: java.lang.Throwable -> Lc3
            if (r11 == 0) goto Lfa
            com.google.android.gms.measurement.internal.zzlk r14 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_npa"
            java.lang.Boolean r0 = r2.B     // Catch: java.lang.Throwable -> Lc3
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> Lc3
            if (r12 == r0) goto Ld9
            r22 = 0
            goto Ldb
        Ld9:
            r22 = 1
        Ldb:
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch: java.lang.Throwable -> Lc3
            r22 = 1
            java.lang.String r19 = "auto"
            r18 = r0
            r12 = r22
            r14.<init>(r15, r16, r18, r19)     // Catch: java.lang.Throwable -> Lc3
            if (r10 == 0) goto Lf6
            java.lang.Object r0 = r10.f5334e     // Catch: java.lang.Throwable -> Lc3
            java.lang.Long r10 = r14.f3271n     // Catch: java.lang.Throwable -> Lc3
            boolean r0 = r0.equals(r10)     // Catch: java.lang.Throwable -> Lc3
            if (r0 != 0) goto L101
        Lf6:
            r1.B(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            goto L101
        Lfa:
            r12 = 1
            if (r10 == 0) goto L101
            r1.u(r0, r2)     // Catch: java.lang.Throwable -> Lc3
        L101:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r0)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r10 = u1.f.h(r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> Lc3
            g2.e6 r0 = r0.R(r10)     // Catch: java.lang.Throwable -> Lc3
            r10 = 0
            if (r0 == 0) goto L1ef
            g2.wa r14 = r1.h0()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = r2.f3276e     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r11 = r0.a()     // Catch: java.lang.Throwable -> Lc3
            r24 = r12
            java.lang.String r12 = r2.A     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r13 = r0.j0()     // Catch: java.lang.Throwable -> Lc3
            boolean r11 = r14.d0(r15, r11, r12, r13)     // Catch: java.lang.Throwable -> Lc3
            if (r11 == 0) goto L1ec
            g2.v3 r11 = r1.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r11 = r11.w()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r0.l0()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r13 = g2.v3.z(r13)     // Catch: java.lang.Throwable -> Lc3
            r11.b(r12, r13)     // Catch: java.lang.Throwable -> Lc3
            g2.k r11 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r11)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r12 = r0.l0()     // Catch: java.lang.Throwable -> Lc3
            r11.i()     // Catch: java.lang.Throwable -> Lc3
            r11.h()     // Catch: java.lang.Throwable -> Lc3
            u1.f.d(r12)     // Catch: java.lang.Throwable -> Lc3
            android.database.sqlite.SQLiteDatabase r0 = r11.P()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            java.lang.String[] r13 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            java.lang.String r14 = "events"
            int r14 = r0.delete(r14, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            java.lang.String r15 = "user_attributes"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r0.delete(r15, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            int r14 = r14 + r15
            com.google.android.gms.internal.measurement.pc.b()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            g2.h5 r15 = r11.f4646a     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            g2.g r15 = r15.z()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1d5
            r23 = r9
            g2.h3 r9 = g2.i3.f4954v0     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            boolean r9 = r15.B(r10, r9)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            if (r9 == 0) goto L1be
            java.lang.String r9 = "default_event_params"
            int r0 = r0.delete(r9, r8, r13)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            int r14 = r14 + r0
            goto L1be
        L1bc:
            r0 = move-exception
            goto L1d8
        L1be:
            if (r14 <= 0) goto L1d3
            g2.h5 r0 = r11.f4646a     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            g2.t3 r0 = r0.v()     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
            r0.c(r8, r12, r9)     // Catch: java.lang.Throwable -> Lc3 android.database.sqlite.SQLiteException -> L1bc
        L1d3:
            r0 = r10
            goto L1f2
        L1d5:
            r0 = move-exception
            r23 = r9
        L1d8:
            g2.h5 r8 = r11.f4646a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r8 = r8.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r8 = r8.r()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "Error deleting application data. appId, error"
            java.lang.Object r11 = g2.v3.z(r12)     // Catch: java.lang.Throwable -> Lc3
            r8.c(r9, r11, r0)     // Catch: java.lang.Throwable -> Lc3
            goto L1d3
        L1ec:
            r23 = r9
            goto L1f2
        L1ef:
            r24 = r12
            goto L1ec
        L1f2:
            if (r0 == 0) goto L24a
            long r8 = r0.R()     // Catch: java.lang.Throwable -> Lc3
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r13 == 0) goto L20b
            long r8 = r0.R()     // Catch: java.lang.Throwable -> Lc3
            long r13 = r2.f3284t     // Catch: java.lang.Throwable -> Lc3
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 == 0) goto L20b
            r8 = 1
            goto L20c
        L20b:
            r8 = 0
        L20c:
            java.lang.String r9 = r0.o0()     // Catch: java.lang.Throwable -> Lc3
            long r13 = r0.R()     // Catch: java.lang.Throwable -> Lc3
            int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r0 != 0) goto L224
            if (r9 == 0) goto L224
            java.lang.String r0 = r2.f3277m     // Catch: java.lang.Throwable -> Lc3
            boolean r0 = r9.equals(r0)     // Catch: java.lang.Throwable -> Lc3
            if (r0 != 0) goto L224
            r11 = 1
            goto L225
        L224:
            r11 = 0
        L225:
            r0 = r8 | r11
            if (r0 == 0) goto L24a
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lc3
            r0.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = "_pv"
            r0.putString(r8, r9)     // Catch: java.lang.Throwable -> Lc3
            com.google.android.gms.measurement.internal.zzau r14 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_au"
            com.google.android.gms.measurement.internal.zzas r8 = new com.google.android.gms.measurement.internal.zzas     // Catch: java.lang.Throwable -> Lc3
            r8.<init>(r0)     // Catch: java.lang.Throwable -> Lc3
            r18 = r16
            java.lang.String r17 = "auto"
            r16 = r8
            r14.<init>(r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Lc3
            r16 = r18
            r1.j(r14, r2)     // Catch: java.lang.Throwable -> Lc3
        L24a:
            r26.S(r27)     // Catch: java.lang.Throwable -> Lc3
            if (r23 != 0) goto L25e
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r0)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "_f"
            g2.q r0 = r0.V(r8, r9)     // Catch: java.lang.Throwable -> Lc3
            r11 = 0
            goto L26c
        L25e:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r0)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "_v"
            g2.q r0 = r0.V(r8, r9)     // Catch: java.lang.Throwable -> Lc3
            r11 = 1
        L26c:
            if (r0 != 0) goto L52e
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r16 / r8
            long r12 = r12 + r24
            long r12 = r12 * r8
            java.lang.String r8 = "_dac"
            java.lang.String r9 = "_et"
            java.lang.String r14 = "_r"
            java.lang.String r15 = "_c"
            if (r11 != 0) goto L4e5
            r11 = r14
            com.google.android.gms.measurement.internal.zzlk r14 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> Lc3
            r18 = r15
            java.lang.String r15 = "_fot"
            r19 = r18
            java.lang.Long r18 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Throwable -> Lc3
            r12 = r19
            java.lang.String r19 = "auto"
            r13 = r12
            r12 = r11
            r14.<init>(r15, r16, r18, r19)     // Catch: java.lang.Throwable -> Lc3
            r1.B(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            g2.e5 r0 = r1.f()     // Catch: java.lang.Throwable -> Lc3
            r0.h()     // Catch: java.lang.Throwable -> Lc3
            g2.o4 r0 = r1.f5213k     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> Lc3
            r14 = r0
            g2.o4 r14 = (g2.o4) r14     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            if (r0 == 0) goto L39c
            boolean r11 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lc3
            if (r11 == 0) goto L2b6
            goto L39c
        L2b6:
            g2.h5 r11 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.e5 r11 = r11.f()     // Catch: java.lang.Throwable -> Lc3
            r11.h()     // Catch: java.lang.Throwable -> Lc3
            boolean r11 = r14.a()     // Catch: java.lang.Throwable -> Lc3
            if (r11 != 0) goto L2d6
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.u()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Install Referrer Reporter is not available"
            r0.a(r6)     // Catch: java.lang.Throwable -> Lc3
            goto L3ab
        L2d6:
            g2.n4 r11 = new g2.n4     // Catch: java.lang.Throwable -> Lc3
            r11.<init>(r14, r0)     // Catch: java.lang.Throwable -> Lc3
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.e5 r0 = r0.f()     // Catch: java.lang.Throwable -> Lc3
            r0.h()     // Catch: java.lang.Throwable -> Lc3
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch: java.lang.Throwable -> Lc3
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r6, r10)     // Catch: java.lang.Throwable -> Lc3
            r0.setComponent(r15)     // Catch: java.lang.Throwable -> Lc3
            g2.h5 r10 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            android.content.Context r10 = r10.c()     // Catch: java.lang.Throwable -> Lc3
            android.content.pm.PackageManager r10 = r10.getPackageManager()     // Catch: java.lang.Throwable -> Lc3
            if (r10 != 0) goto L312
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.y()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.a(r6)     // Catch: java.lang.Throwable -> Lc3
            goto L3ab
        L312:
            r15 = 0
            java.util.List r10 = r10.queryIntentServices(r0, r15)     // Catch: java.lang.Throwable -> Lc3
            if (r10 == 0) goto L38c
            boolean r18 = r10.isEmpty()     // Catch: java.lang.Throwable -> Lc3
            if (r18 != 0) goto L38c
            java.lang.Object r10 = r10.get(r15)     // Catch: java.lang.Throwable -> Lc3
            android.content.pm.ResolveInfo r10 = (android.content.pm.ResolveInfo) r10     // Catch: java.lang.Throwable -> Lc3
            android.content.pm.ServiceInfo r10 = r10.serviceInfo     // Catch: java.lang.Throwable -> Lc3
            if (r10 == 0) goto L3ab
            java.lang.String r15 = r10.packageName     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = r10.name     // Catch: java.lang.Throwable -> Lc3
            if (r10 == 0) goto L37c
            boolean r6 = r6.equals(r15)     // Catch: java.lang.Throwable -> Lc3
            if (r6 == 0) goto L37c
            boolean r6 = r14.a()     // Catch: java.lang.Throwable -> Lc3
            if (r6 == 0) goto L37c
            android.content.Intent r6 = new android.content.Intent     // Catch: java.lang.Throwable -> Lc3
            r6.<init>(r0)     // Catch: java.lang.Throwable -> Lc3
            w1.b r0 = w1.b.b()     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            g2.h5 r10 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            android.content.Context r10 = r10.c()     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            r15 = 1
            boolean r0 = r0.a(r10, r6, r11, r15)     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            g2.h5 r6 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            g2.v3 r6 = r6.d()     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            g2.t3 r6 = r6.v()     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            java.lang.String r10 = "Install Referrer Service is"
            if (r0 == 0) goto L362
            java.lang.String r0 = "available"
            goto L364
        L360:
            r0 = move-exception
            goto L368
        L362:
            java.lang.String r0 = "not available"
        L364:
            r6.b(r10, r0)     // Catch: java.lang.Throwable -> Lc3 java.lang.RuntimeException -> L360
            goto L3ab
        L368:
            g2.h5 r6 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r6 = r6.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r6 = r6.r()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lc3
            r6.b(r10, r0)     // Catch: java.lang.Throwable -> Lc3
            goto L3ab
        L37c:
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.w()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.a(r6)     // Catch: java.lang.Throwable -> Lc3
            goto L3ab
        L38c:
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.u()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.a(r6)     // Catch: java.lang.Throwable -> Lc3
            goto L3ab
        L39c:
            g2.h5 r0 = r14.f5160a     // Catch: java.lang.Throwable -> Lc3
            g2.v3 r0 = r0.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.y()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Install Referrer Reporter was called with invalid app package name"
            r0.a(r6)     // Catch: java.lang.Throwable -> Lc3
        L3ab:
            g2.e5 r0 = r1.f()     // Catch: java.lang.Throwable -> Lc3
            r0.h()     // Catch: java.lang.Throwable -> Lc3
            r1.g()     // Catch: java.lang.Throwable -> Lc3
            android.os.Bundle r6 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lc3
            r6.<init>()     // Catch: java.lang.Throwable -> Lc3
            r14 = r24
            r6.putLong(r13, r14)     // Catch: java.lang.Throwable -> Lc3
            r6.putLong(r12, r14)     // Catch: java.lang.Throwable -> Lc3
            r12 = 0
            r6.putLong(r7, r12)     // Catch: java.lang.Throwable -> Lc3
            r6.putLong(r5, r12)     // Catch: java.lang.Throwable -> Lc3
            r6.putLong(r4, r12)     // Catch: java.lang.Throwable -> Lc3
            r6.putLong(r3, r12)     // Catch: java.lang.Throwable -> Lc3
            r6.putLong(r9, r14)     // Catch: java.lang.Throwable -> Lc3
            boolean r0 = r2.f3290z     // Catch: java.lang.Throwable -> Lc3
            if (r0 == 0) goto L3da
            r6.putLong(r8, r14)     // Catch: java.lang.Throwable -> Lc3
        L3da:
            java.lang.String r0 = r2.f3275c     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> Lc3
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> Lc3
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r0)     // Catch: java.lang.Throwable -> Lc3
            u1.f.d(r8)     // Catch: java.lang.Throwable -> Lc3
            r0.h()     // Catch: java.lang.Throwable -> Lc3
            r0.i()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "first_open_count"
            long r12 = r0.L(r8, r9)     // Catch: java.lang.Throwable -> Lc3
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> Lc3
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> Lc3
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> Lc3
            if (r0 != 0) goto L418
            g2.v3 r0 = r1.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r0 = r0.r()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = g2.v3.z(r8)     // Catch: java.lang.Throwable -> Lc3
            r0.b(r3, r4)     // Catch: java.lang.Throwable -> Lc3
        L414:
            r20 = 0
            goto L4c8
        L418:
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L428
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L428
            y1.d r0 = y1.e.a(r0)     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L428
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.c(r8, r15)     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L428
            goto L43b
        L428:
            r0 = move-exception
            g2.v3 r9 = r1.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r9 = r9.r()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r14 = g2.v3.z(r8)     // Catch: java.lang.Throwable -> Lc3
            r9.c(r10, r14, r0)     // Catch: java.lang.Throwable -> Lc3
            r0 = 0
        L43b:
            if (r0 == 0) goto L48a
            long r9 = r0.firstInstallTime     // Catch: java.lang.Throwable -> Lc3
            r20 = 0
            int r14 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r14 == 0) goto L48a
            long r14 = r0.lastUpdateTime     // Catch: java.lang.Throwable -> Lc3
            int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r0 == 0) goto L46f
            g2.g r0 = r1.U()     // Catch: java.lang.Throwable -> Lc3
            g2.h3 r9 = g2.i3.f4922f0     // Catch: java.lang.Throwable -> Lc3
            r10 = 0
            boolean r0 = r0.B(r10, r9)     // Catch: java.lang.Throwable -> Lc3
            if (r0 == 0) goto L469
            r20 = 0
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 != 0) goto L467
            r14 = 1
            r6.putLong(r7, r14)     // Catch: java.lang.Throwable -> Lc3
            r0 = 0
            r12 = 0
            goto L471
        L467:
            r0 = 0
            goto L471
        L469:
            r14 = 1
            r6.putLong(r7, r14)     // Catch: java.lang.Throwable -> Lc3
            goto L467
        L46f:
            r10 = 0
            r0 = 1
        L471:
            com.google.android.gms.measurement.internal.zzlk r14 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_fi"
            r11 = 1
            if (r11 == r0) goto L47b
            r18 = 0
            goto L47d
        L47b:
            r18 = 1
        L47d:
            java.lang.Long r18 = java.lang.Long.valueOf(r18)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r19 = "auto"
            r14.<init>(r15, r16, r18, r19)     // Catch: java.lang.Throwable -> Lc3
            r1.B(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            goto L48b
        L48a:
            r10 = 0
        L48b:
            g2.h5 r0 = r1.f5214l     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L49b
            android.content.Context r0 = r0.c()     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L49b
            y1.d r0 = y1.e.a(r0)     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L49b
            r15 = 0
            android.content.pm.ApplicationInfo r10 = r0.b(r8, r15)     // Catch: java.lang.Throwable -> Lc3 android.content.pm.PackageManager.NameNotFoundException -> L49b
            goto L4ad
        L49b:
            r0 = move-exception
            g2.v3 r7 = r1.d()     // Catch: java.lang.Throwable -> Lc3
            g2.t3 r7 = r7.r()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r8 = g2.v3.z(r8)     // Catch: java.lang.Throwable -> Lc3
            r7.c(r9, r8, r0)     // Catch: java.lang.Throwable -> Lc3
        L4ad:
            if (r10 == 0) goto L414
            int r0 = r10.flags     // Catch: java.lang.Throwable -> Lc3
            r11 = 1
            r0 = r0 & r11
            if (r0 == 0) goto L4bb
            r14 = 1
            r6.putLong(r4, r14)     // Catch: java.lang.Throwable -> Lc3
            goto L4bd
        L4bb:
            r14 = 1
        L4bd:
            int r0 = r10.flags     // Catch: java.lang.Throwable -> Lc3
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L414
            r6.putLong(r3, r14)     // Catch: java.lang.Throwable -> Lc3
            goto L414
        L4c8:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 < 0) goto L4cf
            r6.putLong(r5, r12)     // Catch: java.lang.Throwable -> Lc3
        L4cf:
            com.google.android.gms.measurement.internal.zzau r14 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_f"
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch: java.lang.Throwable -> Lc3
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lc3
            r18 = r16
            java.lang.String r17 = "auto"
            r16 = r0
            r14.<init>(r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Lc3
            r1.l(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            goto L54c
        L4e5:
            r11 = r14
            r3 = r15
            com.google.android.gms.measurement.internal.zzlk r14 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_fvt"
            java.lang.Long r18 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r19 = "auto"
            r14.<init>(r15, r16, r18, r19)     // Catch: java.lang.Throwable -> Lc3
            r1.B(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            g2.e5 r0 = r1.f()     // Catch: java.lang.Throwable -> Lc3
            r0.h()     // Catch: java.lang.Throwable -> Lc3
            r1.g()     // Catch: java.lang.Throwable -> Lc3
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lc3
            r0.<init>()     // Catch: java.lang.Throwable -> Lc3
            r14 = 1
            r0.putLong(r3, r14)     // Catch: java.lang.Throwable -> Lc3
            r0.putLong(r11, r14)     // Catch: java.lang.Throwable -> Lc3
            r0.putLong(r9, r14)     // Catch: java.lang.Throwable -> Lc3
            boolean r3 = r2.f3290z     // Catch: java.lang.Throwable -> Lc3
            if (r3 == 0) goto L518
            r0.putLong(r8, r14)     // Catch: java.lang.Throwable -> Lc3
        L518:
            com.google.android.gms.measurement.internal.zzau r14 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_v"
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch: java.lang.Throwable -> Lc3
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lc3
            r18 = r16
            java.lang.String r17 = "auto"
            r16 = r3
            r14.<init>(r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Lc3
            r1.l(r14, r2)     // Catch: java.lang.Throwable -> Lc3
            goto L54c
        L52e:
            boolean r0 = r2.f3283s     // Catch: java.lang.Throwable -> Lc3
            if (r0 == 0) goto L54c
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lc3
            r0.<init>()     // Catch: java.lang.Throwable -> Lc3
            com.google.android.gms.measurement.internal.zzau r14 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r15 = "_cd"
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch: java.lang.Throwable -> Lc3
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lc3
            r18 = r16
            java.lang.String r17 = "auto"
            r16 = r3
            r14.<init>(r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Lc3
            r1.l(r14, r2)     // Catch: java.lang.Throwable -> Lc3
        L54c:
            g2.k r0 = r1.f5205c     // Catch: java.lang.Throwable -> Lc3
            R(r0)     // Catch: java.lang.Throwable -> Lc3
            r0.o()     // Catch: java.lang.Throwable -> Lc3
            g2.k r0 = r1.f5205c
            R(r0)
            r0.f0()
            return
        L55d:
            g2.k r2 = r1.f5205c
            R(r2)
            r2.f0()
            throw r0
        L566:
            return
    }

    public final void r() {
            r1 = this;
            int r0 = r1.f5219q
            int r0 = r0 + 1
            r1.f5219q = r0
            return
    }

    public final void s(com.google.android.gms.measurement.internal.zzac r2) {
            r1 = this;
            java.lang.String r0 = r2.f3251c
            java.lang.Object r0 = u1.f.h(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.google.android.gms.measurement.internal.zzq r0 = r1.I(r0)
            if (r0 == 0) goto L11
            r1.t(r2, r0)
        L11:
            return
    }

    public final void t(com.google.android.gms.measurement.internal.zzac r11, com.google.android.gms.measurement.internal.zzq r12) {
            r10 = this;
            u1.f.h(r11)
            java.lang.String r0 = r11.f3251c
            u1.f.d(r0)
            com.google.android.gms.measurement.internal.zzlk r0 = r11.f3253m
            u1.f.h(r0)
            com.google.android.gms.measurement.internal.zzlk r0 = r11.f3253m
            java.lang.String r0 = r0.f3269e
            u1.f.d(r0)
            g2.e5 r0 = r10.f()
            r0.h()
            r10.g()
            boolean r0 = Q(r12)
            if (r0 != 0) goto L25
            return
        L25:
            boolean r0 = r12.f3282r
            if (r0 == 0) goto Lf8
            g2.k r0 = r10.f5205c
            R(r0)
            r0.e0()
            r10.S(r12)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r11.f3251c     // Catch: java.lang.Throwable -> L86
            java.lang.Object r0 = u1.f.h(r0)     // Catch: java.lang.Throwable -> L86
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L86
            g2.k r0 = r10.f5205c     // Catch: java.lang.Throwable -> L86
            R(r0)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzlk r1 = r11.f3253m     // Catch: java.lang.Throwable -> L86
            java.lang.String r1 = r1.f3269e     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzac r0 = r0.S(r2, r1)     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto Lbd
            g2.v3 r1 = r10.d()     // Catch: java.lang.Throwable -> L86
            g2.t3 r1 = r1.q()     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = "Removing conditional user property"
            java.lang.String r4 = r11.f3251c     // Catch: java.lang.Throwable -> L86
            g2.h5 r5 = r10.f5214l     // Catch: java.lang.Throwable -> L86
            g2.q3 r5 = r5.D()     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzlk r6 = r11.f3253m     // Catch: java.lang.Throwable -> L86
            java.lang.String r6 = r6.f3269e     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r5.f(r6)     // Catch: java.lang.Throwable -> L86
            r1.c(r3, r4, r5)     // Catch: java.lang.Throwable -> L86
            g2.k r1 = r10.f5205c     // Catch: java.lang.Throwable -> L86
            R(r1)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzlk r3 = r11.f3253m     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r3.f3269e     // Catch: java.lang.Throwable -> L86
            r1.J(r2, r3)     // Catch: java.lang.Throwable -> L86
            boolean r1 = r0.f3255o     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L89
            g2.k r1 = r10.f5205c     // Catch: java.lang.Throwable -> L86
            R(r1)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzlk r3 = r11.f3253m     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r3.f3269e     // Catch: java.lang.Throwable -> L86
            r1.m(r2, r3)     // Catch: java.lang.Throwable -> L86
            goto L89
        L86:
            r0 = move-exception
            r11 = r0
            goto Lef
        L89:
            com.google.android.gms.measurement.internal.zzau r1 = r11.f3261u     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto Lde
            com.google.android.gms.measurement.internal.zzas r1 = r1.f3264e     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L97
            android.os.Bundle r1 = r1.g()     // Catch: java.lang.Throwable -> L86
        L95:
            r4 = r1
            goto L99
        L97:
            r1 = 0
            goto L95
        L99:
            g2.wa r1 = r10.h0()     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzau r3 = r11.f3261u     // Catch: java.lang.Throwable -> L86
            java.lang.Object r3 = u1.f.h(r3)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzau r3 = (com.google.android.gms.measurement.internal.zzau) r3     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r3.f3263c     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r0.f3252e     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzau r11 = r11.f3261u     // Catch: java.lang.Throwable -> L86
            long r6 = r11.f3266n     // Catch: java.lang.Throwable -> L86
            r8 = 1
            r9 = 1
            com.google.android.gms.measurement.internal.zzau r11 = r1.y0(r2, r3, r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r11 = u1.f.h(r11)     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzau r11 = (com.google.android.gms.measurement.internal.zzau) r11     // Catch: java.lang.Throwable -> L86
            r10.D(r11, r12)     // Catch: java.lang.Throwable -> L86
            goto Lde
        Lbd:
            g2.v3 r12 = r10.d()     // Catch: java.lang.Throwable -> L86
            g2.t3 r12 = r12.w()     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "Conditional user property doesn't exist"
            java.lang.String r1 = r11.f3251c     // Catch: java.lang.Throwable -> L86
            java.lang.Object r1 = g2.v3.z(r1)     // Catch: java.lang.Throwable -> L86
            g2.h5 r2 = r10.f5214l     // Catch: java.lang.Throwable -> L86
            g2.q3 r2 = r2.D()     // Catch: java.lang.Throwable -> L86
            com.google.android.gms.measurement.internal.zzlk r11 = r11.f3253m     // Catch: java.lang.Throwable -> L86
            java.lang.String r11 = r11.f3269e     // Catch: java.lang.Throwable -> L86
            java.lang.String r11 = r2.f(r11)     // Catch: java.lang.Throwable -> L86
            r12.c(r0, r1, r11)     // Catch: java.lang.Throwable -> L86
        Lde:
            g2.k r11 = r10.f5205c     // Catch: java.lang.Throwable -> L86
            R(r11)     // Catch: java.lang.Throwable -> L86
            r11.o()     // Catch: java.lang.Throwable -> L86
            g2.k r11 = r10.f5205c
            R(r11)
            r11.f0()
            return
        Lef:
            g2.k r12 = r10.f5205c
            R(r12)
            r12.f0()
            throw r11
        Lf8:
            r10.S(r12)
            return
    }

    public final void u(java.lang.String r8, com.google.android.gms.measurement.internal.zzq r9) {
            r7 = this;
            g2.e5 r0 = r7.f()
            r0.h()
            r7.g()
            boolean r0 = Q(r9)
            if (r0 != 0) goto L11
            return
        L11:
            boolean r0 = r9.f3282r
            if (r0 != 0) goto L19
            r7.S(r9)
            return
        L19:
            java.lang.String r0 = "_npa"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L59
            java.lang.Boolean r0 = r9.B
            if (r0 == 0) goto L59
            g2.v3 r8 = r7.d()
            g2.t3 r8 = r8.q()
            java.lang.String r0 = "Falling back to manifest metadata value for ad personalization"
            r8.a(r0)
            com.google.android.gms.measurement.internal.zzlk r1 = new com.google.android.gms.measurement.internal.zzlk
            x1.c r8 = r7.a()
            long r3 = r8.a()
            java.lang.Boolean r8 = r9.B
            boolean r8 = r8.booleanValue()
            r0 = 1
            if (r0 == r8) goto L48
            r5 = 0
            goto L4a
        L48:
            r5 = 1
        L4a:
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "auto"
            java.lang.String r2 = "_npa"
            r1.<init>(r2, r3, r5, r6)
            r7.B(r1, r9)
            return
        L59:
            g2.v3 r0 = r7.d()
            g2.t3 r0 = r0.q()
            g2.h5 r1 = r7.f5214l
            g2.q3 r1 = r1.D()
            java.lang.String r1 = r1.f(r8)
            java.lang.String r2 = "Removing user property"
            r0.b(r2, r1)
            g2.k r0 = r7.f5205c
            R(r0)
            r0.e0()
            r7.S(r9)     // Catch: java.lang.Throwable -> L96
            java.lang.String r0 = "_id"
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L99
            g2.k r0 = r7.f5205c     // Catch: java.lang.Throwable -> L96
            R(r0)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = r9.f3275c     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = u1.f.h(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = "_lair"
            r0.m(r1, r2)     // Catch: java.lang.Throwable -> L96
            goto L99
        L96:
            r0 = move-exception
            r8 = r0
            goto Ld1
        L99:
            g2.k r0 = r7.f5205c     // Catch: java.lang.Throwable -> L96
            R(r0)     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = r9.f3275c     // Catch: java.lang.Throwable -> L96
            java.lang.Object r9 = u1.f.h(r9)     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L96
            r0.m(r9, r8)     // Catch: java.lang.Throwable -> L96
            g2.k r9 = r7.f5205c     // Catch: java.lang.Throwable -> L96
            R(r9)     // Catch: java.lang.Throwable -> L96
            r9.o()     // Catch: java.lang.Throwable -> L96
            g2.v3 r9 = r7.d()     // Catch: java.lang.Throwable -> L96
            g2.t3 r9 = r9.q()     // Catch: java.lang.Throwable -> L96
            java.lang.String r0 = "User property removed"
            g2.h5 r1 = r7.f5214l     // Catch: java.lang.Throwable -> L96
            g2.q3 r1 = r1.D()     // Catch: java.lang.Throwable -> L96
            java.lang.String r8 = r1.f(r8)     // Catch: java.lang.Throwable -> L96
            r9.b(r0, r8)     // Catch: java.lang.Throwable -> L96
            g2.k r8 = r7.f5205c
            R(r8)
            r8.f0()
            return
        Ld1:
            g2.k r9 = r7.f5205c
            R(r9)
            r9.f0()
            throw r8
    }

    public final void v(com.google.android.gms.measurement.internal.zzq r8) {
            r7 = this;
            java.lang.String r0 = "app_id=?"
            java.util.List r1 = r7.f5226x
            if (r1 == 0) goto L12
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7.f5227y = r1
            java.util.List r2 = r7.f5226x
            r1.addAll(r2)
        L12:
            g2.k r1 = r7.f5205c
            R(r1)
            java.lang.String r2 = r8.f3275c
            java.lang.Object r2 = u1.f.h(r2)
            java.lang.String r2 = (java.lang.String) r2
            u1.f.d(r2)
            r1.h()
            r1.i()
            android.database.sqlite.SQLiteDatabase r3 = r1.P()     // Catch: android.database.sqlite.SQLiteException -> L8b
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch: android.database.sqlite.SQLiteException -> L8b
            java.lang.String r5 = "apps"
            int r5 = r3.delete(r5, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            java.lang.String r6 = "events"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "user_attributes"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "conditional_properties"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "raw_events"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "raw_events_metadata"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "queue"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "audience_filter_values"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "main_event_params"
            int r6 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r6
            java.lang.String r6 = "default_event_params"
            int r0 = r3.delete(r6, r0, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            int r5 = r5 + r0
            if (r5 <= 0) goto L9f
            g2.h5 r0 = r1.f4646a     // Catch: android.database.sqlite.SQLiteException -> L8b
            g2.v3 r0 = r0.d()     // Catch: android.database.sqlite.SQLiteException -> L8b
            g2.t3 r0 = r0.v()     // Catch: android.database.sqlite.SQLiteException -> L8b
            java.lang.String r3 = "Reset analytics data. app, records"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch: android.database.sqlite.SQLiteException -> L8b
            r0.c(r3, r2, r4)     // Catch: android.database.sqlite.SQLiteException -> L8b
            goto L9f
        L8b:
            r0 = move-exception
            g2.h5 r1 = r1.f4646a
            g2.v3 r1 = r1.d()
            g2.t3 r1 = r1.r()
            java.lang.Object r2 = g2.v3.z(r2)
            java.lang.String r3 = "Error resetting analytics data. appId, error"
            r1.c(r3, r2, r0)
        L9f:
            boolean r0 = r8.f3282r
            if (r0 == 0) goto La6
            r7.q(r8)
        La6:
            return
    }

    public final void w(java.lang.String r2, g2.v7 r3) {
            r1 = this;
            g2.e5 r0 = r1.f()
            r0.h()
            java.lang.String r0 = r1.D
            if (r0 == 0) goto L15
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L15
            if (r3 == 0) goto L14
            goto L15
        L14:
            return
        L15:
            r1.D = r2
            r1.C = r3
            return
    }

    public final void x() {
            r5 = this;
            g2.e5 r0 = r5.f()
            r0.h()
            g2.k r0 = r5.f5205c
            R(r0)
            r0.h0()
            g2.g9 r0 = r5.f5211i
            g2.h4 r0 = r0.f4835g
            long r0 = r0.a()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L2c
            g2.g9 r0 = r5.f5211i
            g2.h4 r0 = r0.f4835g
            x1.c r1 = r5.a()
            long r1 = r1.a()
            r0.b(r1)
        L2c:
            r5.M()
            return
    }

    public final void y(com.google.android.gms.measurement.internal.zzac r2) {
            r1 = this;
            java.lang.String r0 = r2.f3251c
            java.lang.Object r0 = u1.f.h(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.google.android.gms.measurement.internal.zzq r0 = r1.I(r0)
            if (r0 == 0) goto L11
            r1.z(r2, r0)
        L11:
            return
    }

    public final void z(com.google.android.gms.measurement.internal.zzac r11, com.google.android.gms.measurement.internal.zzq r12) {
            r10 = this;
            u1.f.h(r11)
            java.lang.String r0 = r11.f3251c
            u1.f.d(r0)
            java.lang.String r0 = r11.f3252e
            u1.f.h(r0)
            com.google.android.gms.measurement.internal.zzlk r0 = r11.f3253m
            u1.f.h(r0)
            com.google.android.gms.measurement.internal.zzlk r0 = r11.f3253m
            java.lang.String r0 = r0.f3269e
            u1.f.d(r0)
            g2.e5 r0 = r10.f()
            r0.h()
            r10.g()
            boolean r0 = Q(r12)
            if (r0 != 0) goto L2a
            return
        L2a:
            boolean r0 = r12.f3282r
            if (r0 != 0) goto L32
            r10.S(r12)
            return
        L32:
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac
            r0.<init>(r11)
            r11 = 0
            r0.f3255o = r11
            g2.k r1 = r10.f5205c
            R(r1)
            r1.e0()
            g2.k r1 = r10.f5205c     // Catch: java.lang.Throwable -> L83
            R(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = u1.f.h(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r3 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.f3269e     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzac r1 = r1.S(r2, r3)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L87
            java.lang.String r2 = r1.f3252e     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r0.f3252e     // Catch: java.lang.Throwable -> L83
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L87
            g2.v3 r2 = r10.d()     // Catch: java.lang.Throwable -> L83
            g2.t3 r2 = r2.w()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "Updating a conditional user property with different origin. name, origin, origin (from DB)"
            g2.h5 r4 = r10.f5214l     // Catch: java.lang.Throwable -> L83
            g2.q3 r4 = r4.D()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r5 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r5.f3269e     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.f(r5)     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r0.f3252e     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = r1.f3252e     // Catch: java.lang.Throwable -> L83
            r2.d(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r0 = move-exception
            r11 = r0
            goto L1c0
        L87:
            r2 = 1
            if (r1 == 0) goto Lbc
            boolean r3 = r1.f3255o     // Catch: java.lang.Throwable -> L83
            if (r3 == 0) goto Lbc
            java.lang.String r3 = r1.f3252e     // Catch: java.lang.Throwable -> L83
            r0.f3252e = r3     // Catch: java.lang.Throwable -> L83
            long r3 = r1.f3254n     // Catch: java.lang.Throwable -> L83
            r0.f3254n = r3     // Catch: java.lang.Throwable -> L83
            long r3 = r1.f3258r     // Catch: java.lang.Throwable -> L83
            r0.f3258r = r3     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r1.f3256p     // Catch: java.lang.Throwable -> L83
            r0.f3256p = r3     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzau r3 = r1.f3259s     // Catch: java.lang.Throwable -> L83
            r0.f3259s = r3     // Catch: java.lang.Throwable -> L83
            r0.f3255o = r2     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r4 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r2 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r2.f3269e     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r3 = r1.f3253m     // Catch: java.lang.Throwable -> L83
            long r6 = r3.f3270m     // Catch: java.lang.Throwable -> L83
            java.lang.Object r8 = r2.c()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r1 = r1.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r9 = r1.f3273p     // Catch: java.lang.Throwable -> L83
            r4.<init>(r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L83
            r0.f3253m = r4     // Catch: java.lang.Throwable -> L83
            goto Ldc
        Lbc:
            java.lang.String r1 = r0.f3256p     // Catch: java.lang.Throwable -> L83
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto Ldc
            com.google.android.gms.measurement.internal.zzlk r3 = new com.google.android.gms.measurement.internal.zzlk     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r11 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r11.f3269e     // Catch: java.lang.Throwable -> L83
            long r5 = r0.f3254n     // Catch: java.lang.Throwable -> L83
            java.lang.Object r7 = r11.c()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r11 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r8 = r11.f3273p     // Catch: java.lang.Throwable -> L83
            r3.<init>(r4, r5, r7, r8)     // Catch: java.lang.Throwable -> L83
            r0.f3253m = r3     // Catch: java.lang.Throwable -> L83
            r0.f3255o = r2     // Catch: java.lang.Throwable -> L83
            r11 = 1
        Ldc:
            boolean r1 = r0.f3255o     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L159
            com.google.android.gms.measurement.internal.zzlk r1 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            g2.ta r2 = new g2.ta     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            java.lang.Object r3 = u1.f.h(r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r0.f3252e     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r1.f3269e     // Catch: java.lang.Throwable -> L83
            long r6 = r1.f3270m     // Catch: java.lang.Throwable -> L83
            java.lang.Object r1 = r1.c()     // Catch: java.lang.Throwable -> L83
            java.lang.Object r8 = u1.f.h(r1)     // Catch: java.lang.Throwable -> L83
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: java.lang.Throwable -> L83
            g2.k r1 = r10.f5205c     // Catch: java.lang.Throwable -> L83
            R(r1)     // Catch: java.lang.Throwable -> L83
            boolean r1 = r1.x(r2)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L126
            g2.v3 r1 = r10.d()     // Catch: java.lang.Throwable -> L83
            g2.t3 r1 = r1.q()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "User property updated immediately"
            java.lang.String r4 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            g2.h5 r5 = r10.f5214l     // Catch: java.lang.Throwable -> L83
            g2.q3 r5 = r5.D()     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = r2.f5332c     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r5.f(r6)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r2.f5334e     // Catch: java.lang.Throwable -> L83
            r1.d(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> L83
            goto L147
        L126:
            g2.v3 r1 = r10.d()     // Catch: java.lang.Throwable -> L83
            g2.t3 r1 = r1.r()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "(2)Too many active user properties, ignoring"
            java.lang.String r4 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            java.lang.Object r4 = g2.v3.z(r4)     // Catch: java.lang.Throwable -> L83
            g2.h5 r5 = r10.f5214l     // Catch: java.lang.Throwable -> L83
            g2.q3 r5 = r5.D()     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = r2.f5332c     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = r5.f(r6)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r2.f5334e     // Catch: java.lang.Throwable -> L83
            r1.d(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> L83
        L147:
            if (r11 == 0) goto L159
            com.google.android.gms.measurement.internal.zzau r11 = r0.f3259s     // Catch: java.lang.Throwable -> L83
            if (r11 == 0) goto L159
            com.google.android.gms.measurement.internal.zzau r11 = new com.google.android.gms.measurement.internal.zzau     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzau r1 = r0.f3259s     // Catch: java.lang.Throwable -> L83
            long r2 = r0.f3254n     // Catch: java.lang.Throwable -> L83
            r11.<init>(r1, r2)     // Catch: java.lang.Throwable -> L83
            r10.D(r11, r12)     // Catch: java.lang.Throwable -> L83
        L159:
            g2.k r11 = r10.f5205c     // Catch: java.lang.Throwable -> L83
            R(r11)     // Catch: java.lang.Throwable -> L83
            boolean r11 = r11.w(r0)     // Catch: java.lang.Throwable -> L83
            if (r11 == 0) goto L188
            g2.v3 r11 = r10.d()     // Catch: java.lang.Throwable -> L83
            g2.t3 r11 = r11.q()     // Catch: java.lang.Throwable -> L83
            java.lang.String r12 = "Conditional property added"
            java.lang.String r1 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            g2.h5 r2 = r10.f5214l     // Catch: java.lang.Throwable -> L83
            g2.q3 r2 = r2.D()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r3 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.f3269e     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r2.f(r3)     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r0 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L83
            r11.d(r12, r1, r2, r0)     // Catch: java.lang.Throwable -> L83
            goto L1af
        L188:
            g2.v3 r11 = r10.d()     // Catch: java.lang.Throwable -> L83
            g2.t3 r11 = r11.r()     // Catch: java.lang.Throwable -> L83
            java.lang.String r12 = "Too many conditional properties, ignoring"
            java.lang.String r1 = r0.f3251c     // Catch: java.lang.Throwable -> L83
            java.lang.Object r1 = g2.v3.z(r1)     // Catch: java.lang.Throwable -> L83
            g2.h5 r2 = r10.f5214l     // Catch: java.lang.Throwable -> L83
            g2.q3 r2 = r2.D()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r3 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.f3269e     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r2.f(r3)     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzlk r0 = r0.f3253m     // Catch: java.lang.Throwable -> L83
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L83
            r11.d(r12, r1, r2, r0)     // Catch: java.lang.Throwable -> L83
        L1af:
            g2.k r11 = r10.f5205c     // Catch: java.lang.Throwable -> L83
            R(r11)     // Catch: java.lang.Throwable -> L83
            r11.o()     // Catch: java.lang.Throwable -> L83
            g2.k r11 = r10.f5205c
            R(r11)
            r11.f0()
            return
        L1c0:
            g2.k r12 = r10.f5205c
            R(r12)
            r12.f0()
            throw r11
    }
}
