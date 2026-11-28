package i8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import autodispose2.r;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.e0;
import java.io.File;
import java.util.concurrent.Callable;
import r6.q;
import w7.u;
import x8.c1;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public String f6315r0 = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ProgressBar f6316s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public TextView f6317t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ScrollView f6318u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public e0 f6319v0;

    public static /* synthetic */ void a3(r5.b bVar) {
        bVar.setFillViewport(true);
        r3.g(bVar);
        r3.i(bVar);
    }

    public static /* synthetic */ void c3(k kVar, x.d dVar) {
        kVar.f6316s0.setVisibility(8);
        kVar.f6318u0.setVisibility(0);
        if (!com.tuyafeng.support.utils.p.f((String) dVar.f14455a)) {
            kVar.f6319v0.setTitle((CharSequence) dVar.f14455a);
        }
        Object obj = dVar.f14456b;
        if (obj != null) {
            kVar.f6317t0.setText((CharSequence) obj);
            return;
        }
        kVar.f6317t0.setText("Cannot read file at: " + kVar.f6315r0);
    }

    public static /* synthetic */ void e3(k kVar, TextView textView) {
        kVar.getClass();
        textView.setTextIsSelectable(true);
        textView.setTypeface(Typeface.MONOSPACE);
        v8.g.m(textView, v8.h.t(kVar.G()));
        v8.g.l(textView);
        r3.p(textView, false);
    }

    public static /* synthetic */ x.d f3(k kVar) {
        String str = kVar.f6315r0;
        File file = (str == null || str.isEmpty()) ? null : new File(kVar.f6315r0);
        return x.d.a(file != null ? file.getName() : null, c1.O(file));
    }

    public static Bundle g3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("file_path", str);
        return bundle;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        view.postDelayed(new Runnable() { // from class: i8.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f6312c.h3();
            }
        }, 200L);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f6318u0 = (ScrollView) new b6.a(new r5.b(G()), new FrameLayout.LayoutParams(-2, -2)).V(new b6.a.InterfaceC0033a() { // from class: i8.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.a3((r5.b) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(G()), new ViewGroup.LayoutParams(-1, -2)).E(x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: i8.f
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.e3(this.f6311a, (TextView) obj);
            }
        }).l();
        this.f6317t0 = textView;
        this.f6318u0.addView(textView);
        this.f6316s0 = (ProgressBar) new b6.a(new ProgressBar(G()), new FrameLayout.LayoutParams(-2, -2)).p(17).V(new b6.a.InterfaceC0033a() { // from class: i8.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((ProgressBar) obj).setIndeterminate(false);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        frameLayout.addView(this.f6316s0);
        frameLayout.addView(this.f6318u0);
        return frameLayout;
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, u.oi);
        this.f6319v0 = e0Var;
    }

    public final void h3() {
        if (o1()) {
            this.f6316s0.setVisibility(0);
            this.f6318u0.setVisibility(8);
            ((r) q.f(new Callable() { // from class: i8.i
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k.f3(this.f6313c);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: i8.j
                @Override // u6.f
                public final void accept(Object obj) {
                    k.c3(this.f6314c, (x.d) obj);
                }
            }, new w7.e0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (w0() != null) {
            this.f6315r0 = w0().getString("file_path");
        }
    }
}
