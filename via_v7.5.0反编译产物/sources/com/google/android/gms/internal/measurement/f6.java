package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f6 implements c6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f6 f2792c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentObserver f2794b;

    public f6() {
        this.f2793a = null;
        this.f2794b = null;
    }

    public static f6 b(Context context) {
        f6 f6Var;
        synchronized (f6.class) {
            try {
                if (f2792c == null) {
                    f2792c = o.o.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new f6(context) : new f6();
                }
                f6Var = f2792c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6Var;
    }

    public static synchronized void e() {
        Context context;
        try {
            f6 f6Var = f2792c;
            if (f6Var != null && (context = f6Var.f2793a) != null && f6Var.f2794b != null) {
                context.getContentResolver().unregisterContentObserver(f2792c.f2794b);
            }
            f2792c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.c6
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a(final String str) {
        Context context = this.f2793a;
        if (context != null && !u5.a(context)) {
            try {
                return (String) a6.a(new b6() { // from class: com.google.android.gms.internal.measurement.d6
                    @Override // com.google.android.gms.internal.measurement.b6
                    public final Object zza() {
                        return this.f2744a.d(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e10);
            }
        }
        return null;
    }

    public final /* synthetic */ String d(String str) {
        return s5.a(this.f2793a.getContentResolver(), str, null);
    }

    public f6(Context context) {
        this.f2793a = context;
        e6 e6Var = new e6(this, null);
        this.f2794b = e6Var;
        context.getContentResolver().registerContentObserver(s5.f3051a, true, e6Var);
    }
}
