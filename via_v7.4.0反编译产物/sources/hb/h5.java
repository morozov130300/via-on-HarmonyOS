package hb;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f6569r0;

    /* renamed from: s0, reason: collision with root package name */
    public s8.b f6570s0;

    public static /* synthetic */ void h3(h5 h5Var, View view, k.p pVar) {
        h5Var.getClass();
        h5Var.f6570s0.b().m(pVar.f13339c[0].trim());
        h5Var.s3();
    }

    public static /* synthetic */ void i3(h5 h5Var, View view, k.p pVar) {
        h5Var.getClass();
        h5Var.f6570s0.b().a(pVar.f13339c[0].trim());
        h5Var.s3();
    }

    public static /* synthetic */ void j3(h5 h5Var, View view, int i10, a6.n nVar) {
        h5Var.getClass();
        if (nVar.c() == 1) {
            h5Var.t3(!nVar.i());
        } else if (nVar.c() == 2) {
            h5Var.u3(!nVar.i());
        }
    }

    public static /* synthetic */ void k3(h5 h5Var, String str, View view) {
        h5Var.f6570s0.b().k(str);
        h5Var.s3();
    }

    public static /* synthetic */ void m3(h5 h5Var, View view, int i10, a6.q qVar) {
        h5Var.getClass();
        if (qVar.c() == 4) {
            h5Var.r3(qVar.d());
        } else {
            h5Var.q3(qVar.a());
        }
    }

    public static /* synthetic */ void n3(h5 h5Var, String str, View view, k.p pVar) {
        h5Var.getClass();
        String strTrim = pVar.f13339c[0].trim();
        h5Var.f6570s0.b().k(str);
        h5Var.f6570s0.b().a(strTrim);
        h5Var.s3();
    }

    private void s3() {
        v3(p3(this.f6570s0.b()));
    }

    private void v3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f6569r0.H(), list));
        this.f6569r0.M(list);
        eVarB.c(this.f6569r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        if (this.f6570s0.b().g()) {
            z8.h.b(new Runnable() { // from class: hb.z4
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f6864e.f6570s0.b().b();
                }
            });
            if (this.f6570s0.b().f()) {
                this.f6570s0.f();
                this.f6570s0.e();
            } else {
                this.f6570s0.f();
            }
        }
        super.F1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6569r0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.a5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                h5.m3(this.f6466a, view2, i10, (a6.q) obj);
            }
        });
        this.f6569r0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: hb.b5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6481a.o3();
            }
        });
        this.f6569r0.K(a6.e.class, fVar);
        this.f6569r0.K(a6.l.class, new a6.m());
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.c5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                h5.j3(this.f6511a, view2, i10, (a6.n) obj);
            }
        });
        this.f6569r0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f6569r0);
        s3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, "Proxy");
    }

    public final void o3() {
        w5.k.l(I()).e0(this.f6570s0.b().h() ? "Add proxy rule" : "Add bypass rule").i("", "*example.com", 1).V(R.string.ok, new k.m() { // from class: hb.g5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h5.i3(this.f6561a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final List p3(s8.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (!this.f6570s0.c()) {
            arrayList.add(new a6.q(0, "Enable Proxy", "Proxy is not supported.", true));
            return arrayList;
        }
        arrayList.add(new a6.n(1, "Enable proxy", null, cVar.f()));
        arrayList.add(new a6.q(4, "Proxy url", cVar.d()));
        arrayList.add(new a6.n(2, "Reverse bypass rules", (String) null, cVar.h(), !this.f6570s0.d()));
        arrayList.add(new a6.e(3, cVar.h() ? "Add proxy rule" : "Add bypass rule", lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        Set setC = cVar.c();
        if (setC != null && !setC.isEmpty()) {
            if (cVar.h()) {
                arrayList.add(new a6.l("Proxy rules"));
            } else {
                arrayList.add(new a6.l("Bypass rules"));
            }
            ArrayList<String> arrayList2 = new ArrayList(setC);
            Collections.sort(arrayList2);
            for (String str : arrayList2) {
                arrayList.add(new a6.q(str.hashCode(), str));
            }
        }
        return arrayList;
    }

    public final void q3(final String str) {
        w5.k.l(I()).e0(this.f6570s0.b().h() ? "Edit proxy rule" : "Edit bypass rule").i(str, "*example.com", 1).V(R.string.ok, new k.m() { // from class: hb.e5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h5.n3(this.f6533a, str, view, pVar);
            }
        }).N(R.string.cancel, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: hb.f5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h5.k3(this.f6546a, str, view);
            }
        }).f0();
    }

    public final void r3(String str) {
        w5.k.l(I()).e0("Proxy url").i(str, "socks://127.0.0.1:1080", 1).V(R.string.ok, new k.m() { // from class: hb.d5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h5.h3(this.f6522a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void t3(boolean z10) {
        this.f6570s0.b().l(z10);
        s3();
    }

    public final void u3(boolean z10) {
        this.f6570s0.b().n(z10);
        s3();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        pa.r.b(I()).t(this);
    }
}
