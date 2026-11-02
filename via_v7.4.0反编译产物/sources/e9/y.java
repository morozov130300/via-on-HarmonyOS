package e9;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.i0;
import hb.i1;
import java.util.ArrayList;
import java.util.List;
import w5.k;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends k {

    /* renamed from: s0, reason: collision with root package name */
    public i9.b f4937s0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements k.m {
        public a() {
        }

        @Override // w5.k.m
        public void a(View view, k.p pVar) {
            y.this.f4907m0.q();
        }
    }

    public static /* synthetic */ void b3(y yVar, View view, k.p pVar) {
        if (w3.d(w3.m(yVar.I()))) {
            g6.n.q(yVar.I(), x7.u.S2);
            yVar.f4907m0.j();
            yVar.f4907m0.p();
        }
    }

    public static /* synthetic */ void c3(y yVar, FragmentManager fragmentManager, String str, Bundle bundle) {
        yVar.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            yVar.f4908n0.a2(string);
            w9.n.e().v(true);
            yVar.f4907m0.p();
        }
        fragmentManager.x("edit_text_result");
    }

    @Override // e9.k
    public List V2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h9.a.g(3).e(Z0(x7.u.Lb), Z0(x7.u.Mb)).c(Z0(x7.u.Lb), Z0(x7.u.Nb)).b(g6.f.e(I(), x7.o.f13771v)).d(this.f4937s0.c()).a());
        arrayList.add(h9.a.g(1).e(Z0(x7.u.Wb), Z0(x7.u.Xb)).c(Z0(x7.u.Wb), Z0(x7.u.Yb)).b(g6.f.e(I(), x7.o.S)).d(this.f4937s0.d()).a());
        arrayList.add(h9.a.f(0).d(Z0(x7.u.K2)).c("").b(g6.f.e(I(), x7.o.f13747n)).a());
        arrayList.add(h9.a.f(2).d(Z0(x7.u.f14074m5)).c("").b(g6.f.e(I(), x7.o.D)).a());
        arrayList.add(h9.a.f(4).d(Z0(x7.u.P2)).c("").b(g6.f.e(I(), x7.o.X0)).a());
        return arrayList;
    }

    @Override // e9.k
    public void W2(h9.a aVar, int i10) {
        super.W2(aVar, i10);
        int iB = aVar.b();
        if (iB == 0) {
            d3();
            return;
        }
        if (iB == 1) {
            this.f4937s0.g(((h9.d) aVar).h());
            this.f4907m0.s(this.f4937s0);
        } else {
            if (iB == 2) {
                g6.n.e(I(), x7.u.f13959e2, x7.u.f13973f2, new k.m() { // from class: e9.w
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        y.b3(this.f4934a, view, pVar);
                    }
                });
                return;
            }
            if (iB == 3) {
                this.f4937s0.e(((h9.d) aVar).h());
                this.f4907m0.s(this.f4937s0);
            } else {
                if (iB != 4) {
                    return;
                }
                g6.n.e(I(), x7.u.f13996gb, x7.u.f14219x3, new a());
            }
        }
    }

    public final void d3() {
        final FragmentManager fragmentManagerN0 = M0() == null ? N0() : M0().N0();
        fragmentManagerN0.y1("edit_text_result", this, new i0() { // from class: e9.x
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                y.c3(this.f4935a, fragmentManagerN0, str, bundle);
            }
        });
        g6.i.h(M0(), i1.class, i1.g3(Z0(x7.u.K2), this.f4908n0.d0(), Z0(x7.u.K2), true));
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4937s0 = this.f4907m0.l();
    }
}
