package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v extends RecyclerView.r {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f1604a;

    /* renamed from: b, reason: collision with root package name */
    public Scroller f1605b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView.t f1606c = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1607a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f1607a) {
                this.f1607a = false;
                v.this.j();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f1607a = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f1604a.getLayoutManager();
        if (layoutManager == null || this.f1604a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1604a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && i(layoutManager, i10, i11);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1604a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.f1604a = recyclerView;
        if (recyclerView != null) {
            h();
            this.f1605b = new Scroller(this.f1604a.getContext(), new DecelerateInterpolator());
            j();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public abstract RecyclerView.y d(RecyclerView.o oVar);

    public final void e() {
        this.f1604a.g1(this.f1606c);
        this.f1604a.setOnFlingListener(null);
    }

    public abstract View f(RecyclerView.o oVar);

    public abstract int g(RecyclerView.o oVar, int i10, int i11);

    public final void h() {
        if (this.f1604a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1604a.o(this.f1606c);
        this.f1604a.setOnFlingListener(this);
    }

    public final boolean i(RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.y yVarD;
        int iG;
        if (!(oVar instanceof RecyclerView.y.b) || (yVarD = d(oVar)) == null || (iG = g(oVar, i10, i11)) == -1) {
            return false;
        }
        yVarD.p(iG);
        oVar.K1(yVarD);
        return true;
    }

    public void j() {
        RecyclerView.o layoutManager;
        View viewF;
        RecyclerView recyclerView = this.f1604a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewF = f(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewF);
        int i10 = iArrC[0];
        if (i10 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f1604a.t1(i10, iArrC[1]);
    }
}
