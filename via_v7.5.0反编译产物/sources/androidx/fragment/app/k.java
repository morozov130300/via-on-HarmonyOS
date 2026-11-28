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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public boolean A0;
    public boolean B0;
    public boolean C0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public Handler f765o0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f774x0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Dialog f776z0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Runnable f766p0 = new a();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public DialogInterface.OnCancelListener f767q0 = new b();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public DialogInterface.OnDismissListener f768r0 = new c();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f769s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f770t0 = 0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f771u0 = true;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f772v0 = true;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f773w0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public androidx.lifecycle.o f775y0 = new d();
    public boolean D0 = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f768r0.onDismiss(k.this.f776z0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (k.this.f776z0 != null) {
                k kVar = k.this;
                kVar.onCancel(kVar.f776z0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (k.this.f776z0 != null) {
                k kVar = k.this;
                kVar.onDismiss(kVar.f776z0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements androidx.lifecycle.o {
        public d() {
        }

        @Override // androidx.lifecycle.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.j jVar) {
            if (jVar == null || !k.this.f772v0) {
                return;
            }
            View viewA2 = k.this.A2();
            if (viewA2.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (k.this.f776z0 != null) {
                if (FragmentManager.O0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + k.this.f776z0);
                }
                k.this.f776z0.setContentView(viewA2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e extends s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f781c;

        public e(s sVar) {
            this.f781c = sVar;
        }

        @Override // androidx.fragment.app.s
        public View l(int i10) {
            return this.f781c.o() ? this.f781c.l(i10) : k.this.a3(i10);
        }

        @Override // androidx.fragment.app.s
        public boolean o() {
            return this.f781c.o() || k.this.b3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        super.D1();
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            this.A0 = true;
            dialog.setOnDismissListener(null);
            this.f776z0.dismiss();
            if (!this.B0) {
                onDismiss(this.f776z0);
            }
            this.f776z0 = null;
            this.D0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void E1() {
        super.E1();
        if (!this.C0 && !this.B0) {
            this.B0 = true;
        }
        c1().l(this.f775y0);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater F1(Bundle bundle) {
        LayoutInflater layoutInflaterF1 = super.F1(bundle);
        if (this.f772v0 && !this.f774x0) {
            c3(bundle);
            if (FragmentManager.O0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f776z0;
            if (dialog != null) {
                return layoutInflaterF1.cloneInContext(dialog.getContext());
            }
        } else if (FragmentManager.O0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f772v0) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterF1;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterF1;
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Bundle bundle) {
        super.S1(bundle);
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f769s0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f770t0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f771u0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f772v0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f773w0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            this.A0 = false;
            dialog.show();
            View decorView = this.f776z0.getWindow().getDecorView();
            androidx.lifecycle.f0.a(decorView, this);
            androidx.lifecycle.g0.a(decorView, this);
            m0.e.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void U1() {
        super.U1();
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void V2() {
        W2(false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void W1(Bundle bundle) {
        Bundle bundle2;
        super.W1(bundle);
        if (this.f776z0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f776z0.onRestoreInstanceState(bundle2);
    }

    public final void W2(boolean z10, boolean z11, boolean z12) {
        if (this.B0) {
            return;
        }
        this.B0 = true;
        this.C0 = false;
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f776z0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f765o0.getLooper()) {
                    onDismiss(this.f776z0);
                } else {
                    this.f765o0.post(this.f766p0);
                }
            }
        }
        this.A0 = true;
        if (this.f773w0 >= 0) {
            if (z12) {
                L0().f1(this.f773w0, 1);
            } else {
                L0().d1(this.f773w0, 1, z10);
            }
            this.f773w0 = -1;
            return;
        }
        l0 l0VarQ = L0().q();
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

    public Dialog X2() {
        return this.f776z0;
    }

    public int Y2() {
        return this.f770t0;
    }

    public Dialog Z2(Bundle bundle) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.k(G(), Y2());
    }

    public View a3(int i10) {
        Dialog dialog = this.f776z0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    public boolean b3() {
        return this.D0;
    }

    public final void c3(Bundle bundle) {
        if (this.f772v0 && !this.D0) {
            try {
                this.f774x0 = true;
                Dialog dialogZ2 = Z2(bundle);
                this.f776z0 = dialogZ2;
                if (this.f772v0) {
                    f3(dialogZ2, this.f769s0);
                    Context contextY0 = y0();
                    if (contextY0 instanceof Activity) {
                        this.f776z0.setOwnerActivity((Activity) contextY0);
                    }
                    this.f776z0.setCancelable(this.f771u0);
                    this.f776z0.setOnCancelListener(this.f767q0);
                    this.f776z0.setOnDismissListener(this.f768r0);
                    this.D0 = true;
                } else {
                    this.f776z0 = null;
                }
            } finally {
                this.f774x0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void d2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.d2(layoutInflater, viewGroup, bundle);
        if (this.T != null || this.f776z0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f776z0.onRestoreInstanceState(bundle2);
    }

    public final Dialog d3() {
        Dialog dialogX2 = X2();
        if (dialogX2 != null) {
            return dialogX2;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void e3(int i10, int i11) {
        if (FragmentManager.O0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i10 + ", " + i11);
        }
        this.f769s0 = i10;
        if (i10 == 2 || i10 == 3) {
            this.f770t0 = R.style.Theme.Panel;
        }
        if (i11 != 0) {
            this.f770t0 = i11;
        }
    }

    public void f3(Dialog dialog, int i10) {
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

    public void g3(FragmentManager fragmentManager, String str) {
        this.B0 = false;
        this.C0 = true;
        l0 l0VarQ = fragmentManager.q();
        l0VarQ.x(true);
        l0VarQ.e(this, str);
        l0VarQ.i();
    }

    public void h3(FragmentManager fragmentManager, String str) {
        this.B0 = false;
        this.C0 = true;
        l0 l0VarQ = fragmentManager.q();
        l0VarQ.x(true);
        l0VarQ.e(this, str);
        l0VarQ.k();
    }

    @Override // androidx.fragment.app.Fragment
    public s n0() {
        return new e(super.n0());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.A0) {
            return;
        }
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        W2(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void q1(Bundle bundle) {
        super.q1(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        c1().h(this.f775y0);
        if (this.C0) {
            return;
        }
        this.B0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f765o0 = new Handler();
        this.f772v0 = this.J == 0;
        if (bundle != null) {
            this.f769s0 = bundle.getInt("android:style", 0);
            this.f770t0 = bundle.getInt("android:theme", 0);
            this.f771u0 = bundle.getBoolean("android:cancelable", true);
            this.f772v0 = bundle.getBoolean("android:showsDialog", this.f772v0);
            this.f773w0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
