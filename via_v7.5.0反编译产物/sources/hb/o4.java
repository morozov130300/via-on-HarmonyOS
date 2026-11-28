package hb;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o4 extends m8.f {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6001v0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final u9.l f6000u0 = la.s.j();

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public View f6002w0 = null;

    public static /* synthetic */ void g3(o4 o4Var, TextView textView) {
        o4Var.getClass();
        textView.setText(x8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, v8.h.q(o4Var.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(o4Var.G(), w7.k.f13732l));
    }

    public static /* synthetic */ void j3(o4 o4Var, FrameLayout frameLayout, SeekBar seekBar) {
        o4Var.getClass();
        seekBar.setMax(154);
        x8.r3.h(seekBar);
        seekBar.setMinimumHeight(com.tuyafeng.support.utils.x.h(o4Var.G(), 2.0f));
        seekBar.setOnSeekBarChangeListener(o4Var.new a(frameLayout));
    }

    public static List m3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, o4.class, w7.u.Fc, w7.u.Q);
        hVar.b(1, w7.u.V8, new String[0]);
        hVar.b(2, w7.u.Y5, new String[0]);
        return hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(View view, int i10, v5.n nVar) {
        if (nVar.c() == 2) {
            nVar.j(!nVar.i());
            if (nVar.i() && !this.f6000u0.n2().t() && Build.VERSION.SDK_INT < 29) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.f14174ob);
            }
            this.f6000u0.R(nVar.i());
            this.f6001v0.m(i10);
            u9.n.e().w(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(View view, int i10, v5.q qVar) {
        if (qVar.c() == 1) {
            p3();
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.V8)));
        arrayList.add(new v5.n(2, X0(w7.u.Y5), X0(w7.u.Z5), this.f6000u0.V2()));
        t5.f fVar = new t5.f(arrayList);
        this.f6001v0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.j4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5922a.o3(view2, i10, (v5.q) obj);
            }
        }));
        this.f6001v0.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.k4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5938a.n3(view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(this.f6001v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.Q);
    }

    public final View l3() {
        View view = this.f6002w0;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: hb.l4
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    ((LinearLayout) obj).setOrientation(1);
                }
            }).l();
            final FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -2)).r(1, 22, 16, 22, 16).l();
            TextView textView = (TextView) new b6.a(new TextView(G()), new ViewGroup.LayoutParams(-1, -2)).H(1, 0, 32, 0, 32).V(new b6.a.InterfaceC0033a() { // from class: hb.m4
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    o4.g3(this.f5972a, (TextView) obj);
                }
            }).l();
            SeekBar seekBar = (SeekBar) new b6.a(new SeekBar(new ContextThemeWrapper(i0(), w7.v.f14329f)), new FrameLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).r(1, 16, 0, 16, 16).V(new b6.a.InterfaceC0033a() { // from class: hb.n4
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    o4.j3(this.f5989a, frameLayout, (SeekBar) obj);
                }
            }).l();
            frameLayout.addView(textView);
            linearLayout.addView(frameLayout);
            linearLayout.addView(seekBar);
            seekBar.setProgress(this.f6000u0.o2());
            this.f6002w0 = linearLayout;
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f6002w0);
        }
        return this.f6002w0;
    }

    public final void p3() {
        q5.k.l(G()).z(l3()).h0();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f6003a;

        public a(FrameLayout frameLayout) {
            this.f6003a = frameLayout;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            this.f6003a.setForeground(new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.f.d(o4.this.G(), w7.n.f13763p)).h(Color.argb(i10, 0, 0, 0)).a());
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            o4.this.f6000u0.a1(seekBar.getProgress());
            u9.n.e().w(true);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }
}
