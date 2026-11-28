package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public SavedState I;
    public int J;
    public int[] O;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d[] f1230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q f1231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public q f1232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f1235y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1229s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1236z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public LazySpanLookup E = new LazySpanLookup();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1243c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1244e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1245m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int[] f1246n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1247o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int[] f1248p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List f1249q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f1250r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f1251s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f1252t;

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

        public void a() {
            this.f1246n = null;
            this.f1245m = 0;
            this.f1243c = -1;
            this.f1244e = -1;
        }

        public void b() {
            this.f1246n = null;
            this.f1245m = 0;
            this.f1247o = 0;
            this.f1248p = null;
            this.f1249q = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1243c);
            parcel.writeInt(this.f1244e);
            parcel.writeInt(this.f1245m);
            if (this.f1245m > 0) {
                parcel.writeIntArray(this.f1246n);
            }
            parcel.writeInt(this.f1247o);
            if (this.f1247o > 0) {
                parcel.writeIntArray(this.f1248p);
            }
            parcel.writeInt(this.f1250r ? 1 : 0);
            parcel.writeInt(this.f1251s ? 1 : 0);
            parcel.writeInt(this.f1252t ? 1 : 0);
            parcel.writeList(this.f1249q);
        }

        public SavedState(Parcel parcel) {
            this.f1243c = parcel.readInt();
            this.f1244e = parcel.readInt();
            int i10 = parcel.readInt();
            this.f1245m = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f1246n = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f1247o = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f1248p = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1250r = parcel.readInt() == 1;
            this.f1251s = parcel.readInt() == 1;
            this.f1252t = parcel.readInt() == 1;
            this.f1249q = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1245m = savedState.f1245m;
            this.f1243c = savedState.f1243c;
            this.f1244e = savedState.f1244e;
            this.f1246n = savedState.f1246n;
            this.f1247o = savedState.f1247o;
            this.f1248p = savedState.f1248p;
            this.f1250r = savedState.f1250r;
            this.f1251s = savedState.f1251s;
            this.f1252t = savedState.f1252t;
            this.f1249q = savedState.f1249q;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.T1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f1259f;

        public b() {
            c();
        }

        public void a() {
            this.f1255b = this.f1256c ? StaggeredGridLayoutManager.this.f1231u.i() : StaggeredGridLayoutManager.this.f1231u.m();
        }

        public void b(int i10) {
            if (this.f1256c) {
                this.f1255b = StaggeredGridLayoutManager.this.f1231u.i() - i10;
            } else {
                this.f1255b = StaggeredGridLayoutManager.this.f1231u.m() + i10;
            }
        }

        public void c() {
            this.f1254a = -1;
            this.f1255b = Integer.MIN_VALUE;
            this.f1256c = false;
            this.f1257d = false;
            this.f1258e = false;
            int[] iArr = this.f1259f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f1259f;
            if (iArr == null || iArr.length < length) {
                this.f1259f = new int[StaggeredGridLayoutManager.this.f1230t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f1259f[i10] = dVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f1261e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1262f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f1262f;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f1263a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1264b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1265c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1266d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1267e;

        public d(int i10) {
            this.f1267e = i10;
        }

        public void a(View view) {
            c cVarN = n(view);
            cVarN.f1261e = this;
            this.f1263a.add(view);
            this.f1265c = Integer.MIN_VALUE;
            if (this.f1263a.size() == 1) {
                this.f1264b = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1266d += StaggeredGridLayoutManager.this.f1231u.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int iL = z10 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || iL >= StaggeredGridLayoutManager.this.f1231u.i()) {
                if (z10 || iL <= StaggeredGridLayoutManager.this.f1231u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        iL += i10;
                    }
                    this.f1265c = iL;
                    this.f1264b = iL;
                }
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList arrayList = this.f1263a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f1265c = StaggeredGridLayoutManager.this.f1231u.d(view);
            if (cVarN.f1262f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && fullSpanItemF.f1240e == 1) {
                this.f1265c += fullSpanItemF.a(this.f1267e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = (View) this.f1263a.get(0);
            c cVarN = n(view);
            this.f1264b = StaggeredGridLayoutManager.this.f1231u.g(view);
            if (cVarN.f1262f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && fullSpanItemF.f1240e == -1) {
                this.f1264b -= fullSpanItemF.a(this.f1267e);
            }
        }

        public void e() {
            this.f1263a.clear();
            q();
            this.f1266d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f1236z ? i(this.f1263a.size() - 1, -1, true) : i(0, this.f1263a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f1236z ? i(0, this.f1263a.size(), true) : i(this.f1263a.size() - 1, -1, true);
        }

        public int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int iM = StaggeredGridLayoutManager.this.f1231u.m();
            int i12 = StaggeredGridLayoutManager.this.f1231u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = (View) this.f1263a.get(i10);
                int iG = StaggeredGridLayoutManager.this.f1231u.g(view);
                int iD = StaggeredGridLayoutManager.this.f1231u.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? iG >= i12 : iG > i12;
                if (!z12 ? iD > iM : iD >= iM) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (z10 && z11) {
                        if (iG >= iM && iD <= i12) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                        if (iG < iM || iD > i12) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    }
                }
                i10 += i13;
            }
            return -1;
        }

        public int i(int i10, int i11, boolean z10) {
            return h(i10, i11, false, false, z10);
        }

        public int j() {
            return this.f1266d;
        }

        public int k() {
            int i10 = this.f1265c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f1265c;
        }

        public int l(int i10) {
            int i11 = this.f1265c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f1263a.size() == 0) {
                return i10;
            }
            c();
            return this.f1265c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f1263a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f1263a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1236z && staggeredGridLayoutManager.i0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1236z && staggeredGridLayoutManager2.i0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = this.f1263a.size();
            int i12 = 0;
            while (i12 < size2) {
                View view3 = (View) this.f1263a.get(i12);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.f1236z && staggeredGridLayoutManager3.i0(view3) <= i10) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.f1236z && staggeredGridLayoutManager4.i0(view3) >= i10) || !view3.hasFocusable()) {
                    break;
                }
                i12++;
                view = view3;
            }
            return view;
        }

        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        public int o() {
            int i10 = this.f1264b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f1264b;
        }

        public int p(int i10) {
            int i11 = this.f1264b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f1263a.size() == 0) {
                return i10;
            }
            d();
            return this.f1264b;
        }

        public void q() {
            this.f1264b = Integer.MIN_VALUE;
            this.f1265c = Integer.MIN_VALUE;
        }

        public void r(int i10) {
            int i11 = this.f1264b;
            if (i11 != Integer.MIN_VALUE) {
                this.f1264b = i11 + i10;
            }
            int i12 = this.f1265c;
            if (i12 != Integer.MIN_VALUE) {
                this.f1265c = i12 + i10;
            }
        }

        public void s() {
            int size = this.f1263a.size();
            View view = (View) this.f1263a.remove(size - 1);
            c cVarN = n(view);
            cVarN.f1261e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f1266d -= StaggeredGridLayoutManager.this.f1231u.e(view);
            }
            if (size == 1) {
                this.f1264b = Integer.MIN_VALUE;
            }
            this.f1265c = Integer.MIN_VALUE;
        }

        public void t() {
            View view = (View) this.f1263a.remove(0);
            c cVarN = n(view);
            cVarN.f1261e = null;
            if (this.f1263a.size() == 0) {
                this.f1265c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1266d -= StaggeredGridLayoutManager.this.f1231u.e(view);
            }
            this.f1264b = Integer.MIN_VALUE;
        }

        public void u(View view) {
            c cVarN = n(view);
            cVarN.f1261e = this;
            this.f1263a.add(0, view);
            this.f1264b = Integer.MIN_VALUE;
            if (this.f1263a.size() == 1) {
                this.f1265c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1266d += StaggeredGridLayoutManager.this.f1231u.e(view);
            }
        }

        public void v(int i10) {
            this.f1264b = i10;
            this.f1265c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d dVarJ0 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        I2(dVarJ0.f1191a);
        K2(dVarJ0.f1192b);
        J2(dVarJ0.f1193c);
        this.f1235y = new m();
        b2();
    }

    private void F2() {
        if (this.f1233w == 1 || !u2()) {
            this.A = this.f1236z;
        } else {
            this.A = !this.f1236z;
        }
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return t.a(a0Var, this.f1231u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return t.b(a0Var, this.f1231u, f2(!this.N), e2(!this.N), this, this.N, this.A);
    }

    private int X1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return t.c(a0Var, this.f1231u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int Y1(int i10) {
        if (i10 == 1) {
            return (this.f1233w != 1 && u2()) ? 1 : -1;
        }
        if (i10 == 2) {
            return (this.f1233w != 1 && u2()) ? -1 : 1;
        }
        if (i10 == 17) {
            return this.f1233w == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return this.f1233w == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 != 66) {
            return (i10 == 130 && this.f1233w == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1233w == 0 ? 1 : Integer.MIN_VALUE;
    }

    private void v2(View view, int i10, int i11, boolean z10) {
        k(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int iS2 = S2(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int iS3 = S2(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10 ? I1(view, iS2, iS3, cVar) : G1(view, iS2, iS3, cVar)) {
            view.measure(iS2, iS3);
        }
    }

    public final void A2(View view) {
        for (int i10 = this.f1229s - 1; i10 >= 0; i10--) {
            this.f1230t[i10].u(view);
        }
    }

    public final void B2(RecyclerView.v vVar, m mVar) {
        int iMin;
        if (!mVar.f1476a || mVar.f1484i) {
            return;
        }
        if (mVar.f1477b == 0) {
            if (mVar.f1480e == -1) {
                C2(vVar, mVar.f1482g);
                return;
            } else {
                D2(vVar, mVar.f1481f);
                return;
            }
        }
        if (mVar.f1480e == -1) {
            int i10 = mVar.f1481f;
            int iN2 = i10 - n2(i10);
            C2(vVar, iN2 < 0 ? mVar.f1482g : mVar.f1482g - Math.min(iN2, mVar.f1477b));
        } else {
            int iO2 = o2(mVar.f1482g) - mVar.f1482g;
            if (iO2 < 0) {
                iMin = mVar.f1481f;
            } else {
                iMin = Math.min(iO2, mVar.f1477b) + mVar.f1481f;
            }
            D2(vVar, iMin);
        }
    }

    public final void C2(RecyclerView.v vVar, int i10) {
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            if (this.f1231u.g(viewJ) < i10 || this.f1231u.q(viewJ) < i10) {
                return;
            }
            c cVar = (c) viewJ.getLayoutParams();
            if (cVar.f1262f) {
                for (int i11 = 0; i11 < this.f1229s; i11++) {
                    if (this.f1230t[i11].f1263a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f1229s; i12++) {
                    this.f1230t[i12].s();
                }
            } else if (cVar.f1261e.f1263a.size() == 1) {
                return;
            } else {
                cVar.f1261e.s();
            }
            n1(viewJ, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i10) {
        super.D0(i10);
        for (int i11 = 0; i11 < this.f1229s; i11++) {
            this.f1230t[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(Rect rect, int i10, int i11) {
        int iO;
        int iO2;
        int iF0 = f0() + g0();
        int iH0 = h0() + e0();
        if (this.f1233w == 1) {
            iO2 = RecyclerView.o.o(i11, rect.height() + iH0, c0());
            iO = RecyclerView.o.o(i10, (this.f1234x * this.f1229s) + iF0, d0());
        } else {
            iO = RecyclerView.o.o(i10, rect.width() + iF0, d0());
            iO2 = RecyclerView.o.o(i11, (this.f1234x * this.f1229s) + iH0, c0());
        }
        C1(iO, iO2);
    }

    public final void D2(RecyclerView.v vVar, int i10) {
        while (K() > 0) {
            View viewJ = J(0);
            if (this.f1231u.d(viewJ) > i10 || this.f1231u.p(viewJ) > i10) {
                return;
            }
            c cVar = (c) viewJ.getLayoutParams();
            if (cVar.f1262f) {
                for (int i11 = 0; i11 < this.f1229s; i11++) {
                    if (this.f1230t[i11].f1263a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f1229s; i12++) {
                    this.f1230t[i12].t();
                }
            } else if (cVar.f1261e.f1263a.size() == 1) {
                return;
            } else {
                cVar.f1261e.t();
            }
            n1(viewJ, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return this.f1233w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E0(int i10) {
        super.E0(i10);
        for (int i11 = 0; i11 < this.f1229s; i11++) {
            this.f1230t[i11].r(i10);
        }
    }

    public final void E2() {
        if (this.f1232v.k() == 1073741824) {
            return;
        }
        int iK = K();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < iK; i10++) {
            View viewJ = J(i10);
            float fE = this.f1232v.e(viewJ);
            if (fE >= fMax) {
                if (((c) viewJ.getLayoutParams()).e()) {
                    fE = (fE * 1.0f) / this.f1229s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i11 = this.f1234x;
        int iRound = Math.round(fMax * this.f1229s);
        if (this.f1232v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1232v.n());
        }
        Q2(iRound);
        if (this.f1234x == i11) {
            return;
        }
        for (int i12 = 0; i12 < iK; i12++) {
            View viewJ2 = J(i12);
            c cVar = (c) viewJ2.getLayoutParams();
            if (!cVar.f1262f) {
                if (u2() && this.f1233w == 1) {
                    int i13 = this.f1229s;
                    int i14 = cVar.f1261e.f1267e;
                    viewJ2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f1234x) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = cVar.f1261e.f1267e;
                    int i16 = this.f1234x * i15;
                    int i17 = i15 * i11;
                    if (this.f1233w == 1) {
                        viewJ2.offsetLeftAndRight(i16 - i17);
                    } else {
                        viewJ2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void F0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.E.b();
        for (int i10 = 0; i10 < this.f1229s; i10++) {
            this.f1230t[i10].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public int G2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        z2(i10, a0Var);
        int iC2 = c2(vVar, this.f1235y, a0Var);
        if (this.f1235y.f1477b >= iC2) {
            i10 = i10 < 0 ? -iC2 : iC2;
        }
        this.f1231u.r(-i10);
        this.G = this.A;
        m mVar = this.f1235y;
        mVar.f1477b = 0;
        B2(vVar, mVar);
        return i10;
    }

    public final void H2(int i10) {
        m mVar = this.f1235y;
        mVar.f1480e = i10;
        mVar.f1479d = this.A != (i10 == -1) ? -1 : 1;
    }

    public void I2(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        h(null);
        if (i10 == this.f1233w) {
            return;
        }
        this.f1233w = i10;
        q qVar = this.f1231u;
        this.f1231u = this.f1232v;
        this.f1232v = qVar;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        p1(this.P);
        for (int i10 = 0; i10 < this.f1229s; i10++) {
            this.f1230t[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        n nVar = new n(recyclerView.getContext());
        nVar.p(i10);
        K1(nVar);
    }

    public void J2(boolean z10) {
        h(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.f1250r != z10) {
            savedState.f1250r = z10;
        }
        this.f1236z = z10;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewC;
        View viewM;
        if (K() == 0 || (viewC = C(view)) == null) {
            return null;
        }
        F2();
        int iY1 = Y1(i10);
        if (iY1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewC.getLayoutParams();
        boolean z10 = cVar.f1262f;
        d dVar = cVar.f1261e;
        int iL2 = iY1 == 1 ? l2() : k2();
        P2(iL2, a0Var);
        H2(iY1);
        m mVar = this.f1235y;
        mVar.f1478c = mVar.f1479d + iL2;
        mVar.f1477b = (int) (this.f1231u.n() * 0.33333334f);
        m mVar2 = this.f1235y;
        mVar2.f1483h = true;
        mVar2.f1476a = false;
        c2(vVar, mVar2, a0Var);
        this.G = this.A;
        if (!z10 && (viewM = dVar.m(iL2, iY1)) != null && viewM != viewC) {
            return viewM;
        }
        if (y2(iY1)) {
            for (int i11 = this.f1229s - 1; i11 >= 0; i11--) {
                View viewM2 = this.f1230t[i11].m(iL2, iY1);
                if (viewM2 != null && viewM2 != viewC) {
                    return viewM2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f1229s; i12++) {
                View viewM3 = this.f1230t[i12].m(iL2, iY1);
                if (viewM3 != null && viewM3 != viewC) {
                    return viewM3;
                }
            }
        }
        boolean z11 = (this.f1236z ^ true) == (iY1 == -1);
        if (!z10) {
            View viewD = D(z11 ? dVar.f() : dVar.g());
            if (viewD != null && viewD != viewC) {
                return viewD;
            }
        }
        if (y2(iY1)) {
            for (int i13 = this.f1229s - 1; i13 >= 0; i13--) {
                if (i13 != dVar.f1267e) {
                    View viewD2 = D(z11 ? this.f1230t[i13].f() : this.f1230t[i13].g());
                    if (viewD2 != null && viewD2 != viewC) {
                        return viewD2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f1229s; i14++) {
                View viewD3 = D(z11 ? this.f1230t[i14].f() : this.f1230t[i14].g());
                if (viewD3 != null && viewD3 != viewC) {
                    return viewD3;
                }
            }
        }
        return null;
    }

    public void K2(int i10) {
        h(null);
        if (i10 != this.f1229s) {
            t2();
            this.f1229s = i10;
            this.B = new BitSet(this.f1229s);
            this.f1230t = new d[this.f1229s];
            for (int i11 = 0; i11 < this.f1229s; i11++) {
                this.f1230t[i11] = new d(i11);
            }
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            View viewF2 = f2(false);
            View viewE2 = e2(false);
            if (viewF2 == null || viewE2 == null) {
                return;
            }
            int iI0 = i0(viewF2);
            int iI1 = i0(viewE2);
            if (iI0 < iI1) {
                accessibilityEvent.setFromIndex(iI0);
                accessibilityEvent.setToIndex(iI1);
            } else {
                accessibilityEvent.setFromIndex(iI1);
                accessibilityEvent.setToIndex(iI0);
            }
        }
    }

    public final void L2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f1229s; i12++) {
            if (!this.f1230t[i12].f1263a.isEmpty()) {
                R2(this.f1230t[i12], i10, i11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.I == null;
    }

    public final boolean M2(RecyclerView.a0 a0Var, b bVar) {
        bVar.f1254a = this.G ? h2(a0Var.b()) : d2(a0Var.b());
        bVar.f1255b = Integer.MIN_VALUE;
        return true;
    }

    public final void N1(View view) {
        for (int i10 = this.f1229s - 1; i10 >= 0; i10--) {
            this.f1230t[i10].a(view);
        }
    }

    public boolean N2(RecyclerView.a0 a0Var, b bVar) {
        int i10;
        if (!a0Var.e() && (i10 = this.C) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f1243c == -1 || savedState.f1245m < 1) {
                    View viewD = D(this.C);
                    if (viewD != null) {
                        bVar.f1254a = this.A ? l2() : k2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1256c) {
                                bVar.f1255b = (this.f1231u.i() - this.D) - this.f1231u.d(viewD);
                            } else {
                                bVar.f1255b = (this.f1231u.m() + this.D) - this.f1231u.g(viewD);
                            }
                            return true;
                        }
                        if (this.f1231u.e(viewD) > this.f1231u.n()) {
                            bVar.f1255b = bVar.f1256c ? this.f1231u.i() : this.f1231u.m();
                            return true;
                        }
                        int iG = this.f1231u.g(viewD) - this.f1231u.m();
                        if (iG < 0) {
                            bVar.f1255b = -iG;
                            return true;
                        }
                        int i11 = this.f1231u.i() - this.f1231u.d(viewD);
                        if (i11 < 0) {
                            bVar.f1255b = i11;
                            return true;
                        }
                        bVar.f1255b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.C;
                        bVar.f1254a = i12;
                        int i13 = this.D;
                        if (i13 == Integer.MIN_VALUE) {
                            bVar.f1256c = S1(i12) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f1257d = true;
                    }
                } else {
                    bVar.f1255b = Integer.MIN_VALUE;
                    bVar.f1254a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void O1(b bVar) {
        SavedState savedState = this.I;
        int i10 = savedState.f1245m;
        if (i10 > 0) {
            if (i10 == this.f1229s) {
                for (int i11 = 0; i11 < this.f1229s; i11++) {
                    this.f1230t[i11].e();
                    SavedState savedState2 = this.I;
                    int i12 = savedState2.f1246n[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += savedState2.f1251s ? this.f1231u.i() : this.f1231u.m();
                    }
                    this.f1230t[i11].v(i12);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f1243c = savedState3.f1244e;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f1252t;
        J2(savedState4.f1250r);
        F2();
        SavedState savedState5 = this.I;
        int i13 = savedState5.f1243c;
        if (i13 != -1) {
            this.C = i13;
            bVar.f1256c = savedState5.f1251s;
        } else {
            bVar.f1256c = this.A;
        }
        if (savedState5.f1247o > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f1237a = savedState5.f1248p;
            lazySpanLookup.f1238b = savedState5.f1249q;
        }
    }

    public void O2(RecyclerView.a0 a0Var, b bVar) {
        if (N2(a0Var, bVar) || M2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f1254a = 0;
    }

    public boolean P1() {
        int iL = this.f1230t[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f1229s; i10++) {
            if (this.f1230t[i10].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    public final void P2(int i10, RecyclerView.a0 a0Var) {
        int iN;
        int iN2;
        int iC;
        m mVar = this.f1235y;
        boolean z10 = false;
        mVar.f1477b = 0;
        mVar.f1478c = i10;
        if (y0() && (iC = a0Var.c()) != -1) {
            if (this.A == (iC < i10)) {
                iN = this.f1231u.n();
            } else {
                iN2 = this.f1231u.n();
                iN = 0;
            }
            if (N()) {
                this.f1235y.f1481f = this.f1231u.m() - iN2;
                this.f1235y.f1482g = this.f1231u.i() + iN;
            } else {
                this.f1235y.f1482g = this.f1231u.h() + iN;
                this.f1235y.f1481f = -iN2;
            }
            m mVar2 = this.f1235y;
            mVar2.f1483h = false;
            mVar2.f1476a = true;
            if (this.f1231u.k() == 0 && this.f1231u.h() == 0) {
                z10 = true;
            }
            mVar2.f1484i = z10;
        }
        iN = 0;
        iN2 = 0;
        if (N()) {
            this.f1235y.f1481f = this.f1231u.m() - iN2;
            this.f1235y.f1482g = this.f1231u.i() + iN;
        } else {
            this.f1235y.f1482g = this.f1231u.h() + iN;
            this.f1235y.f1481f = -iN2;
        }
        m mVar3 = this.f1235y;
        mVar3.f1483h = false;
        mVar3.f1476a = true;
        if (this.f1231u.k() == 0) {
            z10 = true;
        }
        mVar3.f1484i = z10;
    }

    public boolean Q1() {
        int iP = this.f1230t[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f1229s; i10++) {
            if (this.f1230t[i10].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    public void Q2(int i10) {
        this.f1234x = i10 / this.f1229s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f1232v.k());
    }

    public final void R1(View view, c cVar, m mVar) {
        if (mVar.f1480e == 1) {
            if (cVar.f1262f) {
                N1(view);
                return;
            } else {
                cVar.f1261e.a(view);
                return;
            }
        }
        if (cVar.f1262f) {
            A2(view);
        } else {
            cVar.f1261e.u(view);
        }
    }

    public final void R2(d dVar, int i10, int i11) {
        int iJ = dVar.j();
        if (i10 == -1) {
            if (dVar.o() + iJ <= i11) {
                this.B.set(dVar.f1267e, false);
            }
        } else if (dVar.k() - iJ >= i11) {
            this.B.set(dVar.f1267e, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i10, int i11) {
        r2(i10, i11, 1);
    }

    public final int S1(int i10) {
        if (K() == 0) {
            return this.A ? 1 : -1;
        }
        return (i10 < k2()) != this.A ? -1 : 1;
    }

    public final int S2(int i10, int i11, int i12) {
        int mode;
        return (!(i11 == 0 && i12 == 0) && ((mode = View.MeasureSpec.getMode(i10)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView) {
        this.E.b();
        u1();
    }

    public boolean T1() {
        int iK2;
        int iL2;
        if (K() == 0 || this.F == 0 || !s0()) {
            return false;
        }
        if (this.A) {
            iK2 = l2();
            iL2 = k2();
        } else {
            iK2 = k2();
            iL2 = l2();
        }
        if (iK2 == 0 && s2() != null) {
            this.E.b();
            v1();
            u1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i10 = this.A ? -1 : 1;
        int i11 = iL2 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.E.e(iK2, i11, i10, true);
        if (fullSpanItemE == null) {
            this.M = false;
            this.E.d(i11);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.E.e(iK2, fullSpanItemE.f1239c, i10 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.E.d(fullSpanItemE.f1239c);
        } else {
            this.E.d(fullSpanItemE2.f1239c + 1);
        }
        v1();
        u1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        r2(i10, i11, 8);
    }

    public final boolean U1(d dVar) {
        boolean z10;
        if (!this.A) {
            if (dVar.o() > this.f1231u.m()) {
                z10 = dVar.n((View) dVar.f1263a.get(0)).f1262f;
                return !z10;
            }
            return false;
        }
        if (dVar.k() < this.f1231u.i()) {
            ArrayList arrayList = dVar.f1263a;
            z10 = dVar.n((View) arrayList.get(arrayList.size() - 1)).f1262f;
            return !z10;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i10, int i11) {
        r2(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        r2(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        x2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.a0 a0Var) {
        super.Z0(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public final LazySpanLookup.FullSpanItem Z1(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1241m = new int[this.f1229s];
        for (int i11 = 0; i11 < this.f1229s; i11++) {
            fullSpanItem.f1241m[i11] = i10 - this.f1230t[i11].l(i10);
        }
        return fullSpanItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i10) {
        int iS1 = S1(i10);
        PointF pointF = new PointF();
        if (iS1 == 0) {
            return null;
        }
        if (this.f1233w == 0) {
            pointF.x = iS1;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = iS1;
        return pointF;
    }

    public final LazySpanLookup.FullSpanItem a2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1241m = new int[this.f1229s];
        for (int i11 = 0; i11 < this.f1229s; i11++) {
            fullSpanItem.f1241m[i11] = this.f1230t[i11].p(i10) - i10;
        }
        return fullSpanItem;
    }

    public final void b2() {
        this.f1231u = q.b(this, this.f1233w);
        this.f1232v = q.b(this, 1 - this.f1233w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    public final int c2(RecyclerView.v vVar, m mVar, RecyclerView.a0 a0Var) {
        int i10;
        int iM2;
        d dVarQ2;
        int iP2;
        int iE;
        int iM;
        int iE2;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this;
        ?? r10 = 0;
        staggeredGridLayoutManager2.B.set(0, staggeredGridLayoutManager2.f1229s, true);
        if (staggeredGridLayoutManager2.f1235y.f1484i) {
            i10 = mVar.f1480e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i10 = mVar.f1480e == 1 ? mVar.f1482g + mVar.f1477b : mVar.f1481f - mVar.f1477b;
        }
        staggeredGridLayoutManager2.L2(mVar.f1480e, i10);
        int i11 = staggeredGridLayoutManager2.A ? staggeredGridLayoutManager2.f1231u.i() : staggeredGridLayoutManager2.f1231u.m();
        boolean z10 = false;
        StaggeredGridLayoutManager staggeredGridLayoutManager3 = staggeredGridLayoutManager2;
        while (mVar.a(a0Var) && (staggeredGridLayoutManager3.f1235y.f1484i || !staggeredGridLayoutManager3.B.isEmpty())) {
            View viewB = mVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = staggeredGridLayoutManager3.E.g(iA);
            boolean z11 = iG == -1;
            if (z11) {
                dVarQ2 = cVar.f1262f ? staggeredGridLayoutManager3.f1230t[r10] : staggeredGridLayoutManager3.q2(mVar);
                staggeredGridLayoutManager3.E.n(iA, dVarQ2);
            } else {
                dVarQ2 = staggeredGridLayoutManager3.f1230t[iG];
            }
            d dVar = dVarQ2;
            cVar.f1261e = dVar;
            if (mVar.f1480e == 1) {
                staggeredGridLayoutManager3.e(viewB);
            } else {
                staggeredGridLayoutManager3.f(viewB, r10);
            }
            staggeredGridLayoutManager3.w2(viewB, cVar, r10);
            if (mVar.f1480e == 1) {
                iE = cVar.f1262f ? staggeredGridLayoutManager3.m2(i11) : dVar.l(i11);
                iP2 = staggeredGridLayoutManager3.f1231u.e(viewB) + iE;
                if (z11 && cVar.f1262f) {
                    LazySpanLookup.FullSpanItem fullSpanItemZ1 = staggeredGridLayoutManager3.Z1(iE);
                    fullSpanItemZ1.f1240e = -1;
                    fullSpanItemZ1.f1239c = iA;
                    staggeredGridLayoutManager3.E.a(fullSpanItemZ1);
                }
            } else {
                iP2 = cVar.f1262f ? staggeredGridLayoutManager3.p2(i11) : dVar.p(i11);
                iE = iP2 - staggeredGridLayoutManager3.f1231u.e(viewB);
                if (z11 && cVar.f1262f) {
                    LazySpanLookup.FullSpanItem fullSpanItemA2 = staggeredGridLayoutManager3.a2(iP2);
                    fullSpanItemA2.f1240e = 1;
                    fullSpanItemA2.f1239c = iA;
                    staggeredGridLayoutManager3.E.a(fullSpanItemA2);
                }
            }
            if (cVar.f1262f && mVar.f1479d == -1) {
                if (z11) {
                    staggeredGridLayoutManager3.M = true;
                } else {
                    if (!(mVar.f1480e == 1 ? staggeredGridLayoutManager3.P1() : staggeredGridLayoutManager3.Q1())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = staggeredGridLayoutManager3.E.f(iA);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f1242n = true;
                        }
                        staggeredGridLayoutManager3.M = true;
                    }
                }
            }
            staggeredGridLayoutManager3.R1(viewB, cVar, mVar);
            if (staggeredGridLayoutManager3.u2() && staggeredGridLayoutManager3.f1233w == 1) {
                iE2 = cVar.f1262f ? staggeredGridLayoutManager3.f1232v.i() : staggeredGridLayoutManager3.f1232v.i() - (((staggeredGridLayoutManager3.f1229s - 1) - dVar.f1267e) * staggeredGridLayoutManager3.f1234x);
                iM = iE2 - staggeredGridLayoutManager3.f1232v.e(viewB);
            } else {
                iM = cVar.f1262f ? staggeredGridLayoutManager3.f1232v.m() : (dVar.f1267e * staggeredGridLayoutManager3.f1234x) + staggeredGridLayoutManager3.f1232v.m();
                iE2 = staggeredGridLayoutManager3.f1232v.e(viewB) + iM;
            }
            int i12 = iE2;
            int i13 = iM;
            if (staggeredGridLayoutManager3.f1233w == 1) {
                staggeredGridLayoutManager3.A0(viewB, i13, iE, i12, iP2);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager3.A0(viewB, iE, i13, iP2, i12);
                staggeredGridLayoutManager = staggeredGridLayoutManager3;
            }
            if (cVar.f1262f) {
                staggeredGridLayoutManager.L2(staggeredGridLayoutManager.f1235y.f1480e, i10);
            } else {
                staggeredGridLayoutManager.R2(dVar, staggeredGridLayoutManager.f1235y.f1480e, i10);
            }
            staggeredGridLayoutManager.B2(vVar, staggeredGridLayoutManager.f1235y);
            if (staggeredGridLayoutManager.f1235y.f1483h && viewB.hasFocusable()) {
                if (cVar.f1262f) {
                    staggeredGridLayoutManager.B.clear();
                } else {
                    staggeredGridLayoutManager.B.set(dVar.f1267e, false);
                }
            }
            z10 = true;
            r10 = 0;
            staggeredGridLayoutManager3 = staggeredGridLayoutManager;
        }
        if (!z10) {
            staggeredGridLayoutManager3.B2(vVar, staggeredGridLayoutManager3.f1235y);
        }
        if (staggeredGridLayoutManager3.f1235y.f1480e == -1) {
            iM2 = staggeredGridLayoutManager3.f1231u.m() - staggeredGridLayoutManager3.p2(staggeredGridLayoutManager3.f1231u.m());
        } else {
            iM2 = staggeredGridLayoutManager3.m2(staggeredGridLayoutManager3.f1231u.i()) - staggeredGridLayoutManager3.f1231u.i();
        }
        if (iM2 > 0) {
            return Math.min(mVar.f1477b, iM2);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.b();
            }
            u1();
        }
    }

    public final int d2(int i10) {
        int iK = K();
        for (int i11 = 0; i11 < iK; i11++) {
            int iI0 = i0(J(i11));
            if (iI0 >= 0 && iI0 < i10) {
                return iI0;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable e1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f1250r = this.f1236z;
        savedState.f1251s = this.G;
        savedState.f1252t = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f1237a) == null) {
            savedState.f1247o = 0;
        } else {
            savedState.f1248p = iArr;
            savedState.f1247o = iArr.length;
            savedState.f1249q = lazySpanLookup.f1238b;
        }
        if (K() <= 0) {
            savedState.f1243c = -1;
            savedState.f1244e = -1;
            savedState.f1245m = 0;
            return savedState;
        }
        savedState.f1243c = this.G ? l2() : k2();
        savedState.f1244e = g2();
        int i10 = this.f1229s;
        savedState.f1245m = i10;
        savedState.f1246n = new int[i10];
        for (int i11 = 0; i11 < this.f1229s; i11++) {
            if (this.G) {
                iP = this.f1230t[i11].l(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.f1231u.i();
                    iP -= iM;
                }
            } else {
                iP = this.f1230t[i11].p(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.f1231u.m();
                    iP -= iM;
                }
            }
            savedState.f1246n[i11] = iP;
        }
        return savedState;
    }

    public View e2(boolean z10) {
        int iM = this.f1231u.m();
        int i10 = this.f1231u.i();
        View view = null;
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            int iG = this.f1231u.g(viewJ);
            int iD = this.f1231u.d(viewJ);
            if (iD > iM && iG < i10) {
                if (iD <= i10 || !z10) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f1(int i10) {
        if (i10 == 0) {
            T1();
        }
    }

    public View f2(boolean z10) {
        int iM = this.f1231u.m();
        int i10 = this.f1231u.i();
        int iK = K();
        View view = null;
        for (int i11 = 0; i11 < iK; i11++) {
            View viewJ = J(i11);
            int iG = this.f1231u.g(viewJ);
            if (this.f1231u.d(viewJ) > iM && iG < i10) {
                if (iG >= iM || !z10) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    public int g2() {
        View viewE2 = this.A ? e2(true) : f2(true);
        if (viewE2 == null) {
            return -1;
        }
        return i0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(String str) {
        if (this.I == null) {
            super.h(str);
        }
    }

    public final int h2(int i10) {
        for (int iK = K() - 1; iK >= 0; iK--) {
            int iI0 = i0(J(iK));
            if (iI0 >= 0 && iI0 < i10) {
                return iI0;
            }
        }
        return 0;
    }

    public final void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10;
        int iM2 = m2(Integer.MIN_VALUE);
        if (iM2 != Integer.MIN_VALUE && (i10 = this.f1231u.i() - iM2) > 0) {
            int i11 = i10 - (-G2(-i10, vVar, a0Var));
            if (!z10 || i11 <= 0) {
                return;
            }
            this.f1231u.r(i11);
        }
    }

    public final void j2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int iM;
        int iP2 = p2(Integer.MAX_VALUE);
        if (iP2 != Integer.MAX_VALUE && (iM = iP2 - this.f1231u.m()) > 0) {
            int iG2 = iM - G2(iM, vVar, a0Var);
            if (!z10 || iG2 <= 0) {
                return;
            }
            this.f1231u.r(-iG2);
        }
    }

    public int k2() {
        if (K() == 0) {
            return 0;
        }
        return i0(J(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1233w == 0;
    }

    public int l2() {
        int iK = K();
        if (iK == 0) {
            return 0;
        }
        return i0(J(iK - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m() {
        return this.f1233w == 1;
    }

    public final int m2(int i10) {
        int iL = this.f1230t[0].l(i10);
        for (int i11 = 1; i11 < this.f1229s; i11++) {
            int iL2 = this.f1230t[i11].l(i10);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public final int n2(int i10) {
        int iP = this.f1230t[0].p(i10);
        for (int i11 = 1; i11 < this.f1229s; i11++) {
            int iP2 = this.f1230t[i11].p(i10);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final int o2(int i10) {
        int iL = this.f1230t[0].l(i10);
        for (int i11 = 1; i11 < this.f1229s; i11++) {
            int iL2 = this.f1230t[i11].l(i10);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f1233w != 0) {
            i10 = i11;
        }
        if (K() == 0 || i10 == 0) {
            return;
        }
        z2(i10, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f1229s) {
            this.O = new int[this.f1229s];
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f1229s; i13++) {
            m mVar = this.f1235y;
            if (mVar.f1479d == -1) {
                iL = mVar.f1481f;
                iP = this.f1230t[i13].p(iL);
            } else {
                iL = this.f1230t[i13].l(mVar.f1482g);
                iP = this.f1235y.f1482g;
            }
            int i14 = iL - iP;
            if (i14 >= 0) {
                this.O[i12] = i14;
                i12++;
            }
        }
        Arrays.sort(this.O, 0, i12);
        for (int i15 = 0; i15 < i12 && this.f1235y.a(a0Var); i15++) {
            cVar.a(this.f1235y.f1478c, this.O[i15]);
            m mVar2 = this.f1235y;
            mVar2.f1478c += mVar2.f1479d;
        }
    }

    public final int p2(int i10) {
        int iP = this.f1230t[0].p(i10);
        for (int i11 = 1; i11 < this.f1229s; i11++) {
            int iP2 = this.f1230t[i11].p(i10);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final d q2(m mVar) {
        int i10;
        int i11;
        int i12;
        if (y2(mVar.f1480e)) {
            i11 = this.f1229s - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = this.f1229s;
            i11 = 0;
            i12 = 1;
        }
        d dVar = null;
        if (mVar.f1480e == 1) {
            int iM = this.f1231u.m();
            int i13 = Integer.MAX_VALUE;
            while (i11 != i10) {
                d dVar2 = this.f1230t[i11];
                int iL = dVar2.l(iM);
                if (iL < i13) {
                    dVar = dVar2;
                    i13 = iL;
                }
                i11 += i12;
            }
            return dVar;
        }
        int i14 = this.f1231u.i();
        int i15 = Integer.MIN_VALUE;
        while (i11 != i10) {
            d dVar3 = this.f1230t[i11];
            int iP = dVar3.p(i14);
            if (iP > i15) {
                dVar = dVar3;
                i15 = iP;
            }
            i11 += i12;
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    public final void r2(int i10, int i11, int i12) {
        int i13;
        int i14;
        int iL2;
        int iL3 = this.A ? l2() : k2();
        if (i12 == 8) {
            if (i10 < i11) {
                i13 = i11 + 1;
            } else {
                i13 = i10 + 1;
                i14 = i11;
            }
            this.E.h(i14);
            if (i12 != 1) {
                this.E.j(i10, i11);
            } else if (i12 != 2) {
                this.E.k(i10, i11);
            } else if (i12 == 8) {
                this.E.k(i10, 1);
                this.E.j(i11, 1);
            }
            if (i13 <= iL3) {
                return;
            }
            if (this.A) {
                iL2 = k2();
            } else {
                iL2 = l2();
            }
            if (i14 <= iL2) {
                u1();
            }
        }
        i13 = i10 + i11;
        i14 = i10;
        this.E.h(i14);
        if (i12 != 1) {
            this.E.j(i10, i11);
        } else if (i12 != 2) {
            this.E.k(i10, i11);
        } else if (i12 == 8) {
            this.E.k(i10, 1);
            this.E.j(i11, 1);
        }
        if (i13 <= iL3) {
            return;
        }
        if (this.A) {
            iL2 = k2();
        } else {
            iL2 = l2();
        }
        if (i14 <= iL2) {
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x0099  */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:43:0x009e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
    public View s2() {
        int i10;
        View viewJ;
        int iG;
        int iG2;
        boolean z10;
        boolean z11;
        int iD;
        int iD2;
        int iK = K();
        int i11 = iK - 1;
        BitSet bitSet = new BitSet(this.f1229s);
        bitSet.set(0, this.f1229s, true);
        byte b10 = (this.f1233w == 1 && u2()) ? (byte) 1 : (byte) -1;
        if (this.A) {
            iK = -1;
        } else {
            i11 = 0;
        }
        int i12 = i11 < iK ? 1 : -1;
        while (i11 != iK) {
            View viewJ2 = J(i11);
            c cVar = (c) viewJ2.getLayoutParams();
            if (!bitSet.get(cVar.f1261e.f1267e)) {
                if (!cVar.f1262f && (i10 = i11 + i12) != iK) {
                    viewJ = J(i10);
                    if (this.A) {
                        iD = this.f1231u.d(viewJ2);
                        iD2 = this.f1231u.d(viewJ);
                        if (iD >= iD2) {
                            if (iD == iD2) {
                                if (cVar.f1261e.f1267e - ((c) viewJ.getLayoutParams()).f1261e.f1267e < 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (b10 < 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z10 != z11) {
                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        iG = this.f1231u.g(viewJ2);
                        iG2 = this.f1231u.g(viewJ);
                        if (iG <= iG2) {
                            if (iG == iG2) {
                                if (cVar.f1261e.f1267e - ((c) viewJ.getLayoutParams()).f1261e.f1267e < 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (b10 < 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z10 != z11) {
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i11 += i12;
            } else if (!U1(cVar.f1261e)) {
                bitSet.clear(cVar.f1261e.f1267e);
                if (!cVar.f1262f) {
                    viewJ = J(i10);
                    if (this.A) {
                        iD = this.f1231u.d(viewJ2);
                        iD2 = this.f1231u.d(viewJ);
                        if (iD >= iD2) {
                            if (iD == iD2) {
                                if (cVar.f1261e.f1267e - ((c) viewJ.getLayoutParams()).f1261e.f1267e < 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (b10 < 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z10 != z11) {
                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        iG = this.f1231u.g(viewJ2);
                        iG2 = this.f1231u.g(viewJ);
                        if (iG <= iG2) {
                            if (iG == iG2) {
                                if (cVar.f1261e.f1267e - ((c) viewJ.getLayoutParams()).f1261e.f1267e < 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (b10 < 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z10 != z11) {
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i11 += i12;
            }
            return viewJ2;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return X1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean t0() {
        return this.F != 0;
    }

    public void t2() {
        this.E.b();
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    public boolean u2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.a0 a0Var) {
        return X1(a0Var);
    }

    public final void w2(View view, c cVar, boolean z10) {
        if (cVar.f1262f) {
            if (this.f1233w == 1) {
                v2(view, this.J, RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
                return;
            } else {
                v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z10);
                return;
            }
        }
        if (this.f1233w == 1) {
            v2(view, RecyclerView.o.L(this.f1234x, q0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
        } else {
            v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.L(this.f1234x, Y(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return G2(i10, vVar, a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0155  */
    public final void x2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        boolean z11;
        SavedState savedState;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && a0Var.b() == 0) {
            l1(vVar);
            bVar.c();
            return;
        }
        boolean z12 = (bVar.f1258e && this.C == -1 && this.I == null) ? false : true;
        if (z12) {
            bVar.c();
            if (this.I != null) {
                O1(bVar);
            } else {
                F2();
                bVar.f1256c = this.A;
            }
            O2(a0Var, bVar);
            bVar.f1258e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.f1256c != this.G || u2() != this.H)) {
            this.E.b();
            bVar.f1257d = true;
        }
        if (K() > 0 && ((savedState = this.I) == null || savedState.f1245m < 1)) {
            if (bVar.f1257d) {
                for (int i10 = 0; i10 < this.f1229s; i10++) {
                    this.f1230t[i10].e();
                    int i11 = bVar.f1255b;
                    if (i11 != Integer.MIN_VALUE) {
                        this.f1230t[i10].v(i11);
                    }
                }
            } else if (z12 || this.L.f1259f == null) {
                for (int i12 = 0; i12 < this.f1229s; i12++) {
                    this.f1230t[i12].b(this.A, bVar.f1255b);
                }
                this.L.d(this.f1230t);
            } else {
                for (int i13 = 0; i13 < this.f1229s; i13++) {
                    d dVar = this.f1230t[i13];
                    dVar.e();
                    dVar.v(this.L.f1259f[i13]);
                }
            }
        }
        x(vVar);
        this.f1235y.f1476a = false;
        this.M = false;
        Q2(this.f1232v.n());
        P2(bVar.f1254a, a0Var);
        if (bVar.f1256c) {
            H2(-1);
            c2(vVar, this.f1235y, a0Var);
            H2(1);
            m mVar = this.f1235y;
            mVar.f1478c = bVar.f1254a + mVar.f1479d;
            c2(vVar, mVar, a0Var);
        } else {
            H2(1);
            c2(vVar, this.f1235y, a0Var);
            H2(-1);
            m mVar2 = this.f1235y;
            mVar2.f1478c = bVar.f1254a + mVar2.f1479d;
            c2(vVar, mVar2, a0Var);
        }
        E2();
        if (K() > 0) {
            if (this.A) {
                i2(vVar, a0Var, true);
                j2(vVar, a0Var, false);
            } else {
                j2(vVar, a0Var, true);
                i2(vVar, a0Var, false);
            }
        }
        if (z10 && !a0Var.e() && this.F != 0 && K() > 0 && (this.M || s2() != null)) {
            p1(this.P);
            z11 = T1();
        }
        if (a0Var.e()) {
            this.L.c();
        }
        this.G = bVar.f1256c;
        this.H = u2();
        if (z11) {
            this.L.c();
            x2(vVar, a0Var, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y1(int i10) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.f1243c != i10) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        u1();
    }

    public final boolean y2(int i10) {
        if (this.f1233w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == u2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return G2(i10, vVar, a0Var);
    }

    public void z2(int i10, RecyclerView.a0 a0Var) {
        int iK2;
        int i11;
        if (i10 > 0) {
            iK2 = l2();
            i11 = 1;
        } else {
            iK2 = k2();
            i11 = -1;
        }
        this.f1235y.f1476a = true;
        P2(iK2, a0Var);
        H2(i11);
        m mVar = this.f1235y;
        mVar.f1478c = iK2 + mVar.f1479d;
        mVar.f1477b = Math.abs(i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class LazySpanLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f1237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f1238b;

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1238b == null) {
                this.f1238b = new ArrayList();
            }
            int size = this.f1238b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1238b.get(i10);
                if (fullSpanItem2.f1239c == fullSpanItem.f1239c) {
                    this.f1238b.remove(i10);
                }
                if (fullSpanItem2.f1239c >= fullSpanItem.f1239c) {
                    this.f1238b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f1238b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f1237a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1238b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f1237a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f1237a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f1237a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1237a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List list = this.f1238b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1238b.get(size)).f1239c >= i10) {
                        this.f1238b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List list = this.f1238b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1238b.get(i13);
                int i14 = fullSpanItem.f1239c;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f1240e == i12 || (z10 && fullSpanItem.f1242n))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List list = this.f1238b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1238b.get(size);
                if (fullSpanItem.f1239c == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f1237a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int h(int i10) {
            int[] iArr = this.f1237a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f1237a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f1237a.length;
            }
            int iMin = Math.min(i11 + 1, this.f1237a.length);
            Arrays.fill(this.f1237a, i10, iMin, -1);
            return iMin;
        }

        public final int i(int i10) {
            if (this.f1238b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i10);
            if (fullSpanItemF != null) {
                this.f1238b.remove(fullSpanItemF);
            }
            int size = this.f1238b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (((FullSpanItem) this.f1238b.get(i11)).f1239c >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = (FullSpanItem) this.f1238b.get(i11);
            this.f1238b.remove(i11);
            return fullSpanItem.f1239c;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f1237a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f1237a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f1237a, i10, i12, -1);
            l(i10, i11);
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f1237a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f1237a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f1237a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m(i10, i11);
        }

        public final void l(int i10, int i11) {
            List list = this.f1238b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1238b.get(size);
                int i12 = fullSpanItem.f1239c;
                if (i12 >= i10) {
                    fullSpanItem.f1239c = i12 + i11;
                }
            }
        }

        public final void m(int i10, int i11) {
            List list = this.f1238b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1238b.get(size);
                int i13 = fullSpanItem.f1239c;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f1238b.remove(size);
                    } else {
                        fullSpanItem.f1239c = i13 - i11;
                    }
                }
            }
        }

        public void n(int i10, d dVar) {
            c(i10);
            this.f1237a[i10] = dVar.f1267e;
        }

        public int o(int i10) {
            int length = this.f1237a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1239c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f1240e;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int[] f1241m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public boolean f1242n;

            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f1239c = parcel.readInt();
                this.f1240e = parcel.readInt();
                this.f1242n = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f1241m = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f1241m;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1239c + ", mGapDir=" + this.f1240e + ", mHasUnwantedGapAfter=" + this.f1242n + ", mGapPerSpan=" + Arrays.toString(this.f1241m) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f1239c);
                parcel.writeInt(this.f1240e);
                parcel.writeInt(this.f1242n ? 1 : 0);
                int[] iArr = this.f1241m;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1241m);
                }
            }

            public FullSpanItem() {
            }
        }
    }
}
