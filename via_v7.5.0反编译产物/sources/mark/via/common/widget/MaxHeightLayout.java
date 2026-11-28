package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class MaxHeightLayout extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9861c;

    public MaxHeightLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f9861c;
        if (i12 > 0) {
            i11 = View.MeasureSpec.getMode(i11) == 0 ? View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), this.f9861c), View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxHeight(int i10) {
        this.f9861c = i10;
        requestLayout();
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9861c = -1;
    }
}
