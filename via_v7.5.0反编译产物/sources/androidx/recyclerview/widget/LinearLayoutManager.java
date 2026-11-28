package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements j.InterfaceC0022j, RecyclerView.z.b {
    public int A;
    public int B;
    public boolean C;
    public SavedState D;
    public final a E;
    public final b F;
    public int G;
    public int[] H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1030s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f1031t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q f1032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1036y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1037z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1038c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1039e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1040m;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public boolean a() {
            return this.f1038c >= 0;
        }

        public void b() {
            this.f1038c = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1038c);
            parcel.writeInt(this.f1039e);
            parcel.writeInt(this.f1040m ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f1038c = parcel.readInt();
            this.f1039e = parcel.readInt();
            this.f1040m = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f1038c = savedState.f1038c;
            this.f1039e = savedState.f1039e;
            this.f1040m = savedState.f1040m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f1041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1045e;

        public a() {
            e();
        }

        public void a() {
            this.f1043c = this.f1044d ? this.f1041a.i() : this.f1041a.m();
        }

        public void b(View view, int i10) {
            if (this.f1044d) {
                this.f1043c = this.f1041a.d(view) + this.f1041a.o();
            } else {
                this.f1043c = this.f1041a.g(view);
            }
            this.f1042b = i10;
        }

        public void c(View view, int i10) {
            int iO = this.f1041a.o();
            if (iO >= 0) {
                b(view, i10);
                return;
            }
            this.f1042b = i10;
            if (this.f1044d) {
                int i11 = (this.f1041a.i() - iO) - this.f1041a.d(view);
                this.f1043c = this.f1041a.i() - i11;
                if (i11 > 0) {
                    int iE = this.f1043c - this.f1041a.e(view);
                    int iM = this.f1041a.m();
                    int iMin = iE - (iM + Math.min(this.f1041a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f1043c += Math.min(i11, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f1041a.g(view);
            int iM2 = iG - this.f1041a.m();
            this.f1043c = iG;
            if (iM2 > 0) {
                int i12 = (this.f1041a.i() - Math.min(0, (this.f1041a.i() - iO) - this.f1041a.d(view))) - (iG + this.f1041a.e(view));
                if (i12 < 0) {
                    this.f1043c -= Math.min(iM2, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        public void e() {
            this.f1042b = -1;
            this.f1043c = Integer.MIN_VALUE;
            this.f1044d = false;
            this.f1045e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1042b + ", mCoordinate=" + this.f1043c + ", mLayoutFromEnd=" + this.f1044d + ", mValid=" + this.f1045e + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1049d;

        public void a() {
            this.f1046a = 0;
            this.f1047b = false;
            this.f1048c = false;
            this.f1049d = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1054e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1055f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1056g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1060k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1062m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1050a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1057h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1058i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1059j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f1061l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f1053d = -1;
            } else {
                this.f1053d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.a0 a0Var) {
            int i10 = this.f1053d;
            return i10 >= 0 && i10 < a0Var.b();
        }

        public View d(RecyclerView.v vVar) {
            if (this.f1061l != null) {
                return e();
            }
            View viewO = vVar.o(this.f1053d);
            this.f1053d += this.f1054e;
            return viewO;
        }

        public final View e() {
            int size = this.f1061l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((RecyclerView.d0) this.f1061l.get(i10)).f1138a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1053d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int iA;
            int size = this.f1061l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = ((RecyclerView.d0) this.f1061l.get(i11)).f1138a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f1053d) * this.f1054e) >= 0 && iA < i10) {
                    if (iA == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i10 = iA;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public int A2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        U1();
        this.f1031t.f1050a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        I2(i11, iAbs, true, a0Var);
        c cVar = this.f1031t;
        int iV1 = cVar.f1056g + V1(vVar, cVar, a0Var, false);
        if (iV1 < 0) {
            return 0;
        }
        if (iAbs > iV1) {
            i10 = i11 * iV1;
        }
        this.f1032u.r(-i10);
        this.f1031t.f1060k = i10;
        return i10;
    }

    public void B2(int i10, int i11) {
        this.A = i10;
        this.B = i11;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        u1();
    }

    public void C2(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        h(null);
        if (i10 != this.f1030s || this.f1032u == null) {
            q qVarB = q.b(this, i10);
            this.f1032u = qVarB;
            this.E.f1041a = qVarB;
            this.f1030s = i10;
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View D(int i10) {
        int iK = K();
        if (iK == 0) {
            return null;
        }
        int iI0 = i10 - i0(J(0));
        if (iI0 >= 0 && iI0 < iK) {
            View viewJ = J(iI0);
            if (i0(viewJ) == i10) {
                return viewJ;
            }
        }
        return super.D(i10);
    }

    public void D2(boolean z10) {
        h(null);
        if (z10 == this.f1034w) {
            return;
        }
        this.f1034w = z10;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return new RecyclerView.p(-2, -2);
    }

    public void E2(boolean z10) {
        h(null);
        if (this.f1036y == z10) {
            return;
        }
        this.f1036y = z10;
        u1();
    }

    public final boolean F2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        View viewI2;
        boolean z10 = false;
        if (K() == 0) {
            return false;
        }
        View viewW = W();
        if (viewW != null && aVar.d(viewW, a0Var)) {
            aVar.c(viewW, i0(viewW));
            return true;
        }
        boolean z11 = this.f1033v;
        boolean z12 = this.f1036y;
        if (z11 != z12 || (viewI2 = i2(vVar, a0Var, aVar.f1044d, z12)) == null) {
            return false;
        }
        aVar.b(viewI2, i0(viewI2));
        if (!a0Var.e() && M1()) {
            int iG = this.f1032u.g(viewI2);
            int iD = this.f1032u.d(viewI2);
            int iM = this.f1032u.m();
            int i10 = this.f1032u.i();
            boolean z13 = iD <= iM && iG < iM;
            if (iG >= i10 && iD > i10) {
                z10 = true;
            }
            if (z13 || z10) {
                if (aVar.f1044d) {
                    iM = i10;
                }
                aVar.f1043c = iM;
            }
        }
        return true;
    }

    public final boolean G2(RecyclerView.a0 a0Var, a aVar) {
        int i10;
        if (!a0Var.e() && (i10 = this.A) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                aVar.f1042b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z10 = this.D.f1040m;
                    aVar.f1044d = z10;
                    if (z10) {
                        aVar.f1043c = this.f1032u.i() - this.D.f1039e;
                    } else {
                        aVar.f1043c = this.f1032u.m() + this.D.f1039e;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z11 = this.f1035x;
                    aVar.f1044d = z11;
                    if (z11) {
                        aVar.f1043c = this.f1032u.i() - this.B;
                    } else {
                        aVar.f1043c = this.f1032u.m() + this.B;
                    }
                    return true;
                }
                View viewD = D(this.A);
                if (viewD == null) {
                    if (K() > 0) {
                        aVar.f1044d = (this.A < i0(J(0))) == this.f1035x;
                    }
                    aVar.a();
                } else {
                    if (this.f1032u.e(viewD) > this.f1032u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f1032u.g(viewD) - this.f1032u.m() < 0) {
                        aVar.f1043c = this.f1032u.m();
                        aVar.f1044d = false;
                        return true;
                    }
                    if (this.f1032u.i() - this.f1032u.d(viewD) < 0) {
                        aVar.f1043c = this.f1032u.i();
                        aVar.f1044d = true;
                        return true;
                    }
                    aVar.f1043c = aVar.f1044d ? this.f1032u.d(viewD) + this.f1032u.o() : this.f1032u.g(viewD);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return (Y() == 1073741824 || q0() == 1073741824 || !r0()) ? false : true;
    }

    public final void H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (G2(a0Var, aVar) || F2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1042b = this.f1036y ? a0Var.b() - 1 : 0;
    }

    public final void I2(int i10, int i11, boolean z10, RecyclerView.a0 a0Var) {
        int iM;
        this.f1031t.f1062m = y2();
        this.f1031t.f1055f = i10;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z11 = i10 == 1;
        c cVar = this.f1031t;
        int i12 = z11 ? iMax2 : iMax;
        cVar.f1057h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        cVar.f1058i = iMax;
        if (z11) {
            cVar.f1057h = i12 + this.f1032u.j();
            View viewL2 = l2();
            c cVar2 = this.f1031t;
            cVar2.f1054e = this.f1035x ? -1 : 1;
            int iI0 = i0(viewL2);
            c cVar3 = this.f1031t;
            cVar2.f1053d = iI0 + cVar3.f1054e;
            cVar3.f1051b = this.f1032u.d(viewL2);
            iM = this.f1032u.d(viewL2) - this.f1032u.i();
        } else {
            View viewM2 = m2();
            this.f1031t.f1057h += this.f1032u.m();
            c cVar4 = this.f1031t;
            cVar4.f1054e = this.f1035x ? 1 : -1;
            int iI1 = i0(viewM2);
            c cVar5 = this.f1031t;
            cVar4.f1053d = iI1 + cVar5.f1054e;
            cVar5.f1051b = this.f1032u.g(viewM2);
            iM = (-this.f1032u.g(viewM2)) + this.f1032u.m();
        }
        c cVar6 = this.f1031t;
        cVar6.f1052c = i11;
        if (z10) {
            cVar6.f1052c = i11 - iM;
        }
        cVar6.f1056g = iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        if (this.C) {
            l1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        n nVar = new n(recyclerView.getContext());
        nVar.p(i10);
        K1(nVar);
    }

    public final void J2(int i10, int i11) {
        this.f1031t.f1052c = this.f1032u.i() - i11;
        c cVar = this.f1031t;
        cVar.f1054e = this.f1035x ? -1 : 1;
        cVar.f1053d = i10;
        cVar.f1055f = 1;
        cVar.f1051b = i11;
        cVar.f1056g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iS1;
        z2();
        if (K() == 0 || (iS1 = S1(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        U1();
        I2(iS1, (int) (this.f1032u.n() * 0.33333334f), false, a0Var);
        c cVar = this.f1031t;
        cVar.f1056g = Integer.MIN_VALUE;
        cVar.f1050a = false;
        V1(vVar, cVar, a0Var, true);
        View viewH2 = iS1 == -1 ? h2() : g2();
        View viewM2 = iS1 == -1 ? m2() : l2();
        if (!viewM2.hasFocusable()) {
            return viewH2;
        }
        if (viewH2 == null) {
            return null;
        }
        return viewM2;
    }

    public final void K2(a aVar) {
        J2(aVar.f1042b, aVar.f1043c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            accessibilityEvent.setFromIndex(a2());
            accessibilityEvent.setToIndex(d2());
        }
    }

    public final void L2(int i10, int i11) {
        this.f1031t.f1052c = i11 - this.f1032u.m();
        c cVar = this.f1031t;
        cVar.f1053d = i10;
        cVar.f1054e = this.f1035x ? 1 : -1;
        cVar.f1055f = -1;
        cVar.f1051b = i11;
        cVar.f1056g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.D == null && this.f1033v == this.f1036y;
    }

    public final void M2(a aVar) {
        L2(aVar.f1042b, aVar.f1043c);
    }

    public void N1(RecyclerView.a0 a0Var, int[] iArr) {
        int i10;
        int iN2 = n2(a0Var);
        if (this.f1031t.f1055f == -1) {
            i10 = 0;
        } else {
            i10 = iN2;
            iN2 = 0;
        }
        iArr[0] = iN2;
        iArr[1] = i10;
    }

    public void O1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f1053d;
        if (i10 < 0 || i10 >= a0Var.b()) {
            return;
        }
        cVar2.a(i10, Math.max(0, cVar.f1056g));
    }

    public final int P1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.a(a0Var, this.f1032u, Z1(!this.f1037z, true), Y1(!this.f1037z, true), this, this.f1037z);
    }

    public final int Q1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.b(a0Var, this.f1032u, Z1(!this.f1037z, true), Y1(!this.f1037z, true), this, this.f1037z, this.f1035x);
    }

    public final int R1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.c(a0Var, this.f1032u, Z1(!this.f1037z, true), Y1(!this.f1037z, true), this, this.f1037z);
    }

    public int S1(int i10) {
        if (i10 == 1) {
            return (this.f1030s != 1 && p2()) ? 1 : -1;
        }
        if (i10 == 2) {
            return (this.f1030s != 1 && p2()) ? -1 : 1;
        }
        if (i10 == 17) {
            return this.f1030s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return this.f1030s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 != 66) {
            return (i10 == 130 && this.f1030s == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1030s == 0 ? 1 : Integer.MIN_VALUE;
    }

    public c T1() {
        return new c();
    }

    public void U1() {
        if (this.f1031t == null) {
            this.f1031t = T1();
        }
    }

    public int V1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10 = cVar.f1052c;
        int i11 = cVar.f1056g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f1056g = i11 + i10;
            }
            u2(vVar, cVar);
        }
        int i12 = cVar.f1052c + cVar.f1057h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f1062m && i12 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            r2(vVar, a0Var, cVar, bVar);
            if (!bVar.f1047b) {
                cVar.f1051b += bVar.f1046a * cVar.f1055f;
                if (!bVar.f1048c || cVar.f1061l != null || !a0Var.e()) {
                    int i13 = cVar.f1052c;
                    int i14 = bVar.f1046a;
                    cVar.f1052c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f1056g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f1046a;
                    cVar.f1056g = i16;
                    int i17 = cVar.f1052c;
                    if (i17 < 0) {
                        cVar.f1056g = i16 + i17;
                    }
                    u2(vVar, cVar);
                }
                if (z10 && bVar.f1049d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f1052c;
    }

    public int W1() {
        View viewF2 = f2(0, K(), true, false);
        if (viewF2 == null) {
            return -1;
        }
        return i0(viewF2);
    }

    public final View X1() {
        return e2(0, K());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iJ2;
        int i14;
        View viewD;
        int iG;
        int i15;
        int i16 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            l1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f1038c;
        }
        U1();
        this.f1031t.f1050a = false;
        z2();
        View viewW = W();
        a aVar = this.E;
        if (!aVar.f1045e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f1044d = this.f1035x ^ this.f1036y;
            H2(vVar, a0Var, aVar2);
            this.E.f1045e = true;
        } else if (viewW != null && (this.f1032u.g(viewW) >= this.f1032u.i() || this.f1032u.d(viewW) <= this.f1032u.m())) {
            this.E.c(viewW, i0(viewW));
        }
        c cVar = this.f1031t;
        cVar.f1055f = cVar.f1060k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]) + this.f1032u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.f1032u.j();
        if (a0Var.e() && (i14 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewD = D(i14)) != null) {
            if (this.f1035x) {
                i15 = this.f1032u.i() - this.f1032u.d(viewD);
                iG = this.B;
            } else {
                iG = this.f1032u.g(viewD) - this.f1032u.m();
                i15 = this.B;
            }
            int i17 = i15 - iG;
            if (i17 > 0) {
                iMax += i17;
            } else {
                iMax2 -= i17;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f1044d ? !this.f1035x : this.f1035x) {
            i16 = 1;
        }
        t2(vVar, a0Var, aVar3, i16);
        x(vVar);
        this.f1031t.f1062m = y2();
        this.f1031t.f1059j = a0Var.e();
        this.f1031t.f1058i = 0;
        a aVar4 = this.E;
        if (aVar4.f1044d) {
            M2(aVar4);
            c cVar2 = this.f1031t;
            cVar2.f1057h = iMax;
            V1(vVar, cVar2, a0Var, false);
            c cVar3 = this.f1031t;
            i11 = cVar3.f1051b;
            int i18 = cVar3.f1053d;
            int i19 = cVar3.f1052c;
            if (i19 > 0) {
                iMax2 += i19;
            }
            K2(this.E);
            c cVar4 = this.f1031t;
            cVar4.f1057h = iMax2;
            cVar4.f1053d += cVar4.f1054e;
            V1(vVar, cVar4, a0Var, false);
            c cVar5 = this.f1031t;
            i10 = cVar5.f1051b;
            int i20 = cVar5.f1052c;
            if (i20 > 0) {
                L2(i18, i11);
                c cVar6 = this.f1031t;
                cVar6.f1057h = i20;
                V1(vVar, cVar6, a0Var, false);
                i11 = this.f1031t.f1051b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f1031t;
            cVar7.f1057h = iMax2;
            V1(vVar, cVar7, a0Var, false);
            c cVar8 = this.f1031t;
            i10 = cVar8.f1051b;
            int i21 = cVar8.f1053d;
            int i22 = cVar8.f1052c;
            if (i22 > 0) {
                iMax += i22;
            }
            M2(this.E);
            c cVar9 = this.f1031t;
            cVar9.f1057h = iMax;
            cVar9.f1053d += cVar9.f1054e;
            V1(vVar, cVar9, a0Var, false);
            c cVar10 = this.f1031t;
            i11 = cVar10.f1051b;
            int i23 = cVar10.f1052c;
            if (i23 > 0) {
                J2(i21, i10);
                c cVar11 = this.f1031t;
                cVar11.f1057h = i23;
                V1(vVar, cVar11, a0Var, false);
                i10 = this.f1031t.f1051b;
            }
        }
        if (K() > 0) {
            if (this.f1035x ^ this.f1036y) {
                int iJ3 = j2(i10, vVar, a0Var, true);
                i12 = i11 + iJ3;
                i13 = i10 + iJ3;
                iJ2 = k2(i12, vVar, a0Var, false);
            } else {
                int iK2 = k2(i11, vVar, a0Var, true);
                i12 = i11 + iK2;
                i13 = i10 + iK2;
                iJ2 = j2(i13, vVar, a0Var, false);
            }
            i11 = i12 + iJ2;
            i10 = i13 + iJ2;
        }
        s2(vVar, a0Var, i11, i10);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.f1032u.s();
        }
        this.f1033v = this.f1036y;
    }

    public View Y1(boolean z10, boolean z11) {
        return this.f1035x ? f2(0, K(), z10, z11) : f2(K() - 1, -1, z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.a0 a0Var) {
        super.Z0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    public View Z1(boolean z10, boolean z11) {
        return this.f1035x ? f2(K() - 1, -1, z10, z11) : f2(0, K(), z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i10) {
        if (K() == 0) {
            return null;
        }
        int i11 = (i10 < i0(J(0))) != this.f1035x ? -1 : 1;
        return this.f1030s == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    public int a2() {
        View viewF2 = f2(0, K(), false, true);
        if (viewF2 == null) {
            return -1;
        }
        return i0(viewF2);
    }

    @Override // androidx.recyclerview.widget.j.InterfaceC0022j
    public void b(View view, View view2, int i10, int i11) {
        h("Cannot drop a view during a scroll or layout calculation");
        U1();
        z2();
        int iI0 = i0(view);
        int iI1 = i0(view2);
        byte b10 = iI0 < iI1 ? (byte) 1 : (byte) -1;
        if (this.f1035x) {
            if (b10 == 1) {
                B2(iI1, this.f1032u.i() - (this.f1032u.g(view2) + this.f1032u.e(view)));
                return;
            } else {
                B2(iI1, this.f1032u.i() - this.f1032u.d(view2));
                return;
            }
        }
        if (b10 == -1) {
            B2(iI1, this.f1032u.g(view2));
        } else {
            B2(iI1, this.f1032u.d(view2) - this.f1032u.e(view));
        }
    }

    public int b2() {
        View viewF2 = f2(K() - 1, -1, true, false);
        if (viewF2 == null) {
            return -1;
        }
        return i0(viewF2);
    }

    public final View c2() {
        return e2(K() - 1, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.b();
            }
            u1();
        }
    }

    public int d2() {
        View viewF2 = f2(K() - 1, -1, false, true);
        if (viewF2 == null) {
            return -1;
        }
        return i0(viewF2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable e1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (K() <= 0) {
            savedState.b();
            return savedState;
        }
        U1();
        boolean z10 = this.f1033v ^ this.f1035x;
        savedState.f1040m = z10;
        if (z10) {
            View viewL2 = l2();
            savedState.f1039e = this.f1032u.i() - this.f1032u.d(viewL2);
            savedState.f1038c = i0(viewL2);
            return savedState;
        }
        View viewM2 = m2();
        savedState.f1038c = i0(viewM2);
        savedState.f1039e = this.f1032u.g(viewM2) - this.f1032u.m();
        return savedState;
    }

    public View e2(int i10, int i11) {
        int i12;
        int i13;
        U1();
        if (i11 <= i10 && i11 >= i10) {
            return J(i10);
        }
        if (this.f1032u.g(J(i10)) < this.f1032u.m()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.f1030s == 0 ? this.f1175e.a(i10, i11, i12, i13) : this.f1176f.a(i10, i11, i12, i13);
    }

    public View f2(int i10, int i11, boolean z10, boolean z11) {
        U1();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        return this.f1030s == 0 ? this.f1175e.a(i10, i11, i12, i13) : this.f1176f.a(i10, i11, i12, i13);
    }

    public final View g2() {
        return this.f1035x ? X1() : c2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    public final View h2() {
        return this.f1035x ? c2() : X1();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    public View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10, boolean z11) {
        int i10;
        int iK;
        int i11;
        U1();
        int iK2 = K();
        if (z11) {
            iK = K() - 1;
            i10 = -1;
            i11 = -1;
        } else {
            i10 = iK2;
            iK = 0;
            i11 = 1;
        }
        int iB = a0Var.b();
        int iM = this.f1032u.m();
        int i12 = this.f1032u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iK != i10) {
            View viewJ = J(iK);
            int iI0 = i0(viewJ);
            int iG = this.f1032u.g(viewJ);
            int iD = this.f1032u.d(viewJ);
            if (iI0 >= 0 && iI0 < iB) {
                if (!((RecyclerView.p) viewJ.getLayoutParams()).c()) {
                    boolean z12 = iD <= iM && iG < iM;
                    boolean z13 = iG >= i12 && iD > i12;
                    if (!z12 && !z13) {
                        return viewJ;
                    }
                    if (z10) {
                        if (z13) {
                            view2 = viewJ;
                        } else if (view == null) {
                            view = viewJ;
                        }
                    } else if (z12) {
                        view2 = viewJ;
                    } else if (view == null) {
                        view = viewJ;
                    }
                } else if (view3 == null) {
                    view3 = viewJ;
                }
            }
            iK += i11;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    public final int j2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i11;
        int i12 = this.f1032u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -A2(-i12, vVar, a0Var);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f1032u.i() - i14) <= 0) {
            return i13;
        }
        this.f1032u.r(i11);
        return i11 + i13;
    }

    public final int k2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int iM;
        int iM2 = i10 - this.f1032u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i11 = -A2(iM2, vVar, a0Var);
        int i12 = i10 + i11;
        if (!z10 || (iM = i12 - this.f1032u.m()) <= 0) {
            return i11;
        }
        this.f1032u.r(-iM);
        return i11 - iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1030s == 0;
    }

    public final View l2() {
        return J(this.f1035x ? 0 : K() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m() {
        return this.f1030s == 1;
    }

    public final View m2() {
        return J(this.f1035x ? K() - 1 : 0);
    }

    public int n2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.f1032u.n();
        }
        return 0;
    }

    public int o2() {
        return this.f1030s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.f1030s != 0) {
            i10 = i11;
        }
        if (K() == 0 || i10 == 0) {
            return;
        }
        U1();
        I2(i10 > 0 ? 1 : -1, Math.abs(i10), true, a0Var);
        O1(a0Var, this.f1031t, cVar);
    }

    public boolean p2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.D;
        if (savedState == null || !savedState.a()) {
            z2();
            z10 = this.f1035x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f1040m;
            i11 = savedState2.f1038c;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public boolean q2() {
        return this.f1037z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public void r2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int iF;
        int i10;
        int i11;
        int i12;
        int iF0;
        int iF2;
        int i13;
        int i14;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f1047b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f1061l == null) {
            if (this.f1035x == (cVar.f1055f == -1)) {
                e(viewD);
            } else {
                f(viewD, 0);
            }
        } else {
            if (this.f1035x == (cVar.f1055f == -1)) {
                c(viewD);
            } else {
                d(viewD, 0);
            }
        }
        B0(viewD, 0, 0);
        bVar.f1046a = this.f1032u.e(viewD);
        if (this.f1030s == 1) {
            if (p2()) {
                iF2 = p0() - g0();
                iF0 = iF2 - this.f1032u.f(viewD);
            } else {
                iF0 = f0();
                iF2 = this.f1032u.f(viewD) + iF0;
            }
            if (cVar.f1055f == -1) {
                i14 = cVar.f1051b;
                i13 = i14 - bVar.f1046a;
            } else {
                i13 = cVar.f1051b;
                i14 = bVar.f1046a + i13;
            }
            int i15 = iF0;
            i12 = i13;
            i11 = i15;
            iF = i14;
            i10 = iF2;
        } else {
            int iH0 = h0();
            iF = this.f1032u.f(viewD) + iH0;
            if (cVar.f1055f == -1) {
                int i16 = cVar.f1051b;
                i11 = i16 - bVar.f1046a;
                i10 = i16;
            } else {
                int i17 = cVar.f1051b;
                i10 = bVar.f1046a + i17;
                i11 = i17;
            }
            i12 = iH0;
        }
        A0(viewD, i11, i12, i10, iF);
        if (pVar.c() || pVar.b()) {
            bVar.f1048c = true;
        }
        bVar.f1049d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    public final void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11) {
        if (!a0Var.g() || K() == 0 || a0Var.e() || !M1()) {
            return;
        }
        List listK = vVar.k();
        int size = listK.size();
        int iI0 = i0(J(0));
        int iE = 0;
        int iE2 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) listK.get(i12);
            if (!d0Var.x()) {
                if ((d0Var.o() < iI0) != this.f1035x) {
                    iE += this.f1032u.e(d0Var.f1138a);
                } else {
                    iE2 += this.f1032u.e(d0Var.f1138a);
                }
            }
        }
        this.f1031t.f1061l = listK;
        if (iE > 0) {
            L2(i0(m2()), i10);
            c cVar = this.f1031t;
            cVar.f1057h = iE;
            cVar.f1052c = 0;
            cVar.a();
            V1(vVar, this.f1031t, a0Var, false);
        }
        if (iE2 > 0) {
            J2(i0(l2()), i11);
            c cVar2 = this.f1031t;
            cVar2.f1057h = iE2;
            cVar2.f1052c = 0;
            cVar2.a();
            V1(vVar, this.f1031t, a0Var, false);
        }
        this.f1031t.f1061l = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return R1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean t0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public final void u2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f1050a || cVar.f1062m) {
            return;
        }
        int i10 = cVar.f1056g;
        int i11 = cVar.f1058i;
        if (cVar.f1055f == -1) {
            w2(vVar, i10, i11);
        } else {
            x2(vVar, i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    public final void v2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                o1(i10, vVar);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                o1(i12, vVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.a0 a0Var) {
        return R1(a0Var);
    }

    public final void w2(RecyclerView.v vVar, int i10, int i11) {
        int iK = K();
        if (i10 < 0) {
            return;
        }
        int iH = (this.f1032u.h() - i10) + i11;
        if (this.f1035x) {
            for (int i12 = 0; i12 < iK; i12++) {
                View viewJ = J(i12);
                if (this.f1032u.g(viewJ) < iH || this.f1032u.q(viewJ) < iH) {
                    v2(vVar, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = iK - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View viewJ2 = J(i14);
            if (this.f1032u.g(viewJ2) < iH || this.f1032u.q(viewJ2) < iH) {
                v2(vVar, i13, i14);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1030s == 1) {
            return 0;
        }
        return A2(i10, vVar, a0Var);
    }

    public final void x2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int iK = K();
        if (!this.f1035x) {
            for (int i13 = 0; i13 < iK; i13++) {
                View viewJ = J(i13);
                if (this.f1032u.d(viewJ) > i12 || this.f1032u.p(viewJ) > i12) {
                    v2(vVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = iK - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View viewJ2 = J(i15);
            if (this.f1032u.d(viewJ2) > i12 || this.f1032u.p(viewJ2) > i12) {
                v2(vVar, i14, i15);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        u1();
    }

    public boolean y2() {
        return this.f1032u.k() == 0 && this.f1032u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1030s == 0) {
            return 0;
        }
        return A2(i10, vVar, a0Var);
    }

    public final void z2() {
        if (this.f1030s == 1 || !p2()) {
            this.f1035x = this.f1034w;
        } else {
            this.f1035x = !this.f1034w;
        }
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f1030s = 1;
        this.f1034w = false;
        this.f1035x = false;
        this.f1036y = false;
        this.f1037z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i10);
        D2(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1030s = 1;
        this.f1034w = false;
        this.f1035x = false;
        this.f1036y = false;
        this.f1037z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d dVarJ0 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        C2(dVarJ0.f1191a);
        D2(dVarJ0.f1193c);
        E2(dVarJ0.f1194d);
    }

    public void t2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i10) {
    }
}
