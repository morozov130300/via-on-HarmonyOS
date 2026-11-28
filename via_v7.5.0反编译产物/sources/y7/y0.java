package y7;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import x8.c1;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public List f14936u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f14937v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f14938w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            return w5.c.h().a(viewGroup);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, String str, int i10) {
            gVar.X(w5.c.f13659c, str);
        }
    }

    public static /* synthetic */ void g3(y0 y0Var, List list) {
        y0Var.f14936u0.clear();
        y0Var.f14936u0.addAll(list);
        y0Var.f14937v0.l();
        tc.a.a("count: %d", Integer.valueOf(list.size()));
        y0Var.d3(list.isEmpty());
    }

    public static Bundle h3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("title", str2);
        }
        return bundle;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14936u0 = new ArrayList();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f14937v0 = new t5.f(this.f14936u0);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: y7.v0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                com.tuyafeng.support.utils.n.l(this.f14928a.G(), w7.u.X, (String) obj);
            }
        });
        this.f14937v0.K(String.class, aVar);
        this.f7946t0.setAdapter(this.f14937v0);
        ((autodispose2.r) r6.q.g(this.f14938w0).h(new u6.g() { // from class: y7.w0
            @Override // u6.g
            public final Object apply(Object obj) {
                return c1.v((String) obj);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y7.x0
            @Override // u6.f
            public final void accept(Object obj) {
                y0.g3(this.f14933c, (List) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        String strX0 = X0(w7.u.X);
        Bundle bundleW0 = w0();
        if (bundleW0 != null) {
            if (bundleW0.containsKey("path")) {
                this.f14938w0 = bundleW0.getString("path");
            }
            if (bundleW0.containsKey("title")) {
                strX0 = bundleW0.getString("title");
            }
        }
        v3.b(e0Var, strX0);
    }
}
