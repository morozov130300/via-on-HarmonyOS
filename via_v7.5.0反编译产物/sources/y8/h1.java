package y8;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.widget.l1;
import org.simpleframework.xml.strategy.Name;
import x8.c4;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h1 extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public n9.o f14967r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public n9.q f14968s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f14969t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f14970u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f14971v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f14972w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public RecyclerView f14973x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public t5.f f14974y0;

    public static /* synthetic */ Boolean b3(h1 h1Var) {
        if (h1Var.f14968s0.d() != null) {
            h1Var.f14968s0.s(System.currentTimeMillis());
            return Boolean.valueOf(h1Var.f14967r0.r(h1Var.f14968s0.d(), h1Var.f14968s0));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        h1Var.f14968s0.s(jCurrentTimeMillis);
        h1Var.f14968s0.m(jCurrentTimeMillis);
        h1Var.f14968s0.o(UUID.randomUUID().toString());
        if (h1Var.f14967r0.c(h1Var.f14968s0)) {
            return Boolean.TRUE;
        }
        h1Var.f14968s0.o(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void d3(h1 h1Var, EditText editText) {
        h1Var.getClass();
        v8.g.h(editText);
        editText.setInputType(655361);
        editText.setLines(7);
        editText.setMaxLines(7);
        editText.setMinLines(7);
        editText.setTextSize(0, v8.h.q(h1Var.G()));
        editText.setHint(w7.u.J2);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        r3.p(editText, false);
    }

    public static /* synthetic */ void e3(h1 h1Var) {
        r3.k(h1Var.f14969t0);
        r3.k(h1Var.f14970u0);
        r3.d(h1Var.f14973x0);
    }

    public static /* synthetic */ void g3(h1 h1Var, Boolean bool) {
        h1Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("sug_result", h1Var.f14968s0.d());
        h1Var.L0().y1("sug_result", bundle);
        h1Var.n3();
    }

    public static /* synthetic */ void i3(h1 h1Var, View view, int i10, a9.h0 h0Var) {
        h1Var.getClass();
        com.tuyafeng.support.utils.n.a(h1Var.G(), h0Var.b(), w7.u.Eg);
    }

    public static /* synthetic */ void j3(h1 h1Var, s5.a aVar) {
        h1Var.getClass();
        if (aVar.d()) {
            h1Var.f14968s0 = (n9.q) aVar.b();
            h1Var.f14969t0.setText(((n9.q) aVar.b()).e());
            h1Var.f14970u0.setText(((n9.q) aVar.b()).a());
            h1Var.f14971v0 = x8.v0.d(((n9.q) aVar.b()).e(), ((n9.q) aVar.b()).a());
            h1Var.f14972w0.setTitle(h1Var.X0(w7.u.E));
        } else {
            n9.q qVarK = n9.q.k("", "");
            h1Var.f14968s0 = qVarK;
            qVarK.o(null);
        }
        h1Var.s3(h1Var.f14968s0.g());
    }

    public static /* synthetic */ void l3(h1 h1Var, l1 l1Var) {
        h1Var.getClass();
        EditText editText = l1Var.getEditText();
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setTextSize(0, v8.h.q(h1Var.G()));
        editText.setHint(w7.u.f14292x6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        super.T2();
    }

    private boolean o3() {
        String strD = x8.v0.d(com.tuyafeng.support.utils.p.l(this.f14969t0.getText().toString()).trim(), c4.h(this.f14970u0.getText().toString()));
        return (this.f14971v0 == null && strD.isEmpty()) || strD.equals(this.f14971v0);
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
        String strTrim = com.tuyafeng.support.utils.p.l(this.f14969t0.getText().toString()).trim();
        String strH = c4.h(this.f14970u0.getText().toString());
        if (o3()) {
            n3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: y8.g1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f14964a.r3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: y8.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f15031a.n3();
                }
            }).h0();
            return;
        }
        if (strTrim.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(this.f14969t0);
            com.tuyafeng.support.utils.n.i(this.f14969t0);
            return;
        }
        if (strH.isEmpty()) {
            com.tuyafeng.support.utils.x.Y(this.f14970u0);
            com.tuyafeng.support.utils.n.i(this.f14970u0);
            return;
        }
        this.f14968s0.p(strTrim);
        this.f14968s0.l(strH);
        n9.q qVar = this.f14968s0;
        qVar.q(n9.s.i(strH, qVar.g()));
        n9.q qVar2 = this.f14968s0;
        qVar2.n(n9.s.g(qVar2.f()));
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h1.b3(this.f15033c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.x0
            @Override // u6.f
            public final void accept(Object obj) {
                h1.g3(this.f15036c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f14970u0);
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        r3(true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14967r0 = la.s.e();
        this.f14973x0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f14973x0.setLayoutManager(new LinearLayoutManager(G()));
        this.f14974y0 = new t5.f(Collections.EMPTY_LIST);
        a9.l0 l0Var = new a9.l0();
        l0Var.j(new t5.g() { // from class: y8.c1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                h1.i3(this.f14947a, view2, i10, (a9.h0) obj);
            }
        });
        this.f14974y0.K(a9.h0.class, l0Var);
        this.f14974y0.K(v5.l.class, new v5.m());
        this.f14973x0.setAdapter(this.f14974y0);
        final String string = w0() == null ? null : w0().getString(Name.MARK);
        if (string != null) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.d1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return s5.a.f(this.f14950c.f14967r0.w(string));
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.e1
                @Override // u6.f
                public final void accept(Object obj) {
                    h1.j3(this.f14954c, (s5.a) obj);
                }
            }, new w7.a0());
            return;
        }
        n9.q qVarK = (w0() == null ? 1 : w0().getInt("type", 1)) == 1 ? n9.q.k("", "") : n9.q.j("", "");
        this.f14968s0 = qVarK;
        qVarK.o(null);
        s3(this.f14968s0.g());
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).V(new b6.a.InterfaceC0033a() { // from class: y8.u0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        l1 l1Var = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(-1, -2)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: y8.y0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h1.l3(this.f15038a, (l1) obj);
            }
        }).l();
        this.f14969t0 = l1Var.getEditText();
        this.f14970u0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 8.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13792g)).V(new b6.a.InterfaceC0033a() { // from class: y8.z0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h1.d3(this.f15043a, (EditText) obj);
            }
        }).l();
        this.f14973x0 = (RecyclerView) new b6.a(new RecyclerView(G()), new LinearLayout.LayoutParams(-1, -2)).B(1, 18).V(new b6.a.InterfaceC0033a() { // from class: y8.a1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r3.e((RecyclerView) obj);
            }
        }).l();
        linearLayout.addView(l1Var);
        linearLayout.addView(this.f14970u0);
        linearLayout.addView(this.f14973x0);
        X2(new Runnable() { // from class: y8.b1
            @Override // java.lang.Runnable
            public final void run() {
                h1.e3(this.f14944c);
            }
        });
        return linearLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.O);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, null, X0(w7.u.f13967a0)), new View.OnClickListener() { // from class: y8.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14960a.r3(false);
            }
        });
        this.f14972w0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        return o3();
    }

    public final void s3(int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.l(X0(w7.u.f14178p1)));
        if (i10 == 1) {
            arrayList.add(new a9.h0("{{webpage_url}}", X0(w7.u.ei)));
            arrayList.add(new a9.h0("{{webpage_title}}", X0(w7.u.di)));
            arrayList.add(new a9.h0("{{webpage_content}}", X0(w7.u.ci)));
        } else {
            arrayList.add(new a9.h0("{{input}}", X0(w7.u.ai)));
        }
        arrayList.add(new a9.h0("{{time}}", X0(w7.u.bi)));
        this.f14974y0.M(arrayList);
        this.f14974y0.l();
    }
}
