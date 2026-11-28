package c9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.lifecycle.a0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import mark.via.common.widget.LinearLayoutPagerManager;
import mark.via.settings.search.SettingsSearchLocator;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public b9.t f2324o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public u9.l f2325p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public RecyclerView f2326q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t5.f f2327r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public d9.b f2328s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public SeekBar f2329t0;

    public static /* synthetic */ void S2(j jVar, View view, int i10, f9.a aVar) {
        if (aVar instanceof f9.b) {
            jVar.V2((f9.b) aVar, i10);
            return;
        }
        if (aVar instanceof f9.d) {
            jVar.X2((f9.d) aVar, i10);
        } else if (aVar instanceof f9.c) {
            jVar.W2((f9.c) aVar, i10);
        } else {
            jVar.getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13948q, viewGroup, false);
    }

    public abstract List T2();

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(w7.p.f13919w0);
        this.f2326q0 = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f2326q0.setLayoutManager(new LinearLayoutPagerManager(G(), 0, 5, false));
        this.f2327r0 = new t5.f(T2());
        d9.b bVar = new d9.b();
        this.f2328s0 = bVar;
        bVar.j(new t5.g() { // from class: c9.i
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                j.S2(this.f2323a, view2, i10, (f9.a) obj);
            }
        });
        this.f2327r0.K(f9.a.class, this.f2328s0);
        this.f2326q0.setAdapter(this.f2327r0);
        SettingsSearchLocator.b(this, this.f2326q0);
        SeekBar seekBar = (SeekBar) view.findViewById(w7.p.f13928z0);
        this.f2329t0 = seekBar;
        r3.h(seekBar);
        this.f2326q0.requestFocus();
    }

    public void V2(f9.b bVar, int i10) {
        if (this.f2328s0.l() == i10) {
            this.f2329t0.setVisibility(8);
            this.f2328s0.p(this.f2327r0, -1);
            return;
        }
        this.f2328s0.p(this.f2327r0, i10);
        this.f2329t0.setVisibility(0);
        this.f2329t0.setOnSeekBarChangeListener(null);
        this.f2329t0.setMax(bVar.h() - bVar.i());
        this.f2329t0.setProgress(bVar.j() - bVar.i());
        this.f2329t0.setOnSeekBarChangeListener(new a(bVar, i10));
        this.f2329t0.requestFocus();
    }

    public void W2(f9.c cVar, int i10) {
        if (this.f2328s0.l() >= 0) {
            this.f2329t0.setVisibility(8);
            this.f2328s0.p(this.f2327r0, -1);
        }
        U2(cVar, i10);
    }

    public void X2(f9.d dVar, int i10) {
        if (this.f2328s0.l() >= 0) {
            this.f2329t0.setVisibility(8);
            this.f2328s0.p(this.f2327r0, -1);
        }
        dVar.i(!dVar.h());
        this.f2327r0.m(i10);
        U2(dVar, i10);
    }

    public void Y2() {
        this.f2327r0.M(T2());
        this.f2327r0.l();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2324o0 = (b9.t) new a0(z2()).a(b9.t.class);
        this.f2325p0 = la.s.j();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f9.b f2330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2331b;

        public a(f9.b bVar, int i10) {
            this.f2330a = bVar;
            this.f2331b = i10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            f9.b bVar = this.f2330a;
            bVar.l(i10 + bVar.i());
            j.this.f2327r0.m(this.f2331b);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            j.this.U2(this.f2330a, this.f2331b);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }

    public void U2(f9.a aVar, int i10) {
    }
}
