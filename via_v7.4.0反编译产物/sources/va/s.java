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
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.widget.l1;
import org.simpleframework.xml.strategy.Name;
import w5.k;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public v9.g f13160o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f13161p0;

    /* renamed from: q0, reason: collision with root package name */
    public EditText f13162q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f13163r0;

    /* renamed from: s0, reason: collision with root package name */
    public EditText f13164s0;

    /* renamed from: t0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f13165t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f13166u0;

    /* renamed from: v0, reason: collision with root package name */
    public LinearLayout f13167v0;

    /* renamed from: w0, reason: collision with root package name */
    public v9.f f13168w0;

    /* renamed from: x0, reason: collision with root package name */
    public final wa.a f13169x0 = new wa.r(this);

    /* renamed from: y0, reason: collision with root package name */
    public boolean f13170y0 = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            s.this.u3(false);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends wa.s {
        public b(Context context) {
            super(context);
        }

        @Override // wa.s, wa.b
        public void onCancel() {
            s.this.q3();
        }

        @Override // wa.b
        public void onSuccess() {
            s.this.f13167v0.setVisibility(0);
        }
    }

    public static /* synthetic */ v9.f c3(s sVar, String str) {
        v9.f fVarF = sVar.f13160o0.f(str);
        return fVarF == null ? new v9.f() : fVarF;
    }

    public static /* synthetic */ Boolean d3(s sVar) {
        if (sVar.f13168w0.b() != null) {
            sVar.f13168w0.n(System.currentTimeMillis());
            return Boolean.valueOf(sVar.f13160o0.b(sVar.f13168w0.b(), sVar.f13168w0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        sVar.f13168w0.j(UUID.randomUUID().toString().toLowerCase(Locale.ROOT));
        sVar.f13168w0.n(jCurrentTimeMillis);
        sVar.f13168w0.i(jCurrentTimeMillis);
        if (sVar.f13160o0.k(sVar.f13168w0)) {
            return Boolean.TRUE;
        }
        sVar.f13168w0.j(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void e3(s sVar, String str, View view, k.p pVar) {
        sVar.s3(str);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(sVar.f13163r0, "alpha", 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(1200L);
        objectAnimatorOfFloat.start();
    }

    public static /* synthetic */ void g3(s sVar, l1 l1Var) {
        sVar.getClass();
        EditText editText = l1Var.getEditText();
        x8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(x7.u.f14089n6);
        editText.setGravity(16);
        r3.j(editText);
        x8.g.m(editText, x8.h.r(sVar.I()));
    }

    public static /* synthetic */ void h3(s sVar, EditText editText) {
        sVar.getClass();
        x8.g.h(editText);
        editText.setLines(1);
        editText.setMinLines(1);
        editText.setMaxLines(1);
        editText.setImeOptions(5);
        editText.setInputType(129);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setAutofillHints(new String[]{"password"});
        }
        editText.setHint(x7.u.f14033j6);
        editText.setGravity(16);
        r3.j(editText);
        x8.g.m(editText, x8.h.r(sVar.I()));
        g6.y.R(editText);
    }

    public static /* synthetic */ void i3(s sVar, l1 l1Var) {
        sVar.getClass();
        EditText editText = l1Var.getEditText();
        x8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(x7.u.f14075m6);
        editText.setGravity(16);
        r3.j(editText);
        x8.g.m(editText, x8.h.r(sVar.I()));
    }

    public static /* synthetic */ void j3(s sVar, EditText editText) {
        sVar.getClass();
        x8.g.h(editText);
        editText.setInputType(655361);
        editText.setLines(5);
        editText.setMaxLines(5);
        editText.setMinLines(5);
        editText.setTextColor(g6.e.a(sVar.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(sVar.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(sVar.I()));
        editText.setHint(sVar.Z0(x7.u.V8));
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        r3.o(editText, false);
        x8.g.d(editText);
    }

    public static /* synthetic */ void k3(s sVar, Boolean bool) {
        sVar.getClass();
        if (bool.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("result", sVar.f13168w0.b());
            sVar.N0().x1("result", bundle);
            sVar.q3();
        }
    }

    public static /* synthetic */ void m3(s sVar, v9.f fVar) {
        sVar.f13168w0 = fVar;
        if (fVar.b() != null) {
            sVar.f13165t0.setTitle(sVar.Z0(x7.u.D));
        }
        sVar.f13161p0.setText(fVar.c());
        sVar.f13162q0.setText(fVar.h());
        sVar.f13163r0.setText(fVar.e());
        sVar.f13164s0.setText(fVar.d());
        sVar.f13166u0 = z8.v0.d(fVar.c(), fVar.h(), fVar.e(), g6.p.m(fVar.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3() {
        super.V2();
    }

    private boolean r3() {
        String strTrim = this.f13161p0.getText().toString().trim();
        if (strTrim.contains("://")) {
            strTrim = i6.i0.f7006a.e(strTrim);
        }
        String strD = z8.v0.d(i6.i.f7005a.b(strTrim), this.f13162q0.getText().toString().trim(), this.f13163r0.getText().toString().trim(), this.f13164s0.getText().toString().trim());
        return (this.f13166u0 == null && strD.isEmpty()) || strD.equals(this.f13166u0);
    }

    private void s3(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: va.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s.c3(this.f13128e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: va.o
            @Override // a7.e
            public final void accept(Object obj) {
                s.m3(this.f13131e, (v9.f) obj);
            }
        }, new x7.g0());
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
        String strTrim = this.f13161p0.getText().toString().trim();
        if (strTrim.contains("://")) {
            strTrim = i6.i0.f7006a.e(strTrim);
        }
        String strB = i6.i.f7005a.b(strTrim);
        String strTrim2 = this.f13162q0.getText().toString().trim();
        String strTrim3 = this.f13163r0.getText().toString().trim();
        String strTrim4 = this.f13164s0.getText().toString().trim();
        z8.v0.d(strB, strTrim2, strTrim3, strTrim4);
        if (r3()) {
            q3();
            return;
        }
        if (z10) {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: va.p
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f13134a.u3(false);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: va.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13136a.q3();
                }
            }).f0();
            return;
        }
        if (strB.isEmpty()) {
            g6.n.j(this.f13161p0, true);
            return;
        }
        if (strTrim2.isEmpty()) {
            g6.n.j(this.f13162q0, true);
            return;
        }
        if (strTrim3.isEmpty()) {
            g6.n.j(this.f13163r0, true);
            return;
        }
        final String strM = this.f13160o0.m(strB, strTrim2);
        if (strM != null && !strM.equals(this.f13168w0.b())) {
            w5.k.l(I()).d0(x7.u.f13967ea).J(a1(x7.u.f13981fa, strB)).V(R.string.ok, new k.m() { // from class: va.r
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    s.e3(this.f13139a, strM, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
            return;
        }
        this.f13168w0.k(strB);
        this.f13168w0.p(strTrim2);
        this.f13168w0.m(strTrim3);
        this.f13168w0.l(strTrim4);
        ((autodispose2.r) x6.o.g(new Callable() { // from class: va.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s.d3(this.f13116e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: va.i
            @Override // a7.e
            public final void accept(Object obj) {
                s.k3(this.f13118e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f13164s0);
        super.O1();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        l0().getWindow().setFlags(8192, 8192);
        if (this.f13170y0) {
            this.f13167v0.setVisibility(8);
            this.f13169x0.a(Z0(x7.u.Kh), Z0(x7.u.ah), new b(I()));
        }
    }

    @Override // o8.h
    public void V2() {
        u3(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void W1() {
        l0().getWindow().clearFlags(8192);
        this.f13170y0 = true;
        super.W1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f13160o0 = pa.r.i();
        x8.g.f(view);
        this.f13168w0 = new v9.f();
        String string = y0() == null ? null : y0().getString(Name.MARK);
        if (string == null || string.isEmpty()) {
            return;
        }
        s3(string);
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f13167v0 = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -1)).Q(g6.y.h(I(), 12.0f)).V(new a.InterfaceC0076a() { // from class: va.g
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        l1 l1Var = (l1) new h6.a(new l1(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 10.0f)).w(g6.y.h(I(), 16.0f)).s(g6.y.h(I(), 12.0f)).d(x7.o.f13729h).V(new a.InterfaceC0076a() { // from class: va.j
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                s.i3(this.f13120a, (l1) obj);
            }
        }).l();
        this.f13161p0 = l1Var.getEditText();
        l1 l1Var2 = (l1) new h6.a(new l1(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 10.0f)).w(g6.y.h(I(), 16.0f)).s(g6.y.h(I(), 12.0f)).d(x7.o.f13729h).V(new a.InterfaceC0076a() { // from class: va.k
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                s.g3(this.f13122a, (l1) obj);
            }
        }).l();
        this.f13162q0 = l1Var2.getEditText();
        this.f13163r0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 10.0f)).w(g6.y.h(I(), 16.0f)).s(g6.y.h(I(), 12.0f)).d(x7.o.f13729h).V(new a.InterfaceC0076a() { // from class: va.l
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                s.h3(this.f13124a, (EditText) obj);
            }
        }).l();
        this.f13164s0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 10.0f)).w(g6.y.h(I(), 16.0f)).s(g6.y.h(I(), 12.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: va.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                s.j3(this.f13126a, (EditText) obj);
            }
        }).l();
        this.f13167v0.addView(l1Var);
        this.f13167v0.addView(l1Var2);
        this.f13167v0.addView(this.f13163r0);
        this.f13167v0.addView(this.f13164s0);
        return this.f13167v0;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        v3.a(zVar, x7.u.N);
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.Z)), new a());
        this.f13165t0 = zVar;
    }

    @Override // o8.h
    public boolean l() {
        return r3();
    }
}
