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
import android.widget.TextView;
import f6.h;
import java.io.File;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h0 extends k8.a {
    public y9.a C0;
    public String D0;
    public TextView E0;
    public EditText F0;
    public EditText G0;
    public ImageView H0;
    public ImageView I0;
    public n9.b J0;
    public long K0;
    public i9.c L0;
    public int M0;
    public String N0 = null;
    public final androidx.activity.result.b O0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: qa.p
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            h0.w3(this.f11407a, (Uri) obj);
        }
    });

    public static /* synthetic */ void A3(h0 h0Var, x5.a aVar) {
        h0Var.getClass();
        if (aVar.d()) {
            w9.n.e().w(true);
            h0Var.N0 = (String) aVar.b();
            h0Var.E3((String) aVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3() {
        E3("");
        this.N0 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3() {
        X2();
    }

    private void D3() {
        final int i10 = y0() != null ? y0().getInt(Name.MARK, -1) : -1;
        if (i10 >= 0) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: qa.d0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f11349e.C0.f(i10);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.e0
                @Override // a7.e
                public final void accept(Object obj) {
                    h0.y3(this.f11353e, (n9.b) obj);
                }
            }, new x7.c0());
            return;
        }
        final String string = y0() == null ? null : y0().getString("url", null);
        if (string == null || string.isEmpty()) {
            this.E0.setText(x7.u.f13956e);
        } else {
            final String string2 = y0() != null ? y0().getString("title", null) : null;
            ((autodispose2.r) x6.o.g(new Callable() { // from class: qa.f0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h0.m3(this.f11359e, string, string2);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.g0
                @Override // a7.e
                public final void accept(Object obj) {
                    h0.z3(this.f11372e, (n9.b) obj);
                }
            }, new x7.c0());
        }
    }

    private void E3(final String str) {
        if (this.L0.f()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: qa.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return h0.r3(this.f11409e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.r
            @Override // a7.e
            public final void accept(Object obj) {
                h0.q3(this.f11414e, (w.d) obj);
            }
        }, new x7.c0());
    }

    private void F3(String str) {
        if (this.L0.f()) {
            return;
        }
        ((autodispose2.r) x6.o.h(str).i(new a7.f() { // from class: qa.w
            @Override // a7.f
            public final Object apply(Object obj) {
                return h0.x3(this.f11435a, (String) obj);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.x
            @Override // a7.e
            public final void accept(Object obj) {
                h0.t3(this.f11436e, (w.d) obj);
            }
        }, new x7.c0());
    }

    public static h0 G3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("title", str2);
        h0 h0Var = new h0();
        h0Var.H2(bundle);
        return h0Var;
    }

    private void H3() {
        if (this.J0 == null) {
            return;
        }
        try {
            this.O0.a(null);
        } catch (ActivityNotFoundException e10) {
            pc.a.d(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3() {
        if (SystemClock.elapsedRealtime() - this.K0 < 300) {
            return;
        }
        this.K0 = SystemClock.elapsedRealtime();
        String string = this.F0.getText().toString();
        if (TextUtils.isEmpty(string)) {
            g6.y.X(this.F0);
            N(a1(x7.u.f14020i7, this.F0.getHint()));
            return;
        }
        String strTrim = this.G0.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            g6.y.X(this.G0);
            N(a1(x7.u.f14020i7, this.G0.getHint()));
        } else {
            String strV = i6.i0.f7006a.v(strTrim, pa.r.j().Z0());
            this.J0.o(string);
            this.J0.q(strV);
            ((autodispose2.r) x6.o.h(this.J0).i(new a7.f() { // from class: qa.u
                @Override // a7.f
                public final Object apply(Object obj) {
                    return h0.s3(this.f11420a, (n9.b) obj);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: qa.v
                @Override // a7.e
                public final void accept(Object obj) {
                    h0.o3(this.f11422e, (Integer) obj);
                }
            }, new x7.c0());
        }
    }

    private void N(String str) {
        new h.b(I()).h(str).a().s();
    }

    public static /* synthetic */ boolean k3(h0 h0Var, View view) {
        h0Var.B3();
        return true;
    }

    public static /* synthetic */ n9.b m3(h0 h0Var, String str, String str2) {
        n9.b bVarA = h0Var.C0.a(str);
        if (bVarA != null) {
            return bVarA;
        }
        n9.b bVar = new n9.b();
        bVar.o(str2);
        bVar.q(str);
        return bVar;
    }

    public static /* synthetic */ void o3(h0 h0Var, Integer num) {
        h0Var.getClass();
        if (num.intValue() < 0) {
            h0Var.N(h0Var.Z0(x7.u.xg));
            return;
        }
        w9.n.e().w(true);
        h0Var.M0 = num.intValue();
        Bundle bundle = new Bundle();
        int iC = h0Var.M0;
        if (iC <= 0) {
            iC = h0Var.J0.c();
        }
        bundle.putInt("result_id", iC);
        h0Var.l0().L().x1("fav_result", bundle);
        h0Var.X2();
    }

    public static /* synthetic */ void p3(h0 h0Var, View view) {
        if (h0Var.I0.getVisibility() == 8) {
            h0Var.H3();
        }
    }

    public static /* synthetic */ void q3(h0 h0Var, w.d dVar) {
        h0Var.I0.setVisibility(dVar.f13207a == Boolean.FALSE ? 0 : 8);
        h0Var.H0.setImageDrawable((Drawable) dVar.f13208b);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ w.d r3(h0 h0Var, String str) {
        Drawable drawableK;
        Drawable drawableP;
        boolean z10;
        int iH = g6.y.h(h0Var.I(), 42.0f);
        int iC = (int) (((h0Var.L0.c() / 100.0f) * iH) / 2.0f);
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
            drawableP = w3.p(h0Var.I(), iC << 1);
        } else {
            drawableP = drawableK;
            z10 = false;
        }
        return new w.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ Integer s3(h0 h0Var, n9.b bVar) {
        String str;
        int iS = h0Var.C0.s(bVar);
        if (iS > 0 && (str = h0Var.N0) != null) {
            if (str.isEmpty()) {
                w3.e(h0Var.D0, bVar.g());
            } else {
                w3.a(h0Var.D0, h0Var.N0, bVar.g());
            }
            h0Var.N0 = null;
        }
        return Integer.valueOf(iS);
    }

    public static /* synthetic */ void t3(h0 h0Var, w.d dVar) {
        h0Var.I0.setVisibility(dVar.f13207a == Boolean.FALSE ? 0 : 8);
        h0Var.H0.setImageDrawable((Drawable) dVar.f13208b);
    }

    public static /* synthetic */ void w3(final h0 h0Var, Uri uri) {
        h0Var.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.h(uri).i(new a7.f() { // from class: qa.s
            @Override // a7.f
            public final Object apply(Object obj) {
                h0 h0Var2 = this.f11416a;
                return x5.a.f(z8.c1.b(h0Var2.I(), (Uri) obj, new File(h0Var2.D0, "cache.png")));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(h0Var.d1()))).a(new a7.e() { // from class: qa.t
            @Override // a7.e
            public final void accept(Object obj) {
                h0.A3(this.f11418e, (x5.a) obj);
            }
        }, new x7.c0());
    }

    public static /* synthetic */ w.d x3(h0 h0Var, String str) {
        Drawable drawableP;
        boolean z10;
        int iH = g6.y.h(h0Var.I(), 42.0f);
        int iC = (int) (((h0Var.L0.c() / 100.0f) * iH) / 2.0f);
        Drawable drawableJ = w3.j(h0Var.D0, str, iH, iH, iC);
        if (drawableJ == null) {
            z10 = true;
            drawableP = w3.p(h0Var.I(), iC << 1);
        } else {
            drawableP = drawableJ;
            z10 = false;
        }
        return new w.d(Boolean.valueOf(z10), drawableP);
    }

    public static /* synthetic */ void y3(h0 h0Var, n9.b bVar) {
        h0Var.J0 = bVar;
        String strG = bVar.g();
        h0Var.F0.setText(bVar.e());
        h0Var.G0.setText(strG);
        h0Var.F3(strG);
    }

    public static /* synthetic */ void z3(h0 h0Var, n9.b bVar) {
        h0Var.J0 = bVar;
        if (bVar.c() <= 0) {
            h0Var.E0.setText(x7.u.f13942d);
        }
        String strG = bVar.g();
        h0Var.F0.setText(bVar.e());
        h0Var.G0.setText(strG);
        h0Var.F3(strG);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13871f, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.findViewById(x7.p.f13812i1).setOnClickListener(new View.OnClickListener() { // from class: qa.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11438a.I3();
            }
        });
        view.findViewById(x7.p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: qa.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11440a.C3();
            }
        });
        this.E0 = (TextView) view.findViewById(x7.p.H1);
        this.F0 = (EditText) view.findViewById(x7.p.f13831p);
        this.G0 = (EditText) view.findViewById(x7.p.f13834q);
        ImageView imageView = (ImageView) view.findViewById(x7.p.N);
        this.I0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qa.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11336a.B3();
            }
        });
        ImageView imageView2 = (ImageView) view.findViewById(x7.p.S);
        this.H0 = imageView2;
        imageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: qa.b0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return h0.k3(this.f11342a, view2);
            }
        });
        this.H0.setOnClickListener(new View.OnClickListener() { // from class: qa.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h0.p3(this.f11346a, view2);
            }
        });
        if (this.L0.f()) {
            this.I0.setVisibility(8);
            this.H0.setVisibility(8);
        }
        this.C0 = pa.r.f();
        this.J0 = new n9.b();
        D3();
    }

    @Override // k8.a
    public int i3() {
        return 2;
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.L0 = pa.r.j().X2();
        this.D0 = w3.m(I());
    }
}
