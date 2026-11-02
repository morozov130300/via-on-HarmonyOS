package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f1593a;

    /* renamed from: b, reason: collision with root package name */
    public int f1594b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1595c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends q {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.q
        public int d(View view) {
            return this.f1593a.U(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1593a.T(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1593a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int g(View view) {
            return this.f1593a.R(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int h() {
            return this.f1593a.p0();
        }

        @Override // androidx.recyclerview.widget.q
        public int i() {
            return this.f1593a.p0() - this.f1593a.g0();
        }

        @Override // androidx.recyclerview.widget.q
        public int j() {
            return this.f1593a.g0();
        }

        @Override // androidx.recyclerview.widget.q
        public int k() {
            return this.f1593a.q0();
        }

        @Override // androidx.recyclerview.widget.q
        public int l() {
            return this.f1593a.Y();
        }

        @Override // androidx.recyclerview.widget.q
        public int m() {
            return this.f1593a.f0();
        }

        @Override // androidx.recyclerview.widget.q
        public int n() {
            return (this.f1593a.p0() - this.f1593a.f0()) - this.f1593a.g0();
        }

        @Override // androidx.recyclerview.widget.q
        public int p(View view) {
            this.f1593a.o0(view, true, this.f1595c);
            return this.f1595c.right;
        }

        @Override // androidx.recyclerview.widget.q
        public int q(View view) {
            this.f1593a.o0(view, true, this.f1595c);
            return this.f1595c.left;
        }

        @Override // androidx.recyclerview.widget.q
        public void r(int i10) {
            this.f1593a.D0(i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends q {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.q
        public int d(View view) {
            return this.f1593a.P(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1593a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1593a.T(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int g(View view) {
            return this.f1593a.V(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.q
        public int h() {
            return this.f1593a.X();
        }

        @Override // androidx.recyclerview.widget.q
        public int i() {
            return this.f1593a.X() - this.f1593a.e0();
        }

        @Override // androidx.recyclerview.widget.q
        public int j() {
            return this.f1593a.e0();
        }

        @Override // androidx.recyclerview.widget.q
        public int k() {
            return this.f1593a.Y();
        }

        @Override // androidx.recyclerview.widget.q
        public int l() {
            return this.f1593a.q0();
        }

        @Override // androidx.recyclerview.widget.q
        public int m() {
            return this.f1593a.h0();
        }

        @Override // androidx.recyclerview.widget.q
        public int n() {
            return (this.f1593a.X() - this.f1593a.h0()) - this.f1593a.e0();
        }

        @Override // androidx.recyclerview.widget.q
        public int p(View view) {
            this.f1593a.o0(view, true, this.f1595c);
            return this.f1595c.bottom;
        }

        @Override // androidx.recyclerview.widget.q
        public int q(View view) {
            this.f1593a.o0(view, true, this.f1595c);
            return this.f1595c.top;
        }

        @Override // androidx.recyclerview.widget.q
        public void r(int i10) {
            this.f1593a.E0(i10);
        }
    }

    public q(RecyclerView.o oVar) {
        this.f1594b = Integer.MIN_VALUE;
        this.f1595c = new Rect();
        this.f1593a = oVar;
    }

    public /* synthetic */ q(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static q a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static q b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static q c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f1594b) {
            return 0;
        }
        return n() - this.f1594b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f1594b = n();
    }
}
