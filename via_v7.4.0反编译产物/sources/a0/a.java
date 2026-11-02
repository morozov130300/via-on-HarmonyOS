package a0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import x.r;
import y.d0;
import y.g0;
import y.h0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends x.a {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f6n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final a0.b f7o = new C0002a();

    /* renamed from: p, reason: collision with root package name */
    public static final a0.c f8p = new b();

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f13h;

    /* renamed from: i, reason: collision with root package name */
    public final View f14i;

    /* renamed from: j, reason: collision with root package name */
    public c f15j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f9d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f10e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f11f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f12g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f16k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f17l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f18m = Integer.MIN_VALUE;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: a0.a$a, reason: collision with other inner class name */
    public class C0002a implements a0.b {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements a0.c {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends g0 {
        public c() {
        }

        @Override // y.g0
        public d0 b(int i10) {
            return d0.K(a.this.w(i10));
        }

        @Override // y.g0
        public d0 d(int i10) {
            int i11 = i10 == 2 ? a.this.f16k : a.this.f17l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // y.g0
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.D(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f14i = view;
        this.f13h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (r.t(view) == 0) {
            r.b0(view, 1);
        }
    }

    public void A(d0 d0Var) {
    }

    public abstract void B(int i10, d0 d0Var);

    public void C(int i10, boolean z10) {
    }

    public boolean D(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? E(i10, i11, bundle) : F(i11, bundle);
    }

    public final boolean E(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? x(i10, i11, bundle) : n(i10) : G(i10) : o(i10) : H(i10);
    }

    public final boolean F(int i10, Bundle bundle) {
        return r.N(this.f14i, i10, bundle);
    }

    public final boolean G(int i10) {
        int i11;
        if (!this.f13h.isEnabled() || !this.f13h.isTouchExplorationEnabled() || (i11 = this.f16k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f16k = i10;
        this.f14i.invalidate();
        I(i10, 32768);
        return true;
    }

    public final boolean H(int i10) {
        int i11;
        if ((!this.f14i.isFocused() && !this.f14i.requestFocus()) || (i11 = this.f17l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f17l = i10;
        C(i10, true);
        I(i10, 8);
        return true;
    }

    public final boolean I(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f13h.isEnabled() || (parent = this.f14i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f14i, p(i10, i11));
    }

    @Override // x.a
    public g0 b(View view) {
        if (this.f15j == null) {
            this.f15j = new c();
        }
        return this.f15j;
    }

    @Override // x.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        y(accessibilityEvent);
    }

    @Override // x.a
    public void g(View view, d0 d0Var) {
        super.g(view, d0Var);
        A(d0Var);
    }

    public final boolean n(int i10) {
        if (this.f16k != i10) {
            return false;
        }
        this.f16k = Integer.MIN_VALUE;
        this.f14i.invalidate();
        I(i10, 65536);
        return true;
    }

    public final boolean o(int i10) {
        if (this.f17l != i10) {
            return false;
        }
        this.f17l = Integer.MIN_VALUE;
        C(i10, false);
        I(i10, 8);
        return true;
    }

    public final AccessibilityEvent p(int i10, int i11) {
        return i10 != -1 ? q(i10, i11) : r(i11);
    }

    public final AccessibilityEvent q(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        d0 d0VarW = w(i10);
        accessibilityEventObtain.getText().add(d0VarW.u());
        accessibilityEventObtain.setContentDescription(d0VarW.p());
        accessibilityEventObtain.setScrollable(d0VarW.G());
        accessibilityEventObtain.setPassword(d0VarW.F());
        accessibilityEventObtain.setEnabled(d0VarW.B());
        accessibilityEventObtain.setChecked(d0VarW.z());
        z(i10, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(d0VarW.n());
        h0.a(accessibilityEventObtain, this.f14i, i10);
        accessibilityEventObtain.setPackageName(this.f14i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent r(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f14i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    public final d0 s(int i10) {
        d0 d0VarI = d0.I();
        d0VarI.Y(true);
        d0VarI.Z(true);
        d0VarI.T("android.view.View");
        Rect rect = f6n;
        d0VarI.R(rect);
        d0VarI.S(rect);
        d0VarI.e0(this.f14i);
        B(i10, d0VarI);
        if (d0VarI.u() == null && d0VarI.p() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        d0VarI.k(this.f10e);
        if (this.f10e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iJ = d0VarI.j();
        if ((iJ & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iJ & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        d0VarI.c0(this.f14i.getContext().getPackageName());
        d0VarI.i0(this.f14i, i10);
        if (this.f16k == i10) {
            d0VarI.P(true);
            d0VarI.a(128);
        } else {
            d0VarI.P(false);
            d0VarI.a(64);
        }
        boolean z10 = this.f17l == i10;
        if (z10) {
            d0VarI.a(2);
        } else if (d0VarI.C()) {
            d0VarI.a(1);
        }
        d0VarI.a0(z10);
        this.f14i.getLocationOnScreen(this.f12g);
        d0VarI.l(this.f9d);
        if (this.f9d.equals(rect)) {
            d0VarI.k(this.f9d);
            if (d0VarI.f14355b != -1) {
                d0 d0VarI2 = d0.I();
                for (int i11 = d0VarI.f14355b; i11 != -1; i11 = d0VarI2.f14355b) {
                    d0VarI2.f0(this.f14i, -1);
                    d0VarI2.R(f6n);
                    B(i11, d0VarI2);
                    d0VarI2.k(this.f10e);
                    Rect rect2 = this.f9d;
                    Rect rect3 = this.f10e;
                    rect2.offset(rect3.left, rect3.top);
                }
                d0VarI2.M();
            }
            this.f9d.offset(this.f12g[0] - this.f14i.getScrollX(), this.f12g[1] - this.f14i.getScrollY());
        }
        if (this.f14i.getLocalVisibleRect(this.f11f)) {
            this.f11f.offset(this.f12g[0] - this.f14i.getScrollX(), this.f12g[1] - this.f14i.getScrollY());
            if (this.f9d.intersect(this.f11f)) {
                d0VarI.S(this.f9d);
                if (v(this.f9d)) {
                    d0VarI.l0(true);
                }
            }
        }
        return d0VarI;
    }

    public final d0 t() {
        d0 d0VarJ = d0.J(this.f14i);
        r.L(this.f14i, d0VarJ);
        ArrayList arrayList = new ArrayList();
        u(arrayList);
        if (d0VarJ.m() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d0VarJ.c(this.f14i, ((Integer) arrayList.get(i10)).intValue());
        }
        return d0VarJ;
    }

    public abstract void u(List list);

    public final boolean v(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f14i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f14i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public d0 w(int i10) {
        return i10 == -1 ? t() : s(i10);
    }

    public abstract boolean x(int i10, int i11, Bundle bundle);

    public void y(AccessibilityEvent accessibilityEvent) {
    }

    public abstract void z(int i10, AccessibilityEvent accessibilityEvent);
}
