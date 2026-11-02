package va;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w5.k;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public v9.g f13110r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f13111s0;

    public static /* synthetic */ void h3(f fVar, View view, k.p pVar) {
        fVar.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String strL3 = fVar.l3(pVar.f13339c[0]);
        if (strL3.isEmpty()) {
            return;
        }
        fVar.n3(strL3, false);
        fVar.m3();
    }

    public static /* synthetic */ void i3(f fVar, String str, View view, k.p pVar) {
        fVar.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String strL3 = fVar.l3(pVar.f13339c[0]);
        if (strL3.isEmpty() || strL3.equals(str)) {
            return;
        }
        fVar.n3(str, true);
        fVar.n3(strL3, false);
        fVar.m3();
    }

    public static /* synthetic */ void j3(f fVar, View view, int i10, a6.q qVar) {
        fVar.getClass();
        fVar.p3(qVar.a());
    }

    public static /* synthetic */ void k3(f fVar, String str, View view) {
        fVar.n3(str, true);
        fVar.m3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f13110r0 = pa.r.i();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f13111s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: va.b
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                f.j3(this.f13092a, view2, i10, (a6.q) obj);
            }
        });
        this.f13111s0.K(a6.q.class, sVar);
        this.f10459q0.setAdapter(this.f13111s0);
        m3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.Oc);
        zVar.c(new z.b(0, 0, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: va.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13089a.o3();
            }
        });
    }

    public final String l3(String str) {
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.contains("://")) {
            strTrim = i6.i0.f7006a.e(strTrim);
        }
        return ba.c.f(strTrim);
    }

    public final void m3() {
        List<String> listL = this.f13110r0.l();
        Collections.sort(listL, new k8.p());
        ArrayList arrayList = new ArrayList(listL.size());
        for (String str : listL) {
            arrayList.add(new a6.q(str.hashCode(), str));
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f13111s0.H(), arrayList));
        this.f13111s0.M(arrayList);
        eVarB.c(this.f13111s0);
        e3(listL.isEmpty());
    }

    public final void n3(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f13110r0.c("https://" + str, z10);
    }

    public final void o3() {
        w5.k.l(I()).d0(x7.u.N).u(false).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: va.e
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                f.h3(this.f13108a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void p3(final String str) {
        w5.k.l(I()).d0(x7.u.D).u(false).i(str, "www.example.com", 1).V(R.string.ok, new k.m() { // from class: va.c
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                f.i3(this.f13095a, str, view, pVar);
            }
        }).N(R.string.cancel, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: va.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.k3(this.f13105a, str, view);
            }
        }).f0();
    }
}
