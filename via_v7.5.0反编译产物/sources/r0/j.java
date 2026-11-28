package r0;

import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;
import s0.t;
import s0.u;
import s0.v;
import s0.w;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static t a(WebSettings webSettings) {
        try {
            return w.c().b(webSettings);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT != 30 || !"android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                throw e10;
            }
            Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", e10);
            return new u();
        }
    }

    public static g b(WebSettings webSettings) {
        if (v.f12156c0.d()) {
            return a(webSettings).a();
        }
        throw v.a();
    }

    public static void c(WebSettings webSettings, boolean z10) {
        if (!v.Q.d()) {
            throw v.a();
        }
        a(webSettings).b(z10);
    }

    public static void d(WebSettings webSettings, int i10) {
        s0.a.i iVar = v.T;
        if (iVar.c()) {
            s0.g.a(webSettings, i10);
        } else {
            if (!iVar.d()) {
                throw v.a();
            }
            a(webSettings).c(i10);
        }
    }

    public static void e(WebSettings webSettings, g gVar) {
        if (!v.f12156c0.d()) {
            throw v.a();
        }
        a(webSettings).d(gVar);
    }

    public static void f(WebSettings webSettings, int i10) {
        if (!v.f12168i0.d()) {
            throw v.a();
        }
        a(webSettings).e(i10);
    }
}
