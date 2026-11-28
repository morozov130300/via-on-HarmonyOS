package z7;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
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
public class g1 extends m8.g {
    public static final String B0 = "z7.g1";
    public boolean A0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public o1 f15254r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public EditText f15255s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f15256t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public TextView f15257u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public CheckBox f15258v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public RecyclerView f15259w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public t5.f f15260x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f15261y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ImageView f15262z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            g1.this.z3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3() {
        boolean z10 = this.f15259w0.getVisibility() == 8;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        if (z10) {
            this.f15262z0.animate().rotationBy(180.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
            this.f15259w0.setVisibility(0);
            long j10 = 140;
            this.f15259w0.animate().alpha(1.0f).setDuration(j10).setInterpolator(accelerateDecelerateInterpolator).start();
            if (this.A0) {
                y.r.c(this.f15258v0).a(0.0f).d(j10).i(new Runnable() { // from class: z7.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15335c.f15258v0.setVisibility(8);
                    }
                }).e(accelerateDecelerateInterpolator).f();
                return;
            }
            return;
        }
        this.f15262z0.animate().rotation(0.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
        long j11 = 140;
        y.r.c(this.f15259w0).a(0.0f).d(j11).i(new Runnable() { // from class: z7.w0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15340c.f15259w0.setVisibility(8);
            }
        }).e(accelerateDecelerateInterpolator).f();
        if (this.A0) {
            this.f15258v0.setVisibility(0);
            this.f15258v0.animate().alpha(1.0f).setDuration(j11).setInterpolator(accelerateDecelerateInterpolator).start();
        }
    }

    public static /* synthetic */ void c3(CheckBox checkBox) {
        checkBox.setButtonDrawable(v8.h.d(checkBox.getContext()));
        checkBox.setText(w7.u.f14022e);
        checkBox.setTextColor(com.tuyafeng.support.utils.e.a(checkBox.getContext(), w7.k.f13733m));
        checkBox.setTextSize(0, v8.h.t(checkBox.getContext()));
    }

    public static /* synthetic */ void f3(g1 g1Var, m9.b bVar) {
        if (g1Var.f15254r0.v()) {
            com.tuyafeng.support.utils.n.q(g1Var.G(), w7.u.f14017d8);
        }
        g1Var.L0().y1(B0, p5.a.b().e(Name.MARK, bVar.c()).a());
        g1Var.i0().onBackPressed();
    }

    public static /* synthetic */ void g3(g1 g1Var, mark.via.common.widget.l1 l1Var) {
        g1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(w7.u.f14292x6);
        editText.setGravity(16);
        r3.k(editText);
        v8.g.m(editText, v8.h.q(g1Var.G()));
        v8.g.d(editText);
    }

    public static /* synthetic */ void h3(g1 g1Var, mark.via.common.widget.l1 l1Var) {
        g1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setImeOptions(6);
        editText.setInputType(16);
        editText.setHint(w7.u.f14305y6);
        editText.setGravity(16);
        r3.k(editText);
        v8.g.m(editText, v8.h.q(g1Var.G()));
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        v8.g.d(editText);
    }

    public static /* synthetic */ void j3(RecyclerView recyclerView) {
        recyclerView.setVisibility(8);
        recyclerView.setAlpha(0.0f);
    }

