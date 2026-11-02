package q0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import r0.o;
import r0.p;
import r0.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f11232a = Uri.parse("*");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f11233b = Uri.parse("");

    public static PackageInfo a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return r0.c.a();
        }
        try {
            return c();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static q b() {
        return p.d();
    }

    public static PackageInfo c() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static boolean d() {
        if (o.R.d()) {
            return b().getStatics().isMultiProcessEnabled();
        }
        throw o.a();
    }
}
