package a8;

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
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import v5.b;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends k8.a {
    public y5.f C0;
    public RecyclerView D0;
    public TextView E0;
    public TextView F0;
    public l8.a G0;
    public cb.b H0;
    public String I0;
    public boolean J0;
    public int K0;
    public int L0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {

        /* renamed from: c, reason: collision with root package name */
        public Drawable f211c;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f212d;

        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            View viewA = b6.c.b().a(viewGroup);
            com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) viewA.findViewById(b6.c.f1831f);
            dVar.setDrawableTint(0);
            int iH = g6.y.h(k.this.I(), 16.0f);
            int iH2 = g6.y.h(k.this.I(), 12.0f);
            dVar.setPadding(iH, iH2, iH, iH2);
            x8.g.d(dVar);
            return viewA;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, cb.a aVar, int i10) {
            Drawable drawableCreateFromPath;
            com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1219a.findViewById(b6.c.f1831f);
            if (aVar.a() != null) {
                if (this.f211c == null) {
                    Drawable drawableA = lb.b.a(k.this.I(), x7.o.f13721e0, x7.u.ee);
                    this.f211c = drawableA;
                    g6.h.a(drawableA, g6.e.a(k.this.I(), x7.k.f13662h));
                }
                drawableCreateFromPath = this.f211c;
            } else if (aVar.b() != null) {
                String strD = z8.y0.d(k.this.I(), aVar.b().g());
                if (strD == null || strD.isEmpty() || !new File(strD).exists()) {
                    if (this.f212d == null) {
                        Drawable drawableA2 = lb.b.a(k.this.I(), x7.o.f13774w, x7.u.Td);
                        this.f212d = drawableA2;
                        g6.h.a(drawableA2, g6.e.a(k.this.I(), x7.k.f13662h));
                    }
                    drawableCreateFromPath = this.f212d;
                } else {
                    drawableCreateFromPath = Drawable.createFromPath(strD);
                }
            } else {
                drawableCreateFromPath = null;
            }
            androidx.core.widget.c.a(dVar, drawableCreateFromPath, null, null, null);
            dVar.setText(g6.p.j(aVar.f(), 256));
        }
    }

    public static /* synthetic */ void j3(k kVar, String str, w.d dVar) {
        String strE;
        int iG;
        kVar.getClass();
        kVar.I0 = ((o9.a) dVar.f13207a).b();
        if (o9.a.g(((o9.a) dVar.f13207a).b())) {
            strE = kVar.Z0(x7.u.f14026j);
        } else {
            strE = ((o9.a) dVar.f13207a).e();
            if (strE == null || strE.trim().isEmpty()) {
                strE = kVar.Z0(x7.u.bh);
            }
        }
        kVar.F0.setText(strE);
        kVar.s3((List) dVar.f13208b);
        if (kVar.J0) {
            kVar.J0 = false;
            if (!str.equals(kVar.I0) || (iG = kVar.C0.g()) <= 0) {
                return;
            }
            ((LinearLayoutManager) kVar.D0.getLayoutManager()).B2(Math.max(Math.min(kVar.K0, iG - 1), 0), kVar.L0);
        }
    }

    public static /* synthetic */ w.d k3(String str) {
        o9.c cVarD = pa.r.d();
        o9.a aVarF = cVarD.f(str);
        if (aVarF == null) {
            aVarF = o9.a.r();
        }
        ArrayList arrayList = new ArrayList();
        if (!o9.a.g(aVarF.b())) {
            o9.a aVarK = o9.a.k(cVarD.f(aVarF.d()));
            if (aVarK == null) {
                aVarK = o9.a.i("", null);
            }
            aVarK.p("..");
            cb.a aVar = new cb.a(aVarK);
            aVar.j(true);
            arrayList.add(aVar);
        }
        Iterator it = cVarD.s(aVarF.b()).iterator();
        while (it.hasNext()) {
            arrayList.add(new cb.a((o9.a) it.next()));
        }
        Iterator it2 = cVarD.n(aVarF.b()).iterator();
        while (it2.hasNext()) {
            arrayList.add(new cb.a((o9.b) it2.next()));
        }
        return w.d.a(aVarF, arrayList);
    }

    public static /* synthetic */ void l3(k kVar, View view, int i10, cb.a aVar) {
        kVar.getClass();
        if (aVar.a() != null) {
            kVar.n3(aVar.a().b());
        } else if (aVar.b() != null) {
            kVar.G0 = new l8.a(aVar.b().g(), 0);
            kVar.X2();
        }
    }

    public static k o3() {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putBoolean("restore_state", true);
        kVar.H2(bundle);
        return kVar;
    }

    public static k p3(String str) {
        Bundle bundle = new Bundle();
        k kVar = new k();
        bundle.putString("folder", str);
        kVar.H2(bundle);
        return kVar;
    }

    private void r3() {
        RecyclerView recyclerView;
        if (this.I0 == null || (recyclerView = this.D0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        b.C0148b c0148bD = v5.b.a().e("BOOKMARK_DIALOG_CACHE").f(180).d("folder", this.I0);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.D0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0148bD.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0148bD.a();
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13868c, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void O1() {
        r3();
        super.O1();
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        int iMin = Math.min((g6.y.p(I()) * 4) / 5, g6.y.h(I(), 450.0f));
        int iMin2 = Math.min((g6.y.p(I()) * 4) / 5, g6.y.h(I(), 600.0f));
        if (Z2() == null || Z2().getWindow() == null) {
            return;
        }
        Z2().getWindow().setLayout(iMin, iMin2);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        TextView textView = (TextView) view.findViewById(x7.p.H1);
        this.F0 = textView;
        x8.g.d(textView);
        ImageView imageView = (ImageView) view.findViewById(x7.p.R);
        imageView.setImageDrawable(lb.b.a(I(), x7.o.N, x7.u.Zd));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: a8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f178a.q3();
            }
        });
        TextView textView2 = (TextView) view.findViewById(x7.p.f13818k1);
        this.E0 = textView2;
        r3.e(textView2);
        x8.g.d(this.E0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.D0 = recyclerView;
        r3.d(recyclerView);
        r3.a(this.D0);
        this.C0 = new y5.f(new ArrayList());
        a aVar = new a();
        aVar.j(new y5.g() { // from class: a8.h
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                k.l3(this.f194a, view2, i10, (cb.a) obj);
            }
        });
        this.C0.K(cb.a.class, aVar);
        this.D0.setLayoutManager(new LinearLayoutManager(I()));
        this.D0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.D0.setAdapter(this.C0);
        this.H0 = cb.b.c(pa.r.j().V0());
        String string = "";
        if (y0() != null && y0().getBoolean("restore_state", false)) {
            Bundle bundleC = v5.b.d().c("BOOKMARK_DIALOG_CACHE");
            if (bundleC != null) {
                string = bundleC.getString("folder", "");
                this.K0 = bundleC.getInt("position", 0);
                this.L0 = bundleC.getInt("offset", 0);
                this.J0 = true;
            }
        } else if (y0() != null) {
            string = y0().getString("folder", "");
        }
        n3(string);
    }

    public final void n3(final String str) {
        if (str == null) {
            str = "";
        }
        ((autodispose2.n) x6.j.s(new Callable() { // from class: a8.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k.k3(str);
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: a8.j
            @Override // a7.e
            public final void accept(Object obj) {
                k.j3(this.f203e, str, (w.d) obj);
            }
        }, new x7.g0());
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.G0 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.G0);
            l0().L().x1("result", l8.b.b(arrayList));
        }
        super.onDismiss(dialogInterface);
    }

    public final void q3() {
        int top;
        LinearLayoutManager linearLayoutManager;
        View viewJ;
        if (this.I0 == null) {
            return;
        }
        RecyclerView recyclerView = this.D0;
        int iI0 = 0;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (viewJ = (linearLayoutManager = (LinearLayoutManager) this.D0.getLayoutManager()).J(0)) == null) {
            top = 0;
        } else {
            iI0 = linearLayoutManager.i0(viewJ);
            top = viewJ.getTop();
        }
        cb.e0.U3(this.I0, iI0, top);
        Fragment fragmentM0 = M0();
        X2();
        g6.i.i(fragmentM0, bb.i.class, bb.i.n3(true, 1), "RecordContainerFragment");
    }

    public final void s3(List list) {
        Collections.sort(list, this.H0);
        this.C0.M(list);
        this.C0.l();
        boolean zIsEmpty = list.isEmpty();
        this.D0.setVisibility(zIsEmpty ? 8 : 0);
        this.E0.setVisibility(zIsEmpty ? 0 : 8);
    }
}
