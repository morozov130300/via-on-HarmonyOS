package z8;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {
    public static /* synthetic */ void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public static void b(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        g7.a.c().d(new Runnable() { // from class: z8.g
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
        if (fragment == null || !fragment.i1() || fragment.j1()) {
            return;
        }
        fragment.l0().runOnUiThread(runnable);
    }
}
