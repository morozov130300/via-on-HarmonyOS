package c9;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g9.e f2350u0;

    public static List Z2(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_section", w7.p.f13910t0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b9.q.class, bundle, w7.u.Kc, w7.u.id);
        hVar.c("custom.searchbar.1", 1, w7.u.R2, new String[0]);
        hVar.c("custom.searchbar.2", 2, w7.u.f14214r9, new String[0]);
        hVar.c("custom.searchbar.4", 4, w7.u.Gd, new String[0]);
        hVar.c("custom.searchbar.3", 3, w7.u.Fd, new String[0]);
        hVar.c("custom.searchbar.5", 5, w7.u.f13993bc, new String[0]);
        return hVar.f();
    }

    @Override // c9.j
    public List T2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f9.a.e(1).g(X0(w7.u.R2)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.R0)).d(0, 100).c(this.f2350u0.c()).f("%d%%").a());
        arrayList.add(f9.a.e(2).g(X0(w7.u.f14214r9)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13831t)).d(0, 100).c(this.f2350u0.a()).f("%d%%").a());
        arrayList.add(f9.a.e(4).g(X0(w7.u.Gd)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13839v1)).d(0, 7).c(this.f2350u0.e()).f("%dpx").a());
        arrayList.add(f9.a.e(3).g(X0(w7.u.Fd)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13836u1)).d(0, 100).c(this.f2350u0.d()).f("%d%%").a());
        arrayList.add(f9.a.g(5).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13834u)).e(X0(w7.u.f13993bc), X0(w7.u.f14007cc)).c(X0(w7.u.f13993bc), X0(w7.u.f14021dc)).d(this.f2350u0.l()).a());
        return arrayList;
    }

    @Override // c9.j
    public void U2(f9.a aVar, int i10) {
        super.U2(aVar, i10);
        int iB = aVar.b();
        if (iB == 1) {
            this.f2350u0.h(((f9.b) aVar).j());
            this.f2324o0.v(this.f2350u0);
            return;
        }
        if (iB == 2) {
            this.f2350u0.f(((f9.b) aVar).j());
            this.f2324o0.v(this.f2350u0);
            return;
        }
        if (iB == 3) {
            this.f2350u0.i(((f9.b) aVar).j());
            this.f2324o0.v(this.f2350u0);
        } else if (iB == 4) {
            this.f2350u0.j(((f9.b) aVar).j());
            this.f2324o0.v(this.f2350u0);
        } else {
            if (iB != 5) {
                return;
            }
            this.f2350u0.k(((f9.d) aVar).h());
            this.f2324o0.v(this.f2350u0);
        }
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2350u0 = this.f2324o0.o();
    }
}
