package la;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.tuyafeng.support.utils.x;
import java.util.Objects;
import n9.v;
import n9.w;
import oa.k1;
import x8.c1;
import x8.j0;
import x8.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7535a;

        /* JADX INFO: renamed from: la.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0095a implements e6.c {
            public C0095a() {
            }

            @Override // e6.c
            public void a(View view, String str) {
                z.S(view.getContext(), str);
            }
        }

        public a(Context context) {
            this.f7535a = context;
        }

        @Override // e6.a, e6.i
        public void d(e6.g.b bVar) {
            bVar.i(new C0095a());
        }

        @Override // e6.a, e6.i
        public void f(f6.a.C0068a c0068a) {
            int iH = x.h(this.f7535a, 1.0f);
            c0068a.F(iH).E(iH).B(545292416).C(545292416);
        }
    }

    public static /* synthetic */ void a(u9.l lVar, qa.b bVar, qa.a aVar, Context context) {
        int iQ1 = lVar.Q1();
        int iN0 = bVar.n0(iQ1);
        if (iN0 != iQ1) {
            lVar.Y1(iN0);
        }
        aVar.Q();
        j0.c(p9.a.a().o() && lVar.v().e(), true);
        j0.d(context, true);
    }

    public Context b(Application application) {
        return application.getApplicationContext();
    }

    public u4.a c(Context context, u9.l lVar, u9.r rVar) {
        final u4.a aVarM = u4.a.m(context, c1.p(context), c1.H(context), lVar.F0(), rVar.b());
        Objects.requireNonNull(aVarM);
        x8.h.b(new Runnable() { // from class: la.b
            @Override // java.lang.Runnable
            public final void run() {
                aVarM.i();
            }
        });
        return aVarM;
    }

    public n9.o d(Context context) {
        return new v(new w(context));
    }

    public q9.d e(Context context) {
        return new q9.d(c1.x(context, "font"));
    }

    public e6.e f(Context context) {
        return e6.e.a(context).a(i6.b.j(i6.e.e(context).n(Math.max(0, x.p(context) - x.h(context, 64.0f))).m(0).l(0).o(1).i(1082163328).j(x.h(context, 1.0f)).k(x.h(context, 4.0f)).h())).a(l6.a.j(i6.a.a())).a(new a(context)).build();
    }

    public t9.g g(Context context, u9.l lVar) {
        return new t9.d(new ya.d(context), lVar, new t9.e(context), new t9.j(c1.y(context, "pass", "ignored_sites.txt")));
    }

    public u9.l h(Context context) {
        return new u9.k(new u9.e(context, "settings"), new u9.f());
    }

    public q8.b i(Context context) {
        return new q8.b(new q8.c(c1.y(context, "proxy", "config.txt")));
    }

    public ha.g j() {
        return new ha.g(new ia.a(s.f(), s.d()), new ja.a(), new ia.b());
    }

    public pb.b k(Context context, u9.l lVar) {
        return new pb.a(context, lVar.B1(), lVar.h0(), c1.y(context, "syncing", "storages.txt"), c1.y(context, "syncing", "temp"));
    }

    public k1 l(final Context context, final u9.l lVar) {
        final qa.b bVar = new qa.b(context.getApplicationContext());
        final qa.a aVar = new qa.a(bVar);
        x8.h.b(new Runnable() { // from class: la.c
            @Override // java.lang.Runnable
            public final void run() {
                d.a(lVar, bVar, aVar, context);
            }
        });
        return new oa.a(aVar);
    }

    public u9.r m(Context context) {
        return u9.r.a(s4.b.b(context));
    }
}
