package mark.via;

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
import androidx.lifecycle.Lifecycle;
import c8.k6;
import g5.c;
import g6.i;
import g7.a;
import java.util.List;
import java.util.concurrent.Callable;
import k8.r;
import mark.via.Shell;
import mark.via.common.SoftInputAssistObserver;
import r9.f;
import r9.j;
import s8.b;
import w.d;
import w9.e;
import w9.l;
import w9.n;
import x.k0;
import x.r;
import x6.o;
import x7.c0;
import x7.g0;
import x7.v;
import y8.h;
import z8.l0;
import z8.l3;
import z8.t1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class Shell extends q implements h0 {
    public l I;
    public b J;
    public SoftInputAssistObserver K;
    public Context L = null;
    public boolean M;

    public static /* synthetic */ List R(Shell shell) {
        shell.getClass();
        return new j(f.f11594a, "default:production.5ae8018a613c7b4ef6297b23aaf7d5d18d16cac9a6636ae20d378aa2", new e(shell, "features"), shell.getFilesDir().getAbsolutePath()).a();
    }

    public static /* synthetic */ void S(Shell shell, d dVar) {
        shell.getClass();
        Object obj = dVar.f13208b;
        if (obj == null) {
            h.h(shell, (h.a) dVar.f13207a);
        } else {
            h.w(shell, (h.a) dVar.f13207a, ((c) obj).f());
        }
    }

    public static /* synthetic */ d U(Shell shell, h.a aVar) {
        shell.getClass();
        return new d(aVar, aVar.i() ? h.n(shell, aVar) : null);
    }

    public static /* synthetic */ void V(Shell shell) {
        shell.getClass();
        r8.d.f(shell);
    }

    public static /* synthetic */ void X(View view) {
        k0 k0VarY = r.y(view);
        l0.k((k0VarY == null || k0VarY.e() == null) ? false : true);
    }

    public static /* synthetic */ void Y(Shell shell, View view) {
        shell.getClass();
        if (!view.isAttachedToWindow() || shell.isFinishing()) {
            return;
        }
        shell.getWindowManager().updateViewLayout(view, shell.getWindow().getAttributes());
    }

    public static /* synthetic */ Boolean Z(Shell shell) {
        shell.J.b().i();
        return Boolean.valueOf(shell.J.b().f());
    }

    public static /* synthetic */ void a0(Shell shell, Boolean bool) {
        shell.getClass();
        if (bool.booleanValue()) {
            shell.J.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(boolean z10) {
        for (androidx.lifecycle.h hVar : L().A0()) {
            if (hVar instanceof o8.d) {
                ((o8.d) hVar).a(z10);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        this.L = context;
        String strK0 = pa.r.j().K0();
        if (TextUtils.isEmpty(strK0)) {
            super.attachBaseContext(context);
            return;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.uiMode &= -49;
        t1.p(context, configuration, strK0);
        t1.l(configuration);
        super.attachBaseContext(context.createConfigurationContext(configuration));
    }

    public void c0() {
        ((autodispose2.r) o.g(new Callable() { // from class: x7.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y8.h.k();
            }
        }).i(new a7.f() { // from class: x7.a0
            @Override // a7.f
            public final Object apply(Object obj) {
                return Shell.U(this.f13620a, (h.a) obj);
            }
        }).l(a.c()).j(w6.b.b()).m(u8.b.a(this))).a(new a7.e() { // from class: x7.b0
            @Override // a7.e
            public final void accept(Object obj) {
                Shell.S(this.f13622e, (w.d) obj);
            }
        }, new c0());
    }

    public final void d0() {
        ((autodispose2.r) o.g(new Callable() { // from class: x7.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Shell.R(this.f13669e);
            }
        }).l(a.c()).j(w6.b.b()).m(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: x7.l0
            @Override // a7.e
            public final void accept(Object obj) {
                r9.k.q().t(new r9.i((List) obj));
            }
        }, new g0());
    }

    @Override // n.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        k6 k6VarE0 = e0();
        return (k6VarE0 == null || !k6VarE0.q1()) ? super.dispatchKeyEvent(keyEvent) : k6VarE0.n8(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public k6 e0() {
        Fragment fragmentN0 = L().n0(k6.class.getName());
        if (fragmentN0 instanceof k6) {
            return (k6) fragmentN0;
        }
        return null;
    }

    public Context f0() {
        Context context = this.L;
        return context == null ? this : context;
    }

    public void g0() {
        h0();
        if (pa.r.o().f()) {
            i.j(this, ra.h.class, ra.h.c3(1), null);
        } else {
            i.j(this, k6.class, null, k6.class.getName());
        }
    }

    public final void h0() {
        d0();
        z8.f.f(this);
    }

    public void j0(boolean z10) {
        SoftInputAssistObserver softInputAssistObserver = this.K;
        if (softInputAssistObserver == null) {
            return;
        }
        softInputAssistObserver.j(l3.f14720a || z10);
    }

    @Override // androidx.fragment.app.h0
    public void k(FragmentManager fragmentManager, Fragment fragment) {
        for (androidx.lifecycle.h hVar : L().A0()) {
            if (hVar instanceof o8.c) {
                ((o8.c) hVar).m(fragmentManager, fragment);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        pc.a.a("BrowserApp::onConfigurationChanged, check shouldNightMode2Change", new Object[0]);
        super.onConfigurationChanged(configuration);
        if (this.I.m0(g6.q.a(this))) {
            boolean zD = this.I.d();
            setTheme(zD ? v.f14254a : v.f14255b);
            for (Fragment fragment : L().A0()) {
                if (fragment != 0 && !fragment.j1() && (fragment instanceof o8.b)) {
                    ((o8.b) fragment).d0(zD);
                }
            }
            pc.a.a("BrowserApp::shouldNightModeChange, setTheme. night: %s", Boolean.valueOf(zD));
        }
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        pc.a.a("Shell::onCreate", new Object[0]);
        pa.r.a(this).v(this);
        this.I.m0(g6.q.a(this));
        setTheme(this.I.d() ? v.f14254a : v.f14255b);
        l3.m(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        final FrameLayout frameLayoutA = i.a(this);
        setContentView(frameLayoutA);
        L().l(this);
        ((autodispose2.r) o.g(new Callable() { // from class: x7.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Shell.Z(this.f13629e);
            }
        }).l(a.c()).j(w6.b.b()).m(u8.b.a(this))).a(new a7.e() { // from class: x7.f0
            @Override // a7.e
            public final void accept(Object obj) {
                Shell.a0(this.f13632e, (Boolean) obj);
            }
        }, new g0());
        if (bundle == null) {
            if (n.e().l() || n.e().k()) {
                z8.h.b(new Runnable() { // from class: x7.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Shell.V(this.f13635e);
                    }
                });
            }
            if (this.I.I2() >= 1) {
                g0();
            } else {
                i.j(this, y7.c.class, null, null);
            }
        } else {
            h0();
        }
        SoftInputAssistObserver softInputAssistObserver = new SoftInputAssistObserver(this);
        this.K = softInputAssistObserver;
        softInputAssistObserver.j(l3.f14720a || this.I.O1());
        this.K.i(new r.a() { // from class: x7.i0
            @Override // k8.r.a
            public final void a(boolean z10) {
                this.f13643a.i0(z10);
            }
        });
        k0().a(this.K);
        pa.q.a(this);
        frameLayoutA.post(new Runnable() { // from class: x7.j0
            @Override // java.lang.Runnable
            public final void run() {
                Shell.X(frameLayoutA);
            }
        });
        pc.a.a("Shell::onCreate, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public void onDestroy() {
        L().o1(this);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        for (androidx.lifecycle.h hVar : L().A0()) {
            if ((hVar instanceof o8.e) && ((o8.e) hVar).c0(intent)) {
                return;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && !this.M) {
            this.M = true;
            final View decorView = getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: x7.d0
                @Override // java.lang.Runnable
                public final void run() {
                    Shell.Y(this.f13624e, decorView);
                }
            });
        }
        k6 k6VarE0 = e0();
        if (k6VarE0 != null) {
            k6VarE0.U9(z10);
        }
    }
}
