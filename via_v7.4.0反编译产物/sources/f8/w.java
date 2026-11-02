package f8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import c8.lc;
import g8.f;
import g8.j;
import g8.u;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w extends c {

    /* renamed from: s0, reason: collision with root package name */
    public b f6030s0;

    /* renamed from: t0, reason: collision with root package name */
    public RecyclerView f6031t0;

    /* renamed from: u0, reason: collision with root package name */
    public y5.f f6032u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f6033v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f6034w0;

    /* renamed from: x0, reason: collision with root package name */
    public w9.l f6035x0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements u.b {
        public a() {
        }

        @Override // g8.u.b
        public void a() {
            w.this.i3(5);
        }

        @Override // g8.u.b
        public void b() {
            w.this.i3(6);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    public static /* synthetic */ void a3(w wVar, int i10) {
        wVar.f6035x0.W2(i10);
        wVar.j3();
    }

    public static /* synthetic */ void b3(w wVar, int i10) {
        wVar.f6035x0.p1(i10);
        wVar.j3();
    }

    public static /* synthetic */ void c3(w wVar, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(wVar.I()));
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(recyclerView);
    }

    public static /* synthetic */ boolean d3(w wVar, View view, int i10, a6.q qVar) {
        wVar.getClass();
        if (8 != qVar.c()) {
            return false;
        }
        b bVar = wVar.f6030s0;
        if (bVar == null) {
            return true;
        }
        bVar.f();
        return true;
    }

    public static /* synthetic */ void e3(w wVar, View view, int i10, a6.q qVar) {
        wVar.getClass();
        wVar.i3(qVar.c());
    }

    private List g3() {
        Bundle bundle = y0() == null ? new Bundle() : y0();
        String string = bundle.getString("url");
        String string2 = bundle.getString("title");
        int i10 = bundle.getInt("flag");
        boolean z10 = false;
        boolean z11 = (i10 & 1) != 0;
        boolean z12 = (i10 & 2) != 0;
        boolean zS = i6.i0.f7006a.s(string);
        boolean z13 = !zS && u9.d.m(I(), string);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g8.m(string, string2, z11));
        if (!this.f6034w0 && this.f6033v0 == 3) {
            z10 = true;
        }
        if (z10) {
            arrayList.add(new g8.g(this.f6035x0.b2()));
            arrayList.add(new g8.a(this.f6035x0.Z1()));
        } else {
            if (z11) {
                arrayList.add(new a6.q(1, Z0(x7.u.Ih)));
            }
            if (zS) {
                arrayList.add(new a6.q(2, Z0(x7.u.f14027j0)));
            }
            arrayList.add(new a6.q(3, Z0(z12 ? x7.u.Jc : x7.u.Ic)));
            if (pa.r.j().m2().D() && !z13 && string != null && !string.isEmpty() && zS && !r9.g.a().e(string) && lc.c().d().C(string)) {
                arrayList.add(new a6.q(4, Z0(x7.u.Lh)));
            }
        }
        int i11 = this.f6033v0;
        if (i11 != 0) {
            arrayList.add(new a6.q(7, Z0(i11 == 3 ? x7.u.f14005h6 : x7.u.Bc)));
        }
        if (z10) {
            arrayList.add(new a6.q(8, Z0(x7.u.f14211w8)));
        }
        return arrayList;
    }

    private void h3() {
        if (i1()) {
            m3(g3());
        }
    }

    private void m3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new g8.n(this.f6032u0.H(), list));
        this.f6032u0.M(list);
        eVarB.c(this.f6032u0);
    }

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.Lc);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6035x0 = pa.r.j();
        this.f6032u0 = new y5.f(Collections.EMPTY_LIST);
        g8.u uVar = new g8.u();
        uVar.u(new a());
        this.f6032u0.K(g8.m.class, uVar);
        g8.l lVar = new g8.l();
        lVar.j(new y5.g() { // from class: f8.r
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                w.e3(this.f6020a, view2, i10, (a6.q) obj);
            }
        });
        lVar.k(new y5.h() { // from class: f8.s
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w.d3(this.f6022a, view2, i10, (a6.q) obj);
            }
        });
        this.f6032u0.K(a6.q.class, lVar);
        g8.f fVar = new g8.f();
        fVar.o(new f.b() { // from class: f8.t
            @Override // g8.f.b
            public final void a(int i10) {
                w.a3(this.f6024a, i10);
            }
        });
        this.f6032u0.K(g8.a.class, fVar);
        g8.j jVar = new g8.j();
        jVar.o(this.f6035x0.d());
        jVar.p(new j.a() { // from class: f8.u
            @Override // g8.j.a
            public final void a(int i10) {
                w.b3(this.f6027a, i10);
            }
        });
        this.f6032u0.K(g8.g.class, jVar);
        this.f6031t0.setAdapter(this.f6032u0);
        h3();
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new h6.a(new RecyclerView(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: f8.v
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                w.c3(this.f6029a, (RecyclerView) obj);
            }
        }).l();
        this.f6031t0 = recyclerView;
        return recyclerView;
    }

    @Override // f8.c
    public void Y2() {
        g6.y.L(this.f6031t0);
    }

    public final void i3(int i10) {
        b bVar = this.f6030s0;
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
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
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
                bVar.i(this.f6033v0 != 3);
                break;
            case 8:
                this.f6034w0 = true;
                h3();
                break;
        }
    }

    public final void j3() {
        b bVar = this.f6030s0;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void k3(b bVar) {
        this.f6030s0 = bVar;
    }

    public void l3(int i10) {
        if (this.f6033v0 == i10) {
            return;
        }
        this.f6033v0 = i10;
        h3();
    }
}
