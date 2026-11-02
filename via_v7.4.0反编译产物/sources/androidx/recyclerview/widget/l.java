package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f1574a = new l();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float fR = x.r.r(childAt);
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
            Object tag = view.getTag(k0.c.f8027a);
            if (tag instanceof Float) {
                x.r.a0(view, ((Float) tag).floatValue());
            }
            view.setTag(k0.c.f8027a, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.k
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.k
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    @Override // androidx.recyclerview.widget.k
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 && z10 && view.getTag(k0.c.f8027a) == null) {
            Float fValueOf = Float.valueOf(x.r.r(view));
            x.r.a0(view, e(recyclerView, view) + 1.0f);
            view.setTag(k0.c.f8027a, fValueOf);
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }
}
