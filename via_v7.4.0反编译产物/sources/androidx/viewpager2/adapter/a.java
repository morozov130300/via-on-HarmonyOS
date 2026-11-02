package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import x.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends RecyclerView.c0 {
    public a(FrameLayout frameLayout) {
        super(frameLayout);
    }

    public static a O(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(r.j());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }

    public FrameLayout P() {
        return (FrameLayout) this.f1219a;
    }
}
