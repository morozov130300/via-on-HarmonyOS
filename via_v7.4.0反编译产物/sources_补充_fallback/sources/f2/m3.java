package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m3 extends f2.c4 {

    /* renamed from: c, reason: collision with root package name */
    public java.lang.String f5466c;

    /* renamed from: d, reason: collision with root package name */
    public java.lang.String f5467d;

    /* renamed from: e, reason: collision with root package name */
    public int f5468e;

    /* renamed from: f, reason: collision with root package name */
    public java.lang.String f5469f;

    /* renamed from: g, reason: collision with root package name */
    public java.lang.String f5470g;

    /* renamed from: h, reason: collision with root package name */
    public long f5471h;

    /* renamed from: i, reason: collision with root package name */
    public final long f5472i;

    /* renamed from: j, reason: collision with root package name */
    public java.util.List f5473j;

    /* renamed from: k, reason: collision with root package name */
    public java.lang.String f5474k;

    /* renamed from: l, reason: collision with root package name */
    public int f5475l;

    /* renamed from: m, reason: collision with root package name */
    public java.lang.String f5476m;

    /* renamed from: n, reason: collision with root package name */
    public java.lang.String f5477n;

    /* renamed from: o, reason: collision with root package name */
    public java.lang.String f5478o;

    /* renamed from: p, reason: collision with root package name */
    public long f5479p;

    /* renamed from: q, reason: collision with root package name */
    public java.lang.String f5480q;

    public m3(f2.h5 r3, long r4) {
            r2 = this;
            r2.<init>(r3)
            r0 = 0
            r2.f5479p = r0
            r3 = 0
            r2.f5480q = r3
            r2.f5472i = r4
            return
    }

    @Override // f2.c4
    public final void l() {
            r11 = this;
            f2.h5 r0 = r11.f5030a
            android.content.Context r0 = r0.c()
            java.lang.String r0 = r0.getPackageName()
            f2.h5 r1 = r11.f5030a
            android.content.Context r1 = r1.c()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            java.lang.String r4 = ""
            java.lang.String r5 = "Unknown"
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L35
            f2.h5 r7 = r11.f5030a
            f2.v3 r7 = r7.d()
            f2.t3 r7 = r7.r()
            java.lang.Object r8 = f2.v3.z(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.b(r9, r8)
        L32:
            r8 = r5
            goto L9b
        L35:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch: java.lang.IllegalArgumentException -> L3a
            goto L4d
        L3a:
            f2.h5 r7 = r11.f5030a
            f2.v3 r7 = r7.d()
            f2.t3 r7 = r7.r()
            java.lang.Object r8 = f2.v3.z(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.b(r9, r8)
        L4d:
            if (r6 != 0) goto L52
            java.lang.String r6 = "manual_install"
            goto L5b
        L52:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L5b
            r6 = r4
        L5b:
            f2.h5 r7 = r11.f5030a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            android.content.Context r7 = r7.c()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            java.lang.String r7 = r7.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            if (r7 == 0) goto L32
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            if (r9 != 0) goto L7c
            java.lang.String r8 = r8.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L85
            goto L7d
        L7c:
            r8 = r5
        L7d:
            java.lang.String r5 = r7.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L82
            int r2 = r7.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L82
            goto L9b
        L82:
            r7 = r5
            r5 = r8
            goto L86
        L85:
            r7 = r5
        L86:
            f2.h5 r8 = r11.f5030a
            f2.v3 r8 = r8.d()
            f2.t3 r8 = r8.r()
            java.lang.Object r9 = f2.v3.z(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.c(r10, r9, r5)
            r8 = r5
            r5 = r7
        L9b:
            r11.f5466c = r0
            r11.f5469f = r6
            r11.f5467d = r5
            r11.f5468e = r2
            r11.f5470g = r8
            r5 = 0
            r11.f5471h = r5
            f2.h5 r2 = r11.f5030a
            java.lang.String r2 = r2.O()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto Lc5
            f2.h5 r2 = r11.f5030a
            java.lang.String r2 = r2.P()
            java.lang.String r5 = "am"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto Lc5
            r2 = 1
            goto Lc6
        Lc5:
            r2 = 0
        Lc6:
            f2.h5 r5 = r11.f5030a
            int r5 = r5.x()
            switch(r5) {
                case 0: goto L150;
                case 1: goto L140;
                case 2: goto L130;
                case 3: goto L120;
                case 4: goto L110;
                case 5: goto L100;
                case 6: goto Lf0;
                case 7: goto Le0;
                default: goto Lcf;
            }
        Lcf:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            r6.a(r7)
            goto L15f
        Le0:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            r6.a(r7)
            goto L15f
        Lf0:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.x()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.a(r7)
            goto L15f
        L100:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.v()
            java.lang.String r7 = "App measurement disabled via the init parameters"
            r6.a(r7)
            goto L15f
        L110:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the manifest"
            r6.a(r7)
            goto L15f
        L120:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.a(r7)
            goto L15f
        L130:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.v()
            java.lang.String r7 = "App measurement deactivated via the init parameters"
            r6.a(r7)
            goto L15f
        L140:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.u()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            r6.a(r7)
            goto L15f
        L150:
            f2.h5 r6 = r11.f5030a
            f2.v3 r6 = r6.d()
            f2.t3 r6 = r6.v()
            java.lang.String r7 = "App measurement collection enabled"
            r6.a(r7)
        L15f:
            r11.f5476m = r4
            r11.f5477n = r4
            f2.h5 r6 = r11.f5030a
            r6.b()
            if (r2 == 0) goto L172
            f2.h5 r2 = r11.f5030a
            java.lang.String r2 = r2.O()
            r11.f5477n = r2
        L172:
            f2.h5 r2 = r11.f5030a     // Catch: java.lang.IllegalStateException -> L1bb
            android.content.Context r2 = r2.c()     // Catch: java.lang.IllegalStateException -> L1bb
            f2.h5 r6 = r11.f5030a     // Catch: java.lang.IllegalStateException -> L1bb
            java.lang.String r6 = r6.R()     // Catch: java.lang.IllegalStateException -> L1bb
            java.lang.String r7 = "google_app_id"
            java.lang.String r2 = f2.u7.b(r2, r7, r6)     // Catch: java.lang.IllegalStateException -> L1bb
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.IllegalStateException -> L1bb
            if (r6 == 0) goto L18b
            goto L18c
        L18b:
            r4 = r2
        L18c:
            r11.f5476m = r4     // Catch: java.lang.IllegalStateException -> L1bb
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.IllegalStateException -> L1bb
            if (r2 != 0) goto L1bd
            f2.h5 r2 = r11.f5030a     // Catch: java.lang.IllegalStateException -> L1bb
            android.content.Context r2 = r2.c()     // Catch: java.lang.IllegalStateException -> L1bb
            f2.h5 r4 = r11.f5030a     // Catch: java.lang.IllegalStateException -> L1bb
            java.lang.String r4 = r4.R()     // Catch: java.lang.IllegalStateException -> L1bb
            t1.f.h(r2)     // Catch: java.lang.IllegalStateException -> L1bb
            android.content.res.Resources r6 = r2.getResources()     // Catch: java.lang.IllegalStateException -> L1bb
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.IllegalStateException -> L1bb
            if (r7 != 0) goto L1ae
            goto L1b2
        L1ae:
            java.lang.String r4 = f2.z4.a(r2)     // Catch: java.lang.IllegalStateException -> L1bb
        L1b2:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = f2.z4.b(r2, r6, r4)     // Catch: java.lang.IllegalStateException -> L1bb
            r11.f5477n = r2     // Catch: java.lang.IllegalStateException -> L1bb
            goto L1bd
        L1bb:
            r2 = move-exception
            goto L1de
        L1bd:
            if (r5 != 0) goto L1f1
            f2.h5 r2 = r11.f5030a     // Catch: java.lang.IllegalStateException -> L1bb
            f2.v3 r2 = r2.d()     // Catch: java.lang.IllegalStateException -> L1bb
            f2.t3 r2 = r2.v()     // Catch: java.lang.IllegalStateException -> L1bb
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.f5466c     // Catch: java.lang.IllegalStateException -> L1bb
            java.lang.String r6 = r11.f5476m     // Catch: java.lang.IllegalStateException -> L1bb
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.IllegalStateException -> L1bb
            if (r6 == 0) goto L1d8
            java.lang.String r6 = r11.f5477n     // Catch: java.lang.IllegalStateException -> L1bb
            goto L1da
        L1d8:
            java.lang.String r6 = r11.f5476m     // Catch: java.lang.IllegalStateException -> L1bb
        L1da:
            r2.c(r4, r5, r6)     // Catch: java.lang.IllegalStateException -> L1bb
            goto L1f1
        L1de:
            f2.h5 r4 = r11.f5030a
            f2.v3 r4 = r4.d()
            f2.t3 r4 = r4.r()
            java.lang.Object r0 = f2.v3.z(r0)
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            r4.c(r5, r0, r2)
        L1f1:
            r0 = 0
            r11.f5473j = r0
            f2.h5 r0 = r11.f5030a
            r0.b()
            f2.h5 r0 = r11.f5030a
            f2.g r0 = r0.z()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.y(r2)
            if (r0 != 0) goto L208
            goto L23d
        L208:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L21e
            f2.h5 r0 = r11.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.x()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.a(r2)
            goto L23f
        L21e:
            java.util.Iterator r2 = r0.iterator()
        L222:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L23d
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            f2.h5 r5 = r11.f5030a
            f2.wa r5 = r5.N()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.R(r6, r4)
            if (r4 != 0) goto L222
            goto L23f
        L23d:
            r11.f5473j = r0
        L23f:
            if (r1 == 0) goto L24e
            f2.h5 r0 = r11.f5030a
            android.content.Context r0 = r0.c()
            boolean r0 = x1.b.a(r0)
            r11.f5475l = r0
            return
        L24e:
            r11.f5475l = r3
            return
    }

    @Override // f2.c4
    public final boolean n() {
            r1 = this;
            r0 = 1
            return r0
    }

    public final int o() {
            r1 = this;
            r1.i()
            int r0 = r1.f5475l
            return r0
    }

    public final int p() {
            r1 = this;
            r1.i()
            int r0 = r1.f5468e
            return r0
    }

    public final com.google.android.gms.measurement.internal.zzq q(java.lang.String r37) {
            r36 = this;
            r1 = r36
            r1.h()
            com.google.android.gms.measurement.internal.zzq r2 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r1.s()
            java.lang.String r4 = r1.t()
            r1.i()
            java.lang.String r5 = r1.f5467d
            r1.i()
            int r0 = r1.f5468e
            long r6 = (long) r0
            r1.i()
            java.lang.String r0 = r1.f5469f
            t1.f.h(r0)
            java.lang.String r8 = r1.f5469f
            f2.h5 r0 = r1.f5030a
            f2.g r0 = r0.z()
            r0.q()
            r1.i()
            r1.h()
            long r9 = r1.f5471h
            r11 = 0
            r12 = 0
            int r0 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r0 != 0) goto Ld2
            f2.h5 r0 = r1.f5030a
            f2.wa r9 = r0.N()
            f2.h5 r0 = r1.f5030a
            android.content.Context r0 = r0.c()
            f2.h5 r10 = r1.f5030a
            android.content.Context r10 = r10.c()
            java.lang.String r10 = r10.getPackageName()
            r9.h()
            t1.f.h(r0)
            t1.f.d(r10)
            android.content.pm.PackageManager r14 = r0.getPackageManager()
            java.security.MessageDigest r15 = f2.wa.t()
            r16 = -1
            if (r15 != 0) goto L79
            f2.h5 r0 = r9.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.r()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.a(r9)
        L76:
            r9 = r16
            goto Ld0
        L79:
            if (r14 == 0) goto Lcf
            boolean r10 = r9.W(r0, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            if (r10 != 0) goto Lbd
            x1.d r0 = x1.e.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            f2.h5 r10 = r9.f5030a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            android.content.Context r10 = r10.c()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            java.lang.String r10 = r10.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            r14 = 64
            android.content.pm.PackageInfo r0 = r0.c(r10, r14)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            if (r0 == 0) goto Lad
            int r10 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            if (r10 <= 0) goto Lad
            r0 = r0[r11]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            byte[] r0 = r0.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            byte[] r0 = r15.digest(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            long r16 = f2.wa.s0(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            goto L76
        Lab:
            r0 = move-exception
            goto Lc0
        Lad:
            f2.h5 r0 = r9.f5030a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            f2.v3 r0 = r0.d()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            f2.t3 r0 = r0.w()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            java.lang.String r10 = "Could not get signatures"
            r0.a(r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lab
            goto L76
        Lbd:
            r16 = r12
            goto L76
        Lc0:
            f2.h5 r9 = r9.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.r()
            java.lang.String r10 = "Package name not found"
            r9.b(r10, r0)
        Lcf:
            r9 = r12
        Ld0:
            r1.f5471h = r9
        Ld2:
            f2.h5 r0 = r1.f5030a
            boolean r14 = r0.o()
            f2.h5 r0 = r1.f5030a
            f2.l4 r0 = r0.F()
            boolean r0 = r0.f5443q
            r15 = 1
            r0 = r0 ^ r15
            r1.h()
            r16 = r12
            f2.h5 r12 = r1.f5030a
            boolean r12 = r12.o()
            r13 = 0
            if (r12 != 0) goto Lf6
            r20 = r0
            r18 = 0
            goto L183
        Lf6:
            com.google.android.gms.internal.measurement.qe.b()
            f2.h5 r12 = r1.f5030a
            f2.g r12 = r12.z()
            r18 = 0
            f2.h3 r11 = f2.i3.f5304e0
            boolean r11 = r12.B(r13, r11)
            if (r11 == 0) goto L11b
            f2.h5 r11 = r1.f5030a
            f2.v3 r11 = r11.d()
            f2.t3 r11 = r11.v()
            java.lang.String r12 = "Disabled IID for tests."
            r11.a(r12)
        L118:
            r20 = r0
            goto L183
        L11b:
            f2.h5 r11 = r1.f5030a     // Catch: java.lang.ClassNotFoundException -> L17f
            android.content.Context r11 = r11.c()     // Catch: java.lang.ClassNotFoundException -> L17f
            java.lang.ClassLoader r11 = r11.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L17f
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r11 = r11.loadClass(r12)     // Catch: java.lang.ClassNotFoundException -> L17f
            if (r11 != 0) goto L12e
            goto L118
        L12e:
            java.lang.String r12 = "getInstance"
            java.lang.Class[] r13 = new java.lang.Class[r15]     // Catch: java.lang.Exception -> L16d
            java.lang.Class<android.content.Context> r20 = android.content.Context.class
            r13[r18] = r20     // Catch: java.lang.Exception -> L16d
            java.lang.reflect.Method r12 = r11.getDeclaredMethod(r12, r13)     // Catch: java.lang.Exception -> L16d
            f2.h5 r13 = r1.f5030a     // Catch: java.lang.Exception -> L16d
            android.content.Context r13 = r13.c()     // Catch: java.lang.Exception -> L16d
            r20 = r0
            java.lang.Object[] r0 = new java.lang.Object[r15]     // Catch: java.lang.Exception -> L16f
            r0[r18] = r13     // Catch: java.lang.Exception -> L16f
            r13 = 0
            java.lang.Object r0 = r12.invoke(r13, r0)     // Catch: java.lang.Exception -> L16f
            if (r0 != 0) goto L14e
            goto L183
        L14e:
            java.lang.String r12 = "getFirebaseInstanceId"
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r12, r13)     // Catch: java.lang.Exception -> L15c
            java.lang.Object r0 = r11.invoke(r0, r13)     // Catch: java.lang.Exception -> L15c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L15c
            r13 = r0
            goto L183
        L15c:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.x()
            java.lang.String r11 = "Failed to retrieve Firebase Instance Id"
            r0.a(r11)
        L16b:
            r13 = 0
            goto L183
        L16d:
            r20 = r0
        L16f:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.y()
            java.lang.String r11 = "Failed to obtain Firebase Analytics instance"
            r0.a(r11)
            goto L16b
        L17f:
            r20 = r0
            goto L16b
        L183:
            f2.h5 r0 = r1.f5030a
            f2.l4 r11 = r0.F()
            f2.h4 r11 = r11.f5431e
            long r11 = r11.a()
            int r21 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r21 != 0) goto L19a
            long r11 = r0.G
            r21 = r2
            r22 = r3
            goto L1a4
        L19a:
            r21 = r2
            r22 = r3
            long r2 = r0.G
            long r11 = java.lang.Math.min(r2, r11)
        L1a4:
            r1.i()
            int r0 = r1.f5475l
            f2.h5 r2 = r1.f5030a
            f2.g r2 = r2.z()
            boolean r2 = r2.A()
            f2.h5 r3 = r1.f5030a
            f2.l4 r3 = r3.F()
            r3.h()
            android.content.SharedPreferences r3 = r3.o()
            r23 = 1
            java.lang.String r15 = "deferred_analytics_collection"
            r24 = r2
            r2 = 0
            boolean r3 = r3.getBoolean(r15, r2)
            r1.i()
            java.lang.String r2 = r1.f5477n
            f2.h5 r15 = r1.f5030a
            f2.g r15 = r15.z()
            r25 = r0
            java.lang.String r0 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r0 = r15.t(r0)
            if (r0 != 0) goto L1e5
            r0 = 0
        L1e1:
            r15 = r2
            r23 = r3
            goto L1f0
        L1e5:
            boolean r0 = r0.booleanValue()
            r0 = r0 ^ 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L1e1
        L1f0:
            long r2 = r1.f5472i
            r26 = r0
            java.util.List r0 = r1.f5473j
            r28 = r0
            f2.h5 r0 = r1.f5030a
            f2.l4 r0 = r0.F()
            f2.f6 r0 = r0.q()
            java.lang.String r30 = r0.i()
            java.lang.String r0 = r1.f5474k
            if (r0 != 0) goto L216
            f2.h5 r0 = r1.f5030a
            f2.wa r0 = r0.N()
            java.lang.String r0 = r0.q()
            r1.f5474k = r0
        L216:
            java.lang.String r0 = r1.f5474k
            com.google.android.gms.internal.measurement.ae.b()
            r31 = r0
            f2.h5 r0 = r1.f5030a
            f2.g r0 = r0.z()
            r32 = r2
            f2.h3 r2 = f2.i3.f5326p0
            r3 = 0
            boolean r0 = r0.B(r3, r2)
            if (r0 == 0) goto L26e
            r1.h()
            long r2 = r1.f5479p
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 != 0) goto L238
            goto L25a
        L238:
            f2.h5 r0 = r1.f5030a
            w1.c r0 = r0.a()
            long r2 = r0.a()
            r34 = r2
            long r2 = r1.f5479p
            long r2 = r34 - r2
            java.lang.String r0 = r1.f5478o
            if (r0 == 0) goto L25a
            r34 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r2 > r34 ? 1 : (r2 == r34 ? 0 : -1))
            if (r0 <= 0) goto L25a
            java.lang.String r0 = r1.f5480q
            if (r0 != 0) goto L25a
            r1.v()
        L25a:
            java.lang.String r0 = r1.f5478o
            if (r0 != 0) goto L261
            r1.v()
        L261:
            java.lang.String r0 = r1.f5478o
            r2 = r21
            r21 = r25
            r25 = r26
            r26 = r32
            r32 = r0
            goto L278
        L26e:
            r2 = r21
            r21 = r25
            r25 = r26
            r26 = r32
            r32 = 0
        L278:
            f2.h5 r0 = r1.f5030a
            f2.g r0 = r0.z()
            f2.h5 r3 = r0.f5030a
            java.lang.String r3 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r0 = r0.t(r3)
            if (r0 != 0) goto L28b
            r33 = 0
            goto L291
        L28b:
            boolean r0 = r0.booleanValue()
            r33 = r0
        L291:
            com.google.android.gms.internal.measurement.ed.b()
            f2.h5 r0 = r1.f5030a
            f2.g r0 = r0.z()
            f2.h3 r3 = f2.i3.F0
            r29 = r2
            r2 = 0
            boolean r0 = r0.B(r2, r3)
            if (r0 == 0) goto L2e9
            f2.h5 r0 = r1.f5030a
            f2.wa r0 = r0.N()
            java.lang.String r2 = r1.s()
            f2.h5 r3 = r0.f5030a
            android.content.Context r3 = r3.c()
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            if (r3 != 0) goto L2bc
            goto L2e9
        L2bc:
            f2.h5 r3 = r0.f5030a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2d1
            android.content.Context r3 = r3.c()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2d1
            x1.d r3 = x1.e.a(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2d1
            r1 = 0
            android.content.pm.ApplicationInfo r3 = r3.b(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2d2
            if (r3 == 0) goto L2e6
            int r0 = r3.targetSdkVersion     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2d2
            r1 = r0
            goto L2e6
        L2d1:
            r1 = 0
        L2d2:
            f2.h5 r3 = r0.f5030a
            r3.b()
            f2.h5 r0 = r0.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.u()
            java.lang.String r3 = "PackageManager failed to find running app: app_id"
            r0.b(r3, r2)
        L2e6:
            long r0 = (long) r1
            r16 = r0
        L2e9:
            r34 = r16
            r17 = 0
            r2 = r29
            r29 = 0
            r3 = r22
            r22 = r24
            r24 = r15
            r15 = r20
            r19 = r11
            r11 = r9
            r9 = 79000(0x13498, double:3.9031E-319)
            r16 = r13
            r13 = r37
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34)
            return r2
    }

    public final java.lang.String r() {
            r1 = this;
            r1.i()
            java.lang.String r0 = r1.f5477n
            return r0
    }

    public final java.lang.String s() {
            r1 = this;
            r1.i()
            java.lang.String r0 = r1.f5466c
            t1.f.h(r0)
            java.lang.String r0 = r1.f5466c
            return r0
    }

    public final java.lang.String t() {
            r1 = this;
            r1.h()
            r1.i()
            java.lang.String r0 = r1.f5476m
            t1.f.h(r0)
            java.lang.String r0 = r1.f5476m
            return r0
    }

    public final java.util.List u() {
            r1 = this;
            java.util.List r0 = r1.f5473j
            return r0
    }

    public final void v() {
            r5 = this;
            r5.h()
            f2.h5 r0 = r5.f5030a
            f2.l4 r0 = r0.F()
            f2.f6 r0 = r0.q()
            com.google.android.gms.measurement.internal.zzha r1 = com.google.android.gms.measurement.internal.zzha.zzb
            boolean r0 = r0.j(r1)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L28
            f2.h5 r0 = r5.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r3 = "Analytics Storage consent is not granted"
            r0.a(r3)
            r0 = 0
            goto L4a
        L28:
            r0 = 16
            byte[] r0 = new byte[r0]
            f2.h5 r3 = r5.f5030a
            f2.wa r3 = r3.N()
            java.security.SecureRandom r3 = r3.u()
            r3.nextBytes(r0)
            java.util.Locale r3 = java.util.Locale.US
            java.math.BigInteger r4 = new java.math.BigInteger
            r4.<init>(r2, r0)
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r1] = r4
            java.lang.String r4 = "%032x"
            java.lang.String r0 = java.lang.String.format(r3, r4, r0)
        L4a:
            f2.h5 r3 = r5.f5030a
            f2.v3 r3 = r3.d()
            f2.t3 r3 = r3.q()
            if (r0 != 0) goto L59
            java.lang.String r4 = "null"
            goto L5b
        L59:
            java.lang.String r4 = "not null"
        L5b:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r4
            java.lang.String r1 = "Resetting session stitching token to %s"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r3.a(r1)
            r5.f5478o = r0
            f2.h5 r0 = r5.f5030a
            w1.c r0 = r0.a()
            long r0 = r0.a()
            r5.f5479p = r0
            return
    }

    public final boolean w(java.lang.String r3) {
            r2 = this;
            java.lang.String r0 = r2.f5480q
            r1 = 0
            if (r0 == 0) goto Lc
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto Lc
            r1 = 1
        Lc:
            r2.f5480q = r3
            return r1
    }
}
