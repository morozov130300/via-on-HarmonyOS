package hb;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v1 extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public y9.a f6788o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f6789p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    public ja.c f6790q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f6791r0;

    /* renamed from: s0, reason: collision with root package name */
    public EditText f6792s0;

    /* renamed from: t0, reason: collision with root package name */
    public String f6793t0;

    public static /* synthetic */ void c3(v1 v1Var, mark.via.common.widget.l1 l1Var) {
        v1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextColor(g6.e.a(v1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(v1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(v1Var.I()));
        editText.setHint(x7.u.f14061l6);
        x8.g.d(editText);
    }

    public static /* synthetic */ void f3(v1 v1Var, EditText editText) {
        v1Var.getClass();
        x8.g.h(editText);
        editText.setImeOptions(6);
        editText.setInputType(524289);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextColor(g6.e.a(v1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(v1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(v1Var.I()));
        editText.setHint(x7.u.C0);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        z8.r3.o(editText, false);
        x8.g.d(editText);
    }

    public static /* synthetic */ void g3(v1 v1Var, ja.c cVar) {
        v1Var.f6790q0 = cVar;
        v1Var.f6791r0.setText(cVar.g());
        v1Var.f6792s0.setText(cVar.a());
        v1Var.f6793t0 = z8.v0.d(cVar.g(), cVar.a());
    }

    public static /* synthetic */ boolean h3(Integer num) {
        return num.intValue() > 0;
    }

    public static /* synthetic */ boolean i3(v1 v1Var, View view, int i10, KeyEvent keyEvent) {
        v1Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            v1Var.q3(false);
        }
        return true;
    }

    public static /* synthetic */ void k3(v1 v1Var, Boolean bool) {
        v1Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt("ua_result", v1Var.f6790q0.d());
        v1Var.N0().x1("ua_result", bundle);
        v1Var.n3();
    }

    public static /* synthetic */ Boolean m3(v1 v1Var) {
        if (v1Var.f6790q0.d() > 0) {
            y9.d.c().a(v1Var.f6790q0.d());
            v1Var.f6790q0.s(System.currentTimeMillis());
            return Boolean.valueOf(v1Var.f6788o0.z().b(v1Var.f6790q0.d(), v1Var.f6790q0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        v1Var.f6790q0.s(jCurrentTimeMillis);
        v1Var.f6790q0.p(jCurrentTimeMillis);
        v1Var.f6790q0.v(1);
        int iH = v1Var.f6788o0.z().h(v1Var.f6790q0);
        v1Var.f6790q0.r(iH);
        return Boolean.valueOf(iH > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        super.V2();
    }

    private boolean o3() {
        String strD = z8.v0.d(g6.p.l(this.f6791r0.getText().toString()).trim(), z8.b4.g(this.f6792s0.getText().toString()));
        return (this.f6793t0 == null && strD.isEmpty()) || strD.equals(this.f6793t0);
    }

    public static Bundle p3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3(boolean z10) {
        String strTrim = g6.p.l(this.f6791r0.getText().toString()).trim();
        String strG = z8.b4.g(this.f6792s0.getText().toString());
        z8.v0.d(strTrim, strG);
        if (o3()) {
            n3();
            return;
        }
        if (z10) {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: hb.j1
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f6605a.q3(false);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: hb.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6654a.n3();
                }
            }).f0();
            return;
        }
        if (strTrim.isEmpty()) {
            g6.n.q(I(), x7.u.Of);
        } else {
            if (strG.isEmpty()) {
                g6.n.q(I(), x7.u.rh);
                return;
            }
            this.f6790q0.u(strTrim);
            this.f6790q0.o(strG);
            ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.n1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return v1.m3(this.f6670e);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.o1
                @Override // a7.e
                public final void accept(Object obj) {
                    v1.k3(this.f6685e, (Boolean) obj);
                }
            }, new x7.c0());
        }
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f6792s0);
        super.O1();
    }

    @Override // o8.h
    public void V2() {
        q3(true);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6788o0 = pa.r.f();
        this.f6790q0 = new ja.c();
        this.f6792s0.setOnKeyListener(new View.OnKeyListener() { // from class: hb.t1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return v1.i3(this.f6753a, view2, i10, keyEvent);
            }
        });
        ((autodispose2.m) x6.f.i(Integer.valueOf(this.f6789p0)).e(new a7.h() { // from class: hb.u1
            @Override // a7.h
            public final boolean test(Object obj) {
                return v1.h3((Integer) obj);
            }
        }).j(new a7.f() { // from class: hb.k1
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f6624a.f6788o0.z().d(((Integer) obj).intValue());
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: hb.l1
            @Override // a7.e
            public final void accept(Object obj) {
                v1.g3(this.f6633e, (ja.c) obj);
            }
        }, new x7.c0());
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -1)).Q(g6.y.h(I(), 12.0f)).M(g6.y.h(I(), 16.0f)).V(new a.InterfaceC0076a() { // from class: hb.p1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new h6.a(new mark.via.common.widget.l1(I()), new LinearLayout.LayoutParams(-1, -2)).s(g6.y.h(I(), 12.0f)).S(g6.y.h(I(), 8.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: hb.q1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v1.c3(this.f6716a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f6791r0 = l1Var.getEditText();
        this.f6792s0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 8.0f)).M(0).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: hb.r1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v1.f3(this.f6728a, (EditText) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f6792s0);
        return linearLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, this.f6789p0 > 0 ? x7.u.D : x7.u.N);
        zVar.c(new z.b(1, 1, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: hb.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6739a.q3(false);
            }
        });
    }

    @Override // o8.h
    public boolean l() {
        return o3();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (y0() == null) {
            return;
        }
        this.f6789p0 = y0().getInt(Name.MARK, 0);
    }
}
