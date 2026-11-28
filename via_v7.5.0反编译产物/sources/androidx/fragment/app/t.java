package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f854c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f855e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f857n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f858a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v10, WindowInsets insets) {
            kotlin.jvm.internal.h.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.h.f(v10, "v");
            kotlin.jvm.internal.h.f(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            kotlin.jvm.internal.h.e(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, AttributeSet attrs, FragmentManager fm) {
        String str;
        super(context, attrs);
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(attrs, "attrs");
        kotlin.jvm.internal.h.f(fm, "fm");
        this.f854c = new ArrayList();
        this.f855e = new ArrayList();
        this.f857n = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = e0.c.f4074e;
        kotlin.jvm.internal.h.e(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(e0.c.f4075f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(e0.c.f4076g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentM0 = fm.m0(id);
        if (classAttribute != null && fragmentM0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = fm.z0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.h.e(fragmentA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentA.I = id;
            fragmentA.J = id;
            fragmentA.K = string;
            fragmentA.E = fm;
            fragmentA.F = fm.B0();
            fragmentA.I1(context, attrs, null);
            fm.q().x(true).d(this, fragmentA, string).l();
        }
        fm.a1(this);
    }

    public final void a(View view) {
        if (this.f855e.contains(view)) {
            this.f854c.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i10, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.f(child, "child");
        if (FragmentManager.I0(child) != null) {
            super.addView(child, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        y.k0 k0VarL;
        kotlin.jvm.internal.h.f(insets, "insets");
        y.k0 k0VarQ = y.k0.q(insets);
        kotlin.jvm.internal.h.e(k0VarQ, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f856m;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f858a;
            kotlin.jvm.internal.h.c(onApplyWindowInsetsListener);
            k0VarL = y.k0.q(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            k0VarL = y.r.L(this, k0VarQ);
        }
        kotlin.jvm.internal.h.e(k0VarL, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!k0VarL.j()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                y.r.f(getChildAt(i10), k0VarL);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.h.f(canvas, "canvas");
        if (this.f857n) {
            Iterator it = this.f854c.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j10) {
        kotlin.jvm.internal.h.f(canvas, "canvas");
        kotlin.jvm.internal.h.f(child, "child");
        if (this.f857n && !this.f854c.isEmpty() && this.f854c.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        this.f855e.remove(view);
        if (this.f854c.remove(view)) {
            this.f857n = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.p0(this).m0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.h.f(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.h.e(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View view = getChildAt(i10);
        kotlin.jvm.internal.h.e(view, "view");
        a(view);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.h.e(view, "view");
            a(view);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.h.e(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f857n = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.h.f(listener, "listener");
        this.f856m = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        if (view.getParent() == this) {
            this.f855e.add(view);
        }
        super.startViewTransition(view);
    }
}
