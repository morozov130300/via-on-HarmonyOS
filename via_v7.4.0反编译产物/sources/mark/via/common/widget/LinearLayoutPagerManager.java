package mark.via.common.widget;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LinearLayoutPagerManager extends LinearLayoutManager {
    public int I;

    public LinearLayoutPagerManager(Context context, int i10, int i11, boolean z10) {
        super(context, i10, z10);
        this.I = i11;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        return P2(super.E());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        return P2(super.G(layoutParams));
    }

    public final int N2() {
        return Math.round((o2() == 0 ? p0() : X()) / this.I);
    }

    public void O2(int i10) {
        if (i10 == this.I) {
            return;
        }
        this.I = i10;
        u1();
    }

    public final RecyclerView.p P2(RecyclerView.p pVar) {
        int iN2 = N2();
        if (o2() == 0) {
            ((ViewGroup.MarginLayoutParams) pVar).width = iN2;
            return pVar;
        }
        ((ViewGroup.MarginLayoutParams) pVar).height = iN2;
        return pVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(RecyclerView.p pVar) {
        return super.n(pVar) && ((ViewGroup.MarginLayoutParams) pVar).width == N2();
    }
}
