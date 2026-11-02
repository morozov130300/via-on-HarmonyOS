package a9;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.widget.l1;
import org.simpleframework.xml.strategy.Name;
import w5.k;
import z8.b4;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f1 extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public p9.o f300o0;

    /* renamed from: p0, reason: collision with root package name */
    public p9.q f301p0;

    /* renamed from: q0, reason: collision with root package name */
    public EditText f302q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f303r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f304s0;

    /* renamed from: t0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f305t0;

    /* renamed from: u0, reason: collision with root package name */
    public RecyclerView f306u0;

    /* renamed from: v0, reason: collision with root package name */
    public y5.f f307v0;

    public static /* synthetic */ void b3(f1 f1Var, x5.a aVar) {
        f1Var.getClass();
        if (aVar.d()) {
            f1Var.f301p0 = (p9.q) aVar.b();
            f1Var.f302q0.setText(((p9.q) aVar.b()).e());
            f1Var.f303r0.setText(((p9.q) aVar.b()).a());
            f1Var.f304s0 = z8.v0.d(((p9.q) aVar.b()).e(), ((p9.q) aVar.b()).a());
            f1Var.f305t0.setTitle(f1Var.Z0(x7.u.D));
        } else {
            p9.q qVarK = p9.q.k("", "");
            f1Var.f301p0 = qVarK;
            qVarK.o(null);
        }
        f1Var.s3(f1Var.f301p0.g());
    }

    public static /* synthetic */ Boolean d3(f1 f1Var) {
        if (f1Var.f301p0.d() != null) {
            f1Var.f301p0.s(System.currentTimeMillis());
            return Boolean.valueOf(f1Var.f300o0.s(f1Var.f301p0.d(), f1Var.f301p0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f1Var.f301p0.s(jCurrentTimeMillis);
        f1Var.f301p0.m(jCurrentTimeMillis);
        f1Var.f301p0.o(UUID.randomUUID().toString());
        if (f1Var.f300o0.t(f1Var.f301p0)) {
            return Boolean.TRUE;
        }
        f1Var.f301p0.o(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void g3(f1 f1Var, EditText editText) {
        f1Var.getClass();
        x8.g.h(editText);
        editText.setInputType(655361);
        editText.setLines(7);
        editText.setMaxLines(7);
        editText.setMinLines(7);
        editText.setTextColor(g6.e.a(f1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(f1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(f1Var.I()));
        editText.setHint(x7.u.f14218x2);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        r3.o(editText, false);
    }

    public static /* synthetic */ void j3(f1 f1Var, View view, int i10, c9.h0 h0Var) {
        f1Var.getClass();
        g6.n.a(f1Var.I(), h0Var.b(), x7.u.og);
    }

    public static /* synthetic */ void k3(f1 f1Var, l1 l1Var) {
        f1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextColor(g6.e.a(f1Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(f1Var.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(f1Var.I()));
        editText.setHint(x7.u.f14061l6);
    }

    public static /* synthetic */ void l3(f1 f1Var, Boolean bool) {
        f1Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("sug_result", f1Var.f301p0.d());
        f1Var.N0().x1("sug_result", bundle);
        f1Var.n3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        super.V2();
    }

    private boolean o3() {
        String strD = z8.v0.d(g6.p.l(this.f302q0.getText().toString()).trim(), b4.g(this.f303r0.getText().toString()));
        return (this.f304s0 == null && strD.isEmpty()) || strD.equals(this.f304s0);
    }

    public static Bundle p3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        return bundle;
    }

    public static Bundle q3(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(boolean z10) {
        String strTrim = g6.p.l(this.f302q0.getText().toString()).trim();
        String strG = b4.g(this.f303r0.getText().toString());
        if (o3()) {
            n3();
            return;
        }
        if (z10) {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: a9.d1
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f292a.r3(false);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: a9.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f295a.n3();
                }
            }).f0();
            return;
        }
        if (strTrim.isEmpty()) {
            g6.y.X(this.f302q0);
            g6.n.i(this.f302q0);
            return;
        }
        if (strG.isEmpty()) {
            g6.y.X(this.f303r0);
            g6.n.i(this.f303r0);
            return;
        }
        this.f301p0.p(strTrim);
        this.f301p0.l(strG);
        p9.q qVar = this.f301p0;
        qVar.q(p9.s.i(strG, qVar.g()));
        p9.q qVar2 = this.f301p0;
        qVar2.n(p9.s.g(qVar2.f()));
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.u0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f1.d3(this.f369e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.v0
            @Override // a7.e
            public final void accept(Object obj) {
                f1.l3(this.f371e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f303r0);
        super.O1();
    }

    @Override // o8.h
    public void V2() {
        r3(true);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f300o0 = pa.r.e();
        this.f306u0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f306u0.setLayoutManager(new LinearLayoutManager(I()));
        this.f307v0 = new y5.f(Collections.EMPTY_LIST);
        c9.l0 l0Var = new c9.l0();
        l0Var.j(new y5.g() { // from class: a9.z0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                f1.j3(this.f382a, view2, i10, (c9.h0) obj);
            }
        });
        this.f307v0.K(c9.h0.class, l0Var);
        this.f307v0.K(a6.l.class, new a6.m());
        this.f306u0.setAdapter(this.f307v0);
        final String string = y0() == null ? null : y0().getString(Name.MARK);
        if (string != null) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.a1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return x5.a.f(this.f283e.f300o0.v(string));
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.b1
                @Override // a7.e
                public final void accept(Object obj) {
                    f1.b3(this.f286e, (x5.a) obj);
                }
            }, new x7.c0());
            return;
        }
        p9.q qVarK = (y0() == null ? 1 : y0().getInt("type", 1)) == 1 ? p9.q.k("", "") : p9.q.j("", "");
        this.f301p0 = qVarK;
        qVarK.o(null);
        s3(this.f301p0.g());
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -1)).Q(g6.y.h(I(), 12.0f)).V(new a.InterfaceC0076a() { // from class: a9.t0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        l1 l1Var = (l1) new h6.a(new l1(I()), new LinearLayout.LayoutParams(-1, -2)).s(g6.y.h(I(), 12.0f)).S(g6.y.h(I(), 8.0f)).w(g6.y.h(I(), 16.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: a9.w0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f1.k3(this.f373a, (l1) obj);
            }
        }).l();
        this.f302q0 = l1Var.getEditText();
        this.f303r0 = (EditText) new h6.a(new EditText(I()), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 8.0f)).w(g6.y.h(I(), 16.0f)).e(g6.f.e(I(), x7.o.f13729h)).V(new a.InterfaceC0076a() { // from class: a9.x0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f1.g3(this.f376a, (EditText) obj);
            }
        }).l();
        this.f306u0 = (RecyclerView) new h6.a(new RecyclerView(I()), new LinearLayout.LayoutParams(-1, -2)).B(1, 18).V(new a.InterfaceC0076a() { // from class: a9.y0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                r3.d((RecyclerView) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f303r0);
        linearLayout.addView(this.f306u0);
        return linearLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.N);
        zVar.c(new z.b(1, 1, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: a9.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f289a.r3(false);
            }
        });
        this.f305t0 = zVar;
    }

    @Override // o8.h
    public boolean l() {
        return o3();
    }

    public final void s3(int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.l(Z0(x7.u.f14056l1)));
        if (i10 == 1) {
            arrayList.add(new c9.h0("{{webpage_url}}", Z0(x7.u.Eh)));
            arrayList.add(new c9.h0("{{webpage_title}}", Z0(x7.u.Dh)));
            arrayList.add(new c9.h0("{{webpage_content}}", Z0(x7.u.Ch)));
        } else {
            arrayList.add(new c9.h0("{{input}}", Z0(x7.u.Ah)));
        }
        arrayList.add(new c9.h0("{{time}}", Z0(x7.u.Bh)));
        this.f307v0.M(arrayList);
        this.f307v0.l();
    }
}
