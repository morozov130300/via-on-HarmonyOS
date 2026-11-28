package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import n.b1;
import n.y0;
import n.z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivity extends n.d implements androidx.lifecycle.j, e0, androidx.lifecycle.f, m0.d, r, androidx.activity.result.c, o.m, o.n, y0, z0, y.g, n {
    public final CopyOnWriteArrayList A;
    public final CopyOnWriteArrayList B;
    public final CopyOnWriteArrayList C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d.a f328m = new d.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y.h f329n = new y.h(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f391c.D();
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.lifecycle.k f330o = new androidx.lifecycle.k(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m0.c f331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d0 f332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a0.b f333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnBackPressedDispatcher f334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m f336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicInteger f338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ActivityResultRegistry f339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList f340y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList f341z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ActivityResultRegistry {

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class RunnableC0009a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f347c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ e.a.C0058a f348e;

            public RunnableC0009a(int i10, e.a.C0058a c0058a) {
                this.f347c = i10;
                this.f348e = c0058a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f347c, this.f348e.a());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f350c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f351e;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f350c = i10;
                this.f351e = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f350c, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f351e));
            }
        }

        public a() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public void f(int i10, e.a aVar, Object obj, n.b bVar) {
            Bundle bundleExtra;
            int i11;
            ComponentActivity componentActivity = ComponentActivity.this;
            e.a.C0058a c0058aB = aVar.b(componentActivity, obj);
            if (c0058aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0009a(i10, c0058aB));
                return;
            }
            Intent intentA = aVar.a(componentActivity, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                n.a.m(componentActivity, stringArrayExtra, i10);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                n.a.n(componentActivity, intentA, i10, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i11 = i10;
                try {
                    n.a.o(componentActivity, intentSenderRequest.d(), i11, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
                } catch (IntentSender.SendIntentException e10) {
                    e = e10;
                    new Handler(Looper.getMainLooper()).post(new b(i11, e));
                }
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                i11 = i10;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            } catch (NullPointerException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e11;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d0 f355b;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface f extends Executor {
        void a();

        void e(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f357e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f356c = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f358m = false;

        public g() {
        }

        public static /* synthetic */ void b(g gVar) {
            Runnable runnable = gVar.f357e;
            if (runnable != null) {
                runnable.run();
                gVar.f357e = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void a() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.f
        public void e(View view) {
            if (this.f358m) {
                return;
            }
            this.f358m = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f357e = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f358m) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.g.b(this.f395c);
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f357e;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f356c) {
                    this.f358m = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f357e = null;
            if (ComponentActivity.this.f336u.c()) {
                this.f358m = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        m0.c cVarA = m0.c.a(this);
        this.f331p = cVarA;
        this.f334s = null;
        f fVarZ = z();
        this.f335t = fVarZ;
        this.f336u = new m(fVarZ, new p7.a() { // from class: androidx.activity.e
            @Override // p7.a
            public final Object invoke() {
                return ComponentActivity.s(this.f392c);
            }
        });
        this.f338w = new AtomicInteger();
        this.f339x = new a();
        this.f340y = new CopyOnWriteArrayList();
        this.f341z = new CopyOnWriteArrayList();
        this.A = new CopyOnWriteArrayList();
        this.B = new CopyOnWriteArrayList();
        this.C = new CopyOnWriteArrayList();
        this.D = false;
        this.E = false;
        if (h0() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i10 = Build.VERSION.SDK_INT;
        h0().a(new androidx.lifecycle.h() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.h
            public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        h0().a(new androidx.lifecycle.h() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.h
            public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.f328m.b();
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.B().a();
                    }
                    ComponentActivity.this.f335t.a();
                }
            }
        });
        h0().a(new androidx.lifecycle.h() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.h
            public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                ComponentActivity.this.A();
                ComponentActivity.this.h0().c(this);
            }
        });
        cVarA.c();
        SavedStateHandleSupport.c(this);
        if (i10 <= 23) {
            h0().a(new ImmLeaksCleaner(this));
        }
        Q().h("android:support:activity-result", new androidx.savedstate.a.c() { // from class: androidx.activity.f
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return ComponentActivity.r(this.f393a);
            }
        });
        x(new d.b() { // from class: androidx.activity.g
            @Override // d.b
            public final void a(Context context) {
                ComponentActivity.q(this.f394a, context);
            }
        });
    }

    public static /* synthetic */ void q(ComponentActivity componentActivity, Context context) {
        Bundle bundleB = componentActivity.Q().b("android:support:activity-result");
        if (bundleB != null) {
            componentActivity.f339x.g(bundleB);
        }
    }

    public static /* synthetic */ Bundle r(ComponentActivity componentActivity) {
        componentActivity.getClass();
        Bundle bundle = new Bundle();
        componentActivity.f339x.h(bundle);
        return bundle;
    }

    public static /* synthetic */ d7.h s(ComponentActivity componentActivity) {
        componentActivity.reportFullyDrawn();
        return null;
    }

    public void A() {
        if (this.f332q == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f332q = eVar.f355b;
            }
            if (this.f332q == null) {
                this.f332q = new d0();
            }
        }
    }

    @Override // androidx.lifecycle.e0
    public d0 B() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        A();
        return this.f332q;
    }

    public void C() {
        f0.a(getWindow().getDecorView(), this);
        g0.a(getWindow().getDecorView(), this);
        m0.e.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    public void D() {
        invalidateOptionsMenu();
    }

    public Object E() {
        return null;
    }

    @Override // m0.d
    public final androidx.savedstate.a Q() {
        return this.f331p.b();
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C();
        this.f335t.e(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // y.g
    public void b(y.i iVar) {
        this.f329n.a(iVar);
    }

    @Override // o.m
    public final void c(x.a aVar) {
        this.f340y.add(aVar);
    }

    @Override // n.z0
    public final void d(x.a aVar) {
        this.C.add(aVar);
    }

    @Override // n.y0
    public final void e(x.a aVar) {
        this.B.add(aVar);
    }

    @Override // o.n
    public final void f(x.a aVar) {
        this.f341z.remove(aVar);
    }

    @Override // androidx.activity.result.c
    public final ActivityResultRegistry g() {
        return this.f339x;
    }

    @Override // androidx.activity.r
    public final OnBackPressedDispatcher h() {
        if (this.f334s == null) {
            this.f334s = new OnBackPressedDispatcher(new b());
            h0().a(new androidx.lifecycle.h() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.h
                public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                    if (event != Lifecycle.Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    ComponentActivity.this.f334s.n(d.a((ComponentActivity) jVar));
                }
            });
        }
        return this.f334s;
    }

    @Override // androidx.lifecycle.j
    public Lifecycle h0() {
        return this.f330o;
    }

    @Override // o.n
    public final void i(x.a aVar) {
        this.f341z.add(aVar);
    }

    @Override // y.g
    public void j(y.i iVar) {
        this.f329n.f(iVar);
    }

    @Override // o.m
    public final void k(x.a aVar) {
        this.f340y.remove(aVar);
    }

    @Override // n.y0
    public final void m(x.a aVar) {
        this.B.remove(aVar);
    }

    @Override // n.z0
    public final void n(x.a aVar) {
        this.C.remove(aVar);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f339x.b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f340y.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).accept(configuration);
        }
    }

    @Override // n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f331p.d(bundle);
        this.f328m.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.q.e(this);
        int i10 = this.f337v;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f329n.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f329n.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.D) {
            return;
        }
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).accept(new n.e(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.A.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f329n.c(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.E) {
            return;
        }
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).accept(new b1(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f329n.e(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f339x.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object objE = E();
        d0 d0Var = this.f332q;
        if (d0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            d0Var = eVar.f355b;
        }
        if (d0Var == null && objE == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f354a = objE;
        eVar2.f355b = d0Var;
        return eVar2;
    }

    @Override // n.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycleH0 = h0();
        if (lifecycleH0 instanceof androidx.lifecycle.k) {
            ((androidx.lifecycle.k) lifecycleH0).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f331p.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator it = this.f341z.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).accept(Integer.valueOf(i10));
        }
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (o0.b.d()) {
                o0.b.a("reportFullyDrawn() for ComponentActivity");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 19) {
                super.reportFullyDrawn();
            } else if (i10 == 19 && o.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
            this.f336u.b();
        } finally {
            o0.b.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        C();
        this.f335t.e(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // androidx.lifecycle.f
    public a0.b v() {
        if (this.f333r == null) {
            this.f333r = new x(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f333r;
    }

    @Override // androidx.lifecycle.f
    public i0.a w() {
        i0.d dVar = new i0.d();
        if (getApplication() != null) {
            dVar.c(a0.a.f943g, getApplication());
        }
        dVar.c(SavedStateHandleSupport.f930a, this);
        dVar.c(SavedStateHandleSupport.f931b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(SavedStateHandleSupport.f932c, getIntent().getExtras());
        }
        return dVar;
    }

    public final void x(d.b bVar) {
        this.f328m.a(bVar);
    }

    public final void y(x.a aVar) {
        this.A.add(aVar);
    }

    public final f z() {
        return new g();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.D = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.D = false;
            Iterator it = this.B.iterator();
            while (it.hasNext()) {
                ((x.a) it.next()).accept(new n.e(z10, configuration));
            }
        } catch (Throwable th) {
            this.D = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.E = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.E = false;
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                ((x.a) it.next()).accept(new b1(z10, configuration));
            }
        } catch (Throwable th) {
            this.E = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        C();
        this.f335t.e(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C();
        this.f335t.e(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
