package z8;

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
import x.k0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l3 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14720a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f14721b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14722c;

    static {
        f14720a = Build.VERSION.SDK_INT >= 29;
        f14721b = x7.p.H0;
        f14722c = new int[]{0, 0, 0, 0};
    }

    public static /* synthetic */ x.k0 a(View view, View view2, View view3, x.k0 k0Var) {
        if (!i(k0Var, view3)) {
            d(k0Var, true, view3, view, view2);
            return k0Var;
        }
        r.f fVarF = k0Var.f(k0.m.b() | k0.m.f());
        if (r.f.f11464e.equals(fVarF)) {
            d(k0Var, false, view3, view, view2);
            return k0Var;
        }
        if (Resources.getSystem().getConfiguration().orientation == 2) {
            view3.setPadding(fVarF.f11465a, 0, fVarF.f11467c, 0);
            j(view, view2);
            return k0Var;
        }
        if (view == null && view2 == null) {
            view3.setPadding(0, fVarF.f11466b, 0, k0Var.f(k0.m.c()).f11468d > 0 ? 0 : fVarF.f11468d);
            return k0Var;
        }
        x.c cVarE = k0Var.e();
        int measuredWidth = view3.getMeasuredWidth();
        int measuredHeight = view3.getMeasuredHeight();
        if (cVarE != null && measuredWidth > 0 && measuredHeight > 0) {
            r.f fVarF2 = k0Var.f(k0.m.c());
            List<Rect> listA = cVarE.a();
            int[] iArr = {0, 0};
            int[] iArr2 = {0, 0};
            int iH = g6.y.h(view3.getContext(), 16.0f);
            for (Rect rect : listA) {
                if (rect.top <= iH) {
                    int i10 = rect.left;
                    int i11 = iH * 2;
                    if (i10 < i11) {
                        iArr[0] = Math.max(iArr[0], rect.right);
                    } else if (rect.right >= measuredWidth - i11) {
                        iArr[1] = Math.max(iArr[1], measuredWidth - i10);
                    }
                } else if (fVarF2.f11468d <= 0 && rect.bottom >= measuredHeight - iH) {
                    int i12 = rect.left;
                    int i13 = iH * 2;
                    if (i12 < i13) {
                        iArr2[0] = Math.max(iArr2[0], rect.right);
                    } else if (rect.right >= measuredWidth - i13) {
                        iArr2[1] = Math.max(iArr2[1], measuredWidth - i12);
                    }
                }
            }
            if (view != null) {
                view.setPadding(iArr[0], 0, iArr[1], 0);
            }
            if (view2 != null) {
                view2.setPadding(iArr2[0], 0, iArr2[1], 0);
            }
            view3.setPadding(0, 0, 0, 0);
        }
        return k0Var;
    }

    public static void b(View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        c(view, (View) g6.y.k(view, com.tuyafeng.support.widget.z.class), (View) g6.y.k(view, com.tuyafeng.support.widget.a0.class));
    }

    public static void c(View view, final View view2, final View view3) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        x.r.d0(view, new x.m() { // from class: z8.k3
            @Override // x.m
            public final x.k0 a(View view4, x.k0 k0Var) {
                return l3.a(view2, view3, view4, k0Var);
            }
        });
    }

    public static void d(x.k0 k0Var, boolean z10, View view, View view2, View view3) {
        if (!f14720a || k0Var == null || view == null) {
            return;
        }
        int i10 = 0;
        if (!z10) {
            j(view2, view3, view);
            return;
        }
        r.f fVarG = k0Var.g(k0.m.f() | k0.m.b());
        int i11 = fVarG.f11466b;
        if (view2 != null) {
            view2.setPadding(0, i11, 0, 0);
            i11 = 0;
        }
        int i12 = fVarG.f11468d;
        if (view3 != null) {
            view3.setPadding(0, 0, 0, i12);
        } else {
            i10 = i12;
        }
        view.setPadding(fVarG.f11465a, i11, fVarG.f11467c, i10);
    }

    public static Window e(Context context) {
        Activity activityA;
        if (context == null || (activityA = g6.f.a(context)) == null) {
            return null;
        }
        return activityA.getWindow();
    }

    public static boolean f(Context context) {
        return h(e(context));
    }

    public static boolean g(View view) {
        if (view == null) {
            return false;
        }
        View rootView = view.getRootView();
        if (Build.VERSION.SDK_INT < 30) {
            return (rootView.getSystemUiVisibility() & 4) == 4;
        }
        Object tag = rootView.getTag(f14721b);
        return tag instanceof Integer ? ((Integer) tag).intValue() == 1 : f(view.getContext());
    }

    public static boolean h(Window window) {
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= 30) {
            Object tag = decorView.getTag(f14721b);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue() == 1;
            }
            if (window.getDecorView().getRootWindowInsets() != null) {
                return !r5.isVisible(WindowInsets.Type.statusBars());
            }
        }
        return (decorView.getSystemUiVisibility() & 4) == 4;
    }

    public static boolean i(x.k0 k0Var, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            if (view != null) {
                Object tag = view.getRootView().getTag(f14721b);
                if (tag instanceof Integer) {
                    return ((Integer) tag).intValue() == 1;
                }
            }
            if (k0Var != null) {
                return !k0Var.k(k0.m.e());
            }
        }
        return g(view);
    }

    public static void j(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
            }
        }
    }

    public static void k(Context context, int[] iArr) {
        Window windowE;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21 || iArr == null || iArr.length == 0 || (windowE = e(context)) == null) {
            return;
        }
        int length = iArr.length;
        if (length >= 1) {
            windowE.setStatusBarColor(iArr[0]);
        }
        if (length >= 2) {
            windowE.setNavigationBarColor(iArr[1]);
            if (i10 >= 28) {
                windowE.setNavigationBarDividerColor(iArr[1]);
            }
        }
        if (length >= 3) {
            if (i10 < 30) {
                windowE.getDecorView().setSystemUiVisibility(iArr[2]);
                return;
            }
            WindowInsetsController insetsController = windowE.getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(iArr[2], 24);
            }
        }
    }

    public static int[] l(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            return new int[0];
        }
        Window windowE = e(context);
        if (windowE == null) {
            return new int[0];
        }
        int[] iArr = new int[3];
        iArr[0] = windowE.getStatusBarColor();
        iArr[1] = windowE.getNavigationBarColor();
        if (i10 < 30) {
            iArr[2] = windowE.getDecorView().getSystemUiVisibility();
            return iArr;
        }
        WindowInsetsController insetsController = windowE.getInsetsController();
        if (insetsController != null) {
            iArr[2] = insetsController.getSystemBarsAppearance();
        }
        return iArr;
    }

    public static void m(Context context) {
        int i10;
        Window windowE;
        if (f14720a && (i10 = Build.VERSION.SDK_INT) < 35 && (windowE = e(context)) != null) {
            if (i10 >= 30) {
                windowE.setDecorFitsSystemWindows(false);
            } else if (i10 >= 21) {
                windowE.getDecorView().setSystemUiVisibility(1792);
                windowE.setStatusBarColor(0);
                windowE.setNavigationBarColor(0);
            }
        }
    }

    public static void n(Window window, boolean z10) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            decorView.setTag(f14721b, Integer.valueOf(z10 ? 1 : 0));
            if (i10 < 35) {
                window.setDecorFitsSystemWindows((f14720a || z10) ? false : true);
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
        int i11 = (z10 || !f14720a) ? 5638 : 4102;
        decorView.setSystemUiVisibility(z10 ? i11 | decorView.getSystemUiVisibility() : (i11 ^ (-1)) & decorView.getSystemUiVisibility());
    }

    public static boolean o(Context context, boolean z10) {
        Window windowE;
        WindowInsetsController insetsController;
        boolean z11 = !z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26 || (windowE = e(context)) == null) {
            return z11;
        }
        if (i10 >= 30 && (insetsController = e(context).getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(z10 ? 16 : 0, 16);
            return true;
        }
        View decorView = windowE.getDecorView();
        decorView.setSystemUiVisibility(z10 ? decorView.getSystemUiVisibility() | 16 : decorView.getSystemUiVisibility() & (-17));
        return true;
    }

    public static boolean p(Context context, boolean z10) {
        Window windowE;
        WindowInsetsController insetsController;
        boolean z11 = !z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 || (windowE = e(context)) == null) {
            return z11;
        }
        if (i10 >= 30 && (insetsController = e(context).getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(z10 ? 8 : 0, 8);
            return true;
        }
        View decorView = windowE.getDecorView();
        decorView.setSystemUiVisibility(z10 ? decorView.getSystemUiVisibility() | 8192 : decorView.getSystemUiVisibility() & (-8193));
        return true;
    }

    public static void q(Context context, int i10) {
        Window windowE;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21 && (windowE = e(context)) != null) {
            boolean zC = g6.y.C(i10);
            o(context, zC);
            if (f14720a) {
                return;
            }
            if (zC && i11 < 26) {
                i10 = g6.y.G(i10, -16777216, 0.2f);
            }
            windowE.setNavigationBarColor(i10);
            if (i11 >= 28) {
                windowE.setNavigationBarDividerColor(i10);
            }
        }
    }

    public static void r(Context context, int i10) {
        Window windowE;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 21 && (windowE = e(context)) != null) {
            boolean zC = g6.y.C(i10);
            p(context, zC);
            if (f14720a) {
                return;
            }
            if (zC && i11 < 23) {
                i10 = g6.y.G(i10, -16777216, 0.2f);
            }
            windowE.setStatusBarColor(i10);
        }
    }

    public static void s(x.k0 k0Var) {
        WindowInsets windowInsetsP = k0Var == null ? null : k0Var.p();
        if (Build.VERSION.SDK_INT < 31 || windowInsetsP == null) {
            return;
        }
        RoundedCorner roundedCorner = windowInsetsP.getRoundedCorner(0);
        if (roundedCorner != null) {
            f14722c[0] = roundedCorner.getRadius();
        }
        RoundedCorner roundedCorner2 = windowInsetsP.getRoundedCorner(1);
        if (roundedCorner2 != null) {
            f14722c[1] = roundedCorner2.getRadius();
        }
        RoundedCorner roundedCorner3 = windowInsetsP.getRoundedCorner(2);
        if (roundedCorner3 != null) {
            f14722c[2] = roundedCorner3.getRadius();
        }
        RoundedCorner roundedCorner4 = windowInsetsP.getRoundedCorner(3);
        if (roundedCorner4 != null) {
            f14722c[3] = roundedCorner4.getRadius();
        }
    }
}
