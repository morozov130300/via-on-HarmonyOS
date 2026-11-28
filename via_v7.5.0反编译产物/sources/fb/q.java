package fb;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tuyafeng.scanner.BarcodeView;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.e0;
import java.util.List;
import java.util.concurrent.Callable;
import n5.v;
import n5.z;
import w7.u;
import x8.a0;
import x8.h3;
import x8.j3;
import x8.l0;
import x8.r3;
import x8.v3;
import x8.y1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends m8.a {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public FrameLayout f4594p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public n5.k f4595q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ImageView f4596r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ImageView f4597s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public TextView f4598t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f4599u0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final m8.h f4593o0 = new a(this);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f4600v0 = false;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public double f4601w0 = 0.0d;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f4602x0 = true;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f4603y0 = true;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f4604z0 = false;
    public final n5.a A0 = new b();
    public final androidx.activity.result.b B0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: fb.h
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q.f3(this.f4585a, (Uri) obj);
        }
    });
    public final androidx.activity.result.b C0 = w2(new e.g(), new androidx.activity.result.a() { // from class: fb.i
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q.S2(this.f4586a, (Boolean) obj);
        }
    });
    public int D0 = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends m8.h {
        public a(Fragment fragment) {
            super(fragment);
        }

        @Override // m8.h
        public void n() {
            j(false);
            q.this.i0().onBackPressed();
        }

        @Override // m8.h
        public boolean o() {
            return true;
        }
    }

    public static /* synthetic */ void S2(q qVar, Boolean bool) {
        qVar.getClass();
        if (!bool.booleanValue()) {
            y1.f(qVar.i0());
            return;
        }
        qVar.f4598t0.setVisibility(8);
        qVar.f4604z0 = true;
        tc.a.a("resume bar after granting permission", new Object[0]);
        qVar.o3();
        r3.l(qVar.f4596r0, qVar.f4603y0);
    }

    public static /* synthetic */ String T2(Bitmap bitmap) {
        String strC = z.c(bitmap);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return strC;
    }

    public static /* synthetic */ void U2(q qVar, String str) {
        if (str != null) {
            qVar.getClass();
            if (!str.isEmpty()) {
                qVar.f4599u0 = str;
                qVar.l3();
                return;
            }
        }
        com.tuyafeng.support.utils.n.q(qVar.G(), u.Pa);
    }

    public static /* synthetic */ void V2(q qVar, TextView textView) {
        textView.setTextSize(0, v8.h.r(qVar.G()));
        textView.setTextColor(com.tuyafeng.support.utils.f.b(qVar.G(), w7.m.f13747k));
        textView.setGravity(17);
        textView.setVisibility(8);
        textView.setText(u.f14113k6);
    }

    public static /* synthetic */ void W2(n5.k kVar) {
        BarcodeView barcodeView = kVar.getBarcodeView();
        if (barcodeView == null) {
            return;
        }
        barcodeView.setPreviewScalingStrategy(new o5.e());
        barcodeView.setUseTextureView(false);
    }

    public static /* synthetic */ void X2(q qVar, ImageView imageView) {
        qVar.getClass();
        r3.m(imageView, -1);
        imageView.setImageDrawable(lb.g.a(qVar.G(), w7.o.C1, u.Qf));
    }

    public static /* synthetic */ void Y2(e0 e0Var) {
        v3.a(e0Var, u.Qb);
        e0Var.setBackgroundColor(0);
        e0Var.setContentColor(-1);
        e0Var.setDividerColor(0);
    }

    public static /* synthetic */ void a3(q qVar, ImageView imageView) {
        qVar.getClass();
        r3.m(imageView, -1);
        imageView.setImageDrawable(lb.g.a(qVar.G(), w7.o.f13826r0, u.Ae));
    }

    public static /* synthetic */ void c3(q qVar, View view, View view2) {
        if (com.tuyafeng.support.utils.f.g(qVar.G(), "android.permission.CAMERA")) {
            view.setVisibility(8);
        } else {
            qVar.C0.a("android.permission.CAMERA");
        }
    }

    public static /* synthetic */ void d3(q qVar, View view) {
        qVar.getClass();
        try {
            qVar.B0.a(null);
        } catch (ActivityNotFoundException e10) {
            tc.a.j(e10);
        }
    }

    public static /* synthetic */ void e3(q qVar) {
        h3.u(qVar.G(), -16777216);
        h3.t(qVar.G(), -16777216);
    }

    public static /* synthetic */ void f3(final q qVar, final Uri uri) {
        qVar.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.m) r6.f.h(new Callable() { // from class: fb.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BitmapFactory.decodeStream(this.f4582c.G().getContentResolver().openInputStream(uri));
            }
        }).j(new u6.g() { // from class: fb.f
            @Override // u6.g
            public final Object apply(Object obj) {
                return q.T2((Bitmap) obj);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(qVar.b1()))).a(new u6.f() { // from class: fb.g
            @Override // u6.f
            public final void accept(Object obj) {
                q.U2(this.f4584c, (String) obj);
            }
        }, new w7.e0());
    }

    public static /* synthetic */ boolean g3(q qVar, View view, int i10, KeyEvent keyEvent) {
        qVar.getClass();
        if (keyEvent.getAction() == 0) {
            return qVar.f4595q0.onKeyDown(i10, keyEvent);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f4594p0 = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f4595q0 = (n5.k) new b6.a(new n5.k(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: fb.o
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.W2((n5.k) obj);
            }
        }).l();
        e0 e0Var = (e0) new b6.a(new e0(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: fb.p
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.Y2((e0) obj);
            }
        }).l();
        this.f4598t0 = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, -1)).N(1, 16).A(com.tuyafeng.support.utils.f.d(G(), w7.n.D)).V(new b6.a.InterfaceC0033a() { // from class: fb.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.V2(this.f4579a, (TextView) obj);
            }
        }).l();
        this.f4596r0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).Y(1, 48).n(1, 48).i(u.Hd).F(1, 10).d(w7.o.f13777b).V(new b6.a.InterfaceC0033a() { // from class: fb.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.X2(this.f4580a, (ImageView) obj);
            }
        }).l();
        this.f4597s0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).Y(1, 48).n(1, 48).i(u.Rb).F(1, 10).d(w7.o.f13777b).V(new b6.a.InterfaceC0033a() { // from class: fb.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q.a3(this.f4581a, (ImageView) obj);
            }
        }).l();
        this.f4594p0.addView(e0Var);
        this.f4594p0.addView(this.f4598t0);
        this.f4594p0.addView(this.f4596r0);
        this.f4594p0.addView(this.f4597s0);
        frameLayout.addView(this.f4595q0);
        frameLayout.addView(this.f4594p0);
        return x.a0(this, frameLayout, true, false);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        super.M1();
        if (this.f4604z0) {
            int i10 = this.D0;
            if ((i10 & 2) != 0) {
                this.D0 = i10 | 4;
                tc.a.a("pause barcode from lifecycle", new Object[0]);
                n3();
            }
        }
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        if (this.f4604z0) {
            int i10 = this.D0;
            if ((i10 & 4) == 0 || (i10 & 1) == 0) {
                return;
            }
            this.D0 = i10 & (-5);
            tc.a.a("resume barcode from lifecycle", new Object[0]);
            o3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(final View view, Bundle bundle) {
        super.V1(view, bundle);
        if (j3.h(G())) {
            i0().h().h(b1(), this.f4593o0);
        }
        view.post(new Runnable() { // from class: fb.j
            @Override // java.lang.Runnable
            public final void run() {
                q.e3(this.f4587c);
            }
        });
        this.f4602x0 = l0.h(G());
        this.f4603y0 = l0.i(G());
        this.f4598t0.setVisibility(8);
        this.f4598t0.setOnClickListener(new View.OnClickListener() { // from class: fb.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q.c3(this.f4588a, view, view2);
            }
        });
        this.f4595q0.getBarcodeView().setDecoderFactory(new n5.l(2052));
        this.f4595q0.b(this.A0);
        this.f4596r0.setOnClickListener(new View.OnClickListener() { // from class: fb.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4590a.p3();
            }
        });
        this.f4597s0.setOnClickListener(new View.OnClickListener() { // from class: fb.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q.d3(this.f4591a, view2);
            }
        });
        x.F(this.f4597s0, -1);
        m3(Resources.getSystem().getConfiguration());
        h3.e(this.f4594p0);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() { // from class: fb.n
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return q.g3(this.f4592a, view2, i10, keyEvent);
            }
        });
        if (!this.f4602x0) {
            r3.l(this.f4596r0, false);
            this.f4598t0.setVisibility(0);
            this.f4598t0.setEnabled(false);
            this.f4598t0.setText(u.X8);
            return;
        }
        if (com.tuyafeng.support.utils.f.g(G(), "android.permission.CAMERA")) {
            this.f4604z0 = true;
            r3.l(this.f4596r0, this.f4603y0);
            tc.a.a("resume barcode with permission", new Object[0]);
            o3();
            return;
        }
        r3.l(this.f4596r0, false);
        if (a0.f()) {
            this.f4598t0.setVisibility(0);
        } else {
            this.C0.a("android.permission.CAMERA");
        }
    }

    public final void l3() {
        String str = this.f4599u0;
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f4595q0.performHapticFeedback(3, 2);
        Bundle bundle = new Bundle();
        bundle.putString("qrcode", this.f4599u0);
        L0().y1("qrcode", bundle);
        i0().onBackPressed();
    }

    public final void m3(Configuration configuration) {
        int iAbs;
        int iH = x.h(G(), configuration.screenWidthDp);
        int iH2 = x.h(G(), configuration.screenHeightDp);
        boolean z10 = configuration.orientation == 2;
        double d10 = z10 ? 0.6d : 0.75d;
        if (this.f4601w0 == d10) {
            return;
        }
        this.f4601w0 = d10;
        double dMin = Math.min(iH2, iH);
        Double.isNaN(dMin);
        int iMin = Math.min((int) (dMin * d10), x.h(G(), 320.0f));
        this.f4595q0.getBarcodeView().setFramingRectSize(new v(iMin, iMin));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4596r0.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f4597s0.getLayoutParams();
        int iH3 = x.h(G(), 48.0f);
        if (z10) {
            int iH4 = x.h(G(), 32.0f);
            int i10 = (iMin / 2) - (iH3 / 2);
            if (Build.VERSION.SDK_INT < 30 || h3.j(this.f4596r0)) {
                iAbs = 0;
            } else {
                Insets insets = this.f4594p0.getRootWindowInsets().getInsets(WindowInsets.Type.systemBars());
                iH4 += insets.right;
                iAbs = Math.abs(insets.top - insets.bottom) >> 1;
            }
            layoutParams.gravity = 8388629;
            layoutParams2.gravity = 8388629;
            layoutParams.setMargins(0, 0, iH4, i10 + iAbs);
            layoutParams2.setMargins(0, i10 - iAbs, iH4, 0);
        } else {
            int iH5 = x.h(G(), 32.0f);
            int i11 = (iMin / 2) - (iH3 / 2);
            layoutParams.setMargins(0, 0, i11, iH5);
            layoutParams.gravity = 81;
            layoutParams2.setMargins(i11, 0, 0, iH5);
            layoutParams2.gravity = 81;
        }
        this.f4596r0.setLayoutParams(layoutParams);
        this.f4597s0.setLayoutParams(layoutParams2);
    }

    public final void n3() {
        n5.k kVar;
        if (!this.f4602x0 || (kVar = this.f4595q0) == null) {
            return;
        }
        if ((this.D0 & 1) == 0) {
            kVar.e();
            this.D0 |= 1;
            tc.a.a("pause barcode", new Object[0]);
        }
        this.D0 &= -3;
    }

    public final void o3() {
        n5.k kVar;
        if (!this.f4602x0 || (kVar = this.f4595q0) == null) {
            return;
        }
        if ((this.D0 & 2) == 0) {
            kVar.f();
            this.D0 |= 2;
            tc.a.a("resume barcode", new Object[0]);
        }
        this.D0 &= -2;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3(configuration);
    }

    public final void p3() {
        boolean z10 = this.f4600v0;
        this.f4600v0 = !z10;
        if (z10) {
            this.f4595q0.g();
        } else {
            this.f4595q0.h();
        }
        this.f4596r0.setSelected(this.f4600v0);
        x.T(this.f4600v0 ? v8.h.j(G()) : com.tuyafeng.support.utils.f.b(G(), R.color.white), this.f4596r0);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements n5.a {
        public b() {
        }

        @Override // n5.a
        public void b(n5.d dVar) {
            if (dVar.a() == null || dVar.a().equals(q.this.f4599u0)) {
                return;
            }
            q.this.f4599u0 = dVar.a();
            q.this.f4595q0.setStatusText(dVar.a());
            q.this.l3();
        }

        @Override // n5.a
        public void a(List list) {
        }
    }
}
