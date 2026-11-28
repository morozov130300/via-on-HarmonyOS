package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import n.b1;
import n.z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    public static boolean U = false;
    public static boolean V = true;
    public Fragment A;
    public androidx.activity.result.b F;
    public androidx.activity.result.b G;
    public androidx.activity.result.b H;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ArrayList O;
    public ArrayList P;
    public ArrayList Q;
    public g0 R;
    public FragmentStrictMode.b S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f624b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f627e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f629g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w f646x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public s f647y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Fragment f648z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f623a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f625c = new k0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f626d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f628f = new x(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.a f630h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f631i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.activity.o f632j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f633k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f634l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f635m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f636n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f637o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final y f638p = new y(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f639q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x.a f640r = new x.a() { // from class: androidx.fragment.app.z
        @Override // x.a
        public final void accept(Object obj) {
            FragmentManager.e(this.f891a, (Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x.a f641s = new x.a() { // from class: androidx.fragment.app.a0
        @Override // x.a
        public final void accept(Object obj) {
            FragmentManager.a(this.f726a, (Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final x.a f642t = new x.a() { // from class: androidx.fragment.app.b0
        @Override // x.a
        public final void accept(Object obj) {
            FragmentManager.d(this.f729a, (n.e) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final x.a f643u = new x.a() { // from class: androidx.fragment.app.c0
        @Override // x.a
        public final void accept(Object obj) {
            FragmentManager.c(this.f733a, (b1) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y.i f644v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f645w = -1;
    public v B = null;
    public v C = new d();
    public y0 D = null;
    public y0 E = new e();
    public ArrayDeque I = new ArrayDeque();
    public Runnable T = new f();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements androidx.activity.result.a {
        public a() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfo.f653c;
            int i11 = launchedFragmentInfo.f654e;
            Fragment fragmentI = FragmentManager.this.f625c.i(str);
            if (fragmentI != null) {
                fragmentI.Q1(i11, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends androidx.activity.o {
        public b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void c() {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.r();
                FragmentManager.this.f630h = null;
            }
        }

        @Override // androidx.activity.o
        public void d() {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager.this.K0();
        }

        @Override // androidx.activity.o
        public void e(androidx.activity.b bVar) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.f630h != null) {
                Iterator it = fragmentManager.z(new ArrayList(Collections.singletonList(FragmentManager.this.f630h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((SpecialEffectsController) it.next()).y(bVar);
                }
                Iterator it2 = FragmentManager.this.f637o.iterator();
                while (it2.hasNext()) {
                    ((m) it2.next()).a(bVar);
                }
            }
        }

        @Override // androidx.activity.o
        public void f(androidx.activity.b bVar) {
            if (FragmentManager.O0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.c0();
                FragmentManager.this.k1();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements y.i {
        public c() {
        }

        @Override // y.i
        public boolean a(MenuItem menuItem) {
            return FragmentManager.this.O(menuItem);
        }

        @Override // y.i
        public void b(Menu menu) {
            FragmentManager.this.P(menu);
        }

        @Override // y.i
        public void c(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.H(menu, menuInflater);
        }

        @Override // y.i
        public void d(Menu menu) {
            FragmentManager.this.T(menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends v {
        public d() {
        }

        @Override // androidx.fragment.app.v
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.B0().a(FragmentManager.this.B0().q(), str, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements y0 {
        public e() {
        }

        @Override // androidx.fragment.app.y0
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.f0(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements h0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f661c;

        public g(Fragment fragment) {
            this.f661c = fragment;
        }

        @Override // androidx.fragment.app.h0
        public void V(FragmentManager fragmentManager, Fragment fragment) {
            this.f661c.u1(fragment);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h implements androidx.activity.result.a {
        public h() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollLast();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfo.f653c;
            int i10 = launchedFragmentInfo.f654e;
            Fragment fragmentI = FragmentManager.this.f625c.i(str);
            if (fragmentI != null) {
                fragmentI.r1(i10, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class i implements androidx.activity.result.a {
        public i() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfo.f653c;
            int i10 = launchedFragmentInfo.f654e;
            Fragment fragmentI = FragmentManager.this.f625c.i(str);
            if (fragmentI != null) {
                fragmentI.r1(i10, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class j extends e.a {
        @Override // e.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // e.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class l implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0 f666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.lifecycle.h f667c;

        public l(Lifecycle lifecycle, i0 i0Var, androidx.lifecycle.h hVar) {
            this.f665a = lifecycle;
            this.f666b = i0Var;
            this.f667c = hVar;
        }

        @Override // androidx.fragment.app.i0
        public void a(String str, Bundle bundle) {
            this.f666b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f665a.b().isAtLeast(state);
        }

        public void c() {
            this.f665a.c(this.f667c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface m {
        void a(androidx.activity.b bVar);

        void d(Fragment fragment, boolean z10);

        void h(Fragment fragment, boolean z10);

        void k();

        void onBackStackChanged();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface n {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class o implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f670c;

        public o(String str, int i10, int i11) {
            this.f668a = str;
            this.f669b = i10;
            this.f670c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.A;
            if (fragment == null || this.f669b >= 0 || this.f668a != null || !fragment.x0().e1()) {
                return FragmentManager.this.i1(arrayList, arrayList2, this.f668a, this.f669b, this.f670c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class p implements n {
        public p() {
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zJ1 = FragmentManager.this.j1(arrayList, arrayList2);
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.f631i = true;
            if (!fragmentManager.f637o.isEmpty() && arrayList.size() > 0) {
                boolean zBooleanValue = ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.this.s0((androidx.fragment.app.a) it.next()));
                }
                for (m mVar : FragmentManager.this.f637o) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        mVar.h((Fragment) it2.next(), zBooleanValue);
                    }
                }
            }
            return zJ1;
        }
    }

    public static Fragment I0(View view) {
        Object tag = view.getTag(e0.b.f4067a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean O0(int i10) {
        return U || Log.isLoggable("FragmentManager", i10);
    }

    public static /* synthetic */ void a(FragmentManager fragmentManager, Integer num) {
        if (fragmentManager.Q0() && num.intValue() == 80) {
            fragmentManager.K(false);
        }
    }

    public static /* synthetic */ void c(FragmentManager fragmentManager, b1 b1Var) {
        if (fragmentManager.Q0()) {
            fragmentManager.S(b1Var.a(), false);
        }
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, n.e eVar) {
        if (fragmentManager.Q0()) {
            fragmentManager.L(eVar.a(), false);
        }
    }

    public static /* synthetic */ void e(FragmentManager fragmentManager, Configuration configuration) {
        if (fragmentManager.Q0()) {
            fragmentManager.E(configuration, false);
        }
    }

    public static void h0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                aVar.y(-1);
                aVar.D();
            } else {
                aVar.y(1);
                aVar.C();
            }
            i10++;
        }
    }

    public static FragmentManager p0(View view) {
        q qVar;
        Fragment fragmentQ0 = q0(view);
        if (fragmentQ0 != null) {
            if (fragmentQ0.g1()) {
                return fragmentQ0.x0();
            }
            throw new IllegalStateException("The Fragment " + fragmentQ0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                qVar = null;
                break;
            }
            if (context instanceof q) {
                qVar = (q) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (qVar != null) {
            return qVar.K();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static Fragment q0(View view) {
        while (view != null) {
            Fragment fragmentI0 = I0(view);
            if (fragmentI0 != null) {
                return fragmentI0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int t1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public j0 A(Fragment fragment) {
        j0 j0VarN = this.f625c.n(fragment.f575p);
        if (j0VarN != null) {
            return j0VarN;
        }
        j0 j0Var = new j0(this.f638p, this.f625c, fragment);
        j0Var.o(this.f646x.q().getClassLoader());
        j0Var.t(this.f645w);
        return j0Var;
    }

    public List A0() {
        return this.f625c.o();
    }

    public void A1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(k0(fragment.f575p)) && (fragment.F == null || fragment.E == this)) {
            fragment.f561d0 = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void B(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.M) {
            return;
        }
        fragment.M = true;
        if (fragment.f581v) {
            if (O0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f625c.u(fragment);
            if (P0(fragment)) {
                this.J = true;
            }
            C1(fragment);
        }
    }

    public w B0() {
        return this.f646x;
    }

    public void B1(Fragment fragment) {
        if (fragment == null || (fragment.equals(k0(fragment.f575p)) && (fragment.F == null || fragment.E == this))) {
            Fragment fragment2 = this.A;
            this.A = fragment;
            Q(fragment2);
            Q(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void C() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(4);
    }

    public LayoutInflater.Factory2 C0() {
        return this.f628f;
    }

    public final void C1(Fragment fragment) {
        ViewGroup viewGroupY0 = y0(fragment);
        if (viewGroupY0 == null || fragment.z0() + fragment.C0() + fragment.N0() + fragment.O0() <= 0) {
            return;
        }
        if (viewGroupY0.getTag(e0.b.f4069c) == null) {
            viewGroupY0.setTag(e0.b.f4069c, fragment);
        }
        ((Fragment) viewGroupY0.getTag(e0.b.f4069c)).K2(fragment.M0());
    }

    public void D() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(0);
    }

    public y D0() {
        return this.f638p;
    }

    public void D1(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.L) {
            fragment.L = false;
            fragment.Z = !fragment.Z;
        }
    }

    public void E(Configuration configuration, boolean z10) {
        if (z10 && (this.f646x instanceof o.m)) {
            F1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.Z1(configuration);
                if (z10) {
                    fragment.G.E(configuration, true);
                }
            }
        }
    }

    public Fragment E0() {
        return this.f648z;
    }

    public final void E1() {
        Iterator it = this.f625c.k().iterator();
        while (it.hasNext()) {
            b1((j0) it.next());
        }
    }

    public boolean F(MenuItem menuItem) {
        if (this.f645w < 1) {
            return false;
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null && fragment.a2(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment F0() {
        return this.A;
    }

    public final void F1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
        w wVar = this.f646x;
        if (wVar != null) {
            try {
                wVar.t("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            b0("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public void G() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(1);
    }

    public y0 G0() {
        y0 y0Var = this.D;
        if (y0Var != null) {
            return y0Var;
        }
        Fragment fragment = this.f648z;
        return fragment != null ? fragment.E.G0() : this.E;
    }

    public void G1(k kVar) {
        this.f638p.p(kVar);
    }

    public boolean H(Menu menu, MenuInflater menuInflater) {
        if (this.f645w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null && S0(fragment) && fragment.c2(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f627e != null) {
            for (int i10 = 0; i10 < this.f627e.size(); i10++) {
                Fragment fragment2 = (Fragment) this.f627e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.C1();
                }
            }
        }
        this.f627e = arrayList;
        return z10;
    }

    public FragmentStrictMode.b H0() {
        return this.S;
    }

    public final void H1() {
        synchronized (this.f623a) {
            try {
                if (!this.f623a.isEmpty()) {
                    this.f632j.j(true);
                    if (O0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z10 = u0() > 0 && T0(this.f648z);
                if (O0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z10);
                }
                this.f632j.j(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void I() {
        this.M = true;
        f0(true);
        c0();
        v();
        X(-1);
        Object obj = this.f646x;
        if (obj instanceof o.n) {
            ((o.n) obj).f(this.f641s);
        }
        Object obj2 = this.f646x;
        if (obj2 instanceof o.m) {
            ((o.m) obj2).k(this.f640r);
        }
        Object obj3 = this.f646x;
        if (obj3 instanceof n.y0) {
            ((n.y0) obj3).m(this.f642t);
        }
        Object obj4 = this.f646x;
        if (obj4 instanceof z0) {
            ((z0) obj4).n(this.f643u);
        }
        Object obj5 = this.f646x;
        if ((obj5 instanceof y.g) && this.f648z == null) {
            ((y.g) obj5).j(this.f644v);
        }
        this.f646x = null;
        this.f647y = null;
        this.f648z = null;
        if (this.f629g != null) {
            this.f632j.h();
            this.f629g = null;
        }
        androidx.activity.result.b bVar = this.F;
        if (bVar != null) {
            bVar.c();
            this.G.c();
            this.H.c();
        }
    }

    public void J() {
        X(1);
    }

    public androidx.lifecycle.d0 J0(Fragment fragment) {
        return this.R.r(fragment);
    }

    public void K(boolean z10) {
        if (z10 && (this.f646x instanceof o.n)) {
            F1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.i2();
                if (z10) {
                    fragment.G.K(true);
                }
            }
        }
    }

    public void K0() {
        f0(true);
        if (!V || this.f630h == null) {
            if (this.f632j.g()) {
                if (O0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                e1();
                return;
            } else {
                if (O0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f629g.k();
                return;
            }
        }
        if (!this.f637o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(s0(this.f630h));
            for (m mVar : this.f637o) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    mVar.d((Fragment) it.next(), true);
                }
            }
        }
        Iterator it2 = this.f630h.f790c.iterator();
        while (it2.hasNext()) {
            Fragment fragment = ((l0.a) it2.next()).f808b;
            if (fragment != null) {
                fragment.f583x = false;
            }
        }
        Iterator it3 = z(new ArrayList(Collections.singletonList(this.f630h)), 0, 1).iterator();
        while (it3.hasNext()) {
            ((SpecialEffectsController) it3.next()).f();
        }
        this.f630h = null;
        H1();
        if (O0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f632j.g() + " for  FragmentManager " + this);
        }
    }

    public void L(boolean z10, boolean z11) {
        if (z11 && (this.f646x instanceof n.y0)) {
            F1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.j2(z10);
                if (z11) {
                    fragment.G.L(z10, true);
                }
            }
        }
    }

    public void L0(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.L) {
            return;
        }
        fragment.L = true;
        fragment.Z = true ^ fragment.Z;
        C1(fragment);
    }

    public void M(Fragment fragment) {
        Iterator it = this.f639q.iterator();
        while (it.hasNext()) {
            ((h0) it.next()).V(this, fragment);
        }
    }

    public void M0(Fragment fragment) {
        if (fragment.f581v && P0(fragment)) {
            this.J = true;
        }
    }

    public void N() {
        for (Fragment fragment : this.f625c.l()) {
            if (fragment != null) {
                fragment.G1(fragment.i1());
                fragment.G.N();
            }
        }
    }

    public boolean N0() {
        return this.M;
    }

    public boolean O(MenuItem menuItem) {
        if (this.f645w < 1) {
            return false;
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null && fragment.k2(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void P(Menu menu) {
        if (this.f645w < 1) {
            return;
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.l2(menu);
            }
        }
    }

    public final boolean P0(Fragment fragment) {
        return (fragment.P && fragment.Q) || fragment.G.s();
    }

    public final void Q(Fragment fragment) {
        if (fragment == null || !fragment.equals(k0(fragment.f575p))) {
            return;
        }
        fragment.p2();
    }

    public final boolean Q0() {
        Fragment fragment = this.f648z;
        if (fragment == null) {
            return true;
        }
        return fragment.g1() && this.f648z.L0().Q0();
    }

    public void R() {
        X(5);
    }

    public boolean R0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.i1();
    }

    public void S(boolean z10, boolean z11) {
        if (z11 && (this.f646x instanceof z0)) {
            F1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.n2(z10);
                if (z11) {
                    fragment.G.S(z10, true);
                }
            }
        }
    }

    public boolean S0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.k1();
    }

    public boolean T(Menu menu) {
        boolean z10 = false;
        if (this.f645w < 1) {
            return false;
        }
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null && S0(fragment) && fragment.o2(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean T0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.E;
        return fragment.equals(fragmentManager.F0()) && T0(fragmentManager.f648z);
    }

    public void U() {
        H1();
        Q(this.A);
    }

    public boolean U0(int i10) {
        return this.f645w >= i10;
    }

    public void V() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(7);
    }

    public boolean V0() {
        return this.K || this.L;
    }

    public void W() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(5);
    }

    public void W0(Fragment fragment, String[] strArr, int i10) {
        if (this.H == null) {
            this.f646x.w(fragment, strArr, i10);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f575p, i10));
        this.H.a(strArr);
    }

    public final void X(int i10) {
        try {
            this.f624b = true;
            this.f625c.d(i10);
            Y0(i10, false);
            Iterator it = y().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).q();
            }
            this.f624b = false;
            f0(true);
        } catch (Throwable th) {
            this.f624b = false;
            throw th;
        }
    }

    public void X0(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.F == null) {
            this.f646x.x(fragment, intent, i10, bundle);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f575p, i10));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.F.a(intent);
    }

    public void Y() {
        this.L = true;
        this.R.u(true);
        X(4);
    }

    public void Y0(int i10, boolean z10) {
        w wVar;
        if (this.f646x == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f645w) {
            this.f645w = i10;
            this.f625c.t();
            E1();
            if (this.J && (wVar = this.f646x) != null && this.f645w == 7) {
                wVar.y();
                this.J = false;
            }
        }
    }

    public void Z() {
        X(2);
    }

    public void Z0() {
        if (this.f646x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.u(false);
        for (Fragment fragment : this.f625c.o()) {
            if (fragment != null) {
                fragment.p1();
            }
        }
    }

    public final void a0() {
        if (this.N) {
            this.N = false;
            E1();
        }
    }

    public void a1(t tVar) {
        View view;
        for (j0 j0Var : this.f625c.k()) {
            Fragment fragmentK = j0Var.k();
            if (fragmentK.J == tVar.getId() && (view = fragmentK.T) != null && view.getParent() == null) {
                fragmentK.S = tVar;
                j0Var.b();
            }
        }
    }

    public void b0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f625c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f627e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) this.f627e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        int size2 = this.f626d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size2; i11++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f626d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.A(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f633k.get());
        synchronized (this.f623a) {
            try {
                int size3 = this.f623a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        n nVar = (n) this.f623a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(nVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f646x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f647y);
        if (this.f648z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f648z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f645w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    public void b1(j0 j0Var) {
        Fragment fragmentK = j0Var.k();
        if (fragmentK.U) {
            if (this.f624b) {
                this.N = true;
            } else {
                fragmentK.U = false;
                j0Var.m();
            }
        }
    }

    public final void c0() {
        Iterator it = y().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).q();
        }
    }

    public void c1() {
        d0(new o(null, -1, 0), false);
    }

    public void d0(n nVar, boolean z10) {
        if (!z10) {
            if (this.f646x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            t();
        }
        synchronized (this.f623a) {
            try {
                if (this.f646x == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f623a.add(nVar);
                    w1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            d0(new o(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void e0(boolean z10) {
        if (this.f624b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f646x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f646x.s().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            t();
        }
        if (this.O == null) {
            this.O = new ArrayList();
            this.P = new ArrayList();
        }
    }

    public boolean e1() {
        return h1(null, -1, 0);
    }

    public boolean f0(boolean z10) {
        e0(z10);
        boolean z11 = false;
        while (t0(this.O, this.P)) {
            z11 = true;
            this.f624b = true;
            try {
                q1(this.O, this.P);
                u();
            } catch (Throwable th) {
                u();
                throw th;
            }
        }
        H1();
        a0();
        this.f625c.b();
        return z11;
    }

    public boolean f1(int i10, int i11) {
        if (i10 >= 0) {
            return h1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public void g0(n nVar, boolean z10) {
        if (z10 && (this.f646x == null || this.M)) {
            return;
        }
        e0(z10);
        if (nVar.a(this.O, this.P)) {
            this.f624b = true;
            try {
                q1(this.O, this.P);
                u();
            } catch (Throwable th) {
                u();
                throw th;
            }
        }
        H1();
        a0();
        this.f625c.b();
    }

    public boolean g1(String str, int i10) {
        return h1(str, -1, i10);
    }

    public final boolean h1(String str, int i10, int i11) {
        f0(false);
        e0(true);
        Fragment fragment = this.A;
        if (fragment != null && i10 < 0 && str == null && fragment.x0().e1()) {
            return true;
        }
        boolean zI1 = i1(this.O, this.P, str, i10, i11);
        if (zI1) {
            this.f624b = true;
            try {
                q1(this.O, this.P);
                u();
            } catch (Throwable th) {
                u();
                throw th;
            }
        }
        H1();
        a0();
        this.f625c.b();
        return zI1;
    }

    public final void i0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        boolean z10 = ((androidx.fragment.app.a) arrayList.get(i10)).f805r;
        ArrayList arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.f625c.o());
        Fragment fragmentF0 = F0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i12);
            fragmentF0 = !((Boolean) arrayList2.get(i12)).booleanValue() ? aVar.E(this.Q, fragmentF0) : aVar.H(this.Q, fragmentF0);
            z11 = z11 || aVar.f796i;
        }
        this.Q.clear();
        if (!z10 && this.f645w >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i13)).f790c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((l0.a) it.next()).f808b;
                    if (fragment != null && fragment.E != null) {
                        this.f625c.r(A(fragment));
                    }
                }
            }
        }
        h0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i11 - 1)).booleanValue();
        if (z11 && !this.f637o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(s0((androidx.fragment.app.a) it2.next()));
            }
            if (this.f630h == null) {
                for (m mVar : this.f637o) {
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        mVar.h((Fragment) it3.next(), zBooleanValue);
                    }
                }
                for (m mVar2 : this.f637o) {
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        mVar2.d((Fragment) it4.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = aVar2.f790c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((l0.a) aVar2.f790c.get(size)).f808b;
                    if (fragment2 != null) {
                        A(fragment2).m();
                    }
                }
            } else {
                Iterator it5 = aVar2.f790c.iterator();
                while (it5.hasNext()) {
                    Fragment fragment3 = ((l0.a) it5.next()).f808b;
                    if (fragment3 != null) {
                        A(fragment3).m();
                    }
                }
            }
        }
        Y0(this.f645w, true);
        for (SpecialEffectsController specialEffectsController : z(arrayList, i10, i11)) {
            specialEffectsController.B(zBooleanValue);
            specialEffectsController.x();
            specialEffectsController.n();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue() && aVar3.f724v >= 0) {
                aVar3.f724v = -1;
            }
            aVar3.G();
            i10++;
        }
        if (z11) {
            r1();
        }
    }

    public boolean i1(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int iL0 = l0(str, i10, (i11 & 1) != 0);
        if (iL0 < 0) {
            return false;
        }
        for (int size = this.f626d.size() - 1; size >= iL0; size--) {
            arrayList.add((androidx.fragment.app.a) this.f626d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void j(androidx.fragment.app.a aVar) {
        this.f626d.add(aVar);
    }

    public boolean j0() {
        boolean zF0 = f0(true);
        r0();
        return zF0;
    }

    public boolean j1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f626d;
        androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList3.get(arrayList3.size() - 1);
        this.f630h = aVar;
        Iterator it = aVar.f790c.iterator();
        while (it.hasNext()) {
            Fragment fragment = ((l0.a) it.next()).f808b;
            if (fragment != null) {
                fragment.f583x = true;
            }
        }
        return i1(arrayList, arrayList2, null, -1, 0);
    }

    public j0 k(Fragment fragment) {
        String str = fragment.f560c0;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (O0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        j0 j0VarA = A(fragment);
        fragment.E = this;
        this.f625c.r(j0VarA);
        if (!fragment.M) {
            this.f625c.a(fragment);
            fragment.f582w = false;
            if (fragment.T == null) {
                fragment.Z = false;
            }
            if (P0(fragment)) {
                this.J = true;
            }
        }
        return j0VarA;
    }

    public Fragment k0(String str) {
        return this.f625c.f(str);
    }

    public void k1() {
        d0(new p(), false);
    }

    public void l(h0 h0Var) {
        this.f639q.add(h0Var);
    }

    public final int l0(String str, int i10, boolean z10) {
        if (this.f626d.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f626d.size() - 1;
        }
        int size = this.f626d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f626d.get(size);
            if ((str != null && str.equals(aVar.F())) || (i10 >= 0 && i10 == aVar.f724v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f626d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f626d.get(size - 1);
            if ((str == null || !str.equals(aVar2.F())) && (i10 < 0 || i10 != aVar2.f724v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public void l1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.E != this) {
            F1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f575p);
    }

    public void m(m mVar) {
        this.f637o.add(mVar);
    }

    public Fragment m0(int i10) {
        return this.f625c.g(i10);
    }

    public void m1(k kVar, boolean z10) {
        this.f638p.o(kVar, z10);
    }

    public int n() {
        return this.f633k.getAndIncrement();
    }

    public Fragment n0(String str) {
        return this.f625c.h(str);
    }

    public void n1(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.D);
        }
        boolean zJ1 = fragment.j1();
        if (fragment.M && zJ1) {
            return;
        }
        this.f625c.u(fragment);
        if (P0(fragment)) {
            this.J = true;
        }
        fragment.f582w = true;
        C1(fragment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(w wVar, s sVar, Fragment fragment) {
        String str;
        if (this.f646x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f646x = wVar;
        this.f647y = sVar;
        this.f648z = fragment;
        if (fragment != null) {
            l(new g(fragment));
        } else if (wVar instanceof h0) {
            l((h0) wVar);
        }
        if (this.f648z != null) {
            H1();
        }
        if (wVar instanceof androidx.activity.r) {
            androidx.activity.r rVar = (androidx.activity.r) wVar;
            OnBackPressedDispatcher onBackPressedDispatcherH = rVar.h();
            this.f629g = onBackPressedDispatcherH;
            androidx.lifecycle.j jVar = rVar;
            if (fragment != null) {
                jVar = fragment;
            }
            onBackPressedDispatcherH.h(jVar, this.f632j);
        }
        if (fragment != null) {
            this.R = fragment.E.v0(fragment);
        } else if (wVar instanceof androidx.lifecycle.e0) {
            this.R = g0.p(((androidx.lifecycle.e0) wVar).B());
        } else {
            this.R = new g0(false);
        }
        this.R.u(V0());
        this.f625c.A(this.R);
        Object obj = this.f646x;
        if ((obj instanceof m0.d) && fragment == null) {
            androidx.savedstate.a aVarQ = ((m0.d) obj).Q();
            aVarQ.h("android:support:fragments", new androidx.savedstate.a.c() { // from class: androidx.fragment.app.d0
                @Override // androidx.savedstate.a.c
                public final Bundle b() {
                    return this.f735a.u1();
                }
            });
            Bundle bundleB = aVarQ.b("android:support:fragments");
            if (bundleB != null) {
                s1(bundleB);
            }
        }
        Object obj2 = this.f646x;
        if (obj2 instanceof androidx.activity.result.c) {
            ActivityResultRegistry activityResultRegistryG = ((androidx.activity.result.c) obj2).g();
            if (fragment != null) {
                str = fragment.f575p + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.F = activityResultRegistryG.j(str2 + "StartActivityForResult", new e.h(), new h());
            this.G = activityResultRegistryG.j(str2 + "StartIntentSenderForResult", new j(), new i());
            this.H = activityResultRegistryG.j(str2 + "RequestPermissions", new e.f(), new a());
        }
        Object obj3 = this.f646x;
        if (obj3 instanceof o.m) {
            ((o.m) obj3).c(this.f640r);
        }
        Object obj4 = this.f646x;
        if (obj4 instanceof o.n) {
            ((o.n) obj4).i(this.f641s);
        }
        Object obj5 = this.f646x;
        if (obj5 instanceof n.y0) {
            ((n.y0) obj5).e(this.f642t);
        }
        Object obj6 = this.f646x;
        if (obj6 instanceof z0) {
            ((z0) obj6).d(this.f643u);
        }
        Object obj7 = this.f646x;
        if ((obj7 instanceof y.g) && fragment == null) {
            ((y.g) obj7).b(this.f644v);
        }
    }

    public Fragment o0(String str) {
        return this.f625c.i(str);
    }

    public void o1(h0 h0Var) {
        this.f639q.remove(h0Var);
    }

    public void p(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.M) {
            fragment.M = false;
            if (fragment.f581v) {
                return;
            }
            this.f625c.a(fragment);
            if (O0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (P0(fragment)) {
                this.J = true;
            }
        }
    }

    public void p1(m mVar) {
        this.f637o.remove(mVar);
    }

    public l0 q() {
        return new androidx.fragment.app.a(this);
    }

    public final void q1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i10)).f805r) {
                if (i11 != i10) {
                    i0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                    while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i11)).f805r) {
                        i11++;
                    }
                }
                i0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            i0(arrayList, arrayList2, i11, size);
        }
    }

    public void r() {
        androidx.fragment.app.a aVar = this.f630h;
        if (aVar != null) {
            aVar.f723u = false;
            aVar.i();
            j0();
            Iterator it = this.f637o.iterator();
            while (it.hasNext()) {
                ((m) it.next()).k();
            }
        }
    }

    public final void r0() {
        Iterator it = y().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).r();
        }
    }

    public final void r1() {
        for (int i10 = 0; i10 < this.f637o.size(); i10++) {
            ((m) this.f637o.get(i10)).onBackStackChanged();
        }
    }

    public boolean s() {
        boolean zP0 = false;
        for (Fragment fragment : this.f625c.l()) {
            if (fragment != null) {
                zP0 = P0(fragment);
            }
            if (zP0) {
                return true;
            }
        }
        return false;
    }

    public Set s0(androidx.fragment.app.a aVar) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < aVar.f790c.size(); i10++) {
            Fragment fragment = ((l0.a) aVar.f790c.get(i10)).f808b;
            if (fragment != null && aVar.f796i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public void s1(Parcelable parcelable) {
        j0 j0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f646x.q().getClassLoader());
                this.f635m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f646x.q().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f625c.x(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.f625c.v();
        Iterator it = fragmentManagerState.f673c.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f625c.B((String) it.next(), null);
            if (bundleB != null) {
                Fragment fragmentN = this.R.n(((FragmentState) bundleB.getParcelable("state")).f682e);
                if (fragmentN != null) {
                    if (O0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentN);
                    }
                    j0Var = new j0(this.f638p, this.f625c, fragmentN, bundleB);
                } else {
                    j0Var = new j0(this.f638p, this.f625c, this.f646x.q().getClassLoader(), z0(), bundleB);
                }
                Fragment fragmentK = j0Var.k();
                fragmentK.f562e = bundleB;
                fragmentK.E = this;
                if (O0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.f575p + "): " + fragmentK);
                }
                j0Var.o(this.f646x.q().getClassLoader());
                this.f625c.r(j0Var);
                j0Var.t(this.f645w);
            }
        }
        for (Fragment fragment : this.R.q()) {
            if (!this.f625c.c(fragment.f575p)) {
                if (O0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f673c);
                }
                this.R.t(fragment);
                fragment.E = this;
                j0 j0Var2 = new j0(this.f638p, this.f625c, fragment);
                j0Var2.t(1);
                j0Var2.m();
                fragment.f582w = true;
                j0Var2.m();
            }
        }
        this.f625c.w(fragmentManagerState.f674e);
        if (fragmentManagerState.f675m != null) {
            this.f626d = new ArrayList(fragmentManagerState.f675m.length);
            int i10 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f675m;
                if (i10 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = backStackRecordStateArr[i10].b(this);
                if (O0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + aVarB.f724v + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
                    aVarB.B("  ", printWriter, false);
                    printWriter.close();
                }
                this.f626d.add(aVarB);
                i10++;
            }
        } else {
            this.f626d = new ArrayList();
        }
        this.f633k.set(fragmentManagerState.f676n);
        String str3 = fragmentManagerState.f677o;
        if (str3 != null) {
            Fragment fragmentK0 = k0(str3);
            this.A = fragmentK0;
            Q(fragmentK0);
        }
        ArrayList arrayList = fragmentManagerState.f678p;
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                this.f634l.put((String) arrayList.get(i11), (BackStackState) fragmentManagerState.f679q.get(i11));
            }
        }
        this.I = new ArrayDeque(fragmentManagerState.f680r);
    }

    public final void t() {
        if (V0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean t0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f623a) {
            if (this.f623a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f623a.size();
                boolean zA = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zA |= ((n) this.f623a.get(i10)).a(arrayList, arrayList2);
                }
                this.f623a.clear();
                this.f646x.s().removeCallbacks(this.T);
                return zA;
            } catch (Throwable th) {
                this.f623a.clear();
                this.f646x.s().removeCallbacks(this.T);
                throw th;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f648z;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f648z)));
            sb2.append("}");
        } else {
            w wVar = this.f646x;
            if (wVar != null) {
                sb2.append(wVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f646x)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u() {
        this.f624b = false;
        this.P.clear();
        this.O.clear();
    }

    public int u0() {
        return this.f626d.size() + (this.f630h != null ? 1 : 0);
    }

    public Bundle u1() {
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        r0();
        c0();
        f0(true);
        this.K = true;
        this.R.u(true);
        ArrayList arrayListY = this.f625c.y();
        HashMap mapM = this.f625c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f625c.z();
            int size = this.f626d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState((androidx.fragment.app.a) this.f626d.get(i10));
                    if (O0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f626d.get(i10));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f673c = arrayListY;
            fragmentManagerState.f674e = arrayListZ;
            fragmentManagerState.f675m = backStackRecordStateArr;
            fragmentManagerState.f676n = this.f633k.get();
            Fragment fragment = this.A;
            if (fragment != null) {
                fragmentManagerState.f677o = fragment.f575p;
            }
            fragmentManagerState.f678p.addAll(this.f634l.keySet());
            fragmentManagerState.f679q.addAll(this.f634l.values());
            fragmentManagerState.f680r = new ArrayList(this.I);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f635m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f635m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (O0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void v() {
        boolean zS;
        w wVar = this.f646x;
        if (wVar instanceof androidx.lifecycle.e0) {
            zS = this.f625c.p().s();
        } else {
            zS = wVar.q() instanceof Activity ? !((Activity) this.f646x.q()).isChangingConfigurations() : true;
        }
        if (zS) {
            Iterator it = this.f634l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f518c.iterator();
                while (it2.hasNext()) {
                    this.f625c.p().l((String) it2.next(), false);
                }
            }
        }
    }

    public final g0 v0(Fragment fragment) {
        return this.R.o(fragment);
    }

    public Fragment.SavedState v1(Fragment fragment) {
        j0 j0VarN = this.f625c.n(fragment.f575p);
        if (j0VarN == null || !j0VarN.k().equals(fragment)) {
            F1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return j0VarN.q();
    }

    public final void w(String str) {
        this.f635m.remove(str);
        if (O0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public s w0() {
        return this.f647y;
    }

    public void w1() {
        synchronized (this.f623a) {
            try {
                if (this.f623a.size() == 1) {
                    this.f646x.s().removeCallbacks(this.T);
                    this.f646x.s().post(this.T);
                    H1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(String str) {
        l lVar = (l) this.f636n.remove(str);
        if (lVar != null) {
            lVar.c();
        }
        if (O0(2)) {
            Log.v("FragmentManager", "Clearing FragmentResultListener for key " + str);
        }
    }

    public Fragment x0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentK0 = k0(string);
        if (fragmentK0 == null) {
            F1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentK0;
    }

    public void x1(Fragment fragment, boolean z10) {
        ViewGroup viewGroupY0 = y0(fragment);
        if (viewGroupY0 == null || !(viewGroupY0 instanceof t)) {
            return;
        }
        ((t) viewGroupY0).setDrawDisappearingViewsLast(!z10);
    }

    public final Set y() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f625c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((j0) it.next()).k().S;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.v(viewGroup, G0()));
            }
        }
        return hashSet;
    }

    public final ViewGroup y0(Fragment fragment) {
        ViewGroup viewGroup = fragment.S;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.J > 0 && this.f647y.o()) {
            View viewL = this.f647y.l(fragment.J);
            if (viewL instanceof ViewGroup) {
                return (ViewGroup) viewL;
            }
        }
        return null;
    }

    public final void y1(String str, Bundle bundle) {
        l lVar = (l) this.f636n.get(str);
        if (lVar == null || !lVar.b(Lifecycle.State.STARTED)) {
            this.f635m.put(str, bundle);
        } else {
            lVar.a(str, bundle);
        }
        if (O0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    public Set z(ArrayList arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i10)).f790c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((l0.a) it.next()).f808b;
                if (fragment != null && (viewGroup = fragment.S) != null) {
                    hashSet.add(SpecialEffectsController.u(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public v z0() {
        v vVar = this.B;
        if (vVar != null) {
            return vVar;
        }
        Fragment fragment = this.f648z;
        return fragment != null ? fragment.E.z0() : this.C;
    }

    public final void z1(final String str, androidx.lifecycle.j jVar, final i0 i0Var) {
        final Lifecycle lifecycleH0 = jVar.h0();
        if (lifecycleH0.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        androidx.lifecycle.h hVar = new androidx.lifecycle.h() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.h
            public void e(androidx.lifecycle.j jVar2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f635m.get(str)) != null) {
                    i0Var.a(str, bundle);
                    FragmentManager.this.w(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycleH0.c(this);
                    FragmentManager.this.f636n.remove(str);
                }
            }
        };
        l lVar = (l) this.f636n.put(str, new l(lifecycleH0, i0Var, hVar));
        if (lVar != null) {
            lVar.c();
        }
        if (O0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycleH0 + " and listener " + i0Var);
        }
        lifecycleH0.a(hVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f653c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f654e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(String str, int i10) {
            this.f653c = str;
            this.f654e = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f653c);
            parcel.writeInt(this.f654e);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f653c = parcel.readString();
            this.f654e = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class k {
        public abstract void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle);

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }
    }
}
