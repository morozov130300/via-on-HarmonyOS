package i8;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import w5.k;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f7083r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7084s0;

    /* renamed from: t0, reason: collision with root package name */
    public List f7085t0;

    /* renamed from: u0, reason: collision with root package name */
    public final List f7086u0 = new ArrayList();

    /* renamed from: v0, reason: collision with root package name */
    public final List f7087v0 = new ArrayList();

    /* renamed from: w0, reason: collision with root package name */
    public boolean f7088w0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends GridLayoutManager.c {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i10) {
            return (i10 < 0 || i10 >= s.this.f7085t0.size() || !(s.this.f7085t0.get(i10) instanceof m)) ? 5 : 1;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends j.f {
        public b() {
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.c0 c0Var, int i10) {
            super.A(c0Var, i10);
            s.this.f7088w0 = i10 != 0;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.c0 c0Var, int i10) {
        }

        @Override // androidx.recyclerview.widget.j.f
        public int k(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            int iL = c0Var.l();
            return (iL == -1 || iL >= s.this.f7085t0.size() || !(s.this.f7085t0.get(iL) instanceof m)) ? j.f.t(0, 0) : j.f.t(15, 0);
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            int iL = c0Var.l();
            int iL2 = c0Var2.l();
            if (iL == -1 || iL2 == -1 || iL == iL2 || iL >= s.this.f7085t0.size() || iL2 >= s.this.f7085t0.size() || !(s.this.f7085t0.get(iL) instanceof m)) {
                return false;
            }
            int iX3 = s.this.x3((m) s.this.f7085t0.get(iL), iL2);
            if (iX3 == -1) {
                return false;
            }
            s.this.f7084s0.p(iL, iX3);
            return true;
        }
    }

    public static /* synthetic */ void g3(s sVar, View view, int i10, m mVar) {
        int iA3;
        if (sVar.f7088w0 || i10 < 0 || g6.y.D(sVar.f10459q0) || mVar.b() == 10 || (iA3 = sVar.A3(mVar)) == -1) {
            return;
        }
        sVar.f7084s0.p(i10, iA3);
    }

    public static /* synthetic */ void i3(s sVar, View view, k.p pVar) {
        sVar.f7083r0.O2(null);
        sVar.f7083r0.H2(null);
        sVar.w3();
    }

    public final int A3(m mVar) {
        if (this.f7086u0.remove(mVar)) {
            mVar.d(false);
            this.f7087v0.add(0, mVar);
        } else {
            if (!this.f7087v0.remove(mVar)) {
                return -1;
            }
            mVar.d(true);
            this.f7086u0.add(mVar);
        }
        y3();
        return q3(mVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            z3();
        }
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z3();
        super.O1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f7083r0 = pa.r.j();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(I(), 5);
        gridLayoutManager.f3(new a());
        this.f10459q0.setLayoutManager(gridLayoutManager);
        this.f7085t0 = new ArrayList();
        this.f7084s0 = new y5.f(this.f7085t0);
        o oVar = new o();
        oVar.j(new y5.g() { // from class: i8.p
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                s.g3(this.f7080a, view2, i10, (m) obj);
            }
        });
        this.f7084s0.K(m.class, oVar);
        this.f7084s0.K(x.class, new y());
        this.f10459q0.setAdapter(this.f7084s0);
        new androidx.recyclerview.widget.j(new b()).m(this.f10459q0);
        w3();
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        v3.b(zVar, Z0(x7.u.R2));
        zVar.c(new z.b(g6.y.l(), 0, null, Z0(x7.u.Y)), new View.OnClickListener() { // from class: i8.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s sVar = this.f7081a;
                w5.k.l(sVar.I()).d0(x7.u.f13996gb).I(x7.u.f14219x3).V(x7.u.Y, new k.m() { // from class: i8.r
                    @Override // w5.k.m
                    public final void a(View view2, k.p pVar) {
                        s.i3(sVar, view2, pVar);
                    }
                }).N(R.string.cancel, null).f0();
            }
        });
    }

    public final int n3() {
        return 0;
    }

    public final int o3(int i10) {
        return i10 - 1;
    }

    public final void p3() {
        for (int i10 = 0; i10 < this.f7087v0.size(); i10++) {
            m mVar = (m) this.f7087v0.get(i10);
            if (mVar.b() == 10) {
                this.f7087v0.remove(i10);
                mVar.d(true);
                this.f7086u0.add(mVar);
                return;
            }
        }
        for (m mVar2 : this.f7086u0) {
            if (mVar2.b() == 10) {
                mVar2.d(true);
                return;
            }
        }
        this.f7086u0.add(r3(10, true));
    }

    public final int q3(m mVar) {
        int iIndexOf = this.f7086u0.indexOf(mVar);
        if (iIndexOf >= 0) {
            return iIndexOf + 1;
        }
        int iIndexOf2 = this.f7087v0.indexOf(mVar);
        if (iIndexOf2 >= 0) {
            return this.f7086u0.size() + 2 + iIndexOf2;
        }
        return -1;
    }

    public final m r3(int i10, boolean z10) {
        h8.a aVarA = l.a(I(), i10);
        return new m(i10, aVarA.b(), aVarA.d(), z10);
    }

    public final int s3() {
        return this.f7086u0.size() + 1;
    }

    public final int t3(int i10) {
        return (i10 - s3()) - 1;
    }

    public final boolean u3(int i10) {
        return i10 > n3() && i10 < s3();
    }

    public final boolean v3(int i10) {
        return i10 > s3() && i10 < this.f7085t0.size();
    }

    public final void w3() {
        this.f7086u0.clear();
        this.f7087v0.clear();
        Set setC = l.c();
        for (int i10 : this.f7083r0.t0()) {
            if (setC.contains(Integer.valueOf(i10))) {
                setC.remove(Integer.valueOf(i10));
                this.f7086u0.add(r3(i10, true));
            }
        }
        for (int i11 : this.f7083r0.F2()) {
            if (setC.contains(Integer.valueOf(i11))) {
                setC.remove(Integer.valueOf(i11));
                this.f7087v0.add(r3(i11, false));
            }
        }
        if (setC.size() > 0) {
            int size = setC.size();
            int[] iArr = new int[size];
            Iterator it = setC.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                iArr[i12] = ((Integer) it.next()).intValue();
                i12++;
            }
            Arrays.sort(iArr);
            for (int i13 = 0; i13 < size; i13++) {
                this.f7087v0.add(r3(iArr[i13], false));
            }
        }
        p3();
        y3();
        this.f7084s0.l();
    }

    public final int x3(m mVar, int i10) {
        if (q3(mVar) == -1 || i10 < 0 || i10 >= this.f7085t0.size() || i10 == n3()) {
            return -1;
        }
        if (mVar.b() == 10 && i10 >= s3()) {
            return -1;
        }
        boolean zRemove = this.f7086u0.remove(mVar);
        boolean z10 = !zRemove && this.f7087v0.remove(mVar);
        if (!zRemove && !z10) {
            return -1;
        }
        if (i10 == s3()) {
            if (zRemove) {
                mVar.d(true);
                this.f7086u0.add(mVar);
            } else {
                mVar.d(false);
                this.f7087v0.add(0, mVar);
            }
        } else if (u3(i10)) {
            mVar.d(true);
            int iO3 = o3(i10);
            List list = this.f7086u0;
            list.add(Math.max(0, Math.min(iO3, list.size())), mVar);
        } else if (v3(i10)) {
            mVar.d(false);
            int iT3 = t3(i10);
            List list2 = this.f7087v0;
            list2.add(Math.max(0, Math.min(iT3, list2.size())), mVar);
        } else {
            mVar.d(true);
            this.f7086u0.add(mVar);
        }
        y3();
        return q3(mVar);
    }

    public final void y3() {
        this.f7085t0.clear();
        this.f7085t0.add(new x(Z0(x7.u.f14131q6)));
        this.f7085t0.addAll(this.f7086u0);
        this.f7085t0.add(new x(Z0(x7.u.f14117p6)));
        this.f7085t0.addAll(this.f7087v0);
    }

    public final void z3() {
        pc.a.a("save menus", new Object[0]);
        p3();
        ArrayList arrayList = new ArrayList(this.f7086u0.size());
        ArrayList arrayList2 = new ArrayList(this.f7087v0.size());
        Iterator it = this.f7086u0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((m) it.next()).b()));
        }
        Iterator it2 = this.f7087v0.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((m) it2.next()).b()));
        }
        this.f7083r0.O2(g6.a.d(arrayList));
        this.f7083r0.H2(g6.a.d(arrayList2));
    }
}
