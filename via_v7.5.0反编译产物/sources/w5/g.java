package w5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g extends RecyclerView.d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SparseArray f13671u;

    public g(View view) {
        super(view);
        this.f13671u = null;
    }

    public Context O() {
        return this.f1138a.getContext();
    }

    public View P(int i10) {
        if (this.f13671u == null) {
            this.f13671u = new SparseArray();
        }
        View view = (View) this.f13671u.get(i10);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f1138a.findViewById(i10);
        this.f13671u.put(i10, viewFindViewById);
        return viewFindViewById;
    }

    public g Q(int i10, float f10) {
        P(i10).setAlpha(f10);
        return this;
    }

    public g R(int i10, int i11) {
        P(i10).setBackgroundColor(i11);
        return this;
    }

    public g S(int i10, int i11) {
        P(i10).setBackgroundResource(i11);
        return this;
    }

    public g T(int i10, boolean z10) {
        ((Checkable) P(i10)).setChecked(z10);
        return this;
    }

    public g U(int i10, CharSequence charSequence) {
        P(i10).setContentDescription(charSequence);
        return this;
    }

    public g V(int i10, Drawable drawable) {
        ((ImageView) P(i10)).setImageDrawable(drawable);
        return this;
    }

    public g W(int i10, int i11) {
        ((ImageView) P(i10)).setImageResource(i11);
        return this;
    }

    public g X(int i10, CharSequence charSequence) {
        ((TextView) P(i10)).setText(charSequence);
        return this;
    }

    public g Y(int i10, boolean z10) {
        P(i10).setVisibility(z10 ? 0 : 8);
        return this;
    }
}
