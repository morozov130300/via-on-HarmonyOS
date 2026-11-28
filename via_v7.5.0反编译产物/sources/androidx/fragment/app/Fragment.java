package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import n.e1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.j, androidx.lifecycle.e0, androidx.lifecycle.f, m0.d {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Object f556n0 = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public FragmentManager E;
    public w F;
    public Fragment H;
    public int I;
    public int J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean R;
    public ViewGroup S;
    public View T;
    public boolean U;
    public i W;
    public Handler X;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public LayoutInflater f557a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f558b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f560c0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f562e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public androidx.lifecycle.k f563e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public u0 f564f0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public androidx.lifecycle.a0.b f566h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public m0.c f567i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f568j0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SparseArray f571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bundle f573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f574o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bundle f576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Fragment f577r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f579t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f581v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f582w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f583x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f584y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f585z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f559c = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f575p = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f578s = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f580u = null;
    public FragmentManager G = new f0();
    public boolean Q = true;
    public boolean V = true;
    public Runnable Y = new b();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Lifecycle.State f561d0 = Lifecycle.State.RESUMED;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public androidx.lifecycle.n f565g0 = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final AtomicInteger f569k0 = new AtomicInteger();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final ArrayList f570l0 = new ArrayList();

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final j f572m0 = new c();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.activity.result.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f589b;

        public a(AtomicReference atomicReference, e.a aVar) {
            this.f588a = atomicReference;
            this.f589b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, n.b bVar) {
            androidx.activity.result.b bVar2 = (androidx.activity.result.b) this.f588a.get();
            if (bVar2 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            bVar2.b(obj, bVar);
        }

        @Override // androidx.activity.result.b
        public void c() {
            androidx.activity.result.b bVar = (androidx.activity.result.b) this.f588a.getAndSet(null);
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.R2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends j {
        public c() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.j
        public void a() {
            Fragment.this.f567i0.c();
            SavedStateHandleSupport.c(Fragment.this);
            Bundle bundle = Fragment.this.f562e;
            Fragment.this.f567i0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m0(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController f594c;

        public e(SpecialEffectsController specialEffectsController) {
            this.f594c = specialEffectsController;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f594c.w()) {
                this.f594c.n();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f extends s {
        public f() {
        }

        @Override // androidx.fragment.app.s
        public View l(int i10) {
            View view = Fragment.this.T;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.s
        public boolean o() {
            return Fragment.this.T != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements h.a {
        public g() {
        }

        @Override // h.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r10) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.F;
            return obj instanceof androidx.activity.result.c ? ((androidx.activity.result.c) obj).g() : fragment.i0().g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.a f598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.a f601d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(h.a aVar, AtomicReference atomicReference, e.a aVar2, androidx.activity.result.a aVar3) {
            super(null);
            this.f598a = aVar;
            this.f599b = atomicReference;
            this.f600c = aVar2;
            this.f601d = aVar3;
        }

        @Override // androidx.fragment.app.Fragment.j
        public void a() {
            String strR0 = Fragment.this.r0();
            this.f599b.set(((ActivityResultRegistry) this.f598a.apply(null)).i(strR0, Fragment.this, this.f600c, this.f601d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f610h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList f611i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f612j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f613k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f614l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f615m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f616n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f617o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f618p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f619q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f620r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View f621s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f622t;

        public i() {
            Object obj = Fragment.f556n0;
            this.f613k = obj;
            this.f614l = null;
            this.f615m = obj;
            this.f616n = null;
            this.f617o = obj;
            this.f620r = 1.0f;
            this.f621s = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class j {
        public j() {
        }

        public abstract void a();

        public /* synthetic */ j(b bVar) {
            this();
        }
    }

    public Fragment() {
        d1();
    }

    public static Fragment f1(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) v.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.F2(bundle);
            return fragment;
        } catch (IllegalAccessException e10) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (java.lang.InstantiationException e11) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    public static /* synthetic */ void l0(Fragment fragment) {
        fragment.f564f0.d(fragment.f573n);
        fragment.f573n = null;
    }

    public Object A0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        return iVar.f612j;
    }

    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10 = this.f568j0;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    public final View A2() {
        View viewA1 = a1();
        if (viewA1 != null) {
            return viewA1;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Override // androidx.lifecycle.e0
    public androidx.lifecycle.d0 B() {
        if (this.E == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (I0() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.E.J0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public e1 B0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void B1() {
        this.R = true;
    }

    public void B2() {
        Bundle bundle;
        Bundle bundle2 = this.f562e;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.G.s1(bundle);
        this.G.G();
    }

    public int C0() {
        i iVar = this.W;
        if (iVar == null) {
            return 0;
        }
        return iVar.f606d;
    }

    public final void C2() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.T != null) {
            Bundle bundle = this.f562e;
            D2(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.f562e = null;
    }

    public Object D0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        return iVar.f614l;
    }

    public void D1() {
        this.R = true;
    }

    public final void D2(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f571m;
        if (sparseArray != null) {
            this.T.restoreHierarchyState(sparseArray);
            this.f571m = null;
        }
        this.R = false;
        W1(bundle);
        if (this.R) {
            if (this.T != null) {
                this.f564f0.a(Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public e1 E0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void E1() {
        this.R = true;
    }

    public void E2(int i10, int i11, int i12, int i13) {
        if (this.W == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        p0().f605c = i10;
        p0().f606d = i11;
        p0().f607e = i12;
        p0().f608f = i13;
    }

    public View F0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        return iVar.f621s;
    }

    public LayoutInflater F1(Bundle bundle) {
        return H0(bundle);
    }

    public void F2(Bundle bundle) {
        if (this.E != null && n1()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f576q = bundle;
    }

    public final Context G() {
        Context contextY0 = y0();
        if (contextY0 != null) {
            return contextY0;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final Object G0() {
        w wVar = this.F;
        if (wVar == null) {
            return null;
        }
        return wVar.u();
    }

    public void G2(View view) {
        p0().f621s = view;
    }

    public LayoutInflater H0(Bundle bundle) {
        w wVar = this.F;
        if (wVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterV = wVar.v();
        y.f.b(layoutInflaterV, this.G.C0());
        return layoutInflaterV;
    }

    public void H1(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.R = true;
    }

    public void H2(SavedState savedState) {
        Bundle bundle;
        if (this.E != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f587c) == null) {
            bundle = null;
        }
        this.f562e = bundle;
    }

    public final int I0() {
        Lifecycle.State state = this.f561d0;
        return (state == Lifecycle.State.INITIALIZED || this.H == null) ? state.ordinal() : Math.min(state.ordinal(), this.H.I0());
    }

    public void I1(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.R = true;
        w wVar = this.F;
        Activity activityP = wVar == null ? null : wVar.p();
        if (activityP != null) {
            this.R = false;
            H1(activityP, attributeSet, bundle);
        }
    }

    public void I2(boolean z10) {
        if (this.Q != z10) {
            this.Q = z10;
            if (this.P && g1() && !i1()) {
                this.F.y();
            }
        }
    }

    public int J0() {
        i iVar = this.W;
        if (iVar == null) {
            return 0;
        }
        return iVar.f609g;
    }

    public void J2(int i10) {
        if (this.W == null && i10 == 0) {
            return;
        }
        p0();
        this.W.f609g = i10;
    }

    public final Fragment K0() {
        return this.H;
    }

    public boolean K1(MenuItem menuItem) {
        return false;
    }

    public void K2(boolean z10) {
        if (this.W == null) {
            return;
        }
        p0().f604b = z10;
    }

    public final FragmentManager L0() {
        FragmentManager fragmentManager = this.E;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void L2(float f10) {
        p0().f620r = f10;
    }

    public boolean M0() {
        i iVar = this.W;
        if (iVar == null) {
            return false;
        }
        return iVar.f604b;
    }

    public void M1() {
        this.R = true;
    }

    public void M2(ArrayList arrayList, ArrayList arrayList2) {
        p0();
        i iVar = this.W;
        iVar.f610h = arrayList;
        iVar.f611i = arrayList2;
    }

    public int N0() {
        i iVar = this.W;
        if (iVar == null) {
            return 0;
        }
        return iVar.f607e;
    }

    public void N2(Intent intent) {
        O2(intent, null);
    }

    public int O0() {
        i iVar = this.W;
        if (iVar == null) {
            return 0;
        }
        return iVar.f608f;
    }

    public void O2(Intent intent, Bundle bundle) {
        w wVar = this.F;
        if (wVar != null) {
            wVar.x(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public float P0() {
        i iVar = this.W;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f620r;
    }

    public void P2(Intent intent, int i10) {
        Q2(intent, i10, null);
    }

    @Override // m0.d
    public final androidx.savedstate.a Q() {
        return this.f567i0.b();
    }

    public Object Q0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f615m;
        return obj == f556n0 ? D0() : obj;
    }

    public void Q2(Intent intent, int i10, Bundle bundle) {
        if (this.F != null) {
            L0().X0(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final Resources R0() {
        return G().getResources();
    }

    public void R1() {
        this.R = true;
    }

    public void R2() {
        if (this.W == null || !p0().f622t) {
            return;
        }
        if (this.F == null) {
            p0().f622t = false;
        } else if (Looper.myLooper() != this.F.s().getLooper()) {
            this.F.s().postAtFrontOfQueue(new d());
        } else {
            m0(true);
        }
    }

    public Object S0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f613k;
        return obj == f556n0 ? A0() : obj;
    }

    public Object T0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        return iVar.f616n;
    }

    public void T1() {
        this.R = true;
    }

    public Object U0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f617o;
        return obj == f556n0 ? T0() : obj;
    }

    public void U1() {
        this.R = true;
    }

    public ArrayList V0() {
        ArrayList arrayList;
        i iVar = this.W;
        return (iVar == null || (arrayList = iVar.f610h) == null) ? new ArrayList() : arrayList;
    }

    public ArrayList W0() {
        ArrayList arrayList;
        i iVar = this.W;
        return (iVar == null || (arrayList = iVar.f611i) == null) ? new ArrayList() : arrayList;
    }

    public void W1(Bundle bundle) {
        this.R = true;
    }

    public final String X0(int i10) {
        return R0().getString(i10);
    }

    public void X1(Bundle bundle) {
        this.G.Z0();
        this.f559c = 3;
        this.R = false;
        q1(bundle);
        if (this.R) {
            C2();
            this.G.C();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public final String Y0(int i10, Object... objArr) {
        return R0().getString(i10, objArr);
    }

    public void Y1() {
        Iterator it = this.f570l0.iterator();
        while (it.hasNext()) {
            ((j) it.next()).a();
        }
        this.f570l0.clear();
        this.G.o(this.F, n0(), this);
        this.f559c = 0;
        this.R = false;
        t1(this.F.q());
        if (this.R) {
            this.E.M(this);
            this.G.D();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final Fragment Z0(boolean z10) {
        String str;
        if (z10) {
            FragmentStrictMode.h(this);
        }
        Fragment fragment = this.f577r;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.E;
        if (fragmentManager == null || (str = this.f578s) == null) {
            return null;
        }
        return fragmentManager.k0(str);
    }

    public void Z1(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public View a1() {
        return this.T;
    }

    public boolean a2(MenuItem menuItem) {
        if (this.L) {
            return false;
        }
        if (v1(menuItem)) {
            return true;
        }
        return this.G.F(menuItem);
    }

    public androidx.lifecycle.j b1() {
        u0 u0Var = this.f564f0;
        if (u0Var != null) {
            return u0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public void b2(Bundle bundle) {
        this.G.Z0();
        this.f559c = 1;
        this.R = false;
        this.f563e0.a(new androidx.lifecycle.h() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.h
            public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.T) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        w1(bundle);
        this.f558b0 = true;
        if (this.R) {
            this.f563e0.h(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public LiveData c1() {
        return this.f565g0;
    }

    public boolean c2(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.L) {
            return false;
        }
        if (this.P && this.Q) {
            z1(menu, menuInflater);
            z10 = true;
        }
        return this.G.H(menu, menuInflater) | z10;
    }

    public final void d1() {
        this.f563e0 = new androidx.lifecycle.k(this);
        this.f567i0 = m0.c.a(this);
        this.f566h0 = null;
        if (this.f570l0.contains(this.f572m0)) {
            return;
        }
        x2(this.f572m0);
    }

    public void d2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.G.Z0();
        this.C = true;
        this.f564f0 = new u0(this, B(), new Runnable() { // from class: androidx.fragment.app.l
            @Override // java.lang.Runnable
            public final void run() {
                Fragment.l0(this.f787c);
            }
        });
        View viewA1 = A1(layoutInflater, viewGroup, bundle);
        this.T = viewA1;
        if (viewA1 == null) {
            if (this.f564f0.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f564f0 = null;
            return;
        }
        this.f564f0.b();
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.T + " for Fragment " + this);
        }
        androidx.lifecycle.f0.a(this.T, this.f564f0);
        androidx.lifecycle.g0.a(this.T, this.f564f0);
        m0.e.a(this.T, this.f564f0);
        this.f565g0.m(this.f564f0);
    }

    public void e1() {
        d1();
        this.f560c0 = this.f575p;
        this.f575p = UUID.randomUUID().toString();
        this.f581v = false;
        this.f582w = false;
        this.f585z = false;
        this.A = false;
        this.B = false;
        this.D = 0;
        this.E = null;
        this.G = new f0();
        this.F = null;
        this.I = 0;
        this.J = 0;
        this.K = null;
        this.L = false;
        this.M = false;
    }

    public void e2() {
        this.G.I();
        this.f563e0.h(Lifecycle.Event.ON_DESTROY);
        this.f559c = 0;
        this.R = false;
        this.f558b0 = false;
        B1();
        if (this.R) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f2() {
        this.G.J();
        if (this.T != null && this.f564f0.h0().b().isAtLeast(Lifecycle.State.CREATED)) {
            this.f564f0.a(Lifecycle.Event.ON_DESTROY);
        }
        this.f559c = 1;
        this.R = false;
        D1();
        if (this.R) {
            j0.a.b(this).c();
            this.C = false;
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final boolean g1() {
        return this.F != null && this.f581v;
    }

    public void g2() {
        this.f559c = -1;
        this.R = false;
        E1();
        this.f557a0 = null;
        if (this.R) {
            if (this.G.N0()) {
                return;
            }
            this.G.I();
            this.G = new f0();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @Override // androidx.lifecycle.j
    public Lifecycle h0() {
        return this.f563e0;
    }

    public final boolean h1() {
        return this.M;
    }

    public LayoutInflater h2(Bundle bundle) {
        LayoutInflater layoutInflaterF1 = F1(bundle);
        this.f557a0 = layoutInflaterF1;
        return layoutInflaterF1;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final q i0() {
        q qVarS0 = s0();
        if (qVarS0 != null) {
            return qVarS0;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final boolean i1() {
        if (this.L) {
            return true;
        }
        FragmentManager fragmentManager = this.E;
        return fragmentManager != null && fragmentManager.R0(this.H);
    }

    public void i2() {
        onLowMemory();
    }

    public final boolean j1() {
        return this.D > 0;
    }

    public void j2(boolean z10) {
        J1(z10);
    }

    public final boolean k1() {
        if (!this.Q) {
            return false;
        }
        FragmentManager fragmentManager = this.E;
        return fragmentManager == null || fragmentManager.S0(this.H);
    }

    public boolean k2(MenuItem menuItem) {
        if (this.L) {
            return false;
        }
        if (this.P && this.Q && K1(menuItem)) {
            return true;
        }
        return this.G.O(menuItem);
    }

    public boolean l1() {
        i iVar = this.W;
        if (iVar == null) {
            return false;
        }
        return iVar.f622t;
    }

    public void l2(Menu menu) {
        if (this.L) {
            return;
        }
        if (this.P && this.Q) {
            L1(menu);
        }
        this.G.P(menu);
    }

    public void m0(boolean z10) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.W;
        if (iVar != null) {
            iVar.f622t = false;
        }
        if (this.T == null || (viewGroup = this.S) == null || (fragmentManager = this.E) == null) {
            return;
        }
        SpecialEffectsController specialEffectsControllerU = SpecialEffectsController.u(viewGroup, fragmentManager);
        specialEffectsControllerU.x();
        if (z10) {
            this.F.s().post(new e(specialEffectsControllerU));
        } else {
            specialEffectsControllerU.n();
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacks(this.Y);
            this.X = null;
        }
    }

    public final boolean m1() {
        return this.f559c >= 7;
    }

    public void m2() {
        this.G.R();
        if (this.T != null) {
            this.f564f0.a(Lifecycle.Event.ON_PAUSE);
        }
        this.f563e0.h(Lifecycle.Event.ON_PAUSE);
        this.f559c = 6;
        this.R = false;
        M1();
        if (this.R) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public s n0() {
        return new f();
    }

    public final boolean n1() {
        FragmentManager fragmentManager = this.E;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.V0();
    }

    public void n2(boolean z10) {
        N1(z10);
    }

    public void o0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.I));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.J));
        printWriter.print(" mTag=");
        printWriter.println(this.K);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f559c);
        printWriter.print(" mWho=");
        printWriter.print(this.f575p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f581v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f582w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f585z);
        printWriter.print(" mInLayout=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.L);
        printWriter.print(" mDetached=");
        printWriter.print(this.M);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.Q);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.P);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.N);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.E);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.F);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.H);
        }
        if (this.f576q != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f576q);
        }
        if (this.f562e != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f562e);
        }
        if (this.f571m != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f571m);
        }
        if (this.f573n != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f573n);
        }
        Fragment fragmentZ0 = Z0(false);
        if (fragmentZ0 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentZ0);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f579t);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(M0());
        if (z0() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(z0());
        }
        if (C0() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(C0());
        }
        if (N0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(N0());
        }
        if (O0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(O0());
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.S);
        }
        if (this.T != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.T);
        }
        if (v0() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(v0());
        }
        if (y0() != null) {
            j0.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.G + ":");
        this.G.b0(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean o1() {
        View view;
        return (!g1() || i1() || (view = this.T) == null || view.getWindowToken() == null || this.T.getVisibility() != 0) ? false : true;
    }

    public boolean o2(Menu menu) {
        boolean z10 = false;
        if (this.L) {
            return false;
        }
        if (this.P && this.Q) {
            O1(menu);
            z10 = true;
        }
        return this.G.T(menu) | z10;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.R = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        i0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.R = true;
    }

    public final i p0() {
        if (this.W == null) {
            this.W = new i();
        }
        return this.W;
    }

    public void p1() {
        this.G.Z0();
    }

    public void p2() {
        boolean zT0 = this.E.T0(this);
        Boolean bool = this.f580u;
        if (bool == null || bool.booleanValue() != zT0) {
            this.f580u = Boolean.valueOf(zT0);
            P1(zT0);
            this.G.U();
        }
    }

    public Fragment q0(String str) {
        return str.equals(this.f575p) ? this : this.G.o0(str);
    }

    public void q1(Bundle bundle) {
        this.R = true;
    }

    public void q2() {
        this.G.Z0();
        this.G.f0(true);
        this.f559c = 7;
        this.R = false;
        R1();
        if (!this.R) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.k kVar = this.f563e0;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        kVar.h(event);
        if (this.T != null) {
            this.f564f0.a(event);
        }
        this.G.V();
    }

    public String r0() {
        return "fragment_" + this.f575p + "_rq#" + this.f569k0.getAndIncrement();
    }

    public void r1(int i10, int i11, Intent intent) {
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    public void r2(Bundle bundle) {
        S1(bundle);
    }

    public final q s0() {
        w wVar = this.F;
        if (wVar == null) {
            return null;
        }
        return (q) wVar.p();
    }

    public void s1(Activity activity) {
        this.R = true;
    }

    public void s2() {
        this.G.Z0();
        this.G.f0(true);
        this.f559c = 5;
        this.R = false;
        T1();
        if (!this.R) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.k kVar = this.f563e0;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        kVar.h(event);
        if (this.T != null) {
            this.f564f0.a(event);
        }
        this.G.W();
    }

    public boolean t0() {
        Boolean bool;
        i iVar = this.W;
        if (iVar == null || (bool = iVar.f619q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void t1(Context context) {
        this.R = true;
        w wVar = this.F;
        Activity activityP = wVar == null ? null : wVar.p();
        if (activityP != null) {
            this.R = false;
            s1(activityP);
        }
    }

    public void t2() {
        this.G.Y();
        if (this.T != null) {
            this.f564f0.a(Lifecycle.Event.ON_STOP);
        }
        this.f563e0.h(Lifecycle.Event.ON_STOP);
        this.f559c = 4;
        this.R = false;
        U1();
        if (this.R) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.f575p);
        if (this.I != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.I));
        }
        if (this.K != null) {
            sb2.append(" tag=");
            sb2.append(this.K);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public boolean u0() {
        Boolean bool;
        i iVar = this.W;
        if (iVar == null || (bool = iVar.f618p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void u2() {
        Bundle bundle = this.f562e;
        V1(this.T, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.G.Z();
    }

    @Override // androidx.lifecycle.f
    public androidx.lifecycle.a0.b v() {
        Application application;
        if (this.E == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f566h0 == null) {
            Context applicationContext = G().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.O0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + G().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f566h0 = new androidx.lifecycle.x(application, this, w0());
        }
        return this.f566h0;
    }

    public View v0() {
        i iVar = this.W;
        if (iVar == null) {
            return null;
        }
        return iVar.f603a;
    }

    public boolean v1(MenuItem menuItem) {
        return false;
    }

    public final androidx.activity.result.b v2(e.a aVar, h.a aVar2, androidx.activity.result.a aVar3) {
        if (this.f559c <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            x2(new h(aVar2, atomicReference, aVar, aVar3));
            return new a(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    @Override // androidx.lifecycle.f
    public i0.a w() {
        Application application;
        Context applicationContext = G().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + G().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        i0.d dVar = new i0.d();
        if (application != null) {
            dVar.c(androidx.lifecycle.a0.a.f943g, application);
        }
        dVar.c(SavedStateHandleSupport.f930a, this);
        dVar.c(SavedStateHandleSupport.f931b, this);
        if (w0() != null) {
            dVar.c(SavedStateHandleSupport.f932c, w0());
        }
        return dVar;
    }

    public final Bundle w0() {
        return this.f576q;
    }

    public void w1(Bundle bundle) {
        this.R = true;
        B2();
        if (this.G.U0(1)) {
            return;
        }
        this.G.G();
    }

    public final androidx.activity.result.b w2(e.a aVar, androidx.activity.result.a aVar2) {
        return v2(aVar, new g(), aVar2);
    }

    public final FragmentManager x0() {
        if (this.F != null) {
            return this.G;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Animation x1(int i10, boolean z10, int i11) {
        return null;
    }

    public final void x2(j jVar) {
        if (this.f559c >= 0) {
            jVar.a();
        } else {
            this.f570l0.add(jVar);
        }
    }

    public Context y0() {
        w wVar = this.F;
        if (wVar == null) {
            return null;
        }
        return wVar.q();
    }

    public Animator y1(int i10, boolean z10, int i11) {
        return null;
    }

    public final void y2(String[] strArr, int i10) {
        if (this.F != null) {
            L0().W0(this, strArr, i10);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public int z0() {
        i iVar = this.W;
        if (iVar == null) {
            return 0;
        }
        return iVar.f605c;
    }

    public final Fragment z2() {
        Fragment fragmentK0 = K0();
        if (fragmentK0 != null) {
            return fragmentK0;
        }
        if (y0() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + y0());
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f587c;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Bundle bundle) {
            this.f587c = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeBundle(this.f587c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f587c = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    public void C1() {
    }

    public void G1(boolean z10) {
    }

    public void J1(boolean z10) {
    }

    public void L1(Menu menu) {
    }

    public void N1(boolean z10) {
    }

    public void O1(Menu menu) {
    }

    public void P1(boolean z10) {
    }

    public void S1(Bundle bundle) {
    }

    public void u1(Fragment fragment) {
    }

    public void V1(View view, Bundle bundle) {
    }

    public void z1(Menu menu, MenuInflater menuInflater) {
    }

    public void Q1(int i10, String[] strArr, int[] iArr) {
    }
}
