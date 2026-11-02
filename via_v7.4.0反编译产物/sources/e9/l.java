package e9;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends k {

    /* renamed from: s0, reason: collision with root package name */
    public i9.c f4916s0;

    @Override // e9.k
    public List V2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h9.a.e(1).g(Z0(x7.u.Th)).b(g6.f.e(I(), x7.o.M1)).d(24, 80).c(this.f4916s0.d() == 0 ? 24 : this.f4916s0.d()).e(24, Z0(x7.u.f14083n0)).f("%dpx").a());
        arrayList.add(h9.a.e(2).g(Z0(x7.u.f13935c6)).b(g6.f.e(I(), x7.o.f13745m0)).d(24, 80).c(this.f4916s0.b() == 0 ? 24 : this.f4916s0.b()).e(24, Z0(x7.u.f14083n0)).f("%dpx").a());
        arrayList.add(h9.a.e(3).g(Z0(x7.u.F2)).b(g6.f.e(I(), x7.o.T0)).d(0, 100).c(this.f4916s0.c()).f("%d%%").a());
        arrayList.add(h9.a.g(4).b(g6.f.e(I(), x7.o.T)).e(Z0(x7.u.f14130q5), Z0(x7.u.f14156s5)).c(Z0(x7.u.f14130q5), Z0(x7.u.f14143r5)).d(this.f4916s0.f()).a());
        arrayList.add(h9.a.g(5).b(g6.f.e(I(), x7.o.R)).e(Z0(x7.u.f14088n5), Z0(x7.u.f14116p5)).c(Z0(x7.u.f14088n5), Z0(x7.u.f14102o5)).d(this.f4916s0.e()).a());
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    @Override // e9.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W2(h9.a aVar, int i10) {
        int iB;
        super.W2(aVar, i10);
        int iJ = 0;
        if (!(aVar instanceof h9.b)) {
            boolean zH = aVar instanceof h9.d ? ((h9.d) aVar).h() : false;
            iB = aVar.b();
            if (iB != 1) {
                this.f4916s0.l(iJ);
                this.f4907m0.t(this.f4916s0);
                return;
            }
            if (iB == 2) {
                this.f4916s0.h(iJ);
                this.f4907m0.t(this.f4916s0);
                return;
            }
            if (iB == 3) {
                this.f4916s0.k(iJ);
                this.f4907m0.t(this.f4916s0);
                return;
            } else if (iB == 4) {
                this.f4916s0.j(zH);
                w9.n.e().w(true);
                this.f4907m0.t(this.f4916s0);
                return;
            } else {
                if (iB != 5) {
                    return;
                }
                this.f4916s0.i(zH);
                w9.n.e().w(true);
                this.f4907m0.t(this.f4916s0);
                return;
            }
        }
        h9.b bVar = (h9.b) aVar;
        iJ = bVar.j() == bVar.k() ? 0 : bVar.j();
        iB = aVar.b();
        if (iB != 1) {
        }
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4916s0 = this.f4907m0.m();
    }
}
