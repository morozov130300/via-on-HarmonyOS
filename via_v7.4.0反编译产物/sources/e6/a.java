package e6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import g6.f;
import g6.y;
import h6.a;
import java.util.List;
import x7.o;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends RecyclerView.Adapter {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView.Adapter f4775d;

    /* renamed from: e, reason: collision with root package name */
    public int f4776e = 1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: e6.a$a, reason: collision with other inner class name */
    public static class C0067a extends RecyclerView.c0 {

        /* renamed from: v, reason: collision with root package name */
        public static final int f4777v = y.l();

        /* renamed from: w, reason: collision with root package name */
        public static final int f4778w = y.l();

        /* renamed from: u, reason: collision with root package name */
        public ProgressBar f4779u;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: e6.a$a$a, reason: collision with other inner class name */
        public class C0068a implements a.InterfaceC0076a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f4780a;

            public C0068a(Context context) {
                this.f4780a = context;
            }

            @Override // h6.a.InterfaceC0076a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(ProgressBar progressBar) {
                progressBar.setIndeterminate(false);
                progressBar.setIndeterminateDrawable(f.e(this.f4780a, o.f13738k));
            }
        }

        public C0067a(View view) {
            super(view);
            this.f4779u = (ProgressBar) view.findViewById(f4778w);
        }

        public static C0067a P(Context context) {
            FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, y.h(context, 48.0f))).o(f4777v).l();
            View view = (ProgressBar) new h6.a(new ProgressBar(context), new FrameLayout.LayoutParams(-1, -1)).o(f4778w).V(new C0068a(context)).l();
            frameLayout.addView(view);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            return new C0067a(frameLayout);
        }

        public final void Q(int i10) {
            this.f4779u.setVisibility(i10 == 0 ? 0 : 8);
        }
    }

    public a(RecyclerView.Adapter adapter) {
        this.f4775d = adapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean A(RecyclerView.c0 c0Var) {
        return c0Var instanceof C0067a ? super.A(c0Var) : this.f4775d.A(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void B(RecyclerView.c0 c0Var) {
        if (c0Var instanceof C0067a) {
            super.B(c0Var);
        } else {
            this.f4775d.B(c0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void C(RecyclerView.c0 c0Var) {
        if (c0Var instanceof C0067a) {
            super.C(c0Var);
        } else {
            this.f4775d.C(c0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void D(RecyclerView.c0 c0Var) {
        if (c0Var instanceof C0067a) {
            super.D(c0Var);
        } else {
            this.f4775d.D(c0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void E(RecyclerView.i iVar) {
        super.E(iVar);
        this.f4775d.E(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void G(RecyclerView.i iVar) {
        super.G(iVar);
        this.f4775d.G(iVar);
    }

    public final boolean H() {
        return this.f4776e != 2;
    }

    public void I(int i10) {
        int i11 = this.f4776e;
        if (i11 == i10) {
            return;
        }
        boolean z10 = i11 != 2;
        boolean z11 = i10 != 2;
        this.f4776e = i10;
        if (z10 == z11) {
            m(this.f4775d.g());
        } else if (z10) {
            u(this.f4775d.g());
        } else {
            o(this.f4775d.g());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int g() {
        return this.f4775d.g() + (H() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long h(int i10) {
        return i10 >= this.f4775d.g() ? super.h(i10) : this.f4775d.h(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int i(int i10) {
        if (i10 == this.f4775d.g()) {
            return 1;
        }
        return this.f4775d.i(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void w(RecyclerView.c0 c0Var, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void x(RecyclerView.c0 c0Var, int i10, List list) {
        if (!(c0Var instanceof C0067a)) {
            this.f4775d.x(c0Var, i10, list);
        } else {
            super.x(c0Var, i10, list);
            ((C0067a) c0Var).Q(this.f4776e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.c0 y(ViewGroup viewGroup, int i10) {
        return i10 == 1 ? C0067a.P(viewGroup.getContext()) : this.f4775d.y(viewGroup, i10);
    }
}
