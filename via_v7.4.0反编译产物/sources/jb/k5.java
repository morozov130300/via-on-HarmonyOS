package jb;

import android.R;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import h6.a;
import ib.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public l5 f7763r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7764s0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f7765a;

        public a(TextView textView) {
            this.f7765a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            double dZ = g6.y.Z(seekBar.getContext(), 14.0f);
            Double.isNaN(dZ);
            Double.isNaN((i10 * 5) + 50);
            this.f7765a.setTextSize(0, (int) ((dZ * r3) / 100.0d));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends a6.k {
        public b(List list, List list2) {
            super(list, list2);
        }

        @Override // a6.k, androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            Object obj = this.f115a.get(i10);
            if (obj.getClass() != this.f116b.get(i11).getClass()) {
                return false;
            }
            if (obj instanceof ib.x) {
                return true;
            }
            return super.a(i10, i11);
        }

        @Override // a6.k, androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = this.f115a.get(i10);
            if (obj.getClass() != this.f116b.get(i11).getClass()) {
                return false;
            }
            if (obj instanceof ib.x) {
                return true;
            }
            return super.b(i10, i11);
        }
    }

    public static /* synthetic */ void h3(k5 k5Var, int i10, TextView textView, int i11, mark.via.common.widget.w0 w0Var) {
        k5Var.getClass();
        w0Var.setMax(30);
        w0Var.setHighlightProgress((i10 - 50) / 5);
        z8.r3.g(w0Var);
        w0Var.setMinimumHeight(g6.y.h(k5Var.I(), 2.0f));
        w0Var.setOnSeekBarChangeListener(k5Var.new a(textView));
        w0Var.setProgress((i11 - 50) / 5);
    }

    public static /* synthetic */ void k3(k5 k5Var, TextView textView) {
        k5Var.getClass();
        textView.setText(z8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, x8.h.s(k5Var.I()));
        textView.setTextColor(g6.e.a(k5Var.I(), x7.k.f13665k));
    }

    public static /* synthetic */ void m3(k5 k5Var, View view, int i10, a6.n nVar) {
        k5Var.getClass();
        nVar.j(!nVar.i());
        k5Var.f7764s0.m(i10);
        k5Var.f7763r0.t(nVar.i());
    }

    public static /* synthetic */ void o3(k5 k5Var, mark.via.common.widget.w0 w0Var, String str, View view, k.p pVar) {
        k5Var.getClass();
        k5Var.f7763r0.l(str, (w0Var.getProgress() * 5) + 50);
    }

    public static /* synthetic */ void p3(k5 k5Var, View view, k.p pVar) {
        k5Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        k5Var.v3(ba.c.f(pVar.f13339c[0]), k5Var.f7763r0.m(), false);
    }

    public static /* synthetic */ void q3(k5 k5Var, View view, int i10, a6.q qVar) {
        k5Var.getClass();
        k5Var.t3(qVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3() {
        w5.k.l(I()).e0(Z0(x7.u.f14216x0)).I(x7.u.Ef).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.a5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                k5.p3(this.f7644a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private void t3(String str) {
        Integer num = (Integer) this.f7763r0.n().get(str);
        if (num == null) {
            return;
        }
        v3(str, num.intValue(), true);
    }

    private void u3() {
        this.f7763r0.o().g(d1(), new androidx.lifecycle.m() { // from class: jb.e5
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                k5 k5Var = this.f7689a;
                k5Var.w3(k5Var.s3(k5Var.f7763r0.m(), (Map) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new b(this.f7764s0.H(), list));
        this.f7764s0.M(list);
        eVarB.c(this.f7764s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7764s0 = new y5.f(Collections.EMPTY_LIST);
        ib.z zVar = new ib.z();
        zVar.q(new z.b() { // from class: jb.z4
            @Override // ib.z.b
            public final void a(int i10) {
                this.f7951a.f7763r0.s(i10);
            }
        });
        this.f7764s0.K(ib.x.class, zVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.b5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7651a.r3();
            }
        });
        this.f7764s0.K(a6.e.class, fVar);
        this.f7764s0.K(a6.l.class, new a6.m());
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.c5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k5.q3(this.f7663a, view2, i10, (a6.q) obj);
            }
        });
        this.f7764s0.K(a6.q.class, sVar);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: jb.d5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k5.m3(this.f7678a, view2, i10, (a6.n) obj);
            }
        });
        this.f7764s0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f7764s0);
        u3();
        this.f7763r0.q();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.Pc);
    }

    public final List s3(int i10, Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ib.x(1, Z0(x7.u.Pc), "%d%%", z8.f.c(), i10, 50, 200, 5, 100));
        arrayList.add(new a6.n(3, Z0(x7.u.O5), this.f7763r0.p()));
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (!map.isEmpty()) {
            arrayList.add(new a6.l(Z0(x7.u.I4)));
            ArrayList<String> arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2, new k8.p());
            for (String str : arrayList2) {
                arrayList.add(new a6.q(str.hashCode(), str, String.format(Locale.ROOT, "%d%%", map.get(str))));
            }
        }
        return arrayList;
    }

    public final void v3(final String str, final int i10, boolean z10) {
        final int iM = this.f7763r0.m();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: jb.f5
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-1, -2)).r(1, 12, 16, 12, 16).n(1, 76).V(new a.InterfaceC0076a() { // from class: jb.g5
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k5.k3(this.f7713a, (TextView) obj);
            }
        }).l();
        final mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new h6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(l0(), x7.v.f14259f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new a.InterfaceC0076a() { // from class: jb.h5
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k5.h3(this.f7722a, iM, textView, i10, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        w5.k kVarN = w5.k.l(I()).y(linearLayout).V(R.string.ok, new k.m() { // from class: jb.i5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                k5.o3(this.f7735a, w0Var, str, view, pVar);
            }
        }).N(R.string.cancel, null);
        if (z10) {
            kVarN.R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.j5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f7749a.f7763r0.r(str);
                }
            });
        }
        kVarN.f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7763r0 = (l5) new androidx.lifecycle.y(this, pa.r.n()).a(l5.class);
    }
}
