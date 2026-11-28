package na;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.e0;
import java.util.ArrayList;
import w7.p;
import w7.r;
import w7.u;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends m8.f {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            return w5.c.e(r.B).a(viewGroup);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, b bVar, int i10) {
            gVar.X(p.I, bVar.f10821a);
            gVar.X(p.H, i.this.X0(bVar.f10822b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10822b;

        public b(String str, int i10) {
            this.f10821a = str;
            this.f10822b = i10;
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("Ctrl + t", u.P));
        arrayList.add(new b("Ctrl + Tab", u.R9));
        arrayList.add(new b("Ctrl + Shift + Tab", u.Q9));
        arrayList.add(new b("Alt + ←", u.M9));
        arrayList.add(new b("Alt + →", u.N9));
        arrayList.add(new b("Ctrl + w", u.L9));
        arrayList.add(new b("Alt + f", u.D3));
        arrayList.add(new b("Ctrl + Shift + b", u.f14092j));
        arrayList.add(new b("Ctrl + h", u.I));
        arrayList.add(new b("Ctrl + f", u.G));
        arrayList.add(new b("Ctrl + l", u.P9));
        arrayList.add(new b("F5 / Ctrl + r", u.Y9));
        arrayList.add(new b("Ctrl + u", u.f14051g0));
        arrayList.add(new b("Ctrl + d", u.f13994c));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        t5.f fVar = new t5.f(arrayList);
        fVar.K(b.class, new a());
        this.f7946t0.setAdapter(fVar);
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, u.G7);
    }
}
