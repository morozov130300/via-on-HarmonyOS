package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import mark.via.data.preference.VideoGesture;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c8 extends m8.f {
    public static /* synthetic */ void f3(u9.l lVar, List list, t5.f fVar, View view, int i10, v5.n nVar) {
        boolean zI = nVar.i();
        boolean z10 = !zI;
        nVar.j(z10);
        if (nVar.c() != 0) {
            int iJ0 = lVar.j0();
            lVar.E2(!zI ? iJ0 & (nVar.c() ^ (-1)) : iJ0 | nVar.c());
            fVar.m(i10);
            return;
        }
        lVar.N(z10);
        for (Object obj : list) {
            if ((obj instanceof v5.n) && obj != nVar) {
                ((v5.n) obj).g(zI);
            }
        }
        fVar.q(0, list.size());
    }

    public static List g3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, c8.class, w7.u.Fc, w7.u.Gc, w7.u.ki);
        hVar.b(0, w7.u.L4, new String[0]);
        for (VideoGesture videoGesture : VideoGesture.values()) {
            hVar.b(videoGesture.flag, videoGesture.label, new String[0]);
        }
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        final u9.l lVarJ = la.s.j();
        boolean zG1 = lVarJ.G1();
        int iJ0 = lVarJ.j0();
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(0, X0(w7.u.L4), X0(w7.u.M4), zG1));
        arrayList.add(new v5.l(X0(w7.u.f14043f6)));
        for (VideoGesture videoGesture : VideoGesture.values()) {
            arrayList.add(new v5.n(videoGesture.flag, X0(videoGesture.label), (String) null, (videoGesture.flag & iJ0) == 0, !zG1));
        }
        final t5.f fVar = new t5.f(arrayList);
        fVar.K(v5.l.class, new v5.m());
        fVar.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.b8
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                c8.f3(lVarJ, arrayList, fVar, view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(fVar);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.ki);
    }
}
