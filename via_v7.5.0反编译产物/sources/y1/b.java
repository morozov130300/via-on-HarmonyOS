package y1;

import android.content.Context;
import x1.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f14811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f14812b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f14811a;
        if (context2 != null && (bool = f14812b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f14812b = null;
        if (j.g()) {
            f14812b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f14812b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f14812b = Boolean.FALSE;
            }
        }
        f14811a = applicationContext;
        return f14812b.booleanValue();
    }
}
