package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class SizedLinearLayoutManager extends LinearLayoutManager {
    public int I;
    public int J;
    public int K;
    public int L;

    public SizedLinearLayoutManager(Context context) {
        super(context);
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
    }

    public SizedLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(int i10, int i11) {
        int i12 = this.K;
        if (i12 <= 0 || i11 >= i12) {
            i12 = i11;
        }
        int i13 = this.J;
        if (i13 > 0 && i11 > i13) {
            i12 = i13;
        }
        int i14 = this.L;
        if (i14 <= 0 || i10 >= i14) {
            i14 = i10;
        }
        int i15 = this.I;
        if (i15 > 0 && i10 > i15) {
            i14 = i15;
        }
        super.C1(i14, i12);
    }

    public void N2(int i10) {
        this.J = i10;
    }

    public void O2(int i10) {
        this.K = i10;
    }
}
