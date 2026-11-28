package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l6 extends m8.f {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f5953y0 = "hb.l6";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f5954u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5955v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f5956w0 = false;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f5957x0 = -1;

    public static /* synthetic */ void g3(l6 l6Var, View view, int i10, v5.g gVar) {
        l6Var.l3(i10);
        if (l6Var.f5956w0) {
            l6Var.k3();
        }
    }

    private void h3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.g(0, X0(w7.u.S9), false));
        arrayList.add(new v5.l(X0(w7.u.de)));
        int[] iArr = {5, 10, 11, 12, 13, 9, 16, 27};
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = iArr[i10];
            arrayList.add(new v5.g(i11, w4.b(G(), i11), false));
        }
        arrayList.add(new v5.l(X0(w7.u.E5)));
        int[] iArr2 = {7, 30, 8, 23, 28, 26, 14, 15, 24, 25, 29};
        for (int i12 = 0; i12 < 11; i12++) {
            int i13 = iArr2[i12];
            arrayList.add(new v5.g(i13, w4.b(G(), i13), false));
        }
        arrayList.add(new v5.l(X0(w7.u.E0)));
        int i14 = new int[]{4}[0];
        arrayList.add(new v5.g(i14, w4.b(G(), i14), false));
        arrayList.add(new v5.l(X0(w7.u.vi)));
        int[] iArr3 = {19, 1, 20, 6, 18, 17, 2, 3};
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = iArr3[i15];
            arrayList.add(new v5.g(i16, w4.b(G(), i16), false));
        }
        this.f5955v0.M(arrayList);
        this.f5955v0.l();
        int i17 = w0() == null ? 0 : w0().getInt(Name.MARK, 0);
        this.f5956w0 = w0() != null && w0().getBoolean("disposable", false);
        int i18 = 0;
        while (true) {
            if (i18 >= arrayList.size()) {
                i18 = 0;
                break;
            }
            Object obj = arrayList.get(i18);
            if ((obj instanceof v5.g) && ((v5.g) obj).c() == i17) {
                break;
            } else {
                i18++;
            }
        }
        l3(i18);
        this.f7946t0.p1(i18);
        if (this.f5956w0) {
            return;
        }
        this.f5954u0.c(new com.tuyafeng.support.widget.e0.b(0, 0, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: hb.k6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5940a.k3();
            }
        });
    }

    public static Bundle i3(int i10, boolean z10) {
        Bundle bundle = new Bundle();
        if (i10 >= 0) {
            bundle.putInt(Name.MARK, i10);
        }
        if (z10) {
            bundle.putBoolean("disposable", true);
        }
        return bundle;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f5955v0 = new t5.f(Collections.EMPTY_LIST);
        v5.j jVar = new v5.j();
        jVar.j(new t5.g() { // from class: hb.j6
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                l6.g3(this.f5924a, view2, i10, (v5.g) obj);
            }
        });
        this.f5955v0.K(v5.g.class, jVar);
        this.f5955v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f5955v0);
        h3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14245tc));
        this.f5954u0 = e0Var;
    }

    public final boolean j3() {
        int i10 = this.f5957x0;
        if (i10 < 0 || i10 >= this.f5955v0.g()) {
            return false;
        }
        Object obj = this.f5955v0.H().get(this.f5957x0);
        if (!(obj instanceof v5.g)) {
            return false;
        }
        L0().y1(f5953y0, p5.a.b().d(Name.MARK, ((v5.g) obj).c()).a());
        return true;
    }

    public final void k3() {
        if (j3()) {
            i0().onBackPressed();
        }
    }

    public final void l3(int i10) {
        if (this.f5957x0 == i10 || i10 < 0 || i10 >= this.f5955v0.g()) {
            return;
        }
        int i11 = this.f5957x0;
        this.f5957x0 = i10;
        if (i11 >= 0) {
            Object obj = this.f5955v0.H().get(i11);
            if (obj instanceof v5.g) {
                ((v5.g) obj).j(false);
                this.f5955v0.m(i11);
            }
        }
        Object obj2 = this.f5955v0.H().get(i10);
        if (obj2 instanceof v5.g) {
            ((v5.g) obj2).j(true);
            this.f5955v0.m(i10);
        }
    }
}
