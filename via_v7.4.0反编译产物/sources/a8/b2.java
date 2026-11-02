package a8;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b2 extends o8.g {

    /* renamed from: u0, reason: collision with root package name */
    public static final String f148u0 = "a8.b2";

    /* renamed from: r0, reason: collision with root package name */
    public d2 f149r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f150s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f151t0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            b2.this.n3();
        }
    }

    public static /* synthetic */ void g3(b2 b2Var, List list) {
        b2Var.getClass();
        ArrayList arrayList = new ArrayList(list);
        if (b2Var.f151t0) {
            arrayList.add(new l(lb.b.a(b2Var.I(), x7.o.f13724f0, x7.u.fe), b2Var.Z0(x7.u.G8)));
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new b(b2Var.f150s0.H(), arrayList));
        b2Var.f150s0.M(arrayList);
        eVarB.c(b2Var.f150s0);
    }

    public static /* synthetic */ void h3(b2 b2Var, String str, Bundle bundle) {
        b2Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            b2Var.f149r0.o(string);
        }
        b2Var.N0().x(d0.f155w0);
    }

    public static /* synthetic */ void i3(b2 b2Var, View view, int i10, a8.a aVar) {
        b2Var.getClass();
        if (aVar == null || aVar.c()) {
            return;
        }
        int size = b2Var.f150s0.H().size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            Object obj = b2Var.f150s0.H().get(i11);
            if (i11 != i10 && (obj instanceof a8.a)) {
                a8.a aVar2 = (a8.a) obj;
                if (aVar2.c()) {
                    aVar2.d(false);
                    b2Var.f150s0.m(i11);
                    break;
                }
            }
            i11++;
        }
        aVar.d(!aVar.c());
        b2Var.f150s0.m(i10);
        b2Var.f149r0.p(aVar.a().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        N0().y1(d0.f155w0, this, new androidx.fragment.app.i0() { // from class: a8.a2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                b2.h3(this.f144a, str, bundle);
            }
        });
        g6.i.h(this, d0.class, d0.s3(null, this.f149r0.n(), true));
    }

    public static Bundle m3(String str, boolean z10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("selected_id", str);
        }
        if (z10) {
            bundle.putBoolean("creation_enabled", true);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        N0().x1(f148u0, v5.a.b().e("result_id", this.f149r0.n()).a());
        l0().onBackPressed();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f150s0 = new y5.f(Collections.EMPTY_LIST);
        f fVar = new f();
        fVar.j(new y5.g() { // from class: a8.x1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                b2.i3(this.f275a, view2, i10, (a) obj);
            }
        });
        this.f150s0.K(a8.a.class, fVar);
        n nVar = new n(true);
        nVar.j(new y5.g() { // from class: a8.y1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f277a.l3();
            }
        });
        this.f150s0.K(l.class, nVar);
        this.f10459q0.setAdapter(this.f150s0);
        this.f149r0.m().g(d1(), new androidx.lifecycle.m() { // from class: a8.z1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                b2.g3(this.f280a, (List) obj);
            }
        });
        this.f151t0 = y0() != null && y0().getBoolean("creation_enabled", false);
        this.f149r0.o(y0() == null ? null : y0().getString("selected_id"));
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.b(zVar, Z0(x7.u.f14011hc));
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.K3)), new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f149r0 = (d2) new androidx.lifecycle.y(this, pa.r.n()).a(d2.class);
    }
}
