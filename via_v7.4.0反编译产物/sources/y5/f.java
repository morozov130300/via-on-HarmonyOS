package y5;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends RecyclerView.Adapter {

    /* renamed from: f, reason: collision with root package name */
    public static final String f14464f = "f";

    /* renamed from: d, reason: collision with root package name */
    public List f14465d;

    /* renamed from: e, reason: collision with root package name */
    public final k f14466e = new c();

    public f(List list) {
        this.f14465d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean A(RecyclerView.c0 c0Var) {
        return I(c0Var).e(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void B(RecyclerView.c0 c0Var) {
        I(c0Var).f(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void C(RecyclerView.c0 c0Var) {
        I(c0Var).g(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void D(RecyclerView.c0 c0Var) {
        I(c0Var).h(c0Var);
    }

    public List H() {
        return this.f14465d;
    }

    public final d I(RecyclerView.c0 c0Var) {
        return this.f14466e.getType(c0Var.n()).b();
    }

    public final int J(int i10, Object obj) {
        int iB = this.f14466e.b(obj.getClass());
        if (iB >= 0) {
            return iB + this.f14466e.getType(iB).c().a(i10, obj);
        }
        throw new IndexOutOfBoundsException("Can not find type for " + obj.getClass().getName());
    }

    public void K(Class cls, d dVar) {
        N(cls);
        L(new j(cls, dVar, new b()));
    }

    public void L(j jVar) {
        this.f14466e.c(jVar);
    }

    public void M(List list) {
        this.f14465d = list;
    }

    public final void N(Class cls) {
        if (this.f14466e.a(cls)) {
            Log.w(f14464f, "The type " + cls.getSimpleName() + " you originally registered is now overwritten.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int g() {
        return this.f14465d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long h(int i10) {
        return this.f14466e.getType(i(i10)).b().a(this.f14465d.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int i(int i10) {
        return J(i10, this.f14465d.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void w(RecyclerView.c0 c0Var, int i10) {
        x(c0Var, i10, Collections.EMPTY_LIST);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void x(RecyclerView.c0 c0Var, int i10, List list) {
        I(c0Var).c(c0Var, this.f14465d.get(i10), list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.c0 y(ViewGroup viewGroup, int i10) {
        return this.f14466e.getType(i10).b().d(viewGroup.getContext(), viewGroup);
    }
}
