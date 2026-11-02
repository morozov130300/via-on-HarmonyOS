package a8;

import a8.u1;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.IconCompat;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.Callable;
import mark.via.Shell;
import p.r;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u1 extends k8.a {
    public EditText C0;
    public EditText D0;
    public ImageView E0;
    public Bitmap F0;
    public Bitmap G0;
    public final androidx.activity.result.b H0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: a8.r1
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            u1.m3(this.f252a, (Uri) obj);
        }
    });

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            try {
                u1.this.H0.a(null);
            } catch (ActivityNotFoundException e10) {
                pc.a.d(e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {
        public b() {
        }

        public static /* synthetic */ void b(b bVar, String str, String str2, Bitmap bitmap) throws PackageManager.NameNotFoundException {
            u1.this.X2();
            u1.this.y3(str, str2, bitmap);
        }

        public static /* synthetic */ Bitmap c(b bVar, String str, String str2) {
            if (u1.this.G0 == null) {
                u1 u1Var = u1.this;
                Context contextI = u1Var.I();
                if (TextUtils.isEmpty(str)) {
                    str = "http://viayoo.com/";
                }
                u1Var.F0 = w3.q(contextI, str, str2);
            }
            u1 u1Var2 = u1.this;
            Bitmap bitmap = u1Var2.G0;
            u1 u1Var3 = u1.this;
            return u1Var2.w3(bitmap != null ? u1Var3.G0 : u1Var3.F0, 0.32f);
        }

        @Override // v5.c
        public void a(View view) {
            final String strTrim = u1.this.D0.getText().toString().trim();
            if (strTrim.isEmpty()) {
                g6.y.X(u1.this.D0);
                g6.n.i(u1.this.D0);
                return;
            }
            final String string = u1.this.C0.getText().toString();
            if (string.isEmpty()) {
                g6.y.X(u1.this.C0);
                g6.n.i(u1.this.C0);
            } else {
                u1.this.z3(strTrim, string);
                ((autodispose2.r) x6.o.g(new Callable() { // from class: a8.v1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return u1.b.c(this.f265e, strTrim, string);
                    }
                }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(u1.this.d1()))).a(new a7.e() { // from class: a8.w1
                    @Override // a7.e
                    public final void accept(Object obj) throws PackageManager.NameNotFoundException {
                        u1.b.b(this.f270e, strTrim, string, (Bitmap) obj);
                    }
                }, new x7.g0());
            }
        }
    }

    public static /* synthetic */ Boolean j3(u1 u1Var, Uri uri) throws IOException {
        String strK = z8.c1.k(u1Var.I(), "icons", "cache.png");
        if (strK == null) {
            return Boolean.FALSE;
        }
        File file = new File(strK);
        if (file.exists() && !file.delete()) {
            return Boolean.FALSE;
        }
        String strB = z8.c1.b(u1Var.I(), uri, file);
        if (strB != null && !strB.isEmpty() && w3.c(file)) {
            u1Var.G0 = BitmapFactory.decodeFile(strB);
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ void l3(u1 u1Var, Boolean bool) {
        Bitmap bitmap;
        u1Var.getClass();
        if (!bool.booleanValue() || (bitmap = u1Var.G0) == null) {
            return;
        }
        u1Var.E0.setImageBitmap(bitmap);
    }

    public static /* synthetic */ void m3(final u1 u1Var, Uri uri) {
        u1Var.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.h(uri).i(new a7.f() { // from class: a8.s1
            @Override // a7.f
            public final Object apply(Object obj) {
                return u1.j3(this.f255a, (Uri) obj);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(u1Var.d1()))).a(new a7.e() { // from class: a8.t1
            @Override // a7.e
            public final void accept(Object obj) {
                u1.l3(this.f258e, (Boolean) obj);
            }
        }, new x7.c0());
    }

    public static u1 x3(String str, String str2) {
        Bundle bundle = new Bundle();
        u1 u1Var = new u1();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        u1Var.H2(bundle);
        return u1Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13871f, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        ((TextView) view.findViewById(x7.p.H1)).setText(x7.u.f14203w0);
        this.C0 = (EditText) view.findViewById(x7.p.f13831p);
        this.D0 = (EditText) view.findViewById(x7.p.f13834q);
        ImageView imageView = (ImageView) view.findViewById(x7.p.S);
        this.E0 = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iH = g6.y.h(I(), 48.0f);
        layoutParams.height = iH;
        layoutParams.width = iH;
        this.E0.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(x7.p.f13812i1);
        TextView textView2 = (TextView) view.findViewById(x7.p.f13797d1);
        String string = y0() == null ? "" : y0().getString("title", "");
        this.C0.setText(string);
        String string2 = y0() != null ? y0().getString("url", "") : "";
        this.D0.setText(string2);
        Context contextI = I();
        if (TextUtils.isEmpty(string2)) {
            string2 = "http://viayoo.com/";
        }
        Bitmap bitmapQ = w3.q(contextI, string2, string);
        this.F0 = bitmapQ;
        this.E0.setImageBitmap(bitmapQ);
        this.E0.setOnClickListener(new a());
        textView.setOnClickListener(new b());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: a8.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f250a.X2();
            }
        });
    }

    public final Bitmap w3(Bitmap bitmap, float f10) {
        if (bitmap == null || f10 <= 0.0f || f10 > 1.0f || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return bitmap;
        }
        int pixel = bitmap.getPixel(0, 0);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i10 = (int) (width * f10);
        int i11 = (int) (height * f10);
        pc.a.a("padding: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(pixel);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i12 = i10 / 2;
        int i13 = i11 / 2;
        Bitmap bitmapB = z8.i.b(bitmap, width - i10, height - i11);
        if (bitmapB == null) {
            bitmapCreateBitmap.recycle();
            return bitmap;
        }
        pc.a.a("position: %dx%d", Integer.valueOf(i12), Integer.valueOf(i13));
        canvas.drawBitmap(bitmapB, i12, i13, (Paint) null);
        return bitmapCreateBitmap;
    }

    public final void y3(String str, String str2, Bitmap bitmap) throws PackageManager.NameNotFoundException {
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(I(), (Class<?>) Shell.class);
        intent.setPackage("mark.via");
        intent.setData(Uri.parse(str));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        String strF = i6.i0.f7006a.f(str);
        if (strF.isEmpty()) {
            strF = g6.p.j(str, 32);
        }
        p.r rVarA = new r.a(I(), "sc_" + z8.v0.g(str)).b(bitmap == null ? IconCompat.f(I(), x7.s.f13892a) : IconCompat.d(bitmap)).e(str2).c(intent).a();
        if (w8.e.h(I(), rVarA.c())) {
            p.z.h(I(), Collections.singletonList(rVarA));
            g6.n.s(I(), a1(x7.u.jh, strF));
        } else {
            p.z.g(I(), rVarA, null);
            g6.n.s(I(), a1(x7.u.J2, strF));
        }
    }

    public final void z3(String str, String str2) {
        Context contextI = I();
        if (TextUtils.isEmpty(str)) {
            str = "http://viayoo.com/";
        }
        Bitmap bitmapQ = w3.q(contextI, str, str2);
        this.F0 = bitmapQ;
        this.E0.setImageBitmap(bitmapQ);
    }
}
