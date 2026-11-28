package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u extends RecyclerView.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1504g = true;

    public abstract boolean A(RecyclerView.d0 d0Var);

    public abstract boolean B(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean C(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13);

    public abstract boolean D(RecyclerView.d0 d0Var);

    public final void E(RecyclerView.d0 d0Var) {
        M(d0Var);
        h(d0Var);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var, boolean z10) {
        O(d0Var, z10);
        h(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var, boolean z10) {
        P(d0Var, z10);
    }

    public final void I(RecyclerView.d0 d0Var) {
        Q(d0Var);
        h(d0Var);
    }

    public final void J(RecyclerView.d0 d0Var) {
        R(d0Var);
    }

    public final void K(RecyclerView.d0 d0Var) {
        S(d0Var);
        h(d0Var);
    }

    public final void L(RecyclerView.d0 d0Var) {
        T(d0Var);
    }

    public void U(boolean z10) {
        this.f1504g = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        return (cVar == null || ((i10 = cVar.f1166a) == (i11 = cVar2.f1166a) && cVar.f1167b == cVar2.f1167b)) ? A(d0Var) : C(d0Var, i10, cVar.f1167b, i11, cVar2.f1167b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f1166a;
        int i13 = cVar.f1167b;
        if (d0Var2.L()) {
            int i14 = cVar.f1166a;
            i11 = cVar.f1167b;
            i10 = i14;
        } else {
            i10 = cVar2.f1166a;
            i11 = cVar2.f1167b;
        }
        return B(d0Var, d0Var2, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f1166a;
        int i11 = cVar.f1167b;
        View view = d0Var.f1138a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1166a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1167b;
        if (d0Var.x() || (i10 == left && i11 == top)) {
            return D(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return C(d0Var, i10, i11, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f1166a;
        int i11 = cVar2.f1166a;
        if (i10 != i11 || cVar.f1167b != cVar2.f1167b) {
            return C(d0Var, i10, cVar.f1167b, i11, cVar2.f1167b);
        }
        I(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.d0 d0Var) {
        return !this.f1504g || d0Var.v();
    }

    public void M(RecyclerView.d0 d0Var) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void Q(RecyclerView.d0 d0Var) {
    }

    public void R(RecyclerView.d0 d0Var) {
    }

    public void S(RecyclerView.d0 d0Var) {
    }

    public void T(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var, boolean z10) {
    }

    public void P(RecyclerView.d0 d0Var, boolean z10) {
    }
}
