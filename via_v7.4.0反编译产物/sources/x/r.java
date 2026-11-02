package x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import x.a;
import x.k0;
import x.x;
import y.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: b, reason: collision with root package name */
    public static WeakHashMap f13510b;

    /* renamed from: d, reason: collision with root package name */
    public static Field f13512d;

    /* renamed from: f, reason: collision with root package name */
    public static ThreadLocal f13514f;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f13509a = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public static WeakHashMap f13511c = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f13513e = false;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f13515g = {m.b.f8501b, m.b.f8502c, m.b.f8513n, m.b.f8524y, m.b.B, m.b.C, m.b.D, m.b.E, m.b.F, m.b.G, m.b.f8503d, m.b.f8504e, m.b.f8505f, m.b.f8506g, m.b.f8507h, m.b.f8508i, m.b.f8509j, m.b.f8510k, m.b.f8511l, m.b.f8512m, m.b.f8514o, m.b.f8515p, m.b.f8516q, m.b.f8517r, m.b.f8518s, m.b.f8519t, m.b.f8520u, m.b.f8521v, m.b.f8522w, m.b.f8523x, m.b.f8525z, m.b.A};

    /* renamed from: h, reason: collision with root package name */
    public static final x.n f13516h = new x.n() { // from class: x.q
    };

    /* renamed from: i, reason: collision with root package name */
    public static final e f13517i = new e();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends f {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // x.r.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(n.d(view));
        }

        @Override // x.r.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            n.i(view, bool.booleanValue());
        }

        @Override // x.r.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends f {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // x.r.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return n.b(view);
        }

        @Override // x.r.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            n.h(view, charSequence);
        }

        @Override // x.r.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends f {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // x.r.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return p.a(view);
        }

        @Override // x.r.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            p.b(view, charSequence);
        }

        @Override // x.r.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends f {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // x.r.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(n.c(view));
        }

        @Override // x.r.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            n.g(view, bool.booleanValue());
        }

        @Override // x.r.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        public final WeakHashMap f13518e = new WeakHashMap();

        public void a(View view) {
            this.f13518e.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (i.b(view)) {
                c(view);
            }
        }

        public final void b(View view, boolean z10) {
            boolean z11 = view.isShown() && view.getWindowVisibility() == 0;
            if (z10 != z11) {
                r.H(view, z11 ? 16 : 32);
                this.f13518e.put(view, Boolean.valueOf(z11));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f13518e.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            g.o(view.getViewTreeObserver(), this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.f13518e.entrySet()) {
                    b((View) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f13519a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f13520b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13521c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13522d;

        public f(int i10, Class cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public f(int i10, Class cls, int i11, int i12) {
            this.f13519a = i10;
            this.f13520b = cls;
            this.f13522d = i11;
            this.f13521c = i12;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return true;
        }

        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.f13521c;
        }

        public abstract Object d(View view);

        public abstract void e(View view, Object obj);

        public Object f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            Object tag = view.getTag(this.f13519a);
            if (this.f13520b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void g(View view, Object obj) {
            if (c()) {
                e(view, obj);
            } else if (b() && h(f(view), obj)) {
                r.i(view);
                view.setTag(this.f13519a, obj);
                r.H(view, this.f13522d);
            }
        }

        public abstract boolean h(Object obj, Object obj2);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g {
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        public static int d(View view) {
            return view.getMinimumHeight();
        }

        public static int e(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean i(View view) {
            return view.hasTransientState();
        }

        public static boolean j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        public static void s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View view) {
            return view.getDisplay();
        }

        public static int c(View view) {
            return view.getLabelFor();
        }

        public static int d(View view) {
            return view.getLayoutDirection();
        }

        public static int e(View view) {
            return view.getPaddingEnd();
        }

        public static int f(View view) {
            return view.getPaddingStart();
        }

        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        public static void h(View view, int i10) {
            view.setLabelFor(i10);
        }

        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        public static void k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i {
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean c(View view) {
            return view.isLaidOut();
        }

        public static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        public static void f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        public static void g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class j {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class k {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public k0 f13523a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f13524b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ x.m f13525c;

            public a(View view, x.m mVar) {
                this.f13524b = view;
                this.f13525c = mVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                k0 k0VarR = k0.r(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    k.a(windowInsets, this.f13524b);
                    if (k0VarR.equals(this.f13523a)) {
                        return this.f13525c.a(view, k0VarR).p();
                    }
                }
                this.f13523a = k0VarR;
                k0 k0VarA = this.f13525c.a(view, k0VarR);
                if (i10 >= 30) {
                    return k0VarA.p();
                }
                r.U(view);
                return k0VarA.p();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(m.b.R);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static k0 b(View view, k0 k0Var, Rect rect) {
            WindowInsets windowInsetsP = k0Var.p();
            if (windowInsetsP != null) {
                return k0.r(view.computeSystemWindowInsets(windowInsetsP, rect), view);
            }
            rect.setEmpty();
            return k0Var;
        }

        public static boolean c(View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        public static boolean d(View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        public static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        public static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static k0 j(View view) {
            return k0.a.a(view);
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f10) {
            view.setElevation(f10);
        }

        public static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        public static void u(View view, x.m mVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(m.b.L, mVar);
            }
            if (mVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(m.b.R));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, mVar));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        public static void x(View view, float f10) {
            view.setZ(f10);
        }

        public static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class l {
        public static k0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            k0 k0VarQ = k0.q(rootWindowInsets);
            k0VarQ.n(k0VarQ);
            k0VarQ.d(view.getRootView());
            return k0VarQ;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i10) {
            view.setScrollIndicators(i10);
        }

        public static void d(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class m {
        public static void a(View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        public static int b(View view) {
            return view.getImportantForAutofill();
        }

        public static int c(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View h(View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        public static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        public static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void k(View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        public static void l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        public static void m(View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        public static void n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        public static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class n {
        public static void a(View view, final q qVar) {
            k.g gVar = (k.g) view.getTag(m.b.Q);
            if (gVar == null) {
                gVar = new k.g();
                view.setTag(m.b.Q, gVar);
            }
            Objects.requireNonNull(qVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(qVar) { // from class: x.s
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            gVar.put(qVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, q qVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            k.g gVar = (k.g) view.getTag(m.b.Q);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(qVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        public static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class o {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        public static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class p {
        public static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface q {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: x.r$r, reason: collision with other inner class name */
    public static class C0152r {

        /* renamed from: d, reason: collision with root package name */
        public static final ArrayList f13526d = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap f13527a = null;

        /* renamed from: b, reason: collision with root package name */
        public SparseArray f13528b = null;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference f13529c = null;

        public static C0152r a(View view) {
            C0152r c0152r = (C0152r) view.getTag(m.b.P);
            if (c0152r != null) {
                return c0152r;
            }
            C0152r c0152r2 = new C0152r();
            view.setTag(m.b.P, c0152r2);
            return c0152r2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f13527a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray d() {
            if (this.f13528b == null) {
                this.f13528b = new SparseArray();
            }
            return this.f13528b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(m.b.Q);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            n.g.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f13529c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f13529c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && r.F(view)) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap weakHashMap = this.f13527a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f13526d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f13527a == null) {
                        this.f13527a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f13526d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f13527a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f13527a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String A(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return k.k(view);
        }
        WeakHashMap weakHashMap = f13510b;
        if (weakHashMap == null) {
            return null;
        }
        return (String) weakHashMap.get(view);
    }

    public static float B(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return k.l(view);
        }
        return 0.0f;
    }

    public static float C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return k.m(view);
        }
        return 0.0f;
    }

    public static boolean D(View view) {
        return g.i(view);
    }

    public static boolean E(View view) {
        Boolean bool = (Boolean) a().f(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean F(View view) {
        return i.b(view);
    }

    public static boolean G(View view) {
        Boolean bool = (Boolean) W().f(view);
        return bool != null && bool.booleanValue();
    }

    public static void H(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = o(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (n(view) != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                i.g(accessibilityEventObtain, i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(o(view));
                    i0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                i.g(accessibilityEventObtain2, i10);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(o(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    i.e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static void I(View view, int i10) {
        boolean z10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetLeftAndRight(i10);
            return;
        }
        if (i11 < 21) {
            d(view, i10);
            return;
        }
        Rect rectS = s();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectS.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectS.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        d(view, i10);
        if (z10 && rectS.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectS);
        }
    }

    public static void J(View view, int i10) {
        boolean z10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetTopAndBottom(i10);
            return;
        }
        if (i11 < 21) {
            e(view, i10);
            return;
        }
        Rect rectS = s();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectS.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectS.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        e(view, i10);
        if (z10 && rectS.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectS);
        }
    }

    public static k0 K(View view, k0 k0Var) {
        WindowInsets windowInsetsP;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsP = k0Var.p()) != null) {
            WindowInsets windowInsetsB = j.b(view, windowInsetsP);
            if (!windowInsetsB.equals(windowInsetsP)) {
                return k0.r(windowInsetsB, view);
            }
        }
        return k0Var;
    }

    public static void L(View view, y.d0 d0Var) {
        view.onInitializeAccessibilityNodeInfo(d0Var.m0());
    }

    public static f M() {
        return new b(m.b.K, CharSequence.class, 8, 28);
    }

    public static boolean N(View view, int i10, Bundle bundle) {
        return g.j(view, i10, bundle);
    }

    public static void O(View view) {
        g.k(view);
    }

    public static void P(View view, Runnable runnable) {
        g.m(view, runnable);
    }

    public static void Q(View view, Runnable runnable, long j10) {
        g.n(view, runnable, j10);
    }

    public static void R(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            S(i10, view);
            H(view, 0);
        }
    }

    public static void S(int i10, View view) {
        List listP = p(view);
        for (int i11 = 0; i11 < listP.size(); i11++) {
            if (((d0.a) listP.get(i11)).b() == i10) {
                listP.remove(i11);
                return;
            }
        }
    }

    public static void T(View view, d0.a aVar, CharSequence charSequence, y.i0 i0Var) {
        if (i0Var == null && charSequence == null) {
            R(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, i0Var));
        }
    }

    public static void U(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            j.c(view);
        } else {
            g.p(view);
        }
    }

    public static void V(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            o.c(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static f W() {
        return new a(m.b.M, Boolean.class, 28);
    }

    public static void X(View view, x.a aVar) {
        if (aVar == null && (l(view) instanceof a.C0151a)) {
            aVar = new x.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void Y(View view, CharSequence charSequence) {
        M().g(view, charSequence);
        if (charSequence != null) {
            f13517i.a(view);
        } else {
            f13517i.d(view);
        }
    }

    public static void Z(View view, Drawable drawable) {
        g.q(view, drawable);
    }

    public static f a() {
        return new d(m.b.J, Boolean.class, 28);
    }

    public static void a0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.s(view, f10);
        }
    }

    public static void b(View view, d0.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            i(view);
            S(aVar.b(), view);
            p(view).add(aVar);
            H(view, 0);
        }
    }

    public static void b0(View view, int i10) {
        g.s(view, i10);
    }

    public static w c(View view) {
        if (f13511c == null) {
            f13511c = new WeakHashMap();
        }
        w wVar = (w) f13511c.get(view);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(view);
        f13511c.put(view, wVar2);
        return wVar2;
    }

    public static void c0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            m.l(view, i10);
        }
    }

    public static void d(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            n0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    public static void d0(View view, x.m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.u(view, mVar);
        }
    }

    public static void e(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            n0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    public static void e0(View view, int i10, int i11, int i12, int i13) {
        h.k(view, i10, i11, i12, i13);
    }

    public static k0 f(View view, k0 k0Var) {
        WindowInsets windowInsetsP;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsP = k0Var.p()) != null) {
            WindowInsets windowInsetsA = j.a(view, windowInsetsP);
            if (!windowInsetsA.equals(windowInsetsP)) {
                return k0.r(windowInsetsA, view);
            }
        }
        return k0Var;
    }

    public static void f0(View view, CharSequence charSequence) {
        l0().g(view, charSequence);
    }

    public static boolean g(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0152r.a(view).b(view, keyEvent);
    }

    public static void g0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.v(view, str);
            return;
        }
        if (f13510b == null) {
            f13510b = new WeakHashMap();
        }
        f13510b.put(view, str);
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0152r.a(view).f(keyEvent);
    }

    public static void h0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.w(view, f10);
        }
    }

    public static void i(View view) {
        x.a aVarK = k(view);
        if (aVarK == null) {
            aVarK = new x.a();
        }
        X(view, aVarK);
    }

    public static void i0(View view) {
        if (t(view) == 0) {
            b0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (t((View) parent) == 4) {
                b0(view, 2);
                return;
            }
        }
    }

    public static int j() {
        return h.a();
    }

    public static void j0(View view, x.b bVar) {
        x.d(view, bVar);
    }

    public static x.a k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof a.C0151a ? ((a.C0151a) accessibilityDelegateL).f13455a : new x.a(accessibilityDelegateL);
    }

    public static void k0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.x(view, f10);
        }
    }

    public static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? o.a(view) : m(view);
    }

    public static f l0() {
        return new c(m.b.N, CharSequence.class, 64, 30);
    }

    public static View.AccessibilityDelegate m(View view) {
        if (f13513e) {
            return null;
        }
        if (f13512d == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f13512d = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f13513e = true;
                return null;
            }
        }
        try {
            Object obj = f13512d.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f13513e = true;
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            k.z(view);
        } else if (view instanceof x.k) {
            ((x.k) view).stopNestedScroll();
        }
    }

    public static int n(View view) {
        return i.a(view);
    }

    public static void n0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static CharSequence o(View view) {
        return (CharSequence) M().f(view);
    }

    public static List p(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(m.b.H);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(m.b.H, arrayList2);
        return arrayList2;
    }

    public static Display q(View view) {
        return h.b(view);
    }

    public static float r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return k.i(view);
        }
        return 0.0f;
    }

    public static Rect s() {
        if (f13514f == null) {
            f13514f = new ThreadLocal();
        }
        Rect rect = (Rect) f13514f.get();
        if (rect == null) {
            rect = new Rect();
            f13514f.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static int t(View view) {
        return g.c(view);
    }

    public static int u(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return m.b(view);
        }
        return 0;
    }

    public static int v(View view) {
        return h.d(view);
    }

    public static int w(View view) {
        return g.d(view);
    }

    public static int x(View view) {
        return g.e(view);
    }

    public static k0 y(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return l.a(view);
        }
        if (i10 >= 21) {
            return k.j(view);
        }
        return null;
    }

    public static CharSequence z(View view) {
        return (CharSequence) l0().f(view);
    }
}
