package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends Dialog implements androidx.lifecycle.j, r, m0.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.k f397c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m0.c f398e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OnBackPressedDispatcher f399m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.h.f(context, "context");
        this.f398e = m0.c.f7784d.a(this);
        this.f399m = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(this.f396c);
            }
        });
    }

    public static final void d(k this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // m0.d
    public androidx.savedstate.a Q() {
        return this.f398e.b();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final androidx.lifecycle.k b() {
        androidx.lifecycle.k kVar = this.f397c;
        if (kVar != null) {
            return kVar;
        }
        androidx.lifecycle.k kVar2 = new androidx.lifecycle.k(this);
        this.f397c = kVar2;
        return kVar2;
    }

    public void c() {
        Window window = getWindow();
        kotlin.jvm.internal.h.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.h.e(decorView, "window!!.decorView");
        f0.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.h.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.h.e(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.h.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.h.e(decorView3, "window!!.decorView");
        m0.e.a(decorView3, this);
    }

    @Override // androidx.activity.r
    public final OnBackPressedDispatcher h() {
        return this.f399m;
    }

    @Override // androidx.lifecycle.j
    public Lifecycle h0() {
        return b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f399m.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f399m;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.h.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.n(onBackInvokedDispatcher);
        }
        this.f398e.d(bundle);
        b().h(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.h.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f398e.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().h(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().h(Lifecycle.Event.ON_DESTROY);
        this.f397c = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        c();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.h.f(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.f(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
