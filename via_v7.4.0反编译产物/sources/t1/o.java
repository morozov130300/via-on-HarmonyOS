package t1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f12067a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12068b;

    /* renamed from: c, reason: collision with root package name */
    public static String f12069c;

    /* renamed from: d, reason: collision with root package name */
    public static int f12070d;

    public static int a(Context context) {
        b(context);
        return f12070d;
    }

    public static void b(Context context) {
        Bundle bundle;
        synchronized (f12067a) {
            try {
                if (f12068b) {
                    return;
                }
                f12068b = true;
                try {
                    bundle = x1.e.a(context).b(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
                if (bundle == null) {
                    return;
                }
                f12069c = bundle.getString("com.google.app.id");
                f12070d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
