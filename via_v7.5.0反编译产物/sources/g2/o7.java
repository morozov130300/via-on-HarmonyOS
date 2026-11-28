package g2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.mc;
import com.google.android.gms.internal.measurement.wb;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o7 extends c4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n7 f5167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j6 f5168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f5169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f5171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f5172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f6 f5173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f5174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cb f5176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final va f5178n;

    public o7(h5 h5Var) {
        super(h5Var);
        this.f5169e = new CopyOnWriteArraySet();
        this.f5172h = new Object();
        this.f5177m = true;
        this.f5178n = new c7(this);
        this.f5171g = new AtomicReference();
        this.f5173i = f6.f4794c;
        this.f5175k = -1L;
        this.f5174j = new AtomicLong(0L);
        this.f5176l = new cb(h5Var);
    }

    public static /* bridge */ /* synthetic */ void b0(o7 o7Var, f6 f6Var, f6 f6Var2) {
        boolean z10;
        zzha[] zzhaVarArr = {zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE};
        int i10 = 0;
        while (true) {
            if (i10 >= 2) {
                z10 = false;
                break;
            }
            zzha zzhaVar = zzhaVarArr[i10];
            if (!f6Var2.j(zzhaVar) && f6Var.j(zzhaVar)) {
                z10 = true;
                break;
            }
            i10++;
        }
        boolean zN = f6Var.n(f6Var2, zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE);
        if (z10 || zN) {
            o7Var.f4646a.B().v();
        }
    }

    public static /* synthetic */ void c0(o7 o7Var, f6 f6Var, long j10, boolean z10, boolean z11) {
        o7Var.h();
        o7Var.i();
        f6 f6VarQ = o7Var.f4646a.F().q();
        if (j10 <= o7Var.f5175k && f6.k(f6VarQ.a(), f6Var.a())) {
            o7Var.f4646a.d().u().b("Dropped out-of-date consent setting, proposed settings", f6Var);
            return;
        }
        l4 l4VarF = o7Var.f4646a.F();
        h5 h5Var = l4VarF.f4646a;
        l4VarF.h();
        int iA = f6Var.a();
        if (!l4VarF.w(iA)) {
            o7Var.f4646a.d().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(f6Var.a()));
            return;
        }
        SharedPreferences.Editor editorEdit = l4VarF.o().edit();
        editorEdit.putString("consent_settings", f6Var.i());
        editorEdit.putInt("consent_source", iA);
        editorEdit.apply();
        o7Var.f5175k = j10;
        o7Var.f4646a.L().t(z10);
        if (z11) {
            o7Var.f4646a.L().S(new AtomicReference());
        }
    }

    public final void A(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i10];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelable);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        this.f4646a.f().z(new t6(this, str, str2, j10, bundle2, z10, z11, z12, str3));
    }

    public final void B(String str, String str2, long j10, Object obj) {
        this.f4646a.f().z(new u6(this, str, str2, obj, j10));
    }

    public final void C(String str) {
        this.f5171g.set(str);
    }

    public final void D(Bundle bundle) {
        E(bundle, this.f4646a.a().a());
    }

    public final void E(Bundle bundle, long j10) {
        u1.f.h(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f4646a.d().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        u1.f.h(bundle2);
        d6.a(bundle2, "app_id", String.class, null);
        d6.a(bundle2, "origin", String.class, null);
        d6.a(bundle2, "name", String.class, null);
        d6.a(bundle2, "value", Object.class, null);
        d6.a(bundle2, "trigger_event_name", String.class, null);
        d6.a(bundle2, "trigger_timeout", Long.class, 0L);
        d6.a(bundle2, "timed_out_event_name", String.class, null);
        d6.a(bundle2, "timed_out_event_params", Bundle.class, null);
        d6.a(bundle2, "triggered_event_name", String.class, null);
        d6.a(bundle2, "triggered_event_params", Bundle.class, null);
        d6.a(bundle2, "time_to_live", Long.class, 0L);
        d6.a(bundle2, "expired_event_name", String.class, null);
        d6.a(bundle2, "expired_event_params", Bundle.class, null);
        u1.f.d(bundle2.getString("name"));
        u1.f.d(bundle2.getString("origin"));
        u1.f.h(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.f4646a.N().p0(string) != 0) {
            this.f4646a.d().r().b("Invalid conditional user property name", this.f4646a.D().f(string));
            return;
        }
        if (this.f4646a.N().l0(string, obj) != 0) {
            this.f4646a.d().r().c("Invalid conditional user property value", this.f4646a.D().f(string), obj);
            return;
        }
        Object objP = this.f4646a.N().p(string, obj);
        if (objP == null) {
            this.f4646a.d().r().c("Unable to normalize conditional user property value", this.f4646a.D().f(string), obj);
            return;
        }
        d6.b(bundle2, objP);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            this.f4646a.z();
            if (j11 > 15552000000L || j11 < 1) {
                this.f4646a.d().r().c("Invalid conditional user property timeout", this.f4646a.D().f(string), Long.valueOf(j11));
                return;
            }
        }
        long j12 = bundle2.getLong("time_to_live");
        this.f4646a.z();
        if (j12 > 15552000000L || j12 < 1) {
            this.f4646a.d().r().c("Invalid conditional user property time to live", this.f4646a.D().f(string), Long.valueOf(j12));
        } else {
            this.f4646a.f().z(new w6(this, bundle2));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:48:0x00c0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void F(g2.f6 r13, long r14) {
        /*
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
            g2.h5 r13 = r12.f4646a
            g2.v3 r13 = r13.d()
            g2.t3 r13 = r13.x()
            java.lang.String r14 = "Discarding empty consent settings"
            r13.a(r14)
            return
        L28:
            java.lang.Object r2 = r12.f5172h
            monitor-enter(r2)
            g2.f6 r9 = r12.f5173i     // Catch: java.lang.Throwable -> Lbb
            int r3 = r9.a()     // Catch: java.lang.Throwable -> Lbb
            boolean r3 = g2.f6.k(r0, r3)     // Catch: java.lang.Throwable -> Lbb
            r4 = 0
            if (r3 == 0) goto L62
            g2.f6 r3 = r12.f5173i     // Catch: java.lang.Throwable -> L51
            boolean r3 = r13.m(r3)     // Catch: java.lang.Throwable -> L51
            com.google.android.gms.measurement.internal.zzha r5 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE     // Catch: java.lang.Throwable -> L51
            boolean r6 = r13.j(r5)     // Catch: java.lang.Throwable -> L51
            r7 = 1
            if (r6 == 0) goto L56
            g2.f6 r6 = r12.f5173i     // Catch: java.lang.Throwable -> L51
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
            g2.f6 r5 = r12.f5173i     // Catch: java.lang.Throwable -> L51
            g2.f6 r13 = r13.e(r5)     // Catch: java.lang.Throwable -> L51
            r12.f5173i = r13     // Catch: java.lang.Throwable -> L51
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
            g2.h5 r13 = r12.f4646a
            g2.v3 r13 = r13.d()
            g2.t3 r13 = r13.u()
            java.lang.String r14 = "Ignoring lower-priority consent settings, proposed settings"
            r13.b(r14, r5)
            return
        L78:
            java.util.concurrent.atomic.AtomicLong r13 = r12.f5174j
            long r6 = r13.getAndIncrement()
            if (r3 == 0) goto L9a
            java.util.concurrent.atomic.AtomicReference r13 = r12.f5171g
            r0 = 0
            r13.set(r0)
            g2.h5 r13 = r12.f4646a
            g2.e5 r13 = r13.f()
            g2.j7 r3 = new g2.j7
            r4 = r12
            r10 = r8
            r11 = r9
            r8 = r6
            r6 = r14
            r3.<init>(r4, r5, r6, r8, r10, r11)
            r13.A(r3)
            return
        L9a:
            g2.k7 r3 = new g2.k7
            r4 = r12
            r3.<init>(r4, r5, r6, r8, r9)
            r13 = 30
            if (r0 == r13) goto Lb1
            if (r0 != r1) goto La7
            goto Lb1
        La7:
            g2.h5 r13 = r4.f4646a
            g2.e5 r13 = r13.f()
            r13.z(r3)
            return
        Lb1:
            g2.h5 r13 = r4.f4646a
            g2.e5 r13 = r13.f()
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
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o7.F(g2.f6, long):void");
    }

    public final void G(Bundle bundle, int i10, long j10) {
        i();
        String strH = f6.h(bundle);
        if (strH != null) {
            this.f4646a.d().x().b("Ignoring invalid consent setting", strH);
            this.f4646a.d().x().a("Valid consent values are 'granted', 'denied'");
        }
        F(f6.b(bundle, i10), j10);
    }

    public final void H(j6 j6Var) {
        j6 j6Var2;
        h();
        i();
        if (j6Var != null && j6Var != (j6Var2 = this.f5168d)) {
            u1.f.l(j6Var2 == null, "EventInterceptor already set.");
        }
        this.f5168d = j6Var;
    }

    public final void I(Boolean bool) {
        i();
        this.f4646a.f().z(new i7(this, bool));
    }

    public final void J(f6 f6Var) {
        h();
        boolean z10 = (f6Var.j(zzha.ANALYTICS_STORAGE) && f6Var.j(zzha.AD_STORAGE)) || this.f4646a.L().A();
        if (z10 != this.f4646a.p()) {
            this.f4646a.l(z10);
            l4 l4VarF = this.f4646a.F();
            h5 h5Var = l4VarF.f4646a;
            l4VarF.h();
            Boolean boolValueOf = l4VarF.o().contains("measurement_enabled_from_api") ? Boolean.valueOf(l4VarF.o().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z10 || boolValueOf == null || boolValueOf.booleanValue()) {
                O(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void K(String str, String str2, Object obj, boolean z10) {
        L("auto", "_ldl", obj, true, this.f4646a.a().a());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    public final void L(String str, String str2, Object obj, boolean z10, long j10) {
        int iP0;
        if (z10) {
            iP0 = this.f4646a.N().p0(str2);
        } else {
            wa waVarN = this.f4646a.N();
            if (!waVarN.S("user property", str2)) {
                iP0 = 6;
            } else if (waVarN.P("user property", i6.f4966a, null, str2)) {
                waVarN.f4646a.z();
                if (waVarN.N("user property", 24, str2)) {
                    iP0 = 0;
                } else {
                    iP0 = 6;
                }
            } else {
                iP0 = 15;
            }
        }
        if (iP0 != 0) {
            wa waVarN2 = this.f4646a.N();
            this.f4646a.z();
            this.f4646a.N().C(this.f5178n, null, iP0, "_ev", waVarN2.r(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj == null) {
            B(str3, str2, j10, null);
            return;
        }
        int iL0 = this.f4646a.N().l0(str2, obj);
        if (iL0 != 0) {
            wa waVarN3 = this.f4646a.N();
            this.f4646a.z();
            this.f4646a.N().C(this.f5178n, null, iL0, "_ev", waVarN3.r(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
        } else {
            Object objP = this.f4646a.N().p(str2, obj);
            if (objP != null) {
                B(str3, str2, j10, objP);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:18:0x0062  */
    public final void M(String str, String str2, Object obj, long j10) {
        String str3;
        Object obj2;
        u1.f.d(str);
        u1.f.d(str2);
        h();
        i();
        if (!"allow_personalized_ads".equals(str2)) {
            str3 = str2;
            obj2 = obj;
        } else if (obj instanceof String) {
            String str4 = (String) obj;
            if (!TextUtils.isEmpty(str4)) {
                long j11 = true != "false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                Long lValueOf = Long.valueOf(j11);
                this.f4646a.F().f5055m.b(j11 == 1 ? "true" : "false");
                str3 = "_npa";
                obj2 = lValueOf;
            } else if (obj == null) {
                this.f4646a.F().f5055m.b("unset");
                obj2 = obj;
                str3 = "_npa";
            } else {
                str3 = str2;
                obj2 = obj;
            }
        } else if (obj == null) {
            this.f4646a.F().f5055m.b("unset");
            obj2 = obj;
            str3 = "_npa";
        } else {
            str3 = str2;
            obj2 = obj;
        }
        if (!this.f4646a.o()) {
            this.f4646a.d().v().a("User property not set since app measurement is disabled");
        } else if (this.f4646a.r()) {
            this.f4646a.L().y(new zzlk(str3, j10, obj2, str));
        }
    }

    public final void N(k6 k6Var) {
        i();
        u1.f.h(k6Var);
        if (this.f5169e.remove(k6Var)) {
            return;
        }
        this.f4646a.d().w().a("OnEventListener had not been registered");
    }

    public final void O(Boolean bool, boolean z10) {
        h();
        i();
        this.f4646a.d().q().b("Setting app measurement enabled (FE)", bool);
        this.f4646a.F().s(bool);
        if (z10) {
            l4 l4VarF = this.f4646a.F();
            h5 h5Var = l4VarF.f4646a;
            l4VarF.h();
            SharedPreferences.Editor editorEdit = l4VarF.o().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.f4646a.p() || !(bool == null || bool.booleanValue())) {
            P();
        }
    }

    public final void P() {
        o7 o7Var;
        h();
        String strA = this.f4646a.F().f5055m.a();
        if (strA == null) {
            o7Var = this;
        } else if ("unset".equals(strA)) {
            o7Var = this;
            o7Var.M("app", "_npa", null, this.f4646a.a().a());
        } else {
            o7Var = this;
            o7Var.M("app", "_npa", Long.valueOf(true != "true".equals(strA) ? 0L : 1L), o7Var.f4646a.a().a());
        }
        if (!o7Var.f4646a.o() || !o7Var.f5177m) {
            o7Var.f4646a.d().q().a("Updating Scion state (FE)");
            o7Var.f4646a.L().w();
            return;
        }
        o7Var.f4646a.d().q().a("Recording app launch after enabling measurement for the first time (FE)");
        f0();
        mc.b();
        if (o7Var.f4646a.z().B(null, i3.f4926h0)) {
            o7Var.f4646a.M().f5356e.a();
        }
        o7Var.f4646a.f().z(new r6(this));
    }

    public final int Q(String str) {
        u1.f.d(str);
        this.f4646a.z();
        return 25;
    }

    public final Boolean R() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f4646a.f().r(atomicReference, 15000L, "boolean test flag value", new z6(this, atomicReference));
    }

    public final Double S() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f4646a.f().r(atomicReference, 15000L, "double test flag value", new h7(this, atomicReference));
    }

    public final Integer T() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f4646a.f().r(atomicReference, 15000L, "int test flag value", new g7(this, atomicReference));
    }

    public final Long U() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f4646a.f().r(atomicReference, 15000L, "long test flag value", new f7(this, atomicReference));
    }

    public final String V() {
        return (String) this.f5171g.get();
    }

    public final String W() {
        v7 v7VarR = this.f4646a.K().r();
        if (v7VarR != null) {
            return v7VarR.f5382b;
        }
        return null;
    }

    public final String X() {
        v7 v7VarR = this.f4646a.K().r();
        if (v7VarR != null) {
            return v7VarR.f5381a;
        }
        return null;
    }

    public final String Y() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f4646a.f().r(atomicReference, 15000L, "String test flag value", new e7(this, atomicReference));
    }

    public final ArrayList Z(String str, String str2) {
        if (this.f4646a.f().C()) {
            this.f4646a.d().r().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.f4646a.b();
        if (c.a()) {
            this.f4646a.d().r().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f4646a.f().r(atomicReference, 5000L, "get conditional user properties", new y6(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return wa.v(list);
        }
        this.f4646a.d().r().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final Map a0(String str, String str2, boolean z10) {
        if (this.f4646a.f().C()) {
            this.f4646a.d().r().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        this.f4646a.b();
        if (c.a()) {
            this.f4646a.d().r().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f4646a.f().r(atomicReference, 5000L, "get user properties", new a7(this, atomicReference, null, str, str2, z10));
        List<zzlk> list = (List) atomicReference.get();
        if (list == null) {
            this.f4646a.d().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.EMPTY_MAP;
        }
        k.a aVar = new k.a(list.size());
        for (zzlk zzlkVar : list) {
            Object objC = zzlkVar.c();
            if (objC != null) {
                aVar.put(zzlkVar.f3269e, objC);
            }
        }
        return aVar;
    }

    public final void f0() {
        h();
        i();
        if (this.f4646a.r()) {
            if (this.f4646a.z().B(null, i3.f4914b0)) {
                g gVarZ = this.f4646a.z();
                gVarZ.f4646a.b();
                Boolean boolT = gVarZ.t("google_analytics_deferred_deep_link_enabled");
                if (boolT != null && boolT.booleanValue()) {
                    this.f4646a.d().q().a("Deferred Deep Link feature enabled.");
                    this.f4646a.f().z(new Runnable() { // from class: g2.q6
                        @Override // java.lang.Runnable
                        public final void run() {
                            o7 o7Var = this.f5250c;
                            o7Var.h();
                            if (o7Var.f4646a.F().f5061s.b()) {
                                o7Var.f4646a.d().q().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jA = o7Var.f4646a.F().f5062t.a();
                            o7Var.f4646a.F().f5062t.b(1 + jA);
                            o7Var.f4646a.z();
                            if (jA < 5) {
                                o7Var.f4646a.j();
                            } else {
                                o7Var.f4646a.d().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                o7Var.f4646a.F().f5061s.a(true);
                            }
                        }
                    });
                }
            }
            this.f4646a.L().O();
            this.f5177m = false;
            l4 l4VarF = this.f4646a.F();
            l4VarF.h();
            String string = l4VarF.o().getString("previous_os_version", null);
            l4VarF.f4646a.A().k();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = l4VarF.o().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f4646a.A().k();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            u("auto", "_ou", bundle);
        }
    }

    @Override // g2.c4
    public final boolean n() {
        return false;
    }

    public final void o(String str, String str2, Bundle bundle) {
        long jA = this.f4646a.a().a();
        u1.f.d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jA);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.f4646a.f().z(new x6(this, bundle2));
    }

    public final void p() {
        if (!(this.f4646a.c().getApplicationContext() instanceof Application) || this.f5167c == null) {
            return;
        }
        ((Application) this.f4646a.c().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f5167c);
    }

    public final /* synthetic */ void q(Bundle bundle) {
        if (bundle == null) {
            this.f4646a.F().f5066x.b(new Bundle());
            return;
        }
        Bundle bundleA = this.f4646a.F().f5066x.a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.f4646a.N().V(obj)) {
                    this.f4646a.N().C(this.f5178n, null, 27, null, null, 0);
                }
                this.f4646a.d().x().c("Invalid default event parameter type. Name, value", str, obj);
            } else if (wa.Y(str)) {
                this.f4646a.d().x().b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleA.remove(str);
            } else {
                wa waVarN = this.f4646a.N();
                this.f4646a.z();
                if (waVarN.Q("param", str, 100, obj)) {
                    this.f4646a.N().D(bundleA, str, obj);
                }
            }
        }
        this.f4646a.N();
        int iM = this.f4646a.z().m();
        if (bundleA.size() > iM) {
            int i10 = 0;
            for (String str2 : new TreeSet(bundleA.keySet())) {
                i10++;
                if (i10 > iM) {
                    bundleA.remove(str2);
                }
            }
            this.f4646a.N().C(this.f5178n, null, 26, null, null, 0);
            this.f4646a.d().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.f4646a.F().f5066x.b(bundleA);
        this.f4646a.L().v(bundleA);
    }

    public final void r(String str, String str2, Bundle bundle) {
        s(str, str2, bundle, true, true, this.f4646a.a().a());
    }

    public final void s(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (str2 == "screen_view" || (str2 != null && str2.equals("screen_view"))) {
            this.f4646a.K().E(bundle2, j10);
            return;
        }
        boolean z12 = !z11 || this.f5168d == null || wa.Y(str2);
        if (str == null) {
            str = "app";
        }
        A(str, str2, j10, bundle2, z11, z12, z10, null);
    }

    public final void t(String str, String str2, Bundle bundle, String str3) {
        h5.t();
        A("auto", str2, this.f4646a.a().a(), bundle, false, true, true, str3);
    }

    public final void u(String str, String str2, Bundle bundle) {
        h();
        v(str, str2, this.f4646a.a().a(), bundle);
    }

    public final void v(String str, String str2, long j10, Bundle bundle) {
        h();
        w(str, str2, j10, bundle, true, this.f5168d == null || wa.Y(str2), true, null);
    }

    public final void w(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        boolean z13;
        long j11;
        char c10;
        long j12;
        String str4;
        Bundle[] bundleArr;
        String str5 = str;
        u1.f.d(str5);
        u1.f.h(bundle);
        h();
        i();
        if (!this.f4646a.o()) {
            this.f4646a.d().q().a("Event not sent since app measurement is disabled");
            return;
        }
        List listU = this.f4646a.B().u();
        if (listU != null && !listU.contains(str2)) {
            this.f4646a.d().q().c("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.f5170f) {
            this.f5170f = true;
            try {
                try {
                    (!this.f4646a.s() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.f4646a.c().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.f4646a.c());
                } catch (Exception e10) {
                    this.f4646a.d().w().b("Failed to invoke Tag Manager's initialize() method", e10);
                }
            } catch (ClassNotFoundException unused) {
                this.f4646a.d().u().a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            this.f4646a.b();
            M("auto", "_lgclid", bundle.getString("gclid"), this.f4646a.a().a());
        }
        o7 o7Var = this;
        o7Var.f4646a.b();
        if (z10 && wa.c0(str2)) {
            o7Var.f4646a.N().z(bundle, o7Var.f4646a.F().f5066x.a());
        }
        if (!z12) {
            o7Var.f4646a.b();
            if (!"_iap".equals(str2)) {
                wa waVarN = o7Var.f4646a.N();
                int i10 = 2;
                if (waVarN.S("event", str2)) {
                    if (waVarN.P("event", g6.f4822a, g6.f4823b, str2)) {
                        waVarN.f4646a.z();
                        if (waVarN.N("event", 40, str2)) {
                            i10 = 0;
                        }
                    } else {
                        i10 = 13;
                    }
                }
                if (i10 != 0) {
                    o7Var.f4646a.d().s().b("Invalid public event name. Event will not be logged (FE)", o7Var.f4646a.D().d(str2));
                    wa waVarN2 = o7Var.f4646a.N();
                    o7Var.f4646a.z();
                    o7Var.f4646a.N().C(o7Var.f5178n, null, i10, "_ev", waVarN2.r(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        o7Var.f4646a.b();
        v7 v7VarS = o7Var.f4646a.K().s(false);
        if (v7VarS != null && !bundle.containsKey("_sc")) {
            v7VarS.f5384d = true;
        }
        wa.y(v7VarS, bundle, z10 && !z12);
        boolean zEquals = "am".equals(str5);
        boolean zY = wa.Y(str2);
        if (!z10 || o7Var.f5168d == null || zY) {
            z13 = zEquals;
        } else {
            if (!zEquals) {
                o7Var.f4646a.d().q().c("Passing event to registered event handler (FE)", o7Var.f4646a.D().d(str2), o7Var.f4646a.D().b(bundle));
                u1.f.h(o7Var.f5168d);
                o7Var.f5168d.a(str5, str2, bundle, j10);
                return;
            }
            z13 = true;
        }
        if (o7Var.f4646a.r()) {
            int iM0 = o7Var.f4646a.N().m0(str2);
            if (iM0 != 0) {
                o7Var.f4646a.d().s().b("Invalid event name. Event will not be logged (FE)", o7Var.f4646a.D().d(str2));
                wa waVarN3 = o7Var.f4646a.N();
                o7Var.f4646a.z();
                o7Var.f4646a.N().C(o7Var.f5178n, str3, iM0, "_ev", waVarN3.r(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleX0 = o7Var.f4646a.N().x0(str3, str2, bundle, x1.d.c("_o", "_sn", "_sc", "_si"), z12);
            u1.f.h(bundleX0);
            o7Var.f4646a.b();
            if (o7Var.f4646a.K().s(false) == null || !"_ae".equals(str2)) {
                j11 = 0;
                c10 = 0;
            } else {
                s9 s9Var = o7Var.f4646a.M().f5357f;
                j11 = 0;
                long jB = s9Var.f5302d.f4646a.a().b();
                c10 = 0;
                long j13 = jB - s9Var.f5300b;
                s9Var.f5300b = jB;
                if (j13 > 0) {
                    o7Var.f4646a.N().w(bundleX0, j13);
                }
            }
            wb.b();
            if (o7Var.f4646a.z().B(null, i3.f4924g0)) {
                if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                    wa waVarN4 = o7Var.f4646a.N();
                    String string = bundleX0.getString("_ffr");
                    if (x1.l.a(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (ua.a(string, waVarN4.f4646a.F().f5063u.a())) {
                        waVarN4.f4646a.d().q().a("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    waVarN4.f4646a.F().f5063u.b(string);
                } else if ("_ae".equals(str2)) {
                    String strA = o7Var.f4646a.N().f4646a.F().f5063u.a();
                    if (!TextUtils.isEmpty(strA)) {
                        bundleX0.putString("_ffr", strA);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleX0);
            boolean zT = o7Var.f4646a.z().B(null, i3.I0) ? o7Var.f4646a.M().t() : o7Var.f4646a.F().f5060r.b();
            if (o7Var.f4646a.F().f5057o.a() > j11 && o7Var.f4646a.F().v(j10) && zT) {
                o7Var.f4646a.d().v().a("Current session is expired, remove the session number, ID, and engagement time");
                j12 = j11;
                str4 = "_ae";
                M("auto", "_sid", null, o7Var.f4646a.a().a());
                M("auto", "_sno", null, this.f4646a.a().a());
                M("auto", "_se", null, this.f4646a.a().a());
                o7Var = this;
                o7Var.f4646a.F().f5058p.b(j12);
            } else {
                j12 = j11;
                str4 = "_ae";
            }
            if (bundleX0.getLong("extend_session", j12) == 1) {
                o7Var.f4646a.d().v().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                o7Var.f4646a.M().f5356e.b(j10, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleX0.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                String str6 = (String) arrayList2.get(i11);
                if (str6 != null) {
                    o7Var.f4646a.N();
                    Object obj = bundleX0.get(str6);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[1];
                        bundleArr[c10] = (Bundle) obj;
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleX0.putParcelableArray(str6, bundleArr);
                    }
                }
            }
            int i12 = 0;
            while (i12 < arrayList.size()) {
                ArrayList arrayList4 = arrayList;
                Bundle bundleW0 = (Bundle) arrayList4.get(i12);
                String str7 = i12 != 0 ? "_ep" : str2;
                bundleW0.putString("_o", str5);
                if (z11) {
                    bundleW0 = o7Var.f4646a.N().w0(bundleW0);
                }
                String str8 = str5;
                Bundle bundle2 = bundleW0;
                o7Var.f4646a.L().o(new zzau(str7, new zzas(bundleW0), str8, j10), str3);
                if (!z13) {
                    Iterator it = o7Var.f5169e.iterator();
                    while (it.hasNext()) {
                        ((k6) it.next()).a(str, str2, new Bundle(bundle2), j10);
                    }
                }
                i12++;
                str5 = str;
                j10 = j10;
                arrayList = arrayList4;
            }
            o7Var.f4646a.b();
            if (o7Var.f4646a.K().s(false) == null || !str4.equals(str2)) {
                return;
            }
            o7Var.f4646a.M().f5357f.d(true, true, o7Var.f4646a.a().b());
        }
    }

    public final void x(k6 k6Var) {
        i();
        u1.f.h(k6Var);
        if (this.f5169e.add(k6Var)) {
            return;
        }
        this.f4646a.d().w().a("OnEventListener already registered");
    }

    public final void y(long j10) {
        this.f5171g.set(null);
        this.f4646a.f().z(new v6(this, j10));
    }

    public final void z(long j10, boolean z10) {
        h();
        i();
        this.f4646a.d().q().a("Resetting analytics data (FE)");
        u9 u9VarM = this.f4646a.M();
        u9VarM.h();
        u9VarM.f5357f.a();
        ae.b();
        if (this.f4646a.z().B(null, i3.f4942p0)) {
            this.f4646a.B().v();
        }
        boolean zO = this.f4646a.o();
        l4 l4VarF = this.f4646a.F();
        l4VarF.f5047e.b(j10);
        if (!TextUtils.isEmpty(l4VarF.f4646a.F().f5063u.a())) {
            l4VarF.f5063u.b(null);
        }
        mc.b();
        g gVarZ = l4VarF.f4646a.z();
        h3 h3Var = i3.f4926h0;
        if (gVarZ.B(null, h3Var)) {
            l4VarF.f5057o.b(0L);
        }
        l4VarF.f5058p.b(0L);
        if (!l4VarF.f4646a.z().E()) {
            l4VarF.t(!zO);
        }
        l4VarF.f5064v.b(null);
        l4VarF.f5065w.b(0L);
        l4VarF.f5066x.b(null);
        if (z10) {
            this.f4646a.L().q();
        }
        mc.b();
        if (this.f4646a.z().B(null, h3Var)) {
            this.f4646a.M().f5356e.a();
        }
        this.f5177m = !zO;
    }
}
