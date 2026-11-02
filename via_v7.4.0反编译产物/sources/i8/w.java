package i8;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.List;
import w5.k;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7094r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7095s0;

    /* renamed from: t0, reason: collision with root package name */
    public List f7096t0;

    /* renamed from: u0, reason: collision with root package name */
    public List f7097u0;

    public static /* synthetic */ void h3(w wVar, View view, int i10, a6.n nVar) {
        wVar.getClass();
        int iC = nVar.c();
        if (wVar.f7097u0.contains(Integer.valueOf(iC))) {
            wVar.f7097u0.remove(Integer.valueOf(iC));
        } else {
            wVar.f7097u0.add(Integer.valueOf(iC));
        }
        nVar.j(!wVar.f7097u0.contains(Integer.valueOf(iC)));
        wVar.f7095s0.m(i10);
        int[] iArr = new int[wVar.f7097u0.size()];
        for (int i11 = 0; i11 < wVar.f7097u0.size(); i11++) {
            iArr[i11] = ((Integer) wVar.f7097u0.get(i11)).intValue();
        }
        wVar.f7094r0.U1(iArr);
    }

    public static /* synthetic */ void i3(w wVar, View view, k.p pVar) {
        wVar.f7094r0.U1(null);
        wVar.j3();
    }

    private void j3() {
        this.f7096t0.clear();
        this.f7096t0.add(new a6.n(0, Z0(x7.u.Q), true));
        this.f7096t0.add(new a6.n(1, Z0(x7.u.R), true));
        this.f7096t0.add(new a6.n(2, Z0(x7.u.f14041k0), true));
        this.f7096t0.add(new a6.n(6, Z0(x7.u.f13901a0), true));
        this.f7096t0.add(new a6.n(38, Z0(x7.u.B), true));
        this.f7096t0.add(new a6.n(33, Z0(x7.u.wc), true));
        this.f7096t0.add(new a6.n(7, Z0(x7.u.Rb), true));
        this.f7096t0.add(new a6.n(8, Z0(x7.u.U), true));
        this.f7096t0.add(new a6.n(22, Z0(x7.u.S), true));
        this.f7096t0.add(new a6.n(23, Z0(x7.u.L), true));
        this.f7096t0.add(new a6.n(29, Z0(x7.u.f14176u), true));
        this.f7096t0.add(new a6.n(34, Z0(x7.u.Db), true));
        this.f7096t0.add(new a6.n(3, Z0(x7.u.f14150s), true));
        this.f7096t0.add(new a6.n(31, Z0(x7.u.f13943d0), true));
        int[] iArrD1 = this.f7094r0.D1();
        this.f7097u0.clear();
        for (a6.n nVar : this.f7096t0) {
            if (g6.a.b(iArrD1, nVar.c())) {
                this.f7097u0.add(Integer.valueOf(nVar.c()));
                nVar.j(false);
            }
        }
        this.f7095s0.l();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7097u0 = new ArrayList();
        this.f7094r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f7096t0 = new ArrayList();
        this.f7095s0 = new y5.f(this.f7096t0);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: i8.t
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                w.h3(this.f7091a, view2, i10, (a6.n) obj);
            }
        });
        this.f7095s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7095s0);
        j3();
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.Q2);
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.Y)), new View.OnClickListener() { // from class: i8.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w wVar = this.f7092a;
                w5.k.l(wVar.I()).d0(x7.u.f13996gb).I(x7.u.f14219x3).V(x7.u.Y, new k.m() { // from class: i8.v
                    @Override // w5.k.m
                    public final void a(View view2, k.p pVar) {
                        w.i3(wVar, view2, pVar);
                    }
                }).N(R.string.cancel, null).f0();
            }
        });
    }
}
