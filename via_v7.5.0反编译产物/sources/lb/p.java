package lb;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import autodispose2.r;
import com.tuyafeng.support.widget.e0;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import la.s;
import r6.q;
import w7.u;
import x8.b1;
import x8.c1;
import x8.f4;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f7639u0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public u9.l f7642x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public mb.d f7643y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f7644z0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final List f7640v0 = new ArrayList();

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f7641w0 = null;
    public final n8.f A0 = new n8.f(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            v5.i iVar = new v5.i(viewGroup.getContext());
            iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return iVar;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, mb.c cVar, int i10) {
            gVar.T(v5.i.f13394m, cVar.a() != null && cVar.a().equals(p.this.f7641w0));
            gVar.X(v5.i.f13392c, cVar.c());
            gVar.Y(v5.i.f13393e, false);
        }
    }

    public static /* synthetic */ void f3(p pVar, mb.c cVar, int i10, View view, q5.k.p pVar2) {
        if (pVar.f7643y0.b(cVar.a())) {
            pVar.f7640v0.remove(i10);
            pVar.f7639u0.u(i10);
            String str = pVar.f7641w0;
            if (str == null || !str.equals(cVar.a())) {
                return;
            }
            pVar.s3("");
            pVar.f7639u0.m(0);
        }
    }

    public static /* synthetic */ s5.a g3(p pVar, Uri uri) {
        String strK = b1.k(pVar.G(), uri);
        long j10 = b1.j(pVar.G(), uri);
        mb.c cVar = null;
        if (strK == null || j10 < 0 || j10 > 12582912) {
            return s5.a.f(null);
        }
        InputStream inputStreamI = b1.i(pVar.G(), uri);
        int iLastIndexOf = strK.lastIndexOf(46);
        if (iLastIndexOf >= strK.length() - 5) {
            strK = strK.substring(0, iLastIndexOf);
        }
        File file = new File(pVar.f7644z0, strK);
        if (f4.a(inputStreamI, file.getAbsolutePath()) && file.exists()) {
            cVar = new mb.c(file.getName(), file.getName(), file.lastModified());
        }
        return s5.a.f(cVar);
    }

    public static /* synthetic */ void h3(p pVar, View view, int i10, mb.c cVar) {
        int iP3 = pVar.p3(pVar.f7641w0);
        if (iP3 == i10) {
            return;
        }
        pVar.s3(cVar.a());
        if (iP3 >= 0) {
            pVar.f7639u0.m(iP3);
        }
        pVar.f7639u0.m(i10);
    }

    public static /* synthetic */ boolean j3(final p pVar, View view, final int i10, final mb.c cVar) {
        if (i10 == 0) {
            pVar.getClass();
            return false;
        }
        q5.k.l(pVar.G()).f0(u.f14298y).K(pVar.Y0(u.f14222s3, cVar.c())).X(R.string.ok, new q5.k.m() { // from class: lb.l
            @Override // q5.k.m
            public final void a(View view2, q5.k.p pVar2) {
                p.f3(this.f7632a, cVar, i10, view2, pVar2);
            }
        }).P(R.string.cancel, null).h0();
        return true;
    }

    public static /* synthetic */ void m3(p pVar, s5.a aVar) {
        pVar.getClass();
        if (!aVar.d()) {
            com.tuyafeng.support.utils.n.s(pVar.G(), pVar.X0(u.Q7));
            return;
        }
        mb.c cVar = (mb.c) aVar.b();
        int iP3 = pVar.p3(cVar.a());
        if (iP3 > 0) {
            pVar.f7639u0.m(iP3);
        } else {
            pVar.f7640v0.add(1, cVar);
            pVar.f7639u0.o(1);
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7642x0 = s.j();
        String strF = c1.F(G());
        this.f7644z0 = strF;
        this.f7643y0 = new mb.d(new mb.b(strF));
        this.f7641w0 = this.f7642x0.U1();
        this.f7639u0 = new t5.f(this.f7640v0);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: lb.h
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                p.h3(this.f7628a, view2, i10, (mb.c) obj);
            }
        });
        aVar.k(new t5.h() { // from class: lb.i
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return p.j3(this.f7629a, view2, i10, (mb.c) obj);
            }
        });
        this.f7639u0.K(mb.c.class, aVar);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setAdapter(this.f7639u0);
        r3();
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        v3.b(e0Var, X0(u.jd));
        e0Var.c(new e0.b(1, 1, g.a(G(), w7.o.f13810m, u.ge), X0(u.P7)), new View.OnClickListener() { // from class: lb.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7630a.q3();
            }
        });
    }

    public final void o3(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((r) q.f(new Callable() { // from class: lb.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p.g3(this.f7636c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: lb.o
            @Override // u6.f
            public final void accept(Object obj) {
                p.m3(this.f7638c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public final int p3(String str) {
        int size = this.f7640v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = ((mb.c) this.f7640v0.get(i10)).a();
            if (strA != null && strA.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public final void q3() {
        this.A0.b(new String[]{"application/zip"}, new n8.f.a() { // from class: lb.m
            @Override // n8.f.a
            public final void a(Uri uri) {
                this.f7635a.o3(uri);
            }
        });
    }

    public final void r3() {
        List listA = this.f7643y0.a();
        listA.add(0, new mb.c("", X0(u.f14110k3), 0L));
        this.f7640v0.clear();
        this.f7640v0.addAll(listA);
        this.f7639u0.l();
    }

    public final void s3(String str) {
        this.f7641w0 = str;
        this.f7642x0.M(str);
        q5.k.l(G()).f0(u.gd).J(u.f14310yb).X(u.U2, new q5.k.m() { // from class: lb.k
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                x8.f.k(this.f7631a.G());
            }
        }).P(R.string.cancel, null).h0();
    }
}
