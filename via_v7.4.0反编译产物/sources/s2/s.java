package s2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11777a;

    /* renamed from: b, reason: collision with root package name */
    public final h2.e f11778b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11779c;

    /* renamed from: d, reason: collision with root package name */
    public g2.g f11780d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11781e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11782f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f11783g;

    /* renamed from: h, reason: collision with root package name */
    public final g2.g f11784h;

    public s(h2.e eVar) {
        Object obj = new Object();
        this.f11779c = obj;
        this.f11780d = new g2.g();
        this.f11781e = false;
        this.f11782f = false;
        this.f11784h = new g2.g();
        Context contextJ = eVar.j();
        this.f11778b = eVar;
        this.f11777a = CommonUtils.s(contextJ);
        Boolean boolB = b();
        this.f11783g = boolB == null ? a(contextJ) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f11780d.e(null);
                    this.f11781e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Boolean f(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e10) {
            p2.f.f().e("Could not read data collection permission from manifest", e10);
            return null;
        }
    }

    public final Boolean a(Context context) {
        Boolean boolF = f(context);
        if (boolF == null) {
            this.f11782f = false;
            return null;
        }
        this.f11782f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolF));
    }

    public final Boolean b() {
        if (!this.f11777a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f11782f = false;
        return Boolean.valueOf(this.f11777a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f11784h.e(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f11783g;
            zBooleanValue = bool != null ? bool.booleanValue() : this.f11778b.t();
            e(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final void e(boolean z10) {
        p2.f.f().b(String.format("Crashlytics automatic data collection %s by %s.", z10 ? "ENABLED" : "DISABLED", this.f11783g == null ? "global Firebase setting" : this.f11782f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    public g2.f g() {
        g2.f fVarA;
        synchronized (this.f11779c) {
            fVarA = this.f11780d.a();
        }
        return fVarA;
    }

    public g2.f h(Executor executor) {
        return u0.j(executor, this.f11784h.a(), g());
    }
}
