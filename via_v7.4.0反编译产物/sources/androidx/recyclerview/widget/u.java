package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u extends RecyclerView.l {

    /* renamed from: g, reason: collision with root package name */
    public boolean f1603g = true;

    public abstract boolean A(RecyclerView.c0 c0Var);

    public abstract boolean B(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean C(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13);

    public abstract boolean D(RecyclerView.c0 c0Var);

    public final void E(RecyclerView.c0 c0Var) {
        M(c0Var);
        h(c0Var);
    }

    public final void F(RecyclerView.c0 c0Var) {
        N(c0Var);
    }

    public final void G(RecyclerView.c0 c0Var, boolean z10) {
        O(c0Var, z10);
        h(c0Var);
    }

    public final void H(RecyclerView.c0 c0Var, boolean z10) {
        P(c0Var, z10);
    }

    public final void I(RecyclerView.c0 c0Var) {
        Q(c0Var);
        h(c0Var);
    }

    public final void J(RecyclerView.c0 c0Var) {
        R(c0Var);
    }

    public final void K(RecyclerView.c0 c0Var) {
        S(c0Var);
        h(c0Var);
    }

    public final void L(RecyclerView.c0 c0Var) {
        T(c0Var);
    }

    public void M(RecyclerView.c0 c0Var) {
    }

    public void N(RecyclerView.c0 c0Var) {
    }

    public void O(RecyclerView.c0 c0Var, boolean z10) {
    }

    public void P(RecyclerView.c0 c0Var, boolean z10) {
    }

    public void Q(RecyclerView.c0 c0Var) {
    }

    public void R(RecyclerView.c0 c0Var) {
    }

    public void S(RecyclerView.c0 c0Var) {
    }

    public void T(RecyclerView.c0 c0Var) {
    }

    public void U(boolean z10) {
        this.f1603g = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        return (cVar == null || ((i10 = cVar.f1248a) == (i11 = cVar2.f1248a) && cVar.f1249b == cVar2.f1249b)) ? A(c0Var) : C(c0Var, i10, cVar.f1249b, i11, cVar2.f1249b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f1248a;
        int i13 = cVar.f1249b;
        if (c0Var2.L()) {
            int i14 = cVar.f1248a;
            i11 = cVar.f1249b;
            i10 = i14;
        } else {
            i10 = cVar2.f1248a;
            i11 = cVar2.f1249b;
        }
        return B(c0Var, c0Var2, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f1248a;
        int i11 = cVar.f1249b;
        View view = c0Var.f1219a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1248a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1249b;
        if (c0Var.x() || (i10 == left && i11 == top)) {
            return D(c0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return C(c0Var, i10, i11, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f1248a;
        int i11 = cVar2.f1248a;
        if (i10 != i11 || cVar.f1249b != cVar2.f1249b) {
            return C(c0Var, i10, cVar.f1249b, i11, cVar2.f1249b);
        }
        I(c0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.c0 c0Var) {
        return !this.f1603g || c0Var.v();
    }
}
