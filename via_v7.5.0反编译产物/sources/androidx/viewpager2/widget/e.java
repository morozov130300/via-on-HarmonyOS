package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2.i f1609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f1610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f1611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f1612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f1615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1621m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1624c;

        public void a() {
            this.f1622a = -1;
            this.f1623b = 0.0f;
            this.f1624c = 0;
        }
    }

    public e(ViewPager2 viewPager2) {
        this.f1610b = viewPager2;
        RecyclerView recyclerView = viewPager2.f1575t;
        this.f1611c = recyclerView;
        this.f1612d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f1615g = new a();
        n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i10) {
        if (!(this.f1613e == 1 && this.f1614f == 1) && i10 == 1) {
            p(false);
            return;
        }
        if (k() && i10 == 2) {
            if (this.f1619k) {
                e(2);
                this.f1618j = true;
                return;
            }
            return;
        }
        if (k() && i10 == 0) {
            q();
            if (this.f1619k) {
                a aVar = this.f1615g;
                if (aVar.f1624c == 0) {
                    int i11 = this.f1616h;
                    int i12 = aVar.f1622a;
                    if (i11 != i12) {
                        d(i12);
                    }
                }
            } else {
                int i13 = this.f1615g.f1622a;
                if (i13 != -1) {
                    c(i13, 0.0f, 0);
                }
            }
            e(0);
            n();
        }
        if (this.f1613e == 2 && i10 == 0 && this.f1620l) {
            q();
            a aVar2 = this.f1615g;
            if (aVar2.f1624c == 0) {
                int i14 = this.f1617i;
                int i15 = aVar2.f1622a;
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

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i10, int i11) {
        a aVar;
        int i12;
        this.f1619k = true;
        q();
        if (this.f1618j) {
            this.f1618j = false;
            if (i11 > 0) {
                aVar = this.f1615g;
                if (aVar.f1624c != 0) {
                    i12 = aVar.f1622a + 1;
                } else {
                    i12 = this.f1615g.f1622a;
                }
            } else {
                if (i11 == 0) {
                    if ((i10 < 0) == this.f1610b.d()) {
                        aVar = this.f1615g;
                        if (aVar.f1624c != 0) {
                            i12 = aVar.f1622a + 1;
                        }
                    }
                }
                i12 = this.f1615g.f1622a;
            }
            this.f1617i = i12;
            if (this.f1616h != i12) {
                d(i12);
            }
        } else if (this.f1613e == 0) {
            int i13 = this.f1615g.f1622a;
            if (i13 == -1) {
                i13 = 0;
            }
            d(i13);
        }
        a aVar2 = this.f1615g;
        int i14 = aVar2.f1622a;
        if (i14 == -1) {
            i14 = 0;
        }
        c(i14, aVar2.f1623b, aVar2.f1624c);
        a aVar3 = this.f1615g;
        int i15 = aVar3.f1622a;
        int i16 = this.f1617i;
        if ((i15 == i16 || i16 == -1) && aVar3.f1624c == 0 && this.f1614f != 1) {
            e(0);
            n();
        }
    }

    public final void c(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f1609a;
        if (iVar != null) {
            iVar.b(i10, f10, i11);
        }
    }

    public final void d(int i10) {
        ViewPager2.i iVar = this.f1609a;
        if (iVar != null) {
            iVar.c(i10);
        }
    }

    public final void e(int i10) {
        if ((this.f1613e == 3 && this.f1614f == 0) || this.f1614f == i10) {
            return;
        }
        this.f1614f = i10;
        ViewPager2.i iVar = this.f1609a;
        if (iVar != null) {
            iVar.a(i10);
        }
    }

    public final int f() {
        return this.f1612d.a2();
    }

    public double g() {
        q();
        a aVar = this.f1615g;
        double d10 = aVar.f1622a;
        double d11 = aVar.f1623b;
        Double.isNaN(d10);
        Double.isNaN(d11);
        return d10 + d11;
    }

    public int h() {
        return this.f1614f;
    }

    public boolean i() {
        return this.f1621m;
    }

    public boolean j() {
        return this.f1614f == 0;
    }

    public final boolean k() {
        int i10 = this.f1613e;
        return i10 == 1 || i10 == 4;
    }

    public void l() {
        this.f1620l = true;
    }

    public void m(int i10, boolean z10) {
        this.f1613e = z10 ? 2 : 3;
        this.f1621m = false;
        boolean z11 = this.f1617i != i10;
        this.f1617i = i10;
        e(2);
        if (z11) {
            d(i10);
        }
    }

    public final void n() {
        this.f1613e = 0;
        this.f1614f = 0;
        this.f1615g.a();
        this.f1616h = -1;
        this.f1617i = -1;
        this.f1618j = false;
        this.f1619k = false;
        this.f1621m = false;
        this.f1620l = false;
    }

    public void o(ViewPager2.i iVar) {
        this.f1609a = iVar;
    }

    public final void p(boolean z10) {
        this.f1621m = z10;
        this.f1613e = z10 ? 4 : 1;
        int i10 = this.f1617i;
        if (i10 != -1) {
            this.f1616h = i10;
            this.f1617i = -1;
        } else if (this.f1616h == -1) {
            this.f1616h = f();
        }
        e(1);
    }

    public final void q() {
        int top;
        a aVar = this.f1615g;
        int iA2 = this.f1612d.a2();
        aVar.f1622a = iA2;
        if (iA2 == -1) {
            aVar.a();
            return;
        }
        View viewD = this.f1612d.D(iA2);
        if (viewD == null) {
            aVar.a();
            return;
        }
        int iB0 = this.f1612d.b0(viewD);
        int iK0 = this.f1612d.k0(viewD);
        int iN0 = this.f1612d.n0(viewD);
        int I = this.f1612d.I(viewD);
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
        if (this.f1612d.o2() == 0) {
            top = (viewD.getLeft() - iB0) - this.f1611c.getPaddingLeft();
            if (this.f1610b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewD.getTop() - iN0) - this.f1611c.getPaddingTop();
        }
        int i10 = -top;
        aVar.f1624c = i10;
        if (i10 >= 0) {
            aVar.f1623b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f1612d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f1624c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }
}
