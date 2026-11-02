package a8;

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
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d0 extends o8.h {

    /* renamed from: w0, reason: collision with root package name */
    public static final String f155w0 = "a8.d0";

    /* renamed from: o0, reason: collision with root package name */
    public m0 f156o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f157p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f158q0;

    /* renamed from: r0, reason: collision with root package name */
    public RecyclerView f159r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f160s0;

    /* renamed from: t0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f161t0;

    /* renamed from: u0, reason: collision with root package name */
    public ImageView f162u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f163v0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            d0.this.w3();
        }
    }

    public static /* synthetic */ void b3(RecyclerView recyclerView) {
        recyclerView.setVisibility(8);
        recyclerView.setAlpha(0.0f);
    }

    public static /* synthetic */ void c3(d0 d0Var, String str, Bundle bundle) {
        d0Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null) {
            d0Var.f156o0.C(string);
        }
        d0Var.N0().x(f155w0);
    }

    public static /* synthetic */ void d3(ImageView imageView) {
        r3.m(imageView);
        imageView.setImageResource(x7.o.f13721e0);
    }

    public static /* synthetic */ void e3(ImageView imageView) {
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.G0, x7.u.bf));
    }

    public static /* synthetic */ void g3(d0 d0Var, o9.a aVar) {
        d0Var.getClass();
        d0Var.N0().x1(f155w0, v5.a.b().e(Name.MARK, aVar.b()).a());
        d0Var.l0().onBackPressed();
    }

    public static /* synthetic */ void l3(d0 d0Var, mark.via.common.widget.l1 l1Var) {
        d0Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(x7.u.f14061l6);
        editText.setGravity(16);
        r3.j(editText);
        x8.g.m(editText, x8.h.r(d0Var.I()));
        x8.g.d(editText);
    }

    public static /* synthetic */ void m3(d0 d0Var, o9.a aVar) {
        if (d0Var.f156o0.v()) {
            d0Var.f161t0.setTitle(d0Var.Z0(x7.u.G8));
        }
        d0Var.f157p0.setText(aVar.e());
    }

    public static /* synthetic */ void o3(d0 d0Var, List list) {
        d0Var.getClass();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (d0Var.f163v0) {
            arrayList.add(new l(lb.b.a(d0Var.I(), x7.o.f13724f0, x7.u.fe), d0Var.Z0(x7.u.G8)));
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new b(d0Var.f160s0.H(), arrayList));
        d0Var.f160s0.M(arrayList);
        eVarB.c(d0Var.f160s0);
    }

    public static /* synthetic */ void p3(d0 d0Var, TextView textView) {
        d0Var.getClass();
        textView.setHint(x7.u.f14019i6);
        x8.g.k(textView);
        x8.g.l(textView);
        x8.g.m(textView, x8.h.r(d0Var.I()));
        r3.n(textView);
        x8.g.d(textView);
    }

    public static Bundle s3(String str, String str2, boolean z10) {
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

    private void u3() {
        this.f158q0.setOnClickListener(new View.OnClickListener() { // from class: a8.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f234a.x3();
            }
        });
        this.f162u0.setOnClickListener(new View.OnClickListener() { // from class: a8.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f259a.x3();
            }
        });
        this.f159r0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f159r0.setLayoutManager(new LinearLayoutManager(I()));
        this.f159r0.setAlpha(0.0f);
        this.f160s0 = new y5.f(Collections.EMPTY_LIST);
        f fVar = new f();
        fVar.p(true);
        fVar.j(new y5.g() { // from class: a8.v
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                this.f263a.f156o0.B(((a) obj).a());
            }
        });
        this.f160s0.K(a8.a.class, fVar);
        n nVar = new n(true);
        nVar.j(new y5.g() { // from class: a8.w
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                this.f268a.r3();
            }
        });
        this.f160s0.K(l.class, nVar);
        this.f159r0.setAdapter(this.f160s0);
    }

    private void v3() {
        String string = y0() == null ? null : y0().getString(Name.MARK);
        String string2 = y0() != null ? y0().getString("parent_folder_id") : null;
        boolean z10 = false;
        if (y0() != null && y0().getBoolean("creation_enabled", false)) {
            z10 = true;
        }
        this.f163v0 = z10;
        this.f156o0.x(string, string2);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            z8.f.e(this.f10460m0);
        }
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f10460m0);
        super.O1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        u3();
        t3();
        v3();
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(I()), new RelativeLayout.LayoutParams(-1, -1)).M(g6.y.h(I(), 16.0f)).Q(g6.y.h(I(), 12.0f)).l();
        int iL = g6.y.l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new h6.a(new mark.via.common.widget.l1(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).S(g6.y.h(I(), 10.0f)).s(g6.y.h(I(), 12.0f)).d(x7.o.f13729h).V(new a.InterfaceC0076a() { // from class: a8.b0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                d0.l3(this.f147a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f157p0 = l1Var.getEditText();
        int iL2 = g6.y.l();
        ImageView imageView = (ImageView) new h6.a(new ImageView(I()), new RelativeLayout.LayoutParams(g6.y.h(I(), 20.0f), -2)).o(g6.y.l()).g(144, iL2).u(g6.y.h(I(), 16.0f)).V(new a.InterfaceC0076a() { // from class: a8.c0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                d0.d3((ImageView) obj);
            }
        }).l();
        int iL3 = g6.y.l();
        this.f158q0 = (TextView) new h6.a(new TextView(I()), new RelativeLayout.LayoutParams(-1, -2)).o(iL2).S(g6.y.h(I(), 10.0f)).s(g6.y.h(I(), 12.0f)).d(x7.o.f13732i).g(2, imageView.getId()).g(4, iL3).g(32, l1Var.getId()).V(new a.InterfaceC0076a() { // from class: a8.p
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                d0.p3(this.f245a, (TextView) obj);
            }
        }).l();
        this.f162u0 = (ImageView) new h6.a(new ImageView(I()), new RelativeLayout.LayoutParams(g6.y.h(I(), 42.0f), -2)).o(iL3).E(g6.y.h(I(), 10.0f)).g(144, iL2).d(x7.o.f13720e).h(8).V(new a.InterfaceC0076a() { // from class: a8.q
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                d0.e3((ImageView) obj);
            }
        }).l();
        this.f159r0 = (RecyclerView) new h6.a(new RecyclerView(I()), new RelativeLayout.LayoutParams(-1, -2)).g(9, iL).g(32, iL2).V(new a.InterfaceC0076a() { // from class: a8.r
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                d0.b3((RecyclerView) obj);
            }
        }).l();
        relativeLayout.addView(l1Var);
        relativeLayout.addView(imageView);
        relativeLayout.addView(this.f158q0);
        relativeLayout.addView(this.f162u0);
        relativeLayout.addView(this.f159r0);
        return relativeLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.Vf);
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.K3)), new a());
        this.f161t0 = zVar;
    }

    public final void r3() {
        N0().y1(f155w0, this, new androidx.fragment.app.i0() { // from class: a8.s
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                d0.c3(this.f253a, str, bundle);
            }
        });
        o9.a aVar = (o9.a) this.f156o0.t().e();
        g6.i.h(this, d0.class, s3(null, aVar == null ? null : aVar.b(), true));
    }

    public final void t3() {
        this.f156o0.t().g(d1(), new androidx.lifecycle.m() { // from class: a8.x
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                d0 d0Var = this.f273a;
                o9.a aVar = (o9.a) obj;
                d0Var.f158q0.setText(g6.p.f(aVar.b()) ? d0Var.Z0(x7.u.f14149rb) : aVar.e());
            }
        });
        this.f156o0.r().g(d1(), new androidx.lifecycle.m() { // from class: a8.y
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                d0.m3(this.f276a, (o9.a) obj);
            }
        });
        this.f156o0.s().g(d1(), new androidx.lifecycle.m() { // from class: a8.z
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                d0.o3(this.f278a, (List) obj);
            }
        });
        this.f156o0.u().g(d1(), new androidx.lifecycle.m() { // from class: a8.a0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                d0.g3(this.f143a, (o9.a) obj);
            }
        });
    }

    public final void w3() {
        String string = this.f157p0.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            this.f156o0.A(string);
        } else {
            g6.y.X(this.f157p0);
            g6.n.i(this.f157p0);
        }
    }

    public final void x3() {
        boolean z10 = this.f159r0.getVisibility() == 8;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        if (!z10) {
            this.f162u0.animate().rotation(0.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
            x.r.c(this.f159r0).a(0.0f).d(140).i(new Runnable() { // from class: a8.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f256e.f159r0.setVisibility(8);
                }
            }).e(accelerateDecelerateInterpolator).f();
        } else {
            this.f162u0.animate().rotationBy(180.0f).setDuration(140L).setInterpolator(accelerateDecelerateInterpolator).start();
            this.f159r0.setVisibility(0);
            this.f159r0.animate().alpha(1.0f).setDuration(140).setInterpolator(accelerateDecelerateInterpolator).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f156o0 = (m0) new androidx.lifecycle.y(this, pa.r.n()).a(m0.class);
    }
}
