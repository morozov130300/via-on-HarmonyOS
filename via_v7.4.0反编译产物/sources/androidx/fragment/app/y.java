package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f986a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f987b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final FragmentManager.k f988a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f989b;

        public a(FragmentManager.k callback, boolean z10) {
            kotlin.jvm.internal.h.f(callback, "callback");
            this.f988a = callback;
            this.f989b = z10;
        }

        public final FragmentManager.k a() {
            return this.f988a;
        }

        public final boolean b() {
            return this.f989b;
        }
    }

    public y(FragmentManager fragmentManager) {
        kotlin.jvm.internal.h.f(fragmentManager, "fragmentManager");
        this.f986a = fragmentManager;
        this.f987b = new CopyOnWriteArrayList();
    }

    public final void a(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().a(f10, bundle, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().a(this.f986a, f10, bundle);
            }
        }
    }

    public final void b(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Context contextR = this.f986a.B0().r();
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().b(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().b(this.f986a, f10, contextR);
            }
        }
    }

    public final void c(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().c(f10, bundle, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().c(this.f986a, f10, bundle);
            }
        }
    }

    public final void d(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().d(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().d(this.f986a, f10);
            }
        }
    }

    public final void e(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().e(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().e(this.f986a, f10);
            }
        }
    }

    public final void f(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().f(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().f(this.f986a, f10);
            }
        }
    }

    public final void g(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Context contextR = this.f986a.B0().r();
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().g(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().g(this.f986a, f10, contextR);
            }
        }
    }

    public final void h(Fragment f10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().h(f10, bundle, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().h(this.f986a, f10, bundle);
            }
        }
    }

    public final void i(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().i(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().i(this.f986a, f10);
            }
        }
    }

    public final void j(Fragment f10, Bundle outState, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        kotlin.jvm.internal.h.f(outState, "outState");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().j(f10, outState, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().j(this.f986a, f10, outState);
            }
        }
    }

    public final void k(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().k(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().k(this.f986a, f10);
            }
        }
    }

    public final void l(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().l(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().l(this.f986a, f10);
            }
        }
    }

    public final void m(Fragment f10, View v10, Bundle bundle, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        kotlin.jvm.internal.h.f(v10, "v");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().m(f10, v10, bundle, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().m(this.f986a, f10, v10, bundle);
            }
        }
    }

    public final void n(Fragment f10, boolean z10) {
        kotlin.jvm.internal.h.f(f10, "f");
        Fragment fragmentE0 = this.f986a.E0();
        if (fragmentE0 != null) {
            FragmentManager fragmentManagerN0 = fragmentE0.N0();
            kotlin.jvm.internal.h.e(fragmentManagerN0, "parent.getParentFragmentManager()");
            fragmentManagerN0.D0().n(f10, true);
        }
        Iterator it = this.f987b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z10 || aVar.b()) {
                aVar.a().n(this.f986a, f10);
            }
        }
    }

    public final void o(FragmentManager.k cb2, boolean z10) {
        kotlin.jvm.internal.h.f(cb2, "cb");
        this.f987b.add(new a(cb2, z10));
    }

    public final void p(FragmentManager.k cb2) {
        kotlin.jvm.internal.h.f(cb2, "cb");
        synchronized (this.f987b) {
            try {
                int size = this.f987b.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    if (((a) this.f987b.get(i10)).a() == cb2) {
                        this.f987b.remove(i10);
                        break;
                    }
                    i10++;
                }
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
