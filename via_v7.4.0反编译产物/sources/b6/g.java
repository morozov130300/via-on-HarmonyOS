package b6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g extends RecyclerView.c0 {

    /* renamed from: u, reason: collision with root package name */
    public SparseArray f1840u;

    public g(View view) {
        super(view);
        this.f1840u = null;
    }

    public Context O() {
        return this.f1219a.getContext();
    }

    public View P(int i10) {
        if (this.f1840u == null) {
            this.f1840u = new SparseArray();
        }
        View view = (View) this.f1840u.get(i10);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f1219a.findViewById(i10);
        this.f1840u.put(i10, viewFindViewById);
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
