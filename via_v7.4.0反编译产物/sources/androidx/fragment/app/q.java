package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import n.a;
import n.z0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class q extends ComponentActivity implements a.d, a.e {
    public boolean F;
    public boolean G;
    public final u D = u.b(new a());
    public final androidx.lifecycle.i E = new androidx.lifecycle.i(this);
    public boolean H = true;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends w implements o.m, o.n, n.y0, z0, androidx.lifecycle.c0, androidx.activity.r, androidx.activity.result.c, l0.d, h0, x.g {
        public a() {
            super(q.this);
        }

        public void A() {
            q.this.E();
        }

        @Override // androidx.fragment.app.w
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public q v() {
            return q.this;
        }

        @Override // androidx.lifecycle.c0
        public androidx.lifecycle.b0 D() {
            return q.this.D();
        }

        @Override // l0.d
        public androidx.savedstate.a T() {
            return q.this.T();
        }

        @Override // o.m
        public void b(w.a aVar) {
            q.this.b(aVar);
        }

        @Override // x.g
        public void c(x.i iVar) {
            q.this.c(iVar);
        }

        @Override // o.m
        public void d(w.a aVar) {
            q.this.d(aVar);
        }

        @Override // n.y0
        public void e(w.a aVar) {
            q.this.e(aVar);
        }

        @Override // androidx.activity.result.c
        public ActivityResultRegistry f() {
            return q.this.f();
        }

        @Override // x.g
        public void g(x.i iVar) {
            q.this.g(iVar);
        }

        @Override // androidx.activity.r
        public OnBackPressedDispatcher h() {
            return q.this.h();
        }

        @Override // n.z0
        public void i(w.a aVar) {
            q.this.i(aVar);
        }

        @Override // androidx.fragment.app.s
        public View j(int i10) {
            return q.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.h0
        public void k(FragmentManager fragmentManager, Fragment fragment) {
            q.this.P(fragment);
        }

        @Override // androidx.lifecycle.h
        public Lifecycle k0() {
            return q.this.E;
        }

        @Override // o.n
        public void l(w.a aVar) {
            q.this.l(aVar);
        }

        @Override // o.n
        public void m(w.a aVar) {
            q.this.m(aVar);
        }

        @Override // n.y0
        public void n(w.a aVar) {
            q.this.n(aVar);
        }

        @Override // n.z0
        public void o(w.a aVar) {
            q.this.o(aVar);
        }

        @Override // androidx.fragment.app.s
        public boolean p() {
            Window window = q.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.w
        public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            q.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.w
        public LayoutInflater w() {
            return q.this.getLayoutInflater().cloneInContext(q.this);
        }

        @Override // androidx.fragment.app.w
        public void z() {
            A();
        }
    }

    public q() {
        M();
    }

    public static /* synthetic */ Bundle I(q qVar) {
        qVar.N();
        qVar.E.h(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public static boolean O(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zO = false;
        for (Fragment fragment : fragmentManager.A0()) {
            if (fragment != null) {
                if (fragment.I0() != null) {
                    zO |= O(fragment.z0(), state);
                }
                u0 u0Var = fragment.f657d0;
                if (u0Var != null && u0Var.k0().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.f657d0.f(state);
                    zO = true;
                }
                if (fragment.f656c0.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.f656c0.n(state);
                    zO = true;
                }
            }
        }
        return zO;
    }

    public final View K(View view, String str, Context context, AttributeSet attributeSet) {
        return this.D.n(view, str, context, attributeSet);
    }

    public FragmentManager L() {
        return this.D.l();
    }

    public final void M() {
        T().h("android:support:lifecycle", new a.c() { // from class: androidx.fragment.app.m
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return q.I(this.f915a);
            }
        });
        b(new w.a() { // from class: androidx.fragment.app.n
            @Override // w.a
            public final void accept(Object obj) {
                this.f919a.D.m();
            }
        });
        z(new w.a() { // from class: androidx.fragment.app.o
            @Override // w.a
            public final void accept(Object obj) {
                this.f920a.D.m();
            }
        });
        y(new d.b() { // from class: androidx.fragment.app.p
            @Override // d.b
            public final void a(Context context) {
                this.f921a.D.a(null);
            }
        });
    }

    public void N() {
        while (O(L(), Lifecycle.State.CREATED)) {
        }
    }

    public void P(Fragment fragment) {
    }

    public void Q() {
        this.E.h(Lifecycle.Event.ON_RESUME);
        this.D.h();
    }

    @Override // n.a.e
    public final void a(int i10) {
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (p(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.F);
            printWriter.print(" mResumed=");
            printWriter.print(this.G);
            printWriter.print(" mStopped=");
            printWriter.print(this.H);
            if (getApplication() != null) {
                i0.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.D.l().b0(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.D.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.E.h(Lifecycle.Event.ON_CREATE);
        this.D.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewK = K(view, str, context, attributeSet);
        return viewK == null ? super.onCreateView(view, str, context, attributeSet) : viewK;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewK = K(null, str, context, attributeSet);
        return viewK == null ? super.onCreateView(str, context, attributeSet) : viewK;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.D.f();
        this.E.h(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.D.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.G = false;
        this.D.g();
        this.E.h(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        Q();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.D.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.D.m();
        super.onResume();
        this.G = true;
        this.D.k();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.D.m();
        super.onStart();
        this.H = false;
        if (!this.F) {
            this.F = true;
            this.D.c();
        }
        this.D.k();
        this.E.h(Lifecycle.Event.ON_START);
        this.D.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.D.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.H = true;
        N();
        this.D.j();
        this.E.h(Lifecycle.Event.ON_STOP);
    }
}
