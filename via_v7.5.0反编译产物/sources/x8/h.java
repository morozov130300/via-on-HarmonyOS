package x8;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static /* synthetic */ void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public static void b(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a7.a.c().d(new Runnable() { // from class: x8.g
            @Override // java.lang.Runnable
            public final void run() {
                h.a(runnable);
            }
        });
    }

    public static void c(Activity activity, Runnable runnable) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(runnable);
    }

    public static void d(Fragment fragment, Runnable runnable) {
        if (fragment == null || !fragment.g1() || fragment.h1()) {
            return;
        }
        fragment.i0().runOnUiThread(runnable);
    }
}
