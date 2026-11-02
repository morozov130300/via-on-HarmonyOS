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
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f378r0;

    /* renamed from: s0, reason: collision with root package name */
    public p9.o f379s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f380t0;

    /* renamed from: u0, reason: collision with root package name */
    public final Map f381u0 = new HashMap();

    public static /* synthetic */ void i3(z zVar, List list) {
        zVar.u3(zVar.q3(list));
        zVar.e3(list.isEmpty());
    }

    public static /* synthetic */ void j3(z zVar, AdapterView adapterView, View view, int i10, long j10) {
        zVar.getClass();
        g6.i.i(zVar, f1.class, f1.p3(i10 == 0 ? 1 : 2), null);
    }

    public static /* synthetic */ void l3(z zVar, String str, Bundle bundle) {
        zVar.getClass();
        if (bundle.getString("sug_result", null) != null) {
            zVar.t3();
        }
        zVar.N0().x("sug_result");
    }

    public static /* synthetic */ void m3(z zVar, String str, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            zVar.s3(null, str);
        } else {
            zVar.r3(str);
        }
    }

    public static /* synthetic */ void o3(z zVar, View view, int i10, a6.q qVar) {
        zVar.getClass();
        zVar.s3(null, (String) zVar.f381u0.get(Integer.valueOf(qVar.c())));
    }

    public static /* synthetic */ boolean p3(final z zVar, View view, int i10, a6.q qVar) {
        zVar.getClass();
        final String str = (String) zVar.f381u0.get(Integer.valueOf(qVar.c()));
        w5.k.l(zVar.I()).F(new String[]{zVar.Z0(x7.u.D), zVar.Z0(x7.u.f14215x)}, new AdapterView.OnItemClickListener() { // from class: a9.u
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                z.m3(this.f367a, str, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    private List q3(List list) {
        ArrayList arrayList = new ArrayList();
        this.f381u0.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p9.q qVar = (p9.q) it.next();
            if (qVar.g() == 1) {
                int iHashCode = qVar.d().hashCode();
                this.f381u0.put(Integer.valueOf(iHashCode), qVar.d());
                arrayList.add(new a6.q(iHashCode, qVar.e()));
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, new a6.l(Z0(x7.u.Md)));
        }
        int size = arrayList.size();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            p9.q qVar2 = (p9.q) it2.next();
            if (qVar2.g() == 2) {
                int iHashCode2 = qVar2.d().hashCode();
                this.f381u0.put(Integer.valueOf(iHashCode2), qVar2.d());
                arrayList.add(new a6.q(iHashCode2, qVar2.e()));
            }
        }
        if (arrayList.size() > size) {
            arrayList.add(size, new a6.l(Z0(x7.u.f14063l8)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f363e.f379s0.r();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.t
            @Override // a7.e
            public final void accept(Object obj) {
                z.i3(this.f366e, (List) obj);
            }
        }, new x7.g0());
    }

    private void u3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f380t0.H(), list));
        this.f380t0.M(list);
        eVarB.c(this.f380t0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f378r0 = pa.r.j();
        this.f379s0 = pa.r.e();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(this.f10459q0);
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.f380t0 = fVar;
        fVar.K(a6.l.class, new a6.m());
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: a9.q
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                z.o3(this.f339a, view2, i10, (a6.q) obj);
            }
        });
        sVar.k(new y5.h() { // from class: a9.r
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return z.p3(this.f341a, view2, i10, (a6.q) obj);
            }
        });
        this.f380t0.K(a6.q.class, sVar);
        this.f10459q0.setAdapter(this.f380t0);
        t3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.b(zVar, Z0(x7.u.P0));
        zVar.c(new z.b(1, 1, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: a9.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f337a.s3(view, null);
            }
        });
    }

    public final void r3(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f374e.f379s0.u(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.y
            @Override // a7.e
            public final void accept(Object obj) {
                this.f377e.t3();
            }
        }, new x7.g0());
    }

    public final void s3(View view, String str) {
        N0().y1("sug_result", this, new androidx.fragment.app.i0() { // from class: a9.v
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                z.l3(this.f370a, str2, bundle);
            }
        });
        if (str == null) {
            w5.k.l(I()).F(new String[]{Z0(x7.u.Md), Z0(x7.u.f14063l8)}, new AdapterView.OnItemClickListener() { // from class: a9.w
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                    z.j3(this.f372a, adapterView, view2, i10, j10);
                }
            }).h0(view);
        } else {
            g6.i.i(this, f1.class, f1.q3(str), null);
        }
    }
}
