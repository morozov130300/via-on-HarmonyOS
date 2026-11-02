package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u0 implements androidx.lifecycle.d, l0.d, androidx.lifecycle.c0 {

    /* renamed from: e, reason: collision with root package name */
    public final Fragment f965e;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.b0 f966j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f967k;

    /* renamed from: l, reason: collision with root package name */
    public y.b f968l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.lifecycle.i f969m = null;

    /* renamed from: n, reason: collision with root package name */
    public l0.c f970n = null;

    public u0(Fragment fragment, androidx.lifecycle.b0 b0Var, Runnable runnable) {
        this.f965e = fragment;
        this.f966j = b0Var;
        this.f967k = runnable;
    }

    @Override // androidx.lifecycle.c0
    public androidx.lifecycle.b0 D() {
        b();
        return this.f966j;
    }

    @Override // l0.d
    public androidx.savedstate.a T() {
        b();
        return this.f970n.b();
    }

    public void a(Lifecycle.Event event) {
        this.f969m.h(event);
    }

    public void b() {
        if (this.f969m == null) {
            this.f969m = new androidx.lifecycle.i(this);
            l0.c cVarA = l0.c.a(this);
            this.f970n = cVarA;
            cVarA.c();
            this.f967k.run();
        }
    }

    public boolean c() {
        return this.f969m != null;
    }

    public void d(Bundle bundle) {
        this.f970n.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f970n.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.f969m.n(state);
    }

    @Override // androidx.lifecycle.h
    public Lifecycle k0() {
        b();
        return this.f969m;
    }

    @Override // androidx.lifecycle.d
    public y.b w() {
        Application application;
        y.b bVarW = this.f965e.w();
        if (!bVarW.equals(this.f965e.f660f0)) {
            this.f968l = bVarW;
            return bVarW;
        }
        if (this.f968l == null) {
            Context applicationContext = this.f965e.I().getApplicationContext();
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
            Fragment fragment = this.f965e;
            this.f968l = new androidx.lifecycle.v(application, fragment, fragment.y0());
        }
        return this.f968l;
    }

    @Override // androidx.lifecycle.d
    public h0.a x() {
        Application application;
        Context applicationContext = this.f965e.I().getApplicationContext();
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
        h0.d dVar = new h0.d();
        if (application != null) {
            dVar.c(y.a.f1083g, application);
        }
        dVar.c(SavedStateHandleSupport.f1027a, this.f965e);
        dVar.c(SavedStateHandleSupport.f1028b, this);
        if (this.f965e.y0() != null) {
            dVar.c(SavedStateHandleSupport.f1029c, this.f965e.y0());
        }
        return dVar;
    }
}
