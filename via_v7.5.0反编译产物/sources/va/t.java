package va;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import c6.a2;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.widget.l1;
import org.simpleframework.xml.strategy.Name;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends m8.g {
    public final wa.a A0 = new wa.r(this);
    public boolean B0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t9.g f13515r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public EditText f13516s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f13517t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f13518u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f13519v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f13520w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f13521x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public LinearLayout f13522y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public t9.f f13523z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            t.this.u3(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends wa.s {
        public b(Context context) {
            super(context);
        }

        @Override // wa.s, wa.b
        public void onCancel() {
            t.this.q3();
        }

        @Override // wa.b
        public void onSuccess() {
            t.this.f13522y0.setVisibility(0);
        }
    }

    public static /* synthetic */ void b3(t tVar) {
        r3.k(tVar.f13516s0);
        r3.k(tVar.f13517t0);
        r3.k(tVar.f13518u0);
        r3.k(tVar.f13519v0);
        com.tuyafeng.support.utils.x.S(tVar.f13518u0);
    }

    public static /* synthetic */ Boolean d3(t tVar) {
        if (tVar.f13523z0.b() != null) {
            tVar.f13523z0.n(System.currentTimeMillis());
            return Boolean.valueOf(tVar.f13515r0.k(tVar.f13523z0.b(), tVar.f13523z0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        tVar.f13523z0.j(UUID.randomUUID().toString().toLowerCase(Locale.ROOT));
        tVar.f13523z0.n(jCurrentTimeMillis);
        tVar.f13523z0.i(jCurrentTimeMillis);
        if (tVar.f13515r0.b(tVar.f13523z0)) {
            return Boolean.TRUE;
        }
        tVar.f13523z0.j(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void e3(t tVar, l1 l1Var) {
        tVar.getClass();
        EditText editText = l1Var.getEditText();
        v8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(w7.u.f14318z6);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(tVar.G()));
    }

    public static /* synthetic */ void f3(t tVar, EditText editText) {
        tVar.getClass();
        v8.g.h(editText);
        editText.setLines(1);
        editText.setMinLines(1);
        editText.setMaxLines(1);
        editText.setImeOptions(5);
        editText.setInputType(129);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setAutofillHints(new String[]{"password"});
        }
        editText.setHint(w7.u.f14266v6);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(tVar.G()));
    }

    public static /* synthetic */ void g3(t tVar, l1 l1Var) {
        tVar.getClass();
        EditText editText = l1Var.getEditText();
        v8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(w7.u.f14305y6);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(tVar.G()));
    }

    public static /* synthetic */ t9.f i3(t tVar, String str) {
        t9.f fVarF = tVar.f13515r0.f(str);
        return fVarF == null ? new t9.f() : fVarF;
    }

    public static /* synthetic */ void j3(t tVar, EditText editText) {
        tVar.getClass();
        v8.g.h(editText);
        editText.setInputType(655361);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextSize(0, v8.h.q(tVar.G()));
        editText.setHint(tVar.X0(w7.u.f14074h9));
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        r3.p(editText, false);
        v8.g.d(editText);
    }

    public static /* synthetic */ void k3(t tVar, t9.f fVar) {
        tVar.f13523z0 = fVar;
        if (fVar.b() != null) {
            tVar.f13520w0.setTitle(tVar.X0(w7.u.E));
        }
        tVar.f13516s0.setText(fVar.c());
        tVar.f13517t0.setText(fVar.h());
        tVar.f13518u0.setText(fVar.e());
        tVar.f13519v0.setText(fVar.d());
        tVar.f13521x0 = x8.v0.d(fVar.c(), fVar.h(), fVar.e(), com.tuyafeng.support.utils.p.m(fVar.d()));
    }

    public static /* synthetic */ void l3(t tVar, String str, View view, q5.k.p pVar) {
        tVar.s3(str);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(tVar.f13518u0, "alpha", 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(1200L);
        objectAnimatorOfFloat.start();
    }

    public static /* synthetic */ void m3(t tVar, Boolean bool) {
        tVar.getClass();
        if (bool.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("result", tVar.f13523z0.b());
            tVar.L0().y1("result", bundle);
            tVar.q3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3() {
        super.T2();
    }

    private boolean r3() {
        String strTrim = this.f13516s0.getText().toString().trim();
        if (strTrim.contains("://")) {
            strTrim = a2.f1958a.f(strTrim);
        }
        String strD = x8.v0.d(c6.b0.f1960a.e(strTrim), this.f13517t0.getText().toString().trim(), this.f13518u0.getText().toString().trim(), this.f13519v0.getText().toString().trim());
        return (this.f13521x0 == null && strD.isEmpty()) || strD.equals(this.f13521x0);
    }

    private void s3(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.i3(this.f13505c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.q
            @Override // u6.f
            public final void accept(Object obj) {
                t.k3(this.f13508c, (t9.f) obj);
            }
        }, new w7.e0());
    }

    public static Bundle t3(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(boolean z10) {
        String strTrim = this.f13516s0.getText().toString().trim();
        if (strTrim.contains("://")) {
            strTrim = a2.f1958a.f(strTrim);
        }
        String strE = c6.b0.f1960a.e(strTrim);
        String strTrim2 = this.f13517t0.getText().toString().trim();
        String strTrim3 = this.f13518u0.getText().toString().trim();
        String strTrim4 = this.f13519v0.getText().toString().trim();
        x8.v0.d(strE, strTrim2, strTrim3, strTrim4);
        if (r3()) {
            q3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: va.r
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f13510a.u3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: va.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13513a.q3();
                }
            }).h0();
            return;
        }
        if (strE.isEmpty()) {
            com.tuyafeng.support.utils.n.j(this.f13516s0, true);
            return;
        }
        if (strTrim2.isEmpty()) {
            com.tuyafeng.support.utils.n.j(this.f13517t0, true);
            return;
        }
        if (strTrim3.isEmpty()) {
            com.tuyafeng.support.utils.n.j(this.f13518u0, true);
            return;
        }
        final String strM = this.f13515r0.m(strE, strTrim2);
        if (strM != null && !strM.equals(this.f13523z0.b())) {
            q5.k.l(G()).f0(w7.u.f14201qa).K(Y0(w7.u.f14215ra, strE)).X(R.string.ok, new q5.k.m() { // from class: va.h
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    t.l3(this.f13486a, strM, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        this.f13523z0.k(strE);
        this.f13523z0.p(strTrim2);
        this.f13523z0.m(strTrim3);
        this.f13523z0.l(strTrim4);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.d3(this.f13490c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.j
            @Override // u6.f
            public final void accept(Object obj) {
                t.m3(this.f13493c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f13519v0);
        super.M1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        i0().getWindow().setFlags(8192, 8192);
        if (this.B0) {
            this.f13522y0.setVisibility(8);
            this.A0.a(X0(w7.u.pi), X0(w7.u.zh), new b(G()));
        }
    }

    @Override // m8.g
    public void T2() {
        u3(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void U1() {
        i0().getWindow().clearFlags(8192);
        this.B0 = true;
        super.U1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f13515r0 = la.s.i();
        v8.g.f(view);
        this.f13523z0 = new t9.f();
        String string = w0() == null ? null : w0().getString(Name.MARK);
        if (string == null || string.isEmpty()) {
            return;
        }
        s3(string);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f13522y0 = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).V(new b6.a.InterfaceC0033a() { // from class: va.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        l1 l1Var = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: va.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.g3(this.f13495a, (l1) obj);
            }
        }).l();
        this.f13516s0 = l1Var.getEditText();
        l1 l1Var2 = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: va.l
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.e3(this.f13497a, (l1) obj);
            }
        }).l();
        this.f13517t0 = l1Var2.getEditText();
        this.f13518u0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: va.m
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.f3(this.f13499a, (EditText) obj);
            }
        }).l();
        this.f13519v0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: va.n
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.j3(this.f13501a, (EditText) obj);
            }
        }).l();
        this.f13522y0.addView(l1Var);
        this.f13522y0.addView(l1Var2);
        this.f13522y0.addView(this.f13518u0);
        this.f13522y0.addView(this.f13519v0);
        X2(new Runnable() { // from class: va.o
            @Override // java.lang.Runnable
            public final void run() {
                t.b3(this.f13503c);
            }
        });
        return this.f13522y0;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        v3.a(e0Var, w7.u.O);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.f13967a0)), new a());
        this.f13520w0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        return r3();
    }
}
