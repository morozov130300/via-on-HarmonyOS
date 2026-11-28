package hb;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y1 extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public w9.a f6152r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f6153s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ga.c f6154t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f6155u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f6156v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f6157w0;

    public static /* synthetic */ void b3(y1 y1Var, mark.via.common.widget.l1 l1Var) {
        y1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextSize(0, v8.h.q(y1Var.G()));
        editText.setHint(w7.u.f14292x6);
        v8.g.d(editText);
    }

    public static /* synthetic */ void c3(y1 y1Var, ga.c cVar) {
        y1Var.f6154t0 = cVar;
        y1Var.f6155u0.setText(cVar.g());
        y1Var.f6156v0.setText(cVar.a());
        y1Var.f6157w0 = x8.v0.d(cVar.g(), cVar.a());
    }

    public static /* synthetic */ Boolean e3(y1 y1Var) {
        if (y1Var.f6154t0.d() > 0) {
            w9.d.d().b(y1Var.f6154t0.d());
            y1Var.f6154t0.s(System.currentTimeMillis());
            return Boolean.valueOf(y1Var.f6152r0.z().f(y1Var.f6154t0.d(), y1Var.f6154t0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        y1Var.f6154t0.s(jCurrentTimeMillis);
        y1Var.f6154t0.p(jCurrentTimeMillis);
        y1Var.f6154t0.v(1);
        int iD = y1Var.f6152r0.z().d(y1Var.f6154t0);
        y1Var.f6154t0.r(iD);
        return Boolean.valueOf(iD > 0);
    }

    public static /* synthetic */ void f3(y1 y1Var, EditText editText) {
        y1Var.getClass();
        v8.g.h(editText);
        editText.setImeOptions(6);
        editText.setInputType(524289);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextSize(0, v8.h.q(y1Var.G()));
        editText.setHint(w7.u.F0);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        x8.r3.p(editText, false);
        v8.g.d(editText);
    }

    public static /* synthetic */ void g3(y1 y1Var, Boolean bool) {
        y1Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt("ua_result", y1Var.f6154t0.d());
        y1Var.L0().y1("ua_result", bundle);
        y1Var.n3();
    }

    public static /* synthetic */ boolean i3(y1 y1Var, View view, int i10, KeyEvent keyEvent) {
        y1Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            y1Var.q3(false);
        }
        return true;
    }

    public static /* synthetic */ boolean k3(Integer num) {
        return num.intValue() > 0;
    }

    public static /* synthetic */ void l3(y1 y1Var) {
        x8.r3.k(y1Var.f6155u0);
        x8.r3.k(y1Var.f6156v0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        super.T2();
    }

    private boolean o3() {
        String strD = x8.v0.d(com.tuyafeng.support.utils.p.l(this.f6155u0.getText().toString()).trim(), x8.c4.h(this.f6156v0.getText().toString()));
        return (this.f6157w0 == null && strD.isEmpty()) || strD.equals(this.f6157w0);
    }

    public static Bundle p3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3(boolean z10) {
        String strTrim = com.tuyafeng.support.utils.p.l(this.f6155u0.getText().toString()).trim();
        String strH = x8.c4.h(this.f6156v0.getText().toString());
        x8.v0.d(strTrim, strH);
        if (o3()) {
            n3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: hb.l1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f5945a.q3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: hb.p1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6020a.n3();
                }
            }).h0();
            return;
        }
        if (strTrim.isEmpty()) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.eg);
        } else {
            if (strH.isEmpty()) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.Qh);
                return;
            }
            this.f6154t0.u(strTrim);
            this.f6154t0.o(strH);
            ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.q1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return y1.e3(this.f6030c);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.r1
                @Override // u6.f
                public final void accept(Object obj) {
                    y1.g3(this.f6046c, (Boolean) obj);
                }
            }, new w7.a0());
        }
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f6156v0);
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        q3(true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6152r0 = la.s.f();
        this.f6154t0 = new ga.c();
        this.f6156v0.setOnKeyListener(new View.OnKeyListener() { // from class: hb.x1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return y1.i3(this.f6138a, view2, i10, keyEvent);
            }
        });
        ((autodispose2.m) r6.f.i(Integer.valueOf(this.f6153s0)).e(new u6.i() { // from class: hb.m1
            @Override // u6.i
            public final boolean test(Object obj) {
                return y1.k3((Integer) obj);
            }
        }).j(new u6.g() { // from class: hb.n1
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f5984a.f6152r0.z().c(((Integer) obj).intValue());
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: hb.o1
            @Override // u6.f
            public final void accept(Object obj) {
                y1.c3(this.f5997c, (ga.c) obj);
            }
        }, new w7.a0());
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: hb.s1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        mark.via.common.widget.l1 l1Var = (mark.via.common.widget.l1) new b6.a(new mark.via.common.widget.l1(G()), new LinearLayout.LayoutParams(-1, -2)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: hb.t1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y1.b3(this.f6069a, (mark.via.common.widget.l1) obj);
            }
        }).l();
        this.f6155u0 = l1Var.getEditText();
        this.f6156v0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).M(0).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: hb.u1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y1.f3(this.f6087a, (EditText) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f6156v0);
        X2(new Runnable() { // from class: hb.v1
            @Override // java.lang.Runnable
            public final void run() {
                y1.l3(this.f6098c);
            }
        });
        return linearLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, this.f6153s0 > 0 ? w7.u.E : w7.u.O);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: hb.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6116a.q3(false);
            }
        });
    }

    @Override // m8.g
    public boolean l() {
        return o3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (w0() == null) {
            return;
        }
        this.f6153s0 = w0().getInt(Name.MARK, 0);
    }
}
