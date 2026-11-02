package t9;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import pa.r;
import w5.k;
import w9.n;
import x7.u;
import z8.b0;
import z8.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {
    public static /* synthetic */ void b(Context context, Runnable runnable, View view, k.p pVar) {
        b0.n(context);
        n.e().u(true);
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void d(Context context, final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.startsWith("file://") || str.startsWith("view-source:") || str.startsWith("about:")) {
            return;
        }
        h.b(new Runnable() { // from class: t9.b
            @Override // java.lang.Runnable
            public final void run() {
                r.f().t(str, str2);
            }
        });
        n.e().u(true);
    }

    public static void e(final Context context, final Runnable runnable) {
        g6.n.e(context, u.f14228y, u.f14219x3, new k.m() { // from class: t9.c
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                e.b(context, runnable, view, pVar);
            }
        });
    }

    public static void f(Context context, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        h.b(new Runnable() { // from class: t9.d
            @Override // java.lang.Runnable
            public final void run() {
                r.f().e(str);
            }
        });
        n.e().u(true);
    }
}
