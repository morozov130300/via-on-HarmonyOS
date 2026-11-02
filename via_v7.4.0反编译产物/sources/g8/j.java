package g8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import g6.y;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends y5.d {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6283d = {0, -462365, -4133433, -11908531, -15592942};

    /* renamed from: a, reason: collision with root package name */
    public a f6284a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f6285b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6286c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(int i10);
    }

    public static /* synthetic */ void i(j jVar, View view) {
        jVar.getClass();
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            int iIntValue = ((Integer) tag).intValue();
            a aVar = jVar.f6284a;
            if (aVar != null) {
                aVar.a(iIntValue);
            }
            jVar.q((LinearLayout) view.getParent(), g6.a.c(f6283d, iIntValue));
        }
    }

    public static /* synthetic */ void j(j jVar, int i10, Context context, View view) {
        jVar.getClass();
        view.setTag(Integer.valueOf(i10));
        y.O(view, jVar.k(context, i10, false));
    }

    public final Drawable k(Context context, int i10, boolean z10) {
        if (i10 != 0 && this.f6286c) {
            i10 = y.G(i10, -16777216, 0.3f);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float fE = x8.h.e(context);
        gradientDrawable.setCornerRadii(new float[]{fE, fE, fE, fE, fE, fE, fE, fE});
        gradientDrawable.setColor(i10);
        gradientDrawable.setStroke(y.h(context, 2.0f), z10 ? x8.h.j(context) : g6.f.b(context, x7.m.f13673c));
        return gradientDrawable;
    }

    public final View l(final Context context, final int i10) {
        return new h6.a(new View(context), new LinearLayout.LayoutParams(0, y.h(context, 42.0f))).W(1.0f).x(1, 8).V(new a.InterfaceC0076a() { // from class: g8.h
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                j.j(this.f6279a, i10, context, (View) obj);
            }
        }).l();
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, g gVar2) {
        LinearLayout linearLayout = (LinearLayout) gVar.f1219a;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: g8.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.i(this.f6282a, view);
            }
        };
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            linearLayout.getChildAt(i10).setOnClickListener(onClickListener);
        }
        q(linearLayout, g6.a.c(f6283d, gVar2.a()));
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).p(16).N(1, 8).T(1, 12).l();
        for (int i10 : f6283d) {
            linearLayout.addView(l(context, i10));
        }
        return new b6.g(linearLayout);
    }

    public void o(boolean z10) {
        this.f6286c = z10;
    }

    public void p(a aVar) {
        this.f6284a = aVar;
    }

    public final void q(LinearLayout linearLayout, int i10) {
        View childAt;
        View childAt2;
        if (this.f6285b == i10) {
            return;
        }
        Context context = linearLayout.getContext();
        int i11 = this.f6285b;
        this.f6285b = i10;
        if (i11 >= 0 && i11 < f6283d.length && (childAt2 = linearLayout.getChildAt(i11)) != null) {
            y.O(childAt2, k(context, ((Integer) childAt2.getTag()).intValue(), false));
        }
        int i12 = this.f6285b;
        if (i12 < 0 || i12 >= f6283d.length || (childAt = linearLayout.getChildAt(i12)) == null) {
            return;
        }
        y.O(childAt, k(context, ((Integer) childAt.getTag()).intValue(), true));
    }
}
