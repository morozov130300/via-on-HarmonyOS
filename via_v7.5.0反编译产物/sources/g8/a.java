package g8;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.recyclerview.widget.v {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Interpolator f5541n = new InterpolatorC0071a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f5542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f5547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5548j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Scroller f5549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.recyclerview.widget.q f5550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f5551m;

    /* JADX INFO: renamed from: g8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class InterpolatorC0071a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends androidx.recyclerview.widget.n {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.n, androidx.recyclerview.widget.RecyclerView.z
        public void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            a aVar2 = a.this;
            int[] iArrC = aVar2.c(aVar2.f5542d.getLayoutManager(), view);
            int i10 = iArrC[0];
            int i11 = iArrC[1];
            int iW = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iW > 0) {
                aVar.d(i10, i11, iW, a.f5541n);
            }
        }

        @Override // androidx.recyclerview.widget.n
        public float v(DisplayMetrics displayMetrics) {
            return 50.0f / displayMetrics.densityDpi;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f5553a;

        public c(int i10) {
            this.f5553a = i10 == 1;
        }

        public int[] a(LinearLayoutManager linearLayoutManager, int i10) {
            int[] iArr = new int[2];
            int iA2 = linearLayoutManager.a2();
            if (linearLayoutManager.l() && i10 <= iA2) {
                if (this.f5553a) {
                    iArr[0] = a.this.f5550l.d(linearLayoutManager.D(linearLayoutManager.d2())) + ((iA2 - i10) * a.this.f5545g);
                } else {
                    iArr[0] = a.this.f5550l.g(linearLayoutManager.D(iA2)) - ((iA2 - i10) * a.this.f5545g);
                }
            }
            if (linearLayoutManager.m() && i10 <= iA2) {
                View viewD = linearLayoutManager.D(iA2);
                iArr[1] = (viewD != null ? viewD.getTop() : 0) - ((iA2 - i10) * a.this.f5545g);
            }
            return iArr;
        }

        public int b(LinearLayoutManager linearLayoutManager, int i10, int i11) {
            int iY = a.this.y(Math.abs(i10) / i11);
            if (iY < a.this.f5543e) {
                iY = a.this.f5543e;
            } else if (iY > a.this.f5544f) {
                iY = a.this.f5544f;
            }
            if (i10 < 0) {
                iY *= -1;
            }
            if (this.f5553a) {
                iY *= -1;
            }
            return (a.this.f5551m.d(i10 < 0) ? a.this.x(linearLayoutManager.a2()) : a.this.x(linearLayoutManager.d2())) + iY;
        }

        public int c(View view) {
            return this.f5553a ? a.this.f5550l.d(view) - a.this.f5542d.getWidth() : a.this.f5550l.g(view);
        }

        public boolean d(boolean z10) {
            if (this.f5553a) {
                return z10;
            }
            return !z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        void a(int i10);

        void b(int i10);
    }

    public a(int i10) {
        this.f5546h = i10;
    }

    @Override // androidx.recyclerview.widget.v
    public void b(RecyclerView recyclerView) {
        if (recyclerView != null) {
            this.f5542d = recyclerView;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager == null) {
                throw new IllegalStateException("RecyclerView must have a layout manager");
            }
            if (linearLayoutManager.l()) {
                boolean zD = com.tuyafeng.support.utils.l.d(recyclerView.getContext());
                this.f5550l = androidx.recyclerview.widget.q.a(linearLayoutManager);
                this.f5551m = new c(zD ? 1 : 0);
            } else {
                if (!linearLayoutManager.m()) {
                    throw new IllegalStateException("RecyclerView must be scrollable");
                }
                this.f5550l = androidx.recyclerview.widget.q.c(linearLayoutManager);
                this.f5551m = new c(0);
            }
            this.f5549k = new Scroller(this.f5542d.getContext(), f5541n);
            w(linearLayoutManager);
        }
        super.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.v
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.l()) {
            iArr[0] = this.f5551m.c(view);
        }
        if (oVar.m()) {
            iArr[1] = this.f5551m.c(view);
        }
        d dVar = this.f5547i;
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
        this.f5549k.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (i10 != 0) {
            return this.f5551m.b(linearLayoutManager, this.f5549k.getFinalX(), this.f5545g);
        }
        if (i11 != 0) {
            return this.f5551m.b(linearLayoutManager, this.f5549k.getFinalY(), this.f5545g);
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
        if (iA2 >= this.f5548j) {
            iW1 = linearLayoutManager.W1();
            if (iW1 == -1 || iW1 % this.f5543e != 0) {
                iW1 = x(this.f5543e + iA2);
            }
        } else {
            int iX = x(iA2);
            if (linearLayoutManager.D(iX) == null) {
                int[] iArrA = this.f5551m.a(linearLayoutManager, iX);
                this.f5542d.u1(iArrA[0], iArrA[1], f5541n);
            }
            iW1 = iX;
        }
        this.f5548j = iA2;
        return iW1;
    }

    @Override // androidx.recyclerview.widget.v
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public androidx.recyclerview.widget.n d(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new b(this.f5542d.getContext());
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
        if (this.f5545g == 0 && (viewJ = oVar.J(0)) != null) {
            if (oVar.l()) {
                this.f5545g = viewJ.getWidth();
                this.f5543e = v(oVar) * (this.f5542d.getWidth() / this.f5545g);
            } else if (oVar.m()) {
                this.f5545g = viewJ.getHeight();
                this.f5543e = v(oVar) * (this.f5542d.getHeight() / this.f5545g);
            }
            this.f5544f = this.f5543e * this.f5546h;
        }
    }

    public final int x(int i10) {
        return i10 - (i10 % this.f5543e);
    }

    public final int y(int i10) {
        return x((i10 + this.f5543e) - 1);
    }

    public void z(d dVar) {
        this.f5547i = dVar;
    }
}
