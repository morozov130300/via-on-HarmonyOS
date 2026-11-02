package n3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import g3.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10189a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f10190b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10191c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10192d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f10189a = contextA;
        this.f10190b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f10191c = cVar;
        this.f10192d = c();
    }

    public static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : o.a.b(context);
    }

    public synchronized boolean b() {
        return this.f10192d;
    }

    public final boolean c() {
        return this.f10190b.contains("firebase_data_collection_default_enabled") ? this.f10190b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f10189a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f10189a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
