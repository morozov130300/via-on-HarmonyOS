package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.u2;
import g2.p7;
import h2.i;
import j2.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f3291b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2 f3292a;

    public FirebaseAnalytics(u2 u2Var) {
        f.h(u2Var);
        this.f3292a = u2Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f3291b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f3291b == null) {
                        f3291b = new FirebaseAnalytics(u2.q(context, null, null, null, null));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3291b;
    }

    @Keep
    public static p7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        u2 u2VarQ = u2.q(context, null, null, null, bundle);
        if (u2VarQ == null) {
            return null;
        }
        return new a(u2VarQ);
    }

    public void a(String str, Bundle bundle) {
        this.f3292a.E(str, bundle);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) i.b(com.google.firebase.installations.a.m().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.f3292a.d(activity, str, str2);
    }
}
