package x;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f13468b;

    /* renamed from: a, reason: collision with root package name */
    public final l f13469a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Field f13470a;

        /* renamed from: b, reason: collision with root package name */
        public static Field f13471b;

        /* renamed from: c, reason: collision with root package name */
        public static Field f13472c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f13473d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f13470a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f13471b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f13472c = declaredField3;
                declaredField3.setAccessible(true);
                f13473d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static k0 a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f13473d && view.isAttachedToWindow()) {
                try {
                    Object obj = f13470a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f13471b.get(obj);
                        Rect rect2 = (Rect) f13472c.get(obj);
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f13474a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f13474a = new e();
                return;
            }
            if (i10 >= 29) {
                this.f13474a = new d();
            } else if (i10 >= 20) {
                this.f13474a = new c();
            } else {
                this.f13474a = new f();
            }
        }

        public b(k0 k0Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f13474a = new e(k0Var);
                return;
            }
            if (i10 >= 29) {
                this.f13474a = new d(k0Var);
            } else if (i10 >= 20) {
                this.f13474a = new c(k0Var);
            } else {
                this.f13474a = new f(k0Var);
            }
        }

        public k0 a() {
            return this.f13474a.b();
        }

        public b b(int i10, r.f fVar) {
            this.f13474a.c(i10, fVar);
            return this;
        }

        public b c(r.f fVar) {
            this.f13474a.e(fVar);
            return this;
        }

        public b d(r.f fVar) {
            this.f13474a.g(fVar);
            return this;
        }

        public b e(int i10, boolean z10) {
            this.f13474a.i(i10, z10);
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public static Field f13475e = null;

        /* renamed from: f, reason: collision with root package name */
        public static boolean f13476f = false;

        /* renamed from: g, reason: collision with root package name */
        public static Constructor f13477g = null;

        /* renamed from: h, reason: collision with root package name */
        public static boolean f13478h = false;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsets f13479c;

        /* renamed from: d, reason: collision with root package name */
        public r.f f13480d;

        public c() {
            this.f13479c = j();
        }

        public c(k0 k0Var) {
            super(k0Var);
            this.f13479c = k0Var.p();
        }

        private static WindowInsets j() {
            if (!f13476f) {
                try {
                    f13475e = m0.a().getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f13476f = true;
            }
            Field field = f13475e;
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
            if (!f13478h) {
                try {
                    f13477g = m0.a().getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f13478h = true;
            }
            Constructor constructor = f13477g;
            if (constructor != null) {
                try {
                    return j0.a(constructor.newInstance(new Rect()));
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // x.k0.f
        public k0 b() {
            a();
            k0 k0VarQ = k0.q(this.f13479c);
            k0VarQ.l(this.f13483b);
            k0VarQ.o(this.f13480d);
            return k0VarQ;
        }

        @Override // x.k0.f
        public void e(r.f fVar) {
            this.f13480d = fVar;
        }

        @Override // x.k0.f
        public void g(r.f fVar) {
            WindowInsets windowInsets = this.f13479c;
            if (windowInsets != null) {
                this.f13479c = windowInsets.replaceSystemWindowInsets(fVar.f11465a, fVar.f11466b, fVar.f11467c, fVar.f11468d);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f13481c;

        public d() {
            this.f13481c = new WindowInsets.Builder();
        }

        public d(k0 k0Var) {
            super(k0Var);
            WindowInsets windowInsetsP = k0Var.p();
            this.f13481c = windowInsetsP != null ? new WindowInsets.Builder(windowInsetsP) : new WindowInsets.Builder();
        }

        @Override // x.k0.f
        public k0 b() {
            a();
            k0 k0VarQ = k0.q(this.f13481c.build());
            k0VarQ.l(this.f13483b);
            return k0VarQ;
        }

        @Override // x.k0.f
        public void d(r.f fVar) {
            this.f13481c.setMandatorySystemGestureInsets(fVar.e());
        }

        @Override // x.k0.f
        public void e(r.f fVar) {
            this.f13481c.setStableInsets(fVar.e());
        }

        @Override // x.k0.f
        public void f(r.f fVar) {
            this.f13481c.setSystemGestureInsets(fVar.e());
        }

        @Override // x.k0.f
        public void g(r.f fVar) {
            this.f13481c.setSystemWindowInsets(fVar.e());
        }

        @Override // x.k0.f
        public void h(r.f fVar) {
            this.f13481c.setTappableElementInsets(fVar.e());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class e extends d {
        public e() {
        }

        public e(k0 k0Var) {
            super(k0Var);
        }

        @Override // x.k0.f
        public void c(int i10, r.f fVar) {
            this.f13481c.setInsets(n.a(i10), fVar.e());
        }

        @Override // x.k0.f
        public void i(int i10, boolean z10) {
            this.f13481c.setVisible(n.a(i10), z10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final k0 f13482a;

        /* renamed from: b, reason: collision with root package name */
        public r.f[] f13483b;

        public f() {
            this(new k0((k0) null));
        }

        public f(k0 k0Var) {
            this.f13482a = k0Var;
        }

        public final void a() {
            r.f[] fVarArr = this.f13483b;
            if (fVarArr != null) {
                r.f fVarF = fVarArr[m.d(1)];
                r.f fVarF2 = this.f13483b[m.d(2)];
                if (fVarF2 == null) {
                    fVarF2 = this.f13482a.f(2);
                }
                if (fVarF == null) {
                    fVarF = this.f13482a.f(1);
                }
                g(r.f.a(fVarF, fVarF2));
                r.f fVar = this.f13483b[m.d(16)];
                if (fVar != null) {
                    f(fVar);
                }
                r.f fVar2 = this.f13483b[m.d(32)];
                if (fVar2 != null) {
                    d(fVar2);
                }
                r.f fVar3 = this.f13483b[m.d(64)];
                if (fVar3 != null) {
                    h(fVar3);
                }
            }
        }

        public k0 b() {
            a();
            return this.f13482a;
        }

        public void c(int i10, r.f fVar) {
            if (this.f13483b == null) {
                this.f13483b = new r.f[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f13483b[m.d(i11)] = fVar;
                }
            }
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        public static boolean f13484h = false;

        /* renamed from: i, reason: collision with root package name */
        public static Method f13485i;

        /* renamed from: j, reason: collision with root package name */
        public static Class f13486j;

        /* renamed from: k, reason: collision with root package name */
        public static Field f13487k;

        /* renamed from: l, reason: collision with root package name */
        public static Field f13488l;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f13489c;

        /* renamed from: d, reason: collision with root package name */
        public r.f[] f13490d;

        /* renamed from: e, reason: collision with root package name */
        public r.f f13491e;

        /* renamed from: f, reason: collision with root package name */
        public k0 f13492f;

        /* renamed from: g, reason: collision with root package name */
        public r.f f13493g;

        public g(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var);
            this.f13491e = null;
            this.f13489c = windowInsets;
        }

        public g(k0 k0Var, g gVar) {
            this(k0Var, new WindowInsets(gVar.f13489c));
        }

        @SuppressLint({"WrongConstant"})
        private r.f u(int i10, boolean z10) {
            r.f fVarA = r.f.f11464e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    fVarA = r.f.a(fVarA, v(i11, z10));
                }
            }
            return fVarA;
        }

        private r.f w() {
            k0 k0Var = this.f13492f;
            return k0Var != null ? k0Var.h() : r.f.f11464e;
        }

        private r.f x(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f13484h) {
                z();
            }
            Method method = f13485i;
            if (method != null && f13486j != null && f13487k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f13487k.get(f13488l.get(objInvoke));
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
        private static void z() throws ClassNotFoundException, SecurityException {
            try {
                f13485i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f13486j = cls;
                f13487k = cls.getDeclaredField("mVisibleInsets");
                f13488l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f13487k.setAccessible(true);
                f13488l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f13484h = true;
        }

        @Override // x.k0.l
        public void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            r.f fVarX = x(view);
            if (fVarX == null) {
                fVarX = r.f.f11464e;
            }
            r(fVarX);
        }

        @Override // x.k0.l
        public void e(k0 k0Var) {
            k0Var.n(this.f13492f);
            k0Var.m(this.f13493g);
        }

        @Override // x.k0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f13493g, ((g) obj).f13493g);
            }
            return false;
        }

        @Override // x.k0.l
        public r.f g(int i10) {
            return u(i10, false);
        }

        @Override // x.k0.l
        public r.f h(int i10) {
            return u(i10, true);
        }

        @Override // x.k0.l
        public final r.f l() {
            if (this.f13491e == null) {
                this.f13491e = r.f.b(this.f13489c.getSystemWindowInsetLeft(), this.f13489c.getSystemWindowInsetTop(), this.f13489c.getSystemWindowInsetRight(), this.f13489c.getSystemWindowInsetBottom());
            }
            return this.f13491e;
        }

        @Override // x.k0.l
        public boolean o() {
            return this.f13489c.isRound();
        }

        @Override // x.k0.l
        @SuppressLint({"WrongConstant"})
        public boolean p(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !y(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // x.k0.l
        public void q(r.f[] fVarArr) {
            this.f13490d = fVarArr;
        }

        @Override // x.k0.l
        public void r(r.f fVar) {
            this.f13493g = fVar;
        }

        @Override // x.k0.l
        public void s(k0 k0Var) {
            this.f13492f = k0Var;
        }

        public r.f v(int i10, boolean z10) {
            r.f fVarH;
            int i11;
            if (i10 == 1) {
                return z10 ? r.f.b(0, Math.max(w().f11466b, l().f11466b), 0, 0) : r.f.b(0, l().f11466b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    r.f fVarW = w();
                    r.f fVarJ = j();
                    return r.f.b(Math.max(fVarW.f11465a, fVarJ.f11465a), 0, Math.max(fVarW.f11467c, fVarJ.f11467c), Math.max(fVarW.f11468d, fVarJ.f11468d));
                }
                r.f fVarL = l();
                k0 k0Var = this.f13492f;
                fVarH = k0Var != null ? k0Var.h() : null;
                int iMin = fVarL.f11468d;
                if (fVarH != null) {
                    iMin = Math.min(iMin, fVarH.f11468d);
                }
                return r.f.b(fVarL.f11465a, 0, fVarL.f11467c, iMin);
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
                    return r.f.f11464e;
                }
                k0 k0Var2 = this.f13492f;
                x.c cVarE = k0Var2 != null ? k0Var2.e() : f();
                return cVarE != null ? r.f.b(cVarE.c(), cVarE.e(), cVarE.d(), cVarE.b()) : r.f.f11464e;
            }
            r.f[] fVarArr = this.f13490d;
            fVarH = fVarArr != null ? fVarArr[m.d(8)] : null;
            if (fVarH != null) {
                return fVarH;
            }
            r.f fVarL2 = l();
            r.f fVarW2 = w();
            int i12 = fVarL2.f11468d;
            if (i12 > fVarW2.f11468d) {
                return r.f.b(0, 0, 0, i12);
            }
            r.f fVar = this.f13493g;
            return (fVar == null || fVar.equals(r.f.f11464e) || (i11 = this.f13493g.f11468d) <= fVarW2.f11468d) ? r.f.f11464e : r.f.b(0, 0, 0, i11);
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
            return !v(i10, false).equals(r.f.f11464e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        public r.f f13494m;

        public h(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f13494m = null;
        }

        public h(k0 k0Var, h hVar) {
            super(k0Var, hVar);
            this.f13494m = null;
            this.f13494m = hVar.f13494m;
        }

        @Override // x.k0.l
        public k0 b() {
            return k0.q(this.f13489c.consumeStableInsets());
        }

        @Override // x.k0.l
        public k0 c() {
            return k0.q(this.f13489c.consumeSystemWindowInsets());
        }

        @Override // x.k0.l
        public final r.f j() {
            if (this.f13494m == null) {
                this.f13494m = r.f.b(this.f13489c.getStableInsetLeft(), this.f13489c.getStableInsetTop(), this.f13489c.getStableInsetRight(), this.f13489c.getStableInsetBottom());
            }
            return this.f13494m;
        }

        @Override // x.k0.l
        public boolean n() {
            return this.f13489c.isConsumed();
        }

        @Override // x.k0.l
        public void t(r.f fVar) {
            this.f13494m = fVar;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i extends h {
        public i(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        public i(k0 k0Var, i iVar) {
            super(k0Var, iVar);
        }

        @Override // x.k0.l
        public k0 a() {
            return k0.q(this.f13489c.consumeDisplayCutout());
        }

        @Override // x.k0.g, x.k0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f13489c, iVar.f13489c) && Objects.equals(this.f13493g, iVar.f13493g);
        }

        @Override // x.k0.l
        public x.c f() {
            return x.c.f(this.f13489c.getDisplayCutout());
        }

        @Override // x.k0.l
        public int hashCode() {
            return this.f13489c.hashCode();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        public r.f f13495n;

        /* renamed from: o, reason: collision with root package name */
        public r.f f13496o;

        /* renamed from: p, reason: collision with root package name */
        public r.f f13497p;

        public j(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f13495n = null;
            this.f13496o = null;
            this.f13497p = null;
        }

        public j(k0 k0Var, j jVar) {
            super(k0Var, jVar);
            this.f13495n = null;
            this.f13496o = null;
            this.f13497p = null;
        }

        @Override // x.k0.l
        public r.f i() {
            if (this.f13496o == null) {
                this.f13496o = r.f.d(this.f13489c.getMandatorySystemGestureInsets());
            }
            return this.f13496o;
        }

        @Override // x.k0.l
        public r.f k() {
            if (this.f13495n == null) {
                this.f13495n = r.f.d(this.f13489c.getSystemGestureInsets());
            }
            return this.f13495n;
        }

        @Override // x.k0.l
        public r.f m() {
            if (this.f13497p == null) {
                this.f13497p = r.f.d(this.f13489c.getTappableElementInsets());
            }
            return this.f13497p;
        }

        @Override // x.k0.h, x.k0.l
        public void t(r.f fVar) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        public static final k0 f13498q = k0.q(WindowInsets.CONSUMED);

        public k(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        public k(k0 k0Var, k kVar) {
            super(k0Var, kVar);
        }

        @Override // x.k0.g, x.k0.l
        public final void d(View view) {
        }

        @Override // x.k0.g, x.k0.l
        public r.f g(int i10) {
            return r.f.d(this.f13489c.getInsets(n.a(i10)));
        }

        @Override // x.k0.g, x.k0.l
        public r.f h(int i10) {
            return r.f.d(this.f13489c.getInsetsIgnoringVisibility(n.a(i10)));
        }

        @Override // x.k0.g, x.k0.l
        public boolean p(int i10) {
            return this.f13489c.isVisible(n.a(i10));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        public static final k0 f13499b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        public final k0 f13500a;

        public l(k0 k0Var) {
            this.f13500a = k0Var;
        }

        public k0 a() {
            return this.f13500a;
        }

        public k0 b() {
            return this.f13500a;
        }

        public k0 c() {
            return this.f13500a;
        }

        public void d(View view) {
        }

        public void e(k0 k0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && w.c.a(l(), lVar.l()) && w.c.a(j(), lVar.j()) && w.c.a(f(), lVar.f());
        }

        public x.c f() {
            return null;
        }

        public r.f g(int i10) {
            return r.f.f11464e;
        }

        public r.f h(int i10) {
            if ((i10 & 8) == 0) {
                return r.f.f11464e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return w.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), l(), j(), f());
        }

        public r.f i() {
            return l();
        }

        public r.f j() {
            return r.f.f11464e;
        }

        public r.f k() {
            return l();
        }

        public r.f l() {
            return r.f.f11464e;
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

        public void q(r.f[] fVarArr) {
        }

        public void r(r.f fVar) {
        }

        public void s(k0 k0Var) {
        }

        public void t(r.f fVar) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            f13468b = k.f13498q;
        } else {
            f13468b = l.f13499b;
        }
    }

    public k0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f13469a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f13469a = new j(this, windowInsets);
            return;
        }
        if (i10 >= 28) {
            this.f13469a = new i(this, windowInsets);
            return;
        }
        if (i10 >= 21) {
            this.f13469a = new h(this, windowInsets);
        } else if (i10 >= 20) {
            this.f13469a = new g(this, windowInsets);
        } else {
            this.f13469a = new l(this);
        }
    }

    public k0(k0 k0Var) {
        if (k0Var == null) {
            this.f13469a = new l(this);
            return;
        }
        l lVar = k0Var.f13469a;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30 && (lVar instanceof k)) {
            this.f13469a = new k(this, (k) lVar);
        } else if (i10 >= 29 && (lVar instanceof j)) {
            this.f13469a = new j(this, (j) lVar);
        } else if (i10 >= 28 && (lVar instanceof i)) {
            this.f13469a = new i(this, (i) lVar);
        } else if (i10 >= 21 && (lVar instanceof h)) {
            this.f13469a = new h(this, (h) lVar);
        } else if (i10 < 20 || !(lVar instanceof g)) {
            this.f13469a = new l(this);
        } else {
            this.f13469a = new g(this, (g) lVar);
        }
        lVar.e(this);
    }

    public static r.f i(r.f fVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, fVar.f11465a - i10);
        int iMax2 = Math.max(0, fVar.f11466b - i11);
        int iMax3 = Math.max(0, fVar.f11467c - i12);
        int iMax4 = Math.max(0, fVar.f11468d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? fVar : r.f.b(iMax, iMax2, iMax3, iMax4);
    }

    public static k0 q(WindowInsets windowInsets) {
        return r(windowInsets, null);
    }

    public static k0 r(WindowInsets windowInsets, View view) {
        k0 k0Var = new k0(j0.a(w.g.b(windowInsets)));
        if (view != null && r.F(view)) {
            k0Var.n(r.y(view));
            k0Var.d(view.getRootView());
        }
        return k0Var;
    }

    public k0 a() {
        return this.f13469a.a();
    }

    public k0 b() {
        return this.f13469a.b();
    }

    public k0 c() {
        return this.f13469a.c();
    }

    public void d(View view) {
        this.f13469a.d(view);
    }

    public x.c e() {
        return this.f13469a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k0) {
            return w.c.a(this.f13469a, ((k0) obj).f13469a);
        }
        return false;
    }

    public r.f f(int i10) {
        return this.f13469a.g(i10);
    }

    public r.f g(int i10) {
        return this.f13469a.h(i10);
    }

    public r.f h() {
        return this.f13469a.j();
    }

    public int hashCode() {
        l lVar = this.f13469a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public boolean j() {
        return this.f13469a.n();
    }

    public boolean k(int i10) {
        return this.f13469a.p(i10);
    }

    public void l(r.f[] fVarArr) {
        this.f13469a.q(fVarArr);
    }

    public void m(r.f fVar) {
        this.f13469a.r(fVar);
    }

    public void n(k0 k0Var) {
        this.f13469a.s(k0Var);
    }

    public void o(r.f fVar) {
        this.f13469a.t(fVar);
    }

    public WindowInsets p() {
        l lVar = this.f13469a;
        if (lVar instanceof g) {
            return ((g) lVar).f13489c;
        }
        return null;
    }
}
