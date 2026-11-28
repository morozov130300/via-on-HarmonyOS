package com.tuyafeng.support.utils;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tuyafeng.support.widget.d0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mark.via.common.widget.q1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3593a = l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3597a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f3598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f3599c;

        public b(EditText editText, boolean z10) {
            this.f3598b = editText;
            this.f3599c = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            boolean z10 = true;
            if (action == 0) {
                boolean z11 = this.f3598b.getText().length() > 0;
                this.f3597a = z11;
                if (z11) {
                    z10 = this.f3599c ? false : false;
                    this.f3597a = z10;
                }
            } else if (action == 1 && this.f3597a) {
                this.f3598b.setText("");
            }
            return this.f3597a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3600a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditText f3602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Drawable f3603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Drawable f3604e;

        public c(boolean z10, EditText editText, Drawable drawable, Drawable drawable2) {
            this.f3601b = z10;
            this.f3602c = editText;
            this.f3603d = drawable;
            this.f3604e = drawable2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        
            r1 = true;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
            /*
                r4 = this;
                int r0 = r6.getAction()
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L35
                boolean r0 = r4.f3601b
                if (r0 == 0) goto L1d
                float r6 = r6.getX()
                android.widget.EditText r5 = (android.widget.EditText) r5
                int r5 = r5.getCompoundPaddingLeft()
                float r5 = (float) r5
                int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
                if (r5 > 0) goto L32
            L1b:
                r1 = 1
                goto L32
            L1d:
                float r6 = r6.getX()
                int r0 = r5.getMeasuredWidth()
                android.widget.EditText r5 = (android.widget.EditText) r5
                int r5 = r5.getCompoundPaddingRight()
                int r0 = r0 - r5
                float r5 = (float) r0
                int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
                if (r5 < 0) goto L32
                goto L1b
            L32:
                r4.f3600a = r1
                goto L75
            L35:
                if (r0 != r2) goto L75
                boolean r5 = r4.f3600a
                if (r5 == 0) goto L75
                android.widget.EditText r5 = r4.f3602c
                int r5 = r5.getSelectionStart()
                android.widget.EditText r6 = r4.f3602c
                int r6 = r6.getInputType()
                r0 = r6 & 144(0x90, float:2.02E-43)
                r3 = 144(0x90, float:2.02E-43)
                if (r0 != r3) goto L4e
                r1 = 1
            L4e:
                if (r1 == 0) goto L5a
                android.widget.EditText r0 = r4.f3602c
                r6 = r6 & (-145(0xffffffffffffff6f, float:NaN))
                r6 = r6 | 128(0x80, float:1.8E-43)
                r0.setInputType(r6)
                goto L62
            L5a:
                android.widget.EditText r0 = r4.f3602c
                r6 = r6 & (-129(0xffffffffffffff7f, float:NaN))
                r6 = r6 | r3
                r0.setInputType(r6)
            L62:
                if (r1 == 0) goto L67
                android.graphics.drawable.Drawable r6 = r4.f3603d
                goto L69
            L67:
                android.graphics.drawable.Drawable r6 = r4.f3604e
            L69:
                android.widget.EditText r0 = r4.f3602c
                boolean r1 = r4.f3601b
                com.tuyafeng.support.utils.x.e(r0, r6, r1)
                android.widget.EditText r6 = r4.f3602c
                r6.setSelection(r5)
            L75:
                boolean r5 = r4.f3600a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuyafeng.support.utils.x.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3605c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f3606e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f3607m;

        public d(View view, int i10, View view2) {
            this.f3605c = view;
            this.f3606e = i10;
            this.f3607m = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f3605c.getHitRect(rect);
            int i10 = rect.left;
            int i11 = this.f3606e;
            rect.left = i10 - i11;
            rect.top -= i11;
            rect.right += i11;
            rect.bottom += i11;
            this.f3607m.setTouchDelegate(new TouchDelegate(rect, this.f3605c));
        }
    }

    public static boolean A(ViewGroup viewGroup, int i10) {
        int i11;
        if (viewGroup == null) {
            return false;
        }
        View viewFindFocus = viewGroup.findFocus();
        if (viewFindFocus == null) {
            viewGroup.requestFocus();
            return true;
        }
        if (i10 == 21 || i10 == 22) {
            if (viewFindFocus instanceof EditText) {
                return false;
            }
            i11 = i10 == 21 ? 17 : 66;
        } else {
            if (i10 != 19 && i10 != 20) {
                return false;
            }
            i11 = i10 == 19 ? 33 : 130;
        }
        View viewFocusSearch = viewFindFocus.focusSearch(i11);
        if (viewFocusSearch == null) {
            return false;
        }
        viewFocusSearch.requestFocus();
        return true;
    }

    public static void B(View view, boolean z10) {
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, h(view.getContext(), 10.0f) * (z10 ? 1 : -1), 0.0f);
            objectAnimatorOfFloat.setDuration(280L);
            objectAnimatorOfFloat.start();
        }
    }

    public static boolean C(int i10) {
        double dRed = Color.red(i10);
        Double.isNaN(dRed);
        double dGreen = Color.green(i10);
        Double.isNaN(dGreen);
        double d10 = (dRed * 0.299d) + (dGreen * 0.587d);
        double dBlue = Color.blue(i10);
        Double.isNaN(dBlue);
        return d10 + (dBlue * 0.114d) >= 192.0d;
    }

    public static boolean D(RecyclerView recyclerView) {
        RecyclerView.l itemAnimator;
        return (recyclerView == null || (itemAnimator = recyclerView.getItemAnimator()) == null || !itemAnimator.p()) ? false : true;
    }

    public static boolean E(Context context) {
        int i10 = context.getResources().getConfiguration().screenLayout & 15;
        return (i10 == 3 || i10 == 4) && r(context) >= 7.0d;
    }

    public static void F(ImageView imageView, int i10) {
        Drawable drawable;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
        imageView.setImageDrawable(drawableMutate);
    }

    public static int G(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return (((int) (((i10 & 255) * f10) + ((i11 & 255) * f11))) & 255) | (-16777216) | ((((int) ((((i10 >> 16) & 255) * f10) + (((i11 >> 16) & 255) * f11))) & 255) << 16) | ((((int) ((((i10 >> 8) & 255) * f10) + (((i11 >> 8) & 255) * f11))) & 255) << 8);
    }

    public static int H(int i10) {
        int i11 = (i10 >> 24) & 255;
        return (i10 & 16777215) | (((i11 < 255 ? i11 + 1 : i11 - 1) & 255) << 24);
    }

    public static int I(Context context, float f10) {
        if (f10 == 0.0f) {
            return 0;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void J(ViewPager2 viewPager2) {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("t");
            declaredField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) declaredField.get(viewPager2);
            Field declaredField2 = RecyclerView.class.getDeclaredField("h0");
            declaredField2.setAccessible(true);
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) declaredField2.get(recyclerView)).intValue() * 4));
        } catch (Exception unused) {
        }
    }

    public static void K(View view) {
        if (view.getParent() instanceof FrameLayout) {
            View childAt = ((FrameLayout) view.getParent()).getChildAt(0);
            if (childAt instanceof q1) {
                f((q1) childAt);
                return;
            }
        }
        view.setBackgroundResource(x(view.getContext()));
    }

    public static void L(View view) {
        if (view != null && view.isAttachedToWindow() && view.isShown()) {
            view.requestFocus();
            view.performAccessibilityAction(64, null);
        }
    }

    public static void M(RecyclerView recyclerView) {
        N(recyclerView, 0);
    }

    public static void N(RecyclerView recyclerView, final int i10) {
        if (recyclerView == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: com.tuyafeng.support.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                x.d(weakReference, i10);
            }
        });
    }

    public static void O(View view) {
        if (view == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) k(view, RecyclerView.class);
        if (recyclerView != null) {
            recyclerView.x1(0);
            return;
        }
        ScrollView scrollView = (ScrollView) k(view, ScrollView.class);
        if (scrollView != null) {
            scrollView.smoothScrollTo(0, 0);
        }
    }

    public static void P(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        y.r.a0(view, drawable);
    }

    public static void Q(EditText editText, Drawable drawable) {
        if (editText == null || drawable == null) {
            return;
        }
        Context context = editText.getContext();
        drawable.setBounds(0, 0, h(context, 18.0f), h(context, 18.0f));
        boolean zD = l.d(context);
        editText.addTextChangedListener(new a(editText, zD, drawable));
        editText.setOnTouchListener(new b(editText, zD));
    }

    public static void R(EditText editText, Drawable drawable, boolean z10) {
        Drawable[] compoundDrawables = editText.getCompoundDrawables();
        if (z10) {
            editText.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        } else {
            editText.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        }
    }

    public static void S(EditText editText) {
        if (editText == null) {
            return;
        }
        Context context = editText.getContext();
        Drawable drawableA = lb.g.a(context, w7.o.O, w7.u.qe);
        Drawable drawableA2 = lb.g.a(context, w7.o.N, w7.u.pe);
        int iH = h(context, 22.0f);
        drawableA.setBounds(0, 0, iH, iH);
        drawableA2.setBounds(0, 0, iH, iH);
        int iA = com.tuyafeng.support.utils.e.a(context, w7.k.f13729i);
        h.a(drawableA, iA);
        h.a(drawableA2, iA);
        boolean zD = l.d(context);
        R(editText, (editText.getInputType() & 144) == 144 ? drawableA : drawableA2, zD);
        editText.setOnTouchListener(new c(zD, editText, drawableA2, drawableA));
    }

    public static void T(int i10, ImageView... imageViewArr) {
        for (ImageView imageView : imageViewArr) {
            if (imageView != null) {
                imageView.setColorFilter(i10);
            }
        }
    }

    public static void U(View view, int i10, int i11) {
        if (view == null) {
            return;
        }
        view.setPadding(i10, i11, i10, i11);
    }

    public static void V(View view, int i10, int i11, int i12, int i13) {
        if (view == null) {
            return;
        }
        y.r.f0(view, i10, i11, i12, i13);
    }

    public static void W(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setHorizontalScrollbarThumbDrawable(drawable);
            view.setVerticalScrollbarThumbDrawable(drawable);
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, drawable);
            Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(obj2, drawable);
        } catch (Exception unused) {
        }
    }

    public static void X(RecyclerView recyclerView, final int i10) {
        if (recyclerView == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: com.tuyafeng.support.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                x.b(weakReference, i10);
            }
        });
    }

    public static void Y(View view) {
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, h(view.getContext(), 24.0f), 0.0f);
            objectAnimatorOfFloat.setRepeatCount(2);
            objectAnimatorOfFloat.setRepeatMode(1);
            objectAnimatorOfFloat.setDuration(280L);
            objectAnimatorOfFloat.setInterpolator(v8.h.b());
            objectAnimatorOfFloat.start();
        }
    }

    public static int Z(Context context, float f10) {
        if (f10 == 0.0f) {
            return 0;
        }
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static View a0(Fragment fragment, View view, boolean z10, boolean z11) {
        Context contextG = fragment.G();
        if (x8.l.f()) {
            FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(contextG), new FrameLayout.LayoutParams(-1, -1)).l();
            frameLayout.addView((q1) new b6.a(new q1(contextG), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: com.tuyafeng.support.utils.t
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    x.f((q1) obj);
                }
            }).l(), 0);
            frameLayout.addView(view);
            view = frameLayout;
        } else {
            view.setBackgroundResource(x(contextG));
        }
        if (!z10) {
            return view;
        }
        d0 d0Var = new d0(contextG);
        d0Var.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        d0Var.setId(f3593a);
        d0Var.o(fragment, view);
        d0Var.setEdgeSize(-2);
        d0Var.setScrollThresholdSize(h(contextG, 200.0f));
        return d0Var;
    }

    public static /* synthetic */ void b(final WeakReference weakReference, final int i10) {
        RecyclerView recyclerView = (RecyclerView) weakReference.get();
        if (recyclerView == null) {
            return;
        }
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).B2(i10, 20);
        } else {
            recyclerView.p1(i10);
        }
        recyclerView.post(new Runnable() { // from class: com.tuyafeng.support.utils.w
            @Override // java.lang.Runnable
            public final void run() {
                x.c(weakReference, i10);
            }
        });
    }

    public static /* synthetic */ void c(WeakReference weakReference, int i10) {
        RecyclerView.d0 d0VarC0;
        RecyclerView recyclerView = (RecyclerView) weakReference.get();
        if (recyclerView == null || (d0VarC0 = recyclerView.c0(i10)) == null) {
            return;
        }
        Y(d0VarC0.f1138a);
    }

    public static /* synthetic */ void d(WeakReference weakReference, int i10) {
        RecyclerView recyclerView = (RecyclerView) weakReference.get();
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        RecyclerView.d0 d0VarC0 = recyclerView.c0(i10);
        View view = d0VarC0 != null ? d0VarC0.f1138a : null;
        if (view != null) {
            L(view);
        } else {
            recyclerView.m(new e(weakReference, i10));
        }
    }

    public static void f(q1 q1Var) {
        Context context = q1Var.getContext();
        Drawable drawableB = w7.f.a().b();
        if (!(drawableB instanceof mark.via.browser.e)) {
            q1Var.setImageDrawable(null);
            q1Var.setBackgroundResource(x(context));
            return;
        }
        mark.via.browser.e eVarA = ((mark.via.browser.e) drawableB).a(v8.h.a(context));
        eVarA.f((la.s.j().e() || (la.s.j().Q2().c() ? la.s.j().Q2().d() : C(la.s.j().f0()))) ? 0 : -1711276033);
        q1Var.setImageDrawable(eVarA);
        q1Var.b();
        x8.l.e(q1Var, true);
    }

    public static String g(int i10) {
        StringBuilder sb2 = new StringBuilder();
        String hexString = Integer.toHexString(Color.red(i10));
        String hexString2 = Integer.toHexString(Color.green(i10));
        String hexString3 = Integer.toHexString(Color.blue(i10));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        sb2.append("#");
        sb2.append(hexString);
        sb2.append(hexString2);
        sb2.append(hexString3);
        return sb2.toString();
    }

    public static int h(Context context, float f10) {
        if (f10 == 0.0f) {
            return 0;
        }
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void i(View view, int i10) {
        if (view == null || view.getParent() == null) {
            return;
        }
        View view2 = (View) view.getParent();
        view2.post(new d(view, i10, view2));
    }

    public static void j(View view, boolean z10) {
        if (view != null) {
            if (z10 || view.getVisibility() != 0) {
                view.setAlpha(0.0f);
                view.setVisibility(0);
                y.r.c(view).a(1.0f).e(v8.h.b()).d(250L).f();
            }
        }
    }

    public static Object k(View view, Class cls) {
        if (view == null) {
            return null;
        }
        if (cls.isInstance(view)) {
            return cls.cast(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                Object objK = k(viewGroup.getChildAt(i10), cls);
                if (objK != null) {
                    return objK;
                }
            }
        }
        return null;
    }

    public static int l() {
        return y.r.j();
    }

    public static Activity m(Context context) {
        if (context != null && (context instanceof ContextWrapper)) {
            return context instanceof Activity ? (Activity) context : m(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int n(View view, int i10) {
        if (view == null) {
            return 0;
        }
        return o(view, i10)[1];
    }

    public static int[] o(View view, int i10) {
        if (view == null) {
            return new int[]{0, 0};
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int p(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int q(Context context) {
        Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point.y;
    }

    public static double r(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Point point = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealSize(point);
        return Math.sqrt(Math.pow(point.x / displayMetrics.xdpi, 2.0d) + Math.pow(point.y / displayMetrics.ydpi, 2.0d));
    }

    public static int s(Context context) {
        Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point.x;
    }

    public static int t(Context context) {
        WindowManager windowManager;
        if (Build.VERSION.SDK_INT >= 30 && (windowManager = (WindowManager) context.getSystemService(WindowManager.class)) != null) {
            return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.systemBars()).bottom;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : h(context, 25.0f);
    }

    public static int u(Context context) {
        if ((((Activity) context).getWindow().getAttributes().flags & 1024) == 1024) {
            return 0;
        }
        return t(context);
    }

    public static d0 v(Context context) {
        View viewA1;
        Fragment fragmentC = FragmentUtils.c(context);
        if (fragmentC == null || (viewA1 = fragmentC.a1()) == null) {
            return null;
        }
        View viewFindViewById = viewA1.findViewById(f3593a);
        if (viewFindViewById instanceof d0) {
            return (d0) viewFindViewById;
        }
        return null;
    }

    public static Window w(Context context) {
        Activity activityM;
        if (context == null || (activityM = m(context)) == null) {
            return null;
        }
        return activityM.getWindow();
    }

    public static int x(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int y(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int z(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements RecyclerView.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f3608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3609b;

        public e(WeakReference weakReference, int i10) {
            this.f3608a = weakReference;
            this.f3609b = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            RecyclerView recyclerView = (RecyclerView) this.f3608a.get();
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.k0(view).l() == this.f3609b || recyclerView.getChildCount() == 1) {
                recyclerView.e1(this);
                x.L(view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditText f3594c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f3595e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Drawable f3596m;

        public a(EditText editText, boolean z10, Drawable drawable) {
            this.f3594c = editText;
            this.f3595e = z10;
            this.f3596m = drawable;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Drawable[] compoundDrawables = this.f3594c.getCompoundDrawables();
            boolean z10 = editable.length() <= 0;
            boolean z11 = this.f3595e;
            if (z11) {
                if ((compoundDrawables[0] == null) == z10) {
                    return;
                }
            } else {
                if ((compoundDrawables[2] == null) == z10) {
                    return;
                }
            }
            x.R(this.f3594c, z10 ? null : this.f3596m, z11);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
