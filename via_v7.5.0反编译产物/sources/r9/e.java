package r9;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import la.s;
import q5.k;
import u9.n;
import w7.u;
import x8.h;
import x8.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static /* synthetic */ void b(Context context, Runnable runnable, View view, k.p pVar) {
        z.n(context);
        n.e().s(true);
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void d(Context context, final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.startsWith("file://") || str.startsWith("view-source:") || str.startsWith("about:")) {
            return;
        }
        h.b(new Runnable() { // from class: r9.b
            @Override // java.lang.Runnable
            public final void run() {
                s.f().t(str, str2);
            }
        });
        n.e().s(true);
    }

    public static void e(final Context context, final Runnable runnable) {
        com.tuyafeng.support.utils.n.e(context, u.f14311z, u.K3, new k.m() { // from class: r9.c
            @Override // q5.k.m
            public final void a(View view, k.p pVar) {
                e.b(context, runnable, view, pVar);
            }
        });
    }

    public static void f(Context context, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        h.b(new Runnable() { // from class: r9.d
            @Override // java.lang.Runnable
            public final void run() {
                s.f().e(str);
            }
        });
        n.e().s(true);
    }
}
