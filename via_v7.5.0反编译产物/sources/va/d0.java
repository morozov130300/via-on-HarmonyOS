package va;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.simpleframework.xml.strategy.Name;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends i8.a {
    public t9.g E0;
    public t5.f F0;
    public RecyclerView G0;
    public TextView H0;
    public TextView I0;
    public EditText J0;
    public ImageView K0;
    public boolean L0 = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            d0 d0Var = d0.this;
            d0Var.B3(!d0Var.v3());
        }
    }

    public static /* synthetic */ void l3(d0 d0Var, List list) {
        d0Var.C3(d0Var.u3(list));
        d0Var.y3(list.isEmpty());
    }

    public static /* synthetic */ void o3(d0 d0Var, View view, int i10, t9.f fVar) {
        d0Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, fVar.b());
        d0Var.L0().y1("passresult", bundle);
        d0Var.V2();
    }

    public static /* synthetic */ void p3(d0 d0Var, List list) {
        d0Var.C3(d0Var.u3(list));
        if (!d0Var.L0 && !list.isEmpty()) {
            d0Var.z3();
        }
        d0Var.y3(list.isEmpty());
        d0Var.L0 = true;
    }

    public static /* synthetic */ void r3(d0 d0Var, CharSequence charSequence) {
        d0Var.getClass();
        d0Var.A3(charSequence.toString());
    }

    private void w3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13457c.E0.g();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.b0
            @Override // u6.f
            public final void accept(Object obj) {
                d0.p3(this.f13461c, (List) obj);
            }
        }, new w7.e0());
    }

    public static d0 x3(String str) {
        Bundle bundle = new Bundle();
        d0 d0Var = new d0();
        bundle.putString("name", str);
        d0Var.F2(bundle);
        return d0Var;
    }

    private void y3(boolean z10) {
        if (z10) {
            this.H0.setVisibility(0);
            this.G0.setVisibility(8);
        } else {
            this.H0.setVisibility(8);
            this.G0.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13940i, viewGroup, false);
    }

    public final void A3(final String str) {
        if (str == null || str.isEmpty()) {
            w3();
        } else {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: va.y
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13551c.E0.d(str);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.z
                @Override // u6.f
                public final void accept(Object obj) {
                    d0.l3(this.f13554c, (List) obj);
                }
            }, new w7.e0());
        }
    }

    public final void B3(boolean z10) {
        if (z10) {
            y.r.c(this.I0).a(0.0f).d(100L).i(new Runnable() { // from class: va.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13547c.I0.setVisibility(4);
                }
            }).f();
            this.J0.setAlpha(0.0f);
            this.J0.setVisibility(0);
            y.r.c(this.J0).a(1.0f).d(100L).f();
            com.tuyafeng.support.utils.x.j(this.K0, true);
            this.K0.setImageDrawable(lb.g.a(G(), w7.o.f13846y, w7.u.je));
            this.K0.setContentDescription(X0(R.string.cancel));
            x8.f.l(this.J0);
            return;
        }
        this.J0.setText("");
        x8.f.e(this.J0);
        this.I0.setVisibility(0);
        y.r.c(this.I0).a(1.0f).d(100L).f();
        y.r.c(this.J0).a(0.0f).d(100L).i(new Runnable() { // from class: va.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f13549c.J0.setVisibility(8);
            }
        }).f();
        com.tuyafeng.support.utils.x.j(this.K0, true);
        this.K0.setImageDrawable(lb.g.a(G(), w7.o.f13797h1, w7.u.Hf));
        this.K0.setContentDescription(X0(w7.u.Xb));
    }

    public final void C3(List list) {
        if (list.isEmpty() != this.F0.H().isEmpty()) {
            this.F0.M(list);
            this.F0.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new xa.a(this.F0.H(), list));
            this.F0.M(list);
            eVarB.c(this.F0);
        }
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
        this.E0 = la.s.i();
        this.J0 = (EditText) view.findViewById(w7.p.f13891n);
        ImageView imageView = (ImageView) view.findViewById(w7.p.f13859c0);
        this.K0 = imageView;
        imageView.setImageDrawable(lb.g.a(G(), w7.o.f13797h1, w7.u.Hf));
        this.K0.setOnClickListener(new a());
        this.I0 = (TextView) view.findViewById(w7.p.H1);
        String string = w0() == null ? null : w0().getString("name");
        this.I0.setText((string == null || string.isEmpty()) ? X0(w7.u.f14296xa) : Y0(w7.u.L5, string));
        v8.g.d(this.I0);
        TextView textView = (TextView) view.findViewById(w7.p.f13884k1);
        this.H0 = textView;
        r3.f(textView);
        v8.g.d(this.H0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.G0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(G()));
        this.G0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(this.G0);
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.F0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        xa.b bVar = new xa.b();
        bVar.j(new t5.g() { // from class: va.u
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                d0.o3(this.f13542a, view2, i10, (t9.f) obj);
            }
        });
        this.F0.K(t9.f.class, bVar);
        this.G0.setAdapter(this.F0);
        ((autodispose2.n) s8.c.a(this.J0).E(1L).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: va.v
            @Override // u6.f
            public final void accept(Object obj) {
                d0.r3(this.f13545c, (CharSequence) obj);
            }
        }, new w7.e0());
        w3();
    }

    public final List u3(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        final i8.p pVar = new i8.p();
        Collections.sort(list, new Comparator() { // from class: va.c0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return pVar.compare(((t9.f) obj).c(), ((t9.f) obj2).c());
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        String strC = null;
        while (it.hasNext()) {
            t9.f fVar = (t9.f) it.next();
            if (!fVar.c().equals(strC)) {
                strC = fVar.c();
                arrayList.add(new v5.l(strC));
            }
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final boolean v3() {
        return this.J0.getVisibility() == 0;
    }

    public final void z3() {
        if (this.L0) {
            return;
        }
        String string = w0() != null ? w0().getString("name", null) : null;
        if (string == null || string.isEmpty()) {
            return;
        }
        List listH = this.F0.H();
        int size = listH.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            Object obj = listH.get(i10);
            if ((obj instanceof v5.l) && string.equals(((v5.l) obj).a())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            String strC = a2.f1958a.c("https://" + string);
            if (strC.equals(string)) {
                return;
            }
            int size2 = listH.size();
            for (int i11 = 0; i11 < size2; i11++) {
                Object obj2 = listH.get(i11);
                if ((obj2 instanceof v5.l) && ((v5.l) obj2).a().contains(strC)) {
                    i10 = i11;
                    break;
                }
            }
        }
        if (i10 >= 0) {
            this.G0.p1(i10);
        }
    }
}
