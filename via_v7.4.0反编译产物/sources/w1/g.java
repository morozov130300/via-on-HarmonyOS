package w1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f13215a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f13216b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f13217c;

    public static boolean a() {
        int i10 = q1.g.f11244a;
        return "user".equals(Build.TYPE);
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f13215a == null) {
            boolean z10 = false;
            if (j.d() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f13215a = Boolean.valueOf(z10);
        }
        return f13215a.booleanValue();
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
        if (f13216b == null) {
            boolean z10 = false;
            if (j.e() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f13216b = Boolean.valueOf(z10);
        }
        return f13216b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f13217c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f13217c = Boolean.valueOf(z10);
        }
        return f13217c.booleanValue();
    }
}
