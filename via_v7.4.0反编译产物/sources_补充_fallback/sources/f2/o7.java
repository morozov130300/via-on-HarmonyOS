package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o7 extends f2.c4 {

    /* renamed from: c, reason: collision with root package name */
    public f2.n7 f5551c;

    /* renamed from: d, reason: collision with root package name */
    public f2.j6 f5552d;

    /* renamed from: e, reason: collision with root package name */
    public final java.util.Set f5553e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5554f;

    /* renamed from: g, reason: collision with root package name */
    public final java.util.concurrent.atomic.AtomicReference f5555g;

    /* renamed from: h, reason: collision with root package name */
    public final java.lang.Object f5556h;

    /* renamed from: i, reason: collision with root package name */
    public f2.f6 f5557i;

    /* renamed from: j, reason: collision with root package name */
    public final java.util.concurrent.atomic.AtomicLong f5558j;

    /* renamed from: k, reason: collision with root package name */
    public long f5559k;

    /* renamed from: l, reason: collision with root package name */
    public final f2.cb f5560l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5561m;

    /* renamed from: n, reason: collision with root package name */
    public final f2.va f5562n;

    public o7(f2.h5 r4) {
            r3 = this;
            r3.<init>(r4)
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>()
            r3.f5553e = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f5556h = r0
            r0 = 1
            r3.f5561m = r0
            f2.c7 r0 = new f2.c7
            r0.<init>(r3)
            r3.f5562n = r0
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r3.f5555g = r0
            f2.f6 r0 = f2.f6.f5178c
            r3.f5557i = r0
            r0 = -1
            r3.f5559k = r0
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            r3.f5558j = r0
            f2.cb r0 = new f2.cb
            r0.<init>(r4)
            r3.f5560l = r0
            return
    }

    public static /* bridge */ /* synthetic */ void b0(f2.o7 r7, f2.f6 r8, f2.f6 r9) {
            r0 = 2
            com.google.android.gms.measurement.internal.zzha[] r1 = new com.google.android.gms.measurement.internal.zzha[r0]
            com.google.android.gms.measurement.internal.zzha r2 = com.google.android.gms.measurement.internal.zzha.zzb
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.measurement.internal.zzha r2 = com.google.android.gms.measurement.internal.zzha.zza
            r4 = 1
            r1[r4] = r2
            r2 = 0
        Le:
            if (r2 >= r0) goto L23
            r5 = r1[r2]
            boolean r6 = r9.j(r5)
            if (r6 != 0) goto L20
            boolean r5 = r8.j(r5)
            if (r5 == 0) goto L20
            r1 = 1
            goto L24
        L20:
            int r2 = r2 + 1
            goto Le
        L23:
            r1 = 0
        L24:
            com.google.android.gms.measurement.internal.zzha[] r0 = new com.google.android.gms.measurement.internal.zzha[r0]
            com.google.android.gms.measurement.internal.zzha r2 = com.google.android.gms.measurement.internal.zzha.zzb
            r0[r3] = r2
            com.google.android.gms.measurement.internal.zzha r2 = com.google.android.gms.measurement.internal.zzha.zza
            r0[r4] = r2
            boolean r8 = r8.n(r9, r0)
            if (r1 != 0) goto L38
            if (r8 == 0) goto L37
            goto L38
        L37:
            return
        L38:
            f2.h5 r7 = r7.f5030a
            f2.m3 r7 = r7.B()
            r7.v()
            return
    }

    public static /* synthetic */ void c0(f2.o7 r4, f2.f6 r5, long r6, boolean r8, boolean r9) {
            r4.h()
            r4.i()
            f2.h5 r0 = r4.f5030a
            f2.l4 r0 = r0.F()
            f2.f6 r0 = r0.q()
            long r1 = r4.f5559k
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 > 0) goto L35
            int r0 = r0.a()
            int r1 = r5.a()
            boolean r0 = f2.f6.k(r0, r1)
            if (r0 != 0) goto L25
            goto L35
        L25:
            f2.h5 r4 = r4.f5030a
            f2.v3 r4 = r4.d()
            f2.t3 r4 = r4.u()
            java.lang.String r6 = "Dropped out-of-date consent setting, proposed settings"
            r4.b(r6, r5)
            return
        L35:
            f2.h5 r0 = r4.f5030a
            f2.l4 r0 = r0.F()
            f2.h5 r1 = r0.f5030a
            r0.h()
            int r1 = r5.a()
            boolean r2 = r0.w(r1)
            if (r2 == 0) goto L7f
            android.content.SharedPreferences r0 = r0.o()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r5 = r5.i()
            java.lang.String r2 = "consent_settings"
            r0.putString(r2, r5)
            java.lang.String r5 = "consent_source"
            r0.putInt(r5, r1)
            r0.apply()
            r4.f5559k = r6
            f2.h5 r5 = r4.f5030a
            f2.d9 r5 = r5.L()
            r5.t(r8)
            if (r9 == 0) goto L7e
            f2.h5 r4 = r4.f5030a
            f2.d9 r4 = r4.L()
            java.util.concurrent.atomic.AtomicReference r5 = new java.util.concurrent.atomic.AtomicReference
            r5.<init>()
            r4.S(r5)
        L7e:
            return
        L7f:
            f2.h5 r4 = r4.f5030a
            f2.v3 r4 = r4.d()
            f2.t3 r4 = r4.u()
            int r5 = r5.a()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Lower precedence consent source ignored, proposed source"
            r4.b(r6, r5)
            return
    }

    public static /* bridge */ /* synthetic */ void d0(f2.o7 r0, java.lang.Boolean r1, boolean r2) {
            r2 = 1
            r0.O(r1, r2)
            return
    }

    public static /* bridge */ /* synthetic */ void e0(f2.o7 r0) {
            r0.P()
            return
    }

    public final void A(java.lang.String r13, java.lang.String r14, long r15, android.os.Bundle r17, boolean r18, boolean r19, boolean r20, java.lang.String r21) {
            r12 = this;
            android.os.Bundle r6 = new android.os.Bundle
            r0 = r17
            r6.<init>(r0)
            java.util.Set r0 = r6.keySet()
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r6.get(r1)
            boolean r3 = r2 instanceof android.os.Bundle
            if (r3 == 0) goto L2e
            android.os.Bundle r3 = new android.os.Bundle
            android.os.Bundle r2 = (android.os.Bundle) r2
            r3.<init>(r2)
            r6.putBundle(r1, r3)
            goto Lf
        L2e:
            boolean r1 = r2 instanceof android.os.Parcelable[]
            r3 = 0
            if (r1 == 0) goto L4a
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
        L35:
            int r1 = r2.length
            if (r3 >= r1) goto Lf
            r1 = r2[r3]
            boolean r4 = r1 instanceof android.os.Bundle
            if (r4 == 0) goto L47
            android.os.Bundle r4 = new android.os.Bundle
            android.os.Bundle r1 = (android.os.Bundle) r1
            r4.<init>(r1)
            r2[r3] = r4
        L47:
            int r3 = r3 + 1
            goto L35
        L4a:
            boolean r1 = r2 instanceof java.util.List
            if (r1 == 0) goto Lf
            java.util.List r2 = (java.util.List) r2
        L50:
            int r1 = r2.size()
            if (r3 >= r1) goto Lf
            java.lang.Object r1 = r2.get(r3)
            boolean r4 = r1 instanceof android.os.Bundle
            if (r4 == 0) goto L68
            android.os.Bundle r4 = new android.os.Bundle
            android.os.Bundle r1 = (android.os.Bundle) r1
            r4.<init>(r1)
            r2.set(r3, r4)
        L68:
            int r3 = r3 + 1
            goto L50
        L6b:
            f2.h5 r0 = r12.f5030a
            f2.e5 r11 = r0.f()
            f2.t6 r0 = new f2.t6
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r10)
            r11.z(r0)
            return
    }

    public final void B(java.lang.String r9, java.lang.String r10, long r11, java.lang.Object r13) {
            r8 = this;
            f2.h5 r0 = r8.f5030a
            f2.e5 r0 = r0.f()
            f2.u6 r1 = new f2.u6
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r11
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6)
            r0.z(r1)
            return
    }

    public final void C(java.lang.String r2) {
            r1 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r1.f5555g
            r0.set(r2)
            return
    }

    public final void D(android.os.Bundle r3) {
            r2 = this;
            f2.h5 r0 = r2.f5030a
            w1.c r0 = r0.a()
            long r0 = r0.a()
            r2.E(r3, r0)
            return
    }

    public final void E(android.os.Bundle r12, long r13) {
            r11 = this;
            t1.f.h(r12)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>(r12)
            java.lang.String r12 = "app_id"
            java.lang.String r1 = r0.getString(r12)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L23
            f2.h5 r1 = r11.f5030a
            f2.v3 r1 = r1.d()
            f2.t3 r1 = r1.w()
            java.lang.String r2 = "Package name should be null when calling setConditionalUserProperty"
            r1.a(r2)
        L23:
            r0.remove(r12)
            t1.f.h(r0)
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r2 = 0
            f2.d6.a(r0, r12, r1, r2)
            java.lang.String r12 = "origin"
            f2.d6.a(r0, r12, r1, r2)
            java.lang.String r3 = "name"
            f2.d6.a(r0, r3, r1, r2)
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            java.lang.String r5 = "value"
            f2.d6.a(r0, r5, r4, r2)
            java.lang.String r4 = "trigger_event_name"
            f2.d6.a(r0, r4, r1, r2)
            r6 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.String r7 = "trigger_timeout"
            java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
            f2.d6.a(r0, r7, r8, r6)
            java.lang.String r9 = "timed_out_event_name"
            f2.d6.a(r0, r9, r1, r2)
            java.lang.String r9 = "timed_out_event_params"
            java.lang.Class<android.os.Bundle> r10 = android.os.Bundle.class
            f2.d6.a(r0, r9, r10, r2)
            java.lang.String r9 = "triggered_event_name"
            f2.d6.a(r0, r9, r1, r2)
            java.lang.String r9 = "triggered_event_params"
            f2.d6.a(r0, r9, r10, r2)
            java.lang.String r9 = "time_to_live"
            f2.d6.a(r0, r9, r8, r6)
            java.lang.String r6 = "expired_event_name"
            f2.d6.a(r0, r6, r1, r2)
            java.lang.String r1 = "expired_event_params"
            f2.d6.a(r0, r1, r10, r2)
            java.lang.String r1 = r0.getString(r3)
            t1.f.d(r1)
            java.lang.String r12 = r0.getString(r12)
            t1.f.d(r12)
            java.lang.Object r12 = r0.get(r5)
            t1.f.h(r12)
            java.lang.String r12 = "creation_timestamp"
            r0.putLong(r12, r13)
            java.lang.String r12 = r0.getString(r3)
            java.lang.Object r13 = r0.get(r5)
            f2.h5 r14 = r11.f5030a
            f2.wa r14 = r14.N()
            int r14 = r14.p0(r12)
            if (r14 != 0) goto L173
            f2.h5 r14 = r11.f5030a
            f2.wa r14 = r14.N()
            int r14 = r14.l0(r12, r13)
            if (r14 != 0) goto L159
            f2.h5 r14 = r11.f5030a
            f2.wa r14 = r14.N()
            java.lang.Object r14 = r14.p(r12, r13)
            if (r14 != 0) goto Ld7
            f2.h5 r14 = r11.f5030a
            f2.v3 r14 = r14.d()
            f2.t3 r14 = r14.r()
            f2.h5 r0 = r11.f5030a
            f2.q3 r0 = r0.D()
            java.lang.String r12 = r0.f(r12)
            java.lang.String r0 = "Unable to normalize conditional user property value"
            r14.c(r0, r12, r13)
            return
        Ld7:
            f2.d6.b(r0, r14)
            long r13 = r0.getLong(r7)
            java.lang.String r1 = r0.getString(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 1
            r4 = 15552000000(0x39ef8b000, double:7.683708924E-314)
            if (r1 != 0) goto L11a
            f2.h5 r1 = r11.f5030a
            r1.z()
            int r1 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r1 > 0) goto Lfc
            int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r1 >= 0) goto L11a
        Lfc:
            f2.h5 r0 = r11.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.r()
            f2.h5 r1 = r11.f5030a
            f2.q3 r1 = r1.D()
            java.lang.String r12 = r1.f(r12)
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            java.lang.String r14 = "Invalid conditional user property timeout"
            r0.c(r14, r12, r13)
            return
        L11a:
            long r13 = r0.getLong(r9)
            f2.h5 r1 = r11.f5030a
            r1.z()
            int r1 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r1 > 0) goto L13b
            int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r1 >= 0) goto L12c
            goto L13b
        L12c:
            f2.h5 r12 = r11.f5030a
            f2.e5 r12 = r12.f()
            f2.w6 r13 = new f2.w6
            r13.<init>(r11, r0)
            r12.z(r13)
            return
        L13b:
            f2.h5 r0 = r11.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.r()
            f2.h5 r1 = r11.f5030a
            f2.q3 r1 = r1.D()
            java.lang.String r12 = r1.f(r12)
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            java.lang.String r14 = "Invalid conditional user property time to live"
            r0.c(r14, r12, r13)
            return
        L159:
            f2.h5 r14 = r11.f5030a
            f2.v3 r14 = r14.d()
            f2.t3 r14 = r14.r()
            f2.h5 r0 = r11.f5030a
            f2.q3 r0 = r0.D()
            java.lang.String r12 = r0.f(r12)
            java.lang.String r0 = "Invalid conditional user property value"
            r14.c(r0, r12, r13)
            return
        L173:
            f2.h5 r13 = r11.f5030a
            f2.v3 r13 = r13.d()
            f2.t3 r13 = r13.r()
            f2.h5 r14 = r11.f5030a
            f2.q3 r14 = r14.D()
            java.lang.String r12 = r14.f(r12)
            java.lang.String r14 = "Invalid conditional user property name"
            r13.b(r14, r12)
            return
    }

    public final void F(f2.f6 r13, long r14) {
            r12 = this;
            r12.i()
            int r0 = r13.a()
            r1 = -10
            if (r0 == r1) goto L28
            java.lang.Boolean r2 = r13.f()
            if (r2 != 0) goto L28
            java.lang.Boolean r2 = r13.g()
            if (r2 == 0) goto L18
            goto L28
        L18:
            f2.h5 r13 = r12.f5030a
            f2.v3 r13 = r13.d()
            f2.t3 r13 = r13.x()
            java.lang.String r14 = "Discarding empty consent settings"
            r13.a(r14)
            return
        L28:
            java.lang.Object r2 = r12.f5556h
            monitor-enter(r2)
            f2.f6 r9 = r12.f5557i     // Catch: java.lang.Throwable -> Lbb
            int r3 = r9.a()     // Catch: java.lang.Throwable -> Lbb
            boolean r3 = f2.f6.k(r0, r3)     // Catch: java.lang.Throwable -> Lbb
            r4 = 0
            if (r3 == 0) goto L62
            f2.f6 r3 = r12.f5557i     // Catch: java.lang.Throwable -> L51
            boolean r3 = r13.m(r3)     // Catch: java.lang.Throwable -> L51
            com.google.android.gms.measurement.internal.zzha r5 = com.google.android.gms.measurement.internal.zzha.zzb     // Catch: java.lang.Throwable -> L51
            boolean r6 = r13.j(r5)     // Catch: java.lang.Throwable -> L51
            r7 = 1
            if (r6 == 0) goto L56
            f2.f6 r6 = r12.f5557i     // Catch: java.lang.Throwable -> L51
            boolean r5 = r6.j(r5)     // Catch: java.lang.Throwable -> L51
            if (r5 != 0) goto L56
            r4 = 1
            goto L56
        L51:
            r0 = move-exception
            r13 = r0
            r4 = r12
            goto Lbe
        L56:
            f2.f6 r5 = r12.f5557i     // Catch: java.lang.Throwable -> L51
            f2.f6 r13 = r13.e(r5)     // Catch: java.lang.Throwable -> L51
            r12.f5557i = r13     // Catch: java.lang.Throwable -> L51
            r8 = r4
            r4 = 1
        L60:
            r5 = r13
            goto L65
        L62:
            r3 = 0
            r8 = 0
            goto L60
        L65:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lbb
            if (r4 != 0) goto L78
            f2.h5 r13 = r12.f5030a
            f2.v3 r13 = r13.d()
            f2.t3 r13 = r13.u()
            java.lang.String r14 = "Ignoring lower-priority consent settings, proposed settings"
            r13.b(r14, r5)
            return
        L78:
            java.util.concurrent.atomic.AtomicLong r13 = r12.f5558j
            long r6 = r13.getAndIncrement()
            if (r3 == 0) goto L9a
            java.util.concurrent.atomic.AtomicReference r13 = r12.f5555g
            r0 = 0
            r13.set(r0)
            f2.h5 r13 = r12.f5030a
            f2.e5 r13 = r13.f()
            f2.j7 r3 = new f2.j7
            r4 = r12
            r10 = r8
            r11 = r9
            r8 = r6
            r6 = r14
            r3.<init>(r4, r5, r6, r8, r10, r11)
            r13.A(r3)
            return
        L9a:
            f2.k7 r3 = new f2.k7
            r4 = r12
            r3.<init>(r4, r5, r6, r8, r9)
            r13 = 30
            if (r0 == r13) goto Lb1
            if (r0 != r1) goto La7
            goto Lb1
        La7:
            f2.h5 r13 = r4.f5030a
            f2.e5 r13 = r13.f()
            r13.z(r3)
            return
        Lb1:
            f2.h5 r13 = r4.f5030a
            f2.e5 r13 = r13.f()
            r13.A(r3)
            return
        Lbb:
            r0 = move-exception
            r4 = r12
        Lbd:
            r13 = r0
        Lbe:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc0
            throw r13
        Lc0:
            r0 = move-exception
            goto Lbd
    }

    public final void G(android.os.Bundle r4, int r5, long r6) {
            r3 = this;
            r3.i()
            java.lang.String r0 = f2.f6.h(r4)
            if (r0 == 0) goto L27
            f2.h5 r1 = r3.f5030a
            f2.v3 r1 = r1.d()
            f2.t3 r1 = r1.x()
            java.lang.String r2 = "Ignoring invalid consent setting"
            r1.b(r2, r0)
            f2.h5 r0 = r3.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.x()
            java.lang.String r1 = "Valid consent values are 'granted', 'denied'"
            r0.a(r1)
        L27:
            f2.f6 r4 = f2.f6.b(r4, r5)
            r3.F(r4, r6)
            return
    }

    public final void H(f2.j6 r3) {
            r2 = this;
            r2.h()
            r2.i()
            if (r3 == 0) goto L16
            f2.j6 r0 = r2.f5552d
            if (r3 == r0) goto L16
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r1 = "EventInterceptor already set."
            t1.f.l(r0, r1)
        L16:
            r2.f5552d = r3
            return
    }

    public final void I(java.lang.Boolean r3) {
            r2 = this;
            r2.i()
            f2.h5 r0 = r2.f5030a
            f2.e5 r0 = r0.f()
            f2.i7 r1 = new f2.i7
            r1.<init>(r2, r3)
            r0.z(r1)
            return
    }

    public final void J(f2.f6 r6) {
            r5 = this;
            r5.h()
            com.google.android.gms.measurement.internal.zzha r0 = com.google.android.gms.measurement.internal.zzha.zzb
            boolean r0 = r6.j(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            com.google.android.gms.measurement.internal.zzha r0 = com.google.android.gms.measurement.internal.zzha.zza
            boolean r6 = r6.j(r0)
            if (r6 != 0) goto L16
            goto L18
        L16:
            r6 = 1
            goto L26
        L18:
            f2.h5 r6 = r5.f5030a
            f2.d9 r6 = r6.L()
            boolean r6 = r6.A()
            if (r6 == 0) goto L25
            goto L16
        L25:
            r6 = 0
        L26:
            f2.h5 r0 = r5.f5030a
            boolean r0 = r0.p()
            if (r6 == r0) goto L69
            f2.h5 r0 = r5.f5030a
            r0.l(r6)
            f2.h5 r0 = r5.f5030a
            f2.l4 r0 = r0.F()
            f2.h5 r3 = r0.f5030a
            r0.h()
            android.content.SharedPreferences r3 = r0.o()
            java.lang.String r4 = "measurement_enabled_from_api"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L57
            android.content.SharedPreferences r0 = r0.o()
            boolean r0 = r0.getBoolean(r4, r2)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L58
        L57:
            r0 = 0
        L58:
            if (r6 == 0) goto L62
            if (r0 == 0) goto L62
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L69
        L62:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r5.O(r6, r1)
        L69:
            return
    }

    public final void K(java.lang.String r8, java.lang.String r9, java.lang.Object r10, boolean r11) {
            r7 = this;
            f2.h5 r8 = r7.f5030a
            w1.c r8 = r8.a()
            long r5 = r8.a()
            java.lang.String r2 = "_ldl"
            r4 = 1
            java.lang.String r1 = "auto"
            r0 = r7
            r3 = r10
            r0.L(r1, r2, r3, r4, r5)
            return
    }

    public final void L(java.lang.String r17, java.lang.String r18, java.lang.Object r19, boolean r20, long r21) {
            r16 = this;
            r0 = r16
            r2 = r18
            r1 = r19
            r3 = 0
            r4 = 24
            if (r20 == 0) goto L17
            f2.h5 r5 = r0.f5030a
            f2.wa r5 = r5.N()
            int r5 = r5.p0(r2)
            r12 = r5
            goto L43
        L17:
            f2.h5 r5 = r0.f5030a
            f2.wa r5 = r5.N()
            java.lang.String r6 = "user property"
            boolean r7 = r5.S(r6, r2)
            r8 = 6
            if (r7 != 0) goto L28
        L26:
            r12 = 6
            goto L43
        L28:
            java.lang.String[] r7 = f2.i6.f5350a
            r9 = 0
            boolean r7 = r5.P(r6, r7, r9, r2)
            if (r7 != 0) goto L36
            r5 = 15
            r12 = 15
            goto L43
        L36:
            f2.h5 r7 = r5.f5030a
            r7.z()
            boolean r5 = r5.N(r6, r4, r2)
            if (r5 != 0) goto L42
            goto L26
        L42:
            r12 = 0
        L43:
            r5 = 1
            if (r12 == 0) goto L6d
            f2.h5 r1 = r0.f5030a
            f2.wa r1 = r1.N()
            f2.h5 r6 = r0.f5030a
            r6.z()
            java.lang.String r14 = r1.r(r2, r4, r5)
            if (r2 == 0) goto L5d
            int r3 = r2.length()
            r15 = r3
            goto L5e
        L5d:
            r15 = 0
        L5e:
            f2.h5 r1 = r0.f5030a
            f2.wa r9 = r1.N()
            f2.va r10 = r0.f5562n
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.C(r10, r11, r12, r13, r14, r15)
            return
        L6d:
            if (r17 != 0) goto L72
            java.lang.String r6 = "app"
            goto L74
        L72:
            r6 = r17
        L74:
            if (r1 == 0) goto Lc7
            f2.h5 r7 = r0.f5030a
            f2.wa r7 = r7.N()
            int r11 = r7.l0(r2, r1)
            if (r11 == 0) goto Lb4
            f2.h5 r6 = r0.f5030a
            f2.wa r6 = r6.N()
            f2.h5 r7 = r0.f5030a
            r7.z()
            java.lang.String r13 = r6.r(r2, r4, r5)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L9c
            boolean r2 = r1 instanceof java.lang.CharSequence
            if (r2 == 0) goto L9a
            goto L9c
        L9a:
            r14 = 0
            goto La5
        L9c:
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            r14 = r3
        La5:
            f2.h5 r1 = r0.f5030a
            f2.wa r8 = r1.N()
            f2.va r9 = r0.f5562n
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.C(r9, r10, r11, r12, r13, r14)
            return
        Lb4:
            f2.h5 r3 = r0.f5030a
            f2.wa r3 = r3.N()
            java.lang.Object r5 = r3.p(r2, r1)
            if (r5 == 0) goto Lc6
            r3 = r21
            r1 = r6
            r0.B(r1, r2, r3, r5)
        Lc6:
            return
        Lc7:
            r1 = r6
            r5 = 0
            r0 = r16
            r2 = r18
            r3 = r21
            r0.B(r1, r2, r3, r5)
            return
    }

    public final void M(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
            r8 = this;
            t1.f.d(r9)
            t1.f.d(r10)
            r8.h()
            r8.i()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L62
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r4 = java.lang.Long.valueOf(r10)
            f2.h5 r5 = r8.f5030a
            f2.l4 r5 = r5.F()
            f2.k4 r5 = r5.f5439m
            int r6 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r6 != 0) goto L4a
            java.lang.String r0 = "true"
        L4a:
            r5.b(r0)
            r3 = r1
            r6 = r4
            goto L64
        L50:
            if (r11 != 0) goto L62
            f2.h5 r10 = r8.f5030a
            f2.l4 r10 = r10.F()
            f2.k4 r10 = r10.f5439m
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
            r3 = r1
            goto L64
        L62:
            r3 = r10
            r6 = r11
        L64:
            f2.h5 r10 = r8.f5030a
            boolean r10 = r10.o()
            if (r10 != 0) goto L7c
            f2.h5 r9 = r8.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.v()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7c:
            f2.h5 r10 = r8.f5030a
            boolean r10 = r10.r()
            if (r10 != 0) goto L85
            return
        L85:
            com.google.android.gms.measurement.internal.zzlk r2 = new com.google.android.gms.measurement.internal.zzlk
            r7 = r9
            r4 = r12
            r2.<init>(r3, r4, r6, r7)
            f2.h5 r9 = r8.f5030a
            f2.d9 r9 = r9.L()
            r9.y(r2)
            return
    }

    public final void N(f2.k6 r2) {
            r1 = this;
            r1.i()
            t1.f.h(r2)
            java.util.Set r0 = r1.f5553e
            boolean r2 = r0.remove(r2)
            if (r2 != 0) goto L1d
            f2.h5 r2 = r1.f5030a
            f2.v3 r2 = r2.d()
            f2.t3 r2 = r2.w()
            java.lang.String r0 = "OnEventListener had not been registered"
            r2.a(r0)
        L1d:
            return
    }

    public final void O(java.lang.Boolean r3, boolean r4) {
            r2 = this;
            r2.h()
            r2.i()
            f2.h5 r0 = r2.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r1 = "Setting app measurement enabled (FE)"
            r0.b(r1, r3)
            f2.h5 r0 = r2.f5030a
            f2.l4 r0 = r0.F()
            r0.s(r3)
            if (r4 == 0) goto L45
            f2.h5 r4 = r2.f5030a
            f2.l4 r4 = r4.F()
            f2.h5 r0 = r4.f5030a
            r4.h()
            android.content.SharedPreferences r4 = r4.o()
            android.content.SharedPreferences$Editor r4 = r4.edit()
            java.lang.String r0 = "measurement_enabled_from_api"
            if (r3 == 0) goto L3f
            boolean r1 = r3.booleanValue()
            r4.putBoolean(r0, r1)
            goto L42
        L3f:
            r4.remove(r0)
        L42:
            r4.apply()
        L45:
            f2.h5 r4 = r2.f5030a
            boolean r4 = r4.p()
            if (r4 != 0) goto L57
            if (r3 == 0) goto L56
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L56
            goto L57
        L56:
            return
        L57:
            r2.P()
            return
    }

    public final void P() {
            r13 = this;
            r13.h()
            f2.h5 r0 = r13.f5030a
            f2.l4 r0 = r0.F()
            f2.k4 r0 = r0.f5439m
            java.lang.String r0 = r0.a()
            if (r0 == 0) goto L53
            java.lang.String r1 = "unset"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L2d
            f2.h5 r0 = r13.f5030a
            w1.c r0 = r0.a()
            long r5 = r0.a()
            java.lang.String r3 = "_npa"
            r4 = 0
            java.lang.String r2 = "app"
            r1 = r13
            r1.M(r2, r3, r4, r5)
            goto L54
        L2d:
            r1 = r13
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)
            r2 = 1
            if (r2 == r0) goto L3a
            r2 = 0
            goto L3c
        L3a:
            r2 = 1
        L3c:
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            f2.h5 r0 = r1.f5030a
            w1.c r0 = r0.a()
            long r11 = r0.a()
            java.lang.String r8 = "app"
            java.lang.String r9 = "_npa"
            r7 = r1
            r7.M(r8, r9, r10, r11)
            goto L54
        L53:
            r1 = r13
        L54:
            f2.h5 r0 = r1.f5030a
            boolean r0 = r0.o()
            if (r0 == 0) goto L9e
            boolean r0 = r1.f5561m
            if (r0 == 0) goto L9e
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r2 = "Recording app launch after enabling measurement for the first time (FE)"
            r0.a(r2)
            r13.f0()
            com.google.android.gms.internal.measurement.mc.b()
            f2.h5 r0 = r1.f5030a
            f2.g r0 = r0.z()
            r2 = 0
            f2.h3 r3 = f2.i3.f5310h0
            boolean r0 = r0.B(r2, r3)
            if (r0 == 0) goto L8f
            f2.h5 r0 = r1.f5030a
            f2.u9 r0 = r0.M()
            f2.t9 r0 = r0.f5740e
            r0.a()
        L8f:
            f2.h5 r0 = r1.f5030a
            f2.e5 r0 = r0.f()
            f2.r6 r2 = new f2.r6
            r2.<init>(r13)
            r0.z(r2)
            return
        L9e:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r2 = "Updating Scion state (FE)"
            r0.a(r2)
            f2.h5 r0 = r1.f5030a
            f2.d9 r0 = r0.L()
            r0.w()
            return
    }

    public final int Q(java.lang.String r1) {
            r0 = this;
            t1.f.d(r1)
            f2.h5 r1 = r0.f5030a
            r1.z()
            r1 = 25
            return r1
    }

    public final java.lang.Boolean R() {
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r6.f5030a
            f2.e5 r0 = r0.f()
            f2.z6 r5 = new f2.z6
            r5.<init>(r6, r1)
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.String r4 = "boolean test flag value"
            java.lang.Object r0 = r0.r(r1, r2, r4, r5)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            return r0
    }

    public final java.lang.Double S() {
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r6.f5030a
            f2.e5 r0 = r0.f()
            f2.h7 r5 = new f2.h7
            r5.<init>(r6, r1)
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.String r4 = "double test flag value"
            java.lang.Object r0 = r0.r(r1, r2, r4, r5)
            java.lang.Double r0 = (java.lang.Double) r0
            return r0
    }

    public final java.lang.Integer T() {
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r6.f5030a
            f2.e5 r0 = r0.f()
            f2.g7 r5 = new f2.g7
            r5.<init>(r6, r1)
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.String r4 = "int test flag value"
            java.lang.Object r0 = r0.r(r1, r2, r4, r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            return r0
    }

    public final java.lang.Long U() {
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r6.f5030a
            f2.e5 r0 = r0.f()
            f2.f7 r5 = new f2.f7
            r5.<init>(r6, r1)
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.String r4 = "long test flag value"
            java.lang.Object r0 = r0.r(r1, r2, r4, r5)
            java.lang.Long r0 = (java.lang.Long) r0
            return r0
    }

    public final java.lang.String V() {
            r1 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r1.f5555g
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            return r0
    }

    public final java.lang.String W() {
            r1 = this;
            f2.h5 r0 = r1.f5030a
            f2.d8 r0 = r0.K()
            f2.v7 r0 = r0.r()
            if (r0 == 0) goto Lf
            java.lang.String r0 = r0.f5766b
            return r0
        Lf:
            r0 = 0
            return r0
    }

    public final java.lang.String X() {
            r1 = this;
            f2.h5 r0 = r1.f5030a
            f2.d8 r0 = r0.K()
            f2.v7 r0 = r0.r()
            if (r0 == 0) goto Lf
            java.lang.String r0 = r0.f5765a
            return r0
        Lf:
            r0 = 0
            return r0
    }

    public final java.lang.String Y() {
            r6 = this;
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r6.f5030a
            f2.e5 r0 = r0.f()
            f2.e7 r5 = new f2.e7
            r5.<init>(r6, r1)
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.String r4 = "String test flag value"
            java.lang.Object r0 = r0.r(r1, r2, r4, r5)
            java.lang.String r0 = (java.lang.String) r0
            return r0
    }

    public final java.util.ArrayList Z(java.lang.String r9, java.lang.String r10) {
            r8 = this;
            f2.h5 r0 = r8.f5030a
            f2.e5 r0 = r0.f()
            boolean r0 = r0.C()
            r1 = 0
            if (r0 == 0) goto L22
            f2.h5 r9 = r8.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.r()
            java.lang.String r10 = "Cannot get conditional user properties from analytics worker thread"
            r9.a(r10)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>(r1)
            return r9
        L22:
            f2.h5 r0 = r8.f5030a
            r0.b()
            boolean r0 = f2.c.a()
            if (r0 == 0) goto L42
            f2.h5 r9 = r8.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.r()
            java.lang.String r10 = "Cannot get conditional user properties from main thread"
            r9.a(r10)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>(r1)
            return r9
        L42:
            java.util.concurrent.atomic.AtomicReference r3 = new java.util.concurrent.atomic.AtomicReference
            r3.<init>()
            f2.h5 r0 = r8.f5030a
            f2.e5 r0 = r0.f()
            f2.y6 r2 = new f2.y6
            r5 = 0
            r6 = r9
            r7 = r10
            r4 = r3
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r9 = r3
            r3 = r4
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.String r6 = "get conditional user properties"
            r7 = r2
            r2 = r0
            r2.r(r3, r4, r6, r7)
            java.lang.Object r10 = r3.get()
            java.util.List r10 = (java.util.List) r10
            if (r10 != 0) goto L80
            f2.h5 r10 = r9.f5030a
            f2.v3 r10 = r10.d()
            f2.t3 r10 = r10.r()
            java.lang.String r0 = "Timed out waiting for get conditional user properties"
            r1 = 0
            r10.b(r0, r1)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            return r10
        L80:
            java.util.ArrayList r10 = f2.wa.v(r10)
            return r10
    }

    public final java.util.Map a0(java.lang.String r9, java.lang.String r10, boolean r11) {
            r8 = this;
            f2.h5 r0 = r8.f5030a
            f2.e5 r0 = r0.f()
            boolean r0 = r0.C()
            if (r0 == 0) goto L1e
            f2.h5 r9 = r8.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.r()
            java.lang.String r10 = "Cannot get user properties from analytics worker thread"
            r9.a(r10)
            java.util.Map r9 = java.util.Collections.EMPTY_MAP
            return r9
        L1e:
            f2.h5 r0 = r8.f5030a
            r0.b()
            boolean r0 = f2.c.a()
            if (r0 == 0) goto L3b
            f2.h5 r9 = r8.f5030a
            f2.v3 r9 = r9.d()
            f2.t3 r9 = r9.r()
            java.lang.String r10 = "Cannot get user properties from main thread"
            r9.a(r10)
            java.util.Map r9 = java.util.Collections.EMPTY_MAP
            return r9
        L3b:
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            f2.h5 r0 = r8.f5030a
            f2.e5 r7 = r0.f()
            f2.a7 r0 = new f2.a7
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r2 = r1
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9 = r1
            r1 = r2
            r2 = 5000(0x1388, double:2.4703E-320)
            java.lang.String r4 = "get user properties"
            r5 = r0
            r0 = r7
            r0.r(r1, r2, r4, r5)
            java.lang.Object r10 = r1.get()
            java.util.List r10 = (java.util.List) r10
            if (r10 != 0) goto L7a
            f2.h5 r10 = r9.f5030a
            f2.v3 r10 = r10.d()
            f2.t3 r10 = r10.r()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r6)
            java.lang.String r0 = "Timed out waiting for handle get user properties, includeInternal"
            r10.b(r0, r11)
            java.util.Map r10 = java.util.Collections.EMPTY_MAP
            return r10
        L7a:
            k.a r11 = new k.a
            int r0 = r10.size()
            r11.<init>(r0)
            java.util.Iterator r10 = r10.iterator()
        L87:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L9f
            java.lang.Object r0 = r10.next()
            com.google.android.gms.measurement.internal.zzlk r0 = (com.google.android.gms.measurement.internal.zzlk) r0
            java.lang.Object r1 = r0.c()
            if (r1 == 0) goto L87
            java.lang.String r0 = r0.f3970j
            r11.put(r0, r1)
            goto L87
        L9f:
            return r11
    }

    public final void f0() {
            r5 = this;
            r5.h()
            r5.i()
            f2.h5 r0 = r5.f5030a
            boolean r0 = r0.r()
            if (r0 == 0) goto Lbd
            f2.h5 r0 = r5.f5030a
            f2.g r0 = r0.z()
            f2.h3 r1 = f2.i3.f5298b0
            r2 = 0
            boolean r0 = r0.B(r2, r1)
            if (r0 == 0) goto L53
            f2.h5 r0 = r5.f5030a
            f2.g r0 = r0.z()
            f2.h5 r1 = r0.f5030a
            r1.b()
            java.lang.String r1 = "google_analytics_deferred_deep_link_enabled"
            java.lang.Boolean r0 = r0.t(r1)
            if (r0 == 0) goto L53
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L53
            f2.h5 r0 = r5.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r1 = "Deferred Deep Link feature enabled."
            r0.a(r1)
            f2.h5 r0 = r5.f5030a
            f2.e5 r0 = r0.f()
            f2.q6 r1 = new f2.q6
            r1.<init>(r5)
            r0.z(r1)
        L53:
            f2.h5 r0 = r5.f5030a
            f2.d9 r0 = r0.L()
            r0.O()
            r0 = 0
            r5.f5561m = r0
            f2.h5 r0 = r5.f5030a
            f2.l4 r0 = r0.F()
            r0.h()
            android.content.SharedPreferences r1 = r0.o()
            java.lang.String r3 = "previous_os_version"
            java.lang.String r1 = r1.getString(r3, r2)
            f2.h5 r2 = r0.f5030a
            f2.o r2 = r2.A()
            r2.k()
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L97
            boolean r4 = r2.equals(r1)
            if (r4 != 0) goto L97
            android.content.SharedPreferences r0 = r0.o()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putString(r3, r2)
            r0.apply()
        L97:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto Lbd
            f2.h5 r0 = r5.f5030a
            f2.o r0 = r0.A()
            r0.k()
            boolean r0 = r1.equals(r2)
            if (r0 != 0) goto Lbd
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r2 = "_po"
            r0.putString(r2, r1)
            java.lang.String r1 = "auto"
            java.lang.String r2 = "_ou"
            r5.u(r1, r2, r0)
        Lbd:
            return
    }

    @Override // f2.c4
    public final boolean n() {
            r1 = this;
            r0 = 0
            return r0
    }

    public final void o(java.lang.String r5, java.lang.String r6, android.os.Bundle r7) {
            r4 = this;
            f2.h5 r0 = r4.f5030a
            w1.c r0 = r0.a()
            long r0 = r0.a()
            t1.f.d(r5)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "name"
            r2.putString(r3, r5)
            java.lang.String r5 = "creation_timestamp"
            r2.putLong(r5, r0)
            if (r6 == 0) goto L28
            java.lang.String r5 = "expired_event_name"
            r2.putString(r5, r6)
            java.lang.String r5 = "expired_event_params"
            r2.putBundle(r5, r7)
        L28:
            f2.h5 r5 = r4.f5030a
            f2.e5 r5 = r5.f()
            f2.x6 r6 = new f2.x6
            r6.<init>(r4, r2)
            r5.z(r6)
            return
    }

    public final void p() {
            r2 = this;
            f2.h5 r0 = r2.f5030a
            android.content.Context r0 = r0.c()
            android.content.Context r0 = r0.getApplicationContext()
            boolean r0 = r0 instanceof android.app.Application
            if (r0 == 0) goto L23
            f2.n7 r0 = r2.f5551c
            if (r0 == 0) goto L23
            f2.h5 r0 = r2.f5030a
            android.content.Context r0 = r0.c()
            android.content.Context r0 = r0.getApplicationContext()
            android.app.Application r0 = (android.app.Application) r0
            f2.n7 r1 = r2.f5551c
            r0.unregisterActivityLifecycleCallbacks(r1)
        L23:
            return
    }

    public final /* synthetic */ void q(android.os.Bundle r13) {
            r12 = this;
            if (r13 != 0) goto L13
            f2.h5 r13 = r12.f5030a
            f2.l4 r13 = r13.F()
            f2.g4 r13 = r13.f5450x
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r13.b(r0)
            return
        L13:
            f2.h5 r0 = r12.f5030a
            f2.l4 r0 = r0.F()
            f2.g4 r0 = r0.f5450x
            android.os.Bundle r0 = r0.a()
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L27:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lae
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r13.get(r2)
            if (r3 == 0) goto L72
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L72
            boolean r4 = r3 instanceof java.lang.Long
            if (r4 != 0) goto L72
            boolean r4 = r3 instanceof java.lang.Double
            if (r4 != 0) goto L72
            f2.h5 r4 = r12.f5030a
            f2.wa r4 = r4.N()
            boolean r4 = r4.V(r3)
            if (r4 == 0) goto L62
            f2.h5 r4 = r12.f5030a
            f2.wa r5 = r4.N()
            f2.va r6 = r12.f5562n
            r10 = 0
            r11 = 0
            r7 = 0
            r8 = 27
            r9 = 0
            r5.C(r6, r7, r8, r9, r10, r11)
        L62:
            f2.h5 r4 = r12.f5030a
            f2.v3 r4 = r4.d()
            f2.t3 r4 = r4.x()
            java.lang.String r5 = "Invalid default event parameter type. Name, value"
            r4.c(r5, r2, r3)
            goto L27
        L72:
            boolean r4 = f2.wa.Y(r2)
            if (r4 == 0) goto L88
            f2.h5 r3 = r12.f5030a
            f2.v3 r3 = r3.d()
            f2.t3 r3 = r3.x()
            java.lang.String r4 = "Invalid default event parameter name. Name"
            r3.b(r4, r2)
            goto L27
        L88:
            if (r3 != 0) goto L8e
            r0.remove(r2)
            goto L27
        L8e:
            f2.h5 r4 = r12.f5030a
            f2.wa r4 = r4.N()
            f2.h5 r5 = r12.f5030a
            r5.z()
            java.lang.String r5 = "param"
            r6 = 100
            boolean r4 = r4.Q(r5, r2, r6, r3)
            if (r4 == 0) goto L27
            f2.h5 r4 = r12.f5030a
            f2.wa r4 = r4.N()
            r4.D(r0, r2, r3)
            goto L27
        Lae:
            f2.h5 r13 = r12.f5030a
            r13.N()
            f2.h5 r13 = r12.f5030a
            f2.g r13 = r13.z()
            int r13 = r13.m()
            int r1 = r0.size()
            if (r1 > r13) goto Lc4
            goto L106
        Lc4:
            java.util.TreeSet r1 = new java.util.TreeSet
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        Ld2:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Le6
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            int r2 = r2 + 1
            if (r2 <= r13) goto Ld2
            r0.remove(r3)
            goto Ld2
        Le6:
            f2.h5 r13 = r12.f5030a
            f2.wa r1 = r13.N()
            f2.va r2 = r12.f5562n
            r6 = 0
            r7 = 0
            r3 = 0
            r4 = 26
            r5 = 0
            r1.C(r2, r3, r4, r5, r6, r7)
            f2.h5 r13 = r12.f5030a
            f2.v3 r13 = r13.d()
            f2.t3 r13 = r13.x()
            java.lang.String r1 = "Too many default event parameters set. Discarding beyond event parameter limit"
            r13.a(r1)
        L106:
            f2.h5 r13 = r12.f5030a
            f2.l4 r13 = r13.F()
            f2.g4 r13 = r13.f5450x
            r13.b(r0)
            f2.h5 r13 = r12.f5030a
            f2.d9 r13 = r13.L()
            r13.v(r0)
            return
    }

    public final void r(java.lang.String r10, java.lang.String r11, android.os.Bundle r12) {
            r9 = this;
            f2.h5 r0 = r9.f5030a
            w1.c r0 = r0.a()
            long r7 = r0.a()
            r5 = 1
            r6 = 1
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r1.s(r2, r3, r4, r5, r6, r7)
            return
    }

    public final void s(java.lang.String r11, java.lang.String r12, android.os.Bundle r13, boolean r14, boolean r15, long r16) {
            r10 = this;
            if (r13 != 0) goto L7
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
        L7:
            r5 = r13
            java.lang.String r13 = "screen_view"
            if (r12 == r13) goto L35
            if (r12 == 0) goto L14
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L35
        L14:
            r13 = 1
            if (r15 == 0) goto L21
            f2.j6 r0 = r10.f5552d
            if (r0 == 0) goto L21
            boolean r0 = f2.wa.Y(r12)
            if (r0 == 0) goto L23
        L21:
            r7 = 1
            goto L25
        L23:
            r13 = 0
            r7 = 0
        L25:
            if (r11 != 0) goto L29
            java.lang.String r11 = "app"
        L29:
            r1 = r11
            r9 = 0
            r0 = r10
            r2 = r12
            r8 = r14
            r6 = r15
            r3 = r16
            r0.A(r1, r2, r3, r5, r6, r7, r8, r9)
            return
        L35:
            f2.h5 r11 = r10.f5030a
            f2.d8 r11 = r11.K()
            r3 = r16
            r11.E(r5, r3)
            return
    }

    public final void t(java.lang.String r11, java.lang.String r12, android.os.Bundle r13, java.lang.String r14) {
            r10 = this;
            f2.h5.t()
            f2.h5 r11 = r10.f5030a
            w1.c r11 = r11.a()
            long r3 = r11.a()
            r7 = 1
            r8 = 1
            java.lang.String r1 = "auto"
            r6 = 0
            r0 = r10
            r2 = r12
            r5 = r13
            r9 = r14
            r0.A(r1, r2, r3, r5, r6, r7, r8, r9)
            return
    }

    public final void u(java.lang.String r8, java.lang.String r9, android.os.Bundle r10) {
            r7 = this;
            r7.h()
            f2.h5 r0 = r7.f5030a
            w1.c r0 = r0.a()
            long r4 = r0.a()
            r1 = r7
            r2 = r8
            r3 = r9
            r6 = r10
            r1.v(r2, r3, r4, r6)
            return
    }

    public final void v(java.lang.String r11, java.lang.String r12, long r13, android.os.Bundle r15) {
            r10 = this;
            r10.h()
            f2.j6 r1 = r10.f5552d
            r2 = 1
            if (r1 == 0) goto Le
            boolean r1 = f2.wa.Y(r12)
            if (r1 == 0) goto L10
        Le:
            r7 = 1
            goto L12
        L10:
            r2 = 0
            r7 = 0
        L12:
            r8 = 1
            r9 = 0
            r6 = 1
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r0.w(r1, r2, r3, r5, r6, r7, r8, r9)
            return
    }

    public final void w(java.lang.String r20, java.lang.String r21, long r22, android.os.Bundle r24, boolean r25, boolean r26, boolean r27, java.lang.String r28) {
            r19 = this;
            r1 = r19
            r7 = r20
            r8 = r21
            r9 = r24
            t1.f.d(r7)
            t1.f.h(r9)
            r1.h()
            r1.i()
            f2.h5 r0 = r1.f5030a
            boolean r0 = r0.o()
            if (r0 == 0) goto L505
            f2.h5 r0 = r1.f5030a
            f2.m3 r0 = r0.B()
            java.util.List r0 = r0.u()
            if (r0 == 0) goto L3f
            boolean r0 = r0.contains(r8)
            if (r0 == 0) goto L2f
            goto L3f
        L2f:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r2 = "Dropping non-safelisted event. event name, origin"
            r0.c(r2, r8, r7)
            return
        L3f:
            boolean r0 = r1.f5554f
            r10 = 0
            r11 = 0
            r12 = 1
            if (r0 != 0) goto L9f
            r1.f5554f = r12
            f2.h5 r0 = r1.f5030a     // Catch: java.lang.ClassNotFoundException -> L90
            boolean r0 = r0.s()     // Catch: java.lang.ClassNotFoundException -> L90
            java.lang.String r2 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L61
            f2.h5 r0 = r1.f5030a     // Catch: java.lang.ClassNotFoundException -> L90
            android.content.Context r0 = r0.c()     // Catch: java.lang.ClassNotFoundException -> L90
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L90
            java.lang.Class r0 = java.lang.Class.forName(r2, r12, r0)     // Catch: java.lang.ClassNotFoundException -> L90
            goto L65
        L61:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L90
        L65:
            java.lang.String r2 = "initialize"
            java.lang.Class[] r3 = new java.lang.Class[r12]     // Catch: java.lang.Exception -> L7f
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r11] = r4     // Catch: java.lang.Exception -> L7f
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r3)     // Catch: java.lang.Exception -> L7f
            f2.h5 r2 = r1.f5030a     // Catch: java.lang.Exception -> L7f
            android.content.Context r2 = r2.c()     // Catch: java.lang.Exception -> L7f
            java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch: java.lang.Exception -> L7f
            r3[r11] = r2     // Catch: java.lang.Exception -> L7f
            r0.invoke(r10, r3)     // Catch: java.lang.Exception -> L7f
            goto L9f
        L7f:
            r0 = move-exception
            f2.h5 r2 = r1.f5030a     // Catch: java.lang.ClassNotFoundException -> L90
            f2.v3 r2 = r2.d()     // Catch: java.lang.ClassNotFoundException -> L90
            f2.t3 r2 = r2.w()     // Catch: java.lang.ClassNotFoundException -> L90
            java.lang.String r3 = "Failed to invoke Tag Manager's initialize() method"
            r2.b(r3, r0)     // Catch: java.lang.ClassNotFoundException -> L90
            goto L9f
        L90:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.u()
            java.lang.String r2 = "Tag Manager is not found and thus will not be used"
            r0.a(r2)
        L9f:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto Lc9
            java.lang.String r0 = "gclid"
            boolean r2 = r9.containsKey(r0)
            if (r2 == 0) goto Lc9
            f2.h5 r2 = r1.f5030a
            r2.b()
            java.lang.String r4 = r9.getString(r0)
            f2.h5 r0 = r1.f5030a
            w1.c r0 = r0.a()
            long r5 = r0.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1.M(r2, r3, r4, r5)
        Lc9:
            r6 = r1
            f2.h5 r0 = r6.f5030a
            r0.b()
            if (r25 == 0) goto Lec
            boolean r0 = f2.wa.c0(r8)
            if (r0 == 0) goto Lec
            f2.h5 r0 = r6.f5030a
            f2.wa r0 = r0.N()
            f2.h5 r1 = r6.f5030a
            f2.l4 r1 = r1.F()
            f2.g4 r1 = r1.f5450x
            android.os.Bundle r1 = r1.a()
            r0.z(r9, r1)
        Lec:
            r0 = 40
            if (r27 != 0) goto L174
            f2.h5 r1 = r6.f5030a
            r1.b()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L174
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            java.lang.String r2 = "event"
            boolean r3 = r1.S(r2, r8)
            r4 = 2
            if (r3 != 0) goto L10d
            goto L127
        L10d:
            java.lang.String[] r3 = f2.g6.f5206a
            java.lang.String[] r5 = f2.g6.f5207b
            boolean r3 = r1.P(r2, r3, r5, r8)
            if (r3 != 0) goto L11a
            r4 = 13
            goto L127
        L11a:
            f2.h5 r3 = r1.f5030a
            r3.z()
            boolean r1 = r1.N(r2, r0, r8)
            if (r1 != 0) goto L126
            goto L127
        L126:
            r4 = 0
        L127:
            if (r4 == 0) goto L174
            f2.h5 r1 = r6.f5030a
            f2.v3 r1 = r1.d()
            f2.t3 r1 = r1.s()
            f2.h5 r2 = r6.f5030a
            f2.q3 r2 = r2.D()
            java.lang.String r2 = r2.d(r8)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.b(r3, r2)
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            f2.h5 r2 = r6.f5030a
            r2.z()
            java.lang.String r0 = r1.r(r8, r0, r12)
            if (r8 == 0) goto L157
            int r11 = r8.length()
        L157:
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            f2.va r2 = r6.f5562n
            r3 = 0
            java.lang.String r5 = "_ev"
            r25 = r0
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r26 = r11
            r20.C(r21, r22, r23, r24, r25, r26)
            return
        L174:
            f2.h5 r1 = r6.f5030a
            r1.b()
            f2.h5 r1 = r6.f5030a
            f2.d8 r1 = r1.K()
            f2.v7 r1 = r1.s(r11)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L18f
            boolean r3 = r9.containsKey(r2)
            if (r3 != 0) goto L18f
            r1.f5768d = r12
        L18f:
            if (r25 == 0) goto L195
            if (r27 != 0) goto L195
            r3 = 1
            goto L196
        L195:
            r3 = 0
        L196:
            f2.wa.y(r1, r9, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r7)
            boolean r3 = f2.wa.Y(r8)
            if (r25 == 0) goto L1e4
            f2.j6 r4 = r6.f5552d
            if (r4 == 0) goto L1e4
            if (r3 != 0) goto L1e4
            if (r1 == 0) goto L1b1
            r13 = r22
            r9 = 1
            goto L1e7
        L1b1:
            f2.h5 r0 = r6.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            f2.h5 r1 = r6.f5030a
            f2.q3 r1 = r1.D()
            java.lang.String r1 = r1.d(r8)
            f2.h5 r2 = r6.f5030a
            f2.q3 r2 = r2.D()
            java.lang.String r2 = r2.b(r9)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.c(r3, r1, r2)
            f2.j6 r0 = r6.f5552d
            t1.f.h(r0)
            f2.j6 r0 = r6.f5552d
            r4 = r22
            r1 = r7
            r2 = r8
            r3 = r9
            r0.a(r1, r2, r3, r4)
            return
        L1e4:
            r13 = r22
            r9 = r1
        L1e7:
            f2.h5 r1 = r6.f5030a
            boolean r1 = r1.r()
            if (r1 == 0) goto L504
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            int r1 = r1.m0(r8)
            if (r1 == 0) goto L245
            f2.h5 r2 = r6.f5030a
            f2.v3 r2 = r2.d()
            f2.t3 r2 = r2.s()
            f2.h5 r3 = r6.f5030a
            f2.q3 r3 = r3.D()
            java.lang.String r3 = r3.d(r8)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            f2.h5 r2 = r6.f5030a
            f2.wa r2 = r2.N()
            f2.h5 r3 = r6.f5030a
            r3.z()
            java.lang.String r0 = r2.r(r8, r0, r12)
            if (r8 == 0) goto L229
            int r11 = r8.length()
        L229:
            f2.h5 r2 = r6.f5030a
            f2.wa r2 = r2.N()
            f2.va r3 = r6.f5562n
            java.lang.String r4 = "_ev"
            r22 = r28
            r25 = r0
            r23 = r1
            r20 = r2
            r21 = r3
            r24 = r4
            r26 = r11
            r20.C(r21, r22, r23, r24, r25, r26)
            return
        L245:
            java.lang.String r0 = "_sn"
            java.lang.String r1 = "_si"
            java.lang.String r15 = "_o"
            java.lang.String[] r0 = new java.lang.String[]{r15, r0, r2, r1}
            java.util.List r4 = w1.d.c(r0)
            f2.h5 r0 = r6.f5030a
            f2.wa r0 = r0.N()
            r3 = r24
            r5 = r27
            r1 = r28
            r2 = r8
            android.os.Bundle r0 = r0.x0(r1, r2, r3, r4, r5)
            t1.f.h(r0)
            f2.h5 r1 = r6.f5030a
            r1.b()
            f2.h5 r1 = r6.f5030a
            f2.d8 r1 = r1.K()
            f2.v7 r1 = r1.s(r11)
            java.lang.String r2 = "_ae"
            if (r1 == 0) goto L2ac
            boolean r1 = r2.equals(r8)
            if (r1 == 0) goto L2ac
            f2.h5 r1 = r6.f5030a
            f2.u9 r1 = r1.M()
            f2.s9 r1 = r1.f5741f
            f2.u9 r5 = r1.f5686d
            f2.h5 r5 = r5.f5030a
            w1.c r5 = r5.a()
            r24 = 0
            long r3 = r5.b()
            r16 = 0
            long r11 = r1.f5684b
            long r11 = r3 - r11
            r1.f5684b = r3
            int r1 = (r11 > r24 ? 1 : (r11 == r24 ? 0 : -1))
            if (r1 <= 0) goto L2b0
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            r1.w(r0, r11)
            goto L2b0
        L2ac:
            r24 = 0
            r16 = 0
        L2b0:
            com.google.android.gms.internal.measurement.wb.b()
            f2.h5 r1 = r6.f5030a
            f2.g r1 = r1.z()
            f2.h3 r3 = f2.i3.f5308g0
            boolean r1 = r1.B(r10, r3)
            if (r1 == 0) goto L33a
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r7)
            java.lang.String r3 = "_ffr"
            if (r1 != 0) goto L319
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L319
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            java.lang.String r3 = r0.getString(r3)
            boolean r4 = w1.l.a(r3)
            if (r4 == 0) goto L2e5
            r3 = r10
            goto L2eb
        L2e5:
            if (r3 == 0) goto L2eb
            java.lang.String r3 = r3.trim()
        L2eb:
            f2.h5 r4 = r1.f5030a
            f2.l4 r4 = r4.F()
            f2.k4 r4 = r4.f5447u
            java.lang.String r4 = r4.a()
            boolean r4 = f2.ua.a(r3, r4)
            if (r4 != 0) goto L309
            f2.h5 r1 = r1.f5030a
            f2.l4 r1 = r1.F()
            f2.k4 r1 = r1.f5447u
            r1.b(r3)
            goto L33a
        L309:
            f2.h5 r0 = r1.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.a(r1)
            return
        L319:
            boolean r1 = r2.equals(r8)
            if (r1 == 0) goto L33a
            f2.h5 r1 = r6.f5030a
            f2.wa r1 = r1.N()
            f2.h5 r1 = r1.f5030a
            f2.l4 r1 = r1.F()
            f2.k4 r1 = r1.f5447u
            java.lang.String r1 = r1.a()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L33a
            r0.putString(r3, r1)
        L33a:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r0)
            f2.h5 r1 = r6.f5030a
            f2.g r1 = r1.z()
            f2.h3 r3 = f2.i3.I0
            boolean r1 = r1.B(r10, r3)
            if (r1 == 0) goto L35b
            f2.h5 r1 = r6.f5030a
            f2.u9 r1 = r1.M()
            boolean r1 = r1.t()
            goto L367
        L35b:
            f2.h5 r1 = r6.f5030a
            f2.l4 r1 = r1.F()
            f2.f4 r1 = r1.f5444r
            boolean r1 = r1.b()
        L367:
            f2.h5 r3 = r6.f5030a
            f2.l4 r3 = r3.F()
            f2.h4 r3 = r3.f5441o
            long r3 = r3.a()
            int r5 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r5 <= 0) goto L3e0
            f2.h5 r3 = r6.f5030a
            f2.l4 r3 = r3.F()
            boolean r3 = r3.v(r13)
            if (r3 == 0) goto L3e0
            if (r1 == 0) goto L3e0
            f2.h5 r1 = r6.f5030a
            f2.v3 r1 = r1.d()
            f2.t3 r1 = r1.v()
            java.lang.String r3 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.a(r3)
            f2.h5 r1 = r6.f5030a
            w1.c r1 = r1.a()
            long r3 = r1.a()
            r5 = r3
            java.lang.String r3 = "_sid"
            r4 = 0
            r1 = r2
            java.lang.String r2 = "auto"
            r17 = r24
            r24 = r11
            r10 = r17
            r12 = r1
            r1 = r19
            r1.M(r2, r3, r4, r5)
            f2.h5 r2 = r1.f5030a
            w1.c r2 = r2.a()
            long r5 = r2.a()
            java.lang.String r3 = "_sno"
            java.lang.String r2 = "auto"
            r1.M(r2, r3, r4, r5)
            f2.h5 r2 = r1.f5030a
            w1.c r2 = r2.a()
            long r5 = r2.a()
            java.lang.String r3 = "_se"
            java.lang.String r2 = "auto"
            r1.M(r2, r3, r4, r5)
            r6 = r1
            f2.h5 r1 = r6.f5030a
            f2.l4 r1 = r1.F()
            f2.h4 r1 = r1.f5442p
            r1.b(r10)
            goto L3e7
        L3e0:
            r17 = r24
            r24 = r11
            r10 = r17
            r12 = r2
        L3e7:
            java.lang.String r1 = "extend_session"
            long r1 = r0.getLong(r1, r10)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L40e
            f2.h5 r1 = r6.f5030a
            f2.v3 r1 = r1.d()
            f2.t3 r1 = r1.v()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            f2.h5 r1 = r6.f5030a
            f2.u9 r1 = r1.M()
            f2.t9 r1 = r1.f5740e
            r2 = 1
            r1.b(r13, r2)
        L40e:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L41f:
            if (r3 >= r2) goto L46c
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L469
            f2.h5 r5 = r6.f5030a
            r5.N()
            java.lang.Object r5 = r0.get(r4)
            boolean r10 = r5 instanceof android.os.Bundle
            if (r10 == 0) goto L43e
            r10 = 1
            android.os.Bundle[] r11 = new android.os.Bundle[r10]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r11[r16] = r5
            goto L464
        L43e:
            boolean r10 = r5 instanceof android.os.Parcelable[]
            if (r10 == 0) goto L44f
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r10 = r5.length
            java.lang.Class<android.os.Bundle[]> r11 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r10, r11)
            r11 = r5
            android.os.Bundle[] r11 = (android.os.Bundle[]) r11
            goto L464
        L44f:
            boolean r10 = r5 instanceof java.util.ArrayList
            if (r10 == 0) goto L463
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r10 = r5.size()
            android.os.Bundle[] r10 = new android.os.Bundle[r10]
            java.lang.Object[] r5 = r5.toArray(r10)
            r11 = r5
            android.os.Bundle[] r11 = (android.os.Bundle[]) r11
            goto L464
        L463:
            r11 = 0
        L464:
            if (r11 == 0) goto L469
            r0.putParcelableArray(r4, r11)
        L469:
            int r3 = r3 + 1
            goto L41f
        L46c:
            r10 = 0
        L46d:
            int r0 = r24.size()
            if (r10 >= r0) goto L4d6
            r11 = r24
            java.lang.Object r0 = r11.get(r10)
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r10 == 0) goto L480
            java.lang.String r1 = "_ep"
            goto L481
        L480:
            r1 = r8
        L481:
            r0.putString(r15, r7)
            if (r26 == 0) goto L490
            f2.h5 r2 = r6.f5030a
            f2.wa r2 = r2.N()
            android.os.Bundle r0 = r2.w0(r0)
        L490:
            com.google.android.gms.measurement.internal.zzau r2 = new com.google.android.gms.measurement.internal.zzau
            r3 = r2
            com.google.android.gms.measurement.internal.zzas r2 = new com.google.android.gms.measurement.internal.zzas
            r2.<init>(r0)
            r4 = r7
            r7 = r0
            r0 = r3
            r3 = r4
            r4 = r13
            r0.<init>(r1, r2, r3, r4)
            f2.h5 r1 = r6.f5030a
            f2.d9 r1 = r1.L()
            r13 = r28
            r1.o(r0, r13)
            if (r9 != 0) goto L4cd
            java.util.Set r0 = r6.f5553e
            java.util.Iterator r14 = r0.iterator()
        L4b3:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L4cd
            java.lang.Object r0 = r14.next()
            f2.k6 r0 = (f2.k6) r0
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>(r7)
            r1 = r20
            r4 = r22
            r2 = r8
            r0.a(r1, r2, r3, r4)
            goto L4b3
        L4cd:
            int r10 = r10 + 1
            r7 = r20
            r13 = r22
            r24 = r11
            goto L46d
        L4d6:
            f2.h5 r0 = r6.f5030a
            r0.b()
            f2.h5 r0 = r6.f5030a
            f2.d8 r0 = r0.K()
            r1 = 0
            f2.v7 r0 = r0.s(r1)
            if (r0 == 0) goto L504
            boolean r0 = r12.equals(r8)
            if (r0 == 0) goto L504
            f2.h5 r0 = r6.f5030a
            f2.u9 r0 = r0.M()
            f2.h5 r1 = r6.f5030a
            w1.c r1 = r1.a()
            long r1 = r1.b()
            f2.s9 r0 = r0.f5741f
            r10 = 1
            r0.d(r10, r10, r1)
        L504:
            return
        L505:
            r6 = r1
            f2.h5 r0 = r6.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
    }

    public final void x(f2.k6 r2) {
            r1 = this;
            r1.i()
            t1.f.h(r2)
            java.util.Set r0 = r1.f5553e
            boolean r2 = r0.add(r2)
            if (r2 != 0) goto L1d
            f2.h5 r2 = r1.f5030a
            f2.v3 r2 = r2.d()
            f2.t3 r2 = r2.w()
            java.lang.String r0 = "OnEventListener already registered"
            r2.a(r0)
        L1d:
            return
    }

    public final void y(long r3) {
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.f5555g
            r1 = 0
            r0.set(r1)
            f2.h5 r0 = r2.f5030a
            f2.e5 r0 = r0.f()
            f2.v6 r1 = new f2.v6
            r1.<init>(r2, r3)
            r0.z(r1)
            return
    }

    public final void z(long r6, boolean r8) {
            r5 = this;
            r5.h()
            r5.i()
            f2.h5 r0 = r5.f5030a
            f2.v3 r0 = r0.d()
            f2.t3 r0 = r0.q()
            java.lang.String r1 = "Resetting analytics data (FE)"
            r0.a(r1)
            f2.h5 r0 = r5.f5030a
            f2.u9 r0 = r0.M()
            r0.h()
            f2.s9 r0 = r0.f5741f
            r0.a()
            com.google.android.gms.internal.measurement.ae.b()
            f2.h5 r0 = r5.f5030a
            f2.g r0 = r0.z()
            f2.h3 r1 = f2.i3.f5326p0
            r2 = 0
            boolean r0 = r0.B(r2, r1)
            if (r0 == 0) goto L3e
            f2.h5 r0 = r5.f5030a
            f2.m3 r0 = r0.B()
            r0.v()
        L3e:
            f2.h5 r0 = r5.f5030a
            boolean r0 = r0.o()
            f2.h5 r1 = r5.f5030a
            f2.l4 r1 = r1.F()
            f2.h4 r3 = r1.f5431e
            r3.b(r6)
            f2.h5 r6 = r1.f5030a
            f2.l4 r6 = r6.F()
            f2.k4 r6 = r6.f5447u
            java.lang.String r6 = r6.a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L66
            f2.k4 r6 = r1.f5447u
            r6.b(r2)
        L66:
            com.google.android.gms.internal.measurement.mc.b()
            f2.h5 r6 = r1.f5030a
            f2.g r6 = r6.z()
            f2.h3 r7 = f2.i3.f5310h0
            boolean r6 = r6.B(r2, r7)
            r3 = 0
            if (r6 == 0) goto L7e
            f2.h4 r6 = r1.f5441o
            r6.b(r3)
        L7e:
            f2.h4 r6 = r1.f5442p
            r6.b(r3)
            f2.h5 r6 = r1.f5030a
            f2.g r6 = r6.z()
            boolean r6 = r6.E()
            if (r6 != 0) goto L94
            r6 = r0 ^ 1
            r1.t(r6)
        L94:
            f2.k4 r6 = r1.f5448v
            r6.b(r2)
            f2.h4 r6 = r1.f5449w
            r6.b(r3)
            f2.g4 r6 = r1.f5450x
            r6.b(r2)
            if (r8 == 0) goto Lae
            f2.h5 r6 = r5.f5030a
            f2.d9 r6 = r6.L()
            r6.q()
        Lae:
            com.google.android.gms.internal.measurement.mc.b()
            f2.h5 r6 = r5.f5030a
            f2.g r6 = r6.z()
            boolean r6 = r6.B(r2, r7)
            if (r6 == 0) goto Lc8
            f2.h5 r6 = r5.f5030a
            f2.u9 r6 = r6.M()
            f2.t9 r6 = r6.f5740e
            r6.a()
        Lc8:
            r6 = r0 ^ 1
            r5.f5561m = r6
            return
    }
}
