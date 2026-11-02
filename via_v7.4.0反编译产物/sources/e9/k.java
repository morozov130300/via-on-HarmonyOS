package e9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import mark.via.common.widget.LinearLayoutPagerManager;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class k extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public d9.t f4907m0;

    /* renamed from: n0, reason: collision with root package name */
    public w9.l f4908n0;

    /* renamed from: o0, reason: collision with root package name */
    public RecyclerView f4909o0;

    /* renamed from: p0, reason: collision with root package name */
    public y5.f f4910p0;

    /* renamed from: q0, reason: collision with root package name */
    public f9.b f4911q0;

    /* renamed from: r0, reason: collision with root package name */
    public SeekBar f4912r0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h9.b f4913a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4914b;

        public a(h9.b bVar, int i10) {
            this.f4913a = bVar;
            this.f4914b = i10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            h9.b bVar = this.f4913a;
            bVar.l(i10 + bVar.i());
            k.this.f4910p0.m(this.f4914b);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            k.this.W2(this.f4913a, this.f4914b);
        }
    }

    public static /* synthetic */ void U2(k kVar, View view, int i10, h9.a aVar) {
        if (aVar instanceof h9.b) {
            kVar.X2((h9.b) aVar, i10);
            return;
        }
        if (aVar instanceof h9.d) {
            kVar.Z2((h9.d) aVar, i10);
        } else if (aVar instanceof h9.c) {
            kVar.Y2((h9.c) aVar, i10);
        } else {
            kVar.getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13882q, viewGroup, false);
    }

    public abstract List V2();

    public void W2(h9.a aVar, int i10) {
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(x7.p.A0);
        this.f4909o0 = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f4909o0.setLayoutManager(new LinearLayoutPagerManager(I(), 0, 5, false));
        this.f4910p0 = new y5.f(V2());
        f9.b bVar = new f9.b();
        this.f4911q0 = bVar;
        bVar.j(new y5.g() { // from class: e9.j
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k.U2(this.f4906a, view2, i10, (h9.a) obj);
            }
        });
        this.f4910p0.K(h9.a.class, this.f4911q0);
        this.f4909o0.setAdapter(this.f4910p0);
        SeekBar seekBar = (SeekBar) view.findViewById(x7.p.D0);
        this.f4912r0 = seekBar;
        r3.g(seekBar);
        this.f4909o0.requestFocus();
    }

    public void X2(h9.b bVar, int i10) {
        if (this.f4911q0.l() == i10) {
            this.f4912r0.setVisibility(8);
            this.f4911q0.p(this.f4910p0, -1);
            return;
        }
        this.f4911q0.p(this.f4910p0, i10);
        this.f4912r0.setVisibility(0);
        this.f4912r0.setOnSeekBarChangeListener(null);
        this.f4912r0.setMax(bVar.h() - bVar.i());
        this.f4912r0.setProgress(bVar.j() - bVar.i());
        this.f4912r0.setOnSeekBarChangeListener(new a(bVar, i10));
        this.f4912r0.requestFocus();
    }

    public void Y2(h9.c cVar, int i10) {
        if (this.f4911q0.l() >= 0) {
            this.f4912r0.setVisibility(8);
            this.f4911q0.p(this.f4910p0, -1);
        }
        W2(cVar, i10);
    }

    public void Z2(h9.d dVar, int i10) {
        if (this.f4911q0.l() >= 0) {
            this.f4912r0.setVisibility(8);
            this.f4911q0.p(this.f4910p0, -1);
        }
        dVar.i(!dVar.h());
        this.f4910p0.m(i10);
        W2(dVar, i10);
    }

    public void a3() {
        this.f4910p0.M(V2());
        this.f4910p0.l();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4907m0 = (d9.t) new androidx.lifecycle.y(B2()).a(d9.t.class);
        this.f4908n0 = pa.r.j();
    }
}
