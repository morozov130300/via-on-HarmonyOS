package z7;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b2 extends m8.f {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f15220x0 = "z7.b2";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public d2 f15221u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f15222v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f15223w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            b2.this.m3();
        }
    }

    public static /* synthetic */ void f3(b2 b2Var, List list) {
        b2Var.getClass();
        ArrayList arrayList = new ArrayList(list);
        if (b2Var.f15223w0) {
            arrayList.add(new l(lb.g.a(b2Var.G(), w7.o.f13787e0, w7.u.ue), b2Var.X0(w7.u.S8)));
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new b(b2Var.f15222v0.H(), arrayList));
        b2Var.f15222v0.M(arrayList);
        eVarB.c(b2Var.f15222v0);
    }

    public static /* synthetic */ void g3(b2 b2Var, String str, Bundle bundle) {
        b2Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            b2Var.f15221u0.o(string);
        }
        b2Var.L0().x(d0.f15227z0);
    }

    public static /* synthetic */ void h3(b2 b2Var, View view, int i10, z7.a aVar) {
        b2Var.getClass();
        if (aVar == null || aVar.c()) {
            return;
        }
        int size = b2Var.f15222v0.H().size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = b2Var.f15222v0.H().get(i11);
            if (i11 != i10 && (obj instanceof z7.a)) {
                z7.a aVar2 = (z7.a) obj;
                if (aVar2.c()) {
                    aVar2.d(false);
                    b2Var.f15222v0.m(i11);
                    break;
                }
            }
        }
        aVar.d(!aVar.c());
        b2Var.f15222v0.m(i10);
        b2Var.f15221u0.p(aVar.a().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3() {
        L0().z1(d0.f15227z0, this, new androidx.fragment.app.i0() { // from class: z7.a2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                b2.g3(this.f15216a, str, bundle);
            }
        });
        FragmentUtils.j(this, d0.class, d0.r3(null, this.f15221u0.n(), true));
    }

    public static Bundle l3(String str, boolean z10) {
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
    public void m3() {
        L0().y1(f15220x0, p5.a.b().e("result_id", this.f15221u0.n()).a());
        i0().onBackPressed();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f15222v0 = new t5.f(Collections.EMPTY_LIST);
        f fVar = new f();
        fVar.j(new t5.g() { // from class: z7.x1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                b2.h3(this.f15346a, view2, i10, (a) obj);
            }
        });
        this.f15222v0.K(z7.a.class, fVar);
        n nVar = new n(true);
        nVar.j(new t5.g() { // from class: z7.y1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f15348a.k3();
            }
        });
        this.f15222v0.K(l.class, nVar);
        this.f7946t0.setAdapter(this.f15222v0);
        this.f15221u0.m().g(b1(), new androidx.lifecycle.o() { // from class: z7.z1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                b2.f3(this.f15351a, (List) obj);
            }
        });
        this.f15223w0 = w0() != null && w0().getBoolean("creation_enabled", false);
        this.f15221u0.o(w0() == null ? null : w0().getString("selected_id"));
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.b(e0Var, X0(w7.u.vc));
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.X3)), new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f15221u0 = (d2) new androidx.lifecycle.a0(this, la.s.n()).a(d2.class);
    }
}
