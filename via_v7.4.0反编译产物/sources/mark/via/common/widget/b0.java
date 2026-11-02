package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public ImageView f9610e;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f9611j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f9612k;

    public b0(Context context) {
        this(context, null);
    }

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d();
    }

    public static /* synthetic */ void b(b0 b0Var, TextView textView) {
        x8.g.m(textView, x8.h.r(b0Var.getContext()));
        textView.setSingleLine();
        textView.setGravity(16);
        textView.setFadingEdgeLength(g6.y.h(b0Var.getContext(), 24.0f));
        textView.setHorizontalFadingEdgeEnabled(true);
        r3.n(textView);
        x8.g.d(textView);
    }

    public static /* synthetic */ void c(b0 b0Var, ImageView imageView) {
        b0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(b0Var.getContext(), x7.o.f13783z, x7.u.Ud));
    }

    public final void d() {
        setOrientation(0);
        this.f9610e = (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(g6.f.d(getContext(), x7.n.f13706y), -1)).M(g6.f.d(getContext(), x7.n.f13705x)).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.y
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((ImageView) obj).setImportantForAccessibility(2);
            }
        }).l();
        this.f9612k = (TextView) new h6.a(new TextView(getContext()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.z
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                b0.b(this.f9799a, (TextView) obj);
            }
        }).l();
        this.f9611j = (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(g6.f.d(getContext(), x7.n.f13706y), -1)).N(1, 14).i(x7.u.f14251z9).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.a0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                b0.c(this.f9608a, (ImageView) obj);
            }
        }).l();
        addView(this.f9610e);
        addView(this.f9612k);
        addView(this.f9611j);
    }

    public ImageView getCloseView() {
        return this.f9611j;
    }

    public ImageView getIconView() {
        return this.f9610e;
    }

    public TextView getTextView() {
        return this.f9612k;
    }
}
