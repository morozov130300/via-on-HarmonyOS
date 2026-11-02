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
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public BitSet B;
    public boolean G;
    public boolean H;
    public SavedState I;
    public int J;
    public int[] O;

    /* renamed from: t, reason: collision with root package name */
    public d[] f1329t;

    /* renamed from: u, reason: collision with root package name */
    public q f1330u;

    /* renamed from: v, reason: collision with root package name */
    public q f1331v;

    /* renamed from: w, reason: collision with root package name */
    public int f1332w;

    /* renamed from: x, reason: collision with root package name */
    public int f1333x;

    /* renamed from: y, reason: collision with root package name */
    public final m f1334y;

    /* renamed from: s, reason: collision with root package name */
    public int f1328s = -1;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1335z = false;
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        public int[] f1336a;

        /* renamed from: b, reason: collision with root package name */
        public List f1337b;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: e, reason: collision with root package name */
            public int f1338e;

            /* renamed from: j, reason: collision with root package name */
            public int f1339j;

            /* renamed from: k, reason: collision with root package name */
            public int[] f1340k;

            /* renamed from: l, reason: collision with root package name */
            public boolean f1341l;

            /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
            public class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel parcel) {
                this.f1338e = parcel.readInt();
                this.f1339j = parcel.readInt();
                this.f1341l = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f1340k = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f1340k;
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
                return "FullSpanItem{mPosition=" + this.f1338e + ", mGapDir=" + this.f1339j + ", mHasUnwantedGapAfter=" + this.f1341l + ", mGapPerSpan=" + Arrays.toString(this.f1340k) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f1338e);
                parcel.writeInt(this.f1339j);
                parcel.writeInt(this.f1341l ? 1 : 0);
                int[] iArr = this.f1340k;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1340k);
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1337b == null) {
                this.f1337b = new ArrayList();
            }
            int size = this.f1337b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1337b.get(i10);
                if (fullSpanItem2.f1338e == fullSpanItem.f1338e) {
                    this.f1337b.remove(i10);
                }
                if (fullSpanItem2.f1338e >= fullSpanItem.f1338e) {
                    this.f1337b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f1337b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f1336a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1337b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f1336a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f1336a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f1336a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1336a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List list = this.f1337b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1337b.get(size)).f1338e >= i10) {
                        this.f1337b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List list = this.f1337b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1337b.get(i13);
                int i14 = fullSpanItem.f1338e;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f1339j == i12 || (z10 && fullSpanItem.f1341l))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List list = this.f1337b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1337b.get(size);
                if (fullSpanItem.f1338e == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f1336a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int h(int i10) {
            int[] iArr = this.f1336a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f1336a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f1336a.length;
            }
            int iMin = Math.min(i11 + 1, this.f1336a.length);
            Arrays.fill(this.f1336a, i10, iMin, -1);
            return iMin;
        }

        public final int i(int i10) {
            if (this.f1337b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i10);
            if (fullSpanItemF != null) {
                this.f1337b.remove(fullSpanItemF);
            }
            int size = this.f1337b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (((FullSpanItem) this.f1337b.get(i11)).f1338e >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = (FullSpanItem) this.f1337b.get(i11);
            this.f1337b.remove(i11);
            return fullSpanItem.f1338e;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f1336a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f1336a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f1336a, i10, i12, -1);
            l(i10, i11);
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f1336a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f1336a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f1336a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m(i10, i11);
        }

        public final void l(int i10, int i11) {
            List list = this.f1337b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1337b.get(size);
                int i12 = fullSpanItem.f1338e;
                if (i12 >= i10) {
                    fullSpanItem.f1338e = i12 + i11;
                }
            }
        }

        public final void m(int i10, int i11) {
            List list = this.f1337b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1337b.get(size);
                int i13 = fullSpanItem.f1338e;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f1337b.remove(size);
                    } else {
                        fullSpanItem.f1338e = i13 - i11;
                    }
                }
            }
        }

        public void n(int i10, d dVar) {
            c(i10);
            this.f1336a[i10] = dVar.f1366e;
        }

        public int o(int i10) {
            int length = this.f1336a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f1342e;

        /* renamed from: j, reason: collision with root package name */
        public int f1343j;

        /* renamed from: k, reason: collision with root package name */
        public int f1344k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f1345l;

        /* renamed from: m, reason: collision with root package name */
        public int f1346m;

        /* renamed from: n, reason: collision with root package name */
        public int[] f1347n;

        /* renamed from: o, reason: collision with root package name */
        public List f1348o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f1349p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f1350q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f1351r;

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
            this.f1342e = parcel.readInt();
            this.f1343j = parcel.readInt();
            int i10 = parcel.readInt();
            this.f1344k = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f1345l = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f1346m = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f1347n = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1349p = parcel.readInt() == 1;
            this.f1350q = parcel.readInt() == 1;
            this.f1351r = parcel.readInt() == 1;
            this.f1348o = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1344k = savedState.f1344k;
            this.f1342e = savedState.f1342e;
            this.f1343j = savedState.f1343j;
            this.f1345l = savedState.f1345l;
            this.f1346m = savedState.f1346m;
            this.f1347n = savedState.f1347n;
            this.f1349p = savedState.f1349p;
            this.f1350q = savedState.f1350q;
            this.f1351r = savedState.f1351r;
            this.f1348o = savedState.f1348o;
        }

        public void a() {
            this.f1345l = null;
            this.f1344k = 0;
            this.f1342e = -1;
            this.f1343j = -1;
        }

        public void b() {
            this.f1345l = null;
            this.f1344k = 0;
            this.f1346m = 0;
            this.f1347n = null;
            this.f1348o = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1342e);
            parcel.writeInt(this.f1343j);
            parcel.writeInt(this.f1344k);
            if (this.f1344k > 0) {
                parcel.writeIntArray(this.f1345l);
            }
            parcel.writeInt(this.f1346m);
            if (this.f1346m > 0) {
                parcel.writeIntArray(this.f1347n);
            }
            parcel.writeInt(this.f1349p ? 1 : 0);
            parcel.writeInt(this.f1350q ? 1 : 0);
            parcel.writeInt(this.f1351r ? 1 : 0);
            parcel.writeList(this.f1348o);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.T1();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1353a;

        /* renamed from: b, reason: collision with root package name */
        public int f1354b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1355c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1356d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1357e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f1358f;

        public b() {
            c();
        }

        public void a() {
            this.f1354b = this.f1355c ? StaggeredGridLayoutManager.this.f1330u.i() : StaggeredGridLayoutManager.this.f1330u.m();
        }

        public void b(int i10) {
            if (this.f1355c) {
                this.f1354b = StaggeredGridLayoutManager.this.f1330u.i() - i10;
            } else {
                this.f1354b = StaggeredGridLayoutManager.this.f1330u.m() + i10;
            }
        }

        public void c() {
            this.f1353a = -1;
            this.f1354b = Integer.MIN_VALUE;
            this.f1355c = false;
            this.f1356d = false;
            this.f1357e = false;
            int[] iArr = this.f1358f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f1358f;
            if (iArr == null || iArr.length < length) {
                this.f1358f = new int[StaggeredGridLayoutManager.this.f1329t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f1358f[i10] = dVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        public d f1360e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1361f;

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean e() {
            return this.f1361f;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f1362a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public int f1363b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f1364c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f1365d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f1366e;

        public d(int i10) {
            this.f1366e = i10;
        }

        public void a(View view) {
            c cVarN = n(view);
            cVarN.f1360e = this;
            this.f1362a.add(view);
            this.f1364c = Integer.MIN_VALUE;
            if (this.f1362a.size() == 1) {
                this.f1363b = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1365d += StaggeredGridLayoutManager.this.f1330u.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int iL = z10 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || iL >= StaggeredGridLayoutManager.this.f1330u.i()) {
                if (z10 || iL <= StaggeredGridLayoutManager.this.f1330u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        iL += i10;
                    }
                    this.f1364c = iL;
                    this.f1363b = iL;
                }
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList arrayList = this.f1362a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f1364c = StaggeredGridLayoutManager.this.f1330u.d(view);
            if (cVarN.f1361f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && fullSpanItemF.f1339j == 1) {
                this.f1364c += fullSpanItemF.a(this.f1366e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = (View) this.f1362a.get(0);
            c cVarN = n(view);
            this.f1363b = StaggeredGridLayoutManager.this.f1330u.g(view);
            if (cVarN.f1361f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && fullSpanItemF.f1339j == -1) {
                this.f1363b -= fullSpanItemF.a(this.f1366e);
            }
        }

        public void e() {
            this.f1362a.clear();
            q();
            this.f1365d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f1335z ? i(this.f1362a.size() - 1, -1, true) : i(0, this.f1362a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f1335z ? i(0, this.f1362a.size(), true) : i(this.f1362a.size() - 1, -1, true);
        }

        public int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int iM = StaggeredGridLayoutManager.this.f1330u.m();
            int i12 = StaggeredGridLayoutManager.this.f1330u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = (View) this.f1362a.get(i10);
                int iG = StaggeredGridLayoutManager.this.f1330u.g(view);
                int iD = StaggeredGridLayoutManager.this.f1330u.d(view);
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
            return this.f1365d;
        }

        public int k() {
            int i10 = this.f1364c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f1364c;
        }

        public int l(int i10) {
            int i11 = this.f1364c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f1362a.size() == 0) {
                return i10;
            }
            c();
            return this.f1364c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f1362a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f1362a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1335z && staggeredGridLayoutManager.i0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1335z && staggeredGridLayoutManager2.i0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = this.f1362a.size();
            int i12 = 0;
            while (i12 < size2) {
                View view3 = (View) this.f1362a.get(i12);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                if (staggeredGridLayoutManager3.f1335z && staggeredGridLayoutManager3.i0(view3) <= i10) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                if ((!staggeredGridLayoutManager4.f1335z && staggeredGridLayoutManager4.i0(view3) >= i10) || !view3.hasFocusable()) {
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
            int i10 = this.f1363b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f1363b;
        }

        public int p(int i10) {
            int i11 = this.f1363b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f1362a.size() == 0) {
                return i10;
            }
            d();
            return this.f1363b;
        }

        public void q() {
            this.f1363b = Integer.MIN_VALUE;
            this.f1364c = Integer.MIN_VALUE;
        }

        public void r(int i10) {
            int i11 = this.f1363b;
            if (i11 != Integer.MIN_VALUE) {
                this.f1363b = i11 + i10;
            }
            int i12 = this.f1364c;
            if (i12 != Integer.MIN_VALUE) {
                this.f1364c = i12 + i10;
            }
        }

        public void s() {
            int size = this.f1362a.size();
            View view = (View) this.f1362a.remove(size - 1);
            c cVarN = n(view);
            cVarN.f1360e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f1365d -= StaggeredGridLayoutManager.this.f1330u.e(view);
            }
            if (size == 1) {
                this.f1363b = Integer.MIN_VALUE;
            }
            this.f1364c = Integer.MIN_VALUE;
        }

        public void t() {
            View view = (View) this.f1362a.remove(0);
            c cVarN = n(view);
            cVarN.f1360e = null;
            if (this.f1362a.size() == 0) {
                this.f1364c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1365d -= StaggeredGridLayoutManager.this.f1330u.e(view);
            }
            this.f1363b = Integer.MIN_VALUE;
        }

        public void u(View view) {
            c cVarN = n(view);
            cVarN.f1360e = this;
            this.f1362a.add(0, view);
            this.f1363b = Integer.MIN_VALUE;
            if (this.f1362a.size() == 1) {
                this.f1364c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1365d += StaggeredGridLayoutManager.this.f1330u.e(view);
            }
        }

        public void v(int i10) {
            this.f1363b = i10;
            this.f1364c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d dVarJ0 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        I2(dVarJ0.f1273a);
        K2(dVarJ0.f1274b);
        J2(dVarJ0.f1275c);
        this.f1334y = new m();
        b2();
    }

    private void F2() {
        if (this.f1332w == 1 || !u2()) {
            this.A = this.f1335z;
        } else {
            this.A = !this.f1335z;
        }
    }

    private int V1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return t.a(zVar, this.f1330u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int W1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return t.b(zVar, this.f1330u, f2(!this.N), e2(!this.N), this, this.N, this.A);
    }

    private int X1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return t.c(zVar, this.f1330u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int Y1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f1332w == 1) ? 1 : Integer.MIN_VALUE : this.f1332w == 0 ? 1 : Integer.MIN_VALUE : this.f1332w == 1 ? -1 : Integer.MIN_VALUE : this.f1332w == 0 ? -1 : Integer.MIN_VALUE : (this.f1332w != 1 && u2()) ? -1 : 1 : (this.f1332w != 1 && u2()) ? 1 : -1;
    }

    private void v2(View view, int i10, int i11, boolean z10) {
        k(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int iS2 = S2(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int iS22 = S2(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10 ? I1(view, iS2, iS22, cVar) : G1(view, iS2, iS22, cVar)) {
            view.measure(iS2, iS22);
        }
    }

    public final void A2(View view) {
        for (int i10 = this.f1328s - 1; i10 >= 0; i10--) {
            this.f1329t[i10].u(view);
        }
    }

    public final void B2(RecyclerView.v vVar, m mVar) {
        if (!mVar.f1575a || mVar.f1583i) {
            return;
        }
        if (mVar.f1576b == 0) {
            if (mVar.f1579e == -1) {
                C2(vVar, mVar.f1581g);
                return;
            } else {
                D2(vVar, mVar.f1580f);
                return;
            }
        }
        if (mVar.f1579e != -1) {
            int iO2 = o2(mVar.f1581g) - mVar.f1581g;
            D2(vVar, iO2 < 0 ? mVar.f1580f : Math.min(iO2, mVar.f1576b) + mVar.f1580f);
        } else {
            int i10 = mVar.f1580f;
            int iN2 = i10 - n2(i10);
            C2(vVar, iN2 < 0 ? mVar.f1581g : mVar.f1581g - Math.min(iN2, mVar.f1576b));
        }
    }

    public final void C2(RecyclerView.v vVar, int i10) {
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            if (this.f1330u.g(viewJ) < i10 || this.f1330u.q(viewJ) < i10) {
                return;
            }
            c cVar = (c) viewJ.getLayoutParams();
            if (cVar.f1361f) {
                for (int i11 = 0; i11 < this.f1328s; i11++) {
                    if (this.f1329t[i11].f1362a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f1328s; i12++) {
                    this.f1329t[i12].s();
                }
            } else if (cVar.f1360e.f1362a.size() == 1) {
                return;
            } else {
                cVar.f1360e.s();
            }
            n1(viewJ, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i10) {
        super.D0(i10);
        for (int i11 = 0; i11 < this.f1328s; i11++) {
            this.f1329t[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(Rect rect, int i10, int i11) {
        int iO;
        int iO2;
        int iF0 = f0() + g0();
        int iH0 = h0() + e0();
        if (this.f1332w == 1) {
            iO2 = RecyclerView.o.o(i11, rect.height() + iH0, c0());
            iO = RecyclerView.o.o(i10, (this.f1333x * this.f1328s) + iF0, d0());
        } else {
            iO = RecyclerView.o.o(i10, rect.width() + iF0, d0());
            iO2 = RecyclerView.o.o(i11, (this.f1333x * this.f1328s) + iH0, c0());
        }
        C1(iO, iO2);
    }

    public final void D2(RecyclerView.v vVar, int i10) {
        while (K() > 0) {
            View viewJ = J(0);
            if (this.f1330u.d(viewJ) > i10 || this.f1330u.p(viewJ) > i10) {
                return;
            }
            c cVar = (c) viewJ.getLayoutParams();
            if (cVar.f1361f) {
                for (int i11 = 0; i11 < this.f1328s; i11++) {
                    if (this.f1329t[i11].f1362a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f1328s; i12++) {
                    this.f1329t[i12].t();
                }
            } else if (cVar.f1360e.f1362a.size() == 1) {
                return;
            } else {
                cVar.f1360e.t();
            }
            n1(viewJ, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return this.f1332w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E0(int i10) {
        super.E0(i10);
        for (int i11 = 0; i11 < this.f1328s; i11++) {
            this.f1329t[i11].r(i10);
        }
    }

    public final void E2() {
        if (this.f1331v.k() == 1073741824) {
            return;
        }
        int iK = K();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < iK; i10++) {
            View viewJ = J(i10);
            float fE = this.f1331v.e(viewJ);
            if (fE >= fMax) {
                if (((c) viewJ.getLayoutParams()).e()) {
                    fE = (fE * 1.0f) / this.f1328s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i11 = this.f1333x;
        int iRound = Math.round(fMax * this.f1328s);
        if (this.f1331v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1331v.n());
        }
        Q2(iRound);
        if (this.f1333x == i11) {
            return;
        }
        for (int i12 = 0; i12 < iK; i12++) {
            View viewJ2 = J(i12);
            c cVar = (c) viewJ2.getLayoutParams();
            if (!cVar.f1361f) {
                if (u2() && this.f1332w == 1) {
                    int i13 = this.f1328s;
                    int i14 = cVar.f1360e.f1366e;
                    viewJ2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f1333x) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = cVar.f1360e.f1366e;
                    int i16 = this.f1333x * i15;
                    int i17 = i15 * i11;
                    if (this.f1332w == 1) {
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
        for (int i10 = 0; i10 < this.f1328s; i10++) {
            this.f1329t[i10].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public int G2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        z2(i10, zVar);
        int iC2 = c2(vVar, this.f1334y, zVar);
        if (this.f1334y.f1576b >= iC2) {
            i10 = i10 < 0 ? -iC2 : iC2;
        }
        this.f1330u.r(-i10);
        this.G = this.A;
        m mVar = this.f1334y;
        mVar.f1576b = 0;
        B2(vVar, mVar);
        return i10;
    }

    public final void H2(int i10) {
        m mVar = this.f1334y;
        mVar.f1579e = i10;
        mVar.f1578d = this.A != (i10 == -1) ? -1 : 1;
    }

    public void I2(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        h(null);
        if (i10 == this.f1332w) {
            return;
        }
        this.f1332w = i10;
        q qVar = this.f1330u;
        this.f1330u = this.f1331v;
        this.f1331v = qVar;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        p1(this.P);
        for (int i10 = 0; i10 < this.f1328s; i10++) {
            this.f1329t[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        n nVar = new n(recyclerView.getContext());
        nVar.p(i10);
        K1(nVar);
    }

    public void J2(boolean z10) {
        h(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.f1349p != z10) {
            savedState.f1349p = z10;
        }
        this.f1335z = z10;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
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
        boolean z10 = cVar.f1361f;
        d dVar = cVar.f1360e;
        int iL2 = iY1 == 1 ? l2() : k2();
        P2(iL2, zVar);
        H2(iY1);
        m mVar = this.f1334y;
        mVar.f1577c = mVar.f1578d + iL2;
        mVar.f1576b = (int) (this.f1330u.n() * 0.33333334f);
        m mVar2 = this.f1334y;
        mVar2.f1582h = true;
        mVar2.f1575a = false;
        c2(vVar, mVar2, zVar);
        this.G = this.A;
        if (!z10 && (viewM = dVar.m(iL2, iY1)) != null && viewM != viewC) {
            return viewM;
        }
        if (y2(iY1)) {
            for (int i11 = this.f1328s - 1; i11 >= 0; i11--) {
                View viewM2 = this.f1329t[i11].m(iL2, iY1);
                if (viewM2 != null && viewM2 != viewC) {
                    return viewM2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f1328s; i12++) {
                View viewM3 = this.f1329t[i12].m(iL2, iY1);
                if (viewM3 != null && viewM3 != viewC) {
                    return viewM3;
                }
            }
        }
        boolean z11 = (this.f1335z ^ true) == (iY1 == -1);
        if (!z10) {
            View viewD = D(z11 ? dVar.f() : dVar.g());
            if (viewD != null && viewD != viewC) {
                return viewD;
            }
        }
        if (y2(iY1)) {
            for (int i13 = this.f1328s - 1; i13 >= 0; i13--) {
                if (i13 != dVar.f1366e) {
                    View viewD2 = D(z11 ? this.f1329t[i13].f() : this.f1329t[i13].g());
                    if (viewD2 != null && viewD2 != viewC) {
                        return viewD2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f1328s; i14++) {
                View viewD3 = D(z11 ? this.f1329t[i14].f() : this.f1329t[i14].g());
                if (viewD3 != null && viewD3 != viewC) {
                    return viewD3;
                }
            }
        }
        return null;
    }

    public void K2(int i10) {
        h(null);
        if (i10 != this.f1328s) {
            t2();
            this.f1328s = i10;
            this.B = new BitSet(this.f1328s);
            this.f1329t = new d[this.f1328s];
            for (int i11 = 0; i11 < this.f1328s; i11++) {
                this.f1329t[i11] = new d(i11);
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
            int iI02 = i0(viewE2);
            if (iI0 < iI02) {
                accessibilityEvent.setFromIndex(iI0);
                accessibilityEvent.setToIndex(iI02);
            } else {
                accessibilityEvent.setFromIndex(iI02);
                accessibilityEvent.setToIndex(iI0);
            }
        }
    }

    public final void L2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f1328s; i12++) {
            if (!this.f1329t[i12].f1362a.isEmpty()) {
                R2(this.f1329t[i12], i10, i11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.I == null;
    }

    public final boolean M2(RecyclerView.z zVar, b bVar) {
        bVar.f1353a = this.G ? h2(zVar.b()) : d2(zVar.b());
        bVar.f1354b = Integer.MIN_VALUE;
        return true;
    }

    public final void N1(View view) {
        for (int i10 = this.f1328s - 1; i10 >= 0; i10--) {
            this.f1329t[i10].a(view);
        }
    }

    public boolean N2(RecyclerView.z zVar, b bVar) {
        int i10;
        if (!zVar.e() && (i10 = this.C) != -1) {
            if (i10 >= 0 && i10 < zVar.b()) {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f1342e == -1 || savedState.f1344k < 1) {
                    View viewD = D(this.C);
                    if (viewD != null) {
                        bVar.f1353a = this.A ? l2() : k2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1355c) {
                                bVar.f1354b = (this.f1330u.i() - this.D) - this.f1330u.d(viewD);
                            } else {
                                bVar.f1354b = (this.f1330u.m() + this.D) - this.f1330u.g(viewD);
                            }
                            return true;
                        }
                        if (this.f1330u.e(viewD) > this.f1330u.n()) {
                            bVar.f1354b = bVar.f1355c ? this.f1330u.i() : this.f1330u.m();
                            return true;
                        }
                        int iG = this.f1330u.g(viewD) - this.f1330u.m();
                        if (iG < 0) {
                            bVar.f1354b = -iG;
                            return true;
                        }
                        int i11 = this.f1330u.i() - this.f1330u.d(viewD);
                        if (i11 < 0) {
                            bVar.f1354b = i11;
                            return true;
                        }
                        bVar.f1354b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.C;
                        bVar.f1353a = i12;
                        int i13 = this.D;
                        if (i13 == Integer.MIN_VALUE) {
                            bVar.f1355c = S1(i12) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f1356d = true;
                    }
                } else {
                    bVar.f1354b = Integer.MIN_VALUE;
                    bVar.f1353a = this.C;
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
        int i10 = savedState.f1344k;
        if (i10 > 0) {
            if (i10 == this.f1328s) {
                for (int i11 = 0; i11 < this.f1328s; i11++) {
                    this.f1329t[i11].e();
                    SavedState savedState2 = this.I;
                    int i12 = savedState2.f1345l[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += savedState2.f1350q ? this.f1330u.i() : this.f1330u.m();
                    }
                    this.f1329t[i11].v(i12);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f1342e = savedState3.f1343j;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f1351r;
        J2(savedState4.f1349p);
        F2();
        SavedState savedState5 = this.I;
        int i13 = savedState5.f1342e;
        if (i13 != -1) {
            this.C = i13;
            bVar.f1355c = savedState5.f1350q;
        } else {
            bVar.f1355c = this.A;
        }
        if (savedState5.f1346m > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f1336a = savedState5.f1347n;
            lazySpanLookup.f1337b = savedState5.f1348o;
        }
    }

    public void O2(RecyclerView.z zVar, b bVar) {
        if (N2(zVar, bVar) || M2(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.f1353a = 0;
    }

    public boolean P1() {
        int iL = this.f1329t[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f1328s; i10++) {
            if (this.f1329t[i10].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P2(int i10, RecyclerView.z zVar) {
        int iN;
        int iN2;
        int iC;
        m mVar = this.f1334y;
        boolean z10 = false;
        mVar.f1576b = 0;
        mVar.f1577c = i10;
        if (!y0() || (iC = zVar.c()) == -1) {
            iN = 0;
        } else {
            if (this.A != (iC < i10)) {
                iN2 = this.f1330u.n();
                iN = 0;
                if (N()) {
                    this.f1334y.f1581g = this.f1330u.h() + iN;
                    this.f1334y.f1580f = -iN2;
                } else {
                    this.f1334y.f1580f = this.f1330u.m() - iN2;
                    this.f1334y.f1581g = this.f1330u.i() + iN;
                }
                m mVar2 = this.f1334y;
                mVar2.f1582h = false;
                mVar2.f1575a = true;
                if (this.f1330u.k() == 0 && this.f1330u.h() == 0) {
                    z10 = true;
                }
                mVar2.f1583i = z10;
            }
            iN = this.f1330u.n();
        }
        iN2 = 0;
        if (N()) {
        }
        m mVar22 = this.f1334y;
        mVar22.f1582h = false;
        mVar22.f1575a = true;
        if (this.f1330u.k() == 0) {
            z10 = true;
        }
        mVar22.f1583i = z10;
    }

    public boolean Q1() {
        int iP = this.f1329t[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f1328s; i10++) {
            if (this.f1329t[i10].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    public void Q2(int i10) {
        this.f1333x = i10 / this.f1328s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f1331v.k());
    }

    public final void R1(View view, c cVar, m mVar) {
        if (mVar.f1579e == 1) {
            if (cVar.f1361f) {
                N1(view);
                return;
            } else {
                cVar.f1360e.a(view);
                return;
            }
        }
        if (cVar.f1361f) {
            A2(view);
        } else {
            cVar.f1360e.u(view);
        }
    }

    public final void R2(d dVar, int i10, int i11) {
        int iJ = dVar.j();
        if (i10 == -1) {
            if (dVar.o() + iJ <= i11) {
                this.B.set(dVar.f1366e, false);
            }
        } else if (dVar.k() - iJ >= i11) {
            this.B.set(dVar.f1366e, false);
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
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.E.e(iK2, fullSpanItemE.f1338e, i10 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.E.d(fullSpanItemE.f1338e);
        } else {
            this.E.d(fullSpanItemE2.f1338e + 1);
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
            if (dVar.o() > this.f1330u.m()) {
                z10 = dVar.n((View) dVar.f1362a.get(0)).f1361f;
                return !z10;
            }
            return false;
        }
        if (dVar.k() < this.f1330u.i()) {
            z10 = dVar.n((View) dVar.f1362a.get(r0.size() - 1)).f1361f;
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
    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
        x2(vVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public final LazySpanLookup.FullSpanItem Z1(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1340k = new int[this.f1328s];
        for (int i11 = 0; i11 < this.f1328s; i11++) {
            fullSpanItem.f1340k[i11] = i10 - this.f1329t[i11].l(i10);
        }
        return fullSpanItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i10) {
        int iS1 = S1(i10);
        PointF pointF = new PointF();
        if (iS1 == 0) {
            return null;
        }
        if (this.f1332w == 0) {
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
        fullSpanItem.f1340k = new int[this.f1328s];
        for (int i11 = 0; i11 < this.f1328s; i11++) {
            fullSpanItem.f1340k[i11] = this.f1329t[i11].p(i10) - i10;
        }
        return fullSpanItem;
    }

    public final void b2() {
        this.f1330u = q.b(this, this.f1332w);
        this.f1331v = q.b(this, 1 - this.f1332w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    public final int c2(RecyclerView.v vVar, m mVar, RecyclerView.z zVar) {
        int i10;
        d dVarQ2;
        int iP2;
        int iE;
        int iM;
        int iE2;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this;
        ?? r82 = 0;
        staggeredGridLayoutManager2.B.set(0, staggeredGridLayoutManager2.f1328s, true);
        if (staggeredGridLayoutManager2.f1334y.f1583i) {
            i10 = mVar.f1579e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i10 = mVar.f1579e == 1 ? mVar.f1581g + mVar.f1576b : mVar.f1580f - mVar.f1576b;
        }
        staggeredGridLayoutManager2.L2(mVar.f1579e, i10);
        int i11 = staggeredGridLayoutManager2.A ? staggeredGridLayoutManager2.f1330u.i() : staggeredGridLayoutManager2.f1330u.m();
        boolean z10 = false;
        StaggeredGridLayoutManager staggeredGridLayoutManager3 = staggeredGridLayoutManager2;
        while (mVar.a(zVar) && (staggeredGridLayoutManager3.f1334y.f1583i || !staggeredGridLayoutManager3.B.isEmpty())) {
            View viewB = mVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = staggeredGridLayoutManager3.E.g(iA);
            boolean z11 = iG == -1;
            if (z11) {
                dVarQ2 = cVar.f1361f ? staggeredGridLayoutManager3.f1329t[r82] : staggeredGridLayoutManager3.q2(mVar);
                staggeredGridLayoutManager3.E.n(iA, dVarQ2);
            } else {
                dVarQ2 = staggeredGridLayoutManager3.f1329t[iG];
            }
            d dVar = dVarQ2;
            cVar.f1360e = dVar;
            if (mVar.f1579e == 1) {
                staggeredGridLayoutManager3.e(viewB);
            } else {
                staggeredGridLayoutManager3.f(viewB, r82);
            }
            staggeredGridLayoutManager3.w2(viewB, cVar, r82);
            if (mVar.f1579e == 1) {
                iE = cVar.f1361f ? staggeredGridLayoutManager3.m2(i11) : dVar.l(i11);
                iP2 = staggeredGridLayoutManager3.f1330u.e(viewB) + iE;
                if (z11 && cVar.f1361f) {
                    LazySpanLookup.FullSpanItem fullSpanItemZ1 = staggeredGridLayoutManager3.Z1(iE);
                    fullSpanItemZ1.f1339j = -1;
                    fullSpanItemZ1.f1338e = iA;
                    staggeredGridLayoutManager3.E.a(fullSpanItemZ1);
                }
            } else {
                iP2 = cVar.f1361f ? staggeredGridLayoutManager3.p2(i11) : dVar.p(i11);
                iE = iP2 - staggeredGridLayoutManager3.f1330u.e(viewB);
                if (z11 && cVar.f1361f) {
                    LazySpanLookup.FullSpanItem fullSpanItemA2 = staggeredGridLayoutManager3.a2(iP2);
                    fullSpanItemA2.f1339j = 1;
                    fullSpanItemA2.f1338e = iA;
                    staggeredGridLayoutManager3.E.a(fullSpanItemA2);
                }
            }
            if (cVar.f1361f && mVar.f1578d == -1) {
                if (z11) {
                    staggeredGridLayoutManager3.M = true;
                } else {
                    if (!(mVar.f1579e == 1 ? staggeredGridLayoutManager3.P1() : staggeredGridLayoutManager3.Q1())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = staggeredGridLayoutManager3.E.f(iA);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f1341l = true;
                        }
                        staggeredGridLayoutManager3.M = true;
                    }
                }
            }
            staggeredGridLayoutManager3.R1(viewB, cVar, mVar);
            if (staggeredGridLayoutManager3.u2() && staggeredGridLayoutManager3.f1332w == 1) {
                iE2 = cVar.f1361f ? staggeredGridLayoutManager3.f1331v.i() : staggeredGridLayoutManager3.f1331v.i() - (((staggeredGridLayoutManager3.f1328s - 1) - dVar.f1366e) * staggeredGridLayoutManager3.f1333x);
                iM = iE2 - staggeredGridLayoutManager3.f1331v.e(viewB);
            } else {
                iM = cVar.f1361f ? staggeredGridLayoutManager3.f1331v.m() : (dVar.f1366e * staggeredGridLayoutManager3.f1333x) + staggeredGridLayoutManager3.f1331v.m();
                iE2 = staggeredGridLayoutManager3.f1331v.e(viewB) + iM;
            }
            int i12 = iE2;
            int i13 = iM;
            if (staggeredGridLayoutManager3.f1332w == 1) {
                staggeredGridLayoutManager3.A0(viewB, i13, iE, i12, iP2);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager3.A0(viewB, iE, i13, iP2, i12);
                staggeredGridLayoutManager = staggeredGridLayoutManager3;
            }
            if (cVar.f1361f) {
                staggeredGridLayoutManager.L2(staggeredGridLayoutManager.f1334y.f1579e, i10);
            } else {
                staggeredGridLayoutManager.R2(dVar, staggeredGridLayoutManager.f1334y.f1579e, i10);
            }
            staggeredGridLayoutManager.B2(vVar, staggeredGridLayoutManager.f1334y);
            if (staggeredGridLayoutManager.f1334y.f1582h && viewB.hasFocusable()) {
                if (cVar.f1361f) {
                    staggeredGridLayoutManager.B.clear();
                } else {
                    staggeredGridLayoutManager.B.set(dVar.f1366e, false);
                }
            }
            z10 = true;
            r82 = 0;
            staggeredGridLayoutManager3 = staggeredGridLayoutManager;
        }
        if (!z10) {
            staggeredGridLayoutManager3.B2(vVar, staggeredGridLayoutManager3.f1334y);
        }
        int iM2 = staggeredGridLayoutManager3.f1334y.f1579e == -1 ? staggeredGridLayoutManager3.f1330u.m() - staggeredGridLayoutManager3.p2(staggeredGridLayoutManager3.f1330u.m()) : staggeredGridLayoutManager3.m2(staggeredGridLayoutManager3.f1330u.i()) - staggeredGridLayoutManager3.f1330u.i();
        if (iM2 > 0) {
            return Math.min(mVar.f1576b, iM2);
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
        savedState.f1349p = this.f1335z;
        savedState.f1350q = this.G;
        savedState.f1351r = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f1336a) == null) {
            savedState.f1346m = 0;
        } else {
            savedState.f1347n = iArr;
            savedState.f1346m = iArr.length;
            savedState.f1348o = lazySpanLookup.f1337b;
        }
        if (K() <= 0) {
            savedState.f1342e = -1;
            savedState.f1343j = -1;
            savedState.f1344k = 0;
            return savedState;
        }
        savedState.f1342e = this.G ? l2() : k2();
        savedState.f1343j = g2();
        int i10 = this.f1328s;
        savedState.f1344k = i10;
        savedState.f1345l = new int[i10];
        for (int i11 = 0; i11 < this.f1328s; i11++) {
            if (this.G) {
                iP = this.f1329t[i11].l(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.f1330u.i();
                    iP -= iM;
                }
            } else {
                iP = this.f1329t[i11].p(Integer.MIN_VALUE);
                if (iP != Integer.MIN_VALUE) {
                    iM = this.f1330u.m();
                    iP -= iM;
                }
            }
            savedState.f1345l[i11] = iP;
        }
        return savedState;
    }

    public View e2(boolean z10) {
        int iM = this.f1330u.m();
        int i10 = this.f1330u.i();
        View view = null;
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            int iG = this.f1330u.g(viewJ);
            int iD = this.f1330u.d(viewJ);
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
        int iM = this.f1330u.m();
        int i10 = this.f1330u.i();
        int iK = K();
        View view = null;
        for (int i11 = 0; i11 < iK; i11++) {
            View viewJ = J(i11);
            int iG = this.f1330u.g(viewJ);
            if (this.f1330u.d(viewJ) > iM && iG < i10) {
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

    public final void i2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i10;
        int iM2 = m2(Integer.MIN_VALUE);
        if (iM2 != Integer.MIN_VALUE && (i10 = this.f1330u.i() - iM2) > 0) {
            int i11 = i10 - (-G2(-i10, vVar, zVar));
            if (!z10 || i11 <= 0) {
                return;
            }
            this.f1330u.r(i11);
        }
    }

    public final void j2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int iM;
        int iP2 = p2(Integer.MAX_VALUE);
        if (iP2 != Integer.MAX_VALUE && (iM = iP2 - this.f1330u.m()) > 0) {
            int iG2 = iM - G2(iM, vVar, zVar);
            if (!z10 || iG2 <= 0) {
                return;
            }
            this.f1330u.r(-iG2);
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
        return this.f1332w == 0;
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
        return this.f1332w == 1;
    }

    public final int m2(int i10) {
        int iL = this.f1329t[0].l(i10);
        for (int i11 = 1; i11 < this.f1328s; i11++) {
            int iL2 = this.f1329t[i11].l(i10);
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
        int iP = this.f1329t[0].p(i10);
        for (int i11 = 1; i11 < this.f1328s; i11++) {
            int iP2 = this.f1329t[i11].p(i10);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final int o2(int i10) {
        int iL = this.f1329t[0].l(i10);
        for (int i11 = 1; i11 < this.f1328s; i11++) {
            int iL2 = this.f1329t[i11].l(i10);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i10, int i11, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f1332w != 0) {
            i10 = i11;
        }
        if (K() == 0 || i10 == 0) {
            return;
        }
        z2(i10, zVar);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f1328s) {
            this.O = new int[this.f1328s];
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f1328s; i13++) {
            m mVar = this.f1334y;
            if (mVar.f1578d == -1) {
                iL = mVar.f1580f;
                iP = this.f1329t[i13].p(iL);
            } else {
                iL = this.f1329t[i13].l(mVar.f1581g);
                iP = this.f1334y.f1581g;
            }
            int i14 = iL - iP;
            if (i14 >= 0) {
                this.O[i12] = i14;
                i12++;
            }
        }
        Arrays.sort(this.O, 0, i12);
        for (int i15 = 0; i15 < i12 && this.f1334y.a(zVar); i15++) {
            cVar.a(this.f1334y.f1577c, this.O[i15]);
            m mVar2 = this.f1334y;
            mVar2.f1577c += mVar2.f1578d;
        }
    }

    public final int p2(int i10) {
        int iP = this.f1329t[0].p(i10);
        for (int i11 = 1; i11 < this.f1328s; i11++) {
            int iP2 = this.f1329t[i11].p(i10);
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
        if (y2(mVar.f1579e)) {
            i11 = this.f1328s - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = this.f1328s;
            i11 = 0;
            i12 = 1;
        }
        d dVar = null;
        if (mVar.f1579e == 1) {
            int iM = this.f1330u.m();
            int i13 = Integer.MAX_VALUE;
            while (i11 != i10) {
                d dVar2 = this.f1329t[i11];
                int iL = dVar2.l(iM);
                if (iL < i13) {
                    dVar = dVar2;
                    i13 = iL;
                }
                i11 += i12;
            }
            return dVar;
        }
        int i14 = this.f1330u.i();
        int i15 = Integer.MIN_VALUE;
        while (i11 != i10) {
            d dVar3 = this.f1329t[i11];
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
    public int r(RecyclerView.z zVar) {
        return V1(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r2(int i10, int i11, int i12) {
        int i13;
        int i14;
        int iL2 = this.A ? l2() : k2();
        if (i12 != 8) {
            i13 = i10 + i11;
        } else {
            if (i10 >= i11) {
                i13 = i10 + 1;
                i14 = i11;
                this.E.h(i14);
                if (i12 != 1) {
                    this.E.j(i10, i11);
                } else if (i12 == 2) {
                    this.E.k(i10, i11);
                } else if (i12 == 8) {
                    this.E.k(i10, 1);
                    this.E.j(i11, 1);
                }
                if (i13 > iL2) {
                    return;
                }
                if (i14 <= (this.A ? k2() : l2())) {
                    u1();
                    return;
                }
                return;
            }
            i13 = i11 + 1;
        }
        i14 = i10;
        this.E.h(i14);
        if (i12 != 1) {
        }
        if (i13 > iL2) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return W1(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View s2() {
        int i10;
        int iK = K();
        int i11 = iK - 1;
        BitSet bitSet = new BitSet(this.f1328s);
        bitSet.set(0, this.f1328s, true);
        char c10 = (this.f1332w == 1 && u2()) ? (char) 1 : '\uffff';
        if (this.A) {
            iK = -1;
        } else {
            i11 = 0;
        }
        int i12 = i11 < iK ? 1 : -1;
        while (i11 != iK) {
            View viewJ = J(i11);
            c cVar = (c) viewJ.getLayoutParams();
            if (!bitSet.get(cVar.f1360e.f1366e)) {
                if (!cVar.f1361f && (i10 = i11 + i12) != iK) {
                    View viewJ2 = J(i10);
                    if (this.A) {
                        int iG = this.f1330u.g(viewJ);
                        int iG2 = this.f1330u.g(viewJ2);
                        if (iG <= iG2) {
                            if (iG != iG2) {
                                continue;
                            }
                        }
                    } else {
                        int iD = this.f1330u.d(viewJ);
                        int iD2 = this.f1330u.d(viewJ2);
                        if (iD >= iD2) {
                            if (iD == iD2) {
                                if ((cVar.f1360e.f1366e - ((c) viewJ2.getLayoutParams()).f1360e.f1366e < 0) != (c10 < 0)) {
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i11 += i12;
            } else if (!U1(cVar.f1360e)) {
                bitSet.clear(cVar.f1360e.f1366e);
                if (!cVar.f1361f) {
                    View viewJ22 = J(i10);
                    if (this.A) {
                    }
                }
                i11 += i12;
            }
            return viewJ;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return X1(zVar);
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
    public int u(RecyclerView.z zVar) {
        return V1(zVar);
    }

    public boolean u2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return W1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.z zVar) {
        return X1(zVar);
    }

    public final void w2(View view, c cVar, boolean z10) {
        if (cVar.f1361f) {
            if (this.f1332w == 1) {
                v2(view, this.J, RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
                return;
            } else {
                v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z10);
                return;
            }
        }
        if (this.f1332w == 1) {
            v2(view, RecyclerView.o.L(this.f1333x, q0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
        } else {
            v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.L(this.f1333x, Y(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return G2(i10, vVar, zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        SavedState savedState;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && zVar.b() == 0) {
            l1(vVar);
            bVar.c();
            return;
        }
        boolean z11 = true;
        boolean z12 = (bVar.f1357e && this.C == -1 && this.I == null) ? false : true;
        if (z12) {
            bVar.c();
            if (this.I != null) {
                O1(bVar);
            } else {
                F2();
                bVar.f1355c = this.A;
            }
            O2(zVar, bVar);
            bVar.f1357e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.f1355c != this.G || u2() != this.H)) {
            this.E.b();
            bVar.f1356d = true;
        }
        if (K() > 0 && ((savedState = this.I) == null || savedState.f1344k < 1)) {
            if (bVar.f1356d) {
                for (int i10 = 0; i10 < this.f1328s; i10++) {
                    this.f1329t[i10].e();
                    int i11 = bVar.f1354b;
                    if (i11 != Integer.MIN_VALUE) {
                        this.f1329t[i10].v(i11);
                    }
                }
            } else if (z12 || this.L.f1358f == null) {
                for (int i12 = 0; i12 < this.f1328s; i12++) {
                    this.f1329t[i12].b(this.A, bVar.f1354b);
                }
                this.L.d(this.f1329t);
            } else {
                for (int i13 = 0; i13 < this.f1328s; i13++) {
                    d dVar = this.f1329t[i13];
                    dVar.e();
                    dVar.v(this.L.f1358f[i13]);
                }
            }
        }
        x(vVar);
        this.f1334y.f1575a = false;
        this.M = false;
        Q2(this.f1331v.n());
        P2(bVar.f1353a, zVar);
        if (bVar.f1355c) {
            H2(-1);
            c2(vVar, this.f1334y, zVar);
            H2(1);
            m mVar = this.f1334y;
            mVar.f1577c = bVar.f1353a + mVar.f1578d;
            c2(vVar, mVar, zVar);
        } else {
            H2(1);
            c2(vVar, this.f1334y, zVar);
            H2(-1);
            m mVar2 = this.f1334y;
            mVar2.f1577c = bVar.f1353a + mVar2.f1578d;
            c2(vVar, mVar2, zVar);
        }
        E2();
        if (K() > 0) {
            if (this.A) {
                i2(vVar, zVar, true);
                j2(vVar, zVar, false);
            } else {
                j2(vVar, zVar, true);
                i2(vVar, zVar, false);
            }
        }
        if (!z10 || zVar.e() || this.F == 0 || K() <= 0 || (!this.M && s2() == null)) {
            z11 = false;
        } else {
            p1(this.P);
            if (!T1()) {
            }
        }
        if (zVar.e()) {
            this.L.c();
        }
        this.G = bVar.f1355c;
        this.H = u2();
        if (z11) {
            this.L.c();
            x2(vVar, zVar, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y1(int i10) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.f1342e != i10) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        u1();
    }

    public final boolean y2(int i10) {
        if (this.f1332w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == u2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return G2(i10, vVar, zVar);
    }

    public void z2(int i10, RecyclerView.z zVar) {
        int iK2;
        int i11;
        if (i10 > 0) {
            iK2 = l2();
            i11 = 1;
        } else {
            iK2 = k2();
            i11 = -1;
        }
        this.f1334y.f1575a = true;
        P2(iK2, zVar);
        H2(i11);
        m mVar = this.f1334y;
        mVar.f1577c = iK2 + mVar.f1578d;
        mVar.f1576b = Math.abs(i10);
    }
}
