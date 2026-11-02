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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.l0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
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

    /* renamed from: b, reason: collision with root package name */
    public boolean f721b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f724e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f726g;

    /* renamed from: x, reason: collision with root package name */
    public w f743x;

    /* renamed from: y, reason: collision with root package name */
    public s f744y;

    /* renamed from: z, reason: collision with root package name */
    public Fragment f745z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f720a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final k0 f722c = new k0();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f723d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final x f725f = new x(this);

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.a f727h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f728i = false;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.activity.o f729j = new b(false);

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f730k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public final Map f731l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final Map f732m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    public final Map f733n = Collections.synchronizedMap(new HashMap());

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f734o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final y f735p = new y(this);

    /* renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f736q = new CopyOnWriteArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final w.a f737r = new w.a() { // from class: androidx.fragment.app.z
        @Override // w.a
        public final void accept(Object obj) {
            FragmentManager.e(this.f990a, (Configuration) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public final w.a f738s = new w.a() { // from class: androidx.fragment.app.a0
        @Override // w.a
        public final void accept(Object obj) {
            FragmentManager.a(this.f823a, (Integer) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public final w.a f739t = new w.a() { // from class: androidx.fragment.app.b0
        @Override // w.a
        public final void accept(Object obj) {
            FragmentManager.d(this.f826a, (n.e) obj);
        }
    };

    /* renamed from: u, reason: collision with root package name */
    public final w.a f740u = new w.a() { // from class: androidx.fragment.app.c0
        @Override // w.a
        public final void accept(Object obj) {
            FragmentManager.c(this.f830a, (b1) obj);
        }
    };

    /* renamed from: v, reason: collision with root package name */
    public final x.i f741v = new c();

    /* renamed from: w, reason: collision with root package name */
    public int f742w = -1;
    public v B = null;
    public v C = new d();
    public y0 D = null;
    public y0 E = new e();
    public ArrayDeque I = new ArrayDeque();
    public Runnable T = new f();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public String f750e;

        /* renamed from: j, reason: collision with root package name */
        public int f751j;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f750e = parcel.readString();
            this.f751j = parcel.readInt();
        }

        public LaunchedFragmentInfo(String str, int i10) {
            this.f750e = str;
            this.f751j = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f750e);
            parcel.writeInt(this.f751j);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements androidx.activity.result.a {
        public a() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
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
            String str = launchedFragmentInfo.f750e;
            int i11 = launchedFragmentInfo.f751j;
            Fragment fragmentI = FragmentManager.this.f722c.i(str);
            if (fragmentI != null) {
                fragmentI.S1(i11, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
                FragmentManager.this.f727h = null;
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
            if (fragmentManager.f727h != null) {
                Iterator it = fragmentManager.z(new ArrayList(Collections.singletonList(FragmentManager.this.f727h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((SpecialEffectsController) it.next()).y(bVar);
                }
                Iterator it2 = FragmentManager.this.f734o.iterator();
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements x.i {
        public c() {
        }

        @Override // x.i
        public boolean a(MenuItem menuItem) {
            return FragmentManager.this.O(menuItem);
        }

        @Override // x.i
        public void b(Menu menu) {
            FragmentManager.this.P(menu);
        }

        @Override // x.i
        public void c(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.H(menu, menuInflater);
        }

        @Override // x.i
        public void d(Menu menu) {
            FragmentManager.this.T(menu);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends v {
        public d() {
        }

        @Override // androidx.fragment.app.v
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.B0().a(FragmentManager.this.B0().r(), str, null);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements y0 {
        public e() {
        }

        @Override // androidx.fragment.app.y0
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.f0(true);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements h0 {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Fragment f758e;

        public g(Fragment fragment) {
            this.f758e = fragment;
        }

        @Override // androidx.fragment.app.h0
        public void k(FragmentManager fragmentManager, Fragment fragment) {
            this.f758e.w1(fragment);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h implements androidx.activity.result.a {
        public h() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollLast();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfo.f750e;
            int i10 = launchedFragmentInfo.f751j;
            Fragment fragmentI = FragmentManager.this.f722c.i(str);
            if (fragmentI != null) {
                fragmentI.t1(i10, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class i implements androidx.activity.result.a {
        public i() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfo.f750e;
            int i10 = launchedFragmentInfo.f751j;
            Fragment fragmentI = FragmentManager.this.f722c.i(str);
            if (fragmentI != null) {
                fragmentI.t1(i10, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class j extends e.a {
        @Override // e.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
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
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class k {
        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public abstract void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle);

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class l implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f762a;

        /* renamed from: b, reason: collision with root package name */
        public final i0 f763b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.lifecycle.f f764c;

        public l(Lifecycle lifecycle, i0 i0Var, androidx.lifecycle.f fVar) {
            this.f762a = lifecycle;
            this.f763b = i0Var;
            this.f764c = fVar;
        }

        @Override // androidx.fragment.app.i0
        public void a(String str, Bundle bundle) {
            this.f763b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f762a.b().isAtLeast(state);
        }

        public void c() {
            this.f762a.c(this.f764c);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface m {
        void a(androidx.activity.b bVar);

        void b(Fragment fragment, boolean z10);

        void c(Fragment fragment, boolean z10);

        void d();

        void onBackStackChanged();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface n {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class o implements n {

        /* renamed from: a, reason: collision with root package name */
        public final String f765a;

        /* renamed from: b, reason: collision with root package name */
        public final int f766b;

        /* renamed from: c, reason: collision with root package name */
        public final int f767c;

        public o(String str, int i10, int i11) {
            this.f765a = str;
            this.f766b = i10;
            this.f767c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.A;
            if (fragment == null || this.f766b >= 0 || this.f765a != null || !fragment.z0().e1()) {
                return FragmentManager.this.i1(arrayList, arrayList2, this.f765a, this.f766b, this.f767c);
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class p implements n {
        public p() {
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zJ1 = FragmentManager.this.j1(arrayList, arrayList2);
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.f728i = true;
            if (!fragmentManager.f734o.isEmpty() && arrayList.size() > 0) {
                boolean zBooleanValue = ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.this.s0((androidx.fragment.app.a) it.next()));
                }
                Iterator it2 = FragmentManager.this.f734o.iterator();
                while (it2.hasNext()) {
                    m mVar = (m) it2.next();
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        mVar.c((Fragment) it3.next(), zBooleanValue);
                    }
                }
            }
            return zJ1;
        }
    }

    public static Fragment I0(View view) {
        Object tag = view.getTag(d0.b.f4435a);
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
            if (fragmentQ0.i1()) {
                return fragmentQ0.z0();
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
            return qVar.L();
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

    public static int s1(int i10) {
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
        j0 j0VarN = this.f722c.n(fragment.f670n);
        if (j0VarN != null) {
            return j0VarN;
        }
        j0 j0Var = new j0(this.f735p, this.f722c, fragment);
        j0Var.o(this.f743x.r().getClassLoader());
        j0Var.t(this.f742w);
        return j0Var;
    }

    public List A0() {
        return this.f722c.o();
    }

    public void A1(Fragment fragment) {
        if (fragment == null || (fragment.equals(k0(fragment.f670n)) && (fragment.D == null || fragment.C == this))) {
            Fragment fragment2 = this.A;
            this.A = fragment;
            Q(fragment2);
            Q(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void B(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.K) {
            return;
        }
        fragment.K = true;
        if (fragment.f676t) {
            if (O0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f722c.u(fragment);
            if (P0(fragment)) {
                this.J = true;
            }
            B1(fragment);
        }
    }

    public w B0() {
        return this.f743x;
    }

    public final void B1(Fragment fragment) {
        ViewGroup viewGroupY0 = y0(fragment);
        if (viewGroupY0 == null || fragment.B0() + fragment.E0() + fragment.P0() + fragment.Q0() <= 0) {
            return;
        }
        if (viewGroupY0.getTag(d0.b.f4437c) == null) {
            viewGroupY0.setTag(d0.b.f4437c, fragment);
        }
        ((Fragment) viewGroupY0.getTag(d0.b.f4437c)).M2(fragment.O0());
    }

    public void C() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(4);
    }

    public LayoutInflater.Factory2 C0() {
        return this.f725f;
    }

    public void C1(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.J) {
            fragment.J = false;
            fragment.X = !fragment.X;
        }
    }

    public void D() {
        this.K = false;
        this.L = false;
        this.R.u(false);
        X(0);
    }

    public y D0() {
        return this.f735p;
    }

    public final void D1() {
        Iterator it = this.f722c.k().iterator();
        while (it.hasNext()) {
            b1((j0) it.next());
        }
    }

    public void E(Configuration configuration, boolean z10) {
        if (z10 && (this.f743x instanceof o.m)) {
            E1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.b2(configuration);
                if (z10) {
                    fragment.E.E(configuration, true);
                }
            }
        }
    }

    public Fragment E0() {
        return this.f745z;
    }

    public final void E1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
        w wVar = this.f743x;
        if (wVar != null) {
            try {
                wVar.u("  ", null, printWriter, new String[0]);
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

    public boolean F(MenuItem menuItem) {
        if (this.f742w < 1) {
            return false;
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null && fragment.c2(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment F0() {
        return this.A;
    }

    public void F1(k kVar) {
        this.f735p.p(kVar);
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
        Fragment fragment = this.f745z;
        return fragment != null ? fragment.C.G0() : this.E;
    }

    public final void G1() {
        synchronized (this.f720a) {
            try {
                if (!this.f720a.isEmpty()) {
                    this.f729j.j(true);
                    if (O0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z10 = u0() > 0 && T0(this.f745z);
                if (O0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z10);
                }
                this.f729j.j(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean H(Menu menu, MenuInflater menuInflater) {
        if (this.f742w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null && S0(fragment) && fragment.e2(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f724e != null) {
            for (int i10 = 0; i10 < this.f724e.size(); i10++) {
                Fragment fragment2 = (Fragment) this.f724e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.E1();
                }
            }
        }
        this.f724e = arrayList;
        return z10;
    }

    public FragmentStrictMode.b H0() {
        return this.S;
    }

    public void I() {
        this.M = true;
        f0(true);
        c0();
        v();
        X(-1);
        Object obj = this.f743x;
        if (obj instanceof o.n) {
            ((o.n) obj).l(this.f738s);
        }
        Object obj2 = this.f743x;
        if (obj2 instanceof o.m) {
            ((o.m) obj2).d(this.f737r);
        }
        Object obj3 = this.f743x;
        if (obj3 instanceof n.y0) {
            ((n.y0) obj3).e(this.f739t);
        }
        Object obj4 = this.f743x;
        if (obj4 instanceof z0) {
            ((z0) obj4).i(this.f740u);
        }
        Object obj5 = this.f743x;
        if ((obj5 instanceof x.g) && this.f745z == null) {
            ((x.g) obj5).g(this.f741v);
        }
        this.f743x = null;
        this.f744y = null;
        this.f745z = null;
        if (this.f726g != null) {
            this.f729j.h();
            this.f726g = null;
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

    public androidx.lifecycle.b0 J0(Fragment fragment) {
        return this.R.r(fragment);
    }

    public void K(boolean z10) {
        if (z10 && (this.f743x instanceof o.n)) {
            E1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.k2();
                if (z10) {
                    fragment.E.K(true);
                }
            }
        }
    }

    public void K0() {
        f0(true);
        if (!V || this.f727h == null) {
            if (this.f729j.g()) {
                if (O0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                e1();
                return;
            } else {
                if (O0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f726g.k();
                return;
            }
        }
        if (!this.f734o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(s0(this.f727h));
            Iterator it = this.f734o.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    mVar.b((Fragment) it2.next(), true);
                }
            }
        }
        Iterator it3 = this.f727h.f889c.iterator();
        while (it3.hasNext()) {
            Fragment fragment = ((l0.a) it3.next()).f907b;
            if (fragment != null) {
                fragment.f678v = false;
            }
        }
        Iterator it4 = z(new ArrayList(Collections.singletonList(this.f727h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((SpecialEffectsController) it4.next()).f();
        }
        this.f727h = null;
        G1();
        if (O0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f729j.g() + " for  FragmentManager " + this);
        }
    }

    public void L(boolean z10, boolean z11) {
        if (z11 && (this.f743x instanceof n.y0)) {
            E1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.l2(z10);
                if (z11) {
                    fragment.E.L(z10, true);
                }
            }
        }
    }

    public void L0(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.J) {
            return;
        }
        fragment.J = true;
        fragment.X = true ^ fragment.X;
        B1(fragment);
    }

    public void M(Fragment fragment) {
        Iterator it = this.f736q.iterator();
        while (it.hasNext()) {
            ((h0) it.next()).k(this, fragment);
        }
    }

    public void M0(Fragment fragment) {
        if (fragment.f676t && P0(fragment)) {
            this.J = true;
        }
    }

    public void N() {
        for (Fragment fragment : this.f722c.l()) {
            if (fragment != null) {
                fragment.I1(fragment.k1());
                fragment.E.N();
            }
        }
    }

    public boolean N0() {
        return this.M;
    }

    public boolean O(MenuItem menuItem) {
        if (this.f742w < 1) {
            return false;
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null && fragment.m2(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void P(Menu menu) {
        if (this.f742w < 1) {
            return;
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.n2(menu);
            }
        }
    }

    public final boolean P0(Fragment fragment) {
        return (fragment.N && fragment.O) || fragment.E.s();
    }

    public final void Q(Fragment fragment) {
        if (fragment == null || !fragment.equals(k0(fragment.f670n))) {
            return;
        }
        fragment.r2();
    }

    public final boolean Q0() {
        Fragment fragment = this.f745z;
        if (fragment == null) {
            return true;
        }
        return fragment.i1() && this.f745z.N0().Q0();
    }

    public void R() {
        X(5);
    }

    public boolean R0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.k1();
    }

    public void S(boolean z10, boolean z11) {
        if (z11 && (this.f743x instanceof z0)) {
            E1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.p2(z10);
                if (z11) {
                    fragment.E.S(z10, true);
                }
            }
        }
    }

    public boolean S0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.m1();
    }

    public boolean T(Menu menu) {
        boolean z10 = false;
        if (this.f742w < 1) {
            return false;
        }
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null && S0(fragment) && fragment.q2(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean T0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.C;
        return fragment.equals(fragmentManager.F0()) && T0(fragmentManager.f745z);
    }

    public void U() {
        G1();
        Q(this.A);
    }

    public boolean U0(int i10) {
        return this.f742w >= i10;
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
            this.f743x.x(fragment, strArr, i10);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f670n, i10));
        this.H.a(strArr);
    }

    public final void X(int i10) {
        try {
            this.f721b = true;
            this.f722c.d(i10);
            Y0(i10, false);
            Iterator it = y().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).q();
            }
            this.f721b = false;
            f0(true);
        } catch (Throwable th) {
            this.f721b = false;
            throw th;
        }
    }

    public void X0(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.F == null) {
            this.f743x.y(fragment, intent, i10, bundle);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f670n, i10));
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
        if (this.f743x == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f742w) {
            this.f742w = i10;
            this.f722c.t();
            D1();
            if (this.J && (wVar = this.f743x) != null && this.f742w == 7) {
                wVar.z();
                this.J = false;
            }
        }
    }

    public void Z() {
        X(2);
    }

    public void Z0() {
        if (this.f743x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.u(false);
        for (Fragment fragment : this.f722c.o()) {
            if (fragment != null) {
                fragment.r1();
            }
        }
    }

    public final void a0() {
        if (this.N) {
            this.N = false;
            D1();
        }
    }

    public void a1(t tVar) {
        View view;
        for (j0 j0Var : this.f722c.k()) {
            Fragment fragmentK = j0Var.k();
            if (fragmentK.H == tVar.getId() && (view = fragmentK.R) != null && view.getParent() == null) {
                fragmentK.Q = tVar;
                j0Var.b();
            }
        }
    }

    public void b0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f722c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f724e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) this.f724e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        int size2 = this.f723d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size2; i11++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f723d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.A(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f730k.get());
        synchronized (this.f720a) {
            try {
                int size3 = this.f720a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        n nVar = (n) this.f720a.get(i12);
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
        printWriter.println(this.f743x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f744y);
        if (this.f745z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f745z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f742w);
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
        if (fragmentK.S) {
            if (this.f721b) {
                this.N = true;
            } else {
                fragmentK.S = false;
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
            if (this.f743x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            t();
        }
        synchronized (this.f720a) {
            try {
                if (this.f743x == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f720a.add(nVar);
                    v1();
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
        if (this.f721b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f743x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f743x.t().getLooper()) {
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
            this.f721b = true;
            try {
                p1(this.O, this.P);
            } finally {
                u();
            }
        }
        G1();
        a0();
        this.f722c.b();
        return z11;
    }

    public boolean f1(int i10, int i11) {
        if (i10 >= 0) {
            return h1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public void g0(n nVar, boolean z10) {
        if (z10 && (this.f743x == null || this.M)) {
            return;
        }
        e0(z10);
        if (nVar.a(this.O, this.P)) {
            this.f721b = true;
            try {
                p1(this.O, this.P);
            } finally {
                u();
            }
        }
        G1();
        a0();
        this.f722c.b();
    }

    public boolean g1(String str, int i10) {
        return h1(str, -1, i10);
    }

    public final boolean h1(String str, int i10, int i11) {
        f0(false);
        e0(true);
        Fragment fragment = this.A;
        if (fragment != null && i10 < 0 && str == null && fragment.z0().e1()) {
            return true;
        }
        boolean zI1 = i1(this.O, this.P, str, i10, i11);
        if (zI1) {
            this.f721b = true;
            try {
                p1(this.O, this.P);
            } finally {
                u();
            }
        }
        G1();
        a0();
        this.f722c.b();
        return zI1;
    }

    public final void i0(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        boolean z10 = ((androidx.fragment.app.a) arrayList.get(i10)).f904r;
        ArrayList arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.f722c.o());
        Fragment fragmentF0 = F0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i12);
            fragmentF0 = !((Boolean) arrayList2.get(i12)).booleanValue() ? aVar.E(this.Q, fragmentF0) : aVar.H(this.Q, fragmentF0);
            z11 = z11 || aVar.f895i;
        }
        this.Q.clear();
        if (!z10 && this.f742w >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i13)).f889c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((l0.a) it.next()).f907b;
                    if (fragment != null && fragment.C != null) {
                        this.f722c.r(A(fragment));
                    }
                }
            }
        }
        h0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i11 - 1)).booleanValue();
        if (z11 && !this.f734o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(s0((androidx.fragment.app.a) it2.next()));
            }
            if (this.f727h == null) {
                Iterator it3 = this.f734o.iterator();
                while (it3.hasNext()) {
                    m mVar = (m) it3.next();
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        mVar.c((Fragment) it4.next(), zBooleanValue);
                    }
                }
                Iterator it5 = this.f734o.iterator();
                while (it5.hasNext()) {
                    m mVar2 = (m) it5.next();
                    Iterator it6 = linkedHashSet.iterator();
                    while (it6.hasNext()) {
                        mVar2.b((Fragment) it6.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = aVar2.f889c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((l0.a) aVar2.f889c.get(size)).f907b;
                    if (fragment2 != null) {
                        A(fragment2).m();
                    }
                }
            } else {
                Iterator it7 = aVar2.f889c.iterator();
                while (it7.hasNext()) {
                    Fragment fragment3 = ((l0.a) it7.next()).f907b;
                    if (fragment3 != null) {
                        A(fragment3).m();
                    }
                }
            }
        }
        Y0(this.f742w, true);
        for (SpecialEffectsController specialEffectsController : z(arrayList, i10, i11)) {
            specialEffectsController.B(zBooleanValue);
            specialEffectsController.x();
            specialEffectsController.n();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i10);
            if (((Boolean) arrayList2.get(i10)).booleanValue() && aVar3.f821v >= 0) {
                aVar3.f821v = -1;
            }
            aVar3.G();
            i10++;
        }
        if (z11) {
            q1();
        }
    }

    public boolean i1(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int iL0 = l0(str, i10, (i11 & 1) != 0);
        if (iL0 < 0) {
            return false;
        }
        for (int size = this.f723d.size() - 1; size >= iL0; size--) {
            arrayList.add((androidx.fragment.app.a) this.f723d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void j(androidx.fragment.app.a aVar) {
        this.f723d.add(aVar);
    }

    public boolean j0() {
        boolean zF0 = f0(true);
        r0();
        return zF0;
    }

    public boolean j1(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = this.f723d;
        androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList3.get(arrayList3.size() - 1);
        this.f727h = aVar;
        Iterator it = aVar.f889c.iterator();
        while (it.hasNext()) {
            Fragment fragment = ((l0.a) it.next()).f907b;
            if (fragment != null) {
                fragment.f678v = true;
            }
        }
        return i1(arrayList, arrayList2, null, -1, 0);
    }

    public j0 k(Fragment fragment) {
        String str = fragment.f654a0;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (O0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        j0 j0VarA = A(fragment);
        fragment.C = this;
        this.f722c.r(j0VarA);
        if (!fragment.K) {
            this.f722c.a(fragment);
            fragment.f677u = false;
            if (fragment.R == null) {
                fragment.X = false;
            }
            if (P0(fragment)) {
                this.J = true;
            }
        }
        return j0VarA;
    }

    public Fragment k0(String str) {
        return this.f722c.f(str);
    }

    public void k1() {
        d0(new p(), false);
    }

    public void l(h0 h0Var) {
        this.f736q.add(h0Var);
    }

    public final int l0(String str, int i10, boolean z10) {
        if (this.f723d.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f723d.size() - 1;
        }
        int size = this.f723d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f723d.get(size);
            if ((str != null && str.equals(aVar.F())) || (i10 >= 0 && i10 == aVar.f821v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f723d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f723d.get(size - 1);
            if ((str == null || !str.equals(aVar2.F())) && (i10 < 0 || i10 != aVar2.f821v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public void l1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.C != this) {
            E1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f670n);
    }

    public void m(m mVar) {
        this.f734o.add(mVar);
    }

    public Fragment m0(int i10) {
        return this.f722c.g(i10);
    }

    public void m1(k kVar, boolean z10) {
        this.f735p.o(kVar, z10);
    }

    public int n() {
        return this.f730k.getAndIncrement();
    }

    public Fragment n0(String str) {
        return this.f722c.h(str);
    }

    public void n1(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.B);
        }
        boolean zL1 = fragment.l1();
        if (fragment.K && zL1) {
            return;
        }
        this.f722c.u(fragment);
        if (P0(fragment)) {
            this.J = true;
        }
        fragment.f677u = true;
        B1(fragment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(w wVar, s sVar, Fragment fragment) {
        String str;
        if (this.f743x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f743x = wVar;
        this.f744y = sVar;
        this.f745z = fragment;
        if (fragment != null) {
            l(new g(fragment));
        } else if (wVar instanceof h0) {
            l((h0) wVar);
        }
        if (this.f745z != null) {
            G1();
        }
        if (wVar instanceof androidx.activity.r) {
            androidx.activity.r rVar = (androidx.activity.r) wVar;
            OnBackPressedDispatcher onBackPressedDispatcherH = rVar.h();
            this.f726g = onBackPressedDispatcherH;
            androidx.lifecycle.h hVar = rVar;
            if (fragment != null) {
                hVar = fragment;
            }
            onBackPressedDispatcherH.h(hVar, this.f729j);
        }
        if (fragment != null) {
            this.R = fragment.C.v0(fragment);
        } else if (wVar instanceof androidx.lifecycle.c0) {
            this.R = g0.p(((androidx.lifecycle.c0) wVar).D());
        } else {
            this.R = new g0(false);
        }
        this.R.u(V0());
        this.f722c.A(this.R);
        Object obj = this.f743x;
        if ((obj instanceof l0.d) && fragment == null) {
            androidx.savedstate.a aVarT = ((l0.d) obj).T();
            aVarT.h("android:support:fragments", new a.c() { // from class: androidx.fragment.app.d0
                @Override // androidx.savedstate.a.c
                public final Bundle b() {
                    return this.f832a.t1();
                }
            });
            Bundle bundleB = aVarT.b("android:support:fragments");
            if (bundleB != null) {
                r1(bundleB);
            }
        }
        Object obj2 = this.f743x;
        if (obj2 instanceof androidx.activity.result.c) {
            ActivityResultRegistry activityResultRegistryF = ((androidx.activity.result.c) obj2).f();
            if (fragment != null) {
                str = fragment.f670n + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.F = activityResultRegistryF.j(str2 + "StartActivityForResult", new e.h(), new h());
            this.G = activityResultRegistryF.j(str2 + "StartIntentSenderForResult", new j(), new i());
            this.H = activityResultRegistryF.j(str2 + "RequestPermissions", new e.f(), new a());
        }
        Object obj3 = this.f743x;
        if (obj3 instanceof o.m) {
            ((o.m) obj3).b(this.f737r);
        }
        Object obj4 = this.f743x;
        if (obj4 instanceof o.n) {
            ((o.n) obj4).m(this.f738s);
        }
        Object obj5 = this.f743x;
        if (obj5 instanceof n.y0) {
            ((n.y0) obj5).n(this.f739t);
        }
        Object obj6 = this.f743x;
        if (obj6 instanceof z0) {
            ((z0) obj6).o(this.f740u);
        }
        Object obj7 = this.f743x;
        if ((obj7 instanceof x.g) && fragment == null) {
            ((x.g) obj7).c(this.f741v);
        }
    }

    public Fragment o0(String str) {
        return this.f722c.i(str);
    }

    public void o1(h0 h0Var) {
        this.f736q.remove(h0Var);
    }

    public void p(Fragment fragment) {
        if (O0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            if (fragment.f676t) {
                return;
            }
            this.f722c.a(fragment);
            if (O0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (P0(fragment)) {
                this.J = true;
            }
        }
    }

    public final void p1(ArrayList arrayList, ArrayList arrayList2) {
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
            if (!((androidx.fragment.app.a) arrayList.get(i10)).f904r) {
                if (i11 != i10) {
                    i0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                    while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i11)).f904r) {
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

    public l0 q() {
        return new androidx.fragment.app.a(this);
    }

    public final void q1() {
        for (int i10 = 0; i10 < this.f734o.size(); i10++) {
            ((m) this.f734o.get(i10)).onBackStackChanged();
        }
    }

    public void r() {
        androidx.fragment.app.a aVar = this.f727h;
        if (aVar != null) {
            aVar.f820u = false;
            aVar.i();
            j0();
            Iterator it = this.f734o.iterator();
            while (it.hasNext()) {
                ((m) it.next()).d();
            }
        }
    }

    public final void r0() {
        Iterator it = y().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).r();
        }
    }

    public void r1(Parcelable parcelable) {
        j0 j0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f743x.r().getClassLoader());
                this.f732m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f743x.r().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f722c.x(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.f722c.v();
        Iterator it = fragmentManagerState.f770e.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f722c.B((String) it.next(), null);
            if (bundleB != null) {
                Fragment fragmentN = this.R.n(((FragmentState) bundleB.getParcelable("state")).f779j);
                if (fragmentN != null) {
                    if (O0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentN);
                    }
                    j0Var = new j0(this.f735p, this.f722c, fragmentN, bundleB);
                } else {
                    j0Var = new j0(this.f735p, this.f722c, this.f743x.r().getClassLoader(), z0(), bundleB);
                }
                Fragment fragmentK = j0Var.k();
                fragmentK.f664j = bundleB;
                fragmentK.C = this;
                if (O0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.f670n + "): " + fragmentK);
                }
                j0Var.o(this.f743x.r().getClassLoader());
                this.f722c.r(j0Var);
                j0Var.t(this.f742w);
            }
        }
        for (Fragment fragment : this.R.q()) {
            if (!this.f722c.c(fragment.f670n)) {
                if (O0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f770e);
                }
                this.R.t(fragment);
                fragment.C = this;
                j0 j0Var2 = new j0(this.f735p, this.f722c, fragment);
                j0Var2.t(1);
                j0Var2.m();
                fragment.f677u = true;
                j0Var2.m();
            }
        }
        this.f722c.w(fragmentManagerState.f771j);
        if (fragmentManagerState.f772k != null) {
            this.f723d = new ArrayList(fragmentManagerState.f772k.length);
            int i10 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f772k;
                if (i10 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = backStackRecordStateArr[i10].b(this);
                if (O0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + aVarB.f821v + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
                    aVarB.B("  ", printWriter, false);
                    printWriter.close();
                }
                this.f723d.add(aVarB);
                i10++;
            }
        } else {
            this.f723d = new ArrayList();
        }
        this.f730k.set(fragmentManagerState.f773l);
        String str3 = fragmentManagerState.f774m;
        if (str3 != null) {
            Fragment fragmentK0 = k0(str3);
            this.A = fragmentK0;
            Q(fragmentK0);
        }
        ArrayList arrayList = fragmentManagerState.f775n;
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                this.f731l.put((String) arrayList.get(i11), (BackStackState) fragmentManagerState.f776o.get(i11));
            }
        }
        this.I = new ArrayDeque(fragmentManagerState.f777p);
    }

    public boolean s() {
        boolean zP0 = false;
        for (Fragment fragment : this.f722c.l()) {
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
        for (int i10 = 0; i10 < aVar.f889c.size(); i10++) {
            Fragment fragment = ((l0.a) aVar.f889c.get(i10)).f907b;
            if (fragment != null && aVar.f895i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public final void t() {
        if (V0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean t0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f720a) {
            if (this.f720a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f720a.size();
                boolean zA = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zA |= ((n) this.f720a.get(i10)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f720a.clear();
                this.f743x.t().removeCallbacks(this.T);
            }
        }
    }

    public Bundle t1() {
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        r0();
        c0();
        f0(true);
        this.K = true;
        this.R.u(true);
        ArrayList arrayListY = this.f722c.y();
        HashMap mapM = this.f722c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f722c.z();
            int size = this.f723d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState((androidx.fragment.app.a) this.f723d.get(i10));
                    if (O0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f723d.get(i10));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f770e = arrayListY;
            fragmentManagerState.f771j = arrayListZ;
            fragmentManagerState.f772k = backStackRecordStateArr;
            fragmentManagerState.f773l = this.f730k.get();
            Fragment fragment = this.A;
            if (fragment != null) {
                fragmentManagerState.f774m = fragment.f670n;
            }
            fragmentManagerState.f775n.addAll(this.f731l.keySet());
            fragmentManagerState.f776o.addAll(this.f731l.values());
            fragmentManagerState.f777p = new ArrayList(this.I);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f732m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f732m.get(str));
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

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f745z;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f745z)));
            sb2.append("}");
        } else {
            w wVar = this.f743x;
            if (wVar != null) {
                sb2.append(wVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f743x)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u() {
        this.f721b = false;
        this.P.clear();
        this.O.clear();
    }

    public int u0() {
        return this.f723d.size() + (this.f727h != null ? 1 : 0);
    }

    public Fragment.SavedState u1(Fragment fragment) {
        j0 j0VarN = this.f722c.n(fragment.f670n);
        if (j0VarN == null || !j0VarN.k().equals(fragment)) {
            E1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return j0VarN.q();
    }

    public final void v() {
        w wVar = this.f743x;
        if (wVar instanceof androidx.lifecycle.c0 ? this.f722c.p().s() : wVar.r() instanceof Activity ? !((Activity) this.f743x.r()).isChangingConfigurations() : true) {
            Iterator it = this.f731l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f615e.iterator();
                while (it2.hasNext()) {
                    this.f722c.p().l((String) it2.next(), false);
                }
            }
        }
    }

    public final g0 v0(Fragment fragment) {
        return this.R.o(fragment);
    }

    public void v1() {
        synchronized (this.f720a) {
            try {
                if (this.f720a.size() == 1) {
                    this.f743x.t().removeCallbacks(this.T);
                    this.f743x.t().post(this.T);
                    G1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(String str) {
        this.f732m.remove(str);
        if (O0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public s w0() {
        return this.f744y;
    }

    public void w1(Fragment fragment, boolean z10) {
        ViewGroup viewGroupY0 = y0(fragment);
        if (viewGroupY0 == null || !(viewGroupY0 instanceof t)) {
            return;
        }
        ((t) viewGroupY0).setDrawDisappearingViewsLast(!z10);
    }

    public final void x(String str) {
        l lVar = (l) this.f733n.remove(str);
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
            E1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentK0;
    }

    public final void x1(String str, Bundle bundle) {
        l lVar = (l) this.f733n.get(str);
        if (lVar == null || !lVar.b(Lifecycle.State.STARTED)) {
            this.f732m.put(str, bundle);
        } else {
            lVar.a(str, bundle);
        }
        if (O0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    public final Set y() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f722c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((j0) it.next()).k().Q;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.v(viewGroup, G0()));
            }
        }
        return hashSet;
    }

    public final ViewGroup y0(Fragment fragment) {
        ViewGroup viewGroup = fragment.Q;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.H > 0 && this.f744y.p()) {
            View viewJ = this.f744y.j(fragment.H);
            if (viewJ instanceof ViewGroup) {
                return (ViewGroup) viewJ;
            }
        }
        return null;
    }

    public final void y1(final String str, androidx.lifecycle.h hVar, final i0 i0Var) {
        final Lifecycle lifecycleK0 = hVar.k0();
        if (lifecycleK0.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        androidx.lifecycle.f fVar = new androidx.lifecycle.f() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.f
            public void a(androidx.lifecycle.h hVar2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f732m.get(str)) != null) {
                    i0Var.a(str, bundle);
                    FragmentManager.this.w(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycleK0.c(this);
                    FragmentManager.this.f733n.remove(str);
                }
            }
        };
        l lVar = (l) this.f733n.put(str, new l(lifecycleK0, i0Var, fVar));
        if (lVar != null) {
            lVar.c();
        }
        if (O0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycleK0 + " and listener " + i0Var);
        }
        lifecycleK0.a(fVar);
    }

    public Set z(ArrayList arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i10)).f889c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((l0.a) it.next()).f907b;
                if (fragment != null && (viewGroup = fragment.Q) != null) {
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
        Fragment fragment = this.f745z;
        return fragment != null ? fragment.C.z0() : this.C;
    }

    public void z1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(k0(fragment.f670n)) && (fragment.D == null || fragment.C == this)) {
            fragment.f655b0 = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }
}
