package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u0 implements androidx.lifecycle.f, m0.d, androidx.lifecycle.e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f866c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.lifecycle.d0 f867e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.lifecycle.a0.b f869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.lifecycle.k f870o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m0.c f871p = null;

    public u0(Fragment fragment, androidx.lifecycle.d0 d0Var, Runnable runnable) {
        this.f866c = fragment;
        this.f867e = d0Var;
        this.f868m = runnable;
    }

    @Override // androidx.lifecycle.e0
    public androidx.lifecycle.d0 B() {
        b();
        return this.f867e;
    }

    @Override // m0.d
    public androidx.savedstate.a Q() {
        b();
        return this.f871p.b();
    }

    public void a(Lifecycle.Event event) {
        this.f870o.h(event);
    }

    public void b() {
        if (this.f870o == null) {
            this.f870o = new androidx.lifecycle.k(this);
            m0.c cVarA = m0.c.a(this);
            this.f871p = cVarA;
            cVarA.c();
            this.f868m.run();
        }
    }

    public boolean c() {
        return this.f870o != null;
    }

    public void d(Bundle bundle) {
        this.f871p.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f871p.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.f870o.n(state);
    }

    @Override // androidx.lifecycle.j
    public Lifecycle h0() {
        b();
        return this.f870o;
    }

    @Override // androidx.lifecycle.f
    public androidx.lifecycle.a0.b v() {
        Application application;
        androidx.lifecycle.a0.b bVarV = this.f866c.v();
        if (!bVarV.equals(this.f866c.f566h0)) {
            this.f869n = bVarV;
            return bVarV;
        }
        if (this.f869n == null) {
            Context applicationContext = this.f866c.G().getApplicationContext();
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
            Fragment fragment = this.f866c;
            this.f869n = new androidx.lifecycle.x(application, fragment, fragment.w0());
        }
        return this.f869n;
    }

    @Override // androidx.lifecycle.f
    public i0.a w() {
        Application application;
        Context applicationContext = this.f866c.G().getApplicationContext();
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
        i0.d dVar = new i0.d();
        if (application != null) {
            dVar.c(androidx.lifecycle.a0.a.f943g, application);
        }
        dVar.c(SavedStateHandleSupport.f930a, this.f866c);
        dVar.c(SavedStateHandleSupport.f931b, this);
        if (this.f866c.w0() != null) {
            dVar.c(SavedStateHandleSupport.f932c, this.f866c.w0());
        }
        return dVar;
    }
}
