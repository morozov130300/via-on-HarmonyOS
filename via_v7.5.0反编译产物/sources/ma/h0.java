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
import android.widget.TextView;
import c6.a2;
import java.io.File;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h0 extends i8.a {
    public w9.a E0;
    public String F0;
    public TextView G0;
    public EditText H0;
    public EditText I0;
    public ImageView J0;
    public ImageView K0;
    public l9.b L0;
    public long M0;
    public g9.c N0;
    public int O0;
    public String P0 = null;
    public final androidx.activity.result.b Q0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: ma.p
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            h0.w3(this.f8049a, (Uri) obj);
        }
    });

    public static /* synthetic */ void A3(h0 h0Var, s5.a aVar) {
        h0Var.getClass();
        if (aVar.d()) {
            u9.n.e().u(true);
            h0Var.P0 = (String) aVar.b();
            h0Var.E3((String) aVar.b());
        }
    }

    private void D3() {
        final int i10 = w0() != null ? w0().getInt(Name.MARK, -1) : -1;
        if (i10 >= 0) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: ma.d0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7991c.E0.f(i10);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.e0
                @Override // u6.f
                public final void accept(Object obj) {
                    h0.y3(this.f7995c, (l9.b) obj);
                }
            }, new w7.a0());
            return;
        }
        final String string = w0() == null ? null : w0().getString("url", null);
        if (string == null || string.isEmpty()) {
            this.G0.setText(w7.u.f14022e);
        } else {
            final String string2 = w0() != null ? w0().getString("title", null) : null;
            ((autodispose2.r) r6.q.f(new Callable() { // from class: ma.f0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h0.m3(this.f8001c, string, string2);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.g0
                @Override // u6.f
                public final void accept(Object obj) {
                    h0.z3(this.f8014c, (l9.b) obj);
                }
            }, new w7.a0());
        }
    }

    public static h0 G3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("title", str2);
        h0 h0Var = new h0();
        h0Var.F2(bundle);
        return h0Var;
    }

    private void L(String str) {
        new a6.h.b(G()).h(str).a().s();
    }

    public static /* synthetic */ boolean k3(h0 h0Var, View view) {
        h0Var.B3();
        return true;
    }

    public static /* synthetic */ l9.b m3(h0 h0Var, String str, String str2) {
        l9.b bVarA = h0Var.E0.a(str);
        if (bVarA != null) {
            return bVarA;
        }
        l9.b bVar = new l9.b();
        bVar.o(str2);
        bVar.q(str);
        return bVar;
    }

    public static /* synthetic */ void o3(h0 h0Var, Integer num) {
        h0Var.getClass();
        if (num.intValue() < 0) {
            h0Var.L(h0Var.X0(w7.u.Ng));
            return;
        }
        u9.n.e().u(true);
        h0Var.O0 = num.intValue();
        Bundle bundle = new Bundle();
        int iC = h0Var.O0;
        if (iC <= 0) {
            iC = h0Var.L0.c();
        }
        bundle.putInt("result_id", iC);
        h0Var.i0().K().y1("fav_result", bundle);
        h0Var.V2();
    }

    public static /* synthetic */ void p3(h0 h0Var, View view) {
        if (h0Var.K0.getVisibility() == 8) {
            h0Var.H3();
        }
    }

    public static /* synthetic */ void q3(h0 h0Var, x.d dVar) {
        h0Var.K0.setVisibility(dVar.f14455a == Boolean.FALSE ? 0 : 8);
        h0Var.J0.setImageDrawable((Drawable) dVar.f14456b);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    public static /* synthetic */ x.d r3(h0 h0Var, String str) {
        Drawable drawableK;
        Drawable drawableP;
        boolean z10;
        int iH = com.tuyafeng.support.utils.x.h(h0Var.G(), 42.0f);
        int iC = (int) (((h0Var.N0.c() / 100.0f) * iH) / 2.0f);
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
            drawableP = w3.p(h0Var.G(), iC << 1);
        } else {
            drawableP = drawableK;
            z10 = false;
        }
        return new x.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ Integer s3(h0 h0Var, l9.b bVar) {
        String str;
        int iS = h0Var.E0.s(bVar);
        if (iS > 0 && (str = h0Var.P0) != null) {
            if (str.isEmpty()) {
                w3.e(h0Var.F0, bVar.g());
            } else {
                w3.a(h0Var.F0, h0Var.P0, bVar.g());
            }
            h0Var.P0 = null;
        }
        return Integer.valueOf(iS);
    }

    public static /* synthetic */ void t3(h0 h0Var, x.d dVar) {
        h0Var.K0.setVisibility(dVar.f14455a == Boolean.FALSE ? 0 : 8);
        h0Var.J0.setImageDrawable((Drawable) dVar.f14456b);
    }

    public static /* synthetic */ void w3(final h0 h0Var, Uri uri) {
        h0Var.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.g(uri).h(new u6.g() { // from class: ma.s
            @Override // u6.g
            public final Object apply(Object obj) {
                h0 h0Var2 = this.f8058a;
                return s5.a.f(x8.c1.b(h0Var2.G(), (Uri) obj, new File(h0Var2.F0, "cache.png")));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(h0Var.b1()))).a(new u6.f() { // from class: ma.t
            @Override // u6.f
            public final void accept(Object obj) {
                h0.A3(this.f8060c, (s5.a) obj);
            }
        }, new w7.a0());
    }

    public static /* synthetic */ x.d x3(h0 h0Var, String str) {
        Drawable drawableP;
        boolean z10;
        int iH = com.tuyafeng.support.utils.x.h(h0Var.G(), 42.0f);
        int iC = (int) (((h0Var.N0.c() / 100.0f) * iH) / 2.0f);
        Drawable drawableJ = w3.j(h0Var.F0, str, iH, iH, iC);
        if (drawableJ == null) {
            z10 = true;
            drawableP = w3.p(h0Var.G(), iC << 1);
        } else {
            drawableP = drawableJ;
            z10 = false;
        }
        return new x.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ void y3(h0 h0Var, l9.b bVar) {
        h0Var.L0 = bVar;
        String strG = bVar.g();
        h0Var.H0.setText(bVar.e());
        h0Var.I0.setText(strG);
        h0Var.F3(strG);
    }

    public static /* synthetic */ void z3(h0 h0Var, l9.b bVar) {
        h0Var.L0 = bVar;
        if (bVar.c() <= 0) {
            h0Var.G0.setText(w7.u.f14008d);
        }
        String strG = bVar.g();
        h0Var.H0.setText(bVar.e());
        h0Var.I0.setText(strG);
        h0Var.F3(strG);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13937f, viewGroup, false);
    }

    public final void B3() {
        E3("");
        this.P0 = "";
    }

    public final void C3() {
        V2();
    }

    public final void E3(final String str) {
        if (this.N0.f()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: ma.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h0.r3(this.f8051c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.r
            @Override // u6.f
            public final void accept(Object obj) {
                h0.q3(this.f8056c, (x.d) obj);
            }
        }, new w7.a0());
    }

    public final void F3(String str) {
        if (this.N0.f()) {
            return;
        }
        ((autodispose2.r) r6.q.g(str).h(new u6.g() { // from class: ma.w
            @Override // u6.g
            public final Object apply(Object obj) {
                return h0.x3(this.f8077a, (String) obj);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.x
            @Override // u6.f
            public final void accept(Object obj) {
                h0.t3(this.f8078c, (x.d) obj);
            }
        }, new w7.a0());
    }

    public final void H3() {
        if (this.L0 == null) {
            return;
        }
        try {
            this.Q0.a(null);
        } catch (ActivityNotFoundException e10) {
            tc.a.e(e10);
        }
    }

    public final void I3() {
        if (SystemClock.elapsedRealtime() - this.M0 < 300) {
            return;
        }
        this.M0 = SystemClock.elapsedRealtime();
        String string = this.H0.getText().toString();
        if (TextUtils.isEmpty(string)) {
            com.tuyafeng.support.utils.x.Y(this.H0);
            L(Y0(w7.u.f14254u7, this.H0.getHint()));
            return;
        }
        String strTrim = this.I0.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            com.tuyafeng.support.utils.x.Y(this.I0);
            L(Y0(w7.u.f14254u7, this.I0.getHint()));
        } else {
            String strW = a2.f1958a.w(strTrim, la.s.j().b1());
            this.L0.o(string);
            this.L0.q(strW);
            ((autodispose2.r) r6.q.g(this.L0).h(new u6.g() { // from class: ma.u
                @Override // u6.g
                public final Object apply(Object obj) {
                    return h0.s3(this.f8062a, (l9.b) obj);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: ma.v
                @Override // u6.f
                public final void accept(Object obj) {
                    h0.o3(this.f8064c, (Integer) obj);
                }
            }, new w7.a0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.findViewById(w7.p.f13878i1).setOnClickListener(new View.OnClickListener() { // from class: ma.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f8080a.I3();
            }
        });
        view.findViewById(w7.p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: ma.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f8082a.C3();
            }
        });
        this.G0 = (TextView) view.findViewById(w7.p.H1);
        this.H0 = (EditText) view.findViewById(w7.p.f13894o);
        this.I0 = (EditText) view.findViewById(w7.p.f13897p);
        ImageView imageView = (ImageView) view.findViewById(w7.p.L);
        this.K0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ma.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7978a.B3();
            }
        });
        ImageView imageView2 = (ImageView) view.findViewById(w7.p.R);
        this.J0 = imageView2;
        imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: ma.b0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return h0.k3(this.f7982a, view2);
            }
        });
        this.J0.setOnClickListener(new View.OnClickListener() { // from class: ma.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h0.p3(this.f7987a, view2);
            }
        });
        if (this.N0.f()) {
            this.K0.setVisibility(8);
            this.J0.setVisibility(8);
        }
        this.E0 = la.s.f();
        this.L0 = new l9.b();
        D3();
    }

    @Override // i8.a
    public int i3() {
        return 2;
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.N0 = la.s.j().a3();
        this.F0 = w3.m(G());
    }
}
