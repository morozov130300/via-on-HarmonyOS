package o3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import h3.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f10914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f10915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10916d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f10913a = contextA;
        this.f10914b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f10915c = cVar;
        this.f10916d = c();
    }

    public static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : o.a.b(context);
    }

    public synchronized boolean b() {
        return this.f10916d;
    }

    public final boolean c() {
        return this.f10914b.contains("firebase_data_collection_default_enabled") ? this.f10914b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f10913a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f10913a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
