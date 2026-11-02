package pa;

import android.app.Application;
import android.content.Context;
import android.view.View;
import g6.y;
import java.util.Objects;
import k6.g;
import l6.a;
import p9.v;
import p9.w;
import sa.i1;
import z8.b0;
import z8.c1;
import z8.j0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends k6.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11084a;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: pa.c$a$a, reason: collision with other inner class name */
        public class C0112a implements k6.c {
            public C0112a() {
            }

            @Override // k6.c
            public void a(View view, String str) {
                b0.T(view.getContext(), str);
            }
        }

        public a(Context context) {
            this.f11084a = context;
        }

        @Override // k6.a, k6.i
        public void c(g.b bVar) {
            bVar.i(new C0112a());
        }

        @Override // k6.a, k6.i
        public void g(a.C0095a c0095a) {
            int iH = y.h(this.f11084a, 1.0f);
            c0095a.F(iH).E(iH).B(545292416).C(545292416);
        }
    }

    public static /* synthetic */ void a(p5.a aVar, w9.l lVar, Context context) {
        aVar.Q();
        j0.c(context, r9.g.a().l().e() && lVar.v().e(), true);
    }

    public Context b(Application application) {
        return application.getApplicationContext();
    }

    public u4.a c(Context context, w9.l lVar, w9.r rVar) {
        u4.a aVarM = u4.a.m(context, c1.o(context), c1.H(context), lVar.D0(), rVar.b());
        Objects.requireNonNull(aVarM);
        z8.h.b(new m9.k(aVarM));
        return aVarM;
    }

    public p9.o d(Context context) {
        return new v(new w(context));
    }

    public s9.d e(Context context) {
        return new s9.d(c1.v(context, "font"));
    }

    public k6.e f(Context context) {
        return k6.e.a(context).a(o6.b.j(o6.e.e(context).n(Math.max(0, y.p(context) - y.h(context, 64.0f))).m(0).l(0).o(1).i(1082163328).j(y.h(context, 1.0f)).k(y.h(context, 4.0f)).h())).a(r6.a.j(o6.a.a())).a(new a(context)).build();
    }

    public v9.g g(Context context, w9.l lVar) {
        return new v9.d(new ya.d(context), lVar, new v9.e(context), new v9.j(c1.w(context, "pass", "ignored_sites.txt")));
    }

    public w9.l h(Context context) {
        return new w9.k(new w9.e(context, "settings"), new w9.f());
    }

    public s8.b i(Context context) {
        return new s8.b(new s8.c(c1.w(context, "proxy", "config.txt")));
    }

    public ka.g j() {
        return new ka.g(new la.a(r.f(), r.d()), new ma.e(), new la.b());
    }

    public pb.b k(Context context, w9.l lVar) {
        return new pb.a(context, lVar.A1(), lVar.e0(), c1.w(context, "syncing", "storages.txt"), c1.w(context, "syncing", "temp"));
    }

    public n5.b l(final Context context, final w9.l lVar) {
        i1 i1Var = new i1();
        final p5.a aVar = new p5.a(new p5.b(context.getApplicationContext()));
        z8.h.b(new Runnable() { // from class: pa.b
            @Override // java.lang.Runnable
            public final void run() {
                c.a(aVar, lVar, context);
            }
        });
        return new n5.a(aVar, i1Var);
    }

    public w9.r m(Context context) {
        return w9.r.a(s4.b.b(context));
    }
}
