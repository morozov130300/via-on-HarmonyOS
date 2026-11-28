package y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14779a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowInsets f14782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14783b;

        public b(int i10) {
            this.f14783b = i10;
        }

        public final int a() {
            return this.f14783b;
        }

        public abstract void b(x xVar);

        public abstract void c(x xVar);

        public abstract k0 d(k0 k0Var, List list);

        public abstract a e(x xVar, a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends e {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f14784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public k0 f14785b;

            /* JADX INFO: renamed from: y.x$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public class C0159a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ x f14786a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f14787b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ k0 f14788c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f14789d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ View f14790e;

                public C0159a(x xVar, k0 k0Var, k0 k0Var2, int i10, View view) {
                    this.f14786a = xVar;
                    this.f14787b = k0Var;
                    this.f14788c = k0Var2;
                    this.f14789d = i10;
                    this.f14790e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f14786a.e(valueAnimator.getAnimatedFraction());
                    c.j(this.f14790e, c.n(this.f14787b, this.f14788c, this.f14786a.b(), this.f14789d), Collections.singletonList(this.f14786a));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ x f14792a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ View f14793b;

                public b(x xVar, View view) {
                    this.f14792a = xVar;
                    this.f14793b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f14792a.e(1.0f);
                    c.h(this.f14793b, this.f14792a);
                }
            }

            /* JADX INFO: renamed from: y.x$c$a$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public class RunnableC0160c implements Runnable {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ View f14795c;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ x f14796e;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ a f14797m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public final /* synthetic */ ValueAnimator f14798n;

                public RunnableC0160c(View view, x xVar, a aVar, ValueAnimator valueAnimator) {
                    this.f14795c = view;
                    this.f14796e = xVar;
                    this.f14797m = aVar;
                    this.f14798n = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.k(this.f14795c, this.f14796e, this.f14797m);
                    this.f14798n.start();
                }
            }

            public a(View view, b bVar) {
                this.f14784a = bVar;
                k0 k0VarY = r.y(view);
                this.f14785b = k0VarY != null ? new k0.b(k0VarY).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f14785b = k0.r(windowInsets, view);
                    return c.l(view, windowInsets);
                }
                k0 k0VarR = k0.r(windowInsets, view);
                if (this.f14785b == null) {
                    this.f14785b = r.y(view);
                }
                if (this.f14785b == null) {
                    this.f14785b = k0VarR;
                    return c.l(view, windowInsets);
                }
                b bVarM = c.m(view);
                if (bVarM != null && Objects.equals(bVarM.f14782a, windowInsets)) {
                    return c.l(view, windowInsets);
                }
                int iE = c.e(k0VarR, this.f14785b);
                if (iE == 0) {
                    return c.l(view, windowInsets);
                }
                k0 k0Var = this.f14785b;
                x xVar = new x(iE, new DecelerateInterpolator(), 160L);
                xVar.e(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(xVar.a());
                a aVarF = c.f(k0VarR, k0Var, iE);
                c.i(view, xVar, windowInsets, false);
                duration.addUpdateListener(new C0159a(xVar, k0VarR, k0Var, iE, view));
                duration.addListener(new b(xVar, view));
                o.a(view, new RunnableC0160c(view, xVar, aVarF, duration));
                this.f14785b = k0VarR;
                return c.l(view, windowInsets);
            }
        }

        public c(int i10, Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        public static int e(k0 k0Var, k0 k0Var2) {
            int i10 = 0;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if (!k0Var.f(i11).equals(k0Var2.f(i11))) {
                    i10 |= i11;
                }
            }
            return i10;
        }

        public static a f(k0 k0Var, k0 k0Var2, int i10) {
            r.f fVarF = k0Var.f(i10);
            r.f fVarF2 = k0Var2.f(i10);
            return new a(r.f.b(Math.min(fVarF.f11875a, fVarF2.f11875a), Math.min(fVarF.f11876b, fVarF2.f11876b), Math.min(fVarF.f11877c, fVarF2.f11877c), Math.min(fVarF.f11878d, fVarF2.f11878d)), r.f.b(Math.max(fVarF.f11875a, fVarF2.f11875a), Math.max(fVarF.f11876b, fVarF2.f11876b), Math.max(fVarF.f11877c, fVarF2.f11877c), Math.max(fVarF.f11878d, fVarF2.f11878d)));
        }

        public static View.OnApplyWindowInsetsListener g(View view, b bVar) {
            return new a(view, bVar);
        }

        public static void h(View view, x xVar) {
            b bVarM = m(view);
            if (bVarM != null) {
                bVarM.b(xVar);
                if (bVarM.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    h(viewGroup.getChildAt(i10), xVar);
                }
            }
        }

        public static void i(View view, x xVar, WindowInsets windowInsets, boolean z10) {
            b bVarM = m(view);
            if (bVarM != null) {
                bVarM.f14782a = windowInsets;
                if (!z10) {
                    bVarM.c(xVar);
                    z10 = bVarM.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    i(viewGroup.getChildAt(i10), xVar, windowInsets, z10);
                }
            }
        }

        public static void j(View view, k0 k0Var, List list) {
            b bVarM = m(view);
            if (bVarM != null) {
                k0Var = bVarM.d(k0Var, list);
                if (bVarM.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    j(viewGroup.getChildAt(i10), k0Var, list);
                }
            }
        }

        public static void k(View view, x xVar, a aVar) {
            b bVarM = m(view);
            if (bVarM != null) {
                bVarM.e(xVar, aVar);
                if (bVarM.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    k(viewGroup.getChildAt(i10), xVar, aVar);
                }
            }
        }

        public static WindowInsets l(View view, WindowInsets windowInsets) {
            return view.getTag(m.b.L) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static b m(View view) {
            Object tag = view.getTag(m.b.R);
            if (tag instanceof a) {
                return ((a) tag).f14784a;
            }
            return null;
        }

        public static k0 n(k0 k0Var, k0 k0Var2, float f10, int i10) {
            k0.b bVar = new k0.b(k0Var);
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) == 0) {
                    bVar.b(i11, k0Var.f(i11));
                } else {
                    r.f fVarF = k0Var.f(i11);
                    r.f fVarF2 = k0Var2.f(i11);
                    float f11 = 1.0f - f10;
                    double d10 = (fVarF.f11875a - fVarF2.f11875a) * f11;
                    Double.isNaN(d10);
                    int i12 = (int) (d10 + 0.5d);
                    double d11 = (fVarF.f11876b - fVarF2.f11876b) * f11;
                    Double.isNaN(d11);
                    double d12 = (fVarF.f11877c - fVarF2.f11877c) * f11;
                    Double.isNaN(d12);
                    int i13 = (int) (d12 + 0.5d);
                    double d13 = (fVarF.f11878d - fVarF2.f11878d) * f11;
                    Double.isNaN(d13);
                    bVar.b(i11, k0.i(fVarF, i12, (int) (d11 + 0.5d), i13, (int) (d13 + 0.5d)));
                }
            }
            return bVar.a();
        }

        public static void o(View view, b bVar) {
            Object tag = view.getTag(m.b.L);
            if (bVar == null) {
                view.setTag(m.b.R, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerG = g(view, bVar);
            view.setTag(m.b.R, onApplyWindowInsetsListenerG);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f14806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f14807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f14808d;

        public e(int i10, Interpolator interpolator, long j10) {
            this.f14805a = i10;
            this.f14807c = interpolator;
            this.f14808d = j10;
        }

        public long a() {
            return this.f14808d;
        }

        public float b() {
            Interpolator interpolator = this.f14807c;
            return interpolator != null ? interpolator.getInterpolation(this.f14806b) : this.f14806b;
        }

        public int c() {
            return this.f14805a;
        }

        public void d(float f10) {
            this.f14806b = f10;
        }
    }

    public x(int i10, Interpolator interpolator, long j10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.f14779a = new d(i10, interpolator, j10);
        } else if (i11 >= 21) {
            this.f14779a = new c(i10, interpolator, j10);
        } else {
            this.f14779a = new e(0, interpolator, j10);
        }
    }

    public static void d(View view, b bVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            d.h(view, bVar);
        } else if (i10 >= 21) {
            c.o(view, bVar);
        }
    }

    public static x f(WindowInsetsAnimation windowInsetsAnimation) {
        return new x(windowInsetsAnimation);
    }

    public long a() {
        return this.f14779a.a();
    }

    public float b() {
        return this.f14779a.b();
    }

    public int c() {
        return this.f14779a.c();
    }

    public void e(float f10) {
        this.f14779a.d(f10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WindowInsetsAnimation f14800e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f14801a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List f14802b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ArrayList f14803c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final HashMap f14804d;

            public a(b bVar) {
                super(bVar.a());
                this.f14804d = new HashMap();
                this.f14801a = bVar;
            }

            public final x a(WindowInsetsAnimation windowInsetsAnimation) {
                x xVar = (x) this.f14804d.get(windowInsetsAnimation);
                if (xVar != null) {
                    return xVar;
                }
                x xVarF = x.f(windowInsetsAnimation);
                this.f14804d.put(windowInsetsAnimation, xVarF);
                return xVarF;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f14801a.b(a(windowInsetsAnimation));
                this.f14804d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f14801a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f14803c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f14803c = arrayList2;
                    this.f14802b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = h0.a(list.get(size));
                    x xVarA = a(windowInsetsAnimationA);
                    xVarA.e(windowInsetsAnimationA.getFraction());
                    this.f14803c.add(xVarA);
                }
                return this.f14801a.d(k0.q(windowInsets), this.f14802b).p();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f14801a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        public d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f14800e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().e(), aVar.b().e());
        }

        public static r.f f(WindowInsetsAnimation.Bounds bounds) {
            return r.f.d(bounds.getUpperBound());
        }

        public static r.f g(WindowInsetsAnimation.Bounds bounds) {
            return r.f.d(bounds.getLowerBound());
        }

        public static void h(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // y.x.e
        public long a() {
            return this.f14800e.getDurationMillis();
        }

        @Override // y.x.e
        public float b() {
            return this.f14800e.getInterpolatedFraction();
        }

        @Override // y.x.e
        public int c() {
            return this.f14800e.getTypeMask();
        }

        @Override // y.x.e
        public void d(float f10) {
            this.f14800e.setFraction(f10);
        }

        public d(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r.f f14780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r.f f14781b;

        public a(r.f fVar, r.f fVar2) {
            this.f14780a = fVar;
            this.f14781b = fVar2;
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public r.f a() {
            return this.f14780a;
        }

        public r.f b() {
            return this.f14781b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f14780a + " upper=" + this.f14781b + "}";
        }

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f14780a = d.g(bounds);
            this.f14781b = d.f(bounds);
        }
    }

    public x(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f14779a = new d(windowInsetsAnimation);
        }
    }
}
