package x8;

import android.R;
import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class y1 {
    public static /* synthetic */ void b(Runnable runnable, Fragment fragment, Boolean bool) {
        if (!bool.booleanValue()) {
            f(fragment.i0());
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void c(Runnable runnable, Runnable runnable2, Boolean bool) {
        if (bool.booleanValue()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (runnable2 != null) {
            runnable2.run();
        }
    }

    public static androidx.activity.result.b d(final Fragment fragment, final Runnable runnable) {
        return fragment.w2(new e.g(), new androidx.activity.result.a() { // from class: x8.v1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                y1.b(runnable, fragment, (Boolean) obj);
            }
        });
    }

    public static androidx.activity.result.b e(Fragment fragment, final Runnable runnable, final Runnable runnable2) {
        return fragment.w2(new e.g(), new androidx.activity.result.a() { // from class: x8.x1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                y1.c(runnable, runnable2, (Boolean) obj);
            }
        });
    }

    public static void f(final Activity activity) {
        com.tuyafeng.support.utils.n.r(activity, w7.u.f14109k2, R.string.ok, new View.OnClickListener() { // from class: x8.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e1.j(activity, e1.d());
            }
        });
    }
}
