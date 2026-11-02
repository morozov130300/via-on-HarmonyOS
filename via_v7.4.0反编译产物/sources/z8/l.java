package z8;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static void a(Window window, int i10) {
        if (window == null || i10 == 0 || Build.VERSION.SDK_INT < 31 || d()) {
            return;
        }
        p8.l lVar = new p8.l(window);
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
        return Build.VERSION.SDK_INT < 31 || !pa.r.j().s().e();
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
        if (l3.f14720a && pa.r.j().s().g()) {
            Drawable drawableB = x7.f.a().b();
            if (drawableB instanceof c8.b) {
                return ((c8.b) drawableB).c();
            }
        }
        return false;
    }
}
