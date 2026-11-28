package t5;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12556f = "f";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f12557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f12558e = new c();

    public f(List list) {
        this.f12557d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean A(RecyclerView.d0 d0Var) {
        return I(d0Var).e(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void B(RecyclerView.d0 d0Var) {
        I(d0Var).f(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void C(RecyclerView.d0 d0Var) {
        I(d0Var).g(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void D(RecyclerView.d0 d0Var) {
        I(d0Var).h(d0Var);
    }

    public List H() {
        return this.f12557d;
    }

    public final d I(RecyclerView.d0 d0Var) {
        return this.f12558e.getType(d0Var.n()).b();
    }

    public final int J(int i10, Object obj) {
        int iB = this.f12558e.b(obj.getClass());
        if (iB >= 0) {
            return iB + this.f12558e.getType(iB).c().a(i10, obj);
        }
        throw new IndexOutOfBoundsException("Can not find type for " + obj.getClass().getName());
    }

    public void K(Class cls, d dVar) {
        N(cls);
        L(new j(cls, dVar, new b()));
    }

    public void L(j jVar) {
        this.f12558e.c(jVar);
    }

    public void M(List list) {
        this.f12557d = list;
    }

    public final void N(Class cls) {
        if (this.f12558e.a(cls)) {
            Log.w(f12556f, "The type " + cls.getSimpleName() + " you originally registered is now overwritten.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int g() {
        return this.f12557d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long h(int i10) {
        return this.f12558e.getType(i(i10)).b().a(this.f12557d.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int i(int i10) {
        return J(i10, this.f12557d.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void w(RecyclerView.d0 d0Var, int i10) {
        x(d0Var, i10, Collections.EMPTY_LIST);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void x(RecyclerView.d0 d0Var, int i10, List list) {
        I(d0Var).c(d0Var, this.f12557d.get(i10), list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.d0 y(ViewGroup viewGroup, int i10) {
        return this.f12558e.getType(i10).b().d(viewGroup.getContext(), viewGroup);
    }
}
