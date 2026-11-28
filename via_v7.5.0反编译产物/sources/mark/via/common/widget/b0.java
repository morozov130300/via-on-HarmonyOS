package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9901c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f9902e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f9903m;

    public b0(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void b(b0 b0Var, TextView textView) {
        v8.g.m(textView, v8.h.q(b0Var.getContext()));
        textView.setSingleLine();
        textView.setGravity(16);
        textView.setFadingEdgeLength(com.tuyafeng.support.utils.x.h(b0Var.getContext(), 24.0f));
        textView.setHorizontalFadingEdgeEnabled(true);
        r3.o(textView);
        v8.g.d(textView);
    }

    public static /* synthetic */ void c(b0 b0Var, ImageView imageView) {
        b0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(b0Var.getContext(), w7.o.f13846y, w7.u.je));
    }

    public final void d() {
        setOrientation(0);
        this.f9901c = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(com.tuyafeng.support.utils.f.d(getContext(), w7.n.A), -1)).M(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13773z)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.y
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((ImageView) obj).setImportantForAccessibility(2);
            }
        }).l();
        this.f9903m = (TextView) new b6.a(new TextView(getContext()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.z
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                b0.b(this.f10102a, (TextView) obj);
            }
        }).l();
        this.f9902e = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(com.tuyafeng.support.utils.f.d(getContext(), w7.n.A), -1)).N(1, 14).i(w7.u.L9).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.a0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                b0.c(this.f9899a, (ImageView) obj);
            }
        }).l();
        addView(this.f9901c);
        addView(this.f9903m);
        addView(this.f9902e);
    }

    public ImageView getCloseView() {
        return this.f9902e;
    }

    public ImageView getIconView() {
        return this.f9901c;
    }

    public TextView getTextView() {
        return this.f9903m;
    }

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d();
    }
}
