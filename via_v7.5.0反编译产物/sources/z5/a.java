package z5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.x;
import java.util.List;
import w7.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.Adapter f15183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15184e = 1;

    /* JADX INFO: renamed from: z5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0164a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f15185v = x.l();

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f15186w = x.l();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public ProgressBar f15187u;

        /* JADX INFO: renamed from: z5.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0165a implements b6.a.InterfaceC0033a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f15188a;

            public C0165a(Context context) {
                this.f15188a = context;
            }

            @Override // b6.a.InterfaceC0033a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(ProgressBar progressBar) {
                progressBar.setIndeterminate(false);
                progressBar.setIndeterminateDrawable(f.e(this.f15188a, o.f13801j));
            }
        }

        public C0164a(View view) {
            super(view);
            this.f15187u = (ProgressBar) view.findViewById(f15186w);
        }

        public static C0164a P(Context context) {
            FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, x.h(context, 48.0f))).o(f15185v).l();
            View view = (ProgressBar) new b6.a(new ProgressBar(context), new FrameLayout.LayoutParams(-1, -1)).o(f15186w).V(new C0165a(context)).l();
            frameLayout.addView(view);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            return new C0164a(frameLayout);
        }

        public final void Q(int i10) {
            this.f15187u.setVisibility(i10 == 0 ? 0 : 8);
        }
    }

    public a(RecyclerView.Adapter adapter) {
        this.f15183d = adapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean A(RecyclerView.d0 d0Var) {
        return d0Var instanceof C0164a ? super.A(d0Var) : this.f15183d.A(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void B(RecyclerView.d0 d0Var) {
        if (d0Var instanceof C0164a) {
            super.B(d0Var);
        } else {
            this.f15183d.B(d0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void C(RecyclerView.d0 d0Var) {
        if (d0Var instanceof C0164a) {
            super.C(d0Var);
        } else {
            this.f15183d.C(d0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void D(RecyclerView.d0 d0Var) {
        if (d0Var instanceof C0164a) {
            super.D(d0Var);
        } else {
            this.f15183d.D(d0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void E(RecyclerView.i iVar) {
        super.E(iVar);
        this.f15183d.E(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void G(RecyclerView.i iVar) {
        super.G(iVar);
        this.f15183d.G(iVar);
    }

    public final boolean H() {
        return this.f15184e != 2;
    }

    public void I(int i10) {
        int i11 = this.f15184e;
        if (i11 == i10) {
            return;
        }
        boolean z10 = i11 != 2;
        boolean z11 = i10 != 2;
        this.f15184e = i10;
        if (z10 == z11) {
            m(this.f15183d.g());
        } else if (z10) {
            u(this.f15183d.g());
        } else {
            o(this.f15183d.g());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int g() {
        return this.f15183d.g() + (H() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long h(int i10) {
        return i10 >= this.f15183d.g() ? super.h(i10) : this.f15183d.h(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int i(int i10) {
        if (i10 == this.f15183d.g()) {
            return 1;
        }
        return this.f15183d.i(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void x(RecyclerView.d0 d0Var, int i10, List list) {
        if (!(d0Var instanceof C0164a)) {
            this.f15183d.x(d0Var, i10, list);
        } else {
            super.x(d0Var, i10, list);
            ((C0164a) d0Var).Q(this.f15184e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.d0 y(ViewGroup viewGroup, int i10) {
        return i10 == 1 ? C0164a.P(viewGroup.getContext()) : this.f15183d.y(viewGroup, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void w(RecyclerView.d0 d0Var, int i10) {
    }
}
