package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends RecyclerView.d0 {
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
        return (FrameLayout) this.f1138a;
    }
}
