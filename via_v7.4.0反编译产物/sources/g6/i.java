package g6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6223a = y.l();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f6224b = new WeakHashMap();

    public static FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(f6223a);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public static Fragment b(Context context) {
        Activity activityA = f.a(context);
        if (activityA instanceof androidx.fragment.app.q) {
            return c((androidx.fragment.app.q) activityA);
        }
        return null;
    }

    public static Fragment c(androidx.fragment.app.q qVar) {
        for (Fragment fragment : qVar.L().A0()) {
            if (fragment != null && fragment.q1()) {
                return fragment;
            }
        }
        return null;
    }

    public static boolean d(Fragment fragment) {
        return fragment == null || !fragment.q1() || fragment.p1();
    }

    public static void e(Fragment fragment, int i10, Class cls, Bundle bundle, String str) {
        if (fragment == null) {
            return;
        }
        f(fragment, fragment.N0(), i10, cls, bundle, str);
    }

    public static void f(Fragment fragment, FragmentManager fragmentManager, int i10, Class cls, Bundle bundle, String str) {
        if (fragment == null || d(fragment)) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map map = f6224b;
        Long l10 = (Long) map.get(fragment);
        if (l10 == null || jElapsedRealtime - l10.longValue() > 300) {
            map.put(fragment, Long.valueOf(jElapsedRealtime));
            fragmentManager.q().x(true).v(x7.i.f13638c, x7.i.f13639d, x7.i.f13640e, x7.i.f13641f).c(i10, cls, bundle, str).q(fragment).g(null).i();
        }
    }

    public static void g(Fragment fragment, Class cls) {
        e(fragment, f6223a, cls, null, cls.getSimpleName());
    }

    public static void h(Fragment fragment, Class cls, Bundle bundle) {
        e(fragment, f6223a, cls, bundle, cls.getSimpleName());
    }

    public static void i(Fragment fragment, Class cls, Bundle bundle, String str) {
        e(fragment, f6223a, cls, bundle, str);
    }

    public static void j(androidx.fragment.app.q qVar, Class cls, Bundle bundle, String str) {
        qVar.L().q().x(true).u(f6223a, cls, bundle, str).i();
    }
}
