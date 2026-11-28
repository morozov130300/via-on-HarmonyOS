package ma;

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
import c6.a2;
import java.io.File;
import java.util.concurrent.Callable;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public f1 f8035o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public w9.a f8036p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public g9.c f8037q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public String f8038r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public EditText f8039s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public EditText f8040t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ImageView f8041u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public l9.b f8042v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ImageView f8043w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public long f8045y0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f8044x0 = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final androidx.activity.result.b f8046z0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: ma.a
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            o.X2(this.f7977a, (Uri) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            o.this.m3();
        }
    }

    public static /* synthetic */ void S2(o oVar, s5.a aVar) {
        oVar.getClass();
        if (aVar.d()) {
            oVar.f8044x0 = (String) aVar.b();
            oVar.j3((String) aVar.b());
        }
    }

    public static /* synthetic */ x.d W2(o oVar, String str) {
        boolean z10;
        int iH = com.tuyafeng.support.utils.x.h(oVar.G(), 42.0f);
        int iC = (int) (((oVar.f8037q0.c() / 100.0f) * iH) / 2.0f);
        Drawable drawableJ = w3.j(oVar.f8038r0, str, iH, iH, iC);
        if (drawableJ == null) {
            drawableJ = w3.p(oVar.G(), iC * 2);
            z10 = true;
        } else {
            z10 = false;
        }
        return new x.d(Boolean.valueOf(z10), drawableJ);
    }

    public static /* synthetic */ void X2(final o oVar, Uri uri) {
        oVar.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.g(uri).h(new u6.g() { // from class: ma.k
            @Override // u6.g
            public final Object apply(Object obj) {
                o oVar2 = this.f8027a;
                return s5.a.f(x8.c1.b(oVar2.G(), (Uri) obj, new File(oVar2.f8038r0, "cache.png")));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(oVar.b1()))).a(new u6.f() { // from class: ma.l
            @Override // u6.f
            public final void accept(Object obj) {
                o.S2(this.f8029c, (s5.a) obj);
            }
        }, new w7.a0());
    }

    public static /* synthetic */ void Y2(o oVar, View view) {
        if (oVar.f8043w0.getVisibility() == 8) {
            oVar.l3();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    public static /* synthetic */ x.d Z2(o oVar, String str) {
        Drawable drawableK;
        Drawable drawableP;
        boolean z10;
        int iH = com.tuyafeng.support.utils.x.h(oVar.G(), 42.0f);
        int iC = (int) (((oVar.f8037q0.c() / 100.0f) * iH) / 2.0f);
        if (str == null || str.isEmpty()) {
            drawableK = null;
        } else {
            File file = new File(str);
            if (file.isFile()) {
                drawableK = w3.k(file.getParent(), file.getName(), iH, iH, iC);
            } else {
                drawableK = null;
            }
        }
        if (drawableK == null) {
            z10 = true;
            drawableP = w3.p(oVar.G(), iC << 1);
        } else {
            drawableP = drawableK;
            z10 = false;
        }
        return new x.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ void a3(o oVar, Integer num) {
        oVar.getClass();
        if (num.intValue() < 0) {
            com.tuyafeng.support.utils.n.q(oVar.G(), w7.u.Ng);
        } else {
            u9.n.e().u(true);
            oVar.f8035o0.n(oVar.f8042v0);
        }
    }

    public static /* synthetic */ boolean b3(o oVar, View view) {
        oVar.h3();
        return true;
    }

    public static /* synthetic */ Integer c3(o oVar, l9.b bVar) {
        String str;
        int iS = oVar.f8036p0.s(bVar);
        if (iS > 0 && (str = oVar.f8044x0) != null) {
            if (str.isEmpty()) {
                w3.e(oVar.f8038r0, bVar.g());
            } else {
                w3.a(oVar.f8038r0, oVar.f8044x0, bVar.g());
            }
            oVar.f8044x0 = null;
        }
        return Integer.valueOf(iS);
    }

    public static /* synthetic */ void d3(o oVar, x.d dVar) {
        oVar.f8043w0.setVisibility(dVar.f14455a == Boolean.FALSE ? 0 : 8);
        oVar.f8041u0.setImageDrawable((Drawable) dVar.f14456b);
    }

    public static /* synthetic */ void e3(o oVar, x.d dVar) {
        oVar.f8043w0.setVisibility(dVar.f14455a == Boolean.FALSE ? 0 : 8);
        oVar.f8041u0.setImageDrawable((Drawable) dVar.f14456b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3() {
        j3("");
        this.f8044x0 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        this.f8035o0.n(null);
    }

    private void j3(final String str) {
        if (this.f8037q0.f()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: ma.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o.Z2(this.f7980c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.c
            @Override // u6.f
            public final void accept(Object obj) {
                o.d3(this.f7986c, (x.d) obj);
            }
        }, new w7.a0());
    }

    private void k3(String str) {
        if (this.f8037q0.f()) {
            return;
        }
        ((autodispose2.r) r6.q.g(str).h(new u6.g() { // from class: ma.m
            @Override // u6.g
            public final Object apply(Object obj) {
                return o.W2(this.f8031a, (String) obj);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.n
            @Override // u6.f
            public final void accept(Object obj) {
                o.e3(this.f8033c, (x.d) obj);
            }
        }, new w7.a0());
    }

    private void l3() {
        if (this.f8042v0 == null) {
            return;
        }
        try {
            this.f8046z0.a(null);
        } catch (ActivityNotFoundException e10) {
            tc.a.e(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3() {
        if (SystemClock.elapsedRealtime() - this.f8045y0 < 300) {
            return;
        }
        this.f8045y0 = SystemClock.elapsedRealtime();
        String string = this.f8039s0.getText().toString();
        if (TextUtils.isEmpty(string)) {
            com.tuyafeng.support.utils.x.Y(this.f8039s0);
            com.tuyafeng.support.utils.n.i(this.f8039s0);
            return;
        }
        String strTrim = this.f8040t0.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            com.tuyafeng.support.utils.x.Y(this.f8040t0);
            com.tuyafeng.support.utils.n.i(this.f8040t0);
        } else {
            String strW = a2.f1958a.w(strTrim, la.s.j().b1());
            this.f8042v0.o(string);
            this.f8042v0.q(strW);
            ((autodispose2.r) r6.q.g(this.f8042v0).h(new u6.g() { // from class: ma.d
                @Override // u6.g
                public final Object apply(Object obj) {
                    return o.c3(this.f7990a, (l9.b) obj);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.e
                @Override // u6.f
                public final void accept(Object obj) {
                    o.a3(this.f7994c, (Integer) obj);
                }
            }, new w7.a0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13949r, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.findViewById(w7.p.f13878i1).setOnClickListener(new a());
        view.findViewById(w7.p.J).setOnClickListener(new View.OnClickListener() { // from class: ma.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f8000a.i3();
            }
        });
        ImageView imageView = (ImageView) view.findViewById(w7.p.L);
        this.f8043w0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ma.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f8013a.h3();
            }
        });
        this.f8039s0 = (EditText) view.findViewById(w7.p.f13894o);
        this.f8040t0 = (EditText) view.findViewById(w7.p.f13897p);
        ImageView imageView2 = (ImageView) view.findViewById(w7.p.R);
        this.f8041u0 = imageView2;
        imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: ma.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return o.b3(this.f8015a, view2);
            }
        });
        this.f8041u0.setOnClickListener(new View.OnClickListener() { // from class: ma.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o.Y2(this.f8016a, view2);
            }
        });
        if (this.f8037q0.f()) {
            this.f8041u0.setVisibility(8);
            this.f8043w0.setVisibility(8);
        }
        this.f8035o0.f8007g.g(b1(), new androidx.lifecycle.o() { // from class: ma.j
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f8019a.n3((l9.b) obj);
            }
        });
    }

    public final void n3(l9.b bVar) {
        this.f8042v0 = bVar;
        if (bVar == null) {
            return;
        }
        this.f8040t0.setText(bVar.g());
        this.f8039s0.setText(bVar.e());
        if (this.f8037q0.f()) {
            return;
        }
        k3(bVar.g());
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f8036p0 = la.s.f();
        this.f8037q0 = la.s.j().a3();
        this.f8038r0 = w3.m(G());
        if (K0() != null) {
            this.f8035o0 = (f1) new androidx.lifecycle.a0(K0()).a(f1.class);
        }
    }
}
