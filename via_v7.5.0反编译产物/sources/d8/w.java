package d8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.browser.kd;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w extends c {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public b f3994u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public RecyclerView f3995v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f3996w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f3997x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f3998y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public u9.l f3999z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements e8.u.b {
        public a() {
        }

        @Override // e8.u.b
        public void a() {
            w.this.g3(5);
        }

        @Override // e8.u.b
        public void b() {
            w.this.g3(6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i(boolean z10);
    }

    public static /* synthetic */ void Y2(w wVar, int i10) {
        wVar.f3999z0.Z2(i10);
        wVar.h3();
    }

    public static /* synthetic */ void Z2(w wVar, int i10) {
        wVar.f3999z0.q1(i10);
        wVar.h3();
    }

    public static /* synthetic */ void a3(w wVar, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(wVar.G()));
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(recyclerView);
    }

    public static /* synthetic */ boolean b3(w wVar, View view, int i10, v5.q qVar) {
        wVar.getClass();
        if (8 != qVar.c()) {
            return false;
        }
        b bVar = wVar.f3994u0;
        if (bVar == null) {
            return true;
        }
        bVar.f();
        return true;
    }

    public static /* synthetic */ void c3(w wVar, View view, int i10, v5.q qVar) {
        wVar.getClass();
        wVar.g3(qVar.c());
    }

    private void f3() {
        if (g1()) {
            k3(e3());
        }
    }

    private void k3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new e8.n(this.f3996w0.H(), list));
        this.f3996w0.M(list);
        eVarB.c(this.f3996w0);
    }

    @Override // d8.c
    public CharSequence U2() {
        return X0(w7.u.ad);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f3999z0 = la.s.j();
        this.f3996w0 = new t5.f(Collections.EMPTY_LIST);
        e8.u uVar = new e8.u();
        uVar.u(new a());
        this.f3996w0.K(e8.m.class, uVar);
        e8.l lVar = new e8.l();
        lVar.j(new t5.g() { // from class: d8.r
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w.c3(this.f3989a, view2, i10, (v5.q) obj);
            }
        });
        lVar.k(new t5.h() { // from class: d8.s
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w.b3(this.f3990a, view2, i10, (v5.q) obj);
            }
        });
        this.f3996w0.K(v5.q.class, lVar);
        e8.f fVar = new e8.f();
        fVar.o(new e8.f.b() { // from class: d8.t
            @Override // e8.f.b
            public final void a(int i10) {
                w.Y2(this.f3991a, i10);
            }
        });
        this.f3996w0.K(e8.a.class, fVar);
        e8.j jVar = new e8.j();
        jVar.o(this.f3999z0.e());
        jVar.p(new e8.j.a() { // from class: d8.u
            @Override // e8.j.a
            public final void a(int i10) {
                w.Z2(this.f3992a, i10);
            }
        });
        this.f3996w0.K(e8.g.class, jVar);
        this.f3995v0.setAdapter(this.f3996w0);
        f3();
    }

    @Override // d8.c
    public View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new b6.a(new RecyclerView(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: d8.v
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                w.a3(this.f3993a, (RecyclerView) obj);
            }
        }).l();
        this.f3995v0 = recyclerView;
        return recyclerView;
    }

    @Override // d8.c
    public void W2() {
        com.tuyafeng.support.utils.x.M(this.f3995v0);
    }

    public final List e3() {
        Bundle bundle = w0() == null ? new Bundle() : w0();
        String string = bundle.getString("url");
        String string2 = bundle.getString("title");
        int i10 = bundle.getInt("flag");
        boolean z10 = false;
        boolean z11 = (i10 & 1) != 0;
        boolean z12 = (i10 & 2) != 0;
        boolean zT = a2.f1958a.t(string);
        boolean z13 = !zT && s9.d.l(G(), string);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e8.m(string, string2, z11));
        if (!this.f3998y0 && this.f3997x0 == 3) {
            z10 = true;
        }
        if (z10) {
            arrayList.add(new e8.g(this.f3999z0.c2()));
            arrayList.add(new e8.a(this.f3999z0.a2()));
        } else {
            if (z11) {
                arrayList.add(new v5.q(1, X0(w7.u.ni)));
            }
            if (zT) {
                arrayList.add(new v5.q(2, X0(w7.u.f14121l0)));
            }
            arrayList.add(new v5.q(3, X0(z12 ? w7.u.Yc : w7.u.Xc)));
            if (la.s.j().n2().C() && !z13 && string != null && !string.isEmpty() && zT && !p9.a.a().r(string) && kd.c().f().C(string)) {
                arrayList.add(new v5.q(4, X0(w7.u.qi)));
            }
        }
        int i11 = this.f3997x0;
        if (i11 != 0) {
            arrayList.add(new v5.q(7, X0(i11 == 3 ? w7.u.f14239t6 : w7.u.Qc)));
        }
        if (z10) {
            arrayList.add(new v5.q(8, X0(w7.u.I8)));
        }
        return arrayList;
    }

    public final void g3(int i10) {
        b bVar = this.f3994u0;
        if (bVar == null) {
            return;
        }
        switch (i10) {
            case 1:
                bVar.b();
                break;
            case 2:
                bVar.d();
                break;
            case 3:
                bVar.h();
                break;
            case 4:
                bVar.c();
                break;
            case 5:
                bVar.a();
                break;
            case 6:
                bVar.e();
                break;
            case 7:
                bVar.i(this.f3997x0 != 3);
                break;
            case 8:
                this.f3998y0 = true;
                f3();
                break;
        }
    }

    public final void h3() {
        b bVar = this.f3994u0;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void i3(b bVar) {
        this.f3994u0 = bVar;
    }

    public void j3(int i10) {
        if (this.f3997x0 == i10) {
            return;
        }
        this.f3997x0 = i10;
        f3();
    }
}
