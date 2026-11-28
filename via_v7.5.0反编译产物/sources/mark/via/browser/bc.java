package mark.via.browser;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class bc extends i8.a {
    public ImageView E0;
    public Bitmap F0;
    public final androidx.activity.result.b G0 = x8.y1.d(this, new Runnable() { // from class: mark.via.browser.tb
        @Override // java.lang.Runnable
        public final void run() {
            this.f9673c.t3();
        }
    });

    public static /* synthetic */ void l3(bc bcVar, Boolean bool) {
        bcVar.getClass();
        if (!bool.booleanValue()) {
            com.tuyafeng.support.utils.n.q(bcVar.G(), w7.u.Ng);
        } else {
            com.tuyafeng.support.utils.n.q(bcVar.G(), w7.u.Ob);
            bcVar.V2();
        }
    }

    public static /* synthetic */ void m3(final bc bcVar, TextView textView) {
        bcVar.getClass();
        textView.setText(w7.u.f13981b0);
        textView.setTextColor(v8.h.j(bcVar.G()));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, v8.h.q(bcVar.G()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: mark.via.browser.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9019a.t3();
            }
        });
        v8.g.d(textView);
    }

    public static /* synthetic */ Bitmap n3(String str) {
        int i10 = 512;
        while (i10 < str.length()) {
            i10 *= 2;
        }
        return n5.z.a(str, i10);
    }

    public static /* synthetic */ void o3(bc bcVar, Bitmap bitmap) {
        bcVar.F0 = bitmap;
        bcVar.E0.setImageBitmap(bitmap);
    }

    public static /* synthetic */ Boolean q3(bc bcVar) {
        OutputStream outputStreamL;
        bcVar.getClass();
        Uri uriC = x8.b1.c(bcVar.G(), Environment.DIRECTORY_DOWNLOADS, "qrcode-" + new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + ".png", "image/png");
        if (uriC == null || (outputStreamL = x8.b1.l(bcVar.G(), uriC)) == null) {
            return null;
        }
        boolean z10 = false;
        try {
            try {
                if (bcVar.F0.compress(Bitmap.CompressFormat.PNG, 100, outputStreamL)) {
                    mark.via.download.t1.g(bcVar.G(), uriC);
                    z10 = true;
                }
            } catch (Exception e10) {
                tc.a.j(e10);
            }
            return Boolean.valueOf(z10);
        } finally {
            com.tuyafeng.support.utils.j.a(outputStreamL);
        }
    }

    public static bc s3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bc bcVar = new bc();
        bcVar.F2(bundle);
        return bcVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.E0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-1, (int) (r3() * 1.0f))).w(com.tuyafeng.support.utils.x.h(G(), 6.0f)).Q(com.tuyafeng.support.utils.x.h(G(), 6.0f)).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new FrameLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(G(), 14.0f)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13786e)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.ub
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                bc.m3(this.f9695a, (TextView) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.vb
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(this.E0);
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        if (X2() == null || X2().getWindow() == null) {
            return;
        }
        X2().getWindow().setLayout(r3(), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        final String string = w0() == null ? null : w0().getString("url");
        if (string == null || string.isEmpty()) {
            V2();
        } else {
            ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.wb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return bc.n3(string);
                }
            }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.xb
                @Override // u6.f
                public final void accept(Object obj) {
                    bc.o3(this.f9767c, (Bitmap) obj);
                }
            }, new w7.e0());
        }
    }

    public final int r3() {
        return (int) Math.min(com.tuyafeng.support.utils.x.p(G()) * 0.72f, com.tuyafeng.support.utils.x.h(G(), 420.0f));
    }

    public final void t3() {
        if (this.F0 == null) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 || i10 < 23 || com.tuyafeng.support.utils.f.g(G(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.yb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return bc.q3(this.f9799c);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.zb
                @Override // u6.f
                public final void accept(Object obj) {
                    bc.l3(this.f9832c, (Boolean) obj);
                }
            }, new w7.a0());
            return;
        }
        try {
            this.G0.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }
}
