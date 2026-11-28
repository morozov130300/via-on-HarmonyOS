package mark.via.browser;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z5 f9594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x.a f9595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f9597d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f9598e = new int[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f9599f = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: mark.via.browser.q5
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f9536c.d();
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9600g;

    public r5(z5 z5Var, int i10, x.a aVar) {
        this.f9594a = z5Var;
        this.f9595b = aVar;
        this.f9596c = Build.VERSION.SDK_INT >= 30 && i10 >= 139;
    }

    public static void e(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.bottomMargin == i10) {
            return;
        }
        marginLayoutParams.bottomMargin = i10;
        view.requestLayout();
    }

    public void b(y.k0 k0Var) {
        int iMax;
        if (this.f9600g) {
            boolean zK = k0Var.k(y.k0.m.c());
            int i10 = k0Var.f(y.k0.m.c()).f11878d;
            if (Build.VERSION.SDK_INT >= 30 || zK) {
                this.f9594a.getLocationInWindow(this.f9598e);
                iMax = zK ? Math.max(0, (this.f9598e[1] + this.f9594a.getHeight()) - (this.f9594a.getRootView().getHeight() - i10)) : 0;
            } else {
                iMax = c();
                zK = iMax > 0;
            }
            h(zK, iMax);
        }
    }

    public final int c() {
        this.f9594a.getWindowVisibleDisplayFrame(this.f9597d);
        this.f9594a.getRootView().getLocationOnScreen(this.f9598e);
        if ((this.f9598e[1] + this.f9594a.getRootView().getHeight()) - this.f9597d.bottom < com.tuyafeng.support.utils.x.h(this.f9594a.getContext(), 120.0f)) {
            return 0;
        }
        this.f9594a.getLocationOnScreen(this.f9598e);
        return Math.max(0, (this.f9598e[1] + this.f9594a.getHeight()) - this.f9597d.bottom);
    }

    public final void d() {
        y.k0 k0VarY = y.r.y(this.f9594a);
        if (k0VarY != null) {
            b(k0VarY);
        } else {
            int iC = c();
            h(iC > 0, iC);
        }
    }

    public void f() {
        if (this.f9600g) {
            return;
        }
        this.f9600g = true;
        if (Build.VERSION.SDK_INT < 30) {
            this.f9594a.getViewTreeObserver().addOnGlobalLayoutListener(this.f9599f);
        }
        y.r.V(this.f9594a.f9811c);
    }

    public void g() {
        if (this.f9600g) {
            this.f9600g = false;
            if (Build.VERSION.SDK_INT < 30) {
                this.f9594a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f9599f);
            }
            e(this.f9594a.f9811c, 0);
            e(this.f9594a.f9815o, 0);
            this.f9595b.accept(Boolean.FALSE);
        }
    }

    public final void h(boolean z10, int i10) {
        e(this.f9594a.f9811c, this.f9596c ? 0 : i10);
        if (this.f9596c) {
            this.f9594a.getLocationInWindow(this.f9598e);
            int height = (this.f9598e[1] + this.f9594a.getHeight()) - i10;
            this.f9594a.f9815o.getLocationInWindow(this.f9598e);
            e(this.f9594a.f9815o, z10 ? Math.max(0, ((this.f9598e[1] + this.f9594a.f9815o.getHeight()) + ((ViewGroup.MarginLayoutParams) this.f9594a.f9815o.getLayoutParams()).bottomMargin) - height) : 0);
        }
        this.f9595b.accept(Boolean.valueOf(z10));
    }

    public boolean i() {
        return this.f9596c;
    }
}
