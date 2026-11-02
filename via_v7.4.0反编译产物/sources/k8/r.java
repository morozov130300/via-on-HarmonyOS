package k8;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import g6.y;
import x.k0;
import z8.l3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: e, reason: collision with root package name */
    public View f8218e;

    /* renamed from: j, reason: collision with root package name */
    public ViewGroup f8219j;

    /* renamed from: k, reason: collision with root package name */
    public ViewTreeObserver f8220k;

    /* renamed from: n, reason: collision with root package name */
    public final FrameLayout.LayoutParams f8223n;

    /* renamed from: q, reason: collision with root package name */
    public int f8226q;

    /* renamed from: s, reason: collision with root package name */
    public int f8228s;

    /* renamed from: t, reason: collision with root package name */
    public a f8229t;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f8221l = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: k8.q
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f8217e.h();
        }
    };

    /* renamed from: m, reason: collision with root package name */
    public final Rect f8222m = new Rect();

    /* renamed from: o, reason: collision with root package name */
    public int f8224o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f8225p = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8227r = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8230u = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(boolean z10);
    }

    public r(Activity activity) {
        this.f8228s = 0;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        this.f8219j = viewGroup;
        View childAt = viewGroup.getChildAt(0);
        this.f8218e = childAt;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        this.f8223n = layoutParams;
        this.f8228s = layoutParams.height;
        this.f8226q = y.h(activity, 120.0f);
    }

    public static int c(int i10, int i11, int i12, boolean z10, boolean z11) {
        if (!z10) {
            return i10;
        }
        if (!z11) {
            i12 = 0;
        }
        return i11 + i12;
    }

    public static int d(Rect rect, r.f fVar, boolean z10, boolean z11) {
        return c(rect.height(), rect.bottom, fVar.f11468d, z10, z11);
    }

    public void e() {
        this.f8218e = null;
        this.f8219j = null;
        this.f8220k = null;
    }

    public void f() {
        ViewTreeObserver viewTreeObserver = this.f8220k;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        this.f8220k.removeOnGlobalLayoutListener(this.f8221l);
    }

    public void g() {
        ViewTreeObserver viewTreeObserver = this.f8220k;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            this.f8220k = this.f8218e.getViewTreeObserver();
        }
        this.f8220k.removeOnGlobalLayoutListener(this.f8221l);
        this.f8220k.addOnGlobalLayoutListener(this.f8221l);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        int i10;
        ViewGroup viewGroup = this.f8219j;
        if (viewGroup == null) {
            View view = this.f8218e;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = this.f8223n;
                int i11 = layoutParams.height;
                int i12 = this.f8228s;
                if (i11 != i12) {
                    layoutParams.height = i12;
                    view.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            return;
        }
        viewGroup.getWindowVisibleDisplayFrame(this.f8222m);
        int iWidth = this.f8222m.width();
        k0 k0VarY = x.r.y(this.f8218e);
        boolean z10 = false;
        int iD = d(this.f8222m, k0VarY == null ? r.f.f11464e : k0VarY.f(k0.m.f()), l3.f14720a, k0VarY != null && k0VarY.k(k0.m.e()));
        int i13 = this.f8224o;
        if (iD == i13) {
            return;
        }
        if (Math.abs(i13 - iD) <= this.f8226q || Math.abs(this.f8225p - iWidth) >= this.f8226q / 2) {
            int i14 = this.f8223n.height;
            int i15 = this.f8228s;
            i10 = i14 == i15 ? i15 : iD;
        } else {
            if (this.f8224o > iD && (k0VarY == null || k0VarY.k(k0.m.c()))) {
                z10 = true;
            }
            a aVar = this.f8229t;
            if (aVar != null && z10 != this.f8230u) {
                aVar.a(!z10);
                this.f8230u = z10;
            }
            if (!this.f8227r || !z10) {
                i10 = this.f8228s;
            }
        }
        FrameLayout.LayoutParams layoutParams2 = this.f8223n;
        if (i10 != layoutParams2.height) {
            layoutParams2.height = i10;
            this.f8218e.requestLayout();
        }
        this.f8224o = iD;
        this.f8225p = iWidth;
    }

    public void i(a aVar) {
        this.f8229t = aVar;
    }

    public void j(boolean z10) {
        this.f8227r = z10;
    }
}
