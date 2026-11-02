package s4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.stopLoading();
            webView.getSettings().setJavaScriptEnabled(false);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(null);
            webView.setTag(null);
            webView.clearHistory();
            webView.clearCache(false);
            webView.onPause();
            if (Build.VERSION.SDK_INT <= 19) {
                webView.freeMemory();
            }
            webView.removeAllViews();
            webView.destroyDrawingCache();
            webView.destroy();
        } catch (Exception unused) {
        }
    }

    public static PackageInfo b(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            return null;
        }
        if (i10 >= 26) {
            return WebView.getCurrentWebViewPackage();
        }
        try {
            PackageInfo packageInfoC = c();
            return packageInfoC != null ? packageInfoC : d(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static PackageInfo c() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static PackageInfo d(Context context) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            String str = (i10 < 21 || i10 > 23) ? (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", null).invoke(null, null) : (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", null).invoke(null, null);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static int e(View view) {
        if (view != null) {
            Bitmap bitmapCreateBitmap = null;
            try {
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                    view.draw(new Canvas(bitmapCreateBitmap));
                    int pixel = bitmapCreateBitmap.getPixel(0, 0);
                    bitmapCreateBitmap.recycle();
                    return pixel;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                }
            } catch (Throwable th) {
                if (bitmapCreateBitmap != null) {
                    bitmapCreateBitmap.recycle();
                }
                throw th;
            }
        }
        return 0;
    }

    public static void f(WebView webView) {
        if (webView == null) {
            return;
        }
        Context context = webView.getContext();
        webView.setDrawingCacheBackgroundColor(0);
        webView.setFocusable(true);
        if (Build.VERSION.SDK_INT < 23) {
            webView.setAnimationCacheEnabled(false);
        }
        webView.setBackgroundColor(0);
        webView.setScrollbarFadingEnabled(true);
        webView.setSaveEnabled(true);
        webView.setScrollBarSize(10);
        WebSettings settings = webView.getSettings();
        settings.setEnableSmoothTransition(true);
        try {
            settings.setMediaPlaybackRequiresUserGesture(true);
        } catch (Exception unused) {
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 19) {
            settings.setDatabasePath(context.getCacheDir() + "/databases");
        }
        settings.setDomStorageEnabled(true);
        settings.setGeolocationDatabasePath(context.getFilesDir().toString());
        settings.setAllowFileAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setSaveFormData(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAllowContentAccess(true);
        settings.setMinimumFontSize(1);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (i10 >= 21) {
            try {
                settings.setMixedContentMode(0);
            } catch (Exception unused2) {
            }
        }
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(context.getApplicationContext());
        }
    }

    public static void g(WebView webView, String str) {
        if (str == null || str.isEmpty() || webView == null) {
            return;
        }
        try {
            webView.evaluateJavascript(str, null);
        } catch (Exception unused) {
        }
    }

    public static void h(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.onPause();
    }

    public static void i(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.onResume();
    }

    public static boolean j(WebView webView, String str) {
        if (webView != null && str != null && str.length() > 0) {
            try {
                webView.saveWebArchive(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
