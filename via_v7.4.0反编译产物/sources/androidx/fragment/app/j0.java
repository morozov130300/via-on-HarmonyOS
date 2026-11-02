package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final y f854a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f855b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f856c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f857d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f858e = -1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f859e;

        public a(View view) {
            this.f859e = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f859e.removeOnAttachStateChangeListener(this);
            x.r.U(this.f859e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f861a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f861a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f861a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f861a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f861a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public j0(y yVar, k0 k0Var, Fragment fragment) {
        this.f854a = yVar;
        this.f855b = k0Var;
        this.f856c = fragment;
    }

    public j0(y yVar, k0 k0Var, Fragment fragment, Bundle bundle) {
        this.f854a = yVar;
        this.f855b = k0Var;
        this.f856c = fragment;
        fragment.f666k = null;
        fragment.f668l = null;
        fragment.B = 0;
        fragment.f681y = false;
        fragment.f676t = false;
        Fragment fragment2 = fragment.f672p;
        fragment.f673q = fragment2 != null ? fragment2.f670n : null;
        fragment.f672p = null;
        fragment.f664j = bundle;
        fragment.f671o = bundle.getBundle("arguments");
    }

    public j0(y yVar, k0 k0Var, ClassLoader classLoader, v vVar, Bundle bundle) {
        this.f854a = yVar;
        this.f855b = k0Var;
        Fragment fragmentA = ((FragmentState) bundle.getParcelable("state")).a(vVar, classLoader);
        this.f856c = fragmentA;
        fragmentA.f664j = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        fragmentA.H2(bundle2);
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    public void a() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f856c);
        }
        Bundle bundle = this.f856c.f664j;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f856c.Z1(bundle2);
        this.f854a.a(this.f856c, bundle2, false);
    }

    public void b() {
        Fragment fragmentQ0 = FragmentManager.q0(this.f856c.Q);
        Fragment fragmentM0 = this.f856c.M0();
        if (fragmentQ0 != null && !fragmentQ0.equals(fragmentM0)) {
            Fragment fragment = this.f856c;
            FragmentStrictMode.j(fragment, fragmentQ0, fragment.H);
        }
        int iJ = this.f855b.j(this.f856c);
        Fragment fragment2 = this.f856c;
        fragment2.Q.addView(fragment2.R, iJ);
    }

    public void c() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f856c);
        }
        Fragment fragment = this.f856c;
        Fragment fragment2 = fragment.f672p;
        j0 j0VarN = null;
        if (fragment2 != null) {
            j0 j0VarN2 = this.f855b.n(fragment2.f670n);
            if (j0VarN2 == null) {
                throw new IllegalStateException("Fragment " + this.f856c + " declared target fragment " + this.f856c.f672p + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f856c;
            fragment3.f673q = fragment3.f672p.f670n;
            fragment3.f672p = null;
            j0VarN = j0VarN2;
        } else {
            String str = fragment.f673q;
            if (str != null && (j0VarN = this.f855b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f856c + " declared target fragment " + this.f856c.f673q + " that does not belong to this FragmentManager!");
            }
        }
        if (j0VarN != null) {
            j0VarN.m();
        }
        Fragment fragment4 = this.f856c;
        fragment4.D = fragment4.C.B0();
        Fragment fragment5 = this.f856c;
        fragment5.F = fragment5.C.E0();
        this.f854a.g(this.f856c, false);
        this.f856c.a2();
        this.f854a.b(this.f856c, false);
    }

    public int d() {
        Fragment fragment = this.f856c;
        if (fragment.C == null) {
            return fragment.f658e;
        }
        int iMin = this.f858e;
        int i10 = b.f861a[fragment.f655b0.ordinal()];
        if (i10 != 1) {
            iMin = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f856c;
        if (fragment2.f680x) {
            if (fragment2.f681y) {
                iMin = Math.max(this.f858e, 2);
                View view = this.f856c.R;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f858e < 4 ? Math.min(iMin, fragment2.f658e) : Math.min(iMin, 1);
            }
        }
        if (!this.f856c.f676t) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f856c;
        ViewGroup viewGroup = fragment3.Q;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactS = viewGroup != null ? SpecialEffectsController.u(viewGroup, fragment3.N0()).s(this) : null;
        if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f856c;
            if (fragment4.f677u) {
                iMin = fragment4.l1() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f856c;
        if (fragment5.S && fragment5.f658e < 5) {
            iMin = Math.min(iMin, 4);
        }
        Fragment fragment6 = this.f856c;
        if (fragment6.f678v && fragment6.Q != null) {
            iMin = Math.max(iMin, 3);
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f856c);
        }
        return iMin;
    }

    public void e() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f856c);
        }
        Bundle bundle = this.f856c.f664j;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.f856c;
        if (fragment.Z) {
            fragment.f658e = 1;
            fragment.D2();
        } else {
            this.f854a.h(fragment, bundle2, false);
            this.f856c.d2(bundle2);
            this.f854a.c(this.f856c, bundle2, false);
        }
    }

    public void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f856c.f680x) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f856c);
        }
        Bundle bundle = this.f856c.f664j;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterJ2 = this.f856c.j2(bundle2);
        Fragment fragment = this.f856c;
        ViewGroup viewGroup2 = fragment.Q;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = fragment.H;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f856c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.C.w0().j(this.f856c.H);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f856c;
                    if (!fragment2.f682z) {
                        try {
                            resourceName = fragment2.T0().getResourceName(this.f856c.H);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f856c.H) + " (" + resourceName + ") for fragment " + this.f856c);
                    }
                } else if (!(viewGroup instanceof t)) {
                    FragmentStrictMode.i(this.f856c, viewGroup);
                }
            }
        }
        Fragment fragment3 = this.f856c;
        fragment3.Q = viewGroup;
        fragment3.f2(layoutInflaterJ2, viewGroup, bundle2);
        if (this.f856c.R != null) {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f856c);
            }
            this.f856c.R.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f856c;
            fragment4.R.setTag(d0.b.f4435a, fragment4);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment5 = this.f856c;
            if (fragment5.J) {
                fragment5.R.setVisibility(8);
            }
            if (this.f856c.R.isAttachedToWindow()) {
                x.r.U(this.f856c.R);
            } else {
                View view = this.f856c.R;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f856c.w2();
            y yVar = this.f854a;
            Fragment fragment6 = this.f856c;
            yVar.m(fragment6, fragment6.R, bundle2, false);
            int visibility = this.f856c.R.getVisibility();
            this.f856c.N2(this.f856c.R.getAlpha());
            Fragment fragment7 = this.f856c;
            if (fragment7.Q != null && visibility == 0) {
                View viewFindFocus = fragment7.R.findFocus();
                if (viewFindFocus != null) {
                    this.f856c.I2(viewFindFocus);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f856c);
                    }
                }
                this.f856c.R.setAlpha(0.0f);
            }
        }
        this.f856c.f658e = 2;
    }

    public void g() {
        Fragment fragmentF;
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f856c);
        }
        Fragment fragment = this.f856c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = fragment.f677u && !fragment.l1();
        if (z10) {
            Fragment fragment2 = this.f856c;
            if (!fragment2.f679w) {
                this.f855b.B(fragment2.f670n, null);
            }
        }
        if (!z10 && !this.f855b.p().v(this.f856c)) {
            String str = this.f856c.f673q;
            if (str != null && (fragmentF = this.f855b.f(str)) != null && fragmentF.L) {
                this.f856c.f672p = fragmentF;
            }
            this.f856c.f658e = 0;
            return;
        }
        w wVar = this.f856c.D;
        if (wVar instanceof androidx.lifecycle.c0) {
            zIsChangingConfigurations = this.f855b.p().s();
        } else if (wVar.r() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) wVar.r()).isChangingConfigurations();
        }
        if ((z10 && !this.f856c.f679w) || zIsChangingConfigurations) {
            this.f855b.p().k(this.f856c, false);
        }
        this.f856c.g2();
        this.f854a.d(this.f856c, false);
        for (j0 j0Var : this.f855b.k()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (this.f856c.f670n.equals(fragmentK.f673q)) {
                    fragmentK.f672p = this.f856c;
                    fragmentK.f673q = null;
                }
            }
        }
        Fragment fragment3 = this.f856c;
        String str2 = fragment3.f673q;
        if (str2 != null) {
            fragment3.f672p = this.f855b.f(str2);
        }
        this.f855b.s(this);
    }

    public void h() {
        View view;
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f856c);
        }
        Fragment fragment = this.f856c;
        ViewGroup viewGroup = fragment.Q;
        if (viewGroup != null && (view = fragment.R) != null) {
            viewGroup.removeView(view);
        }
        this.f856c.h2();
        this.f854a.n(this.f856c, false);
        Fragment fragment2 = this.f856c;
        fragment2.Q = null;
        fragment2.R = null;
        fragment2.f657d0 = null;
        fragment2.f659e0.m(null);
        this.f856c.f681y = false;
    }

    public void i() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f856c);
        }
        this.f856c.i2();
        this.f854a.e(this.f856c, false);
        Fragment fragment = this.f856c;
        fragment.f658e = -1;
        fragment.D = null;
        fragment.F = null;
        fragment.C = null;
        if ((!fragment.f677u || fragment.l1()) && !this.f855b.p().v(this.f856c)) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f856c);
        }
        this.f856c.g1();
    }

    public void j() {
        Fragment fragment = this.f856c;
        if (fragment.f680x && fragment.f681y && !fragment.A) {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f856c);
            }
            Bundle bundle = this.f856c.f664j;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.f856c;
            fragment2.f2(fragment2.j2(bundle2), null, bundle2);
            View view = this.f856c.R;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f856c;
                fragment3.R.setTag(d0.b.f4435a, fragment3);
                Fragment fragment4 = this.f856c;
                if (fragment4.J) {
                    fragment4.R.setVisibility(8);
                }
                this.f856c.w2();
                y yVar = this.f854a;
                Fragment fragment5 = this.f856c;
                yVar.m(fragment5, fragment5.R, bundle2, false);
                this.f856c.f658e = 2;
            }
        }
    }

    public Fragment k() {
        return this.f856c;
    }

    public final boolean l(View view) {
        if (view == this.f856c.R) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f856c.R) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f857d) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f857d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f856c;
                int i10 = fragment.f658e;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && fragment.f677u && !fragment.l1() && !this.f856c.f679w) {
                        if (FragmentManager.O0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f856c);
                        }
                        this.f855b.p().k(this.f856c, true);
                        this.f855b.s(this);
                        if (FragmentManager.O0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f856c);
                        }
                        this.f856c.g1();
                    }
                    Fragment fragment2 = this.f856c;
                    if (fragment2.X) {
                        if (fragment2.R != null && (viewGroup = fragment2.Q) != null) {
                            SpecialEffectsController specialEffectsControllerU = SpecialEffectsController.u(viewGroup, fragment2.N0());
                            if (this.f856c.J) {
                                specialEffectsControllerU.k(this);
                            } else {
                                specialEffectsControllerU.m(this);
                            }
                        }
                        Fragment fragment3 = this.f856c;
                        FragmentManager fragmentManager = fragment3.C;
                        if (fragmentManager != null) {
                            fragmentManager.M0(fragment3);
                        }
                        Fragment fragment4 = this.f856c;
                        fragment4.X = false;
                        fragment4.I1(fragment4.J);
                        this.f856c.E.N();
                    }
                    this.f857d = false;
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.f679w && this.f855b.q(fragment.f670n) == null) {
                                this.f855b.B(this.f856c.f670n, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f856c.f658e = 1;
                            break;
                        case 2:
                            fragment.f681y = false;
                            fragment.f658e = 2;
                            break;
                        case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                            if (FragmentManager.O0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f856c);
                            }
                            Fragment fragment5 = this.f856c;
                            if (fragment5.f679w) {
                                this.f855b.B(fragment5.f670n, r());
                            } else if (fragment5.R != null && fragment5.f666k == null) {
                                s();
                            }
                            Fragment fragment6 = this.f856c;
                            if (fragment6.R != null && (viewGroup2 = fragment6.Q) != null) {
                                SpecialEffectsController.u(viewGroup2, fragment6.N0()).l(this);
                            }
                            this.f856c.f658e = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.f658e = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                            a();
                            break;
                        case 4:
                            if (fragment.R != null && (viewGroup3 = fragment.Q) != null) {
                                SpecialEffectsController.u(viewGroup3, fragment.N0()).j(SpecialEffectsController.Operation.State.from(this.f856c.R.getVisibility()), this);
                            }
                            this.f856c.f658e = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.f658e = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th) {
            this.f857d = false;
            throw th;
        }
    }

    public void n() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f856c);
        }
        this.f856c.o2();
        this.f854a.f(this.f856c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f856c.f664j;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f856c.f664j.getBundle("savedInstanceState") == null) {
            this.f856c.f664j.putBundle("savedInstanceState", new Bundle());
        }
        try {
            Fragment fragment = this.f856c;
            fragment.f666k = fragment.f664j.getSparseParcelableArray("viewState");
            Fragment fragment2 = this.f856c;
            fragment2.f668l = fragment2.f664j.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) this.f856c.f664j.getParcelable("state");
            if (fragmentState != null) {
                Fragment fragment3 = this.f856c;
                fragment3.f673q = fragmentState.f789t;
                fragment3.f674r = fragmentState.f790u;
                Boolean bool = fragment3.f669m;
                if (bool != null) {
                    fragment3.T = bool.booleanValue();
                    this.f856c.f669m = null;
                } else {
                    fragment3.T = fragmentState.f791v;
                }
            }
            Fragment fragment4 = this.f856c;
            if (fragment4.T) {
                return;
            }
            fragment4.S = true;
        } catch (BadParcelableException e10) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e10);
        }
    }

    public void p() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f856c);
        }
        View viewH0 = this.f856c.H0();
        if (viewH0 != null && l(viewH0)) {
            boolean zRequestFocus = viewH0.requestFocus();
            if (FragmentManager.O0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(viewH0);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f856c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f856c.R.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f856c.I2(null);
        this.f856c.s2();
        this.f854a.i(this.f856c, false);
        this.f855b.B(this.f856c.f670n, null);
        Fragment fragment = this.f856c;
        fragment.f664j = null;
        fragment.f666k = null;
        fragment.f668l = null;
    }

    public Fragment.SavedState q() {
        if (this.f856c.f658e > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f856c;
        if (fragment.f658e == -1 && (bundle = fragment.f664j) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(this.f856c));
        if (this.f856c.f658e > -1) {
            Bundle bundle3 = new Bundle();
            this.f856c.t2(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f854a.j(this.f856c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f856c.f661g0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleT1 = this.f856c.E.t1();
            if (!bundleT1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleT1);
            }
            if (this.f856c.R != null) {
                s();
            }
            SparseArray<? extends Parcelable> sparseArray = this.f856c.f666k;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f856c.f668l;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f856c.f671o;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.f856c.R == null) {
            return;
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f856c + " with view " + this.f856c.R);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f856c.R.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f856c.f666k = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f856c.f657d0.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f856c.f668l = bundle;
    }

    public void t(int i10) {
        this.f858e = i10;
    }

    public void u() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f856c);
        }
        this.f856c.u2();
        this.f854a.k(this.f856c, false);
    }

    public void v() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f856c);
        }
        this.f856c.v2();
        this.f854a.l(this.f856c, false);
    }
}
