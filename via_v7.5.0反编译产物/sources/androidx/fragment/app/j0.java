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
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f760d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f761e = -1;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f764a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f764a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f764a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f764a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f764a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public j0(y yVar, k0 k0Var, Fragment fragment) {
        this.f757a = yVar;
        this.f758b = k0Var;
        this.f759c = fragment;
    }

    public void a() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f759c);
        }
        Bundle bundle = this.f759c.f562e;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f759c.X1(bundle2);
        this.f757a.a(this.f759c, bundle2, false);
    }

    public void b() {
        Fragment fragmentQ0 = FragmentManager.q0(this.f759c.S);
        Fragment fragmentK0 = this.f759c.K0();
        if (fragmentQ0 != null && !fragmentQ0.equals(fragmentK0)) {
            Fragment fragment = this.f759c;
            FragmentStrictMode.j(fragment, fragmentQ0, fragment.J);
        }
        int iJ = this.f758b.j(this.f759c);
        Fragment fragment2 = this.f759c;
        fragment2.S.addView(fragment2.T, iJ);
    }

    public void c() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f759c);
        }
        Fragment fragment = this.f759c;
        Fragment fragment2 = fragment.f577r;
        j0 j0VarN = null;
        if (fragment2 != null) {
            j0 j0VarN2 = this.f758b.n(fragment2.f575p);
            if (j0VarN2 == null) {
                throw new IllegalStateException("Fragment " + this.f759c + " declared target fragment " + this.f759c.f577r + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f759c;
            fragment3.f578s = fragment3.f577r.f575p;
            fragment3.f577r = null;
            j0VarN = j0VarN2;
        } else {
            String str = fragment.f578s;
            if (str != null && (j0VarN = this.f758b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f759c + " declared target fragment " + this.f759c.f578s + " that does not belong to this FragmentManager!");
            }
        }
        if (j0VarN != null) {
            j0VarN.m();
        }
        Fragment fragment4 = this.f759c;
        fragment4.F = fragment4.E.B0();
        Fragment fragment5 = this.f759c;
        fragment5.H = fragment5.E.E0();
        this.f757a.g(this.f759c, false);
        this.f759c.Y1();
        this.f757a.b(this.f759c, false);
    }

    public int d() {
        Fragment fragment = this.f759c;
        if (fragment.E == null) {
            return fragment.f559c;
        }
        int iMin = this.f761e;
        int i10 = b.f764a[fragment.f561d0.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i10 != 3) {
                iMin = i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        Fragment fragment2 = this.f759c;
        if (fragment2.f585z) {
            if (fragment2.A) {
                iMin = Math.max(this.f761e, 2);
                View view = this.f759c.T;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f761e < 4 ? Math.min(iMin, fragment2.f559c) : Math.min(iMin, 1);
            }
        }
        if (!this.f759c.f581v) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f759c;
        ViewGroup viewGroup = fragment3.S;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactS = viewGroup != null ? SpecialEffectsController.u(viewGroup, fragment3.L0()).s(this) : null;
        if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactS == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f759c;
            if (fragment4.f582w) {
                iMin = fragment4.j1() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f759c;
        if (fragment5.U && fragment5.f559c < 5) {
            iMin = Math.min(iMin, 4);
        }
        Fragment fragment6 = this.f759c;
        if (fragment6.f583x && fragment6.S != null) {
            iMin = Math.max(iMin, 3);
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f759c);
        }
        return iMin;
    }

    public void e() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f759c);
        }
        Bundle bundle = this.f759c.f562e;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.f759c;
        if (fragment.f558b0) {
            fragment.f559c = 1;
            fragment.B2();
        } else {
            this.f757a.h(fragment, bundle2, false);
            this.f759c.b2(bundle2);
            this.f757a.c(this.f759c, bundle2, false);
        }
    }

    public void f() {
        String resourceName;
        if (this.f759c.f585z) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f759c);
        }
        Bundle bundle = this.f759c.f562e;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterH2 = this.f759c.h2(bundle2);
        Fragment fragment = this.f759c;
        ViewGroup viewGroup2 = fragment.S;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = fragment.J;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f759c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.E.w0().l(this.f759c.J);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f759c;
                    if (!fragment2.B) {
                        try {
                            resourceName = fragment2.R0().getResourceName(this.f759c.J);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f759c.J) + " (" + resourceName + ") for fragment " + this.f759c);
                    }
                } else if (!(viewGroup instanceof t)) {
                    FragmentStrictMode.i(this.f759c, viewGroup);
                }
            }
        }
        Fragment fragment3 = this.f759c;
        fragment3.S = viewGroup;
        fragment3.d2(layoutInflaterH2, viewGroup, bundle2);
        if (this.f759c.T != null) {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f759c);
            }
            this.f759c.T.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f759c;
            fragment4.T.setTag(e0.b.f4067a, fragment4);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment5 = this.f759c;
            if (fragment5.L) {
                fragment5.T.setVisibility(8);
            }
            if (this.f759c.T.isAttachedToWindow()) {
                y.r.V(this.f759c.T);
            } else {
                View view = this.f759c.T;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f759c.u2();
            y yVar = this.f757a;
            Fragment fragment6 = this.f759c;
            yVar.m(fragment6, fragment6.T, bundle2, false);
            int visibility = this.f759c.T.getVisibility();
            this.f759c.L2(this.f759c.T.getAlpha());
            Fragment fragment7 = this.f759c;
            if (fragment7.S != null && visibility == 0) {
                View viewFindFocus = fragment7.T.findFocus();
                if (viewFindFocus != null) {
                    this.f759c.G2(viewFindFocus);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f759c);
                    }
                }
                this.f759c.T.setAlpha(0.0f);
            }
        }
        this.f759c.f559c = 2;
    }

    public void g() {
        Fragment fragmentF;
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f759c);
        }
        Fragment fragment = this.f759c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = fragment.f582w && !fragment.j1();
        if (z10) {
            Fragment fragment2 = this.f759c;
            if (!fragment2.f584y) {
                this.f758b.B(fragment2.f575p, null);
            }
        }
        if (!z10 && !this.f758b.p().v(this.f759c)) {
            String str = this.f759c.f578s;
            if (str != null && (fragmentF = this.f758b.f(str)) != null && fragmentF.N) {
                this.f759c.f577r = fragmentF;
            }
            this.f759c.f559c = 0;
            return;
        }
        w wVar = this.f759c.F;
        if (wVar instanceof androidx.lifecycle.e0) {
            zIsChangingConfigurations = this.f758b.p().s();
        } else if (wVar.q() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) wVar.q()).isChangingConfigurations();
        }
        if ((z10 && !this.f759c.f584y) || zIsChangingConfigurations) {
            this.f758b.p().k(this.f759c, false);
        }
        this.f759c.e2();
        this.f757a.d(this.f759c, false);
        for (j0 j0Var : this.f758b.k()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (this.f759c.f575p.equals(fragmentK.f578s)) {
                    fragmentK.f577r = this.f759c;
                    fragmentK.f578s = null;
                }
            }
        }
        Fragment fragment3 = this.f759c;
        String str2 = fragment3.f578s;
        if (str2 != null) {
            fragment3.f577r = this.f758b.f(str2);
        }
        this.f758b.s(this);
    }

    public void h() {
        View view;
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f759c);
        }
        Fragment fragment = this.f759c;
        ViewGroup viewGroup = fragment.S;
        if (viewGroup != null && (view = fragment.T) != null) {
            viewGroup.removeView(view);
        }
        this.f759c.f2();
        this.f757a.n(this.f759c, false);
        Fragment fragment2 = this.f759c;
        fragment2.S = null;
        fragment2.T = null;
        fragment2.f564f0 = null;
        fragment2.f565g0.m(null);
        this.f759c.A = false;
    }

    public void i() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f759c);
        }
        this.f759c.g2();
        this.f757a.e(this.f759c, false);
        Fragment fragment = this.f759c;
        fragment.f559c = -1;
        fragment.F = null;
        fragment.H = null;
        fragment.E = null;
        if ((!fragment.f582w || fragment.j1()) && !this.f758b.p().v(this.f759c)) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f759c);
        }
        this.f759c.e1();
    }

    public void j() {
        Fragment fragment = this.f759c;
        if (fragment.f585z && fragment.A && !fragment.C) {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f759c);
            }
            Bundle bundle = this.f759c.f562e;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.f759c;
            fragment2.d2(fragment2.h2(bundle2), null, bundle2);
            View view = this.f759c.T;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f759c;
                fragment3.T.setTag(e0.b.f4067a, fragment3);
                Fragment fragment4 = this.f759c;
                if (fragment4.L) {
                    fragment4.T.setVisibility(8);
                }
                this.f759c.u2();
                y yVar = this.f757a;
                Fragment fragment5 = this.f759c;
                yVar.m(fragment5, fragment5.T, bundle2, false);
                this.f759c.f559c = 2;
            }
        }
    }

    public Fragment k() {
        return this.f759c;
    }

    public final boolean l(View view) {
        if (view == this.f759c.T) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f759c.T) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f760d) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f760d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f759c;
                int i10 = fragment.f559c;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && fragment.f582w && !fragment.j1() && !this.f759c.f584y) {
                        if (FragmentManager.O0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f759c);
                        }
                        this.f758b.p().k(this.f759c, true);
                        this.f758b.s(this);
                        if (FragmentManager.O0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f759c);
                        }
                        this.f759c.e1();
                    }
                    Fragment fragment2 = this.f759c;
                    if (fragment2.Z) {
                        if (fragment2.T != null && (viewGroup = fragment2.S) != null) {
                            SpecialEffectsController specialEffectsControllerU = SpecialEffectsController.u(viewGroup, fragment2.L0());
                            if (this.f759c.L) {
                                specialEffectsControllerU.k(this);
                            } else {
                                specialEffectsControllerU.m(this);
                            }
                        }
                        Fragment fragment3 = this.f759c;
                        FragmentManager fragmentManager = fragment3.E;
                        if (fragmentManager != null) {
                            fragmentManager.M0(fragment3);
                        }
                        Fragment fragment4 = this.f759c;
                        fragment4.Z = false;
                        fragment4.G1(fragment4.L);
                        this.f759c.G.N();
                    }
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                            i();
                            break;
                        case 0:
                            if (fragment.f584y && this.f758b.q(fragment.f575p) == null) {
                                this.f758b.B(this.f759c.f575p, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f759c.f559c = 1;
                            break;
                        case 2:
                            fragment.A = false;
                            fragment.f559c = 2;
                            break;
                        case 3:
                            if (FragmentManager.O0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f759c);
                            }
                            Fragment fragment5 = this.f759c;
                            if (fragment5.f584y) {
                                this.f758b.B(fragment5.f575p, r());
                            } else if (fragment5.T != null && fragment5.f571m == null) {
                                s();
                            }
                            Fragment fragment6 = this.f759c;
                            if (fragment6.T != null && (viewGroup2 = fragment6.S) != null) {
                                SpecialEffectsController.u(viewGroup2, fragment6.L0()).l(this);
                            }
                            this.f759c.f559c = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.f559c = 5;
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
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.T != null && (viewGroup3 = fragment.S) != null) {
                                SpecialEffectsController.u(viewGroup3, fragment.L0()).j(SpecialEffectsController.Operation.State.from(this.f759c.T.getVisibility()), this);
                            }
                            this.f759c.f559c = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.f559c = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } finally {
            this.f760d = false;
        }
    }

    public void n() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f759c);
        }
        this.f759c.m2();
        this.f757a.f(this.f759c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f759c.f562e;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f759c.f562e.getBundle("savedInstanceState") == null) {
            this.f759c.f562e.putBundle("savedInstanceState", new Bundle());
        }
        try {
            Fragment fragment = this.f759c;
            fragment.f571m = fragment.f562e.getSparseParcelableArray("viewState");
            Fragment fragment2 = this.f759c;
            fragment2.f573n = fragment2.f562e.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) this.f759c.f562e.getParcelable("state");
            if (fragmentState != null) {
                Fragment fragment3 = this.f759c;
                fragment3.f578s = fragmentState.f692v;
                fragment3.f579t = fragmentState.f693w;
                Boolean bool = fragment3.f574o;
                if (bool != null) {
                    fragment3.V = bool.booleanValue();
                    this.f759c.f574o = null;
                } else {
                    fragment3.V = fragmentState.f694x;
                }
            }
            Fragment fragment4 = this.f759c;
            if (fragment4.V) {
                return;
            }
            fragment4.U = true;
        } catch (BadParcelableException e10) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e10);
        }
    }

    public void p() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f759c);
        }
        View viewF0 = this.f759c.F0();
        if (viewF0 != null && l(viewF0)) {
            boolean zRequestFocus = viewF0.requestFocus();
            if (FragmentManager.O0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(viewF0);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f759c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f759c.T.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f759c.G2(null);
        this.f759c.q2();
        this.f757a.i(this.f759c, false);
        this.f758b.B(this.f759c.f575p, null);
        Fragment fragment = this.f759c;
        fragment.f562e = null;
        fragment.f571m = null;
        fragment.f573n = null;
    }

    public Fragment.SavedState q() {
        if (this.f759c.f559c > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f759c;
        if (fragment.f559c == -1 && (bundle = fragment.f562e) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(this.f759c));
        if (this.f759c.f559c > -1) {
            Bundle bundle3 = new Bundle();
            this.f759c.r2(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f757a.j(this.f759c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f759c.f567i0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleU1 = this.f759c.G.u1();
            if (!bundleU1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleU1);
            }
            if (this.f759c.T != null) {
                s();
            }
            SparseArray<? extends Parcelable> sparseArray = this.f759c.f571m;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f759c.f573n;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f759c.f576q;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.f759c.T == null) {
            return;
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f759c + " with view " + this.f759c.T);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f759c.T.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f759c.f571m = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f759c.f564f0.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f759c.f573n = bundle;
    }

    public void t(int i10) {
        this.f761e = i10;
    }

    public void u() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f759c);
        }
        this.f759c.s2();
        this.f757a.k(this.f759c, false);
    }

    public void v() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f759c);
        }
        this.f759c.t2();
        this.f757a.l(this.f759c, false);
    }

    public j0(y yVar, k0 k0Var, ClassLoader classLoader, v vVar, Bundle bundle) {
        this.f757a = yVar;
        this.f758b = k0Var;
        Fragment fragmentA = ((FragmentState) bundle.getParcelable("state")).a(vVar, classLoader);
        this.f759c = fragmentA;
        fragmentA.f562e = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        fragmentA.F2(bundle2);
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    public j0(y yVar, k0 k0Var, Fragment fragment, Bundle bundle) {
        this.f757a = yVar;
        this.f758b = k0Var;
        this.f759c = fragment;
        fragment.f571m = null;
        fragment.f573n = null;
        fragment.D = 0;
        fragment.A = false;
        fragment.f581v = false;
        Fragment fragment2 = fragment.f577r;
        fragment.f578s = fragment2 != null ? fragment2.f575p : null;
        fragment.f577r = null;
        fragment.f562e = bundle;
        fragment.f576q = bundle.getBundle("arguments");
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f762c;

        public a(View view) {
            this.f762c = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f762c.removeOnAttachStateChangeListener(this);
            y.r.V(this.f762c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
