package n8;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import g6.y;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements RecyclerView.s {

    /* renamed from: c, reason: collision with root package name */
    public int f10229c;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0100b f10232f;

    /* renamed from: g, reason: collision with root package name */
    public final n8.a f10233g;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f10236j;

    /* renamed from: v, reason: collision with root package name */
    public float f10248v;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f10227a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f10228b = new a();

    /* renamed from: h, reason: collision with root package name */
    public int f10234h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f10235i = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f10237k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f10238l = 0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10239m = false;

    /* renamed from: n, reason: collision with root package name */
    public int f10240n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f10241o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f10242p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f10243q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10244r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10245s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f10246t = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10247u = false;

    /* renamed from: w, reason: collision with root package name */
    public final Map f10249w = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f10230d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10231e = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f10244r) {
                b.this.f10236j.scrollBy(0, -b.this.f10246t);
                b.this.f10227a.postDelayed(this, 25L);
            } else if (b.this.f10245s) {
                b.this.f10236j.scrollBy(0, b.this.f10246t);
                b.this.f10227a.postDelayed(this, 25L);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: n8.b$b, reason: collision with other inner class name */
    public interface InterfaceC0100b {
        void a(boolean z10);

        void b(boolean z10);
    }

    public b(Context context, n8.a aVar) {
        this.f10229c = y.h(context, 56.0f);
        this.f10233g = aVar;
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
            if (this.f10229c > -1) {
                if (y10 <= this.f10242p) {
                    this.f10245s = false;
                    if (!this.f10244r) {
                        this.f10244r = true;
                        this.f10227a.removeCallbacks(this.f10228b);
                        this.f10227a.postDelayed(this.f10228b, 25L);
                        l(true);
                    }
                    this.f10246t = ((int) Math.min(this.f10229c, this.f10242p - y10)) / 2;
                } else if (y10 >= this.f10243q) {
                    this.f10244r = false;
                    if (!this.f10245s) {
                        this.f10245s = true;
                        this.f10227a.removeCallbacks(this.f10228b);
                        this.f10227a.postDelayed(this.f10228b, 25L);
                        l(true);
                    }
                    this.f10246t = ((int) Math.min(this.f10229c, y10 - this.f10243q)) / 2;
                } else if (this.f10244r || this.f10245s) {
                    this.f10227a.removeCallbacks(this.f10228b);
                    l(false);
                    this.f10244r = false;
                    this.f10245s = false;
                }
            }
            if (i10 != -1 && this.f10237k != i10 && (this.f10248v <= 0.0f || j(recyclerView, motionEvent.getX()))) {
                int i11 = this.f10235i;
                if (i11 == 1) {
                    int i12 = this.f10237k;
                    int i13 = i10 > i12 ? i10 : i12 - 1;
                    boolean zA = this.f10233g.a(this.f10238l);
                    for (int i14 = i10 > i12 ? i12 + 1 : i10; i14 <= i13; i14++) {
                        q(i14, zA);
                    }
                    this.f10237k = i10;
                    return;
                }
                if (i11 == 0) {
                    this.f10237k = i10;
                    if (this.f10240n == -1) {
                        this.f10240n = i10;
                    }
                    if (this.f10241o == -1) {
                        this.f10241o = i10;
                    }
                    if (i10 > this.f10241o) {
                        this.f10241o = i10;
                    }
                    if (i10 < this.f10240n) {
                        this.f10240n = i10;
                    }
                    r(this.f10233g.a(this.f10238l), this.f10238l, this.f10237k, this.f10240n, this.f10241o);
                    int i15 = this.f10238l;
                    int i16 = this.f10237k;
                    if (i15 == i16) {
                        this.f10240n = i16;
                        this.f10241o = i16;
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
        if (this.f10234h != 0 && !this.f10239m) {
            if (motionEvent.getAction() == 0) {
                this.f10248v = j(recyclerView, motionEvent.getX()) ? motionEvent.getY() : -1.0f;
            } else if (this.f10248v >= 0.0f && motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.f10248v) > ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop() && ((i10 = i(recyclerView, motionEvent.getX(), motionEvent.getY())) == -1 || !n(true, i10))) {
                this.f10248v = -1.0f;
            }
        }
        if (!this.f10239m) {
            return false;
        }
        this.f10236j = recyclerView;
        int i11 = this.f10229c;
        if (i11 > -1) {
            this.f10242p = this.f10230d + i11;
            this.f10243q = (recyclerView.getMeasuredHeight() - this.f10229c) - this.f10231e;
        }
        if (motionEvent.getAction() == 1) {
            m();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z10) {
    }

    public final int i(RecyclerView recyclerView, float f10, float f11) {
        View viewV = recyclerView.V(f10, f11);
        if (viewV != null) {
            return recyclerView.i0(viewV);
        }
        return -1;
    }

    public final boolean j(View view, float f10) {
        int i10 = this.f10234h;
        if (i10 == 0) {
            return false;
        }
        if (i10 <= 0 || f10 >= i10) {
            return i10 < 0 && f10 > ((float) (view.getMeasuredWidth() + this.f10234h));
        }
        return true;
    }

    public final void k(boolean z10) {
        if (this.f10239m == z10) {
            return;
        }
        this.f10249w.clear();
        this.f10239m = z10;
        InterfaceC0100b interfaceC0100b = this.f10232f;
        if (interfaceC0100b != null) {
            interfaceC0100b.a(z10);
        }
    }

    public final void l(boolean z10) {
        if (this.f10247u == z10) {
            return;
        }
        this.f10247u = z10;
        InterfaceC0100b interfaceC0100b = this.f10232f;
        if (interfaceC0100b != null) {
            interfaceC0100b.b(z10);
        }
    }

    public final void m() {
        k(false);
        this.f10244r = false;
        this.f10245s = false;
        this.f10227a.removeCallbacks(this.f10228b);
        l(false);
    }

    public boolean n(boolean z10, int i10) {
        if (z10 && this.f10239m) {
            return false;
        }
        this.f10237k = -1;
        this.f10240n = -1;
        this.f10241o = -1;
        this.f10227a.removeCallbacks(this.f10228b);
        l(false);
        this.f10244r = false;
        this.f10245s = false;
        if (!z10) {
            this.f10238l = -1;
            return false;
        }
        if (!this.f10233g.c(i10)) {
            k(false);
            this.f10238l = -1;
            return false;
        }
        this.f10233g.b(i10, !this.f10233g.a(i10));
        k(true);
        this.f10238l = i10;
        this.f10237k = i10;
        return true;
    }

    public void o(InterfaceC0100b interfaceC0100b) {
        this.f10232f = interfaceC0100b;
    }

    public void p(int i10) {
        this.f10234h = i10;
    }

    public final void q(int i10, boolean z10) {
        n8.a aVar = this.f10233g;
        aVar.b(i10, z10 && aVar.c(i10));
    }

    public final void r(boolean z10, int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            while (i12 <= i13) {
                if (i12 != i10) {
                    q(i12, this.f10249w.get(Integer.valueOf(i12)) == Boolean.TRUE);
                }
                i12++;
            }
            return;
        }
        int iMin = Math.min(i10, i11);
        int iMax = Math.max(i10, i11);
        for (int i14 = iMin; i14 <= iMax; i14++) {
            if (!this.f10249w.containsKey(Integer.valueOf(i14))) {
                this.f10249w.put(Integer.valueOf(i14), Boolean.valueOf(this.f10233g.a(i14)));
            }
            q(i14, z10);
        }
        if (i12 > -1) {
            while (i12 < iMin) {
                q(i12, this.f10249w.get(Integer.valueOf(i12)) == Boolean.TRUE);
                i12++;
            }
        }
        if (i13 > -1) {
            for (int i15 = iMax + 1; i15 <= i13; i15++) {
                q(i15, this.f10249w.get(Integer.valueOf(i15)) == Boolean.TRUE);
            }
        }
    }
}
