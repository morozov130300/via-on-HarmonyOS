package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends RecyclerView.t {

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2.i f1710a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f1711b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f1712c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f1713d;

    /* renamed from: e, reason: collision with root package name */
    public int f1714e;

    /* renamed from: f, reason: collision with root package name */
    public int f1715f;

    /* renamed from: g, reason: collision with root package name */
    public a f1716g;

    /* renamed from: h, reason: collision with root package name */
    public int f1717h;

    /* renamed from: i, reason: collision with root package name */
    public int f1718i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1719j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1720k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1721l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1722m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1723a;

        /* renamed from: b, reason: collision with root package name */
        public float f1724b;

        /* renamed from: c, reason: collision with root package name */
        public int f1725c;

        public void a() {
            this.f1723a = -1;
            this.f1724b = 0.0f;
            this.f1725c = 0;
        }
    }

    public e(ViewPager2 viewPager2) {
        this.f1711b = viewPager2;
        RecyclerView recyclerView = viewPager2.f1674r;
        this.f1712c = recyclerView;
        this.f1713d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f1716g = new a();
        n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i10) {
        if (!(this.f1714e == 1 && this.f1715f == 1) && i10 == 1) {
            p(false);
            return;
        }
        if (k() && i10 == 2) {
            if (this.f1720k) {
                e(2);
                this.f1719j = true;
                return;
            }
            return;
        }
        if (k() && i10 == 0) {
            q();
            if (this.f1720k) {
                a aVar = this.f1716g;
                if (aVar.f1725c == 0) {
                    int i11 = this.f1717h;
                    int i12 = aVar.f1723a;
                    if (i11 != i12) {
                        d(i12);
                    }
                }
            } else {
                int i13 = this.f1716g.f1723a;
                if (i13 != -1) {
                    c(i13, 0.0f, 0);
                }
            }
            e(0);
            n();
        }
        if (this.f1714e == 2 && i10 == 0 && this.f1721l) {
            q();
            a aVar2 = this.f1716g;
            if (aVar2.f1725c == 0) {
                int i14 = this.f1718i;
                int i15 = aVar2.f1723a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    d(i15);
                }
                e(0);
                n();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(RecyclerView recyclerView, int i10, int i11) {
        int i12;
        this.f1720k = true;
        q();
        if (this.f1719j) {
            this.f1719j = false;
            if (i11 > 0) {
                a aVar = this.f1716g;
                i12 = aVar.f1725c != 0 ? aVar.f1723a + 1 : this.f1716g.f1723a;
                this.f1718i = i12;
                if (this.f1717h != i12) {
                    d(i12);
                }
            } else {
                if (i11 == 0) {
                    if ((i10 < 0) == this.f1711b.d()) {
                    }
                }
                this.f1718i = i12;
                if (this.f1717h != i12) {
                }
            }
        } else if (this.f1714e == 0) {
            int i13 = this.f1716g.f1723a;
            if (i13 == -1) {
                i13 = 0;
            }
            d(i13);
        }
        a aVar2 = this.f1716g;
        int i14 = aVar2.f1723a;
        if (i14 == -1) {
            i14 = 0;
        }
        c(i14, aVar2.f1724b, aVar2.f1725c);
        a aVar3 = this.f1716g;
        int i15 = aVar3.f1723a;
        int i16 = this.f1718i;
        if ((i15 == i16 || i16 == -1) && aVar3.f1725c == 0 && this.f1715f != 1) {
            e(0);
            n();
        }
    }

    public final void c(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f1710a;
        if (iVar != null) {
            iVar.b(i10, f10, i11);
        }
    }

    public final void d(int i10) {
        ViewPager2.i iVar = this.f1710a;
        if (iVar != null) {
            iVar.c(i10);
        }
    }

    public final void e(int i10) {
        if ((this.f1714e == 3 && this.f1715f == 0) || this.f1715f == i10) {
            return;
        }
        this.f1715f = i10;
        ViewPager2.i iVar = this.f1710a;
        if (iVar != null) {
            iVar.a(i10);
        }
    }

    public final int f() {
        return this.f1713d.a2();
    }

    public double g() {
        q();
        a aVar = this.f1716g;
        double d10 = aVar.f1723a;
        double d11 = aVar.f1724b;
        Double.isNaN(d10);
        Double.isNaN(d11);
        return d10 + d11;
    }

    public int h() {
        return this.f1715f;
    }

    public boolean i() {
        return this.f1722m;
    }

    public boolean j() {
        return this.f1715f == 0;
    }

    public final boolean k() {
        int i10 = this.f1714e;
        return i10 == 1 || i10 == 4;
    }

    public void l() {
        this.f1721l = true;
    }

    public void m(int i10, boolean z10) {
        this.f1714e = z10 ? 2 : 3;
        this.f1722m = false;
        boolean z11 = this.f1718i != i10;
        this.f1718i = i10;
        e(2);
        if (z11) {
            d(i10);
        }
    }

    public final void n() {
        this.f1714e = 0;
        this.f1715f = 0;
        this.f1716g.a();
        this.f1717h = -1;
        this.f1718i = -1;
        this.f1719j = false;
        this.f1720k = false;
        this.f1722m = false;
        this.f1721l = false;
    }

    public void o(ViewPager2.i iVar) {
        this.f1710a = iVar;
    }

    public final void p(boolean z10) {
        this.f1722m = z10;
        this.f1714e = z10 ? 4 : 1;
        int i10 = this.f1718i;
        if (i10 != -1) {
            this.f1717h = i10;
            this.f1718i = -1;
        } else if (this.f1717h == -1) {
            this.f1717h = f();
        }
        e(1);
    }

    public final void q() {
        int top;
        a aVar = this.f1716g;
        int iA2 = this.f1713d.a2();
        aVar.f1723a = iA2;
        if (iA2 == -1) {
            aVar.a();
            return;
        }
        View viewD = this.f1713d.D(iA2);
        if (viewD == null) {
            aVar.a();
            return;
        }
        int iB0 = this.f1713d.b0(viewD);
        int iK0 = this.f1713d.k0(viewD);
        int iN0 = this.f1713d.n0(viewD);
        int I = this.f1713d.I(viewD);
        ViewGroup.LayoutParams layoutParams = viewD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iB0 += marginLayoutParams.leftMargin;
            iK0 += marginLayoutParams.rightMargin;
            iN0 += marginLayoutParams.topMargin;
            I += marginLayoutParams.bottomMargin;
        }
        int height = viewD.getHeight() + iN0 + I;
        int width = viewD.getWidth() + iB0 + iK0;
        if (this.f1713d.o2() == 0) {
            top = (viewD.getLeft() - iB0) - this.f1712c.getPaddingLeft();
            if (this.f1711b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewD.getTop() - iN0) - this.f1712c.getPaddingTop();
        }
        int i10 = -top;
        aVar.f1725c = i10;
        if (i10 >= 0) {
            aVar.f1724b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f1713d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f1725c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }
}
