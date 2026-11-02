package q0;

import android.webkit.WebSettings;
import r0.a;
import r0.n;
import r0.o;
import r0.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {
    public static n a(WebSettings webSettings) {
        return p.c().b(webSettings);
    }

    public static d b(WebSettings webSettings) {
        if (o.f11483b0.d()) {
            return a(webSettings).a();
        }
        throw o.a();
    }

    public static void c(WebSettings webSettings, boolean z10) {
        if (!o.P.d()) {
            throw o.a();
        }
        a(webSettings).b(z10);
    }

    public static void d(WebSettings webSettings, int i10) {
        a.h hVar = o.S;
        if (hVar.c()) {
            r0.g.a(webSettings, i10);
        } else {
            if (!hVar.d()) {
                throw o.a();
            }
            a(webSettings).c(i10);
        }
    }

    public static void e(WebSettings webSettings, d dVar) {
        if (!o.f11483b0.d()) {
            throw o.a();
        }
        a(webSettings).d(dVar);
    }

    public static void f(WebSettings webSettings, int i10) {
        if (!o.f11493g0.d()) {
            throw o.a();
        }
        a(webSettings).e(i10);
    }
}
