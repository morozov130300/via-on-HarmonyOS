package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class MaxHeightLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public int f9570e;

    public MaxHeightLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9570e = -1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f9570e;
        if (i12 > 0) {
            i11 = View.MeasureSpec.getMode(i11) == 0 ? View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), this.f9570e), View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxHeight(int i10) {
        this.f9570e = i10;
        requestLayout();
    }
}
