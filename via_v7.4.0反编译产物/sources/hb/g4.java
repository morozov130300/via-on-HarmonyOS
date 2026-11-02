package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g4 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6558r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6559s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f6560t0 = 0;

    public static /* synthetic */ void g3(g4 g4Var, View view, int i10, a6.g gVar) {
        g4Var.getClass();
        g4Var.j3(gVar.c());
        gVar.j(!gVar.i());
        g4Var.f6559s0.m(i10);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6560t0 = this.f6558r0.G2();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(i3(0, x7.u.fd));
        arrayList.add(i3(1, x7.u.ad));
        arrayList.add(i3(2, x7.u.cd));
        arrayList.add(i3(3, x7.u.bd));
        arrayList.add(i3(4, x7.u.ed));
        arrayList.add(i3(5, x7.u.dd));
        this.f6559s0 = new y5.f(arrayList);
        a6.j jVar = new a6.j();
        jVar.j(new y5.g() { // from class: hb.f4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                g4.g3(this.f6545a, view2, i10, (a6.g) obj);
            }
        });
        this.f6559s0.K(a6.g.class, jVar);
        this.f10459q0.setAdapter(this.f6559s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.Yf));
        zVar.c(new z.b(0, 0, null, Z0(x7.u.f13949d6)), new View.OnClickListener() { // from class: hb.e4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w5.k.l(this.f6532a.I()).d0(x7.u.Yf).I(x7.u.f13923b8).V(R.string.ok, null).f0();
            }
        });
    }

    public final a6.g i3(int i10, int i11) {
        int i12 = 1 << i10;
        return new a6.g(i12, Z0(i11), (this.f6560t0 & i12) != 0);
    }

    public final void j3(int i10) {
        int i11 = this.f6560t0;
        if ((i11 & i10) == i10) {
            this.f6560t0 = (i10 ^ (-1)) & i11;
        } else {
            this.f6560t0 = i10 | i11;
        }
        this.f6558r0.a(this.f6560t0);
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).u(this);
    }
}
