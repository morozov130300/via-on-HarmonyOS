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
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.simpleframework.xml.strategy.Name;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c0 extends k8.a {
    public v9.g C0;
    public y5.f D0;
    public RecyclerView E0;
    public TextView F0;
    public TextView G0;
    public EditText H0;
    public ImageView I0;
    public boolean J0 = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            c0.this.B3(!r2.v3());
        }
    }

    private void A3(final String str) {
        if (str == null || str.isEmpty()) {
            w3();
        } else {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: va.x
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13183e.C0.d(str);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: va.y
                @Override // a7.e
                public final void accept(Object obj) {
                    c0.l3(this.f13187e, (List) obj);
                }
            }, new x7.g0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3(boolean z10) {
        if (z10) {
            x.r.c(this.G0).a(0.0f).d(100L).i(new Runnable() { // from class: va.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13179e.G0.setVisibility(4);
                }
            }).f();
            this.H0.setAlpha(0.0f);
            this.H0.setVisibility(0);
            x.r.c(this.H0).a(1.0f).d(100L).f();
            g6.y.j(this.I0, true);
            this.I0.setImageDrawable(lb.b.a(I(), x7.o.f13783z, x7.u.Ud));
            this.I0.setContentDescription(Z0(R.string.cancel));
            z8.f.l(this.H0);
            return;
        }
        this.H0.setText("");
        z8.f.e(this.H0);
        this.G0.setVisibility(0);
        x.r.c(this.G0).a(1.0f).d(100L).f();
        x.r.c(this.H0).a(0.0f).d(100L).i(new Runnable() { // from class: va.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f13181e.H0.setVisibility(8);
            }
        }).f();
        g6.y.j(this.I0, true);
        this.I0.setImageDrawable(lb.b.a(I(), x7.o.f13737j1, x7.u.qf));
        this.I0.setContentDescription(Z0(x7.u.Kb));
    }

    private void C3(List list) {
        if (list.isEmpty() != this.D0.H().isEmpty()) {
            this.D0.M(list);
            this.D0.l();
        } else {
            f.e eVarB = androidx.recyclerview.widget.f.b(new xa.a(this.D0.H(), list));
            this.D0.M(list);
            eVarB.c(this.D0);
        }
    }

    public static /* synthetic */ void l3(c0 c0Var, List list) {
        c0Var.C3(c0Var.u3(list));
        c0Var.y3(list.isEmpty());
    }

    public static /* synthetic */ void o3(c0 c0Var, View view, int i10, v9.f fVar) {
        c0Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, fVar.b());
        c0Var.N0().x1("passresult", bundle);
        c0Var.X2();
    }

    public static /* synthetic */ void p3(c0 c0Var, List list) {
        c0Var.C3(c0Var.u3(list));
        if (!c0Var.J0 && !list.isEmpty()) {
            c0Var.z3();
        }
        c0Var.y3(list.isEmpty());
        c0Var.J0 = true;
    }

    public static /* synthetic */ void r3(c0 c0Var, CharSequence charSequence) {
        c0Var.getClass();
        c0Var.A3(charSequence.toString());
    }

    private List u3(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        final k8.p pVar = new k8.p();
        Collections.sort(list, new Comparator() { // from class: va.b0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return pVar.compare(((v9.f) obj).c(), ((v9.f) obj2).c());
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        String strC = null;
        while (it.hasNext()) {
            v9.f fVar = (v9.f) it.next();
            if (!fVar.c().equals(strC)) {
                strC = fVar.c();
                arrayList.add(new a6.l(strC));
            }
            arrayList.add(fVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v3() {
        return this.H0.getVisibility() == 0;
    }

    private void w3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: va.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13190e.C0.g();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: va.a0
            @Override // a7.e
            public final void accept(Object obj) {
                c0.p3(this.f13090e, (List) obj);
            }
        }, new x7.g0());
    }

    public static c0 x3(String str) {
        Bundle bundle = new Bundle();
        c0 c0Var = new c0();
        bundle.putString("name", str);
        c0Var.H2(bundle);
        return c0Var;
    }

    private void y3(boolean z10) {
        if (z10) {
            this.F0.setVisibility(0);
            this.E0.setVisibility(8);
        } else {
            this.F0.setVisibility(8);
            this.E0.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13874i, viewGroup, false);
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
        this.C0 = pa.r.i();
        this.H0 = (EditText) view.findViewById(x7.p.f13828o);
        ImageView imageView = (ImageView) view.findViewById(x7.p.f13799e0);
        this.I0 = imageView;
        imageView.setImageDrawable(lb.b.a(I(), x7.o.f13737j1, x7.u.qf));
        this.I0.setOnClickListener(new a());
        TextView textView = (TextView) view.findViewById(x7.p.H1);
        this.G0 = textView;
        textView.setText(x7.u.f14065la);
        x8.g.d(this.G0);
        TextView textView2 = (TextView) view.findViewById(x7.p.f13818k1);
        this.F0 = textView2;
        r3.e(textView2);
        x8.g.d(this.F0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.E0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(I()));
        this.E0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(this.E0);
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.D0 = fVar;
        fVar.K(a6.l.class, new a6.m());
        xa.b bVar = new xa.b();
        bVar.j(new y5.g() { // from class: va.t
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                c0.o3(this.f13175a, view2, i10, (v9.f) obj);
            }
        });
        this.D0.K(v9.f.class, bVar);
        this.E0.setAdapter(this.D0);
        ((autodispose2.n) u8.c.a(this.H0).B(1L).f(100L, TimeUnit.MILLISECONDS).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: va.u
            @Override // a7.e
            public final void accept(Object obj) {
                c0.r3(this.f13177e, (CharSequence) obj);
            }
        }, new x7.g0());
        w3();
    }

    public final void z3() {
        if (this.J0) {
            return;
        }
        String string = y0() != null ? y0().getString("name", null) : null;
        if (string == null || string.isEmpty()) {
            return;
        }
        List listH = this.D0.H();
        int size = listH.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            }
            Object obj = listH.get(i11);
            if ((obj instanceof a6.l) && string.equals(((a6.l) obj).a())) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0) {
            String strB = i6.i0.f7006a.b("https://" + string);
            if (!strB.equals(string)) {
                int size2 = listH.size();
                while (true) {
                    if (i10 >= size2) {
                        break;
                    }
                    Object obj2 = listH.get(i10);
                    if ((obj2 instanceof a6.l) && ((a6.l) obj2).a().contains(strB)) {
                        i11 = i10;
                        break;
                    }
                    i10++;
                }
            } else {
                return;
            }
        }
        if (i11 >= 0) {
            this.E0.p1(i11);
        }
    }
}
