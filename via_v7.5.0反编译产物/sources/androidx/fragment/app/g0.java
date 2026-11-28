package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends androidx.lifecycle.z {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final androidx.lifecycle.a0.b f743k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f747g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f744d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f745e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f746f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f748h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f749i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f750j = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements androidx.lifecycle.a0.b {
        @Override // androidx.lifecycle.a0.b
        public androidx.lifecycle.z a(Class cls) {
            return new g0(true);
        }

        @Override // androidx.lifecycle.a0.b
        public /* synthetic */ androidx.lifecycle.z b(Class cls, i0.a aVar) {
            return androidx.lifecycle.b0.b(this, cls, aVar);
        }
    }

    public g0(boolean z10) {
        this.f747g = z10;
    }

    public static g0 p(androidx.lifecycle.d0 d0Var) {
        return (g0) new androidx.lifecycle.a0(d0Var, f743k).a(g0.class);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g0.class == obj.getClass()) {
            g0 g0Var = (g0) obj;
            if (this.f744d.equals(g0Var.f744d) && this.f745e.equals(g0Var.f745e) && this.f746f.equals(g0Var.f746f)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.lifecycle.z
    public void h() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f748h = true;
    }

    public int hashCode() {
        return (((this.f744d.hashCode() * 31) + this.f745e.hashCode()) * 31) + this.f746f.hashCode();
    }

    public void j(Fragment fragment) {
        if (this.f750j) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f744d.containsKey(fragment.f575p)) {
                return;
            }
            this.f744d.put(fragment.f575p, fragment);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void k(Fragment fragment, boolean z10) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        m(fragment.f575p, z10);
    }

    public void l(String str, boolean z10) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        m(str, z10);
    }

    public final void m(String str, boolean z10) {
        g0 g0Var = (g0) this.f745e.get(str);
        if (g0Var != null) {
            if (z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(g0Var.f745e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g0Var.l((String) it.next(), true);
                }
            }
            g0Var.h();
            this.f745e.remove(str);
        }
        androidx.lifecycle.d0 d0Var = (androidx.lifecycle.d0) this.f746f.get(str);
        if (d0Var != null) {
            d0Var.a();
            this.f746f.remove(str);
        }
    }

    public Fragment n(String str) {
        return (Fragment) this.f744d.get(str);
    }

    public g0 o(Fragment fragment) {
        g0 g0Var = (g0) this.f745e.get(fragment.f575p);
        if (g0Var != null) {
            return g0Var;
        }
        g0 g0Var2 = new g0(this.f747g);
        this.f745e.put(fragment.f575p, g0Var2);
        return g0Var2;
    }

    public Collection q() {
        return new ArrayList(this.f744d.values());
    }

    public androidx.lifecycle.d0 r(Fragment fragment) {
        androidx.lifecycle.d0 d0Var = (androidx.lifecycle.d0) this.f746f.get(fragment.f575p);
        if (d0Var != null) {
            return d0Var;
        }
        androidx.lifecycle.d0 d0Var2 = new androidx.lifecycle.d0();
        this.f746f.put(fragment.f575p, d0Var2);
        return d0Var2;
    }

    public boolean s() {
        return this.f748h;
    }

    public void t(Fragment fragment) {
        if (this.f750j) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f744d.remove(fragment.f575p) == null || !FragmentManager.O0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f744d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f745e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f746f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f750j = z10;
    }

    public boolean v(Fragment fragment) {
        if (this.f744d.containsKey(fragment.f575p)) {
            return this.f747g ? this.f748h : !this.f749i;
        }
        return true;
    }
}
