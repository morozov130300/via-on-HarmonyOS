package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1480e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1484i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1476a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1481f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1482g = 0;

    public boolean a(RecyclerView.a0 a0Var) {
        int i10 = this.f1478c;
        return i10 >= 0 && i10 < a0Var.b();
    }

    public View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f1478c);
        this.f1478c += this.f1479d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1477b + ", mCurrentPosition=" + this.f1478c + ", mItemDirection=" + this.f1479d + ", mLayoutDirection=" + this.f1480e + ", mStartLine=" + this.f1481f + ", mEndLine=" + this.f1482g + '}';
    }
}
