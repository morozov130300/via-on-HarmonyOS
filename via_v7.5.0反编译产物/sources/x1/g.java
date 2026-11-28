package x1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f14463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f14464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f14465c;

    public static boolean a() {
        int i10 = r1.g.f11934a;
        return "user".equals(Build.TYPE);
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f14463a == null) {
            boolean z10 = false;
            if (j.d() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f14463a = Boolean.valueOf(z10);
        }
        return f14463a.booleanValue();
    }

    public static boolean c(Context context) {
        if (b(context) && !j.f()) {
            return true;
        }
        if (d(context)) {
            return !j.g() || j.i();
        }
        return false;
    }

    public static boolean d(Context context) {
        if (f14464b == null) {
            boolean z10 = false;
            if (j.e() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f14464b = Boolean.valueOf(z10);
        }
        return f14464b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f14465c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f14465c = Boolean.valueOf(z10);
        }
        return f14465c.booleanValue();
    }
}
