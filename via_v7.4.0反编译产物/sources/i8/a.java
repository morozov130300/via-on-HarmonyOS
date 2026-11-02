package i8;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends androidx.recyclerview.widget.v {

    /* renamed from: n, reason: collision with root package name */
    public static final Interpolator f7054n = new InterpolatorC0081a();

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f7055d;

    /* renamed from: e, reason: collision with root package name */
    public int f7056e;

    /* renamed from: f, reason: collision with root package name */
    public int f7057f;

    /* renamed from: g, reason: collision with root package name */
    public int f7058g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7059h;

    /* renamed from: i, reason: collision with root package name */
    public d f7060i;

    /* renamed from: j, reason: collision with root package name */
    public int f7061j = -1;

    /* renamed from: k, reason: collision with root package name */
    public Scroller f7062k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.recyclerview.widget.q f7063l;

    /* renamed from: m, reason: collision with root package name */
    public c f7064m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: i8.a$a, reason: collision with other inner class name */
    public class InterpolatorC0081a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends androidx.recyclerview.widget.n {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.n, androidx.recyclerview.widget.RecyclerView.y
        public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            a aVar2 = a.this;
            int[] iArrC = aVar2.c(aVar2.f7055d.getLayoutManager(), view);
            int i10 = iArrC[0];
            int i11 = iArrC[1];
            int iW = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iW > 0) {
                aVar.d(i10, i11, iW, a.f7054n);
            }
        }

        @Override // androidx.recyclerview.widget.n
        public float v(DisplayMetrics displayMetrics) {
            return 50.0f / displayMetrics.densityDpi;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f7066a;

        public c(int i10) {
            this.f7066a = i10 == 1;
        }

        public int[] a(LinearLayoutManager linearLayoutManager, int i10) {
            int[] iArr = new int[2];
            int iA2 = linearLayoutManager.a2();
            if (linearLayoutManager.l() && i10 <= iA2) {
                if (this.f7066a) {
                    iArr[0] = a.this.f7063l.d(linearLayoutManager.D(linearLayoutManager.d2())) + ((iA2 - i10) * a.this.f7058g);
                } else {
                    iArr[0] = a.this.f7063l.g(linearLayoutManager.D(iA2)) - ((iA2 - i10) * a.this.f7058g);
                }
            }
            if (linearLayoutManager.m() && i10 <= iA2) {
                View viewD = linearLayoutManager.D(iA2);
                iArr[1] = (viewD != null ? viewD.getTop() : 0) - ((iA2 - i10) * a.this.f7058g);
            }
            return iArr;
        }

        public int b(LinearLayoutManager linearLayoutManager, int i10, int i11) {
            int iY = a.this.y(Math.abs(i10) / i11);
            if (iY < a.this.f7056e) {
                iY = a.this.f7056e;
            } else if (iY > a.this.f7057f) {
                iY = a.this.f7057f;
            }
            if (i10 < 0) {
                iY *= -1;
            }
            if (this.f7066a) {
                iY *= -1;
            }
            return (a.this.f7064m.d(i10 < 0) ? a.this.x(linearLayoutManager.a2()) : a.this.x(linearLayoutManager.d2())) + iY;
        }

        public int c(View view) {
            return this.f7066a ? a.this.f7063l.d(view) - a.this.f7055d.getWidth() : a.this.f7063l.g(view);
        }

        public boolean d(boolean z10) {
            return this.f7066a ? z10 : !z10;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        void a(int i10);

        void b(int i10);
    }

    public a(int i10) {
        this.f7059h = i10;
    }

    @Override // androidx.recyclerview.widget.v
    public void b(RecyclerView recyclerView) {
        if (recyclerView != null) {
            this.f7055d = recyclerView;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager == null) {
                throw new IllegalStateException("RecyclerView must have a layout manager");
            }
            if (linearLayoutManager.l()) {
                boolean zD = g6.l.d(recyclerView.getContext());
                this.f7063l = androidx.recyclerview.widget.q.a(linearLayoutManager);
                this.f7064m = new c(zD ? 1 : 0);
            } else {
                if (!linearLayoutManager.m()) {
                    throw new IllegalStateException("RecyclerView must be scrollable");
                }
                this.f7063l = androidx.recyclerview.widget.q.c(linearLayoutManager);
                this.f7064m = new c(0);
            }
            this.f7062k = new Scroller(this.f7055d.getContext(), f7054n);
            w(linearLayoutManager);
        }
        super.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.v
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.l()) {
            iArr[0] = this.f7064m.c(view);
        }
        if (oVar.m()) {
            iArr[1] = this.f7064m.c(view);
        }
        d dVar = this.f7060i;
        if (dVar != null) {
            if (iArr[0] == 0 && iArr[1] == 0) {
                dVar.a(oVar.i0(view));
                return iArr;
            }
            dVar.b(oVar.i0(view));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.v
    public View f(RecyclerView.o oVar) {
        int iT = t((LinearLayoutManager) oVar);
        if (iT == -1) {
            return null;
        }
        return oVar.D(iT);
    }

    @Override // androidx.recyclerview.widget.v
    public int g(RecyclerView.o oVar, int i10, int i11) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) oVar;
        w(oVar);
        this.f7062k.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (i10 != 0) {
            return this.f7064m.b(linearLayoutManager, this.f7062k.getFinalX(), this.f7058g);
        }
        if (i11 != 0) {
            return this.f7064m.b(linearLayoutManager, this.f7062k.getFinalY(), this.f7058g);
        }
        return -1;
    }

    public final int t(LinearLayoutManager linearLayoutManager) {
        int iW1;
        int iA2 = linearLayoutManager.a2();
        if (iA2 == -1) {
            return -1;
        }
        w(linearLayoutManager);
        if (iA2 >= this.f7061j) {
            iW1 = linearLayoutManager.W1();
            if (iW1 == -1 || iW1 % this.f7056e != 0) {
                iW1 = x(this.f7056e + iA2);
            }
        } else {
            int iX = x(iA2);
            if (linearLayoutManager.D(iX) == null) {
                int[] iArrA = this.f7064m.a(linearLayoutManager, iX);
                this.f7055d.u1(iArrA[0], iArrA[1], f7054n);
            }
            iW1 = iX;
        }
        this.f7061j = iA2;
        return iW1;
    }

    @Override // androidx.recyclerview.widget.v
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public androidx.recyclerview.widget.n d(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new b(this.f7055d.getContext());
        }
        return null;
    }

    public final int v(RecyclerView.o oVar) {
        if (oVar instanceof GridLayoutManager) {
            return ((GridLayoutManager) oVar).X2();
        }
        return 1;
    }

    public final void w(RecyclerView.o oVar) {
        View viewJ;
        if (this.f7058g == 0 && (viewJ = oVar.J(0)) != null) {
            if (oVar.l()) {
                this.f7058g = viewJ.getWidth();
                this.f7056e = v(oVar) * (this.f7055d.getWidth() / this.f7058g);
            } else if (oVar.m()) {
                this.f7058g = viewJ.getHeight();
                this.f7056e = v(oVar) * (this.f7055d.getHeight() / this.f7058g);
            }
            this.f7057f = this.f7056e * this.f7059h;
        }
    }

    public final int x(int i10) {
        return i10 - (i10 % this.f7056e);
    }

    public final int y(int i10) {
        return x((i10 + this.f7056e) - 1);
    }

    public void z(d dVar) {
        this.f7060i = dVar;
    }
}
