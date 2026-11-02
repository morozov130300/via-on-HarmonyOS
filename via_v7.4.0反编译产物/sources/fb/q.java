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
import g6.y;
import h6.a;
import java.util.List;
import java.util.concurrent.Callable;
import t5.v;
import t5.z;
import x7.g0;
import x7.u;
import z8.c0;
import z8.l0;
import z8.l3;
import z8.n3;
import z8.r3;
import z8.v3;
import z8.z1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q extends o8.a {

    /* renamed from: n0, reason: collision with root package name */
    public FrameLayout f6080n0;

    /* renamed from: o0, reason: collision with root package name */
    public t5.k f6081o0;

    /* renamed from: p0, reason: collision with root package name */
    public ImageView f6082p0;

    /* renamed from: q0, reason: collision with root package name */
    public ImageView f6083q0;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f6084r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f6085s0;

    /* renamed from: m0, reason: collision with root package name */
    public final o8.i f6079m0 = new a(this);

    /* renamed from: t0, reason: collision with root package name */
    public boolean f6086t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    public double f6087u0 = 0.0d;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f6088v0 = true;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f6089w0 = true;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f6090x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public final t5.a f6091y0 = new b();

    /* renamed from: z0, reason: collision with root package name */
    public final androidx.activity.result.b f6092z0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: fb.h
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q.h3(this.f6071a, (Uri) obj);
        }
    });
    public final androidx.activity.result.b A0 = y2(new e.g(), new androidx.activity.result.a() { // from class: fb.i
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q.U2(this.f6072a, (Boolean) obj);
        }
    });
    public int B0 = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends o8.i {
        public a(Fragment fragment) {
            super(fragment);
        }

        @Override // o8.i
        public void n() {
            j(false);
            q.this.l0().onBackPressed();
        }

        @Override // o8.i
        public boolean o() {
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements t5.a {
        public b() {
        }

        @Override // t5.a
        public void a(List list) {
        }

        @Override // t5.a
        public void b(t5.d dVar) {
            if (dVar.a() == null || dVar.a().equals(q.this.f6085s0)) {
                return;
            }
            q.this.f6085s0 = dVar.a();
            q.this.f6081o0.setStatusText(dVar.a());
            q.this.n3();
        }
    }

    public static /* synthetic */ void U2(q qVar, Boolean bool) {
        qVar.getClass();
        if (!bool.booleanValue()) {
            z1.f(qVar.l0());
            return;
        }
        qVar.f6084r0.setVisibility(8);
        qVar.f6090x0 = true;
        pc.a.a("resume bar after granting permission", new Object[0]);
        qVar.q3();
        r3.k(qVar.f6082p0, qVar.f6089w0);
    }

    public static /* synthetic */ String V2(Bitmap bitmap) {
        String strC = z.c(bitmap);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return strC;
    }

    public static /* synthetic */ void W2(q qVar, String str) {
        if (str != null) {
            qVar.getClass();
            if (!str.isEmpty()) {
                qVar.f6085s0 = str;
                qVar.n3();
                return;
            }
        }
        g6.n.q(qVar.I(), u.Da);
    }

    public static /* synthetic */ void X2(q qVar, TextView textView) {
        textView.setTextSize(0, x8.h.s(qVar.I()));
        textView.setTextColor(g6.f.b(qVar.I(), x7.m.f13681k));
        textView.setGravity(17);
        textView.setVisibility(8);
        textView.setText(u.Y5);
    }

    public static /* synthetic */ void Y2(t5.k kVar) {
        BarcodeView barcodeView = kVar.getBarcodeView();
        if (barcodeView == null) {
            return;
        }
        barcodeView.setPreviewScalingStrategy(new u5.e());
        barcodeView.setUseTextureView(false);
    }

    public static /* synthetic */ void Z2(q qVar, ImageView imageView) {
        qVar.getClass();
        r3.l(imageView, -1);
        imageView.setImageDrawable(lb.b.a(qVar.I(), x7.o.E1, u.zf));
    }

    public static /* synthetic */ void a3(com.tuyafeng.support.widget.z zVar) {
        v3.a(zVar, u.Db);
        zVar.setBackgroundColor(0);
        zVar.setContentColor(-1);
        zVar.setDividerColor(0);
    }

    public static /* synthetic */ void c3(q qVar, ImageView imageView) {
        qVar.getClass();
        r3.l(imageView, -1);
        imageView.setImageDrawable(lb.b.a(qVar.I(), x7.o.f13757q0, u.ke));
    }

    public static /* synthetic */ void e3(q qVar, View view, View view2) {
        if (g6.f.g(qVar.I(), "android.permission.CAMERA")) {
            view.setVisibility(8);
        } else {
            qVar.A0.a("android.permission.CAMERA");
        }
    }

    public static /* synthetic */ void f3(q qVar, View view) {
        qVar.getClass();
        try {
            qVar.f6092z0.a(null);
        } catch (ActivityNotFoundException e10) {
            pc.a.i(e10);
        }
    }

    public static /* synthetic */ void g3(q qVar) {
        l3.r(qVar.I(), -16777216);
        l3.q(qVar.I(), -16777216);
    }

    public static /* synthetic */ void h3(final q qVar, final Uri uri) {
        qVar.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.m) x6.f.h(new Callable() { // from class: fb.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BitmapFactory.decodeStream(this.f6068e.I().getContentResolver().openInputStream(uri));
            }
        }).j(new a7.f() { // from class: fb.f
            @Override // a7.f
            public final Object apply(Object obj) {
                return q.V2((Bitmap) obj);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(qVar.d1()))).a(new a7.e() { // from class: fb.g
            @Override // a7.e
            public final void accept(Object obj) {
                q.W2(this.f6070e, (String) obj);
            }
        }, new g0());
    }

    public static /* synthetic */ boolean i3(q qVar, View view, int i10, KeyEvent keyEvent) {
        qVar.getClass();
        if (keyEvent.getAction() == 0) {
            return qVar.f6081o0.onKeyDown(i10, keyEvent);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f6080n0 = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f6081o0 = (t5.k) new h6.a(new t5.k(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: fb.o
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q.Y2((t5.k) obj);
            }
        }).l();
        com.tuyafeng.support.widget.z zVar = (com.tuyafeng.support.widget.z) new h6.a(new com.tuyafeng.support.widget.z(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: fb.p
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q.a3((com.tuyafeng.support.widget.z) obj);
            }
        }).l();
        this.f6084r0 = (TextView) new h6.a(new TextView(I()), new FrameLayout.LayoutParams(-1, -1)).N(1, 16).A(g6.f.d(I(), x7.n.B)).V(new a.InterfaceC0076a() { // from class: fb.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q.X2(this.f6065a, (TextView) obj);
            }
        }).l();
        this.f6082p0 = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-2, -2)).Y(1, 48).n(1, 48).i(u.rd).F(1, 10).d(x7.o.f13714c).V(new a.InterfaceC0076a() { // from class: fb.c
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q.Z2(this.f6066a, (ImageView) obj);
            }
        }).l();
        this.f6083q0 = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-2, -2)).Y(1, 48).n(1, 48).i(u.Eb).F(1, 10).d(x7.o.f13714c).V(new a.InterfaceC0076a() { // from class: fb.d
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                q.c3(this.f6067a, (ImageView) obj);
            }
        }).l();
        this.f6080n0.addView(zVar);
        this.f6080n0.addView(this.f6084r0);
        this.f6080n0.addView(this.f6082p0);
        this.f6080n0.addView(this.f6083q0);
        frameLayout.addView(this.f6081o0);
        frameLayout.addView(this.f6080n0);
        return y.a0(this, frameLayout, true, false);
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        super.O1();
        if (this.f6090x0) {
            int i10 = this.B0;
            if ((i10 & 2) != 0) {
                this.B0 = i10 | 4;
                pc.a.a("pause barcode from lifecycle", new Object[0]);
                p3();
            }
        }
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        if (this.f6090x0) {
            int i10 = this.B0;
            if ((i10 & 4) == 0 || (i10 & 1) == 0) {
                return;
            }
            this.B0 = i10 & (-5);
            pc.a.a("resume barcode from lifecycle", new Object[0]);
            q3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(final View view, Bundle bundle) {
        super.X1(view, bundle);
        if (n3.h(I())) {
            l0().h().h(d1(), this.f6079m0);
        }
        view.post(new Runnable() { // from class: fb.j
            @Override // java.lang.Runnable
            public final void run() {
                q.g3(this.f6073e);
            }
        });
        this.f6088v0 = l0.h(I());
        this.f6089w0 = l0.i(I());
        this.f6084r0.setVisibility(8);
        this.f6084r0.setOnClickListener(new View.OnClickListener() { // from class: fb.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q.e3(this.f6074a, view, view2);
            }
        });
        this.f6081o0.getBarcodeView().setDecoderFactory(new t5.l(2052));
        this.f6081o0.b(this.f6091y0);
        this.f6082p0.setOnClickListener(new View.OnClickListener() { // from class: fb.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6076a.r3();
            }
        });
        this.f6083q0.setOnClickListener(new View.OnClickListener() { // from class: fb.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q.f3(this.f6077a, view2);
            }
        });
        y.F(this.f6083q0, -1);
        o3(Resources.getSystem().getConfiguration());
        l3.b(this.f6080n0);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() { // from class: fb.n
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return q.i3(this.f6078a, view2, i10, keyEvent);
            }
        });
        if (!this.f6088v0) {
            r3.k(this.f6082p0, false);
            this.f6084r0.setVisibility(0);
            this.f6084r0.setEnabled(false);
            this.f6084r0.setText(u.L8);
            return;
        }
        if (g6.f.g(I(), "android.permission.CAMERA")) {
            this.f6090x0 = true;
            r3.k(this.f6082p0, this.f6089w0);
            pc.a.a("resume barcode with permission", new Object[0]);
            q3();
            return;
        }
        r3.k(this.f6082p0, false);
        if (c0.f()) {
            this.f6084r0.setVisibility(0);
        } else {
            this.A0.a("android.permission.CAMERA");
        }
    }

    public final void n3() {
        String str = this.f6085s0;
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f6081o0.performHapticFeedback(3, 2);
        Bundle bundle = new Bundle();
        bundle.putString("qrcode", this.f6085s0);
        N0().x1("qrcode", bundle);
        l0().onBackPressed();
    }

    public final void o3(Configuration configuration) {
        int iAbs;
        int iH = y.h(I(), configuration.screenWidthDp);
        int iH2 = y.h(I(), configuration.screenHeightDp);
        boolean z10 = configuration.orientation == 2;
        double d10 = z10 ? 0.6d : 0.75d;
        if (this.f6087u0 == d10) {
            return;
        }
        this.f6087u0 = d10;
        double dMin = Math.min(iH2, iH);
        Double.isNaN(dMin);
        int iMin = Math.min((int) (dMin * d10), y.h(I(), 320.0f));
        this.f6081o0.getBarcodeView().setFramingRectSize(new v(iMin, iMin));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6082p0.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f6083q0.getLayoutParams();
        int iH3 = y.h(I(), 48.0f);
        if (z10) {
            int iH4 = y.h(I(), 32.0f);
            int i10 = (iMin / 2) - (iH3 / 2);
            if (Build.VERSION.SDK_INT < 30 || l3.g(this.f6082p0)) {
                iAbs = 0;
            } else {
                Insets insets = this.f6080n0.getRootWindowInsets().getInsets(WindowInsets.Type.systemBars());
                iH4 += insets.right;
                iAbs = Math.abs(insets.top - insets.bottom) >> 1;
            }
            layoutParams.gravity = 8388629;
            layoutParams2.gravity = 8388629;
            layoutParams.setMargins(0, 0, iH4, i10 + iAbs);
            layoutParams2.setMargins(0, i10 - iAbs, iH4, 0);
        } else {
            int iH5 = y.h(I(), 32.0f);
            int i11 = (iMin / 2) - (iH3 / 2);
            layoutParams.setMargins(0, 0, i11, iH5);
            layoutParams.gravity = 81;
            layoutParams2.setMargins(i11, 0, 0, iH5);
            layoutParams2.gravity = 81;
        }
        this.f6082p0.setLayoutParams(layoutParams);
        this.f6083q0.setLayoutParams(layoutParams2);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o3(configuration);
    }

    public final void p3() {
        t5.k kVar;
        if (!this.f6088v0 || (kVar = this.f6081o0) == null) {
            return;
        }
        if ((this.B0 & 1) == 0) {
            kVar.e();
            this.B0 |= 1;
            pc.a.a("pause barcode", new Object[0]);
        }
        this.B0 &= -3;
    }

    public final void q3() {
        t5.k kVar;
        if (!this.f6088v0 || (kVar = this.f6081o0) == null) {
            return;
        }
        if ((this.B0 & 2) == 0) {
            kVar.f();
            this.B0 |= 2;
            pc.a.a("resume barcode", new Object[0]);
        }
        this.B0 &= -2;
    }

    public final void r3() {
        boolean z10 = this.f6086t0;
        this.f6086t0 = !z10;
        if (z10) {
            this.f6081o0.g();
        } else {
            this.f6081o0.h();
        }
        this.f6082p0.setSelected(this.f6086t0);
        y.S(this.f6086t0 ? x8.h.j(I()) : g6.f.b(I(), R.color.white), this.f6082p0);
    }
}
