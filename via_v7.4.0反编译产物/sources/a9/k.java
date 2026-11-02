package a9;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f320r0;

    /* renamed from: s0, reason: collision with root package name */
    public p9.o f321s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f322t0;

    /* renamed from: u0, reason: collision with root package name */
    public final Map f323u0 = new HashMap();

    /* renamed from: v0, reason: collision with root package name */
    public String f324v0 = null;

    public static /* synthetic */ void h3(k kVar, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        kVar.getClass();
        g6.i.i(kVar, r0.class, r0.G3(strArr[i10]), null);
    }

    public static /* synthetic */ void i3(k kVar, String str, Boolean bool) {
        if (str.equals(kVar.f324v0)) {
            kVar.u3(null);
        } else {
            kVar.t3();
        }
    }

    public static /* synthetic */ void j3(k kVar, String str, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            kVar.s3(str);
        } else {
            kVar.r3(str);
        }
    }

    public static /* synthetic */ boolean k3(final k kVar, View view, int i10, a6.g gVar) {
        kVar.getClass();
        if (i10 == 0) {
            return false;
        }
        final String str = (String) kVar.f323u0.get(Integer.valueOf(gVar.c()));
        w5.k.l(kVar.I()).F(new String[]{kVar.Z0(x7.u.D), kVar.Z0(x7.u.f14215x)}, new AdapterView.OnItemClickListener() { // from class: a9.f
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                k.j3(this.f296a, str, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ void m3(k kVar, String str, Bundle bundle) {
        kVar.getClass();
        if (bundle.getString(Name.MARK) != null) {
            kVar.t3();
        }
        kVar.N0().x("result");
    }

    public static /* synthetic */ void n3(k kVar, List list) {
        kVar.f324v0 = kVar.f320r0.n0();
        kVar.v3(kVar.q3(list));
    }

    public static /* synthetic */ void o3(k kVar, View view, int i10, a6.g gVar) {
        kVar.getClass();
        kVar.u3((String) kVar.f323u0.get(Integer.valueOf(gVar.c())));
    }

    private void t3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f308e.f321s0.p();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.h
            @Override // a7.e
            public final void accept(Object obj) {
                k.n3(this.f310e, (List) obj);
            }
        }, new x7.g0());
    }

    private void v3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f322t0.H(), list));
        this.f322t0.M(list);
        eVarB.c(this.f322t0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f320r0 = pa.r.j();
        this.f321s0 = pa.r.e();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(this.f10459q0);
        this.f322t0 = new y5.f(Collections.EMPTY_LIST);
        a6.j jVar = new a6.j();
        jVar.j(new y5.g() { // from class: a9.a
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k.o3(this.f281a, view2, i10, (a6.g) obj);
            }
        });
        jVar.k(new y5.h() { // from class: a9.b
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return k.k3(this.f285a, view2, i10, (a6.g) obj);
            }
        });
        this.f322t0.K(a6.g.class, jVar);
        this.f10459q0.setAdapter(this.f322t0);
        t3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.Q0);
        zVar.c(new z.b(1, 1, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: a9.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f287a.s3(null);
            }
        });
    }

    public final List q3(List list) {
        ArrayList arrayList = new ArrayList();
        this.f323u0.clear();
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            p9.l lVar = (p9.l) it.next();
            int iHashCode = lVar.d().hashCode();
            this.f323u0.put(Integer.valueOf(iHashCode), lVar.d());
            boolean zEquals = lVar.d().equals(this.f324v0);
            if (zEquals) {
                z10 = false;
            }
            arrayList.add(new a6.g(iHashCode, lVar.g(), zEquals));
        }
        arrayList.add(0, new a6.g(0, Z0(x7.u.U8), z10));
        if (z10 && this.f324v0 != null) {
            this.f324v0 = null;
        }
        return arrayList;
    }

    public final void r3(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f312e.f321s0.k(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.j
            @Override // a7.e
            public final void accept(Object obj) {
                k.i3(this.f315e, str, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public final void s3(String str) {
        N0().y1("result", this, new androidx.fragment.app.i0() { // from class: a9.d
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                k.m3(this.f290a, str2, bundle);
            }
        });
        if (str != null) {
            g6.i.i(this, r0.class, r0.G3(str), null);
            return;
        }
        final String[] strArrD = p9.s.d();
        if (strArrD.length == 0) {
            g6.i.i(this, r0.class, r0.G3(null), null);
            return;
        }
        String[] strArr = new String[strArrD.length];
        for (int i10 = 0; i10 < strArrD.length; i10++) {
            p9.l lVarC = p9.s.c(strArrD[i10]);
            strArr[i10] = lVarC == null ? Z0(x7.u.G0) : lVarC.g();
        }
        w5.k.l(I()).d0(x7.u.N).F(strArr, new AdapterView.OnItemClickListener() { // from class: a9.e
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                k.h3(this.f293a, strArrD, adapterView, view, i11, j10);
            }
        }).f0();
    }

    public final void u3(String str) {
        boolean zEquals;
        if (str == null) {
            String str2 = this.f324v0;
            zEquals = str2 == null || str2.isEmpty();
        } else {
            zEquals = str.equals(this.f324v0);
        }
        if (zEquals) {
            return;
        }
        this.f320r0.H0(str);
        t3();
    }
}
