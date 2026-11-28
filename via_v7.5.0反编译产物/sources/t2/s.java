package t2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2.e f12446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h2.g f12448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f12451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h2.g f12452h;

    public s(i2.e eVar) {
        Object obj = new Object();
        this.f12447c = obj;
        this.f12448d = new h2.g();
        this.f12449e = false;
        this.f12450f = false;
        this.f12452h = new h2.g();
        Context contextJ = eVar.j();
        this.f12446b = eVar;
        this.f12445a = CommonUtils.s(contextJ);
        Boolean boolB = b();
        this.f12451g = boolB == null ? a(contextJ) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f12448d.e(null);
                    this.f12449e = true;
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
            q2.f.f().e("Could not read data collection permission from manifest", e10);
            return null;
        }
    }

    public final Boolean a(Context context) {
        Boolean boolF = f(context);
        if (boolF == null) {
            this.f12450f = false;
            return null;
        }
        this.f12450f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolF));
    }

    public final Boolean b() {
        if (!this.f12445a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f12450f = false;
        return Boolean.valueOf(this.f12445a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f12452h.e(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f12451g;
            zBooleanValue = bool != null ? bool.booleanValue() : this.f12446b.t();
            e(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final void e(boolean z10) {
        String str;
        String str2 = z10 ? "ENABLED" : "DISABLED";
        if (this.f12451g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f12450f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        q2.f.f().b(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
    }

    public h2.f g() {
        h2.f fVarA;
        synchronized (this.f12447c) {
            fVarA = this.f12448d.a();
        }
        return fVarA;
    }

    public h2.f h(Executor executor) {
        return u0.j(executor, this.f12452h.a(), g());
    }
}
