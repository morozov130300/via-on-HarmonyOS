package j8;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f6.h;
import g6.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import z8.f1;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends k8.a {
    public RecyclerView C0;
    public y5.f D0;
    public int E0;
    public q F0;
    public long H0;
    public w9.l I0;
    public String G0 = null;
    public int J0 = -1;
    public final Handler K0 = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            TextView textView = (TextView) b6.c.h().a(viewGroup);
            textView.setGravity(17);
            return textView;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, String str, int i10) {
            TextView textView = (TextView) gVar.f1219a;
            textView.setText(str);
            int i11 = i10 == p.this.E0 ? 1 : 0;
            x8.g.e(textView, i11);
            int iH = y.h(p.this.I(), 16.0f);
            int iH2 = y.h(p.this.I(), 8.0f);
            textView.setPadding(iH, iH2, iH, iH2);
            textView.setSingleLine(false);
            textView.setTextColor(i11 != 0 ? x8.h.j(gVar.O()) : x8.h.o(gVar.O()));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    p.this.H0 = -1L;
                }
            } else if (p.this.H0 == -1) {
                p.this.H0 = SystemClock.elapsedRealtime() + 3000;
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements j8.d {
        public c() {
        }

        @Override // j8.d
        public void a(t tVar) {
            if (p.this.G0 != null && p.this.G0.equals(tVar.b()) && p.this.J0 < 0) {
                p.this.L3(tVar.a(), true);
            }
            if (p.this.c1() != null) {
                p.this.M3(!tVar.g() && tVar.h());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f7617a;

        public d(TextView textView) {
            this.f7617a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            this.f7617a.setText(String.format(Locale.ROOT, "%.2fx", Float.valueOf((i10 + 1) * 0.25f)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            float progress = (seekBar.getProgress() + 1) * 0.25f;
            p.this.I0.u0(progress);
            p.this.F0.g().g(progress);
            t tVarF = p.this.F0.f(p.this.G0);
            if (tVarF == null || !tVarF.h()) {
                return;
            }
            p pVar = p.this;
            pVar.K3(pVar.E0);
        }
    }

    private void D3() {
        List listA = this.F0.a();
        boolean z10 = true;
        if (listA.isEmpty()) {
            F3(true);
            return;
        }
        t tVar = (t) listA.get(0);
        M3(!tVar.g() && tVar.h());
        this.G0 = tVar.b();
        if (tVar.d() != null) {
            this.D0.M(new ArrayList(tVar.d()));
            this.D0.l();
            L3(tVar.a(), false);
        }
        if (tVar.d() != null && !tVar.d().isEmpty()) {
            z10 = false;
        }
        F3(z10);
    }

    public static p E3() {
        return new p();
    }

    private void N(String str) {
        new h.b(I()).h(str).a().s();
    }

    public static /* synthetic */ void l3(p pVar, View view) {
        LinearLayout linearLayout = (LinearLayout) pVar.C2().findViewById(x7.p.f13829o0);
        boolean z10 = linearLayout.findViewById(x7.p.E0).getVisibility() == 8;
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = linearLayout.getChildAt(i10);
            int id = childAt.getId();
            if (id == x7.p.C1) {
                TextView textView = (TextView) childAt;
                textView.setTypeface(z10 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                textView.setTextColor(z10 ? x8.h.j(pVar.I()) : x8.h.p(pVar.I()));
            } else if (!(z10 && id == x7.p.E0) && (z10 || id == x7.p.E0)) {
                childAt.setVisibility(8);
            } else {
                childAt.setVisibility(0);
                childAt.setAlpha(0.0f);
                x.r.c(childAt).a(1.0f).d(200L).f();
            }
        }
    }

    public static /* synthetic */ void n3(p pVar, View view) {
        pVar.getClass();
        Intent intentE = f1.e();
        try {
            pVar.G3(true);
            pVar.P2(intentE);
        } catch (Exception unused) {
            pVar.N(pVar.Z0(x7.u.xg));
        }
    }

    public static /* synthetic */ boolean p3(p pVar, View view, int i10, String str) {
        pVar.getClass();
        pVar.H0 = SystemClock.elapsedRealtime() + 3000;
        t tVarF = pVar.F0.f(pVar.G0);
        g6.n.a(pVar.I(), tVarF == null ? null : tVarF.c(i10), x7.u.og);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13875j, viewGroup, false);
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void F1() {
        this.K0.removeCallbacksAndMessages(null);
        super.F1();
    }

    public final void F3(boolean z10) {
        View viewC1 = c1();
        if (viewC1 == null) {
            return;
        }
        viewC1.findViewById(x7.p.f13818k1).setVisibility(z10 ? 0 : 8);
        viewC1.findViewById(x7.p.f13829o0).setVisibility(z10 ? 8 : 0);
        viewC1.findViewById(x7.p.C0).setVisibility(z10 ? 8 : 0);
    }

    public final void G3(boolean z10) {
        t tVarF = this.F0.f(this.G0);
        if (tVarF == null) {
            return;
        }
        if (tVarF.h()) {
            e.a(I(), null);
        } else {
            if (z10) {
                return;
            }
            if (tVarF.g()) {
                tVarF.i(0);
            }
            e.b(I(), tVarF.b());
        }
    }

    public final void H3() {
        t tVarF = this.F0.f(this.G0);
        if (tVarF == null || tVarF.d() == null || tVarF.d().isEmpty()) {
            return;
        }
        this.H0 = 0L;
        K3(Math.max(0, Math.min(tVarF.d().size() - 1, this.J0)));
        this.J0 = -1;
    }

    public final void I3() {
        if (this.J0 < 0) {
            this.J0 = this.E0;
        }
        int i10 = this.J0 + 1;
        this.J0 = i10;
        L3(i10, true);
        this.K0.removeCallbacksAndMessages(null);
        this.K0.postDelayed(new o(this), 300L);
    }

    public final void J3() {
        if (this.J0 < 0) {
            this.J0 = this.E0;
        }
        int iMax = Math.max(0, this.J0 - 1);
        this.J0 = iMax;
        L3(iMax, true);
        this.K0.removeCallbacksAndMessages(null);
        this.K0.postDelayed(new o(this), 300L);
    }

    public final void K3(int i10) {
        e.c(I(), this.G0, i10);
    }

    public final void L3(int i10, boolean z10) {
        int i11 = this.E0;
        if (i10 == i11) {
            return;
        }
        this.E0 = i10;
        if (i11 >= 0 && i11 < this.D0.g()) {
            this.D0.m(i11);
        }
        int i12 = this.E0;
        if (i12 < 0 || i12 >= this.D0.g()) {
            return;
        }
        this.D0.m(this.E0);
        if (this.H0 < 0 || SystemClock.elapsedRealtime() <= this.H0) {
            return;
        }
        if (z10) {
            this.C0.post(new Runnable() { // from class: j8.m
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = this.f7611e;
                    pVar.C0.x1(pVar.E0);
                }
            });
        } else {
            this.C0.post(new Runnable() { // from class: j8.n
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = this.f7612e;
                    pVar.C0.p1(pVar.E0);
                }
            });
        }
    }

    public final void M3(boolean z10) {
        View viewC1 = c1();
        if (viewC1 == null) {
            return;
        }
        ImageView imageView = (ImageView) viewC1.findViewById(x7.p.Z);
        imageView.setImageResource(z10 ? x7.o.M0 : x7.o.O0);
        imageView.setContentDescription(Z0(z10 ? x7.u.N3 : x7.u.O3));
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        int iMin = Math.min((y.p(I()) * 4) / 5, y.h(I(), 450.0f));
        int iMin2 = Math.min((y.p(I()) * 4) / 5, y.h(I(), 600.0f));
        if (Z2() == null || Z2().getWindow() == null) {
            return;
        }
        Z2().getWindow().setLayout(iMin, iMin2);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.C0 = (RecyclerView) view.findViewById(x7.p.C0);
        this.D0 = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: j8.f
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7604a.K3(i10);
            }
        });
        aVar.k(new y5.h() { // from class: j8.g
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return p.p3(this.f7605a, view2, i10, (String) obj);
            }
        });
        this.D0.K(String.class, aVar);
        this.C0.setLayoutManager(new LinearLayoutManager(I()));
        r3.d(this.C0);
        r3.f(this.C0);
        this.C0.setItemAnimator(null);
        this.C0.setAdapter(this.D0);
        this.C0.o(new b());
        this.F0.b(new c());
        view.findViewById(x7.p.f13793c0).setOnClickListener(new View.OnClickListener() { // from class: j8.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7606a.J3();
            }
        });
        view.findViewById(x7.p.O).setOnClickListener(new View.OnClickListener() { // from class: j8.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7607a.I3();
            }
        });
        view.findViewById(x7.p.Z).setOnClickListener(new View.OnClickListener() { // from class: j8.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7608a.G3(false);
            }
        });
        view.findViewById(x7.p.f13802f0).setOnClickListener(new View.OnClickListener() { // from class: j8.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.n3(this.f7609a, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(x7.p.C1);
        x8.g.d(textView);
        SeekBar seekBar = (SeekBar) view.findViewById(x7.p.E0);
        r3.g(seekBar);
        textView.setOnClickListener(new View.OnClickListener() { // from class: j8.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.l3(this.f7610a, view2);
            }
        });
        seekBar.setMax(13);
        float fO = this.I0.O();
        seekBar.setProgress(Math.max(0, ((int) (fO / 0.25f)) - 1));
        textView.setText(String.format(Locale.ROOT, "%.2fx", Float.valueOf(fO)));
        seekBar.setOnSeekBarChangeListener(new d(textView));
        D3();
    }

    @Override // k8.a
    public int i3() {
        return 2;
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.F0 = j8.c.n(I());
        this.I0 = pa.r.j();
    }
}
