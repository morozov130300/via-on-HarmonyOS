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
import androidx.lifecycle.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends Dialog implements androidx.lifecycle.h, r, l0.d {

    /* renamed from: e, reason: collision with root package name */
    public androidx.lifecycle.i f494e;

    /* renamed from: j, reason: collision with root package name */
    public final l0.c f495j;

    /* renamed from: k, reason: collision with root package name */
    public final OnBackPressedDispatcher f496k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.h.f(context, "context");
        this.f495j = l0.c.f8310d.a(this);
        this.f496k = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.d(this.f493e);
            }
        });
    }

    public static final void d(k this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // l0.d
    public androidx.savedstate.a T() {
        return this.f495j.b();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public final androidx.lifecycle.i b() {
        androidx.lifecycle.i iVar = this.f494e;
        if (iVar != null) {
            return iVar;
        }
        androidx.lifecycle.i iVar2 = new androidx.lifecycle.i(this);
        this.f494e = iVar2;
        return iVar2;
    }

    public void c() {
        Window window = getWindow();
        kotlin.jvm.internal.h.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.h.e(decorView, "window!!.decorView");
        d0.a(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.h.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.h.e(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.h.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.h.e(decorView3, "window!!.decorView");
        l0.e.a(decorView3, this);
    }

    @Override // androidx.activity.r
    public final OnBackPressedDispatcher h() {
        return this.f496k;
    }

    @Override // androidx.lifecycle.h
    public Lifecycle k0() {
        return b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f496k.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f496k;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.h.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.n(onBackInvokedDispatcher);
        }
        this.f495j.d(bundle);
        b().h(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.h.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f495j.e(bundleOnSaveInstanceState);
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
        this.f494e = null;
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
