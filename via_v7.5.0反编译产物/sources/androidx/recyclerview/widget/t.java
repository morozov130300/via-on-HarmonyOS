package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static int a(RecyclerView.a0 a0Var, q qVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1;
        }
        return Math.min(qVar.n(), qVar.d(view2) - qVar.g(view));
    }

    public static int b(RecyclerView.a0 a0Var, q qVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z11 ? Math.max(0, (a0Var.b() - Math.max(oVar.i0(view), oVar.i0(view2))) - 1) : Math.max(0, Math.min(oVar.i0(view), oVar.i0(view2)));
        if (z10) {
            return Math.round((iMax * (Math.abs(qVar.d(view2) - qVar.g(view)) / (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1))) + (qVar.m() - qVar.g(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.a0 a0Var, q qVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.K() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return a0Var.b();
        }
        return (int) (((qVar.d(view2) - qVar.g(view)) / (Math.abs(oVar.i0(view) - oVar.i0(view2)) + 1)) * a0Var.b());
    }
}
