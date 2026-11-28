package g8;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.widget.e0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mark.via.settings.search.SettingsSearchLocator;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5570u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5571v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public List f5572w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final List f5573x0 = new ArrayList();

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final List f5574y0 = new ArrayList();

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f5575z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends GridLayoutManager.c {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i10) {
            return (i10 < 0 || i10 >= s.this.f5572w0.size() || !(s.this.f5572w0.get(i10) instanceof m)) ? 5 : 1;
        }
    }

    public static /* synthetic */ void f3(s sVar, View view, int i10, m mVar) {
        int iA3;
        if (sVar.f5575z0 || i10 < 0 || com.tuyafeng.support.utils.x.D(sVar.f7946t0) || mVar.b() == 10 || (iA3 = sVar.A3(mVar)) == -1) {
            return;
        }
        sVar.f5571v0.p(i10, iA3);
    }

    public static /* synthetic */ void h3(s sVar, View view, q5.k.p pVar) {
        sVar.f5570u0.S2(null);
        sVar.f5570u0.L2(null);
        sVar.w3();
    }

    public static List r3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, s.class, w7.u.Fc, w7.u.f14012d3);
        hVar.b(1, w7.u.Q, new String[0]);
        hVar.b(2, w7.u.f14092j, new String[0]);
        hVar.b(3, w7.u.I, new String[0]);
        hVar.b(4, w7.u.D, new String[0]);
        hVar.b(5, w7.u.J, new String[0]);
        hVar.b(6, w7.u.f14037f0, new String[0]);
        hVar.b(7, w7.u.f13994c, new String[0]);
        hVar.b(8, w7.u.U, new String[0]);
        hVar.b(9, w7.u.f14065h0, new String[0]);
        hVar.b(10, w7.u.Bc, new String[0]);
        hVar.b(11, w7.u.G, new String[0]);
        hVar.b(12, w7.u.f13967a0, new String[0]);
        hVar.b(13, w7.u.f14009d0, new String[0]);
        hVar.b(14, w7.u.f14079i0, new String[0]);
        hVar.b(15, w7.u.f14051g0, new String[0]);
        hVar.b(16, w7.u.H, new String[0]);
        hVar.b(17, w7.u.I6, new String[0]);
        hVar.b(18, w7.u.f14271vb, new String[0]);
        hVar.b(19, w7.u.F0, new String[0]);
        hVar.b(20, w7.u.Q8, new String[0]);
        hVar.b(23, w7.u.M, new String[0]);
        hVar.b(24, w7.u.Y9, new String[0]);
        hVar.b(25, w7.u.Qb, new String[0]);
        hVar.b(26, w7.u.Xc, new String[0]);
        hVar.b(27, w7.u.Ic, new String[0]);
        hVar.b(28, w7.u.G1, new String[0]);
        hVar.b(31, w7.u.f14137m2, new String[0]);
        hVar.b(29, w7.u.ed, new String[0]);
        hVar.b(30, w7.u.f13991ba, new String[0]);
        hVar.b(32, w7.u.La, new String[0]);
        hVar.b(33, w7.u.Ua, new String[0]);
        hVar.b(34, w7.u.A0, "快捷方式", "添加到主屏幕");
        hVar.b(35, w7.u.f14012d3, new String[0]);
        hVar.b(36, w7.u.Za, new String[0]);
        hVar.b(37, w7.u.H9, new String[0]);
        hVar.b(38, w7.u.f14001c6, new String[0]);
        hVar.b(39, w7.u.R0, new String[0]);
        hVar.b(40, w7.u.f14008d, new String[0]);
        hVar.b(41, w7.u.f14076hb, new String[0]);
        return hVar.f();
    }

    public final int A3(m mVar) {
        if (this.f5573x0.remove(mVar)) {
            mVar.d(false);
            this.f5574y0.add(0, mVar);
        } else {
            if (!this.f5574y0.remove(mVar)) {
                return -1;
            }
            mVar.d(true);
            this.f5573x0.add(mVar);
        }
        y3();
        return p3(mVar);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        z3();
        super.M1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5570u0 = la.s.j();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(G(), 5);
        gridLayoutManager.f3(new a());
        this.f7946t0.setLayoutManager(gridLayoutManager);
        this.f5572w0 = new ArrayList();
        this.f5571v0 = new t5.f(this.f5572w0);
        o oVar = new o();
        oVar.j(new t5.g() { // from class: g8.p
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                s.f3(this.f5567a, view2, i10, (m) obj);
            }
        });
        this.f5571v0.K(m.class, oVar);
        this.f5571v0.K(x.class, new y());
        this.f7946t0.setAdapter(this.f5571v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        new androidx.recyclerview.widget.j(new b()).m(this.f7946t0);
        w3();
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        v3.b(e0Var, X0(w7.u.f14012d3));
        e0Var.c(new e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.Z)), new View.OnClickListener() { // from class: g8.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s sVar = this.f5568a;
                q5.k.l(sVar.G()).f0(w7.u.f14230sb).J(w7.u.K3).X(w7.u.Z, new q5.k.m() { // from class: g8.r
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        s.h3(sVar, view2, pVar);
                    }
                }).P(R.string.cancel, null).h0();
            }
        });
    }

    public final int m3() {
        return 0;
    }

    public final int n3(int i10) {
        return i10 - 1;
    }

    public final void o3() {
        for (int i10 = 0; i10 < this.f5574y0.size(); i10++) {
            m mVar = (m) this.f5574y0.get(i10);
            if (mVar.b() == 10) {
                this.f5574y0.remove(i10);
                mVar.d(true);
                this.f5573x0.add(mVar);
                return;
            }
        }
        for (m mVar2 : this.f5573x0) {
            if (mVar2.b() == 10) {
                mVar2.d(true);
                return;
            }
        }
        this.f5573x0.add(q3(10, true));
    }

    public final int p3(m mVar) {
        int iIndexOf = this.f5573x0.indexOf(mVar);
        if (iIndexOf >= 0) {
            return iIndexOf + 1;
        }
        int iIndexOf2 = this.f5574y0.indexOf(mVar);
        if (iIndexOf2 >= 0) {
            return this.f5573x0.size() + 2 + iIndexOf2;
        }
        return -1;
    }

    public final m q3(int i10, boolean z10) {
        f8.a aVarA = l.a(G(), i10);
        return new m(i10, aVarA.b(), aVarA.d(), z10);
    }

    public final int s3() {
        return this.f5573x0.size() + 1;
    }

    public final int t3(int i10) {
        return (i10 - s3()) - 1;
    }

    public final boolean u3(int i10) {
        return i10 > m3() && i10 < s3();
    }

    public final boolean v3(int i10) {
        return i10 > s3() && i10 < this.f5572w0.size();
    }

    public final void w3() {
        this.f5573x0.clear();
        this.f5574y0.clear();
        Set setC = l.c();
        for (int i10 : this.f5570u0.v0()) {
            if (setC.contains(Integer.valueOf(i10))) {
                setC.remove(Integer.valueOf(i10));
                this.f5573x0.add(q3(i10, true));
            }
        }
        for (int i11 : this.f5570u0.I2()) {
            if (setC.contains(Integer.valueOf(i11))) {
                setC.remove(Integer.valueOf(i11));
                this.f5574y0.add(q3(i11, false));
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
                this.f5574y0.add(q3(iArr[i13], false));
            }
        }
        o3();
        y3();
        this.f5571v0.l();
    }

    public final int x3(m mVar, int i10) {
        if (p3(mVar) == -1 || i10 < 0 || i10 >= this.f5572w0.size() || i10 == m3()) {
            return -1;
        }
        if (mVar.b() == 10 && i10 >= s3()) {
            return -1;
        }
        boolean zRemove = this.f5573x0.remove(mVar);
        boolean z10 = !zRemove && this.f5574y0.remove(mVar);
        if (!zRemove && !z10) {
            return -1;
        }
        if (i10 == s3()) {
            if (zRemove) {
                mVar.d(true);
                this.f5573x0.add(mVar);
            } else {
                mVar.d(false);
                this.f5574y0.add(0, mVar);
            }
        } else if (u3(i10)) {
            mVar.d(true);
            int iN3 = n3(i10);
            List list = this.f5573x0;
            list.add(Math.max(0, Math.min(iN3, list.size())), mVar);
        } else if (v3(i10)) {
            mVar.d(false);
            int iT3 = t3(i10);
            List list2 = this.f5574y0;
            list2.add(Math.max(0, Math.min(iT3, list2.size())), mVar);
        } else {
            mVar.d(true);
            this.f5573x0.add(mVar);
        }
        y3();
        return p3(mVar);
    }

    public final void y3() {
        this.f5572w0.clear();
        this.f5572w0.add(new x(X0(w7.u.C6)));
        this.f5572w0.addAll(this.f5573x0);
        this.f5572w0.add(new x(X0(w7.u.B6)));
        this.f5572w0.addAll(this.f5574y0);
    }

    public final void z3() {
        tc.a.a("save menus", new Object[0]);
        o3();
        ArrayList arrayList = new ArrayList(this.f5573x0.size());
        ArrayList arrayList2 = new ArrayList(this.f5574y0.size());
        Iterator it = this.f5573x0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((m) it.next()).b()));
        }
        Iterator it2 = this.f5574y0.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((m) it2.next()).b()));
        }
        this.f5570u0.S2(com.tuyafeng.support.utils.a.d(arrayList));
        this.f5570u0.L2(com.tuyafeng.support.utils.a.d(arrayList2));
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends androidx.recyclerview.widget.j.f {
        public b() {
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            s.this.f5575z0 = i10 != 0;
        }

        @Override // androidx.recyclerview.widget.j.f
        public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            int iL = d0Var.l();
            return (iL == -1 || iL >= s.this.f5572w0.size() || !(s.this.f5572w0.get(iL) instanceof m)) ? androidx.recyclerview.widget.j.f.t(0, 0) : androidx.recyclerview.widget.j.f.t(15, 0);
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            int iL = d0Var.l();
            int iL2 = d0Var2.l();
            if (iL == -1 || iL2 == -1 || iL == iL2 || iL >= s.this.f5572w0.size() || iL2 >= s.this.f5572w0.size() || !(s.this.f5572w0.get(iL) instanceof m)) {
                return false;
            }
            int iX3 = s.this.x3((m) s.this.f5572w0.get(iL), iL2);
            if (iX3 == -1) {
                return false;
            }
            s.this.f5571v0.p(iL, iX3);
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
        }
    }
}
