package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.g1;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.n1;
import com.google.android.gms.internal.measurement.p1;
import com.google.android.gms.internal.measurement.zzcl;
import f2.ab;
import f2.b7;
import f2.d7;
import f2.e8;
import f2.e9;
import f2.h5;
import f2.ha;
import f2.k6;
import f2.l7;
import f2.n7;
import f2.o7;
import f2.s6;
import f2.u7;
import f2.wa;
import f2.xa;
import f2.ya;
import f2.za;
import java.util.Map;
import k.a;
import t1.f;
import y1.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends g1 {

    /* renamed from: d, reason: collision with root package name */
    public h5 f3950d = null;

    /* renamed from: e, reason: collision with root package name */
    public final Map f3951e = new a();

    public final void Z() {
        if (this.f3950d == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void a0(k1 k1Var, String str) {
        Z();
        this.f3950d.N().K(k1Var, str);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void beginAdUnitExposure(String str, long j10) {
        Z();
        this.f3950d.y().l(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Z();
        this.f3950d.I().o(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void clearMeasurementEnabled(long j10) {
        Z();
        this.f3950d.I().I(null);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void endAdUnitExposure(String str, long j10) {
        Z();
        this.f3950d.y().m(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void generateEventId(k1 k1Var) {
        Z();
        long jT0 = this.f3950d.N().t0();
        Z();
        this.f3950d.N().J(k1Var, jT0);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getAppInstanceId(k1 k1Var) {
        Z();
        this.f3950d.f().z(new d7(this, k1Var));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getCachedAppInstanceId(k1 k1Var) {
        Z();
        a0(k1Var, this.f3950d.I().V());
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getConditionalUserProperties(String str, String str2, k1 k1Var) {
        Z();
        this.f3950d.f().z(new xa(this, k1Var, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getCurrentScreenClass(k1 k1Var) {
        Z();
        a0(k1Var, this.f3950d.I().W());
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getCurrentScreenName(k1 k1Var) {
        Z();
        a0(k1Var, this.f3950d.I().X());
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getGmpAppId(k1 k1Var) {
        String strB;
        Z();
        o7 o7VarI = this.f3950d.I();
        if (o7VarI.f5030a.O() != null) {
            strB = o7VarI.f5030a.O();
        } else {
            try {
                strB = u7.b(o7VarI.f5030a.c(), "google_app_id", o7VarI.f5030a.R());
            } catch (IllegalStateException e10) {
                o7VarI.f5030a.d().r().b("getGoogleAppId failed with exception", e10);
                strB = null;
            }
        }
        a0(k1Var, strB);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getMaxUserProperties(String str, k1 k1Var) {
        Z();
        this.f3950d.I().Q(str);
        Z();
        this.f3950d.N().I(k1Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getSessionId(k1 k1Var) {
        Z();
        o7 o7VarI = this.f3950d.I();
        o7VarI.f5030a.f().z(new b7(o7VarI, k1Var));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getTestFlag(k1 k1Var, int i10) {
        Z();
        if (i10 == 0) {
            this.f3950d.N().K(k1Var, this.f3950d.I().Y());
            return;
        }
        if (i10 == 1) {
            this.f3950d.N().J(k1Var, this.f3950d.I().U().longValue());
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f3950d.N().I(k1Var, this.f3950d.I().T().intValue());
                return;
            } else {
                if (i10 != 4) {
                    return;
                }
                this.f3950d.N().E(k1Var, this.f3950d.I().R().booleanValue());
                return;
            }
        }
        wa waVarN = this.f3950d.N();
        double dDoubleValue = this.f3950d.I().S().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            waVarN.f5030a.d().w().b("Error returning double value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void getUserProperties(String str, String str2, boolean z10, k1 k1Var) {
        Z();
        this.f3950d.f().z(new e9(this, k1Var, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void initForTests(Map map) {
        Z();
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void initialize(y1.a aVar, zzcl zzclVar, long j10) {
        h5 h5Var = this.f3950d;
        if (h5Var == null) {
            this.f3950d = h5.H((Context) f.h((Context) b.a0(aVar)), zzclVar, Long.valueOf(j10));
        } else {
            h5Var.d().w().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void isDataCollectionEnabled(k1 k1Var) {
        Z();
        this.f3950d.f().z(new ya(this, k1Var));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Z();
        this.f3950d.I().s(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void logEventAndBundle(String str, String str2, Bundle bundle, k1 k1Var, long j10) {
        Z();
        f.d(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f3950d.f().z(new e8(this, k1Var, new zzau(str2, new zzas(bundle), "app", j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void logHealthData(int i10, String str, y1.a aVar, y1.a aVar2, y1.a aVar3) {
        Z();
        this.f3950d.d().G(i10, true, false, str, aVar == null ? null : b.a0(aVar), aVar2 == null ? null : b.a0(aVar2), aVar3 != null ? b.a0(aVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityCreated(y1.a aVar, Bundle bundle, long j10) {
        Z();
        n7 n7Var = this.f3950d.I().f5551c;
        if (n7Var != null) {
            this.f3950d.I().p();
            n7Var.onActivityCreated((Activity) b.a0(aVar), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityDestroyed(y1.a aVar, long j10) {
        Z();
        n7 n7Var = this.f3950d.I().f5551c;
        if (n7Var != null) {
            this.f3950d.I().p();
            n7Var.onActivityDestroyed((Activity) b.a0(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityPaused(y1.a aVar, long j10) {
        Z();
        n7 n7Var = this.f3950d.I().f5551c;
        if (n7Var != null) {
            this.f3950d.I().p();
            n7Var.onActivityPaused((Activity) b.a0(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityResumed(y1.a aVar, long j10) {
        Z();
        n7 n7Var = this.f3950d.I().f5551c;
        if (n7Var != null) {
            this.f3950d.I().p();
            n7Var.onActivityResumed((Activity) b.a0(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivitySaveInstanceState(y1.a aVar, k1 k1Var, long j10) {
        Z();
        n7 n7Var = this.f3950d.I().f5551c;
        Bundle bundle = new Bundle();
        if (n7Var != null) {
            this.f3950d.I().p();
            n7Var.onActivitySaveInstanceState((Activity) b.a0(aVar), bundle);
        }
        try {
            k1Var.w(bundle);
        } catch (RemoteException e10) {
            this.f3950d.d().w().b("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityStarted(y1.a aVar, long j10) {
        Z();
        if (this.f3950d.I().f5551c != null) {
            this.f3950d.I().p();
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void onActivityStopped(y1.a aVar, long j10) {
        Z();
        if (this.f3950d.I().f5551c != null) {
            this.f3950d.I().p();
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void performAction(Bundle bundle, k1 k1Var, long j10) {
        Z();
        k1Var.w(null);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void registerOnMeasurementEventListener(n1 n1Var) {
        k6 abVar;
        Z();
        synchronized (this.f3951e) {
            try {
                abVar = (k6) this.f3951e.get(Integer.valueOf(n1Var.c()));
                if (abVar == null) {
                    abVar = new ab(this, n1Var);
                    this.f3951e.put(Integer.valueOf(n1Var.c()), abVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3950d.I().x(abVar);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void resetAnalyticsData(long j10) {
        Z();
        this.f3950d.I().y(j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setConditionalUserProperty(Bundle bundle, long j10) {
        Z();
        if (bundle == null) {
            this.f3950d.d().r().a("Conditional user property must not be null");
        } else {
            this.f3950d.I().E(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setConsent(final Bundle bundle, final long j10) {
        Z();
        final o7 o7VarI = this.f3950d.I();
        o7VarI.f5030a.f().A(new Runnable() { // from class: f2.n6
            @Override // java.lang.Runnable
            public final void run() {
                o7 o7Var = o7VarI;
                Bundle bundle2 = bundle;
                long j11 = j10;
                if (TextUtils.isEmpty(o7Var.f5030a.B().t())) {
                    o7Var.G(bundle2, 0, j11);
                } else {
                    o7Var.f5030a.d().x().a("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setConsentThirdParty(Bundle bundle, long j10) {
        Z();
        this.f3950d.I().G(bundle, -20, j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setCurrentScreen(y1.a aVar, String str, String str2, long j10) {
        Z();
        this.f3950d.K().D((Activity) b.a0(aVar), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setDataCollectionEnabled(boolean z10) {
        Z();
        o7 o7VarI = this.f3950d.I();
        o7VarI.i();
        o7VarI.f5030a.f().z(new l7(o7VarI, z10));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setDefaultEventParameters(Bundle bundle) {
        Z();
        final o7 o7VarI = this.f3950d.I();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        o7VarI.f5030a.f().z(new Runnable() { // from class: f2.o6
            @Override // java.lang.Runnable
            public final void run() {
                o7VarI.q(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setEventInterceptor(n1 n1Var) {
        Z();
        za zaVar = new za(this, n1Var);
        if (this.f3950d.f().C()) {
            this.f3950d.I().H(zaVar);
        } else {
            this.f3950d.f().z(new ha(this, zaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setInstanceIdProvider(p1 p1Var) {
        Z();
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setMeasurementEnabled(boolean z10, long j10) {
        Z();
        this.f3950d.I().I(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setMinimumSessionDuration(long j10) {
        Z();
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setSessionTimeoutDuration(long j10) {
        Z();
        o7 o7VarI = this.f3950d.I();
        o7VarI.f5030a.f().z(new s6(o7VarI, j10));
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setUserId(final String str, long j10) {
        Z();
        final o7 o7VarI = this.f3950d.I();
        if (str != null && TextUtils.isEmpty(str)) {
            o7VarI.f5030a.d().w().a("User ID must be non-empty or null");
        } else {
            o7VarI.f5030a.f().z(new Runnable() { // from class: f2.p6
                @Override // java.lang.Runnable
                public final void run() {
                    o7 o7Var = o7VarI;
                    if (o7Var.f5030a.B().w(str)) {
                        o7Var.f5030a.B().v();
                    }
                }
            });
            o7VarI.L(null, "_id", str, true, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void setUserProperty(String str, String str2, y1.a aVar, boolean z10, long j10) throws SecurityException {
        Z();
        this.f3950d.I().L(str, str2, b.a0(aVar), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public void unregisterOnMeasurementEventListener(n1 n1Var) {
        k6 abVar;
        Z();
        synchronized (this.f3951e) {
            abVar = (k6) this.f3951e.remove(Integer.valueOf(n1Var.c()));
        }
        if (abVar == null) {
            abVar = new ab(this, n1Var);
        }
        this.f3950d.I().N(abVar);
    }
}
