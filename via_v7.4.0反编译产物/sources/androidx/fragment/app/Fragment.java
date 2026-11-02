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
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import n.e1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.h, androidx.lifecycle.c0, androidx.lifecycle.d, l0.d {

    /* renamed from: l0, reason: collision with root package name */
    public static final Object f653l0 = new Object();
    public boolean A;
    public int B;
    public FragmentManager C;
    public w D;
    public Fragment F;
    public int G;
    public int H;
    public String I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean P;
    public ViewGroup Q;
    public View R;
    public boolean S;
    public i U;
    public Handler V;
    public boolean X;
    public LayoutInflater Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f654a0;

    /* renamed from: c0, reason: collision with root package name */
    public androidx.lifecycle.i f656c0;

    /* renamed from: d0, reason: collision with root package name */
    public u0 f657d0;

    /* renamed from: f0, reason: collision with root package name */
    public y.b f660f0;

    /* renamed from: g0, reason: collision with root package name */
    public l0.c f661g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f662h0;

    /* renamed from: j, reason: collision with root package name */
    public Bundle f664j;

    /* renamed from: k, reason: collision with root package name */
    public SparseArray f666k;

    /* renamed from: l, reason: collision with root package name */
    public Bundle f668l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f669m;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f671o;

    /* renamed from: p, reason: collision with root package name */
    public Fragment f672p;

    /* renamed from: r, reason: collision with root package name */
    public int f674r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f676t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f677u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f678v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f679w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f680x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f681y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f682z;

    /* renamed from: e, reason: collision with root package name */
    public int f658e = -1;

    /* renamed from: n, reason: collision with root package name */
    public String f670n = UUID.randomUUID().toString();

    /* renamed from: q, reason: collision with root package name */
    public String f673q = null;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f675s = null;
    public FragmentManager E = new f0();
    public boolean O = true;
    public boolean T = true;
    public Runnable W = new b();

    /* renamed from: b0, reason: collision with root package name */
    public Lifecycle.State f655b0 = Lifecycle.State.RESUMED;

    /* renamed from: e0, reason: collision with root package name */
    public androidx.lifecycle.l f659e0 = new androidx.lifecycle.l();

    /* renamed from: i0, reason: collision with root package name */
    public final AtomicInteger f663i0 = new AtomicInteger();

    /* renamed from: j0, reason: collision with root package name */
    public final ArrayList f665j0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    public final j f667k0 = new c();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f684e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Bundle bundle) {
            this.f684e = bundle;
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f684e = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeBundle(this.f684e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends androidx.activity.result.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f685a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f686b;

        public a(AtomicReference atomicReference, e.a aVar) {
            this.f685a = atomicReference;
            this.f686b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, n.b bVar) {
            androidx.activity.result.b bVar2 = (androidx.activity.result.b) this.f685a.get();
            if (bVar2 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            bVar2.b(obj, bVar);
        }

        @Override // androidx.activity.result.b
        public void c() {
            androidx.activity.result.b bVar = (androidx.activity.result.b) this.f685a.getAndSet(null);
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.T2();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends j {
        public c() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.j
        public void a() {
            Fragment.this.f661g0.c();
            SavedStateHandleSupport.c(Fragment.this);
            Bundle bundle = Fragment.this.f664j;
            Fragment.this.f661g0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.o0(false);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController f691e;

        public e(SpecialEffectsController specialEffectsController) {
            this.f691e = specialEffectsController;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f691e.w()) {
                this.f691e.n();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f extends s {
        public f() {
        }

        @Override // androidx.fragment.app.s
        public View j(int i10) {
            View view = Fragment.this.R;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.s
        public boolean p() {
            return Fragment.this.R != null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements h.a {
        public g() {
        }

        @Override // h.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r32) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.D;
            return obj instanceof androidx.activity.result.c ? ((androidx.activity.result.c) obj).f() : fragment.l0().f();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h extends j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.a f695a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f696b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f697c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.a f698d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(h.a aVar, AtomicReference atomicReference, e.a aVar2, androidx.activity.result.a aVar3) {
            super(null);
            this.f695a = aVar;
            this.f696b = atomicReference;
            this.f697c = aVar2;
            this.f698d = aVar3;
        }

        @Override // androidx.fragment.app.Fragment.j
        public void a() {
            String strT0 = Fragment.this.t0();
            this.f696b.set(((ActivityResultRegistry) this.f695a.apply(null)).i(strT0, Fragment.this, this.f697c, this.f698d));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public View f700a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f701b;

        /* renamed from: c, reason: collision with root package name */
        public int f702c;

        /* renamed from: d, reason: collision with root package name */
        public int f703d;

        /* renamed from: e, reason: collision with root package name */
        public int f704e;

        /* renamed from: f, reason: collision with root package name */
        public int f705f;

        /* renamed from: g, reason: collision with root package name */
        public int f706g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList f707h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList f708i;

        /* renamed from: j, reason: collision with root package name */
        public Object f709j = null;

        /* renamed from: k, reason: collision with root package name */
        public Object f710k;

        /* renamed from: l, reason: collision with root package name */
        public Object f711l;

        /* renamed from: m, reason: collision with root package name */
        public Object f712m;

        /* renamed from: n, reason: collision with root package name */
        public Object f713n;

        /* renamed from: o, reason: collision with root package name */
        public Object f714o;

        /* renamed from: p, reason: collision with root package name */
        public Boolean f715p;

        /* renamed from: q, reason: collision with root package name */
        public Boolean f716q;

        /* renamed from: r, reason: collision with root package name */
        public float f717r;

        /* renamed from: s, reason: collision with root package name */
        public View f718s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f719t;

        public i() {
            Object obj = Fragment.f653l0;
            this.f710k = obj;
            this.f711l = null;
            this.f712m = obj;
            this.f713n = null;
            this.f714o = obj;
            this.f717r = 1.0f;
            this.f718s = null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class j {
        public j() {
        }

        public /* synthetic */ j(b bVar) {
            this();
        }

        public abstract void a();
    }

    public Fragment() {
        f1();
    }

    public static Fragment h1(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) v.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.H2(bundle);
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

    public static /* synthetic */ void n0(Fragment fragment) {
        fragment.f657d0.d(fragment.f668l);
        fragment.f668l = null;
    }

    public Context A0() {
        w wVar = this.D;
        if (wVar == null) {
            return null;
        }
        return wVar.r();
    }

    public Animator A1(int i10, boolean z10, int i11) {
        return null;
    }

    public final void A2(String[] strArr, int i10) {
        if (this.D != null) {
            N0().W0(this, strArr, i10);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public int B0() {
        i iVar = this.U;
        if (iVar == null) {
            return 0;
        }
        return iVar.f702c;
    }

    public void B1(Menu menu, MenuInflater menuInflater) {
    }

    public final Fragment B2() {
        Fragment fragmentM0 = M0();
        if (fragmentM0 != null) {
            return fragmentM0;
        }
        if (A0() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + A0());
    }

    public Object C0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        return iVar.f709j;
    }

    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10 = this.f662h0;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    public final View C2() {
        View viewC1 = c1();
        if (viewC1 != null) {
            return viewC1;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Override // androidx.lifecycle.c0
    public androidx.lifecycle.b0 D() {
        if (this.C == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (K0() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.C.J0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public e1 D0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void D1() {
        this.P = true;
    }

    public void D2() {
        Bundle bundle;
        Bundle bundle2 = this.f664j;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.E.r1(bundle);
        this.E.G();
    }

    public int E0() {
        i iVar = this.U;
        if (iVar == null) {
            return 0;
        }
        return iVar.f703d;
    }

    public void E1() {
    }

    public final void E2() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.R != null) {
            Bundle bundle = this.f664j;
            F2(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.f664j = null;
    }

    public Object F0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        return iVar.f711l;
    }

    public void F1() {
        this.P = true;
    }

    public final void F2(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f666k;
        if (sparseArray != null) {
            this.R.restoreHierarchyState(sparseArray);
            this.f666k = null;
        }
        this.P = false;
        Y1(bundle);
        if (this.P) {
            if (this.R != null) {
                this.f657d0.a(Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public e1 G0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    public void G1() {
        this.P = true;
    }

    public void G2(int i10, int i11, int i12, int i13) {
        if (this.U == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        r0().f702c = i10;
        r0().f703d = i11;
        r0().f704e = i12;
        r0().f705f = i13;
    }

    public View H0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        return iVar.f718s;
    }

    public LayoutInflater H1(Bundle bundle) {
        return J0(bundle);
    }

    public void H2(Bundle bundle) {
        if (this.C != null && p1()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f671o = bundle;
    }

    public final Context I() {
        Context contextA0 = A0();
        if (contextA0 != null) {
            return contextA0;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final Object I0() {
        w wVar = this.D;
        if (wVar == null) {
            return null;
        }
        return wVar.v();
    }

    public void I1(boolean z10) {
    }

    public void I2(View view) {
        r0().f718s = view;
    }

    public LayoutInflater J0(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        w wVar = this.D;
        if (wVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterW = wVar.w();
        x.f.b(layoutInflaterW, this.E.C0());
        return layoutInflaterW;
    }

    public void J1(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
    }

    public void J2(SavedState savedState) {
        Bundle bundle;
        if (this.C != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f684e) == null) {
            bundle = null;
        }
        this.f664j = bundle;
    }

    public final int K0() {
        Lifecycle.State state = this.f655b0;
        return (state == Lifecycle.State.INITIALIZED || this.F == null) ? state.ordinal() : Math.min(state.ordinal(), this.F.K0());
    }

    public void K1(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
        w wVar = this.D;
        Activity activityQ = wVar == null ? null : wVar.q();
        if (activityQ != null) {
            this.P = false;
            J1(activityQ, attributeSet, bundle);
        }
    }

    public void K2(boolean z10) {
        if (this.O != z10) {
            this.O = z10;
            if (this.N && i1() && !k1()) {
                this.D.z();
            }
        }
    }

    public int L0() {
        i iVar = this.U;
        if (iVar == null) {
            return 0;
        }
        return iVar.f706g;
    }

    public void L1(boolean z10) {
    }

    public void L2(int i10) {
        if (this.U == null && i10 == 0) {
            return;
        }
        r0();
        this.U.f706g = i10;
    }

    public final Fragment M0() {
        return this.F;
    }

    public boolean M1(MenuItem menuItem) {
        return false;
    }

    public void M2(boolean z10) {
        if (this.U == null) {
            return;
        }
        r0().f701b = z10;
    }

    public final FragmentManager N0() {
        FragmentManager fragmentManager = this.C;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void N1(Menu menu) {
    }

    public void N2(float f10) {
        r0().f717r = f10;
    }

    public boolean O0() {
        i iVar = this.U;
        if (iVar == null) {
            return false;
        }
        return iVar.f701b;
    }

    public void O1() {
        this.P = true;
    }

    public void O2(ArrayList arrayList, ArrayList arrayList2) {
        r0();
        i iVar = this.U;
        iVar.f707h = arrayList;
        iVar.f708i = arrayList2;
    }

    public int P0() {
        i iVar = this.U;
        if (iVar == null) {
            return 0;
        }
        return iVar.f704e;
    }

    public void P1(boolean z10) {
    }

    public void P2(Intent intent) {
        Q2(intent, null);
    }

    public int Q0() {
        i iVar = this.U;
        if (iVar == null) {
            return 0;
        }
        return iVar.f705f;
    }

    public void Q1(Menu menu) {
    }

    public void Q2(Intent intent, Bundle bundle) {
        w wVar = this.D;
        if (wVar != null) {
            wVar.y(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public float R0() {
        i iVar = this.U;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f717r;
    }

    public void R1(boolean z10) {
    }

    public void R2(Intent intent, int i10) {
        S2(intent, i10, null);
    }

    public Object S0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f712m;
        return obj == f653l0 ? F0() : obj;
    }

    public void S1(int i10, String[] strArr, int[] iArr) {
    }

    public void S2(Intent intent, int i10, Bundle bundle) {
        if (this.D != null) {
            N0().X0(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Override // l0.d
    public final androidx.savedstate.a T() {
        return this.f661g0.b();
    }

    public final Resources T0() {
        return I().getResources();
    }

    public void T1() {
        this.P = true;
    }

    public void T2() {
        if (this.U == null || !r0().f719t) {
            return;
        }
        if (this.D == null) {
            r0().f719t = false;
        } else if (Looper.myLooper() != this.D.t().getLooper()) {
            this.D.t().postAtFrontOfQueue(new d());
        } else {
            o0(true);
        }
    }

    public Object U0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f710k;
        return obj == f653l0 ? C0() : obj;
    }

    public void U1(Bundle bundle) {
    }

    public Object V0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        return iVar.f713n;
    }

    public void V1() {
        this.P = true;
    }

    public Object W0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f714o;
        return obj == f653l0 ? V0() : obj;
    }

    public void W1() {
        this.P = true;
    }

    public ArrayList X0() {
        ArrayList arrayList;
        i iVar = this.U;
        return (iVar == null || (arrayList = iVar.f707h) == null) ? new ArrayList() : arrayList;
    }

    public void X1(View view, Bundle bundle) {
    }

    public ArrayList Y0() {
        ArrayList arrayList;
        i iVar = this.U;
        return (iVar == null || (arrayList = iVar.f708i) == null) ? new ArrayList() : arrayList;
    }

    public void Y1(Bundle bundle) {
        this.P = true;
    }

    public final String Z0(int i10) {
        return T0().getString(i10);
    }

    public void Z1(Bundle bundle) {
        this.E.Z0();
        this.f658e = 3;
        this.P = false;
        s1(bundle);
        if (this.P) {
            E2();
            this.E.C();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public final String a1(int i10, Object... objArr) {
        return T0().getString(i10, objArr);
    }

    public void a2() {
        Iterator it = this.f665j0.iterator();
        while (it.hasNext()) {
            ((j) it.next()).a();
        }
        this.f665j0.clear();
        this.E.o(this.D, p0(), this);
        this.f658e = 0;
        this.P = false;
        v1(this.D.r());
        if (this.P) {
            this.C.M(this);
            this.E.D();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final Fragment b1(boolean z10) {
        String str;
        if (z10) {
            FragmentStrictMode.h(this);
        }
        Fragment fragment = this.f672p;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.C;
        if (fragmentManager == null || (str = this.f673q) == null) {
            return null;
        }
        return fragmentManager.k0(str);
    }

    public void b2(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public View c1() {
        return this.R;
    }

    public boolean c2(MenuItem menuItem) {
        if (this.J) {
            return false;
        }
        if (x1(menuItem)) {
            return true;
        }
        return this.E.F(menuItem);
    }

    public androidx.lifecycle.h d1() {
        u0 u0Var = this.f657d0;
        if (u0Var != null) {
            return u0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public void d2(Bundle bundle) {
        this.E.Z0();
        this.f658e = 1;
        this.P = false;
        this.f656c0.a(new androidx.lifecycle.f() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.f
            public void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.R) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        y1(bundle);
        this.Z = true;
        if (this.P) {
            this.f656c0.h(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public LiveData e1() {
        return this.f659e0;
    }

    public boolean e2(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            B1(menu, menuInflater);
            z10 = true;
        }
        return this.E.H(menu, menuInflater) | z10;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final void f1() {
        this.f656c0 = new androidx.lifecycle.i(this);
        this.f661g0 = l0.c.a(this);
        this.f660f0 = null;
        if (this.f665j0.contains(this.f667k0)) {
            return;
        }
        z2(this.f667k0);
    }

    public void f2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.E.Z0();
        this.A = true;
        this.f657d0 = new u0(this, D(), new Runnable() { // from class: androidx.fragment.app.l
            @Override // java.lang.Runnable
            public final void run() {
                Fragment.n0(this.f886e);
            }
        });
        View viewC1 = C1(layoutInflater, viewGroup, bundle);
        this.R = viewC1;
        if (viewC1 == null) {
            if (this.f657d0.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f657d0 = null;
            return;
        }
        this.f657d0.b();
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.R + " for Fragment " + this);
        }
        androidx.lifecycle.d0.a(this.R, this.f657d0);
        androidx.lifecycle.e0.a(this.R, this.f657d0);
        l0.e.a(this.R, this.f657d0);
        this.f659e0.m(this.f657d0);
    }

    public void g1() {
        f1();
        this.f654a0 = this.f670n;
        this.f670n = UUID.randomUUID().toString();
        this.f676t = false;
        this.f677u = false;
        this.f680x = false;
        this.f681y = false;
        this.f682z = false;
        this.B = 0;
        this.C = null;
        this.E = new f0();
        this.D = null;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = false;
        this.K = false;
    }

    public void g2() {
        this.E.I();
        this.f656c0.h(Lifecycle.Event.ON_DESTROY);
        this.f658e = 0;
        this.P = false;
        this.Z = false;
        D1();
        if (this.P) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void h2() {
        this.E.J();
        if (this.R != null && this.f657d0.k0().b().isAtLeast(Lifecycle.State.CREATED)) {
            this.f657d0.a(Lifecycle.Event.ON_DESTROY);
        }
        this.f658e = 1;
        this.P = false;
        F1();
        if (this.P) {
            i0.a.b(this).c();
            this.A = false;
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean i1() {
        return this.D != null && this.f676t;
    }

    public void i2() {
        this.f658e = -1;
        this.P = false;
        G1();
        this.Y = null;
        if (this.P) {
            if (this.E.N0()) {
                return;
            }
            this.E.I();
            this.E = new f0();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    public final boolean j1() {
        return this.K;
    }

    public LayoutInflater j2(Bundle bundle) {
        LayoutInflater layoutInflaterH1 = H1(bundle);
        this.Y = layoutInflaterH1;
        return layoutInflaterH1;
    }

    @Override // androidx.lifecycle.h
    public Lifecycle k0() {
        return this.f656c0;
    }

    public final boolean k1() {
        if (this.J) {
            return true;
        }
        FragmentManager fragmentManager = this.C;
        return fragmentManager != null && fragmentManager.R0(this.F);
    }

    public void k2() {
        onLowMemory();
    }

    public final q l0() {
        q qVarU0 = u0();
        if (qVarU0 != null) {
            return qVarU0;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final boolean l1() {
        return this.B > 0;
    }

    public void l2(boolean z10) {
        L1(z10);
    }

    public final boolean m1() {
        if (!this.O) {
            return false;
        }
        FragmentManager fragmentManager = this.C;
        return fragmentManager == null || fragmentManager.S0(this.F);
    }

    public boolean m2(MenuItem menuItem) {
        if (this.J) {
            return false;
        }
        if (this.N && this.O && M1(menuItem)) {
            return true;
        }
        return this.E.O(menuItem);
    }

    public boolean n1() {
        i iVar = this.U;
        if (iVar == null) {
            return false;
        }
        return iVar.f719t;
    }

    public void n2(Menu menu) {
        if (this.J) {
            return;
        }
        if (this.N && this.O) {
            N1(menu);
        }
        this.E.P(menu);
    }

    public void o0(boolean z10) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.U;
        if (iVar != null) {
            iVar.f719t = false;
        }
        if (this.R == null || (viewGroup = this.Q) == null || (fragmentManager = this.C) == null) {
            return;
        }
        SpecialEffectsController specialEffectsControllerU = SpecialEffectsController.u(viewGroup, fragmentManager);
        specialEffectsControllerU.x();
        if (z10) {
            this.D.t().post(new e(specialEffectsControllerU));
        } else {
            specialEffectsControllerU.n();
        }
        Handler handler = this.V;
        if (handler != null) {
            handler.removeCallbacks(this.W);
            this.V = null;
        }
    }

    public final boolean o1() {
        return this.f658e >= 7;
    }

    public void o2() {
        this.E.R();
        if (this.R != null) {
            this.f657d0.a(Lifecycle.Event.ON_PAUSE);
        }
        this.f656c0.h(Lifecycle.Event.ON_PAUSE);
        this.f658e = 6;
        this.P = false;
        O1();
        if (this.P) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.P = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        l0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.P = true;
    }

    public s p0() {
        return new f();
    }

    public final boolean p1() {
        FragmentManager fragmentManager = this.C;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.V0();
    }

    public void p2(boolean z10) {
        P1(z10);
    }

    public void q0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mTag=");
        printWriter.println(this.I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f658e);
        printWriter.print(" mWho=");
        printWriter.print(this.f670n);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f676t);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f677u);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f680x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f681y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.J);
        printWriter.print(" mDetached=");
        printWriter.print(this.K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.T);
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.C);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.D);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.F);
        }
        if (this.f671o != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f671o);
        }
        if (this.f664j != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f664j);
        }
        if (this.f666k != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f666k);
        }
        if (this.f668l != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f668l);
        }
        Fragment fragmentB1 = b1(false);
        if (fragmentB1 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentB1);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f674r);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(O0());
        if (B0() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(B0());
        }
        if (E0() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(E0());
        }
        if (P0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(P0());
        }
        if (Q0() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(Q0());
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.R);
        }
        if (x0() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(x0());
        }
        if (A0() != null) {
            i0.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.E + ":");
        this.E.b0(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean q1() {
        View view;
        return (!i1() || k1() || (view = this.R) == null || view.getWindowToken() == null || this.R.getVisibility() != 0) ? false : true;
    }

    public boolean q2(Menu menu) {
        boolean z10 = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            Q1(menu);
            z10 = true;
        }
        return this.E.T(menu) | z10;
    }

    public final i r0() {
        if (this.U == null) {
            this.U = new i();
        }
        return this.U;
    }

    public void r1() {
        this.E.Z0();
    }

    public void r2() {
        boolean zT0 = this.C.T0(this);
        Boolean bool = this.f675s;
        if (bool == null || bool.booleanValue() != zT0) {
            this.f675s = Boolean.valueOf(zT0);
            R1(zT0);
            this.E.U();
        }
    }

    public Fragment s0(String str) {
        return str.equals(this.f670n) ? this : this.E.o0(str);
    }

    public void s1(Bundle bundle) {
        this.P = true;
    }

    public void s2() {
        this.E.Z0();
        this.E.f0(true);
        this.f658e = 7;
        this.P = false;
        T1();
        if (!this.P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.i iVar = this.f656c0;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        iVar.h(event);
        if (this.R != null) {
            this.f657d0.a(event);
        }
        this.E.V();
    }

    public String t0() {
        return "fragment_" + this.f670n + "_rq#" + this.f663i0.getAndIncrement();
    }

    public void t1(int i10, int i11, Intent intent) {
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    public void t2(Bundle bundle) {
        U1(bundle);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.f670n);
        if (this.G != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.G));
        }
        if (this.I != null) {
            sb2.append(" tag=");
            sb2.append(this.I);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public final q u0() {
        w wVar = this.D;
        if (wVar == null) {
            return null;
        }
        return (q) wVar.q();
    }

    public void u1(Activity activity) {
        this.P = true;
    }

    public void u2() {
        this.E.Z0();
        this.E.f0(true);
        this.f658e = 5;
        this.P = false;
        V1();
        if (!this.P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.i iVar = this.f656c0;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        iVar.h(event);
        if (this.R != null) {
            this.f657d0.a(event);
        }
        this.E.W();
    }

    public boolean v0() {
        Boolean bool;
        i iVar = this.U;
        if (iVar == null || (bool = iVar.f716q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void v1(Context context) {
        this.P = true;
        w wVar = this.D;
        Activity activityQ = wVar == null ? null : wVar.q();
        if (activityQ != null) {
            this.P = false;
            u1(activityQ);
        }
    }

    public void v2() {
        this.E.Y();
        if (this.R != null) {
            this.f657d0.a(Lifecycle.Event.ON_STOP);
        }
        this.f656c0.h(Lifecycle.Event.ON_STOP);
        this.f658e = 4;
        this.P = false;
        W1();
        if (this.P) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    @Override // androidx.lifecycle.d
    public y.b w() {
        Application application;
        if (this.C == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f660f0 == null) {
            Context applicationContext = I().getApplicationContext();
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
                Log.d("FragmentManager", "Could not find Application instance from Context " + I().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f660f0 = new androidx.lifecycle.v(application, this, y0());
        }
        return this.f660f0;
    }

    public boolean w0() {
        Boolean bool;
        i iVar = this.U;
        if (iVar == null || (bool = iVar.f715p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void w1(Fragment fragment) {
    }

    public void w2() {
        Bundle bundle = this.f664j;
        X1(this.R, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.E.Z();
    }

    @Override // androidx.lifecycle.d
    public h0.a x() {
        Application application;
        Context applicationContext = I().getApplicationContext();
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
            Log.d("FragmentManager", "Could not find Application instance from Context " + I().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        h0.d dVar = new h0.d();
        if (application != null) {
            dVar.c(y.a.f1083g, application);
        }
        dVar.c(SavedStateHandleSupport.f1027a, this);
        dVar.c(SavedStateHandleSupport.f1028b, this);
        if (y0() != null) {
            dVar.c(SavedStateHandleSupport.f1029c, y0());
        }
        return dVar;
    }

    public View x0() {
        i iVar = this.U;
        if (iVar == null) {
            return null;
        }
        return iVar.f700a;
    }

    public boolean x1(MenuItem menuItem) {
        return false;
    }

    public final androidx.activity.result.b x2(e.a aVar, h.a aVar2, androidx.activity.result.a aVar3) {
        if (this.f658e <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            z2(new h(aVar2, atomicReference, aVar, aVar3));
            return new a(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public final Bundle y0() {
        return this.f671o;
    }

    public void y1(Bundle bundle) {
        this.P = true;
        D2();
        if (this.E.U0(1)) {
            return;
        }
        this.E.G();
    }

    public final androidx.activity.result.b y2(e.a aVar, androidx.activity.result.a aVar2) {
        return x2(aVar, new g(), aVar2);
    }

    public final FragmentManager z0() {
        if (this.D != null) {
            return this.E;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Animation z1(int i10, boolean z10, int i11) {
        return null;
    }

    public final void z2(j jVar) {
        if (this.f658e >= 0) {
            jVar.a();
        } else {
            this.f665j0.add(jVar);
        }
    }
}
