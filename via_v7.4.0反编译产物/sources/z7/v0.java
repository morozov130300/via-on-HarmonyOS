package z7;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import z8.c1;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v0 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public List f14661r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f14662s0;

    /* renamed from: t0, reason: collision with root package name */
    public String f14663t0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            return b6.c.h().a(viewGroup);
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, String str, int i10) {
            gVar.X(b6.c.f1828c, str);
        }
    }

    public static /* synthetic */ void h3(v0 v0Var, List list) {
        v0Var.f14661r0.clear();
        v0Var.f14661r0.addAll(list);
        v0Var.f14662s0.l();
        pc.a.a("count: %d", Integer.valueOf(list.size()));
        v0Var.e3(list.isEmpty());
    }

    public static Bundle i3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("title", str2);
        }
        return bundle;
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f14661r0 = new ArrayList();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f14662s0 = new y5.f(this.f14661r0);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: z7.s0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                g6.n.l(this.f14652a.I(), x7.u.W, (String) obj);
            }
        });
        this.f14662s0.K(String.class, aVar);
        this.f10459q0.setAdapter(this.f14662s0);
        ((autodispose2.r) x6.o.h(this.f14663t0).i(new a7.f() { // from class: z7.t0
            @Override // a7.f
            public final Object apply(Object obj) {
                return c1.t((String) obj);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: z7.u0
            @Override // a7.e
            public final void accept(Object obj) {
                v0.h3(this.f14656e, (List) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        String strZ0 = Z0(x7.u.W);
        Bundle bundleY0 = y0();
        if (bundleY0 != null) {
            if (bundleY0.containsKey("path")) {
                this.f14663t0 = bundleY0.getString("path");
            }
            if (bundleY0.containsKey("title")) {
                strZ0 = bundleY0.getString("title");
            }
        }
        v3.b(zVar, strZ0);
    }
}
