package y;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k0 f14712b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f14713a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f14714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f14715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f14716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f14717d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f14714a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f14715b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f14716c = declaredField3;
                declaredField3.setAccessible(true);
                f14717d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static k0 a(View view) {
            if (f14717d && view.isAttachedToWindow()) {
                try {
                    Object obj = f14714a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f14715b.get(obj);
                        Rect rect2 = (Rect) f14716c.get(obj);
                        if (rect != null && rect2 != null) {
                            k0 k0VarA = new b().c(r.f.c(rect)).d(r.f.c(rect2)).a();
                            k0VarA.n(k0VarA);
                            k0VarA.d(view.getRootView());
                            return k0VarA;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class e extends d {
        public e() {
        }

        @Override // y.k0.f
        public void c(int i10, r.f fVar) {
            this.f14725c.setInsets(n.a(i10), fVar.e());
        }

        @Override // y.k0.f
        public void i(int i10, boolean z10) {
            this.f14725c.setVisible(n.a(i10), z10);
        }

        public e(k0 k0Var) {
            super(k0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f14726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r.f[] f14727b;

        public f() {
            this(new k0((k0) null));
        }

        public final void a() {
            r.f[] fVarArr = this.f14727b;
            if (fVarArr != null) {
                r.f fVarF = fVarArr[m.d(1)];
                r.f fVarF2 = this.f14727b[m.d(2)];
                if (fVarF2 == null) {
                    fVarF2 = this.f14726a.f(2);
                }
                if (fVarF == null) {
                    fVarF = this.f14726a.f(1);
                }
                g(r.f.a(fVarF, fVarF2));
                r.f fVar = this.f14727b[m.d(16)];
                if (fVar != null) {
                    f(fVar);
                }
                r.f fVar2 = this.f14727b[m.d(32)];
                if (fVar2 != null) {
                    d(fVar2);
                }
                r.f fVar3 = this.f14727b[m.d(64)];
                if (fVar3 != null) {
                    h(fVar3);
                }
            }
        }

        public k0 b() {
            a();
            return this.f14726a;
        }

        public void c(int i10, r.f fVar) {
            if (this.f14727b == null) {
                this.f14727b = new r.f[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f14727b[m.d(i11)] = fVar;
                }
            }
        }

        public f(k0 k0Var) {
            this.f14726a = k0Var;
        }

        public void d(r.f fVar) {
        }

        public void e(r.f fVar) {
        }

        public void f(r.f fVar) {
        }

        public void g(r.f fVar) {
        }

        public void h(r.f fVar) {
        }

        public void i(int i10, boolean z10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class i extends h {
        public i(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        @Override // y.k0.l
        public k0 a() {
            return k0.q(this.f14733c.consumeDisplayCutout());
        }

        @Override // y.k0.g, y.k0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f14733c, iVar.f14733c) && Objects.equals(this.f14737g, iVar.f14737g);
        }

        @Override // y.k0.l
        public y.c f() {
            return y.c.f(this.f14733c.getDisplayCutout());
        }

        @Override // y.k0.l
        public int hashCode() {
            return this.f14733c.hashCode();
        }

        public i(k0 k0Var, i iVar) {
            super(k0Var, iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final k0 f14742q = k0.q(WindowInsets.CONSUMED);

        public k(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        @Override // y.k0.g, y.k0.l
        public r.f g(int i10) {
            return r.f.d(this.f14733c.getInsets(n.a(i10)));
        }

        @Override // y.k0.g, y.k0.l
        public r.f h(int i10) {
            return r.f.d(this.f14733c.getInsetsIgnoringVisibility(n.a(i10)));
        }

        @Override // y.k0.g, y.k0.l
        public boolean p(int i10) {
            return this.f14733c.isVisible(n.a(i10));
        }

        public k(k0 k0Var, k kVar) {
            super(k0Var, kVar);
        }

        @Override // y.k0.g, y.k0.l
        public final void d(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class m {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        public static int d(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int e() {
            return 1;
        }

        public static int f() {
            return 7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class n {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f14712b = k.f14742q;
        } else {
            f14712b = l.f14743b;
        }
    }

    public k0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f14713a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f14713a = new j(this, windowInsets);
            return;
        }
        if (i10 >= 28) {
            this.f14713a = new i(this, windowInsets);
            return;
        }
        if (i10 >= 21) {
            this.f14713a = new h(this, windowInsets);
        } else if (i10 >= 20) {
            this.f14713a = new g(this, windowInsets);
        } else {
            this.f14713a = new l(this);
        }
    }

    public static r.f i(r.f fVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, fVar.f11875a - i10);
        int iMax2 = Math.max(0, fVar.f11876b - i11);
        int iMax3 = Math.max(0, fVar.f11877c - i12);
        int iMax4 = Math.max(0, fVar.f11878d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? fVar : r.f.b(iMax, iMax2, iMax3, iMax4);
    }

    public static k0 q(WindowInsets windowInsets) {
        return r(windowInsets, null);
    }

    public static k0 r(WindowInsets windowInsets, View view) {
        k0 k0Var = new k0(j0.a(x.g.b(windowInsets)));
        if (view != null && r.F(view)) {
            k0Var.n(r.y(view));
            k0Var.d(view.getRootView());
        }
        return k0Var;
    }

    public k0 a() {
        return this.f14713a.a();
    }

    public k0 b() {
        return this.f14713a.b();
    }

    public k0 c() {
        return this.f14713a.c();
    }

    public void d(View view) {
        this.f14713a.d(view);
    }

    public y.c e() {
        return this.f14713a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k0) {
            return x.c.a(this.f14713a, ((k0) obj).f14713a);
        }
        return false;
    }

    public r.f f(int i10) {
        return this.f14713a.g(i10);
    }

    public r.f g(int i10) {
        return this.f14713a.h(i10);
    }

    public r.f h() {
        return this.f14713a.j();
    }

    public int hashCode() {
        l lVar = this.f14713a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public boolean j() {
        return this.f14713a.n();
    }

    public boolean k(int i10) {
        return this.f14713a.p(i10);
    }

    public void l(r.f[] fVarArr) {
        this.f14713a.q(fVarArr);
    }

    public void m(r.f fVar) {
        this.f14713a.r(fVar);
    }

    public void n(k0 k0Var) {
        this.f14713a.s(k0Var);
    }

    public void o(r.f fVar) {
        this.f14713a.t(fVar);
    }

    public WindowInsets p() {
        l lVar = this.f14713a;
        if (lVar instanceof g) {
            return ((g) lVar).f14733c;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f14719e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f14720f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor f14721g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f14722h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f14723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r.f f14724d;

        public c() {
            this.f14723c = j();
        }

        private static WindowInsets j() {
            if (!f14720f) {
                try {
                    f14719e = m0.a().getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f14720f = true;
            }
            Field field = f14719e;
            if (field != null) {
                try {
                    WindowInsets windowInsetsA = j0.a(field.get(null));
                    if (windowInsetsA != null) {
                        return new WindowInsets(windowInsetsA);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f14722h) {
                try {
                    f14721g = m0.a().getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f14722h = true;
            }
            Constructor constructor = f14721g;
            if (constructor != null) {
                try {
                    return j0.a(constructor.newInstance(new Rect()));
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // y.k0.f
        public k0 b() {
            a();
            k0 k0VarQ = k0.q(this.f14723c);
            k0VarQ.l(this.f14727b);
            k0VarQ.o(this.f14724d);
            return k0VarQ;
        }

        @Override // y.k0.f
        public void e(r.f fVar) {
            this.f14724d = fVar;
        }

        @Override // y.k0.f
        public void g(r.f fVar) {
            WindowInsets windowInsets = this.f14723c;
            if (windowInsets != null) {
                this.f14723c = windowInsets.replaceSystemWindowInsets(fVar.f11875a, fVar.f11876b, fVar.f11877c, fVar.f11878d);
            }
        }

        public c(k0 k0Var) {
            super(k0Var);
            this.f14723c = k0Var.p();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f14725c;

        public d() {
            this.f14725c = new WindowInsets.Builder();
        }

        @Override // y.k0.f
        public k0 b() {
            a();
            k0 k0VarQ = k0.q(this.f14725c.build());
            k0VarQ.l(this.f14727b);
            return k0VarQ;
        }

        @Override // y.k0.f
        public void d(r.f fVar) {
            this.f14725c.setMandatorySystemGestureInsets(fVar.e());
        }

        @Override // y.k0.f
        public void e(r.f fVar) {
            this.f14725c.setStableInsets(fVar.e());
        }

        @Override // y.k0.f
        public void f(r.f fVar) {
            this.f14725c.setSystemGestureInsets(fVar.e());
        }

        @Override // y.k0.f
        public void g(r.f fVar) {
            this.f14725c.setSystemWindowInsets(fVar.e());
        }

        @Override // y.k0.f
        public void h(r.f fVar) {
            this.f14725c.setTappableElementInsets(fVar.e());
        }

        public d(k0 k0Var) {
            WindowInsets.Builder builder;
            super(k0Var);
            WindowInsets windowInsetsP = k0Var.p();
            if (windowInsetsP != null) {
                builder = new WindowInsets.Builder(windowInsetsP);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f14725c = builder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public r.f f14738m;

        public h(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f14738m = null;
        }

        @Override // y.k0.l
        public k0 b() {
            return k0.q(this.f14733c.consumeStableInsets());
        }

        @Override // y.k0.l
        public k0 c() {
            return k0.q(this.f14733c.consumeSystemWindowInsets());
        }

        @Override // y.k0.l
        public final r.f j() {
            if (this.f14738m == null) {
                this.f14738m = r.f.b(this.f14733c.getStableInsetLeft(), this.f14733c.getStableInsetTop(), this.f14733c.getStableInsetRight(), this.f14733c.getStableInsetBottom());
            }
            return this.f14738m;
        }

        @Override // y.k0.l
        public boolean n() {
            return this.f14733c.isConsumed();
        }

        @Override // y.k0.l
        public void t(r.f fVar) {
            this.f14738m = fVar;
        }

        public h(k0 k0Var, h hVar) {
            super(k0Var, hVar);
            this.f14738m = null;
            this.f14738m = hVar.f14738m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f14728h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f14729i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class f14730j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f14731k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f14732l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f14733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r.f[] f14734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public r.f f14735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public k0 f14736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public r.f f14737g;

        public g(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var);
            this.f14735e = null;
            this.f14733c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private r.f u(int i10, boolean z10) {
            r.f fVarA = r.f.f11874e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    fVarA = r.f.a(fVarA, v(i11, z10));
                }
            }
            return fVarA;
        }

        private r.f w() {
            k0 k0Var = this.f14736f;
            return k0Var != null ? k0Var.h() : r.f.f11874e;
        }

        private r.f x(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f14728h) {
                z();
            }
            Method method = f14729i;
            if (method != null && f14730j != null && f14731k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f14731k.get(f14732l.get(objInvoke));
                    if (rect != null) {
                        return r.f.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void z() {
            try {
                f14729i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f14730j = cls;
                f14731k = cls.getDeclaredField("mVisibleInsets");
                f14732l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f14731k.setAccessible(true);
                f14732l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f14728h = true;
        }

        @Override // y.k0.l
        public void d(View view) {
            r.f fVarX = x(view);
            if (fVarX == null) {
                fVarX = r.f.f11874e;
            }
            r(fVarX);
        }

        @Override // y.k0.l
        public void e(k0 k0Var) {
            k0Var.n(this.f14736f);
            k0Var.m(this.f14737g);
        }

        @Override // y.k0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f14737g, ((g) obj).f14737g);
            }
            return false;
        }

        @Override // y.k0.l
        public r.f g(int i10) {
            return u(i10, false);
        }

        @Override // y.k0.l
        public r.f h(int i10) {
            return u(i10, true);
        }

        @Override // y.k0.l
        public final r.f l() {
            if (this.f14735e == null) {
                this.f14735e = r.f.b(this.f14733c.getSystemWindowInsetLeft(), this.f14733c.getSystemWindowInsetTop(), this.f14733c.getSystemWindowInsetRight(), this.f14733c.getSystemWindowInsetBottom());
            }
            return this.f14735e;
        }

        @Override // y.k0.l
        public boolean o() {
            return this.f14733c.isRound();
        }

        @Override // y.k0.l
        @SuppressLint({"WrongConstant"})
        public boolean p(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !y(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // y.k0.l
        public void q(r.f[] fVarArr) {
            this.f14734d = fVarArr;
        }

        @Override // y.k0.l
        public void r(r.f fVar) {
            this.f14737g = fVar;
        }

        @Override // y.k0.l
        public void s(k0 k0Var) {
            this.f14736f = k0Var;
        }

        public r.f v(int i10, boolean z10) {
            r.f fVarH;
            int i11;
            if (i10 == 1) {
                return z10 ? r.f.b(0, Math.max(w().f11876b, l().f11876b), 0, 0) : r.f.b(0, l().f11876b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    r.f fVarW = w();
                    r.f fVarJ = j();
                    return r.f.b(Math.max(fVarW.f11875a, fVarJ.f11875a), 0, Math.max(fVarW.f11877c, fVarJ.f11877c), Math.max(fVarW.f11878d, fVarJ.f11878d));
                }
                r.f fVarL = l();
                k0 k0Var = this.f14736f;
                fVarH = k0Var != null ? k0Var.h() : null;
                int iMin = fVarL.f11878d;
                if (fVarH != null) {
                    iMin = Math.min(iMin, fVarH.f11878d);
                }
                return r.f.b(fVarL.f11875a, 0, fVarL.f11877c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return k();
                }
                if (i10 == 32) {
                    return i();
                }
                if (i10 == 64) {
                    return m();
                }
                if (i10 != 128) {
                    return r.f.f11874e;
                }
                k0 k0Var2 = this.f14736f;
                y.c cVarE = k0Var2 != null ? k0Var2.e() : f();
                return cVarE != null ? r.f.b(cVarE.c(), cVarE.e(), cVarE.d(), cVarE.b()) : r.f.f11874e;
            }
            r.f[] fVarArr = this.f14734d;
            fVarH = fVarArr != null ? fVarArr[m.d(8)] : null;
            if (fVarH != null) {
                return fVarH;
            }
            r.f fVarL2 = l();
            r.f fVarW2 = w();
            int i12 = fVarL2.f11878d;
            if (i12 > fVarW2.f11878d) {
                return r.f.b(0, 0, 0, i12);
            }
            r.f fVar = this.f14737g;
            return (fVar == null || fVar.equals(r.f.f11874e) || (i11 = this.f14737g.f11878d) <= fVarW2.f11878d) ? r.f.f11874e : r.f.b(0, 0, 0, i11);
        }

        public boolean y(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !v(i10, false).equals(r.f.f11874e);
        }

        public g(k0 k0Var, g gVar) {
            this(k0Var, new WindowInsets(gVar.f14733c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public r.f f14739n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public r.f f14740o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public r.f f14741p;

        public j(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f14739n = null;
            this.f14740o = null;
            this.f14741p = null;
        }

        @Override // y.k0.l
        public r.f i() {
            if (this.f14740o == null) {
                this.f14740o = r.f.d(this.f14733c.getMandatorySystemGestureInsets());
            }
            return this.f14740o;
        }

        @Override // y.k0.l
        public r.f k() {
            if (this.f14739n == null) {
                this.f14739n = r.f.d(this.f14733c.getSystemGestureInsets());
            }
            return this.f14739n;
        }

        @Override // y.k0.l
        public r.f m() {
            if (this.f14741p == null) {
                this.f14741p = r.f.d(this.f14733c.getTappableElementInsets());
            }
            return this.f14741p;
        }

        public j(k0 k0Var, j jVar) {
            super(k0Var, jVar);
            this.f14739n = null;
            this.f14740o = null;
            this.f14741p = null;
        }

        @Override // y.k0.h, y.k0.l
        public void t(r.f fVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f14718a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f14718a = new e();
                return;
            }
            if (i10 >= 29) {
                this.f14718a = new d();
            } else if (i10 >= 20) {
                this.f14718a = new c();
            } else {
                this.f14718a = new f();
            }
        }

        public k0 a() {
            return this.f14718a.b();
        }

        public b b(int i10, r.f fVar) {
            this.f14718a.c(i10, fVar);
            return this;
        }

        public b c(r.f fVar) {
            this.f14718a.e(fVar);
            return this;
        }

        public b d(r.f fVar) {
            this.f14718a.g(fVar);
            return this;
        }

        public b e(int i10, boolean z10) {
            this.f14718a.i(i10, z10);
            return this;
        }

        public b(k0 k0Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f14718a = new e(k0Var);
                return;
            }
            if (i10 >= 29) {
                this.f14718a = new d(k0Var);
            } else if (i10 >= 20) {
                this.f14718a = new c(k0Var);
            } else {
                this.f14718a = new f(k0Var);
            }
        }
    }

    public k0(k0 k0Var) {
        if (k0Var != null) {
            l lVar = k0Var.f14713a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f14713a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f14713a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f14713a = new i(this, (i) lVar);
            } else if (i10 >= 21 && (lVar instanceof h)) {
                this.f14713a = new h(this, (h) lVar);
            } else if (i10 >= 20 && (lVar instanceof g)) {
                this.f14713a = new g(this, (g) lVar);
            } else {
                this.f14713a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f14713a = new l(this);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k0 f14743b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f14744a;

        public l(k0 k0Var) {
            this.f14744a = k0Var;
        }

        public k0 a() {
            return this.f14744a;
        }

        public k0 b() {
            return this.f14744a;
        }

        public k0 c() {
            return this.f14744a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && x.c.a(l(), lVar.l()) && x.c.a(j(), lVar.j()) && x.c.a(f(), lVar.f());
        }

        public y.c f() {
            return null;
        }

        public r.f g(int i10) {
            return r.f.f11874e;
        }

        public r.f h(int i10) {
            if ((i10 & 8) == 0) {
                return r.f.f11874e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return x.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), l(), j(), f());
        }

        public r.f i() {
            return l();
        }

        public r.f j() {
            return r.f.f11874e;
        }

        public r.f k() {
            return l();
        }

        public r.f l() {
            return r.f.f11874e;
        }

        public r.f m() {
            return l();
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public boolean p(int i10) {
            return true;
        }

        public void d(View view) {
        }

        public void e(k0 k0Var) {
        }

        public void q(r.f[] fVarArr) {
        }

        public void r(r.f fVar) {
        }

        public void s(k0 k0Var) {
        }

        public void t(r.f fVar) {
        }
    }
}
