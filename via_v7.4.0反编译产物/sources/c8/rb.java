package c8;

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
import h6.a;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class rb extends k8.a {
    public ImageView C0;
    public Bitmap D0;
    public final androidx.activity.result.b E0 = z8.z1.d(this, new Runnable() { // from class: c8.jb
        @Override // java.lang.Runnable
        public final void run() {
            this.f2554e.t3();
        }
    });

    public static /* synthetic */ void l3(rb rbVar, Boolean bool) {
        rbVar.getClass();
        if (!bool.booleanValue()) {
            g6.n.q(rbVar.I(), x7.u.xg);
        } else {
            g6.n.q(rbVar.I(), x7.u.Bb);
            rbVar.X2();
        }
    }

    public static /* synthetic */ void m3(final rb rbVar, TextView textView) {
        rbVar.getClass();
        textView.setText(x7.u.f13901a0);
        textView.setTextColor(x8.h.j(rbVar.I()));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, x8.h.r(rbVar.I()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: c8.qb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2790a.t3();
            }
        });
        x8.g.d(textView);
    }

    public static /* synthetic */ Bitmap n3(String str) {
        int i10 = 512;
        while (i10 < str.length()) {
            i10 *= 2;
        }
        return t5.z.a(str, i10);
    }

    public static /* synthetic */ void o3(rb rbVar, Bitmap bitmap) {
        rbVar.D0 = bitmap;
        rbVar.C0.setImageBitmap(bitmap);
    }

    public static /* synthetic */ Boolean q3(rb rbVar) throws IOException {
        OutputStream outputStreamL;
        rbVar.getClass();
        Uri uriC = z8.b1.c(rbVar.I(), Environment.DIRECTORY_DOWNLOADS, "qrcode-" + new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + ".png", "image/png");
        if (uriC == null || (outputStreamL = z8.b1.l(rbVar.I(), uriC)) == null) {
            return null;
        }
        boolean z10 = false;
        try {
            try {
                if (rbVar.D0.compress(Bitmap.CompressFormat.PNG, 100, outputStreamL)) {
                    mark.via.download.i1.f(rbVar.I(), uriC);
                    z10 = true;
                }
            } catch (Exception e10) {
                pc.a.i(e10);
            }
            return Boolean.valueOf(z10);
        } finally {
            g6.j.a(outputStreamL);
        }
    }

    public static rb s3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        rb rbVar = new rb();
        rbVar.H2(bundle);
        return rbVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C0 = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-1, (int) (r3() * 1.0f))).w(g6.y.h(I(), 6.0f)).Q(g6.y.h(I(), 6.0f)).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new FrameLayout.LayoutParams(-1, -2)).S(g6.y.h(I(), 14.0f)).e(g6.f.e(I(), x7.o.f13723f)).V(new a.InterfaceC0076a() { // from class: c8.kb
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                rb.m3(this.f2647a, (TextView) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: c8.lb
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(this.C0);
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        if (Z2() == null || Z2().getWindow() == null) {
            return;
        }
        Z2().getWindow().setLayout(r3(), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        final String string = y0() == null ? null : y0().getString("url");
        if (string == null || string.isEmpty()) {
            X2();
        } else {
            ((autodispose2.m) x6.f.h(new Callable() { // from class: c8.mb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return rb.n3(string);
                }
            }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: c8.nb
                @Override // a7.e
                public final void accept(Object obj) {
                    rb.o3(this.f2722e, (Bitmap) obj);
                }
            }, new x7.g0());
        }
    }

    public final int r3() {
        return (int) Math.min(g6.y.p(I()) * 0.72f, g6.y.h(I(), 420.0f));
    }

    public final void t3() {
        if (this.D0 == null) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 || i10 < 23 || g6.f.g(I(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.ob
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return rb.q3(this.f2755e);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.pb
                @Override // a7.e
                public final void accept(Object obj) {
                    rb.l3(this.f2773e, (Boolean) obj);
                }
            }, new x7.c0());
            return;
        }
        try {
            this.E0.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }
}
