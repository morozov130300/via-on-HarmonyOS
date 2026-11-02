package hb;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o6 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6694r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6695s0;

    /* renamed from: t0, reason: collision with root package name */
    public long f6696t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public int f6697u0 = 0;

    public static /* synthetic */ void h3(o6 o6Var, View view) {
        o6Var.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - o6Var.f6696t0 < 500) {
            o6Var.f6697u0++;
        } else {
            o6Var.f6697u0 = 1;
        }
        o6Var.f6696t0 = jElapsedRealtime;
        if (o6Var.f6697u0 == 5) {
            w9.d dVarS = o6Var.f6694r0.s();
            dVarS.i(true ^ dVarS.f());
            o6Var.f6694r0.u(dVarS);
            o6Var.f6697u0 = 0;
            o6Var.k3(o6Var.i3());
        }
    }

    private List i3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.rc)));
        arrayList.add(new a6.q(8, Z0(x7.u.vc)));
        arrayList.add(new a6.q(2, Z0(x7.u.tc)));
        arrayList.add(new a6.q(3, Z0(x7.u.f14123pc)));
        arrayList.add(new a6.q(9, Z0(x7.u.uc)));
        if (this.f6694r0.s().f()) {
            arrayList.add(new a6.q(12, Z0(x7.u.R4)));
        }
        arrayList.add(new a6.q(5, Z0(x7.u.f14109oc)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(a6.q qVar) {
        int iC = qVar.c();
        if (iC == 1) {
            g6.i.g(this, c4.class);
            return;
        }
        if (iC == 2) {
            g6.i.g(this, y4.class);
            return;
        }
        if (iC == 3) {
            g6.i.g(this, z.class);
            return;
        }
        if (iC == 5) {
            g6.i.g(this, d.class);
            return;
        }
        if (iC == 8) {
            g6.i.g(this, d9.q.class);
            return;
        }
        if (iC == 9) {
            g6.i.g(this, sa.d1.class);
            return;
        }
        if (iC == 10) {
            g6.i.g(this, jb.y4.class);
        } else if (iC == 11) {
            g6.i.g(this, h5.class);
        } else if (iC == 12) {
            g6.i.g(this, y1.class);
        }
    }

    private void k3(List list) {
        y5.f fVar = this.f6695s0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(fVar.H(), list));
        this.f6695s0.M(list);
        eVarB.c(this.f6695s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6694r0 = pa.r.j();
        this.f6695s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.m6
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6660a.j3((a6.q) obj);
            }
        });
        this.f6695s0.K(a6.q.class, sVar);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setAdapter(this.f6695s0);
        k3(i3());
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.f14095nc);
        View viewFindViewById = zVar.findViewById(com.tuyafeng.support.widget.z.f4412m);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: hb.n6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o6.h3(this.f6678a, view);
                }
            });
        }
    }
}
