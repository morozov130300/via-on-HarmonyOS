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
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e0;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.savedstate.a;
import e.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import n.b1;
import n.y0;
import n.z0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ComponentActivity extends n.d implements androidx.lifecycle.h, c0, androidx.lifecycle.d, l0.d, r, androidx.activity.result.c, o.m, o.n, y0, z0, x.g, n {
    public final CopyOnWriteArrayList A;
    public boolean B;
    public boolean C;

    /* renamed from: k, reason: collision with root package name */
    public final d.a f423k = new d.a();

    /* renamed from: l, reason: collision with root package name */
    public final x.h f424l = new x.h(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f488e.E();
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final androidx.lifecycle.i f425m = new androidx.lifecycle.i(this);

    /* renamed from: n, reason: collision with root package name */
    public final l0.c f426n;

    /* renamed from: o, reason: collision with root package name */
    public b0 f427o;

    /* renamed from: p, reason: collision with root package name */
    public y.b f428p;

    /* renamed from: q, reason: collision with root package name */
    public OnBackPressedDispatcher f429q;

    /* renamed from: r, reason: collision with root package name */
    public final f f430r;

    /* renamed from: s, reason: collision with root package name */
    public final m f431s;

    /* renamed from: t, reason: collision with root package name */
    public int f432t;

    /* renamed from: u, reason: collision with root package name */
    public final AtomicInteger f433u;

    /* renamed from: v, reason: collision with root package name */
    public final ActivityResultRegistry f434v;

    /* renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList f435w;

    /* renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList f436x;

    /* renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList f437y;

    /* renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList f438z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ActivityResultRegistry {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0010a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f444e;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ a.C0063a f445j;

            public RunnableC0010a(int i10, a.C0063a c0063a) {
                this.f444e = i10;
                this.f445j = c0063a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f444e, this.f445j.a());
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class b implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f447e;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f448j;

            public b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f447e = i10;
                this.f448j = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f447e, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f448j));
            }
        }

        public a() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public void f(int i10, e.a aVar, Object obj, n.b bVar) {
            Bundle bundleExtra;
            int i11;
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0063a c0063aB = aVar.b(componentActivity, obj);
            if (c0063aB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0010a(i10, c0063aB));
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
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                i11 = i10;
            }
            try {
                n.a.o(componentActivity, intentSenderRequest.d(), i11, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                new Handler(Looper.getMainLooper()).post(new b(i11, e));
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public Object f451a;

        /* renamed from: b, reason: collision with root package name */
        public b0 f452b;
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface f extends Executor {
        void a();

        void b(View view);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: j, reason: collision with root package name */
        public Runnable f454j;

        /* renamed from: e, reason: collision with root package name */
        public final long f453e = SystemClock.uptimeMillis() + 10000;

        /* renamed from: k, reason: collision with root package name */
        public boolean f455k = false;

        public g() {
        }

        public static /* synthetic */ void c(g gVar) {
            Runnable runnable = gVar.f454j;
            if (runnable != null) {
                runnable.run();
                gVar.f454j = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void a() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.f
        public void b(View view) {
            if (this.f455k) {
                return;
            }
            this.f455k = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f454j = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f455k) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.g.c(this.f492e);
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
            Runnable runnable = this.f454j;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f453e) {
                    this.f455k = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f454j = null;
            if (ComponentActivity.this.f431s.c()) {
                this.f455k = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        l0.c cVarA = l0.c.a(this);
        this.f426n = cVarA;
        this.f429q = null;
        f fVarA = A();
        this.f430r = fVarA;
        this.f431s = new m(fVarA, new q7.a() { // from class: androidx.activity.e
            @Override // q7.a
            public final Object invoke() {
                return ComponentActivity.t(this.f489e);
            }
        });
        this.f433u = new AtomicInteger();
        this.f434v = new a();
        this.f435w = new CopyOnWriteArrayList();
        this.f436x = new CopyOnWriteArrayList();
        this.f437y = new CopyOnWriteArrayList();
        this.f438z = new CopyOnWriteArrayList();
        this.A = new CopyOnWriteArrayList();
        this.B = false;
        this.C = false;
        if (k0() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i10 = Build.VERSION.SDK_INT;
        k0().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.f
            public void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        k0().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.f
            public void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.f423k.b();
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.D().a();
                    }
                    ComponentActivity.this.f430r.a();
                }
            }
        });
        k0().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.f
            public void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                ComponentActivity.this.B();
                ComponentActivity.this.k0().c(this);
            }
        });
        cVarA.c();
        SavedStateHandleSupport.c(this);
        if (i10 <= 23) {
            k0().a(new ImmLeaksCleaner(this));
        }
        T().h("android:support:activity-result", new a.c() { // from class: androidx.activity.f
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return ComponentActivity.s(this.f490a);
            }
        });
        y(new d.b() { // from class: androidx.activity.g
            @Override // d.b
            public final void a(Context context) {
                ComponentActivity.r(this.f491a, context);
            }
        });
    }

    public static /* synthetic */ void r(ComponentActivity componentActivity, Context context) {
        Bundle bundleB = componentActivity.T().b("android:support:activity-result");
        if (bundleB != null) {
            componentActivity.f434v.g(bundleB);
        }
    }

    public static /* synthetic */ Bundle s(ComponentActivity componentActivity) {
        componentActivity.getClass();
        Bundle bundle = new Bundle();
        componentActivity.f434v.h(bundle);
        return bundle;
    }

    public static /* synthetic */ j7.f t(ComponentActivity componentActivity) {
        componentActivity.reportFullyDrawn();
        return null;
    }

    public final f A() {
        return new g();
    }

    public void B() {
        if (this.f427o == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f427o = eVar.f452b;
            }
            if (this.f427o == null) {
                this.f427o = new b0();
            }
        }
    }

    public void C() {
        d0.a(getWindow().getDecorView(), this);
        e0.a(getWindow().getDecorView(), this);
        l0.e.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
        t.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.lifecycle.c0
    public b0 D() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        B();
        return this.f427o;
    }

    public void E() {
        invalidateOptionsMenu();
    }

    public Object F() {
        return null;
    }

    @Override // l0.d
    public final androidx.savedstate.a T() {
        return this.f426n.b();
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C();
        this.f430r.b(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // o.m
    public final void b(w.a aVar) {
        this.f435w.add(aVar);
    }

    @Override // x.g
    public void c(x.i iVar) {
        this.f424l.a(iVar);
    }

    @Override // o.m
    public final void d(w.a aVar) {
        this.f435w.remove(aVar);
    }

    @Override // n.y0
    public final void e(w.a aVar) {
        this.f438z.remove(aVar);
    }

    @Override // androidx.activity.result.c
    public final ActivityResultRegistry f() {
        return this.f434v;
    }

    @Override // x.g
    public void g(x.i iVar) {
        this.f424l.f(iVar);
    }

    @Override // androidx.activity.r
    public final OnBackPressedDispatcher h() {
        if (this.f429q == null) {
            this.f429q = new OnBackPressedDispatcher(new b());
            k0().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.f
                public void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                    if (event != Lifecycle.Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    ComponentActivity.this.f429q.n(d.a((ComponentActivity) hVar));
                }
            });
        }
        return this.f429q;
    }

    @Override // n.z0
    public final void i(w.a aVar) {
        this.A.remove(aVar);
    }

    @Override // androidx.lifecycle.h
    public Lifecycle k0() {
        return this.f425m;
    }

    @Override // o.n
    public final void l(w.a aVar) {
        this.f436x.remove(aVar);
    }

    @Override // o.n
    public final void m(w.a aVar) {
        this.f436x.add(aVar);
    }

    @Override // n.y0
    public final void n(w.a aVar) {
        this.f438z.add(aVar);
    }

    @Override // n.z0
    public final void o(w.a aVar) {
        this.A.add(aVar);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f434v.b(i10, i11, intent)) {
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
        Iterator it = this.f435w.iterator();
        while (it.hasNext()) {
            ((w.a) it.next()).accept(configuration);
        }
    }

    @Override // n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f426n.d(bundle);
        this.f423k.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.o.e(this);
        int i10 = this.f432t;
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
        this.f424l.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f424l.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.B) {
            return;
        }
        Iterator it = this.f438z.iterator();
        while (it.hasNext()) {
            ((w.a) it.next()).accept(new n.e(z10));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.B = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.B = false;
            Iterator it = this.f438z.iterator();
            while (it.hasNext()) {
                ((w.a) it.next()).accept(new n.e(z10, configuration));
            }
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f437y.iterator();
        while (it.hasNext()) {
            ((w.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f424l.c(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.C) {
            return;
        }
        Iterator it = this.A.iterator();
        while (it.hasNext()) {
            ((w.a) it.next()).accept(new b1(z10));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.C = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.C = false;
            Iterator it = this.A.iterator();
            while (it.hasNext()) {
                ((w.a) it.next()).accept(new b1(z10, configuration));
            }
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f424l.e(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f434v.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object objF = F();
        b0 b0Var = this.f427o;
        if (b0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            b0Var = eVar.f452b;
        }
        if (b0Var == null && objF == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f451a = objF;
        eVar2.f452b = b0Var;
        return eVar2;
    }

    @Override // n.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycleK0 = k0();
        if (lifecycleK0 instanceof androidx.lifecycle.i) {
            ((androidx.lifecycle.i) lifecycleK0).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f426n.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator it = this.f436x.iterator();
        while (it.hasNext()) {
            ((w.a) it.next()).accept(Integer.valueOf(i10));
        }
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (n0.b.d()) {
                n0.b.a("reportFullyDrawn() for ComponentActivity");
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 19) {
                super.reportFullyDrawn();
            } else if (i10 == 19 && o.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
            this.f431s.b();
            n0.b.b();
        } catch (Throwable th) {
            n0.b.b();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        C();
        this.f430r.b(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        C();
        this.f430r.b(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C();
        this.f430r.b(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // androidx.lifecycle.d
    public y.b w() {
        if (this.f428p == null) {
            this.f428p = new v(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f428p;
    }

    @Override // androidx.lifecycle.d
    public h0.a x() {
        h0.d dVar = new h0.d();
        if (getApplication() != null) {
            dVar.c(y.a.f1083g, getApplication());
        }
        dVar.c(SavedStateHandleSupport.f1027a, this);
        dVar.c(SavedStateHandleSupport.f1028b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(SavedStateHandleSupport.f1029c, getIntent().getExtras());
        }
        return dVar;
    }

    public final void y(d.b bVar) {
        this.f423k.a(bVar);
    }

    public final void z(w.a aVar) {
        this.f437y.add(aVar);
    }
}
