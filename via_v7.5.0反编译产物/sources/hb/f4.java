package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f4 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5866u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5867v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f5868w0 = 0;

    public static /* synthetic */ void f3(f4 f4Var, View view, int i10, v5.g gVar) {
        f4Var.getClass();
        f4Var.i3(gVar.c());
        gVar.j(!gVar.i());
        f4Var.f5867v0.m(i10);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5868w0 = this.f5866u0.K2();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(h3(0, w7.u.vd));
        arrayList.add(h3(1, w7.u.qd));
        arrayList.add(h3(2, w7.u.sd));
        arrayList.add(h3(3, w7.u.rd));
        arrayList.add(h3(4, w7.u.ud));
        arrayList.add(h3(5, w7.u.td));
        this.f5867v0 = new t5.f(arrayList);
        v5.j jVar = new v5.j();
        jVar.j(new t5.g() { // from class: hb.e4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                f4.f3(this.f5853a, view2, i10, (v5.g) obj);
            }
        });
        this.f5867v0.K(v5.g.class, jVar);
        this.f7946t0.setAdapter(this.f5867v0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.og));
        e0Var.c(new com.tuyafeng.support.widget.e0.b(0, 0, null, X0(w7.u.f14183p6)), new View.OnClickListener() { // from class: hb.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q5.k.l(this.f5841a.G()).f0(w7.u.og).J(w7.u.f14157n8).X(R.string.ok, null).h0();
            }
        });
    }

    public final v5.g h3(int i10, int i11) {
        int i12 = 1 << i10;
        return new v5.g(i12, X0(i11), (this.f5868w0 & i12) != 0);
    }

    public final void i3(int i10) {
        int i11 = this.f5868w0;
        if ((i11 & i10) == i10) {
            this.f5868w0 = (i10 ^ (-1)) & i11;
        } else {
            this.f5868w0 = i10 | i11;
        }
        this.f5866u0.b(this.f5868w0);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).u(this);
    }
}
