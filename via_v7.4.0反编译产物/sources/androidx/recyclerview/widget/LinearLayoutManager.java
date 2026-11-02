package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements j.InterfaceC0023j, RecyclerView.y.b {
    public int A;
    public int B;
    public boolean C;
    public SavedState D;
    public final a E;
    public final b F;
    public int G;
    public int[] H;

    /* renamed from: s, reason: collision with root package name */
    public int f1127s;

    /* renamed from: t, reason: collision with root package name */
    public c f1128t;

    /* renamed from: u, reason: collision with root package name */
    public q f1129u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1130v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1131w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1132x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1133y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1134z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f1135e;

        /* renamed from: j, reason: collision with root package name */
        public int f1136j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f1137k;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.f1135e = parcel.readInt();
            this.f1136j = parcel.readInt();
            this.f1137k = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f1135e = savedState.f1135e;
            this.f1136j = savedState.f1136j;
            this.f1137k = savedState.f1137k;
        }

        public boolean a() {
            return this.f1135e >= 0;
        }

        public void b() {
            this.f1135e = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1135e);
            parcel.writeInt(this.f1136j);
            parcel.writeInt(this.f1137k ? 1 : 0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public q f1138a;

        /* renamed from: b, reason: collision with root package name */
        public int f1139b;

        /* renamed from: c, reason: collision with root package name */
        public int f1140c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1141d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1142e;

        public a() {
            e();
        }

        public void a() {
            this.f1140c = this.f1141d ? this.f1138a.i() : this.f1138a.m();
        }

        public void b(View view, int i10) {
            if (this.f1141d) {
                this.f1140c = this.f1138a.d(view) + this.f1138a.o();
            } else {
                this.f1140c = this.f1138a.g(view);
            }
            this.f1139b = i10;
        }

        public void c(View view, int i10) {
            int iO = this.f1138a.o();
            if (iO >= 0) {
                b(view, i10);
                return;
            }
            this.f1139b = i10;
            if (this.f1141d) {
                int i11 = (this.f1138a.i() - iO) - this.f1138a.d(view);
                this.f1140c = this.f1138a.i() - i11;
                if (i11 > 0) {
                    int iE = this.f1140c - this.f1138a.e(view);
                    int iM = this.f1138a.m();
                    int iMin = iE - (iM + Math.min(this.f1138a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f1140c += Math.min(i11, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f1138a.g(view);
            int iM2 = iG - this.f1138a.m();
            this.f1140c = iG;
            if (iM2 > 0) {
                int i12 = (this.f1138a.i() - Math.min(0, (this.f1138a.i() - iO) - this.f1138a.d(view))) - (iG + this.f1138a.e(view));
                if (i12 < 0) {
                    this.f1140c -= Math.min(iM2, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        public void e() {
            this.f1139b = -1;
            this.f1140c = Integer.MIN_VALUE;
            this.f1141d = false;
            this.f1142e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1139b + ", mCoordinate=" + this.f1140c + ", mLayoutFromEnd=" + this.f1141d + ", mValid=" + this.f1142e + '}';
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1143a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1144b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1145c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1146d;

        public void a() {
            this.f1143a = 0;
            this.f1144b = false;
            this.f1145c = false;
            this.f1146d = false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f1148b;

        /* renamed from: c, reason: collision with root package name */
        public int f1149c;

        /* renamed from: d, reason: collision with root package name */
        public int f1150d;

        /* renamed from: e, reason: collision with root package name */
        public int f1151e;

        /* renamed from: f, reason: collision with root package name */
        public int f1152f;

        /* renamed from: g, reason: collision with root package name */
        public int f1153g;

        /* renamed from: k, reason: collision with root package name */
        public int f1157k;

        /* renamed from: m, reason: collision with root package name */
        public boolean f1159m;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1147a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f1154h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f1155i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f1156j = false;

        /* renamed from: l, reason: collision with root package name */
        public List f1158l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f1150d = -1;
            } else {
                this.f1150d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.z zVar) {
            int i10 = this.f1150d;
            return i10 >= 0 && i10 < zVar.b();
        }

        public View d(RecyclerView.v vVar) {
            if (this.f1158l != null) {
                return e();
            }
            View viewO = vVar.o(this.f1150d);
            this.f1150d += this.f1151e;
            return viewO;
        }

        public final View e() {
            int size = this.f1158l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((RecyclerView.c0) this.f1158l.get(i10)).f1219a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1150d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int iA;
            int size = this.f1158l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = ((RecyclerView.c0) this.f1158l.get(i11)).f1219a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f1150d) * this.f1151e) >= 0 && iA < i10) {
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

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f1127s = 1;
        this.f1131w = false;
        this.f1132x = false;
        this.f1133y = false;
        this.f1134z = true;
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
        this.f1127s = 1;
        this.f1131w = false;
        this.f1132x = false;
        this.f1133y = false;
        this.f1134z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d dVarJ0 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        C2(dVarJ0.f1273a);
        D2(dVarJ0.f1275c);
        E2(dVarJ0.f1276d);
    }

    public int A2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        U1();
        this.f1128t.f1147a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        I2(i11, iAbs, true, zVar);
        c cVar = this.f1128t;
        int iV1 = cVar.f1153g + V1(vVar, cVar, zVar, false);
        if (iV1 < 0) {
            return 0;
        }
        if (iAbs > iV1) {
            i10 = i11 * iV1;
        }
        this.f1129u.r(-i10);
        this.f1128t.f1157k = i10;
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
        if (i10 != this.f1127s || this.f1129u == null) {
            q qVarB = q.b(this, i10);
            this.f1129u = qVarB;
            this.E.f1138a = qVarB;
            this.f1127s = i10;
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
        if (z10 == this.f1131w) {
            return;
        }
        this.f1131w = z10;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return new RecyclerView.p(-2, -2);
    }

    public void E2(boolean z10) {
        h(null);
        if (this.f1133y == z10) {
            return;
        }
        this.f1133y = z10;
        u1();
    }

    public final boolean F2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        View viewI2;
        boolean z10 = false;
        if (K() == 0) {
            return false;
        }
        View viewW = W();
        if (viewW != null && aVar.d(viewW, zVar)) {
            aVar.c(viewW, i0(viewW));
            return true;
        }
        boolean z11 = this.f1130v;
        boolean z12 = this.f1133y;
        if (z11 != z12 || (viewI2 = i2(vVar, zVar, aVar.f1141d, z12)) == null) {
            return false;
        }
        aVar.b(viewI2, i0(viewI2));
        if (!zVar.e() && M1()) {
            int iG = this.f1129u.g(viewI2);
            int iD = this.f1129u.d(viewI2);
            int iM = this.f1129u.m();
            int i10 = this.f1129u.i();
            boolean z13 = iD <= iM && iG < iM;
            if (iG >= i10 && iD > i10) {
                z10 = true;
            }
            if (z13 || z10) {
                if (aVar.f1141d) {
                    iM = i10;
                }
                aVar.f1140c = iM;
            }
        }
        return true;
    }

    public final boolean G2(RecyclerView.z zVar, a aVar) {
        int i10;
        if (!zVar.e() && (i10 = this.A) != -1) {
            if (i10 >= 0 && i10 < zVar.b()) {
                aVar.f1139b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z10 = this.D.f1137k;
                    aVar.f1141d = z10;
                    if (z10) {
                        aVar.f1140c = this.f1129u.i() - this.D.f1136j;
                    } else {
                        aVar.f1140c = this.f1129u.m() + this.D.f1136j;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z11 = this.f1132x;
                    aVar.f1141d = z11;
                    if (z11) {
                        aVar.f1140c = this.f1129u.i() - this.B;
                    } else {
                        aVar.f1140c = this.f1129u.m() + this.B;
                    }
                    return true;
                }
                View viewD = D(this.A);
                if (viewD == null) {
                    if (K() > 0) {
                        aVar.f1141d = (this.A < i0(J(0))) == this.f1132x;
                    }
                    aVar.a();
                } else {
                    if (this.f1129u.e(viewD) > this.f1129u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f1129u.g(viewD) - this.f1129u.m() < 0) {
                        aVar.f1140c = this.f1129u.m();
                        aVar.f1141d = false;
                        return true;
                    }
                    if (this.f1129u.i() - this.f1129u.d(viewD) < 0) {
                        aVar.f1140c = this.f1129u.i();
                        aVar.f1141d = true;
                        return true;
                    }
                    aVar.f1140c = aVar.f1141d ? this.f1129u.d(viewD) + this.f1129u.o() : this.f1129u.g(viewD);
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

    public final void H2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (G2(zVar, aVar) || F2(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1139b = this.f1133y ? zVar.b() - 1 : 0;
    }

    public final void I2(int i10, int i11, boolean z10, RecyclerView.z zVar) {
        int iM;
        this.f1128t.f1159m = y2();
        this.f1128t.f1152f = i10;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(zVar, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z11 = i10 == 1;
        c cVar = this.f1128t;
        int i12 = z11 ? iMax2 : iMax;
        cVar.f1154h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        cVar.f1155i = iMax;
        if (z11) {
            cVar.f1154h = i12 + this.f1129u.j();
            View viewL2 = l2();
            c cVar2 = this.f1128t;
            cVar2.f1151e = this.f1132x ? -1 : 1;
            int iI0 = i0(viewL2);
            c cVar3 = this.f1128t;
            cVar2.f1150d = iI0 + cVar3.f1151e;
            cVar3.f1148b = this.f1129u.d(viewL2);
            iM = this.f1129u.d(viewL2) - this.f1129u.i();
        } else {
            View viewM2 = m2();
            this.f1128t.f1154h += this.f1129u.m();
            c cVar4 = this.f1128t;
            cVar4.f1151e = this.f1132x ? 1 : -1;
            int iI02 = i0(viewM2);
            c cVar5 = this.f1128t;
            cVar4.f1150d = iI02 + cVar5.f1151e;
            cVar5.f1148b = this.f1129u.g(viewM2);
            iM = (-this.f1129u.g(viewM2)) + this.f1129u.m();
        }
        c cVar6 = this.f1128t;
        cVar6.f1149c = i11;
        if (z10) {
            cVar6.f1149c = i11 - iM;
        }
        cVar6.f1153g = iM;
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
    public void J1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        n nVar = new n(recyclerView.getContext());
        nVar.p(i10);
        K1(nVar);
    }

    public final void J2(int i10, int i11) {
        this.f1128t.f1149c = this.f1129u.i() - i11;
        c cVar = this.f1128t;
        cVar.f1151e = this.f1132x ? -1 : 1;
        cVar.f1150d = i10;
        cVar.f1152f = 1;
        cVar.f1148b = i11;
        cVar.f1153g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iS1;
        z2();
        if (K() == 0 || (iS1 = S1(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        U1();
        I2(iS1, (int) (this.f1129u.n() * 0.33333334f), false, zVar);
        c cVar = this.f1128t;
        cVar.f1153g = Integer.MIN_VALUE;
        cVar.f1147a = false;
        V1(vVar, cVar, zVar, true);
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
        J2(aVar.f1139b, aVar.f1140c);
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
        this.f1128t.f1149c = i11 - this.f1129u.m();
        c cVar = this.f1128t;
        cVar.f1150d = i10;
        cVar.f1151e = this.f1132x ? 1 : -1;
        cVar.f1152f = -1;
        cVar.f1148b = i11;
        cVar.f1153g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.D == null && this.f1130v == this.f1133y;
    }

    public final void M2(a aVar) {
        L2(aVar.f1139b, aVar.f1140c);
    }

    public void N1(RecyclerView.z zVar, int[] iArr) {
        int i10;
        int iN2 = n2(zVar);
        if (this.f1128t.f1152f == -1) {
            i10 = 0;
        } else {
            i10 = iN2;
            iN2 = 0;
        }
        iArr[0] = iN2;
        iArr[1] = i10;
    }

    public void O1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f1150d;
        if (i10 < 0 || i10 >= zVar.b()) {
            return;
        }
        cVar2.a(i10, Math.max(0, cVar.f1153g));
    }

    public final int P1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.a(zVar, this.f1129u, Z1(!this.f1134z, true), Y1(!this.f1134z, true), this, this.f1134z);
    }

    public final int Q1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.b(zVar, this.f1129u, Z1(!this.f1134z, true), Y1(!this.f1134z, true), this, this.f1134z, this.f1132x);
    }

    public final int R1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return t.c(zVar, this.f1129u, Z1(!this.f1134z, true), Y1(!this.f1134z, true), this, this.f1134z);
    }

    public int S1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f1127s == 1) ? 1 : Integer.MIN_VALUE : this.f1127s == 0 ? 1 : Integer.MIN_VALUE : this.f1127s == 1 ? -1 : Integer.MIN_VALUE : this.f1127s == 0 ? -1 : Integer.MIN_VALUE : (this.f1127s != 1 && p2()) ? -1 : 1 : (this.f1127s != 1 && p2()) ? 1 : -1;
    }

    public c T1() {
        return new c();
    }

    public void U1() {
        if (this.f1128t == null) {
            this.f1128t = T1();
        }
    }

    public int V1(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z10) {
        int i10 = cVar.f1149c;
        int i11 = cVar.f1153g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f1153g = i11 + i10;
            }
            u2(vVar, cVar);
        }
        int i12 = cVar.f1149c + cVar.f1154h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f1159m && i12 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            r2(vVar, zVar, cVar, bVar);
            if (!bVar.f1144b) {
                cVar.f1148b += bVar.f1143a * cVar.f1152f;
                if (!bVar.f1145c || cVar.f1158l != null || !zVar.e()) {
                    int i13 = cVar.f1149c;
                    int i14 = bVar.f1143a;
                    cVar.f1149c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f1153g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f1143a;
                    cVar.f1153g = i16;
                    int i17 = cVar.f1149c;
                    if (i17 < 0) {
                        cVar.f1153g = i16 + i17;
                    }
                    u2(vVar, cVar);
                }
                if (z10 && bVar.f1146d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f1149c;
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
    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
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
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            l1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f1135e;
        }
        U1();
        this.f1128t.f1147a = false;
        z2();
        View viewW = W();
        a aVar = this.E;
        if (!aVar.f1142e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f1141d = this.f1132x ^ this.f1133y;
            H2(vVar, zVar, aVar2);
            this.E.f1142e = true;
        } else if (viewW != null && (this.f1129u.g(viewW) >= this.f1129u.i() || this.f1129u.d(viewW) <= this.f1129u.m())) {
            this.E.c(viewW, i0(viewW));
        }
        c cVar = this.f1128t;
        cVar.f1152f = cVar.f1157k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(zVar, iArr);
        int iMax = Math.max(0, this.H[0]) + this.f1129u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.f1129u.j();
        if (zVar.e() && (i14 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewD = D(i14)) != null) {
            if (this.f1132x) {
                i15 = this.f1129u.i() - this.f1129u.d(viewD);
                iG = this.B;
            } else {
                iG = this.f1129u.g(viewD) - this.f1129u.m();
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
        if (!aVar3.f1141d ? !this.f1132x : this.f1132x) {
            i16 = 1;
        }
        t2(vVar, zVar, aVar3, i16);
        x(vVar);
        this.f1128t.f1159m = y2();
        this.f1128t.f1156j = zVar.e();
        this.f1128t.f1155i = 0;
        a aVar4 = this.E;
        if (aVar4.f1141d) {
            M2(aVar4);
            c cVar2 = this.f1128t;
            cVar2.f1154h = iMax;
            V1(vVar, cVar2, zVar, false);
            c cVar3 = this.f1128t;
            i11 = cVar3.f1148b;
            int i18 = cVar3.f1150d;
            int i19 = cVar3.f1149c;
            if (i19 > 0) {
                iMax2 += i19;
            }
            K2(this.E);
            c cVar4 = this.f1128t;
            cVar4.f1154h = iMax2;
            cVar4.f1150d += cVar4.f1151e;
            V1(vVar, cVar4, zVar, false);
            c cVar5 = this.f1128t;
            i10 = cVar5.f1148b;
            int i20 = cVar5.f1149c;
            if (i20 > 0) {
                L2(i18, i11);
                c cVar6 = this.f1128t;
                cVar6.f1154h = i20;
                V1(vVar, cVar6, zVar, false);
                i11 = this.f1128t.f1148b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f1128t;
            cVar7.f1154h = iMax2;
            V1(vVar, cVar7, zVar, false);
            c cVar8 = this.f1128t;
            i10 = cVar8.f1148b;
            int i21 = cVar8.f1150d;
            int i22 = cVar8.f1149c;
            if (i22 > 0) {
                iMax += i22;
            }
            M2(this.E);
            c cVar9 = this.f1128t;
            cVar9.f1154h = iMax;
            cVar9.f1150d += cVar9.f1151e;
            V1(vVar, cVar9, zVar, false);
            c cVar10 = this.f1128t;
            i11 = cVar10.f1148b;
            int i23 = cVar10.f1149c;
            if (i23 > 0) {
                J2(i21, i10);
                c cVar11 = this.f1128t;
                cVar11.f1154h = i23;
                V1(vVar, cVar11, zVar, false);
                i10 = this.f1128t.f1148b;
            }
        }
        if (K() > 0) {
            if (this.f1132x ^ this.f1133y) {
                int iJ22 = j2(i10, vVar, zVar, true);
                i12 = i11 + iJ22;
                i13 = i10 + iJ22;
                iJ2 = k2(i12, vVar, zVar, false);
            } else {
                int iK2 = k2(i11, vVar, zVar, true);
                i12 = i11 + iK2;
                i13 = i10 + iK2;
                iJ2 = j2(i13, vVar, zVar, false);
            }
            i11 = i12 + iJ2;
            i10 = i13 + iJ2;
        }
        s2(vVar, zVar, i11, i10);
        if (zVar.e()) {
            this.E.e();
        } else {
            this.f1129u.s();
        }
        this.f1130v = this.f1133y;
    }

    public View Y1(boolean z10, boolean z11) {
        return this.f1132x ? f2(0, K(), z10, z11) : f2(K() - 1, -1, z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    public View Z1(boolean z10, boolean z11) {
        return this.f1132x ? f2(K() - 1, -1, z10, z11) : f2(0, K(), z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i10) {
        if (K() == 0) {
            return null;
        }
        int i11 = (i10 < i0(J(0))) != this.f1132x ? -1 : 1;
        return this.f1127s == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    public int a2() {
        View viewF2 = f2(0, K(), false, true);
        if (viewF2 == null) {
            return -1;
        }
        return i0(viewF2);
    }

    @Override // androidx.recyclerview.widget.j.InterfaceC0023j
    public void b(View view, View view2, int i10, int i11) {
        h("Cannot drop a view during a scroll or layout calculation");
        U1();
        z2();
        int iI0 = i0(view);
        int iI02 = i0(view2);
        char c10 = iI0 < iI02 ? (char) 1 : '\uffff';
        if (this.f1132x) {
            if (c10 == 1) {
                B2(iI02, this.f1129u.i() - (this.f1129u.g(view2) + this.f1129u.e(view)));
                return;
            } else {
                B2(iI02, this.f1129u.i() - this.f1129u.d(view2));
                return;
            }
        }
        if (c10 == '\uffff') {
            B2(iI02, this.f1129u.g(view2));
        } else {
            B2(iI02, this.f1129u.d(view2) - this.f1129u.e(view));
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
        boolean z10 = this.f1130v ^ this.f1132x;
        savedState.f1137k = z10;
        if (z10) {
            View viewL2 = l2();
            savedState.f1136j = this.f1129u.i() - this.f1129u.d(viewL2);
            savedState.f1135e = i0(viewL2);
            return savedState;
        }
        View viewM2 = m2();
        savedState.f1135e = i0(viewM2);
        savedState.f1136j = this.f1129u.g(viewM2) - this.f1129u.m();
        return savedState;
    }

    public View e2(int i10, int i11) {
        int i12;
        int i13;
        U1();
        if (i11 <= i10 && i11 >= i10) {
            return J(i10);
        }
        if (this.f1129u.g(J(i10)) < this.f1129u.m()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.f1127s == 0 ? this.f1257e.a(i10, i11, i12, i13) : this.f1258f.a(i10, i11, i12, i13);
    }

    public View f2(int i10, int i11, boolean z10, boolean z11) {
        U1();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        return this.f1127s == 0 ? this.f1257e.a(i10, i11, i12, i13) : this.f1258f.a(i10, i11, i12, i13);
    }

    public final View g2() {
        return this.f1132x ? X1() : c2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    public final View h2() {
        return this.f1132x ? c2() : X1();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View i2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
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
        int iB = zVar.b();
        int iM = this.f1129u.m();
        int i12 = this.f1129u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iK != i10) {
            View viewJ = J(iK);
            int iI0 = i0(viewJ);
            int iG = this.f1129u.g(viewJ);
            int iD = this.f1129u.d(viewJ);
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
                    } else if (!z12) {
                        if (view == null) {
                        }
                    }
                } else if (view3 == null) {
                    view3 = viewJ;
                }
            }
            iK += i11;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public final int j2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i11;
        int i12 = this.f1129u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -A2(-i12, vVar, zVar);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f1129u.i() - i14) <= 0) {
            return i13;
        }
        this.f1129u.r(i11);
        return i11 + i13;
    }

    public final int k2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int iM;
        int iM2 = i10 - this.f1129u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i11 = -A2(iM2, vVar, zVar);
        int i12 = i10 + i11;
        if (!z10 || (iM = i12 - this.f1129u.m()) <= 0) {
            return i11;
        }
        this.f1129u.r(-iM);
        return i11 - iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1127s == 0;
    }

    public final View l2() {
        return J(this.f1132x ? 0 : K() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m() {
        return this.f1127s == 1;
    }

    public final View m2() {
        return J(this.f1132x ? K() - 1 : 0);
    }

    public int n2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f1129u.n();
        }
        return 0;
    }

    public int o2() {
        return this.f1127s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i10, int i11, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.f1127s != 0) {
            i10 = i11;
        }
        if (K() == 0 || i10 == 0) {
            return;
        }
        U1();
        I2(i10 > 0 ? 1 : -1, Math.abs(i10), true, zVar);
        O1(zVar, this.f1128t, cVar);
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
            z10 = this.f1132x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f1137k;
            i11 = savedState2.f1135e;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public boolean q2() {
        return this.f1134z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public void r2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iF0;
        int iF;
        int i14;
        int i15;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f1144b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f1158l == null) {
            if (this.f1132x == (cVar.f1152f == -1)) {
                e(viewD);
            } else {
                f(viewD, 0);
            }
        } else {
            if (this.f1132x == (cVar.f1152f == -1)) {
                c(viewD);
            } else {
                d(viewD, 0);
            }
        }
        B0(viewD, 0, 0);
        bVar.f1143a = this.f1129u.e(viewD);
        if (this.f1127s == 1) {
            if (p2()) {
                iF = p0() - g0();
                iF0 = iF - this.f1129u.f(viewD);
            } else {
                iF0 = f0();
                iF = this.f1129u.f(viewD) + iF0;
            }
            if (cVar.f1152f == -1) {
                i15 = cVar.f1148b;
                i14 = i15 - bVar.f1143a;
            } else {
                i14 = cVar.f1148b;
                i15 = bVar.f1143a + i14;
            }
            int i16 = iF0;
            i13 = i14;
            i12 = i16;
            i11 = i15;
            i10 = iF;
        } else {
            int iH0 = h0();
            int iF2 = this.f1129u.f(viewD) + iH0;
            if (cVar.f1152f == -1) {
                int i17 = cVar.f1148b;
                i12 = i17 - bVar.f1143a;
                i10 = i17;
                i11 = iF2;
            } else {
                int i18 = cVar.f1148b;
                i10 = bVar.f1143a + i18;
                i11 = iF2;
                i12 = i18;
            }
            i13 = iH0;
        }
        A0(viewD, i12, i13, i10, i11);
        if (pVar.c() || pVar.b()) {
            bVar.f1145c = true;
        }
        bVar.f1146d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    public final void s2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, int i11) {
        if (!zVar.g() || K() == 0 || zVar.e() || !M1()) {
            return;
        }
        List listK = vVar.k();
        int size = listK.size();
        int iI0 = i0(J(0));
        int iE = 0;
        int iE2 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.c0 c0Var = (RecyclerView.c0) listK.get(i12);
            if (!c0Var.x()) {
                if ((c0Var.o() < iI0) != this.f1132x) {
                    iE += this.f1129u.e(c0Var.f1219a);
                } else {
                    iE2 += this.f1129u.e(c0Var.f1219a);
                }
            }
        }
        this.f1128t.f1158l = listK;
        if (iE > 0) {
            L2(i0(m2()), i10);
            c cVar = this.f1128t;
            cVar.f1154h = iE;
            cVar.f1149c = 0;
            cVar.a();
            V1(vVar, this.f1128t, zVar, false);
        }
        if (iE2 > 0) {
            J2(i0(l2()), i11);
            c cVar2 = this.f1128t;
            cVar2.f1154h = iE2;
            cVar2.f1149c = 0;
            cVar2.a();
            V1(vVar, this.f1128t, zVar, false);
        }
        this.f1128t.f1158l = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean t0() {
        return true;
    }

    public void t2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public final void u2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f1147a || cVar.f1159m) {
            return;
        }
        int i10 = cVar.f1153g;
        int i11 = cVar.f1155i;
        if (cVar.f1152f == -1) {
            w2(vVar, i10, i11);
        } else {
            x2(vVar, i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
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
    public int w(RecyclerView.z zVar) {
        return R1(zVar);
    }

    public final void w2(RecyclerView.v vVar, int i10, int i11) {
        int iK = K();
        if (i10 < 0) {
            return;
        }
        int iH = (this.f1129u.h() - i10) + i11;
        if (this.f1132x) {
            for (int i12 = 0; i12 < iK; i12++) {
                View viewJ = J(i12);
                if (this.f1129u.g(viewJ) < iH || this.f1129u.q(viewJ) < iH) {
                    v2(vVar, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = iK - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View viewJ2 = J(i14);
            if (this.f1129u.g(viewJ2) < iH || this.f1129u.q(viewJ2) < iH) {
                v2(vVar, i13, i14);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f1127s == 1) {
            return 0;
        }
        return A2(i10, vVar, zVar);
    }

    public final void x2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int iK = K();
        if (!this.f1132x) {
            for (int i13 = 0; i13 < iK; i13++) {
                View viewJ = J(i13);
                if (this.f1129u.d(viewJ) > i12 || this.f1129u.p(viewJ) > i12) {
                    v2(vVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = iK - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View viewJ2 = J(i15);
            if (this.f1129u.d(viewJ2) > i12 || this.f1129u.p(viewJ2) > i12) {
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
        return this.f1129u.k() == 0 && this.f1129u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f1127s == 0) {
            return 0;
        }
        return A2(i10, vVar, zVar);
    }

    public final void z2() {
        if (this.f1127s == 1 || !p2()) {
            this.f1132x = this.f1131w;
        } else {
            this.f1132x = !this.f1131w;
        }
    }
}
