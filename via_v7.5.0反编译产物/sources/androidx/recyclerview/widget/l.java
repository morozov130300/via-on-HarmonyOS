package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f1475a = new l();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float fR = y.r.r(childAt);
                if (fR > f10) {
                    f10 = fR;
                }
            }
        }
        return f10;
    }

    @Override // androidx.recyclerview.widget.k
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(l0.c.f7374a);
            if (tag instanceof Float) {
                y.r.b0(view, ((Float) tag).floatValue());
            }
            view.setTag(l0.c.f7374a, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.k
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 && z10 && view.getTag(l0.c.f7374a) == null) {
            Float fValueOf = Float.valueOf(y.r.r(view));
            y.r.b0(view, e(recyclerView, view) + 1.0f);
            view.setTag(l0.c.f7374a, fValueOf);
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    @Override // androidx.recyclerview.widget.k
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.k
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }
}
