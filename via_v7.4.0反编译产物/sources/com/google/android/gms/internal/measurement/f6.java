package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f6 implements c6 {

    /* renamed from: c, reason: collision with root package name */
    public static f6 f3493c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3494a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentObserver f3495b;

    public f6() {
        this.f3494a = null;
        this.f3495b = null;
    }

    public f6(Context context) {
        this.f3494a = context;
        e6 e6Var = new e6(this, null);
        this.f3495b = e6Var;
        context.getContentResolver().registerContentObserver(s5.f3752a, true, e6Var);
    }

    public static f6 b(Context context) {
        f6 f6Var;
        synchronized (f6.class) {
            try {
                if (f3493c == null) {
                    f3493c = o.o.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new f6(context) : new f6();
                }
                f6Var = f3493c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6Var;
    }

    public static synchronized void e() {
        Context context;
        try {
            f6 f6Var = f3493c;
            if (f6Var != null && (context = f6Var.f3494a) != null && f6Var.f3495b != null) {
                context.getContentResolver().unregisterContentObserver(f3493c.f3495b);
            }
            f3493c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.c6
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a(final String str) {
        Context context = this.f3494a;
        if (context != null && !u5.a(context)) {
            try {
                return (String) a6.a(new b6() { // from class: com.google.android.gms.internal.measurement.d6
                    @Override // com.google.android.gms.internal.measurement.b6
                    public final Object zza() {
                        return this.f3445a.d(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e10);
            }
        }
        return null;
    }

    public final /* synthetic */ String d(String str) {
        return s5.a(this.f3494a.getContentResolver(), str, null);
    }
}
