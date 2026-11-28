package l8;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements RecyclerView.s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7483c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC0093b f7486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l8.a f7487g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f7490j;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f7502v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f7481a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f7482b = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7488h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7489i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7491k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7492l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7493m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7494n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7495o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7496p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7497q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7498r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7499s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7500t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7501u = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map f7503w = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7484d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7485e = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f7498r) {
                b.this.f7490j.scrollBy(0, -b.this.f7500t);
                b.this.f7481a.postDelayed(this, 25L);
            } else if (b.this.f7499s) {
                b.this.f7490j.scrollBy(0, b.this.f7500t);
                b.this.f7481a.postDelayed(this, 25L);
            }
        }
    }

    /* JADX INFO: renamed from: l8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0093b {
        void a(boolean z10);

        void b(boolean z10);
    }

    public b(Context context, l8.a aVar) {
        this.f7483c = x.h(context, 56.0f);
        this.f7487g = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y10 = motionEvent.getY();
        int i10 = i(recyclerView, motionEvent.getX(), y10);
        if (action == 1) {
            m();
            return;
        }
        if (action == 2) {
            if (this.f7483c > -1) {
                if (y10 <= this.f7496p) {
                    this.f7499s = false;
                    if (!this.f7498r) {
                        this.f7498r = true;
                        this.f7481a.removeCallbacks(this.f7482b);
                        this.f7481a.postDelayed(this.f7482b, 25L);
                        l(true);
                    }
                    this.f7500t = ((int) Math.min(this.f7483c, this.f7496p - y10)) / 2;
                } else if (y10 >= this.f7497q) {
                    this.f7498r = false;
                    if (!this.f7499s) {
                        this.f7499s = true;
                        this.f7481a.removeCallbacks(this.f7482b);
                        this.f7481a.postDelayed(this.f7482b, 25L);
                        l(true);
                    }
                    this.f7500t = ((int) Math.min(this.f7483c, y10 - this.f7497q)) / 2;
                } else if (this.f7498r || this.f7499s) {
                    this.f7481a.removeCallbacks(this.f7482b);
                    l(false);
                    this.f7498r = false;
                    this.f7499s = false;
                }
            }
            if (i10 != -1 && this.f7491k != i10 && (this.f7502v <= 0.0f || j(recyclerView, motionEvent.getX()))) {
                int i11 = this.f7489i;
                if (i11 == 1) {
                    int i12 = this.f7491k;
                    int i13 = i10 > i12 ? i10 : i12 - 1;
                    boolean zA = this.f7487g.a(this.f7492l);
                    for (int i14 = i10 > i12 ? i12 + 1 : i10; i14 <= i13; i14++) {
                        q(i14, zA);
                    }
                    this.f7491k = i10;
                    return;
                }
                if (i11 == 0) {
                    this.f7491k = i10;
                    if (this.f7494n == -1) {
                        this.f7494n = i10;
                    }
                    if (this.f7495o == -1) {
                        this.f7495o = i10;
                    }
                    if (i10 > this.f7495o) {
                        this.f7495o = i10;
                    }
                    if (i10 < this.f7494n) {
                        this.f7494n = i10;
                    }
                    r(this.f7487g.a(this.f7492l), this.f7492l, this.f7491k, this.f7494n, this.f7495o);
                    int i15 = this.f7492l;
                    int i16 = this.f7491k;
                    if (i15 == i16) {
                        this.f7494n = i16;
                        this.f7495o = i16;
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10;
        if (recyclerView.getAdapter() == null || recyclerView.getAdapter().g() == 0) {
            return false;
        }
        if (this.f7488h != 0 && !this.f7493m) {
            if (motionEvent.getAction() == 0) {
                this.f7502v = j(recyclerView, motionEvent.getX()) ? motionEvent.getY() : -1.0f;
            } else if (this.f7502v >= 0.0f && motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.f7502v) > ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop() && ((i10 = i(recyclerView, motionEvent.getX(), motionEvent.getY())) == -1 || !n(true, i10))) {
                this.f7502v = -1.0f;
            }
        }
        if (!this.f7493m) {
            return false;
        }
        this.f7490j = recyclerView;
        int i11 = this.f7483c;
        if (i11 > -1) {
            this.f7496p = this.f7484d + i11;
            this.f7497q = (recyclerView.getMeasuredHeight() - this.f7483c) - this.f7485e;
        }
        if (motionEvent.getAction() == 1) {
            m();
        }
        return true;
    }

    public final int i(RecyclerView recyclerView, float f10, float f11) {
        View viewV = recyclerView.V(f10, f11);
        if (viewV != null) {
            return recyclerView.i0(viewV);
        }
        return -1;
    }

    public final boolean j(View view, float f10) {
        int i10 = this.f7488h;
        if (i10 == 0) {
            return false;
        }
        if (i10 <= 0 || f10 >= i10) {
            return i10 < 0 && f10 > ((float) (view.getMeasuredWidth() + this.f7488h));
        }
        return true;
    }

    public final void k(boolean z10) {
        if (this.f7493m == z10) {
            return;
        }
        this.f7503w.clear();
        this.f7493m = z10;
        InterfaceC0093b interfaceC0093b = this.f7486f;
        if (interfaceC0093b != null) {
            interfaceC0093b.a(z10);
        }
    }

    public final void l(boolean z10) {
        if (this.f7501u == z10) {
            return;
        }
        this.f7501u = z10;
        InterfaceC0093b interfaceC0093b = this.f7486f;
        if (interfaceC0093b != null) {
            interfaceC0093b.b(z10);
        }
    }

    public final void m() {
        k(false);
        this.f7498r = false;
        this.f7499s = false;
        this.f7481a.removeCallbacks(this.f7482b);
        l(false);
    }

    public boolean n(boolean z10, int i10) {
        if (z10 && this.f7493m) {
            return false;
        }
        this.f7491k = -1;
        this.f7494n = -1;
        this.f7495o = -1;
        this.f7481a.removeCallbacks(this.f7482b);
        l(false);
        this.f7498r = false;
        this.f7499s = false;
        if (!z10) {
            this.f7492l = -1;
            return false;
        }
        if (!this.f7487g.c(i10)) {
            k(false);
            this.f7492l = -1;
            return false;
        }
        this.f7487g.b(i10, !this.f7487g.a(i10));
        k(true);
        this.f7492l = i10;
        this.f7491k = i10;
        return true;
    }

    public void o(InterfaceC0093b interfaceC0093b) {
        this.f7486f = interfaceC0093b;
    }

    public void p(int i10) {
        this.f7488h = i10;
    }

    public final void q(int i10, boolean z10) {
        l8.a aVar = this.f7487g;
        aVar.b(i10, z10 && aVar.c(i10));
    }

    public final void r(boolean z10, int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            while (i12 <= i13) {
                if (i12 != i10) {
                    q(i12, this.f7503w.get(Integer.valueOf(i12)) == Boolean.TRUE);
                }
                i12++;
            }
            return;
        }
        int iMin = Math.min(i10, i11);
        int iMax = Math.max(i10, i11);
        for (int i14 = iMin; i14 <= iMax; i14++) {
            if (!this.f7503w.containsKey(Integer.valueOf(i14))) {
                this.f7503w.put(Integer.valueOf(i14), Boolean.valueOf(this.f7487g.a(i14)));
            }
            q(i14, z10);
        }
        if (i12 > -1) {
            while (i12 < iMin) {
                q(i12, this.f7503w.get(Integer.valueOf(i12)) == Boolean.TRUE);
                i12++;
            }
        }
        if (i13 > -1) {
            for (int i15 = iMax + 1; i15 <= i13; i15++) {
                q(i15, this.f7503w.get(Integer.valueOf(i15)) == Boolean.TRUE);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z10) {
    }
}
