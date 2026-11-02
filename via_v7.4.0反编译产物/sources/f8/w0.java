package f8;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import z8.t1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w0 extends f8.c {
    public int A0;
    public oa.c B0;
    public oa.b C0;
    public oa.b D0;
    public y6.b F0;

    /* renamed from: s0, reason: collision with root package name */
    public EditText f6037s0;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f6038t0;

    /* renamed from: u0, reason: collision with root package name */
    public ImageView f6039u0;

    /* renamed from: v0, reason: collision with root package name */
    public ImageView f6040v0;

    /* renamed from: w0, reason: collision with root package name */
    public ImageView f6041w0;

    /* renamed from: x0, reason: collision with root package name */
    public TextView f6042x0;

    /* renamed from: y0, reason: collision with root package name */
    public TextView f6043y0;

    /* renamed from: z0, reason: collision with root package name */
    public com.tuyafeng.support.widget.w f6044z0;
    public oa.d E0 = null;
    public final Random G0 = new Random();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                w0.this.f6039u0.setImageDrawable(lb.b.a(w0.this.I(), x7.o.f13783z, x7.u.Ud));
                w0.this.f6039u0.setContentDescription(w0.this.Z0(x7.u.f14058l3));
            } else {
                w0.this.f6039u0.setImageDrawable(lb.b.a(w0.this.I(), x7.o.L, x7.u.Xd));
                w0.this.f6039u0.setContentDescription(w0.this.Z0(x7.u.N4));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {
        public b() {
        }

        @Override // v5.c
        public void a(View view) {
            if (w0.this.f6037s0.length() <= 0) {
                w0.this.l0().onBackPressed();
            } else {
                w0.this.f6037s0.setText("");
                w0.this.s3(1);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6047a;

        public c(List list) {
            this.f6047a = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            oa.b bVar = (oa.b) this.f6047a.get(i10);
            if (bVar.a().equals(w0.this.C0.a())) {
                return;
            }
            w0.this.C0 = bVar;
            w0.this.f6042x0.setText(w0.this.C0.b());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6049a;

        public d(List list) {
            this.f6049a = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            oa.b bVar = (oa.b) this.f6049a.get(i10);
            if (bVar.a().equals(w0.this.D0.a())) {
                return;
            }
            w0.this.D0 = bVar;
            w0.this.f6043y0.setText(w0.this.D0.b());
        }
    }

    public static /* synthetic */ void a3(w0 w0Var, View view, boolean z10) {
        if (z10) {
            w0Var.s3(1);
        } else if (w0Var.E0 != null) {
            w0Var.s3(2);
        }
    }

    public static /* synthetic */ void b3(w0 w0Var, View view) {
        if (w0Var.f6038t0.length() > 0) {
            g6.n.a(w0Var.I(), w0Var.f6038t0.getText().toString(), x7.u.og);
        }
    }

    public static /* synthetic */ void g3(w0 w0Var, View view) {
        oa.d dVar;
        oa.b bVarE = w0Var.C0;
        if ("auto".equals(bVarE.a()) && (dVar = w0Var.E0) != null) {
            bVarE = w0Var.B0.e(dVar.b());
        }
        if ("auto".equals(bVarE.a()) || bVarE.a().equals(w0Var.D0.a())) {
            return;
        }
        oa.b bVar = w0Var.D0;
        w0Var.C0 = bVar;
        w0Var.D0 = bVarE;
        w0Var.f6042x0.setText(bVar.b());
        w0Var.f6043y0.setText(w0Var.D0.b());
        String string = w0Var.f6037s0.getText().toString();
        w0Var.f6037s0.setText(w0Var.f6038t0.getText().toString());
        w0Var.f6038t0.setText(string);
    }

    public static /* synthetic */ void i3(w0 w0Var, x5.a aVar) {
        w0Var.f6044z0.f(100);
        if (!aVar.d()) {
            w0Var.E0 = null;
            w0Var.s3(1);
            return;
        }
        oa.d dVar = (oa.d) aVar.b();
        w0Var.E0 = dVar;
        w0Var.f6038t0.setText(dVar.d());
        z8.f.e(w0Var.f6037s0);
        w0Var.s3(2);
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        u3();
        y6.b bVar = this.F0;
        if (bVar != null) {
            bVar.dispose();
        }
        super.F1();
    }

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.f13985g0);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        Locale localeC = t1.c(I());
        oa.c cVar = new oa.c(new oa.a(localeC));
        this.B0 = cVar;
        oa.b bVarE = cVar.e("auto");
        this.C0 = bVarE;
        bVarE.c(Z0(x7.u.f14167t3));
        String strM = t1.m(t1.n(localeC));
        if ("zh".equals(strM) && localeC.getCountry().equals("TW")) {
            strM = "zh_HANT";
        }
        this.D0 = this.B0.a(strM);
        this.f6037s0 = (EditText) view.findViewById(x7.p.f13825n);
        this.f6038t0 = (TextView) view.findViewById(x7.p.I1);
        this.f6039u0 = (ImageView) view.findViewById(x7.p.f13790b0);
        this.f6040v0 = (ImageView) view.findViewById(x7.p.L);
        this.f6041w0 = (ImageView) view.findViewById(x7.p.f13817k0);
        Drawable drawableA = lb.b.a(I(), x7.o.F1, x7.u.Af);
        if (drawableA != null) {
            Drawable drawableMutate = drawableA.mutate();
            drawableMutate.setColorFilter(x8.h.m(I()), PorterDuff.Mode.SRC_IN);
            this.f6041w0.setImageDrawable(drawableMutate);
        }
        g6.y.O(this.f6041w0, new g6.g().h(x8.h.j(I())).j(x8.h.k(I())).f(1).a());
        this.f6042x0 = (TextView) view.findViewById(x7.p.B1);
        this.f6043y0 = (TextView) view.findViewById(x7.p.G1);
        ProgressBar progressBar = (ProgressBar) view.findViewById(x7.p.f13838r0);
        progressBar.setProgressDrawable(x8.h.x(I()));
        this.f6044z0 = new com.tuyafeng.support.widget.w(progressBar);
        this.f6037s0.addTextChangedListener(new a());
        this.f6037s0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: f8.m0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                w0.a3(this.f6004a, view2, z10);
            }
        });
        this.f6039u0.setOnClickListener(new b());
        view.findViewById(x7.p.f13811i0).setOnClickListener(new View.OnClickListener() { // from class: f8.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0.g3(this.f6006a, view2);
            }
        });
        this.f6038t0.setOnClickListener(new View.OnClickListener() { // from class: f8.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6012a.s3(2);
            }
        });
        this.f6040v0.setOnClickListener(new View.OnClickListener() { // from class: f8.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0.b3(this.f6014a, view2);
            }
        });
        this.f6042x0.setText(this.C0.b());
        this.f6042x0.setOnClickListener(new View.OnClickListener() { // from class: f8.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6019a.w3();
            }
        });
        this.f6043y0.setText(this.D0.b());
        this.f6043y0.setOnClickListener(new View.OnClickListener() { // from class: f8.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6021a.x3();
            }
        });
        this.f6041w0.setOnClickListener(new View.OnClickListener() { // from class: f8.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6023a.y3();
            }
        });
        t3();
        s3(1);
        String string = y0() == null ? null : y0().getString("text");
        if (string == null || string.isEmpty()) {
            return;
        }
        this.f6037s0.setText(string);
        y3();
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13884s, viewGroup, false);
    }

    @Override // f8.c
    public void Y2() {
        g6.y.K(this.f6037s0);
    }

    public final void s3(int i10) {
        if (this.A0 == i10) {
            return;
        }
        this.A0 = i10;
        if (i10 == 1) {
            if (this.E0 == null) {
                this.f6037s0.setLines(7);
                this.f6038t0.setVisibility(8);
                this.f6040v0.setVisibility(8);
                return;
            } else {
                this.f6037s0.setLines(5);
                this.f6038t0.setScrollX(0);
                this.f6038t0.setLines(1);
                this.f6038t0.setVisibility(0);
                this.f6040v0.setVisibility(0);
                return;
            }
        }
        if (i10 == 2) {
            this.f6037s0.setLines(1);
            this.f6037s0.setScrollX(0);
            this.f6038t0.setLines(5);
            this.f6038t0.setScrollX(0);
            this.f6038t0.setVisibility(0);
            this.f6040v0.setVisibility(0);
            this.f6038t0.requestFocus();
            z8.f.e(this.f6037s0);
        }
    }

    public final void t3() {
        Bundle bundleC = v5.b.d().c("TRANSLATE_CACHE");
        if (bundleC == null) {
            return;
        }
        String string = bundleC.getString("SOURCE", "");
        if (string.isEmpty()) {
            return;
        }
        String string2 = bundleC.getString("TARGET", "");
        if (string2.isEmpty()) {
            return;
        }
        oa.b bVarE = this.B0.e(string);
        this.C0 = bVarE;
        this.f6042x0.setText(bVarE.b());
        oa.b bVarA = this.B0.a(string2);
        this.D0 = bVarA;
        this.f6043y0.setText(bVarA.b());
        this.f6037s0.setText(bundleC.getString("QUERY", ""));
    }

    public final void u3() {
        v5.b.a().e("TRANSLATE_CACHE").f(180).d("QUERY", this.f6037s0.getText().toString()).d("SOURCE", this.C0.a()).d("TARGET", this.D0.a()).a();
    }

    public final void v3(String str, List list, String str2, AdapterView.OnItemClickListener onItemClickListener) {
        String[] strArr = new String[list.size()];
        Iterator it = list.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            oa.b bVar = (oa.b) it.next();
            if (str2.equals(bVar.a())) {
                i10 = i11;
            }
            strArr[i11] = bVar.b();
            i11++;
        }
        w5.k.l(I()).e0(str).b0(strArr, i10, onItemClickListener).f0();
    }

    public final void w3() {
        List listB = this.B0.b();
        v3(Z0(x7.u.ig), listB, this.C0.a(), new c(listB));
    }

    public final void x3() {
        List listD = this.B0.d();
        v3(Z0(x7.u.jg), listD, this.D0.a(), new d(listD));
    }

    public final void y3() {
        y6.b bVar = this.F0;
        if (bVar != null) {
            bVar.dispose();
        }
        final String strTrim = this.f6037s0.getText().toString().trim();
        if (!strTrim.isEmpty()) {
            this.f6044z0.g(this.G0.nextInt(35) + 10, true);
            this.F0 = x6.o.g(new Callable() { // from class: f8.t0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    w0 w0Var = this.f6025e;
                    return x5.a.f(w0Var.B0.c(strTrim, w0Var.C0.a(), w0Var.D0.a()));
                }
            }).l(g7.a.c()).j(w6.b.b()).a(new a7.e() { // from class: f8.u0
                @Override // a7.e
                public final void accept(Object obj) {
                    w0.i3(this.f6028e, (x5.a) obj);
                }
            }, new a7.e() { // from class: f8.v0
                @Override // a7.e
                public final void accept(Object obj) {
                    pc.a.b((Throwable) obj);
                }
            });
        } else {
            this.f6044z0.f(100);
            this.E0 = null;
            s3(1);
        }
    }
}
