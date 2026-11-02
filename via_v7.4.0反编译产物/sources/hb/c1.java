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
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.simpleframework.xml.strategy.Name;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c1 extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public y9.a f6489o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f6490p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    public ja.c f6491q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f6492r0;

    /* renamed from: s0, reason: collision with root package name */
    public EditText f6493s0;

    /* renamed from: t0, reason: collision with root package name */
    public EditText f6494t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f6495u0;

    /* renamed from: v0, reason: collision with root package name */
    public w9.l f6496v0;

    /* renamed from: w0, reason: collision with root package name */
    public Map f6497w0;

    public static /* synthetic */ void e3(c1 c1Var, mark.via.common.widget.l1 l1Var) {
        c1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextColor(g6.e.a(c1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(c1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(c1Var.I()));
        editText.setHint(x7.u.f14061l6);
        x8.g.d(editText);
    }

    public static /* synthetic */ void f3(c1 c1Var, String str, Boolean bool) throws JSONException {
        c1Var.f6497w0.put(Integer.valueOf(c1Var.f6491q0.d()), str);
        tb.c.g(c1Var.f6496v0, c1Var.f6497w0);
        Bundle bundle = new Bundle();
        bundle.putInt("engine_result", c1Var.f6491q0.d());
        c1Var.N0().x1("engine_result", bundle);
        c1Var.p3();
    }

    public static /* synthetic */ void g3(c1 c1Var, EditText editText) {
        c1Var.getClass();
        x8.g.h(editText);
        editText.setImeOptions(6);
        editText.setInputType(524289);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextColor(g6.e.a(c1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(c1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(c1Var.I()));
        editText.setHint(x7.u.f14075m6);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        z8.r3.o(editText, false);
        x8.g.d(editText);
    }

    public static /* synthetic */ void h3(c1 c1Var, TextView textView) {
        c1Var.getClass();
        textView.setText(x7.u.f13927bc);
        textView.setTextColor(x8.h.q(c1Var.I()));
        textView.setTextSize(0, x8.h.u(c1Var.I()));
        x8.g.d(textView);
    }

    public static /* synthetic */ Boolean k3(c1 c1Var) {
        if (c1Var.f6491q0.d() > 0) {
            c1Var.f6491q0.s(System.currentTimeMillis());
            return Boolean.valueOf(c1Var.f6489o0.z().b(c1Var.f6491q0.d(), c1Var.f6491q0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        c1Var.f6491q0.s(jCurrentTimeMillis);
        c1Var.f6491q0.p(jCurrentTimeMillis);
        c1Var.f6491q0.v(2);
        int iH = c1Var.f6489o0.z().h(c1Var.f6491q0);
        c1Var.f6491q0.r(iH);
        return Boolean.valueOf(iH > 0);
    }

    public static /* synthetic */ void l3(c1 c1Var, EditText editText) {
        c1Var.getClass();
        editText.setSingleLine(true);
        editText.setInputType(524289);
        editText.setImeOptions(6);
        editText.setHint(x7.u.f13913ac);
        editText.setTextColor(x8.h.p(c1Var.I()));
        editText.setHintTextColor(x8.h.q(c1Var.I()));
        editText.setTextSize(0, x8.h.r(c1Var.I()));
        x8.g.d(editText);
    }

    public static /* synthetic */ boolean m3(c1 c1Var, TextView textView, int i10, KeyEvent keyEvent) throws JSONException {
        if (i10 == 6) {
            c1Var.t3(false);
            return true;
        }
        c1Var.getClass();
        return false;
    }

    public static /* synthetic */ boolean n3(c1 c1Var, View view, int i10, KeyEvent keyEvent) throws JSONException {
        c1Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            c1Var.t3(false);
        }
        return true;
    }

    public static /* synthetic */ void o3(c1 c1Var, ja.c cVar) {
        c1Var.f6491q0 = cVar;
        c1Var.f6492r0.setText(cVar.g());
        c1Var.f6493s0.setText(cVar.a());
        String strM = g6.p.m((String) c1Var.f6497w0.get(Integer.valueOf(cVar.d())));
        c1Var.f6494t0.setText(strM);
        c1Var.f6495u0 = z8.v0.d(cVar.g(), cVar.a(), strM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3() {
        super.V2();
    }

    private boolean r3() {
        String strTrim = g6.p.l(this.f6492r0.getText().toString()).trim();
        String strTrim2 = this.f6490p0 < 0 ? null : this.f6493s0.getText().toString().trim();
        if (strTrim2 != null && !strTrim2.isEmpty() && strTrim2.indexOf(58) < 0) {
            strTrim2 = i6.i0.f7006a.v(strTrim2, null);
        }
        String strD = z8.v0.d(strTrim, strTrim2, tb.c.e(this.f6494t0.getText().toString()));
        return (this.f6495u0 == null && strD.isEmpty()) || strD.equals(this.f6495u0);
    }

    public static Bundle s3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(boolean z10) throws JSONException {
        String strTrim = g6.p.l(this.f6492r0.getText().toString()).trim();
        String strTrim2 = this.f6490p0 < 0 ? null : this.f6493s0.getText().toString().trim();
        if (strTrim2 != null && !strTrim2.isEmpty() && strTrim2.indexOf(58) < 0) {
            strTrim2 = i6.i0.f7006a.v(strTrim2, null);
        }
        if (r3()) {
            p3();
            return;
        }
        if (z10) {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: hb.y0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) throws JSONException {
                    this.f6834a.t3(false);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: hb.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6855a.p3();
                }
            }).f0();
            return;
        }
        final String strE = tb.c.e(this.f6494t0.getText().toString());
        if (!tb.c.d(strE)) {
            g6.y.X(this.f6494t0);
            g6.n.q(I(), x7.u.f13955dc);
            return;
        }
        if (tb.c.c(this.f6497w0, this.f6490p0, strE)) {
            g6.y.X(this.f6494t0);
            g6.n.q(I(), x7.u.f13941cc);
            return;
        }
        int i10 = this.f6490p0;
        if (i10 < 0) {
            u3(i10, strE);
            return;
        }
        if (strTrim.isEmpty()) {
            g6.n.q(I(), x7.u.Of);
            return;
        }
        if (strTrim2 == null || strTrim2.isEmpty()) {
            g6.n.s(I(), a1(x7.u.f14020i7, this.f6493s0.getHint()));
            return;
        }
        if (strTrim2.length() >= 10) {
            String lowerCase = strTrim2.toLowerCase(Locale.ROOT);
            if (lowerCase.contains("via.search") || lowerCase.contains("v://search") || lowerCase.contains("via://search")) {
                g6.n.q(I(), x7.u.ph);
                return;
            }
        }
        this.f6491q0.u(strTrim);
        this.f6491q0.o(strTrim2);
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c1.k3(this.f6462e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.b1
            @Override // a7.e
            public final void accept(Object obj) throws JSONException {
                c1.f3(this.f6476e, strE, (Boolean) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        EditText editText = this.f6494t0;
        z8.f.e((editText == null || !editText.hasFocus()) ? this.f6493s0 : this.f6494t0);
        super.O1();
    }

    @Override // o8.h
    public void V2() throws JSONException {
        t3(true);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6489o0 = pa.r.f();
        w9.l lVarJ = pa.r.j();
        this.f6496v0 = lVarJ;
        this.f6497w0 = tb.c.f(lVarJ);
        this.f6491q0 = new ja.c();
        this.f6493s0.setOnKeyListener(new View.OnKeyListener() { // from class: hb.p0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return c1.n3(this.f6701a, view2, i10, keyEvent);
            }
        });
        this.f6494t0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: hb.q0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return c1.m3(this.f6715a, textView, i10, keyEvent);
            }
        });
        ((autodispose2.m) x6.f.h(new Callable() { // from class: hb.r0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                c1 c1Var = this.f6727e;
                return c1Var.q3(c1Var.f6490p0);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: hb.s0
            @Override // a7.e
            public final void accept(Object obj) {
                c1.o3(this.f6738e, (ja.c) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -1)).Q(g6.y.h(I(), 12.0f)).M(g6.y.h(I(), 16.0f)).V(new a.InterfaceC0076a() { // from class: hb.o0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new h6.a(new mark.via.common.widget.l1(I()), new LinearLayout.LayoutParams(-1, -2)).s(g6.y.h(I(), 12.0f)).S(g6.y.h(I(), 8.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: hb.t0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c1.e3(this.f6752a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f6492r0 = l1Var.getEditText();
        this.f6493s0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 8.0f)).M(0).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: hb.u0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c1.g3(this.f6773a, (EditText) obj);
            }
        }).l();
        this.f6494t0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).A(g6.y.h(I(), 12.0f)).S(g6.y.h(I(), 8.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: hb.v0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c1.l3(this.f6787a, (EditText) obj);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-1, -2)).A(g6.y.h(I(), 6.0f)).V(new a.InterfaceC0076a() { // from class: hb.w0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c1.h3(this.f6803a, (TextView) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f6493s0);
        linearLayout.addView(this.f6494t0);
        linearLayout.addView(textView);
        if (this.f6490p0 < 0) {
            this.f6492r0.setEnabled(false);
            this.f6492r0.setTextColor(x8.h.q(I()));
            this.f6493s0.setVisibility(8);
            this.f6494t0.setImeOptions(6);
        }
        return linearLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, this.f6490p0 != 0 ? x7.u.D : x7.u.N);
        zVar.c(new z.b(1, 1, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: hb.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                this.f6823a.t3(false);
            }
        });
    }

    @Override // o8.h
    public boolean l() {
        return r3();
    }

    public final ja.c q3(int i10) {
        if (i10 > 0) {
            return this.f6489o0.z().d(i10);
        }
        if (i10 >= 0) {
            return null;
        }
        for (ja.c cVar : z8.v2.b(I())) {
            if (cVar.d() == i10) {
                return cVar;
            }
        }
        return null;
    }

    public final void u3(int i10, String str) throws JSONException {
        this.f6497w0.put(Integer.valueOf(i10), str);
        tb.c.g(this.f6496v0, this.f6497w0);
        Bundle bundle = new Bundle();
        bundle.putInt("engine_result", i10);
        N0().x1("engine_result", bundle);
        p3();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (y0() == null) {
            return;
        }
        this.f6490p0 = y0().getInt(Name.MARK, 0);
    }
}
