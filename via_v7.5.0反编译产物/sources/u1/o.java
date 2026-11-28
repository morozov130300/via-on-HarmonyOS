package u1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f12800a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f12801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f12802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f12803d;

    public static int a(Context context) {
        b(context);
        return f12803d;
    }

    public static void b(Context context) {
        synchronized (f12800a) {
            try {
                if (f12801b) {
                    return;
                }
                f12801b = true;
                try {
                    Bundle bundle = y1.e.a(context).b(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f12802c = bundle.getString("com.google.app.id");
                    f12803d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
