package x1;

import android.content.Context;
import w1.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f13567a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f13568b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f13567a;
        if (context2 != null && (bool = f13568b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f13568b = null;
        if (j.g()) {
            f13568b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f13568b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f13568b = Boolean.FALSE;
            }
        }
        f13567a = applicationContext;
        return f13568b.booleanValue();
    }
}
