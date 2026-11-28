package h8;

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
import com.tuyafeng.support.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import w7.u;
import x8.e1;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends i8.a {
    public RecyclerView E0;
    public t5.f F0;
    public int G0;
    public q H0;
    public long J0;
    public u9.l K0;
    public String I0 = null;
    public int L0 = -1;
    public final Handler M0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            TextView textView = (TextView) w5.c.h().a(viewGroup);
            textView.setGravity(17);
            return textView;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, String str, int i10) {
            TextView textView = (TextView) gVar.f1138a;
            textView.setText(str);
            int i11 = i10 == p.this.G0 ? 1 : 0;
            v8.g.e(textView, i11);
            int iH = x.h(p.this.G(), 16.0f);
            int iH2 = x.h(p.this.G(), 8.0f);
            textView.setPadding(iH, iH2, iH, iH2);
            textView.setSingleLine(false);
            textView.setTextColor(i11 != 0 ? v8.h.j(gVar.O()) : v8.h.n(gVar.O()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    p.this.J0 = -1L;
                }
            } else if (p.this.J0 == -1) {
                p.this.J0 = SystemClock.elapsedRealtime() + 3000;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements h8.d {
        public c() {
        }

        @Override // h8.d
        public void a(t tVar) {
            if (p.this.I0 != null && p.this.I0.equals(tVar.b()) && p.this.L0 < 0) {
                p.this.L3(tVar.a(), true);
            }
            if (p.this.a1() != null) {
                p.this.M3(!tVar.g() && tVar.h());
            }
        }
    }

    private void D3() {
        List listA = this.H0.a();
        boolean z10 = true;
        if (listA.isEmpty()) {
            F3(true);
            return;
        }
        t tVar = (t) listA.get(0);
        M3(!tVar.g() && tVar.h());
        this.I0 = tVar.b();
        if (tVar.d() != null) {
            this.F0.M(new ArrayList(tVar.d()));
            this.F0.l();
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

    private void L(String str) {
        new a6.h.b(G()).h(str).a().s();
    }

    public static /* synthetic */ void l3(p pVar, View view) {
        LinearLayout linearLayout = (LinearLayout) pVar.A2().findViewById(w7.p.f13883k0);
        boolean z10 = linearLayout.findViewById(w7.p.A0).getVisibility() == 8;
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = linearLayout.getChildAt(i10);
            int id = childAt.getId();
            if (id == w7.p.C1) {
                TextView textView = (TextView) childAt;
                textView.setTypeface(z10 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                textView.setTextColor(z10 ? v8.h.j(pVar.G()) : v8.h.o(pVar.G()));
            } else if (!(z10 && id == w7.p.A0) && (z10 || id == w7.p.A0)) {
                childAt.setVisibility(8);
            } else {
                childAt.setVisibility(0);
                childAt.setAlpha(0.0f);
                y.r.c(childAt).a(1.0f).d(200L).f();
            }
        }
    }

    public static /* synthetic */ void n3(p pVar, View view) {
        pVar.getClass();
        Intent intentE = e1.e();
        try {
            pVar.G3(true);
            pVar.N2(intentE);
        } catch (Exception unused) {
            pVar.L(pVar.X0(u.Ng));
        }
    }

    public static /* synthetic */ boolean p3(p pVar, View view, int i10, String str) {
        pVar.getClass();
        pVar.J0 = SystemClock.elapsedRealtime() + 3000;
        t tVarF = pVar.H0.f(pVar.I0);
        com.tuyafeng.support.utils.n.a(pVar.G(), tVarF == null ? null : tVarF.c(i10), u.Eg);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13941j, viewGroup, false);
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void D1() {
        this.M0.removeCallbacksAndMessages(null);
        super.D1();
    }

    public final void F3(boolean z10) {
        View viewA1 = a1();
        if (viewA1 == null) {
            return;
        }
        viewA1.findViewById(w7.p.f13884k1).setVisibility(z10 ? 0 : 8);
        viewA1.findViewById(w7.p.f13883k0).setVisibility(z10 ? 8 : 0);
        viewA1.findViewById(w7.p.f13925y0).setVisibility(z10 ? 8 : 0);
    }

    public final void G3(boolean z10) {
        t tVarF = this.H0.f(this.I0);
        if (tVarF == null) {
            return;
        }
        if (tVarF.h()) {
            e.a(G(), null);
        } else {
            if (z10) {
                return;
            }
            if (tVarF.g()) {
                tVarF.i(0);
            }
            e.b(G(), tVarF.b());
        }
    }

    public final void H3() {
        t tVarF = this.H0.f(this.I0);
        if (tVarF == null || tVarF.d() == null || tVarF.d().isEmpty()) {
            return;
        }
        this.J0 = 0L;
        K3(Math.max(0, Math.min(tVarF.d().size() - 1, this.L0)));
        this.L0 = -1;
    }

    public final void I3() {
        if (this.L0 < 0) {
            this.L0 = this.G0;
        }
        int i10 = this.L0 + 1;
        this.L0 = i10;
        L3(i10, true);
        this.M0.removeCallbacksAndMessages(null);
        this.M0.postDelayed(new o(this), 300L);
    }

    public final void J3() {
        if (this.L0 < 0) {
            this.L0 = this.G0;
        }
        int iMax = Math.max(0, this.L0 - 1);
        this.L0 = iMax;
        L3(iMax, true);
        this.M0.removeCallbacksAndMessages(null);
        this.M0.postDelayed(new o(this), 300L);
    }

    public final void K3(int i10) {
        e.c(G(), this.I0, i10);
    }

    public final void L3(int i10, boolean z10) {
        int i11 = this.G0;
        if (i10 == i11) {
            return;
        }
        this.G0 = i10;
        if (i11 >= 0 && i11 < this.F0.g()) {
            this.F0.m(i11);
        }
        int i12 = this.G0;
        if (i12 < 0 || i12 >= this.F0.g()) {
            return;
        }
        this.F0.m(this.G0);
        if (this.J0 < 0 || SystemClock.elapsedRealtime() <= this.J0) {
            return;
        }
        if (z10) {
            this.E0.post(new Runnable() { // from class: h8.m
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = this.f5742c;
                    pVar.E0.x1(pVar.G0);
                }
            });
        } else {
            this.E0.post(new Runnable() { // from class: h8.n
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = this.f5743c;
                    pVar.E0.p1(pVar.G0);
                }
            });
        }
    }

    public final void M3(boolean z10) {
        View viewA1 = a1();
        if (viewA1 == null) {
            return;
        }
        ImageView imageView = (ImageView) viewA1.findViewById(w7.p.Y);
        imageView.setImageResource(z10 ? w7.o.K0 : w7.o.M0);
        imageView.setContentDescription(X0(z10 ? u.f13971a4 : u.f13985b4));
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        int iMin = Math.min((x.p(G()) * 4) / 5, x.h(G(), 450.0f));
        int iMin2 = Math.min((x.p(G()) * 4) / 5, x.h(G(), 600.0f));
        if (X2() == null || X2().getWindow() == null) {
            return;
        }
        X2().getWindow().setLayout(iMin, iMin2);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.E0 = (RecyclerView) view.findViewById(w7.p.f13925y0);
        this.F0 = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: h8.f
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5735a.K3(i10);
            }
        });
        aVar.k(new t5.h() { // from class: h8.g
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return p.p3(this.f5736a, view2, i10, (String) obj);
            }
        });
        this.F0.K(String.class, aVar);
        this.E0.setLayoutManager(new LinearLayoutManager(G()));
        r3.e(this.E0);
        r3.g(this.E0);
        this.E0.setItemAnimator(null);
        this.E0.setAdapter(this.F0);
        this.E0.o(new b());
        this.H0.g(new c());
        view.findViewById(w7.p.f13853a0).setOnClickListener(new View.OnClickListener() { // from class: h8.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5737a.J3();
            }
        });
        view.findViewById(w7.p.M).setOnClickListener(new View.OnClickListener() { // from class: h8.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5738a.I3();
            }
        });
        view.findViewById(w7.p.Y).setOnClickListener(new View.OnClickListener() { // from class: h8.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5739a.G3(false);
            }
        });
        view.findViewById(w7.p.f13862d0).setOnClickListener(new View.OnClickListener() { // from class: h8.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.n3(this.f5740a, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(w7.p.C1);
        v8.g.d(textView);
        SeekBar seekBar = (SeekBar) view.findViewById(w7.p.A0);
        r3.h(seekBar);
        textView.setOnClickListener(new View.OnClickListener() { // from class: h8.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.l3(this.f5741a, view2);
            }
        });
        seekBar.setMax(13);
        float fP = this.K0.P();
        seekBar.setProgress(Math.max(0, ((int) (fP / 0.25f)) - 1));
        textView.setText(String.format(Locale.ROOT, "%.2fx", Float.valueOf(fP)));
        seekBar.setOnSeekBarChangeListener(new d(textView));
        D3();
    }

    @Override // i8.a
    public int i3() {
        return 2;
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.H0 = h8.c.n(G());
        this.K0 = la.s.j();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f5748a;

        public d(TextView textView) {
            this.f5748a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            this.f5748a.setText(String.format(Locale.ROOT, "%.2fx", Float.valueOf((i10 + 1) * 0.25f)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            float progress = (seekBar.getProgress() + 1) * 0.25f;
            p.this.K0.w0(progress);
            p.this.H0.h().g(progress);
            t tVarF = p.this.H0.f(p.this.I0);
            if (tVarF == null || !tVarF.h()) {
                return;
            }
            p pVar = p.this;
            pVar.K3(pVar.G0);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }
}
