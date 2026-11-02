package z7;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import w5.k;
import z8.c1;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public EditText f14657o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f14658p0;

    /* renamed from: q0, reason: collision with root package name */
    public u4.a f14659q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f14660r0 = "";

    public static /* synthetic */ void c3(Runnable runnable, View view, k.p pVar) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void d3(final v vVar, View view) {
        vVar.getClass();
        vVar.v3(new Runnable() { // from class: z7.j
            @Override // java.lang.Runnable
            public final void run() {
                z8.b0.P(this.f14627e.I(), "https://help.eyeo.com/en/adblockplus/how-to-write-filters");
            }
        });
    }

    public static /* synthetic */ void e3(final v vVar, w.d dVar) {
        vVar.getClass();
        z8.h.b(new Runnable() { // from class: z7.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f14631e.f14659q0.i();
            }
        });
    }

    public static /* synthetic */ void h3(q4.b bVar) {
        bVar.setFillViewport(true);
        r3.f(bVar);
        r3.h(bVar);
    }

    public static /* synthetic */ void i3(v vVar, final Runnable runnable, w.d dVar) {
        vVar.getClass();
        Object obj = dVar.f13208b;
        if (obj != null && !((List) obj).isEmpty()) {
            w5.k.l(vVar.I()).d0(x7.u.lg).J(TextUtils.join("\n", (Iterable) dVar.f13208b)).t(false).u(false).V(R.string.ok, new k.m() { // from class: z7.k
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    v.c3(runnable, view, pVar);
                }
            }).f0();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void n3(v vVar, EditText editText) {
        vVar.getClass();
        x8.g.h(editText);
        editText.setInputType(655361);
        editText.setTextColor(g6.e.a(vVar.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(vVar.I(), x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(vVar.I()));
        editText.setGravity(48);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setHint(x7.u.f13952d9);
        r3.o(editText, false);
    }

    public static /* synthetic */ x5.a o3(v vVar) {
        vVar.getClass();
        return x5.a.f(c1.O(new File(vVar.f14658p0)));
    }

    public static /* synthetic */ void p3(v vVar, x5.a aVar) {
        vVar.getClass();
        if (!aVar.d()) {
            vVar.f14660r0 = "";
            return;
        }
        String str = (String) aVar.b();
        vVar.f14660r0 = z8.v0.d(str);
        vVar.f14657o0.setText(str);
    }

    public static /* synthetic */ w.d q3(v vVar) {
        String string = vVar.f14657o0.getText().toString();
        if (!c1.Q(new File(vVar.f14658p0), string)) {
            return new w.d(Boolean.FALSE, null);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : (string == null || string.isEmpty()) ? new String[0] : string.split("\n")) {
            if (str != null && !str.isEmpty() && str.charAt(0) != '!' && b5.c.v(str) == null) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, vVar.I().getString(x7.u.J5));
        }
        return new w.d(Boolean.TRUE, arrayList);
    }

    private void u3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: z7.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return v.o3(this.f14643e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: z7.r
            @Override // a7.e
            public final void accept(Object obj) {
                v.p3(this.f14650e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        EditText editText = this.f14657o0;
        if (editText != null) {
            z8.f.e(editText);
        }
        super.O1();
    }

    @Override // o8.h
    public void V2() {
        v3(new n(this));
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f14658p0 = this.f14659q0.d();
        u3();
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ScrollView scrollView = (ScrollView) new h6.a(new q4.b(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: z7.f
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v.h3((q4.b) obj);
            }
        }).l();
        EditText editText = (EditText) new h6.a(new EditText(I()), new FrameLayout.LayoutParams(-1, -2)).T(1, 16).N(1, 12).f(0).V(new a.InterfaceC0076a() { // from class: z7.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                v.n3(this.f14633a, (EditText) obj);
            }
        }).l();
        this.f14657o0 = editText;
        scrollView.addView(editText);
        return scrollView;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.L2);
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.f13949d6)), new View.OnClickListener() { // from class: z7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14637a.t3();
            }
        });
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.Z)), new View.OnClickListener() { // from class: z7.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14641a.x3();
            }
        });
    }

    @Override // o8.h
    public boolean l() {
        return s3();
    }

    public final void r3() {
        super.V2();
    }

    public final boolean s3() {
        return z8.v0.d(this.f14657o0.getText().toString()).equals(this.f14660r0);
    }

    public final void t3() {
        w5.k.l(I()).d0(x7.u.f13949d6).I(x7.u.Gc).V(R.string.ok, null).R(x7.u.f14249z7, new View.OnClickListener() { // from class: z7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.d3(this.f14651a, view);
            }
        }).f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).y(this);
    }

    public final void v3(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (s3()) {
            runnable.run();
        } else {
            w5.k.l(I()).d0(x7.u.f14193v3).I(x7.u.f14185u8).V(x7.u.f14201vb, new k.m() { // from class: z7.t
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f14653a.w3(runnable);
                }
            }).N(x7.u.N4, new View.OnClickListener() { // from class: z7.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            }).f0();
        }
    }

    public final void w3(final Runnable runnable) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: z7.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return v.q3(this.f14618e);
            }
        }).d(new a7.e() { // from class: z7.h
            @Override // a7.e
            public final void accept(Object obj) {
                v.e3(this.f14622e, (w.d) obj);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: z7.i
            @Override // a7.e
            public final void accept(Object obj) {
                v.i3(this.f14624e, runnable, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final void x3() {
        if (s3()) {
            r3();
        } else {
            w3(new n(this));
        }
    }
}
