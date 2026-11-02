package k8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tuyafeng.support.widget.z;
import g6.y;
import h6.a;
import java.io.File;
import java.util.concurrent.Callable;
import x7.g0;
import x7.u;
import z8.c1;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends o8.h {

    /* renamed from: o0, reason: collision with root package name */
    public String f8204o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public ProgressBar f8205p0;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f8206q0;

    /* renamed from: r0, reason: collision with root package name */
    public ScrollView f8207r0;

    /* renamed from: s0, reason: collision with root package name */
    public z f8208s0;

    public static /* synthetic */ void c3(k kVar, w.d dVar) {
        kVar.f8205p0.setVisibility(8);
        kVar.f8207r0.setVisibility(0);
        if (!g6.p.f((String) dVar.f13207a)) {
            kVar.f8208s0.setTitle((CharSequence) dVar.f13207a);
        }
        Object obj = dVar.f13208b;
        if (obj != null) {
            kVar.f8206q0.setText((CharSequence) obj);
            return;
        }
        kVar.f8206q0.setText("Cannot read file at: " + kVar.f8204o0);
    }

    public static /* synthetic */ void e3(k kVar, TextView textView) {
        kVar.getClass();
        textView.setTextIsSelectable(true);
        textView.setTypeface(Typeface.MONOSPACE);
        x8.g.m(textView, x8.h.u(kVar.I()));
        x8.g.l(textView);
        r3.o(textView, false);
    }

    public static /* synthetic */ void f3(q4.b bVar) {
        bVar.setFillViewport(true);
        r3.f(bVar);
        r3.h(bVar);
    }

    public static /* synthetic */ w.d g3(k kVar) {
        String str = kVar.f8204o0;
        File file = (str == null || str.isEmpty()) ? null : new File(kVar.f8204o0);
        return w.d.a(file != null ? file.getName() : null, c1.O(file));
    }

    public static Bundle h3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("file_path", str);
        return bundle;
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        view.postDelayed(new Runnable() { // from class: k8.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f8201e.i3();
            }
        }, 200L);
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f8207r0 = (ScrollView) new h6.a(new q4.b(I()), new FrameLayout.LayoutParams(-2, -2)).V(new a.InterfaceC0076a() { // from class: k8.e
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.f3((q4.b) obj);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(I()), new ViewGroup.LayoutParams(-1, -2)).E(y.h(I(), 16.0f)).V(new a.InterfaceC0076a() { // from class: k8.f
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.e3(this.f8200a, (TextView) obj);
            }
        }).l();
        this.f8206q0 = textView;
        this.f8207r0.addView(textView);
        this.f8205p0 = (ProgressBar) new h6.a(new ProgressBar(I()), new FrameLayout.LayoutParams(-2, -2)).p(17).V(new a.InterfaceC0076a() { // from class: k8.g
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((ProgressBar) obj).setIndeterminate(false);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        frameLayout.addView(this.f8205p0);
        frameLayout.addView(this.f8207r0);
        return frameLayout;
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        v3.a(zVar, u.Jh);
        this.f8208s0 = zVar;
    }

    public final void i3() {
        if (q1()) {
            this.f8205p0.setVisibility(0);
            this.f8207r0.setVisibility(8);
            ((autodispose2.r) x6.o.g(new Callable() { // from class: k8.i
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k.g3(this.f8202e);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: k8.j
                @Override // a7.e
                public final void accept(Object obj) {
                    k.c3(this.f8203e, (w.d) obj);
                }
            }, new g0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (y0() != null) {
            this.f8204o0 = y0().getString("file_path");
        }
    }
}
