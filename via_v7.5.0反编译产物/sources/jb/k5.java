package jb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public l5 f6874u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6875v0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends v5.k {
        public b(List list, List list2) {
            super(list, list2);
        }

        @Override // v5.k, androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            Object obj = this.f13399a.get(i10);
            if (obj.getClass() != this.f13400b.get(i11).getClass()) {
                return false;
            }
            if (obj instanceof ib.x) {
                return true;
            }
            return super.a(i10, i11);
        }

        @Override // v5.k, androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = this.f13399a.get(i10);
            if (obj.getClass() != this.f13400b.get(i11).getClass()) {
                return false;
            }
            if (obj instanceof ib.x) {
                return true;
            }
            return super.b(i10, i11);
        }
    }

    public static /* synthetic */ void g3(k5 k5Var, int i10, TextView textView, int i11, mark.via.common.widget.w0 w0Var) {
        k5Var.getClass();
        w0Var.setMax(30);
        w0Var.setHighlightProgress((i10 - 50) / 5);
        x8.r3.h(w0Var);
        w0Var.setMinimumHeight(com.tuyafeng.support.utils.x.h(k5Var.G(), 2.0f));
        w0Var.setOnSeekBarChangeListener(k5Var.new a(textView));
        w0Var.setProgress((i11 - 50) / 5);
    }

    public static /* synthetic */ void j3(k5 k5Var, TextView textView) {
        k5Var.getClass();
        textView.setText(x8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, v8.h.r(k5Var.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(k5Var.G(), w7.k.f13732l));
    }

    public static /* synthetic */ void l3(k5 k5Var, View view, int i10, v5.n nVar) {
        k5Var.getClass();
        nVar.j(!nVar.i());
        k5Var.f6875v0.m(i10);
        k5Var.f6874u0.t(nVar.i());
    }

    public static /* synthetic */ void n3(k5 k5Var, mark.via.common.widget.w0 w0Var, String str, View view, q5.k.p pVar) {
        k5Var.getClass();
        k5Var.f6874u0.l(str, (w0Var.getProgress() * 5) + 50);
    }

    public static /* synthetic */ void o3(k5 k5Var, View view, q5.k.p pVar) {
        k5Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        k5Var.v3(y9.c.f(pVar.f11819c[0]), k5Var.f6874u0.m(), false);
    }

    public static /* synthetic */ void p3(k5 k5Var, View view, int i10, v5.q qVar) {
        k5Var.getClass();
        k5Var.s3(qVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3() {
        q5.k.l(G()).g0(X0(w7.u.f14312z0)).J(w7.u.Uf).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.a5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                k5.o3(this.f6755a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private void s3(String str) {
        Integer num = (Integer) this.f6874u0.n().get(str);
        if (num == null) {
            return;
        }
        v3(str, num.intValue(), true);
    }

    public static List t3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, k5.class, w7.u.Fc, w7.u.Xc, w7.u.ed);
        hVar.b(1, w7.u.ed, "字体大小", "字号", "font size");
        hVar.b(3, w7.u.f13973a6, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void u3() {
        this.f6874u0.o().g(b1(), new androidx.lifecycle.o() { // from class: jb.e5
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                k5 k5Var = this.f6800a;
                k5Var.w3(k5Var.r3(k5Var.f6874u0.m(), (Map) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new b(this.f6875v0.H(), list));
        this.f6875v0.M(list);
        eVarB.c(this.f6875v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6875v0 = new t5.f(Collections.EMPTY_LIST);
        ib.z zVar = new ib.z();
        zVar.q(new ib.z.b() { // from class: jb.z4
            @Override // ib.z.b
            public final void a(int i10) {
                this.f7061a.f6874u0.s(i10);
            }
        });
        this.f6875v0.K(ib.x.class, zVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.b5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6762a.q3();
            }
        });
        this.f6875v0.K(v5.e.class, fVar);
        this.f6875v0.K(v5.l.class, new v5.m());
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.c5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                k5.p3(this.f6774a, view2, i10, (v5.q) obj);
            }
        });
        this.f6875v0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.d5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                k5.l3(this.f6789a, view2, i10, (v5.n) obj);
            }
        });
        this.f6875v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6875v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        u3();
        this.f6874u0.q();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.ed);
    }

    public final List r3(int i10, Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ib.x(1, X0(w7.u.ed), "%d%%", x8.f.c(), i10, 50, 200, 5, 100));
        arrayList.add(new v5.n(3, X0(w7.u.f13973a6), this.f6874u0.p()));
        arrayList.add(new v5.e(2, X0(w7.u.f14312z0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        if (!map.isEmpty()) {
            arrayList.add(new v5.l(X0(w7.u.V4)));
            ArrayList<String> arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2, new i8.p());
            for (String str : arrayList2) {
                arrayList.add(new v5.q(str.hashCode(), str, String.format(Locale.ROOT, "%d%%", map.get(str))));
            }
        }
        return arrayList;
    }

    public final void v3(final String str, final int i10, boolean z10) {
        final int iM = this.f6874u0.m();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: jb.f5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).r(1, 12, 16, 12, 16).n(1, 76).V(new b6.a.InterfaceC0033a() { // from class: jb.g5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k5.j3(this.f6824a, (TextView) obj);
            }
        }).l();
        final mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new b6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(i0(), w7.v.f14329f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new b6.a.InterfaceC0033a() { // from class: jb.h5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k5.g3(this.f6833a, iM, textView, i10, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        q5.k kVarP = q5.k.l(G()).z(linearLayout).X(R.string.ok, new q5.k.m() { // from class: jb.i5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                k5.n3(this.f6846a, w0Var, str, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (z10) {
            kVarP.T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.j5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6860a.f6874u0.r(str);
                }
            });
        }
        kVarP.h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6874u0 = (l5) new androidx.lifecycle.a0(this, la.s.n()).a(l5.class);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f6876a;

        public a(TextView textView) {
            this.f6876a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            double dZ = com.tuyafeng.support.utils.x.Z(seekBar.getContext(), 14.0f);
            double d10 = (i10 * 5) + 50;
            Double.isNaN(dZ);
            Double.isNaN(d10);
            this.f6876a.setTextSize(0, (int) ((dZ * d10) / 100.0d));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
