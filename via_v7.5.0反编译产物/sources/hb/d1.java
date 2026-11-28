package hb;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public w9.a f5830r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f5831s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ga.c f5832t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f5833u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f5834v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public EditText f5835w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f5836x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public u9.l f5837y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Map f5838z0;

    public static /* synthetic */ void a3(d1 d1Var, String str, Boolean bool) {
        d1Var.f5838z0.put(Integer.valueOf(d1Var.f5832t0.d()), str);
        tb.c.g(d1Var.f5837y0, d1Var.f5838z0);
        Bundle bundle = new Bundle();
        bundle.putInt("engine_result", d1Var.f5832t0.d());
        d1Var.L0().y1("engine_result", bundle);
        d1Var.p3();
    }

    public static /* synthetic */ void c3(d1 d1Var, TextView textView) {
        x8.r3.k(d1Var.f5833u0);
        x8.r3.k(d1Var.f5834v0);
        x8.r3.k(d1Var.f5835w0);
        textView.setTextColor(v8.h.p(d1Var.G()));
        if (d1Var.f5831s0 < 0) {
            d1Var.f5833u0.setTextColor(v8.h.p(d1Var.G()));
        }
    }

    public static /* synthetic */ void d3(d1 d1Var, ga.c cVar) {
        d1Var.f5832t0 = cVar;
        d1Var.f5833u0.setText(cVar.g());
        d1Var.f5834v0.setText(cVar.a());
        String strM = com.tuyafeng.support.utils.p.m((String) d1Var.f5838z0.get(Integer.valueOf(cVar.d())));
        d1Var.f5835w0.setText(strM);
        d1Var.f5836x0 = x8.v0.d(cVar.g(), cVar.a(), strM);
    }

    public static /* synthetic */ void f3(d1 d1Var, mark.via.common.widget.l1 l1Var) {
        d1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextSize(0, v8.h.q(d1Var.G()));
        editText.setHint(w7.u.f14292x6);
        v8.g.d(editText);
    }

    public static /* synthetic */ Boolean g3(d1 d1Var) {
        if (d1Var.f5832t0.d() > 0) {
            d1Var.f5832t0.s(System.currentTimeMillis());
            return Boolean.valueOf(d1Var.f5830r0.z().f(d1Var.f5832t0.d(), d1Var.f5832t0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        d1Var.f5832t0.s(jCurrentTimeMillis);
        d1Var.f5832t0.p(jCurrentTimeMillis);
        d1Var.f5832t0.v(2);
        int iD = d1Var.f5830r0.z().d(d1Var.f5832t0);
        d1Var.f5832t0.r(iD);
        return Boolean.valueOf(iD > 0);
    }

    public static /* synthetic */ void h3(d1 d1Var, EditText editText) {
        d1Var.getClass();
        v8.g.h(editText);
        editText.setImeOptions(6);
        editText.setInputType(524289);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextSize(0, v8.h.q(d1Var.G()));
        editText.setHint(w7.u.f14305y6);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        x8.r3.p(editText, false);
        v8.g.d(editText);
    }

    public static /* synthetic */ void i3(d1 d1Var, TextView textView) {
        d1Var.getClass();
        textView.setText(w7.u.f14189pc);
        textView.setTextSize(0, v8.h.t(d1Var.G()));
        v8.g.d(textView);
    }

    public static /* synthetic */ boolean j3(d1 d1Var, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 == 6) {
            d1Var.t3(false);
            return true;
        }
        d1Var.getClass();
        return false;
    }

    public static /* synthetic */ void l3(d1 d1Var, EditText editText) {
        d1Var.getClass();
        editText.setSingleLine(true);
        editText.setInputType(524289);
        editText.setImeOptions(6);
        editText.setHint(w7.u.f14175oc);
        editText.setTextSize(0, v8.h.q(d1Var.G()));
        v8.g.d(editText);
    }

    public static /* synthetic */ boolean m3(d1 d1Var, View view, int i10, KeyEvent keyEvent) {
        d1Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            d1Var.t3(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3() {
        super.T2();
    }

    private boolean r3() {
        String strTrim = com.tuyafeng.support.utils.p.l(this.f5833u0.getText().toString()).trim();
        String strTrim2 = this.f5831s0 < 0 ? null : this.f5834v0.getText().toString().trim();
        if (strTrim2 != null && !strTrim2.isEmpty() && strTrim2.indexOf(58) < 0) {
            strTrim2 = c6.a2.f1958a.w(strTrim2, null);
        }
        String strD = x8.v0.d(strTrim, strTrim2, tb.c.e(this.f5835w0.getText().toString()));
        return (this.f5836x0 == null && strD.isEmpty()) || strD.equals(this.f5836x0);
    }

    public static Bundle s3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(boolean z10) {
        String strTrim = com.tuyafeng.support.utils.p.l(this.f5833u0.getText().toString()).trim();
        String strTrim2 = this.f5831s0 < 0 ? null : this.f5834v0.getText().toString().trim();
        if (strTrim2 != null && !strTrim2.isEmpty() && strTrim2.indexOf(58) < 0) {
            strTrim2 = c6.a2.f1958a.w(strTrim2, null);
        }
        if (r3()) {
            p3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: hb.a1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f5784a.t3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: hb.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f5801a.p3();
                }
            }).h0();
            return;
        }
        final String strE = tb.c.e(this.f5835w0.getText().toString());
        if (!tb.c.d(strE)) {
            com.tuyafeng.support.utils.x.Y(this.f5835w0);
            com.tuyafeng.support.utils.n.q(G(), w7.u.f14217rc);
            return;
        }
        if (tb.c.c(this.f5838z0, this.f5831s0, strE)) {
            com.tuyafeng.support.utils.x.Y(this.f5835w0);
            com.tuyafeng.support.utils.n.q(G(), w7.u.f14203qc);
            return;
        }
        int i10 = this.f5831s0;
        if (i10 < 0) {
            u3(i10, strE);
            return;
        }
        if (strTrim.isEmpty()) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.eg);
            return;
        }
        if (strTrim2 == null || strTrim2.isEmpty()) {
            com.tuyafeng.support.utils.n.s(G(), Y0(w7.u.f14254u7, this.f5834v0.getHint()));
            return;
        }
        if (strTrim2.length() >= 10) {
            String lowerCase = strTrim2.toLowerCase(Locale.ROOT);
            if (lowerCase.contains("via.search") || lowerCase.contains("v://search") || lowerCase.contains("via://search")) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.Oh);
                return;
            }
        }
        this.f5832t0.u(strTrim);
        this.f5832t0.o(strTrim2);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.c1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d1.g3(this.f5823c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.p0
            @Override // u6.f
            public final void accept(Object obj) {
                d1.a3(this.f6018c, strE, (Boolean) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        EditText editText = this.f5835w0;
        x8.f.e((editText == null || !editText.hasFocus()) ? this.f5834v0 : this.f5835w0);
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        t3(true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5830r0 = la.s.f();
        u9.l lVarJ = la.s.j();
        this.f5837y0 = lVarJ;
        this.f5838z0 = tb.c.f(lVarJ);
        this.f5832t0 = new ga.c();
        this.f5834v0.setOnKeyListener(new View.OnKeyListener() { // from class: hb.q0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return d1.m3(this.f6029a, view2, i10, keyEvent);
            }
        });
        this.f5835w0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: hb.r0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return d1.j3(this.f6045a, textView, i10, keyEvent);
            }
        });
        ((autodispose2.m) r6.f.h(new Callable() { // from class: hb.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                d1 d1Var = this.f6058c;
                return d1Var.q3(d1Var.f5831s0);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: hb.t0
            @Override // u6.f
            public final void accept(Object obj) {
                d1.d3(this.f6068c, (ga.c) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: hb.o0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new b6.a(new mark.via.common.widget.l1(G()), new LinearLayout.LayoutParams(-1, -2)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: hb.u0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d1.f3(this.f6086a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f5833u0 = l1Var.getEditText();
        this.f5834v0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).M(0).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: hb.v0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d1.h3(this.f6097a, (EditText) obj);
            }
        }).l();
        this.f5835w0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).A(com.tuyafeng.support.utils.x.h(G(), 12.0f)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: hb.w0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d1.l3(this.f6115a, (EditText) obj);
            }
        }).l();
        final TextView textView = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).A(com.tuyafeng.support.utils.x.h(G(), 6.0f)).V(new b6.a.InterfaceC0033a() { // from class: hb.x0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                d1.i3(this.f6137a, (TextView) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f5834v0);
        linearLayout.addView(this.f5835w0);
        linearLayout.addView(textView);
        if (this.f5831s0 < 0) {
            this.f5833u0.setEnabled(false);
            this.f5834v0.setVisibility(8);
            this.f5835w0.setImeOptions(6);
        }
        X2(new Runnable() { // from class: hb.y0
            @Override // java.lang.Runnable
            public final void run() {
                d1.c3(this.f6150c, textView);
            }
        });
        return linearLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, this.f5831s0 != 0 ? w7.u.E : w7.u.O);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: hb.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6171a.t3(false);
            }
        });
    }

    @Override // m8.g
    public boolean l() {
        return r3();
    }

    public final ga.c q3(int i10) {
        if (i10 > 0) {
            return this.f5830r0.z().c(i10);
        }
        if (i10 >= 0) {
            return null;
        }
        for (ga.c cVar : x8.q2.b(G())) {
            if (cVar.d() == i10) {
                return cVar;
            }
        }
        return null;
    }

    public final void u3(int i10, String str) {
        this.f5838z0.put(Integer.valueOf(i10), str);
        tb.c.g(this.f5837y0, this.f5838z0);
        Bundle bundle = new Bundle();
        bundle.putInt("engine_result", i10);
        L0().y1("engine_result", bundle);
        p3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (w0() == null) {
            return;
        }
        this.f5831s0 = w0().getInt(Name.MARK, 0);
    }
}
