package hb;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public TextView f5977r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public List f5978s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f5979t0 = 0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f5980u0 = false;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f5981v0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f5982w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends r5.b {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onScrollChanged(int i10, int i11, int i12, int i13) {
            super.onScrollChanged(i10, i11, i12, i13);
            if (getChildCount() > 0 && getChildAt(getChildCount() - 1).getBottom() - (getHeight() + getScrollY()) == 0) {
                n0.this.r3();
            }
        }
    }

    public static /* synthetic */ void a3(n0 n0Var, File file, q5.k kVar, Boolean bool) {
        n0Var.getClass();
        if (bool.booleanValue() && file.exists() && (x8.a0.e() || !n0Var.o3(file))) {
            n0Var.v3(file);
        }
        kVar.o();
    }

    public static /* synthetic */ void b3(r5.b bVar) {
        bVar.setFillViewport(true);
        x8.r3.g(bVar);
        x8.r3.i(bVar);
    }

    public static /* synthetic */ Integer c3(List list) {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (x8.c1.f((File) it.next())) {
                i10++;
            }
        }
        return Integer.valueOf(i10);
    }

    public static /* synthetic */ void d3(n0 n0Var, TextView textView) {
        n0Var.getClass();
        textView.setTextIsSelectable(true);
        textView.setTypeface(Typeface.MONOSPACE);
        v8.g.m(textView, v8.h.t(n0Var.G()));
        v8.g.l(textView);
        x8.r3.p(textView, false);
    }

    public static /* synthetic */ Boolean f3(File file, String str, List list, File file2) throws Throwable {
        File file3 = new File(file, "info.txt");
        x8.c1.Q(file3, str);
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(file3);
        return Boolean.valueOf(x8.f4.c(file2.getAbsolutePath(), arrayList));
    }

    public static /* synthetic */ void g3(n0 n0Var, Serializable serializable) {
        n0Var.f5980u0 = false;
        n0Var.f5977r0.setTextIsSelectable(false);
        n0Var.f5977r0.append((CharSequence) serializable);
        n0Var.f5977r0.setTextIsSelectable(true);
    }

    public static /* synthetic */ Serializable i3(n0 n0Var) {
        StringBuilder sb2 = new StringBuilder();
        if (!((File) n0Var.f5978s0.get(n0Var.f5979t0)).exists()) {
            n0Var.f5979t0++;
            n0Var.f5981v0 = 0L;
            return sb2;
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream((File) n0Var.f5978s0.get(n0Var.f5979t0)), "UTF-8");
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    n0Var.f5981v0 = bufferedReader.skip(n0Var.f5981v0);
                    String line = null;
                    for (int i10 = 0; i10 < 128 && (line = bufferedReader.readLine()) != null; i10++) {
                        n0Var.f5981v0 += (long) (line.length() + 1);
                        sb2.append(line);
                        sb2.append("\n");
                    }
                    if (line == null) {
                        n0Var.f5979t0++;
                        n0Var.f5981v0 = 0L;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb2.toString();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static /* synthetic */ void l3(n0 n0Var, Integer num) {
        n0Var.getClass();
        if (num.intValue() > 0) {
            n0Var.s3();
        }
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, n0.class, w7.u.Bc, w7.u.Cc, w7.u.f14068h3);
        hVar.c("about.debugging_log", -1, w7.u.f14068h3, "调试日志", "版本", "debugging info", "version");
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        s3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ScrollView scrollView = (ScrollView) new b6.a(new a(G()), new FrameLayout.LayoutParams(-2, -2)).V(new b6.a.InterfaceC0033a() { // from class: hb.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n0.b3((r5.b) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new ViewGroup.LayoutParams(-1, -2)).E(com.tuyafeng.support.utils.x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: hb.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n0.d3(this.f5896a, (TextView) obj);
            }
        }).l();
        this.f5977r0 = textView;
        scrollView.addView(textView);
        return scrollView;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        this.f5982w0 = e0Var;
        x8.v3.a(e0Var, w7.u.f14068h3);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, lb.g.a(G(), w7.o.C, w7.u.le), X0(w7.u.f14298y)), new View.OnClickListener() { // from class: hb.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n0 n0Var = this.f5861a;
                n0Var.t3(n0Var.f5978s0);
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, lb.g.a(G(), w7.o.f13809l1, w7.u.Kf), X0(w7.u.f14037f0)), new View.OnClickListener() { // from class: hb.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n0 n0Var = this.f5876a;
                n0Var.u3(n0Var.f5978s0);
            }
        });
    }

    public void n3(final List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n0.c3(list);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.c0
            @Override // u6.f
            public final void accept(Object obj) {
                n0.l3(this.f5822c, (Integer) obj);
            }
        }, new u6.f() { // from class: hb.d0
            @Override // u6.f
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public final boolean o3(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"yafengtu@gmail.com"});
        intent.putExtra("android.intent.extra.TEXT", "");
        intent.putExtra("android.intent.extra.SUBJECT", "Via Issue Report");
        Uri uriFromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT >= 24) {
            uriFromFile = FileProvider.f(G(), "mark.via.provider", file);
            intent.addFlags(1);
        }
        intent.putExtra("android.intent.extra.STREAM", uriFromFile);
        intent.addFlags(268435456);
        try {
            N2(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final List p3() {
        ArrayList<File> arrayList = new ArrayList();
        for (tc.a.b bVar : tc.a.g()) {
            if (bVar instanceof i8.d) {
                arrayList.add(new File(((i8.d) bVar).w()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file : arrayList) {
            if (file.exists() && file.isFile() && file.length() > 0) {
                arrayList2.add(file);
            }
        }
        return arrayList2;
    }

    public final void r3() {
        int i10;
        if (this.f5980u0 || (i10 = this.f5979t0) < 0 || i10 >= this.f5978s0.size()) {
            return;
        }
        this.f5980u0 = true;
        ((autodispose2.n) r6.j.v(new Callable() { // from class: hb.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n0.i3(this.f5783c);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: hb.e0
            @Override // u6.f
            public final void accept(Object obj) {
                n0.g3(this.f5849c, (Serializable) obj);
            }
        }, new w7.a0());
    }

    public final void s3() {
        List listP3 = p3();
        this.f5978s0 = listP3;
        this.f5982w0.j(0, !listP3.isEmpty());
        this.f5977r0.setText(x8.f.d(G()));
        this.f5977r0.append("\n\n");
        this.f5979t0 = 0;
        this.f5981v0 = 0L;
        this.f5980u0 = false;
        r3();
    }

    public final void t3(final List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(Y0(w7.u.f14222s3, "logs")).X(w7.u.f14298y, new q5.k.m() { // from class: hb.m0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                this.f5962a.n3(list);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void u3(final List list) {
        if (list.size() <= 0) {
            return;
        }
        final q5.k kVarV = q5.k.l(G()).Z(w7.u.si).u(false).v(false);
        kVarV.h0();
        final File parentFile = ((File) list.get(0)).getParentFile();
        final File file = new File(parentFile, "via-log-" + new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + ".zip");
        final String strD = x8.f.d(G());
        ((autodispose2.n) r6.j.v(new Callable() { // from class: hb.j0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n0.f3(parentFile, strD, list, file);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: hb.k0
            @Override // u6.f
            public final void accept(Object obj) {
                n0.a3(this.f5928c, file, kVarV, (Boolean) obj);
            }
        }, new u6.f() { // from class: hb.l0
            @Override // u6.f
            public final void accept(Object obj) {
                kVarV.o();
            }
        });
    }

    public final void v3(File file) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/zip");
        Uri uriFromFile = Uri.fromFile(file);
        if (Build.VERSION.SDK_INT >= 24) {
            uriFromFile = FileProvider.f(G(), "mark.via.provider", file);
            intent.addFlags(1);
        }
        intent.putExtra("android.intent.extra.STREAM", uriFromFile);
        intent.addFlags(268435456);
        N2(intent);
    }
}
