package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f1497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f1498e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends n {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.n, androidx.recyclerview.widget.RecyclerView.z
        public void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            r rVar = r.this;
            int[] iArrC = rVar.c(rVar.f1505a.getLayoutManager(), view);
            int i10 = iArrC[0];
            int i11 = iArrC[1];
            int iW = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iW > 0) {
                aVar.d(i10, i11, iW, this.f1486j);
            }
        }

        @Override // androidx.recyclerview.widget.n
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.n
        public int x(int i10) {
            return Math.min(100, super.x(i10));
        }
    }

    @Override // androidx.recyclerview.widget.v
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.l()) {
            iArr[0] = k(view, m(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.m()) {
            iArr[1] = k(view, o(oVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.v
    public RecyclerView.z d(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new a(this.f1505a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.v
    public View f(RecyclerView.o oVar) {
        if (oVar.m()) {
            return l(oVar, o(oVar));
        }
        if (oVar.l()) {
            return l(oVar, m(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.v
    public int g(RecyclerView.o oVar, int i10, int i11) {
        q qVarN;
        int iZ = oVar.Z();
        if (iZ == 0 || (qVarN = n(oVar)) == null) {
            return -1;
        }
        int iK = oVar.K();
        View view = null;
        View view2 = null;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        for (int i14 = 0; i14 < iK; i14++) {
            View viewJ = oVar.J(i14);
            if (viewJ != null) {
                int iK2 = k(viewJ, qVarN);
                if (iK2 <= 0 && iK2 > i12) {
                    view2 = viewJ;
                    i12 = iK2;
                }
                if (iK2 >= 0 && iK2 < i13) {
                    view = viewJ;
                    i13 = iK2;
                }
            }
        }
        boolean zP = p(oVar, i10, i11);
        if (zP && view != null) {
            return oVar.i0(view);
        }
        if (!zP && view2 != null) {
            return oVar.i0(view2);
        }
        if (zP) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iI0 = oVar.i0(view) + (q(oVar) == zP ? -1 : 1);
        if (iI0 < 0 || iI0 >= iZ) {
            return -1;
        }
        return iI0;
    }

    public final int k(View view, q qVar) {
        return (qVar.g(view) + (qVar.e(view) / 2)) - (qVar.m() + (qVar.n() / 2));
    }

    public final View l(RecyclerView.o oVar, q qVar) {
        int iK = oVar.K();
        View view = null;
        if (iK == 0) {
            return null;
        }
        int iM = qVar.m() + (qVar.n() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < iK; i11++) {
            View viewJ = oVar.J(i11);
            int iAbs = Math.abs((qVar.g(viewJ) + (qVar.e(viewJ) / 2)) - iM);
            if (iAbs < i10) {
                view = viewJ;
                i10 = iAbs;
            }
        }
        return view;
    }

    public final q m(RecyclerView.o oVar) {
        q qVar = this.f1498e;
        if (qVar == null || qVar.f1494a != oVar) {
            this.f1498e = q.a(oVar);
        }
        return this.f1498e;
    }

    public final q n(RecyclerView.o oVar) {
        if (oVar.m()) {
            return o(oVar);
        }
        if (oVar.l()) {
            return m(oVar);
        }
        return null;
    }

    public final q o(RecyclerView.o oVar) {
        q qVar = this.f1497d;
        if (qVar == null || qVar.f1494a != oVar) {
            this.f1497d = q.c(oVar);
        }
        return this.f1497d;
    }

    public final boolean p(RecyclerView.o oVar, int i10, int i11) {
        if (oVar.l()) {
            return i10 > 0;
        }
        return i11 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean q(RecyclerView.o oVar) {
        PointF pointFA;
        int iZ = oVar.Z();
        if (!(oVar instanceof RecyclerView.z.b) || (pointFA = ((RecyclerView.z.b) oVar).a(iZ - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }
}
