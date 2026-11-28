package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f888b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentManager.k f889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f890b;

        public a(FragmentManager.k callback, boolean z10) {
            kotlin.jvm.internal.h.f(callback, "callback");
            this.f889a = callback;
            this.f890b = z10;
        }

        public final FragmentManager.k a() {
            return this.f889a;
        }

        public final boolean b() {
            return this.f890b;
        }
    }

    public y(FragmentManager fragmentManager) {
        kotlin.jvm.internal.h.f(fragmentManager, "fragmentManager");
        this.f887a = fragmentManager;
        this.f888b = new CopyOnWriteArrayList();
    }

    public final void a(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().a(f10, bundle, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().a(this.f887a, f10, bundle);
            }
        }
    }

    public final void b(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Context contextQ = this.f887a.B0().q();
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().b(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().b(this.f887a, f10, contextQ);
            }
        }
    }

    public final void c(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().c(f10, bundle, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().c(this.f887a, f10, bundle);
            }
        }
    }

    public final void d(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().d(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().d(this.f887a, f10);
            }
        }
    }

    public final void e(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().e(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().e(this.f887a, f10);
            }
        }
    }

    public final void f(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().f(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().f(this.f887a, f10);
            }
        }
    }

    public final void g(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Context contextQ = this.f887a.B0().q();
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().g(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().g(this.f887a, f10, contextQ);
            }
        }
    }

    public final void h(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().h(f10, bundle, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().h(this.f887a, f10, bundle);
            }
        }
    }

    public final void i(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().i(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().i(this.f887a, f10);
            }
        }
    }

    public final void j(Fragment f10, Bundle outState, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        kotlin.jvm.internal.h.f(outState, "outState");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().j(f10, outState, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().j(this.f887a, f10, outState);
            }
        }
    }

    public final void k(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().k(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().k(this.f887a, f10);
            }
        }
    }

    public final void l(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().l(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().l(this.f887a, f10);
            }
        }
    }

    public final void m(Fragment f10, View v10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        kotlin.jvm.internal.h.f(v10, "v");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().m(f10, v10, bundle, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().m(this.f887a, f10, v10, bundle);
            }
        }
    }

    public final void n(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f887a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerL0 = fragmentE0.L0();
            kotlin.jvm.internal.h.e(fragmentManagerL0, "parent.getParentFragmentManager()");
            fragmentManagerL0.D0().n(f10, true);
        }
        for (a aVar : this.f888b) {
            if (!z10 || aVar.b()) {
                aVar.a().n(this.f887a, f10);
            }
        }
    }

    public final void o(FragmentManager.k cb2, boolean z10) {
        kotlin.jvm.internal.h.f(cb2, "cb");
        this.f888b.add(new a(cb2, z10));
    }

    public final void p(FragmentManager.k cb2) {
        kotlin.jvm.internal.h.f(cb2, "cb");
        synchronized (this.f888b) {
            try {
                int size = this.f888b.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((a) this.f888b.get(i10)).a() == cb2) {
                        this.f888b.remove(i10);
                        break;
                    }
                }
                d7.h hVar = d7.h.f3935a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