    public static /* synthetic */ void k3(ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.E0, w7.u.sf));
    }

    public static /* synthetic */ void l3(g1 g1Var, m9.b bVar) {
        if (g1Var.f15254r0.v()) {
            g1Var.f15261y0.setTitle(g1Var.X0(w7.u.f13994c));
        }
        g1Var.f15255s0.setText(bVar.e());
        g1Var.f15256t0.setText(bVar.g());
    }

    public static /* synthetic */ void n3(g1 g1Var, String str, Bundle bundle) {
        g1Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            g1Var.f15254r0.D(string);
            g1Var.f15254r0.E(true);
        }
        g1Var.L0().x(d0.f15227z0);
    }

    public static /* synthetic */ void o3(g1 g1Var, TextView textView) {
        g1Var.getClass();
        textView.setHint(w7.u.f14253u6);
        v8.g.k(textView);
        v8.g.l(textView);
        v8.g.m(textView, v8.h.q(g1Var.G()));
        v8.g.d(textView);
    }

    public static /* synthetic */ void q3(ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13784d0, w7.u.te));
    }

    public static /* synthetic */ void r3(g1 g1Var, List list) {
        g1Var.getClass();
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(new l(lb.g.a(g1Var.G(), w7.o.f13787e0, w7.u.ue), g1Var.X0(w7.u.S8)));
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new b(g1Var.f15260x0.H(), arrayList));
        g1Var.f15260x0.M(arrayList);
        eVarB.c(g1Var.f15260x0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        L0().z1(d0.f15227z0, this, new androidx.fragment.app.i0() { // from class: z7.u0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                g1.n3(this.f15331a, str, bundle);
            }
        });
        FragmentUtils.j(this, d0.class, d0.r3(null, this.f15254r0.z().b(), true));
    }

    public static Bundle u3(String str, String str2, String str3, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("title", str2);
        bundle.putString("folderId", str3);
        bundle.putBoolean("favorite_enabled", z10);
        return bundle;
    }

    public static Bundle v3(String str, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        bundle.putBoolean("favorite_enabled", z10);
        return bundle;
    }

    private void w3() {
        this.f15254r0.r().g(b1(), new androidx.lifecycle.o() { // from class: z7.q0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g1 g1Var = this.f15320a;
                m9.a aVar = (m9.a) obj;
                g1Var.f15257u0.setText(com.tuyafeng.support.utils.p.f(aVar.b()) ? g1Var.X0(w7.u.Eb) : aVar.e());
            }
        });
        this.f15254r0.t().g(b1(), new androidx.lifecycle.o() { // from class: z7.r0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g1.l3(this.f15322a, (m9.b) obj);
            }
        });
        this.f15254r0.s().g(b1(), new androidx.lifecycle.o() { // from class: z7.s0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g1.r3(this.f15325a, (List) obj);
            }
        });
        this.f15254r0.u().g(b1(), new androidx.lifecycle.o() { // from class: z7.t0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g1.f3(this.f15328a, (m9.b) obj);
            }
        });
    }

    private void x3() {
        this.f15257u0.setOnClickListener(new View.OnClickListener() { // from class: z7.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15237a.A3();
            }
        });
        this.f15262z0.setOnClickListener(new View.OnClickListener() { // from class: z7.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15244a.A3();
            }
        });
        this.f15259w0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f15259w0.setLayoutManager(new LinearLayoutManager(G()));
        this.f15260x0 = new t5.f(Collections.EMPTY_LIST);
        f fVar = new f();
        fVar.o(true);
        fVar.j(new t5.g() { // from class: z7.f1
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                this.f15249a.f15254r0.C(((a) obj).a());
            }
        });
        this.f15260x0.K(z7.a.class, fVar);
        n nVar = new n(true);
        nVar.j(new t5.g() { // from class: z7.p0
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                this.f15317a.t3();
            }
        });
        this.f15260x0.K(l.class, nVar);
        this.f15259w0.setAdapter(this.f15260x0);
    }

    private void y3() {
        String string = w0() == null ? null : w0().getString(Name.MARK);
        String string2 = w0() == null ? null : w0().getString("title");
        String string3 = w0() == null ? null : w0().getString("url");
        String string4 = w0() != null ? w0().getString("folderId") : null;
        this.A0 = w0() != null && w0().getBoolean("favorite_enabled");
        this.f15254r0.y(string, string2, string3, string4);
        if (this.A0) {
            return;
        }
        this.f15258v0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z3() {
        String string = this.f15255s0.getText().toString();
        String strTrim = this.f15256t0.getText().toString().trim();
        if (TextUtils.isEmpty(string)) {
            com.tuyafeng.support.utils.x.Y(this.f15255s0);
            com.tuyafeng.support.utils.n.i(this.f15255s0);
        } else if (TextUtils.isEmpty(strTrim)) {
            com.tuyafeng.support.utils.x.Y(this.f15256t0);
            com.tuyafeng.support.utils.n.i(this.f15256t0);
        } else {
            this.f15254r0.B(c6.a2.f1958a.w(strTrim, la.s.j().b1()), string, this.A0 && this.f15258v0.isChecked());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        if (this.f15254r0.w()) {
            L0().y1(B0, p5.a.b().c("folder_created", true).a());
        }
        super.B1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f7947o0);
        super.M1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        x3();
        w3();
        y3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new RelativeLayout.LayoutParams(-1, -1)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).l();
        int iL = com.tuyafeng.support.utils.x.l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new b6.a(new mark.via.common.widget.l1(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: z7.o0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.g3(this.f15306a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f15255s0 = l1Var.getEditText();
        mark.via.common.widget.l1 l1Var2 = (mark.via.common.widget.l1) new b6.a(new mark.via.common.widget.l1(G()), new RelativeLayout.LayoutParams(-1, -2)).o(com.tuyafeng.support.utils.x.l()).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).g(41, iL).V(new b6.a.InterfaceC0033a() { // from class: z7.x0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.h3(this.f15345a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f15256t0 = l1Var2.getEditText();
        int iL2 = com.tuyafeng.support.utils.x.l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(com.tuyafeng.support.utils.f.d(G(), w7.n.f13753f), -2)).g(144, iL2).u(com.tuyafeng.support.utils.x.h(G(), 16.0f)).o(com.tuyafeng.support.utils.x.l()).V(new b6.a.InterfaceC0033a() { // from class: z7.y0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.q3((ImageView) obj);
            }
        }).l();
        int iL3 = com.tuyafeng.support.utils.x.l();
        this.f15257u0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL2).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13795h).g(2, imageView.getId()).g(4, iL3).g(32, l1Var2.getId()).V(new b6.a.InterfaceC0033a() { // from class: z7.z0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.o3(this.f15350a, (TextView) obj);
            }
        }).l();
        this.f15258v0 = (CheckBox) new b6.a(new CheckBox(G()), new RelativeLayout.LayoutParams(-1, -2)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).E(com.tuyafeng.support.utils.x.h(G(), 8.0f)).g(32, iL2).g(9, this.f15256t0.getId()).V(new b6.a.InterfaceC0033a() { // from class: z7.a1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.c3((CheckBox) obj);
            }
        }).l();
        this.f15262z0 = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(com.tuyafeng.support.utils.f.d(G(), w7.n.f13751d), -2)).o(iL3).M(com.tuyafeng.support.utils.f.d(G(), w7.n.f13750c)).g(144, iL2).d(w7.o.f13783d).h(8).V(new b6.a.InterfaceC0033a() { // from class: z7.b1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.k3((ImageView) obj);
            }
        }).l();
        this.f15259w0 = (RecyclerView) new b6.a(new RecyclerView(G()), new RelativeLayout.LayoutParams(-1, -2)).g(9, iL).g(32, iL2).V(new b6.a.InterfaceC0033a() { // from class: z7.c1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g1.j3((RecyclerView) obj);
            }
        }).l();
        relativeLayout.addView(l1Var);
        relativeLayout.addView(l1Var2);
        relativeLayout.addView(imageView);
        relativeLayout.addView(this.f15257u0);
        relativeLayout.addView(this.f15258v0);
        relativeLayout.addView(this.f15262z0);
        relativeLayout.addView(this.f15259w0);
        return relativeLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.kg);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.X3)), new a());
        this.f15261y0 = e0Var;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f15254r0 = (o1) new androidx.lifecycle.a0(this, la.s.n()).a(o1.class);
    }
}
