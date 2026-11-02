package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class SizedGridLayoutManager extends GridLayoutManager {
    public int R;
    public int S;
    public int T;
    public int U;

    public SizedGridLayoutManager(Context context, int i10) {
        super(context, i10);
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
    }

    public SizedGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(int i10, int i11) {
        int i12 = this.T;
        if (i12 <= 0 || i11 >= i12) {
            i12 = i11;
        }
        int i13 = this.S;
        if (i13 > 0 && i11 > i13) {
            i12 = i13;
        }
        int i14 = this.U;
        if (i14 <= 0 || i10 >= i14) {
            i14 = i10;
        }
        int i15 = this.R;
        if (i15 > 0 && i10 > i15) {
            i14 = i15;
        }
        super.C1(i14, i12);
    }

    public void h3(int i10) {
        this.S = i10;
    }
}
