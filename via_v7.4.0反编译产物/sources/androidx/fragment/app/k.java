package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public boolean A0;

    /* renamed from: m0, reason: collision with root package name */
    public Handler f862m0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f871v0;

    /* renamed from: x0, reason: collision with root package name */
    public Dialog f873x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f874y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f875z0;

    /* renamed from: n0, reason: collision with root package name */
    public Runnable f863n0 = new a();

    /* renamed from: o0, reason: collision with root package name */
    public DialogInterface.OnCancelListener f864o0 = new b();

    /* renamed from: p0, reason: collision with root package name */
    public DialogInterface.OnDismissListener f865p0 = new c();

    /* renamed from: q0, reason: collision with root package name */
    public int f866q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    public int f867r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f868s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f869t0 = true;

    /* renamed from: u0, reason: collision with root package name */
    public int f870u0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    public androidx.lifecycle.m f872w0 = new d();
    public boolean B0 = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f865p0.onDismiss(k.this.f873x0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (k.this.f873x0 != null) {
                k kVar = k.this;
                kVar.onCancel(kVar.f873x0);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (k.this.f873x0 != null) {
                k kVar = k.this;
                kVar.onDismiss(kVar.f873x0);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements androidx.lifecycle.m {
        public d() {
        }

        @Override // androidx.lifecycle.m
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.h hVar) {
            if (hVar == null || !k.this.f869t0) {
                return;
            }
            View viewC2 = k.this.C2();
            if (viewC2.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (k.this.f873x0 != null) {
                if (FragmentManager.O0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + k.this.f873x0);
                }
                k.this.f873x0.setContentView(viewC2);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e extends s {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ s f880e;

        public e(s sVar) {
            this.f880e = sVar;
        }

        @Override // androidx.fragment.app.s
        public View j(int i10) {
            return this.f880e.p() ? this.f880e.j(i10) : k.this.c3(i10);
        }

        @Override // androidx.fragment.app.s
        public boolean p() {
            return this.f880e.p() || k.this.d3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        super.F1();
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            this.f874y0 = true;
            dialog.setOnDismissListener(null);
            this.f873x0.dismiss();
            if (!this.f875z0) {
                onDismiss(this.f873x0);
            }
            this.f873x0 = null;
            this.B0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G1() {
        super.G1();
        if (!this.A0 && !this.f875z0) {
            this.f875z0 = true;
        }
        e1().l(this.f872w0);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater H1(Bundle bundle) {
        LayoutInflater layoutInflaterH1 = super.H1(bundle);
        if (this.f869t0 && !this.f871v0) {
            e3(bundle);
            if (FragmentManager.O0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f873x0;
            if (dialog != null) {
                return layoutInflaterH1.cloneInContext(dialog.getContext());
            }
        } else if (FragmentManager.O0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f869t0) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterH1;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterH1;
    }

    @Override // androidx.fragment.app.Fragment
    public void U1(Bundle bundle) {
        super.U1(bundle);
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f866q0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f867r0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f868s0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f869t0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f870u0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1() {
        super.V1();
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            this.f874y0 = false;
            dialog.show();
            View decorView = this.f873x0.getWindow().getDecorView();
            androidx.lifecycle.d0.a(decorView, this);
            androidx.lifecycle.e0.a(decorView, this);
            l0.e.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W1() {
        super.W1();
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void X2() {
        Y2(false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y1(Bundle bundle) {
        Bundle bundle2;
        super.Y1(bundle);
        if (this.f873x0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f873x0.onRestoreInstanceState(bundle2);
    }

    public final void Y2(boolean z10, boolean z11, boolean z12) {
        if (this.f875z0) {
            return;
        }
        this.f875z0 = true;
        this.A0 = false;
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f873x0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f862m0.getLooper()) {
                    onDismiss(this.f873x0);
                } else {
                    this.f862m0.post(this.f863n0);
                }
            }
        }
        this.f874y0 = true;
        if (this.f870u0 >= 0) {
            if (z12) {
                N0().f1(this.f870u0, 1);
            } else {
                N0().d1(this.f870u0, 1, z10);
            }
            this.f870u0 = -1;
            return;
        }
        l0 l0VarQ = N0().q();
        l0VarQ.x(true);
        l0VarQ.s(this);
        if (z12) {
            l0VarQ.k();
        } else if (z10) {
            l0VarQ.j();
        } else {
            l0VarQ.i();
        }
    }

    public Dialog Z2() {
        return this.f873x0;
    }

    public int a3() {
        return this.f867r0;
    }

    public Dialog b3(Bundle bundle) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.k(I(), a3());
    }

    public View c3(int i10) {
        Dialog dialog = this.f873x0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    public boolean d3() {
        return this.B0;
    }

    public final void e3(Bundle bundle) {
        if (this.f869t0 && !this.B0) {
            try {
                this.f871v0 = true;
                Dialog dialogB3 = b3(bundle);
                this.f873x0 = dialogB3;
                if (this.f869t0) {
                    g3(dialogB3, this.f866q0);
                    Context contextA0 = A0();
                    if (contextA0 instanceof Activity) {
                        this.f873x0.setOwnerActivity((Activity) contextA0);
                    }
                    this.f873x0.setCancelable(this.f868s0);
                    this.f873x0.setOnCancelListener(this.f864o0);
                    this.f873x0.setOnDismissListener(this.f865p0);
                    this.B0 = true;
                } else {
                    this.f873x0 = null;
                }
                this.f871v0 = false;
            } catch (Throwable th) {
                this.f871v0 = false;
                throw th;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void f2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.f2(layoutInflater, viewGroup, bundle);
        if (this.R != null || this.f873x0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f873x0.onRestoreInstanceState(bundle2);
    }

    public void f3(int i10, int i11) {
        if (FragmentManager.O0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i10 + ", " + i11);
        }
        this.f866q0 = i10;
        if (i10 == 2 || i10 == 3) {
            this.f867r0 = R.style.Theme.Panel;
        }
        if (i11 != 0) {
            this.f867r0 = i11;
        }
    }

    public void g3(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void h3(FragmentManager fragmentManager, String str) {
        this.f875z0 = false;
        this.A0 = true;
        l0 l0VarQ = fragmentManager.q();
        l0VarQ.x(true);
        l0VarQ.e(this, str);
        l0VarQ.i();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f874y0) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        Y2(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public s p0() {
        return new e(super.p0());
    }

    @Override // androidx.fragment.app.Fragment
    public void s1(Bundle bundle) {
        super.s1(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        e1().h(this.f872w0);
        if (this.A0) {
            return;
        }
        this.f875z0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f862m0 = new Handler();
        this.f869t0 = this.H == 0;
        if (bundle != null) {
            this.f866q0 = bundle.getInt("android:style", 0);
            this.f867r0 = bundle.getInt("android:theme", 0);
            this.f868s0 = bundle.getBoolean("android:cancelable", true);
            this.f869t0 = bundle.getBoolean("android:showsDialog", this.f869t0);
            this.f870u0 = bundle.getInt("android:backStackId", -1);
        }
    }
}
