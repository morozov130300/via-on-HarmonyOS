package ta;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mark.via.common.widget.SizedLinearLayoutManager;
import mark.via.common.widget.v0;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public c0 f12623o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public TextView f12624p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ImageView f12625q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public RecyclerView f12626r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public t5.f f12627s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public List f12628t0 = Collections.EMPTY_LIST;

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
        public void l(w5.g gVar, v5.q qVar, int i10) {
            gVar.X(w5.c.f13659c, qVar.a());
        }
    }

    public static /* synthetic */ void V2(i iVar, v0 v0Var) {
        SizedLinearLayoutManager sizedLinearLayoutManager = new SizedLinearLayoutManager(iVar.G());
        int iMin = Math.min(com.tuyafeng.support.utils.x.y(iVar.G()) / 2, com.tuyafeng.support.utils.x.h(iVar.G(), 600.0f));
        int iMin2 = Math.min(com.tuyafeng.support.utils.x.y(iVar.G()) / 4, com.tuyafeng.support.utils.x.h(iVar.G(), 200.0f));
        sizedLinearLayoutManager.N2(iMin);
        sizedLinearLayoutManager.O2(iMin2);
        v0Var.setLayoutManager(sizedLinearLayoutManager);
        r3.e(v0Var);
        r3.i(v0Var);
    }

    public static /* synthetic */ void W2(i iVar, ra.c cVar) {
        iVar.f12624p0.setText(cVar.g());
        iVar.a3(cVar, iVar.f12623o0.t());
    }

    public static /* synthetic */ void X2(i iVar, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(iVar.G(), w7.o.f13822q, w7.u.he));
        imageView.setContentDescription(iVar.X0(w7.u.O8));
        imageView.setColorFilter(com.tuyafeng.support.utils.e.a(iVar.G(), w7.k.f13729i));
    }

    public static /* synthetic */ void Y2(i iVar, TextView textView) {
        textView.setTextSize(0, v8.h.r(iVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(iVar.G(), w7.k.f13732l));
        textView.setText(w7.u.Ic);
        v8.g.k(textView);
        r3.o(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        v8.g.d(textView);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iL = com.tuyafeng.support.utils.x.l();
        int iL2 = com.tuyafeng.support.utils.x.l();
        this.f12624p0 = (TextView) new b6.a(new TextView(G()), new RelativeLayout.LayoutParams(-1, -2)).o(iL).H(1, 6, 16, 16, 16).g(2, iL2).V(new b6.a.InterfaceC0033a() { // from class: ta.a
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                i.Y2(this.f12599a, (TextView) obj);
            }
        }).l();
        this.f12625q0 = (ImageView) new b6.a(new ImageView(G()), new RelativeLayout.LayoutParams(com.tuyafeng.support.utils.x.h(G(), 48.0f), -2)).o(iL2).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13783d)).F(1, 13).g(16, iL).g(128, iL).V(new b6.a.InterfaceC0033a() { // from class: ta.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                i.X2(this.f12601a, (ImageView) obj);
            }
        }).l();
        this.f12626r0 = (RecyclerView) new b6.a(new v0(G()), new RelativeLayout.LayoutParams(-1, -2)).g(32, iL).V(new b6.a.InterfaceC0033a() { // from class: ta.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                i.V2(this.f12604a, (v0) obj);
            }
        }).l();
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        relativeLayout.addView(this.f12624p0);
        relativeLayout.addView(this.f12626r0);
        relativeLayout.addView(this.f12625q0);
        return relativeLayout;
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        View viewA1 = a1();
        if (viewA1 != null) {
            viewA1.requestLayout();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f12625q0.setOnClickListener(new View.OnClickListener() { // from class: ta.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12618a.f12623o0.z(0);
            }
        });
        this.f12627s0 = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: ta.e
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f12619a.f12623o0.x((v5.q) obj);
            }
        });
        this.f12627s0.K(v5.q.class, aVar);
        this.f12626r0.setAdapter(this.f12627s0);
        this.f12623o0.f12612m.g(b1(), new androidx.lifecycle.o() { // from class: ta.f
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i.W2(this.f12620a, (ra.c) obj);
            }
        });
        this.f12623o0.f12616q.g(b1(), new androidx.lifecycle.o() { // from class: ta.g
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f12621a.b3(((Boolean) obj).booleanValue());
            }
        });
        this.f12623o0.q().g(b1(), new androidx.lifecycle.o() { // from class: ta.h
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i iVar = this.f12622a;
                iVar.a3(iVar.f12623o0.u(), iVar.f12623o0.t());
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0050  */
    public final void a3(ra.c cVar, List list) {
        String strG;
        ArrayList arrayList = new ArrayList();
        boolean z10 = cVar != null && cVar.j();
        arrayList.add(new v5.q(2, X0(z10 ? w7.u.N4 : w7.u.R3)));
        arrayList.add(new v5.q(1, X0(w7.u.E)));
        if (z10) {
            a2 a2Var = a2.f1958a;
            if (a2Var.t(this.f12623o0.v())) {
                strG = a2Var.g(this.f12623o0.v());
            } else {
                strG = null;
            }
        } else {
            strG = null;
        }
        if (z10 && strG != null && strG.length() > 3) {
            arrayList.add(new v5.q(4, Y0(w7.u.X4, strG)));
        }
        arrayList.add(new v5.q(3, X0(w7.u.f14149n0)));
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new v5.q(-1, (String) it.next()));
            }
        }
        this.f12628t0 = arrayList;
        this.f12627s0.M(arrayList);
        this.f12627s0.l();
    }

    public final void b3(boolean z10) {
        ((v5.q) this.f12628t0.get(0)).b(X0(z10 ? w7.u.N4 : w7.u.R3));
        this.f12627s0.m(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (K0() != null) {
            this.f12623o0 = (c0) new androidx.lifecycle.a0(K0()).a(c0.class);
        }
    }
}
