package x8;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(Window window, int i10) {
        if (window == null || i10 == 0 || Build.VERSION.SDK_INT < 31 || d()) {
            return;
        }
        n8.l lVar = new n8.l(window);
        lVar.i(i10 == 1);
        lVar.j(30);
        lVar.h(80);
        lVar.f();
    }

    public static void b(View... viewArr) {
        if (viewArr == null || Build.VERSION.SDK_INT < 31 || d()) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setRenderEffect(null);
            }
        }
    }

    public static boolean c(View... viewArr) {
        if (viewArr != null && Build.VERSION.SDK_INT >= 31 && !d()) {
            int i10 = 0;
            for (View view : viewArr) {
                if (view != null) {
                    i10++;
                    view.setRenderEffect(RenderEffect.createBlurEffect(30.0f, 30.0f, Shader.TileMode.MIRROR));
                }
            }
            if (i10 > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT < 31 || !la.s.j().t().e();
    }

    public static void e(View view, boolean z10) {
        if (view == null || Build.VERSION.SDK_INT < 31 || d()) {
            return;
        }
        if (z10) {
            view.setRenderEffect(RenderEffect.createBlurEffect(30.0f, 30.0f, Shader.TileMode.MIRROR));
        } else {
            view.setRenderEffect(null);
        }
    }

    public static boolean f() {
        if (h3.f14580a && la.s.j().t().g()) {
            Drawable drawableB = w7.f.a().b();
            if (drawableB instanceof mark.via.browser.e) {
                return ((mark.via.browser.e) drawableB).c();
            }
        }
        return false;
    }
}
