package c9;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g9.c f2333u0;

    public static List Z2(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_section", w7.p.f13904r0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b9.q.class, bundle, w7.u.Kc, w7.u.F);
        hVar.c("custom.favorite.1", 1, w7.u.yi, new String[0]);
        hVar.c("custom.favorite.2", 2, w7.u.f14169o6, new String[0]);
        hVar.c("custom.favorite.3", 3, w7.u.R2, new String[0]);
        hVar.c("custom.favorite.4", 4, w7.u.B5, new String[0]);
        hVar.c("custom.favorite.5", 5, w7.u.f14304y5, new String[0]);
        return hVar.f();
    }

    @Override // c9.j
    public List T2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f9.a.e(1).g(X0(w7.u.yi)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.J1)).d(24, 80).c(this.f2333u0.d() == 0 ? 24 : this.f2333u0.d()).e(24, X0(w7.u.f14177p0)).f("%dpx").a());
        arrayList.add(f9.a.e(2).g(X0(w7.u.f14169o6)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13814n0)).d(24, 80).c(this.f2333u0.b() == 0 ? 24 : this.f2333u0.b()).e(24, X0(w7.u.f14177p0)).f("%dpx").a());
        arrayList.add(f9.a.e(3).g(X0(w7.u.R2)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.R0)).d(0, 100).c(this.f2333u0.c()).f("%d%%").a());
        arrayList.add(f9.a.g(4).b(com.tuyafeng.support.utils.f.e(G(), w7.o.S)).e(X0(w7.u.B5), X0(w7.u.D5)).c(X0(w7.u.B5), X0(w7.u.C5)).d(this.f2333u0.f()).a());
        arrayList.add(f9.a.g(5).b(com.tuyafeng.support.utils.f.e(G(), w7.o.Q)).e(X0(w7.u.f14304y5), X0(w7.u.A5)).c(X0(w7.u.f14304y5), X0(w7.u.f14317z5)).d(this.f2333u0.e()).a());
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x003c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    @Override // c9.j
    public void U2(f9.a aVar, int i10) {
        boolean zH;
        int iB;
        super.U2(aVar, i10);
        int iJ = 0;
        if (!(aVar instanceof f9.b)) {
            zH = aVar instanceof f9.d ? ((f9.d) aVar).h() : false;
            iB = aVar.b();
            if (iB != 1) {
                this.f2333u0.l(iJ);
                this.f2324o0.t(this.f2333u0);
                return;
            }
            if (iB != 2) {
                this.f2333u0.h(iJ);
                this.f2324o0.t(this.f2333u0);
                return;
            }
            if (iB != 3) {
                this.f2333u0.k(iJ);
                this.f2324o0.t(this.f2333u0);
            } else if (iB != 4) {
                this.f2333u0.j(zH);
                u9.n.e().u(true);
                this.f2324o0.t(this.f2333u0);
            } else {
                if (iB != 5) {
                    return;
                }
                this.f2333u0.i(zH);
                u9.n.e().u(true);
                this.f2324o0.t(this.f2333u0);
            }
        }
        f9.b bVar = (f9.b) aVar;
        iJ = bVar.j() == bVar.k() ? 0 : bVar.j();
        iB = aVar.b();
        if (iB != 1) {
            this.f2333u0.l(iJ);
            this.f2324o0.t(this.f2333u0);
            return;
        }
        if (iB != 2) {
            this.f2333u0.h(iJ);
            this.f2324o0.t(this.f2333u0);
            return;
        }
        if (iB != 3) {
            this.f2333u0.k(iJ);
            this.f2324o0.t(this.f2333u0);
        } else if (iB != 4) {
            this.f2333u0.j(zH);
            u9.n.e().u(true);
            this.f2324o0.t(this.f2333u0);
        } else {
            if (iB != 5) {
                return;
            }
            this.f2333u0.i(zH);
            u9.n.e().u(true);
            this.f2324o0.t(this.f2333u0);
        }
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2333u0 = this.f2324o0.m();
    }
}
