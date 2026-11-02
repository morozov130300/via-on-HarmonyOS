package z8;

import android.R;
import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class z1 {
    public static /* synthetic */ void b(Runnable runnable, Fragment fragment, Boolean bool) {
        if (!bool.booleanValue()) {
            f(fragment.l0());
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
        return fragment.y2(new e.g(), new androidx.activity.result.a() { // from class: z8.w1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                z1.b(runnable, fragment, (Boolean) obj);
            }
        });
    }

    public static androidx.activity.result.b e(Fragment fragment, final Runnable runnable, final Runnable runnable2) {
        return fragment.y2(new e.g(), new androidx.activity.result.a() { // from class: z8.x1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                z1.c(runnable, runnable2, (Boolean) obj);
            }
        });
    }

    public static void f(final Activity activity) {
        g6.n.r(activity, x7.u.X1, R.string.ok, new View.OnClickListener() { // from class: z8.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.j(activity, f1.d());
            }
        });
    }
}
