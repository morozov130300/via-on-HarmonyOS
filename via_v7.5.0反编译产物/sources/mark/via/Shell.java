package mark.via;

import a7.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.h0;
import androidx.fragment.app.q;
import androidx.lifecycle.f;
import com.tuyafeng.support.utils.FragmentUtils;
import g5.c;
import java.util.concurrent.Callable;
import la.s;
import mark.via.Shell;
import mark.via.browser.q4;
import q8.b;
import u6.g;
import u9.l;
import u9.n;
import w7.a0;
import w7.e0;
import w7.v;
import w8.h;
import x.d;
import x8.h3;
import x8.l0;
import x8.s1;
import y.k0;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Shell extends q implements h0 {
    public l K;
    public b L;
    public Context M = null;
    public boolean N;

    public static /* synthetic */ void R(Shell shell, View view) {
        shell.getClass();
        if (!view.isAttachedToWindow() || shell.isFinishing()) {
            return;
        }
        shell.getWindowManager().updateViewLayout(view, shell.getWindow().getAttributes());
    }

    public static /* synthetic */ void T(Shell shell, d dVar) {
        shell.getClass();
        Object obj = dVar.f14456b;
        if (obj == null) {
            h.h(shell, (h.a) dVar.f14455a);
        } else {
            h.w(shell, (h.a) dVar.f14455a, ((c) obj).f());
        }
    }

    public static /* synthetic */ void U(Shell shell) {
        shell.getClass();
        p8.d.f(shell);
    }

    public static /* synthetic */ void W(View view) {
        k0 k0VarY = r.y(view);
        l0.k((k0VarY == null || k0VarY.e() == null) ? false : true);
    }

    public static /* synthetic */ Boolean X(Shell shell) {
        shell.L.b().i();
        return Boolean.valueOf(shell.L.b().f());
    }

    public static /* synthetic */ d Y(Shell shell, h.a aVar) {
        shell.getClass();
        return new d(aVar, aVar.i() ? h.n(shell, aVar) : null);
    }

    public static /* synthetic */ void Z(Shell shell, Boolean bool) {
        shell.getClass();
        if (bool.booleanValue()) {
            shell.L.e();
        }
    }

    @Override // androidx.fragment.app.h0
    public void V(FragmentManager fragmentManager, Fragment fragment) {
        for (f fVar : K().A0()) {
            if (fVar instanceof m8.c) {
                ((m8.c) fVar).m(fragmentManager, fragment);
            }
        }
    }

    public void a0() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: w7.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return w8.h.k();
            }
        }).h(new g() { // from class: w7.j0
            @Override // u6.g
            public final Object apply(Object obj) {
                return Shell.Y(this.f13720a, (w8.h.a) obj);
            }
        }).k(a.c()).i(q6.b.b()).l(s8.b.a(this))).a(new u6.f() { // from class: w7.z
            @Override // u6.f
            public final void accept(Object obj) {
                Shell.T(this.f14357c, (x.d) obj);
            }
        }, new a0());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        this.M = context;
        String strM0 = s.j().M0();
        if (TextUtils.isEmpty(strM0)) {
            super.attachBaseContext(context);
            return;
        }
        Configuration configuration = new Configuration();
        s1.p(context, configuration, strM0);
        s1.l(configuration);
        super.attachBaseContext(context.createConfigurationContext(configuration));
    }

    public q4 b0() {
        Fragment fragmentN0 = K().n0(q4.class.getName());
        if (fragmentN0 instanceof q4) {
            return (q4) fragmentN0;
        }
        return null;
    }

    public Context c0() {
        Context context = this.M;
        return context == null ? this : context;
    }

    public void d0() {
        e0();
        if (s.o().f()) {
            FragmentUtils.l(this, na.h.class, na.h.a3(1), null);
        } else {
            FragmentUtils.l(this, q4.class, null, q4.class.getName());
        }
    }

    @Override // n.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        q4 q4VarB0 = b0();
        if (q4VarB0 == null || !q4VarB0.o1()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return q4VarB0.Y6(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e0() {
        final Context applicationContext = getApplicationContext();
        x8.h.b(new Runnable() { // from class: w7.h0
            @Override // java.lang.Runnable
            public final void run() {
                p9.a.b(applicationContext);
            }
        });
        x8.f.f(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        tc.a.a("BrowserApp::onConfigurationChanged, check shouldNightMode2Change", new Object[0]);
        super.onConfigurationChanged(configuration);
        if (this.K.p0(com.tuyafeng.support.utils.q.a(this))) {
            boolean zE = this.K.e();
            setTheme(zE ? v.f14324a : v.f14325b);
            for (Fragment fragment : K().A0()) {
                if (fragment != 0 && !fragment.h1() && (fragment instanceof m8.b)) {
                    ((m8.b) fragment).b0(zE);
                }
            }
            tc.a.a("BrowserApp::shouldNightModeChange, setTheme. night: %s", Boolean.valueOf(zE));
        }
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        tc.a.a("Shell::onCreate", new Object[0]);
        s.a(this).v(this);
        this.K.p0(com.tuyafeng.support.utils.q.a(this));
        setTheme(this.K.e() ? v.f14324a : v.f14325b);
        h3.p(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        final FrameLayout frameLayoutB = FragmentUtils.b(this);
        setContentView(frameLayoutB);
        K().l(this);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: w7.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Shell.X(this.f13691c);
            }
        }).k(a.c()).i(q6.b.b()).l(s8.b.a(this))).a(new u6.f() { // from class: w7.d0
            @Override // u6.f
            public final void accept(Object obj) {
                Shell.Z(this.f13693c, (Boolean) obj);
            }
        }, new e0());
        if (bundle == null) {
            if (n.e().k() || n.e().j()) {
                x8.h.b(new Runnable() { // from class: w7.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Shell.U(this.f13699c);
                    }
                });
            }
            if (this.K.M2() >= 1) {
                d0();
            } else {
                FragmentUtils.l(this, x7.c.class, null, null);
            }
        } else {
            e0();
        }
        la.r.a(this);
        frameLayoutB.post(new Runnable() { // from class: w7.g0
            @Override // java.lang.Runnable
            public final void run() {
                Shell.W(frameLayoutB);
            }
        });
        tc.a.a("Shell::onCreate, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public void onDestroy() {
        K().o1(this);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        for (f fVar : K().A0()) {
            if ((fVar instanceof m8.d) && ((m8.d) fVar).Z(intent)) {
                return;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && !this.N) {
            this.N = true;
            final View decorView = getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: w7.b0
                @Override // java.lang.Runnable
                public final void run() {
                    Shell.R(this.f13689c, decorView);
                }
            });
        }
        q4 q4VarB0 = b0();
        if (q4VarB0 != null) {
            q4VarB0.s8(z10);
        }
    }
}
