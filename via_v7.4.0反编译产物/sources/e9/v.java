package e9;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v extends k {

    /* renamed from: s0, reason: collision with root package name */
    public i9.e f4933s0;

    @Override // e9.k
    public List V2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h9.a.e(1).g(Z0(x7.u.F2)).b(g6.f.e(I(), x7.o.T0)).d(0, 100).c(this.f4933s0.c()).f("%d%%").a());
        arrayList.add(h9.a.e(2).g(Z0(x7.u.f13994g9)).b(g6.f.e(I(), x7.o.f13768u)).d(0, 100).c(this.f4933s0.a()).f("%d%%").a());
        arrayList.add(h9.a.e(4).g(Z0(x7.u.qd)).b(g6.f.e(I(), x7.o.f13779x1)).d(0, 7).c(this.f4933s0.e()).f("%dpx").a());
        arrayList.add(h9.a.e(3).g(Z0(x7.u.pd)).b(g6.f.e(I(), x7.o.f13776w1)).d(0, 100).c(this.f4933s0.d()).f("%d%%").a());
        arrayList.add(h9.a.g(5).b(g6.f.e(I(), x7.o.f13771v)).e(Z0(x7.u.Ob), Z0(x7.u.Pb)).c(Z0(x7.u.Ob), Z0(x7.u.Qb)).d(this.f4933s0.l()).a());
        return arrayList;
    }

    @Override // e9.k
    public void W2(h9.a aVar, int i10) {
        super.W2(aVar, i10);
        int iB = aVar.b();
        if (iB == 1) {
            this.f4933s0.h(((h9.b) aVar).j());
            this.f4907m0.v(this.f4933s0);
            return;
        }
        if (iB == 2) {
            this.f4933s0.f(((h9.b) aVar).j());
            this.f4907m0.v(this.f4933s0);
            return;
        }
        if (iB == 3) {
            this.f4933s0.i(((h9.b) aVar).j());
            this.f4907m0.v(this.f4933s0);
        } else if (iB == 4) {
            this.f4933s0.j(((h9.b) aVar).j());
            this.f4907m0.v(this.f4933s0);
        } else {
            if (iB != 5) {
                return;
            }
            this.f4933s0.k(((h9.d) aVar).h());
            this.f4907m0.v(this.f4933s0);
        }
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4933s0 = this.f4907m0.o();
    }
}
