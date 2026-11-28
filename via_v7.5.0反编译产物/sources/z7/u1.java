package z7;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
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
import java.util.Collections;
import java.util.concurrent.Callable;
import mark.via.Shell;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u1 extends i8.a {
    public EditText E0;
    public EditText F0;
    public ImageView G0;
    public Bitmap H0;
    public Bitmap I0;
    public final androidx.activity.result.b J0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: z7.r1
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            u1.m3(this.f15323a, (Uri) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            try {
                u1.this.J0.a(null);
            } catch (ActivityNotFoundException e10) {
                tc.a.e(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends p5.c {
        public b() {
        }

        public static /* synthetic */ void b(b bVar, String str, String str2, Bitmap bitmap) {
            u1.this.V2();
            u1.this.y3(str, str2, bitmap);
        }

        public static /* synthetic */ Bitmap c(b bVar, String str, String str2) {
            if (u1.this.I0 == null) {
                u1 u1Var = u1.this;
                Context contextG = u1Var.G();
                if (TextUtils.isEmpty(str)) {
                    str = "http://viayoo.com/";
                }
                u1Var.H0 = w3.q(contextG, str, str2);
            }
            u1 u1Var2 = u1.this;
            Bitmap bitmap = u1Var2.I0;
            u1 u1Var3 = u1.this;
            return u1Var2.w3(bitmap != null ? u1Var3.I0 : u1Var3.H0, 0.32f);
        }

        @Override // p5.c
        public void a(View view) {
            final String strTrim = u1.this.F0.getText().toString().trim();
            if (strTrim.isEmpty()) {
                com.tuyafeng.support.utils.x.Y(u1.this.F0);
                com.tuyafeng.support.utils.n.i(u1.this.F0);
                return;
            }
            final String string = u1.this.E0.getText().toString();
            if (string.isEmpty()) {
                com.tuyafeng.support.utils.x.Y(u1.this.E0);
                com.tuyafeng.support.utils.n.i(u1.this.E0);
            } else {
                u1.this.z3(strTrim, string);
                ((autodispose2.r) r6.q.f(new Callable() { // from class: z7.v1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return u1.b.c(this.f15336c, strTrim, string);
                    }
                }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(u1.this.b1()))).a(new u6.f() { // from class: z7.w1
                    @Override // u6.f
                    public final void accept(Object obj) {
                        u1.b.b(this.f15341c, strTrim, string, (Bitmap) obj);
                    }
                }, new w7.e0());
            }
        }
    }

    public static /* synthetic */ Boolean j3(u1 u1Var, Uri uri) {
        String strK = x8.c1.k(u1Var.G(), "icons", "cache.png");
        if (strK == null) {
            return Boolean.FALSE;
        }
        File file = new File(strK);
        if (file.exists() && !file.delete()) {
            return Boolean.FALSE;
        }
        String strB = x8.c1.b(u1Var.G(), uri, file);
        if (strB != null && !strB.isEmpty() && w3.c(file)) {
            u1Var.I0 = BitmapFactory.decodeFile(strB);
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ void l3(u1 u1Var, Boolean bool) {
        Bitmap bitmap;
        u1Var.getClass();
        if (!bool.booleanValue() || (bitmap = u1Var.I0) == null) {
            return;
        }
        u1Var.G0.setImageBitmap(bitmap);
    }

    public static /* synthetic */ void m3(final u1 u1Var, Uri uri) {
        u1Var.getClass();
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.g(uri).h(new u6.g() { // from class: z7.s1
            @Override // u6.g
            public final Object apply(Object obj) {
                return u1.j3(this.f15326a, (Uri) obj);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(u1Var.b1()))).a(new u6.f() { // from class: z7.t1
            @Override // u6.f
            public final void accept(Object obj) {
                u1.l3(this.f15329c, (Boolean) obj);
            }
        }, new w7.a0());
    }

    public static u1 x3(String str, String str2) {
        Bundle bundle = new Bundle();
        u1 u1Var = new u1();
        bundle.putString("title", str2);
        bundle.putString("url", str);
        u1Var.F2(bundle);
        return u1Var;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13937f, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ((TextView) view.findViewById(w7.p.H1)).setText(w7.u.f14299y0);
        this.E0 = (EditText) view.findViewById(w7.p.f13894o);
        this.F0 = (EditText) view.findViewById(w7.p.f13897p);
        ImageView imageView = (ImageView) view.findViewById(w7.p.R);
        this.G0 = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iH = com.tuyafeng.support.utils.x.h(G(), 48.0f);
        layoutParams.height = iH;
        layoutParams.width = iH;
        this.G0.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(w7.p.f13878i1);
        TextView textView2 = (TextView) view.findViewById(w7.p.f13863d1);
        String string = w0() == null ? "" : w0().getString("title", "");
        this.E0.setText(string);
        String string2 = w0() != null ? w0().getString("url", "") : "";
        this.F0.setText(string2);
        Context contextG = G();
        if (TextUtils.isEmpty(string2)) {
            string2 = "http://viayoo.com/";
        }
        Bitmap bitmapQ = w3.q(contextG, string2, string);
        this.H0 = bitmapQ;
        this.G0.setImageBitmap(bitmapQ);
        this.G0.setOnClickListener(new a());
        textView.setOnClickListener(new b());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: z7.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f15321a.V2();
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
        tc.a.a("padding: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(pixel);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i12 = i10 / 2;
        int i13 = i11 / 2;
        Bitmap bitmapB = x8.i.b(bitmap, width - i10, height - i11);
        if (bitmapB == null) {
            bitmapCreateBitmap.recycle();
            return bitmap;
        }
        tc.a.a("position: %dx%d", Integer.valueOf(i12), Integer.valueOf(i13));
        canvas.drawBitmap(bitmapB, i12, i13, (Paint) null);
        return bitmapCreateBitmap;
    }

    public final void y3(String str, String str2, Bitmap bitmap) {
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(G(), (Class<?>) Shell.class);
        intent.setPackage("mark.via");
        intent.setData(Uri.parse(str));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        String strG = c6.a2.f1958a.g(str);
        if (strG.isEmpty()) {
            strG = com.tuyafeng.support.utils.p.j(str, 32);
        }
        p.s sVarA = new p.s.a(G(), "sc_" + x8.v0.g(str)).b(bitmap == null ? IconCompat.f(G(), w7.s.f13958a) : IconCompat.d(bitmap)).e(str2).c(intent).a();
        if (u8.e.h(G(), sVarA.c())) {
            p.a0.h(G(), Collections.singletonList(sVarA));
            com.tuyafeng.support.utils.n.s(G(), Y0(w7.u.Ih, strG));
        } else {
            p.a0.g(G(), sVarA, null);
            com.tuyafeng.support.utils.n.s(G(), Y0(w7.u.V2, strG));
        }
    }

    public final void z3(String str, String str2) {
        Context contextG = G();
        if (TextUtils.isEmpty(str)) {
            str = "http://viayoo.com/";
        }
        Bitmap bitmapQ = w3.q(contextG, str, str2);
        this.H0 = bitmapQ;
        this.G0.setImageBitmap(bitmapQ);
    }
}
