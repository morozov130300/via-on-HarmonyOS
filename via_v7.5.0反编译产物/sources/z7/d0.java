package z7;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends m8.g {

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f15227z0 = "z7.d0";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public m0 f15228r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public EditText f15229s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public TextView f15230t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public RecyclerView f15231u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f15232v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f15233w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ImageView f15234x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f15235y0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            d0.this.v3();
        }
    }

    public static /* synthetic */ void a3(RecyclerView recyclerView) {
        recyclerView.setVisibility(8);
        recyclerView.setAlpha(0.0f);
    }

    public static /* synthetic */ void b3(d0 d0Var, String str, Bundle bundle) {
        d0Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            d0Var.f15228r0.C(string);
        }
        d0Var.L0().x(f15227z0);
    }

    public static /* synthetic */ void c3(ImageView imageView) {
        r3.n(imageView);
        imageView.setImageResource(w7.o.f13784d0);
    }

    public static /* synthetic */ void d3(ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.E0, w7.u.sf));
    }

    public static /* synthetic */ void f3(d0 d0Var, m9.a aVar) {
        d0Var.getClass();
        d0Var.L0().y1(f15227z0, p5.a.b().e(Name.MARK, aVar.b()).a());
        d0Var.i0().onBackPressed();
    }

    public static /* synthetic */ void k3(d0 d0Var, mark.via.common.widget.l1 l1Var) {
        d0Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(w7.u.f14292x6);
        editText.setGravity(16);
        r3.k(editText);
        v8.g.m(editText, v8.h.q(d0Var.G()));
        v8.g.d(editText);
    }

    public static /* synthetic */ void l3(d0 d0Var, m9.a aVar) {
        if (d0Var.f15228r0.v()) {
            d0Var.f15233w0.setTitle(d0Var.X0(w7.u.S8));
        }
        d0Var.f15229s0.setText(aVar.e());
    }

    public static /* synthetic */ void n3(d0 d0Var, List list) {
        d0Var.getClass();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (d0Var.f15235y0) {
            arrayList.add(new l(lb.g.a(d0Var.G(), w7.o.f13787e0, w7.u.ue), d0Var.X0(w7.u.S8)));
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new b(d0Var.f15232v0.H(), arrayList));
        d0Var.f15232v0.M(arrayList);
        eVarB.c(d0Var.f15232v0);
    }

    public static /* synthetic */ void o3(d0 d0Var, TextView textView) {
        d0Var.getClass();
        textView.setHint(w7.u.f14253u6);
        v8.g.k(textView);
        v8.g.l(textView);
        v8.g.m(textView, v8.h.q(d0Var.G()));
        r3.o(textView);
        v8.g.d(textView);
    }

    public static Bundle r3(String str, String str2, boolean z10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(Name.MARK, str);
        }
        if (str2 != null) {
            bundle.putString("parent_folder_id", str2);
        }
        if (z10) {
            bundle.putBoolean("creation_enabled", true);
        }
        return bundle;
    }

    private void s3() {
        this.f15228r0.t().g(b1(), new androidx.lifecycle.o() { // from class: z7.x
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                d0 d0Var = this.f15344a;
                m9.a aVar = (m9.a) obj;
                d0Var.f15230t0.setText(com.tuyafeng.support.utils.p.f(aVar.b()) ? d0Var.X0(w7.u.Eb) : aVar.e());
            }
        });
        this.f15228r0.r().g(b1(), new androidx.lifecycle.o() { // from class: z7.y
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                d0.l3(this.f15347a, (m9.a) obj);
            }
        });
        this.f15228r0.s().g(b1(), new androidx.lifecycle.o() { // from class: z7.z
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                d0.n3(this.f15349a, (List) obj);
            }
        });
        this.f15228r0.u().g(b1(), new androidx.lifecycle.o() { // from class: z7.a0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                d0.f3(this.f15215a, (m9.a) obj);
            }
        });
    }

    private void t3() {
        this.f15230t0.setOnClickListener(new View.OnClickListener() { // from class: z7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15305a.w3();
            }
        });
        this.f15234x0.setOnClickListener(new View.OnClickListener() { // from class: z7.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15330a.w3();
            }
        });
        this.f15231u0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f15231u0.setLayoutManager(new LinearLayoutManager(G()));
        this.f15231u0.setAlpha(0.0f);
        this.f15232v0 = new t5.f(Collections.EMPTY_LIST);
        f fVar = new f();
        fVar.o(true);
        fVar.j(new t5.g() { // from class: z7.v
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                this.f15334a.f15228r0.B(((a) obj).a());
            }
        });
        this.f15232v0.K(z7.a.class, fVar);
        n nVar = new n(true);
        nVar.j(new t5.g() { // from class: z7.w
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                this.f15339a.q3();
            }
        });
        this.f15232v0.K(l.class, nVar);
        this.f15231u0.setAdapter(this.f15232v0);
    }

    private void u3() {
        String string = w0() == null ? null : w0().getString(Name.MARK);
        String string2 = w0() != null ? w0().getString("parent_folder_id") : null;
        boolean z10 = false;
        if (w0() != null && w0().getBoolean("creation_enabled", false)) {
            z10 = true;
        }
        this.f15235y0 = z10;
        this.f15228r0.x(string, string2);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f7947o0);
        super.M1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        t3();
        s3();
        u3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new RelativeLayout.LayoutParams(-1, -1)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).l();
        int iL = com.tuyafeng.support.utils.x.l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new b6.a(new mark.via.common.widget.l1(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: z7.b0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d0.k3(this.f15219a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f15229s0 = l1Var.getEditText();
        int iL2 = com.tuyafeng.support.utils.x.l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(com.tuyafeng.support.utils.x.h(G(), 20.0f), -2)).o(com.tuyafeng.support.utils.x.l()).g(144, iL2).u(com.tuyafeng.support.utils.x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: z7.c0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d0.c3((ImageView) obj);
            }
        }).l();
        int iL3 = com.tuyafeng.support.utils.x.l();
        this.f15230t0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL2).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13795h).g(2, imageView.getId()).g(4, iL3).g(32, l1Var.getId()).V(new b6.a.InterfaceC0033a() { // from class: z7.p
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d0.o3(this.f15316a, (TextView) obj);
            }
        }).l();
        this.f15234x0 = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(com.tuyafeng.support.utils.x.h(G(), 42.0f), -2)).o(iL3).E(com.tuyafeng.support.utils.x.h(G(), 10.0f)).g(144, iL2).d(w7.o.f13783d).h(8).V(new b6.a.InterfaceC0033a() { // from class: z7.q
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d0.d3((ImageView) obj);
            }
        }).l();
        this.f15231u0 = (RecyclerView) new b6.a(new RecyclerView(G()), new RelativeLayout.LayoutParams(-1, -2)).g(9, iL).g(32, iL2).V(new b6.a.InterfaceC0033a() { // from class: z7.r
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d0.a3((RecyclerView) obj);
            }
        }).l();
        relativeLayout.addView(l1Var);
        relativeLayout.addView(imageView);
        relativeLayout.addView(this.f15230t0);
        relativeLayout.addView(this.f15234x0);
        relativeLayout.addView(this.f15231u0);
        return relativeLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.lg);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.X3)), new a());
        this.f15233w0 = e0Var;
    }

    public final void q3() {
        L0().z1(f15227z0, this, new androidx.fragment.app.i0() { // from class: z7.s
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                d0.b3(this.f15324a, str, bundle);
            }
        });
        m9.a aVar = (m9.a) this.f15228r0.t().e();
        FragmentUtils.j(this, d0.class, r3(null, aVar == null ? null : aVar.b(), true));
    }

    public final void v3() {
        String string = this.f15229s0.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            this.f15228r0.A(string);
        } else {
            com.tuyafeng.support.utils.x.Y(this.f15229s0);
            com.tuyafeng.support.utils.n.i(this.f15229s0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f15228r0 = (m0) new androidx.lifecycle.a0(this, la.s.n()).a(m0.class);
    }

    public final void w3() {
        boolean z10 = this.f15231u0.getVisibility() == 8;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        if (!z10) {
            this.f15234x0.animate().rotation(0.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
            y.r.c(this.f15231u0).a(0.0f).d(140).i(new Runnable() { // from class: z7.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15327c.f15231u0.setVisibility(8);
                }
            }).e(accelerateDecelerateInterpolator).f();
        } else {
            this.f15234x0.animate().rotationBy(180.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
            this.f15231u0.setVisibility(0);
            this.f15231u0.animate().alpha(1.0f).setDuration(140).setInterpolator(accelerateDecelerateInterpolator).start();
        }
    }
}
