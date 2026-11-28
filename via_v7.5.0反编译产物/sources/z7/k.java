package z7;

import android.R;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends i8.a {
    public t5.f E0;
    public RecyclerView F0;
    public TextView G0;
    public TextView H0;
    public j8.a I0;
    public cb.b J0;
    public String K0;
    public boolean L0;
    public int M0;
    public int N0;
    public final androidx.activity.o O0 = new a(false);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.activity.o {
        public a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() {
            k.this.p3(((cb.a) k.this.E0.H().get(0)).e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends t5.i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f15282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f15283d;

        public b() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            View viewA = w5.c.b().a(viewGroup);
            com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) viewA.findViewById(w5.c.f13662f);
            dVar.setDrawableTint(0);
            int iH = com.tuyafeng.support.utils.x.h(k.this.G(), 16.0f);
            int iH2 = com.tuyafeng.support.utils.x.h(k.this.G(), 12.0f);
            dVar.setPadding(iH, iH2, iH, iH2);
            v8.g.d(dVar);
            return viewA;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, cb.a aVar, int i10) {
            Drawable drawableA;
            com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1138a.findViewById(w5.c.f13662f);
            if (aVar.a() != null) {
                if (this.f15282c == null) {
                    Drawable drawableC = lb.g.c(k.this.G(), w7.o.f13784d0, w7.u.te);
                    this.f15282c = drawableC;
                    com.tuyafeng.support.utils.h.a(drawableC, com.tuyafeng.support.utils.e.a(k.this.G(), w7.k.f13729i));
                }
                drawableA = this.f15282c;
            } else if (aVar.b() != null) {
                String strE = x8.y0.e(k.this.G(), aVar.b().g());
                if (strE == null || strE.isEmpty() || !new File(strE).exists()) {
                    if (this.f15283d == null) {
                        Drawable drawableC2 = lb.g.c(k.this.G(), w7.o.f13837v, w7.u.ie);
                        this.f15283d = drawableC2;
                        com.tuyafeng.support.utils.h.a(drawableC2, com.tuyafeng.support.utils.e.a(k.this.G(), w7.k.f13729i));
                    }
                    drawableA = this.f15283d;
                } else {
                    drawableA = x8.y0.a(Drawable.createFromPath(strE));
                }
            } else {
                drawableA = null;
            }
            androidx.core.widget.d.a(dVar, drawableA, null, null, null);
            dVar.setText(com.tuyafeng.support.utils.p.j(aVar.g(), 256));
        }
    }

    public static /* synthetic */ void j3(k kVar, String str, x.d dVar) {
        String strE;
        int iG;
        String str2 = kVar.K0;
        if (str2 != null && !str2.equals(((m9.a) dVar.f14455a).b())) {
            kVar.O0.j(!m9.a.g(((m9.a) dVar.f14455a).b()));
        }
        kVar.K0 = ((m9.a) dVar.f14455a).b();
        if (m9.a.g(((m9.a) dVar.f14455a).b())) {
            strE = kVar.X0(w7.u.f14092j);
        } else {
            strE = ((m9.a) dVar.f14455a).e();
            if (strE == null || strE.trim().isEmpty()) {
                strE = kVar.X0(w7.u.Ah);
            }
        }
        kVar.H0.setText(strE);
        kVar.u3((List) dVar.f14456b);
        if (kVar.L0) {
            kVar.L0 = false;
            if (!str.equals(kVar.K0) || (iG = kVar.E0.g()) <= 0) {
                return;
            }
            ((LinearLayoutManager) kVar.F0.getLayoutManager()).B2(Math.max(Math.min(kVar.M0, iG - 1), 0), kVar.N0);
        }
    }

    public static /* synthetic */ x.d k3(String str) {
        m9.c cVarD = la.s.d();
        m9.a aVarE = cVarD.e(str);
        if (aVarE == null) {
            aVarE = m9.a.r();
        }
        ArrayList arrayList = new ArrayList();
        if (!m9.a.g(aVarE.b())) {
            m9.a aVarK = m9.a.k(cVarD.e(aVarE.d()));
            if (aVarK == null) {
                aVarK = m9.a.i("", null);
            }
            aVarK.p("..");
            cb.a aVar = new cb.a(aVarK);
            aVar.k(true);
            arrayList.add(aVar);
        }
        Iterator it = cVarD.t(aVarE.b()).iterator();
        while (it.hasNext()) {
            arrayList.add(new cb.a((m9.a) it.next()));
        }
        Iterator it2 = cVarD.o(aVarE.b()).iterator();
        while (it2.hasNext()) {
            arrayList.add(new cb.a((m9.b) it2.next()));
        }
        return x.d.a(aVarE, arrayList);
    }

    public static /* synthetic */ void l3(k kVar, View view, int i10, cb.a aVar) {
        kVar.getClass();
        if (aVar.a() != null) {
            kVar.p3(aVar.a().b());
        } else if (aVar.b() != null) {
            kVar.I0 = new j8.a(aVar.b().g(), 0);
            kVar.V2();
        }
    }

    public static k q3() {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putBoolean("restore_state", true);
        kVar.F2(bundle);
        return kVar;
    }

    public static k r3(String str) {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putString("folder", str);
        kVar.F2(bundle);
        return kVar;
    }

    private void t3() {
        RecyclerView recyclerView;
        if (this.K0 == null || (recyclerView = this.F0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        p5.b.C0110b c0110bD = p5.b.a().e("BOOKMARK_DIALOG_CACHE").f(180).d("folder", this.K0);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.F0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0110bD.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0110bD.a();
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13934c, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        t3();
        super.M1();
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        int iMin = Math.min((com.tuyafeng.support.utils.x.p(G()) * 4) / 5, com.tuyafeng.support.utils.x.h(G(), 450.0f));
        int iMin2 = Math.min((com.tuyafeng.support.utils.x.p(G()) * 4) / 5, com.tuyafeng.support.utils.x.h(G(), 600.0f));
        if (X2() == null || X2().getWindow() == null) {
            return;
        }
        X2().getWindow().setLayout(iMin, iMin2);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ((androidx.activity.k) d3()).h().h(b1(), this.O0);
        TextView textView = (TextView) view.findViewById(w7.p.H1);
        this.H0 = textView;
        v8.g.d(textView);
        ImageView imageView = (ImageView) view.findViewById(w7.p.P);
        imageView.setImageDrawable(lb.g.a(G(), w7.o.M, w7.u.oe));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z7.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f15250a.s3();
            }
        });
        TextView textView2 = (TextView) view.findViewById(w7.p.f13884k1);
        this.G0 = textView2;
        r3.f(textView2);
        v8.g.d(this.G0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.F0 = recyclerView;
        r3.e(recyclerView);
        r3.a(this.F0);
        this.E0 = new t5.f(new ArrayList());
        b bVar = new b();
        bVar.j(new t5.g() { // from class: z7.h
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                k.l3(this.f15264a, view2, i10, (cb.a) obj);
            }
        });
        this.E0.K(cb.a.class, bVar);
        this.F0.setLayoutManager(new LinearLayoutManager(G()));
        this.F0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.F0.setAdapter(this.E0);
        this.J0 = cb.b.c(la.s.j().X0());
        String string = "";
        if (w0() != null && w0().getBoolean("restore_state", false)) {
            Bundle bundleC = p5.b.d().c("BOOKMARK_DIALOG_CACHE");
            if (bundleC != null) {
                string = bundleC.getString("folder", "");
                this.M0 = bundleC.getInt("position", 0);
                this.N0 = bundleC.getInt("offset", 0);
                this.L0 = true;
            }
        } else if (w0() != null) {
            string = w0().getString("folder", "");
        }
        p3(string);
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.I0 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.I0);
            i0().K().y1("result", j8.b.b(arrayList));
        }
        super.onDismiss(dialogInterface);
    }

    public final void p3(final String str) {
        if (str == null) {
            str = "";
        }
        ((autodispose2.n) r6.j.v(new Callable() { // from class: z7.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k.k3(str);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: z7.j
            @Override // u6.f
            public final void accept(Object obj) {
                k.j3(this.f15273c, str, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final void s3() {
        int top;
        LinearLayoutManager linearLayoutManager;
        View viewJ;
        if (this.K0 == null) {
            return;
        }
        RecyclerView recyclerView = this.F0;
        int iI0 = 0;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (viewJ = (linearLayoutManager = (LinearLayoutManager) this.F0.getLayoutManager()).J(0)) == null) {
            top = 0;
        } else {
            iI0 = linearLayoutManager.i0(viewJ);
            top = viewJ.getTop();
        }
        cb.f0.T3(this.K0, iI0, top);
        Fragment fragmentK0 = K0();
        V2();
        FragmentUtils.k(fragmentK0, bb.i.class, bb.i.m3(true, 1), "RecordContainerFragment");
    }

    public final void u3(List list) {
        Collections.sort(list, this.J0);
        this.E0.M(list);
        this.E0.l();
        boolean zIsEmpty = list.isEmpty();
        this.F0.setVisibility(zIsEmpty ? 8 : 0);
        this.G0.setVisibility(zIsEmpty ? 0 : 8);
    }
}
