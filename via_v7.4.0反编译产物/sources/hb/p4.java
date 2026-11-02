package hb;

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
import h6.a;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p4 extends o8.g {

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6707s0;

    /* renamed from: r0, reason: collision with root package name */
    public final w9.l f6706r0 = pa.r.j();

    /* renamed from: t0, reason: collision with root package name */
    public View f6708t0 = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f6709a;

        public a(FrameLayout frameLayout) {
            this.f6709a = frameLayout;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            this.f6709a.setForeground(new g6.g().c(g6.f.d(p4.this.I(), x7.n.f13697p)).h(Color.argb(i10, 0, 0, 0)).a());
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            p4.this.f6706r0.Y0(seekBar.getProgress());
            w9.n.e().y(true);
        }
    }

    public static /* synthetic */ void h3(p4 p4Var, TextView textView) {
        p4Var.getClass();
        textView.setText(z8.f.c());
        textView.setGravity(17);
        textView.setTextSize(0, x8.h.r(p4Var.I()));
        textView.setTextColor(g6.e.a(p4Var.I(), x7.k.f13665k));
    }

    public static /* synthetic */ void k3(p4 p4Var, FrameLayout frameLayout, SeekBar seekBar) {
        p4Var.getClass();
        seekBar.setMax(154);
        z8.r3.g(seekBar);
        seekBar.setMinimumHeight(g6.y.h(p4Var.I(), 2.0f));
        seekBar.setOnSeekBarChangeListener(p4Var.new a(frameLayout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(View view, int i10, a6.n nVar) {
        if (nVar.c() == 2) {
            nVar.j(!nVar.i());
            if (nVar.i() && !this.f6706r0.m2().t() && Build.VERSION.SDK_INT < 29) {
                g6.n.q(I(), x7.u.f13940cb);
            }
            this.f6706r0.Q(nVar.i());
            this.f6707s0.m(i10);
            w9.n.e().y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(View view, int i10, a6.q qVar) {
        if (qVar.c() == 1) {
            p3();
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.J8)));
        arrayList.add(new a6.n(2, Z0(x7.u.M5), Z0(x7.u.N5), this.f6706r0.S2()));
        y5.f fVar = new y5.f(arrayList);
        this.f6707s0 = fVar;
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.k4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6627a.o3(view2, i10, (a6.q) obj);
            }
        }));
        this.f6707s0.K(a6.n.class, new a6.p(new y5.g() { // from class: hb.l4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6642a.n3(view2, i10, (a6.n) obj);
            }
        }));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        this.f10459q0.setAdapter(this.f6707s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.P);
    }

    public final View m3() {
        View view = this.f6708t0;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: hb.m4
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    ((LinearLayout) obj).setOrientation(1);
                }
            }).l();
            final FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -2)).r(1, 22, 16, 22, 16).l();
            TextView textView = (TextView) new h6.a(new TextView(I()), new ViewGroup.LayoutParams(-1, -2)).H(1, 0, 32, 0, 32).V(new a.InterfaceC0076a() { // from class: hb.n4
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    p4.h3(this.f6675a, (TextView) obj);
                }
            }).l();
            SeekBar seekBar = (SeekBar) new h6.a(new SeekBar(new ContextThemeWrapper(l0(), x7.v.f14259f)), new FrameLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).r(1, 16, 0, 16, 16).V(new a.InterfaceC0076a() { // from class: hb.o4
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    p4.k3(this.f6690a, frameLayout, (SeekBar) obj);
                }
            }).l();
            frameLayout.addView(textView);
            linearLayout.addView(frameLayout);
            linearLayout.addView(seekBar);
            seekBar.setProgress(this.f6706r0.n2());
            this.f6708t0 = linearLayout;
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f6708t0);
        }
        return this.f6708t0;
    }

    public final void p3() {
        w5.k.l(I()).y(m3()).f0();
    }
}
