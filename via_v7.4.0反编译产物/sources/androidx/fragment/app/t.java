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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public final List f953e;

    /* renamed from: j, reason: collision with root package name */
    public final List f954j;

    /* renamed from: k, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f955k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f956l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f957a = new a();

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v10, WindowInsets insets) {
            kotlin.jvm.internal.h.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.h.f(v10, "v");
            kotlin.jvm.internal.h.f(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            kotlin.jvm.internal.h.e(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe\u2026lyWindowInsets(v, insets)");
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
        this.f953e = new ArrayList();
        this.f954j = new ArrayList();
        this.f956l = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = d0.c.f4442e;
        kotlin.jvm.internal.h.e(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(d0.c.f4443f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(d0.c.f4444g);
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
            kotlin.jvm.internal.h.e(fragmentA, "fm.fragmentFactory.insta\u2026ontext.classLoader, name)");
            fragmentA.G = id;
            fragmentA.H = id;
            fragmentA.I = string;
            fragmentA.C = fm;
            fragmentA.D = fm.B0();
            fragmentA.K1(context, attrs, null);
            fm.q().x(true).d(this, fragmentA, string).l();
        }
        fm.a1(this);
    }

    public final void a(View view) {
        if (this.f954j.contains(view)) {
            this.f953e.add(view);
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
        x.k0 k0VarK;
        kotlin.jvm.internal.h.f(insets, "insets");
        x.k0 k0VarQ = x.k0.q(insets);
        kotlin.jvm.internal.h.e(k0VarQ, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f955k;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f957a;
            kotlin.jvm.internal.h.c(onApplyWindowInsetsListener);
            k0VarK = x.k0.q(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            k0VarK = x.r.K(this, k0VarQ);
        }
        kotlin.jvm.internal.h.e(k0VarK, "if (applyWindowInsetsLis\u2026, insetsCompat)\n        }");
        if (!k0VarK.j()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                x.r.f(getChildAt(i10), k0VarK);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.h.f(canvas, "canvas");
        if (this.f956l) {
            Iterator it = this.f953e.iterator();
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
        if (this.f956l && !this.f953e.isEmpty() && this.f953e.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        this.f954j.remove(view);
        if (this.f953e.remove(view)) {
            this.f956l = true;
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
        this.f956l = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.h.f(listener, "listener");
        this.f955k = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        if (view.getParent() == this) {
            this.f954j.add(view);
        }
        super.startViewTransition(view);
    }
}
