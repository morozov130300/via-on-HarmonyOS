package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.u2;
import f2.p7;
import g2.i;
import i2.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f3994b;

    /* renamed from: a, reason: collision with root package name */
    public final u2 f3995a;

    public FirebaseAnalytics(u2 u2Var) {
        f.h(u2Var);
        this.f3995a = u2Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f3994b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f3994b == null) {
                        f3994b = new FirebaseAnalytics(u2.q(context, null, null, null, null));
                    }
                } finally {
                }
            }
        }
        return f3994b;
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
        this.f3995a.E(str, bundle);
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
        this.f3995a.d(activity, str, str2);
    }
}
