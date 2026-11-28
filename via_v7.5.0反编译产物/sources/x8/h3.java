package x8;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f14580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f14582c;

    static {
        f14580a = Build.VERSION.SDK_INT >= 29;
        f14581b = w7.p.F0;
        f14582c = new int[]{0, 0, 0, 0};
    }

    public static /* synthetic */ y.k0 a(View view, View view2, View view3, y.k0 k0Var) {
        c(view3, view, view2, k0Var);
        d(view3, k0Var);
        return k0Var;
    }

    public static void c(View view, View view2, View view3, y.k0 k0Var) {
        if (!l(k0Var, view)) {
            g(k0Var, true, view, view2, view3);
            return;
        }
        r.f fVarF = k0Var.f(y.k0.m.b() | y.k0.m.f());
        if (r.f.f11874e.equals(fVarF)) {
            g(k0Var, false, view, view2, view3);
            return;
        }
        if (Resources.getSystem().getConfiguration().orientation == 2) {
            view.setPadding(fVarF.f11875a, 0, fVarF.f11877c, 0);
            m(view2, view3);
            return;
        }
        if (view2 == null && view3 == null) {
            view.setPadding(0, fVarF.f11876b, 0, k0Var.f(y.k0.m.c()).f11878d > 0 ? 0 : fVarF.f11878d);
            return;
        }
        y.c cVarE = k0Var.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE == null || measuredWidth <= 0 || measuredHeight <= 0) {
            view.setPadding(0, 0, 0, 0);
            return;
        }
        r.f fVarF2 = k0Var.f(y.k0.m.c());
        List<Rect> listA = cVarE.a();
        int[] iArr = {0, 0};
        int[] iArr2 = {0, 0};
        int iH = com.tuyafeng.support.utils.x.h(view.getContext(), 16.0f);
        for (Rect rect : listA) {
            if (rect.top <= iH) {
                int i10 = rect.left;
                int i11 = iH * 2;
                if (i10 < i11) {
                    iArr[0] = Math.max(iArr[0], rect.right);
                } else if (rect.right >= measuredWidth - i11) {
                    iArr[1] = Math.max(iArr[1], measuredWidth - i10);
                }
            } else if (fVarF2.f11878d <= 0 && rect.bottom >= measuredHeight - iH) {
                int i12 = rect.left;
                int i13 = iH * 2;
                if (i12 < i13) {
                    iArr2[0] = Math.max(iArr2[0], rect.right);
                } else if (rect.right >= measuredWidth - i13) {
                    iArr2[1] = Math.max(iArr2[1], measuredWidth - i12);
                }
            }
        }
        if (view2 != null) {
            view2.setPadding(iArr[0], 0, iArr[1], 0);
        }
        if (view3 != null) {
            view3.setPadding(iArr2[0], 0, iArr2[1], 0);
        }
        view.setPadding(0, 0, 0, 0);
    }

    public static void d(final View view, y.k0 k0Var) {
        Window windowH;
        if (f14580a && (windowH = h(view.getContext())) != null) {
            int i10 = windowH.getAttributes().softInputMode & 240;
            if (i10 == 16 || i10 == 0) {
                int i11 = k0Var.f(y.k0.m.c()).f11878d;
                if (i11 > 0 && !y.r.G(view)) {
                    y.o.a(view, new Runnable() { // from class: x8.g3
                        @Override // java.lang.Runnable
                        public final void run() {
                            y.r.V(view);
                        }
                    });
                } else if (i11 > 0) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), Math.max(view.getPaddingBottom(), Math.max(0, (iArr[1] + view.getHeight()) - (view.getRootView().getHeight() - i11))));
                }
            }
        }
    }

    public static void e(View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        f(view, (View) com.tuyafeng.support.utils.x.k(view, com.tuyafeng.support.widget.e0.class), (View) com.tuyafeng.support.utils.x.k(view, com.tuyafeng.support.widget.f0.class));
    }

    public static void f(View view, final View view2, final View view3) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        y.r.e0(view, new y.m() { // from class: x8.f3
            @Override // y.m
            public final y.k0 a(View view4, y.k0 k0Var) {
                return h3.a(view2, view3, view4, k0Var);
            }
        });
    }

    public static void g(y.k0 k0Var, boolean z10, View view, View view2, View view3) {
        if (!f14580a || k0Var == null || view == null) {
            return;
        }
        int i10 = 0;
        if (!z10) {
            m(view2, view3, view);
            return;
        }
        r.f fVarG = k0Var.g(y.k0.m.f() | y.k0.m.b());
        int i11 = fVarG.f11876b;
        if (view2 != null) {
            view2.setPadding(0, i11, 0, 0);
            i11 = 0;
        }
        int i12 = fVarG.f11878d;
        if (view3 != null) {
            view3.setPadding(0, 0, 0, k0Var.k(y.k0.m.c()) ? 0 : fVarG.f11878d);
        } else {
            i10 = i12;
        }
        view.setPadding(fVarG.f11875a, i11, fVarG.f11877c, i10);
    }

    public static Window h(Context context) {
        Activity activityA;
        if (context == null || (activityA = com.tuyafeng.support.utils.f.a(context)) == null) {
            return null;
        }
        return activityA.getWindow();
    }

    public static boolean i(Context context) {
        return k(h(context));
    }

    public static boolean j(View view) {
        if (view == null) {
            return false;
        }
        View rootView = view.getRootView();
        if (Build.VERSION.SDK_INT < 30) {
            return (rootView.getSystemUiVisibility() & 4) == 4;
        }
        Object tag = rootView.getTag(f14581b);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue() == 1;
        }
        return i(view.getContext());
    }

    public static boolean k(Window window) {
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= 30) {
            Object tag = decorView.getTag(f14581b);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue() == 1;
            }
            WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                return !rootWindowInsets.isVisible(WindowInsets.Type.statusBars());
            }
        }
        return (decorView.getSystemUiVisibility() & 4) == 4;
    }

    public static boolean l(y.k0 k0Var, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            if (view != null) {
                Object tag = view.getRootView().getTag(f14581b);
                if (tag instanceof Integer) {
                    return ((Integer) tag).intValue() == 1;
                }
            }
            if (k0Var != null) {
                return !k0Var.k(y.k0.m.e());
            }
        }
        return j(view);
    }

    public static void m(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
            }
        }
    }

    public static void n(Context context, int[] iArr) {
        Window windowH;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21 || iArr == null || iArr.length == 0 || (windowH = h(context)) == null) {
            return;
        }
        int length = iArr.length;
        if (length >= 1) {
            windowH.setStatusBarColor(iArr[0]);
        }
        if (length >= 2) {
            windowH.setNavigationBarColor(iArr[1]);
            if (i10 >= 28) {
                windowH.setNavigationBarDividerColor(iArr[1]);
            }
        }
        if (length >= 3) {
            if (i10 < 30) {
                windowH.getDecorView().setSystemUiVisibility(iArr[2]);
                return;
            }
            WindowInsetsController insetsController = windowH.getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(iArr[2], 24);
            }
        }
    }

    public static int[] o(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            return new int[0];
        }
        Window windowH = h(context);
        if (windowH == null) {
            return new int[0];
        }
        int[] iArr = new int[3];
        iArr[0] = windowH.getStatusBarColor();
        iArr[1] = windowH.getNavigationBarColor();
        if (i10 < 30) {
            iArr[2] = windowH.getDecorView().getSystemUiVisibility();
            return iArr;
        }
        WindowInsetsController insetsController = windowH.getInsetsController();
        if (insetsController != null) {
            iArr[2] = insetsController.getSystemBarsAppearance();
        }
        return iArr;
    }

    public static void p(Context context) {
        int i10;
        Window windowH;
        if (f14580a && (i10 = Build.VERSION.SDK_INT) < 35 && (windowH = h(context)) != null) {
            if (i10 >= 30) {
                windowH.setDecorFitsSystemWindows(false);
            } else if (i10 >= 21) {
                windowH.getDecorView().setSystemUiVisibility(1792);
                windowH.setStatusBarColor(0);
                windowH.setNavigationBarColor(0);
            }
        }
    }

    public static void q(Window window, boolean z10) {
        int systemUiVisibility;
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            decorView.setTag(f14581b, Integer.valueOf(z10 ? 1 : 0));
            if (i10 < 35) {
                window.setDecorFitsSystemWindows((f14580a || z10) ? false : true);
            }
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                if (z10) {
                    insetsController.setSystemBarsBehavior(2);
                    insetsController.hide(WindowInsets.Type.systemBars());
                    return;
                } else {
                    if (i10 >= 31) {
                        insetsController.setSystemBarsBehavior(1);
                    }
                    insetsController.show(WindowInsets.Type.systemBars());
                    return;
                }
            }
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = z10 ? attributes.flags | 1024 : attributes.flags & (-1025);
        window.setAttributes(attributes);
        int i11 = (z10 || !f14580a) ? 5638 : 4102;
        if (z10) {
            systemUiVisibility = i11 | decorView.getSystemUiVisibility();
        } else {
            systemUiVisibility = (i11 ^ (-1)) & decorView.getSystemUiVisibility();
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }

    public static boolean r(Context context, boolean z10) {
        Window windowH;
        WindowInsetsController insetsController;
        boolean z11 = !z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26 || (windowH = h(context)) == null) {
            return z11;
        }
        if (i10 >= 30 && (insetsController = h(context).getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(z10 ? 16 : 0, 16);
            return true;
        }
        View decorView = windowH.getDecorView();
        decorView.setSystemUiVisibility(z10 ? decorView.getSystemUiVisibility() | 16 : decorView.getSystemUiVisibility() & (-17));
        return true;
    }

    public static boolean s(Context context, boolean z10) {
        Window windowH;
        WindowInsetsController insetsController;
        boolean z11 = !z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 || (windowH = h(context)) == null) {
            return z11;
        }
        if (i10 >= 30 && (insetsController = h(context).getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(z10 ? 8 : 0, 8);
            return true;
        }
        View decorView = windowH.getDecorView();
        decorView.setSystemUiVisibility(z10 ? decorView.getSystemUiVisibility() | 8192 : decorView.getSystemUiVisibility() & (-8193));
        return true;
    }

    public static void t(Context context, int i10) {
        Window windowH;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21 && (windowH = h(context)) != null) {
            boolean zC = com.tuyafeng.support.utils.x.C(i10);
            r(context, zC);
            if (f14580a) {
                return;
            }
            if (zC && i11 < 26) {
                i10 = com.tuyafeng.support.utils.x.G(i10, -16777216, 0.2f);
            }
            windowH.setNavigationBarColor(i10);
            if (i11 >= 28) {
                windowH.setNavigationBarDividerColor(i10);
            }
        }
    }

    public static void u(Context context, int i10) {
        Window windowH;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21 && (windowH = h(context)) != null) {
            boolean zC = com.tuyafeng.support.utils.x.C(i10);
            s(context, zC);
            if (f14580a) {
                return;
            }
            if (zC && i11 < 23) {
                i10 = com.tuyafeng.support.utils.x.G(i10, -16777216, 0.2f);
            }
            windowH.setStatusBarColor(i10);
        }
    }

    public static void v(y.k0 k0Var) {
        WindowInsets windowInsetsP = k0Var == null ? null : k0Var.p();
        if (Build.VERSION.SDK_INT < 31 || windowInsetsP == null) {
            return;
        }
        RoundedCorner roundedCorner = windowInsetsP.getRoundedCorner(0);
        if (roundedCorner != null) {
            f14582c[0] = roundedCorner.getRadius();
        }
        RoundedCorner roundedCorner2 = windowInsetsP.getRoundedCorner(1);
        if (roundedCorner2 != null) {
            f14582c[1] = roundedCorner2.getRadius();
        }
        RoundedCorner roundedCorner3 = windowInsetsP.getRoundedCorner(2);
        if (roundedCorner3 != null) {
            f14582c[2] = roundedCorner3.getRadius();
        }
        RoundedCorner roundedCorner4 = windowInsetsP.getRoundedCorner(3);
        if (roundedCorner4 != null) {
            f14582c[3] = roundedCorner4.getRadius();
        }
    }
}
