package y8;

import android.R;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.widget.l1;
import org.simpleframework.xml.strategy.Name;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends m8.g {
    public n9.l A0;
    public String D0;
    public int F0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public n9.o f15007r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f15008s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f15009t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f15010u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f15011v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public TextView f15012w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public EditText f15013x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public RecyclerView f15014y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public t5.f f15015z0;
    public boolean B0 = false;
    public final List C0 = new ArrayList();
    public boolean E0 = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            s0.this.K3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {
        public b() {
        }

        @Override // p5.c
        public void a(View view) {
            s0.this.I3(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends p5.c {
        public c() {
        }

        @Override // p5.c
        public void a(View view) {
            s0.this.H3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements b6.a.InterfaceC0033a {
        public d() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(s0.this.G(), w7.n.f13760m));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            r3.o(textView);
            textView.setText(w7.u.F8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e extends p5.c {
        public e() {
        }

        @Override // p5.c
        public void a(View view) {
            s0.this.C3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements a9.n.c {
        public f() {
        }

        @Override // a9.n.c
        public void a(View view, String str, int i10) {
            s0.this.E0 = true;
            s0.this.C0.remove(i10);
            s0.this.f15015z0.u(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements n9.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15022a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15023b;

        public g(int i10) {
            this.f15023b = i10;
        }

        @Override // n9.h
        public void a(final n9.g gVar) {
            if (this.f15022a) {
                return;
            }
            this.f15022a = true;
            s0.this.f15007r0.C();
            if (this.f15023b == s0.this.F0) {
                x8.h.d(s0.this, new Runnable() { // from class: y8.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        s0.this.J3(gVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3() {
        super.T2();
    }

    private boolean E3() {
        EditText[] editTextArr = {this.f15009t0, this.f15010u0, this.f15011v0, this.f15013x0};
        String[] strArr = new String[4];
        for (int i10 = 0; i10 < 4; i10++) {
            strArr[i10] = editTextArr[i10].getText().toString().trim();
        }
        String strD = x8.v0.d(strArr[0], strArr[1], strArr[2], strArr[3]);
        return ((this.D0 == null && strD.isEmpty()) || strD.equals(this.D0)) && !this.E0;
    }

    public static Bundle G3(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, str);
        return bundle;
    }

    public static /* synthetic */ boolean a3(s0 s0Var, View view, int i10, KeyEvent keyEvent) {
        s0Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            s0Var.C3();
        }
        return true;
    }

    public static /* synthetic */ void c3(s0 s0Var, l1 l1Var) {
        s0Var.getClass();
        EditText editText = l1Var.getEditText();
        v8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(524289);
        editText.setHint(w7.u.f14292x6);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(s0Var.G()));
    }

    public static /* synthetic */ void e3(s0 s0Var, boolean z10, Boolean bool) {
        s0Var.getClass();
        if (bool.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(Name.MARK, s0Var.A0.d());
            s0Var.L0().y1("result", bundle);
            s0Var.D3();
        } else if (z10) {
            s0Var.A0 = null;
        }
        s0Var.B0 = false;
    }

    public static /* synthetic */ void g3(final s0 s0Var, l1 l1Var) {
        s0Var.getClass();
        EditText editText = l1Var.getEditText();
        v8.g.h(editText);
        editText.setImeOptions(2);
        editText.setInputType(524289);
        editText.setHint(w7.u.F8);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(s0Var.G()));
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: y8.i0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return s0.a3(this.f14977a, view, i10, keyEvent);
            }
        });
    }

    public static /* synthetic */ n9.l h3(s0 s0Var, String str) {
        s0Var.getClass();
        n9.l lVarC = n9.s.c(str);
        return lVarC == null ? s0Var.f15007r0.h(str) : lVarC;
    }

    public static /* synthetic */ void i3(s0 s0Var, ImageView imageView) {
        s0Var.getClass();
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13810m, w7.u.ge));
        imageView.setOnClickListener(s0Var.new e());
    }

    public static /* synthetic */ void j3(s0 s0Var, EditText editText) {
        s0Var.getClass();
        v8.g.h(editText);
        editText.setLines(1);
        editText.setMinLines(1);
        editText.setMaxLines(1);
        editText.setImeOptions(5);
        editText.setInputType(129);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setAutofillHints(new String[]{"password"});
        }
        editText.setHint(w7.u.f14024e1);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(s0Var.G()));
    }

    public static /* synthetic */ void k3(s0 s0Var, TextView textView) {
        s0Var.getClass();
        textView.setVisibility(8);
        SpannableString spannableString = new SpannableString(s0Var.X0(w7.u.D9));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
        v8.g.m(textView, v8.h.t(s0Var.G()));
        textView.setOnClickListener(s0Var.new c());
    }

    public static /* synthetic */ void l3(s0 s0Var, n9.l lVar) {
        s0Var.A0 = lVar;
        if (lVar.d() != null) {
            s0Var.f15008s0.setTitle(s0Var.X0(w7.u.E));
        }
        s0Var.f15009t0.setText(lVar.g());
        s0Var.f15010u0.setText(lVar.i());
        String strA = n9.s.a(s0Var.f15010u0.getText().toString());
        s0Var.f15012w0.setVisibility((strA == null || strA.isEmpty()) ? 8 : 0);
        s0Var.f15011v0.setText(lVar.e());
        s0Var.C0.clear();
        s0Var.C0.addAll(lVar.f());
        s0Var.f15015z0.l();
        s0Var.D0 = x8.v0.d(lVar.g(), lVar.i(), com.tuyafeng.support.utils.p.m(lVar.e()), "");
        s0Var.E0 = false;
    }

    public static /* synthetic */ void o3(s0 s0Var, TextView textView, ImageView imageView) {
        r3.k(s0Var.f15009t0);
        r3.k(s0Var.f15010u0);
        r3.k(s0Var.f15011v0);
        r3.k(s0Var.f15013x0);
        com.tuyafeng.support.utils.x.S(s0Var.f15011v0);
        s0Var.f15012w0.setTextColor(v8.h.p(s0Var.G()));
        textView.setTextColor(v8.h.j(s0Var.G()));
        r3.n(imageView);
        r3.d(s0Var.f15014y0);
    }

    public static /* synthetic */ void p3(s0 s0Var, l1 l1Var) {
        s0Var.getClass();
        EditText editText = l1Var.getEditText();
        v8.g.h(editText);
        editText.setImeOptions(5);
        editText.setInputType(16);
        editText.setHint(w7.u.f14305y6);
        editText.setGravity(16);
        v8.g.m(editText, v8.h.q(s0Var.G()));
    }

    public static /* synthetic */ void q3(s0 s0Var, Throwable th) {
        s0Var.getClass();
        tc.a.j(th);
        s0Var.B0 = false;
    }

    public final void C3() {
        String strTrim = this.f15013x0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            return;
        }
        this.f15013x0.setText("");
        if (this.C0.contains(strTrim)) {
            return;
        }
        this.E0 = true;
        int size = this.C0.size();
        this.C0.add(size, strTrim);
        this.f15015z0.o(size);
    }

    public final void F3(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s0.h3(this.f14962c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.h0
            @Override // u6.f
            public final void accept(Object obj) {
                s0.l3(this.f14966c, (n9.l) obj);
            }
        }, new w7.e0());
    }

    public final void H3() {
        String strA = n9.s.a(this.f15010u0.getText().toString());
        if (strA == null || strA.isEmpty()) {
            return;
        }
        x8.z.S(G(), strA);
    }

    public final void I3(boolean z10) {
        if (this.B0) {
            return;
        }
        EditText[] editTextArr = {this.f15009t0, this.f15010u0, this.f15011v0, this.f15013x0};
        String[] strArr = new String[4];
        for (int i10 = 0; i10 < 4; i10++) {
            strArr[i10] = editTextArr[i10].getText().toString().trim();
        }
        if (E3()) {
            D3();
            return;
        }
        if (z10) {
            q5.k.l(G()).f0(w7.u.I3).J(w7.u.G8).X(w7.u.Ib, new q5.k.m() { // from class: y8.a0
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f14942a.I3(false);
                }
            }).P(w7.u.f13972a5, new View.OnClickListener() { // from class: y8.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f14980a.D3();
                }
            }).h0();
            return;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            if (i11 == 3) {
                if (strArr[i11].isEmpty() && this.f15015z0.g() == 0) {
                    com.tuyafeng.support.utils.x.Y(editTextArr[i11]);
                    com.tuyafeng.support.utils.n.i(this.f15013x0);
                    return;
                }
            } else if (strArr[i11].isEmpty()) {
                com.tuyafeng.support.utils.x.Y(editTextArr[i11]);
                com.tuyafeng.support.utils.n.i(editTextArr[i11]);
                return;
            }
        }
        this.B0 = true;
        n9.l lVar = this.A0;
        final boolean z11 = lVar == null || lVar.d() == null;
        final n9.l lVar2 = new n9.l();
        if (z11) {
            lVar2.l(UUID.randomUUID().toString());
            lVar2.j(System.currentTimeMillis());
            this.A0 = lVar2;
        } else {
            lVar2.k(this.A0.c());
            lVar2.j(this.A0.a());
        }
        lVar2.p(strArr[0]);
        String strSubstring = strArr[1];
        if (strSubstring.endsWith("/chat/completions")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 17);
        }
        lVar2.r(strSubstring);
        lVar2.m(strArr[2]);
        List listH = this.f15015z0.H();
        String strTrim = this.f15013x0.getText().toString().trim();
        if (!listH.contains(strTrim)) {
            listH.add(strTrim);
        }
        lVar2.o(listH);
        lVar2.q(System.currentTimeMillis());
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                s0 s0Var = this.f14986c;
                boolean z12 = z11;
                n9.l lVar3 = lVar2;
                return Boolean.valueOf(z12 ? s0Var.f15007r0.e(lVar3) : s0Var.f15007r0.b(s0Var.A0.d(), lVar3));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.l0
            @Override // u6.f
            public final void accept(Object obj) {
                s0.e3(this.f14990c, z11, (Boolean) obj);
            }
        }, new u6.f() { // from class: y8.m0
            @Override // u6.f
            public final void accept(Object obj) {
                s0.q3(this.f14994c, (Throwable) obj);
            }
        });
    }

    public final void J3(n9.g gVar) {
        if (FragmentUtils.e(this)) {
            return;
        }
        if (gVar.h()) {
            q5.k.l(G()).f0(w7.u.Yh).K(n9.s.e(G(), gVar)).X(R.string.ok, null).h0();
        } else {
            q5.k.l(G()).f0(w7.u.Xh).J(w7.u.Zh).X(R.string.ok, null).h0();
        }
    }

    public final void K3() {
        EditText[] editTextArr = {this.f15009t0, this.f15010u0, this.f15011v0};
        String[] strArr = new String[3];
        for (int i10 = 0; i10 < 3; i10++) {
            String strTrim = editTextArr[i10].getText().toString().trim();
            if (strTrim.isEmpty()) {
                com.tuyafeng.support.utils.x.Y(editTextArr[i10]);
                com.tuyafeng.support.utils.n.i(editTextArr[i10]);
                return;
            }
            strArr[i10] = strTrim;
        }
        if (this.f15015z0.g() == 0) {
            com.tuyafeng.support.utils.n.i(this.f15013x0);
            return;
        }
        n9.l lVar = new n9.l();
        lVar.l(UUID.randomUUID().toString());
        lVar.p(strArr[0]);
        lVar.r(strArr[1]);
        lVar.m(strArr[2]);
        lVar.o(this.C0);
        lVar.j(System.currentTimeMillis());
        lVar.q(System.currentTimeMillis());
        String str = this.C0.isEmpty() ? null : (String) this.C0.get(0);
        com.tuyafeng.support.utils.n.q(G(), w7.u.si);
        ArrayList arrayList = new ArrayList();
        arrayList.add(n9.e.l("Say 'test'"));
        int i11 = this.F0 + 1;
        this.F0 = i11;
        this.f15007r0.A(arrayList, lVar, str, new g(i11));
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f15009t0);
        super.M1();
    }

    @Override // m8.g
    public void T2() {
        I3(true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f15007r0 = la.s.e();
        this.A0 = null;
        v8.g.f(view);
        this.f15014y0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f15014y0.setLayoutManager(new LinearLayoutManager(G()));
        this.f15015z0 = new t5.f(this.C0);
        a9.n nVar = new a9.n();
        nVar.p(new f());
        this.f15015z0.K(String.class, nVar);
        this.f15014y0.setAdapter(this.f15015z0);
        String string = w0() != null ? w0().getString(Name.MARK) : null;
        if (string == null || string.isEmpty()) {
            return;
        }
        F3(string);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).V(new b6.a.InterfaceC0033a() { // from class: y8.n0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        l1 l1Var = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: y8.o0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.c3(this.f14999a, (l1) obj);
            }
        }).l();
        this.f15009t0 = l1Var.getEditText();
        l1 l1Var2 = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: y8.p0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.p3(this.f15001a, (l1) obj);
            }
        }).l();
        this.f15010u0 = l1Var2.getEditText();
        this.f15011v0 = (EditText) new b6.a(new EditText(G()), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).d(w7.o.f13792g).V(new b6.a.InterfaceC0033a() { // from class: y8.q0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.j3(this.f15003a, (EditText) obj);
            }
        }).l();
        this.f15012w0 = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).w(com.tuyafeng.support.utils.x.h(G(), 16.0f)).s(com.tuyafeng.support.utils.x.h(G(), 12.0f)).V(new b6.a.InterfaceC0033a() { // from class: y8.r0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.k3(this.f15005a, (TextView) obj);
            }
        }).l();
        final TextView textView = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, -2)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).Q(com.tuyafeng.support.utils.x.h(G(), 12.0f)).I(com.tuyafeng.support.utils.x.h(G(), 4.0f)).V(new d()).l();
        LinearLayout linearLayout2 = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: y8.b0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).s(com.tuyafeng.support.utils.x.h(G(), 6.0f)).l();
        l1 l1Var3 = (l1) new b6.a(new l1(G()), new LinearLayout.LayoutParams(0, -2)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).z(1, 16).d(w7.o.f13792g).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: y8.c0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.g3(this.f14946a, (l1) obj);
            }
        }).l();
        final ImageView imageView = (ImageView) new b6.a(new ImageView(G()), new LinearLayout.LayoutParams(-2, -2)).Y(1, 48).n(1, 40).N(1, 13).v(1, 6).p(16).i(w7.u.f14273w0).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: y8.d0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s0.i3(this.f14949a, (ImageView) obj);
            }
        }).l();
        this.f15014y0 = (RecyclerView) new b6.a(new RecyclerView(G()), new LinearLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: y8.e0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r3.e((RecyclerView) obj);
            }
        }).l();
        this.f15013x0 = l1Var3.getEditText();
        linearLayout.addView(l1Var);
        linearLayout.addView(l1Var2);
        linearLayout.addView(this.f15011v0);
        linearLayout.addView(this.f15012w0);
        linearLayout2.addView(l1Var3);
        linearLayout2.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(this.f15014y0);
        X2(new Runnable() { // from class: y8.f0
            @Override // java.lang.Runnable
            public final void run() {
                s0.o3(this.f14957c, textView, imageView);
            }
        });
        return linearLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        v3.a(e0Var, w7.u.O);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.Xh)), new a());
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.f13967a0)), new b());
        this.f15008s0 = e0Var;
    }

    @Override // m8.g
    public boolean l() {
        return E3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
    }
}
