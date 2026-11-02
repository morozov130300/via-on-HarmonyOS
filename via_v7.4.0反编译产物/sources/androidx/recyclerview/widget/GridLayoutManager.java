package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import y.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean I;
    public int J;
    public int[] K;
    public View[] L;
    public final SparseIntArray M;
    public final SparseIntArray N;
    public c O;
    public final Rect P;
    public boolean Q;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i10) {
            return 1;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        public int f1121e;

        /* renamed from: f, reason: collision with root package name */
        public int f1122f;

        public b(int i10, int i11) {
            super(i10, i11);
            this.f1121e = -1;
            this.f1122f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1121e = -1;
            this.f1122f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1121e = -1;
            this.f1122f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1121e = -1;
            this.f1122f = 0;
        }

        public int e() {
            return this.f1121e;
        }

        public int f() {
            return this.f1122f;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f1123a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        public final SparseIntArray f1124b = new SparseIntArray();

        /* renamed from: c, reason: collision with root package name */
        public boolean f1125c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1126d = false;

        public static int a(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        public int b(int i10, int i11) {
            if (!this.f1126d) {
                return d(i10, i11);
            }
            int i12 = this.f1124b.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int iD = d(i10, i11);
            this.f1124b.put(i10, iD);
            return iD;
        }

        public int c(int i10, int i11) {
            if (!this.f1125c) {
                return e(i10, i11);
            }
            int i12 = this.f1123a.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int iE = e(i10, i11);
            this.f1123a.put(i10, iE);
            return iE;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int d(int i10, int i11) {
            int i12;
            int iC;
            int iA;
            if (this.f1126d && (iA = a(this.f1124b, i10)) != -1) {
                int i13 = this.f1124b.get(iA);
                i12 = iA + 1;
                iC = c(iA, i11) + f(iA);
                i13 = iC == i11 ? i13 + 1 : 0;
                int iF = f(i10);
                while (i12 < i10) {
                    int iF2 = f(i12);
                    iC += iF2;
                    if (iC == i11) {
                        i13++;
                        iC = 0;
                    } else if (iC > i11) {
                        i13++;
                        iC = iF2;
                    }
                    i12++;
                }
                return iC + iF <= i11 ? i13 + 1 : i13;
            }
            i12 = 0;
            iC = 0;
            int iF3 = f(i10);
            while (i12 < i10) {
            }
            if (iC + iF3 <= i11) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int e(int i10, int i11) {
            int iA;
            int iF;
            int iF2 = f(i10);
            if (iF2 == i11) {
                return 0;
            }
            if (!this.f1125c || (iA = a(this.f1123a, i10)) < 0) {
                iA = 0;
                iF = 0;
                if (iA >= i10) {
                    int iF3 = f(iA);
                    iF += iF3;
                    if (iF == i11) {
                        iF = 0;
                    } else if (iF > i11) {
                        iF = iF3;
                    }
                    iA++;
                    if (iA >= i10) {
                        if (iF2 + iF <= i11) {
                            return iF;
                        }
                        return 0;
                    }
                }
            } else {
                iF = this.f1123a.get(iA) + f(iA);
                iA++;
                if (iA >= i10) {
                }
            }
        }

        public abstract int f(int i10);

        public void g() {
            this.f1124b.clear();
        }

        public void h() {
            this.f1123a.clear();
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(i10);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(RecyclerView.o.j0(context, attributeSet, i10, i11).f1274b);
    }

    public static int[] Q2(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(Rect rect, int i10, int i11) {
        int iO;
        int iO2;
        if (this.K == null) {
            super.D1(rect, i10, i11);
        }
        int iF0 = f0() + g0();
        int iH0 = h0() + e0();
        if (this.f1127s == 1) {
            iO2 = RecyclerView.o.o(i11, rect.height() + iH0, c0());
            int[] iArr = this.K;
            iO = RecyclerView.o.o(i10, iArr[iArr.length - 1] + iF0, d0());
        } else {
            iO = RecyclerView.o.o(i10, rect.width() + iF0, d0());
            int[] iArr2 = this.K;
            iO2 = RecyclerView.o.o(i11, iArr2[iArr2.length - 1] + iH0, c0());
        }
        C1(iO, iO2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return this.f1127s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E2(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.E2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iK;
        int iK2;
        int i11;
        View view2;
        View view3;
        View view4;
        int i12;
        int i13;
        int i14;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        View viewC = C(view);
        View view5 = null;
        if (viewC == null) {
            return null;
        }
        b bVar = (b) viewC.getLayoutParams();
        int i15 = bVar.f1121e;
        int i16 = bVar.f1122f + i15;
        if (super.K0(view, i10, vVar, zVar) == null) {
            return null;
        }
        if ((S1(i10) == 1) != this.f1132x) {
            iK2 = K() - 1;
            iK = -1;
            i11 = -1;
        } else {
            iK = K();
            iK2 = 0;
            i11 = 1;
        }
        boolean z10 = this.f1127s == 1 && p2();
        int iY2 = Y2(vVar2, zVar2, iK2);
        int i17 = iK2;
        int iMin = 0;
        int i18 = -1;
        int i19 = -1;
        int iMin2 = 0;
        View view6 = null;
        while (i17 != iK) {
            int iY22 = Y2(vVar2, zVar2, i17);
            View viewJ = J(i17);
            if (viewJ == viewC) {
                break;
            }
            if (!viewJ.hasFocusable() || iY22 == iY2) {
                b bVar2 = (b) viewJ.getLayoutParams();
                int i20 = bVar2.f1121e;
                view2 = viewC;
                int i21 = bVar2.f1122f + i20;
                if (viewJ.hasFocusable() && i20 == i15 && i21 == i16) {
                    return viewJ;
                }
                if (!(viewJ.hasFocusable() && view5 == null) && (viewJ.hasFocusable() || view6 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i21, i16) - Math.max(i20, i15);
                    if (!viewJ.hasFocusable()) {
                        if (view3 == null) {
                            view4 = view6;
                            i12 = iMin;
                            if (z0(viewJ, false, true)) {
                                i13 = iMin2;
                                if (iMin3 > i13) {
                                    i14 = i19;
                                } else if (iMin3 == i13) {
                                    i14 = i19;
                                    if (z10 == (i20 > i14)) {
                                    }
                                    iMin = i12;
                                    view5 = view3;
                                    i17 += i11;
                                    vVar2 = vVar;
                                    zVar2 = zVar;
                                    viewC = view2;
                                } else {
                                    i14 = i19;
                                }
                                if (viewJ.hasFocusable()) {
                                    int i22 = bVar2.f1121e;
                                    iMin2 = Math.min(i21, i16) - Math.max(i20, i15);
                                    view6 = viewJ;
                                    i19 = i22;
                                    iMin = i12;
                                    view5 = view3;
                                    i17 += i11;
                                    vVar2 = vVar;
                                    zVar2 = zVar;
                                    viewC = view2;
                                } else {
                                    i19 = i14;
                                    iMin2 = i13;
                                    i18 = bVar2.f1121e;
                                    view6 = view4;
                                    view5 = viewJ;
                                    iMin = Math.min(i21, i16) - Math.max(i20, i15);
                                    i17 += i11;
                                    vVar2 = vVar;
                                    zVar2 = zVar;
                                    viewC = view2;
                                }
                            }
                            i19 = i14;
                            iMin2 = i13;
                            view6 = view4;
                            iMin = i12;
                            view5 = view3;
                            i17 += i11;
                            vVar2 = vVar;
                            zVar2 = zVar;
                            viewC = view2;
                        }
                        i14 = i19;
                        i13 = iMin2;
                        i19 = i14;
                        iMin2 = i13;
                        view6 = view4;
                        iMin = i12;
                        view5 = view3;
                        i17 += i11;
                        vVar2 = vVar;
                        zVar2 = zVar;
                        viewC = view2;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                } else {
                    view3 = view5;
                }
                view4 = view6;
                i12 = iMin;
                i14 = i19;
                i13 = iMin2;
                if (viewJ.hasFocusable()) {
                }
            } else {
                if (view5 != null) {
                    break;
                }
                view2 = viewC;
                view3 = view5;
            }
            view4 = view6;
            i12 = iMin;
            i14 = i19;
            i13 = iMin2;
            i19 = i14;
            iMin2 = i13;
            view6 = view4;
            iMin = i12;
            view5 = view3;
            i17 += i11;
            vVar2 = vVar;
            zVar2 = zVar;
            viewC = view2;
        }
        View view7 = view5;
        return view7 != null ? view7 : view6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.D == null && !this.I;
    }

    public final void N2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i12 = i10;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = i10 - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View view = this.L[i11];
            b bVar = (b) view.getLayoutParams();
            int iA3 = a3(vVar, zVar, i0(view));
            bVar.f1122f = iA3;
            bVar.f1121e = i14;
            i14 += iA3;
            i11 += i13;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int O(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f1127s == 1) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return Y2(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void O1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int iF = this.J;
        for (int i10 = 0; i10 < this.J && cVar.c(zVar) && iF > 0; i10++) {
            int i11 = cVar.f1150d;
            cVar2.a(i11, Math.max(0, cVar.f1153g));
            iF -= this.O.f(i11);
            cVar.f1150d += cVar.f1151e;
        }
    }

    public final void O2() {
        int iK = K();
        for (int i10 = 0; i10 < iK; i10++) {
            b bVar = (b) J(i10).getLayoutParams();
            int iA = bVar.a();
            this.M.put(iA, bVar.f());
            this.N.put(iA, bVar.e());
        }
    }

    public final void P2(int i10) {
        this.K = Q2(this.K, this.J, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView.v vVar, RecyclerView.z zVar, View view, d0 d0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.P0(view, d0Var);
            return;
        }
        b bVar = (b) layoutParams;
        int iY2 = Y2(vVar, zVar, bVar.a());
        if (this.f1127s == 0) {
            d0Var.W(d0.c.a(bVar.e(), bVar.f(), iY2, 1, false, false));
        } else {
            d0Var.W(d0.c.a(iY2, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    public final void R2() {
        this.M.clear();
        this.N.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    public final int S2(RecyclerView.z zVar) {
        if (K() != 0 && zVar.b() != 0) {
            U1();
            boolean zQ2 = q2();
            View viewZ1 = Z1(!zQ2, true);
            View viewY1 = Y1(!zQ2, true);
            if (viewZ1 != null && viewY1 != null) {
                int iB = this.O.b(i0(viewZ1), this.J);
                int iB2 = this.O.b(i0(viewY1), this.J);
                int iMax = this.f1132x ? Math.max(0, ((this.O.b(zVar.b() - 1, this.J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zQ2) {
                    return Math.round((iMax * (Math.abs(this.f1129u.d(viewY1) - this.f1129u.g(viewZ1)) / ((this.O.b(i0(viewY1), this.J) - this.O.b(i0(viewZ1), this.J)) + 1))) + (this.f1129u.m() - this.f1129u.g(viewZ1)));
                }
                return iMax;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    public final int T2(RecyclerView.z zVar) {
        if (K() != 0 && zVar.b() != 0) {
            U1();
            View viewZ1 = Z1(!q2(), true);
            View viewY1 = Y1(!q2(), true);
            if (viewZ1 != null && viewY1 != null) {
                if (!q2()) {
                    return this.O.b(zVar.b() - 1, this.J) + 1;
                }
                int iD = this.f1129u.d(viewY1) - this.f1129u.g(viewZ1);
                int iB = this.O.b(i0(viewZ1), this.J);
                return (int) ((iD / ((this.O.b(i0(viewY1), this.J) - iB) + 1)) * (this.O.b(zVar.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.O.h();
        this.O.g();
    }

    public final void U2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int iZ2 = Z2(vVar, zVar, aVar.f1139b);
        if (z10) {
            while (iZ2 > 0) {
                int i11 = aVar.f1139b;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                aVar.f1139b = i12;
                iZ2 = Z2(vVar, zVar, i12);
            }
            return;
        }
        int iB = zVar.b() - 1;
        int i13 = aVar.f1139b;
        while (i13 < iB) {
            int i14 = i13 + 1;
            int iZ22 = Z2(vVar, zVar, i14);
            if (iZ22 <= iZ2) {
                break;
            }
            i13 = i14;
            iZ2 = iZ22;
        }
        aVar.f1139b = i13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    public final void V2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    public int W2(int i10, int i11) {
        if (this.f1127s != 1 || !p2()) {
            int[] iArr = this.K;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.K;
        int i12 = this.J;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.O.h();
        this.O.g();
    }

    public int X2() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            O2();
        }
        super.Y0(vVar, zVar);
        R2();
    }

    public final int Y2(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.b(i10, this.J);
        }
        int iF = vVar.f(i10);
        if (iF != -1) {
            return this.O.b(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.I = false;
    }

    public final int Z2(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.c(i10, this.J);
        }
        int i11 = this.N.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iF = vVar.f(i10);
        if (iF != -1) {
            return this.O.c(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    public final int a3(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.f(i10);
        }
        int i11 = this.M.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iF = vVar.f(i10);
        if (iF != -1) {
            return this.O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    public final void b3(float f10, int i10) {
        P2(Math.max(Math.round(f10 * this.J), i10));
    }

    public final void c3(View view, int i10, boolean z10) {
        int iL;
        int iL2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1278b;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iW2 = W2(bVar.f1121e, bVar.f1122f);
        if (this.f1127s == 1) {
            iL2 = RecyclerView.o.L(iW2, i10, i12, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iL = RecyclerView.o.L(this.f1129u.n(), Y(), i11, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iL3 = RecyclerView.o.L(iW2, i10, i11, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iL4 = RecyclerView.o.L(this.f1129u.n(), q0(), i12, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iL = iL3;
            iL2 = iL4;
        }
        d3(view, iL2, iL, z10);
    }

    public final void d3(View view, int i10, int i11, boolean z10) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10 ? I1(view, i10, i11, pVar) : G1(view, i10, i11, pVar)) {
            view.measure(i10, i11);
        }
    }

    public void e3(int i10) {
        if (i10 == this.J) {
            return;
        }
        this.I = true;
        if (i10 >= 1) {
            this.J = i10;
            this.O.h();
            u1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void f3(c cVar) {
        this.O = cVar;
    }

    public final void g3() {
        int iX;
        int iH0;
        if (o2() == 1) {
            iX = p0() - g0();
            iH0 = f0();
        } else {
            iX = X() - e0();
            iH0 = h0();
        }
        P2(iX - iH0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View i2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
        int i10;
        int iK;
        int iK2 = K();
        int i11 = 1;
        if (z11) {
            iK = K() - 1;
            i10 = -1;
            i11 = -1;
        } else {
            i10 = iK2;
            iK = 0;
        }
        int iB = zVar.b();
        U1();
        int iM = this.f1129u.m();
        int i12 = this.f1129u.i();
        View view = null;
        View view2 = null;
        while (iK != i10) {
            View viewJ = J(iK);
            int iI0 = i0(viewJ);
            if (iI0 >= 0 && iI0 < iB && Z2(vVar, zVar, iI0) == 0) {
                if (((RecyclerView.p) viewJ.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewJ;
                    }
                } else {
                    if (this.f1129u.g(viewJ) < i12 && this.f1129u.d(viewJ) >= iM) {
                        return viewJ;
                    }
                    if (view == null) {
                        view = viewJ;
                    }
                }
            }
            iK += i11;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f1127s == 0) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return Y2(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void r2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i10;
        int i11;
        int iF0;
        int iH0;
        int iF;
        int iF2;
        int i12;
        int iL;
        int iL2;
        View viewD;
        int iL3 = this.f1129u.l();
        boolean z10 = iL3 != 1073741824;
        int i13 = K() > 0 ? this.K[this.J] : 0;
        if (z10) {
            g3();
        }
        boolean z11 = cVar.f1151e == 1;
        int iZ2 = this.J;
        if (!z11) {
            iZ2 = Z2(vVar, zVar, cVar.f1150d) + a3(vVar, zVar, cVar.f1150d);
        }
        int i14 = 0;
        while (i14 < this.J && cVar.c(zVar) && iZ2 > 0) {
            int i15 = cVar.f1150d;
            int iA3 = a3(vVar, zVar, i15);
            if (iA3 > this.J) {
                throw new IllegalArgumentException("Item at position " + i15 + " requires " + iA3 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
            iZ2 -= iA3;
            if (iZ2 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.L[i14] = viewD;
            i14++;
        }
        if (i14 == 0) {
            bVar.f1144b = true;
            return;
        }
        N2(vVar, zVar, i14, z11);
        float f10 = 0.0f;
        int i16 = 0;
        for (int i17 = 0; i17 < i14; i17++) {
            View view = this.L[i17];
            if (cVar.f1158l == null) {
                if (z11) {
                    e(view);
                } else {
                    f(view, 0);
                }
            } else if (z11) {
                c(view);
            } else {
                d(view, 0);
            }
            k(view, this.P);
            c3(view, iL3, false);
            int iE = this.f1129u.e(view);
            if (iE > i16) {
                i16 = iE;
            }
            float f11 = (this.f1129u.f(view) * 1.0f) / ((b) view.getLayoutParams()).f1122f;
            if (f11 > f10) {
                f10 = f11;
            }
        }
        if (z10) {
            b3(f10, i13);
            i16 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                View view2 = this.L[i18];
                c3(view2, 1073741824, true);
                int iE2 = this.f1129u.e(view2);
                if (iE2 > i16) {
                    i16 = iE2;
                }
            }
        }
        for (int i19 = 0; i19 < i14; i19++) {
            View view3 = this.L[i19];
            if (this.f1129u.e(view3) != i16) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f1278b;
                int i20 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i21 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int iW2 = W2(bVar2.f1121e, bVar2.f1122f);
                if (this.f1127s == 1) {
                    iL2 = RecyclerView.o.L(iW2, 1073741824, i21, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    iL = View.MeasureSpec.makeMeasureSpec(i16 - i20, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - i21, 1073741824);
                    iL = RecyclerView.o.L(iW2, 1073741824, i20, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    iL2 = iMakeMeasureSpec;
                }
                d3(view3, iL2, iL, true);
            }
        }
        bVar.f1143a = i16;
        if (this.f1127s == 1) {
            if (cVar.f1152f == -1) {
                iF2 = cVar.f1148b;
                i12 = iF2 - i16;
            } else {
                i12 = cVar.f1148b;
                iF2 = i12 + i16;
            }
            iH0 = i12;
            iF = 0;
            iF0 = 0;
        } else {
            if (cVar.f1152f == -1) {
                i11 = cVar.f1148b;
                i10 = i11 - i16;
            } else {
                i10 = cVar.f1148b;
                i11 = i10 + i16;
            }
            iF0 = i10;
            iH0 = 0;
            iF = i11;
            iF2 = 0;
        }
        for (int i22 = 0; i22 < i14; i22++) {
            View view4 = this.L[i22];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.f1127s != 1) {
                iH0 = this.K[bVar3.f1121e] + h0();
                iF2 = this.f1129u.f(view4) + iH0;
            } else if (p2()) {
                iF = f0() + this.K[this.J - bVar3.f1121e];
                iF0 = iF - this.f1129u.f(view4);
            } else {
                iF0 = this.K[bVar3.f1121e] + f0();
                iF = this.f1129u.f(view4) + iF0;
            }
            int i23 = iF2;
            int i24 = iH0;
            int i25 = iF;
            int i26 = iF0;
            A0(view4, i26, i24, i25, i23);
            iF2 = i23;
            iF0 = i26;
            iF = i25;
            iH0 = i24;
            if (bVar3.c() || bVar3.b()) {
                bVar.f1145c = true;
            }
            bVar.f1146d = view4.hasFocusable() | bVar.f1146d;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return this.Q ? S2(zVar) : super.s(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return this.Q ? T2(zVar) : super.t(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void t2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        super.t2(vVar, zVar, aVar, i10);
        g3();
        if (zVar.b() > 0 && !zVar.e()) {
            U2(vVar, zVar, aVar, i10);
        }
        V2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return this.Q ? S2(zVar) : super.v(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.z zVar) {
        return this.Q ? T2(zVar) : super.w(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        g3();
        V2();
        return super.x1(i10, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        g3();
        V2();
        return super.z1(i10, vVar, zVar);
    }
}
