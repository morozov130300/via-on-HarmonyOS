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
import java.io.FileDescriptor;
import java.io.PrintWriter;
import n.z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends ComponentActivity implements n.a.d, n.a.e {
    public boolean H;
    public boolean I;
    public final u F = u.b(new a());
    public final androidx.lifecycle.k G = new androidx.lifecycle.k(this);
    public boolean J = true;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends w implements o.m, o.n, n.y0, z0, androidx.lifecycle.e0, androidx.activity.r, androidx.activity.result.c, m0.d, h0, y.g {
        public a() {
            super(q.this);
        }

        @Override // androidx.fragment.app.w
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public q u() {
            return q.this;
        }

        @Override // androidx.lifecycle.e0
        public androidx.lifecycle.d0 B() {
            return q.this.B();
        }

        @Override // m0.d
        public androidx.savedstate.a Q() {
            return q.this.Q();
        }

        @Override // androidx.fragment.app.h0
        public void V(FragmentManager fragmentManager, Fragment fragment) {
            q.this.O(fragment);
        }

        @Override // y.g
        public void b(y.i iVar) {
            q.this.b(iVar);
        }

        @Override // o.m
        public void c(x.a aVar) {
            q.this.c(aVar);
        }

        @Override // n.z0
        public void d(x.a aVar) {
            q.this.d(aVar);
        }

        @Override // n.y0
        public void e(x.a aVar) {
            q.this.e(aVar);
        }

        @Override // o.n
        public void f(x.a aVar) {
            q.this.f(aVar);
        }

        @Override // androidx.activity.result.c
        public ActivityResultRegistry g() {
            return q.this.g();
        }

        @Override // androidx.activity.r
        public OnBackPressedDispatcher h() {
            return q.this.h();
        }

        @Override // androidx.lifecycle.j
        public Lifecycle h0() {
            return q.this.G;
        }

        @Override // o.n
        public void i(x.a aVar) {
            q.this.i(aVar);
        }

        @Override // y.g
        public void j(y.i iVar) {
            q.this.j(iVar);
        }

        @Override // o.m
        public void k(x.a aVar) {
            q.this.k(aVar);
        }

        @Override // androidx.fragment.app.s
        public View l(int i10) {
            return q.this.findViewById(i10);
        }

        @Override // n.y0
        public void m(x.a aVar) {
            q.this.m(aVar);
        }

        @Override // n.z0
        public void n(x.a aVar) {
            q.this.n(aVar);
        }

        @Override // androidx.fragment.app.s
        public boolean o() {
            Window window = q.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.w
        public void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            q.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.w
        public LayoutInflater v() {
            return q.this.getLayoutInflater().cloneInContext(q.this);
        }

        @Override // androidx.fragment.app.w
        public void y() {
            z();
        }

        public void z() {
            q.this.D();
        }
    }

    public q() {
        L();
    }

    public static /* synthetic */ Bundle H(q qVar) {
        qVar.M();
        qVar.G.h(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public static boolean N(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zN = false;
        for (Fragment fragment : fragmentManager.A0()) {
            if (fragment != null) {
                if (fragment.G0() != null) {
                    zN |= N(fragment.x0(), state);
                }
                u0 u0Var = fragment.f564f0;
                if (u0Var != null && u0Var.h0().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.f564f0.f(state);
                    zN = true;
                }
                if (fragment.f563e0.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.f563e0.n(state);
                    zN = true;
                }
            }
        }
        return zN;
    }

    public final View J(View view, String str, Context context, AttributeSet attributeSet) {
        return this.F.n(view, str, context, attributeSet);
    }

    public FragmentManager K() {
        return this.F.l();
    }

    public final void L() {
        Q().h("android:support:lifecycle", new androidx.savedstate.a.c() { // from class: androidx.fragment.app.m
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return q.H(this.f816a);
            }
        });
        c(new x.a() { // from class: androidx.fragment.app.n
            @Override // x.a
            public final void accept(Object obj) {
                this.f820a.F.m();
            }
        });
        y(new x.a() { // from class: androidx.fragment.app.o
            @Override // x.a
            public final void accept(Object obj) {
                this.f821a.F.m();
            }
        });
        x(new d.b() { // from class: androidx.fragment.app.p
            @Override // d.b
            public final void a(Context context) {
                this.f822a.F.a(null);
            }
        });
    }

    public void M() {
        while (N(K(), Lifecycle.State.CREATED)) {
        }
    }

    public void P() {
        this.G.h(Lifecycle.Event.ON_RESUME);
        this.F.h();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (o(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.H);
            printWriter.print(" mResumed=");
            printWriter.print(this.I);
            printWriter.print(" mStopped=");
            printWriter.print(this.J);
            if (getApplication() != null) {
                j0.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.F.l().b0(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.F.m();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.G.h(Lifecycle.Event.ON_CREATE);
        this.F.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewJ = J(view, str, context, attributeSet);
        return viewJ == null ? super.onCreateView(view, str, context, attributeSet) : viewJ;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.F.f();
        this.G.h(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.F.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.I = false;
        this.F.g();
        this.G.h(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        P();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.F.m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.F.m();
        super.onResume();
        this.I = true;
        this.F.k();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.F.m();
        super.onStart();
        this.J = false;
        if (!this.H) {
            this.H = true;
            this.F.c();
        }
        this.F.k();
        this.G.h(Lifecycle.Event.ON_START);
        this.F.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.F.m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.J = true;
        M();
        this.F.j();
        this.G.h(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewJ = J(null, str, context, attributeSet);
        return viewJ == null ? super.onCreateView(str, context, attributeSet) : viewJ;
    }

    public void O(Fragment fragment) {
    }

    @Override // n.a.e
    public final void a(int i10) {
    }
}
