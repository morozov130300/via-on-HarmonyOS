package lb;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import g6.n;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p8.f;
import pa.r;
import w5.k;
import w9.l;
import x7.g0;
import x7.o;
import x7.u;
import z8.b1;
import z8.c1;
import z8.e4;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f8480r0;

    /* renamed from: u0, reason: collision with root package name */
    public l f8483u0;

    /* renamed from: v0, reason: collision with root package name */
    public mb.d f8484v0;

    /* renamed from: w0, reason: collision with root package name */
    public String f8485w0;

    /* renamed from: s0, reason: collision with root package name */
    public final List f8481s0 = new ArrayList();

    /* renamed from: t0, reason: collision with root package name */
    public String f8482t0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public final p8.f f8486x0 = new p8.f(this);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            a6.i iVar = new a6.i(viewGroup.getContext());
            iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return iVar;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, mb.c cVar, int i10) {
            gVar.T(a6.i.f110k, cVar.a() != null && cVar.a().equals(k.this.f8482t0));
            gVar.X(a6.i.f108e, cVar.c());
            gVar.Y(a6.i.f109j, false);
        }
    }

    public static /* synthetic */ void g3(k kVar, mb.c cVar, int i10, View view, k.p pVar) {
        if (kVar.f8484v0.b(cVar.a())) {
            kVar.f8481s0.remove(i10);
            kVar.f8480r0.u(i10);
            String str = kVar.f8482t0;
            if (str == null || !str.equals(cVar.a())) {
                return;
            }
            kVar.t3("");
            kVar.f8480r0.m(0);
        }
    }

    public static /* synthetic */ x5.a h3(k kVar, Uri uri) {
        String strK = b1.k(kVar.I(), uri);
        long j10 = b1.j(kVar.I(), uri);
        mb.c cVar = null;
        if (strK == null || j10 < 0 || j10 > 12582912) {
            return x5.a.f(null);
        }
        InputStream inputStreamI = b1.i(kVar.I(), uri);
        int iLastIndexOf = strK.lastIndexOf(46);
        if (iLastIndexOf >= strK.length() - 5) {
            strK = strK.substring(0, iLastIndexOf);
        }
        File file = new File(kVar.f8485w0, strK);
        if (e4.a(inputStreamI, file.getAbsolutePath()) && file.exists()) {
            cVar = new mb.c(file.getName(), file.getName(), file.lastModified());
        }
        return x5.a.f(cVar);
    }

    public static /* synthetic */ void i3(k kVar, View view, int i10, mb.c cVar) {
        int iQ3 = kVar.q3(kVar.f8482t0);
        if (iQ3 == i10) {
            return;
        }
        kVar.t3(cVar.a());
        if (iQ3 >= 0) {
            kVar.f8480r0.m(iQ3);
        }
        kVar.f8480r0.m(i10);
    }

    public static /* synthetic */ boolean k3(final k kVar, View view, final int i10, final mb.c cVar) {
        if (i10 == 0) {
            kVar.getClass();
            return false;
        }
        w5.k.l(kVar.I()).d0(u.f14215x).J(kVar.a1(u.f13988g3, cVar.c())).V(R.string.ok, new k.m() { // from class: lb.g
            @Override // w5.k.m
            public final void a(View view2, k.p pVar) {
                k.g3(this.f8473a, cVar, i10, view2, pVar);
            }
        }).N(R.string.cancel, null).f0();
        return true;
    }

    public static /* synthetic */ void n3(k kVar, x5.a aVar) {
        kVar.getClass();
        if (!aVar.d()) {
            n.s(kVar.I(), kVar.Z0(u.E7));
            return;
        }
        mb.c cVar = (mb.c) aVar.b();
        int iQ3 = kVar.q3(cVar.a());
        if (iQ3 > 0) {
            kVar.f8480r0.m(iQ3);
        } else {
            kVar.f8481s0.add(1, cVar);
            kVar.f8480r0.o(1);
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f8483u0 = r.j();
        String strF = c1.F(I());
        this.f8485w0 = strF;
        this.f8484v0 = new mb.d(new mb.b(strF));
        this.f8482t0 = this.f8483u0.T1();
        this.f8480r0 = new y5.f(this.f8481s0);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: lb.c
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k.i3(this.f8469a, view2, i10, (mb.c) obj);
            }
        });
        aVar.k(new y5.h() { // from class: lb.d
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return k.k3(this.f8470a, view2, i10, (mb.c) obj);
            }
        });
        this.f8480r0.K(mb.c.class, aVar);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setAdapter(this.f8480r0);
        s3();
    }

    @Override // o8.h
    public void a3(z zVar) {
        v3.b(zVar, Z0(u.Tc));
        zVar.c(new z.b(1, 1, b.a(I(), o.f13747n, u.Rd), Z0(u.D7)), new View.OnClickListener() { // from class: lb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8471a.r3();
            }
        });
    }

    public final void p3(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: lb.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k.h3(this.f8477e, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: lb.j
            @Override // a7.e
            public final void accept(Object obj) {
                k.n3(this.f8479e, (x5.a) obj);
            }
        }, new g0());
    }

    public final int q3(String str) {
        int size = this.f8481s0.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = ((mb.c) this.f8481s0.get(i10)).a();
            if (strA != null && strA.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public final void r3() {
        this.f8486x0.b(new String[]{"application/zip"}, new f.a() { // from class: lb.h
            @Override // p8.f.a
            public final void a(Uri uri) {
                this.f8476a.p3(uri);
            }
        });
    }

    public final void s3() {
        List listA = this.f8484v0.a();
        listA.add(0, new mb.c("", Z0(u.Y2), 0L));
        this.f8481s0.clear();
        this.f8481s0.addAll(listA);
        this.f8480r0.l();
    }

    public final void t3(String str) {
        this.f8482t0 = str;
        this.f8483u0.L(str);
        w5.k.l(I()).d0(u.Rc).I(u.f14080mb).V(u.I2, new k.m() { // from class: lb.f
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                z8.f.k(this.f8472a.I());
            }
        }).N(R.string.cancel, null).f0();
    }
}
