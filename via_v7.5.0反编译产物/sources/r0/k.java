package r0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import s0.v;
import s0.w;
import s0.x;
import s0.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f11921a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f11922b = Uri.parse("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f11923c = new WeakHashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(WebView webView, h hVar, Uri uri, boolean z10, c cVar);
    }

    public static f a(WebView webView, String str, Set set) {
        if (v.W.d()) {
            return j(webView).a(str, (String[]) set.toArray(new String[0]));
        }
        throw v.a();
    }

    public static f b(WebView webView, String str, int i10, Set set, b bVar) {
        if (!v.P0.d()) {
            throw v.a();
        }
        bVar.a(webView);
        return j(webView).b(str, i10, (String[]) set.toArray(new String[0]), bVar.b());
    }

    public static void c(WebView webView, String str, Set set, b bVar, a aVar) {
        if (!v.P0.d()) {
            throw v.a();
        }
        bVar.a(webView);
        j(webView).c(str, (String[]) set.toArray(new String[0]), bVar.b(), aVar);
    }

    public static void d(WebView webView, String str, Set set, a aVar) {
        if (!v.V.d()) {
            throw v.a();
        }
        j(webView).d(str, (String[]) set.toArray(new String[0]), aVar);
    }

    public static WebViewProviderBoundaryInterface e(WebView webView) {
        return h().createWebView(webView);
    }

    public static PackageInfo f() {
        if (Build.VERSION.SDK_INT >= 26) {
            return s0.c.a();
        }
        try {
            return i();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static b g(WebView webView, String str) {
        if (!v.P0.d()) {
            throw v.a();
        }
        j(webView).e(str);
        return new b(str, webView);
    }

    public static y h() {
        return w.d();
    }

    public static PackageInfo i() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static x j(WebView webView) {
        if (!v.B0.d()) {
            return new x(e(webView));
        }
        WeakHashMap weakHashMap = f11923c;
        x xVar = (x) weakHashMap.get(webView);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(e(webView));
        weakHashMap.put(webView, xVar2);
        return xVar2;
    }

    public static boolean k() {
        if (v.S.d()) {
            return h().getStatics().isMultiProcessEnabled();
        }
        throw v.a();
    }

    public static void l(WebView webView, String str) {
        if (!v.V.d()) {
            throw v.a();
        }
        j(webView).f(str);
    }

    public static void m(WebView webView, b bVar, String str) {
        if (!v.P0.d()) {
            throw v.a();
        }
        bVar.a(webView);
        j(webView).g(str, bVar.b());
    }
}
