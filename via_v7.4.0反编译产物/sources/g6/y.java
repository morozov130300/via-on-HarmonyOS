package g6;

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
import android.os.SystemClock;
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
import h6.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import mark.via.common.widget.n1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6242a = l();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ EditText f6243e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f6244j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Drawable f6245k;

        public a(EditText editText, boolean z10, Drawable drawable) {
            this.f6243e = editText;
            this.f6244j = z10;
            this.f6245k = drawable;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Drawable[] compoundDrawables = this.f6243e.getCompoundDrawables();
            boolean z10 = editable.length() <= 0;
            boolean z11 = this.f6244j;
            if (z11) {
                if ((compoundDrawables[0] == null) == z10) {
                    return;
                }
            } else {
                if ((compoundDrawables[2] == null) == z10) {
                    return;
                }
            }
            y.Q(this.f6243e, z10 ? null : this.f6245k, z11);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6246a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f6247b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f6248c;

        public b(EditText editText, boolean z10) {
            this.f6247b = editText;
            this.f6248c = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            boolean z10 = true;
            if (action == 0) {
                boolean z11 = this.f6247b.getText().length() > 0;
                this.f6246a = z11;
                if (z11) {
                    if (this.f6248c) {
                        z10 = false;
                        this.f6246a = z10;
                    } else {
                        z10 = false;
                        this.f6246a = z10;
                    }
                }
            } else if (action == 1 && this.f6246a) {
                this.f6247b.setText("");
            }
            return this.f6246a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6249a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f6250b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditText f6251c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Drawable f6252d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Drawable f6253e;

        public c(boolean z10, EditText editText, Drawable drawable, Drawable drawable2) {
            this.f6250b = z10;
            this.f6251c = editText;
            this.f6252d = drawable;
            this.f6253e = drawable2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        
            r1 = true;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f6250b) {
                    this.f6249a = z;
                } else {
                    this.f6249a = z;
                }
            } else if (action == 1 && this.f6249a) {
                int selectionStart = this.f6251c.getSelectionStart();
                int inputType = this.f6251c.getInputType();
                z = (inputType & 144) == 144;
                if (z) {
                    this.f6251c.setInputType((inputType & (-145)) | 128);
                } else {
                    this.f6251c.setInputType((inputType & (-129)) | 144);
                }
                y.Q(this.f6251c, z ? this.f6252d : this.f6253e, this.f6250b);
                this.f6251c.setSelection(selectionStart);
            }
            return this.f6249a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f6254e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f6255j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ View f6256k;

        public d(View view, int i10, View view2) {
            this.f6254e = view;
            this.f6255j = i10;
            this.f6256k = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f6254e.getHitRect(rect);
            int i10 = rect.left;
            int i11 = this.f6255j;
            rect.left = i10 - i11;
            rect.top -= i11;
            rect.right += i11;
            rect.bottom += i11;
            this.f6256k.setTouchDelegate(new TouchDelegate(rect, this.f6254e));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements RecyclerView.q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f6257a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6258b;

        public e(WeakReference weakReference, int i10) {
            this.f6257a = weakReference;
            this.f6258b = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            RecyclerView recyclerView = (RecyclerView) this.f6257a.get();
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.k0(view).l() == this.f6258b || recyclerView.getChildCount() == 1) {
                recyclerView.e1(this);
                y.K(view);
            }
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

    public static void J(ViewPager2 viewPager2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("r");
            declaredField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) declaredField.get(viewPager2);
            Field declaredField2 = RecyclerView.class.getDeclaredField("f0");
            declaredField2.setAccessible(true);
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) declaredField2.get(recyclerView)).intValue() * 4));
        } catch (Exception unused) {
        }
    }

    public static void K(View view) {
        if (view != null && view.isAttachedToWindow() && view.isShown()) {
            view.requestFocus();
            view.performAccessibilityAction(64, null);
        }
    }

    public static void L(RecyclerView recyclerView) {
        M(recyclerView, 0);
    }

    public static void M(RecyclerView recyclerView, final int i10) {
        if (recyclerView == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: g6.u
            @Override // java.lang.Runnable
            public final void run() {
                y.d(weakReference, i10);
            }
        });
    }

    public static void N(View view) {
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

    public static void O(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        x.r.Z(view, drawable);
    }

    public static void P(EditText editText, Drawable drawable) {
        if (editText == null || drawable == null) {
            return;
        }
        Context context = editText.getContext();
        drawable.setBounds(0, 0, h(context, 18.0f), h(context, 18.0f));
        boolean zD = l.d(context);
        editText.addTextChangedListener(new a(editText, zD, drawable));
        editText.setOnTouchListener(new b(editText, zD));
    }

    public static void Q(EditText editText, Drawable drawable, boolean z10) {
        Drawable[] compoundDrawables = editText.getCompoundDrawables();
        if (z10) {
            editText.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        } else {
            editText.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
        }
    }

    public static void R(EditText editText) {
        if (editText == null) {
            return;
        }
        Context context = editText.getContext();
        Drawable drawableA = lb.b.a(context, x7.o.P, x7.u.be);
        Drawable drawableA2 = lb.b.a(context, x7.o.O, x7.u.ae);
        int iH = h(context, 22.0f);
        drawableA.setBounds(0, 0, iH, iH);
        drawableA2.setBounds(0, 0, iH, iH);
        int iA = g6.e.a(context, x7.k.f13662h);
        h.a(drawableA, iA);
        h.a(drawableA2, iA);
        boolean zD = l.d(context);
        Q(editText, (editText.getInputType() & 144) == 144 ? drawableA : drawableA2, zD);
        editText.setOnTouchListener(new c(zD, editText, drawableA2, drawableA));
    }

    public static void S(int i10, ImageView... imageViewArr) {
        for (ImageView imageView : imageViewArr) {
            if (imageView != null) {
                imageView.setColorFilter(i10);
            }
        }
    }

    public static void T(View view, int i10, int i11) {
        if (view == null) {
            return;
        }
        view.setPadding(i10, i11, i10, i11);
    }

    public static void U(View view, int i10, int i11, int i12, int i13) {
        if (view == null) {
            return;
        }
        x.r.e0(view, i10, i11, i12, i13);
    }

    public static void V(View view, Drawable drawable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
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

    public static void W(RecyclerView recyclerView, final int i10) {
        if (recyclerView == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: g6.v
            @Override // java.lang.Runnable
            public final void run() {
                y.a(weakReference, i10);
            }
        });
    }

    public static void X(View view) {
        if (view != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, h(view.getContext(), 24.0f), 0.0f);
            objectAnimatorOfFloat.setRepeatCount(2);
            objectAnimatorOfFloat.setRepeatMode(1);
            objectAnimatorOfFloat.setDuration(280L);
            objectAnimatorOfFloat.setInterpolator(x8.h.b());
            objectAnimatorOfFloat.start();
        }
    }

    public static boolean Y(View view, final int i10, final int i11) {
        if (view == null) {
            return false;
        }
        final long jUptimeMillis = SystemClock.uptimeMillis();
        view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, i10, i11, 0));
        final WeakReference weakReference = new WeakReference(view);
        view.postDelayed(new Runnable() { // from class: g6.x
            @Override // java.lang.Runnable
            public final void run() {
                y.b(weakReference, jUptimeMillis, i10, i11);
            }
        }, 700L);
        return true;
    }

    public static int Z(Context context, float f10) {
        if (f10 == 0.0f) {
            return 0;
        }
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static /* synthetic */ void a(final WeakReference weakReference, final int i10) {
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
        recyclerView.post(new Runnable() { // from class: g6.w
            @Override // java.lang.Runnable
            public final void run() {
                y.c(weakReference, i10);
            }
        });
    }

    public static View a0(Fragment fragment, View view, boolean z10, boolean z11) {
        final Context contextI = fragment.I();
        if (z8.l.f()) {
            FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(contextI), new FrameLayout.LayoutParams(-1, -1)).l();
            frameLayout.addView((n1) new h6.a(new n1(contextI), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: g6.t
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    y.e(contextI, (n1) obj);
                }
            }).l(), 0);
            frameLayout.addView(view);
            view = frameLayout;
        } else {
            view.setBackgroundResource(x(contextI));
        }
        if (!z10) {
            return view;
        }
        com.tuyafeng.support.widget.y yVar = new com.tuyafeng.support.widget.y(contextI);
        yVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        yVar.setId(f6242a);
        yVar.o(fragment, view);
        yVar.setEdgeSize(-2);
        yVar.setScrollThresholdSize(h(contextI, 200.0f));
        return yVar;
    }

    public static /* synthetic */ void b(WeakReference weakReference, long j10, int i10, int i11) {
        View view = (View) weakReference.get();
        if (view == null) {
            return;
        }
        view.dispatchTouchEvent(MotionEvent.obtain(j10, SystemClock.uptimeMillis(), 2, i10, i11, 0));
    }

    public static /* synthetic */ void c(WeakReference weakReference, int i10) {
        RecyclerView.c0 c0VarC0;
        RecyclerView recyclerView = (RecyclerView) weakReference.get();
        if (recyclerView == null || (c0VarC0 = recyclerView.c0(i10)) == null) {
            return;
        }
        X(c0VarC0.f1219a);
    }

    public static /* synthetic */ void d(WeakReference weakReference, int i10) {
        RecyclerView recyclerView = (RecyclerView) weakReference.get();
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        RecyclerView.c0 c0VarC0 = recyclerView.c0(i10);
        View view = c0VarC0 != null ? c0VarC0.f1219a : null;
        if (view != null) {
            K(view);
        } else {
            recyclerView.m(new e(weakReference, i10));
        }
    }

    public static /* synthetic */ void e(Context context, n1 n1Var) {
        Drawable drawableB = x7.f.a().b();
        if (drawableB instanceof c8.b) {
            c8.b bVarA = ((c8.b) drawableB).a(x8.h.a(context));
            bVarA.f((pa.r.j().d() || (pa.r.j().M2().c() ? pa.r.j().M2().d() : C(pa.r.j().c0()))) ? 0 : -1711276033);
            n1Var.setImageDrawable(bVarA);
            n1Var.b();
            z8.l.e(n1Var, true);
        }
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
                x.r.c(view).a(1.0f).e(x8.h.b()).d(250L).f();
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
        return x.r.j();
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
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealSize(new Point());
        return Math.sqrt(Math.pow(r1.x / displayMetrics.xdpi, 2.0d) + Math.pow(r1.y / displayMetrics.ydpi, 2.0d));
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

    public static com.tuyafeng.support.widget.y v(Context context) {
        View viewC1;
        Fragment fragmentB = i.b(context);
        if (fragmentB == null || (viewC1 = fragmentB.c1()) == null) {
            return null;
        }
        View viewFindViewById = viewC1.findViewById(f6242a);
        if (viewFindViewById instanceof com.tuyafeng.support.widget.y) {
            return (com.tuyafeng.support.widget.y) viewFindViewById;
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
}
