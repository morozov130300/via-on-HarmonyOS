package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: j, reason: collision with root package name */
    public static volatile u2 f3811j;

    /* renamed from: a, reason: collision with root package name */
    public final String f3812a;

    /* renamed from: b, reason: collision with root package name */
    public final w1.c f3813b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f3814c;

    /* renamed from: d, reason: collision with root package name */
    public final e2.a f3815d;

    /* renamed from: e, reason: collision with root package name */
    public final List f3816e;

    /* renamed from: f, reason: collision with root package name */
    public int f3817f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3818g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3819h;

    /* renamed from: i, reason: collision with root package name */
    public volatile h1 f3820i;

    public u2(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !k(str2, str3)) {
            this.f3812a = "FA";
        } else {
            this.f3812a = str;
        }
        this.f3813b = w1.f.d();
        b1.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f2(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3814c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f3815d = new e2.a(this);
        this.f3816e = new ArrayList();
        try {
            if (f2.u7.b(context, "google_app_id", f2.z4.a(context)) != null && !g()) {
                this.f3819h = null;
                this.f3818g = true;
                Log.w(this.f3812a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (k(str2, str3)) {
            this.f3819h = str2;
        } else {
            this.f3819h = "fa";
            if (str2 == null || str3 == null) {
                if ((str3 == null) ^ (str2 == null)) {
                    Log.w(this.f3812a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f3812a, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        }
        j(new v1(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f3812a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new t2(this));
        }
    }

    public static u2 q(Context context, String str, String str2, String str3, Bundle bundle) {
        t1.f.h(context);
        if (f3811j == null) {
            synchronized (u2.class) {
                try {
                    if (f3811j == null) {
                        f3811j = new u2(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return f3811j;
    }

    public final void B(String str) {
        j(new w1(this, str));
    }

    public final void C(String str, String str2, Bundle bundle) {
        j(new s1(this, str, str2, bundle));
    }

    public final void D(String str) {
        j(new x1(this, str));
    }

    public final void E(String str, Bundle bundle) {
        i(null, str, bundle, false, true, null);
    }

    public final void F(String str, String str2, Bundle bundle) {
        i(str, str2, bundle, true, true, null);
    }

    public final void a(int i10, String str, Object obj, Object obj2, Object obj3) {
        j(new e2(this, false, 5, str, obj, null, null));
    }

    public final void b(f2.k6 k6Var) {
        t1.f.h(k6Var);
        synchronized (this.f3816e) {
            for (int i10 = 0; i10 < this.f3816e.size(); i10++) {
                try {
                    if (k6Var.equals(((Pair) this.f3816e.get(i10)).first)) {
                        Log.w(this.f3812a, "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            k2 k2Var = new k2(k6Var);
            this.f3816e.add(new Pair(k6Var, k2Var));
            if (this.f3820i != null) {
                try {
                    this.f3820i.registerOnMeasurementEventListener(k2Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.f3812a, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            j(new h2(this, k2Var));
        }
    }

    public final void c(Bundle bundle) {
        j(new r1(this, bundle));
    }

    public final void d(Activity activity, String str, String str2) {
        j(new u1(this, activity, str, str2));
    }

    public final boolean g() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, u2.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void h(Exception exc, boolean z10, boolean z11) {
        u2 u2Var;
        Exception exc2;
        this.f3818g |= z10;
        if (z10) {
            Log.w(this.f3812a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z11) {
            u2Var = this;
            exc2 = exc;
            u2Var.a(5, "Error with data collection. Data lost.", exc2, null, null);
        } else {
            u2Var = this;
            exc2 = exc;
        }
        Log.w(u2Var.f3812a, "Error with data collection. Data lost.", exc2);
    }

    public final void i(String str, String str2, Bundle bundle, boolean z10, boolean z11, Long l10) {
        j(new i2(this, l10, str, str2, bundle, z10, z11));
    }

    public final void j(j2 j2Var) {
        this.f3814c.execute(j2Var);
    }

    public final boolean k(String str, String str2) {
        return (str2 == null || str == null || g()) ? false : true;
    }

    public final int l(String str) {
        d1 d1Var = new d1();
        j(new g2(this, str, d1Var));
        Integer num = (Integer) d1.c0(d1Var.Z(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long m() {
        d1 d1Var = new d1();
        j(new a2(this, d1Var));
        Long lA0 = d1Var.a0(500L);
        if (lA0 != null) {
            return lA0.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.f3813b.a()).nextLong();
        int i10 = this.f3817f + 1;
        this.f3817f = i10;
        return jNextLong + i10;
    }

    public final e2.a n() {
        return this.f3815d;
    }

    public final h1 p(Context context, boolean z10) {
        try {
            return g1.asInterface(DynamiteModule.d(context, DynamiteModule.f3367e, ModuleDescriptor.MODULE_ID).c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e10) {
            h(e10, true, false);
            return null;
        }
    }

    public final String s() {
        d1 d1Var = new d1();
        j(new z1(this, d1Var));
        return d1Var.b0(50L);
    }

    public final String t() {
        d1 d1Var = new d1();
        j(new c2(this, d1Var));
        return d1Var.b0(500L);
    }

    public final String u() {
        d1 d1Var = new d1();
        j(new b2(this, d1Var));
        return d1Var.b0(500L);
    }

    public final String v() {
        d1 d1Var = new d1();
        j(new y1(this, d1Var));
        return d1Var.b0(500L);
    }

    public final List w(String str, String str2) {
        d1 d1Var = new d1();
        j(new t1(this, str, str2, d1Var));
        List list = (List) d1.c0(d1Var.Z(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final Map x(String str, String str2, boolean z10) {
        d1 d1Var = new d1();
        j(new d2(this, str, str2, z10, d1Var));
        Bundle bundleZ = d1Var.Z(5000L);
        if (bundleZ == null || bundleZ.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleZ.size());
        for (String str3 : bundleZ.keySet()) {
            Object obj = bundleZ.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }
}
