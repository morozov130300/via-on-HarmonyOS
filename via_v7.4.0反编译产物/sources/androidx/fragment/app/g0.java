package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g0 extends androidx.lifecycle.x {

    /* renamed from: k, reason: collision with root package name */
    public static final y.b f840k = new a();

    /* renamed from: g, reason: collision with root package name */
    public final boolean f844g;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f841d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f842e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f843f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public boolean f845h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f846i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f847j = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements y.b {
        @Override // androidx.lifecycle.y.b
        public androidx.lifecycle.x a(Class cls) {
            return new g0(true);
        }

        @Override // androidx.lifecycle.y.b
        public /* synthetic */ androidx.lifecycle.x b(Class cls, h0.a aVar) {
            return androidx.lifecycle.z.b(this, cls, aVar);
        }
    }

    public g0(boolean z10) {
        this.f844g = z10;
    }

    public static g0 p(androidx.lifecycle.b0 b0Var) {
        return (g0) new androidx.lifecycle.y(b0Var, f840k).a(g0.class);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g0.class == obj.getClass()) {
            g0 g0Var = (g0) obj;
            if (this.f841d.equals(g0Var.f841d) && this.f842e.equals(g0Var.f842e) && this.f843f.equals(g0Var.f843f)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.lifecycle.x
    public void h() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f845h = true;
    }

    public int hashCode() {
        return (((this.f841d.hashCode() * 31) + this.f842e.hashCode()) * 31) + this.f843f.hashCode();
    }

    public void j(Fragment fragment) {
        if (this.f847j) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f841d.containsKey(fragment.f670n)) {
                return;
            }
            this.f841d.put(fragment.f670n, fragment);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void k(Fragment fragment, boolean z10) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        m(fragment.f670n, z10);
    }

    public void l(String str, boolean z10) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        m(str, z10);
    }

    public final void m(String str, boolean z10) {
        g0 g0Var = (g0) this.f842e.get(str);
        if (g0Var != null) {
            if (z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(g0Var.f842e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g0Var.l((String) it.next(), true);
                }
            }
            g0Var.h();
            this.f842e.remove(str);
        }
        androidx.lifecycle.b0 b0Var = (androidx.lifecycle.b0) this.f843f.get(str);
        if (b0Var != null) {
            b0Var.a();
            this.f843f.remove(str);
        }
    }

    public Fragment n(String str) {
        return (Fragment) this.f841d.get(str);
    }

    public g0 o(Fragment fragment) {
        g0 g0Var = (g0) this.f842e.get(fragment.f670n);
        if (g0Var != null) {
            return g0Var;
        }
        g0 g0Var2 = new g0(this.f844g);
        this.f842e.put(fragment.f670n, g0Var2);
        return g0Var2;
    }

    public Collection q() {
        return new ArrayList(this.f841d.values());
    }

    public androidx.lifecycle.b0 r(Fragment fragment) {
        androidx.lifecycle.b0 b0Var = (androidx.lifecycle.b0) this.f843f.get(fragment.f670n);
        if (b0Var != null) {
            return b0Var;
        }
        androidx.lifecycle.b0 b0Var2 = new androidx.lifecycle.b0();
        this.f843f.put(fragment.f670n, b0Var2);
        return b0Var2;
    }

    public boolean s() {
        return this.f845h;
    }

    public void t(Fragment fragment) {
        if (this.f847j) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f841d.remove(fragment.f670n) == null || !FragmentManager.O0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f841d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f842e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f843f.keySet().iterator();
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
        this.f847j = z10;
    }

    public boolean v(Fragment fragment) {
        if (this.f841d.containsKey(fragment.f670n)) {
            return this.f844g ? this.f845h : !this.f846i;
        }
        return true;
    }
}
