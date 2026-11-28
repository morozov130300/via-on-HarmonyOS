package x5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f14521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14522b = -1;

    public c(int i10) {
        Paint paint = new Paint();
        this.f14521a = paint;
        paint.setAntiAlias(true);
        paint.setColor(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int i10;
        super.k(canvas, recyclerView, a0Var);
        if (recyclerView.getChildCount() < 1 || (i10 = this.f14522b) == 0) {
            return;
        }
        if (i10 < 0) {
            this.f14522b = x.h(recyclerView.getContext(), 1.0f);
        }
        View childAt = recyclerView.getChildAt(0);
        if (recyclerView.i0(childAt) > 0 || childAt.getTop() < 0) {
            canvas.drawRect(recyclerView.getPaddingLeft(), 0.0f, recyclerView.getWidth() - recyclerView.getPaddingRight(), this.f14522b, this.f14521a);
        }
    }
}
