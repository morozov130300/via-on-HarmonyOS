package com.tuyafeng.support.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3568a = x.l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f3569b = new WeakHashMap();

    public static /* synthetic */ void a(androidx.lifecycle.i iVar, androidx.lifecycle.j jVar) {
        if (jVar != null) {
            jVar.h0().a(iVar);
        }
    }

    public static FrameLayout b(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(f3568a);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public static Fragment c(Context context) {
        Activity activityA = f.a(context);
        if (activityA instanceof androidx.fragment.app.q) {
            return d((androidx.fragment.app.q) activityA);
        }
        return null;
    }

    public static Fragment d(androidx.fragment.app.q qVar) {
        for (Fragment fragment : qVar.K().A0()) {
            if (fragment != null && fragment.o1()) {
                return fragment;
            }
        }
        return null;
    }

    public static boolean e(Fragment fragment) {
        return fragment == null || !fragment.o1() || fragment.n1();
    }

    public static void f(final Fragment fragment, final androidx.lifecycle.i iVar) {
        if (fragment.h0().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        final androidx.lifecycle.o oVar = new androidx.lifecycle.o() { // from class: com.tuyafeng.support.utils.i
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                FragmentUtils.a(iVar, (androidx.lifecycle.j) obj);
            }
        };
        fragment.c1().h(oVar);
        fragment.h0().a(new androidx.lifecycle.d() { // from class: com.tuyafeng.support.utils.FragmentUtils.1
            @Override // androidx.lifecycle.d
            public /* synthetic */ void b(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.c(this, jVar);
            }

            @Override // androidx.lifecycle.d
            public /* synthetic */ void c(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.a(this, jVar);
            }

            @Override // androidx.lifecycle.d
            public /* synthetic */ void f(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.b(this, jVar);
            }

            @Override // androidx.lifecycle.d
            public /* synthetic */ void g(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.e(this, jVar);
            }

            @Override // androidx.lifecycle.d
            public void i(androidx.lifecycle.j jVar) {
                fragment.c1().l(oVar);
            }

            @Override // androidx.lifecycle.d
            public /* synthetic */ void j(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.d(this, jVar);
            }
        });
    }

    public static void g(Fragment fragment, int i10, Class cls, Bundle bundle, String str) {
        if (fragment == null) {
            return;
        }
        h(fragment, fragment.L0(), i10, cls, bundle, str);
    }

    public static void h(Fragment fragment, FragmentManager fragmentManager, int i10, Class cls, Bundle bundle, String str) {
        if (fragment == null || e(fragment)) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map map = f3569b;
        Long l10 = (Long) map.get(fragment);
        if (l10 == null || jElapsedRealtime - l10.longValue() > 300) {
            map.put(fragment, Long.valueOf(jElapsedRealtime));
            fragmentManager.q().x(true).v(w7.i.f13705c, w7.i.f13706d, w7.i.f13707e, w7.i.f13708f).c(i10, cls, bundle, str).q(fragment).w(fragment, Lifecycle.State.STARTED).g(null).i();
        }
    }

    public static void i(Fragment fragment, Class cls) {
        g(fragment, f3568a, cls, null, cls.getSimpleName());
    }

    public static void j(Fragment fragment, Class cls, Bundle bundle) {
        g(fragment, f3568a, cls, bundle, cls.getSimpleName());
    }

    public static void k(Fragment fragment, Class cls, Bundle bundle, String str) {
        g(fragment, f3568a, cls, bundle, str);
    }

    public static void l(androidx.fragment.app.q qVar, Class cls, Bundle bundle, String str) {
        qVar.K().q().x(true).u(f3568a, cls, bundle, str).i();
    }
}
