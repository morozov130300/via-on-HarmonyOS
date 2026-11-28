package b0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import y.r;
import z.d0;
import z.g0;
import z.h0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends y.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rect f1673n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b0.b f1674o = new C0032a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b0.c f1675p = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f1680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f1681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f1682j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f1676d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f1677e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f1678f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f1679g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1683k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1684l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1685m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: b0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0032a implements b0.b {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b0.c {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends g0 {
        public c() {
        }

        @Override // z.g0
        public d0 b(int i10) {
            return d0.K(a.this.w(i10));
        }

        @Override // z.g0
        public d0 d(int i10) {
            int i11 = i10 == 2 ? a.this.f1683k : a.this.f1684l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // z.g0
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.D(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1681i = view;
        this.f1680h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (r.t(view) == 0) {
            r.c0(view, 1);
        }
    }

    public abstract void B(int i10, d0 d0Var);

    public boolean D(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? E(i10, i11, bundle) : F(i11, bundle);
    }

    public final boolean E(int i10, int i11, Bundle bundle) {
        if (i11 == 1) {
            return H(i10);
        }
        if (i11 == 2) {
            return o(i10);
        }
        if (i11 != 64) {
            return i11 != 128 ? x(i10, i11, bundle) : n(i10);
        }
        return G(i10);
    }

    public final boolean F(int i10, Bundle bundle) {
        return r.O(this.f1681i, i10, bundle);
    }

    public final boolean G(int i10) {
        int i11;
        if (!this.f1680h.isEnabled() || !this.f1680h.isTouchExplorationEnabled() || (i11 = this.f1683k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f1683k = i10;
        this.f1681i.invalidate();
        I(i10, 32768);
        return true;
    }

    public final boolean H(int i10) {
        int i11;
        if ((!this.f1681i.isFocused() && !this.f1681i.requestFocus()) || (i11 = this.f1684l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f1684l = i10;
        C(i10, true);
        I(i10, 8);
        return true;
    }

    public final boolean I(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f1680h.isEnabled() || (parent = this.f1681i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f1681i, p(i10, i11));
    }

    @Override // y.a
    public g0 b(View view) {
        if (this.f1682j == null) {
            this.f1682j = new c();
        }
        return this.f1682j;
    }

    @Override // y.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        y(accessibilityEvent);
    }

    @Override // y.a
    public void g(View view, d0 d0Var) {
        super.g(view, d0Var);
        A(d0Var);
    }

    public final boolean n(int i10) {
        if (this.f1683k != i10) {
            return false;
        }
        this.f1683k = Integer.MIN_VALUE;
        this.f1681i.invalidate();
        I(i10, 65536);
        return true;
    }

    public final boolean o(int i10) {
        if (this.f1684l != i10) {
            return false;
        }
        this.f1684l = Integer.MIN_VALUE;
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
        h0.a(accessibilityEventObtain, this.f1681i, i10);
        accessibilityEventObtain.setPackageName(this.f1681i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent r(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f1681i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    public final d0 s(int i10) {
        d0 d0VarI = d0.I();
        d0VarI.Y(true);
        d0VarI.Z(true);
        d0VarI.T("android.view.View");
        Rect rect = f1673n;
        d0VarI.R(rect);
        d0VarI.S(rect);
        d0VarI.e0(this.f1681i);
        B(i10, d0VarI);
        if (d0VarI.u() == null && d0VarI.p() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        d0VarI.k(this.f1677e);
        if (this.f1677e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iJ = d0VarI.j();
        if ((iJ & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iJ & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        d0VarI.c0(this.f1681i.getContext().getPackageName());
        d0VarI.i0(this.f1681i, i10);
        if (this.f1683k == i10) {
            d0VarI.P(true);
            d0VarI.a(128);
        } else {
            d0VarI.P(false);
            d0VarI.a(64);
        }
        boolean z10 = this.f1684l == i10;
        if (z10) {
            d0VarI.a(2);
        } else if (d0VarI.C()) {
            d0VarI.a(1);
        }
        d0VarI.a0(z10);
        this.f1681i.getLocationOnScreen(this.f1679g);
        d0VarI.l(this.f1676d);
        if (this.f1676d.equals(rect)) {
            d0VarI.k(this.f1676d);
            if (d0VarI.f15083b != -1) {
                d0 d0VarI2 = d0.I();
                for (int i11 = d0VarI.f15083b; i11 != -1; i11 = d0VarI2.f15083b) {
                    d0VarI2.f0(this.f1681i, -1);
                    d0VarI2.R(f1673n);
                    B(i11, d0VarI2);
                    d0VarI2.k(this.f1677e);
                    Rect rect2 = this.f1676d;
                    Rect rect3 = this.f1677e;
                    rect2.offset(rect3.left, rect3.top);
                }
                d0VarI2.M();
            }
            this.f1676d.offset(this.f1679g[0] - this.f1681i.getScrollX(), this.f1679g[1] - this.f1681i.getScrollY());
        }
        if (this.f1681i.getLocalVisibleRect(this.f1678f)) {
            this.f1678f.offset(this.f1679g[0] - this.f1681i.getScrollX(), this.f1679g[1] - this.f1681i.getScrollY());
            if (this.f1676d.intersect(this.f1678f)) {
                d0VarI.S(this.f1676d);
                if (v(this.f1676d)) {
                    d0VarI.l0(true);
                }
            }
        }
        return d0VarI;
    }

    public final d0 t() {
        d0 d0VarJ = d0.J(this.f1681i);
        r.M(this.f1681i, d0VarJ);
        ArrayList arrayList = new ArrayList();
        u(arrayList);
        if (d0VarJ.m() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d0VarJ.c(this.f1681i, ((Integer) arrayList.get(i10)).intValue());
        }
        return d0VarJ;
    }

    public abstract void u(List list);

    public final boolean v(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f1681i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f1681i.getParent();
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

    public abstract void z(int i10, AccessibilityEvent accessibilityEvent);

    public void A(d0 d0Var) {
    }

    public void y(AccessibilityEvent accessibilityEvent) {
    }

    public void C(int i10, boolean z10) {
    }
}
