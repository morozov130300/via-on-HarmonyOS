package hb;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b6 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6482r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6483s0;

    /* renamed from: t0, reason: collision with root package name */
    public String f6484t0;

    public static /* synthetic */ void g3(b6 b6Var, View view, k.p pVar) {
        b6Var.getClass();
        int[] iArr = pVar.f13337a;
        int i10 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i11 = 0;
            while (i10 < length) {
                i11 += 1 << iArr[i10];
                i10++;
            }
            i10 = i11;
        }
        b6Var.f6482r0.f(i10);
        w9.n.e().w(true);
        b6Var.o3(b6Var.k3());
    }

    public static /* synthetic */ void i3(b6 b6Var, String str) {
        b6Var.f6484t0 = str;
        b6Var.o3(b6Var.k3());
    }

    private List k3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.Kb), this.f6484t0));
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = {Z0(x7.u.E), Z0(x7.u.f14026j), Z0(x7.u.cg), Z0(x7.u.H), Z0(x7.u.Kb), Z0(x7.u.Ub)};
        int iX1 = this.f6482r0.X1();
        for (int i10 = 0; i10 < 6; i10++) {
            if (((1 << i10) & iX1) != 0) {
                if (sb2.length() > 0) {
                    sb2.append('/');
                }
                sb2.append(strArr[i10]);
            }
        }
        arrayList.add(new a6.q(2, Z0(x7.u.hg), sb2.length() > 0 ? sb2.toString() : null));
        arrayList.add(new a6.q(3, Z0(x7.u.f13969ec), Z0(this.f6482r0.v().r() ? x7.u.A4 : x7.u.E3)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(a6.q qVar) {
        int iC = qVar.c();
        if (iC == 1) {
            g6.i.g(this, w5.class);
        } else if (iC == 2) {
            n3();
        } else {
            if (iC != 3) {
                return;
            }
            g6.i.g(this, i6.class);
        }
    }

    private void n3() {
        String[] strArr = {Z0(x7.u.E), Z0(x7.u.f14026j), Z0(x7.u.cg), Z0(x7.u.H), Z0(x7.u.Kb), Z0(x7.u.Ub)};
        int iX1 = this.f6482r0.X1();
        int[] iArr = new int[10];
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            if (((1 << i11) & iX1) != 0) {
                iArr[i10] = i11;
                i10++;
            }
        }
        w5.k.l(I()).e0(Z0(x7.u.hg)).J(Z0(x7.u.f14035j8)).L(strArr, Arrays.copyOf(iArr, i10)).V(R.string.ok, new k.m() { // from class: hb.a6
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b6.g3(this.f6467a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private void o3(List list) {
        y5.f fVar = this.f6483s0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(fVar.H(), list));
        this.f6483s0.M(list);
        eVarB.c(this.f6483s0);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            return;
        }
        l3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6482r0 = pa.r.j();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6483s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.x5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6829a.m3((a6.q) obj);
            }
        });
        this.f6483s0.K(a6.q.class, sVar);
        this.f10459q0.setAdapter(this.f6483s0);
        l3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.Zb));
    }

    public final void l3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.y5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                b6 b6Var = this.f6844e;
                return z8.v2.d(b6Var.I(), b6Var.f6482r0.M1());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.z5
            @Override // a7.e
            public final void accept(Object obj) {
                b6.i3(this.f6865e, (String) obj);
            }
        }, new x7.g0());
    }
}
