package qa;

import android.content.ActivityNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.File;
import java.util.concurrent.Callable;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public f1 f11393m0;

    /* renamed from: n0, reason: collision with root package name */
    public y9.a f11394n0;

    /* renamed from: o0, reason: collision with root package name */
    public i9.c f11395o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f11396p0;

    /* renamed from: q0, reason: collision with root package name */
    public EditText f11397q0;

    /* renamed from: r0, reason: collision with root package name */
    public EditText f11398r0;

    /* renamed from: s0, reason: collision with root package name */
    public ImageView f11399s0;

    /* renamed from: t0, reason: collision with root package name */
    public n9.b f11400t0;

    /* renamed from: u0, reason: collision with root package name */
    public ImageView f11401u0;

    /* renamed from: w0, reason: collision with root package name */
    public long f11403w0;

    /* renamed from: v0, reason: collision with root package name */
    public String f11402v0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public final androidx.activity.result.b f11404x0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: qa.a
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            o.Z2(this.f11335a, (Uri) obj);
        }
    });

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            o.this.o3();
        }
    }

    public static /* synthetic */ void U2(o oVar, x5.a aVar) {
        oVar.getClass();
        if (aVar.d()) {
            oVar.f11402v0 = (String) aVar.b();
            oVar.l3((String) aVar.b());
        }
    }

    public static /* synthetic */ w.d Y2(o oVar, String str) {
        boolean z10;
        int iH = g6.y.h(oVar.I(), 42.0f);
        int iC = (int) (((oVar.f11395o0.c() / 100.0f) * iH) / 2.0f);
        Drawable drawableJ = w3.j(oVar.f11396p0, str, iH, iH, iC);
        if (drawableJ == null) {
            drawableJ = w3.p(oVar.I(), iC * 2);
            z10 = true;
        } else {
            z10 = false;
        }
        return new w.d(Boolean.valueOf(z10), drawableJ);
    }

    public static /* synthetic */ void Z2(final o oVar, Uri uri) {
        oVar.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.h(uri).i(new a7.f() { // from class: qa.k
            @Override // a7.f
            public final Object apply(Object obj) {
                o oVar2 = this.f11385a;
                return x5.a.f(z8.c1.b(oVar2.I(), (Uri) obj, new File(oVar2.f11396p0, "cache.png")));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(oVar.d1()))).a(new a7.e() { // from class: qa.l
            @Override // a7.e
            public final void accept(Object obj) {
                o.U2(this.f11387e, (x5.a) obj);
            }
        }, new x7.c0());
    }

    public static /* synthetic */ void a3(o oVar, View view) {
        if (oVar.f11401u0.getVisibility() == 8) {
            oVar.n3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ w.d b3(o oVar, String str) {
        Drawable drawableK;
        Drawable drawableP;
        boolean z10;
        int iH = g6.y.h(oVar.I(), 42.0f);
        int iC = (int) (((oVar.f11395o0.c() / 100.0f) * iH) / 2.0f);
        if (str == null || str.isEmpty()) {
            drawableK = null;
        } else {
            File file = new File(str);
            if (file.isFile()) {
                drawableK = w3.k(file.getParent(), file.getName(), iH, iH, iC);
            }
        }
        if (drawableK == null) {
            z10 = true;
            drawableP = w3.p(oVar.I(), iC << 1);
        } else {
            drawableP = drawableK;
            z10 = false;
        }
        return new w.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ void c3(o oVar, Integer num) {
        oVar.getClass();
        if (num.intValue() < 0) {
            g6.n.q(oVar.I(), x7.u.xg);
        } else {
            w9.n.e().w(true);
            oVar.f11393m0.n(oVar.f11400t0);
        }
    }

    public static /* synthetic */ boolean d3(o oVar, View view) {
        oVar.j3();
        return true;
    }

    public static /* synthetic */ Integer e3(o oVar, n9.b bVar) {
        String str;
        int iS = oVar.f11394n0.s(bVar);
        if (iS > 0 && (str = oVar.f11402v0) != null) {
            if (str.isEmpty()) {
                w3.e(oVar.f11396p0, bVar.g());
            } else {
                w3.a(oVar.f11396p0, oVar.f11402v0, bVar.g());
            }
            oVar.f11402v0 = null;
        }
        return Integer.valueOf(iS);
    }

    public static /* synthetic */ void f3(o oVar, w.d dVar) {
        oVar.f11401u0.setVisibility(dVar.f13207a == Boolean.FALSE ? 0 : 8);
        oVar.f11399s0.setImageDrawable((Drawable) dVar.f13208b);
    }

    public static /* synthetic */ void g3(o oVar, w.d dVar) {
        oVar.f11401u0.setVisibility(dVar.f13207a == Boolean.FALSE ? 0 : 8);
        oVar.f11399s0.setImageDrawable((Drawable) dVar.f13208b);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13883r, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.findViewById(x7.p.f13812i1).setOnClickListener(new a());
        view.findViewById(x7.p.K).setOnClickListener(new View.OnClickListener() { // from class: qa.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11358a.k3();
            }
        });
        ImageView imageView = (ImageView) view.findViewById(x7.p.N);
        this.f11401u0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qa.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11371a.j3();
            }
        });
        this.f11397q0 = (EditText) view.findViewById(x7.p.f13831p);
        this.f11398r0 = (EditText) view.findViewById(x7.p.f13834q);
        ImageView imageView2 = (ImageView) view.findViewById(x7.p.S);
        this.f11399s0 = imageView2;
        imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: qa.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return o.d3(this.f11373a, view2);
            }
        });
        this.f11399s0.setOnClickListener(new View.OnClickListener() { // from class: qa.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o.a3(this.f11374a, view2);
            }
        });
        if (this.f11395o0.f()) {
            this.f11399s0.setVisibility(8);
            this.f11401u0.setVisibility(8);
        }
        this.f11393m0.f11365g.g(d1(), new androidx.lifecycle.m() { // from class: qa.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f11377a.p3((n9.b) obj);
            }
        });
    }

    public final void j3() {
        l3("");
        this.f11402v0 = "";
    }

    public final void k3() {
        this.f11393m0.n(null);
    }

    public final void l3(final String str) {
        if (this.f11395o0.f()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: qa.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o.b3(this.f11340e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.c
            @Override // a7.e
            public final void accept(Object obj) {
                o.f3(this.f11345e, (w.d) obj);
            }
        }, new x7.c0());
    }

    public final void m3(String str) {
        if (this.f11395o0.f()) {
            return;
        }
        ((autodispose2.r) x6.o.h(str).i(new a7.f() { // from class: qa.m
            @Override // a7.f
            public final Object apply(Object obj) {
                return o.Y2(this.f11389a, (String) obj);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.n
            @Override // a7.e
            public final void accept(Object obj) {
                o.g3(this.f11391e, (w.d) obj);
            }
        }, new x7.c0());
    }

    public final void n3() {
        if (this.f11400t0 == null) {
            return;
        }
        try {
            this.f11404x0.a(null);
        } catch (ActivityNotFoundException e10) {
            pc.a.d(e10);
        }
    }

    public final void o3() {
        if (SystemClock.elapsedRealtime() - this.f11403w0 < 300) {
            return;
        }
        this.f11403w0 = SystemClock.elapsedRealtime();
        String string = this.f11397q0.getText().toString();
        if (TextUtils.isEmpty(string)) {
            g6.y.X(this.f11397q0);
            g6.n.i(this.f11397q0);
            return;
        }
        String strTrim = this.f11398r0.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            g6.y.X(this.f11398r0);
            g6.n.i(this.f11398r0);
        } else {
            String strV = i6.i0.f7006a.v(strTrim, pa.r.j().Z0());
            this.f11400t0.o(string);
            this.f11400t0.q(strV);
            ((autodispose2.r) x6.o.h(this.f11400t0).i(new a7.f() { // from class: qa.d
                @Override // a7.f
                public final Object apply(Object obj) {
                    return o.e3(this.f11348a, (n9.b) obj);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.e
                @Override // a7.e
                public final void accept(Object obj) {
                    o.c3(this.f11352e, (Integer) obj);
                }
            }, new x7.c0());
        }
    }

    public final void p3(n9.b bVar) {
        this.f11400t0 = bVar;
        if (bVar == null) {
            return;
        }
        this.f11398r0.setText(bVar.g());
        this.f11397q0.setText(bVar.e());
        if (this.f11395o0.f()) {
            return;
        }
        m3(bVar.g());
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f11394n0 = pa.r.f();
        this.f11395o0 = pa.r.j().X2();
        this.f11396p0 = w3.m(I());
        if (M0() != null) {
            this.f11393m0 = (f1) new androidx.lifecycle.y(M0()).a(f1.class);
        }
    }
}
