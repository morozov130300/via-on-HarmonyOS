package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class v extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f1505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f1506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.t f1507c = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1508a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f1508a) {
                this.f1508a = false;
                v.this.j();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f1508a = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f1505a.getLayoutManager();
        if (layoutManager == null || this.f1505a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1505a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && i(layoutManager, i10, i11);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1505a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.f1505a = recyclerView;
        if (recyclerView != null) {
            h();
            this.f1506b = new Scroller(this.f1505a.getContext(), new DecelerateInterpolator());
            j();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public abstract RecyclerView.z d(RecyclerView.o oVar);

    public final void e() {
        this.f1505a.g1(this.f1507c);
        this.f1505a.setOnFlingListener(null);
    }

    public abstract View f(RecyclerView.o oVar);

    public abstract int g(RecyclerView.o oVar, int i10, int i11);

    public final void h() {
        if (this.f1505a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1505a.o(this.f1507c);
        this.f1505a.setOnFlingListener(this);
    }

    public final boolean i(RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.z zVarD;
        int iG;
        if (!(oVar instanceof RecyclerView.z.b) || (zVarD = d(oVar)) == null || (iG = g(oVar, i10, i11)) == -1) {
            return false;
        }
        zVarD.p(iG);
        oVar.K1(zVarD);
        return true;
    }

    public void j() {
        RecyclerView.o layoutManager;
        View viewF;
        RecyclerView recyclerView = this.f1505a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewF = f(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewF);
        int i10 = iArrC[0];
        if (i10 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f1505a.t1(i10, iArrC[1]);
    }
}
